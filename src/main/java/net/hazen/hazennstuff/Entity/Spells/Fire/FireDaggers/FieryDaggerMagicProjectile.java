package net.hazen.hazennstuff.Entity.Spells.Fire.FireDaggers;

import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.fiery_dagger.FieryDaggerEntity;
import io.redspace.ironsspellbooks.entity.spells.magma_ball.FireField;
import io.redspace.ironsspellbooks.particle.BlastwaveParticleOptions;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import io.redspace.ironsspellbooks.util.NBT;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class FieryDaggerMagicProjectile extends FieryDaggerEntity {
    public int delay;
    public @Nullable Vec3 ownerTrack;
    private @Nullable UUID targetEntity;
    private @Nullable Entity cachedTarget;
    int age;
    boolean isGrounded;
    private final AnimatableInstanceCache cache;

    private static final int SPAWN_LAUNCH_EXTRA_MIN = 10;
    private static final int SPAWN_LAUNCH_EXTRA_MAX = 30;
    public @Nullable Vec3 launchDir; // new: direction to use when launching after delay

    public FieryDaggerMagicProjectile(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.ownerTrack = null;
        this.targetEntity = null;
        this.cachedTarget = null;
        this.cache = GeckoLibUtil.createInstanceCache(this);
        this.setNoGravity(true);
    }

    public FieryDaggerMagicProjectile(Level level) {
        this(HnSEntityRegistry.FIERY_DAGGER_MAGIC_PROJECTILE.get(), level);
    }

    public void setTarget(Entity target) {
        this.cachedTarget = target;
        this.targetEntity = target.getUUID();
    }

    public void setExplosionRadius(float radius) {
        this.explosionRadius = radius;
    }

    public boolean isTrackingOwner() {
        return this.ownerTrack != null;
    }

    public boolean hasTarget() {
        return this.targetEntity != null;
    }

    public boolean isSpawnDagger() {
        return this.explosionRadius > 0.0F;
    }

    private void createFireField() {
        FireField fireField = new FireField(this.level);

        fireField.setOwner(this.getOwner());

        fireField.setPos(Utils.moveToRelativeGroundLevel(this.level, this.position(), 3));
        fireField.setRadius(this.explosionRadius + 1.0F);
        fireField.setCircular();
        fireField.setDamage(this.getDamage() * 0.8F);
        fireField.setDuration(300);
        fireField.setDelay(this.delay + 25);
        fireField.setRadiusPerTick(-fireField.getRadius() / (float) fireField.getDuration());

        this.level.addFreshEntity(fireField);
    }


    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        Entity target = entityHitResult.getEntity();
        DamageSources.applyDamage(target, this.getDamage(),
                (HnSSpellRegistries.FIERY_DAGGER.get())
                        .getDamageSource(this, this.getOwner()));
        this.pierceOrDiscard();
        entityHitResult.getEntity().invulnerableTime = 0;
    }

    protected void onHit(HitResult hitresult) {
        super.onHit(hitresult);
        if (this.isSpawnDagger() && this.level instanceof ServerLevel) {
            this.createDaggerZone(Utils.moveToRelativeGroundLevel(this.level, hitresult.getLocation(), 3));
        }

        this.discardHelper(hitresult);
    }

    public void createDaggerZone(Vec3 center) {
        MagicManager.spawnParticles(this.level, new BlastwaveParticleOptions(new Vector3f(1.0F, 0.6F, 0.3F), this.explosionRadius + 1.0F), center.x, center.y + 0.15, center.z, 1, (double)0.0F, (double)0.0F, (double)0.0F, (double)0.0F, false);
        this.playSound(SoundRegistry.FIRE_CAST.get(), 2.0F, (float)Utils.random.nextIntBetweenInclusive(80, 110) * 0.01F);
        float spawnRadius = this.explosionRadius;
        float density = 1.0F;
        int rings = (int)(spawnRadius * density);
        float ringSpacing = 1.0F / density;

        for(int i = 1; i < rings; ++i) {
            float ringRadius = ringSpacing * (float)i;
            int daggerCount = (int)(ringRadius * ((float)Math.PI * 2F));
            float angle = 360.0F / (float)daggerCount * ((float)Math.PI / 180F);

            for(int j = 0; j < daggerCount; ++j) {
                Vec3 jitter = Utils.getRandomVec3((ringSpacing * 0.4F));
                Vec3 pos = Utils.moveToRelativeGroundLevel(this.level, center.add((ringRadius * Mth.sin(angle * (float)j)), (double)0.0F, (double)(ringRadius * Mth.cos(angle * (float)j))).add(jitter), 8);

                FieryDaggerMagicProjectile dagger = new FieryDaggerMagicProjectile(this.level);
                dagger.setOwner(this.getOwner());
                dagger.setDamage(this.getDamage());

                // make dagger affected by gravity so it falls to the ground
                dagger.setDeltaMovement(0.0F, 0.0F, 0.0F);
                dagger.deltaMovementOld = dagger.getDeltaMovement();
                dagger.moveTo(pos);
                dagger.isGrounded = true;
                dagger.setNoGravity(false); // <-- crucial: allow it to fall to ground

                // per-dagger extra randomized delay before launch (relative to this dagger's delay)
                int extra = Utils.random.nextIntBetweenInclusive(SPAWN_LAUNCH_EXTRA_MIN, SPAWN_LAUNCH_EXTRA_MAX);
                dagger.delay = this.delay + extra;

                // Ensure spawn-zone daggers have a default upward launch direction so they fire upwards when their delay expires.
                dagger.launchDir = new Vec3(0.0D, 1.0D, 0.0D);

                this.level.addFreshEntity(dagger);
            }
        }

        this.createFireField();
    }

    // java
    @Override
    public void tick() {
        /*
         * Unified waiting/launch handling:
         * - While age < delay we update owner-tracking position and always update visual rotation to face
         *   the owner's current yaw/pitch (so the dagger points pommel->tip toward the player).
         * - When age == delay we sample an owner look if needed and launch using `launchDir` if present.
         * - After delay we fall back to super.tick() for normal projectile movement/cleanup.
         */

        if (this.age++ < this.delay) {
            Entity owner = this.getOwner();
            float strength = 0.5F;

            if (owner != null && this.isTrackingOwner()) {
                // follow owner movement
                Vec3 ownerMotion = owner.position().subtract(owner.xOld, owner.yOld, owner.zOld);
                this.setPos(this.position().add(ownerMotion));
            }

            // Always update visual rotation each tick so dagger faces the owner's current yaw/pitch
            if (owner != null) {
                // Use owner's yaw/pitch directly to ensure model orientation matches the player
                float yRot = owner.getYRot();
                float xRot = owner.getXRot();
                this.setYRot(yRot);
                this.setXRot(xRot);
                this.yRotO = yRot;
                this.xRotO = xRot;
            }

            Entity target = this.getTargetEntity();
            if (target != null) {
                Vec3 targetPos = target.getBoundingBox().getCenter();
                Vec3 targetMotion = targetPos.subtract(this.position()).normalize().scale((double)this.getSpeed());
                Vec3 currentMotion = this.getDeltaMovement();
                this.deltaMovementOld = currentMotion;
                this.setDeltaMovement(currentMotion.add(targetMotion.subtract(currentMotion).scale((double)strength)));
                if (this.tickCount == 1) {
                    this.deltaMovementOld = this.getDeltaMovement();
                }
            }

            if (this.age == this.delay) {
                // If this projectile was following an owner and no fixed launchDir was stored,
                // sample the owner's current look direction now so it fires where the player is facing at launch time.
                if (this.launchDir == null && owner != null) {
                    Vec3 ownerLook = owner.getLookAngle();
                    if (ownerLook != null) {
                        this.launchDir = ownerLook;
                    }
                }

                // If we have a launchDir, launch now (applies to both spawn and non-spawn daggers)
                if (this.launchDir != null) {
                    if (!this.level.isClientSide) {
                        this.isGrounded = false;
                        this.setNoGravity(true);
                        Vec3 dir = this.launchDir.normalize().scale(this.getSpeed());
                        this.setDeltaMovement(dir);
                        this.deltaMovementOld = this.getDeltaMovement();
                    }
                    this.ownerTrack = null;
                    // Keep launchDir for consistent movement direction

                    if (Utils.random.nextFloat() < 0.25F) {
                        this.playSound(SoundRegistry.FIERY_DAGGER_THROW.get(), 0.75F, (float)Utils.random.nextIntBetweenInclusive(90, 110) * 0.01F);
                    } else {
                        this.playSound(SoundRegistry.FIERY_DAGGER_THROW.get(), 2.0F, (float)Utils.random.nextIntBetweenInclusive(90, 110) * 0.01F);
                    }
                } else {
                    // Fallback launch behavior when no launchDir present (preserve prior behavior)
                    if (this.isGrounded) {
                        if (!this.level.isClientSide) {
                            this.isGrounded = false;
                            this.setNoGravity(true);
                            this.setDeltaMovement(0.0D, this.getSpeed(), 0.0D);
                            this.deltaMovementOld = this.getDeltaMovement();
                        }
                        if (Utils.random.nextFloat() < 0.25F) {
                            this.playSound(SoundRegistry.FIERY_DAGGER_THROW.get(), 0.75F, (float)Utils.random.nextIntBetweenInclusive(90, 110) * 0.01F);
                        }
                    } else {
                        this.playSound(SoundRegistry.FIERY_DAGGER_THROW.get(), 2.0F, (float)Utils.random.nextIntBetweenInclusive(90, 110) * 0.01F);
                    }
                }

                List<Entity> hits = this.level.getEntities(this, this.getBoundingBox().inflate(0.4D), this::canHitEntity);
                EntityHitResult hitResult = hits.isEmpty() ? null : new EntityHitResult(hits.get(0));
                if (hitResult != null) {
                    this.onHit(hitResult);
                }
            }

            if (this.level.isClientSide) {
                this.level.addParticle(ParticleHelper.EMBERS, this.getX(), this.getY() + (double)(this.getBbHeight() * 0.5F), this.getZ(), 0.0, 0.0, 0.0);
            }
        } else {
            super.tick();
        }
    }


    protected boolean canHitEntity(Entity pTarget) {
        return !this.isSpawnDagger() && super.canHitEntity(pTarget);
    }

    public void impactParticles(double x, double y, double z) {
        MagicManager.spawnParticles(this.level, ParticleTypes.LAVA, x, y, z, 5, 0.1, 0.1, 0.1, 0.25F, true);
    }

    public void trailParticles() {
        float yHeading = -((float)(Mth.atan2(this.getDeltaMovement().z, this.getDeltaMovement().x) * (double)(180F / (float)Math.PI)) + 90.0F);
        float radius = 0.25F;
        int steps = 2;
        Vec3 vec = this.getDeltaMovement();
        double x2 = this.getX();
        double x1 = x2 - vec.x;
        double y2 = this.getY();
        double y1 = y2 - vec.y;
        double z2 = this.getZ();
        double z1 = z2 - vec.z;

        for(int j = 0; j < steps; ++j) {
            float offset = 1.0F / (float)steps * (float)j;
            double radians = (((float)this.tickCount + offset) / 7.5F * 360.0F * ((float)Math.PI / 180F));
            Vec3 swirl = (new Vec3(Math.cos(radians) * (double)radius, Math.sin(radians) * (double)radius, 0.0F)).yRot(yHeading * ((float)Math.PI / 180F));
            double x = Mth.lerp(offset, x1, x2) + swirl.x;
            double y = Mth.lerp(offset, y1, y2) + swirl.y + (double)(this.getBbHeight() / 2.0F);
            double z = Mth.lerp(offset, z1, z2) + swirl.z;
            Vec3 jitter = Vec3.ZERO;
            this.level.addParticle(ParticleHelper.EMBERS, x, y, z, jitter.x, jitter.y, jitter.z);
        }

    }

    public float getSpeed() {
        return 1.25F;
    }

    public Optional<Holder<SoundEvent>> getImpactSound() {
        return this.isGrounded ? Optional.empty() : Optional.of(SoundRegistry.FIRE_IMPACT);
    }

    public Entity getTargetEntity() {
        if (this.cachedTarget != null && this.cachedTarget.isAlive()) {
            return this.cachedTarget;
        } else {
            if (this.targetEntity != null) {
                Level var2 = this.level;
                if (var2 instanceof ServerLevel) {
                    ServerLevel serverLevel = (ServerLevel)var2;
                    this.cachedTarget = serverLevel.getEntity(this.targetEntity);
                    if (this.cachedTarget == null) {
                        this.targetEntity = null;
                    }

                    return this.cachedTarget;
                }
            }

            return null;
        }
    }

    protected void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("delay", this.delay);
        if (this.ownerTrack != null) {
            tag.put("ownerTrack", NBT.writeVec3Pos(this.ownerTrack));
        }
        if (this.targetEntity != null) {
            tag.putUUID("target", this.targetEntity);
        }
        tag.putInt("Age", this.age);
        if (this.launchDir != null) {
            tag.put("launchDir", NBT.writeVec3Pos(this.launchDir));
        }
    }

    protected void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.delay = tag.getInt("delay");
        if (tag.hasUUID("ownerTrack")) {
            this.ownerTrack = NBT.readVec3(tag.getCompound("ownerTrack"));
        }
        if (tag.hasUUID("target")) {
            this.targetEntity = tag.getUUID("target");
        }
        this.age = tag.getInt("Age");
        if (tag.contains("launchDir")) {
            this.launchDir = NBT.readVec3(tag.getCompound("launchDir"));
        }
    }


    public void writeSpawnData(RegistryFriendlyByteBuf buffer) {
        buffer.writeInt(this.delay);
        buffer.writeFloat(this.explosionRadius);
        buffer.writeBoolean(this.isGrounded);
        boolean tracking = this.ownerTrack != null;
        buffer.writeBoolean(tracking);
        if (tracking) {
            buffer.writeDouble(this.ownerTrack.x);
            buffer.writeDouble(this.ownerTrack.y);
            buffer.writeDouble(this.ownerTrack.z);
        }
        boolean target = this.cachedTarget != null;
        buffer.writeBoolean(target);
        if (target) {
            buffer.writeInt(this.cachedTarget.getId());
        }
        boolean hasLaunch = this.launchDir != null;
        buffer.writeBoolean(hasLaunch);
        if (hasLaunch) {
            buffer.writeDouble(this.launchDir.x);
            buffer.writeDouble(this.launchDir.y);
            buffer.writeDouble(this.launchDir.z);
        }
    }

    public void readSpawnData(RegistryFriendlyByteBuf buffer) {
        this.delay = buffer.readInt();
        this.explosionRadius = buffer.readFloat();
        this.isGrounded = buffer.readBoolean();
        if (buffer.readBoolean()) {
            this.ownerTrack = new Vec3(buffer.readDouble(), buffer.readDouble(), buffer.readDouble());
        }
        if (buffer.readBoolean()) {
            this.cachedTarget = this.level.getEntity(buffer.readInt());
            if (this.cachedTarget != null) {
                this.targetEntity = this.cachedTarget.getUUID();
            }
        }
        if (buffer.readBoolean()) {
            this.launchDir = new Vec3(buffer.readDouble(), buffer.readDouble(), buffer.readDouble());
        }
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    public double getTick(Object object) {
        return this.tickCount;
    }
}
