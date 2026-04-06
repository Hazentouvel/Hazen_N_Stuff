package net.hazen.hazennstuff.Entity.Spells.Cosmic.CosmicBolt;

import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Registries.HnSParticleHelper;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.*;

public class CosmicBolt extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean hasHitOnce = false;
    private LivingEntity currentTarget = null;
    private int getMaxHits() {
        return 0 + spellLevel;
    }
    private int hitCount = 0;
    private int spellLevel = 1;

    HashMap<UUID, Integer> victims;

    public CosmicBolt(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.victims = new HashMap<>();
        this.setNoGravity(true);
        this.setPierceLevel(-1);
    }

    public CosmicBolt(Level level, LivingEntity shooter) {
        this(HnSEntityRegistry.COSMIC_BOLT.get(), level);
        setOwner(shooter);
    }

    public void setSpellLevel(int level) {
        this.spellLevel = level;
    }

    public void impactParticles(double x, double y, double z) {
        MagicManager.spawnParticles(this.level, HnSParticleHelper.STAR_IMPACT_PARTICLE, x, y, z, 5, 0.1, 0.1, 0.1, (double)0.25F, true);
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
            double radians = (double)(((float)this.tickCount + offset) / 7.5F * 360.0F * ((float)Math.PI / 180F));
            Vec3 swirl = (new Vec3(Math.cos(radians) * (double)radius, Math.sin(radians) * (double)radius, (double)0.0F)).yRot(yHeading * ((float)Math.PI / 180F));
            double x = Mth.lerp((double)offset, x1, x2) + swirl.x;
            double y = Mth.lerp((double)offset, y1, y2) + swirl.y + (double)(this.getBbHeight() / 2.0F);
            double z = Mth.lerp((double)offset, z1, z2) + swirl.z;
            Vec3 jitter = Vec3.ZERO;
            this.level.addParticle(HnSParticleHelper.STAR_PARTICLE, x, y, z, jitter.x, jitter.y, jitter.z);
        }
    }

    public float getSpeed() {
        return 1.6f;
    }

    protected boolean canHitEntity(Entity pTarget) {
        return super.canHitEntity(pTarget) && canHitVictim(pTarget);
    }

    public void tick() {
        super.tick();

        if (currentTarget != null && currentTarget.isAlive()) {
            Vec3 direction = currentTarget.position().add(0, currentTarget.getBbHeight() * 0.5, 0).subtract(this.position()).normalize();
            double speed = this.getDeltaMovement().length();
            this.setDeltaMovement(direction.scale(speed));
        }

        this.handleHitDetection();
    }

    @Override
    public void handleHitDetection() {
        Vec3 vec3 = this.getDeltaMovement();
        Vec3 pos = this.position();
        Vec3 vec32 = pos.add(vec3);

        HitResult hitresult = level.clip(new ClipContext(pos, vec32, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
        if (hitresult.getType() != HitResult.Type.MISS) {
            onHit(hitresult);
            return;
        }

        var entities = level.getEntities(this, this.getBoundingBox().inflate(0.25f), this::canHitEntity);
        for (Entity entity : entities) {
            if (entity instanceof LivingEntity living && !entity.isSpectator()) {
                onHit(new EntityHitResult(entity, this.position()));
                hasHitOnce = true;
                // find next target to home in on
                acquireNextTarget(living);
                return;
            }
        }
    }

    private void acquireNextTarget(LivingEntity lastHit) {
        List<LivingEntity> nearby = level.getEntitiesOfClass(LivingEntity.class,
                this.getBoundingBox().inflate(8),
                e -> e != lastHit && e.isAlive() && this.canHitEntity(e)
        );

        if (!nearby.isEmpty()) {
            nearby.sort(Comparator.comparingDouble(e -> e.distanceToSqr(this)));
            currentTarget = nearby.get(0);
        }
    }

    public boolean canHitVictim(Entity entity) {
        var timestamp = victims.get(entity.getUUID());
        return timestamp == null || entity.tickCount - timestamp >= 10;
    }

    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);

        var target = pResult.getEntity();
        if (target instanceof LivingEntity livingEntity) {DamageSources.ignoreNextKnockback(livingEntity);}

        DamageSources.applyDamage(target, getDamage(), HnSSpellRegistries.COSMIC_BOLT.get().getDamageSource(this, getOwner()));
        victims.put(target.getUUID(), target.tickCount);

        hitCount++;

        if (hitCount >= getMaxHits()) {
            discard();
            return;
        }
    }

    protected void doImpactSound(Holder<SoundEvent> sound) {
        this.level.playSound((Player)null, this.getX(), this.getY(), this.getZ(), sound, SoundSource.NEUTRAL, 1.0F, 1F);

        if (this.getOwner() instanceof Player player) {
            player.playSound(sound.value(), 0.75F, 1.0F);
        }
    }


    protected void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        discard();
    }

    public Optional<Holder<SoundEvent>> getImpactSound() {
        int nextHit = hitCount + 1;

        if (nextHit <= 2) {
            return Optional.of(HnSSounds.COSMIC_BOLT_HIT);
        } else if (nextHit <= 4) {
            return Optional.of(HnSSounds.COSMIC_BOLT_OKAY);
        } else if (nextHit <= 6) {
            return Optional.of(HnSSounds.COSMIC_BOLT_GOOD);
        } else {
            return Optional.of(HnSSounds.COSMIC_BOLT_EXCELLENT);
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
}