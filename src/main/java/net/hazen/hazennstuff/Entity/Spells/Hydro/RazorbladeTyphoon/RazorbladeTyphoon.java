package net.hazen.hazennstuff.Entity.Spells.Hydro.RazorbladeTyphoon;

import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import mod.azure.azurelib.core.utils.MathHelper;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.*;

public class RazorbladeTyphoon extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public static final int lifetime = 150;
    int bounces;
    HashMap<UUID, Integer> victims;

    public RazorbladeTyphoon(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.victims = new HashMap<>();
        this.setNoGravity(true);
        this.setPierceLevel(-1);
    }

    public RazorbladeTyphoon(Level level, LivingEntity shooter) {
        this(HnSEntityRegistry.RAZORBLADE_TYPHOON.get(), level);
        setOwner(shooter);
    }

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

    private LivingEntity findNearestTarget() {
        List<LivingEntity> entities = level.getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(12),
                e -> e != this.getOwner() && e.isAlive() && !e.isInvisible());

        return entities.stream()
                .min(Comparator.comparingDouble(e -> e.distanceToSqr(this)))
                .orElse(null);
    }


    private LivingEntity lockedTarget = null;
    private float getYawFromVec(Vec3 vec) {
        return (float)(Math.toDegrees(Math.atan2(vec.z, vec.x)) - 180.0F);
    }

    private float getPitchFromVec(Vec3 vec) {
        return (float)(-Math.toDegrees(Math.atan2(vec.y, vec.horizontalDistance())));
    }

    private float rotLerp(float lerpSpeed, float current, float target) {
        float delta = MathHelper.wrapDegrees(target - current);
        return current + delta * Math.min(lerpSpeed * 0.05f, 1.0f);
    }

    @Override
    public void tick() {
        super.tick();

        if (!level.isClientSide) {
            if (this.tickCount > 10) {

                // Refresh target if needed
                if (lockedTarget == null || !lockedTarget.isAlive()) {
                    lockedTarget = findNearestTarget();
                }

                if (lockedTarget != null) {
                    Vec3 toTarget = lockedTarget.getEyePosition().subtract(this.position());
                    Vec3 currentMotion = this.getDeltaMovement();

                    // Prevent NaN if velocity is 0
                    if (currentMotion.lengthSqr() < 0.0001) {
                        currentMotion = toTarget.normalize().scale(getSpeed());
                    }

                    double homingStrength = 0.05; // same as SoulSeeker
                    double speed = currentMotion.length();

                    Vec3 desiredDirection = toTarget.normalize();

                    // Blend directions (THIS is the key behavior)
                    Vec3 newDirection = currentMotion.normalize()
                            .scale(1.0 - homingStrength)
                            .add(desiredDirection.scale(homingStrength))
                            .normalize();

                    this.setDeltaMovement(newDirection.scale(speed));
                }
            }
        }

        // Lifetime handling stays the same
        if (this.tickCount > lifetime) {
            this.discard();
            if (!this.level.isClientSide) {
                this.impactParticles(this.getX(), this.getBoundingBox().getCenter().y, this.getZ());
            }
        }
    }

    public void trailParticles() {
    }

    public void impactParticles(double x, double y, double z) {
    }


    public float getSpeed() {
        return 2.4F;
    }

    protected boolean canHitEntity(Entity pTarget) {
        return super.canHitEntity(pTarget) && this.canHitVictim(pTarget);
    }

    public void handleHitDetection() {
        Vec3 vec3 = this.getDeltaMovement();
        Vec3 pos = this.position();
        Vec3 vec32 = pos.add(vec3);
        HitResult hitresult = this.level.clip(new ClipContext(pos, vec32, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
        if (hitresult.getType() != HitResult.Type.MISS) {
            this.onHit(hitresult);
        } else {
            for(Entity entity : this.level.getEntities(this, this.getBoundingBox().inflate((double)0.25F), this::canHitEntity)) {
                this.onHit(new EntityHitResult(entity, this.getBoundingBox().getCenter().add(entity.getBoundingBox().getCenter()).scale((double)0.5F)));
            }
        }

    }

    public boolean canHitVictim(Entity entity) {
        Integer timestamp = (Integer)this.victims.get(entity.getUUID());
        return timestamp == null || entity.tickCount - timestamp >= 10;
    }

    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity target = pResult.getEntity();
        if (target instanceof LivingEntity livingEntity) {
            DamageSources.ignoreNextKnockback(livingEntity);
        }

        DamageSources.applyDamage(target, this.getDamage(), ((AbstractSpell) HnSSpellRegistries.RAZORBLADE_TYPHOON.get()).getDamageSource(this, this.getOwner()));
        this.victims.put(target.getUUID(), target.tickCount);
    }

    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        switch (pResult.getDirection()) {
            case UP:
            case DOWN:
                this.setDeltaMovement(this.getDeltaMovement().multiply((double)1.0F, this.isNoGravity() ? (double)-1.0F : (double)-0.8F, (double)1.0F));
                break;
            case EAST:
            case WEST:
                this.setDeltaMovement(this.getDeltaMovement().multiply((double)-1.0F, (double)1.0F, (double)1.0F));
                break;
            case NORTH:
            case SOUTH:
                this.setDeltaMovement(this.getDeltaMovement().multiply((double)1.0F, (double)1.0F, (double)-1.0F));
        }

        if (++this.bounces >= 6) {
            this.discard();
        }

    }

    public Optional<Holder<SoundEvent>> getImpactSound() {
            return Optional.of(HnSSounds.TERRARIA_IMPACT);
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
}