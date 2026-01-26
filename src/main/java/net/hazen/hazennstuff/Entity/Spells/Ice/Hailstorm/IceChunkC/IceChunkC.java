package net.hazen.hazennstuff.Entity.Spells.Ice.Hailstorm.IceChunkC;

import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.particle.BlastwaveParticleOptions;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Optional;

public class IceChunkC extends AbstractMagicProjectile implements GeoEntity {
    public IceChunkC(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setNoGravity(true);
    }

    public IceChunkC(Level pLevel, LivingEntity pShooter) {
        this(HnSEntityRegistry.ICE_CHUNK_C.get(), pLevel);
        this.setOwner(pShooter);
    }

    public void shoot(Vec3 rotation, float innaccuracy) {
        Vec3 offset = Utils.getRandomVec3((double)1.0F).normalize().scale((double)innaccuracy);
        super.shoot(rotation.add(offset));
    }

    public void trailParticles() {
        Vec3 vec = this.getDeltaMovement();
        double length = vec.length();
        int count = (int)Math.min(20L, Math.round(length) * 4L) + 1;
        float f = (float)length / (float)count;

        for(int i = 0; i < count; ++i) {
            Vec3 random = Utils.getRandomVec3(0.04);
            Vec3 p = vec.scale((double)(f * (float)i));
            this.level.addParticle(ParticleHelper.SNOW_DUST, this.getX() + random.x + p.x, this.getY() + random.y + p.y, this.getZ() + random.z + p.z, random.x, random.y, random.z);
        }

    }

    public void impactParticles(double x, double y, double z) {
        MagicManager.spawnParticles(this.level, new BlastwaveParticleOptions((HnSSpellRegistries.HAILSTORM.get()).getSchoolType().getTargetingColor(), 1.25F), x, y, z, 1, (double)0.0F, (double)0.0F, (double)0.0F, (double)0.0F, true);
        MagicManager.spawnParticles(level, ParticleHelper.SNOWFLAKE, x, y, z, 15, .03, .03, .03, 0.2, true);
    }

    public float getSpeed() {
        return 1.85F;
    }

    protected void doImpactSound(Holder<SoundEvent> sound) {
        this.level.playSound(null, this.getX(), this.getY(), this.getZ(), sound, SoundSource.NEUTRAL, 0.8F, 1.35F + Utils.random.nextFloat() * 0.3F);
    }

    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.of(SoundRegistry.ICE_IMPACT);
    }

    protected void onHitEntity(EntityHitResult entityHitResult) {
        if (!this.level.isClientSide) {
            this.impactParticles(this.xOld, this.yOld, this.zOld);
            this.getImpactSound().ifPresent(this::doImpactSound);

            DamageSources.applyDamage(entityHitResult.getEntity(), this.damage, (HnSSpellRegistries.HAILSTORM.get()).getDamageSource(this, this.getOwner()));
            this.discard();
        }

    }

    //ANIMATION

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private final RawAnimation idle = RawAnimation.begin().thenLoop("animation.ice_chunk.spinning_a");

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
