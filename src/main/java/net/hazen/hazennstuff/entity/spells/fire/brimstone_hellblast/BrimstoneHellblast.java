package net.hazen.hazennstuff.entity.spells.fire.brimstone_hellblast;

import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.config.ServerConfigs;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.network.particles.FieryExplosionParticlesPacket;
import net.hazen.hazennstuff.registries.HnSEntityRegistry;
import net.hazen.hazennstuff.registries.HnSSounds;
import net.hazen.hazennstuff.registries.HnSSpellRegistries;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.level.ExplosionEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Optional;

public class BrimstoneHellblast extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public BrimstoneHellblast(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setNoGravity(true);
    }

    public BrimstoneHellblast(Level level, LivingEntity shooter)
    {
        this(HnSEntityRegistry.BRIMSTONE_HELLBLAST.get(), level);
        setOwner(shooter);
    }

    @Override
    public void travel() {
        this.setPos(this.position().add(this.getDeltaMovement()));
        if (!this.isNoGravity())
        {
            Vec3 vec3 = this.getDeltaMovement();
            this.setDeltaMovement(vec3.x, vec3.y - 0.05000000074505806, vec3.z);
        }
    }

    public void setRotation(float x, float y) {
        this.setXRot(x);
        this.xRotO = x;
        this.setYRot(y);
        this.yRotO = y;
    }

    @Override
    public void tick() {
        // Save previous rotation for interpolation
        this.xRotO = this.getXRot();
        this.yRotO = this.getYRot();

        Vec3 deltaMovement = getDeltaMovement();
        double distance = deltaMovement.horizontalDistance();



        float newYRot = (float) (Mth.atan2(deltaMovement.x, deltaMovement.z) * (180F / Math.PI));
        float newXRot = (float) (Mth.atan2(deltaMovement.y, distance) * (180F / Math.PI));

        float maxDelta = 20f; // max degrees per tick
        this.setYRot(Mth.approachDegrees(this.yRotO, newYRot, maxDelta));
        this.setXRot(Mth.approachDegrees(this.xRotO, newXRot, maxDelta));

        super.tick();
    }

    @Override
    public void trailParticles() {
        for (int i = 0; i < 1; i++) {
            double speed = .05;
            double dx = Utils.random.nextDouble() * 2 * speed - speed;
            double dy = Utils.random.nextDouble() * 2 * speed - speed;
            double dz = Utils.random.nextDouble() * 2 * speed - speed;
            level().addParticle(Utils.random.nextDouble() < .3 ? ParticleTypes.CAMPFIRE_SIGNAL_SMOKE : ParticleTypes.FLAME, this.getX() + dx, this.getY() + dy, this.getZ() + dz, dx, dy, dz);
        }
    }

    @Override
    public void impactParticles(double x, double y, double z) {
        MagicManager.spawnParticles(this.level(), ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, x, y, z, 5, .1, .1, .1, .25, true);
    }

    @Override
    public float getSpeed() {
        return 1.4f;
    }

    @Override
    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.of(HnSSounds.BRIMSTONE_HELLBLAST_IMPACT);
    }

    @Override
    protected void doImpactSound(Holder<SoundEvent> sound) {
        level().playSound(null, getX(), getY(), getZ(), sound, SoundSource.NEUTRAL, 1.5f, 1.0f);
    }

//    @Override
//    protected void onHit(HitResult hitResult) {
//        if (!this.level().isClientSide) {
//            impactParticles(xOld, yOld, zOld);
//            float explosionRadius = getExplosionRadius();
//            var explosionRadiusSqr = explosionRadius * explosionRadius;
//            var entities = level().getEntities(this, this.getBoundingBox().inflate(explosionRadius));
//            Vec3 losPoint = Utils.raycastForBlock(level(), this.position(), this.position().add(0, 2, 0), ClipContext.Fluid.NONE).getLocation();
//            for (Entity entity : entities) {
//                double distanceSqr = entity.distanceToSqr(hitResult.getLocation());
//                if (distanceSqr < explosionRadiusSqr && canHitEntity(entity) && Utils.hasLineOfSight(level(), losPoint, entity.getBoundingBox().getCenter(), true)) {
//                    double p = (1 - distanceSqr / explosionRadiusSqr);
//                    float damage = (float) (this.damage * p);
//                    DamageSources.applyDamage(entity, damage, HnSSpellRegistries.BRIMSTONE_HELLBLAST.get().getDamageSource(this, getOwner()));
//                }
//            }
//            if (ServerConfigs.SPELL_GREIFING.get()) {
//                Explosion explosion = new Explosion(
//                        level(),
//                        null,
//                        HnSSpellRegistries.BRIMSTONE_HELLBLAST.get().getDamageSource(this, getOwner()),
//                        null,
//                        this.getX(), this.getY(), this.getZ(),
//                        this.getExplosionRadius() / 2,
//                        true,
//                        Explosion.BlockInteraction.DESTROY,
//                        ParticleTypes.EXPLOSION,
//                        ParticleTypes.EXPLOSION_EMITTER,
//                        SoundEvents.GENERIC_EXPLODE);
//                if (!NeoForge.EVENT_BUS.post(new ExplosionEvent.Start(level(), explosion)).isCanceled()) {
//                    explosion.explode();
//                    explosion.finalizeExplosion(false);
//                }
//            }
//            PacketDistributor.sendToPlayersTrackingEntity(this, new FieryExplosionParticlesPacket(hitResult.getLocation().subtract(getDeltaMovement().scale(0.5)), getExplosionRadius()));
//            playSound(HnSSounds.BRIMSTONE_HELLBLAST_IMPACT.value(), 4.0F, (1.0F + (this.level().random.nextFloat() - this.level().random.nextFloat()) * 0.2F) * 0.7F);
//            this.discard();
//        }
//    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        var target = pResult.getEntity();

        DamageSources.applyDamage(target, damage,
                HnSSpellRegistries.BRIMSTONE_HELLBLAST.get().getDamageSource(this, getOwner()));

        level().playSound(null, getX(), getY(), getZ(),
                HnSSounds.BRIMSTONE_HELLBLAST_IMPACT.get(), SoundSource.NEUTRAL, 2.0f, 1.0f);

        level().explode(this, this.getX(), this.getY(), this.getZ(), 4.0f, false, Level.ExplosionInteraction.NONE);

        discard();
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);

        level().explode(this, this.getX(), this.getY(), this.getZ(), 4.0f, false, Level.ExplosionInteraction.NONE);

        level().playSound(null, getX(), getY(), getZ(),
                HnSSounds.BRIMSTONE_HELLBLAST_IMPACT.get(), SoundSource.NEUTRAL, 2.0f, 1.0f);

        discard();
    }

    //ANIMATION
    private final RawAnimation idle = RawAnimation.begin().thenLoop("animation.brimstone_hellblast.idle");

    private PlayState predicate(software.bernie.geckolib.animation.AnimationState event) {
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
}