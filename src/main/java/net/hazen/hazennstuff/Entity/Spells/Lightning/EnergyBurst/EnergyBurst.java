package net.hazen.hazennstuff.Entity.Spells.Lightning.EnergyBurst;

import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.particle.ZapParticleOption;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Optional;

public class EnergyBurst extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private int delay = 0;
    private int age = 0;
    private Vec3 spawnPos;

    public void setSpawnPos(Vec3 pos) {
        this.spawnPos = pos;
        if (pos != null) {
            this.setPos(pos);
        }
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public EnergyBurst(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setNoGravity(true);
    }

    public EnergyBurst(Level level, LivingEntity shooter)
    {
        this(HnSEntityRegistry.ENERGY_BURST.get(), level);
        setOwner(shooter);
    }


    @Override
    public void tick() {
        this.age++;

        if (this.age < this.delay) {
            if (this.spawnPos != null) {
                setPos(this.spawnPos);
            }

            if (level.isClientSide) {
                level.addParticle(ParticleHelper.ELECTRIC_SPARKS,
                        getX(), getY() + getBbHeight() * 0.5, getZ(),
                        (random.nextDouble() - 0.5) * 0.1,
                        (random.nextDouble() - 0.5) * 0.1,
                        (random.nextDouble() - 0.5) * 0.1);
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

    @Override
    protected void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        discard();
    }


    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        DamageSources.applyDamage(
                    entityHitResult.getEntity(),
                    damage,
                    HnSSpellRegistries.ENERGY_BURST.get().getDamageSource(this, getOwner())
        );
        discard();
    }

    //ANIMATION
    private final RawAnimation idle = RawAnimation.begin().thenLoop("animation.spark.idle");

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

    private float damage = 2.0f; // Default value

    public void setDamage(float damage) {
        this.damage = damage;
    }
}