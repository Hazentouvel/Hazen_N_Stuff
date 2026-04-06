package net.hazen.hazennstuff.Entity.Spells.Hydro.Hydrobullet;

import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.util.Utils;
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
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.*;

public class HydroBullet extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    HashMap<UUID, Integer> victims;

    public HydroBullet(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.victims = new HashMap<>();
        this.setNoGravity(true);
    }

    public HydroBullet(Level level, LivingEntity shooter) {
        this(HnSEntityRegistry.HYDROBULLET.get(), level);
        setOwner(shooter);
    }

    public void trailParticles() {
    }

    public void impactParticles(double x, double y, double z) {
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

            DamageSources.applyDamage(target, damage, HnSSpellRegistries.HYDROBULLET.get().getDamageSource(this, owner));
        }

        impactParticles(center.x, center.y, center.z);
    }

    @Override
    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.of(HnSSounds.TERRARIA_IMPACT);
    }

    //ANIMATION
    private final RawAnimation idle = RawAnimation.begin().thenLoop("idle_2");

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