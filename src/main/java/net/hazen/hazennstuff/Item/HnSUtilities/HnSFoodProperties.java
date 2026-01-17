package net.hazen.hazennstuff.Item.HnSUtilities;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class HnSFoodProperties {
    public static final FoodProperties DIVINE_LEMON = new FoodProperties
            .Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 400),1f).build();

    public static final FoodProperties LEMON = new FoodProperties
            .Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .build();



}
