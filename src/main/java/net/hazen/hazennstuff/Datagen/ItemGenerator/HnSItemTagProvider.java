package net.hazen.hazennstuff.Datagen.ItemGenerator;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import io.redspace.ironsspellbooks.util.ModTags;
import net.hazen.hazennstuff.Item.Block.HnSBlocks;
import net.hazen.hazennstuff.Datagen.HnSTags;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.HnSItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class HnSItemTagProvider extends ItemTagsProvider {
    public HnSItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, HazenNStuff.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        //Ores and Ingots
        tag(Tags.Items.INGOTS)
                .add(HnSItemRegistry.ZENALITE_INGOT.get())
                .add(HnSItemRegistry.STEEL_INGOT.get())
                .add(HnSItemRegistry.ROSE_GOLD_INGOT.get())
                .add(HnSItemRegistry.DREADSTEEL_INGOT.get())
                .add(HnSItemRegistry.CHLOROPHYTE_INGOT.get())
                .add(HnSItemRegistry.HALLOWED_INGOT.get())
                .add(HnSItemRegistry.DEMONITE_INGOT.get())
        ;

        tag(Tags.Items.NUGGETS)
                .add(HnSItemRegistry.PYRIUM_NUGGET.get())
                .add(HnSItemRegistry.STEEL_NUGGET.get())
        ;

        tag(Tags.Items.ORES)

                .add(HnSItemRegistry.RAW_ZENALITE.get())
                .add(HnSItemRegistry.CHLOROPHYTE_CHUNK.get())
                .add(HnSItemRegistry.DREADSTONE.get())
                .add(HnSItemRegistry.SOLAR_CORE.get())
                .add(HnSItemRegistry.ROSE_QUARTZ.get())

        ;

        tag(Tags.Items.RAW_MATERIALS)

                .add(HnSItemRegistry.RAW_ZENALITE.get())
                .add(HnSItemRegistry.CHLOROPHYTE_CHUNK.get())
                .add(HnSItemRegistry.DREADSTONE.get())
                .add(HnSItemRegistry.CRUDE_METAL.get())

        ;

        tag(Tags.Items.GEMS)

                .add(HnSItemRegistry.SOLAR_CORE.get())
                .add(HnSItemRegistry.ROSE_QUARTZ.get())

        ;

        tag(Tags.Items.GEMS_QUARTZ)

                .add(HnSItemRegistry.ROSE_QUARTZ.get())

        ;

        tag(HnSTags.ZENALITE)

                .add(HnSItemRegistry.RAW_ZENALITE.get())
                .add(HnSItemRegistry.STARKISSED_ZENALITE.get())

        ;

        tag(HnSTags.LIGHTNING_SHEATH)

                .add(HnSItemRegistry.GALVANIZED_SHEATH.get())

        ;

        tag(HnSTags.HARMONIOUS_EQUIPMENT)

                .add(HnSItemRegistry.PENDANT_OF_HARMONY.get())

        ;

        tag(HnSTags.CINDEROUS_EQUIPMENT)

                .add(HnSItemRegistry.TYROS_HELMET.get())
                .add(HnSItemRegistry.TYROS_CHESTPLATE.get())
                .add(HnSItemRegistry.TYROS_LEGGINGS.get())
                .add(HnSItemRegistry.TYROS_BOOTS.get())

                .add(HnSItemRegistry.TYROS_SOUL_HELMET.get())
                .add(HnSItemRegistry.TYROS_SOUL_CHESTPLATE.get())
                .add(HnSItemRegistry.TYROS_SOUL_LEGGINGS.get())
                .add(HnSItemRegistry.TYROS_SOUL_BOOTS.get())

                .add(HnSItemRegistry.SOULCALLING_SCEPTER.get())

                .add(HnSItemRegistry.BLADE_OF_THE_LEGATE.get())
                .add(HnSItemRegistry.THE_PREFECTS_RING.get())
                .add(HnSItemRegistry.THE_TRIBUNES_MEDALLION.get())

        ;

        tag(Tags.Items.FOODS)
                .add(HnSItemRegistry.LEMON.get())
                .add(HnSItemRegistry.DIVINE_LEMON.get())
                .add(HnSItemRegistry.CORN_BEEF.get())
                .add(HnSItemRegistry.FRIED_ICE_SPIDER_EGG.get())
        ;

        /*
        *** Armor Tags
         */

        tag(Tags.Items.ENCHANTABLES)
                .addTag(HnSTags.HNS_HELMET)
                .addTag(HnSTags.HNS_CHESTPLATE)
                .addTag(HnSTags.HNS_LEGGINGS)
                .addTag(HnSTags.HNS_BOOTS)

                /*
                *** Weapons
                 */

                //Fire
                .add(HnSItemRegistry.FIREBLOSSOM_RAPIER.get())
                .add(HnSItemRegistry.DRACONIC_SPLITTER.get())
                .add(HnSItemRegistry.FIREBRAND.get())
                .add(HnSItemRegistry.WARFLAMING_LANCE.get())
                .add(HnSItemRegistry.RAVENS_BANE.get())
                .add(HnSItemRegistry.VOLCANO.get())

                //Ice
                .add(HnSItemRegistry.ICE_PIKE.get())
                .add(HnSItemRegistry.FROSTBURN_DAGGER.get())

                //Lightning
                .add(HnSItemRegistry.BEONGAE.get())
                .add(HnSItemRegistry.SKYSCORCHER.get())
                .add(HnSItemRegistry.IONIC_SPLITTER_DORMANT.get())
                .add(HnSItemRegistry.IONIC_SPLITTER_T1.get())
                .add(HnSItemRegistry.IONIC_SPLITTER_T2.get())
                .add(HnSItemRegistry.IONIC_SPLITTER_T3.get())

                //Nature
                .add(HnSItemRegistry.BOUNTIFUL_HARVEST.get())
                .add(HnSItemRegistry.THORN_CHAKRAM.get())
                 .add(HnSItemRegistry.BLADE_OF_GRASS.get())

                //Blood
                .add(HnSItemRegistry.VAMPIRE_KNIVES.get())

                //Ender
                .add(HnSItemRegistry.OBSIDIAN_CLAYMORE.get())
                .add(HnSItemRegistry.STARFURY.get())

                //Radiance
                .add(HnSItemRegistry.SPECTRUM.get())
                .add(HnSItemRegistry.MEOWMERE.get())
                .add(HnSItemRegistry.HAMMUSH.get())

                //Shadow
                .add(HnSItemRegistry.SOUL_REAPER.get())
                .add(HnSItemRegistry.LIGHTS_BANE.get())
                .add(HnSItemRegistry.NIGHTS_EDGE.get())
                .add(HnSItemRegistry.TRUE_NIGHTS_EDGE.get())

                // Cosmic
                .add(HnSItemRegistry.ASTRALITE_CLEAVER.get())

                // Hydro
                .add(HnSItemRegistry.TIDAL_WAVE.get())

                //Holy
                .add(HnSItemRegistry.HAMMER_OF_JUSTICE.get())
                .add(HnSItemRegistry.DIVINE_GREATSWORD.get())
                .add(HnSItemRegistry.EXCALIBUR.get())
                .add(HnSItemRegistry.HAZENS_EXCALIBUR.get())
                .add(HnSItemRegistry.ISS_EXCALIBUR.get())

                //Evocation
                .add(HnSItemRegistry.MALICE.get())
                .add(HnSItemRegistry.ANCIENT_WARRIORS_AXE.get())

                //Eldritch
                .add(HnSItemRegistry.THE_DEVOURER.get())

                //Misc
                .add(HnSItemRegistry.MAGE_BANE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_WARLOCK_AXE.get())
                .add(HnSItemRegistry.MURAMASA.get())
                .add(HnSItemRegistry.DAWNMAKER.get())

                /*
                *** Tools
                */

                .add(HnSItemRegistry.SPECTRAL_PICKAXE.get())
                .add(HnSItemRegistry.PICKAXE_AXE.get())
                .add(HnSItemRegistry.PICKAXE_AXE_DIVINE_GOLD.get())
        ;

        tag(ItemTags.EQUIPPABLE_ENCHANTABLE)
                .addTag(HnSTags.HNS_HELMET)
                .addTag(HnSTags.HNS_CHESTPLATE)
                .addTag(HnSTags.HNS_LEGGINGS)
                .addTag(HnSTags.HNS_BOOTS)
        ;

        tag(ItemTags.DURABILITY_ENCHANTABLE)
                .addTag(HnSTags.HNS_HELMET)
                .addTag(HnSTags.HNS_CHESTPLATE)
                .addTag(HnSTags.HNS_LEGGINGS)
                .addTag(HnSTags.HNS_BOOTS)

                /*
                *** Weapons
                 */

                //Fire
                .add(HnSItemRegistry.FIREBLOSSOM_RAPIER.get())
                .add(HnSItemRegistry.DRACONIC_SPLITTER.get())
                .add(HnSItemRegistry.FIREBRAND.get())
                .add(HnSItemRegistry.WARFLAMING_LANCE.get())
                .add(HnSItemRegistry.RAVENS_BANE.get())
                .add(HnSItemRegistry.VOLCANO.get())

                //Ice
                .add(HnSItemRegistry.ICE_PIKE.get())
                .add(HnSItemRegistry.FROSTBURN_DAGGER.get())

                //Lightning
                .add(HnSItemRegistry.BEONGAE.get())
                .add(HnSItemRegistry.SKYSCORCHER.get())
                .add(HnSItemRegistry.IONIC_SPLITTER_DORMANT.get())
                .add(HnSItemRegistry.IONIC_SPLITTER_T1.get())
                .add(HnSItemRegistry.IONIC_SPLITTER_T2.get())
                .add(HnSItemRegistry.IONIC_SPLITTER_T3.get())

                //Nature
                .add(HnSItemRegistry.BOUNTIFUL_HARVEST.get())
                .add(HnSItemRegistry.THORN_CHAKRAM.get())
                 .add(HnSItemRegistry.BLADE_OF_GRASS.get())

                //Blood
                .add(HnSItemRegistry.VAMPIRE_KNIVES.get())

                //Ender
                .add(HnSItemRegistry.OBSIDIAN_CLAYMORE.get())
                .add(HnSItemRegistry.STARFURY.get())

                //Radiance
                .add(HnSItemRegistry.SPECTRUM.get())
                .add(HnSItemRegistry.MEOWMERE.get())
                .add(HnSItemRegistry.HAMMUSH.get())

                //Shadow
                .add(HnSItemRegistry.SOUL_REAPER.get())
                .add(HnSItemRegistry.LIGHTS_BANE.get())
                .add(HnSItemRegistry.NIGHTS_EDGE.get())
                .add(HnSItemRegistry.TRUE_NIGHTS_EDGE.get())

                // Cosmic
                .add(HnSItemRegistry.ASTRALITE_CLEAVER.get())

                // Hydro
                .add(HnSItemRegistry.TIDAL_WAVE.get())

                //Holy
                .add(HnSItemRegistry.HAMMER_OF_JUSTICE.get())
                .add(HnSItemRegistry.DIVINE_GREATSWORD.get())
                .add(HnSItemRegistry.EXCALIBUR.get())
                .add(HnSItemRegistry.HAZENS_EXCALIBUR.get())
                .add(HnSItemRegistry.ISS_EXCALIBUR.get())

                //Evocation
                .add(HnSItemRegistry.MALICE.get())
                .add(HnSItemRegistry.ANCIENT_WARRIORS_AXE.get())

                //Eldritch
                .add(HnSItemRegistry.THE_DEVOURER.get())

                //Misc
                .add(HnSItemRegistry.MAGE_BANE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_WARLOCK_AXE.get())
                .add(HnSItemRegistry.MURAMASA.get())
                .add(HnSItemRegistry.DAWNMAKER.get())

                /*
                *** Tools
                */

                .add(HnSItemRegistry.SPECTRAL_PICKAXE.get())
                .add(HnSItemRegistry.PICKAXE_AXE.get())
                .add(HnSItemRegistry.PICKAXE_AXE_DIVINE_GOLD.get())
        ;

        tag(ItemTags.HEAD_ARMOR)
                .addTag(HnSTags.HNS_HELMET)
        ;

        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .addTag(HnSTags.HNS_HELMET)
        ;

        tag(ItemTags.CHEST_ARMOR)
                .addTag(HnSTags.HNS_CHESTPLATE)
        ;

        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .addTag(HnSTags.HNS_CHESTPLATE)
        ;

        tag(ItemTags.LEG_ARMOR)
                .addTag(HnSTags.HNS_LEGGINGS)
        ;

        tag(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .addTag(HnSTags.HNS_LEGGINGS)
        ;

        tag(ItemTags.FOOT_ARMOR)
                .addTag(HnSTags.HNS_BOOTS)
        ;

        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .addTag(HnSTags.HNS_BOOTS)
        ;

        tag(HnSTags.SCHOOL_HELMET)
                .add(ItemRegistry.PYROMANCER_HELMET.get())
                .add(ItemRegistry.PLAGUED_HELMET.get())
                .add(ItemRegistry.ARCHEVOKER_HELMET.get())
                .add(ItemRegistry.PRIEST_HELMET.get())
                .add(ItemRegistry.CRYOMANCER_HELMET.get())
                .add(ItemRegistry.ELECTROMANCER_HELMET.get())
                .add(ItemRegistry.CULTIST_HELMET.get())
                .add(ItemRegistry.SHADOWWALKER_HELMET.get())
                .add(HnSItemRegistry.MASKED_FOOL_HELMET.get())
                .add(HnSItemRegistry.RADIANT_CRYSTAL_HELMET.get())
                .add(HnSItemRegistry.COSMIC_SCHOLAR_HELMET.get())
                .add(HnSItemRegistry.NAUTILUS_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.FIREBLOSSOM_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_HELMET.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_HELMET.get())
        ;

        tag(HnSTags.SCHOOL_CHESTPLATE)
                .add(ItemRegistry.PYROMANCER_CHESTPLATE.get())
                .add(ItemRegistry.PLAGUED_CHESTPLATE.get())
                .add(ItemRegistry.ARCHEVOKER_CHESTPLATE.get())
                .add(ItemRegistry.PRIEST_CHESTPLATE.get())
                .add(ItemRegistry.CRYOMANCER_CHESTPLATE.get())
                .add(ItemRegistry.ELECTROMANCER_CHESTPLATE.get())
                .add(ItemRegistry.CULTIST_CHESTPLATE.get())
                .add(ItemRegistry.SHADOWWALKER_CHESTPLATE.get())
                .add(HnSItemRegistry.MASKED_FOOL_CHESTPLATE.get())
                .add(HnSItemRegistry.RADIANT_CRYSTAL_CHESTPLATE.get())
                .add(HnSItemRegistry.COSMIC_SCHOLAR_CHESTPLATE.get())
                .add(HnSItemRegistry.NAUTILUS_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.FIREBLOSSOM_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_CHESTPLATE.get())
        ;

        tag(HnSTags.SCHOOL_LEGGINGS)
                .add(ItemRegistry.PYROMANCER_LEGGINGS.get())
                .add(ItemRegistry.PLAGUED_LEGGINGS.get())
                .add(ItemRegistry.ARCHEVOKER_LEGGINGS.get())
                .add(ItemRegistry.PRIEST_LEGGINGS.get())
                .add(ItemRegistry.CRYOMANCER_LEGGINGS.get())
                .add(ItemRegistry.ELECTROMANCER_LEGGINGS.get())
                .add(ItemRegistry.CULTIST_LEGGINGS.get())
                .add(ItemRegistry.SHADOWWALKER_LEGGINGS.get())
                .add(HnSItemRegistry.MASKED_FOOL_LEGGINGS.get())
                .add(HnSItemRegistry.RADIANT_CRYSTAL_LEGGINGS.get())
                .add(HnSItemRegistry.COSMIC_SCHOLAR_LEGGINGS.get())
                .add(HnSItemRegistry.NAUTILUS_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.FIREBLOSSOM_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_LEGGINGS.get())
        ;

        tag(HnSTags.SCHOOL_BOOTS)
                .add(ItemRegistry.PYROMANCER_BOOTS.get())
                .add(ItemRegistry.PLAGUED_BOOTS.get())
                .add(ItemRegistry.ARCHEVOKER_BOOTS.get())
                .add(ItemRegistry.PRIEST_BOOTS.get())
                .add(ItemRegistry.CRYOMANCER_BOOTS.get())
                .add(ItemRegistry.ELECTROMANCER_BOOTS.get())
                .add(ItemRegistry.CULTIST_BOOTS.get())
                .add(ItemRegistry.SHADOWWALKER_BOOTS.get())
                .add(HnSItemRegistry.MASKED_FOOL_BOOTS.get())
                .add(HnSItemRegistry.RADIANT_CRYSTAL_BOOTS.get())
                .add(HnSItemRegistry.COSMIC_SCHOLAR_BOOTS.get())
                .add(HnSItemRegistry.NAUTILUS_KNIGHT_BOOTS.get())
                .add(HnSItemRegistry.FIREBLOSSOM_KNIGHT_BOOTS.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_BOOTS.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_BOOTS.get())
        ;



        tag(HnSTags.NETHERITE_BATTLEMAGE_HELMET)
                .add(ItemRegistry.NETHERITE_MAGE_HELMET.get())
                .add(HnSItemRegistry.ATLAS_HELMET.get())
                .add(HnSItemRegistry.FRIEREN_HELMET.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_HELMET.get())
        ;

        tag(HnSTags.NETHERITE_BATTLEMAGE_CHESTPLATE)
                .add(ItemRegistry.NETHERITE_MAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.ATLAS_CHESTPLATE.get())
                .add(HnSItemRegistry.FRIEREN_CHESTPLATE.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_CHESTPLATE.get())
        ;

        tag(HnSTags.NETHERITE_BATTLEMAGE_LEGGINGS)
                .add(ItemRegistry.NETHERITE_MAGE_LEGGINGS.get())
                .add(HnSItemRegistry.ATLAS_LEGGINGS.get())
                .add(HnSItemRegistry.FRIEREN_LEGGINGS.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_LEGGINGS.get())
        ;

        tag(HnSTags.NETHERITE_BATTLEMAGE_BOOTS)
                .add(ItemRegistry.NETHERITE_MAGE_BOOTS.get())
                .add(HnSItemRegistry.ATLAS_BOOTS.get())
                .add(HnSItemRegistry.FRIEREN_BOOTS.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_BOOTS.get())
        ;


        tag(HnSTags.PURE_HELMET)
                .add(HnSItemRegistry.CALAMITAS_HELMET.get())
                .add(HnSItemRegistry.BLAZEBORNE_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_BLAZEBORNE_HELMET.get())
                .add(HnSItemRegistry.HAZEL_HELMET.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_HELMET.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_HELMET.get())
                .add(HnSItemRegistry.HERTA_PUPPET_HELMET.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_HELMET.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_HELMET.get())
                .add(HnSItemRegistry.CREAKING_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_CREAKING_HELMET.get())
                .add(HnSItemRegistry.FLESH_MASS_HELMET.get())
                .add(HnSItemRegistry.THE_WITHER_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_THE_WITHER_HELMET.get())
                .add(HnSItemRegistry.ENDER_DRAGON_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_HELMET.get())
                .add(HnSItemRegistry.SERAPH_HELMET.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_HELMET.get())
                .add(HnSItemRegistry.SUPREME_WITCH_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_SUPREME_WITCH_HELMET.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_HELMET.get())
                .add(HnSItemRegistry.SHADOW_SCALE_HELMET.get())
                .add(HnSItemRegistry.INFESTATION_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_INFESTATION_HELMET.get())
                .add(HnSItemRegistry.LEGACY_LEGIONNAIRE_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_HELMET.get())
                .add(HnSItemRegistry.TYROS_HELMET.get())
                .add(HnSItemRegistry.TYROS_SOUL_HELMET.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_HELMET.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItemRegistry.LEGACY_GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.LEGACY_GECKOLIB_FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.MAVERICK_HELMET.get())
                .add(HnSItemRegistry.SLC_CAT_HELMET.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_HELMET.get())
                .add(HnSItemRegistry.CHLOROPHYTE_HELMET.get())
                .add(HnSItemRegistry.CHLOROPHYTE_HEADGEAR.get())
                .add(HnSItemRegistry.CHLOROPHYTE_MASK.get())
                .add(HnSItemRegistry.ASTRACONIC_WEAVER_HELMET.get())
                .add(HnSItemRegistry.GLASSWEAVER_HELMET.get())
                .add(HnSItemRegistry.SHADOW_JESTER_HELMET.get())
                .add(HnSItemRegistry.ELDER_GUARDIAN_HELMET.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_HELMET.get())
        ;

        tag(HnSTags.PURE_CHESTPLATE)
                .add(HnSItemRegistry.CALAMITAS_CHESTPLATE.get())
                .add(HnSItemRegistry.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItemRegistry.HAZEL_CHESTPLATE.get())
                .add(HnSItemRegistry.HAZEL_HOLY_MOLLY_CHESTPLATE.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_CHESTPLATE.get())
                .add(HnSItemRegistry.HERTA_PUPPET_CHESTPLATE.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_CHESTPLATE.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_CHESTPLATE.get())
                .add(HnSItemRegistry.CREAKING_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_CREAKING_CHESTPLATE.get())
                .add(HnSItemRegistry.FLESH_MASS_CHESTPLATE.get())
                .add(HnSItemRegistry.FLESH_MASS_LEGGINGS.get())
                .add(HnSItemRegistry.THE_WITHER_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_THE_WITHER_CHESTPLATE.get())
                .add(HnSItemRegistry.ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItemRegistry.SERAPH_CHESTPLATE.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_CHESTPLATE.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_SECRET_CHESTPLATE.get())
                .add(HnSItemRegistry.SUPREME_WITCH_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_SUPREME_WITCH_CHESTPLATE.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .add(HnSItemRegistry.SHADOW_SCALE_CHESTPLATE.get())
                .add(HnSItemRegistry.INFESTATION_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_INFESTATION_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGACY_LEGIONNAIRE_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_CHESTPLATE.get())
                .add(HnSItemRegistry.TYROS_CHESTPLATE.get())
                .add(HnSItemRegistry.TYROS_SOUL_CHESTPLATE.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGACY_GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.MAVERICK_CHESTPLATE.get())
                .add(HnSItemRegistry.SLC_CAT_CHESTPLATE.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_CHESTPLATE.get())
                .add(HnSItemRegistry.CHLOROPHYTE_CHESTPLATE.get())
                .add(HnSItemRegistry.ASTRACONIC_WEAVER_CHESTPLATE.get())
                .add(HnSItemRegistry.GLASSWEAVER_CHESTPLATE.get())
                .add(HnSItemRegistry.SHADOW_JESTER_CHESTPLATE.get())
                .add(HnSItemRegistry.ELDER_GUARDIAN_CHESTPLATE.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_CHESTPLATE.get())
        ;

        tag(HnSTags.PURE_LEGGINGS)
                .add(HnSItemRegistry.CALAMITAS_LEGGINGS.get())
                .add(HnSItemRegistry.BLAZEBORNE_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_BLAZEBORNE_LEGGINGS.get())
                .add(HnSItemRegistry.HAZEL_LEGGINGS.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_LEGGINGS.get())
                .add(HnSItemRegistry.HERTA_PUPPET_LEGGINGS.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_LEGGINGS.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_LEGGINGS.get())
                .add(HnSItemRegistry.CREAKING_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_CREAKING_LEGGINGS.get())
                .add(HnSItemRegistry.FLESH_MASS_LEGGINGS.get())
                .add(HnSItemRegistry.THE_WITHER_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_THE_WITHER_LEGGINGS.get())
                .add(HnSItemRegistry.ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItemRegistry.SERAPH_LEGGINGS.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_LEGGINGS.get())
                .add(HnSItemRegistry.SUPREME_WITCH_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_SUPREME_WITCH_LEGGINGS.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_LEGGINGS.get())
                .add(HnSItemRegistry.SHADOW_SCALE_LEGGINGS.get())
                .add(HnSItemRegistry.INFESTATION_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_INFESTATION_LEGGINGS.get())
                .add(HnSItemRegistry.LEGACY_LEGIONNAIRE_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_LEGGINGS.get())
                .add(HnSItemRegistry.TYROS_LEGGINGS.get())
                .add(HnSItemRegistry.TYROS_SOUL_LEGGINGS.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.LEGACY_GECKOLIB_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.MAVERICK_LEGGINGS.get())
                .add(HnSItemRegistry.SLC_CAT_LEGGINGS.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_LEGGINGS.get())
                .add(HnSItemRegistry.CHLOROPHYTE_LEGGINGS.get())
                .add(HnSItemRegistry.ASTRACONIC_WEAVER_LEGGINGS.get())
                .add(HnSItemRegistry.GLASSWEAVER_LEGGINGS.get())
                .add(HnSItemRegistry.SHADOW_JESTER_LEGGINGS.get())
                .add(HnSItemRegistry.ELDER_GUARDIAN_LEGGINGS.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_LEGGINGS.get())
        ;

        tag(HnSTags.PURE_BOOTS)
                .add(HnSItemRegistry.CALAMITAS_BOOTS.get())
                .add(HnSItemRegistry.BLAZEBORNE_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_BLAZEBORNE_BOOTS.get())
                .add(HnSItemRegistry.HAZEL_BOOTS.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_BOOTS.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_BOOTS.get())
                .add(HnSItemRegistry.HERTA_PUPPET_BOOTS.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_BOOTS.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_BOOTS.get())
                .add(HnSItemRegistry.CREAKING_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_CREAKING_BOOTS.get())
                .add(HnSItemRegistry.FLESH_MASS_BOOTS.get())
                .add(HnSItemRegistry.THE_WITHER_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_THE_WITHER_BOOTS.get())
                .add(HnSItemRegistry.ENDER_DRAGON_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_BOOTS.get())
                .add(HnSItemRegistry.SERAPH_BOOTS.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_BOOTS.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_BOOTS.get())
                .add(HnSItemRegistry.SUPREME_WITCH_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_SUPREME_WITCH_BOOTS.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_BOOTS.get())
                .add(HnSItemRegistry.SHADOW_SCALE_BOOTS.get())
                .add(HnSItemRegistry.INFESTATION_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_INFESTATION_BOOTS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_BOOTS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_BOOTS.get())
                .add(HnSItemRegistry.TYROS_BOOTS.get())
                .add(HnSItemRegistry.TYROS_SOUL_BOOTS.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_BOOTS.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_BOOTS.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_BOOTS.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_BOOTS.get())
                .add(HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_BOOTS.get())
                .add(HnSItemRegistry.LEGACY_GECKOLIB_FIREBLOSSOM_BATTLEMAGE_BOOTS.get())
                .add(HnSItemRegistry.MAVERICK_BOOTS.get())
                .add(HnSItemRegistry.SLC_CAT_BOOTS.get())
                .add(HnSItemRegistry.CHLOROPHYTE_BOOTS.get())
                .add(HnSItemRegistry.ASTRACONIC_WEAVER_BOOTS.get())
                .add(HnSItemRegistry.GLASSWEAVER_BOOTS.get())
                .add(HnSItemRegistry.SHADOW_JESTER_BOOTS.get())
                .add(HnSItemRegistry.ELDER_GUARDIAN_BOOTS.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_BOOTS.get())
        ;

        tag(HnSTags.ARMORS_FOR_IDLE)

                /*
                *** Fire
                 */

                //Blazeborne Armor
                .add(HnSItemRegistry.BLAZEBORNE_HELMET.get())
                .add(HnSItemRegistry.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItemRegistry.BLAZEBORNE_LEGGINGS.get())
                .add(HnSItemRegistry.BLAZEBORNE_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_BLAZEBORNE_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_BLAZEBORNE_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_BLAZEBORNE_BOOTS.get())

                //Calamitas Armor
                .add(HnSItemRegistry.CALAMITAS_HELMET.get())
                .add(HnSItemRegistry.CALAMITAS_CHESTPLATE.get())
                .add(HnSItemRegistry.CALAMITAS_LEGGINGS.get())
                .add(HnSItemRegistry.CALAMITAS_BOOTS.get())

                /*
                *** Ice
                 */

                //Cryogenic Ruler Armor
                .add(HnSItemRegistry.CRYOGENIC_RULER_HELMET.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_BOOTS.get())

                /*
                *** Nature
                 */

                //Cryogenic Ruler Armor
                .add(HnSItemRegistry.MAVERICK_HELMET.get())
                .add(HnSItemRegistry.MAVERICK_CHESTPLATE.get())
                .add(HnSItemRegistry.MAVERICK_LEGGINGS.get())
                .add(HnSItemRegistry.MAVERICK_BOOTS.get())

                /*
                *** Lightning
                 */

                /*
                *** Blood
                 */

                //Flesh Mass Armor
                .add(HnSItemRegistry.FLESH_MASS_HELMET.get())
                .add(HnSItemRegistry.FLESH_MASS_CHESTPLATE.get())
                .add(HnSItemRegistry.FLESH_MASS_LEGGINGS.get())
                .add(HnSItemRegistry.FLESH_MASS_BOOTS.get())

                //The Wither Armor
                .add(HnSItemRegistry.THE_WITHER_HELMET.get())
                .add(HnSItemRegistry.THE_WITHER_CHESTPLATE.get())
                .add(HnSItemRegistry.THE_WITHER_LEGGINGS.get())
                .add(HnSItemRegistry.THE_WITHER_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_THE_WITHER_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_THE_WITHER_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_THE_WITHER_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_THE_WITHER_BOOTS.get())

                /*
                 *** Ender
                 */

                /*
                *** Evocation
                 */

                /*
                *** Holy
                 */

                //Seraph Armor
                .add(HnSItemRegistry.SERAPH_HELMET.get())
                .add(HnSItemRegistry.SERAPH_CHESTPLATE.get())
                .add(HnSItemRegistry.SERAPH_LEGGINGS.get())
                .add(HnSItemRegistry.SERAPH_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_SERAPH_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_SERAPH_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_SERAPH_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_SERAPH_BOOTS.get())

                //Gabriel ULTRAKILL Armor
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_BOOTS.get())

                //SLC!Cat Armor
                .add(HnSItemRegistry.SLC_CAT_HELMET.get())
                .add(HnSItemRegistry.SLC_CAT_CHESTPLATE.get())
                .add(HnSItemRegistry.SLC_CAT_LEGGINGS.get())
                .add(HnSItemRegistry.SLC_CAT_BOOTS.get())

                /*
                *** Shadow
                 */

                /*
                 *** Radiance
                 */

                /*
                 *** Eldritch
                 */

                //Infestation Armor
                .add(HnSItemRegistry.INFESTATION_HELMET.get())
                .add(HnSItemRegistry.INFESTATION_CHESTPLATE.get())
                .add(HnSItemRegistry.INFESTATION_LEGGINGS.get())
                .add(HnSItemRegistry.INFESTATION_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_INFESTATION_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_INFESTATION_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_INFESTATION_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_INFESTATION_BOOTS.get())

                /*
                *** Misc
                 */

                /*
                *** Dedicated Armor
                 */

                //Atlas Armor

                .add(HnSItemRegistry.ATLAS_HELMET.get())
                .add(HnSItemRegistry.ATLAS_CHESTPLATE.get())
                .add(HnSItemRegistry.ATLAS_LEGGINGS.get())
                .add(HnSItemRegistry.ATLAS_BOOTS.get())

                //Fireblossom Battlemage Armor


                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                .add(HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                .add(HnSItemRegistry.LEGACY_GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItemRegistry.LEGACY_GECKOLIB_FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.LEGACY_GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGACY_GECKOLIB_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.LEGACY_GECKOLIB_FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                //Lemon God Armor

                .add(HnSItemRegistry.LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.LEMON_GOD_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_BOOTS.get())
        ;

        tag(HnSTags.HNS_HELMET)
                .addTag(HnSTags.SCHOOL_HELMET)
                .addTag(HnSTags.NETHERITE_BATTLEMAGE_HELMET)
                .addTag(HnSTags.PURE_HELMET)

                .add(HnSItemRegistry.MINER_HELMET.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_HELMET.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_HELMET.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.MAGEHUNTER_HELMET.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.IRON431_HELMET.get())
                .add(HnSItemRegistry.SACRED_ROBES_HELMET.get())
                .add(HnSItemRegistry.LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.ENDERMAN_HOOD.get())
                .add(HnSItemRegistry.ENDERMAN_MASKED.get())
                .add(HnSItemRegistry.ENDERMAN_BLINDFOLD.get())
                .add(HnSItemRegistry.FIREBLOSSOM_GOWN_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_GOWN_HELMET.get())
        ;

        tag(HnSTags.HNS_CHESTPLATE)
                .addTag(HnSTags.SCHOOL_CHESTPLATE)
                .addTag(HnSTags.NETHERITE_BATTLEMAGE_CHESTPLATE)
                .addTag(HnSTags.PURE_CHESTPLATE)

                .add(HnSItemRegistry.MINER_CHESTPLATE.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_CHESTPLATE.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.MAGEHUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.IRON431_CHESTPLATE.get())
                .add(HnSItemRegistry.SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.ENDERMAN_CHESTPLATE.get())
                .add(HnSItemRegistry.FIREBLOSSOM_GOWN_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_GOWN_CHESTPLATE.get())
        ;

        tag(HnSTags.HNS_LEGGINGS)
                .addTag(HnSTags.SCHOOL_LEGGINGS)
                .addTag(HnSTags.NETHERITE_BATTLEMAGE_LEGGINGS)
                .addTag(HnSTags.PURE_LEGGINGS)

                .add(HnSItemRegistry.MINER_LEGGINGS.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_LEGGINGS.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.MAGEHUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.IRON431_LEGGINGS.get())
                .add(HnSItemRegistry.SACRED_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.ENDERMAN_LEGGINGS.get())
                .add(HnSItemRegistry.FIREBLOSSOM_GOWN_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_GOWN_LEGGINGS.get())
        ;

        tag(HnSTags.HNS_BOOTS)
                .addTag(HnSTags.SCHOOL_BOOTS)
                .addTag(HnSTags.NETHERITE_BATTLEMAGE_BOOTS)
                .addTag(HnSTags.PURE_BOOTS)

                .add(HnSItemRegistry.MINER_BOOTS.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_BOOTS.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_BOOTS.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_BOOTS.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_BOOTS.get())
                .add(HnSItemRegistry.MAGEHUNTER_BOOTS.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_BOOTS.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItemRegistry.IRON431_BOOTS.get())
                .add(HnSItemRegistry.SACRED_ROBES_BOOTS.get())
                .add(HnSItemRegistry.LEMON_GOD_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_BOOTS.get())
                .add(HnSItemRegistry.ENDERMAN_BOOTS.get())
                .add(HnSItemRegistry.FIREBLOSSOM_GOWN_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_GOWN_BOOTS.get())
        ;


        /*
        *** Tools and Weapons Tags
         */

        tag(ItemTags.AXES)
                .add(HnSItemRegistry.BEONGAE.get())
                .add(HnSItemRegistry.SKYSCORCHER.get())
                .add(HnSItemRegistry.ANCIENT_WARRIORS_AXE.get())
                .add(HnSItemRegistry.FIREBRAND.get())
                .add(HnSItemRegistry.PICKAXE_AXE.get())
                .add(HnSItemRegistry.PICKAXE_AXE_DIVINE_GOLD.get())
                .add(HnSItemRegistry.RAVENS_BANE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_WARLOCK_AXE.get())
        ;

        tag(ItemTags.SWORDS)
                //Fire
                .add(HnSItemRegistry.FIREBLOSSOM_RAPIER.get())
                .add(HnSItemRegistry.DRACONIC_SPLITTER.get())
                .add(HnSItemRegistry.FIREBRAND.get())
                .add(HnSItemRegistry.WARFLAMING_LANCE.get())
                .add(HnSItemRegistry.RAVENS_BANE.get())
                .add(HnSItemRegistry.VOLCANO.get())

                //Ice
                .add(HnSItemRegistry.ICE_PIKE.get())
                .add(HnSItemRegistry.FROSTBURN_DAGGER.get())

                //Lightning
                .add(HnSItemRegistry.BEONGAE.get())
                .add(HnSItemRegistry.SKYSCORCHER.get())

                //Nature
                .add(HnSItemRegistry.BOUNTIFUL_HARVEST.get())
                .add(HnSItemRegistry.THORN_CHAKRAM.get())
                .add(HnSItemRegistry.BLADE_OF_GRASS.get())

                //Blood
                .add(HnSItemRegistry.VAMPIRE_KNIVES.get())

                //Ender
                .add(HnSItemRegistry.OBSIDIAN_CLAYMORE.get())
                .add(HnSItemRegistry.STARFURY.get())

                //Radiance
                .add(HnSItemRegistry.SPECTRUM.get())
                .add(HnSItemRegistry.MEOWMERE.get())
                .add(HnSItemRegistry.HAMMUSH.get())

                //Shadow
                .add(HnSItemRegistry.LIGHTS_BANE.get())
                .add(HnSItemRegistry.NIGHTS_EDGE.get())
                .add(HnSItemRegistry.TRUE_NIGHTS_EDGE.get())

                //Holy
                .add(HnSItemRegistry.HAMMER_OF_JUSTICE.get())
                .add(HnSItemRegistry.DIVINE_GREATSWORD.get())
                .add(HnSItemRegistry.EXCALIBUR.get())
                .add(HnSItemRegistry.HAZENS_EXCALIBUR.get())
                .add(HnSItemRegistry.ISS_EXCALIBUR.get())

                //Evocation
                .add(HnSItemRegistry.MALICE.get())
                .add(HnSItemRegistry.ANCIENT_WARRIORS_AXE.get())

                //Eldritch
                .add(HnSItemRegistry.THE_DEVOURER.get())

                //Misc
                .add(HnSItemRegistry.MAGE_BANE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_WARLOCK_AXE.get())
                .add(HnSItemRegistry.MURAMASA.get())
                .add(HnSItemRegistry.DAWNMAKER.get())
        ;

        tag(ItemTags.PICKAXES)
                .add(HnSItemRegistry.SPECTRAL_PICKAXE.get())
                .add(HnSItemRegistry.PICKAXE_AXE.get())
                .add(HnSItemRegistry.PICKAXE_AXE_DIVINE_GOLD.get())
        ;

        tag(Tags.Items.TOOLS_MACE)
                .add(HnSItemRegistry.SKYSCORCHER.get())
        ;

        tag(ItemTags.MACE_ENCHANTABLE)
                .add(HnSItemRegistry.SKYSCORCHER.get())
        ;

        tag(ItemTags.MINING_ENCHANTABLE)
                .add(HnSItemRegistry.SPECTRAL_PICKAXE.get())
                .add(HnSItemRegistry.PICKAXE_AXE.get())
                .add(HnSItemRegistry.PICKAXE_AXE_DIVINE_GOLD.get())
        ;

        tag(Tags.Items.TOOLS_SPEAR)
                .add(HnSItemRegistry.ICE_PIKE.get())
        ;

        tag(HnSTags.IONIC_SPLITTER)
                .add(HnSItemRegistry.IONIC_SPLITTER_T1.get())
                .add(HnSItemRegistry.IONIC_SPLITTER_T2.get())
                .add(HnSItemRegistry.IONIC_SPLITTER_T3.get())
        ;

        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                //Fire
                .add(HnSItemRegistry.FIREBLOSSOM_RAPIER.get())
                .add(HnSItemRegistry.DRACONIC_SPLITTER.get())
                .add(HnSItemRegistry.FIREBRAND.get())
                .add(HnSItemRegistry.WARFLAMING_LANCE.get())
                .add(HnSItemRegistry.RAVENS_BANE.get())
                .add(HnSItemRegistry.BLADE_OF_GRASS.get())
                .add(HnSItemRegistry.VOLCANO.get())

                //Ice
                .add(HnSItemRegistry.ICE_PIKE.get())
                .add(HnSItemRegistry.FROSTBURN_DAGGER.get())

                //Lightning
                .add(HnSItemRegistry.BEONGAE.get())
                .add(HnSItemRegistry.SKYSCORCHER.get())
                .add(HnSItemRegistry.IONIC_SPLITTER_DORMANT.get())
                .add(HnSItemRegistry.IONIC_SPLITTER_T1.get())
                .add(HnSItemRegistry.IONIC_SPLITTER_T2.get())
                .add(HnSItemRegistry.IONIC_SPLITTER_T3.get())

                //Nature
                .add(HnSItemRegistry.BOUNTIFUL_HARVEST.get())
                .add(HnSItemRegistry.THORN_CHAKRAM.get())
                .add(HnSItemRegistry.O_FORTUNA_DORMANT.get())
                //.add(HnSItemRegistry.O_FORTUNA_T1.get())
                //.add(HnSItemRegistry.O_FORTUNA_T2.get())
                //.add(HnSItemRegistry.O_FORTUNA_T3.get())

                //Blood
                .add(HnSItemRegistry.VAMPIRE_KNIVES.get())
                .add(HnSItemRegistry.DEVASTATOR_DORMANT.get())
                //.add(HnSItemRegistry.DEVASTATOR_T1.get())

                //Ender
                .add(HnSItemRegistry.OBSIDIAN_CLAYMORE.get())
                .add(HnSItemRegistry.UMBRANOVA_DORMANT.get())
                //.add(HnSItemRegistry.UMBRANOVA_T1.get())

                //Radiance
                .add(HnSItemRegistry.SPECTRUM.get())
                .add(HnSItemRegistry.MEOWMERE.get())
                .add(HnSItemRegistry.HAMMUSH.get())

                //Shadow
                .add(HnSItemRegistry.SOUL_REAPER.get())
                .add(HnSItemRegistry.LIGHTS_BANE.get())
                .add(HnSItemRegistry.NIGHTS_EDGE.get())
                .add(HnSItemRegistry.TRUE_NIGHTS_EDGE.get())

                //Cosmic

                .add(HnSItemRegistry.ASTRALITE_CLEAVER.get())
                .add(HnSItemRegistry.STARFURY.get())

                // Hydro
                .add(HnSItemRegistry.TIDAL_WAVE.get())

                //Holy
                .add(HnSItemRegistry.HAMMER_OF_JUSTICE.get())
                .add(HnSItemRegistry.DIVINE_GREATSWORD.get())
                .add(HnSItemRegistry.EXCALIBUR.get())
                .add(HnSItemRegistry.HAZENS_EXCALIBUR.get())
                .add(HnSItemRegistry.ISS_EXCALIBUR.get())

                //Evocation
                .add(HnSItemRegistry.MALICE.get())
                .add(HnSItemRegistry.ANCIENT_WARRIORS_AXE.get())
                .add(HnSItemRegistry.PROVOCATION_DORMANT.get())
                //.add(HnSItemRegistry.PROVOCATION_T1.get())

                //Eldritch
                .add(HnSItemRegistry.THE_DEVOURER.get())

                //Misc
                .add(HnSItemRegistry.MAGE_BANE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_WARLOCK_AXE.get())
                .add(HnSItemRegistry.MURAMASA.get())
                .add(HnSItemRegistry.DAWNMAKER.get())
        ;

        /*
        *** Blocks
         */


        /*
         *** Generic Tags
         */

        //Door
        tag(ItemTags.DOORS)

                .add(HnSBlocks.WISEWOOD_DOOR.get().asItem())

        ;

        tag(ItemTags.WOODEN_DOORS)

                .add(HnSBlocks.WISEWOOD_DOOR.get().asItem())

        ;

        //Trapdoor
        tag(ItemTags.TRAPDOORS)

                .add(HnSBlocks.WISEWOOD_TRAPDOOR.get().asItem())
        ;

        tag(ItemTags.WOODEN_TRAPDOORS)

                .add(HnSBlocks.WISEWOOD_TRAPDOOR.get().asItem())

        ;

        //Fence
        tag(ItemTags.FENCES)

                .add(HnSBlocks.WISEWOOD_FENCE.get().asItem())
                .add(HnSBlocks.FROSTBITE_BIRCH_FENCE.get().asItem())

        ;

        tag(ItemTags.WOODEN_FENCES)

                .add(HnSBlocks.WISEWOOD_FENCE.get().asItem())
                .add(HnSBlocks.FROSTBITE_BIRCH_FENCE.get().asItem())

        ;

        tag(ItemTags.FENCE_GATES)

                .add(HnSBlocks.WISEWOOD_FENCE_GATE.get().asItem())
                .add(HnSBlocks.FROSTBITE_BIRCH_FENCE_GATE.get().asItem())

        ;

        tag(ItemTags.WALLS)

                .add(HnSBlocks.FROSTBITE_BIRCH_FENCE_GATE.get().asItem())

        ;

        //Stairs
        tag(ItemTags.STAIRS)

                .add(HnSBlocks.WISEWOOD_STAIRS.get().asItem())
                .add(HnSBlocks.ZENALITE_BRICK_STAIRS.get().asItem())
        ;

        tag(ItemTags.WOODEN_STAIRS)

                .add(HnSBlocks.WISEWOOD_STAIRS.get().asItem())

        ;

        //Slabs
        tag(ItemTags.SLABS)

                .add(HnSBlocks.WISEWOOD_SLAB.get().asItem())
                .add(HnSBlocks.ZENALITE_BRICK_SLAB.get().asItem())
        ;

        tag(ItemTags.WOODEN_SLABS)

                .add(HnSBlocks.WISEWOOD_SLAB.get().asItem())

        ;


        //Bricks
        tag(ItemTags.STONE_BRICKS)

                .add(HnSBlocks.ZENALITE_BRICKS.get().asItem())

        ;

        /*
         *** Wood Tags
         */


        tag(ItemTags.PLANKS)

                .add(HnSBlocks.WISEWOOD_PLANKS.get().asItem())

        ;

        tag(ItemTags.LOGS)

                .add(HnSBlocks.WISEWOOD_LOG.get().asItem())
                .add(HnSBlocks.STRIPPED_WISEWOOD_LOG.get().asItem())
                .add(HnSBlocks.WISEWOOD_WOOD.get().asItem())
                .add(HnSBlocks.STRIPPED_WISEWOOD_WOOD.get().asItem())

        ;

        tag(ItemTags.LOGS_THAT_BURN)

                .add(HnSBlocks.WISEWOOD_LOG.get().asItem())
                .add(HnSBlocks.STRIPPED_WISEWOOD_LOG.get().asItem())
                .add(HnSBlocks.WISEWOOD_WOOD.get().asItem())
                .add(HnSBlocks.STRIPPED_WISEWOOD_WOOD.get().asItem())

                .add(HnSBlocks.FROSTBITE_BIRCH_LOG.get().asItem())
                .add(HnSBlocks.STRIPPED_FROSTBITE_BIRCH_LOG.get().asItem())
                .add(HnSBlocks.FROSTBITE_BIRCH_WOOD.get().asItem())
                .add(HnSBlocks.STRIPPED_FROSTBITE_BIRCH_WOOD.get().asItem())

        ;

        tag(ItemTags.LEAVES)

                .add(HnSBlocks.PERMAFROST_LEAVES.get().asItem())
                .add(HnSBlocks.WISEWOOD_LEAVES.get().asItem())

        ;

        /*
         *** Misc
         */

        tag(ItemTags.SAPLINGS)
                .add(HnSBlocks.FROSTBITE_BIRCH_SAPLING.get().asItem())
                .add(HnSBlocks.WISEWOOD_SAPLING.get().asItem())

        ;

        /*
        *** Misc
         */


        tag(Tags.Items.ENCHANTING_FUELS)
                .add(ItemRegistry.ARCANE_ESSENCE.get())
        ;

        tag(Tags.Items.BONES)
                .add(HnSItemRegistry.OVERGROWN_BONE.get())
                .add(HnSItemRegistry.CHARRED_BONES.get())
        ;

        tag(Tags.Items.HIDDEN_FROM_RECIPE_VIEWERS)
                .add(HnSItemRegistry.HAZEL_HOLY_MOLLY_CHESTPLATE.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_SECRET_CHESTPLATE.get())
        ;

        tag(ModTags.INSCRIBED_RUNES)
                .add(HnSItemRegistry.MELEE_RUNE.get())
                .add(HnSItemRegistry.ARCHERY_RUNE.get())
                .add(HnSItemRegistry.HEALTH_RUNE.get())
                .add(HnSItemRegistry.ELDRITCH_RUNE.get())
                .add(HnSItemRegistry.SHADOW_RUNE.get())
                .add(HnSItemRegistry.RADIANCE_RUNE.get())
                .add(HnSItemRegistry.COSMIC_RUNE.get())
                .add(HnSItemRegistry.HYDRO_RUNE.get())
        ;

        tag(HnSTags.ENDER_MASK)
                .add(Items.CARVED_PUMPKIN)
        ;

    }
}