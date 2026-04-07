package net.hazen.hazennstuff.Registries.Effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class GluttonousHungerEffect extends MobEffect {
    public GluttonousHungerEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }
    public static final float HEALTH_PER_LEVEL = 0.05f;
    public static final float HUNGER_STEAL_PER_LEVEL = 0.05f;

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.getHealth() < livingEntity.getMaxHealth()) {
            livingEntity.heal(1.5F);
        }

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        int i = 50 >> amplifier;
        return i > 0 ? duration % i == 0 : true;
    }
}
