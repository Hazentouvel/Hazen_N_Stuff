package net.hazen.hazennstuff.item.weapons.hammer_of_justice;

import mod.azure.azurelib.rewrite.animation.controller.AzAnimationController;
import mod.azure.azurelib.rewrite.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.rewrite.animation.impl.AzItemAnimator;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class HammerOfJusticeAnimator extends AzItemAnimator {
    private static final ResourceLocation ANIMATIONS = ResourceLocation.fromNamespaceAndPath(
            HazenNStuff.MOD_ID,
            "animations/item/weapons/hammer_of_justice.animation.json"
    );

    @Override
    public void registerControllers(AzAnimationControllerContainer<ItemStack> animationControllerContainer) {
        animationControllerContainer.add(
                AzAnimationController.builder(this, "base_controller")
                        .build()
        );
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(ItemStack animatable) {
        return ANIMATIONS;
    }
}