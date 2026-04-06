package net.hazen.hazennstuff.Entity.Spells.Ender.EndraconicMeteor.EndraconicBreath;

import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.damage.ISSDamageTypes;
import io.redspace.ironsspellbooks.entity.spells.AoeEntity;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Registries.HnSParticleHelper;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Optional;

public class EndraconicBreath extends AoeEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private DamageSource damageSource;

    public EndraconicBreath(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);

    }

    public EndraconicBreath(Level level) {
        this(HnSEntityRegistry.ENDRACONIC_BREATH.get(), level);
    }

    @Override
    public float getParticleCount() {
        return .15f;
    }

    @Override
    public Optional<ParticleOptions> getParticle() {
        return Optional.of(HnSParticleHelper.ENDRACONIC_BREATH_CLOUD);
    }

    @Override
    public void applyEffect(LivingEntity livingEntity) {
        if (damageSource == null) {
            damageSource = new DamageSource(DamageSources.getHolderFromResource(livingEntity, ISSDamageTypes.ENDER_MAGIC), this, getOwner());
        }

        DamageSources.ignoreNextKnockback(livingEntity);
        livingEntity.hurt(this.damageSource, this.getDamage());
    }

    //ANIMATION
    private final RawAnimation idle = RawAnimation.begin().thenLoop("idle");

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

    private float damage = 5.0f; // Default value

    public void setDamage(float damage) {
        this.damage = damage;
    }
}