package net.hazen.hazennstuff.Entity.Spells.Ender.EndraconicMeteor;

import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.config.ServerConfigs;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.network.particles.FieryExplosionParticlesPacket;
import net.hazen.hazennstuff.Entity.Spells.Ender.EndraconicMeteor.EndraconicBreath.EndraconicBreath;
import net.hazen.hazennstuff.Particle.EnderExplosionParticlesPacket;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Registries.HnSParticleHelper;
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
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EndraconicMeteor extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public int delay;
    public @Nullable Vec3 ownerTrack;
    private @Nullable UUID targetEntity;
    private @Nullable Entity cachedTarget;
    int age;
    boolean isGrounded;

    private static final int SPAWN_LAUNCH_EXTRA_MIN = 10;
    private static final int SPAWN_LAUNCH_EXTRA_MAX = 30;
    public @Nullable Vec3 launchDir;
    public EndraconicMeteor(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setNoGravity(true);
    }

    public int shakeTime;
    protected boolean hasEmittedPoison;
    protected boolean inGround;
    protected float aoeDamage;

    public EndraconicMeteor(Level pLevel, LivingEntity pShooter) {
        this(HnSEntityRegistry.ENDRACONIC_METEOR.get(), pLevel);
        this.setOwner(pShooter);
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
            this.level.addParticle(HnSParticleHelper.ENDER_EMBER_PARTICLE, true, x - random.x, y + (double)(this.getBbHeight() * 0.5F) - random.y, z - random.z, (double)0.0F, (double)0.0F, (double)0.0F);
        }

    }

    @Override
    public void impactParticles(double x, double y, double z) {
        MagicManager.spawnParticles(this.level, HnSParticleHelper.ENDER_EMBER_PARTICLE, x, y, z, 5, .1, .1, .1, .25, true);
    }

    @Override
    public float getSpeed() {
        return 2f;
    }

    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.of(HnSSounds.ENDRACONIC_METEOR_IMPACT);
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
                    DamageSources.applyDamage(entity, damage, ((AbstractSpell)HnSSpellRegistries.ENDRACONIC_METEOR.get()).getDamageSource(this, this.getOwner()));
                }
            }

            if ((Boolean)ServerConfigs.SPELL_GREIFING.get()) {
                Explosion explosion = new Explosion(this.level, (Entity)null, ((AbstractSpell)HnSSpellRegistries.ENDRACONIC_METEOR.get()).getDamageSource(this, this.getOwner()), (ExplosionDamageCalculator)null, this.getX(), this.getY(), this.getZ(), this.getExplosionRadius() / 2.0F, true,
                        Explosion.BlockInteraction.DESTROY,
                        ParticleTypes.EXPLOSION,
                        ParticleTypes.EXPLOSION_EMITTER,
                        HnSSounds.ENDRACONIC_METEOR_IMPACT);
                if (!((ExplosionEvent.Start)NeoForge.EVENT_BUS.post(new ExplosionEvent.Start(this.level, explosion))).isCanceled()) {
                    explosion.explode();
                    explosion.finalizeExplosion(false);
                }
            }

            PacketDistributor.sendToPlayersTrackingEntity(this, new EnderExplosionParticlesPacket(hitResult.getLocation().subtract(this.getDeltaMovement().scale((double)0.5F)), this.getExplosionRadius()), new CustomPacketPayload[0]);
            this.playSound((SoundEvent)HnSSounds.ENDRACONIC_METEOR_IMPACT.value(), 4.0F, (1.0F + (this.level.random.nextFloat() - this.level.random.nextFloat()) * 0.2F) * 0.7F);
            this.discard();
        }

        if (!level.isClientSide && !hasEmittedPoison) {
            createEndraconicBreath(hitResult.getLocation());
        }

    }


    public void setAoeDamage(float damage) {
        this.aoeDamage = damage;
    }

    public float getAoeDamage() {
        return aoeDamage;
    }

    public void createEndraconicBreath(Vec3 location) {
        if (!level.isClientSide) {
            EndraconicBreath cloud = new EndraconicBreath(level);
            cloud.setOwner(getOwner());
            cloud.setDuration(300);
            cloud.setDamage(aoeDamage);
            cloud.moveTo(location);
            level.addFreshEntity(cloud);
            hasEmittedPoison = true;
        }
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

    @Override
    public void tick() {
        if (this.age++ < this.delay) {
            Entity owner = this.getOwner();

            if (owner != null && this.ownerTrack != null) {
                Vec3 ownerMotion = owner.position().subtract(owner.xOld, owner.yOld, owner.zOld);
                this.setPos(this.position().add(ownerMotion));
            }

            if (owner != null) {
                float yRot = owner.getYRot();
                float xRot = owner.getXRot();
                this.setYRot(yRot);
                this.setXRot(xRot);
                this.yRotO = yRot;
                this.xRotO = xRot;
            }

            if (this.age == this.delay) {
                // Sample owner's look if no preset launchDir
                if (this.launchDir == null && owner instanceof LivingEntity) {
                    this.launchDir = owner.getLookAngle();
                }

                if (this.launchDir != null) {
                    if (!this.level.isClientSide) {
                        this.isGrounded = false;
                        this.setNoGravity(true);
                        Vec3 dir = this.launchDir.normalize().scale(this.getSpeed());
                        this.setDeltaMovement(dir);
                    }
                    this.ownerTrack = null;

                    if (Utils.random.nextFloat() < 0.25F) {
                        this.playSound((SoundEvent)HnSSounds.ENDRACONIC_METEOR_CAST.value(), 0.75F, 1);
                    } else {
                        this.playSound((SoundEvent)HnSSounds.ENDRACONIC_METEOR_CAST.value(), 1.0F, 1);
                    }
                }
            }

        } else {
            super.tick();
        }
    }
}
