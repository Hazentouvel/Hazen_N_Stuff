package net.hazen.hazennstuff.datagen;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.block.HnSBlocks;
import net.hazen.hazennstuff.registries.HnSItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class HnSRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public HnSRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

    //Items ----------------------------------------------------------------------------------------------------------------
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.SHADOW_UPGRADE_ORB.get(), 1)
//                .pattern("AAA")
//                .pattern("ADA")
//                .pattern("AAA")
//                .define('D', ItemRegistry.UPGRADE_ORB.get())
//                .define('A', HnSItems.SHADOW_SCALE.get())
//                .unlockedBy("has_shadow_scale", has(HnSItems.SHADOW_SCALE.get()))
//                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/upgrade_orb/shadow_upgrade_orb"));
//
        //Blocks ----------------------------------------------------------------------------------------------------------------


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HnSBlocks.WISEWOOD_BUTTON.get(), 18)
                .requires(HnSBlocks.WISEWOOD_PLANKS)
                .unlockedBy("has_wisewood_planks",
                        has(HnSBlocks.WISEWOOD_PLANKS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/blocks/wisewood_button")
                );


        stairBuilder(HnSBlocks.FROSTBITE_BIRCH_STAIRS.get(),
                Ingredient.of(HnSBlocks.FROSTBITE_BIRCH_PLANKS))
                .group("bismuth")
                .unlockedBy("has_bismuth",
                        has(HnSBlocks.FROSTBITE_BIRCH_PLANKS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/blocks/frostbite_birch_stairs")
                );

        slabBuilder(
                RecipeCategory.BUILDING_BLOCKS,
                HnSBlocks.FROSTBITE_BIRCH_SLAB.get(),
                Ingredient.of(HnSBlocks.FROSTBITE_BIRCH_PLANKS.get()))
                .group("frostbite_birch")
                .unlockedBy("has_frostbite_birch", has(HnSBlocks.FROSTBITE_BIRCH_PLANKS.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/blocks/frostbite_birch_slab")
                );

        buttonBuilder(HnSBlocks.FROSTBITE_BIRCH_BUTTON.get(),
                Ingredient.of(HnSBlocks.FROSTBITE_BIRCH_PLANKS.get()))
                .group("frostbite_birch")
                .unlockedBy("has_bismuth",
                        has(HnSBlocks.FROSTBITE_BIRCH_PLANKS.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/blocks/frostbite_birch_button")
                );

        pressurePlate(recipeOutput,
                HnSBlocks.FROSTBITE_BIRCH_PRESSURE_PLATE.get(),
                HnSBlocks.FROSTBITE_BIRCH_PLANKS.get()
        );

        fenceBuilder(HnSBlocks.FROSTBITE_BIRCH_FENCE.get(),
                Ingredient.of(HnSBlocks.FROSTBITE_BIRCH_PLANKS.get()))
                .group("bismuth")
                .unlockedBy("has_bismuth", has(HnSBlocks.FROSTBITE_BIRCH_PLANKS.get()))
                .save(recipeOutput);

        fenceGateBuilder(HnSBlocks.FROSTBITE_BIRCH_FENCE_GATE.get(),
                Ingredient.of(HnSBlocks.FROSTBITE_BIRCH_PLANKS.get()))
                .group("bismuth")
                .unlockedBy("has_bismuth",
                        has(HnSBlocks.FROSTBITE_BIRCH_PLANKS.get()))
                .save(recipeOutput);



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSBlocks.MOSSY_MUD_BRICKS.get(), 4)
                .pattern("AAA")
                .pattern("ADA")
                .pattern("AAA")
                .define('D', Items.MOSS_BLOCK)
                .define('A', Items.MUD_BRICKS)
                .unlockedBy("has_mud_bricks", has(Items.MUD_BRICKS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/blocks/mossy_mud_bricks"));


        stairBuilder(HnSBlocks.MOSSY_MUD_BRICK_STAIRS.get(),
                Ingredient.of(HnSBlocks.MOSSY_MUD_BRICKS))
                .group("mossy_mud_bricks")
                .unlockedBy("has_mossy_mud_bricks",
                        has(HnSBlocks.MOSSY_MUD_BRICKS))
                .save(recipeOutput);

        slabBuilder(
                RecipeCategory.BUILDING_BLOCKS,
                HnSBlocks.MOSSY_MUD_BRICK_SLAB.get(),
                Ingredient.of(HnSBlocks.MOSSY_MUD_BRICKS.get()))
                .group("mossy_mud_bricks")
                .unlockedBy("has_mossy_mud_bricks", has(HnSBlocks.MOSSY_MUD_BRICKS.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/blocks/mossy_mud_brick_slab")
                );

        wallBuilder(
                RecipeCategory.BUILDING_BLOCKS,
                HnSBlocks.MOSSY_MUD_BRICK_WALL.get(),
                Ingredient.of(HnSBlocks.MOSSY_MUD_BRICKS.get()))
                .group("mossy_mud_bricks")
                .unlockedBy("has_mossy_mud_bricks", has(HnSBlocks.MOSSY_MUD_BRICKS.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/blocks/mossy_mud_brick_wall")
                );



        stairBuilder(HnSBlocks.ZENALITE_BRICK_STAIRS.get(),
                Ingredient.of(HnSBlocks.ZENALITE_BRICKS))
                .group("bismuth")
                .unlockedBy("has_bismuth",
                        has(HnSBlocks.ZENALITE_BRICKS))
                .save(recipeOutput);

        slab(recipeOutput,
                RecipeCategory.BUILDING_BLOCKS,
                HnSBlocks.ZENALITE_BRICK_SLAB.get(),
                HnSBlocks.ZENALITE_BRICKS.get()
        );

        wall(recipeOutput, RecipeCategory
                        .BUILDING_BLOCKS,
                HnSBlocks.MOSSY_MUD_BRICK_WALL.get(),
                HnSBlocks.ZENALITE_BRICKS.get()
        );

//            ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.HnSBlocks.ZENALITE_BLOCK.get())
//                    .pattern("TTT")
//                    .pattern("TTT")
//                    .pattern("TTT")
//                    .define('T', HnSItems.ZENALITE_INGOT.get())
//                    .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
//                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/zenalite_ingot_block"));


        //Armor Upgrading  Recipes -----------------------------------------------------------------------------------------------------------------------------------+

        /*
        *** Fire
         */


        //Blazeborne Armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.BLAZEBORNE_HELMET.get())
                .pattern("RTR")
                .pattern("TPT")
                .pattern(" M ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.PYROMANCER_HELMET.get())
                    .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/blazeborne/blazeborne_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.BLAZEBORNE_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RMR")
                .pattern("TTT")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.PYROMANCER_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/blazeborne/blazeborne_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.BLAZEBORNE_LEGGINGS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.PYROMANCER_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/blazeborne/blazeborne_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.BLAZEBORNE_BOOTS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.PYROMANCER_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/blazeborne/blazeborne_boots"));


        /*
        *** Ice
         */


        //Cryogenic Ruler Armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.CRYOGENIC_RULER_HELMET.get())
                .pattern("RTR")
                .pattern("TPT")
                .pattern(" M ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.ICE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.CRYOMANCER_HELMET.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/cryogenic_ruler/cryogenic_ruler_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.CRYOGENIC_RULER_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RMR")
                .pattern("TTT")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.ICE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.CRYOMANCER_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/cryogenic_ruler/cryogenic_ruler_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.CRYOGENIC_RULER_LEGGINGS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.ICE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.CRYOMANCER_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/cryogenic_ruler/cryogenic_ruler_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.CRYOGENIC_RULER_BOOTS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.ICE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.CRYOMANCER_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/cryogenic_ruler/cryogenic_ruler_boots"));


        /*
        *** Lightning
         */


        // Thunder Prowler Armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.THUNDER_PROWLER_HELMET.get())
                .pattern("TPT")
                .pattern("RMR")
                .pattern("TTT")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.LIGHTNING_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.ELECTROMANCER_HELMET.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/thunder_prowler/thunder_prowler_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.THUNDER_PROWLER_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RMR")
                .pattern("TTT")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.LIGHTNING_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.ELECTROMANCER_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/thunder_prowler/thunder_prowler_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.THUNDER_PROWLER_LEGGINGS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.LIGHTNING_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.ELECTROMANCER_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/thunder_prowler/thunder_prowler_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.THUNDER_PROWLER_BOOTS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.LIGHTNING_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.ELECTROMANCER_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/thunder_prowler/thunder_prowler_boots"));


        /*
        *** Nature
         */


        // Sorcerer Armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.CREAKING_HELMET.get())
                .pattern("RTR")
                .pattern("TPT")
                .pattern(" M ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.NATURE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.PLAGUED_HELMET.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/creaking_sorcerer/creaking_sorcerer_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.CREAKING_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RMR")
                .pattern("TTT")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.NATURE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.PLAGUED_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/creaking_sorcerer/creaking_sorcerer_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.CREAKING_LEGGINGS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.NATURE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.PLAGUED_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/creaking_sorcerer/creaking_sorcerer_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.CREAKING_BOOTS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.NATURE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.PLAGUED_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/creaking_sorcerer/creaking_sorcerer_boots"));


        /*
        *** Blood
         */


        // Flesh Mass Armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.FLESH_MASS_HELMET.get())
                .pattern("RTR")
                .pattern("TPT")
                .pattern(" M ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.BLOOD_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.CULTIST_HELMET.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/flesh_mass/flesh_mass_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.FLESH_MASS_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RMR")
                .pattern("TTT")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.BLOOD_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.CULTIST_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/flesh_mass/flesh_mass_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.FLESH_MASS_LEGGINGS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.BLOOD_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.CULTIST_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/flesh_mass/flesh_mass_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.FLESH_MASS_BOOTS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.BLOOD_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.CULTIST_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/flesh_mass/flesh_mass_boots"));


        /*
        *** Ender
         */


        // Ender Dragon Armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.ENDER_DRAGON_HELMET.get())
                .pattern("RTR")
                .pattern("TPT")
                .pattern(" M ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.ENDER_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.SHADOWWALKER_HELMET.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/ender_dragon/ender_dragon_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.ENDER_DRAGON_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RMR")
                .pattern("TTT")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.ENDER_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.SHADOWWALKER_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/ender_dragon/ender_dragon_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.ENDER_DRAGON_LEGGINGS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.ENDER_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.SHADOWWALKER_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/ender_dragon/ender_dragon_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.ENDER_DRAGON_BOOTS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.ENDER_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.SHADOWWALKER_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/ender_dragon/ender_dragon_boots"));


        /*
         *** Holy
         */


        // Seraph Armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.SERAPH_HELMET.get())
                .pattern("RTR")
                .pattern("TPT")
                .pattern(" M ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.PRIEST_HELMET.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/seraph/seraph_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.SERAPH_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RMR")
                .pattern("TTT")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.PRIEST_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/seraph/seraph_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.SERAPH_LEGGINGS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.PRIEST_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/seraph/seraph_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.SERAPH_BOOTS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.PRIEST_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/seraph/seraph_boots"));


        // Gabriel ULTRAKILL Armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.GABRIEL_ULTRAKILL_HELMET.get())
                .pattern("RTR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', Items.GOLD_INGOT)
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .define('P', HnSItems.SERAPH_HELMET.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/gabriel_ultrakill/gabriel_ultrakill_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RER")
                .pattern("TTT")
                .define('T', Items.GOLD_INGOT)
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .define('E', Items.ELYTRA)
                .define('P', HnSItems.SERAPH_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/gabriel_ultrakill/gabriel_ultrakill_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.GABRIEL_ULTRAKILL_LEGGINGS.get())
                .pattern("RTR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', Items.GOLD_INGOT)
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .define('P', HnSItems.SERAPH_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/gabriel_ultrakill/gabriel_ultrakill_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.GABRIEL_ULTRAKILL_BOOTS.get())
                .pattern("RTR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', Items.GOLD_INGOT)
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .define('P', HnSItems.SERAPH_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/gabriel_ultrakill/gabriel_ultrakill_boots"));


        /*
        *** Evocation
         */


        // Alchemist Supreme Armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.ALCHEMIST_SUPREME_HELMET.get())
                .pattern("RTR")
                .pattern("TPT")
                .pattern(" M ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.EVOCATION_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.ARCHEVOKER_HELMET.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/alchemist_supreme/alchemist_supreme_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RMR")
                .pattern("TTT")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.EVOCATION_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.ARCHEVOKER_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/alchemist_supreme/alchemist_supreme_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.ALCHEMIST_SUPREME_LEGGINGS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.EVOCATION_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.ARCHEVOKER_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/alchemist_supreme/alchemist_supreme_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.ALCHEMIST_SUPREME_BOOTS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.EVOCATION_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.ARCHEVOKER_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/alchemist_supreme/alchemist_supreme_boots"));


        /*
        *** Radiance
         */


        /*
        *** Shadow
         */


        /*
        *** Eldritch
         */


        /*
        *** Tyros
         */


        // Tyros Armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.TYROS_HELMET.get())
                .pattern("RTR")
                .pattern("TPT")
                .pattern(" M ")
                .define('T', HnSItems.CLOTH_OF_THE_FLAMEBEARER.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .define('M', HnSItems.FLAMING_TEMPLATE.get())
                .define('P', HnSItems.BLAZEBORNE_HELMET.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/tyros/tyros_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.TYROS_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RMR")
                .pattern("TTT")
                .define('T', HnSItems.CLOTH_OF_THE_FLAMEBEARER.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .define('M', HnSItems.FLAMING_TEMPLATE.get())
                .define('P', HnSItems.BLAZEBORNE_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/tyros/tyros_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.TYROS_LEGGINGS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', HnSItems.CLOTH_OF_THE_FLAMEBEARER.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .define('M', HnSItems.FLAMING_TEMPLATE.get())
                .define('P', HnSItems.BLAZEBORNE_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/tyros/tyros_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.TYROS_BOOTS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.CLOTH_OF_THE_FLAMEBEARER.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .define('M', HnSItems.FLAMING_TEMPLATE.get())
                .define('P', HnSItems.BLAZEBORNE_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/crafting/armor/tyros/tyros_boots"));




        // Armor Upgrading (Smithing Table)



        //Soul Flame Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.FLAMING_TEMPLATE.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_HELMET.get()),
                        Ingredient.of(Items.SOUL_SAND),
                        RecipeCategory.COMBAT,
                        HnSItems.SOUL_FLAME_HELMET.get())
                .unlocks("has_flaming_template", has(HnSItems.FLAMING_TEMPLATE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/smithing/armor/soul_flame/soul_flame_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.FLAMING_TEMPLATE.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_CHESTPLATE.get()),
                        Ingredient.of(Items.SOUL_SAND),
                        RecipeCategory.COMBAT,
                        HnSItems.SOUL_FLAME_CHESTPLATE.get())
                .unlocks("has_flaming_template", has(HnSItems.FLAMING_TEMPLATE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/smithing/armor/soul_flame/soul_flame_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.FLAMING_TEMPLATE.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_LEGGINGS.get()),
                        Ingredient.of(Items.SOUL_SAND),
                        RecipeCategory.COMBAT,
                        HnSItems.SOUL_FLAME_LEGGINGS.get())
                .unlocks("has_flaming_template", has(HnSItems.FLAMING_TEMPLATE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/smithing/armor/soul_flame/soul_flame_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.FLAMING_TEMPLATE.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_BOOTS.get()),
                        Ingredient.of(Items.SOUL_SAND),
                        RecipeCategory.COMBAT,
                        HnSItems.SOUL_FLAME_BOOTS.get())
                .unlocks("has_flaming_template", has(HnSItems.FLAMING_TEMPLATE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/smithing/armor/soul_flame/soul_flame_boots"));



        //Fireblossom Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.FLAMING_TEMPLATE.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_HELMET.get()),
                        Ingredient.of(HnSBlocks.FIREBLOSSOM.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .unlocks("has_flaming_template", has(HnSItems.FLAMING_TEMPLATE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/smithing/armor/fireblossom_battlemage/fireblossom_battlemage_crown"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.FLAMING_TEMPLATE.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_CHESTPLATE.get()),
                        Ingredient.of(HnSBlocks.FIREBLOSSOM.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .unlocks("has_flaming_template", has(HnSItems.FLAMING_TEMPLATE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/smithing/armor/fireblossom_battlemage/fireblossom_battlemage_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.FLAMING_TEMPLATE.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_LEGGINGS.get()),
                        Ingredient.of(HnSBlocks.FIREBLOSSOM.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .unlocks("has_flaming_template", has(HnSItems.FLAMING_TEMPLATE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/smithing/armor/fireblossom_battlemage/fireblossom_battlemage_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.FLAMING_TEMPLATE.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_BOOTS.get()),
                        Ingredient.of(HnSBlocks.FIREBLOSSOM.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())
                .unlocks("has_flaming_template", has(HnSItems.FLAMING_TEMPLATE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/smithing/armor/fireblossom_battlemage/fireblossom_battlemage_boots"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.FLAMING_TEMPLATE.get()),
                        Ingredient.of(HnSItems.FIREBLOSSOM_BATTLEMAGE_CROWN.get()),
                        Ingredient.of(Items.GOLD_INGOT),
                        RecipeCategory.COMBAT,
                        HnSItems.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .unlocks("has_flaming_template", has(HnSItems.FLAMING_TEMPLATE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/smithing/armor/fireblossom_battlemage/convert_fireblossom_battlemage_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.FLAMING_TEMPLATE.get()),
                        Ingredient.of(HnSItems.FIREBLOSSOM_BATTLEMAGE_HELMET.get()),
                        Ingredient.of(HnSBlocks.FIREBLOSSOM.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .unlocks("has_flaming_template", has(HnSItems.FLAMING_TEMPLATE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/smithing/armor/fireblossom_battlemage/convert_fireblossom_battlemage_crown"));



        //Calamitas Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_HELMET.get()),
                        Ingredient.of(HnSItems.FLESH_MASS_HELMET.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.CALAMITAS_HELMET.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/smithing/armor/calamitas/calamitas_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_CHESTPLATE.get()),
                        Ingredient.of(HnSItems.FLESH_MASS_CHESTPLATE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.CALAMITAS_CHESTPLATE.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/smithing/armor/calamitas/calamitas_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_LEGGINGS.get()),
                        Ingredient.of(HnSItems.FLESH_MASS_LEGGINGS.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.CALAMITAS_LEGGINGS.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/smithing/armor/calamitas/calamitas_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_BOOTS.get()),
                        Ingredient.of(HnSItems.FLESH_MASS_BOOTS.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.CALAMITAS_BOOTS.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "recipe/smithing/armor/calamitas/calamitas_boots"));




        //Shapeless recipes -------------------------------------------------------------------------------------------------------------------------------------------+

//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HnSItems.ZENALITE_INGOT.get(), 9)
//                .requires(HnSItems.HnSBlocks.ZENALITE_BLOCK)
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