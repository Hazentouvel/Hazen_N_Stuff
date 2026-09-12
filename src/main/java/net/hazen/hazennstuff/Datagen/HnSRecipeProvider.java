package net.hazen.hazennstuff.Datagen;

import net.hazen.hazennstuff.Registries.HnSItemRegistry;
import net.hazen.hazentouvelib.Registries.HLItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import java.util.concurrent.CompletableFuture;

public class HnSRecipeProvider extends RecipeProvider {
    public HnSRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new HnSRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "TutorialMod Recipes";
        }
    }

    @Override
    protected void buildRecipes() {


        /*
        *** Armor
         */

        // Steel
        shaped(RecipeCategory.COMBAT, HnSItemRegistry.STEEL_HELMET.get())
                .pattern("SDS")
                .pattern("S S")
                .pattern("   ")
                .define('D', Items.DIAMOND_HELMET)
                .define('S', HLItemRegistry.STEEL_INGOT.get())
                .unlockedBy(getHasName(HLItemRegistry.STEEL_INGOT.get()), has(HLItemRegistry.STEEL_INGOT))
                .group("steel")
                .save(output);

        shaped(RecipeCategory.COMBAT, HnSItemRegistry.STEEL_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SDS")
                .pattern("SSS")
                .define('D', Items.DIAMOND_CHESTPLATE)
                .define('S', HLItemRegistry.STEEL_INGOT.get())
                .unlockedBy(getHasName(HLItemRegistry.STEEL_INGOT.get()), has(HLItemRegistry.STEEL_INGOT))
                .group("steel")
                .save(output);

        shaped(RecipeCategory.COMBAT, HnSItemRegistry.STEEL_LEGGINGS.get())
                .pattern("SSS")
                .pattern("SDS")
                .pattern("S S")
                .define('D', Items.DIAMOND_LEGGINGS)
                .define('S', HLItemRegistry.STEEL_INGOT.get())
                .unlockedBy(getHasName(HLItemRegistry.STEEL_INGOT.get()), has(HLItemRegistry.STEEL_INGOT))
                .group("steel")
                .save(output);

        shaped(RecipeCategory.COMBAT, HnSItemRegistry.STEEL_BOOTS.get())
                .pattern("   ")
                .pattern("S S")
                .pattern("SDS")
                .define('D', Items.DIAMOND_BOOTS)
                .define('S', HLItemRegistry.STEEL_INGOT.get())
                .unlockedBy(getHasName(HLItemRegistry.STEEL_INGOT.get()), has(HLItemRegistry.STEEL_INGOT))
                .group("steel")
                .save(output);

        // Stalwart
        shaped(RecipeCategory.COMBAT, HnSItemRegistry.STALWART_HELMET.get())
                .pattern("SDS")
                .pattern("S S")
                .pattern("   ")
                .define('D', HnSItemRegistry.STEEL_HELMET.get())
                .define('S', HLItemRegistry.STEEL_INGOT.get())
                .unlockedBy(getHasName(HLItemRegistry.STEEL_INGOT.get()), has(HLItemRegistry.STEEL_INGOT))
                .group("stalwart")
                .save(output);

        shaped(RecipeCategory.COMBAT, HnSItemRegistry.STALWART_CHESTPLATE.get())
                .pattern("S S")
                .pattern("SDS")
                .pattern("SSS")
                .define('D', HnSItemRegistry.STEEL_CHESTPLATE.get())
                .define('S', HLItemRegistry.STEEL_INGOT.get())
                .unlockedBy(getHasName(HLItemRegistry.STEEL_INGOT.get()), has(HLItemRegistry.STEEL_INGOT))
                .group("stalwart")
                .save(output);

    }


}