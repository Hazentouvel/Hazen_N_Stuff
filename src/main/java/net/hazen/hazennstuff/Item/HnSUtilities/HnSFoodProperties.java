package net.hazen.hazennstuff.Item.HnSUtilities;

import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class HnSFoodProperties {
    public static final FoodProperties DIVINE_LEMON = new FoodProperties
            .Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 400),1f)
            .build();

    public static final FoodProperties LEMON = new FoodProperties
            .Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .build();

    public static final FoodProperties FRIED_ICE_SPIDER_EGG = new FoodProperties
            .Builder()
            .nutrition(8)
            .saturationModifier(4f)
            .effect(() -> new MobEffectInstance(MobEffectRegistry.FROSTBITTEN_STRIKES, 1200),1f)
            .build();

}
