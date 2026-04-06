package net.hazen.hazennstuff.Entity.Spells.Eldritch.SoulSeeker;

import io.redspace.ironsspellbooks.api.entity.IMagicEntity;
import io.redspace.ironsspellbooks.api.events.CounterSpellEvent;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.capabilities.magic.RecastResult;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import io.redspace.ironsspellbooks.entity.mobs.AntiMagicSusceptible;
import io.redspace.ironsspellbooks.entity.mobs.IMagicSummon;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.particle.ZapParticleOption;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import mod.azure.azurelib.core.utils.MathHelper;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Registries.HnSParticleHelper;
import net.hazen.hazennstuff.Registries.HnSParticleRegistry;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForge;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SoulSeeker extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public SoulSeeker(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setNoGravity(true);
    }

    public SoulSeeker(Level level, LivingEntity shooter)
    {
        this(HnSEntityRegistry.SOUL_SEEKER.get(), level);
        setOwner(shooter);
    }

    public void travel() {
        this.setPos(this.position().add(this.getDeltaMovement()));
        if (!this.isNoGravity())
        {
            Vec3 vec3 = this.getDeltaMovement();
            this.setDeltaMovement(vec3.x, vec3.y - 0.05000000074505806, vec3.z);
        }
    }

    private LivingEntity findNearestTarget() {
        List<LivingEntity> entities = level.getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(12),
                e -> e != this.getOwner() && e.isAlive() && !e.isInvisible());

        return entities.stream()
                .min(Comparator.comparingDouble(e -> e.distanceToSqr(this)))
                .orElse(null);
    }


    private LivingEntity lockedTarget = null;
    private float getYawFromVec(Vec3 vec) {
        return (float)(Math.toDegrees(Math.atan2(vec.z, vec.x)) - 180.0F);
    }

    private float getPitchFromVec(Vec3 vec) {
        return (float)(-Math.toDegrees(Math.atan2(vec.y, vec.horizontalDistance())));
    }

    private float rotLerp(float lerpSpeed, float current, float target) {
        float delta = MathHelper.wrapDegrees(target - current);
        return current + delta * Math.min(lerpSpeed * 0.05f, 1.0f);
    }

    @Override
    public void tick() {
        super.tick();

        if (!level.isClientSide) {
            if (this.tickCount > 10) {
                if (lockedTarget == null || !lockedTarget.isAlive()) {
                    lockedTarget = findNearestTarget();
                }

                if (lockedTarget != null) {
                    Vec3 toTarget = lockedTarget.getEyePosition().subtract(this.position());
                    Vec3 currentMotion = this.getDeltaMovement();

                    double homingStrength = 0.05;
                    double speed = currentMotion.length();

                    Vec3 desiredDirection = toTarget.normalize();

                    Vec3 newDirection = currentMotion.normalize().scale(1.0 - homingStrength)
                            .add(desiredDirection.scale(homingStrength))
                            .normalize();

                    Vec3 newMotion = newDirection.scale(speed);
                    this.setDeltaMovement(newMotion);
                }
            }
        }
    }


    @Override
    public void trailParticles() {
        Vec3 pos = this.getBoundingBox().getCenter().add(getDeltaMovement());
        Vec3 random = Utils.getRandomVec3(0);
        pos = pos.add(getDeltaMovement());
        level.addParticle(HnSParticleHelper.BLADE_PARTICLE, pos.x, pos.y, pos.z, random.x, random.y, random.z);
    }

    @Override
    public void impactParticles(double x, double y, double z) {
        MagicManager.spawnParticles(level, HnSParticleHelper.ELDRITCH_SOUL_PARTICLE, x, y, z, 12, .08, .08, .08, 0.3, false);
    }

    @Override
    public float getSpeed() {
        return 2f;
    }

    @Override
    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.of(HnSSounds.BRIMSTONE_HELLBLAST_IMPACT);
    }

    @Override
    protected void doImpactSound(Holder<SoundEvent> sound) {
        level.playSound(null, getX(), getY(), getZ(), sound, SoundSource.NEUTRAL, 1.5f, 1.0f);
    }

    @Override
    protected void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        if (this.level.isClientSide) return;
        LivingEntity owner = (LivingEntity) this.getOwner();
        Vec3 hitPos = blockHitResult.getLocation();
        applyCounterspellArea(hitPos, owner, 6.0f);
        discard();
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);

        if (this.level.isClientSide) return;

        Entity target = entityHitResult.getEntity();
        LivingEntity owner = (LivingEntity) this.getOwner();

        // Use the target position as center for the area counterspell
        Vec3 center = target.position();
        applyCounterspellArea(center, owner, 6.0f);

        discard();
    }

    // Apply counterspell behavior in an area centered at `center` with given radius
    private void applyCounterspellArea(Vec3 center, LivingEntity owner, float radius) {
        List<LivingEntity> targets = this.level.getEntitiesOfClass(LivingEntity.class,
                AABB.ofSize(center, (double)radius * 2.0D, (double)radius * 2.0D, (double)radius * 2.0D));

        for (LivingEntity livingTarget : targets) {
            if (livingTarget == null || !livingTarget.isAlive()) continue;

            CounterSpellEvent event = new CounterSpellEvent(owner, livingTarget);
            NeoForge.EVENT_BUS.post(event);

            if (event.isCanceled()) continue;

            MagicData targetMagicData = MagicData.getPlayerMagicData(livingTarget);

            if (livingTarget instanceof AntiMagicSusceptible antiMagicTarget) {
                if (antiMagicTarget instanceof IMagicSummon summon) {
                    if (summon.getSummoner() == owner) {
                        if (summon instanceof Mob mob && mob.getTarget() == null) {
                            antiMagicTarget.onAntiMagic(targetMagicData);
                        }
                    } else {
                        antiMagicTarget.onAntiMagic(targetMagicData);
                    }
                } else {
                    antiMagicTarget.onAntiMagic(targetMagicData);
                }
            } else if (livingTarget instanceof ServerPlayer serverPlayer) {
                Utils.serverSideCancelCast(serverPlayer, true);
                MagicData.getPlayerMagicData(serverPlayer).getPlayerRecasts().removeAll(RecastResult.COUNTERSPELL);
            } else if (livingTarget instanceof IMagicEntity magicEntity) {
                magicEntity.cancelCast();
            }

            for (Holder<MobEffect> mobEffect : livingTarget.getActiveEffectsMap().keySet().stream().toList()) {
                if (mobEffect.value() instanceof MagicMobEffect) {
                    livingTarget.removeEffect(mobEffect);
                }
            }

            try {
                DamageSources.applyDamage(livingTarget, damage, HnSSpellRegistries.SOUL_SEEKERS.get().getDamageSource(this, owner));
            } catch (Exception ignored) {}
        }
    }

    //ANIMATION
    private final RawAnimation idle = RawAnimation.begin().thenLoop("animation.spark.idle");

    private PlayState predicate(AnimationState event) {
        event.getController().setAnimation(idle);
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<GeoAnimatable>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    private float damage = 2.0f; // Default value

    public void setDamage(float damage) {
        this.damage = damage;
    }
}