package net.hazen.hazennstuff.datagen;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.registries.HnSItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SmithingTransformRecipe;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

    //Items ----------------------------------------------------------------------------------------------------------------
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.SHADOW_UPGRADE_ORB.get(), 2)
                .pattern("AAA")
                .pattern("ADA")
                .pattern("AAA")
                .define('D', ItemRegistry.UPGRADE_ORB.get())
                .define('A', HnSItems.DEUS_ESSENCE.get())
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/shadow_upgrade_orb"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.RADIANCE_UPGRADE_ORB.get(), 2)
                .pattern("AAA")
                .pattern("ADA")
                .pattern("AAA")
                .define('D', ItemRegistry.UPGRADE_ORB.get())
                .define('A', HnSItems.DIVINE_MOLD.get())
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/radiance_upgrade_orb"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.ARCHERY_UPGRADE_ORB.get(), 2)
                .pattern("AAA")
                .pattern("ADA")
                .pattern("AAA")
                .define('D', ItemRegistry.UPGRADE_ORB.get())
                .define('A', HnSItems.ZENALITE_INGOT.get())
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/archery_upgrade_orb"));


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.MELEE_UPGRADE_ORB.get(), 2)
                .pattern("AAA")
                .pattern("ADA")
                .pattern("AAA")
                .define('D', ItemRegistry.UPGRADE_ORB.get())
                .define('A', HnSItems.DIVINE_GREATSWORD.get())
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/melee_upgrade_orb"));


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.HEALTH_UPGRADE_ORB.get(), 2)
                .pattern("AAA")
                .pattern("ADA")
                .pattern("AAA")
                .define('D', ItemRegistry.UPGRADE_ORB.get())
                .define('A', HnSItems.ZENALITE_INGOT.get())
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/melee_upgrade_orb"));

        //Blocks ----------------------------------------------------------------------------------------------------------------

            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.HnSBlocks.ZENALITE_BLOCK.get())
                    .pattern("TTT")
                    .pattern("TTT")
                    .pattern("TTT")
                    .define('T', HnSItems.ZENALITE_INGOT.get())
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/tungsten_block"));

        //Holy Priest Armor
//        SmithingTransformRecipeBuilder.smithing(Ingredient.of(HnSItems.RUNESTONE_FRAGMENTS.get()),
//                Ingredient.of(ItemRegistry.WIZARD_HELMET.get()),
//                Ingredient.of(HnSItems.CHARRED_BONES),
//                RecipeCategory.COMBAT,
//                HnSItems.SHADOW_SCALE_HELMET.get())
//                .save(recipeOutput, "empty_priest_headpiece");
//
//        SmithingTransformRecipeBuilder.smithing(Ingredient.of(HnSItems.RUNESTONE_FRAGMENTS.get()),
//                Ingredient.of(ItemRegistry.WIZARD_LEGGINGS.get()),
//                Ingredient.of(HnSItems.CHARRED_BONES),
//                RecipeCategory.COMBAT,
//                HnSItems.SHADOW_SCALE_CHESTPLATE.get())
//                .save(recipeOutput, "empty_priest_skirt");
//
//        SmithingTransformRecipeBuilder.smithing(Ingredient.of(HnSItems.RUNESTONE_FRAGMENTS.get()),
//                Ingredient.of(ItemRegistry.WIZARD_LEGGINGS.get()),
//                Ingredient.of(HnSItems.CHARRED_BONES),
//                RecipeCategory.COMBAT,
//                HnSItems.SHADOW_SCALE_LEGGINGS.get())
//                .save(recipeOutput, "empty_priest_skirt");
//
//        SmithingTransformRecipeBuilder.smithing(Ingredient.of(HnSItems.RUNESTONE_FRAGMENTS.get()),
//                Ingredient.of(ItemRegistry.WIZARD_BOOTS.get()),
//                Ingredient.of(HnSItems.CHARRED_BONES),
//                RecipeCategory.COMBAT,
//                HnSItems.SHADOW_SCALE_BOOTS.get())
//                .save(recipeOutput, "empty_priest_boots");


        //Shapeless recipes -------------------------------------------------------------------------------------------------------------------------------------------+

//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HnSItems.ZENALITE_INGOT.get(), 9)
//                .requires(HnSItems.HnSBlocks.TUNGSTENBLOCK)
//                .unlockedBy("has_tungsten_block",
//                has(HnSItems.HnSBlocks.TUNGSTENBLOCK))

        //Smelting Recipes -----------------------------------------------------------------------------------------------------------------------------------------------

//        List<ItemLike> TUNGSTEN_SMELTABLES = List.of(HnSItems.RAW_ZENALITE, HnSItems.HnSBlocks.ZENALITE_STONE_ORE, HnSItems.HnSBlocks.ZENALITE_DEEPSLATE_ORE);
//
//        oreSmelting(recipeOutput,
//                TUNGSTEN_SMELTABLES,
//                RecipeCategory.MISC,
//                HnSItems.ZENALITE_INGOT.get(),
//                0.25f,
//                200,
//                "tungsten_ingot");
//
//        oreBlasting(recipeOutput,
//                TUNGSTEN_SMELTABLES,
//                RecipeCategory.MISC,
//                HnSItems.ZENALITE_INGOT.get(),
//                0.25f,
//                100,
//                "tungsten_ingot");

    }
}