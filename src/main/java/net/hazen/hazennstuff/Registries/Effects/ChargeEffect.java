package net.hazen.hazennstuff.Registries.Effects;

import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.fml.common.EventBusSubscriber;
import org.jetbrains.annotations.Nullable;

public class ChargeEffect extends MagicMobEffect {

    public ChargeEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    public static MobEffectInstance addChargeStack(LivingEntity entity, @Nullable Entity afflicter) {
        MobEffectInstance previous = entity.getEffect(HnSEffects.CHARGED_STATE);
        MobEffectInstance inst;
        final int MAX_STACKS = 5;
        final int MAX_AMPLIFIER = MAX_STACKS - 1;
        if (previous != null) {
            int prevAmp = previous.getAmplifier();
            if (prevAmp >= MAX_AMPLIFIER) {
                inst = new MobEffectInstance(HnSEffects.CHARGED_STATE, 100, prevAmp, previous.isAmbient(), previous.isVisible(), previous.showIcon());
            } else {
                inst = new MobEffectInstance(HnSEffects.CHARGED_STATE, 100, prevAmp + 1, previous.isAmbient(), previous.isVisible(), previous.showIcon());
            }
        } else {
            inst = new MobEffectInstance(HnSEffects.CHARGED_STATE, 100, 0, false, false, true);
        }

        entity.addEffect(inst);
        return inst;
    }

    public static float getReductionAmount(int level) {
        return 0.1F + 0.05F * (float)level;
    }
}