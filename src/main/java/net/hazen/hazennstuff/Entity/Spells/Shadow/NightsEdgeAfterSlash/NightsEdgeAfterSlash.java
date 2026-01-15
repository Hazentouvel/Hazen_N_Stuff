package net.hazen.hazennstuff.Entity.Spells.Shadow.NightsEdgeAfterSlash;

import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Registries.HnSParticleHelper;
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
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Optional;

public class NightsEdgeAfterSlash extends AbstractMagicProjectile implements GeoEntity {
    public final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public int despawnTimer = 15;

    @Override
    public void tick() {
        super.tick();
        if (despawnTimer > 0) {
            despawnTimer--;
            if (despawnTimer == 0) discard();
        }
    }

    public void startDespawning() {
        despawnTimer = 15;
    }

    public boolean isDespawning() {
        return despawnTimer > 0;
    }

    public float getDespawnPercent(float partialTicks) {
        return (despawnTimer - partialTicks) / 10.0F;
    }

    public NightsEdgeAfterSlash(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setNoGravity(true);
    }

    public NightsEdgeAfterSlash(Level level, LivingEntity shooter)
    {
        this(HnSEntityRegistry.NIGHTS_EDGE_AFTER_SLASH.get(), level);
        setOwner(shooter);
    }

    @Override
    public void trailParticles() {
    }

    @Override
    public void impactParticles(double x, double y, double z) {
        MagicManager.spawnParticles(level, HnSParticleHelper.NIGHTS_EDGE_PARTICLE, x, y, z, 12, .08, .08, .08, 0.3, false);
    }


    @Override
    public float getSpeed() {
        return 1.6f;
    }

    @Override
    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.empty();
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
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        DamageSources.applyDamage(
                entityHitResult.getEntity(),
                damage,
                HnSSpellRegistries.DEATH_SENTENCE.get().getDamageSource(this, getOwner())
        );
    }

    //ANIMATION
    private final RawAnimation idle = RawAnimation.begin().thenLoop("animation.spectral_axe.idle");

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

    private float damage = 2.0f;

    public void setDamage(float damage) {
        this.damage = damage;
    }
}