package net.hazen.hazennstuff.Entity.Spells.Fire.BrimstoneHellblast;

import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.config.ServerConfigs;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.network.particles.FieryExplosionParticlesPacket;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.level.ExplosionEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.Optional;

public class BrimstoneHellblast extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public BrimstoneHellblast(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setNoGravity(true);
    }

    public BrimstoneHellblast(Level pLevel, LivingEntity pShooter) {
        this(HnSEntityRegistry.BRIMSTONE_HELLBLAST.get(), pLevel);
        this.setOwner(pShooter);
    }

    public void setRotation(float x, float y) {
        this.setXRot(x);
        this.xRotO = x;
        this.setYRot(y);
        this.yRotO = y;
    }

    public void trailParticles() {
        Vec3 vec3 = this.getDeltaMovement();
        double d0 = this.getX() - vec3.x;
        double d1 = this.getY() - vec3.y;
        double d2 = this.getZ() - vec3.z;
        int count = Mth.clamp((int)(vec3.lengthSqr() * (double)2.0F), 1, 4);

        for(int i = 0; i < count; ++i) {
            Vec3 random = Utils.getRandomVec3((double)(this.getBbHeight() * 0.2F));
            float f = (float)i / (float)count;
            double x = Mth.lerp((double)f, d0, this.getX() + vec3.x);
            double y = Mth.lerp((double)f, d1, this.getY() + vec3.y);
            double z = Mth.lerp((double)f, d2, this.getZ() + vec3.z);
            this.level.addParticle(ParticleHelper.FIERY_SMOKE, true, x - random.x, y + (double)(this.getBbHeight() * 0.5F) - random.y, z - random.z, (double)0.0F, (double)0.0F, (double)0.0F);
        }

    }

    @Override
    public void impactParticles(double x, double y, double z) {
        MagicManager.spawnParticles(this.level, ParticleHelper.FIERY_SMOKE, x, y, z, 5, .1, .1, .1, .25, true);
    }

    @Override
    public float getSpeed() {
        return 1.4f;
    }

    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.of(HnSSounds.BRIMSTONE_HELLBLAST_IMPACT);
    }

    @Override
    protected void doImpactSound(Holder<SoundEvent> sound) {
        level.playSound(null, getX(), getY(), getZ(), sound, SoundSource.NEUTRAL, 1.5f, 1.0f);
    }

    protected void onHit(HitResult hitResult) {
        if (!this.level.isClientSide) {
            this.impactParticles(this.xOld, this.yOld, this.zOld);
            float explosionRadius = this.getExplosionRadius();
            float explosionRadiusSqr = explosionRadius * explosionRadius;
            List<Entity> entities = this.level.getEntities(this, this.getBoundingBox().inflate((double)explosionRadius));
            Vec3 losPoint = Utils.raycastForBlock(this.level, this.position(), this.position().add((double)0.0F, (double)2.0F, (double)0.0F), Fluid.NONE).getLocation();

            for(Entity entity : entities) {
                double distanceSqr = entity.distanceToSqr(hitResult.getLocation());
                if (distanceSqr < (double)explosionRadiusSqr && this.canHitEntity(entity) && Utils.hasLineOfSight(this.level, losPoint, entity.getBoundingBox().getCenter(), true)) {
                    double p = (double)1.0F - distanceSqr / (double)explosionRadiusSqr;
                    float damage = (float)((double)this.damage * p);
                    DamageSources.applyDamage(entity, damage, ((AbstractSpell)HnSSpellRegistries.BRIMSTONE_HELLBLAST.get()).getDamageSource(this, this.getOwner()));
                }
            }

            if ((Boolean)ServerConfigs.SPELL_GREIFING.get()) {
                Explosion explosion = new Explosion(this.level, (Entity)null, ((AbstractSpell)HnSSpellRegistries.BRIMSTONE_HELLBLAST.get()).getDamageSource(this, this.getOwner()), (ExplosionDamageCalculator)null, this.getX(), this.getY(), this.getZ(), this.getExplosionRadius() / 2.0F, true,
                        Explosion.BlockInteraction.DESTROY,
                        ParticleTypes.EXPLOSION,
                        ParticleTypes.EXPLOSION_EMITTER,
                        HnSSounds.BRIMSTONE_HELLBLAST_IMPACT);
                if (!((ExplosionEvent.Start)NeoForge.EVENT_BUS.post(new ExplosionEvent.Start(this.level, explosion))).isCanceled()) {
                    explosion.explode();
                    explosion.finalizeExplosion(false);
                }
            }

            PacketDistributor.sendToPlayersTrackingEntity(this, new FieryExplosionParticlesPacket(hitResult.getLocation().subtract(this.getDeltaMovement().scale((double)0.5F)), this.getExplosionRadius()), new CustomPacketPayload[0]);
            this.playSound((SoundEvent)HnSSounds.BRIMSTONE_HELLBLAST_IMPACT.value(), 4.0F, (1.0F + (this.level.random.nextFloat() - this.level.random.nextFloat()) * 0.2F) * 0.7F);
            this.discard();
        }

    }

    //ANIMATION
    private final RawAnimation idle = RawAnimation.begin().thenLoop("animation.brimstone_hellblast.idle");

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