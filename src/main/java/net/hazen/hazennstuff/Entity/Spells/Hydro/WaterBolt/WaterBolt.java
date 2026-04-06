package net.hazen.hazennstuff.Entity.Spells.Hydro.WaterBolt;

import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Registries.HnSParticleHelper;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
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

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class WaterBolt extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public static final int lifetime = 100;
    int bounces;
    HashMap<UUID, Integer> victims;

    public WaterBolt(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.victims = new HashMap<>();
        this.setNoGravity(true);
        this.setPierceLevel(-1);
    }

    public WaterBolt(Level level, LivingEntity shooter) {
        this(HnSEntityRegistry.WATER_BOLT.get(), level);
        setOwner(shooter);
    }

    public void trailParticles() {
    }

    public void impactParticles(double x, double y, double z) {
    }


    public float getSpeed() {
        return 0.6F;
    }

    protected boolean canHitEntity(Entity pTarget) {
        return super.canHitEntity(pTarget) && this.canHitVictim(pTarget);
    }

    public void tick() {
        super.tick();
        if (this.tickCount > 100) {
            this.discard();
            if (!this.level.isClientSide) {
                this.impactParticles(this.getX(), this.getBoundingBox().getCenter().y, this.getZ());
            }
        }

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

        DamageSources.applyDamage(target, this.getDamage(), ((AbstractSpell) HnSSpellRegistries.WATER_BOLT.get()).getDamageSource(this, this.getOwner()));
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