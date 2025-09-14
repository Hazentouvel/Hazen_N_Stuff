package net.hazen.hazennstuff.entity.spells.radiance.syringe;

import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import net.hazen.hazennstuff.registries.HnSEffects;
import net.hazen.hazennstuff.registries.HnSEntityRegistry;
import net.hazen.hazennstuff.registries.HnSSounds;
import net.hazen.hazennstuff.registries.HnSSpellRegistries;
import net.hazen.hazennstuff.registries.effects.InfestedEffect;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
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
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Optional;

public class Syringe extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public Syringe(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public Syringe(Level level, LivingEntity shooter)
    {
        this(HnSEntityRegistry.SYRINGE.get(), level);
        setOwner(shooter);
    }

    @Override
    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.empty();
    }

    public void setRotation(float x, float y) {
        this.setXRot(x);
        this.xRotO = x;
        this.setYRot(y);
        this.yRotO = y;
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

    @Override
    public void trailParticles() {
    }


    @Override
    public void impactParticles(double x, double y, double z) {
    }

    @Override
    public float getSpeed() {
        return 1.4f;
    }

    @Override
    protected void doImpactSound(Holder<SoundEvent> sound) {
        level().playSound(null, getX(), getY(), getZ(), sound, SoundSource.NEUTRAL, 1.5f, 1.0f);
    }


    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);

        level().playSound(null, getX(), getY(), getZ(),
                HnSSounds.SYRINGE_BARRAGE_MISS.get(), SoundSource.NEUTRAL, 2.0f, 1.0f);

        discard();
    }


    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        var target = pResult.getEntity();

        DamageSources.applyDamage(target, damage,
                HnSSpellRegistries.SYRINGE_BARRAGE.get().getDamageSource(this, getOwner()));

        if (target instanceof LivingEntity livingTarget) {
            InfestedEffect.addInfestedStack(livingTarget, getOwner());
        }

        // Play sound
        level().playSound(null, getX(), getY(), getZ(),
                HnSSounds.SYRINGE_BARRAGE_HIT, SoundSource.NEUTRAL, 2.0f, 1.0f);

        discard();
    }



    //ANIMATION
    private final RawAnimation idle = RawAnimation.begin().thenLoop("animation.syringe.idle");

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

    private float damage = 2.0f; // Default value

    public void setDamage(float damage) {
        this.damage = damage;
    }
}