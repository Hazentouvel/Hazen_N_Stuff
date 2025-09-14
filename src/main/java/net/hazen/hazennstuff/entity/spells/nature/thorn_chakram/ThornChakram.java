package net.hazen.hazennstuff.entity.spells.nature.thorn_chakram;

import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.registries.EntityRegistry;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.hazen.hazennstuff.registries.HnSEntityRegistry;
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
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.*;

public class ThornChakram extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);


    public static final int lifetime = 20;
    int bounces;
    HashMap<UUID, Integer> victims;

    public ThornChakram(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.victims = new HashMap<>();
        this.setNoGravity(true);
    }

    public ThornChakram(Level level, LivingEntity shooter) {
        this(HnSEntityRegistry.THORN_CHAKRAM.get(), level);
        setOwner(shooter);
    }

    @Override
    public void trailParticles() {
        Vec3 pos = this.getBoundingBox().getCenter().add(getDeltaMovement());
        Vec3 random = Utils.getRandomVec3(0);
        pos = pos.add(getDeltaMovement());
        level().addParticle(ParticleHelper.ELECTRIC_SPARKS, pos.x, pos.y, pos.z, random.x, random.y, random.z);
    }

    @Override
    public void impactParticles(double x, double y, double z) {
        MagicManager.spawnParticles(level(), ParticleHelper.ELECTRIC_SPARKS, x, y, z, 12, .08, .08, .08, 0.3, false);
    }

    @Override
    public float getSpeed() {
        return 1.2f;
    }

    @Override
    protected boolean canHitEntity(Entity pTarget) {
        return super.canHitEntity(pTarget) && canHitVictim(pTarget);
    }

    private boolean hasHitOnce = false;
    private LivingEntity currentTarget = null;
    private final int maxHits = 3;
    private int hitCount = 0;


    @Override
    public void tick() {
        super.tick();

        if (currentTarget != null && currentTarget.isAlive()) {
            Vec3 direction = currentTarget.position().add(0, currentTarget.getBbHeight() * 0.5, 0).subtract(this.position()).normalize();
            double speed = this.getDeltaMovement().length(); // preserve speed
            this.setDeltaMovement(direction.scale(speed));
        }

        this.handleHitDetection();
    }


    @Override
    public void handleHitDetection() {
        Vec3 vec3 = this.getDeltaMovement();
        Vec3 pos = this.position();
        Vec3 vec32 = pos.add(vec3);

        // Check block collision
        HitResult hitresult = level().clip(new ClipContext(pos, vec32, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
        if (hitresult.getType() != HitResult.Type.MISS) {
            onHit(hitresult);
            return;
        }

        // Check entity collision
        var entities = level().getEntities(this, this.getBoundingBox().inflate(0.25f), this::canHitEntity);
        for (Entity entity : entities) {
            if (entity instanceof LivingEntity living && !entity.isSpectator()) {
                onHit(new EntityHitResult(entity, this.position()));
                hasHitOnce = true;
                acquireNextTarget(living); // find next target to home in on
                return;
            }
        }
    }

    private void acquireNextTarget(LivingEntity lastHit) {
        List<LivingEntity> nearby = level().getEntitiesOfClass(LivingEntity.class,
                this.getBoundingBox().inflate(8), // range to search
                e -> e != lastHit && e.isAlive() && this.canHitEntity(e)
        );

        if (!nearby.isEmpty()) {
            // Choose the closest target
            nearby.sort(Comparator.comparingDouble(e -> e.distanceToSqr(this)));
            currentTarget = nearby.get(0);
        }
    }


//    @Override
//    public void handleHitDetection() {
//        Vec3 vec3 = this.getDeltaMovement();
//        Vec3 pos = this.position();
//        Vec3 vec32 = pos.add(vec3);
//        HitResult hitresult = level().clip(new ClipContext(pos, vec32, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
//        if (hitresult.getType() != HitResult.Type.MISS) {
//            //block hits
//            onHit(hitresult);
//        } else {
//            //entity hits
//            var entities = level().getEntities(this, this.getBoundingBox(), this::canHitEntity);
//            for (Entity entity : entities) {
//                onHit(new EntityHitResult(entity, this.getBoundingBox().getCenter().add(entity.getBoundingBox().getCenter())));
//            }
//        }
//    }

    public boolean canHitVictim(Entity entity) {
        var timestamp = victims.get(entity.getUUID());
        return timestamp == null || entity.tickCount - timestamp >= 10;
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);

        var target = pResult.getEntity();

        if (target instanceof LivingEntity livingEntity) {
            DamageSources.ignoreNextKnockback(livingEntity);
        }

        DamageSources.applyDamage(target, getDamage(), SpellRegistry.BALL_LIGHTNING_SPELL.get().getDamageSource(this, getOwner()));
        victims.put(target.getUUID(), target.tickCount);

        // Increment hit count and discard if maxHits is reached
        hitCount++;
        if (hitCount >= maxHits) {
            discard();
        }
    }


    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        switch (pResult.getDirection()) {
            case UP, DOWN ->
                    this.setDeltaMovement(this.getDeltaMovement().multiply(1, this.isNoGravity() ? -1 : -.8f, 1));
            case EAST, WEST -> this.setDeltaMovement(this.getDeltaMovement().multiply(-1, 1, 1));
            case NORTH, SOUTH -> this.setDeltaMovement(this.getDeltaMovement().multiply(1, 1, -1));
        }
        if (++bounces >= 6) {
            discard();
        }
    }

    @Override
    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.of(SoundRegistry.CHAIN_LIGHTNING_CHAIN);
    }

    //ANIMATION
    private final RawAnimation idle = RawAnimation.begin().thenLoop("animation.thorn_chakram_spell.idle");

    private PlayState predicate(software.bernie.geckolib.animation.AnimationState event) {
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