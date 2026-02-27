package net.hazen.hazennstuff.Entity.Spells.Shadow.ShadowDagger;

import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.particle.ZapParticleOption;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Registries.HnSParticleHelper;
import net.hazen.hazennstuff.Registries.HnSParticleRegistry;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Optional;

public class ShadowDagger extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public ShadowDagger(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setNoGravity(false);
    }

    public ShadowDagger(Level level, LivingEntity shooter)
    {
        this(HnSEntityRegistry.SHADOW_DAGGER.get(), level);
        setOwner(shooter);
    }

    public float getSpeed() {
        return 1.4f;
    }

    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.of(HnSSounds.SHADOW_DAGGER_HIT);
    }

    protected void doImpactSound(Holder<SoundEvent> sound) {
        level.playSound(null, getX(), getY(), getZ(), sound, SoundSource.NEUTRAL, 1.5f, 1.0f);
    }

    public void trailParticles() {
    }

    public void impactParticles(double x, double y, double z) {
        MagicManager.spawnParticles(level, HnSParticleHelper.NIGHTS_EDGE_PARTICLE, x, y, z, 12, .08, .08, .08, 0.3, false);
    }

    @Override
    protected void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        discard();
    }


    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        DamageSources.applyDamage(
                    entityHitResult.getEntity(), damage,
                HnSSpellRegistries.UMBRASHIFT_BARRAGE.get().getDamageSource(this, getOwner())
        );
        discard();
    }

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

    public void setDamage(float damage) {
        this.damage = damage;
    }
}