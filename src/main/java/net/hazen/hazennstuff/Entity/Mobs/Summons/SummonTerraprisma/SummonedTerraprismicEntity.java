package net.hazen.hazennstuff.Entity.Mobs.Summons.SummonTerraprisma;

import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.capabilities.magic.SummonManager;
import io.redspace.ironsspellbooks.entity.mobs.IAnimatedAttacker;
import io.redspace.ironsspellbooks.entity.mobs.IMagicSummon;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMob;
import io.redspace.ironsspellbooks.entity.mobs.goals.GenericCopyOwnerTargetGoal;
import io.redspace.ironsspellbooks.entity.mobs.goals.GenericFollowOwnerGoal;
import io.redspace.ironsspellbooks.entity.mobs.goals.GenericHurtByTargetGoal;
import io.redspace.ironsspellbooks.entity.mobs.goals.GenericOwnerHurtByTargetGoal;
import io.redspace.ironsspellbooks.entity.mobs.goals.GenericOwnerHurtTargetGoal;
import io.redspace.ironsspellbooks.entity.mobs.goals.GenericProtectOwnerTargetGoal;
import io.redspace.ironsspellbooks.entity.mobs.wizards.GenericAnimatedWarlockAttackGoal;
import io.redspace.ironsspellbooks.util.OwnerHelper;
import java.util.UUID;

import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public abstract class SummonedTerraprismicEntity extends AbstractSpellCastingMob implements IMagicSummon, IAnimatedAttacker {
    GenericAnimatedWarlockAttackGoal<? extends SummonedTerraprismicEntity> attackGoal;
    protected LivingEntity cachedSummoner;
    protected UUID summonerUUID;
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final AnimationController<SummonedTerraprismicEntity> meleeController = new AnimationController(this, "animations", 0, this::predicate);
    RawAnimation animationToPlay = null;

    public void initiateCastSpell(AbstractSpell spell, int spellLevel) {
    }

    public abstract GenericAnimatedWarlockAttackGoal<? extends SummonedTerraprismicEntity> makeAttackGoal();

    public SummonedTerraprismicEntity(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.moveControl = new FlyingMoveControl(this, 20, true);
    }

    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pSpawnType, @Nullable SpawnGroupData pSpawnGroupData) {
        this.setNoGravity(true);
        return super.finalizeSpawn(pLevel, pDifficulty, pSpawnType, pSpawnGroupData);
    }

    public boolean canDrownInFluidType(FluidType type) {
        return false;
    }

    public boolean fireImmune() {
        return true;
    }

    protected void registerGoals() {
        this.attackGoal = this.makeAttackGoal();
        this.goalSelector.addGoal(1, this.attackGoal.setMeleeBias(1.0F, 1.0F));
        this.goalSelector.addGoal(3, new GenericFollowOwnerGoal(this, this::getSummoner, 1.0F, 9.0F, 4.0F, true, 20.0F));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomFlyingGoal(this, 0.75F));
        this.targetSelector.addGoal(1, new GenericOwnerHurtByTargetGoal(this, this::getSummoner));
        this.targetSelector.addGoal(2, new GenericOwnerHurtTargetGoal(this, this::getSummoner));
        this.targetSelector.addGoal(3, new GenericCopyOwnerTargetGoal(this, this::getSummoner));
        this.targetSelector.addGoal(4, (new GenericHurtByTargetGoal(this, (entity) -> entity == this.getSummoner())).setAlertOthers(new Class[0]));
        this.targetSelector.addGoal(5, new GenericProtectOwnerTargetGoal(this, this::getSummoner));
    }

    protected PathNavigation createNavigation(Level pLevel) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, pLevel);
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(true);
        flyingpathnavigation.setCanPassDoors(true);
        return flyingpathnavigation;
    }

    protected void customServerAiStep() {
        super.customServerAiStep();
        if (this.tickCount % 8 == 0) {
            Entity owner = this.getSummoner();
            LivingEntity target = this.getTarget();
            Entity trackEntity = (target == null ? owner : target);
            double targetY = trackEntity == null ? Utils.moveToRelativeGroundLevel(this.level(), this.position(), 3).y + (double)1.0F : trackEntity.getY() + (double)1.0F;
            double f = targetY - this.getY();
            double force = Math.clamp(f * 0.05, -0.15, 0.15);
            this.setDeltaMovement(this.getDeltaMovement().add(0.0F, force, 0.0F));
        }

        if (this.tickCount % 80 == 0) {
            this.heal(1.0F);
        }

    }

    protected void playStepSound(BlockPos pos, BlockState state) {
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

    public boolean hurt(DamageSource pSource, float pAmount) {
        return (pSource.is(DamageTypeTags.BYPASSES_INVULNERABILITY) || !this.shouldIgnoreDamage(pSource)) && super.hurt(pSource, pAmount);
    }

    public void onUnSummon() {
        if (!this.level().isClientSide) {
            MagicManager.spawnParticles(this.level(), ParticleTypes.POOF, this.getX(), this.getY(), this.getZ(), 25, 0.4, 0.8, 0.4, 0.03, false);
            this.setRemoved(RemovalReason.DISCARDED);
        }

    }

    public double getBoneResetTime() {
        return 3.0F;
    }

    public void playAnimation(String animationId) {
        this.animationToPlay = RawAnimation.begin().thenPlay(animationId);
    }

    private PlayState predicate(AnimationState<SummonedTerraprismicEntity> animationEvent) {
        AnimationController<SummonedTerraprismicEntity> controller = animationEvent.getController();
        if (this.animationToPlay != null) {
            controller.forceAnimationReset();
            controller.setAnimation(this.animationToPlay);
            this.animationToPlay = null;
        }

        return PlayState.CONTINUE;
    }

    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.summonerUUID = OwnerHelper.deserializeOwner(compoundTag);
    }

    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        OwnerHelper.serializeOwner(compoundTag, this.summonerUUID);
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return LivingEntity.createLivingAttributes().add(Attributes.ATTACK_KNOCKBACK, (double)1.0F).add(Attributes.ATTACK_DAMAGE, (double)5.0F).add(Attributes.MAX_HEALTH, (double)20.0F).add(Attributes.FOLLOW_RANGE, (double)40.0F).add(Attributes.FLYING_SPEED, (double)1.0F).add(Attributes.ENTITY_INTERACTION_RANGE, (double)4.0F).add(Attributes.MOVEMENT_SPEED, 0.2);
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(this.meleeController);
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
