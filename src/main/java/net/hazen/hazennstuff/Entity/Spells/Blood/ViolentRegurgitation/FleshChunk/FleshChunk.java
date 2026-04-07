package net.hazen.hazennstuff.Entity.Spells.Blood.ViolentRegurgitation.FleshChunk;

import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.hazen.hazennstuff.Entity.Spells.Blood.ViolentRegurgitation.FleshChunk.FleshMound.FleshMound;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FleshChunk extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    // store the spell level that spawned this chunk so created mounds can scale
    private int sourceSpellLevel = 1;
    HashMap<UUID, Integer> victims;

    public int shakeTime;
    protected boolean hasEmittedPoison;
    protected boolean inGround;
    protected float aoeDamage;

    public FleshChunk(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.victims = new HashMap<>();
    }

    public FleshChunk(Level level, LivingEntity shooter) {
        this(HnSEntityRegistry.FLESH_CHUNK.get(), level);
        setOwner(shooter);
    }

    public void impactParticles(double x, double y, double z) {
        MagicManager.spawnParticles(this.level, ParticleHelper.BLOOD, x, y, z, 15, 0.1, 0.1, 0.1, 0.18, true);
    }

    public float getSpeed() {
        return 2F;
    }

    protected void onHitEntity(EntityHitResult pResult) {
        if (this.level.isClientSide) return;

        Entity hitEntity = pResult.getEntity();
        LivingEntity owner = (LivingEntity) this.getOwner();

        Vec3 center = hitEntity.position();

        applyAreaEffect(center, owner, 3.0F);

        discard();
    }

    protected void onHitBlock(@NotNull BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);

        if (this.level.isClientSide) return;

        LivingEntity owner = (LivingEntity) this.getOwner();

        Vec3 center = blockHitResult.getLocation();

        applyAreaEffect(center, owner, 3.0F);

        if (!level.isClientSide && !hasEmittedPoison) {
            createFleshMound(blockHitResult.getLocation());
        }

        this.discard();
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

            DamageSources.applyDamage(target, damage, HnSSpellRegistries.VIOLENT_REGURGITATION.get().getDamageSource(this, owner));
        }

        impactParticles(center.x, center.y, center.z);
    }

    public void setAoeDamage(float damage) {
        this.aoeDamage = damage;
    }

    public float getAoeDamage() {
        return aoeDamage;
    }

    public void createFleshMound(Vec3 location) {
        if (!level.isClientSide) {
            FleshMound fleshMound = new FleshMound(level);
            fleshMound.setDuration(300);
            fleshMound.setSourceSpellLevel(this.sourceSpellLevel);
            fleshMound.moveTo(location);
            level.addFreshEntity(fleshMound);
            hasEmittedPoison = true;
        }
    }

    public void setSourceSpellLevel(int level) {
        this.sourceSpellLevel = Math.max(1, level);
    }

    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.of(HnSSounds.FLESH_IMPACT);
    }

    public void trailParticles() {
        for(int i = 0; i < 2; ++i) {
            double speed = 0.05;
            double dx = Utils.random.nextDouble() * (double)2.0F * speed - speed;
            double dy = Utils.random.nextDouble() * (double)2.0F * speed - speed;
            double dz = Utils.random.nextDouble() * (double)2.0F * speed - speed;
            this.level.addParticle(ParticleHelper.BLOOD, this.getX() + dx, this.getY() + dy, this.getZ() + dz, dx, dy, dz);
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