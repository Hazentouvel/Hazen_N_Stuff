package net.hazen.hazennstuff.entity.spells.ice.ice_arrow.IceCloud;

import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.damage.ISSDamageTypes;
import io.redspace.ironsspellbooks.entity.spells.AoeEntity;
import net.hazen.hazennstuff.registries.HnSDamageTypes;
import net.hazen.hazennstuff.registries.HnSEntityRegistry;
import net.hazen.hazennstuff.registries.HnSParticleHelper;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;

import java.util.Optional;

public class IceCloud extends AoeEntity {
    private DamageSource damageSource;

    public IceCloud(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);

    }

    public IceCloud(Level level) {
        this(HnSEntityRegistry.ICE_CLOUD.get(), level);
    }

    @Override
    public void applyEffect(LivingEntity target) {
        if (damageSource == null) {
            damageSource = new DamageSource(DamageSources.getHolderFromResource(target, HnSDamageTypes.ICE_CLOUD), this, getOwner());
        }
        DamageSources.ignoreNextKnockback(target);
        target.hurt(damageSource, getDamage());
        int additionalFreezeTicks = 100;
        target.setTicksFrozen(Math.min(target.getTicksRequiredToFreeze(), target.getTicksFrozen() + additionalFreezeTicks));
    }

    @Override
    public float getParticleCount() {
        return .15f;
    }

    @Override
    public Optional<ParticleOptions> getParticle() {
        return Optional.of(HnSParticleHelper.ICE_CLOUD);
    }
}