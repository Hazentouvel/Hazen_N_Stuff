package net.hazen.hazennstuff.Datagen;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.hazen.hazennstuff.Blocks.HnSBlockRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.ItemRegistries.HnSArmorItemRegistry;
import net.hazen.hazennstuff.Registries.ItemRegistries.HnSMaterialItemRegistry;
import net.hazen.hazennstuff.Registries.ItemRegistries.HnSWeaponItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
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
                .define('S', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSMaterialItemRegistry.CRUDE_METAL.get(), 2)
                .pattern("III")
                .pattern("CC ")
                .pattern("   ")
                .define('I', Items.IRON_INGOT)
                .define('C', Items.COAL)
                .unlockedBy(getHasName(Items.IRON_INGOT),
                        has(Items.IRON_INGOT)
                )
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HnSMaterialItemRegistry.ZENALITE_INGOT.get(), 9)
                .requires(HnSBlockRegistry.ZENALITE_BLOCK.get())
                .unlockedBy(getHasName(HnSBlockRegistry.ZENALITE_BLOCK.get()),
                        has(HnSBlockRegistry.ZENALITE_BLOCK.get())
                )
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HnSMaterialItemRegistry.STARKISSED_ZENALITE.get(), 4)
                .requires(HnSMaterialItemRegistry.RAW_ZENALITE.get())
                .requires(Items.NETHER_STAR)
                .unlockedBy(getHasName(HnSBlockRegistry.ZENALITE_BLOCK.get()),
                        has(HnSBlockRegistry.ZENALITE_BLOCK.get())
                )
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HnSMaterialItemRegistry.STEEL_NUGGET.get(), 9)
                .requires(HnSMaterialItemRegistry.STEEL_INGOT.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.STEEL_INGOT.get()),
                        has(HnSMaterialItemRegistry.STEEL_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSMaterialItemRegistry.STEEL_INGOT.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', HnSMaterialItemRegistry.STEEL_NUGGET.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.STEEL_NUGGET.get()),
                        has(HnSMaterialItemRegistry.STEEL_NUGGET.get())
                )
                .save(pWriter);

        /*
        *** Weapons
         */



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSWeaponItemRegistry.FIREBLOSSOM_RAPIER.get(), 2)
                .pattern(" NB")
                .pattern("ZBF")
                .pattern("WZ ")
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('F', ItemRegistry.FIRE_RUNE.get())
                .define('N', ItemRegistry.NATURE_RUNE.get())
                .define('B', Items.BLAZE_ROD)
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
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
                        Ingredient.of(HnSArmorItemRegistry.BLAZEBORNE_HELMET.get()),
                        Ingredient.of(Items.BLAZE_POWDER),
                        RecipeCategory.COMBAT,
                        HnSArmorItemRegistry.HAZEL_HELMET.get()
                )
                .unlocks(getHasName(HnSArmorItemRegistry.BLAZEBORNE_HELMET.get()),
                        has(HnSArmorItemRegistry.BLAZEBORNE_HELMET.get())
                )
                .save(pWriter, "hazel_helmet");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.LEATHER),
                        Ingredient.of(HnSArmorItemRegistry.BLAZEBORNE_CHESTPLATE.get()),
                        Ingredient.of(Items.BLAZE_POWDER),
                        RecipeCategory.COMBAT,
                        HnSArmorItemRegistry.HAZEL_CHESTPLATE.get()
                )
                .unlocks(getHasName(HnSArmorItemRegistry.BLAZEBORNE_CHESTPLATE.get()),
                        has(HnSArmorItemRegistry.BLAZEBORNE_CHESTPLATE.get())
                )
                .save(pWriter, "hazel_chestplate");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.LEATHER),
                        Ingredient.of(HnSArmorItemRegistry.BLAZEBORNE_LEGGINGS.get()),
                        Ingredient.of(Items.BLAZE_POWDER),
                        RecipeCategory.COMBAT,
                        HnSArmorItemRegistry.HAZEL_LEGGINGS.get()
                )
                .unlocks(getHasName(HnSArmorItemRegistry.BLAZEBORNE_LEGGINGS.get()),
                        has(HnSArmorItemRegistry.BLAZEBORNE_LEGGINGS.get())
                )
                .save(pWriter, "hazel_leggings");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.LEATHER),
                        Ingredient.of(HnSArmorItemRegistry.BLAZEBORNE_BOOTS.get()),
                        Ingredient.of(Items.BLAZE_POWDER),
                        RecipeCategory.COMBAT,
                        HnSArmorItemRegistry.HAZEL_BOOTS.get()
                )
                .unlocks(getHasName(HnSArmorItemRegistry.BLAZEBORNE_BOOTS.get()),
                        has(HnSArmorItemRegistry.BLAZEBORNE_BOOTS.get())
                )
                .save(pWriter, "hazel_boots");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.LEATHER),
                        Ingredient.of(HnSArmorItemRegistry.HAZEL_CHESTPLATE.get()),
                        Ingredient.of(Items.MELON),
                        RecipeCategory.COMBAT,
                        HnSArmorItemRegistry.BIG_HAZEL_CHESTPLATE.get()
                )
                .unlocks(getHasName(HnSArmorItemRegistry.HAZEL_CHESTPLATE.get()),
                        has(HnSArmorItemRegistry.HAZEL_CHESTPLATE.get())
                )
                .save(pWriter, "how_did_you_find_the_hazel_chestplate");



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.BLAZEBORNE_HELMET.get())
                .pattern("ZRZ")
                .pattern("ZSZ")
                .pattern("   ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.PYROMANCER_HELMET.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.BLAZEBORNE_CHESTPLATE.get())
                .pattern("ZSZ")
                .pattern("ZRZ")
                .pattern("ZZZ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.PYROMANCER_CHESTPLATE.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.BLAZEBORNE_LEGGINGS.get())
                .pattern("ZRZ")
                .pattern("ZSZ")
                .pattern("Z Z")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.PYROMANCER_LEGGINGS.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.BLAZEBORNE_BOOTS.get())
                .pattern("Z Z")
                .pattern("ZSZ")
                .pattern(" R ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.PYROMANCER_BOOTS.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        /*
        *** Ice
         */

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.CRYOGENIC_RULER_HELMET.get())
                .pattern("ZRZ")
                .pattern("ZSZ")
                .pattern("   ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.CRYOMANCER_HELMET.get())
                .define('R', ItemRegistry.ICE_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.CRYOGENIC_RULER_CHESTPLATE.get())
                .pattern("ZSZ")
                .pattern("ZRZ")
                .pattern("ZZZ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.CRYOMANCER_CHESTPLATE.get())
                .define('R', ItemRegistry.ICE_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.CRYOGENIC_RULER_LEGGINGS.get())
                .pattern("ZRZ")
                .pattern("ZSZ")
                .pattern("Z Z")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.CRYOMANCER_LEGGINGS.get())
                .define('R', ItemRegistry.ICE_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.CRYOGENIC_RULER_BOOTS.get())
                .pattern("Z Z")
                .pattern("ZSZ")
                .pattern(" R ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.CRYOMANCER_BOOTS.get())
                .define('R', ItemRegistry.ICE_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        /*
        *** Nature
         */

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSArmorItemRegistry.CREAKING_SORCERER_HELMET.get()),
                        Ingredient.of(HnSArmorItemRegistry.BLAZEBORNE_HELMET.get()),
                        Ingredient.of(ItemRegistry.MANA_RUNE.get()),
                        RecipeCategory.COMBAT,
                        HnSArmorItemRegistry.FIREBLOSSOM_BATTLEMAGE_CROWN.get()
                )
                .unlocks(getHasName(HnSArmorItemRegistry.CREAKING_SORCERER_HELMET.get()),
                        has(HnSArmorItemRegistry.CREAKING_SORCERER_HELMET.get())
                )
                .save(pWriter, "fireblossom_battlemage_crown");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSArmorItemRegistry.CREAKING_SORCERER_HELMET.get()),
                        Ingredient.of(HnSArmorItemRegistry.BLAZEBORNE_HELMET.get()),
                        Ingredient.of(ItemRegistry.PROTECTION_RUNE.get()),
                        RecipeCategory.COMBAT,
                        HnSArmorItemRegistry.FIREBLOSSOM_BATTLEMAGE_HELMET.get()
                )
                .unlocks(getHasName(HnSArmorItemRegistry.CREAKING_SORCERER_HELMET.get()),
                        has(HnSArmorItemRegistry.CREAKING_SORCERER_HELMET.get())
                )
                .save(pWriter, "fireblossom_battlemage_helmet");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSArmorItemRegistry.CREAKING_SORCERER_CHESTPLATE.get()),
                        Ingredient.of(HnSArmorItemRegistry.BLAZEBORNE_CHESTPLATE.get()),
                        Ingredient.of(ItemRegistry.BLANK_RUNE.get()),
                        RecipeCategory.COMBAT,
                        HnSArmorItemRegistry.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get()
                )
                .unlocks(getHasName(HnSArmorItemRegistry.CREAKING_SORCERER_CHESTPLATE.get()),
                        has(HnSArmorItemRegistry.CREAKING_SORCERER_CHESTPLATE.get())
                )
                .save(pWriter, "fireblossom_battlemage_chestplate");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSArmorItemRegistry.CREAKING_SORCERER_LEGGINGS.get()),
                        Ingredient.of(HnSArmorItemRegistry.BLAZEBORNE_LEGGINGS.get()),
                        Ingredient.of(ItemRegistry.BLANK_RUNE.get()),
                        RecipeCategory.COMBAT,
                        HnSArmorItemRegistry.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get()
                )
                .unlocks(getHasName(HnSArmorItemRegistry.CREAKING_SORCERER_LEGGINGS.get()),
                        has(HnSArmorItemRegistry.CREAKING_SORCERER_LEGGINGS.get())
                )
                .save(pWriter, "hazefireblossom_battlemage_leggings");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSArmorItemRegistry.CREAKING_SORCERER_BOOTS.get()),
                        Ingredient.of(HnSArmorItemRegistry.BLAZEBORNE_BOOTS.get()),
                        Ingredient.of(ItemRegistry.BLANK_RUNE.get()),
                        RecipeCategory.COMBAT,
                        HnSArmorItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get()
                )
                .unlocks(getHasName(HnSArmorItemRegistry.CREAKING_SORCERER_BOOTS.get()),
                        has(HnSArmorItemRegistry.CREAKING_SORCERER_BOOTS.get())
                )
                .save(pWriter, "fireblossom_battlemage_boots");


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.CREAKING_SORCERER_HELMET.get())
                .pattern("ZRZ")
                .pattern("ZSZ")
                .pattern("   ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.PLAGUED_HELMET.get())
                .define('R', ItemRegistry.NATURE_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.CREAKING_SORCERER_CHESTPLATE.get())
                .pattern("ZSZ")
                .pattern("ZRZ")
                .pattern("ZZZ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.PLAGUED_CHESTPLATE.get())
                .define('R', ItemRegistry.NATURE_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.CREAKING_SORCERER_LEGGINGS.get())
                .pattern("ZRZ")
                .pattern("ZSZ")
                .pattern("Z Z")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.PLAGUED_LEGGINGS.get())
                .define('R', ItemRegistry.NATURE_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.CREAKING_SORCERER_BOOTS.get())
                .pattern("Z Z")
                .pattern("ZSZ")
                .pattern(" R ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.PLAGUED_BOOTS.get())
                .define('R', ItemRegistry.NATURE_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        /*
        *** Lightning
         */

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.THUNDER_PROWLER_HELMET.get())
                .pattern("ZRZ")
                .pattern("ZSZ")
                .pattern("   ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.ELECTROMANCER_HELMET.get())
                .define('R', ItemRegistry.LIGHTNING_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.THUNDER_PROWLER_CHESTPLATE.get())
                .pattern("ZSZ")
                .pattern("ZRZ")
                .pattern("ZZZ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.ELECTROMANCER_CHESTPLATE.get())
                .define('R', ItemRegistry.LIGHTNING_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.THUNDER_PROWLER_LEGGINGS.get())
                .pattern("ZRZ")
                .pattern("ZSZ")
                .pattern("Z Z")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.ELECTROMANCER_LEGGINGS.get())
                .define('R', ItemRegistry.LIGHTNING_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.THUNDER_PROWLER_BOOTS.get())
                .pattern("Z Z")
                .pattern("ZSZ")
                .pattern(" R ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.ELECTROMANCER_BOOTS.get())
                .define('R', ItemRegistry.LIGHTNING_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        /*
        *** Ender
         */

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.ENDER_DRAGON_HELMET.get())
                .pattern("ZRZ")
                .pattern("ZSZ")
                .pattern("   ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.SHADOWWALKER_HELMET.get())
                .define('R', ItemRegistry.ENDER_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.ENDER_DRAGON_CHESTPLATE.get())
                .pattern("ZSZ")
                .pattern("ZRZ")
                .pattern("ZZZ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.SHADOWWALKER_CHESTPLATE.get())
                .define('R', ItemRegistry.ENDER_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.ENDER_DRAGON_LEGGINGS.get())
                .pattern("ZRZ")
                .pattern("ZSZ")
                .pattern("Z Z")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.SHADOWWALKER_LEGGINGS.get())
                .define('R', ItemRegistry.ENDER_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.ENDER_DRAGON_BOOTS.get())
                .pattern("Z Z")
                .pattern("ZSZ")
                .pattern(" R ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.SHADOWWALKER_BOOTS.get())
                .define('R', ItemRegistry.ENDER_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        /*
        *** Blood
         */

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.FLESH_MASS_HELMET.get())
                .pattern("ZRZ")
                .pattern("ZSZ")
                .pattern("   ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.CULTIST_HELMET.get())
                .define('R', ItemRegistry.BLOOD_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.FLESH_MASS_CHESTPLATE.get())
                .pattern("ZSZ")
                .pattern("ZRZ")
                .pattern("ZZZ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.CULTIST_CHESTPLATE.get())
                .define('R', ItemRegistry.BLOOD_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.FLESH_MASS_LEGGINGS.get())
                .pattern("ZRZ")
                .pattern("ZSZ")
                .pattern("Z Z")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.CULTIST_LEGGINGS.get())
                .define('R', ItemRegistry.BLOOD_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.FLESH_MASS_BOOTS.get())
                .pattern("Z Z")
                .pattern("ZSZ")
                .pattern(" R ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.CULTIST_BOOTS.get())
                .define('R', ItemRegistry.BLOOD_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        /*
        *** Evocation
         */

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.ALCHEMIST_SUPREME_HELMET.get())
                .pattern("ZRZ")
                .pattern("ZSZ")
                .pattern("   ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.ARCHEVOKER_HELMET.get())
                .define('R', ItemRegistry.EVOCATION_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .pattern("ZSZ")
                .pattern("ZRZ")
                .pattern("ZZZ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.ARCHEVOKER_CHESTPLATE.get())
                .define('R', ItemRegistry.EVOCATION_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.ALCHEMIST_SUPREME_LEGGINGS.get())
                .pattern("ZRZ")
                .pattern("ZSZ")
                .pattern("Z Z")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.ARCHEVOKER_LEGGINGS.get())
                .define('R', ItemRegistry.EVOCATION_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.ALCHEMIST_SUPREME_BOOTS.get())
                .pattern("Z Z")
                .pattern("ZSZ")
                .pattern(" R ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.ARCHEVOKER_BOOTS.get())
                .define('R', ItemRegistry.EVOCATION_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        /*
        *** Holy
         */

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.SERAPH_HELMET.get())
                .pattern("ZRZ")
                .pattern("ZSZ")
                .pattern("   ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.PRIEST_HELMET.get())
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.SERAPH_CHESTPLATE.get())
                .pattern("ZSZ")
                .pattern("ZRZ")
                .pattern("ZZZ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.PRIEST_CHESTPLATE.get())
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.SERAPH_LEGGINGS.get())
                .pattern("ZRZ")
                .pattern("ZSZ")
                .pattern("Z Z")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.PRIEST_LEGGINGS.get())
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.SERAPH_BOOTS.get())
                .pattern("Z Z")
                .pattern("ZSZ")
                .pattern(" R ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.PRIEST_BOOTS.get())
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        /*
        *** Eldritch
         */

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.INFESTATION_HELMET.get())
                .pattern("ZRZ")
                .pattern("ZSZ")
                .pattern("   ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.NETHERITE_MAGE_HELMET.get())
                .define('R', HnSTags.Items.ELDRITCH_RUNE)
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.INFESTATION_CHESTPLATE.get())
                .pattern("ZSZ")
                .pattern("ZRZ")
                .pattern("ZZZ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.NETHERITE_MAGE_CHESTPLATE.get())
                .define('R', HnSTags.Items.ELDRITCH_RUNE)
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.INFESTATION_LEGGINGS.get())
                .pattern("ZRZ")
                .pattern("ZSZ")
                .pattern("Z Z")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.NETHERITE_MAGE_LEGGINGS.get())
                .define('R', HnSTags.Items.ELDRITCH_RUNE)
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSArmorItemRegistry.INFESTATION_BOOTS.get())
                .pattern("Z Z")
                .pattern("ZSZ")
                .pattern(" R ")
                .define('Z', HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .define('S', ItemRegistry.NETHERITE_MAGE_BOOTS.get())
                .define('R', HnSTags.Items.ELDRITCH_RUNE)
                .unlockedBy(getHasName(HnSMaterialItemRegistry.ZENALITE_INGOT.get()),
                        has(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                )
                .save(pWriter);


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