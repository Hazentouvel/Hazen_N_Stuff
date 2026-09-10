package net.hazen.hazennstuff.Entity.Spells.Lightning.CoruscatedDischarge;

import io.redspace.ironsspellbooks.api.entity.IMagicEntity;
import io.redspace.ironsspellbooks.api.events.CounterSpellEvent;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.capabilities.magic.RecastResult;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import io.redspace.ironsspellbooks.entity.mobs.AntiMagicSusceptible;
import io.redspace.ironsspellbooks.entity.mobs.IMagicSummon;
import io.redspace.ironsspellbooks.entity.spells.AbstractMagicProjectile;
import io.redspace.ironsspellbooks.particle.ZapParticleOption;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.acetheeldritchking.aces_spell_utils.utils.DomeHandler;
import net.acetheeldritchking.aces_spell_utils.utils.ImpactFrameHandler;
import net.acetheeldritchking.aces_spell_utils.vfx.dome.DomeConfig;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForge;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.Optional;

public class CoruscatedDischarge extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public static final int lifetime = 100;
    private int delay = 0;
    private int age = 0;
    private Vec3 spawnPos;
    private float spellRadius = 10.0F;

    public void setSpellRadius(float radius) {
        this.spellRadius = radius;
    }

    public void setSpawnPos(Vec3 pos) {
        this.spawnPos = pos;
        if (pos != null) {
            this.setPos(pos);
        }
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public CoruscatedDischarge(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setNoGravity(false);
    }

    public CoruscatedDischarge(Level level, LivingEntity shooter)
    {
        this(HnSEntityRegistry.CORUSCATED_DISCHARGE.get(), level);
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
        return Optional.of(HnSSounds.CORUSCATED_DISCHARGE_IMPACT);
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
        if (this.level.isClientSide) return;
        LivingEntity owner = (LivingEntity) this.getOwner();
        Vec3 hitPos = blockHitResult.getLocation();
        applyCounterspellArea(hitPos, owner, spellRadius);
        triggerImpactFrame();
        discard();
    }


    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        if (this.level.isClientSide) return;
        Entity target = entityHitResult.getEntity();
        LivingEntity owner = (LivingEntity) this.getOwner();
        Vec3 center = target.position();
        applyCounterspellArea(center, owner, spellRadius);
        triggerImpactFrame();
        discard();
    }

    private void triggerImpactFrame() {
        if (this.getOwner() instanceof ServerPlayer serverPlayer) {
            ImpactFrameHandler.trigger(serverPlayer, 0xFFFFFF, 0x000000, 0.90f, ImpactFrameHandler.DEFAULT_THRESHOLD, 10, 1, 0.1f
            );
        }
    }

    // Apply counterspell behavior in an area centered at `center` with given radius
    private void applyCounterspellArea(Vec3 center, LivingEntity owner, float radius) {
        List<LivingEntity> targets = this.level.getEntitiesOfClass(LivingEntity.class,
                AABB.ofSize(center, (double)radius * 2.0D, (double)radius * 2.0D, (double)radius * 2.0D));

        for (LivingEntity livingTarget : targets) {
            if (livingTarget == null || !livingTarget.isAlive()) continue;

            CounterSpellEvent event = new CounterSpellEvent(owner, livingTarget);
            NeoForge.EVENT_BUS.post(event);

            if (event.isCanceled()) continue;

            MagicData targetMagicData = MagicData.getPlayerMagicData(livingTarget);

            if (livingTarget instanceof AntiMagicSusceptible antiMagicTarget) {
                if (antiMagicTarget instanceof IMagicSummon summon) {
                    if (summon.getSummoner() == owner) {
                        if (summon instanceof Mob mob && mob.getTarget() == null) {
                            antiMagicTarget.onAntiMagic(targetMagicData);
                        }
                    } else {
                        antiMagicTarget.onAntiMagic(targetMagicData);
                    }
                } else {
                    antiMagicTarget.onAntiMagic(targetMagicData);
                }
            } else if (livingTarget instanceof ServerPlayer serverPlayer) {
                Utils.serverSideCancelCast(serverPlayer, true);
                MagicData.getPlayerMagicData(serverPlayer).getPlayerRecasts().removeAll(RecastResult.COUNTERSPELL);
            } else if (livingTarget instanceof IMagicEntity magicEntity) {
                magicEntity.cancelCast();
            }

            for (Holder<MobEffect> mobEffect : livingTarget.getActiveEffectsMap().keySet().stream().toList()) {
                if (mobEffect.value() instanceof MagicMobEffect) {
                    livingTarget.removeEffect(mobEffect);
                }
            }

            try {
                DamageSources.applyDamage(livingTarget, damage, HnSSpellRegistries.CORUSCATED_DISCHARGE.get().getDamageSource(this, owner));
            } catch (Exception ignored) {}

            if (!level.isClientSide && level instanceof ServerLevel serverLevel) {
                DomeHandler.trigger(
                        serverLevel,
                        this.position(),
                        DomeConfig.of(0x00e1ff, spellRadius/1.5f, 15)
                );
            }
        }
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

    public void setDamage(float damage) {
        this.damage = damage;
    }
}