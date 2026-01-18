package net.hazen.hazennstuff.Datagen;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.hazen.hazennstuff.Blocks.HnSBlockRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.HnSItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class HnSRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public HnSRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        /*
        *** Materials and Blocks
         */

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSBlockRegistry.ZENALITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', HnSItemRegistry.ZENALITE_INGOT.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.CRUDE_METAL.get(), 2)
                .pattern("III")
                .pattern("CC ")
                .pattern("   ")
                .define('I', Items.IRON_INGOT)
                .define('C', Items.COAL)
                .unlockedBy(getHasName(Items.IRON_INGOT),
                        has(Items.IRON_INGOT)
                )
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HnSItemRegistry.ZENALITE_INGOT.get(), 9)
                .requires(HnSBlockRegistry.ZENALITE_BLOCK.get())
                .unlockedBy(getHasName(HnSBlockRegistry.ZENALITE_BLOCK.get()),
                        has(HnSBlockRegistry.ZENALITE_BLOCK.get())
                )
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HnSItemRegistry.STARKISSED_ZENALITE.get(), 4)
                .requires(HnSItemRegistry.RAW_ZENALITE.get())
                .requires(Items.NETHER_STAR)
                .unlockedBy(getHasName(HnSBlockRegistry.ZENALITE_BLOCK.get()),
                        has(HnSBlockRegistry.ZENALITE_BLOCK.get())
                )
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HnSItemRegistry.STEEL_NUGGET.get(), 9)
                .requires(HnSItemRegistry.STEEL_INGOT.get())
                .unlockedBy(getHasName(HnSItemRegistry.STEEL_INGOT.get()),
                        has(HnSItemRegistry.STEEL_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.STEEL_INGOT.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', HnSItemRegistry.STEEL_NUGGET.get())
                .unlockedBy(getHasName(HnSItemRegistry.STEEL_NUGGET.get()),
                        has(HnSItemRegistry.STEEL_NUGGET.get())
                )
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HnSItemRegistry.PYRIUM_NUGGET.get(), 9)
                .requires(ItemRegistry.PYRIUM_INGOT.get())
                .unlockedBy(getHasName(ItemRegistry.PYRIUM_INGOT.get()),
                        has(ItemRegistry.PYRIUM_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.PYRIUM_INGOT.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', HnSItemRegistry.PYRIUM_NUGGET.get())
                .unlockedBy(getHasName(HnSItemRegistry.PYRIUM_NUGGET.get()),
                        has(HnSItemRegistry.PYRIUM_NUGGET.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.DIVINE_MOLD.get(), 4)
                .pattern("ZDZ")
                .pattern("ZRZ")
                .pattern("SPS")
                .define('P', ItemRegistry.PYRIUM_INGOT.get())
                .define('Z', HnSItemRegistry.RAW_ZENALITE.get())
                .define('R', ItemRegistry.BLANK_RUNE.get())
                .define('S', ItemRegistry.DRAGONSKIN.get())
                .define('D', ItemRegistry.DIVINE_SOULSHARD.get())
                .unlockedBy(getHasName(ItemRegistry.DIVINE_SOULSHARD.get()),
                        has(ItemRegistry.DIVINE_SOULSHARD.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.DIVINE_MOLD.get(), 2)
                .pattern("DAD")
                .pattern("DMD")
                .pattern("DDD")
                .define('A', ItemRegistry.ARCANE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('D', Items.DIAMOND)
                .unlockedBy(getHasName(HnSItemRegistry.DIVINE_MOLD.get()),
                        has(HnSItemRegistry.DIVINE_MOLD.get())
                )
                .save(pWriter, "duplicate_divine_mold");

        /*
        *** Weapons
         */



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.FIREBLOSSOM_RAPIER.get(), 1)
                .pattern(" NB")
                .pattern("ZBF")
                .pattern("WZ ")
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('F', ItemRegistry.FIRE_RUNE.get())
                .define('N', ItemRegistry.NATURE_RUNE.get())
                .define('B', Items.BLAZE_ROD)
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.DRACONIC_SPLITTER.get(), 1)
                .pattern(" RI")
                .pattern("ZBR")
                .pattern("WZ ")
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .define('I', Items.BLAZE_ROD)
                .define('B', Items.NETHERITE_SWORD)
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.ICE_PIKE.get(), 1)
                .pattern(" RI")
                .pattern("ZBR")
                .pattern("WZ ")
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.ICE_RUNE.get())
                .define('I', ItemRegistry.ICE_VENOM_VIAL.get())
                .define('B', Items.NETHERITE_SWORD)
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.O_FORTUNA.get(), 1)
                .pattern(" RR")
                .pattern("ZBZ")
                .pattern("WZ ")
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.NATURE_RUNE.get())
                .define('B', Items.NETHERITE_AXE)
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.IONIC_SPLITTER.get(), 1)
                .pattern(" RI")
                .pattern("ZBR")
                .pattern("WZ ")
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.LIGHTNING_RUNE.get())
                .define('I', ItemRegistry.ENERGIZED_CORE.get())
                .define('B', Items.NETHERITE_SWORD)
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.UMBRANOVA.get(), 1)
                .pattern(" RI")
                .pattern("ZBR")
                .pattern("WZ ")
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.ENDER_RUNE.get())
                .define('I', ItemRegistry.DRAGONSKIN.get())
                .define('B', Items.NETHERITE_SWORD)
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.DEVASTATOR.get(), 1)
                .pattern(" RI")
                .pattern("ZBR")
                .pattern("WZ ")
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.BLOOD_RUNE.get())
                .define('I', ItemRegistry.BLOODY_VELLUM.get())
                .define('B', Items.NETHERITE_SWORD)
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.PROVOCATION.get(), 1)
                .pattern(" RI")
                .pattern("ZBR")
                .pattern("WZ ")
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.EVOCATION_RUNE.get())
                .define('I', HnSItemRegistry.STEEL_INGOT.get())
                .define('B', Items.NETHERITE_SWORD)
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.EXCALIBUR.get(), 1)
                .pattern(" RI")
                .pattern("ZBR")
                .pattern("WZ ")
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .define('I', ItemRegistry.DIVINE_PEARL.get())
                .define('B', Items.NETHERITE_SWORD)
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.THE_DEVOURER.get(), 1)
                .pattern(" RI")
                .pattern("ZBR")
                .pattern("WZ ")
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('R', HnSTags.Items.ELDRITCH_RUNE)
                .define('I', Items.ECHO_SHARD)
                .define('B', Items.NETHERITE_SWORD)
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.RAVENS_BANE.get(), 1)
                .pattern("ZFR")
                .pattern("ZBR")
                .pattern("WZ ")
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .define('F', Items.FEATHER)
                .define('B', ItemRegistry.HELLRAZOR.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        /*
        *** Armor Sets
         */

        /*
        *** Fires
         */

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.LEATHER),
                        Ingredient.of(HnSItemRegistry.BLAZEBORNE_HELMET.get()),
                        Ingredient.of(Items.BLAZE_POWDER),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.HAZEL_HELMET.get()
                )
                .unlocks(getHasName(HnSItemRegistry.BLAZEBORNE_HELMET.get()),
                        has(HnSItemRegistry.BLAZEBORNE_HELMET.get())
                )
                .save(pWriter, "hazel_helmet");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.LEATHER),
                        Ingredient.of(HnSItemRegistry.BLAZEBORNE_CHESTPLATE.get()),
                        Ingredient.of(Items.BLAZE_POWDER),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.HAZEL_CHESTPLATE.get()
                )
                .unlocks(getHasName(HnSItemRegistry.BLAZEBORNE_CHESTPLATE.get()),
                        has(HnSItemRegistry.BLAZEBORNE_CHESTPLATE.get())
                )
                .save(pWriter, "hazel_chestplate");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.LEATHER),
                        Ingredient.of(HnSItemRegistry.BLAZEBORNE_LEGGINGS.get()),
                        Ingredient.of(Items.BLAZE_POWDER),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.HAZEL_LEGGINGS.get()
                )
                .unlocks(getHasName(HnSItemRegistry.BLAZEBORNE_LEGGINGS.get()),
                        has(HnSItemRegistry.BLAZEBORNE_LEGGINGS.get())
                )
                .save(pWriter, "hazel_leggings");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.LEATHER),
                        Ingredient.of(HnSItemRegistry.BLAZEBORNE_BOOTS.get()),
                        Ingredient.of(Items.BLAZE_POWDER),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.HAZEL_BOOTS.get()
                )
                .unlocks(getHasName(HnSItemRegistry.BLAZEBORNE_BOOTS.get()),
                        has(HnSItemRegistry.BLAZEBORNE_BOOTS.get())
                )
                .save(pWriter, "hazel_boots");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.LEATHER),
                        Ingredient.of(HnSItemRegistry.HAZEL_CHESTPLATE.get()),
                        Ingredient.of(Items.MELON),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.BIG_HAZEL_CHESTPLATE.get()
                )
                .unlocks(getHasName(HnSItemRegistry.HAZEL_CHESTPLATE.get()),
                        has(HnSItemRegistry.HAZEL_CHESTPLATE.get())
                )
                .save(pWriter, "how_did_you_find_the_hazel_chestplate");



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.BLAZEBORNE_HELMET.get())
                .pattern("RZR")
                .pattern("ZSZ")
                .pattern(" M ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.PYROMANCER_HELMET.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.BLAZEBORNE_CHESTPLATE.get())
                .pattern("ZSZ")
                .pattern("RMR")
                .pattern("ZZZ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.PYROMANCER_CHESTPLATE.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.BLAZEBORNE_LEGGINGS.get())
                .pattern("RMR")
                .pattern("ZSZ")
                .pattern("Z Z")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.PYROMANCER_LEGGINGS.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.BLAZEBORNE_BOOTS.get())
                .pattern("RMR")
                .pattern("ZSZ")
                .pattern("   ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.PYROMANCER_BOOTS.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        /*
        *** Ice
         */

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.CRYOGENIC_RULER_HELMET.get())
                .pattern("RZR")
                .pattern("ZSZ")
                .pattern(" M ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.CRYOMANCER_HELMET.get())
                .define('R', ItemRegistry.ICE_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.CRYOGENIC_RULER_CHESTPLATE.get())
                .pattern("ZSZ")
                .pattern("RMR")
                .pattern("ZZZ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.CRYOMANCER_CHESTPLATE.get())
                .define('R', ItemRegistry.ICE_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.CRYOGENIC_RULER_LEGGINGS.get())
                .pattern("RMR")
                .pattern("ZSZ")
                .pattern("Z Z")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.CRYOMANCER_LEGGINGS.get())
                .define('R', ItemRegistry.ICE_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.CRYOGENIC_RULER_BOOTS.get())
                .pattern("RMR")
                .pattern("ZSZ")
                .pattern("   ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.CRYOMANCER_BOOTS.get())
                .define('R', ItemRegistry.ICE_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        /*
        *** Nature
         */

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItemRegistry.CREAKING_SORCERER_HELMET.get()),
                        Ingredient.of(HnSItemRegistry.BLAZEBORNE_HELMET.get()),
                        Ingredient.of(ItemRegistry.MANA_RUNE.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CROWN.get()
                )
                .unlocks(getHasName(HnSItemRegistry.CREAKING_SORCERER_HELMET.get()),
                        has(HnSItemRegistry.CREAKING_SORCERER_HELMET.get())
                )
                .save(pWriter, "fireblossom_battlemage_crown");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItemRegistry.CREAKING_SORCERER_HELMET.get()),
                        Ingredient.of(HnSItemRegistry.BLAZEBORNE_HELMET.get()),
                        Ingredient.of(ItemRegistry.PROTECTION_RUNE.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_HELMET.get()
                )
                .unlocks(getHasName(HnSItemRegistry.CREAKING_SORCERER_HELMET.get()),
                        has(HnSItemRegistry.CREAKING_SORCERER_HELMET.get())
                )
                .save(pWriter, "fireblossom_battlemage_helmet");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItemRegistry.CREAKING_SORCERER_CHESTPLATE.get()),
                        Ingredient.of(HnSItemRegistry.BLAZEBORNE_CHESTPLATE.get()),
                        Ingredient.of(ItemRegistry.BLANK_RUNE.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get()
                )
                .unlocks(getHasName(HnSItemRegistry.CREAKING_SORCERER_CHESTPLATE.get()),
                        has(HnSItemRegistry.CREAKING_SORCERER_CHESTPLATE.get())
                )
                .save(pWriter, "fireblossom_battlemage_chestplate");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItemRegistry.CREAKING_SORCERER_LEGGINGS.get()),
                        Ingredient.of(HnSItemRegistry.BLAZEBORNE_LEGGINGS.get()),
                        Ingredient.of(ItemRegistry.BLANK_RUNE.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get()
                )
                .unlocks(getHasName(HnSItemRegistry.CREAKING_SORCERER_LEGGINGS.get()),
                        has(HnSItemRegistry.CREAKING_SORCERER_LEGGINGS.get())
                )
                .save(pWriter, "hazefireblossom_battlemage_leggings");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItemRegistry.CREAKING_SORCERER_BOOTS.get()),
                        Ingredient.of(HnSItemRegistry.BLAZEBORNE_BOOTS.get()),
                        Ingredient.of(ItemRegistry.BLANK_RUNE.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get()
                )
                .unlocks(getHasName(HnSItemRegistry.CREAKING_SORCERER_BOOTS.get()),
                        has(HnSItemRegistry.CREAKING_SORCERER_BOOTS.get())
                )
                .save(pWriter, "fireblossom_battlemage_boots");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItemRegistry.CREAKING_SORCERER_HELMET.get()),
                        Ingredient.of(HnSItemRegistry.ALCHEMIST_SUPREME_HELMET.get()),
                        Ingredient.of(ItemRegistry.BLANK_RUNE.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.ATLAS_HELMET.get()
                )
                .unlocks(getHasName(HnSItemRegistry.CREAKING_SORCERER_HELMET.get()),
                        has(HnSItemRegistry.CREAKING_SORCERER_HELMET.get())
                )
                .save(pWriter, "atlas_helmet");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItemRegistry.CREAKING_SORCERER_CHESTPLATE.get()),
                        Ingredient.of(HnSItemRegistry.ALCHEMIST_SUPREME_CHESTPLATE.get()),
                        Ingredient.of(ItemRegistry.BLANK_RUNE.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.ATLAS_CHESTPLATE.get()
                )
                .unlocks(getHasName(HnSItemRegistry.CREAKING_SORCERER_CHESTPLATE.get()),
                        has(HnSItemRegistry.CREAKING_SORCERER_CHESTPLATE.get())
                )
                .save(pWriter, "atlas_chestplate");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItemRegistry.CREAKING_SORCERER_LEGGINGS.get()),
                        Ingredient.of(HnSItemRegistry.ALCHEMIST_SUPREME_LEGGINGS.get()),
                        Ingredient.of(ItemRegistry.BLANK_RUNE.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.ATLAS_LEGGINGS.get()
                )
                .unlocks(getHasName(HnSItemRegistry.CREAKING_SORCERER_LEGGINGS.get()),
                        has(HnSItemRegistry.CREAKING_SORCERER_LEGGINGS.get())
                )
                .save(pWriter, "atlas_leggings");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItemRegistry.CREAKING_SORCERER_BOOTS.get()),
                        Ingredient.of(HnSItemRegistry.ALCHEMIST_SUPREME_BOOTS.get()),
                        Ingredient.of(ItemRegistry.BLANK_RUNE.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.ATLAS_BOOTS.get()
                )
                .unlocks(getHasName(HnSItemRegistry.CREAKING_SORCERER_BOOTS.get()),
                        has(HnSItemRegistry.CREAKING_SORCERER_BOOTS.get())
                )
                .save(pWriter, "atlas_boots");


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.CREAKING_SORCERER_HELMET.get())
                .pattern("RZR")
                .pattern("ZSZ")
                .pattern(" M ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.PLAGUED_HELMET.get())
                .define('R', ItemRegistry.NATURE_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.CREAKING_SORCERER_CHESTPLATE.get())
                .pattern("ZSZ")
                .pattern("RMR")
                .pattern("ZZZ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.PLAGUED_CHESTPLATE.get())
                .define('R', ItemRegistry.NATURE_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.CREAKING_SORCERER_LEGGINGS.get())
                .pattern("RMR")
                .pattern("ZSZ")
                .pattern("Z Z")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.PLAGUED_LEGGINGS.get())
                .define('R', ItemRegistry.NATURE_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.CREAKING_SORCERER_BOOTS.get())
                .pattern("RMR")
                .pattern("ZSZ")
                .pattern("   ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.PLAGUED_BOOTS.get())
                .define('R', ItemRegistry.NATURE_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        /*
        *** Lightning
         */

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.THUNDER_PROWLER_HELMET.get())
                .pattern("RZR")
                .pattern("ZSZ")
                .pattern(" M ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.ELECTROMANCER_HELMET.get())
                .define('R', ItemRegistry.LIGHTNING_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.THUNDER_PROWLER_CHESTPLATE.get())
                .pattern("ZSZ")
                .pattern("RMR")
                .pattern("ZZZ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.ELECTROMANCER_CHESTPLATE.get())
                .define('R', ItemRegistry.LIGHTNING_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.THUNDER_PROWLER_LEGGINGS.get())
                .pattern("RMR")
                .pattern("ZSZ")
                .pattern("Z Z")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.ELECTROMANCER_LEGGINGS.get())
                .define('R', ItemRegistry.LIGHTNING_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.THUNDER_PROWLER_BOOTS.get())
                .pattern("RMR")
                .pattern("ZSZ")
                .pattern("   ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.ELECTROMANCER_BOOTS.get())
                .define('R', ItemRegistry.LIGHTNING_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        /*
        *** Ender
         */

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.ENDER_DRAGON_HELMET.get())
                .pattern("RZR")
                .pattern("ZSZ")
                .pattern(" M ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.SHADOWWALKER_HELMET.get())
                .define('R', ItemRegistry.ENDER_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.ENDER_DRAGON_CHESTPLATE.get())
                .pattern("ZSZ")
                .pattern("RMR")
                .pattern("ZZZ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.SHADOWWALKER_CHESTPLATE.get())
                .define('R', ItemRegistry.ENDER_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.ENDER_DRAGON_LEGGINGS.get())
                .pattern("RMR")
                .pattern("ZSZ")
                .pattern("Z Z")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.SHADOWWALKER_LEGGINGS.get())
                .define('R', ItemRegistry.ENDER_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.ENDER_DRAGON_BOOTS.get())
                .pattern("RMR")
                .pattern("ZSZ")
                .pattern("   ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.SHADOWWALKER_BOOTS.get())
                .define('R', ItemRegistry.ENDER_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        /*
        *** Blood
         */

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.FLESH_MASS_HELMET.get())
                .pattern("RZR")
                .pattern("ZSZ")
                .pattern(" M ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.CULTIST_HELMET.get())
                .define('R', ItemRegistry.BLOOD_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.FLESH_MASS_CHESTPLATE.get())
                .pattern("ZSZ")
                .pattern("RMR")
                .pattern("ZZZ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.CULTIST_CHESTPLATE.get())
                .define('R', ItemRegistry.BLOOD_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.FLESH_MASS_LEGGINGS.get())
                .pattern("RMR")
                .pattern("ZSZ")
                .pattern("Z Z")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.CULTIST_LEGGINGS.get())
                .define('R', ItemRegistry.BLOOD_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.FLESH_MASS_BOOTS.get())
                .pattern("RMR")
                .pattern("ZSZ")
                .pattern("   ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.CULTIST_BOOTS.get())
                .define('R', ItemRegistry.BLOOD_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        /*
        *** Evocation
         */

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.ALCHEMIST_SUPREME_HELMET.get())
                .pattern("RZR")
                .pattern("ZSZ")
                .pattern(" M ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.ARCHEVOKER_HELMET.get())
                .define('R', ItemRegistry.EVOCATION_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .pattern("ZSZ")
                .pattern("RMR")
                .pattern("ZZZ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.ARCHEVOKER_CHESTPLATE.get())
                .define('R', ItemRegistry.EVOCATION_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.ALCHEMIST_SUPREME_LEGGINGS.get())
                .pattern("RMR")
                .pattern("ZSZ")
                .pattern("Z Z")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.ARCHEVOKER_LEGGINGS.get())
                .define('R', ItemRegistry.EVOCATION_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.ALCHEMIST_SUPREME_BOOTS.get())
                .pattern("RMR")
                .pattern("ZSZ")
                .pattern("   ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.ARCHEVOKER_BOOTS.get())
                .define('R', ItemRegistry.EVOCATION_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        /*
        *** Holy
         */

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.SERAPH_HELMET.get())
                .pattern("RZR")
                .pattern("ZSZ")
                .pattern(" M ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.PRIEST_HELMET.get())
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.SERAPH_CHESTPLATE.get())
                .pattern("ZSZ")
                .pattern("RMR")
                .pattern("ZZZ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.PRIEST_CHESTPLATE.get())
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.SERAPH_LEGGINGS.get())
                .pattern("RMR")
                .pattern("ZSZ")
                .pattern("Z Z")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.PRIEST_LEGGINGS.get())
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.SERAPH_BOOTS.get())
                .pattern("RMR")
                .pattern("ZSZ")
                .pattern("   ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.PRIEST_BOOTS.get())
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        /*
        *** Eldritch
         */

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.INFESTATION_HELMET.get())
                .pattern("RZR")
                .pattern("ZSZ")
                .pattern(" M ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.NETHERITE_MAGE_HELMET.get())
                .define('R', HnSTags.Items.ELDRITCH_RUNE)
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.INFESTATION_CHESTPLATE.get())
                .pattern("ZSZ")
                .pattern("RMR")
                .pattern("ZZZ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.NETHERITE_MAGE_CHESTPLATE.get())
                .define('R', HnSTags.Items.ELDRITCH_RUNE)
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.INFESTATION_LEGGINGS.get())
                .pattern("RMR")
                .pattern("ZSZ")
                .pattern("Z Z")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.NETHERITE_MAGE_LEGGINGS.get())
                .define('R', HnSTags.Items.ELDRITCH_RUNE)
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItemRegistry.INFESTATION_BOOTS.get())
                .pattern("RMR")
                .pattern("ZSZ")
                .pattern("   ")
                .define('Z', HnSItemRegistry.ZENALITE_INGOT.get())
                .define('M', HnSItemRegistry.DIVINE_MOLD.get())
                .define('S', ItemRegistry.NETHERITE_MAGE_BOOTS.get())
                .define('R', HnSTags.Items.ELDRITCH_RUNE)
                .unlockedBy(getHasName(HnSItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        /*
        *** Misc
         */


        //Pyrium
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(Items.NETHERITE_HELMET),
                        Ingredient.of(ItemRegistry.PYRIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.PYRIUM_HELMET.get()
                )
                .unlocks(getHasName(ItemRegistry.PYRIUM_INGOT.get()),
                        has(ItemRegistry.PYRIUM_INGOT.get())
                )
                .save(pWriter, "pyrium_helmet");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(Items.NETHERITE_CHESTPLATE),
                        Ingredient.of(ItemRegistry.PYRIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.PYRIUM_CHESTPLATE.get()
                )
                .unlocks(getHasName(ItemRegistry.PYRIUM_INGOT.get()),
                        has(ItemRegistry.PYRIUM_INGOT.get())
                )
                .save(pWriter, "pyrium_chestplate");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(Items.NETHERITE_LEGGINGS),
                        Ingredient.of(ItemRegistry.PYRIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.PYRIUM_LEGGINGS.get()
                )
                .unlocks(getHasName(ItemRegistry.PYRIUM_INGOT.get()),
                        has(ItemRegistry.PYRIUM_INGOT.get())
                )
                .save(pWriter, "pyrium_leggings");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(Items.NETHERITE_BOOTS),
                        Ingredient.of(ItemRegistry.PYRIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.PYRIUM_BOOTS.get()
                )
                .unlocks(getHasName(ItemRegistry.PYRIUM_INGOT.get()),
                        has(ItemRegistry.PYRIUM_INGOT.get())
                )
                .save(pWriter, "pyrium_boots");


        //Pyrium Battlemage
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(ItemRegistry.NETHERITE_MAGE_HELMET.get()),
                        Ingredient.of(ItemRegistry.PYRIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.PYRIUM_BATTLEMAGE_HELMET.get()
                )
                .unlocks(getHasName(ItemRegistry.PYRIUM_INGOT.get()),
                        has(ItemRegistry.PYRIUM_INGOT.get())
                )
                .save(pWriter, "pyrium_battlemage_helmet");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(ItemRegistry.NETHERITE_MAGE_CHESTPLATE.get()),
                        Ingredient.of(ItemRegistry.PYRIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.PYRIUM_BATTLEMAGE_CHESTPLATE.get()
                )
                .unlocks(getHasName(ItemRegistry.PYRIUM_INGOT.get()),
                        has(ItemRegistry.PYRIUM_INGOT.get())
                )
                .save(pWriter, "pyrium_battlemage_chestplate");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(ItemRegistry.NETHERITE_MAGE_LEGGINGS.get()),
                        Ingredient.of(ItemRegistry.PYRIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.PYRIUM_BATTLEMAGE_LEGGINGS.get()
                )
                .unlocks(getHasName(ItemRegistry.PYRIUM_INGOT.get()),
                        has(ItemRegistry.PYRIUM_INGOT.get())
                )
                .save(pWriter, "pyrium_battlemage_leggings");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(ItemRegistry.NETHERITE_MAGE_BOOTS.get()),
                        Ingredient.of(ItemRegistry.PYRIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.PYRIUM_BATTLEMAGE_BOOTS.get()
                )
                .unlocks(getHasName(ItemRegistry.PYRIUM_INGOT.get()),
                        has(ItemRegistry.PYRIUM_INGOT.get())
                )
                .save(pWriter, "pyrium_battlemage_boots");

        //Mithril Battlemage
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.MANA_RUNE.get()),
                        Ingredient.of(ItemRegistry.NETHERITE_MAGE_HELMET.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.MITHRIL_BATTLEMAGE_HELMET.get()
                )
                .unlocks(getHasName(ItemRegistry.MITHRIL_INGOT.get()),
                        has(ItemRegistry.MITHRIL_INGOT.get())
                )
                .save(pWriter, "mithril_battlemage_helmet");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.MANA_RUNE.get()),
                        Ingredient.of(ItemRegistry.NETHERITE_MAGE_CHESTPLATE.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.MITHRIL_BATTLEMAGE_CHESTPLATE.get()
                )
                .unlocks(getHasName(ItemRegistry.MITHRIL_INGOT.get()),
                        has(ItemRegistry.MITHRIL_INGOT.get())
                )
                .save(pWriter, "mithril_battlemage_chestplate");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.MANA_RUNE.get()),
                        Ingredient.of(ItemRegistry.NETHERITE_MAGE_LEGGINGS.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.MITHRIL_BATTLEMAGE_LEGGINGS.get()
                )
                .unlocks(getHasName(ItemRegistry.MITHRIL_INGOT.get()),
                        has(ItemRegistry.MITHRIL_INGOT.get())
                )
                .save(pWriter, "mithril_battlemage_leggings");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.MANA_RUNE.get()),
                        Ingredient.of(ItemRegistry.NETHERITE_MAGE_BOOTS.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.MITHRIL_BATTLEMAGE_BOOTS.get()
                )
                .unlocks(getHasName(ItemRegistry.MITHRIL_INGOT.get()),
                        has(ItemRegistry.MITHRIL_INGOT.get())
                )
                .save(pWriter, "mithril_battlemage_boots");

        //Legionnaire Ruler
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItemRegistry.PYRIUM_NUGGET.get()),
                        Ingredient.of(HnSItemRegistry.PYRIUM_HELMET.get()),
                        Ingredient.of(ItemRegistry.MAGIC_CLOTH.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.LEGIONNAIRE_RULER_HELMET.get()
                )
                .unlocks(getHasName(HnSItemRegistry.PYRIUM_HELMET.get()),
                        has(HnSItemRegistry.PYRIUM_HELMET.get())
                )
                .save(pWriter, "legionnaire_ruler_helmet");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItemRegistry.PYRIUM_NUGGET.get()),
                        Ingredient.of(HnSItemRegistry.PYRIUM_CHESTPLATE.get()),
                        Ingredient.of(ItemRegistry.MAGIC_CLOTH.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.LEGIONNAIRE_RULER_CHESTPLATE.get()
                )
                .unlocks(getHasName(HnSItemRegistry.PYRIUM_CHESTPLATE.get()),
                        has(HnSItemRegistry.PYRIUM_CHESTPLATE.get())
                )
                .save(pWriter, "legionnaire_ruler_chestplate");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItemRegistry.PYRIUM_NUGGET.get()),
                        Ingredient.of(HnSItemRegistry.PYRIUM_LEGGINGS.get()),
                        Ingredient.of(ItemRegistry.MAGIC_CLOTH.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.LEGIONNAIRE_RULER_LEGGINGS.get()
                )
                .unlocks(getHasName(HnSItemRegistry.PYRIUM_LEGGINGS.get()),
                        has(HnSItemRegistry.PYRIUM_LEGGINGS.get())
                )
                .save(pWriter, "legionnaire_ruler_leggings");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItemRegistry.PYRIUM_NUGGET.get()),
                        Ingredient.of(HnSItemRegistry.PYRIUM_BOOTS.get()),
                        Ingredient.of(ItemRegistry.MAGIC_CLOTH.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.LEGIONNAIRE_RULER_BOOTS.get()
                )
                .unlocks(getHasName(HnSItemRegistry.PYRIUM_BOOTS.get()),
                        has(HnSItemRegistry.PYRIUM_BOOTS.get())
                )
                .save(pWriter, "legionnaire_ruler_boots");

        //Legionnaire Commander
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItemRegistry.PYRIUM_NUGGET.get()),
                        Ingredient.of(HnSItemRegistry.PYRIUM_HELMET.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.LEGIONNAIRE_COMMANDER_HELMET.get()
                )
                .unlocks(getHasName(HnSItemRegistry.PYRIUM_HELMET.get()),
                        has(HnSItemRegistry.PYRIUM_HELMET.get())
                )
                .save(pWriter, "legionnaire_commander_helmet");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItemRegistry.PYRIUM_NUGGET.get()),
                        Ingredient.of(HnSItemRegistry.PYRIUM_CHESTPLATE.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.LEGIONNAIRE_COMMANDER_CHESTPLATE.get()
                )
                .unlocks(getHasName(HnSItemRegistry.PYRIUM_CHESTPLATE.get()),
                        has(HnSItemRegistry.PYRIUM_CHESTPLATE.get())
                )
                .save(pWriter, "legionnaire_commander_chestplate");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItemRegistry.PYRIUM_NUGGET.get()),
                        Ingredient.of(HnSItemRegistry.PYRIUM_LEGGINGS.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.LEGIONNAIRE_COMMANDER_LEGGINGS.get()
                )
                .unlocks(getHasName(HnSItemRegistry.PYRIUM_LEGGINGS.get()),
                        has(HnSItemRegistry.PYRIUM_LEGGINGS.get())
                )
                .save(pWriter, "legionnaire_commander_leggings");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItemRegistry.PYRIUM_NUGGET.get()),
                        Ingredient.of(HnSItemRegistry.PYRIUM_BOOTS.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
                        RecipeCategory.COMBAT,
                        HnSItemRegistry.LEGIONNAIRE_COMMANDER_BOOTS.get()
                )
                .unlocks(getHasName(HnSItemRegistry.PYRIUM_BOOTS.get()),
                        has(HnSItemRegistry.PYRIUM_BOOTS.get())
                )
                .save(pWriter, "legionnaire_commander_boots");

    }



    public static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    public static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  HazenNStuff.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}