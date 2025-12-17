package net.hazen.hazennstuff.Entity.Spells.Blood.LifestealKnife;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
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

public class VampireKnife extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public VampireKnife(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public VampireKnife(Level level, LivingEntity shooter)
    {
        this(HnSEntityRegistry.LIFESTEAL_KNIFE.get(), level);
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
    public void trailParticles() {
        for (int i = 0; i < 1; i++) {
            double speed = .05;
            double dx = Utils.random.nextDouble() * 2 * speed - speed;
            double dy = Utils.random.nextDouble() * 2 * speed - speed;
            double dz = Utils.random.nextDouble() * 2 * speed - speed;
            level.addParticle(ParticleHelper.BLOOD, this.getX() + dx, this.getY() + dy, this.getZ() + dz, dx, dy, dz);
        }
    }

    @Override
    public void impactParticles(double x, double y, double z) {
        MagicManager.spawnParticles(this.level, ParticleHelper.BLOOD, x, y, z, 5, .1, .1, .1, .25, true);
    }
    @Override
    public float getSpeed() {
        return 1.4f;
    }

    @Override
    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.of(HnSSounds.SYRINGE_BARRAGE_HIT);
    }

    @Override
    protected void doImpactSound(Holder<SoundEvent> sound) {
        level.playSound(null, getX(), getY(), getZ(), sound, SoundSource.NEUTRAL, 1.5f, 1.0f);
    }

    @Override
    protected void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        discard();
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);

        if (!level.isClientSide()) {
            Entity target = result.getEntity();

            if (getOwner() instanceof LivingEntity caster) {
                double bloodPower = caster.getAttributeValue(AttributeRegistry.BLOOD_SPELL_POWER);
                double spellPower = caster.getAttributeValue(AttributeRegistry.SPELL_POWER);

                float damage = (float)(2 + 2 * (bloodPower + spellPower));

                DamageSource source = level.damageSources().indirectMagic(this, caster);

                target.hurt(source, damage);

                caster.heal(damage * 0.075f);
            }

            level.playSound(null, getX(), getY(), getZ(),
                    HnSSounds.VAMPIRE_KNIFE_HIT, SoundSource.NEUTRAL, 2.0f, 1.0f
            );

            discard();
        }

    }

    //ANIMATION
    private final RawAnimation idle = RawAnimation.begin().thenLoop("animation.vampire_knife_projectile.idle");

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
}