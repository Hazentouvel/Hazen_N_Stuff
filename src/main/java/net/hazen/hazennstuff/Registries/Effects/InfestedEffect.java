package net.hazen.hazennstuff.Registries.Effects;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.effect.ISyncedMobEffect;
import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import net.hazen.hazennstuff.Registries.HnSAttributeRegistry;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.hazen.hazennstuff.Registries.HnSParticleHelper;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.WeakHashMap;

public class InfestedEffect extends MagicMobEffect implements ISyncedMobEffect {

    public static final int STACKS_REQUIRED = 3;
    public static final int STACKS_REQUIRED_AMPLIFIER = STACKS_REQUIRED - 1;

    private static final Map<LivingEntity, Entity> EFFECT_CREDIT = new WeakHashMap<>();
    private static final Map<MobEffectInstance, Integer> DELAYED_INSTANCES = new WeakHashMap<>();

    public InfestedEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    public static MobEffectInstance addInfestedStack(LivingEntity entity, @Nullable Entity afflicter) {
        MobEffectInstance previous = entity.getEffect(HnSEffects.INFESTED);
        MobEffectInstance inst;
        if (previous != null) {
            inst = new MobEffectInstance(HnSEffects.INFESTED, 20 * 15, previous.getAmplifier() + 1, previous.isAmbient(), previous.isVisible(), previous.showIcon());
        } else {
            inst = new MobEffectInstance(HnSEffects.INFESTED, 20 * 15, 0, false, false, true);
        }
        if (afflicter != null) {
            EFFECT_CREDIT.put(entity, afflicter);
        }
        entity.addEffect(inst);
        return inst;
    }

    @Override
    public void clientTick(LivingEntity livingEntity, MobEffectInstance instance) {
        int amplifier = instance.getAmplifier();
        ParticleOptions particle = HnSParticleHelper.MUSHROOM_PARTICLE;
        if (amplifier >= 1) {
            particle = HnSParticleHelper.MUSHROOM_FOG;
        }
        var random = livingEntity.getRandom();
        for (int i = 0; i < 1; i++) {
            Vec3 motion = new Vec3(
                    random.nextFloat() * 2 - 1,
                    random.nextFloat() * 2 - 1,
                    random.nextFloat() * 2 - 1
            );
            motion = motion.scale(.04f);
            livingEntity.level().addParticle(particle, livingEntity.getRandomX(.4f), livingEntity.getRandomY(), livingEntity.getRandomZ(.4f), motion.x, motion.y, motion.z);
        }
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        var self = livingEntity.getEffect(HnSEffects.INFESTED);
        if (DELAYED_INSTANCES.containsKey(self) && !(DELAYED_INSTANCES.get(self) - duration > 4)) {
            return true;
        }

        float effectRadius = 6;
        var level = livingEntity.level();
        if (level.isClientSide) {
            return true;
        }

        @Nullable Entity attacker = EFFECT_CREDIT.remove(livingEntity);

        if (attacker == null || attacker != livingEntity) {
            livingEntity.addEffect(new MobEffectInstance(HnSEffects.SPORES, 100, 1));
        }

        var entities = level.getEntities(null, livingEntity.getBoundingBox().inflate(effectRadius));
        Vec3 losPoint = Utils.raycastForBlock(level, livingEntity.position(), livingEntity.position().add(0, 1, 0), ClipContext.Fluid.NONE).getLocation();

        for (Entity entity : entities) {
            if (entity instanceof LivingEntity livingVictim
                    && entity != livingEntity
                    && entity != attacker
                    && entity.canBeHitByProjectile()
                    && !DamageSources.isFriendlyFireBetween(attacker, entity)
                    && Utils.hasLineOfSight(level, losPoint, entity.getBoundingBox().getCenter(), true)) {

                livingVictim.addEffect(new MobEffectInstance(HnSEffects.SPORES, 100, 1));
            }
        }

        return false;
    }

    public static double damageFor(@Nullable Entity entity) {
        double baseDamage = 10.0;
        if (entity instanceof LivingEntity livingAttacker) {
            baseDamage = baseDamage * livingAttacker.getAttributeValue(AttributeRegistry.SPELL_POWER) * livingAttacker.getAttributeValue(HnSAttributeRegistry.RADIANCE_SPELL_POWER);
        }
        return baseDamage;
    }

    static int duration;

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        InfestedEffect.duration = duration;
        return amplifier >= STACKS_REQUIRED_AMPLIFIER;
    }
}