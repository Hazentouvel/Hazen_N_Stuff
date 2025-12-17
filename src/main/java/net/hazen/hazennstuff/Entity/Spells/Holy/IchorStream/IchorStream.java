package net.hazen.hazennstuff.Entity.Spells.Holy.IchorStream;

import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Registries.HnSParticleHelper;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

import java.util.Optional;

public class IchorStream extends AbstractMagicProjectile {

    private int spellLevel;
    private float spellPower;

    public IchorStream(EntityType<? extends Projectile> entityType, Level world) {
        super(entityType, world);
        this.setNoGravity(false);
    }

    public IchorStream(Level world, LivingEntity shooter, int spellLevel, float spellPower) {
        this(HnSEntityRegistry.ICHOR_STREAM.get(), world);
        this.setOwner(shooter);
        this.spellLevel = spellLevel;
        this.spellPower = spellPower;
        this.setNoGravity(false);

        var direction = shooter.getLookAngle();
        this.setDeltaMovement(direction.add(0, 0.6, 0).normalize().scale(0.8));
        this.setPos(shooter.getEyePosition());
    }


    @Override
    public void trailParticles() {
        level.addParticle(HnSParticleHelper.ICHOR_TRAIL, getX(), getY(), getZ(), 0, 0, 0);
    }

    @Override
    public void impactParticles(double x, double y, double z) {
        MagicManager.spawnParticles(level, HnSParticleHelper.ICHOR_TRAIL, x, y, z, 10, 0.1, 0.1, 0.1, 0.2, false);
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
    public void tick() {
        super.tick();
        if (this.level.isClientSide) {
            level.addParticle(HnSParticleHelper.ICHOR_TRAIL,
                    this.getX(), this.getY(), this.getZ(),
                    0, 0, 0);
        }
        if (this.tickCount > 20) {
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);

        if (!level.isClientSide && entityHitResult.getEntity() instanceof LivingEntity target) {
            int baseDuration = 100 + spellLevel * 40;
            int scaledDuration = baseDuration + (int) (spellPower * 20);
            int baseAmplifier = Math.max(0, (spellLevel - 1) / 2);
            int scaledAmplifier = baseAmplifier + (int) (spellPower / 10);

            target.addEffect(new MobEffectInstance(
                    HnSEffects.ICHOR,
                    scaledDuration,
                    scaledAmplifier,
                    false, true, true
            ));

            float damage = spellPower * 0.3f;
            DamageSources.applyDamage(
                    target,
                    damage,
                    HnSSpellRegistries.GOLDEN_SHOWER.get().getDamageSource(this, getOwner())
            );
        }

        this.discard();
    }

    @Override
    public float getSpeed() {
        return 1.4f;
    }
}
