package net.hazen.hazennstuff.datagen;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import io.redspace.ironsspellbooks.util.ModTags;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.block.HnSBlocks;
import net.hazen.hazennstuff.registries.HnSItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class HnSRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public HnSRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        //Items ----------------------------------------------------------------------------------------------------------------

        /*
         *** Orbs and Runes
         */


        //Upgrade Orbs
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.RADIANCE_UPGRADE_ORB.get())
                .pattern("RRR")
                .pattern("ROR")
                .pattern("RRR")
                .define('R', HnSItems.RADIANCE_RUNE.get())
                .define('O', ItemRegistry.UPGRADE_ORB.get())
                .unlockedBy("has_upgrade_orb", has(ItemRegistry.UPGRADE_ORB.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/upgrade_orbs/radiance_upgrade_orb"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.SHADOW_UPGRADE_ORB.get())
                .pattern("RRR")
                .pattern("ROR")
                .pattern("RRR")
                .define('R', HnSItems.SHADOW_RUNE.get())
                .define('O', ItemRegistry.UPGRADE_ORB.get())
                .unlockedBy("has_upgrade_orb", has(ItemRegistry.UPGRADE_ORB.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/upgrade_orbs/shadow_upgrade_orb"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.MELEE_UPGRADE_ORB.get())
                .pattern("RRR")
                .pattern("ROR")
                .pattern("RRR")
                .define('R', HnSItems.MELEE_RUNE.get())
                .define('O', ItemRegistry.UPGRADE_ORB.get())
                .unlockedBy("has_upgrade_orb", has(ItemRegistry.UPGRADE_ORB.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/upgrade_orbs/melee_upgrade_orb"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.HEALTH_UPGRADE_ORB.get())
                .pattern("RRR")
                .pattern("ROR")
                .pattern("RRR")
                .define('R', HnSItems.HEALTH_RUNE.get())
                .define('O', ItemRegistry.UPGRADE_ORB.get())
                .unlockedBy("has_upgrade_orb", has(ItemRegistry.UPGRADE_ORB.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/upgrade_orbs/health_upgrade_orb"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.ARCHERY_UPGRADE_ORB.get())
                .pattern("RRR")
                .pattern("ROR")
                .pattern("RRR")
                .define('R', HnSItems.ARCHERY_RUNE.get())
                .define('O', ItemRegistry.UPGRADE_ORB.get())
                .unlockedBy("has_upgrade_orb", has(ItemRegistry.UPGRADE_ORB.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/upgrade_orbs/archery_upgrade_orb"));


        //Runes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.RADIANCE_RUNE.get())
                .pattern("RRR")
                .pattern("ROR")
                .pattern("RRR")
                .define('R', HnSTags.RADIANCE_FOCUS)
                .define('O', ItemRegistry.BLANK_RUNE.get())
                .unlockedBy("has_blank_rune", has(ItemRegistry.BLANK_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/runes/radiance_rune"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.SHADOW_RUNE.get())
                .pattern("RRR")
                .pattern("ROR")
                .pattern("RRR")
                .define('R', HnSTags.SHADOW_FOCUS)
                .define('O', ItemRegistry.BLANK_RUNE.get())
                .unlockedBy("has_blank_rune", has(ItemRegistry.BLANK_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/runes/shadow_rune"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.MELEE_RUNE.get())
                .pattern("RRR")
                .pattern("ROR")
                .pattern("RRR")
                .define('R', HnSTags.MELEE_FOCUS)
                .define('O', ItemRegistry.BLANK_RUNE.get())
                .unlockedBy("has_blank_rune", has(ItemRegistry.BLANK_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/runes/melee_rune"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.HEALTH_RUNE.get())
                .pattern("RRR")
                .pattern("ROR")
                .pattern("RRR")
                .define('R', HnSTags.HEALTH_FOCUS)
                .define('O', ItemRegistry.BLANK_RUNE.get())
                .unlockedBy("has_blank_rune", has(ItemRegistry.BLANK_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/runes/health_rune"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.ARCHERY_RUNE.get())
                .pattern("RRR")
                .pattern("ROR")
                .pattern("RRR")
                .define('R', HnSTags.ARCHERY_FOCUS)
                .define('O', ItemRegistry.BLANK_RUNE.get())
                .unlockedBy("has_blank_rune", has(ItemRegistry.BLANK_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/runes/archery_rune"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.ELDRITCH_RUNE.get())
                .pattern("RRR")
                .pattern("ROR")
                .pattern("RRR")
                .define('R', ModTags.ELDRITCH_FOCUS)
                .define('O', ItemRegistry.BLANK_RUNE.get())
                .unlockedBy("has_blank_rune", has(ItemRegistry.BLANK_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/runes/eldritch_rune"));



        /*
         *** Materials
         */


                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.BLANK_RUNE.get())
                .pattern("FBF")
                .pattern("FAF")
                .pattern("FFF")
                .define('F', HnSItems.RUNESTONE_FRAGMENTS.get())
                .define('A', ItemRegistry.ARCANE_INGOT.get())
                .define('B', ItemRegistry.BLANK_RUNE.get())
                .unlockedBy("has_runestone_fragments", has(HnSItems.RUNESTONE_FRAGMENTS.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/materials/blank_rune"));


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.DREADSTEEL_INGOT.get())
                .pattern(" S ")
                .pattern("SDS")
                .pattern(" S ")
                .define('D', HnSItems.DREADSTONE.get())
                .define('S', HnSItems.STEEL_INGOT.get())
                .unlockedBy("has_dreadstone", has(HnSItems.DREADSTONE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/materials/dreadsteel_ingot"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.HALLOWED_INGOT.get())
                .pattern("MD ")
                .pattern("DSD")
                .pattern(" DM")
                .define('D', ItemRegistry.DIVINE_PEARL.get())
                .define('S', HnSItems.STEEL_INGOT.get())
                .define('M', ItemRegistry.MITHRIL_SCRAP.get())
                .unlockedBy("has_zenalite", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/materials/hallowed_ingot"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.CRUDE_METAL.get())
                .pattern("CIC")
                .pattern("ICI")
                .pattern("CIC")
                .define('I', Items.IRON_INGOT)
                .define('C', Items.COAL)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/materials/crude_metal"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.SHADESTONE.get())
                .pattern(" C ")
                .pattern("CSC")
                .pattern(" C ")
                .define('S', HnSItems.DREADSTONE.get())
                .define('C', HnSItems.SHADOW_SCALE.get())
                .unlockedBy("has_dreadstone", has(HnSItems.DREADSTONE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/materials/shadestone"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.ROSE_GOLD_INGOT.get())
                .pattern(" R ")
                .pattern("RCR")
                .pattern(" R ")
                .define('C', Items.COPPER_INGOT)
                .define('R', HnSItems.ROSE_QUARTZ.get())
                .unlockedBy("has_rose_quartz", has(HnSItems.ROSE_QUARTZ.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/materials/rose_gold_ingot"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HnSItems.STEEL_NUGGET.get(), 9)
                .requires(HnSItems.STEEL_INGOT)
                .unlockedBy("has_steel",
                        has(HnSItems.STEEL_INGOT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/materials/steel_nugget")
                );

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.STEEL_INGOT.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', HnSItems.STEEL_NUGGET.get())
                .unlockedBy("has_steel", has(HnSItems.STEEL_NUGGET.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/materials/steel_ingot"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.STORM_WEAVE.get())
                .pattern("LLL")
                .pattern("LML")
                .pattern("LLL")
                .define('L', ItemRegistry.LIGHTNING_BOTTLE.get())
                .define('M', ItemRegistry.MITHRIL_WEAVE.get())
                .unlockedBy("has_mithril_weave", has(ItemRegistry.MITHRIL_WEAVE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/materials/storm_weave"));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, HnSItems.VOLT_CORE.get())
                .pattern("LLL")
                .pattern("LML")
                .pattern("LLL")
                .define('L', ItemRegistry.LIGHTNING_BOTTLE.get())
                .define('M', HnSItems.DREADSTONE.get())
                .unlockedBy("has_dreadstone", has(HnSItems.DREADSTONE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/materials/volt_core"));


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HnSItems.GLOWING_MUSHROOM.get(), 2)
                .requires(Tags.Items.MUSHROOMS)
                .requires(HnSItems.PRISMATIC_SHARD)
                .unlockedBy("has_mushrooms",
                        has(Tags.Items.MUSHROOMS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/materials/glowing_mushroom")
                );

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HnSItems.PRISMATIC_SHARD.get(), 2)
                .requires(Tags.Items.GLASS_BLOCKS)
                .requires(Items.GLOW_INK_SAC)
                .unlockedBy("has_glass",
                        has(Tags.Items.GLASS_BLOCKS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/materials/prismatic_shard")
                );

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HnSItems.DIVINE_LEMON.get(), 1)
                .requires(HnSItems.LEMON)
                .requires(HnSItems.DEUS_ESSENCE)
                .unlockedBy("has_lemon",
                        has(HnSItems.LEMON))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/materials/divine_lemon")
                );

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HnSItems.LEMON.get(), 1)
                .requires(Tags.Items.FOODS_FRUIT)
                .requires(ModTags.NATURE_FOCUS)
                .unlockedBy("has_fruit",
                        has(Tags.Items.FOODS_FRUIT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/materials/lemon")
                );

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HnSItems.ROSE_QUARTZ.get(), 2)
                .requires(Tags.Items.GEMS_QUARTZ)
                .requires(ItemRegistry.DIVINE_PEARL.get())
                .unlockedBy("has_quartz",
                        has(Tags.Items.GEMS_QUARTZ))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/materials/rose_quartz")
                );



        /*
         *** Weapons
         */
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.RAVENS_BANE.get(), 1)
                .pattern("PFZ")
                .pattern("PD ")
                .pattern(" Z ")
                .define('D', ItemRegistry.HELLRAZOR.get())
                .define('P', ItemRegistry.PYRIUM_INGOT.get())
                .define('F', Items.FEATHER)
                .define('Z', HnSItems.ZENALITE_INGOT.get())
                .unlockedBy("has_pyrium_ingot", has(ItemRegistry.PYRIUM_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/weapons/ravens_bane"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.FIREBRAND.get(), 1)
                .pattern("SGS")
                .pattern("SB ")
                .pattern(" B ")
                .define('S', HnSItems.SOLAR_CORE.get())
                .define('B', Items.BLAZE_ROD)
                .define('G', Items.GOLD_INGOT)
                .unlockedBy("has_blaze_rod", has(Items.BLAZE_ROD))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/weapons/firebrand"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.DRACONIC_SPLITTER.get(), 1)
                .pattern(" ZC")
                .pattern("SDZ")
                .pattern("BS ")
                .define('D', ItemRegistry.LEGIONNAIRE_FLAMBERGE.get())
                .define('S', HnSItems.SOLAR_CORE.get())
                .define('B', Items.BLAZE_ROD)
                .define('Z', HnSItems.ZENALITE_INGOT.get())
                .define('C', HnSItems.CHARRED_BONES.get())
                .unlockedBy("has_legionnaire_flameberge", has(ItemRegistry.LEGIONNAIRE_FLAMBERGE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/weapons/draconic_splitter"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.WARFLAMING_LANCE.get(), 1)
                .pattern("Z B")
                .pattern("SD ")
                .pattern("BSZ")
                .define('D', ItemRegistry.LEGIONNAIRE_FLAMBERGE.get())
                .define('S', HnSItems.SOLAR_CORE.get())
                .define('B', Items.BLAZE_ROD)
                .define('Z', HnSItems.ZENALITE_INGOT.get())
                .unlockedBy("has_legionnaire_flameberge", has(ItemRegistry.LEGIONNAIRE_FLAMBERGE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/weapons/warflaming_lance"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.FROSTBURN_DAGGER.get(), 1)
                .pattern(" R ")
                .pattern(" P ")
                .pattern(" S ")
                .define('P', HnSItems.PERMAFROST_FRAGMENT.get())
                .define('R', ItemRegistry.ICE_RUNE.get())
                .define('S', ItemRegistry.FROSTED_HELVE.get())
                .unlockedBy("has_permafrost_fragment", has(HnSItems.PERMAFROST_FRAGMENT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/weapons/frostburn_dagger"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.VAMPIRE_KNIVES.get(), 1)
                .pattern("DDB")
                .pattern("RPD")
                .pattern("WRD")
                .define('D', HnSItems.DREADSTEEL_INGOT.get())
                .define('R', ItemRegistry.BLOOD_RUNE.get())
                .define('B', ItemRegistry.BLOOD_VIAL.get())
                .define('P', Items.NETHERITE_SWORD)
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .unlockedBy("has_deadsteel_ingot", has(HnSItems.DREADSTEEL_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/weapons/vampire_knives"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.HAMMER_OF_JUSTICE.get(), 1)
                .pattern("HRH")
                .pattern("HWH")
                .pattern(" Z ")
                .define('H', HnSItems.HALLOWED_INGOT.get())
                .define('Z', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .unlockedBy("has_hallowed_ingot", has(HnSItems.HALLOWED_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/weapons/hammer_of_justice"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.EXCALIBUR.get(), 1)
                .pattern(" HH")
                .pattern("ZRH")
                .pattern("WZ ")
                .define('H', HnSItems.HALLOWED_INGOT.get())
                .define('Z', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .unlockedBy("has_hallowed_ingot", has(HnSItems.HALLOWED_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/weapons/excalibur"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.GOLD_INGOT),
                        Ingredient.of(HnSItems.EXCALIBUR.get()),
                        Ingredient.of(ItemRegistry.DIVINE_PEARL.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.ISS_EXCALIBUR.get())
                .unlocks("has_gold_ingot", has(Items.GOLD_INGOT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/weapons/terraria_to_iss"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.DIVINE_PEARL.get()),
                        Ingredient.of(HnSItems.ISS_EXCALIBUR.get()),
                        Ingredient.of(Items.GOLD_INGOT),
                        RecipeCategory.COMBAT,
                        HnSItems.EXCALIBUR.get())
                .unlocks("has_divine_pearl", has(ItemRegistry.DIVINE_PEARL.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/weapons/iss_to_terraria"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.HAZENS_EXCALIBUR.get(), 1)
                .pattern(" HZ")
                .pattern("DRH")
                .pattern("WD ")
                .define('H', HnSItems.HALLOWED_INGOT.get())
                .define('Z', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .define('D', ItemRegistry.DIVINE_PEARL.get())
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .unlockedBy("has_hallowed_ingot", has(HnSItems.HALLOWED_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/weapons/hazens_excalibur"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.DIVINE_PEARL.get()),
                        Ingredient.of(Items.NETHERITE_SWORD),
                        Ingredient.of(ItemRegistry.WEAPON_PARTS.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.DIVINE_GREATSWORD.get())
                .unlocks("has_divine_pearl", has(ItemRegistry.DIVINE_PEARL.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/weapons/divine_greatsword"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.HAMMUSH.get(), 1)
                .pattern("HRH")
                .pattern("SWS")
                .pattern(" Z ")
                .define('H', HnSItems.GLOWING_MUSHROOM.get())
                .define('S', HnSItems.PRISMATIC_SHARD.get())
                .define('Z', HnSItems.ZENALITE_INGOT.get())
                .define('R', HnSItems.RADIANCE_RUNE.get())
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .unlockedBy("has_glowing_mushroom", has(HnSItems.GLOWING_MUSHROOM.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/weapons/hammush"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.SPECTRUM.get(), 1)
                .pattern(" PR")
                .pattern("PRZ")
                .pattern("WZ ")
                .define('P', HnSItems.PRISMATIC_SHARD.get())
                .define('Z', HnSItems.ZENALITE_INGOT.get())
                .define('R', HnSItems.RADIANCE_RUNE.get())
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .unlockedBy("has_prismatic_shard", has(HnSItems.PRISMATIC_SHARD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/weapons/spectrum"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.LIGHTS_BANE.get(), 1)
                .pattern(" D ")
                .pattern(" D ")
                .pattern(" W ")
                .define('D', HnSItems.DEMONITE_INGOT.get())
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .unlockedBy("has_demonite_ingot", has(HnSItems.DEMONITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/weapons/lights_bane"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.VOLCANO.get(), 1)
                .pattern("  B")
                .pattern("RS ")
                .pattern("WR ")
                .define('S', HnSItems.SOLAR_CORE.get())
                .define('B', Items.BLAZE_ROD)
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .unlockedBy("has_demonite_ingot", has(HnSItems.SOLAR_CORE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/weapons/volcano"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.BLADE_OF_GRASS.get(), 1)
                .pattern("  G")
                .pattern("RO ")
                .pattern("WR ")
                .define('O', HnSItems.OVERGROWN_BONE.get())
                .define('G', Items.SHORT_GRASS)
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .define('R', ItemRegistry.NATURE_RUNE.get())
                .unlockedBy("has_demonite_ingot", has(HnSItems.SOLAR_CORE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/weapons/blade_of_grass"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.NIGHTS_EDGE.get(), 1)
                .pattern("WV ")
                .pattern("BDM")
                .pattern(" LW")
                .define('D', ItemRegistry.DIVINE_SOULSHARD.get())
                .define('M', HnSItems.MURAMASA.get())
                .define('V', HnSItems.VOLCANO.get())
                .define('B', HnSItems.BLADE_OF_GRASS.get())
                .define('L', HnSItems.LIGHTS_BANE.get())
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .unlockedBy("has_divine_soulshard", has(ItemRegistry.DIVINE_SOULSHARD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/weapons/nights_edge"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.THE_DEVOURER.get(), 1)
                .pattern(" EE")
                .pattern("WFE")
                .pattern("NW ")
                .define('F', HnSItems.EXCALIBUR_FRAGMENT.get())
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .define('E', Items.ECHO_SHARD)
                .define('N', Items.NETHERITE_SWORD)
                .unlockedBy("has_excalibur_fragment", has(HnSItems.EXCALIBUR_FRAGMENT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/weapons/the_devourer"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.DAWNMAKER.get(), 1)
                .pattern(" HE")
                .pattern(" FH")
                .pattern("W  ")
                .define('F', HnSItems.EXCALIBUR_FRAGMENT.get())
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .define('E', HnSItems.STEEL_INGOT)
                .define('H', HnSItems.HALLOWED_INGOT)
                .unlockedBy("has_excalibur_fragment", has(HnSItems.EXCALIBUR_FRAGMENT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/weapons/dawnmaker"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.MAGE_BANE.get(), 1)
                .pattern(" IS")
                .pattern(" MI")
                .pattern("W  ")
                .define('S', HnSItems.STEEL_INGOT.get())
                .define('I', ItemRegistry.MITHRIL_INGOT.get())
                .define('M', ItemRegistry.MAGEHUNTER.get())
                .define('W', ItemRegistry.WEAPON_PARTS.get())
                .unlockedBy("has_magehunter", has(ItemRegistry.MAGEHUNTER.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/weapons/mage_bane"));

        /*
         *** Staves
         */

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.WHITE_LILY_STAFF.get(), 1)
                .pattern(" L ")
                .pattern("RGR")
                .pattern(" C ")
                .define('C', HnSItems.CHLOROPHYTE_INGOT.get())
                .define('R', ItemRegistry.NATURE_RUNE.get())
                .define('L', Items.LILY_OF_THE_VALLEY)
                .define('G', ItemRegistry.GRAYBEARD_STAFF.get())
                .unlockedBy("has_graybeard_staff", has(ItemRegistry.GRAYBEARD_STAFF.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/staves/white_lily_staff"));





        /*
         *** Curios
         */


        //Spellbooks

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.GOLDEN_SHOWER_SPELLBOOK.get(), 1)
                .pattern("MRM")
                .pattern("DCD")
                .pattern("MAM")
                .define('C', ItemRegistry.CHAINED_BOOK.get())
                .define('M', ItemRegistry.MITHRIL_WEAVE.get())
                .define('D', ItemRegistry.DIVINE_PEARL.get())
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .define('A', HnSItems.ZENALITE_INGOT.get())
                .unlockedBy("has_chained_book", has(ItemRegistry.CHAINED_BOOK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/curios/golden_shower"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.ENERGIZED_CORE_SPELLBOOK.get(), 1)
                .pattern("SRS")
                .pattern("DED")
                .pattern("SIS")
                .define('E', ItemRegistry.ENERGIZED_CORE.get())
                .define('I', ItemRegistry.IRON_SPELL_BOOK.get())
                .define('D', HnSItems.VOLT_CORE.get())
                .define('R', ItemRegistry.LIGHTNING_RUNE.get())
                .define('S', HnSItems.STORM_WEAVE.get())
                .unlockedBy("has_energized_core", has(ItemRegistry.ENERGIZED_CORE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/curios/energized_core"));

        //Sheaths

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.GALVANIZED_SHEATH.get(), 1)
                .pattern(" VZ")
                .pattern("VES")
                .pattern("RS ")
                .define('E', ItemRegistry.ENERGIZED_CORE.get())
                .define('Z', HnSItems.ZENALITE_INGOT.get())
                .define('V', HnSItems.VOLT_CORE.get())
                .define('R', ItemRegistry.LIGHTNING_RUNE.get())
                .define('S', HnSItems.STORM_WEAVE.get())
                .unlockedBy("has_energized_core", has(ItemRegistry.ENERGIZED_CORE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/curios/galvanized_sheath"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.SCROLL_SHEATH.get(), 1)
                .pattern(" MZ")
                .pattern("ADM")
                .pattern("ZR ")
                .define('R', ItemRegistry.MANA_RUNE.get())
                .define('D', ItemRegistry.DIVINE_SOULSHARD.get())
                .define('A', ItemRegistry.ARCANE_INGOT.get())
                .define('Z', HnSItems.ZENALITE_INGOT.get())
                .define('M', ItemRegistry.MITHRIL_WEAVE.get())
                .unlockedBy("has_divine_soulshard", has(ItemRegistry.DIVINE_SOULSHARD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/curios/scroll_sheath"));

        // Wings

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.ARBITRIUM_WINGS.get(), 1)
                .pattern("FWD")
                .pattern("AFW")
                .pattern(" EA")
                .define('F', Items.FEATHER)
                .define('E', Items.ELYTRA)
                .define('W', HnSBlocks.WISEWOOD_LOG.get())
                .define('D', HnSItems.DEUS_ESSENCE.get())
                .define('A', ItemRegistry.ARCANE_ESSENCE.get())
                .unlockedBy("has_deus_essence", has(HnSItems.DEUS_ESSENCE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/curios/arbitrium_wings"));

        //Misc

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.MITHRIL_INGOT.get()),
                        Ingredient.of(ItemRegistry.COOLDOWN_RING.get()),
                        Ingredient.of(ItemRegistry.CAST_TIME_RING.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.RING_OF_EFFICIENCY.get())
                .unlocks("has_mithril", has(ItemRegistry.MITHRIL_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/weapons/ring_of_efficiency"));



        /*
         *** Tools
         */

        // Pickaxe Axe

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.PICKAXE_AXE.get(), 1)
                .pattern("HPH")
                .pattern("HR ")
                .pattern(" A ")
                .define('H', HnSItems.HALLOWED_INGOT.get())
                .define('A', Items.NETHERITE_PICKAXE)
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .define('P', Items.NETHERITE_AXE)
                .unlockedBy("has_hallowed_ingot", has(HnSItems.HALLOWED_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/tools/pickaxe_axe"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.GOLD_INGOT),
                        Ingredient.of(HnSItems.PICKAXE_AXE.get()),
                        Ingredient.of(ItemRegistry.DIVINE_PEARL.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.PICKAXE_AXE_DIVINE_GOLD.get())
                .unlocks("has_gold_ingot", has(Items.GOLD_INGOT))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/tools/terraria_to_iss"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.DIVINE_PEARL.get()),
                        Ingredient.of(HnSItems.PICKAXE_AXE_DIVINE_GOLD.get()),
                        Ingredient.of(Items.GOLD_INGOT),
                        RecipeCategory.COMBAT,
                        HnSItems.PICKAXE_AXE.get())
                .unlocks("has_divine_pearl", has(ItemRegistry.DIVINE_PEARL.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/tools/iss_to_terraria"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.EVOCATION_RUNE.get()),
                        Ingredient.of(Items.NETHERITE_PICKAXE),
                        Ingredient.of(ItemRegistry.MITHRIL_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.SPECTRAL_PICKAXE.get())
                .unlocks("has_netherite_pickaxe", has(Items.NETHERITE_PICKAXE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/tools/spectral_pickaxe"));


        //Blocks ----------------------------------------------------------------------------------------------------------------


        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, HnSBlocks.WISEWOOD_BUTTON.get(), 18)
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
//                    .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/zenalite_ingot_block"));


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
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/blazeborne/blazeborne_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.BLAZEBORNE_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RMR")
                .pattern("TTT")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.PYROMANCER_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/blazeborne/blazeborne_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.BLAZEBORNE_LEGGINGS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.PYROMANCER_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/blazeborne/blazeborne_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.BLAZEBORNE_BOOTS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.PYROMANCER_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/blazeborne/blazeborne_boots"));


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
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/cryogenic_ruler/cryogenic_ruler_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.CRYOGENIC_RULER_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RMR")
                .pattern("TTT")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.ICE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.CRYOMANCER_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/cryogenic_ruler/cryogenic_ruler_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.CRYOGENIC_RULER_LEGGINGS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.ICE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.CRYOMANCER_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/cryogenic_ruler/cryogenic_ruler_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.CRYOGENIC_RULER_BOOTS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.ICE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.CRYOMANCER_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/cryogenic_ruler/cryogenic_ruler_boots"));


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
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/thunder_prowler/thunder_prowler_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.THUNDER_PROWLER_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RMR")
                .pattern("TTT")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.LIGHTNING_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.ELECTROMANCER_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/thunder_prowler/thunder_prowler_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.THUNDER_PROWLER_LEGGINGS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.LIGHTNING_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.ELECTROMANCER_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/thunder_prowler/thunder_prowler_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.THUNDER_PROWLER_BOOTS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.LIGHTNING_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.ELECTROMANCER_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/thunder_prowler/thunder_prowler_boots"));


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
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/creaking_sorcerer/creaking_sorcerer_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.CREAKING_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RMR")
                .pattern("TTT")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.NATURE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.PLAGUED_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/creaking_sorcerer/creaking_sorcerer_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.CREAKING_LEGGINGS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.NATURE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.PLAGUED_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/creaking_sorcerer/creaking_sorcerer_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.CREAKING_BOOTS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.NATURE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.PLAGUED_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/creaking_sorcerer/creaking_sorcerer_boots"));

        //Chlorophyte Armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.CHLOROPHYTE_MASK.get())
                .pattern("RCR")
                .pattern("CPC")
                .pattern(" M ")
                .define('C', HnSItems.CHLOROPHYTE_INGOT.get())
                .define('R', HnSItems.MELEE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', Items.NETHERITE_HELMET)
                .unlockedBy("has_chlorophyte_ingot", has(HnSItems.CHLOROPHYTE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/chlorophyte/chlorophyte_mask"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.CHLOROPHYTE_HELMET.get())
                .pattern("RCR")
                .pattern("CPC")
                .pattern("   ")
                .define('C', HnSItems.CHLOROPHYTE_INGOT.get())
                .define('R', HnSItems.ARCHERY_RUNE.get())
                .define('P', Items.NETHERITE_HELMET)
                .unlockedBy("has_chlorophyte_ingot", has(HnSItems.CHLOROPHYTE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/chlorophyte/chlorophyte_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.CHLOROPHYTE_HEADGEAR.get())
                .pattern("RCR")
                .pattern("CPC")
                .pattern(" C ")
                .define('C', HnSItems.CHLOROPHYTE_INGOT.get())
                .define('R', ItemRegistry.MANA_RUNE.get())
                .define('P', Items.NETHERITE_HELMET)
                .unlockedBy("has_chlorophyte_ingot", has(HnSItems.CHLOROPHYTE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/chlorophyte/chlorophyte_headgear"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.CHLOROPHYTE_CHESTPLATE.get())
                .pattern("CPC")
                .pattern("RCR")
                .pattern("CCC")
                .define('C', HnSItems.CHLOROPHYTE_INGOT.get())
                .define('R', ItemRegistry.BLANK_RUNE.get())
                .define('P', Items.NETHERITE_CHESTPLATE)
                .unlockedBy("has_chlorophyte_ingot", has(HnSItems.CHLOROPHYTE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/chlorophyte/chlorophyte_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.CHLOROPHYTE_LEGGINGS.get())
                .pattern("RPR")
                .pattern("C C")
                .pattern("C C")
                .define('C', HnSItems.CHLOROPHYTE_INGOT.get())
                .define('R', ItemRegistry.BLANK_RUNE.get())
                .define('P', Items.NETHERITE_LEGGINGS)
                .unlockedBy("has_chlorophyte_ingot", has(HnSItems.CHLOROPHYTE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/chlorophyte/chlorophyte_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.CHLOROPHYTE_BOOTS.get())
                .pattern("R R")
                .pattern("CPC")
                .pattern("   ")
                .define('C', HnSItems.CHLOROPHYTE_INGOT.get())
                .define('R', ItemRegistry.BLANK_RUNE.get())
                .define('P', Items.NETHERITE_BOOTS)
                .unlockedBy("has_chlorophyte_ingot", has(HnSItems.CHLOROPHYTE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/chlorophyte/chlorophyte_boots"));



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
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/flesh_mass/flesh_mass_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.FLESH_MASS_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RMR")
                .pattern("TTT")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.BLOOD_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.CULTIST_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/flesh_mass/flesh_mass_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.FLESH_MASS_LEGGINGS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.BLOOD_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.CULTIST_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/flesh_mass/flesh_mass_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.FLESH_MASS_BOOTS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.BLOOD_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.CULTIST_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/flesh_mass/flesh_mass_boots"));


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
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/ender_dragon/ender_dragon_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.ENDER_DRAGON_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RMR")
                .pattern("TTT")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.ENDER_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.SHADOWWALKER_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/ender_dragon/ender_dragon_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.ENDER_DRAGON_LEGGINGS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.ENDER_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.SHADOWWALKER_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/ender_dragon/ender_dragon_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.ENDER_DRAGON_BOOTS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.ENDER_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.SHADOWWALKER_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/ender_dragon/ender_dragon_boots"));


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
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/seraph/seraph_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.SERAPH_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RMR")
                .pattern("TTT")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.PRIEST_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/seraph/seraph_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.SERAPH_LEGGINGS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.PRIEST_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/seraph/seraph_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.SERAPH_BOOTS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.PRIEST_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/seraph/seraph_boots"));


        // Gabriel ULTRAKILL Armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.GABRIEL_ULTRAKILL_HELMET.get())
                .pattern("RTR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', Items.GOLD_INGOT)
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .define('P', HnSItems.SERAPH_HELMET.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/gabriel_ultrakill/gabriel_ultrakill_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RER")
                .pattern("TTT")
                .define('T', Items.GOLD_INGOT)
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .define('E', Items.ELYTRA)
                .define('P', HnSItems.SERAPH_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/gabriel_ultrakill/gabriel_ultrakill_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.GABRIEL_ULTRAKILL_LEGGINGS.get())
                .pattern("RTR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', Items.GOLD_INGOT)
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .define('P', HnSItems.SERAPH_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/gabriel_ultrakill/gabriel_ultrakill_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.GABRIEL_ULTRAKILL_BOOTS.get())
                .pattern("RTR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', Items.GOLD_INGOT)
                .define('R', ItemRegistry.HOLY_RUNE.get())
                .define('P', HnSItems.SERAPH_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/gabriel_ultrakill/gabriel_ultrakill_boots"));


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
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/alchemist_supreme/alchemist_supreme_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RMR")
                .pattern("TTT")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.EVOCATION_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.ARCHEVOKER_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/alchemist_supreme/alchemist_supreme_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.ALCHEMIST_SUPREME_LEGGINGS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.EVOCATION_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.ARCHEVOKER_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/alchemist_supreme/alchemist_supreme_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.ALCHEMIST_SUPREME_BOOTS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.EVOCATION_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.ARCHEVOKER_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/alchemist_supreme/alchemist_supreme_boots"));


        /*
         *** Radiance
         */


        /*
         *** Shadow
         */


        // Shadow Scale Armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.SHADOW_SCALE_HELMET.get())
                .pattern("RTR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.DEMONITE_INGOT.get())
                .define('R', HnSItems.SHADOW_RUNE.get())
                .define('P', ItemRegistry.NETHERITE_MAGE_HELMET.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/shadow_scale/shadow_scale_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.SHADOW_SCALE_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RTR")
                .pattern("TTT")
                .define('T', HnSItems.DEMONITE_INGOT.get())
                .define('R', HnSItems.SHADOW_RUNE.get())
                .define('P', ItemRegistry.NETHERITE_MAGE_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/shadow_scale/shadow_scale_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.SHADOW_SCALE_LEGGINGS.get())
                .pattern("RTR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', HnSItems.DEMONITE_INGOT.get())
                .define('R', HnSItems.SHADOW_RUNE.get())
                .define('P', ItemRegistry.NETHERITE_MAGE_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/shadow_scale/shadow_scale_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.SHADOW_SCALE_BOOTS.get())
                .pattern("R R")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.DEMONITE_INGOT.get())
                .define('R', HnSItems.SHADOW_RUNE.get())
                .define('P', ItemRegistry.NETHERITE_MAGE_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/shadow_scale/shadow_scale_boots"));



        /*
         *** Eldritch
         */

        // Infestation Armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.INFESTATION_HELMET.get())
                .pattern("RTR")
                .pattern("TPT")
                .pattern(" M ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', HnSItems.ELDRITCH_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.NETHERITE_MAGE_HELMET.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/infestation/infestation_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.INFESTATION_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RMR")
                .pattern("TTT")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', HnSItems.ELDRITCH_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.NETHERITE_MAGE_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/infestation/infestation_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.INFESTATION_LEGGINGS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', HnSItems.ELDRITCH_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.NETHERITE_MAGE_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/infestation/infestation_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.INFESTATION_BOOTS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', HnSItems.ELDRITCH_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', ItemRegistry.NETHERITE_MAGE_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/infestation/infestation_boots"));


        /*
         *** Melee
         */


        // Dreadsteel Knight Armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.DREADSTEEL_KNIGHT_HELMET.get())
                .pattern("RTR")
                .pattern("TPT")
                .pattern(" M ")
                .define('T', HnSItems.DREADSTEEL_INGOT.get())
                .define('R', HnSItems.MELEE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', Items.DIAMOND_HELMET)
                .unlockedBy("has_dreadsteel_ingot", has(HnSItems.DREADSTEEL_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/dreadsteel_knight/dreadsteel_knight_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.DREADSTEEL_KNIGHT_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RMR")
                .pattern("TTT")
                .define('T', HnSItems.DREADSTEEL_INGOT.get())
                .define('R', HnSItems.MELEE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', Items.DIAMOND_CHESTPLATE)
                .unlockedBy("has_dreadsteel_ingot", has(HnSItems.DREADSTEEL_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/dreadsteel_knight/dreadsteel_knight_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.DREADSTEEL_KNIGHT_LEGGINGS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', HnSItems.DREADSTEEL_INGOT.get())
                .define('R', HnSItems.MELEE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', Items.DIAMOND_LEGGINGS)
                .unlockedBy("has_dreadsteel_ingot", has(HnSItems.DREADSTEEL_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/dreadsteel_knight/dreadsteel_knight_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.DREADSTEEL_KNIGHT_BOOTS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.DREADSTEEL_INGOT.get())
                .define('R', HnSItems.MELEE_RUNE.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', Items.DIAMOND_BOOTS)
                .unlockedBy("has_dreadsteel_ingot", has(HnSItems.DREADSTEEL_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/dreadsteel_knight/dreadsteel_knight_boots"));


        // Frostbite knight Armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.FROSTBITE_KNIGHT_HELMET.get())
                .pattern("RTR")
                .pattern("TPT")
                .pattern(" M ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.ICE_CRYSTAL.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', HnSItems.DREADSTEEL_KNIGHT_HELMET.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/frostbite_knight/frostbite_knight_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.FROSTBITE_KNIGHT_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RMR")
                .pattern("TTT")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.ICE_CRYSTAL.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', HnSItems.DREADSTEEL_KNIGHT_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/frostbite_knight/frostbite_knight_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.FROSTBITE_KNIGHT_LEGGINGS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.ICE_CRYSTAL.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', HnSItems.DREADSTEEL_KNIGHT_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/frostbite_knight/frostbite_knight_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.FROSTBITE_KNIGHT_BOOTS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', ItemRegistry.ICE_CRYSTAL.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', HnSItems.DREADSTEEL_KNIGHT_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/frostbite_knight/frostbite_knight_boots"));



        /*
         *** Archery
         */


        //Bounty Hunter Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.ARCHERY_RUNE.get()),
                        Ingredient.of(ItemRegistry.WIZARD_HELMET.get()),
                        Ingredient.of(ItemRegistry.ARCANE_ESSENCE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.BOUNTY_HUNTER_HELMET.get())
                .unlocks("has_archery_rune", has(HnSItems.ARCHERY_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/bounty_hunter/bounty_hunter_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.ARCHERY_RUNE.get()),
                        Ingredient.of(ItemRegistry.WIZARD_CHESTPLATE.get()),
                        Ingredient.of(ItemRegistry.ARCANE_ESSENCE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.BOUNTY_HUNTER_CHESTPLATE.get())
                .unlocks("has_archery_rune", has(HnSItems.ARCHERY_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/bounty_hunter/bounty_hunter_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.ARCHERY_RUNE.get()),
                        Ingredient.of(ItemRegistry.WIZARD_LEGGINGS.get()),
                        Ingredient.of(ItemRegistry.ARCANE_ESSENCE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.BOUNTY_HUNTER_LEGGINGS.get())
                .unlocks("has_archery_rune", has(HnSItems.ARCHERY_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/bounty_hunter/bounty_hunter_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.ARCHERY_RUNE.get()),
                        Ingredient.of(ItemRegistry.WIZARD_BOOTS.get()),
                        Ingredient.of(ItemRegistry.ARCANE_ESSENCE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.BOUNTY_HUNTER_BOOTS.get())
                .unlocks("has_archery_rune", has(HnSItems.ARCHERY_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/bounty_hunter/bounty_hunter_boots"));


        // Frostbite knight Armor
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.FROSTBITE_HUNTER_HELMET.get())
                .pattern("RTR")
                .pattern("TPT")
                .pattern(" M ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', HnSItems.PERMAFROST_FRAGMENT.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', HnSItems.BOUNTY_HUNTER_HELMET.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/frostbite_hunter/frostbite_hunter_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.FROSTBITE_HUNTER_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RMR")
                .pattern("TTT")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', HnSItems.PERMAFROST_FRAGMENT.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', HnSItems.BOUNTY_HUNTER_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/frostbite_hunter/frostbite_hunter_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.FROSTBITE_HUNTER_LEGGINGS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', HnSItems.PERMAFROST_FRAGMENT.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', HnSItems.BOUNTY_HUNTER_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/frostbite_hunter/frostbite_hunter_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.FROSTBITE_HUNTER_BOOTS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.ZENALITE_INGOT.get())
                .define('R', HnSItems.PERMAFROST_FRAGMENT.get())
                .define('M', HnSItems.DIVINE_MOLD.get())
                .define('P', HnSItems.BOUNTY_HUNTER_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/frostbite_hunter/frostbite_hunter_boots"));


        //Permafrost Prince Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.ICE_RUNE.get()),
                        Ingredient.of(HnSItems.FROSTBITE_HUNTER_HELMET.get()),
                        Ingredient.of(ItemRegistry.ICE_CRYSTAL.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.PERMAFROST_PRINCE_HELMET.get())
                .unlocks("has_permafrost_shard", has(ItemRegistry.ICE_CRYSTAL.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/permafrost_prince/permafrost_prince_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.ICE_RUNE.get()),
                        Ingredient.of(HnSItems.FROSTBITE_HUNTER_CHESTPLATE.get()),
                        Ingredient.of(ItemRegistry.ICE_CRYSTAL.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.PERMAFROST_PRINCE_CHESTPLATE.get())
                .unlocks("has_permafrost_shard", has(ItemRegistry.ICE_CRYSTAL.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/permafrost_prince/permafrost_prince_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.ICE_RUNE.get()),
                        Ingredient.of(HnSItems.FROSTBITE_HUNTER_LEGGINGS.get()),
                        Ingredient.of(ItemRegistry.ICE_CRYSTAL.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.PERMAFROST_PRINCE_LEGGINGS.get())
                .unlocks("has_permafrost_shard", has(ItemRegistry.ICE_CRYSTAL.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/permafrost_prince/permafrost_prince_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.ICE_RUNE.get()),
                        Ingredient.of(HnSItems.FROSTBITE_HUNTER_BOOTS.get()),
                        Ingredient.of(ItemRegistry.ICE_CRYSTAL.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.PERMAFROST_PRINCE_BOOTS.get())
                .unlocks("has_permafrost_shard", has(ItemRegistry.ICE_CRYSTAL.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/permafrost_prince/permafrost_prince_boots"));




        /*
         *** Tyros
         */


        //Pyrium Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(Items.NETHERITE_HELMET),
                        Ingredient.of(ItemRegistry.PYRIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.PYRIUM_HELMET.get())
                .unlocks("has_pyrium_ingot", has(ItemRegistry.PYRIUM_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/pyrium/pyrium_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(Items.NETHERITE_CHESTPLATE),
                        Ingredient.of(ItemRegistry.PYRIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.PYRIUM_CHESTPLATE.get())
                .unlocks("has_pyrium_ingot", has(ItemRegistry.PYRIUM_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/pyrium/pyrium_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(Items.NETHERITE_LEGGINGS),
                        Ingredient.of(ItemRegistry.PYRIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.PYRIUM_LEGGINGS.get())
                .unlocks("has_pyrium_ingot", has(ItemRegistry.PYRIUM_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/pyrium/pyrium_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(Items.NETHERITE_BOOTS),
                        Ingredient.of(ItemRegistry.PYRIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.PYRIUM_BOOTS.get())
                .unlocks("has_pyrium_ingot", has(ItemRegistry.PYRIUM_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/pyrium/pyrium_boots"));


        //Pyrium Battlemage Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(ItemRegistry.NETHERITE_MAGE_HELMET.get()),
                        Ingredient.of(ItemRegistry.PYRIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.PYRIUM_BATTLEMAGE_HELMET.get())
                .unlocks("has_pyrium_ingot", has(ItemRegistry.PYRIUM_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/pyrium_battlemage/pyrium_battlemage_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(ItemRegistry.NETHERITE_MAGE_CHESTPLATE.get()),
                        Ingredient.of(ItemRegistry.PYRIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.PYRIUM_BATTLEMAGE_CHESTPLATE.get())
                .unlocks("has_pyrium_ingot", has(ItemRegistry.PYRIUM_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/pyrium_battlemage/pyrium_battlemage_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(ItemRegistry.NETHERITE_MAGE_LEGGINGS.get()),
                        Ingredient.of(ItemRegistry.PYRIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.PYRIUM_BATTLEMAGE_LEGGINGS.get())
                .unlocks("has_pyrium_ingot", has(ItemRegistry.PYRIUM_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/pyrium_battlemage/pyrium_battlemage_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(ItemRegistry.NETHERITE_MAGE_BOOTS.get()),
                        Ingredient.of(ItemRegistry.PYRIUM_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.PYRIUM_BATTLEMAGE_BOOTS.get())
                .unlocks("has_pyrium_ingot", has(ItemRegistry.PYRIUM_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/pyrium_battlemage/pyrium_battlemage_boots"));


        //Legionnaire Ruler Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.PYRIUM_NUGGET.get()),
                        Ingredient.of(HnSItems.PYRIUM_HELMET.get()),
                        Ingredient.of(ItemRegistry.MAGIC_CLOTH.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.LEGIONNAIRE_RULER_HELMET.get())
                .unlocks("has_pyrium_nugget", has(HnSItems.PYRIUM_NUGGET.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/legionnaire_ruler/legionnaire_ruler_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.PYRIUM_NUGGET.get()),
                        Ingredient.of(HnSItems.PYRIUM_CHESTPLATE.get()),
                        Ingredient.of(ItemRegistry.MAGIC_CLOTH.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.LEGIONNAIRE_RULER_CHESTPLATE.get())
                .unlocks("has_pyrium_nugget", has(HnSItems.PYRIUM_NUGGET.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/legionnaire_ruler/legionnaire_ruler_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.PYRIUM_NUGGET.get()),
                        Ingredient.of(HnSItems.PYRIUM_LEGGINGS.get()),
                        Ingredient.of(ItemRegistry.MAGIC_CLOTH.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.LEGIONNAIRE_RULER_LEGGINGS.get())
                .unlocks("has_pyrium_nugget", has(HnSItems.PYRIUM_NUGGET.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/legionnaire_ruler/legionnaire_ruler_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.PYRIUM_NUGGET.get()),
                        Ingredient.of(HnSItems.PYRIUM_BOOTS.get()),
                        Ingredient.of(ItemRegistry.MAGIC_CLOTH.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.LEGIONNAIRE_RULER_BOOTS.get())
                .unlocks("has_pyrium_nugget", has(HnSItems.PYRIUM_NUGGET.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/legionnaire_ruler/legionnaire_ruler_boots"));


        //Legionnaire Commander Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.PYRIUM_NUGGET.get()),
                        Ingredient.of(HnSItems.PYRIUM_HELMET.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.LEGIONNAIRE_COMMANDER_HELMET.get())
                .unlocks("has_pyrium_nugget", has(HnSItems.PYRIUM_NUGGET.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/legionnaire_commander/legionnaire_commander_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.PYRIUM_NUGGET.get()),
                        Ingredient.of(HnSItems.PYRIUM_CHESTPLATE.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.LEGIONNAIRE_COMMANDER_CHESTPLATE.get())
                .unlocks("has_pyrium_nugget", has(HnSItems.PYRIUM_NUGGET.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/legionnaire_commander/legionnaire_commander_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.PYRIUM_NUGGET.get()),
                        Ingredient.of(HnSItems.PYRIUM_LEGGINGS.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.LEGIONNAIRE_COMMANDER_LEGGINGS.get())
                .unlocks("has_pyrium_nugget", has(HnSItems.PYRIUM_NUGGET.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/legionnaire_commander/legionnaire_commander_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.PYRIUM_NUGGET.get()),
                        Ingredient.of(HnSItems.PYRIUM_BOOTS.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.LEGIONNAIRE_COMMANDER_BOOTS.get())
                .unlocks("has_pyrium_nugget", has(HnSItems.PYRIUM_NUGGET.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/legionnaire_commander/legionnaire_commander_boots"));


        //Soul Legionnaire Commander Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(HnSItems.LEGIONNAIRE_COMMANDER_HELMET.get()),
                        Ingredient.of(ItemRegistry.CINDER_ESSENCE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.SOUL_LEGIONNAIRE_RULER_HELMET.get())
                .unlocks("has_timeless_slurry", has(ItemRegistry.TIMELESS_SLURRY.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/legionnaire_ruler/soul_legionnaire_ruler_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(HnSItems.LEGIONNAIRE_COMMANDER_CHESTPLATE.get()),
                        Ingredient.of(ItemRegistry.CINDER_ESSENCE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.SOUL_LEGIONNAIRE_RULER_CHESTPLATE.get())
                .unlocks("has_timeless_slurry", has(ItemRegistry.TIMELESS_SLURRY.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/legionnaire_ruler/soul_legionnaire_ruler_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(HnSItems.LEGIONNAIRE_COMMANDER_LEGGINGS.get()),
                        Ingredient.of(ItemRegistry.CINDER_ESSENCE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.SOUL_LEGIONNAIRE_RULER_LEGGINGS.get())
                .unlocks("has_timeless_slurry", has(ItemRegistry.TIMELESS_SLURRY.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/legionnaire_ruler/soul_legionnaire_ruler_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(HnSItems.LEGIONNAIRE_COMMANDER_BOOTS.get()),
                        Ingredient.of(ItemRegistry.CINDER_ESSENCE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.SOUL_LEGIONNAIRE_RULER_BOOTS.get())
                .unlocks("has_timeless_slurry", has(ItemRegistry.TIMELESS_SLURRY.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/legionnaire_ruler/soul_legionnaire_ruler_boots"));


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
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/tyros/tyros_helmet"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.TYROS_CHESTPLATE.get())
                .pattern("TPT")
                .pattern("RMR")
                .pattern("TTT")
                .define('T', HnSItems.CLOTH_OF_THE_FLAMEBEARER.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .define('M', HnSItems.FLAMING_TEMPLATE.get())
                .define('P', HnSItems.BLAZEBORNE_CHESTPLATE.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/tyros/tyros_chestplate"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.TYROS_LEGGINGS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("T T")
                .define('T', HnSItems.CLOTH_OF_THE_FLAMEBEARER.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .define('M', HnSItems.FLAMING_TEMPLATE.get())
                .define('P', HnSItems.BLAZEBORNE_LEGGINGS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/tyros/tyros_leggings"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HnSItems.TYROS_BOOTS.get())
                .pattern("RMR")
                .pattern("TPT")
                .pattern("   ")
                .define('T', HnSItems.CLOTH_OF_THE_FLAMEBEARER.get())
                .define('R', ItemRegistry.FIRE_RUNE.get())
                .define('M', HnSItems.FLAMING_TEMPLATE.get())
                .define('P', HnSItems.BLAZEBORNE_BOOTS.get())
                .unlockedBy("has_zenalite_ingot", has(HnSItems.ZENALITE_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crafting/armor/tyros/tyros_boots"));


        //Soul Legionnaire Commander Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(HnSItems.TYROS_HELMET.get()),
                        Ingredient.of(ItemRegistry.CINDER_ESSENCE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.TYROS_SOUL_HELMET.get())
                .unlocks("has_timeless_slurry", has(ItemRegistry.TIMELESS_SLURRY.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/tyros/tyros_soul_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(HnSItems.TYROS_CHESTPLATE.get()),
                        Ingredient.of(ItemRegistry.CINDER_ESSENCE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.TYROS_SOUL_CHESTPLATE.get())
                .unlocks("has_timeless_slurry", has(ItemRegistry.TIMELESS_SLURRY.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/tyros/tyros_soul_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(HnSItems.TYROS_LEGGINGS.get()),
                        Ingredient.of(ItemRegistry.CINDER_ESSENCE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.TYROS_SOUL_LEGGINGS.get())
                .unlocks("has_timeless_slurry", has(ItemRegistry.TIMELESS_SLURRY.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/tyros/tyros_soul_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.TIMELESS_SLURRY.get()),
                        Ingredient.of(HnSItems.TYROS_BOOTS.get()),
                        Ingredient.of(ItemRegistry.CINDER_ESSENCE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.TYROS_SOUL_BOOTS.get())
                .unlocks("has_timeless_slurry", has(ItemRegistry.TIMELESS_SLURRY.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/tyros/tyros_soul_boots"));


        // Armor Upgrading (Smithing Table)


        //Soul Flame Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.FLAMING_TEMPLATE.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_HELMET.get()),
                        Ingredient.of(Items.SOUL_SAND),
                        RecipeCategory.COMBAT,
                        HnSItems.SOUL_FLAME_HELMET.get())
                .unlocks("has_flaming_template", has(HnSItems.FLAMING_TEMPLATE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/soul_flame/soul_flame_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.FLAMING_TEMPLATE.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_CHESTPLATE.get()),
                        Ingredient.of(Items.SOUL_SAND),
                        RecipeCategory.COMBAT,
                        HnSItems.SOUL_FLAME_CHESTPLATE.get())
                .unlocks("has_flaming_template", has(HnSItems.FLAMING_TEMPLATE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/soul_flame/soul_flame_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.FLAMING_TEMPLATE.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_LEGGINGS.get()),
                        Ingredient.of(Items.SOUL_SAND),
                        RecipeCategory.COMBAT,
                        HnSItems.SOUL_FLAME_LEGGINGS.get())
                .unlocks("has_flaming_template", has(HnSItems.FLAMING_TEMPLATE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/soul_flame/soul_flame_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.FLAMING_TEMPLATE.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_BOOTS.get()),
                        Ingredient.of(Items.SOUL_SAND),
                        RecipeCategory.COMBAT,
                        HnSItems.SOUL_FLAME_BOOTS.get())
                .unlocks("has_flaming_template", has(HnSItems.FLAMING_TEMPLATE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/soul_flame/soul_flame_boots"));


        //Fireblossom Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.FLAMING_TEMPLATE.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_HELMET.get()),
                        Ingredient.of(HnSBlocks.FIREBLOSSOM.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .unlocks("has_flaming_template", has(HnSItems.FLAMING_TEMPLATE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/fireblossom_battlemage/fireblossom_battlemage_crown"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.FLAMING_TEMPLATE.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_CHESTPLATE.get()),
                        Ingredient.of(HnSBlocks.FIREBLOSSOM.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .unlocks("has_flaming_template", has(HnSItems.FLAMING_TEMPLATE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/fireblossom_battlemage/fireblossom_battlemage_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.FLAMING_TEMPLATE.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_LEGGINGS.get()),
                        Ingredient.of(HnSBlocks.FIREBLOSSOM.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .unlocks("has_flaming_template", has(HnSItems.FLAMING_TEMPLATE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/fireblossom_battlemage/fireblossom_battlemage_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.FLAMING_TEMPLATE.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_BOOTS.get()),
                        Ingredient.of(HnSBlocks.FIREBLOSSOM.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())
                .unlocks("has_flaming_template", has(HnSItems.FLAMING_TEMPLATE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/fireblossom_battlemage/fireblossom_battlemage_boots"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.FLAMING_TEMPLATE.get()),
                        Ingredient.of(HnSItems.FIREBLOSSOM_BATTLEMAGE_CROWN.get()),
                        Ingredient.of(Items.GOLD_INGOT),
                        RecipeCategory.COMBAT,
                        HnSItems.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .unlocks("has_flaming_template", has(HnSItems.FLAMING_TEMPLATE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/fireblossom_battlemage/convert_fireblossom_battlemage_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.FLAMING_TEMPLATE.get()),
                        Ingredient.of(HnSItems.FIREBLOSSOM_BATTLEMAGE_HELMET.get()),
                        Ingredient.of(HnSBlocks.FIREBLOSSOM.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .unlocks("has_flaming_template", has(HnSItems.FLAMING_TEMPLATE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/fireblossom_battlemage/convert_fireblossom_battlemage_crown"));


        //Calamitas Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_HELMET.get()),
                        Ingredient.of(HnSItems.FLESH_MASS_HELMET.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.CALAMITAS_HELMET.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/calamitas/calamitas_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_CHESTPLATE.get()),
                        Ingredient.of(HnSItems.FLESH_MASS_CHESTPLATE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.CALAMITAS_CHESTPLATE.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/calamitas/calamitas_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_LEGGINGS.get()),
                        Ingredient.of(HnSItems.FLESH_MASS_LEGGINGS.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.CALAMITAS_LEGGINGS.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/calamitas/calamitas_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_BOOTS.get()),
                        Ingredient.of(HnSItems.FLESH_MASS_BOOTS.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.CALAMITAS_BOOTS.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/calamitas/calamitas_boots"));


        //Ice Spider Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.ICE_VENOM_VIAL.get()),
                        Ingredient.of(HnSItems.CRYOGENIC_RULER_HELMET.get()),
                        Ingredient.of(ItemRegistry.ICY_FANG.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.CRYSTAL_ARACHNID_HELMET.get())
                .unlocks("has_ice_venom_vial", has(ItemRegistry.ICE_VENOM_VIAL.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/ice_spider/crystal_arachnic_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.ICE_VENOM_VIAL.get()),
                        Ingredient.of(HnSItems.CRYOGENIC_RULER_CHESTPLATE.get()),
                        Ingredient.of(ItemRegistry.ICY_FANG.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.CRYSTAL_ARACHNID_CHESTPLATE.get())
                .unlocks("has_ice_venom_vial", has(ItemRegistry.ICE_VENOM_VIAL.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/ice_spider/crystal_arachnic_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.ICE_VENOM_VIAL.get()),
                        Ingredient.of(HnSItems.CRYOGENIC_RULER_LEGGINGS.get()),
                        Ingredient.of(ItemRegistry.ICY_FANG.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.CRYSTAL_ARACHNID_LEGGINGS.get())
                .unlocks("has_ice_venom_vial", has(ItemRegistry.ICE_VENOM_VIAL.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/ice_spider/crystal_arachnic_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.ICE_VENOM_VIAL.get()),
                        Ingredient.of(HnSItems.CRYOGENIC_RULER_BOOTS.get()),
                        Ingredient.of(ItemRegistry.ICY_FANG.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.CRYSTAL_ARACHNID_BOOTS.get())
                .unlocks("has_ice_venom_vial", has(ItemRegistry.ICE_VENOM_VIAL.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/ice_spider/crystal_arachnic_boots"));


        //The Wither Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.WITHER_SKELETON_SKULL),
                        Ingredient.of(HnSItems.FLESH_MASS_HELMET.get()),
                        Ingredient.of(ItemRegistry.BLOODY_VELLUM.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.THE_WITHER_HELMET.get())
                .unlocks("has_wither_skull", has(Items.WITHER_SKELETON_SKULL))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/the_wither/the_wither_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.WITHER_SKELETON_SKULL),
                        Ingredient.of(HnSItems.FLESH_MASS_CHESTPLATE.get()),
                        Ingredient.of(ItemRegistry.BLOODY_VELLUM.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.THE_WITHER_CHESTPLATE.get())
                .unlocks("has_wither_skull", has(Items.WITHER_SKELETON_SKULL))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/the_wither/the_wither_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.WITHER_SKELETON_SKULL),
                        Ingredient.of(HnSItems.FLESH_MASS_LEGGINGS.get()),
                        Ingredient.of(ItemRegistry.BLOODY_VELLUM.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.THE_WITHER_LEGGINGS.get())
                .unlocks("has_wither_skull", has(Items.WITHER_SKELETON_SKULL))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/the_wither/the_wither_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.WITHER_SKELETON_SKULL),
                        Ingredient.of(HnSItems.FLESH_MASS_BOOTS.get()),
                        Ingredient.of(ItemRegistry.BLOODY_VELLUM.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.THE_WITHER_BOOTS.get())
                .unlocks("has_wither_skull", has(Items.WITHER_SKELETON_SKULL))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/the_wither/the_wither_boots"));


        //Mothic Witch Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.HOLY_RUNE.get()),
                        Ingredient.of(HnSItems.SERAPH_HELMET.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.MOTHIC_WITCH_HELMET.get())
                .unlocks("has_holy_rune", has(ItemRegistry.HOLY_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/mothic_witch/mothic_witch_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.HOLY_RUNE.get()),
                        Ingredient.of(HnSItems.SERAPH_CHESTPLATE.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.MOTHIC_WITCH_CHESTPLATE.get())
                .unlocks("has_holy_rune", has(ItemRegistry.HOLY_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/mothic_witch/mothic_witch_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.HOLY_RUNE.get()),
                        Ingredient.of(HnSItems.SERAPH_LEGGINGS.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.MOTHIC_WITCH_LEGGINGS.get())
                .unlocks("has_holy_rune", has(ItemRegistry.HOLY_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/mothic_witch/mothic_witch_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.HOLY_RUNE.get()),
                        Ingredient.of(HnSItems.SERAPH_BOOTS.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.MOTHIC_WITCH_BOOTS.get())
                .unlocks("has_holy_rune", has(ItemRegistry.HOLY_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/mothic_witch/mothic_witch_boots"));


        //Hazel Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_HELMET.get()),
                        Ingredient.of(Items.LEATHER),
                        RecipeCategory.COMBAT,
                        HnSItems.HAZEL_HELMET.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/hazel/hazel_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_CHESTPLATE.get()),
                        Ingredient.of(Items.LEATHER),
                        RecipeCategory.COMBAT,
                        HnSItems.HAZEL_CHESTPLATE.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/hazel/hazel_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_LEGGINGS.get()),
                        Ingredient.of(Items.LEATHER),
                        RecipeCategory.COMBAT,
                        HnSItems.HAZEL_LEGGINGS.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/hazel/hazel_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSItems.BLAZEBORNE_BOOTS.get()),
                        Ingredient.of(Items.LEATHER),
                        RecipeCategory.COMBAT,
                        HnSItems.HAZEL_BOOTS.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/hazel/hazel_boots"));


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.LEATHER),
                        Ingredient.of(HnSItems.HAZEL_CHESTPLATE.get()),
                        Ingredient.of(Items.MELON),
                        RecipeCategory.COMBAT,
                        HnSItems.HAZEL_HOLY_MOLLY_CHESTPLATE.get())
                .unlocks("has_melon", has(Items.MELON))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/hazel/hazel_secret_chestplate"));


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(Items.LEATHER),
                        Ingredient.of(HnSItems.MOTHIC_WITCH_CHESTPLATE.get()),
                        Ingredient.of(Items.MELON),
                        RecipeCategory.COMBAT,
                        HnSItems.MOTHIC_WITCH_SECRET_CHESTPLATE.get())
                .unlocks("has_melon", has(Items.MELON))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/mothic_witch/mothic_witch_secret_chestplate"));


        //Mycelium Guardian Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(ItemRegistry.NETHERITE_MAGE_HELMET.get()),
                        Ingredient.of(HnSItems.GLOWING_MUSHROOM.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.MYCELIUM_GUARDIAN_HELMET.get())
                .unlocks("has_glowing_mushroom", has(HnSItems.GLOWING_MUSHROOM.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/mycelium_guardian/mycelium_guardian_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(ItemRegistry.NETHERITE_MAGE_CHESTPLATE.get()),
                        Ingredient.of(HnSItems.GLOWING_MUSHROOM.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.MYCELIUM_GUARDIAN_CHESTPLATE.get())
                .unlocks("has_glowing_mushroom", has(HnSItems.GLOWING_MUSHROOM.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/mycelium_guardian/mycelium_guardian_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(ItemRegistry.NETHERITE_MAGE_LEGGINGS.get()),
                        Ingredient.of(HnSItems.GLOWING_MUSHROOM.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.MYCELIUM_GUARDIAN_LEGGINGS.get())
                .unlocks("has_glowing_mushroom", has(HnSItems.GLOWING_MUSHROOM.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/mycelium_guardian/mycelium_guardian_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(ItemRegistry.NETHERITE_MAGE_BOOTS.get()),
                        Ingredient.of(HnSItems.GLOWING_MUSHROOM.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.MYCELIUM_GUARDIAN_BOOTS.get())
                .unlocks("has_glowing_mushroom", has(HnSItems.GLOWING_MUSHROOM.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/mycelium_guardian/mycelium_guardian_boots"));


        //Abberant Predator Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.SHADOW_RUNE.get()),
                        Ingredient.of(HnSItems.INFESTATION_HELMET.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.ABBERANT_PREDATOR_HELMET.get())
                .unlocks("has_shadow_rune", has(HnSItems.SHADOW_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/abberant_predator/abberant_predator_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.SHADOW_RUNE.get()),
                        Ingredient.of(HnSItems.INFESTATION_CHESTPLATE.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.ABBERANT_PREDATOR_CHESTPLATE.get())
                .unlocks("has_shadow_rune", has(HnSItems.SHADOW_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/abberant_predator/abberant_predator_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.SHADOW_RUNE.get()),
                        Ingredient.of(HnSItems.INFESTATION_LEGGINGS.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.ABBERANT_PREDATOR_LEGGINGS.get())
                .unlocks("has_shadow_rune", has(HnSItems.SHADOW_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/abberant_predator/abberant_predator_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.SHADOW_RUNE.get()),
                        Ingredient.of(HnSItems.INFESTATION_BOOTS.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.ABBERANT_PREDATOR_BOOTS.get())
                .unlocks("has_shadow_rune", has(HnSItems.SHADOW_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/abberant_predator/abberant_predator_boots"));


        //SLC!Cat Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.HOLY_RUNE.get()),
                        Ingredient.of(HnSItems.SERAPH_HELMET.get()),
                        Ingredient.of(ItemRegistry.ARCANE_ESSENCE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.SLC_CAT_HELMET.get())
                .unlocks("has_holy_rune", has(ItemRegistry.HOLY_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/slc_cat/slc_cat_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.HOLY_RUNE.get()),
                        Ingredient.of(HnSItems.SERAPH_CHESTPLATE.get()),
                        Ingredient.of(ItemRegistry.ARCANE_ESSENCE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.SLC_CAT_CHESTPLATE.get())
                .unlocks("has_holy_rune", has(ItemRegistry.HOLY_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/slc_cat/slc_cat_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.HOLY_RUNE.get()),
                        Ingredient.of(HnSItems.SERAPH_LEGGINGS.get()),
                        Ingredient.of(ItemRegistry.ARCANE_ESSENCE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.SLC_CAT_LEGGINGS.get())
                .unlocks("has_holy_rune", has(ItemRegistry.HOLY_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/slc_cat/slc_cat_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.HOLY_RUNE.get()),
                        Ingredient.of(HnSItems.SERAPH_BOOTS.get()),
                        Ingredient.of(ItemRegistry.ARCANE_ESSENCE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.SLC_CAT_BOOTS.get())
                .unlocks("has_holy_rune", has(ItemRegistry.HOLY_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/slc_cat/slc_cat_boots"));


        //Maverick Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.HOLY_RUNE.get()),
                        Ingredient.of(HnSItems.SERAPH_HELMET.get()),
                        Ingredient.of(Items.VINE),
                        RecipeCategory.COMBAT,
                        HnSItems.MAVERICK_HELMET.get())
                .unlocks("has_holy_rune", has(ItemRegistry.HOLY_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/maverick/maverick_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.HOLY_RUNE.get()),
                        Ingredient.of(HnSItems.SERAPH_CHESTPLATE.get()),
                        Ingredient.of(Items.VINE),
                        RecipeCategory.COMBAT,
                        HnSItems.MAVERICK_CHESTPLATE.get())
                .unlocks("has_holy_rune", has(ItemRegistry.HOLY_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/maverick/maverick_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.HOLY_RUNE.get()),
                        Ingredient.of(HnSItems.SERAPH_LEGGINGS.get()),
                        Ingredient.of(Items.VINE),
                        RecipeCategory.COMBAT,
                        HnSItems.MAVERICK_LEGGINGS.get())
                .unlocks("has_holy_rune", has(ItemRegistry.HOLY_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/maverick/maverick_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.HOLY_RUNE.get()),
                        Ingredient.of(HnSItems.SERAPH_BOOTS.get()),
                        Ingredient.of(Items.VINE),
                        RecipeCategory.COMBAT,
                        HnSItems.MAVERICK_BOOTS.get())
                .unlocks("has_holy_rune", has(ItemRegistry.HOLY_RUNE.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/maverick/maverick_boots"));


        //Mithril Battlemage Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.MANA_RUNE.get()),
                        Ingredient.of(ItemRegistry.NETHERITE_MAGE_HELMET.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.MITHRIL_BATTLEMAGE_HELMET.get())
                .unlocks("has_mithril_ingot", has(ItemRegistry.PYRIUM_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/mithril_battlemage/mithril_battlemage_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.MANA_RUNE.get()),
                        Ingredient.of(ItemRegistry.NETHERITE_MAGE_CHESTPLATE.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.MITHRIL_BATTLEMAGE_CHESTPLATE.get())
                .unlocks("has_mithril_ingot", has(ItemRegistry.PYRIUM_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/mithril_battlemage/mithril_battlemage_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.MANA_RUNE.get()),
                        Ingredient.of(ItemRegistry.NETHERITE_MAGE_LEGGINGS.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.MITHRIL_BATTLEMAGE_LEGGINGS.get())
                .unlocks("has_mithril_ingot", has(ItemRegistry.MITHRIL_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/mithril_battlemage/mithril_battlemage_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.MANA_RUNE.get()),
                        Ingredient.of(ItemRegistry.NETHERITE_MAGE_BOOTS.get()),
                        Ingredient.of(ItemRegistry.MITHRIL_INGOT.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.MITHRIL_BATTLEMAGE_BOOTS.get())
                .unlocks("has_mithril_ingot", has(ItemRegistry.MITHRIL_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/mithril_battlemage/mithril_battlemage_boots"));


        //Magehunter Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.MITHRIL_INGOT.get()),
                        Ingredient.of(ItemRegistry.WIZARD_HELMET.get()),
                        Ingredient.of(HnSItems.SILVER_SCRAPS.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.MAGEHUNTER_HELMET.get())
                .unlocks("has_silver_scraps", has(HnSItems.SILVER_SCRAPS.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/magehunter/magehunter_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.MITHRIL_INGOT.get()),
                        Ingredient.of(ItemRegistry.WIZARD_CHESTPLATE.get()),
                        Ingredient.of(HnSItems.SILVER_SCRAPS.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.MAGEHUNTER_CHESTPLATE.get())
                .unlocks("has_silver_scraps", has(HnSItems.SILVER_SCRAPS.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/magehunter/magehunter_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.MITHRIL_INGOT.get()),
                        Ingredient.of(ItemRegistry.WIZARD_LEGGINGS.get()),
                        Ingredient.of(HnSItems.SILVER_SCRAPS.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.MAGEHUNTER_LEGGINGS.get())
                .unlocks("has_mithril_ingot", has(ItemRegistry.MITHRIL_INGOT.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/magehunter/magehunter_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ItemRegistry.MITHRIL_INGOT.get()),
                        Ingredient.of(ItemRegistry.WIZARD_BOOTS.get()),
                        Ingredient.of(HnSItems.SILVER_SCRAPS.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.MAGEHUNTER_BOOTS.get())
                .unlocks("has_silver_scraps", has(HnSItems.SILVER_SCRAPS.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/magehunter/magehunter_boots"));


        //Arbitrium Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSTags.PURE_HELMET),
                        Ingredient.of(ItemRegistry.ARCANE_ESSENCE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.ARBITRIUM_ROBES_HELMET.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/arbitrium_robes/arbitrium_robes_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSTags.PURE_CHESTPLATE),
                        Ingredient.of(ItemRegistry.ARCANE_ESSENCE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.ARBITRIUM_ROBES_CHESTPLATE.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/arbitrium_robes/arbitrium_robes_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSTags.PURE_LEGGINGS),
                        Ingredient.of(ItemRegistry.ARCANE_ESSENCE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.ARBITRIUM_ROBES_LEGGINGS.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/arbitrium_robes/arbitrium_robes_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSTags.PURE_BOOTS),
                        Ingredient.of(ItemRegistry.ARCANE_ESSENCE.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.ARBITRIUM_ROBES_BOOTS.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/arbitrium_robes/arbitrium_robes_boots"));


        //Iron431 Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSTags.PURE_HELMET),
                        Ingredient.of(Items.IRON_INGOT),
                        RecipeCategory.COMBAT,
                        HnSItems.IRON431_HELMET.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/iron431/iron431_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSTags.PURE_CHESTPLATE),
                        Ingredient.of(Items.IRON_INGOT),
                        RecipeCategory.COMBAT,
                        HnSItems.IRON431_CHESTPLATE.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/iron431/iron431_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSTags.PURE_LEGGINGS),
                        Ingredient.of(Items.IRON_INGOT),
                        RecipeCategory.COMBAT,
                        HnSItems.IRON431_LEGGINGS.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/iron431/iron431_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSTags.PURE_BOOTS),
                        Ingredient.of(Items.IRON_INGOT),
                        RecipeCategory.COMBAT,
                        HnSItems.IRON431_BOOTS.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/iron431/iron431_boots"));


        //Arbitrium Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSTags.PURE_HELMET),
                        Ingredient.of(HnSItems.RUNESTONE_FRAGMENTS.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.SACRED_ROBES_HELMET.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/sacred_robes/sacred_robes_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSTags.PURE_CHESTPLATE),
                        Ingredient.of(HnSItems.RUNESTONE_FRAGMENTS.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.SACRED_ROBES_CHESTPLATE.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/sacred_robes/sacred_robes_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSTags.PURE_LEGGINGS),
                        Ingredient.of(HnSItems.RUNESTONE_FRAGMENTS.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.SACRED_ROBES_LEGGINGS.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/sacred_robes/sacred_robes_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSTags.PURE_BOOTS),
                        Ingredient.of(HnSItems.RUNESTONE_FRAGMENTS.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.SACRED_ROBES_BOOTS.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/sacred_robes/sacred_robes_boots"));


        //Lemon God Armor
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSTags.PURE_HELMET),
                        Ingredient.of(HnSItems.DIVINE_LEMON.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.LEMON_GOD_HELMET.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/lemon_god/lemon_god_helmet"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSTags.PURE_CHESTPLATE),
                        Ingredient.of(HnSItems.DIVINE_LEMON.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.LEMON_GOD_CHESTPLATE.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/lemon_god/lemon_god_chestplate"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSTags.PURE_LEGGINGS),
                        Ingredient.of(HnSItems.DIVINE_LEMON.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.LEMON_GOD_LEGGINGS.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/lemon_god/lemon_god_leggings"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(HnSItems.DIVINE_MOLD.get()),
                        Ingredient.of(HnSTags.PURE_BOOTS),
                        Ingredient.of(HnSItems.DIVINE_LEMON.get()),
                        RecipeCategory.COMBAT,
                        HnSItems.LEMON_GOD_BOOTS.get())
                .unlocks("has_divine_mold", has(HnSItems.DIVINE_MOLD.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "smithing/armor/lemon_god/lemon_god_boots"));




        //Shapeless recipes -------------------------------------------------------------------------------------------------------------------------------------------+

//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, HnSItems.ZENALITE_INGOT.get(), 9)
//                .requires(HnSItems.HnSBlocks.ZENALITE_BLOCK)
//                .unlockedBy("has_tungsten_block",
//                has(HnSItems.HnSBlocks.TUNGSTENBLOCK))

        //Smelting Recipes -----------------------------------------------------------------------------------------------------------------------------------------------

        List<ItemLike> CHLOROPHYTE_SMELTABLES = List.of(
                HnSItems.CHLOROPHYTE_CHUNK);
        List<ItemLike> STEEL_SMELTABLES = List.of(
                HnSItems.CRUDE_METAL);
        List<ItemLike> DEMONITE_SMELTABLES = List.of(
                HnSItems.SHADESTONE);
        List<ItemLike> DREADSTONE_ORE_SMELTABLES = List.of(
                HnSBlocks.DREADSTONE_ORE);
        List<ItemLike> CHLOROPHYTE_ORE_SMELTABLES = List.of(
                HnSBlocks.CHLOROPHYTE_ORE);
        List<ItemLike> SOLAR_CORE_ORE_SMELTABLES = List.of(
                HnSBlocks.SOLAR_CORE_NETHERACK_ORE,
                HnSBlocks.SOLAR_CORE_BLACKSTONE_ORE
                );

        oreSmelting(recipeOutput,
                CHLOROPHYTE_SMELTABLES,
                RecipeCategory.MISC,
                HnSItems.CHLOROPHYTE_INGOT.get(),
                0.25f,
                200,
                "chlorophyte_ingot");

        oreBlasting(recipeOutput,
                CHLOROPHYTE_SMELTABLES,
                RecipeCategory.MISC,
                HnSItems.CHLOROPHYTE_INGOT.get(),
                0.25f,
                100,
                "chlorophyte_ingot");

        oreSmelting(recipeOutput,
                DEMONITE_SMELTABLES,
                RecipeCategory.MISC,
                HnSItems.DEMONITE_INGOT.get(),
                0.25f,
                200,
                "demonite_ingot");

        oreBlasting(recipeOutput,
                DEMONITE_SMELTABLES,
                RecipeCategory.MISC,
                HnSItems.DEMONITE_INGOT.get(),
                0.25f,
                100,
                "demonite_ingot");

        oreSmelting(recipeOutput,
                STEEL_SMELTABLES,
                RecipeCategory.MISC,
                HnSItems.STEEL_INGOT.get(),
                0.25f,
                200,
                "steel_ingot");

        oreBlasting(recipeOutput,
                STEEL_SMELTABLES,
                RecipeCategory.MISC,
                HnSItems.STEEL_INGOT.get(),
                0.25f,
                100,
                "steel_ingot");

        oreSmelting(recipeOutput,
                DREADSTONE_ORE_SMELTABLES,
                RecipeCategory.MISC,
                HnSItems.DREADSTONE.get(),
                0.25f,
                200,
                "dreadstone");

        oreBlasting(recipeOutput,
                DREADSTONE_ORE_SMELTABLES,
                RecipeCategory.MISC,
                HnSItems.DREADSTONE.get(),
                0.25f,
                100,
                "dreadstone");

        oreSmelting(recipeOutput,
                CHLOROPHYTE_ORE_SMELTABLES,
                RecipeCategory.MISC,
                HnSItems.CHLOROPHYTE_CHUNK.get(),
                0.25f,
                200,
                "chlorophyte_chunk");

        oreBlasting(recipeOutput,
                CHLOROPHYTE_ORE_SMELTABLES,
                RecipeCategory.MISC,
                HnSItems.CHLOROPHYTE_CHUNK.get(),
                0.25f,
                100,
                "chlorophyte_chunk");

        oreSmelting(recipeOutput,
                SOLAR_CORE_ORE_SMELTABLES,
                RecipeCategory.MISC,
                HnSItems.SOLAR_CORE.get(),
                0.25f,
                200,
                "solar_core");

        oreBlasting(recipeOutput,
                SOLAR_CORE_ORE_SMELTABLES,
                RecipeCategory.MISC,
                HnSItems.SOLAR_CORE.get(),
                0.25f,
                100,
                "solar_core");


    }
}