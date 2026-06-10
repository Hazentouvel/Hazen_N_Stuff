package net.hazen.hazennstuff.Registries.Effects;

import io.redspace.ironsspellbooks.effect.ISyncedMobEffect;
import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

public class AwakenedEffect extends MagicMobEffect implements ISyncedMobEffect {
    public static final float JIMMY_PER_LEVEL = 0.15F;
    private int lastDuration = -1;

    public AwakenedEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    public boolean applyEffectTick(LivingEntity LivingEntityIn, int amplifier) {
        if (lastDuration == 1) {
            LivingEntityIn.addEffect(new MobEffectInstance(HnSEffects.REVIVE_COOLDOWN, 12000, 0,false,false,true));
        }
        return true;
    }



    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        lastDuration = duration;
        return duration > 0;
    }
}
