package net.hazen.hazennstuff.Entity.Spells.Nature.SpiderLily;

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
import io.redspace.ironsspellbooks.entity.spells.poison_cloud.PoisonCloud;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Registries.HnSParticleHelper;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForge;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Optional;

public class SpiderLily extends AbstractMagicProjectile implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public SpiderLily(EntityType<? extends Projectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setNoGravity(true);
    }

    public SpiderLily(Level level, LivingEntity shooter) {
        this(HnSEntityRegistry.SPIDER_LILY.get(), level);
        setOwner(shooter);
    }

    @Override
    public void trailParticles() {
        Vec3 pos = this.getBoundingBox().getCenter().add(getDeltaMovement());
        Vec3 random = Utils.getRandomVec3(0);
        pos = pos.add(getDeltaMovement());
        level.addParticle(HnSParticleHelper.LEAF_PARTICLE, pos.x, pos.y, pos.z, random.x, random.y, random.z);
    }

    @Override
    public void impactParticles(double x, double y, double z) {
        MagicManager.spawnParticles(level, HnSParticleHelper.LEAF_PARTICLE, x, y, z, 12, .08, .08, .08, 0.3, false);
    }

    @Override
    public float getSpeed() {
        return 1.2f;
    }

    @Override
    public Optional<Holder<SoundEvent>> getImpactSound() {
        return Optional.of(SoundRegistry.ACID_ORB_IMPACT);
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);

        if (this.level.isClientSide) return;

        Entity target = entityHitResult.getEntity();
        LivingEntity owner = (LivingEntity) this.getOwner();

        CounterSpellEvent event = new CounterSpellEvent(owner, target);
        NeoForge.EVENT_BUS.post(event);

        if (!event.isCanceled()) {
            if (target instanceof LivingEntity livingTarget) {
                MagicData targetMagicData = MagicData.getPlayerMagicData(livingTarget);

                if (target instanceof AntiMagicSusceptible antiMagicTarget) {
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
                } else if (target instanceof ServerPlayer serverPlayer) {
                    Utils.serverSideCancelCast(serverPlayer, true);
                    MagicData.getPlayerMagicData(serverPlayer).getPlayerRecasts().removeAll(RecastResult.COUNTERSPELL);
                } else if (target instanceof IMagicEntity magicEntity) {
                    magicEntity.cancelCast();
                }

                for (Holder<MobEffect> mobEffect : livingTarget.getActiveEffectsMap().keySet().stream().toList()) {
                    if (mobEffect.value() instanceof MagicMobEffect) {
                        livingTarget.removeEffect(mobEffect);
                    }
                }

                try {
                    DamageSources.applyDamage(
                            target,
                            getDamage(),
                            HnSSpellRegistries.COUNTERSPELL_SPIDER_LILY.get().getDamageSource(this, owner)
                    );
                } catch (Exception ignored) {}

                if (target.getType() != EntityType.ENDERMAN && !hasEmittedPoison) {
                    createPoisonCloud(target.position());
                }
            }
        }

        discard();
    }



    protected boolean hasEmittedPoison = false;

    public void createPoisonCloud(Vec3 location) {
        if (!this.level.isClientSide && !hasEmittedPoison) {
            PoisonCloud cloud = new PoisonCloud(this.level);
            cloud.setOwner(this.getOwner());
            cloud.setDuration(200);
            cloud.setDamage(getDamage());
            cloud.moveTo(location);
            this.level.addFreshEntity(cloud);
            hasEmittedPoison = true;
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);

        if (!this.level.isClientSide && !hasEmittedPoison) {
            createPoisonCloud(blockHitResult.getLocation());
        }

        this.discard();
    }

    //ANIMATION
    private final RawAnimation idle = RawAnimation.begin().thenLoop("animation.spider_lily.idle");

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