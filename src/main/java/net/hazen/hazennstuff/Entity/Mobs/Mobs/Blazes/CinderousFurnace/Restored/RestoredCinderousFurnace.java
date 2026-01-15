package net.hazen.hazennstuff.Entity.Mobs.Mobs.Blazes.CinderousFurnace.Restored;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMob;
import io.redspace.ironsspellbooks.entity.mobs.goals.PatrolNearLocationGoal;
import io.redspace.ironsspellbooks.entity.spells.fireball.SmallMagicFireball;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class RestoredCinderousFurnace extends AbstractSpellCastingMob implements Enemy {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private float allowedHeightOffset = 0.5F;
    private int nextHeightOffsetChangeTick;
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID;

    public RestoredCinderousFurnace(EntityType<? extends AbstractSpellCastingMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setPathfindingMalus(PathType.WATER, -1.0F);
        this.setPathfindingMalus(PathType.LAVA, 8.0F);
        this.setPathfindingMalus(PathType.DANGER_FIRE, 0.0F);
        this.setPathfindingMalus(PathType.DAMAGE_FIRE, 0.0F);
        xpReward = 25;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
//        this.goalSelector.addGoal(2, new WizardAttackGoal(this, 1.25f, 50, 75)
//                .setSpells(
//                        List.of(SpellRegistry.FIREBOLT_SPELL.get(),
//                                SpellRegistry.FIREBOLT_SPELL.get(),
//                                SpellRegistry.FIREBOLT_SPELL.get()),
//                        List.of(),
//                        List.of(),
//                        List.of()
//                )
//        );
        this.goalSelector.addGoal(4, new SpellcastingBlazeAttackGoal(this));
        this.goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, (double) 1.0F));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, (double) 1.0F, 0.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, new Class[0])).setAlertOthers(new Class[0]));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, true));
        this.goalSelector.addGoal(4, new PatrolNearLocationGoal(this, 30, .75f));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData) {
        RandomSource randomsource = Utils.random;
        this.populateDefaultEquipmentSlots(randomsource, pDifficulty);
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData);
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.ATTACK_DAMAGE, 6.0)
                .add(Attributes.ATTACK_KNOCKBACK, 0.0)
                .add(Attributes.MAX_HEALTH, 120.0)
                .add(AttributeRegistry.SPELL_RESIST, 20.0)
                .add(Attributes.FOLLOW_RANGE, 24.0)
                .add(Attributes.MOVEMENT_SPEED, .25);
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_FLAGS_ID, (byte) 0);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.BLAZE_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.BLAZE_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.BLAZE_DEATH;
    }

    public float getLightLevelDependentMagicValue() {
        return 1.0F;
    }

    public void aiStep() {
        if (!this.onGround() && this.getDeltaMovement().y < (double) 0.0F) {
            this.setDeltaMovement(this.getDeltaMovement().multiply((double) 1.0F, 0.6, (double) 1.0F));
        }

        if (this.level.isClientSide) {
            if (this.random.nextInt(24) == 0 && !this.isSilent()) {
                this.level.playLocalSound(this.getX() + (double) 0.5F, this.getY() + (double) 0.5F, this.getZ() + (double) 0.5F, SoundEvents.BLAZE_BURN, this.getSoundSource(), 1.0F + this.random.nextFloat(), this.random.nextFloat() * 0.7F + 0.3F, false);
            }

            for (int i = 0; i < 2; ++i) {
                this.level.addParticle(ParticleHelper.FIRE, this.getRandomX((double) 0.5F), this.getRandomY(), this.getRandomZ((double) 0.5F), (double) 0.0F, (double) 0.0F, (double) 0.0F);
            }
        }

        super.aiStep();
    }

    public boolean isSensitiveToWater() {
        return true;
    }

    protected void customServerAiStep() {
        --this.nextHeightOffsetChangeTick;
        if (this.nextHeightOffsetChangeTick <= 0) {
            this.nextHeightOffsetChangeTick = 100;
            this.allowedHeightOffset = (float) this.random.triangle((double) 0.5F, 6.891);
        }

        LivingEntity livingentity = this.getTarget();
        if (livingentity != null && livingentity.getEyeY() > this.getEyeY() + (double) this.allowedHeightOffset && this.canAttack(livingentity)) {
            Vec3 vec3 = this.getDeltaMovement();
            this.setDeltaMovement(this.getDeltaMovement().add((double) 0.0F, ((double) 0.3F - vec3.y) * (double) 0.3F, (double) 0.0F));
            this.hasImpulse = true;
        }

        super.customServerAiStep();
    }

    public boolean isOnFire() {
        return this.isCharged();
    }

    private boolean isCharged() {
        return ((Byte) this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
    }

    void setCharged(boolean charged) {
        byte b0 = (Byte) this.entityData.get(DATA_FLAGS_ID);
        if (charged) {
            b0 = (byte) (b0 | 1);
        } else {
            b0 = (byte) (b0 & -2);
        }

        this.entityData.set(DATA_FLAGS_ID, b0);
    }

    static {
        DATA_FLAGS_ID = SynchedEntityData.defineId(RestoredCinderousFurnace.class, EntityDataSerializers.BYTE);
    }

    static class SpellcastingBlazeAttackGoal extends Goal {
        private final RestoredCinderousFurnace cinderousFurnace;
        private int attackStep;
        private int attackTime;
        private int lastSeen;

        public SpellcastingBlazeAttackGoal(RestoredCinderousFurnace cinderousFurnace) {
            this.cinderousFurnace = cinderousFurnace;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        public boolean canUse() {
            LivingEntity livingentity = this.cinderousFurnace.getTarget();
            return livingentity != null && livingentity.isAlive() && this.cinderousFurnace.canAttack(livingentity);
        }

        public void start() {
            this.attackStep = 0;
        }

        public void stop() {
            this.cinderousFurnace.setCharged(false);
            this.lastSeen = 0;
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            --this.attackTime;
            LivingEntity livingentity = this.cinderousFurnace.getTarget();
            if (livingentity != null) {
                boolean flag = this.cinderousFurnace.getSensing().hasLineOfSight(livingentity);
                if (flag) {
                    this.lastSeen = 0;
                } else {
                    ++this.lastSeen;
                }

                double d0 = this.cinderousFurnace.distanceToSqr(livingentity);
                if (d0 < (double) 4.0F) {
                    if (!flag) {
                        return;
                    }

                    if (this.attackTime <= 0) {
                        this.attackTime = 20;
                        this.cinderousFurnace.doHurtTarget(livingentity);
                    }

                    this.cinderousFurnace.getMoveControl().setWantedPosition(livingentity.getX(), livingentity.getY(), livingentity.getZ(), (double) 1.0F);
                } else if (d0 < this.getFollowDistance() * this.getFollowDistance() && flag) {
                    double d1 = livingentity.getX() - this.cinderousFurnace.getX();
                    double d2 = livingentity.getY((double) 0.5F) - this.cinderousFurnace.getY((double) 0.5F);
                    double d3 = livingentity.getZ() - this.cinderousFurnace.getZ();
                    if (this.attackTime <= 0) {

                        ++this.attackStep;
                        if (this.attackStep == 1) {
                            this.attackTime = 60; // charge-up before first fireball
                            this.cinderousFurnace.setCharged(true);
                        } else if (this.attackStep <= 4) {
                            this.attackTime = 6; // delay between fireballs
                        } else {
                            this.attackTime = 100; // cooldown after volley
                            this.attackStep = 0;
                            this.cinderousFurnace.setCharged(false);
                        }

                        if (this.attackStep > 1) {
                            if (!this.cinderousFurnace.isSilent()) {
                                this.cinderousFurnace.level.levelEvent(null, 1018, this.cinderousFurnace.blockPosition(), 0);
                            }

                            SmallMagicFireball smallMagicFireball = new SmallMagicFireball(this.cinderousFurnace.level, this.cinderousFurnace);
                            smallMagicFireball.setDamage((float)this.cinderousFurnace.getAttributeValue(Attributes.ATTACK_DAMAGE));
                            smallMagicFireball.setPos(this.cinderousFurnace.getX(), this.cinderousFurnace.getY(0.5) + 0.5, this.cinderousFurnace.getZ());

                            Vec3 vec3 = new Vec3(d1, d2, d3).normalize(); // Straight trajectory
                            smallMagicFireball.shoot(vec3, smallMagicFireball.getSpeed());

                            this.cinderousFurnace.level.addFreshEntity(smallMagicFireball);
                        }

                    }

                    this.cinderousFurnace.getLookControl().setLookAt(livingentity, 10.0F, 10.0F);
                } else if (this.lastSeen < 5) {
                    this.cinderousFurnace.getMoveControl().setWantedPosition(livingentity.getX(), livingentity.getY(), livingentity.getZ(), (double) 1.0F);
                }

                super.tick();
            }

        }

        private double getFollowDistance() {
            return this.cinderousFurnace.getAttributeValue(Attributes.FOLLOW_RANGE);
        }
    }


    // Geckolib & Animations
    private final AnimationController<RestoredCinderousFurnace> animationController =
            new AnimationController<>(this, "controller", 0, this::idlePredicate);

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(animationController);
    }

    private PlayState idlePredicate(AnimationState<RestoredCinderousFurnace> event) {
        event.getController().setAnimation(RawAnimation.begin().then("animation.cinderous_furnace.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache; // reuse the existing cache variable
    }

    @Override
    public double getTick(Object object) {
        return this.tickCount;
    }
}
