package net.hazen.hazennstuff.Entity.Mobs.Summons.SummonTerraprisma;

import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.entity.mobs.IAnimatedAttacker;
import io.redspace.ironsspellbooks.entity.mobs.IMagicSummon;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMob;
import io.redspace.ironsspellbooks.entity.mobs.goals.*;
import io.redspace.ironsspellbooks.entity.mobs.goals.melee.AttackAnimationData;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import io.redspace.ironsspellbooks.util.OwnerHelper;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.AnimationController.State;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.UUID;

public class SummonedTerraprisma extends AbstractSpellCastingMob implements IMagicSummon, IAnimatedAttacker {
    protected LivingEntity cachedSummoner;
    protected UUID summonerUUID;
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final AnimationController<SummonedTerraprisma> meleeController = new AnimationController(this, "animations", 0, this::predicate);
    RawAnimation animationToPlay;

    public SummonedTerraprisma(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.moveControl = new FlyingMoveControl(this, 20, true);
    }

    public SummonedTerraprisma(Level level, LivingEntity owner) {
        this(HnSEntityRegistry.TERRAPRISMA.get(), level);
    }

    public boolean canDrownInFluidType(FluidType type) {
        return false;
    }

    public boolean fireImmune() {
        return true;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(4, new TerraprismaAttackGoal(this, 1.0F, 10, 30));
        this.goalSelector.addGoal(3, new GenericFollowOwnerGoal(this, this::getSummoner, 1.0F, 9.0F, 4.0F, true, 20.0F));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new GenericFollowOwnerGoal(this, this::getSummoner, 1.0F, 7.0F, 4.0F, true, 20.0F));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomFlyingGoal(this, 0.75F));

        this.targetSelector.addGoal(1, new GenericOwnerHurtByTargetGoal(this, this::getSummoner));
        this.targetSelector.addGoal(2, new GenericOwnerHurtTargetGoal(this, this::getSummoner));
        this.targetSelector.addGoal(3, new GenericCopyOwnerTargetGoal(this, this::getSummoner));
        this.targetSelector.addGoal(5, new GenericProtectOwnerTargetGoal(this, this::getSummoner));
        this.targetSelector.addGoal(4, (new GenericHurtByTargetGoal(this, (entity) -> entity == this.getSummoner())).setAlertOthers(new Class[0]));
    }

    public static enum AttackType {
        Swing_A(40, "animation.terraprisma.swing_a", new int[]{15}),
        Dash(40, "animation.terraprisma.dash", new int[]{20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40}),
        Swing_B(40, "animation.terraprisma.swing_b", new int[]{24, 28}),
        Swing_Barrage(90, "animation.terraprisma.swing_barrage", new int[]{22, 28, 35, 42, 48, 58, 63, 66, 69, 75, 78, 81, 85}),
        Downslash(30, "animation.terraprisma.down_slash", new int[]{21})
        ;

        public final AttackAnimationData data;

        private AttackType(int lengthInTicks, String animationId, int... attackTimestamps) {
            this.data = new AttackAnimationData(lengthInTicks, animationId, attackTimestamps);
        }
    }

    public boolean doHurtTarget(Entity pEntity) {
        return Utils.doMeleeAttack(this, pEntity,
                (HnSSpellRegistries.CALL_FORTH_TERRAPRISMA
                        .get()).getDamageSource(this, this.getSummoner()
                ));
    }

    protected void checkFallDamage(double pY, boolean pOnGround, BlockState pState, BlockPos pPos) {
    }

    public boolean isAlliedTo(Entity pEntity) {
        return super.isAlliedTo(pEntity) || this.isAlliedHelper(pEntity);
    }

    public void die(DamageSource pDamageSource) {
        this.onDeathHelper();
        super.die(pDamageSource);
    }

    public void onRemovedFromLevel() {
        this.onRemovedHelper(this);
        super.onRemovedFromLevel();
    }

    public void onUnSummon() {
        if (!this.level.isClientSide) {
            MagicManager.spawnParticles(this.level, ParticleTypes.POOF, this.getX(), this.getY(), this.getZ(), 25, 0.4, 0.8, 0.4, 0.03, false);
            this.setRemoved(RemovalReason.DISCARDED);
        }
    }

    protected PathNavigation createNavigation(Level pLevel) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, pLevel);
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(true);
        flyingpathnavigation.setCanPassDoors(true);
        return flyingpathnavigation;
    }

    protected BodyRotationControl createBodyControl() {
        return new BodyRotationControl(this);
    }

    protected LookControl createLookControl() {
        return new LookControl(this) {
            protected float rotateTowards(float pFrom, float pTo, float pMaxDelta) {
                return super.rotateTowards(pFrom, pTo, pMaxDelta * 2.5F);
            }
        };
    }

    protected MoveControl createMoveControl() {
        return new MoveControl(this) {
            protected float rotlerp(float pSourceAngle, float pTargetAngle, float pMaximumChange) {
                double d0 = this.wantedX - this.mob.getX();
                double d1 = this.wantedZ - this.mob.getZ();
                return d0 * d0 + d1 * d1 < (double)0.5F ? pSourceAngle : super.rotlerp(pSourceAngle, pTargetAngle, pMaximumChange * 0.25F);
            }
        };
    }

    protected SoundEvent getDeathSound() {
        return SoundRegistry.KEEPER_DEATH.get();
    }

    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundRegistry.KEEPER_HURT.get();
    }

    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pSpawnType, @Nullable SpawnGroupData pSpawnGroupData) {
        this.setNoGravity(true);
        return super.finalizeSpawn(pLevel, pDifficulty, pSpawnType, pSpawnGroupData);
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.ATTACK_KNOCKBACK, 1.0F)
                .add(Attributes.ATTACK_DAMAGE, 2.0F)
                .add(Attributes.MAX_HEALTH, 25.0F)
                .add(Attributes.FOLLOW_RANGE, 40.0F)
                .add(Attributes.FLYING_SPEED, 2.5F)
                .add(Attributes.ENTITY_INTERACTION_RANGE, 4.0F)
                .add(Attributes.MOVEMENT_SPEED, 0.5F);
    }


    public boolean hurt(DamageSource pSource, float pAmount) {
        return (pSource.is(DamageTypeTags.BYPASSES_INVULNERABILITY) || !this.shouldIgnoreDamage(pSource)) && super.hurt(pSource, pAmount);
    }

    protected float nextStep() {
        return this.moveDist + 0.8F;
    }

    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.summonerUUID = OwnerHelper.deserializeOwner(compoundTag);
    }

    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        OwnerHelper.serializeOwner(compoundTag, this.summonerUUID);
    }

    protected void customServerAiStep() {
        super.customServerAiStep();
        if (this.tickCount % 8 == 0) {
            Entity owner = this.getSummoner();
            LivingEntity target = this.getTarget();
            Entity trackEntity = (target == null ? owner : target);
            double targetY = trackEntity == null ? Utils.moveToRelativeGroundLevel(this.level, this.position(), 3).y + (double)1.0F : trackEntity.getY() + (double)1.0F;
            double f = targetY - this.getY();
            double force = Math.clamp(f * 0.05, -0.15, 0.15);
            this.setDeltaMovement(this.getDeltaMovement().add(0.0F, force, 0.0F));
        }
        if (this.tickCount % 80 == 0) {
            this.heal(1.0F);
        }

    }

    private PlayState predicate(AnimationState<SummonedTerraprisma> animationEvent) {
        AnimationController<SummonedTerraprisma> controller = animationEvent.getController();
        if (this.animationToPlay != null) {
            controller.forceAnimationReset();
            controller.setAnimation(this.animationToPlay);
            this.animationToPlay = null;
        }

        return PlayState.CONTINUE;
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(this.meleeController);
        super.registerControllers(controllerRegistrar);
    }

    public void playAnimation(String animationId) {
        try {
            AttackType attackType = AttackType.valueOf(animationId);
            this.animationToPlay = RawAnimation.begin().thenPlay(attackType.data.animationId);
        } catch (Exception var3) {
            HazenNStuff.LOGGER.error("Entity {} Failed to play animation: {}", this, animationId);
        }
    }

    public double getBoneResetTime() {
        return 3.0F;
    }

    public boolean isAnimating() {
        return this.meleeController.getAnimationState() != State.STOPPED || super.isAnimating();
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
