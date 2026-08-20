package net.hazen.hazennstuff.Item.Block.Starforge;

import net.hazen.hazennstuff.Registries.HnSRecipes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;

import java.util.List;

public record StarForgeRecipeJei(
        List<StarForgeRecipe.SizedInput> ingredients,
        ItemStack result,
        int smeltTime
) {

    public static List<StarForgeRecipeJei> getRecipes(Level level) {
        if (level == null) return List.of();

        return level.getRecipeManager()
                .getAllRecipesFor(HnSRecipes.STARFORGE_TYPE.get())
                .stream()
                .map(RecipeHolder::value)
                .map(recipe -> new StarForgeRecipeJei(
                        recipe.ingredients(),
                        recipe.result(),
                        recipe.smeltTime()))
                .toList();
    }
}
