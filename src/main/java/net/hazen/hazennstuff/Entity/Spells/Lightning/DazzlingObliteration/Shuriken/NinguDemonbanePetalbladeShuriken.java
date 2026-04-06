package net.hazen.hazennstuff.Entity.Spells.Lightning.DazzlingObliteration.Shuriken;

import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.particle.ZapParticleOption;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.Optional;

public class NinguDemonbanePetalbladeShuriken extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private int delay = 0;
    private int age = 0;
    private Vec3 spawnPos;
    public @Nullable Vec3 ownerTrack = null;
    public @Nullable Vec3 launchDir = null;


    public void setSpawnPos(Vec3 pos) {
        this.spawnPos = pos;
        if (pos != null) {
            this.setPos(pos);
        }
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public NinguDemonbanePetalbladeShuriken(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setNoGravity(true);
    }

    public NinguDemonbanePetalbladeShuriken(Level level, LivingEntity shooter)
    {
        this(HnSEntityRegistry.NINGU_DEMONBANE_PETALBLADE_SHURIKEN.get(), level);
        setOwner(shooter);
    }


    @Override
    public void tick() {
        if (this.age++ < this.delay) {
            Entity owner = this.getOwner();
            if (owner != null && this.ownerTrack != null) {
                Vec3 desired = owner.position().add(this.ownerTrack);
                setPos(desired.x, desired.y, desired.z);
                if (owner instanceof LivingEntity livingOwner) {
                    this.setYRot(livingOwner.getYRot());
                    this.setXRot(livingOwner.getXRot());
                }
            } else if (this.ownerTrack != null) {
                if (this.spawnPos != null) setPos(this.spawnPos);
            } else if (this.spawnPos != null) {
                setPos(this.spawnPos);
            }

            if (level.isClientSide) {
                level.addParticle(ParticleHelper.ELECTRIC_SPARKS,
                        getX(), getY() + getBbHeight() * 0.5, getZ(),
                        (random.nextDouble() - 0.5) * 0.1,
                        (random.nextDouble() - 0.5) * 0.1,
                        (random.nextDouble() - 0.5) * 0.1);
            }
            if (this.age == this.delay) {
                Entity owner2 = this.getOwner();
                // If no explicit launchDir was provided, sample the owner's current look direction now
                if (this.launchDir == null && owner2 instanceof LivingEntity livingOwner2) {
                    this.launchDir = livingOwner2.getLookAngle();
                }

                if (this.launchDir != null && !this.level.isClientSide) {
                    Vec3 dir = this.launchDir.normalize().scale(this.getSpeed());
                    this.setDeltaMovement(dir);
                    this.deltaMovementOld = this.getDeltaMovement();
                }
                // clear ownerTrack so it no longer follows
                this.ownerTrack = null;
            }
            return;
        }

        super.tick();
    }

    @Override
    public float getSpeed() {
        return 1.4f;
    }

    @Override
    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.of(HnSSounds.ELECTRIC_IMPACT);
    }

    @Override
    protected void doImpactSound(Holder<SoundEvent> sound) {
        level.playSound(null, getX(), getY(), getZ(), sound, SoundSource.NEUTRAL, 1.5f, 1.0f);
    }

    @Override
    public void trailParticles() {
        Vec3 pos = this.getBoundingBox().getCenter().add(getDeltaMovement());
        Vec3 random = Utils.getRandomVec3(0.25f).add(pos);
        pos = pos.add(getDeltaMovement());
        level.addParticle(new ZapParticleOption(random), pos.x, pos.y, pos.z, 0, 0, 0);
    }

    @Override
    public void impactParticles(double x, double y, double z) {
        MagicManager.spawnParticles(level, ParticleHelper.ELECTRIC_SPARKS, x, y, z, 12, .08, .08, .08, 0.3, false);
    }

    private void applyAreaEffect(Vec3 center, LivingEntity owner, float radius) {
        List<LivingEntity> targets = this.level.getEntitiesOfClass(
                LivingEntity.class,
                AABB.ofSize(center, (double)radius * 2.0D, (double)radius * 2.0D, (double)radius * 2.0D));

        for (LivingEntity target : targets) {
            if (target == null || !target.isAlive()) continue;
            if (target == owner) continue;

            Vec3 toTarget = target.position().subtract(center);
            if (toTarget.lengthSqr() > radius * radius) continue;

            DamageSources.applyDamage(target, damage, HnSSpellRegistries.DAZZLING_OBLITERATION.get().getDamageSource(this, owner));

            target.addEffect(new MobEffectInstance(HnSEffects.ELECTROCUTED, 100, 0));
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        if (this.level.isClientSide) return;
        LivingEntity owner = (LivingEntity) this.getOwner();
        Vec3 hitPos = blockHitResult.getLocation();
        applyAreaEffect(hitPos, owner, 4.0f);

        discard();
    }


    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);

        Entity hitEntity = entityHitResult.getEntity();
        LivingEntity owner = (LivingEntity) this.getOwner();

        Vec3 center = hitEntity.position();

        applyAreaEffect(center, owner, 4.0F);

        discard();
    }

    //ANIMATION
    private final RawAnimation idle = RawAnimation.begin().thenLoop("idle_2");

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

    public void setDamage(float damage) {
        this.damage = damage;
    }
}
