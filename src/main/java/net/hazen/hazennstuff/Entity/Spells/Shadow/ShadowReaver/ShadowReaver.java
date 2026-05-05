package net.hazen.hazennstuff.Entity.Spells.Shadow.ShadowReaver;

import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import net.hazen.hazennstuff.Registries.Effects.InfestedEffect;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Registries.HnSParticleHelper;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.hazen.hazentouvelib.Registries.HLEffects;
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

import java.util.*;

public class ShadowReaver extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    HashMap<UUID, Integer> victims;

    public ShadowReaver(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.victims = new HashMap<>();
        this.setNoGravity(true);
        this.setPierceLevel(-1);
    }

    public ShadowReaver(Level level, LivingEntity shooter) {
        this(HnSEntityRegistry.SHADOW_REAVER.get(), level);
        setOwner(shooter);
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
            this.level.addParticle(HnSParticleHelper.NIGHTS_EDGE_PARTICLE, x, y, z, jitter.x, jitter.y, jitter.z);
        }
    }

    public void impactParticles(double x, double y, double z) {
        MagicManager.spawnParticles(this.level(), HnSParticleHelper.NIGHTS_EDGE_PARTICLE, x, y, z, 25, 0.0F, 0.0F, 0.0F, 0.18, true);
    }


    public float getSpeed() {
        return 2f;
    }


    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (this.level.isClientSide) return;

        Entity hitEntity = pResult.getEntity();
        LivingEntity owner = (LivingEntity) this.getOwner();

        Vec3 center = hitEntity.position();

        applyAreaEffect(center, owner, 4.0F);

        discard();
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

            DamageSources.applyDamage(target, damage, HnSSpellRegistries.SHADOW_REAVER.get().getDamageSource(this, owner));

            target.addEffect(new MobEffectInstance(HLEffects.HEXED, 100, 0));
        }

        impactParticles(center.x, center.y, center.z);
    }

    protected void doImpactSound(Holder<SoundEvent> sound) {
        this.level.playSound((Player)null, this.getX(), this.getY(), this.getZ(), sound, SoundSource.NEUTRAL, 1.0F, 1F);

        if (this.getOwner() instanceof Player player) {
            player.playSound(sound.value(), 0.75F, 1.0F);
        }
    }


    protected void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        if (this.level.isClientSide) return;
        LivingEntity owner = (LivingEntity) this.getOwner();
        Vec3 hitPos = blockHitResult.getLocation();
        applyAreaEffect(hitPos, owner, 4.0f);
        discard();
    }

    public Optional<Holder<SoundEvent>> getImpactSound() {
            return Optional.of(HnSSounds.BRIMSTONE_HELLBLAST_IMPACT);
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