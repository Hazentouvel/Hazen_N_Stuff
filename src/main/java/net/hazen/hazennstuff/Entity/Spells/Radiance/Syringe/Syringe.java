package net.hazen.hazennstuff.Entity.Spells.Radiance.Syringe;

import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import net.hazen.hazennstuff.Registries.Effects.InfestedEffect;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.core.Holder;
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

public class Syringe extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private int delay = 0;
    private int age = 0;
    private Vec3 spawnPos;

    public void setSpawnPos(Vec3 pos) {
        this.spawnPos = pos;
        if (pos != null) {
            this.setPos(pos);
        }
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

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

    @Override
    public void tick() {
        this.age++;
        if (this.age < this.delay) {
            if (this.spawnPos != null) {
                setPos(this.spawnPos);
            }
            return;
        }
        super.tick();
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
        level.playSound(null, getX(), getY(), getZ(), sound, SoundSource.NEUTRAL, 1.5f, 1.0f);
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);

        level.playSound(null, getX(), getY(), getZ(),
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

        level.playSound(null, getX(), getY(), getZ(),
                HnSSounds.SYRINGE_BARRAGE_HIT, SoundSource.NEUTRAL, 2.0f, 1.0f);

        discard();
    }


    //ANIMATION
    private final RawAnimation idle = RawAnimation.begin().thenLoop("animation.syringe.idle");

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