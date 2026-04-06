package net.hazen.hazennstuff.Entity.Spells.Cosmic.Evercomet;

import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.damage.ISSDamageTypes;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;
import net.minecraft.world.damagesource.DamageSource;

import java.util.Optional;

public class Evercomet extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public Evercomet(EntityType<? extends Evercomet> entityType, Level level) {
        super(entityType, level);
        this.setNoGravity(true);
    }

    public Evercomet(EntityType<? extends Evercomet> entityType, Level levelIn, LivingEntity shooter) {
        this(entityType, levelIn);
        this.setOwner(shooter);
    }

    public Evercomet(Level levelIn, LivingEntity shooter) {
        this (HnSEntityRegistry.EVERCOMET.get(), levelIn, shooter);
    }

    public void shoot(Vec3 rotation, float inaccuracy) {
        double speed = rotation.length();
        Vec3 offset = Utils.getRandomVec3((double)1.0F).normalize().scale((double)inaccuracy);
        Vec3 motion = rotation.normalize().add(offset).normalize().scale(speed);
        super.shoot(motion);
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
            this.level.addParticle(ParticleHelper.SNOW_DUST, x, y, z, jitter.x, jitter.y, jitter.z);
        }

    }

    public void impactParticles(double x, double y, double z) {
        MagicManager.spawnParticles(this.level(), ParticleHelper.SNOWFLAKE, x, y, z, 25, 0.0F, 0.0F, 0.0F, 0.18, true);
    }

    public float getSpeed() {
        return 2.5F;
    }

    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.of(HnSSounds.EVERCOMET_IMPACT);
    }

    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        // Dual School Damage
        var target = entityHitResult.getEntity();
        float totalDamage = this.damage;
        float half = totalDamage / 2.0F;

        // Apply shadow damage
        DamageSource shadowSource = new DamageSource(DamageSources.getHolderFromResource(target, ISSDamageTypes.ICE_MAGIC));
        DamageSources.applyDamage(target, half, shadowSource);

        // Apply Applies spell damage
        DamageSources.applyDamage(target, totalDamage - half, (HnSSpellRegistries.EVERCOMET_BARRAGE.get()).getDamageSource(this, this.getOwner()));

        this.discard();
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

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    private float damage = 2.0f; // Default value

    public void setDamage(float damage) {
        this.damage = damage;
    }
}
