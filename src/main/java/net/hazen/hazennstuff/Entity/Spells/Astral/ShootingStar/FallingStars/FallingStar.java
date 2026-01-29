package net.hazen.hazennstuff.Entity.Spells.Astral.ShootingStar.FallingStars;

import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.particle.BlastwaveParticleOptions;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Optional;

public class FallingStar extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public FallingStar(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setNoGravity(true);
    }

    public FallingStar(Level pLevel, LivingEntity pShooter) {
        this(HnSEntityRegistry.FALLING_STAR.get(), pLevel);
        this.setOwner(pShooter);
    }

    public void shoot(Vec3 rotation, float innaccuracy) {
        Vec3 offset = Utils.getRandomVec3(1.0F).normalize().scale(innaccuracy);
        super.shoot(rotation.add(offset));
    }

    public void trailParticles() {
        Vec3 vec = this.getDeltaMovement();
        double length = vec.length();
        int count = (int)Math.min(20L, Math.round(length) * 4L) + 1;
        float f = (float)length / (float)count;

        for(int i = 0; i < count; ++i) {
            Vec3 random = Utils.getRandomVec3(0.04);
            Vec3 p = vec.scale((f * (float)i));
            this.level.addParticle(ParticleHelper.UNSTABLE_ENDER, this.getX() + random.x + p.x, this.getY() + random.y + p.y, this.getZ() + random.z + p.z, random.x, random.y, random.z);
        }

    }

    public void impactParticles(double x, double y, double z) {
        MagicManager.spawnParticles(this.level, new BlastwaveParticleOptions((HnSSpellRegistries.STELLAR_COLLAPSE.get()).getSchoolType().getTargetingColor(), 1.25F), x, y, z, 1, 0.0F, 0.0F, 0.0F, 0.0F, true);
    }

    public float getSpeed() {
        return 1.85F;
    }

    protected void doImpactSound(Holder<SoundEvent> sound) {
        this.level.playSound(null, this.getX(), this.getY(), this.getZ(), sound, SoundSource.NEUTRAL, 0.8F, 1.35F + Utils.random.nextFloat() * 0.3F);
    }

    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.of(SoundEvents.GENERIC_EXPLODE);
    }

    protected void onHit(HitResult hitResult) {
        if (!this.level.isClientSide) {
            this.impactParticles(this.xOld, this.yOld, this.zOld);
            this.getImpactSound().ifPresent(this::doImpactSound);
            float explosionRadius = this.getExplosionRadius();

            for(Entity entity : this.level.getEntities(this, this.getBoundingBox().inflate(explosionRadius))) {
                double distance = entity.distanceToSqr(hitResult.getLocation());
                if (distance < (double)(explosionRadius * explosionRadius) && this.canHitEntity(entity)) {
                    DamageSources.applyDamage(entity, this.damage, (HnSSpellRegistries.STELLAR_COLLAPSE.get()).getDamageSource(this, this.getOwner()));
                }
            }

            this.discardHelper(hitResult);
        }

    }

    //ANIMATION
    private final RawAnimation idle = RawAnimation.begin().thenLoop("animation.shooting_star.idle");

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
