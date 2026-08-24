package net.hazen.hazennstuff.Compat.Jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Item.Block.HnSBlocks;
import net.hazen.hazennstuff.Item.Block.Starforge.StarForgeRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@JeiPlugin
public class HnSJeiPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                new StarForgeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(
                StarForgeRecipeCategory.RECIPE_TYPE,
                StarForgeRecipeJei.getRecipes(Minecraft.getInstance().level));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(
                new ItemStack(HnSBlocks.STARFORGE.get()),
                StarForgeRecipeCategory.RECIPE_TYPE);
    }
}
