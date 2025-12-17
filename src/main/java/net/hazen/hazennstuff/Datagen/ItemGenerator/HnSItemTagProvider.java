package net.hazen.hazennstuff.Datagen.ItemGenerator;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import io.redspace.ironsspellbooks.util.ModTags;
import net.hazen.hazennstuff.Block.HnSBlocks;
import net.hazen.hazennstuff.Datagen.HnSTags;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.HnSItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
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
                .add(HnSItems.ZENALITE_INGOT.get())
                .add(HnSItems.STEEL_INGOT.get())
                .add(HnSItems.ROSE_GOLD_INGOT.get())
                .add(HnSItems.DREADSTEEL_INGOT.get())
                .add(HnSItems.CHLOROPHYTE_INGOT.get())
                .add(HnSItems.HALLOWED_INGOT.get())
                .add(HnSItems.DEMONITE_INGOT.get())
        ;

        tag(Tags.Items.NUGGETS)
                .add(HnSItems.PYRIUM_NUGGET.get())
                .add(HnSItems.STEEL_NUGGET.get())
        ;

        tag(Tags.Items.ORES)

                .add(HnSItems.RAW_ZENALITE.get())
                .add(HnSItems.CHLOROPHYTE_CHUNK.get())
                .add(HnSItems.DREADSTONE.get())
                .add(HnSItems.SOLAR_CORE.get())
                .add(HnSItems.ROSE_QUARTZ.get())

        ;

        tag(Tags.Items.RAW_MATERIALS)

                .add(HnSItems.RAW_ZENALITE.get())
                .add(HnSItems.CHLOROPHYTE_CHUNK.get())
                .add(HnSItems.DREADSTONE.get())
                .add(HnSItems.CRUDE_METAL.get())

        ;

        tag(Tags.Items.GEMS)

                .add(HnSItems.SOLAR_CORE.get())
                .add(HnSItems.ROSE_QUARTZ.get())

        ;

        tag(Tags.Items.GEMS_QUARTZ)

                .add(HnSItems.ROSE_QUARTZ.get())

        ;

        tag(HnSTags.ZENALITE)

                .add(HnSItems.RAW_ZENALITE.get())
                .add(HnSItems.STARKISSED_ZENALITE.get())

        ;

        tag(HnSTags.CINDEROUS_EQUIPMENT)

                .add(HnSItems.TYROS_HELMET.get())
                .add(HnSItems.TYROS_CHESTPLATE.get())
                .add(HnSItems.TYROS_LEGGINGS.get())
                .add(HnSItems.TYROS_BOOTS.get())

                .add(HnSItems.TYROS_SOUL_HELMET.get())
                .add(HnSItems.TYROS_SOUL_CHESTPLATE.get())
                .add(HnSItems.TYROS_SOUL_LEGGINGS.get())
                .add(HnSItems.TYROS_SOUL_BOOTS.get())

                .add(HnSItems.SOULCALLING_SCEPTER.get())

                .add(HnSItems.BLADE_OF_THE_LEGATE.get())
                .add(HnSItems.THE_PREFECTS_RING.get())
                .add(HnSItems.THE_TRIBUNES_MEDALLION.get())

        ;


        /*
        *** Enchantable Tags
         */

        tag(Tags.Items.ENCHANTABLES)

                /*
                *** Armor
                 */

                /*
                *** Fire
                 */

                //Calamitas Armor
                .add(HnSItems.CALAMITAS_HELMET.get())
                .add(HnSItems.CALAMITAS_CHESTPLATE.get())
                .add(HnSItems.CALAMITAS_LEGGINGS.get())
                .add(HnSItems.CALAMITAS_BOOTS.get())

                //Blazeborne Armor
                .add(HnSItems.BLAZEBORNE_HELMET.get())
                .add(HnSItems.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItems.BLAZEBORNE_LEGGINGS.get())
                .add(HnSItems.BLAZEBORNE_BOOTS.get())

                //Soul Flame Armor
                .add(HnSItems.SOUL_FLAME_HELMET.get())
                .add(HnSItems.SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItems.SOUL_FLAME_LEGGINGS.get())
                .add(HnSItems.SOUL_FLAME_BOOTS.get())

                .add(HnSItems.GECKOLIB_SOUL_FLAME_HELMET.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_BOOTS.get())

                //Hazel Armor
                .add(HnSItems.HAZEL_HELMET.get())
                .add(HnSItems.HAZEL_CHESTPLATE.get())
                .add(HnSItems.HAZEL_HOLY_MOLLY_CHESTPLATE.get())
                .add(HnSItems.HAZEL_LEGGINGS.get())
                .add(HnSItems.HAZEL_BOOTS.get())

                /*
                *** Ice
                 */

                //Cryogenic Ruler Armor
                .add(HnSItems.CRYOGENIC_RULER_HELMET.get())
                .add(HnSItems.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSItems.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSItems.CRYOGENIC_RULER_BOOTS.get())

                //Crystal Arachnid Armor
                .add(HnSItems.CRYSTAL_ARACHNID_HELMET.get())
                .add(HnSItems.CRYSTAL_ARACHNID_CHESTPLATE.get())
                .add(HnSItems.CRYSTAL_ARACHNID_LEGGINGS.get())
                .add(HnSItems.CRYSTAL_ARACHNID_BOOTS.get())

                //Herta Puppet Armor
                .add(HnSItems.HERTA_PUPPET_HELMET.get())
                .add(HnSItems.HERTA_PUPPET_CHESTPLATE.get())
                .add(HnSItems.HERTA_PUPPET_LEGGINGS.get())
                .add(HnSItems.HERTA_PUPPET_BOOTS.get())

                /*
                *** Lightning
                 */

                //Cryogenic Ruler Armor
                .add(HnSItems.CHARGED_SCOURGE_HELMET.get())
                .add(HnSItems.CHARGED_SCOURGE_CHESTPLATE.get())
                .add(HnSItems.CHARGED_SCOURGE_LEGGINGS.get())
                .add(HnSItems.CHARGED_SCOURGE_BOOTS.get())

                //Thunder Prowler Armor
                .add(HnSItems.THUNDER_PROWLER_HELMET.get())
                .add(HnSItems.THUNDER_PROWLER_CHESTPLATE.get())
                .add(HnSItems.THUNDER_PROWLER_LEGGINGS.get())
                .add(HnSItems.THUNDER_PROWLER_BOOTS.get())

                /*
                *** Nature
                 */

                //Creaking Sorcerer Armor
                .add(HnSItems.CREAKING_HELMET.get())
                .add(HnSItems.CREAKING_CHESTPLATE.get())
                .add(HnSItems.CREAKING_LEGGINGS.get())
                .add(HnSItems.CREAKING_BOOTS.get())

                // Chlorophyte Armor
                .add(HnSItems.CHLOROPHYTE_HELMET.get())
                .add(HnSItems.CHLOROPHYTE_MASK.get())
                .add(HnSItems.CHLOROPHYTE_HEADGEAR.get())
                .add(HnSItems.CHLOROPHYTE_CHESTPLATE.get())
                .add(HnSItems.CHLOROPHYTE_LEGGINGS.get())
                .add(HnSItems.CHLOROPHYTE_BOOTS.get())

                /*
                *** Blood
                 */

                //Flesh Mass Armor
                .add(HnSItems.FLESH_MASS_HELMET.get())
                .add(HnSItems.FLESH_MASS_CHESTPLATE.get())
                .add(HnSItems.FLESH_MASS_LEGGINGS.get())
                .add(HnSItems.FLESH_MASS_BOOTS.get())

                //The Wither Armor
                .add(HnSItems.THE_WITHER_HELMET.get())
                .add(HnSItems.THE_WITHER_CHESTPLATE.get())
                .add(HnSItems.THE_WITHER_LEGGINGS.get())
                .add(HnSItems.THE_WITHER_BOOTS.get())

                .add(HnSItems.GECKOLIB_THE_WITHER_HELMET.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_BOOTS.get())

                /*
                 *** Ender
                 */

                //Ender Dragon Armor
                .add(HnSItems.ENDER_DRAGON_HELMET.get())
                .add(HnSItems.ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItems.ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItems.ENDER_DRAGON_BOOTS.get())

                .add(HnSItems.GECKOLIB_ENDER_DRAGON_HELMET.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_BOOTS.get())

                /*
                 *** Holy
                 */

                //Seraph Armor
                .add(HnSItems.SERAPH_HELMET.get())
                .add(HnSItems.SERAPH_CHESTPLATE.get())
                .add(HnSItems.SERAPH_LEGGINGS.get())
                .add(HnSItems.SERAPH_BOOTS.get())

                //Gabriel ULTRAKILL Armor
                .add(HnSItems.GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_BOOTS.get())

                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_BOOTS.get())

                //Mothic Witch Armor
                .add(HnSItems.MOTHIC_WITCH_HELMET.get())
                .add(HnSItems.MOTHIC_WITCH_CHESTPLATE.get())
                .add(HnSItems.MOTHIC_WITCH_SECRET_CHESTPLATE.get())
                .add(HnSItems.MOTHIC_WITCH_LEGGINGS.get())
                .add(HnSItems.MOTHIC_WITCH_BOOTS.get())

                /*
                *** Evocation
                */

                //Supreme Witch Armor
                .add(HnSItems.SUPREME_WITCH_HELMET.get())
                .add(HnSItems.SUPREME_WITCH_CHESTPLATE.get())
                .add(HnSItems.SUPREME_WITCH_LEGGINGS.get())
                .add(HnSItems.SUPREME_WITCH_BOOTS.get())

                //Alchemist Supreme Armor
                .add(HnSItems.ALCHEMIST_SUPREME_HELMET.get())
                .add(HnSItems.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .add(HnSItems.ALCHEMIST_SUPREME_LEGGINGS.get())
                .add(HnSItems.ALCHEMIST_SUPREME_BOOTS.get())

                /*
                 *** Radiance
                 */

                //Mycelium Guardian Armor
                .add(HnSItems.MYCELIUM_GUARDIAN_HELMET.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_CHESTPLATE.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_LEGGINGS.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_BOOTS.get())

                /*
                 *** Shadow
                 */

                //Shadow Scale Armor
                .add(HnSItems.SHADOW_SCALE_HELMET.get())
                .add(HnSItems.SHADOW_SCALE_CHESTPLATE.get())
                .add(HnSItems.SHADOW_SCALE_LEGGINGS.get())
                .add(HnSItems.SHADOW_SCALE_BOOTS.get())

                /*
                 *** Eldritch
                 */

                //Infestation Armor
                .add(HnSItems.INFESTATION_HELMET.get())
                .add(HnSItems.INFESTATION_CHESTPLATE.get())
                .add(HnSItems.INFESTATION_LEGGINGS.get())
                .add(HnSItems.INFESTATION_BOOTS.get())

                .add(HnSItems.GECKOLIB_INFESTATION_HELMET.get())
                .add(HnSItems.GECKOLIB_INFESTATION_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_INFESTATION_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_INFESTATION_BOOTS.get())

                /*
                *** Pyrium
                 */

                //Pyrium Armor
                .add(HnSItems.PYRIUM_HELMET.get())
                .add(HnSItems.PYRIUM_CHESTPLATE.get())
                .add(HnSItems.PYRIUM_LEGGINGS.get())
                .add(HnSItems.PYRIUM_BOOTS.get())

                //Pyrium Battlemage Armor
                .add(HnSItems.PYRIUM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_BOOTS.get())

                //Legionnaire Armor
                .add(HnSItems.LEGIONNAIRE_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_BOOTS.get())

                //Legionnaire Ruler Armor
                .add(HnSItems.LEGIONNAIRE_RULER_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_RULER_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_RULER_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_RULER_BOOTS.get())

                //Legionnaire Commander Armor
                .add(HnSItems.LEGIONNAIRE_COMMANDER_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_BOOTS.get())

                //Tyros Armor
                .add(HnSItems.TYROS_HELMET.get())
                .add(HnSItems.TYROS_CHESTPLATE.get())
                .add(HnSItems.TYROS_LEGGINGS.get())
                .add(HnSItems.TYROS_BOOTS.get())

                .add(HnSItems.TYROS_SOUL_HELMET.get())
                .add(HnSItems.TYROS_SOUL_CHESTPLATE.get())
                .add(HnSItems.TYROS_SOUL_LEGGINGS.get())
                .add(HnSItems.TYROS_SOUL_BOOTS.get())

                /*
                *** Cosmetic Battlemage
                 */

                //Frieren Armor
                .add(HnSItems.FRIEREN_HELMET.get())
                .add(HnSItems.FRIEREN_CHESTPLATE.get())
                .add(HnSItems.FRIEREN_LEGGINGS.get())
                .add(HnSItems.FRIEREN_BOOTS.get())

                //SynthV
                .add(HnSItems.SYNTHESIZER_V_HELMET.get())
                .add(HnSItems.SYNTHESIZER_V_CHESTPLATE.get())
                .add(HnSItems.SYNTHESIZER_V_LEGGINGS.get())
                .add(HnSItems.SYNTHESIZER_V_BOOTS.get())

                //UTAU Armor
                .add(HnSItems.UTAU_HELMET.get())
                .add(HnSItems.UTAU_CHESTPLATE.get())
                .add(HnSItems.UTAU_LEGGINGS.get())
                .add(HnSItems.UTAU_BOOTS.get())

                //PROJECT SEKAI Armor
                .add(HnSItems.PROJECT_SEKAI_HELMET.get())
                .add(HnSItems.PROJECT_SEKAI_CHESTPLATE.get())
                .add(HnSItems.PROJECT_SEKAI_LEGGINGS.get())
                .add(HnSItems.PROJECT_SEKAI_BOOTS.get())

                //Rotten Girl Armor
                .add(HnSItems.ROTTEN_GIRL_HELMET.get())
                .add(HnSItems.ROTTEN_GIRL_CHESTPLATE.get())
                .add(HnSItems.ROTTEN_GIRL_LEGGINGS.get())
                .add(HnSItems.ROTTEN_GIRL_BOOTS.get())

                //Neru Armor
                .add(HnSItems.NERU_HELMET.get())
                .add(HnSItems.NERU_CHESTPLATE.get())
                .add(HnSItems.NERU_LEGGINGS.get())
                .add(HnSItems.NERU_BOOTS.get())

                //Giorno Giovanna Armor
                .add(HnSItems.GIORNO_GIOVANNA_HELMET.get())
                .add(HnSItems.GIORNO_GIOVANNA_CHESTPLATE.get())
                .add(HnSItems.GIORNO_GIOVANNA_LEGGINGS.get())
                .add(HnSItems.GIORNO_GIOVANNA_BOOTS.get())

                /*
                *** Mining
                 */

                //Miner Armor
                .add(HnSItems.MINER_HELMET.get())
                .add(HnSItems.MINER_CHESTPLATE.get())
                .add(HnSItems.MINER_LEGGINGS.get())
                .add(HnSItems.MINER_BOOTS.get())

                //Spectral Spelunker Armor
                .add(HnSItems.SPECTRAL_SPELUNKER_HELMET.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_CHESTPLATE.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_LEGGINGS.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_BOOTS.get())

                /*
                *** Archer
                 */

                //Bounty Hunter Armor
                .add(HnSItems.BOUNTY_HUNTER_HELMET.get())
                .add(HnSItems.BOUNTY_HUNTER_CHESTPLATE.get())
                .add(HnSItems.BOUNTY_HUNTER_LEGGINGS.get())
                .add(HnSItems.BOUNTY_HUNTER_BOOTS.get())

                //Frostbite Hunter Armor
                .add(HnSItems.FROSTBITE_HUNTER_HELMET.get())
                .add(HnSItems.FROSTBITE_HUNTER_CHESTPLATE.get())
                .add(HnSItems.FROSTBITE_HUNTER_LEGGINGS.get())
                .add(HnSItems.FROSTBITE_HUNTER_BOOTS.get())

                /*
                *** Melee
                 */

                //Frostbite Knight Armor
                .add(HnSItems.FROSTBITE_KNIGHT_HELMET.get())
                .add(HnSItems.FROSTBITE_KNIGHT_CHESTPLATE.get())
                .add(HnSItems.FROSTBITE_KNIGHT_LEGGINGS.get())
                .add(HnSItems.FROSTBITE_KNIGHT_BOOTS.get())

                //Dreadsteel Knight Armor
                .add(HnSItems.DREADSTEEL_KNIGHT_HELMET.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_CHESTPLATE.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_LEGGINGS.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_BOOTS.get())

                /*
                *** Misc
                 */


                //Magehunter Armor
                .add(HnSItems.MAGEHUNTER_HELMET.get())
                .add(HnSItems.MAGEHUNTER_CHESTPLATE.get())
                .add(HnSItems.MAGEHUNTER_LEGGINGS.get())
                .add(HnSItems.MAGEHUNTER_BOOTS.get())

                //Mithril Battlemage Armor
                .add(HnSItems.MITHRIL_BATTLEMAGE_HELMET.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_BOOTS.get())

                //Enderman Shadowwalker Armor
                .add(HnSItems.ENDERMAN_MASKED.get())
                .add(HnSItems.ENDERMAN_BLINDFOLD.get())
                .add(HnSItems.ENDERMAN_HOOD.get())
                .add(HnSItems.ENDERMAN_CHESTPLATE.get())
                .add(HnSItems.ENDERMAN_LEGGINGS.get())
                .add(HnSItems.ENDERMAN_BOOTS.get())

                //Pyromancer Brute Armor
                .add(HnSItems.PYROMANCER_BRUTE_HELMET.get())
                .add(HnSItems.PYROMANCER_BRUTE_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItems.BISHOP_OF_DECEIT_HELMET.get())
                .add(HnSItems.BISHOP_OF_DECEIT_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItems.NECROMANCER_HELMET.get())
                .add(HnSItems.NECROMANCER_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItems.NAMELESS_ONE_HELMET.get())
                .add(HnSItems.NAMELESS_ONE_CHESTPLATE.get())

                /*
                *** Tributes
                 */


                //Dark Ritual Templar Armor
                .add(HnSItems.DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_BOOTS.get())

                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_BOOTS.get())


                //Fireblossom Battlemage Armor
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                //Arbitrium Robes Armor
                .add(HnSItems.ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_BOOTS.get())

                //Atlas Armor
                .add(HnSItems.ATLAS_HELMET.get())
                .add(HnSItems.ATLAS_CHESTPLATE.get())
                .add(HnSItems.ATLAS_LEGGINGS.get())
                .add(HnSItems.ATLAS_BOOTS.get())

                //Maverick Armor
                .add(HnSItems.MAVERICK_HELMET.get())
                .add(HnSItems.MAVERICK_CHESTPLATE.get())
                .add(HnSItems.MAVERICK_LEGGINGS.get())
                .add(HnSItems.MAVERICK_BOOTS.get())

                //SLC!CAT Armor
                .add(HnSItems.SLC_CAT_HELMET.get())
                .add(HnSItems.SLC_CAT_CHESTPLATE.get())
                .add(HnSItems.SLC_CAT_LEGGINGS.get())
                .add(HnSItems.SLC_CAT_BOOTS.get())

                //Abberant Predator Armor
                .add(HnSItems.ABBERANT_PREDATOR_HELMET.get())
                .add(HnSItems.ABBERANT_PREDATOR_CHESTPLATE.get())
                .add(HnSItems.ABBERANT_PREDATOR_LEGGINGS.get())
                .add(HnSItems.ABBERANT_PREDATOR_BOOTS.get())

                //Iron431 Armor
                .add(HnSItems.IRON431_HELMET.get())
                .add(HnSItems.IRON431_CHESTPLATE.get())
                .add(HnSItems.IRON431_LEGGINGS.get())
                .add(HnSItems.IRON431_BOOTS.get())

                .add(HnSItems.ASCENDED_IRON431_HELMET.get())
                .add(HnSItems.ASCENDED_IRON431_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_IRON431_LEGGINGS.get())
                .add(HnSItems.ASCENDED_IRON431_BOOTS.get())

                //Sacred Robes Armor
                .add(HnSItems.SACRED_ROBES_HELMET.get())
                .add(HnSItems.SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItems.SACRED_ROBES_LEGGINGS.get())
                .add(HnSItems.SACRED_ROBES_BOOTS.get())

                .add(HnSItems.ASCENDED_SACRED_ROBES_HELMET.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_LEGGINGS.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_BOOTS.get())

                //Lemon God Armor
                .add(HnSItems.LEMON_GOD_HELMET.get())
                .add(HnSItems.LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.LEMON_GOD_BOOTS.get())

                .add(HnSItems.ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_BOOTS.get())

                .add(HnSItems.GECKOLIB_LEMON_GOD_HELMET.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_BOOTS.get())

                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_BOOTS.get())

                /*
                *** Weapons
                */

                 //Fire
                .add(HnSItems.FIREBLOSSOM_RAPIER.get())
                .add(HnSItems.DRACONIC_SPLITTER.get())
                .add(HnSItems.FIREBRAND.get())
                .add(HnSItems.WARFLAMING_LANCE.get())
                .add(HnSItems.RAVENS_BANE.get())
                .add(HnSItems.VOLCANO.get())

                //Ice
                .add(HnSItems.ICE_PIKE.get())
                .add(HnSItems.FROSTBURN_DAGGER.get())

                //Lightning
                .add(HnSItems.BEONGAE.get())
                .add(HnSItems.SKYSCORCHER.get())

                //Nature
                .add(HnSItems.BOUNTIFUL_HARVEST.get())
                .add(HnSItems.THORN_CHAKRAM.get())
                 .add(HnSItems.BLADE_OF_GRASS.get())

                //Blood
                .add(HnSItems.VAMPIRE_KNIVES.get())

                //Ender
                .add(HnSItems.OBSIDIAN_CLAYMORE.get())
                .add(HnSItems.STARFURY.get())

                //Radiance
                .add(HnSItems.SPECTRUM.get())
                .add(HnSItems.MEOWMERE.get())
                .add(HnSItems.HAMMUSH.get())

                //Shadow
                .add(HnSItems.LIGHTS_BANE.get())
                .add(HnSItems.NIGHTS_EDGE.get())
                .add(HnSItems.TRUE_NIGHTS_EDGE.get())

                //Holy
                .add(HnSItems.HAMMER_OF_JUSTICE.get())
                .add(HnSItems.DIVINE_GREATSWORD.get())
                .add(HnSItems.EXCALIBUR.get())
                .add(HnSItems.HAZENS_EXCALIBUR.get())
                .add(HnSItems.ISS_EXCALIBUR.get())

                //Evocation
                .add(HnSItems.MALICE.get())
                .add(HnSItems.ANCIENT_WARRIORS_AXE.get())

                //Eldritch
                .add(HnSItems.THE_DEVOURER.get())

                //Misc
                .add(HnSItems.MAGE_BANE.get())
                .add(HnSItems.LEGIONNAIRE_WARLOCK_AXE.get())
                .add(HnSItems.MURAMASA.get())
                .add(HnSItems.DAWNMAKER.get())


                /*
                *** Tools
                 */

                .add(HnSItems.SPECTRAL_PICKAXE.get())
                .add(HnSItems.PICKAXE_AXE.get())
                .add(HnSItems.PICKAXE_AXE_DIVINE_GOLD.get())

        ;

        tag(ItemTags.EQUIPPABLE_ENCHANTABLE)
                /*
                *** Fire
                 */

                //Calamitas Armor
                .add(HnSItems.CALAMITAS_HELMET.get())
                .add(HnSItems.CALAMITAS_CHESTPLATE.get())
                .add(HnSItems.CALAMITAS_LEGGINGS.get())
                .add(HnSItems.CALAMITAS_BOOTS.get())

                //Blazeborne Armor
                .add(HnSItems.BLAZEBORNE_HELMET.get())
                .add(HnSItems.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItems.BLAZEBORNE_LEGGINGS.get())
                .add(HnSItems.BLAZEBORNE_BOOTS.get())

                //Soul Flame Armor
                .add(HnSItems.SOUL_FLAME_HELMET.get())
                .add(HnSItems.SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItems.SOUL_FLAME_LEGGINGS.get())
                .add(HnSItems.SOUL_FLAME_BOOTS.get())

                .add(HnSItems.GECKOLIB_SOUL_FLAME_HELMET.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_BOOTS.get())

                //Hazel Armor
                .add(HnSItems.HAZEL_HELMET.get())
                .add(HnSItems.HAZEL_CHESTPLATE.get())
                .add(HnSItems.HAZEL_HOLY_MOLLY_CHESTPLATE.get())
                .add(HnSItems.HAZEL_LEGGINGS.get())
                .add(HnSItems.HAZEL_BOOTS.get())

                /*
                *** Ice
                 */

                //Cryogenic Ruler Armor
                .add(HnSItems.CRYOGENIC_RULER_HELMET.get())
                .add(HnSItems.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSItems.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSItems.CRYOGENIC_RULER_BOOTS.get())

                //Crystal Arachnid Armor
                .add(HnSItems.CRYSTAL_ARACHNID_HELMET.get())
                .add(HnSItems.CRYSTAL_ARACHNID_CHESTPLATE.get())
                .add(HnSItems.CRYSTAL_ARACHNID_LEGGINGS.get())
                .add(HnSItems.CRYSTAL_ARACHNID_BOOTS.get())

                //Herta Puppet Armor
                .add(HnSItems.HERTA_PUPPET_HELMET.get())
                .add(HnSItems.HERTA_PUPPET_CHESTPLATE.get())
                .add(HnSItems.HERTA_PUPPET_LEGGINGS.get())
                .add(HnSItems.HERTA_PUPPET_BOOTS.get())

                /*
                *** Lightning
                 */

                //Cryogenic Ruler Armor
                .add(HnSItems.CHARGED_SCOURGE_HELMET.get())
                .add(HnSItems.CHARGED_SCOURGE_CHESTPLATE.get())
                .add(HnSItems.CHARGED_SCOURGE_LEGGINGS.get())
                .add(HnSItems.CHARGED_SCOURGE_BOOTS.get())

                //Thunder Prowler Armor
                .add(HnSItems.THUNDER_PROWLER_HELMET.get())
                .add(HnSItems.THUNDER_PROWLER_CHESTPLATE.get())
                .add(HnSItems.THUNDER_PROWLER_LEGGINGS.get())
                .add(HnSItems.THUNDER_PROWLER_BOOTS.get())

                /*
                *** Nature
                 */

                //Creaking Sorcerer Armor
                .add(HnSItems.CREAKING_HELMET.get())
                .add(HnSItems.CREAKING_CHESTPLATE.get())
                .add(HnSItems.CREAKING_LEGGINGS.get())
                .add(HnSItems.CREAKING_BOOTS.get())

                // Chlorophyte Armor
                .add(HnSItems.CHLOROPHYTE_HELMET.get())
                .add(HnSItems.CHLOROPHYTE_MASK.get())
                .add(HnSItems.CHLOROPHYTE_HEADGEAR.get())
                .add(HnSItems.CHLOROPHYTE_CHESTPLATE.get())
                .add(HnSItems.CHLOROPHYTE_LEGGINGS.get())
                .add(HnSItems.CHLOROPHYTE_BOOTS.get())

                /*
                *** Blood
                 */

                //Flesh Mass Armor
                .add(HnSItems.FLESH_MASS_HELMET.get())
                .add(HnSItems.FLESH_MASS_CHESTPLATE.get())
                .add(HnSItems.FLESH_MASS_LEGGINGS.get())
                .add(HnSItems.FLESH_MASS_BOOTS.get())

                //The Wither Armor
                .add(HnSItems.THE_WITHER_HELMET.get())
                .add(HnSItems.THE_WITHER_CHESTPLATE.get())
                .add(HnSItems.THE_WITHER_LEGGINGS.get())
                .add(HnSItems.THE_WITHER_BOOTS.get())

                .add(HnSItems.GECKOLIB_THE_WITHER_HELMET.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_BOOTS.get())

                /*
                 *** Ender
                 */

                //Ender Dragon Armor
                .add(HnSItems.ENDER_DRAGON_HELMET.get())
                .add(HnSItems.ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItems.ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItems.ENDER_DRAGON_BOOTS.get())

                .add(HnSItems.GECKOLIB_ENDER_DRAGON_HELMET.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_BOOTS.get())

                /*
                 *** Holy
                 */

                //Seraph Armor
                .add(HnSItems.SERAPH_HELMET.get())
                .add(HnSItems.SERAPH_CHESTPLATE.get())
                .add(HnSItems.SERAPH_LEGGINGS.get())
                .add(HnSItems.SERAPH_BOOTS.get())

                //Gabriel ULTRAKILL Armor
                .add(HnSItems.GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_BOOTS.get())

                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_BOOTS.get())

                //Mothic Witch Armor
                .add(HnSItems.MOTHIC_WITCH_HELMET.get())
                .add(HnSItems.MOTHIC_WITCH_CHESTPLATE.get())
                .add(HnSItems.MOTHIC_WITCH_SECRET_CHESTPLATE.get())
                .add(HnSItems.MOTHIC_WITCH_LEGGINGS.get())
                .add(HnSItems.MOTHIC_WITCH_BOOTS.get())

                /*
                *** Evocation
                */

                //Supreme Witch Armor
                .add(HnSItems.SUPREME_WITCH_HELMET.get())
                .add(HnSItems.SUPREME_WITCH_CHESTPLATE.get())
                .add(HnSItems.SUPREME_WITCH_LEGGINGS.get())
                .add(HnSItems.SUPREME_WITCH_BOOTS.get())

                //Alchemist Supreme Armor
                .add(HnSItems.ALCHEMIST_SUPREME_HELMET.get())
                .add(HnSItems.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .add(HnSItems.ALCHEMIST_SUPREME_LEGGINGS.get())
                .add(HnSItems.ALCHEMIST_SUPREME_BOOTS.get())

                /*
                 *** Radiance
                 */

                //Mycelium Guardian Armor
                .add(HnSItems.MYCELIUM_GUARDIAN_HELMET.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_CHESTPLATE.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_LEGGINGS.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_BOOTS.get())

                /*
                 *** Shadow
                 */

                //Shadow Scale Armor
                .add(HnSItems.SHADOW_SCALE_HELMET.get())
                .add(HnSItems.SHADOW_SCALE_CHESTPLATE.get())
                .add(HnSItems.SHADOW_SCALE_LEGGINGS.get())
                .add(HnSItems.SHADOW_SCALE_BOOTS.get())

                /*
                 *** Eldritch
                 */

                //Infestation Armor
                .add(HnSItems.INFESTATION_HELMET.get())
                .add(HnSItems.INFESTATION_CHESTPLATE.get())
                .add(HnSItems.INFESTATION_LEGGINGS.get())
                .add(HnSItems.INFESTATION_BOOTS.get())

                .add(HnSItems.GECKOLIB_INFESTATION_HELMET.get())
                .add(HnSItems.GECKOLIB_INFESTATION_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_INFESTATION_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_INFESTATION_BOOTS.get())

                /*
                *** Pyrium
                 */

                //Pyrium Armor
                .add(HnSItems.PYRIUM_HELMET.get())
                .add(HnSItems.PYRIUM_CHESTPLATE.get())
                .add(HnSItems.PYRIUM_LEGGINGS.get())
                .add(HnSItems.PYRIUM_BOOTS.get())

                //Pyrium Battlemage Armor
                .add(HnSItems.PYRIUM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_BOOTS.get())

                //Legionnaire Armor
                .add(HnSItems.LEGIONNAIRE_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_BOOTS.get())

                //Legionnaire Ruler Armor
                .add(HnSItems.LEGIONNAIRE_RULER_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_RULER_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_RULER_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_RULER_BOOTS.get())

                //Legionnaire Commander Armor
                .add(HnSItems.LEGIONNAIRE_COMMANDER_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_BOOTS.get())

                //Tyros Armor
                .add(HnSItems.TYROS_HELMET.get())
                .add(HnSItems.TYROS_CHESTPLATE.get())
                .add(HnSItems.TYROS_LEGGINGS.get())
                .add(HnSItems.TYROS_BOOTS.get())

                .add(HnSItems.TYROS_SOUL_HELMET.get())
                .add(HnSItems.TYROS_SOUL_CHESTPLATE.get())
                .add(HnSItems.TYROS_SOUL_LEGGINGS.get())
                .add(HnSItems.TYROS_SOUL_BOOTS.get())

                /*
                *** Cosmetic Battlemage
                 */

                //Frieren Armor
                .add(HnSItems.FRIEREN_HELMET.get())
                .add(HnSItems.FRIEREN_CHESTPLATE.get())
                .add(HnSItems.FRIEREN_LEGGINGS.get())
                .add(HnSItems.FRIEREN_BOOTS.get())

                //SynthV
                .add(HnSItems.SYNTHESIZER_V_HELMET.get())
                .add(HnSItems.SYNTHESIZER_V_CHESTPLATE.get())
                .add(HnSItems.SYNTHESIZER_V_LEGGINGS.get())
                .add(HnSItems.SYNTHESIZER_V_BOOTS.get())

                //UTAU Armor
                .add(HnSItems.UTAU_HELMET.get())
                .add(HnSItems.UTAU_CHESTPLATE.get())
                .add(HnSItems.UTAU_LEGGINGS.get())
                .add(HnSItems.UTAU_BOOTS.get())

                //PROJECT SEKAI Armor
                .add(HnSItems.PROJECT_SEKAI_HELMET.get())
                .add(HnSItems.PROJECT_SEKAI_CHESTPLATE.get())
                .add(HnSItems.PROJECT_SEKAI_LEGGINGS.get())
                .add(HnSItems.PROJECT_SEKAI_BOOTS.get())

                //Rotten Girl Armor
                .add(HnSItems.ROTTEN_GIRL_HELMET.get())
                .add(HnSItems.ROTTEN_GIRL_CHESTPLATE.get())
                .add(HnSItems.ROTTEN_GIRL_LEGGINGS.get())
                .add(HnSItems.ROTTEN_GIRL_BOOTS.get())

                //Neru Armor
                .add(HnSItems.NERU_HELMET.get())
                .add(HnSItems.NERU_CHESTPLATE.get())
                .add(HnSItems.NERU_LEGGINGS.get())
                .add(HnSItems.NERU_BOOTS.get())

                //Giorno Giovanna Armor
                .add(HnSItems.GIORNO_GIOVANNA_HELMET.get())
                .add(HnSItems.GIORNO_GIOVANNA_CHESTPLATE.get())
                .add(HnSItems.GIORNO_GIOVANNA_LEGGINGS.get())
                .add(HnSItems.GIORNO_GIOVANNA_BOOTS.get())

                /*
                *** Mining
                 */

                //Miner Armor
                .add(HnSItems.MINER_HELMET.get())
                .add(HnSItems.MINER_CHESTPLATE.get())
                .add(HnSItems.MINER_LEGGINGS.get())
                .add(HnSItems.MINER_BOOTS.get())

                //Spectral Spelunker Armor
                .add(HnSItems.SPECTRAL_SPELUNKER_HELMET.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_CHESTPLATE.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_LEGGINGS.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_BOOTS.get())

                /*
                *** Archer
                 */

                //Bounty Hunter Armor
                .add(HnSItems.BOUNTY_HUNTER_HELMET.get())
                .add(HnSItems.BOUNTY_HUNTER_CHESTPLATE.get())
                .add(HnSItems.BOUNTY_HUNTER_LEGGINGS.get())
                .add(HnSItems.BOUNTY_HUNTER_BOOTS.get())

                //Frostbite Hunter Armor
                .add(HnSItems.FROSTBITE_HUNTER_HELMET.get())
                .add(HnSItems.FROSTBITE_HUNTER_CHESTPLATE.get())
                .add(HnSItems.FROSTBITE_HUNTER_LEGGINGS.get())
                .add(HnSItems.FROSTBITE_HUNTER_BOOTS.get())

                /*
                *** Melee
                 */

                //Frostbite Knight Armor
                .add(HnSItems.FROSTBITE_KNIGHT_HELMET.get())
                .add(HnSItems.FROSTBITE_KNIGHT_CHESTPLATE.get())
                .add(HnSItems.FROSTBITE_KNIGHT_LEGGINGS.get())
                .add(HnSItems.FROSTBITE_KNIGHT_BOOTS.get())

                //Dreadsteel Knight Armor
                .add(HnSItems.DREADSTEEL_KNIGHT_HELMET.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_CHESTPLATE.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_LEGGINGS.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_BOOTS.get())

                /*
                *** Misc
                 */


                //Magehunter Armor
                .add(HnSItems.MAGEHUNTER_HELMET.get())
                .add(HnSItems.MAGEHUNTER_CHESTPLATE.get())
                .add(HnSItems.MAGEHUNTER_LEGGINGS.get())
                .add(HnSItems.MAGEHUNTER_BOOTS.get())

                //Mithril Battlemage Armor
                .add(HnSItems.MITHRIL_BATTLEMAGE_HELMET.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_BOOTS.get())

                /*
                *** Tributes
                 */


                //Dark Ritual Templar Armor
                .add(HnSItems.DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_BOOTS.get())

                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_BOOTS.get())


                //Fireblossom Battlemage Armor
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                //Arbitrium Robes Armor
                .add(HnSItems.ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_BOOTS.get())

                //Atlas Armor
                .add(HnSItems.ATLAS_HELMET.get())
                .add(HnSItems.ATLAS_CHESTPLATE.get())
                .add(HnSItems.ATLAS_LEGGINGS.get())
                .add(HnSItems.ATLAS_BOOTS.get())

                //Maverick Armor
                .add(HnSItems.MAVERICK_HELMET.get())
                .add(HnSItems.MAVERICK_CHESTPLATE.get())
                .add(HnSItems.MAVERICK_LEGGINGS.get())
                .add(HnSItems.MAVERICK_BOOTS.get())

                //SLC!CAT Armor
                .add(HnSItems.SLC_CAT_HELMET.get())
                .add(HnSItems.SLC_CAT_CHESTPLATE.get())
                .add(HnSItems.SLC_CAT_LEGGINGS.get())
                .add(HnSItems.SLC_CAT_BOOTS.get())

                //Abberant Predator Armor
                .add(HnSItems.ABBERANT_PREDATOR_HELMET.get())
                .add(HnSItems.ABBERANT_PREDATOR_CHESTPLATE.get())
                .add(HnSItems.ABBERANT_PREDATOR_LEGGINGS.get())
                .add(HnSItems.ABBERANT_PREDATOR_BOOTS.get())

                //Iron431 Armor
                .add(HnSItems.IRON431_HELMET.get())
                .add(HnSItems.IRON431_CHESTPLATE.get())
                .add(HnSItems.IRON431_LEGGINGS.get())
                .add(HnSItems.IRON431_BOOTS.get())

                .add(HnSItems.ASCENDED_IRON431_HELMET.get())
                .add(HnSItems.ASCENDED_IRON431_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_IRON431_LEGGINGS.get())
                .add(HnSItems.ASCENDED_IRON431_BOOTS.get())

                //Sacred Robes Armor
                .add(HnSItems.SACRED_ROBES_HELMET.get())
                .add(HnSItems.SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItems.SACRED_ROBES_LEGGINGS.get())
                .add(HnSItems.SACRED_ROBES_BOOTS.get())

                .add(HnSItems.ASCENDED_SACRED_ROBES_HELMET.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_LEGGINGS.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_BOOTS.get())

                //Lemon God Armor
                .add(HnSItems.LEMON_GOD_HELMET.get())
                .add(HnSItems.LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.LEMON_GOD_BOOTS.get())

                .add(HnSItems.ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_BOOTS.get())

                .add(HnSItems.GECKOLIB_LEMON_GOD_HELMET.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_BOOTS.get())

                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_BOOTS.get())
        ;

        tag(ItemTags.DURABILITY_ENCHANTABLE)

                /*
                *** Armor
                 */

                /*
                *** Fire
                 */

                //Calamitas Armor
                .add(HnSItems.CALAMITAS_HELMET.get())
                .add(HnSItems.CALAMITAS_CHESTPLATE.get())
                .add(HnSItems.CALAMITAS_LEGGINGS.get())
                .add(HnSItems.CALAMITAS_BOOTS.get())

                //Blazeborne Armor
                .add(HnSItems.BLAZEBORNE_HELMET.get())
                .add(HnSItems.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItems.BLAZEBORNE_LEGGINGS.get())
                .add(HnSItems.BLAZEBORNE_BOOTS.get())

                //Soul Flame Armor
                .add(HnSItems.SOUL_FLAME_HELMET.get())
                .add(HnSItems.SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItems.SOUL_FLAME_LEGGINGS.get())
                .add(HnSItems.SOUL_FLAME_BOOTS.get())

                .add(HnSItems.GECKOLIB_SOUL_FLAME_HELMET.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_BOOTS.get())

                //Hazel Armor
                .add(HnSItems.HAZEL_HELMET.get())
                .add(HnSItems.HAZEL_CHESTPLATE.get())
                .add(HnSItems.HAZEL_HOLY_MOLLY_CHESTPLATE.get())
                .add(HnSItems.HAZEL_LEGGINGS.get())
                .add(HnSItems.HAZEL_BOOTS.get())

                /*
                *** Ice
                 */

                //Cryogenic Ruler Armor
                .add(HnSItems.CRYOGENIC_RULER_HELMET.get())
                .add(HnSItems.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSItems.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSItems.CRYOGENIC_RULER_BOOTS.get())

                //Crystal Arachnid Armor
                .add(HnSItems.CRYSTAL_ARACHNID_HELMET.get())
                .add(HnSItems.CRYSTAL_ARACHNID_CHESTPLATE.get())
                .add(HnSItems.CRYSTAL_ARACHNID_LEGGINGS.get())
                .add(HnSItems.CRYSTAL_ARACHNID_BOOTS.get())

                //Herta Puppet Armor
                .add(HnSItems.HERTA_PUPPET_HELMET.get())
                .add(HnSItems.HERTA_PUPPET_CHESTPLATE.get())
                .add(HnSItems.HERTA_PUPPET_LEGGINGS.get())
                .add(HnSItems.HERTA_PUPPET_BOOTS.get())

                /*
                *** Lightning
                 */

                //Cryogenic Ruler Armor
                .add(HnSItems.CHARGED_SCOURGE_HELMET.get())
                .add(HnSItems.CHARGED_SCOURGE_CHESTPLATE.get())
                .add(HnSItems.CHARGED_SCOURGE_LEGGINGS.get())
                .add(HnSItems.CHARGED_SCOURGE_BOOTS.get())

                //Thunder Prowler Armor
                .add(HnSItems.THUNDER_PROWLER_HELMET.get())
                .add(HnSItems.THUNDER_PROWLER_CHESTPLATE.get())
                .add(HnSItems.THUNDER_PROWLER_LEGGINGS.get())
                .add(HnSItems.THUNDER_PROWLER_BOOTS.get())

                /*
                *** Nature
                 */

                //Creaking Sorcerer Armor
                .add(HnSItems.CREAKING_HELMET.get())
                .add(HnSItems.CREAKING_CHESTPLATE.get())
                .add(HnSItems.CREAKING_LEGGINGS.get())
                .add(HnSItems.CREAKING_BOOTS.get())

                // Chlorophyte Armor
                .add(HnSItems.CHLOROPHYTE_HELMET.get())
                .add(HnSItems.CHLOROPHYTE_MASK.get())
                .add(HnSItems.CHLOROPHYTE_HEADGEAR.get())
                .add(HnSItems.CHLOROPHYTE_CHESTPLATE.get())
                .add(HnSItems.CHLOROPHYTE_LEGGINGS.get())
                .add(HnSItems.CHLOROPHYTE_BOOTS.get())

                /*
                *** Blood
                 */

                //Flesh Mass Armor
                .add(HnSItems.FLESH_MASS_HELMET.get())
                .add(HnSItems.FLESH_MASS_CHESTPLATE.get())
                .add(HnSItems.FLESH_MASS_LEGGINGS.get())
                .add(HnSItems.FLESH_MASS_BOOTS.get())

                //The Wither Armor
                .add(HnSItems.THE_WITHER_HELMET.get())
                .add(HnSItems.THE_WITHER_CHESTPLATE.get())
                .add(HnSItems.THE_WITHER_LEGGINGS.get())
                .add(HnSItems.THE_WITHER_BOOTS.get())

                .add(HnSItems.GECKOLIB_THE_WITHER_HELMET.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_BOOTS.get())

                /*
                 *** Ender
                 */

                //Ender Dragon Armor
                .add(HnSItems.ENDER_DRAGON_HELMET.get())
                .add(HnSItems.ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItems.ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItems.ENDER_DRAGON_BOOTS.get())

                .add(HnSItems.GECKOLIB_ENDER_DRAGON_HELMET.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_BOOTS.get())

                /*
                 *** Holy
                 */

                //Seraph Armor
                .add(HnSItems.SERAPH_HELMET.get())
                .add(HnSItems.SERAPH_CHESTPLATE.get())
                .add(HnSItems.SERAPH_LEGGINGS.get())
                .add(HnSItems.SERAPH_BOOTS.get())

                //Gabriel ULTRAKILL Armor
                .add(HnSItems.GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_BOOTS.get())

                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_BOOTS.get())

                //Mothic Witch Armor
                .add(HnSItems.MOTHIC_WITCH_HELMET.get())
                .add(HnSItems.MOTHIC_WITCH_CHESTPLATE.get())
                .add(HnSItems.MOTHIC_WITCH_SECRET_CHESTPLATE.get())
                .add(HnSItems.MOTHIC_WITCH_LEGGINGS.get())
                .add(HnSItems.MOTHIC_WITCH_BOOTS.get())

                /*
                *** Evocation
                */

                //Supreme Witch Armor
                .add(HnSItems.SUPREME_WITCH_HELMET.get())
                .add(HnSItems.SUPREME_WITCH_CHESTPLATE.get())
                .add(HnSItems.SUPREME_WITCH_LEGGINGS.get())
                .add(HnSItems.SUPREME_WITCH_BOOTS.get())

                //Alchemist Supreme Armor
                .add(HnSItems.ALCHEMIST_SUPREME_HELMET.get())
                .add(HnSItems.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .add(HnSItems.ALCHEMIST_SUPREME_LEGGINGS.get())
                .add(HnSItems.ALCHEMIST_SUPREME_BOOTS.get())

                /*
                 *** Radiance
                 */

                //Mycelium Guardian Armor
                .add(HnSItems.MYCELIUM_GUARDIAN_HELMET.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_CHESTPLATE.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_LEGGINGS.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_BOOTS.get())

                /*
                 *** Shadow
                 */

                //Shadow Scale Armor
                .add(HnSItems.SHADOW_SCALE_HELMET.get())
                .add(HnSItems.SHADOW_SCALE_CHESTPLATE.get())
                .add(HnSItems.SHADOW_SCALE_LEGGINGS.get())
                .add(HnSItems.SHADOW_SCALE_BOOTS.get())

                /*
                 *** Eldritch
                 */

                //Infestation Armor
                .add(HnSItems.INFESTATION_HELMET.get())
                .add(HnSItems.INFESTATION_CHESTPLATE.get())
                .add(HnSItems.INFESTATION_LEGGINGS.get())
                .add(HnSItems.INFESTATION_BOOTS.get())

                .add(HnSItems.GECKOLIB_INFESTATION_HELMET.get())
                .add(HnSItems.GECKOLIB_INFESTATION_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_INFESTATION_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_INFESTATION_BOOTS.get())

                /*
                *** Pyrium
                 */

                //Pyrium Armor
                .add(HnSItems.PYRIUM_HELMET.get())
                .add(HnSItems.PYRIUM_CHESTPLATE.get())
                .add(HnSItems.PYRIUM_LEGGINGS.get())
                .add(HnSItems.PYRIUM_BOOTS.get())

                //Pyrium Battlemage Armor
                .add(HnSItems.PYRIUM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_BOOTS.get())

                //Legionnaire Armor
                .add(HnSItems.LEGIONNAIRE_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_BOOTS.get())

                //Legionnaire Ruler Armor
                .add(HnSItems.LEGIONNAIRE_RULER_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_RULER_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_RULER_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_RULER_BOOTS.get())

                //Legionnaire Commander Armor
                .add(HnSItems.LEGIONNAIRE_COMMANDER_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_BOOTS.get())

                //Tyros Armor
                .add(HnSItems.TYROS_HELMET.get())
                .add(HnSItems.TYROS_CHESTPLATE.get())
                .add(HnSItems.TYROS_LEGGINGS.get())
                .add(HnSItems.TYROS_BOOTS.get())

                .add(HnSItems.TYROS_SOUL_HELMET.get())
                .add(HnSItems.TYROS_SOUL_CHESTPLATE.get())
                .add(HnSItems.TYROS_SOUL_LEGGINGS.get())
                .add(HnSItems.TYROS_SOUL_BOOTS.get())

                /*
                *** Cosmetic Battlemage
                 */

                //Frieren Armor
                .add(HnSItems.FRIEREN_HELMET.get())
                .add(HnSItems.FRIEREN_CHESTPLATE.get())
                .add(HnSItems.FRIEREN_LEGGINGS.get())
                .add(HnSItems.FRIEREN_BOOTS.get())

                //SynthV
                .add(HnSItems.SYNTHESIZER_V_HELMET.get())
                .add(HnSItems.SYNTHESIZER_V_CHESTPLATE.get())
                .add(HnSItems.SYNTHESIZER_V_LEGGINGS.get())
                .add(HnSItems.SYNTHESIZER_V_BOOTS.get())

                //UTAU Armor
                .add(HnSItems.UTAU_HELMET.get())
                .add(HnSItems.UTAU_CHESTPLATE.get())
                .add(HnSItems.UTAU_LEGGINGS.get())
                .add(HnSItems.UTAU_BOOTS.get())

                //PROJECT SEKAI Armor
                .add(HnSItems.PROJECT_SEKAI_HELMET.get())
                .add(HnSItems.PROJECT_SEKAI_CHESTPLATE.get())
                .add(HnSItems.PROJECT_SEKAI_LEGGINGS.get())
                .add(HnSItems.PROJECT_SEKAI_BOOTS.get())

                //Rotten Girl Armor
                .add(HnSItems.ROTTEN_GIRL_HELMET.get())
                .add(HnSItems.ROTTEN_GIRL_CHESTPLATE.get())
                .add(HnSItems.ROTTEN_GIRL_LEGGINGS.get())
                .add(HnSItems.ROTTEN_GIRL_BOOTS.get())

                //Neru Armor
                .add(HnSItems.NERU_HELMET.get())
                .add(HnSItems.NERU_CHESTPLATE.get())
                .add(HnSItems.NERU_LEGGINGS.get())
                .add(HnSItems.NERU_BOOTS.get())

                //Giorno Giovanna Armor
                .add(HnSItems.GIORNO_GIOVANNA_HELMET.get())
                .add(HnSItems.GIORNO_GIOVANNA_CHESTPLATE.get())
                .add(HnSItems.GIORNO_GIOVANNA_LEGGINGS.get())
                .add(HnSItems.GIORNO_GIOVANNA_BOOTS.get())

                /*
                *** Mining
                 */

                //Miner Armor
                .add(HnSItems.MINER_HELMET.get())
                .add(HnSItems.MINER_CHESTPLATE.get())
                .add(HnSItems.MINER_LEGGINGS.get())
                .add(HnSItems.MINER_BOOTS.get())

                //Spectral Spelunker Armor
                .add(HnSItems.SPECTRAL_SPELUNKER_HELMET.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_CHESTPLATE.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_LEGGINGS.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_BOOTS.get())

                /*
                *** Archer
                 */

                //Bounty Hunter Armor
                .add(HnSItems.BOUNTY_HUNTER_HELMET.get())
                .add(HnSItems.BOUNTY_HUNTER_CHESTPLATE.get())
                .add(HnSItems.BOUNTY_HUNTER_LEGGINGS.get())
                .add(HnSItems.BOUNTY_HUNTER_BOOTS.get())

                //Frostbite Hunter Armor
                .add(HnSItems.FROSTBITE_HUNTER_HELMET.get())
                .add(HnSItems.FROSTBITE_HUNTER_CHESTPLATE.get())
                .add(HnSItems.FROSTBITE_HUNTER_LEGGINGS.get())
                .add(HnSItems.FROSTBITE_HUNTER_BOOTS.get())

                /*
                *** Melee
                 */

                //Frostbite Knight Armor
                .add(HnSItems.FROSTBITE_KNIGHT_HELMET.get())
                .add(HnSItems.FROSTBITE_KNIGHT_CHESTPLATE.get())
                .add(HnSItems.FROSTBITE_KNIGHT_LEGGINGS.get())
                .add(HnSItems.FROSTBITE_KNIGHT_BOOTS.get())

                //Dreadsteel Knight Armor
                .add(HnSItems.DREADSTEEL_KNIGHT_HELMET.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_CHESTPLATE.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_LEGGINGS.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_BOOTS.get())

                /*
                *** Misc
                 */


                //Magehunter Armor
                .add(HnSItems.MAGEHUNTER_HELMET.get())
                .add(HnSItems.MAGEHUNTER_CHESTPLATE.get())
                .add(HnSItems.MAGEHUNTER_LEGGINGS.get())
                .add(HnSItems.MAGEHUNTER_BOOTS.get())

                //Mithril Battlemage Armor
                .add(HnSItems.MITHRIL_BATTLEMAGE_HELMET.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_BOOTS.get())

                //Enderman Shadowwalker Armor
                .add(HnSItems.ENDERMAN_MASKED.get())
                .add(HnSItems.ENDERMAN_BLINDFOLD.get())
                .add(HnSItems.ENDERMAN_HOOD.get())
                .add(HnSItems.ENDERMAN_CHESTPLATE.get())
                .add(HnSItems.ENDERMAN_LEGGINGS.get())
                .add(HnSItems.ENDERMAN_BOOTS.get())

                //Pyromancer Brute Armor
                .add(HnSItems.PYROMANCER_BRUTE_HELMET.get())
                .add(HnSItems.PYROMANCER_BRUTE_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItems.BISHOP_OF_DECEIT_HELMET.get())
                .add(HnSItems.BISHOP_OF_DECEIT_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItems.NECROMANCER_HELMET.get())
                .add(HnSItems.NECROMANCER_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItems.NAMELESS_ONE_HELMET.get())
                .add(HnSItems.NAMELESS_ONE_CHESTPLATE.get())

                /*
                *** Tributes
                 */


                //Dark Ritual Templar Armor
                .add(HnSItems.DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_BOOTS.get())

                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_BOOTS.get())


                //Fireblossom Battlemage Armor
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                //Arbitrium Robes Armor
                .add(HnSItems.ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_BOOTS.get())

                //Atlas Armor
                .add(HnSItems.ATLAS_HELMET.get())
                .add(HnSItems.ATLAS_CHESTPLATE.get())
                .add(HnSItems.ATLAS_LEGGINGS.get())
                .add(HnSItems.ATLAS_BOOTS.get())

                //Maverick Armor
                .add(HnSItems.MAVERICK_HELMET.get())
                .add(HnSItems.MAVERICK_CHESTPLATE.get())
                .add(HnSItems.MAVERICK_LEGGINGS.get())
                .add(HnSItems.MAVERICK_BOOTS.get())

                //SLC!CAT Armor
                .add(HnSItems.SLC_CAT_HELMET.get())
                .add(HnSItems.SLC_CAT_CHESTPLATE.get())
                .add(HnSItems.SLC_CAT_LEGGINGS.get())
                .add(HnSItems.SLC_CAT_BOOTS.get())

                //Abberant Predator Armor
                .add(HnSItems.ABBERANT_PREDATOR_HELMET.get())
                .add(HnSItems.ABBERANT_PREDATOR_CHESTPLATE.get())
                .add(HnSItems.ABBERANT_PREDATOR_LEGGINGS.get())
                .add(HnSItems.ABBERANT_PREDATOR_BOOTS.get())

                //Iron431 Armor
                .add(HnSItems.IRON431_HELMET.get())
                .add(HnSItems.IRON431_CHESTPLATE.get())
                .add(HnSItems.IRON431_LEGGINGS.get())
                .add(HnSItems.IRON431_BOOTS.get())

                .add(HnSItems.ASCENDED_IRON431_HELMET.get())
                .add(HnSItems.ASCENDED_IRON431_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_IRON431_LEGGINGS.get())
                .add(HnSItems.ASCENDED_IRON431_BOOTS.get())

                //Sacred Robes Armor
                .add(HnSItems.SACRED_ROBES_HELMET.get())
                .add(HnSItems.SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItems.SACRED_ROBES_LEGGINGS.get())
                .add(HnSItems.SACRED_ROBES_BOOTS.get())

                .add(HnSItems.ASCENDED_SACRED_ROBES_HELMET.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_LEGGINGS.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_BOOTS.get())

                //Lemon God Armor
                .add(HnSItems.LEMON_GOD_HELMET.get())
                .add(HnSItems.LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.LEMON_GOD_BOOTS.get())

                .add(HnSItems.ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_BOOTS.get())

                .add(HnSItems.GECKOLIB_LEMON_GOD_HELMET.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_BOOTS.get())

                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_BOOTS.get())

                /*
                *** Weapons
                 */

                //Fire
                .add(HnSItems.FIREBLOSSOM_RAPIER.get())
                .add(HnSItems.DRACONIC_SPLITTER.get())
                .add(HnSItems.FIREBRAND.get())
                .add(HnSItems.WARFLAMING_LANCE.get())
                .add(HnSItems.RAVENS_BANE.get())
                .add(HnSItems.VOLCANO.get())

                //Ice
                .add(HnSItems.ICE_PIKE.get())
                .add(HnSItems.FROSTBURN_DAGGER.get())

                //Lightning
                .add(HnSItems.BEONGAE.get())
                .add(HnSItems.SKYSCORCHER.get())

                //Nature
                .add(HnSItems.BOUNTIFUL_HARVEST.get())
                .add(HnSItems.THORN_CHAKRAM.get())
                 .add(HnSItems.BLADE_OF_GRASS.get())

                //Blood
                .add(HnSItems.VAMPIRE_KNIVES.get())

                //Ender
                .add(HnSItems.OBSIDIAN_CLAYMORE.get())
                .add(HnSItems.STARFURY.get())

                //Radiance
                .add(HnSItems.SPECTRUM.get())
                .add(HnSItems.MEOWMERE.get())
                .add(HnSItems.HAMMUSH.get())

                //Shadow
                .add(HnSItems.LIGHTS_BANE.get())
                .add(HnSItems.NIGHTS_EDGE.get())
                .add(HnSItems.TRUE_NIGHTS_EDGE.get())

                //Holy
                .add(HnSItems.HAMMER_OF_JUSTICE.get())
                .add(HnSItems.DIVINE_GREATSWORD.get())
                .add(HnSItems.EXCALIBUR.get())
                .add(HnSItems.HAZENS_EXCALIBUR.get())
                .add(HnSItems.ISS_EXCALIBUR.get())

                //Evocation
                .add(HnSItems.MALICE.get())
                .add(HnSItems.ANCIENT_WARRIORS_AXE.get())

                //Eldritch
                .add(HnSItems.THE_DEVOURER.get())

                //Misc
                .add(HnSItems.MAGE_BANE.get())
                .add(HnSItems.LEGIONNAIRE_WARLOCK_AXE.get())
                .add(HnSItems.MURAMASA.get())
                .add(HnSItems.DAWNMAKER.get())

                /*
                *** Tools
                */

                .add(HnSItems.SPECTRAL_PICKAXE.get())
                .add(HnSItems.PICKAXE_AXE.get())
                .add(HnSItems.PICKAXE_AXE_DIVINE_GOLD.get())
        ;

        /*
        *** Armor Tags
         */

        tag(Tags.Items.ARMORS)

                /*
                *** Fire
                 */

                //Calamitas Armor
                .add(HnSItems.CALAMITAS_HELMET.get())
                .add(HnSItems.CALAMITAS_CHESTPLATE.get())
                .add(HnSItems.CALAMITAS_LEGGINGS.get())
                .add(HnSItems.CALAMITAS_BOOTS.get())

                //Blazeborne Armor
                .add(HnSItems.BLAZEBORNE_HELMET.get())
                .add(HnSItems.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItems.BLAZEBORNE_LEGGINGS.get())
                .add(HnSItems.BLAZEBORNE_BOOTS.get())

                //Soul Flame Armor
                .add(HnSItems.SOUL_FLAME_HELMET.get())
                .add(HnSItems.SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItems.SOUL_FLAME_LEGGINGS.get())
                .add(HnSItems.SOUL_FLAME_BOOTS.get())

                .add(HnSItems.GECKOLIB_SOUL_FLAME_HELMET.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_BOOTS.get())

                //Hazel Armor
                .add(HnSItems.HAZEL_HELMET.get())
                .add(HnSItems.HAZEL_CHESTPLATE.get())
                .add(HnSItems.HAZEL_HOLY_MOLLY_CHESTPLATE.get())
                .add(HnSItems.HAZEL_LEGGINGS.get())
                .add(HnSItems.HAZEL_BOOTS.get())

                /*
                *** Ice
                 */

                //Cryogenic Ruler Armor
                .add(HnSItems.CRYOGENIC_RULER_HELMET.get())
                .add(HnSItems.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSItems.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSItems.CRYOGENIC_RULER_BOOTS.get())

                //Crystal Arachnid Armor
                .add(HnSItems.CRYSTAL_ARACHNID_HELMET.get())
                .add(HnSItems.CRYSTAL_ARACHNID_CHESTPLATE.get())
                .add(HnSItems.CRYSTAL_ARACHNID_LEGGINGS.get())
                .add(HnSItems.CRYSTAL_ARACHNID_BOOTS.get())

                //Herta Puppet Armor
                .add(HnSItems.HERTA_PUPPET_HELMET.get())
                .add(HnSItems.HERTA_PUPPET_CHESTPLATE.get())
                .add(HnSItems.HERTA_PUPPET_LEGGINGS.get())
                .add(HnSItems.HERTA_PUPPET_BOOTS.get())

                /*
                *** Lightning
                 */

                //Cryogenic Ruler Armor
                .add(HnSItems.CHARGED_SCOURGE_HELMET.get())
                .add(HnSItems.CHARGED_SCOURGE_CHESTPLATE.get())
                .add(HnSItems.CHARGED_SCOURGE_LEGGINGS.get())
                .add(HnSItems.CHARGED_SCOURGE_BOOTS.get())

                //Thunder Prowler Armor
                .add(HnSItems.THUNDER_PROWLER_HELMET.get())
                .add(HnSItems.THUNDER_PROWLER_CHESTPLATE.get())
                .add(HnSItems.THUNDER_PROWLER_LEGGINGS.get())
                .add(HnSItems.THUNDER_PROWLER_BOOTS.get())

                /*
                *** Nature
                 */

                //Creaking Sorcerer Armor
                .add(HnSItems.CREAKING_HELMET.get())
                .add(HnSItems.CREAKING_CHESTPLATE.get())
                .add(HnSItems.CREAKING_LEGGINGS.get())
                .add(HnSItems.CREAKING_BOOTS.get())

                // Chlorophyte Armor
                .add(HnSItems.CHLOROPHYTE_HELMET.get())
                .add(HnSItems.CHLOROPHYTE_MASK.get())
                .add(HnSItems.CHLOROPHYTE_HEADGEAR.get())
                .add(HnSItems.CHLOROPHYTE_CHESTPLATE.get())
                .add(HnSItems.CHLOROPHYTE_LEGGINGS.get())
                .add(HnSItems.CHLOROPHYTE_BOOTS.get())

                /*
                *** Blood
                 */

                //Flesh Mass Armor
                .add(HnSItems.FLESH_MASS_HELMET.get())
                .add(HnSItems.FLESH_MASS_CHESTPLATE.get())
                .add(HnSItems.FLESH_MASS_LEGGINGS.get())
                .add(HnSItems.FLESH_MASS_BOOTS.get())

                //The Wither Armor
                .add(HnSItems.THE_WITHER_HELMET.get())
                .add(HnSItems.THE_WITHER_CHESTPLATE.get())
                .add(HnSItems.THE_WITHER_LEGGINGS.get())
                .add(HnSItems.THE_WITHER_BOOTS.get())

                .add(HnSItems.GECKOLIB_THE_WITHER_HELMET.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_BOOTS.get())

                /*
                 *** Ender
                 */

                //Ender Dragon Armor
                .add(HnSItems.ENDER_DRAGON_HELMET.get())
                .add(HnSItems.ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItems.ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItems.ENDER_DRAGON_BOOTS.get())

                .add(HnSItems.GECKOLIB_ENDER_DRAGON_HELMET.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_BOOTS.get())

                /*
                 *** Holy
                 */

                //Seraph Armor
                .add(HnSItems.SERAPH_HELMET.get())
                .add(HnSItems.SERAPH_CHESTPLATE.get())
                .add(HnSItems.SERAPH_LEGGINGS.get())
                .add(HnSItems.SERAPH_BOOTS.get())

                //Gabriel ULTRAKILL Armor
                .add(HnSItems.GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_BOOTS.get())

                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_BOOTS.get())

                //Mothic Witch Armor
                .add(HnSItems.MOTHIC_WITCH_HELMET.get())
                .add(HnSItems.MOTHIC_WITCH_CHESTPLATE.get())
                .add(HnSItems.MOTHIC_WITCH_SECRET_CHESTPLATE.get())
                .add(HnSItems.MOTHIC_WITCH_LEGGINGS.get())
                .add(HnSItems.MOTHIC_WITCH_BOOTS.get())

                /*
                *** Evocation
                */

                //Supreme Witch Armor
                .add(HnSItems.SUPREME_WITCH_HELMET.get())
                .add(HnSItems.SUPREME_WITCH_CHESTPLATE.get())
                .add(HnSItems.SUPREME_WITCH_LEGGINGS.get())
                .add(HnSItems.SUPREME_WITCH_BOOTS.get())

                //Alchemist Supreme Armor
                .add(HnSItems.ALCHEMIST_SUPREME_HELMET.get())
                .add(HnSItems.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .add(HnSItems.ALCHEMIST_SUPREME_LEGGINGS.get())
                .add(HnSItems.ALCHEMIST_SUPREME_BOOTS.get())

                /*
                 *** Radiance
                 */

                //Mycelium Guardian Armor
                .add(HnSItems.MYCELIUM_GUARDIAN_HELMET.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_CHESTPLATE.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_LEGGINGS.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_BOOTS.get())

                /*
                 *** Shadow
                 */

                //Shadow Scale Armor
                .add(HnSItems.SHADOW_SCALE_HELMET.get())
                .add(HnSItems.SHADOW_SCALE_CHESTPLATE.get())
                .add(HnSItems.SHADOW_SCALE_LEGGINGS.get())
                .add(HnSItems.SHADOW_SCALE_BOOTS.get())

                /*
                 *** Eldritch
                 */

                //Infestation Armor
                .add(HnSItems.INFESTATION_HELMET.get())
                .add(HnSItems.INFESTATION_CHESTPLATE.get())
                .add(HnSItems.INFESTATION_LEGGINGS.get())
                .add(HnSItems.INFESTATION_BOOTS.get())

                .add(HnSItems.GECKOLIB_INFESTATION_HELMET.get())
                .add(HnSItems.GECKOLIB_INFESTATION_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_INFESTATION_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_INFESTATION_BOOTS.get())

                /*
                *** Pyrium
                 */

                //Pyrium Armor
                .add(HnSItems.PYRIUM_HELMET.get())
                .add(HnSItems.PYRIUM_CHESTPLATE.get())
                .add(HnSItems.PYRIUM_LEGGINGS.get())
                .add(HnSItems.PYRIUM_BOOTS.get())

                //Pyrium Battlemage Armor
                .add(HnSItems.PYRIUM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_BOOTS.get())

                //Legionnaire Armor
                .add(HnSItems.LEGIONNAIRE_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_BOOTS.get())

                //Legionnaire Ruler Armor
                .add(HnSItems.LEGIONNAIRE_RULER_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_RULER_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_RULER_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_RULER_BOOTS.get())

                //Legionnaire Commander Armor
                .add(HnSItems.LEGIONNAIRE_COMMANDER_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_BOOTS.get())

                //Tyros Armor
                .add(HnSItems.TYROS_HELMET.get())
                .add(HnSItems.TYROS_CHESTPLATE.get())
                .add(HnSItems.TYROS_LEGGINGS.get())
                .add(HnSItems.TYROS_BOOTS.get())

                .add(HnSItems.TYROS_SOUL_HELMET.get())
                .add(HnSItems.TYROS_SOUL_CHESTPLATE.get())
                .add(HnSItems.TYROS_SOUL_LEGGINGS.get())
                .add(HnSItems.TYROS_SOUL_BOOTS.get())

                /*
                *** Cosmetic Battlemage
                 */

                //Frieren Armor
                .add(HnSItems.FRIEREN_HELMET.get())
                .add(HnSItems.FRIEREN_CHESTPLATE.get())
                .add(HnSItems.FRIEREN_LEGGINGS.get())
                .add(HnSItems.FRIEREN_BOOTS.get())

                //SynthV
                .add(HnSItems.SYNTHESIZER_V_HELMET.get())
                .add(HnSItems.SYNTHESIZER_V_CHESTPLATE.get())
                .add(HnSItems.SYNTHESIZER_V_LEGGINGS.get())
                .add(HnSItems.SYNTHESIZER_V_BOOTS.get())

                //UTAU Armor
                .add(HnSItems.UTAU_HELMET.get())
                .add(HnSItems.UTAU_CHESTPLATE.get())
                .add(HnSItems.UTAU_LEGGINGS.get())
                .add(HnSItems.UTAU_BOOTS.get())

                //PROJECT SEKAI Armor
                .add(HnSItems.PROJECT_SEKAI_HELMET.get())
                .add(HnSItems.PROJECT_SEKAI_CHESTPLATE.get())
                .add(HnSItems.PROJECT_SEKAI_LEGGINGS.get())
                .add(HnSItems.PROJECT_SEKAI_BOOTS.get())

                //Rotten Girl Armor
                .add(HnSItems.ROTTEN_GIRL_HELMET.get())
                .add(HnSItems.ROTTEN_GIRL_CHESTPLATE.get())
                .add(HnSItems.ROTTEN_GIRL_LEGGINGS.get())
                .add(HnSItems.ROTTEN_GIRL_BOOTS.get())

                //Neru Armor
                .add(HnSItems.NERU_HELMET.get())
                .add(HnSItems.NERU_CHESTPLATE.get())
                .add(HnSItems.NERU_LEGGINGS.get())
                .add(HnSItems.NERU_BOOTS.get())

                //Giorno Giovanna Armor
                .add(HnSItems.GIORNO_GIOVANNA_HELMET.get())
                .add(HnSItems.GIORNO_GIOVANNA_CHESTPLATE.get())
                .add(HnSItems.GIORNO_GIOVANNA_LEGGINGS.get())
                .add(HnSItems.GIORNO_GIOVANNA_BOOTS.get())

                /*
                *** Mining
                 */

                //Miner Armor
                .add(HnSItems.MINER_HELMET.get())
                .add(HnSItems.MINER_CHESTPLATE.get())
                .add(HnSItems.MINER_LEGGINGS.get())
                .add(HnSItems.MINER_BOOTS.get())

                //Spectral Spelunker Armor
                .add(HnSItems.SPECTRAL_SPELUNKER_HELMET.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_CHESTPLATE.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_LEGGINGS.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_BOOTS.get())

                /*
                *** Archer
                 */

                //Bounty Hunter Armor
                .add(HnSItems.BOUNTY_HUNTER_HELMET.get())
                .add(HnSItems.BOUNTY_HUNTER_CHESTPLATE.get())
                .add(HnSItems.BOUNTY_HUNTER_LEGGINGS.get())
                .add(HnSItems.BOUNTY_HUNTER_BOOTS.get())

                //Frostbite Hunter Armor
                .add(HnSItems.FROSTBITE_HUNTER_HELMET.get())
                .add(HnSItems.FROSTBITE_HUNTER_CHESTPLATE.get())
                .add(HnSItems.FROSTBITE_HUNTER_LEGGINGS.get())
                .add(HnSItems.FROSTBITE_HUNTER_BOOTS.get())

                /*
                *** Melee
                 */

                //Frostbite Knight Armor
                .add(HnSItems.FROSTBITE_KNIGHT_HELMET.get())
                .add(HnSItems.FROSTBITE_KNIGHT_CHESTPLATE.get())
                .add(HnSItems.FROSTBITE_KNIGHT_LEGGINGS.get())
                .add(HnSItems.FROSTBITE_KNIGHT_BOOTS.get())

                //Dreadsteel Knight Armor
                .add(HnSItems.DREADSTEEL_KNIGHT_HELMET.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_CHESTPLATE.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_LEGGINGS.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_BOOTS.get())

                /*
                *** Misc
                 */


                //Magehunter Armor
                .add(HnSItems.MAGEHUNTER_HELMET.get())
                .add(HnSItems.MAGEHUNTER_CHESTPLATE.get())
                .add(HnSItems.MAGEHUNTER_LEGGINGS.get())
                .add(HnSItems.MAGEHUNTER_BOOTS.get())

                //Mithril Battlemage Armor
                .add(HnSItems.MITHRIL_BATTLEMAGE_HELMET.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_BOOTS.get())

                //Enderman Shadowwalker Armor
                .add(HnSItems.ENDERMAN_MASKED.get())
                .add(HnSItems.ENDERMAN_BLINDFOLD.get())
                .add(HnSItems.ENDERMAN_HOOD.get())
                .add(HnSItems.ENDERMAN_CHESTPLATE.get())
                .add(HnSItems.ENDERMAN_LEGGINGS.get())
                .add(HnSItems.ENDERMAN_BOOTS.get())

                //Pyromancer Brute Armor
                .add(HnSItems.PYROMANCER_BRUTE_HELMET.get())
                .add(HnSItems.PYROMANCER_BRUTE_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItems.BISHOP_OF_DECEIT_HELMET.get())
                .add(HnSItems.BISHOP_OF_DECEIT_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItems.NECROMANCER_HELMET.get())
                .add(HnSItems.NECROMANCER_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItems.NAMELESS_ONE_HELMET.get())
                .add(HnSItems.NAMELESS_ONE_CHESTPLATE.get())


                /*
                *** Tributes
                 */


                //Dark Ritual Templar Armor
                .add(HnSItems.DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_BOOTS.get())

                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_BOOTS.get())


                //Fireblossom Battlemage Armor
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                //Arbitrium Robes Armor
                .add(HnSItems.ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_BOOTS.get())

                //Atlas Armor
                .add(HnSItems.ATLAS_HELMET.get())
                .add(HnSItems.ATLAS_CHESTPLATE.get())
                .add(HnSItems.ATLAS_LEGGINGS.get())
                .add(HnSItems.ATLAS_BOOTS.get())

                //Maverick Armor
                .add(HnSItems.MAVERICK_HELMET.get())
                .add(HnSItems.MAVERICK_CHESTPLATE.get())
                .add(HnSItems.MAVERICK_LEGGINGS.get())
                .add(HnSItems.MAVERICK_BOOTS.get())

                //SLC!CAT Armor
                .add(HnSItems.SLC_CAT_HELMET.get())
                .add(HnSItems.SLC_CAT_CHESTPLATE.get())
                .add(HnSItems.SLC_CAT_LEGGINGS.get())
                .add(HnSItems.SLC_CAT_BOOTS.get())

                //Abberant Predator Armor
                .add(HnSItems.ABBERANT_PREDATOR_HELMET.get())
                .add(HnSItems.ABBERANT_PREDATOR_CHESTPLATE.get())
                .add(HnSItems.ABBERANT_PREDATOR_LEGGINGS.get())
                .add(HnSItems.ABBERANT_PREDATOR_BOOTS.get())

                //Iron431 Armor
                .add(HnSItems.IRON431_HELMET.get())
                .add(HnSItems.IRON431_CHESTPLATE.get())
                .add(HnSItems.IRON431_LEGGINGS.get())
                .add(HnSItems.IRON431_BOOTS.get())

                .add(HnSItems.ASCENDED_IRON431_HELMET.get())
                .add(HnSItems.ASCENDED_IRON431_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_IRON431_LEGGINGS.get())
                .add(HnSItems.ASCENDED_IRON431_BOOTS.get())

                //Sacred Robes Armor
                .add(HnSItems.SACRED_ROBES_HELMET.get())
                .add(HnSItems.SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItems.SACRED_ROBES_LEGGINGS.get())
                .add(HnSItems.SACRED_ROBES_BOOTS.get())

                .add(HnSItems.ASCENDED_SACRED_ROBES_HELMET.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_LEGGINGS.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_BOOTS.get())

                //Lemon God Armor
                .add(HnSItems.LEMON_GOD_HELMET.get())
                .add(HnSItems.LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.LEMON_GOD_BOOTS.get())

                .add(HnSItems.ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_BOOTS.get())

                .add(HnSItems.GECKOLIB_LEMON_GOD_HELMET.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_BOOTS.get())

                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_BOOTS.get())
        ;

        tag(ItemTags.HEAD_ARMOR)
                .add(HnSItems.CALAMITAS_HELMET.get())
                .add(HnSItems.BLAZEBORNE_HELMET.get())
                .add(HnSItems.SOUL_FLAME_HELMET.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_HELMET.get())
                .add(HnSItems.HAZEL_HELMET.get())
                .add(HnSItems.CRYOGENIC_RULER_HELMET.get())
                .add(HnSItems.CRYSTAL_ARACHNID_HELMET.get())
                .add(HnSItems.HERTA_PUPPET_HELMET.get())
                .add(HnSItems.CHARGED_SCOURGE_HELMET.get())
                .add(HnSItems.THUNDER_PROWLER_HELMET.get())
                .add(HnSItems.CREAKING_HELMET.get())
                .add(HnSItems.FLESH_MASS_HELMET.get())
                .add(HnSItems.THE_WITHER_HELMET.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_HELMET.get())
                .add(HnSItems.ENDER_DRAGON_HELMET.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_HELMET.get())
                .add(HnSItems.SERAPH_HELMET.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItems.MOTHIC_WITCH_HELMET.get())
                .add(HnSItems.SUPREME_WITCH_HELMET.get())
                .add(HnSItems.ALCHEMIST_SUPREME_HELMET.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_HELMET.get())
                .add(HnSItems.SHADOW_SCALE_HELMET.get())
                .add(HnSItems.INFESTATION_HELMET.get())
                .add(HnSItems.GECKOLIB_INFESTATION_HELMET.get())
                .add(HnSItems.PYRIUM_HELMET.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_RULER_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_HELMET.get())
                .add(HnSItems.TYROS_HELMET.get())
                .add(HnSItems.TYROS_SOUL_HELMET.get())
                .add(HnSItems.FRIEREN_HELMET.get())
                .add(HnSItems.SYNTHESIZER_V_HELMET.get())
                .add(HnSItems.UTAU_HELMET.get())
                .add(HnSItems.PROJECT_SEKAI_HELMET.get())
                .add(HnSItems.ROTTEN_GIRL_HELMET.get())
                .add(HnSItems.NERU_HELMET.get())
                .add(HnSItems.GIORNO_GIOVANNA_HELMET.get())
                .add(HnSItems.MINER_HELMET.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_HELMET.get())
                .add(HnSItems.BOUNTY_HUNTER_HELMET.get())
                .add(HnSItems.FROSTBITE_HUNTER_HELMET.get())
                .add(HnSItems.FROSTBITE_KNIGHT_HELMET.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_HELMET.get())
                .add(HnSItems.MAGEHUNTER_HELMET.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_HELMET.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.ATLAS_HELMET.get())
                .add(HnSItems.MAVERICK_HELMET.get())
                .add(HnSItems.SLC_CAT_HELMET.get())
                .add(HnSItems.ABBERANT_PREDATOR_HELMET.get())
                .add(HnSItems.IRON431_HELMET.get())
                .add(HnSItems.ASCENDED_IRON431_HELMET.get())
                .add(HnSItems.SACRED_ROBES_HELMET.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_HELMET.get())
                .add(HnSItems.LEMON_GOD_HELMET.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_HELMET.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItems.ENDERMAN_MASKED.get())
                .add(HnSItems.ENDERMAN_BLINDFOLD.get())
                .add(HnSItems.ENDERMAN_HOOD.get())
                .add(HnSItems.PYROMANCER_BRUTE_HELMET.get())
                .add(HnSItems.BISHOP_OF_DECEIT_HELMET.get())
                .add(HnSItems.NECROMANCER_HELMET.get())
                .add(HnSItems.NAMELESS_ONE_HELMET.get())
                .add(HnSItems.CHLOROPHYTE_HELMET.get())
                .add(HnSItems.CHLOROPHYTE_HEADGEAR.get())
                .add(HnSItems.CHLOROPHYTE_MASK.get())
        ;

        tag(ItemTags.CHEST_ARMOR)
                .add(HnSItems.CALAMITAS_CHESTPLATE.get())
                .add(HnSItems.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItems.SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItems.HAZEL_CHESTPLATE.get())
                .add(HnSItems.HAZEL_HOLY_MOLLY_CHESTPLATE.get())
                .add(HnSItems.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSItems.CRYSTAL_ARACHNID_CHESTPLATE.get())
                .add(HnSItems.HERTA_PUPPET_CHESTPLATE.get())
                .add(HnSItems.CHARGED_SCOURGE_CHESTPLATE.get())
                .add(HnSItems.THUNDER_PROWLER_CHESTPLATE.get())
                .add(HnSItems.CREAKING_CHESTPLATE.get())
                .add(HnSItems.FLESH_MASS_CHESTPLATE.get())
                .add(HnSItems.FLESH_MASS_LEGGINGS.get())
                .add(HnSItems.THE_WITHER_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_CHESTPLATE.get())
                .add(HnSItems.ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItems.SERAPH_CHESTPLATE.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItems.MOTHIC_WITCH_CHESTPLATE.get())
                .add(HnSItems.MOTHIC_WITCH_SECRET_CHESTPLATE.get())
                .add(HnSItems.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_CHESTPLATE.get())
                .add(HnSItems.SHADOW_SCALE_CHESTPLATE.get())
                .add(HnSItems.INFESTATION_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_INFESTATION_CHESTPLATE.get())
                .add(HnSItems.PYRIUM_CHESTPLATE.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_RULER_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_CHESTPLATE.get())
                .add(HnSItems.TYROS_CHESTPLATE.get())
                .add(HnSItems.TYROS_SOUL_CHESTPLATE.get())
                .add(HnSItems.FRIEREN_CHESTPLATE.get())
                .add(HnSItems.SYNTHESIZER_V_CHESTPLATE.get())
                .add(HnSItems.UTAU_CHESTPLATE.get())
                .add(HnSItems.PROJECT_SEKAI_CHESTPLATE.get())
                .add(HnSItems.ROTTEN_GIRL_CHESTPLATE.get())
                .add(HnSItems.NERU_CHESTPLATE.get())
                .add(HnSItems.GIORNO_GIOVANNA_CHESTPLATE.get())
                .add(HnSItems.MINER_CHESTPLATE.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_CHESTPLATE.get())
                .add(HnSItems.BOUNTY_HUNTER_CHESTPLATE.get())
                .add(HnSItems.FROSTBITE_HUNTER_CHESTPLATE.get())
                .add(HnSItems.FROSTBITE_KNIGHT_CHESTPLATE.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_CHESTPLATE.get())
                .add(HnSItems.MAGEHUNTER_CHESTPLATE.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.ATLAS_CHESTPLATE.get())
                .add(HnSItems.MAVERICK_CHESTPLATE.get())
                .add(HnSItems.SLC_CAT_CHESTPLATE.get())
                .add(HnSItems.ABBERANT_PREDATOR_CHESTPLATE.get())
                .add(HnSItems.IRON431_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_IRON431_CHESTPLATE.get())
                .add(HnSItems.SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItems.LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.ENDERMAN_CHESTPLATE.get())
                .add(HnSItems.PYROMANCER_BRUTE_CHESTPLATE.get())
                .add(HnSItems.BISHOP_OF_DECEIT_CHESTPLATE.get())
                .add(HnSItems.NECROMANCER_CHESTPLATE.get())
                .add(HnSItems.NAMELESS_ONE_CHESTPLATE.get())
                .add(HnSItems.CHLOROPHYTE_CHESTPLATE.get())
        ;

        tag(ItemTags.LEG_ARMOR)
                .add(HnSItems.CALAMITAS_LEGGINGS.get())
                .add(HnSItems.BLAZEBORNE_LEGGINGS.get())
                .add(HnSItems.SOUL_FLAME_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_LEGGINGS.get())
                .add(HnSItems.HAZEL_LEGGINGS.get())
                .add(HnSItems.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSItems.CRYSTAL_ARACHNID_LEGGINGS.get())
                .add(HnSItems.HERTA_PUPPET_LEGGINGS.get())
                .add(HnSItems.CHARGED_SCOURGE_LEGGINGS.get())
                .add(HnSItems.THUNDER_PROWLER_LEGGINGS.get())
                .add(HnSItems.CREAKING_LEGGINGS.get())
                .add(HnSItems.FLESH_MASS_LEGGINGS.get())
                .add(HnSItems.THE_WITHER_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_LEGGINGS.get())
                .add(HnSItems.ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItems.SERAPH_LEGGINGS.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItems.MOTHIC_WITCH_LEGGINGS.get())
                .add(HnSItems.SUPREME_WITCH_LEGGINGS.get())
                .add(HnSItems.ALCHEMIST_SUPREME_LEGGINGS.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_LEGGINGS.get())
                .add(HnSItems.SHADOW_SCALE_LEGGINGS.get())
                .add(HnSItems.INFESTATION_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_INFESTATION_LEGGINGS.get())
                .add(HnSItems.PYRIUM_LEGGINGS.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_RULER_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_LEGGINGS.get())
                .add(HnSItems.TYROS_LEGGINGS.get())
                .add(HnSItems.TYROS_SOUL_LEGGINGS.get())
                .add(HnSItems.FRIEREN_LEGGINGS.get())
                .add(HnSItems.SYNTHESIZER_V_LEGGINGS.get())
                .add(HnSItems.UTAU_LEGGINGS.get())
                .add(HnSItems.PROJECT_SEKAI_LEGGINGS.get())
                .add(HnSItems.ROTTEN_GIRL_LEGGINGS.get())
                .add(HnSItems.NERU_LEGGINGS.get())
                .add(HnSItems.GIORNO_GIOVANNA_LEGGINGS.get())
                .add(HnSItems.MINER_LEGGINGS.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_LEGGINGS.get())
                .add(HnSItems.BOUNTY_HUNTER_LEGGINGS.get())
                .add(HnSItems.FROSTBITE_HUNTER_LEGGINGS.get())
                .add(HnSItems.FROSTBITE_KNIGHT_LEGGINGS.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_LEGGINGS.get())
                .add(HnSItems.MAGEHUNTER_LEGGINGS.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.ATLAS_LEGGINGS.get())
                .add(HnSItems.MAVERICK_LEGGINGS.get())
                .add(HnSItems.SLC_CAT_LEGGINGS.get())
                .add(HnSItems.ABBERANT_PREDATOR_LEGGINGS.get())
                .add(HnSItems.IRON431_LEGGINGS.get())
                .add(HnSItems.ASCENDED_IRON431_LEGGINGS.get())
                .add(HnSItems.SACRED_ROBES_LEGGINGS.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_LEGGINGS.get())
                .add(HnSItems.LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.ENDERMAN_LEGGINGS.get())
                .add(HnSItems.NECROMANCER_LEGGINGS.get())
                .add(HnSItems.NAMELESS_ONE_LEGGINGS.get())
                .add(HnSItems.CHLOROPHYTE_LEGGINGS.get())
        ;

        tag(ItemTags.FOOT_ARMOR)
                .add(HnSItems.CALAMITAS_BOOTS.get())
                .add(HnSItems.BLAZEBORNE_BOOTS.get())
                .add(HnSItems.SOUL_FLAME_BOOTS.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_BOOTS.get())
                .add(HnSItems.HAZEL_BOOTS.get())
                .add(HnSItems.CRYOGENIC_RULER_BOOTS.get())
                .add(HnSItems.CRYSTAL_ARACHNID_BOOTS.get())
                .add(HnSItems.HERTA_PUPPET_BOOTS.get())
                .add(HnSItems.CHARGED_SCOURGE_BOOTS.get())
                .add(HnSItems.THUNDER_PROWLER_BOOTS.get())
                .add(HnSItems.CREAKING_BOOTS.get())
                .add(HnSItems.FLESH_MASS_BOOTS.get())
                .add(HnSItems.THE_WITHER_BOOTS.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_BOOTS.get())
                .add(HnSItems.ENDER_DRAGON_BOOTS.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_BOOTS.get())
                .add(HnSItems.SERAPH_BOOTS.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_BOOTS.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_BOOTS.get())
                .add(HnSItems.MOTHIC_WITCH_BOOTS.get())
                .add(HnSItems.SUPREME_WITCH_BOOTS.get())
                .add(HnSItems.ALCHEMIST_SUPREME_BOOTS.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_BOOTS.get())
                .add(HnSItems.SHADOW_SCALE_BOOTS.get())
                .add(HnSItems.INFESTATION_BOOTS.get())
                .add(HnSItems.GECKOLIB_INFESTATION_BOOTS.get())
                .add(HnSItems.PYRIUM_BOOTS.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_BOOTS.get())
                .add(HnSItems.LEGIONNAIRE_RULER_BOOTS.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_BOOTS.get())
                .add(HnSItems.TYROS_BOOTS.get())
                .add(HnSItems.TYROS_SOUL_BOOTS.get())
                .add(HnSItems.FRIEREN_BOOTS.get())
                .add(HnSItems.SYNTHESIZER_V_BOOTS.get())
                .add(HnSItems.UTAU_BOOTS.get())
                .add(HnSItems.PROJECT_SEKAI_BOOTS.get())
                .add(HnSItems.ROTTEN_GIRL_BOOTS.get())
                .add(HnSItems.NERU_BOOTS.get())
                .add(HnSItems.GIORNO_GIOVANNA_BOOTS.get())
                .add(HnSItems.MINER_BOOTS.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_BOOTS.get())
                .add(HnSItems.BOUNTY_HUNTER_BOOTS.get())
                .add(HnSItems.FROSTBITE_HUNTER_BOOTS.get())
                .add(HnSItems.FROSTBITE_KNIGHT_BOOTS.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_BOOTS.get())
                .add(HnSItems.MAGEHUNTER_BOOTS.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_BOOTS.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_BOOTS.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_BOOTS.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_BOOTS.get())
                .add(HnSItems.ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItems.ATLAS_BOOTS.get())
                .add(HnSItems.MAVERICK_BOOTS.get())
                .add(HnSItems.SLC_CAT_BOOTS.get())
                .add(HnSItems.ABBERANT_PREDATOR_BOOTS.get())
                .add(HnSItems.IRON431_BOOTS.get())
                .add(HnSItems.ASCENDED_IRON431_BOOTS.get())
                .add(HnSItems.SACRED_ROBES_BOOTS.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_BOOTS.get())
                .add(HnSItems.LEMON_GOD_BOOTS.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_BOOTS.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_BOOTS.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_BOOTS.get())
                .add(HnSItems.ENDERMAN_BOOTS.get())
                .add(HnSItems.CHLOROPHYTE_BOOTS.get())
        ;

        tag(ItemTags.HEAD_ARMOR)
                .add(HnSItems.CALAMITAS_HELMET.get())
                .add(HnSItems.BLAZEBORNE_HELMET.get())
                .add(HnSItems.SOUL_FLAME_HELMET.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_HELMET.get())
                .add(HnSItems.HAZEL_HELMET.get())
                .add(HnSItems.CRYOGENIC_RULER_HELMET.get())
                .add(HnSItems.CRYSTAL_ARACHNID_HELMET.get())
                .add(HnSItems.HERTA_PUPPET_HELMET.get())
                .add(HnSItems.CHARGED_SCOURGE_HELMET.get())
                .add(HnSItems.THUNDER_PROWLER_HELMET.get())
                .add(HnSItems.CREAKING_HELMET.get())
                .add(HnSItems.FLESH_MASS_HELMET.get())
                .add(HnSItems.THE_WITHER_HELMET.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_HELMET.get())
                .add(HnSItems.ENDER_DRAGON_HELMET.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_HELMET.get())
                .add(HnSItems.SERAPH_HELMET.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItems.MOTHIC_WITCH_HELMET.get())
                .add(HnSItems.SUPREME_WITCH_HELMET.get())
                .add(HnSItems.ALCHEMIST_SUPREME_HELMET.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_HELMET.get())
                .add(HnSItems.SHADOW_SCALE_HELMET.get())
                .add(HnSItems.INFESTATION_HELMET.get())
                .add(HnSItems.GECKOLIB_INFESTATION_HELMET.get())
                .add(HnSItems.PYRIUM_HELMET.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_RULER_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_HELMET.get())
                .add(HnSItems.TYROS_HELMET.get())
                .add(HnSItems.TYROS_SOUL_HELMET.get())
                .add(HnSItems.FRIEREN_HELMET.get())
                .add(HnSItems.SYNTHESIZER_V_HELMET.get())
                .add(HnSItems.UTAU_HELMET.get())
                .add(HnSItems.PROJECT_SEKAI_HELMET.get())
                .add(HnSItems.ROTTEN_GIRL_HELMET.get())
                .add(HnSItems.NERU_HELMET.get())
                .add(HnSItems.GIORNO_GIOVANNA_HELMET.get())
                .add(HnSItems.MINER_HELMET.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_HELMET.get())
                .add(HnSItems.BOUNTY_HUNTER_HELMET.get())
                .add(HnSItems.FROSTBITE_HUNTER_HELMET.get())
                .add(HnSItems.FROSTBITE_KNIGHT_HELMET.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_HELMET.get())
                .add(HnSItems.MAGEHUNTER_HELMET.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_HELMET.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.ATLAS_HELMET.get())
                .add(HnSItems.MAVERICK_HELMET.get())
                .add(HnSItems.SLC_CAT_HELMET.get())
                .add(HnSItems.ABBERANT_PREDATOR_HELMET.get())
                .add(HnSItems.IRON431_HELMET.get())
                .add(HnSItems.ASCENDED_IRON431_HELMET.get())
                .add(HnSItems.SACRED_ROBES_HELMET.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_HELMET.get())
                .add(HnSItems.LEMON_GOD_HELMET.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_HELMET.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItems.ENDERMAN_MASKED.get())
                .add(HnSItems.ENDERMAN_BLINDFOLD.get())
                .add(HnSItems.ENDERMAN_HOOD.get())
                .add(HnSItems.PYROMANCER_BRUTE_HELMET.get())
                .add(HnSItems.BISHOP_OF_DECEIT_HELMET.get())
                .add(HnSItems.NECROMANCER_HELMET.get())
                .add(HnSItems.NAMELESS_ONE_HELMET.get())
                .add(HnSItems.CHLOROPHYTE_HELMET.get())
                .add(HnSItems.CHLOROPHYTE_HEADGEAR.get())
                .add(HnSItems.CHLOROPHYTE_MASK.get())
        ;

        tag(ItemTags.CHEST_ARMOR)
                .add(HnSItems.CALAMITAS_CHESTPLATE.get())
                .add(HnSItems.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItems.SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItems.HAZEL_CHESTPLATE.get())
                .add(HnSItems.HAZEL_HOLY_MOLLY_CHESTPLATE.get())
                .add(HnSItems.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSItems.CRYSTAL_ARACHNID_CHESTPLATE.get())
                .add(HnSItems.HERTA_PUPPET_CHESTPLATE.get())
                .add(HnSItems.CHARGED_SCOURGE_CHESTPLATE.get())
                .add(HnSItems.THUNDER_PROWLER_CHESTPLATE.get())
                .add(HnSItems.CREAKING_CHESTPLATE.get())
                .add(HnSItems.FLESH_MASS_CHESTPLATE.get())
                .add(HnSItems.FLESH_MASS_LEGGINGS.get())
                .add(HnSItems.THE_WITHER_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_CHESTPLATE.get())
                .add(HnSItems.ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItems.SERAPH_CHESTPLATE.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItems.MOTHIC_WITCH_CHESTPLATE.get())
                .add(HnSItems.MOTHIC_WITCH_SECRET_CHESTPLATE.get())
                .add(HnSItems.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_CHESTPLATE.get())
                .add(HnSItems.SHADOW_SCALE_CHESTPLATE.get())
                .add(HnSItems.INFESTATION_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_INFESTATION_CHESTPLATE.get())
                .add(HnSItems.PYRIUM_CHESTPLATE.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_RULER_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_CHESTPLATE.get())
                .add(HnSItems.TYROS_CHESTPLATE.get())
                .add(HnSItems.TYROS_SOUL_CHESTPLATE.get())
                .add(HnSItems.FRIEREN_CHESTPLATE.get())
                .add(HnSItems.SYNTHESIZER_V_CHESTPLATE.get())
                .add(HnSItems.UTAU_CHESTPLATE.get())
                .add(HnSItems.PROJECT_SEKAI_CHESTPLATE.get())
                .add(HnSItems.ROTTEN_GIRL_CHESTPLATE.get())
                .add(HnSItems.NERU_CHESTPLATE.get())
                .add(HnSItems.GIORNO_GIOVANNA_CHESTPLATE.get())
                .add(HnSItems.MINER_CHESTPLATE.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_CHESTPLATE.get())
                .add(HnSItems.BOUNTY_HUNTER_CHESTPLATE.get())
                .add(HnSItems.FROSTBITE_HUNTER_CHESTPLATE.get())
                .add(HnSItems.FROSTBITE_KNIGHT_CHESTPLATE.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_CHESTPLATE.get())
                .add(HnSItems.MAGEHUNTER_CHESTPLATE.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.ATLAS_CHESTPLATE.get())
                .add(HnSItems.MAVERICK_CHESTPLATE.get())
                .add(HnSItems.SLC_CAT_CHESTPLATE.get())
                .add(HnSItems.ABBERANT_PREDATOR_CHESTPLATE.get())
                .add(HnSItems.IRON431_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_IRON431_CHESTPLATE.get())
                .add(HnSItems.SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItems.LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.ENDERMAN_CHESTPLATE.get())
                .add(HnSItems.PYROMANCER_BRUTE_CHESTPLATE.get())
                .add(HnSItems.BISHOP_OF_DECEIT_CHESTPLATE.get())
                .add(HnSItems.NECROMANCER_CHESTPLATE.get())
                .add(HnSItems.NAMELESS_ONE_CHESTPLATE.get())
                .add(HnSItems.CHLOROPHYTE_CHESTPLATE.get())
        ;

        tag(ItemTags.LEG_ARMOR)
                .add(HnSItems.CALAMITAS_LEGGINGS.get())
                .add(HnSItems.BLAZEBORNE_LEGGINGS.get())
                .add(HnSItems.SOUL_FLAME_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_LEGGINGS.get())
                .add(HnSItems.HAZEL_LEGGINGS.get())
                .add(HnSItems.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSItems.CRYSTAL_ARACHNID_LEGGINGS.get())
                .add(HnSItems.HERTA_PUPPET_LEGGINGS.get())
                .add(HnSItems.CHARGED_SCOURGE_LEGGINGS.get())
                .add(HnSItems.THUNDER_PROWLER_LEGGINGS.get())
                .add(HnSItems.CREAKING_LEGGINGS.get())
                .add(HnSItems.FLESH_MASS_LEGGINGS.get())
                .add(HnSItems.THE_WITHER_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_LEGGINGS.get())
                .add(HnSItems.ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItems.SERAPH_LEGGINGS.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItems.MOTHIC_WITCH_LEGGINGS.get())
                .add(HnSItems.SUPREME_WITCH_LEGGINGS.get())
                .add(HnSItems.ALCHEMIST_SUPREME_LEGGINGS.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_LEGGINGS.get())
                .add(HnSItems.SHADOW_SCALE_LEGGINGS.get())
                .add(HnSItems.INFESTATION_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_INFESTATION_LEGGINGS.get())
                .add(HnSItems.PYRIUM_LEGGINGS.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_RULER_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_LEGGINGS.get())
                .add(HnSItems.TYROS_LEGGINGS.get())
                .add(HnSItems.TYROS_SOUL_LEGGINGS.get())
                .add(HnSItems.FRIEREN_LEGGINGS.get())
                .add(HnSItems.SYNTHESIZER_V_LEGGINGS.get())
                .add(HnSItems.UTAU_LEGGINGS.get())
                .add(HnSItems.PROJECT_SEKAI_LEGGINGS.get())
                .add(HnSItems.ROTTEN_GIRL_LEGGINGS.get())
                .add(HnSItems.NERU_LEGGINGS.get())
                .add(HnSItems.GIORNO_GIOVANNA_LEGGINGS.get())
                .add(HnSItems.MINER_LEGGINGS.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_LEGGINGS.get())
                .add(HnSItems.BOUNTY_HUNTER_LEGGINGS.get())
                .add(HnSItems.FROSTBITE_HUNTER_LEGGINGS.get())
                .add(HnSItems.FROSTBITE_KNIGHT_LEGGINGS.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_LEGGINGS.get())
                .add(HnSItems.MAGEHUNTER_LEGGINGS.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.ATLAS_LEGGINGS.get())
                .add(HnSItems.MAVERICK_LEGGINGS.get())
                .add(HnSItems.SLC_CAT_LEGGINGS.get())
                .add(HnSItems.ABBERANT_PREDATOR_LEGGINGS.get())
                .add(HnSItems.IRON431_LEGGINGS.get())
                .add(HnSItems.ASCENDED_IRON431_LEGGINGS.get())
                .add(HnSItems.SACRED_ROBES_LEGGINGS.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_LEGGINGS.get())
                .add(HnSItems.LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.ENDERMAN_LEGGINGS.get())
                .add(HnSItems.NECROMANCER_LEGGINGS.get())
                .add(HnSItems.NAMELESS_ONE_LEGGINGS.get())
                .add(HnSItems.CHLOROPHYTE_LEGGINGS.get())
        ;

        tag(Tags.Items.ARMORS)
                .add(HnSItems.CALAMITAS_BOOTS.get())
                .add(HnSItems.BLAZEBORNE_BOOTS.get())
                .add(HnSItems.SOUL_FLAME_BOOTS.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_BOOTS.get())
                .add(HnSItems.HAZEL_BOOTS.get())
                .add(HnSItems.CRYOGENIC_RULER_BOOTS.get())
                .add(HnSItems.CRYSTAL_ARACHNID_BOOTS.get())
                .add(HnSItems.HERTA_PUPPET_BOOTS.get())
                .add(HnSItems.CHARGED_SCOURGE_BOOTS.get())
                .add(HnSItems.THUNDER_PROWLER_BOOTS.get())
                .add(HnSItems.CREAKING_BOOTS.get())
                .add(HnSItems.FLESH_MASS_BOOTS.get())
                .add(HnSItems.THE_WITHER_BOOTS.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_BOOTS.get())
                .add(HnSItems.ENDER_DRAGON_BOOTS.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_BOOTS.get())
                .add(HnSItems.SERAPH_BOOTS.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_BOOTS.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_BOOTS.get())
                .add(HnSItems.MOTHIC_WITCH_BOOTS.get())
                .add(HnSItems.SUPREME_WITCH_BOOTS.get())
                .add(HnSItems.ALCHEMIST_SUPREME_BOOTS.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_BOOTS.get())
                .add(HnSItems.SHADOW_SCALE_BOOTS.get())
                .add(HnSItems.INFESTATION_BOOTS.get())
                .add(HnSItems.GECKOLIB_INFESTATION_BOOTS.get())
                .add(HnSItems.PYRIUM_BOOTS.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_BOOTS.get())
                .add(HnSItems.LEGIONNAIRE_RULER_BOOTS.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_BOOTS.get())
                .add(HnSItems.TYROS_BOOTS.get())
                .add(HnSItems.TYROS_SOUL_BOOTS.get())
                .add(HnSItems.FRIEREN_BOOTS.get())
                .add(HnSItems.SYNTHESIZER_V_BOOTS.get())
                .add(HnSItems.UTAU_BOOTS.get())
                .add(HnSItems.PROJECT_SEKAI_BOOTS.get())
                .add(HnSItems.ROTTEN_GIRL_BOOTS.get())
                .add(HnSItems.NERU_BOOTS.get())
                .add(HnSItems.GIORNO_GIOVANNA_BOOTS.get())
                .add(HnSItems.MINER_BOOTS.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_BOOTS.get())
                .add(HnSItems.BOUNTY_HUNTER_BOOTS.get())
                .add(HnSItems.FROSTBITE_HUNTER_BOOTS.get())
                .add(HnSItems.FROSTBITE_KNIGHT_BOOTS.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_BOOTS.get())
                .add(HnSItems.MAGEHUNTER_BOOTS.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_BOOTS.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_BOOTS.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_BOOTS.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_BOOTS.get())
                .add(HnSItems.ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItems.ATLAS_BOOTS.get())
                .add(HnSItems.MAVERICK_BOOTS.get())
                .add(HnSItems.SLC_CAT_BOOTS.get())
                .add(HnSItems.ABBERANT_PREDATOR_BOOTS.get())
                .add(HnSItems.IRON431_BOOTS.get())
                .add(HnSItems.ASCENDED_IRON431_BOOTS.get())
                .add(HnSItems.SACRED_ROBES_BOOTS.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_BOOTS.get())
                .add(HnSItems.LEMON_GOD_BOOTS.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_BOOTS.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_BOOTS.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_BOOTS.get())
                .add(HnSItems.ENDERMAN_BOOTS.get())
                .add(HnSItems.CHLOROPHYTE_BOOTS.get())
        ;

        tag(ItemTags.ARMOR_ENCHANTABLE)

               /*
                *** Fire
                 */

                //Calamitas Armor
                .add(HnSItems.CALAMITAS_HELMET.get())
                .add(HnSItems.CALAMITAS_CHESTPLATE.get())
                .add(HnSItems.CALAMITAS_LEGGINGS.get())
                .add(HnSItems.CALAMITAS_BOOTS.get())

                //Blazeborne Armor
                .add(HnSItems.BLAZEBORNE_HELMET.get())
                .add(HnSItems.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItems.BLAZEBORNE_LEGGINGS.get())
                .add(HnSItems.BLAZEBORNE_BOOTS.get())

                //Soul Flame Armor
                .add(HnSItems.SOUL_FLAME_HELMET.get())
                .add(HnSItems.SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItems.SOUL_FLAME_LEGGINGS.get())
                .add(HnSItems.SOUL_FLAME_BOOTS.get())

                .add(HnSItems.GECKOLIB_SOUL_FLAME_HELMET.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_BOOTS.get())

                //Hazel Armor
                .add(HnSItems.HAZEL_HELMET.get())
                .add(HnSItems.HAZEL_CHESTPLATE.get())
                .add(HnSItems.HAZEL_HOLY_MOLLY_CHESTPLATE.get())
                .add(HnSItems.HAZEL_LEGGINGS.get())
                .add(HnSItems.HAZEL_BOOTS.get())

                /*
                *** Ice
                 */

                //Cryogenic Ruler Armor
                .add(HnSItems.CRYOGENIC_RULER_HELMET.get())
                .add(HnSItems.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSItems.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSItems.CRYOGENIC_RULER_BOOTS.get())

                //Crystal Arachnid Armor
                .add(HnSItems.CRYSTAL_ARACHNID_HELMET.get())
                .add(HnSItems.CRYSTAL_ARACHNID_CHESTPLATE.get())
                .add(HnSItems.CRYSTAL_ARACHNID_LEGGINGS.get())
                .add(HnSItems.CRYSTAL_ARACHNID_BOOTS.get())

                //Herta Puppet Armor
                .add(HnSItems.HERTA_PUPPET_HELMET.get())
                .add(HnSItems.HERTA_PUPPET_CHESTPLATE.get())
                .add(HnSItems.HERTA_PUPPET_LEGGINGS.get())
                .add(HnSItems.HERTA_PUPPET_BOOTS.get())

                /*
                *** Lightning
                 */

                //Cryogenic Ruler Armor
                .add(HnSItems.CHARGED_SCOURGE_HELMET.get())
                .add(HnSItems.CHARGED_SCOURGE_CHESTPLATE.get())
                .add(HnSItems.CHARGED_SCOURGE_LEGGINGS.get())
                .add(HnSItems.CHARGED_SCOURGE_BOOTS.get())

                //Thunder Prowler Armor
                .add(HnSItems.THUNDER_PROWLER_HELMET.get())
                .add(HnSItems.THUNDER_PROWLER_CHESTPLATE.get())
                .add(HnSItems.THUNDER_PROWLER_LEGGINGS.get())
                .add(HnSItems.THUNDER_PROWLER_BOOTS.get())

                /*
                *** Nature
                 */

                //Creaking Sorcerer Armor
                .add(HnSItems.CREAKING_HELMET.get())
                .add(HnSItems.CREAKING_CHESTPLATE.get())
                .add(HnSItems.CREAKING_LEGGINGS.get())
                .add(HnSItems.CREAKING_BOOTS.get())

                // Chlorophyte Armor
                .add(HnSItems.CHLOROPHYTE_HELMET.get())
                .add(HnSItems.CHLOROPHYTE_MASK.get())
                .add(HnSItems.CHLOROPHYTE_HEADGEAR.get())
                .add(HnSItems.CHLOROPHYTE_CHESTPLATE.get())
                .add(HnSItems.CHLOROPHYTE_LEGGINGS.get())
                .add(HnSItems.CHLOROPHYTE_BOOTS.get())

                /*
                *** Blood
                 */

                //Flesh Mass Armor
                .add(HnSItems.FLESH_MASS_HELMET.get())
                .add(HnSItems.FLESH_MASS_CHESTPLATE.get())
                .add(HnSItems.FLESH_MASS_LEGGINGS.get())
                .add(HnSItems.FLESH_MASS_BOOTS.get())

                //The Wither Armor
                .add(HnSItems.THE_WITHER_HELMET.get())
                .add(HnSItems.THE_WITHER_CHESTPLATE.get())
                .add(HnSItems.THE_WITHER_LEGGINGS.get())
                .add(HnSItems.THE_WITHER_BOOTS.get())

                .add(HnSItems.GECKOLIB_THE_WITHER_HELMET.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_BOOTS.get())

                /*
                 *** Ender
                 */

                //Ender Dragon Armor
                .add(HnSItems.ENDER_DRAGON_HELMET.get())
                .add(HnSItems.ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItems.ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItems.ENDER_DRAGON_BOOTS.get())

                .add(HnSItems.GECKOLIB_ENDER_DRAGON_HELMET.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_BOOTS.get())

                /*
                 *** Holy
                 */

                //Seraph Armor
                .add(HnSItems.SERAPH_HELMET.get())
                .add(HnSItems.SERAPH_CHESTPLATE.get())
                .add(HnSItems.SERAPH_LEGGINGS.get())
                .add(HnSItems.SERAPH_BOOTS.get())

                //Gabriel ULTRAKILL Armor
                .add(HnSItems.GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_BOOTS.get())

                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_BOOTS.get())

                //Mothic Witch Armor
                .add(HnSItems.MOTHIC_WITCH_HELMET.get())
                .add(HnSItems.MOTHIC_WITCH_CHESTPLATE.get())
                .add(HnSItems.MOTHIC_WITCH_SECRET_CHESTPLATE.get())
                .add(HnSItems.MOTHIC_WITCH_LEGGINGS.get())
                .add(HnSItems.MOTHIC_WITCH_BOOTS.get())

                /*
                *** Evocation
                */

                //Supreme Witch Armor
                .add(HnSItems.SUPREME_WITCH_HELMET.get())
                .add(HnSItems.SUPREME_WITCH_CHESTPLATE.get())
                .add(HnSItems.SUPREME_WITCH_LEGGINGS.get())
                .add(HnSItems.SUPREME_WITCH_BOOTS.get())

                //Alchemist Supreme Armor
                .add(HnSItems.ALCHEMIST_SUPREME_HELMET.get())
                .add(HnSItems.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .add(HnSItems.ALCHEMIST_SUPREME_LEGGINGS.get())
                .add(HnSItems.ALCHEMIST_SUPREME_BOOTS.get())

                /*
                 *** Radiance
                 */

                //Mycelium Guardian Armor
                .add(HnSItems.MYCELIUM_GUARDIAN_HELMET.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_CHESTPLATE.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_LEGGINGS.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_BOOTS.get())

                /*
                 *** Shadow
                 */

                //Shadow Scale Armor
                .add(HnSItems.SHADOW_SCALE_HELMET.get())
                .add(HnSItems.SHADOW_SCALE_CHESTPLATE.get())
                .add(HnSItems.SHADOW_SCALE_LEGGINGS.get())
                .add(HnSItems.SHADOW_SCALE_BOOTS.get())

                /*
                 *** Eldritch
                 */

                //Infestation Armor
                .add(HnSItems.INFESTATION_HELMET.get())
                .add(HnSItems.INFESTATION_CHESTPLATE.get())
                .add(HnSItems.INFESTATION_LEGGINGS.get())
                .add(HnSItems.INFESTATION_BOOTS.get())

                .add(HnSItems.GECKOLIB_INFESTATION_HELMET.get())
                .add(HnSItems.GECKOLIB_INFESTATION_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_INFESTATION_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_INFESTATION_BOOTS.get())

                /*
                *** Pyrium
                 */

                //Pyrium Armor
                .add(HnSItems.PYRIUM_HELMET.get())
                .add(HnSItems.PYRIUM_CHESTPLATE.get())
                .add(HnSItems.PYRIUM_LEGGINGS.get())
                .add(HnSItems.PYRIUM_BOOTS.get())

                //Pyrium Battlemage Armor
                .add(HnSItems.PYRIUM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_BOOTS.get())

                //Legionnaire Armor
                .add(HnSItems.LEGIONNAIRE_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_BOOTS.get())

                //Legionnaire Ruler Armor
                .add(HnSItems.LEGIONNAIRE_RULER_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_RULER_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_RULER_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_RULER_BOOTS.get())

                //Legionnaire Commander Armor
                .add(HnSItems.LEGIONNAIRE_COMMANDER_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_BOOTS.get())

                //Tyros Armor
                .add(HnSItems.TYROS_HELMET.get())
                .add(HnSItems.TYROS_CHESTPLATE.get())
                .add(HnSItems.TYROS_LEGGINGS.get())
                .add(HnSItems.TYROS_BOOTS.get())

                .add(HnSItems.TYROS_SOUL_HELMET.get())
                .add(HnSItems.TYROS_SOUL_CHESTPLATE.get())
                .add(HnSItems.TYROS_SOUL_LEGGINGS.get())
                .add(HnSItems.TYROS_SOUL_BOOTS.get())

                /*
                *** Cosmetic Battlemage
                 */

                //Frieren Armor
                .add(HnSItems.FRIEREN_HELMET.get())
                .add(HnSItems.FRIEREN_CHESTPLATE.get())
                .add(HnSItems.FRIEREN_LEGGINGS.get())
                .add(HnSItems.FRIEREN_BOOTS.get())

                //SynthV
                .add(HnSItems.SYNTHESIZER_V_HELMET.get())
                .add(HnSItems.SYNTHESIZER_V_CHESTPLATE.get())
                .add(HnSItems.SYNTHESIZER_V_LEGGINGS.get())
                .add(HnSItems.SYNTHESIZER_V_BOOTS.get())

                //UTAU Armor
                .add(HnSItems.UTAU_HELMET.get())
                .add(HnSItems.UTAU_CHESTPLATE.get())
                .add(HnSItems.UTAU_LEGGINGS.get())
                .add(HnSItems.UTAU_BOOTS.get())

                //PROJECT SEKAI Armor
                .add(HnSItems.PROJECT_SEKAI_HELMET.get())
                .add(HnSItems.PROJECT_SEKAI_CHESTPLATE.get())
                .add(HnSItems.PROJECT_SEKAI_LEGGINGS.get())
                .add(HnSItems.PROJECT_SEKAI_BOOTS.get())

                //Rotten Girl Armor
                .add(HnSItems.ROTTEN_GIRL_HELMET.get())
                .add(HnSItems.ROTTEN_GIRL_CHESTPLATE.get())
                .add(HnSItems.ROTTEN_GIRL_LEGGINGS.get())
                .add(HnSItems.ROTTEN_GIRL_BOOTS.get())

                //Neru Armor
                .add(HnSItems.NERU_HELMET.get())
                .add(HnSItems.NERU_CHESTPLATE.get())
                .add(HnSItems.NERU_LEGGINGS.get())
                .add(HnSItems.NERU_BOOTS.get())

                //Giorno Giovanna Armor
                .add(HnSItems.GIORNO_GIOVANNA_HELMET.get())
                .add(HnSItems.GIORNO_GIOVANNA_CHESTPLATE.get())
                .add(HnSItems.GIORNO_GIOVANNA_LEGGINGS.get())
                .add(HnSItems.GIORNO_GIOVANNA_BOOTS.get())

                /*
                *** Mining
                 */

                //Miner Armor
                .add(HnSItems.MINER_HELMET.get())
                .add(HnSItems.MINER_CHESTPLATE.get())
                .add(HnSItems.MINER_LEGGINGS.get())
                .add(HnSItems.MINER_BOOTS.get())

                //Spectral Spelunker Armor
                .add(HnSItems.SPECTRAL_SPELUNKER_HELMET.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_CHESTPLATE.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_LEGGINGS.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_BOOTS.get())

                /*
                *** Archer
                 */

                //Bounty Hunter Armor
                .add(HnSItems.BOUNTY_HUNTER_HELMET.get())
                .add(HnSItems.BOUNTY_HUNTER_CHESTPLATE.get())
                .add(HnSItems.BOUNTY_HUNTER_LEGGINGS.get())
                .add(HnSItems.BOUNTY_HUNTER_BOOTS.get())

                //Frostbite Hunter Armor
                .add(HnSItems.FROSTBITE_HUNTER_HELMET.get())
                .add(HnSItems.FROSTBITE_HUNTER_CHESTPLATE.get())
                .add(HnSItems.FROSTBITE_HUNTER_LEGGINGS.get())
                .add(HnSItems.FROSTBITE_HUNTER_BOOTS.get())

                /*
                *** Melee
                 */

                //Frostbite Knight Armor
                .add(HnSItems.FROSTBITE_KNIGHT_HELMET.get())
                .add(HnSItems.FROSTBITE_KNIGHT_CHESTPLATE.get())
                .add(HnSItems.FROSTBITE_KNIGHT_LEGGINGS.get())
                .add(HnSItems.FROSTBITE_KNIGHT_BOOTS.get())

                //Dreadsteel Knight Armor
                .add(HnSItems.DREADSTEEL_KNIGHT_HELMET.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_CHESTPLATE.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_LEGGINGS.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_BOOTS.get())

                /*
                *** Misc
                 */


                //Magehunter Armor
                .add(HnSItems.MAGEHUNTER_HELMET.get())
                .add(HnSItems.MAGEHUNTER_CHESTPLATE.get())
                .add(HnSItems.MAGEHUNTER_LEGGINGS.get())
                .add(HnSItems.MAGEHUNTER_BOOTS.get())

                //Mithril Battlemage Armor
                .add(HnSItems.MITHRIL_BATTLEMAGE_HELMET.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_BOOTS.get())

                //Enderman Shadowwalker Armor
                .add(HnSItems.ENDERMAN_MASKED.get())
                .add(HnSItems.ENDERMAN_BLINDFOLD.get())
                .add(HnSItems.ENDERMAN_HOOD.get())
                .add(HnSItems.ENDERMAN_CHESTPLATE.get())
                .add(HnSItems.ENDERMAN_LEGGINGS.get())
                .add(HnSItems.ENDERMAN_BOOTS.get())

                //Pyromancer Brute Armor
                .add(HnSItems.PYROMANCER_BRUTE_HELMET.get())
                .add(HnSItems.PYROMANCER_BRUTE_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItems.BISHOP_OF_DECEIT_HELMET.get())
                .add(HnSItems.BISHOP_OF_DECEIT_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItems.NECROMANCER_HELMET.get())
                .add(HnSItems.NECROMANCER_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItems.NAMELESS_ONE_HELMET.get())
                .add(HnSItems.NAMELESS_ONE_CHESTPLATE.get())

                /*
                *** Tributes
                 */


                //Dark Ritual Templar Armor
                .add(HnSItems.DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_BOOTS.get())

                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_BOOTS.get())


                //Fireblossom Battlemage Armor
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                //Arbitrium Robes Armor
                .add(HnSItems.ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_BOOTS.get())

                //Atlas Armor
                .add(HnSItems.ATLAS_HELMET.get())
                .add(HnSItems.ATLAS_CHESTPLATE.get())
                .add(HnSItems.ATLAS_LEGGINGS.get())
                .add(HnSItems.ATLAS_BOOTS.get())

                //Maverick Armor
                .add(HnSItems.MAVERICK_HELMET.get())
                .add(HnSItems.MAVERICK_CHESTPLATE.get())
                .add(HnSItems.MAVERICK_LEGGINGS.get())
                .add(HnSItems.MAVERICK_BOOTS.get())

                //SLC!CAT Armor
                .add(HnSItems.SLC_CAT_HELMET.get())
                .add(HnSItems.SLC_CAT_CHESTPLATE.get())
                .add(HnSItems.SLC_CAT_LEGGINGS.get())
                .add(HnSItems.SLC_CAT_BOOTS.get())

                //Abberant Predator Armor
                .add(HnSItems.ABBERANT_PREDATOR_HELMET.get())
                .add(HnSItems.ABBERANT_PREDATOR_CHESTPLATE.get())
                .add(HnSItems.ABBERANT_PREDATOR_LEGGINGS.get())
                .add(HnSItems.ABBERANT_PREDATOR_BOOTS.get())

                //Iron431 Armor
                .add(HnSItems.IRON431_HELMET.get())
                .add(HnSItems.IRON431_CHESTPLATE.get())
                .add(HnSItems.IRON431_LEGGINGS.get())
                .add(HnSItems.IRON431_BOOTS.get())

                .add(HnSItems.ASCENDED_IRON431_HELMET.get())
                .add(HnSItems.ASCENDED_IRON431_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_IRON431_LEGGINGS.get())
                .add(HnSItems.ASCENDED_IRON431_BOOTS.get())

                //Sacred Robes Armor
                .add(HnSItems.SACRED_ROBES_HELMET.get())
                .add(HnSItems.SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItems.SACRED_ROBES_LEGGINGS.get())
                .add(HnSItems.SACRED_ROBES_BOOTS.get())

                .add(HnSItems.ASCENDED_SACRED_ROBES_HELMET.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_LEGGINGS.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_BOOTS.get())

                //Lemon God Armor
                .add(HnSItems.LEMON_GOD_HELMET.get())
                .add(HnSItems.LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.LEMON_GOD_BOOTS.get())

                .add(HnSItems.ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_BOOTS.get())

                .add(HnSItems.GECKOLIB_LEMON_GOD_HELMET.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_BOOTS.get())

                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_BOOTS.get())

        ;

        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(HnSItems.CALAMITAS_HELMET.get())
                .add(HnSItems.BLAZEBORNE_HELMET.get())
                .add(HnSItems.SOUL_FLAME_HELMET.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_HELMET.get())
                .add(HnSItems.HAZEL_HELMET.get())
                .add(HnSItems.CRYOGENIC_RULER_HELMET.get())
                .add(HnSItems.CRYSTAL_ARACHNID_HELMET.get())
                .add(HnSItems.HERTA_PUPPET_HELMET.get())
                .add(HnSItems.CHARGED_SCOURGE_HELMET.get())
                .add(HnSItems.THUNDER_PROWLER_HELMET.get())
                .add(HnSItems.CREAKING_HELMET.get())
                .add(HnSItems.FLESH_MASS_HELMET.get())
                .add(HnSItems.THE_WITHER_HELMET.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_HELMET.get())
                .add(HnSItems.ENDER_DRAGON_HELMET.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_HELMET.get())
                .add(HnSItems.SERAPH_HELMET.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItems.MOTHIC_WITCH_HELMET.get())
                .add(HnSItems.SUPREME_WITCH_HELMET.get())
                .add(HnSItems.ALCHEMIST_SUPREME_HELMET.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_HELMET.get())
                .add(HnSItems.SHADOW_SCALE_HELMET.get())
                .add(HnSItems.INFESTATION_HELMET.get())
                .add(HnSItems.GECKOLIB_INFESTATION_HELMET.get())
                .add(HnSItems.PYRIUM_HELMET.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_RULER_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_HELMET.get())
                .add(HnSItems.TYROS_HELMET.get())
                .add(HnSItems.TYROS_SOUL_HELMET.get())
                .add(HnSItems.FRIEREN_HELMET.get())
                .add(HnSItems.SYNTHESIZER_V_HELMET.get())
                .add(HnSItems.UTAU_HELMET.get())
                .add(HnSItems.PROJECT_SEKAI_HELMET.get())
                .add(HnSItems.ROTTEN_GIRL_HELMET.get())
                .add(HnSItems.NERU_HELMET.get())
                .add(HnSItems.GIORNO_GIOVANNA_HELMET.get())
                .add(HnSItems.MINER_HELMET.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_HELMET.get())
                .add(HnSItems.BOUNTY_HUNTER_HELMET.get())
                .add(HnSItems.FROSTBITE_HUNTER_HELMET.get())
                .add(HnSItems.FROSTBITE_KNIGHT_HELMET.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_HELMET.get())
                .add(HnSItems.MAGEHUNTER_HELMET.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_HELMET.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItems.ATLAS_HELMET.get())
                .add(HnSItems.MAVERICK_HELMET.get())
                .add(HnSItems.SLC_CAT_HELMET.get())
                .add(HnSItems.ABBERANT_PREDATOR_HELMET.get())
                .add(HnSItems.IRON431_HELMET.get())
                .add(HnSItems.ASCENDED_IRON431_HELMET.get())
                .add(HnSItems.SACRED_ROBES_HELMET.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_HELMET.get())
                .add(HnSItems.LEMON_GOD_HELMET.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_HELMET.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItems.CHLOROPHYTE_HELMET.get())
                .add(HnSItems.CHLOROPHYTE_MASK.get())
                .add(HnSItems.CHLOROPHYTE_HEADGEAR.get())
                .add(HnSItems.PYROMANCER_BRUTE_HELMET.get())
                .add(HnSItems.ENDERMAN_BLINDFOLD.get())
                .add(HnSItems.ENDERMAN_MASKED.get())
                .add(HnSItems.ENDERMAN_HOOD.get())
                .add(HnSItems.BISHOP_OF_DECEIT_HELMET.get())
                .add(HnSItems.NECROMANCER_HELMET.get())
                .add(HnSItems.NAMELESS_ONE_HELMET.get())
        ;

        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(HnSItems.CALAMITAS_CHESTPLATE.get())
                .add(HnSItems.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItems.SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItems.HAZEL_CHESTPLATE.get())
                .add(HnSItems.HAZEL_HOLY_MOLLY_CHESTPLATE.get())
                .add(HnSItems.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSItems.CRYSTAL_ARACHNID_CHESTPLATE.get())
                .add(HnSItems.HERTA_PUPPET_CHESTPLATE.get())
                .add(HnSItems.CHARGED_SCOURGE_CHESTPLATE.get())
                .add(HnSItems.THUNDER_PROWLER_CHESTPLATE.get())
                .add(HnSItems.CREAKING_CHESTPLATE.get())
                .add(HnSItems.FLESH_MASS_CHESTPLATE.get())
                .add(HnSItems.FLESH_MASS_LEGGINGS.get())
                .add(HnSItems.THE_WITHER_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_CHESTPLATE.get())
                .add(HnSItems.ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItems.SERAPH_CHESTPLATE.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItems.MOTHIC_WITCH_CHESTPLATE.get())
                .add(HnSItems.MOTHIC_WITCH_SECRET_CHESTPLATE.get())
                .add(HnSItems.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_CHESTPLATE.get())
                .add(HnSItems.SHADOW_SCALE_CHESTPLATE.get())
                .add(HnSItems.INFESTATION_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_INFESTATION_CHESTPLATE.get())
                .add(HnSItems.PYRIUM_CHESTPLATE.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_RULER_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_CHESTPLATE.get())
                .add(HnSItems.TYROS_CHESTPLATE.get())
                .add(HnSItems.TYROS_SOUL_CHESTPLATE.get())
                .add(HnSItems.FRIEREN_CHESTPLATE.get())
                .add(HnSItems.SYNTHESIZER_V_CHESTPLATE.get())
                .add(HnSItems.UTAU_CHESTPLATE.get())
                .add(HnSItems.PROJECT_SEKAI_CHESTPLATE.get())
                .add(HnSItems.ROTTEN_GIRL_CHESTPLATE.get())
                .add(HnSItems.NERU_CHESTPLATE.get())
                .add(HnSItems.GIORNO_GIOVANNA_CHESTPLATE.get())
                .add(HnSItems.MINER_CHESTPLATE.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_CHESTPLATE.get())
                .add(HnSItems.BOUNTY_HUNTER_CHESTPLATE.get())
                .add(HnSItems.FROSTBITE_HUNTER_CHESTPLATE.get())
                .add(HnSItems.FROSTBITE_KNIGHT_CHESTPLATE.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_CHESTPLATE.get())
                .add(HnSItems.MAGEHUNTER_CHESTPLATE.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItems.ATLAS_CHESTPLATE.get())
                .add(HnSItems.MAVERICK_CHESTPLATE.get())
                .add(HnSItems.SLC_CAT_CHESTPLATE.get())
                .add(HnSItems.ABBERANT_PREDATOR_CHESTPLATE.get())
                .add(HnSItems.IRON431_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_IRON431_CHESTPLATE.get())
                .add(HnSItems.SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItems.LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItems.CHLOROPHYTE_CHESTPLATE.get())
                .add(HnSItems.PYROMANCER_BRUTE_CHESTPLATE.get())
                .add(HnSItems.ENDERMAN_CHESTPLATE.get())
                .add(HnSItems.BISHOP_OF_DECEIT_CHESTPLATE.get())
                .add(HnSItems.NECROMANCER_CHESTPLATE.get())
                .add(HnSItems.NAMELESS_ONE_CHESTPLATE.get())
        ;

        tag(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(HnSItems.CALAMITAS_LEGGINGS.get())
                .add(HnSItems.BLAZEBORNE_LEGGINGS.get())
                .add(HnSItems.SOUL_FLAME_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_LEGGINGS.get())
                .add(HnSItems.HAZEL_LEGGINGS.get())
                .add(HnSItems.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSItems.CRYSTAL_ARACHNID_LEGGINGS.get())
                .add(HnSItems.HERTA_PUPPET_LEGGINGS.get())
                .add(HnSItems.CHARGED_SCOURGE_LEGGINGS.get())
                .add(HnSItems.THUNDER_PROWLER_LEGGINGS.get())
                .add(HnSItems.CREAKING_LEGGINGS.get())
                .add(HnSItems.FLESH_MASS_LEGGINGS.get())
                .add(HnSItems.THE_WITHER_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_LEGGINGS.get())
                .add(HnSItems.ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItems.SERAPH_LEGGINGS.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItems.MOTHIC_WITCH_LEGGINGS.get())
                .add(HnSItems.SUPREME_WITCH_LEGGINGS.get())
                .add(HnSItems.ALCHEMIST_SUPREME_LEGGINGS.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_LEGGINGS.get())
                .add(HnSItems.SHADOW_SCALE_LEGGINGS.get())
                .add(HnSItems.INFESTATION_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_INFESTATION_LEGGINGS.get())
                .add(HnSItems.PYRIUM_LEGGINGS.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_RULER_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_LEGGINGS.get())
                .add(HnSItems.TYROS_LEGGINGS.get())
                .add(HnSItems.TYROS_SOUL_LEGGINGS.get())
                .add(HnSItems.FRIEREN_LEGGINGS.get())
                .add(HnSItems.SYNTHESIZER_V_LEGGINGS.get())
                .add(HnSItems.UTAU_LEGGINGS.get())
                .add(HnSItems.PROJECT_SEKAI_LEGGINGS.get())
                .add(HnSItems.ROTTEN_GIRL_LEGGINGS.get())
                .add(HnSItems.NERU_LEGGINGS.get())
                .add(HnSItems.GIORNO_GIOVANNA_LEGGINGS.get())
                .add(HnSItems.MINER_LEGGINGS.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_LEGGINGS.get())
                .add(HnSItems.BOUNTY_HUNTER_LEGGINGS.get())
                .add(HnSItems.FROSTBITE_HUNTER_LEGGINGS.get())
                .add(HnSItems.FROSTBITE_KNIGHT_LEGGINGS.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_LEGGINGS.get())
                .add(HnSItems.MAGEHUNTER_LEGGINGS.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItems.ATLAS_LEGGINGS.get())
                .add(HnSItems.MAVERICK_LEGGINGS.get())
                .add(HnSItems.SLC_CAT_LEGGINGS.get())
                .add(HnSItems.ABBERANT_PREDATOR_LEGGINGS.get())
                .add(HnSItems.IRON431_LEGGINGS.get())
                .add(HnSItems.ASCENDED_IRON431_LEGGINGS.get())
                .add(HnSItems.SACRED_ROBES_LEGGINGS.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_LEGGINGS.get())
                .add(HnSItems.LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItems.CHLOROPHYTE_LEGGINGS.get())
                .add(HnSItems.NECROMANCER_LEGGINGS.get())
                .add(HnSItems.NAMELESS_ONE_LEGGINGS.get())
        ;

        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(HnSItems.CALAMITAS_BOOTS.get())
                .add(HnSItems.BLAZEBORNE_BOOTS.get())
                .add(HnSItems.SOUL_FLAME_BOOTS.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_BOOTS.get())
                .add(HnSItems.HAZEL_BOOTS.get())
                .add(HnSItems.CRYOGENIC_RULER_BOOTS.get())
                .add(HnSItems.CRYSTAL_ARACHNID_BOOTS.get())
                .add(HnSItems.HERTA_PUPPET_BOOTS.get())
                .add(HnSItems.CHARGED_SCOURGE_BOOTS.get())
                .add(HnSItems.THUNDER_PROWLER_BOOTS.get())
                .add(HnSItems.CREAKING_BOOTS.get())
                .add(HnSItems.FLESH_MASS_BOOTS.get())
                .add(HnSItems.THE_WITHER_BOOTS.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_BOOTS.get())
                .add(HnSItems.ENDER_DRAGON_BOOTS.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_BOOTS.get())
                .add(HnSItems.SERAPH_BOOTS.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_BOOTS.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_BOOTS.get())
                .add(HnSItems.MOTHIC_WITCH_BOOTS.get())
                .add(HnSItems.SUPREME_WITCH_BOOTS.get())
                .add(HnSItems.ALCHEMIST_SUPREME_BOOTS.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_BOOTS.get())
                .add(HnSItems.SHADOW_SCALE_BOOTS.get())
                .add(HnSItems.INFESTATION_BOOTS.get())
                .add(HnSItems.GECKOLIB_INFESTATION_BOOTS.get())
                .add(HnSItems.PYRIUM_BOOTS.get())
                .add(HnSItems.PYRIUM_BATTLEMAGE_BOOTS.get())
                .add(HnSItems.LEGIONNAIRE_RULER_BOOTS.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_BOOTS.get())
                .add(HnSItems.TYROS_BOOTS.get())
                .add(HnSItems.TYROS_SOUL_BOOTS.get())
                .add(HnSItems.FRIEREN_BOOTS.get())
                .add(HnSItems.SYNTHESIZER_V_BOOTS.get())
                .add(HnSItems.UTAU_BOOTS.get())
                .add(HnSItems.PROJECT_SEKAI_BOOTS.get())
                .add(HnSItems.ROTTEN_GIRL_BOOTS.get())
                .add(HnSItems.NERU_BOOTS.get())
                .add(HnSItems.GIORNO_GIOVANNA_BOOTS.get())
                .add(HnSItems.MINER_BOOTS.get())
                .add(HnSItems.SPECTRAL_SPELUNKER_BOOTS.get())
                .add(HnSItems.BOUNTY_HUNTER_BOOTS.get())
                .add(HnSItems.FROSTBITE_HUNTER_BOOTS.get())
                .add(HnSItems.FROSTBITE_KNIGHT_BOOTS.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_BOOTS.get())
                .add(HnSItems.MAGEHUNTER_BOOTS.get())
                .add(HnSItems.MITHRIL_BATTLEMAGE_BOOTS.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_BOOTS.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_BOOTS.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_BOOTS.get())
                .add(HnSItems.ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItems.ASCENDED_ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItems.GECKOLIB_ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItems.ATLAS_BOOTS.get())
                .add(HnSItems.MAVERICK_BOOTS.get())
                .add(HnSItems.SLC_CAT_BOOTS.get())
                .add(HnSItems.ABBERANT_PREDATOR_LEGGINGS.get())
                .add(HnSItems.ABBERANT_PREDATOR_BOOTS.get())
                .add(HnSItems.IRON431_BOOTS.get())
                .add(HnSItems.ASCENDED_IRON431_BOOTS.get())
                .add(HnSItems.SACRED_ROBES_BOOTS.get())
                .add(HnSItems.ASCENDED_SACRED_ROBES_BOOTS.get())
                .add(HnSItems.LEMON_GOD_BOOTS.get())
                .add(HnSItems.ASCENDED_LEMON_GOD_BOOTS.get())
                .add(HnSItems.GECKOLIB_LEMON_GOD_BOOTS.get())
                .add(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_BOOTS.get())
                .add(HnSItems.CHLOROPHYTE_BOOTS.get())
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
        ;



        tag(HnSTags.NETHERITE_BATTLEMAGE_HELMET)
                .add(ItemRegistry.NETHERITE_MAGE_HELMET.get())
                .add(HnSItems.ATLAS_HELMET.get())
                .add(HnSItems.FRIEREN_HELMET.get())
                .add(HnSItems.GIORNO_GIOVANNA_HELMET.get())
        ;

        tag(HnSTags.NETHERITE_BATTLEMAGE_CHESTPLATE)
                .add(ItemRegistry.NETHERITE_MAGE_CHESTPLATE.get())
                .add(HnSItems.ATLAS_CHESTPLATE.get())
                .add(HnSItems.FRIEREN_CHESTPLATE.get())
                .add(HnSItems.GIORNO_GIOVANNA_CHESTPLATE.get())
        ;

        tag(HnSTags.NETHERITE_BATTLEMAGE_LEGGINGS)
                .add(ItemRegistry.NETHERITE_MAGE_LEGGINGS.get())
                .add(HnSItems.ATLAS_LEGGINGS.get())
                .add(HnSItems.FRIEREN_LEGGINGS.get())
                .add(HnSItems.GIORNO_GIOVANNA_LEGGINGS.get())
        ;

        tag(HnSTags.NETHERITE_BATTLEMAGE_BOOTS)
                .add(ItemRegistry.NETHERITE_MAGE_BOOTS.get())
                .add(HnSItems.ATLAS_BOOTS.get())
                .add(HnSItems.FRIEREN_BOOTS.get())
                .add(HnSItems.GIORNO_GIOVANNA_BOOTS.get())
        ;


        tag(HnSTags.PURE_HELMET)
                .add(HnSItems.CALAMITAS_HELMET.get())
                .add(HnSItems.BLAZEBORNE_HELMET.get())
                .add(HnSItems.SOUL_FLAME_HELMET.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_HELMET.get())
                .add(HnSItems.HAZEL_HELMET.get())
                .add(HnSItems.CRYOGENIC_RULER_HELMET.get())
                .add(HnSItems.CRYSTAL_ARACHNID_HELMET.get())
                .add(HnSItems.HERTA_PUPPET_HELMET.get())
                .add(HnSItems.CHARGED_SCOURGE_HELMET.get())
                .add(HnSItems.THUNDER_PROWLER_HELMET.get())
                .add(HnSItems.CREAKING_HELMET.get())
                .add(HnSItems.FLESH_MASS_HELMET.get())
                .add(HnSItems.THE_WITHER_HELMET.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_HELMET.get())
                .add(HnSItems.ENDER_DRAGON_HELMET.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_HELMET.get())
                .add(HnSItems.SERAPH_HELMET.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItems.MOTHIC_WITCH_HELMET.get())
                .add(HnSItems.SUPREME_WITCH_HELMET.get())
                .add(HnSItems.ALCHEMIST_SUPREME_HELMET.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_HELMET.get())
                .add(HnSItems.SHADOW_SCALE_HELMET.get())
                .add(HnSItems.INFESTATION_HELMET.get())
                .add(HnSItems.GECKOLIB_INFESTATION_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_RULER_HELMET.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_HELMET.get())
                .add(HnSItems.TYROS_HELMET.get())
                .add(HnSItems.TYROS_SOUL_HELMET.get())
                .add(HnSItems.FROSTBITE_HUNTER_HELMET.get())
                .add(HnSItems.FROSTBITE_KNIGHT_HELMET.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_HELMET.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItems.ATLAS_HELMET.get())
                .add(HnSItems.MAVERICK_HELMET.get())
                .add(HnSItems.SLC_CAT_HELMET.get())
                .add(HnSItems.ABBERANT_PREDATOR_HELMET.get())
                .add(HnSItems.CHLOROPHYTE_HELMET.get())
                .add(HnSItems.CHLOROPHYTE_HEADGEAR.get())
                .add(HnSItems.CHLOROPHYTE_MASK.get())
        ;

        tag(HnSTags.PURE_CHESTPLATE)
                .add(HnSItems.CALAMITAS_CHESTPLATE.get())
                .add(HnSItems.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItems.SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItems.HAZEL_CHESTPLATE.get())
                .add(HnSItems.HAZEL_HOLY_MOLLY_CHESTPLATE.get())
                .add(HnSItems.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSItems.CRYSTAL_ARACHNID_CHESTPLATE.get())
                .add(HnSItems.HERTA_PUPPET_CHESTPLATE.get())
                .add(HnSItems.CHARGED_SCOURGE_CHESTPLATE.get())
                .add(HnSItems.THUNDER_PROWLER_CHESTPLATE.get())
                .add(HnSItems.CREAKING_CHESTPLATE.get())
                .add(HnSItems.FLESH_MASS_CHESTPLATE.get())
                .add(HnSItems.FLESH_MASS_LEGGINGS.get())
                .add(HnSItems.THE_WITHER_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_CHESTPLATE.get())
                .add(HnSItems.ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItems.SERAPH_CHESTPLATE.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItems.MOTHIC_WITCH_CHESTPLATE.get())
                .add(HnSItems.MOTHIC_WITCH_SECRET_CHESTPLATE.get())
                .add(HnSItems.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_CHESTPLATE.get())
                .add(HnSItems.SHADOW_SCALE_CHESTPLATE.get())
                .add(HnSItems.INFESTATION_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_INFESTATION_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_RULER_CHESTPLATE.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_CHESTPLATE.get())
                .add(HnSItems.TYROS_CHESTPLATE.get())
                .add(HnSItems.TYROS_SOUL_CHESTPLATE.get())
                .add(HnSItems.FROSTBITE_HUNTER_CHESTPLATE.get())
                .add(HnSItems.FROSTBITE_KNIGHT_CHESTPLATE.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_CHESTPLATE.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItems.MAVERICK_CHESTPLATE.get())
                .add(HnSItems.SLC_CAT_CHESTPLATE.get())
                .add(HnSItems.ABBERANT_PREDATOR_CHESTPLATE.get())
                .add(HnSItems.CHLOROPHYTE_CHESTPLATE.get())
        ;

        tag(HnSTags.PURE_LEGGINGS)
                .add(HnSItems.CALAMITAS_LEGGINGS.get())
                .add(HnSItems.BLAZEBORNE_LEGGINGS.get())
                .add(HnSItems.SOUL_FLAME_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_LEGGINGS.get())
                .add(HnSItems.HAZEL_LEGGINGS.get())
                .add(HnSItems.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSItems.CRYSTAL_ARACHNID_LEGGINGS.get())
                .add(HnSItems.HERTA_PUPPET_LEGGINGS.get())
                .add(HnSItems.CHARGED_SCOURGE_LEGGINGS.get())
                .add(HnSItems.THUNDER_PROWLER_LEGGINGS.get())
                .add(HnSItems.CREAKING_LEGGINGS.get())
                .add(HnSItems.FLESH_MASS_LEGGINGS.get())
                .add(HnSItems.THE_WITHER_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_LEGGINGS.get())
                .add(HnSItems.ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItems.SERAPH_LEGGINGS.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItems.MOTHIC_WITCH_LEGGINGS.get())
                .add(HnSItems.SUPREME_WITCH_LEGGINGS.get())
                .add(HnSItems.ALCHEMIST_SUPREME_LEGGINGS.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_LEGGINGS.get())
                .add(HnSItems.SHADOW_SCALE_LEGGINGS.get())
                .add(HnSItems.INFESTATION_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_INFESTATION_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_RULER_LEGGINGS.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_LEGGINGS.get())
                .add(HnSItems.TYROS_LEGGINGS.get())
                .add(HnSItems.TYROS_SOUL_LEGGINGS.get())
                .add(HnSItems.FROSTBITE_HUNTER_LEGGINGS.get())
                .add(HnSItems.FROSTBITE_KNIGHT_LEGGINGS.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_LEGGINGS.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItems.MAVERICK_LEGGINGS.get())
                .add(HnSItems.SLC_CAT_LEGGINGS.get())
                .add(HnSItems.ABBERANT_PREDATOR_LEGGINGS.get())
                .add(HnSItems.CHLOROPHYTE_LEGGINGS.get())
        ;

        tag(HnSTags.PURE_BOOTS)
                .add(HnSItems.CALAMITAS_BOOTS.get())
                .add(HnSItems.BLAZEBORNE_BOOTS.get())
                .add(HnSItems.SOUL_FLAME_BOOTS.get())
                .add(HnSItems.GECKOLIB_SOUL_FLAME_BOOTS.get())
                .add(HnSItems.HAZEL_BOOTS.get())
                .add(HnSItems.CRYOGENIC_RULER_BOOTS.get())
                .add(HnSItems.CRYSTAL_ARACHNID_BOOTS.get())
                .add(HnSItems.HERTA_PUPPET_BOOTS.get())
                .add(HnSItems.CHARGED_SCOURGE_BOOTS.get())
                .add(HnSItems.THUNDER_PROWLER_BOOTS.get())
                .add(HnSItems.CREAKING_BOOTS.get())
                .add(HnSItems.FLESH_MASS_BOOTS.get())
                .add(HnSItems.THE_WITHER_BOOTS.get())
                .add(HnSItems.GECKOLIB_THE_WITHER_BOOTS.get())
                .add(HnSItems.ENDER_DRAGON_BOOTS.get())
                .add(HnSItems.GECKOLIB_ENDER_DRAGON_BOOTS.get())
                .add(HnSItems.SERAPH_BOOTS.get())
                .add(HnSItems.GABRIEL_ULTRAKILL_BOOTS.get())
                .add(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_BOOTS.get())
                .add(HnSItems.MOTHIC_WITCH_BOOTS.get())
                .add(HnSItems.SUPREME_WITCH_BOOTS.get())
                .add(HnSItems.ALCHEMIST_SUPREME_BOOTS.get())
                .add(HnSItems.MYCELIUM_GUARDIAN_BOOTS.get())
                .add(HnSItems.SHADOW_SCALE_BOOTS.get())
                .add(HnSItems.INFESTATION_BOOTS.get())
                .add(HnSItems.GECKOLIB_INFESTATION_BOOTS.get())
                .add(HnSItems.LEGIONNAIRE_RULER_BOOTS.get())
                .add(HnSItems.LEGIONNAIRE_COMMANDER_BOOTS.get())
                .add(HnSItems.TYROS_BOOTS.get())
                .add(HnSItems.TYROS_SOUL_BOOTS.get())
                .add(HnSItems.SYNTHESIZER_V_BOOTS.get())
                .add(HnSItems.FROSTBITE_HUNTER_BOOTS.get())
                .add(HnSItems.FROSTBITE_KNIGHT_BOOTS.get())
                .add(HnSItems.DREADSTEEL_KNIGHT_BOOTS.get())
                .add(HnSItems.DARK_RITUAL_TEMPLAR_BOOTS.get())
                .add(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_BOOTS.get())
                .add(HnSItems.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())
                .add(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_BOOTS.get())
                .add(HnSItems.MAVERICK_BOOTS.get())
                .add(HnSItems.SLC_CAT_BOOTS.get())
                .add(HnSItems.CHLOROPHYTE_BOOTS.get())
        ;


        /*
        *** Tools and Weapons Tags
         */

        tag(ItemTags.AXES)
                .add(HnSItems.BEONGAE.get())
                .add(HnSItems.SKYSCORCHER.get())
                .add(HnSItems.ANCIENT_WARRIORS_AXE.get())
                .add(HnSItems.FIREBRAND.get())
                .add(HnSItems.PICKAXE_AXE.get())
                .add(HnSItems.PICKAXE_AXE_DIVINE_GOLD.get())
                .add(HnSItems.RAVENS_BANE.get())
                .add(HnSItems.LEGIONNAIRE_WARLOCK_AXE.get())
        ;

        tag(ItemTags.SWORDS)
                //Fire
                .add(HnSItems.FIREBLOSSOM_RAPIER.get())
                .add(HnSItems.DRACONIC_SPLITTER.get())
                .add(HnSItems.FIREBRAND.get())
                .add(HnSItems.WARFLAMING_LANCE.get())
                .add(HnSItems.RAVENS_BANE.get())
                .add(HnSItems.VOLCANO.get())

                //Ice
                .add(HnSItems.ICE_PIKE.get())
                .add(HnSItems.FROSTBURN_DAGGER.get())

                //Lightning
                .add(HnSItems.BEONGAE.get())
                .add(HnSItems.SKYSCORCHER.get())

                //Nature
                .add(HnSItems.BOUNTIFUL_HARVEST.get())
                .add(HnSItems.THORN_CHAKRAM.get())
                .add(HnSItems.BLADE_OF_GRASS.get())

                //Blood
                .add(HnSItems.VAMPIRE_KNIVES.get())

                //Ender
                .add(HnSItems.OBSIDIAN_CLAYMORE.get())
                .add(HnSItems.STARFURY.get())

                //Radiance
                .add(HnSItems.SPECTRUM.get())
                .add(HnSItems.MEOWMERE.get())
                .add(HnSItems.HAMMUSH.get())

                //Shadow
                .add(HnSItems.LIGHTS_BANE.get())
                .add(HnSItems.NIGHTS_EDGE.get())
                .add(HnSItems.TRUE_NIGHTS_EDGE.get())

                //Holy
                .add(HnSItems.HAMMER_OF_JUSTICE.get())
                .add(HnSItems.DIVINE_GREATSWORD.get())
                .add(HnSItems.EXCALIBUR.get())
                .add(HnSItems.HAZENS_EXCALIBUR.get())
                .add(HnSItems.ISS_EXCALIBUR.get())

                //Evocation
                .add(HnSItems.MALICE.get())
                .add(HnSItems.ANCIENT_WARRIORS_AXE.get())

                //Eldritch
                .add(HnSItems.THE_DEVOURER.get())

                //Misc
                .add(HnSItems.MAGE_BANE.get())
                .add(HnSItems.LEGIONNAIRE_WARLOCK_AXE.get())
                .add(HnSItems.MURAMASA.get())
                .add(HnSItems.DAWNMAKER.get())
        ;

        tag(ItemTags.PICKAXES)
                .add(HnSItems.SPECTRAL_PICKAXE.get())
                .add(HnSItems.PICKAXE_AXE.get())
                .add(HnSItems.PICKAXE_AXE_DIVINE_GOLD.get())
        ;

        tag(Tags.Items.TOOLS_MACE)
                .add(HnSItems.SKYSCORCHER.get())
        ;

        tag(ItemTags.MACE_ENCHANTABLE)
                .add(HnSItems.SKYSCORCHER.get())
        ;

        tag(ItemTags.MINING_ENCHANTABLE)
                .add(HnSItems.SPECTRAL_PICKAXE.get())
                .add(HnSItems.PICKAXE_AXE.get())
                .add(HnSItems.PICKAXE_AXE_DIVINE_GOLD.get())
        ;

        tag(Tags.Items.TOOLS_SPEAR)
                .add(HnSItems.ICE_PIKE.get())
        ;

        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                //Fire
                .add(HnSItems.FIREBLOSSOM_RAPIER.get())
                .add(HnSItems.DRACONIC_SPLITTER.get())
                .add(HnSItems.FIREBRAND.get())
                .add(HnSItems.WARFLAMING_LANCE.get())
                .add(HnSItems.RAVENS_BANE.get())
                .add(HnSItems.BLADE_OF_GRASS.get())
                .add(HnSItems.VOLCANO.get())

                //Ice
                .add(HnSItems.ICE_PIKE.get())
                .add(HnSItems.FROSTBURN_DAGGER.get())

                //Lightning
                .add(HnSItems.BEONGAE.get())
                .add(HnSItems.SKYSCORCHER.get())

                //Nature
                .add(HnSItems.BOUNTIFUL_HARVEST.get())
                .add(HnSItems.THORN_CHAKRAM.get())

                //Blood
                .add(HnSItems.VAMPIRE_KNIVES.get())

                //Ender
                .add(HnSItems.OBSIDIAN_CLAYMORE.get())
                .add(HnSItems.STARFURY.get())

                //Radiance
                .add(HnSItems.SPECTRUM.get())
                .add(HnSItems.MEOWMERE.get())
                .add(HnSItems.HAMMUSH.get())

                //Shadow
                .add(HnSItems.LIGHTS_BANE.get())
                .add(HnSItems.NIGHTS_EDGE.get())
                .add(HnSItems.TRUE_NIGHTS_EDGE.get())

                //Holy
                .add(HnSItems.HAMMER_OF_JUSTICE.get())
                .add(HnSItems.DIVINE_GREATSWORD.get())
                .add(HnSItems.EXCALIBUR.get())
                .add(HnSItems.HAZENS_EXCALIBUR.get())
                .add(HnSItems.ISS_EXCALIBUR.get())

                //Evocation
                .add(HnSItems.MALICE.get())
                .add(HnSItems.ANCIENT_WARRIORS_AXE.get())

                //Eldritch
                .add(HnSItems.THE_DEVOURER.get())

                //Misc
                .add(HnSItems.MAGE_BANE.get())
                .add(HnSItems.LEGIONNAIRE_WARLOCK_AXE.get())
                .add(HnSItems.MURAMASA.get())
                .add(HnSItems.DAWNMAKER.get())
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
                .add(HnSItems.OVERGROWN_BONE.get())
                .add(HnSItems.CHARRED_BONES.get())
        ;

        tag(Tags.Items.HIDDEN_FROM_RECIPE_VIEWERS)
                .add(HnSItems.HAZEL_HOLY_MOLLY_CHESTPLATE.get())
                .add(HnSItems.MOTHIC_WITCH_SECRET_CHESTPLATE.get())
        ;

        tag(ModTags.CAN_BE_IMBUED)

                //Fire
                .add(HnSItems.FIREBLOSSOM_RAPIER.get())
                .add(HnSItems.DRACONIC_SPLITTER.get())
                .add(HnSItems.FIREBRAND.get())
                .add(HnSItems.WARFLAMING_LANCE.get())
                .add(HnSItems.RAVENS_BANE.get())
                .add(HnSItems.VOLCANO.get())

                //Ice
                .add(HnSItems.ICE_PIKE.get())
                .add(HnSItems.FROSTBURN_DAGGER.get())

                //Lightning
                .add(HnSItems.BEONGAE.get())
                .add(HnSItems.SKYSCORCHER.get())

                //Nature
                .add(HnSItems.BOUNTIFUL_HARVEST.get())
                .add(HnSItems.THORN_CHAKRAM.get())
                .add(HnSItems.BLADE_OF_GRASS.get())


                //Blood
                .add(HnSItems.VAMPIRE_KNIVES.get())

                //Ender
                .add(HnSItems.OBSIDIAN_CLAYMORE.get())
                .add(HnSItems.STARFURY.get())

                //Radiance
                .add(HnSItems.SPECTRUM.get())
                .add(HnSItems.MEOWMERE.get())
                .add(HnSItems.HAMMUSH.get())

                //Shadow
                .add(HnSItems.LIGHTS_BANE.get())
                .add(HnSItems.NIGHTS_EDGE.get())
                .add(HnSItems.TRUE_NIGHTS_EDGE.get())

                //Holy
                .add(HnSItems.HAMMER_OF_JUSTICE.get())
                .add(HnSItems.DIVINE_GREATSWORD.get())
                .add(HnSItems.EXCALIBUR.get())
                .add(HnSItems.HAZENS_EXCALIBUR.get())
                .add(HnSItems.ISS_EXCALIBUR.get())

                //Evocation
                .add(HnSItems.MALICE.get())
                .add(HnSItems.ANCIENT_WARRIORS_AXE.get())

                //Eldritch
                .add(HnSItems.THE_DEVOURER.get())

                //Misc
                .add(HnSItems.MAGE_BANE.get())
                .add(HnSItems.LEGIONNAIRE_WARLOCK_AXE.get())
                .add(HnSItems.MURAMASA.get())
                .add(HnSItems.DAWNMAKER.get())


                /*
                *** Tools
                 */

                .add(HnSItems.SPECTRAL_PICKAXE.get())
                .add(HnSItems.PICKAXE_AXE.get())
                .add(HnSItems.PICKAXE_AXE_DIVINE_GOLD.get())

                /*
                ***
                */

                .add(HnSItems.WISEWOOD_CANE.get())
                .add(HnSItems.FRIEREN_STAFF.get())
                .add(HnSItems.ROD_OF_DISCORD.get())


        ;

        tag(ModTags.CAN_BE_UPGRADED)

                //Fire
                .add(HnSItems.FIREBLOSSOM_RAPIER.get())
                .add(HnSItems.DRACONIC_SPLITTER.get())
                .add(HnSItems.FIREBRAND.get())
                .add(HnSItems.WARFLAMING_LANCE.get())
                .add(HnSItems.RAVENS_BANE.get())
                .add(HnSItems.VOLCANO.get())

                //Ice
                .add(HnSItems.ICE_PIKE.get())
                .add(HnSItems.FROSTBURN_DAGGER.get())

                //Lightning
                .add(HnSItems.BEONGAE.get())
                .add(HnSItems.SKYSCORCHER.get())

                //Nature
                .add(HnSItems.BOUNTIFUL_HARVEST.get())
                .add(HnSItems.THORN_CHAKRAM.get())
                .add(HnSItems.BLADE_OF_GRASS.get())

                //Blood
                .add(HnSItems.VAMPIRE_KNIVES.get())

                //Ender
                .add(HnSItems.OBSIDIAN_CLAYMORE.get())
                .add(HnSItems.STARFURY.get())

                //Radiance
                .add(HnSItems.SPECTRUM.get())
                .add(HnSItems.MEOWMERE.get())
                .add(HnSItems.HAMMUSH.get())

                //Shadow
                .add(HnSItems.LIGHTS_BANE.get())
                .add(HnSItems.NIGHTS_EDGE.get())
                .add(HnSItems.TRUE_NIGHTS_EDGE.get())

                //Holy
                .add(HnSItems.HAMMER_OF_JUSTICE.get())
                .add(HnSItems.DIVINE_GREATSWORD.get())
                .add(HnSItems.EXCALIBUR.get())
                .add(HnSItems.HAZENS_EXCALIBUR.get())
                .add(HnSItems.ISS_EXCALIBUR.get())

                //Evocation
                .add(HnSItems.MALICE.get())
                .add(HnSItems.ANCIENT_WARRIORS_AXE.get())

                //Eldritch
                .add(HnSItems.THE_DEVOURER.get())

                //Misc
                .add(HnSItems.MAGE_BANE.get())
                .add(HnSItems.LEGIONNAIRE_WARLOCK_AXE.get())
                .add(HnSItems.MURAMASA.get())
                .add(HnSItems.DAWNMAKER.get())


                /*
                 *** Tools
                 */

                .add(HnSItems.SPECTRAL_PICKAXE.get())
                .add(HnSItems.PICKAXE_AXE.get())
                .add(HnSItems.PICKAXE_AXE_DIVINE_GOLD.get())

                /*
                 ***
                 */

                .add(HnSItems.WISEWOOD_CANE.get())
                .add(HnSItems.FRIEREN_STAFF.get())
                .add(HnSItems.ROD_OF_DISCORD.get())


        ;

        tag(ModTags.INSCRIBED_RUNES)
                .add(HnSItems.MELEE_RUNE.get())
                .add(HnSItems.ARCHERY_RUNE.get())
                .add(HnSItems.HEALTH_RUNE.get())
                .add(HnSItems.ELDRITCH_RUNE.get())
                .add(HnSItems.SHADOW_RUNE.get())
                .add(HnSItems.RADIANCE_RUNE.get())
        ;

    }
}