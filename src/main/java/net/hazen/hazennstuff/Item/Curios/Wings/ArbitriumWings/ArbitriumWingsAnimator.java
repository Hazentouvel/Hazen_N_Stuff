package net.hazen.hazennstuff.Item.Curios.Wings.ArbitriumWings;

import mod.azure.azurelib.common.animation.controller.AzAnimationController;
import mod.azure.azurelib.common.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.common.animation.easing.AzEasingTypeRegistry;
import mod.azure.azurelib.common.animation.impl.AzItemAnimator;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ArbitriumWingsAnimator extends AzItemAnimator {
    private static final ResourceLocation ANIMATIONS = ResourceLocation.fromNamespaceAndPath(
            HazenNStuff.MOD_ID,
            "animations/curios/arbitrium_wings.animation.json"
    );

    @Override
    public void registerControllers(AzAnimationControllerContainer<ItemStack> animationControllerContainer) {
        animationControllerContainer.add(
                AzAnimationController.builder(this, "base_controller")
                        .setEasingType(AzEasingTypeRegistry.getOrNull("linear"))
                        .setTransitionLength(6)
                        .build()
        );
    }



    @Override
    public @NotNull ResourceLocation getAnimationLocation(ItemStack animatable) {
        return ANIMATIONS;
    }
}