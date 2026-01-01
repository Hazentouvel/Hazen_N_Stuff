package net.hazen.hazennstuff.Datagen.ItemGenerator;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import io.redspace.ironsspellbooks.util.ModTags;
import net.hazen.hazennstuff.Item.Block.HnSBlocks;
import net.hazen.hazennstuff.Datagen.HnSTags;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.ItemRegistry.HnSItemRegistry;
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
                .add(HnSItemRegistry.CALAMITAS_HELMET.get())
                .add(HnSItemRegistry.CALAMITAS_CHESTPLATE.get())
                .add(HnSItemRegistry.CALAMITAS_LEGGINGS.get())
                .add(HnSItemRegistry.CALAMITAS_BOOTS.get())

                //Blazeborne Armor
                .add(HnSItemRegistry.BLAZEBORNE_HELMET.get())
                .add(HnSItemRegistry.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItemRegistry.BLAZEBORNE_LEGGINGS.get())
                .add(HnSItemRegistry.BLAZEBORNE_BOOTS.get())

                //Soul Flame Armor
                .add(HnSItemRegistry.SOUL_FLAME_HELMET.get())
                .add(HnSItemRegistry.SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItemRegistry.SOUL_FLAME_LEGGINGS.get())
                .add(HnSItemRegistry.SOUL_FLAME_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_BOOTS.get())

                //Hazel Armor
                .add(HnSItemRegistry.HAZEL_HELMET.get())
                .add(HnSItemRegistry.HAZEL_CHESTPLATE.get())
                .add(HnSItemRegistry.HAZEL_HOLY_MOLLY_CHESTPLATE.get())
                .add(HnSItemRegistry.HAZEL_LEGGINGS.get())
                .add(HnSItemRegistry.HAZEL_BOOTS.get())

                /*
                *** Ice
                 */

                //Cryogenic Ruler Armor
                .add(HnSItemRegistry.CRYOGENIC_RULER_HELMET.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_BOOTS.get())

                //Crystal Arachnid Armor
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_HELMET.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_CHESTPLATE.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_LEGGINGS.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_BOOTS.get())

                //Herta Puppet Armor
                .add(HnSItemRegistry.HERTA_PUPPET_HELMET.get())
                .add(HnSItemRegistry.HERTA_PUPPET_CHESTPLATE.get())
                .add(HnSItemRegistry.HERTA_PUPPET_LEGGINGS.get())
                .add(HnSItemRegistry.HERTA_PUPPET_BOOTS.get())

                /*
                *** Lightning
                 */

                //Cryogenic Ruler Armor
                .add(HnSItemRegistry.CHARGED_SCOURGE_HELMET.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_CHESTPLATE.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_LEGGINGS.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_BOOTS.get())

                //Thunder Prowler Armor
                .add(HnSItemRegistry.THUNDER_PROWLER_HELMET.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_CHESTPLATE.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_LEGGINGS.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_BOOTS.get())

                /*
                *** Nature
                 */

                //Creaking Sorcerer Armor
                .add(HnSItemRegistry.CREAKING_HELMET.get())
                .add(HnSItemRegistry.CREAKING_CHESTPLATE.get())
                .add(HnSItemRegistry.CREAKING_LEGGINGS.get())
                .add(HnSItemRegistry.CREAKING_BOOTS.get())

                // Chlorophyte Armor
                .add(HnSItemRegistry.CHLOROPHYTE_HELMET.get())
                .add(HnSItemRegistry.CHLOROPHYTE_MASK.get())
                .add(HnSItemRegistry.CHLOROPHYTE_HEADGEAR.get())
                .add(HnSItemRegistry.CHLOROPHYTE_CHESTPLATE.get())
                .add(HnSItemRegistry.CHLOROPHYTE_LEGGINGS.get())
                .add(HnSItemRegistry.CHLOROPHYTE_BOOTS.get())

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

                //Ender Dragon Armor
                .add(HnSItemRegistry.ENDER_DRAGON_HELMET.get())
                .add(HnSItemRegistry.ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItemRegistry.ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItemRegistry.ENDER_DRAGON_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_BOOTS.get())

                /*
                 *** Holy
                 */

                //Seraph Armor
                .add(HnSItemRegistry.SERAPH_HELMET.get())
                .add(HnSItemRegistry.SERAPH_CHESTPLATE.get())
                .add(HnSItemRegistry.SERAPH_LEGGINGS.get())
                .add(HnSItemRegistry.SERAPH_BOOTS.get())

                //Gabriel ULTRAKILL Armor
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_BOOTS.get())

                //Mothic Witch Armor
                .add(HnSItemRegistry.MOTHIC_WITCH_HELMET.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_CHESTPLATE.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_SECRET_CHESTPLATE.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_LEGGINGS.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_BOOTS.get())

                /*
                *** Evocation
                */

                //Supreme Witch Armor
                .add(HnSItemRegistry.SUPREME_WITCH_HELMET.get())
                .add(HnSItemRegistry.SUPREME_WITCH_CHESTPLATE.get())
                .add(HnSItemRegistry.SUPREME_WITCH_LEGGINGS.get())
                .add(HnSItemRegistry.SUPREME_WITCH_BOOTS.get())

                //Alchemist Supreme Armor
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_HELMET.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_LEGGINGS.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_BOOTS.get())

                /*
                 *** Radiance
                 */

                //Mycelium Guardian Armor
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_HELMET.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_CHESTPLATE.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_LEGGINGS.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_BOOTS.get())

                /*
                 *** Shadow
                 */

                //Shadow Scale Armor
                .add(HnSItemRegistry.SHADOW_SCALE_HELMET.get())
                .add(HnSItemRegistry.SHADOW_SCALE_CHESTPLATE.get())
                .add(HnSItemRegistry.SHADOW_SCALE_LEGGINGS.get())
                .add(HnSItemRegistry.SHADOW_SCALE_BOOTS.get())

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
                *** Pyrium
                 */

                //Pyrium Armor
                .add(HnSItemRegistry.PYRIUM_HELMET.get())
                .add(HnSItemRegistry.PYRIUM_CHESTPLATE.get())
                .add(HnSItemRegistry.PYRIUM_LEGGINGS.get())
                .add(HnSItemRegistry.PYRIUM_BOOTS.get())

                //Pyrium Battlemage Armor
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_BOOTS.get())

                //Legionnaire Armor
                .add(HnSItemRegistry.LEGIONNAIRE_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_BOOTS.get())

                //Legionnaire Ruler Armor
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_BOOTS.get())

                //Legionnaire Commander Armor
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_BOOTS.get())

                //Tyros Armor
                .add(HnSItemRegistry.TYROS_HELMET.get())
                .add(HnSItemRegistry.TYROS_CHESTPLATE.get())
                .add(HnSItemRegistry.TYROS_LEGGINGS.get())
                .add(HnSItemRegistry.TYROS_BOOTS.get())

                .add(HnSItemRegistry.TYROS_SOUL_HELMET.get())
                .add(HnSItemRegistry.TYROS_SOUL_CHESTPLATE.get())
                .add(HnSItemRegistry.TYROS_SOUL_LEGGINGS.get())
                .add(HnSItemRegistry.TYROS_SOUL_BOOTS.get())

                /*
                *** Cosmetic Battlemage
                 */

                //Frieren Armor
                .add(HnSItemRegistry.FRIEREN_HELMET.get())
                .add(HnSItemRegistry.FRIEREN_CHESTPLATE.get())
                .add(HnSItemRegistry.FRIEREN_LEGGINGS.get())
                .add(HnSItemRegistry.FRIEREN_BOOTS.get())

                //SynthV
                .add(HnSItemRegistry.SYNTHESIZER_V_HELMET.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_CHESTPLATE.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_LEGGINGS.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_BOOTS.get())

                //UTAU Armor
                .add(HnSItemRegistry.UTAU_HELMET.get())
                .add(HnSItemRegistry.UTAU_CHESTPLATE.get())
                .add(HnSItemRegistry.UTAU_LEGGINGS.get())
                .add(HnSItemRegistry.UTAU_BOOTS.get())

                //PROJECT SEKAI Armor
                .add(HnSItemRegistry.PROJECT_SEKAI_HELMET.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_CHESTPLATE.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_LEGGINGS.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_BOOTS.get())

                //Rotten Girl Armor
                .add(HnSItemRegistry.ROTTEN_GIRL_HELMET.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_CHESTPLATE.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_LEGGINGS.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_BOOTS.get())

                //Neru Armor
                .add(HnSItemRegistry.NERU_HELMET.get())
                .add(HnSItemRegistry.NERU_CHESTPLATE.get())
                .add(HnSItemRegistry.NERU_LEGGINGS.get())
                .add(HnSItemRegistry.NERU_BOOTS.get())

                //Giorno Giovanna Armor
                .add(HnSItemRegistry.GIORNO_GIOVANNA_HELMET.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_CHESTPLATE.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_LEGGINGS.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_BOOTS.get())

                /*
                *** Mining
                 */

                //Miner Armor
                .add(HnSItemRegistry.MINER_HELMET.get())
                .add(HnSItemRegistry.MINER_CHESTPLATE.get())
                .add(HnSItemRegistry.MINER_LEGGINGS.get())
                .add(HnSItemRegistry.MINER_BOOTS.get())

                //Spectral Spelunker Armor
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_HELMET.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_CHESTPLATE.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_LEGGINGS.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_BOOTS.get())

                /*
                *** Archer
                 */

                //Bounty Hunter Armor
                .add(HnSItemRegistry.BOUNTY_HUNTER_HELMET.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_BOOTS.get())

                //Frostbite Hunter Armor
                .add(HnSItemRegistry.FROSTBITE_HUNTER_HELMET.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_BOOTS.get())

                /*
                *** Melee
                 */

                //Frostbite Knight Armor
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_BOOTS.get())

                //Dreadsteel Knight Armor
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_BOOTS.get())

                /*
                *** Misc
                 */


                //Magehunter Armor
                .add(HnSItemRegistry.MAGEHUNTER_HELMET.get())
                .add(HnSItemRegistry.MAGEHUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.MAGEHUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.MAGEHUNTER_BOOTS.get())

                //Mithril Battlemage Armor
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_BOOTS.get())

                //Enderman Shadowwalker Armor
                .add(HnSItemRegistry.ENDERMAN_MASKED.get())
                .add(HnSItemRegistry.ENDERMAN_BLINDFOLD.get())
                .add(HnSItemRegistry.ENDERMAN_HOOD.get())
                .add(HnSItemRegistry.ENDERMAN_CHESTPLATE.get())
                .add(HnSItemRegistry.ENDERMAN_LEGGINGS.get())
                .add(HnSItemRegistry.ENDERMAN_BOOTS.get())

                //Pyromancer Brute Armor
                .add(HnSItemRegistry.PYROMANCER_BRUTE_HELMET.get())
                .add(HnSItemRegistry.PYROMANCER_BRUTE_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItemRegistry.BISHOP_OF_DECEIT_HELMET.get())
                .add(HnSItemRegistry.BISHOP_OF_DECEIT_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItemRegistry.NECROMANCER_HELMET.get())
                .add(HnSItemRegistry.NECROMANCER_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItemRegistry.NAMELESS_ONE_HELMET.get())
                .add(HnSItemRegistry.NAMELESS_ONE_CHESTPLATE.get())

                /*
                *** Tributes
                 */


                //Dark Ritual Templar Armor
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_BOOTS.get())


                //Fireblossom Battlemage Armor
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                //Arbitrium Robes Armor
                .add(HnSItemRegistry.ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_BOOTS.get())

                //Atlas Armor
                .add(HnSItemRegistry.ATLAS_HELMET.get())
                .add(HnSItemRegistry.ATLAS_CHESTPLATE.get())
                .add(HnSItemRegistry.ATLAS_LEGGINGS.get())
                .add(HnSItemRegistry.ATLAS_BOOTS.get())

                //Maverick Armor
                .add(HnSItemRegistry.MAVERICK_HELMET.get())
                .add(HnSItemRegistry.MAVERICK_CHESTPLATE.get())
                .add(HnSItemRegistry.MAVERICK_LEGGINGS.get())
                .add(HnSItemRegistry.MAVERICK_BOOTS.get())

                //SLC!CAT Armor
                .add(HnSItemRegistry.SLC_CAT_HELMET.get())
                .add(HnSItemRegistry.SLC_CAT_CHESTPLATE.get())
                .add(HnSItemRegistry.SLC_CAT_LEGGINGS.get())
                .add(HnSItemRegistry.SLC_CAT_BOOTS.get())

                //Abberant Predator Armor
                .add(HnSItemRegistry.ABBERANT_PREDATOR_HELMET.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_CHESTPLATE.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_LEGGINGS.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_BOOTS.get())

                //Iron431 Armor
                .add(HnSItemRegistry.IRON431_HELMET.get())
                .add(HnSItemRegistry.IRON431_CHESTPLATE.get())
                .add(HnSItemRegistry.IRON431_LEGGINGS.get())
                .add(HnSItemRegistry.IRON431_BOOTS.get())

                .add(HnSItemRegistry.ASCENDED_IRON431_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_BOOTS.get())

                //Sacred Robes Armor
                .add(HnSItemRegistry.SACRED_ROBES_HELMET.get())
                .add(HnSItemRegistry.SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.SACRED_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.SACRED_ROBES_BOOTS.get())

                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_BOOTS.get())

                //Lemon God Armor
                .add(HnSItemRegistry.LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.LEMON_GOD_BOOTS.get())

                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_BOOTS.get())

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


                /*
                *** Tools
                 */

                .add(HnSItemRegistry.SPECTRAL_PICKAXE.get())
                .add(HnSItemRegistry.PICKAXE_AXE.get())
                .add(HnSItemRegistry.PICKAXE_AXE_DIVINE_GOLD.get())

        ;

        tag(ItemTags.EQUIPPABLE_ENCHANTABLE)
                /*
                *** Fire
                 */

                //Calamitas Armor
                .add(HnSItemRegistry.CALAMITAS_HELMET.get())
                .add(HnSItemRegistry.CALAMITAS_CHESTPLATE.get())
                .add(HnSItemRegistry.CALAMITAS_LEGGINGS.get())
                .add(HnSItemRegistry.CALAMITAS_BOOTS.get())

                //Blazeborne Armor
                .add(HnSItemRegistry.BLAZEBORNE_HELMET.get())
                .add(HnSItemRegistry.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItemRegistry.BLAZEBORNE_LEGGINGS.get())
                .add(HnSItemRegistry.BLAZEBORNE_BOOTS.get())

                //Soul Flame Armor
                .add(HnSItemRegistry.SOUL_FLAME_HELMET.get())
                .add(HnSItemRegistry.SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItemRegistry.SOUL_FLAME_LEGGINGS.get())
                .add(HnSItemRegistry.SOUL_FLAME_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_BOOTS.get())

                //Hazel Armor
                .add(HnSItemRegistry.HAZEL_HELMET.get())
                .add(HnSItemRegistry.HAZEL_CHESTPLATE.get())
                .add(HnSItemRegistry.HAZEL_HOLY_MOLLY_CHESTPLATE.get())
                .add(HnSItemRegistry.HAZEL_LEGGINGS.get())
                .add(HnSItemRegistry.HAZEL_BOOTS.get())

                /*
                *** Ice
                 */

                //Cryogenic Ruler Armor
                .add(HnSItemRegistry.CRYOGENIC_RULER_HELMET.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_BOOTS.get())

                //Crystal Arachnid Armor
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_HELMET.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_CHESTPLATE.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_LEGGINGS.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_BOOTS.get())

                //Herta Puppet Armor
                .add(HnSItemRegistry.HERTA_PUPPET_HELMET.get())
                .add(HnSItemRegistry.HERTA_PUPPET_CHESTPLATE.get())
                .add(HnSItemRegistry.HERTA_PUPPET_LEGGINGS.get())
                .add(HnSItemRegistry.HERTA_PUPPET_BOOTS.get())

                /*
                *** Lightning
                 */

                //Cryogenic Ruler Armor
                .add(HnSItemRegistry.CHARGED_SCOURGE_HELMET.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_CHESTPLATE.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_LEGGINGS.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_BOOTS.get())

                //Thunder Prowler Armor
                .add(HnSItemRegistry.THUNDER_PROWLER_HELMET.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_CHESTPLATE.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_LEGGINGS.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_BOOTS.get())

                /*
                *** Nature
                 */

                //Creaking Sorcerer Armor
                .add(HnSItemRegistry.CREAKING_HELMET.get())
                .add(HnSItemRegistry.CREAKING_CHESTPLATE.get())
                .add(HnSItemRegistry.CREAKING_LEGGINGS.get())
                .add(HnSItemRegistry.CREAKING_BOOTS.get())

                // Chlorophyte Armor
                .add(HnSItemRegistry.CHLOROPHYTE_HELMET.get())
                .add(HnSItemRegistry.CHLOROPHYTE_MASK.get())
                .add(HnSItemRegistry.CHLOROPHYTE_HEADGEAR.get())
                .add(HnSItemRegistry.CHLOROPHYTE_CHESTPLATE.get())
                .add(HnSItemRegistry.CHLOROPHYTE_LEGGINGS.get())
                .add(HnSItemRegistry.CHLOROPHYTE_BOOTS.get())

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

                //Ender Dragon Armor
                .add(HnSItemRegistry.ENDER_DRAGON_HELMET.get())
                .add(HnSItemRegistry.ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItemRegistry.ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItemRegistry.ENDER_DRAGON_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_BOOTS.get())

                /*
                 *** Holy
                 */

                //Seraph Armor
                .add(HnSItemRegistry.SERAPH_HELMET.get())
                .add(HnSItemRegistry.SERAPH_CHESTPLATE.get())
                .add(HnSItemRegistry.SERAPH_LEGGINGS.get())
                .add(HnSItemRegistry.SERAPH_BOOTS.get())

                //Gabriel ULTRAKILL Armor
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_BOOTS.get())

                //Mothic Witch Armor
                .add(HnSItemRegistry.MOTHIC_WITCH_HELMET.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_CHESTPLATE.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_SECRET_CHESTPLATE.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_LEGGINGS.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_BOOTS.get())

                /*
                *** Evocation
                */

                //Supreme Witch Armor
                .add(HnSItemRegistry.SUPREME_WITCH_HELMET.get())
                .add(HnSItemRegistry.SUPREME_WITCH_CHESTPLATE.get())
                .add(HnSItemRegistry.SUPREME_WITCH_LEGGINGS.get())
                .add(HnSItemRegistry.SUPREME_WITCH_BOOTS.get())

                //Alchemist Supreme Armor
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_HELMET.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_LEGGINGS.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_BOOTS.get())

                /*
                 *** Radiance
                 */

                //Mycelium Guardian Armor
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_HELMET.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_CHESTPLATE.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_LEGGINGS.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_BOOTS.get())

                /*
                 *** Shadow
                 */

                //Shadow Scale Armor
                .add(HnSItemRegistry.SHADOW_SCALE_HELMET.get())
                .add(HnSItemRegistry.SHADOW_SCALE_CHESTPLATE.get())
                .add(HnSItemRegistry.SHADOW_SCALE_LEGGINGS.get())
                .add(HnSItemRegistry.SHADOW_SCALE_BOOTS.get())

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
                *** Pyrium
                 */

                //Pyrium Armor
                .add(HnSItemRegistry.PYRIUM_HELMET.get())
                .add(HnSItemRegistry.PYRIUM_CHESTPLATE.get())
                .add(HnSItemRegistry.PYRIUM_LEGGINGS.get())
                .add(HnSItemRegistry.PYRIUM_BOOTS.get())

                //Pyrium Battlemage Armor
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_BOOTS.get())

                //Legionnaire Armor
                .add(HnSItemRegistry.LEGIONNAIRE_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_BOOTS.get())

                //Legionnaire Ruler Armor
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_BOOTS.get())

                //Legionnaire Commander Armor
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_BOOTS.get())

                //Tyros Armor
                .add(HnSItemRegistry.TYROS_HELMET.get())
                .add(HnSItemRegistry.TYROS_CHESTPLATE.get())
                .add(HnSItemRegistry.TYROS_LEGGINGS.get())
                .add(HnSItemRegistry.TYROS_BOOTS.get())

                .add(HnSItemRegistry.TYROS_SOUL_HELMET.get())
                .add(HnSItemRegistry.TYROS_SOUL_CHESTPLATE.get())
                .add(HnSItemRegistry.TYROS_SOUL_LEGGINGS.get())
                .add(HnSItemRegistry.TYROS_SOUL_BOOTS.get())

                /*
                *** Cosmetic Battlemage
                 */

                //Frieren Armor
                .add(HnSItemRegistry.FRIEREN_HELMET.get())
                .add(HnSItemRegistry.FRIEREN_CHESTPLATE.get())
                .add(HnSItemRegistry.FRIEREN_LEGGINGS.get())
                .add(HnSItemRegistry.FRIEREN_BOOTS.get())

                //SynthV
                .add(HnSItemRegistry.SYNTHESIZER_V_HELMET.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_CHESTPLATE.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_LEGGINGS.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_BOOTS.get())

                //UTAU Armor
                .add(HnSItemRegistry.UTAU_HELMET.get())
                .add(HnSItemRegistry.UTAU_CHESTPLATE.get())
                .add(HnSItemRegistry.UTAU_LEGGINGS.get())
                .add(HnSItemRegistry.UTAU_BOOTS.get())

                //PROJECT SEKAI Armor
                .add(HnSItemRegistry.PROJECT_SEKAI_HELMET.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_CHESTPLATE.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_LEGGINGS.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_BOOTS.get())

                //Rotten Girl Armor
                .add(HnSItemRegistry.ROTTEN_GIRL_HELMET.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_CHESTPLATE.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_LEGGINGS.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_BOOTS.get())

                //Neru Armor
                .add(HnSItemRegistry.NERU_HELMET.get())
                .add(HnSItemRegistry.NERU_CHESTPLATE.get())
                .add(HnSItemRegistry.NERU_LEGGINGS.get())
                .add(HnSItemRegistry.NERU_BOOTS.get())

                //Giorno Giovanna Armor
                .add(HnSItemRegistry.GIORNO_GIOVANNA_HELMET.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_CHESTPLATE.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_LEGGINGS.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_BOOTS.get())

                /*
                *** Mining
                 */

                //Miner Armor
                .add(HnSItemRegistry.MINER_HELMET.get())
                .add(HnSItemRegistry.MINER_CHESTPLATE.get())
                .add(HnSItemRegistry.MINER_LEGGINGS.get())
                .add(HnSItemRegistry.MINER_BOOTS.get())

                //Spectral Spelunker Armor
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_HELMET.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_CHESTPLATE.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_LEGGINGS.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_BOOTS.get())

                /*
                *** Archer
                 */

                //Bounty Hunter Armor
                .add(HnSItemRegistry.BOUNTY_HUNTER_HELMET.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_BOOTS.get())

                //Frostbite Hunter Armor
                .add(HnSItemRegistry.FROSTBITE_HUNTER_HELMET.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_BOOTS.get())

                /*
                *** Melee
                 */

                //Frostbite Knight Armor
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_BOOTS.get())

                //Dreadsteel Knight Armor
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_BOOTS.get())

                /*
                *** Misc
                 */


                //Magehunter Armor
                .add(HnSItemRegistry.MAGEHUNTER_HELMET.get())
                .add(HnSItemRegistry.MAGEHUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.MAGEHUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.MAGEHUNTER_BOOTS.get())

                //Mithril Battlemage Armor
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_BOOTS.get())

                /*
                *** Tributes
                 */


                //Dark Ritual Templar Armor
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_BOOTS.get())


                //Fireblossom Battlemage Armor
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                //Arbitrium Robes Armor
                .add(HnSItemRegistry.ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_BOOTS.get())

                //Atlas Armor
                .add(HnSItemRegistry.ATLAS_HELMET.get())
                .add(HnSItemRegistry.ATLAS_CHESTPLATE.get())
                .add(HnSItemRegistry.ATLAS_LEGGINGS.get())
                .add(HnSItemRegistry.ATLAS_BOOTS.get())

                //Maverick Armor
                .add(HnSItemRegistry.MAVERICK_HELMET.get())
                .add(HnSItemRegistry.MAVERICK_CHESTPLATE.get())
                .add(HnSItemRegistry.MAVERICK_LEGGINGS.get())
                .add(HnSItemRegistry.MAVERICK_BOOTS.get())

                //SLC!CAT Armor
                .add(HnSItemRegistry.SLC_CAT_HELMET.get())
                .add(HnSItemRegistry.SLC_CAT_CHESTPLATE.get())
                .add(HnSItemRegistry.SLC_CAT_LEGGINGS.get())
                .add(HnSItemRegistry.SLC_CAT_BOOTS.get())

                //Abberant Predator Armor
                .add(HnSItemRegistry.ABBERANT_PREDATOR_HELMET.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_CHESTPLATE.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_LEGGINGS.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_BOOTS.get())

                //Iron431 Armor
                .add(HnSItemRegistry.IRON431_HELMET.get())
                .add(HnSItemRegistry.IRON431_CHESTPLATE.get())
                .add(HnSItemRegistry.IRON431_LEGGINGS.get())
                .add(HnSItemRegistry.IRON431_BOOTS.get())

                .add(HnSItemRegistry.ASCENDED_IRON431_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_BOOTS.get())

                //Sacred Robes Armor
                .add(HnSItemRegistry.SACRED_ROBES_HELMET.get())
                .add(HnSItemRegistry.SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.SACRED_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.SACRED_ROBES_BOOTS.get())

                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_BOOTS.get())

                //Lemon God Armor
                .add(HnSItemRegistry.LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.LEMON_GOD_BOOTS.get())

                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_BOOTS.get())
        ;

        tag(ItemTags.DURABILITY_ENCHANTABLE)

                /*
                *** Armor
                 */

                /*
                *** Fire
                 */

                //Calamitas Armor
                .add(HnSItemRegistry.CALAMITAS_HELMET.get())
                .add(HnSItemRegistry.CALAMITAS_CHESTPLATE.get())
                .add(HnSItemRegistry.CALAMITAS_LEGGINGS.get())
                .add(HnSItemRegistry.CALAMITAS_BOOTS.get())

                //Blazeborne Armor
                .add(HnSItemRegistry.BLAZEBORNE_HELMET.get())
                .add(HnSItemRegistry.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItemRegistry.BLAZEBORNE_LEGGINGS.get())
                .add(HnSItemRegistry.BLAZEBORNE_BOOTS.get())

                //Soul Flame Armor
                .add(HnSItemRegistry.SOUL_FLAME_HELMET.get())
                .add(HnSItemRegistry.SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItemRegistry.SOUL_FLAME_LEGGINGS.get())
                .add(HnSItemRegistry.SOUL_FLAME_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_BOOTS.get())

                //Hazel Armor
                .add(HnSItemRegistry.HAZEL_HELMET.get())
                .add(HnSItemRegistry.HAZEL_CHESTPLATE.get())
                .add(HnSItemRegistry.HAZEL_HOLY_MOLLY_CHESTPLATE.get())
                .add(HnSItemRegistry.HAZEL_LEGGINGS.get())
                .add(HnSItemRegistry.HAZEL_BOOTS.get())

                /*
                *** Ice
                 */

                //Cryogenic Ruler Armor
                .add(HnSItemRegistry.CRYOGENIC_RULER_HELMET.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_BOOTS.get())

                //Crystal Arachnid Armor
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_HELMET.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_CHESTPLATE.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_LEGGINGS.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_BOOTS.get())

                //Herta Puppet Armor
                .add(HnSItemRegistry.HERTA_PUPPET_HELMET.get())
                .add(HnSItemRegistry.HERTA_PUPPET_CHESTPLATE.get())
                .add(HnSItemRegistry.HERTA_PUPPET_LEGGINGS.get())
                .add(HnSItemRegistry.HERTA_PUPPET_BOOTS.get())

                /*
                *** Lightning
                 */

                //Cryogenic Ruler Armor
                .add(HnSItemRegistry.CHARGED_SCOURGE_HELMET.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_CHESTPLATE.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_LEGGINGS.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_BOOTS.get())

                //Thunder Prowler Armor
                .add(HnSItemRegistry.THUNDER_PROWLER_HELMET.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_CHESTPLATE.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_LEGGINGS.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_BOOTS.get())

                /*
                *** Nature
                 */

                //Creaking Sorcerer Armor
                .add(HnSItemRegistry.CREAKING_HELMET.get())
                .add(HnSItemRegistry.CREAKING_CHESTPLATE.get())
                .add(HnSItemRegistry.CREAKING_LEGGINGS.get())
                .add(HnSItemRegistry.CREAKING_BOOTS.get())

                // Chlorophyte Armor
                .add(HnSItemRegistry.CHLOROPHYTE_HELMET.get())
                .add(HnSItemRegistry.CHLOROPHYTE_MASK.get())
                .add(HnSItemRegistry.CHLOROPHYTE_HEADGEAR.get())
                .add(HnSItemRegistry.CHLOROPHYTE_CHESTPLATE.get())
                .add(HnSItemRegistry.CHLOROPHYTE_LEGGINGS.get())
                .add(HnSItemRegistry.CHLOROPHYTE_BOOTS.get())

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

                //Ender Dragon Armor
                .add(HnSItemRegistry.ENDER_DRAGON_HELMET.get())
                .add(HnSItemRegistry.ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItemRegistry.ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItemRegistry.ENDER_DRAGON_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_BOOTS.get())

                /*
                 *** Holy
                 */

                //Seraph Armor
                .add(HnSItemRegistry.SERAPH_HELMET.get())
                .add(HnSItemRegistry.SERAPH_CHESTPLATE.get())
                .add(HnSItemRegistry.SERAPH_LEGGINGS.get())
                .add(HnSItemRegistry.SERAPH_BOOTS.get())

                //Gabriel ULTRAKILL Armor
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_BOOTS.get())

                //Mothic Witch Armor
                .add(HnSItemRegistry.MOTHIC_WITCH_HELMET.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_CHESTPLATE.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_SECRET_CHESTPLATE.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_LEGGINGS.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_BOOTS.get())

                /*
                *** Evocation
                */

                //Supreme Witch Armor
                .add(HnSItemRegistry.SUPREME_WITCH_HELMET.get())
                .add(HnSItemRegistry.SUPREME_WITCH_CHESTPLATE.get())
                .add(HnSItemRegistry.SUPREME_WITCH_LEGGINGS.get())
                .add(HnSItemRegistry.SUPREME_WITCH_BOOTS.get())

                //Alchemist Supreme Armor
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_HELMET.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_LEGGINGS.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_BOOTS.get())

                /*
                 *** Radiance
                 */

                //Mycelium Guardian Armor
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_HELMET.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_CHESTPLATE.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_LEGGINGS.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_BOOTS.get())

                /*
                 *** Shadow
                 */

                //Shadow Scale Armor
                .add(HnSItemRegistry.SHADOW_SCALE_HELMET.get())
                .add(HnSItemRegistry.SHADOW_SCALE_CHESTPLATE.get())
                .add(HnSItemRegistry.SHADOW_SCALE_LEGGINGS.get())
                .add(HnSItemRegistry.SHADOW_SCALE_BOOTS.get())

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
                *** Pyrium
                 */

                //Pyrium Armor
                .add(HnSItemRegistry.PYRIUM_HELMET.get())
                .add(HnSItemRegistry.PYRIUM_CHESTPLATE.get())
                .add(HnSItemRegistry.PYRIUM_LEGGINGS.get())
                .add(HnSItemRegistry.PYRIUM_BOOTS.get())

                //Pyrium Battlemage Armor
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_BOOTS.get())

                //Legionnaire Armor
                .add(HnSItemRegistry.LEGIONNAIRE_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_BOOTS.get())

                //Legionnaire Ruler Armor
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_BOOTS.get())

                //Legionnaire Commander Armor
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_BOOTS.get())

                //Tyros Armor
                .add(HnSItemRegistry.TYROS_HELMET.get())
                .add(HnSItemRegistry.TYROS_CHESTPLATE.get())
                .add(HnSItemRegistry.TYROS_LEGGINGS.get())
                .add(HnSItemRegistry.TYROS_BOOTS.get())

                .add(HnSItemRegistry.TYROS_SOUL_HELMET.get())
                .add(HnSItemRegistry.TYROS_SOUL_CHESTPLATE.get())
                .add(HnSItemRegistry.TYROS_SOUL_LEGGINGS.get())
                .add(HnSItemRegistry.TYROS_SOUL_BOOTS.get())

                /*
                *** Cosmetic Battlemage
                 */

                //Frieren Armor
                .add(HnSItemRegistry.FRIEREN_HELMET.get())
                .add(HnSItemRegistry.FRIEREN_CHESTPLATE.get())
                .add(HnSItemRegistry.FRIEREN_LEGGINGS.get())
                .add(HnSItemRegistry.FRIEREN_BOOTS.get())

                //SynthV
                .add(HnSItemRegistry.SYNTHESIZER_V_HELMET.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_CHESTPLATE.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_LEGGINGS.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_BOOTS.get())

                //UTAU Armor
                .add(HnSItemRegistry.UTAU_HELMET.get())
                .add(HnSItemRegistry.UTAU_CHESTPLATE.get())
                .add(HnSItemRegistry.UTAU_LEGGINGS.get())
                .add(HnSItemRegistry.UTAU_BOOTS.get())

                //PROJECT SEKAI Armor
                .add(HnSItemRegistry.PROJECT_SEKAI_HELMET.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_CHESTPLATE.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_LEGGINGS.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_BOOTS.get())

                //Rotten Girl Armor
                .add(HnSItemRegistry.ROTTEN_GIRL_HELMET.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_CHESTPLATE.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_LEGGINGS.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_BOOTS.get())

                //Neru Armor
                .add(HnSItemRegistry.NERU_HELMET.get())
                .add(HnSItemRegistry.NERU_CHESTPLATE.get())
                .add(HnSItemRegistry.NERU_LEGGINGS.get())
                .add(HnSItemRegistry.NERU_BOOTS.get())

                //Giorno Giovanna Armor
                .add(HnSItemRegistry.GIORNO_GIOVANNA_HELMET.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_CHESTPLATE.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_LEGGINGS.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_BOOTS.get())

                /*
                *** Mining
                 */

                //Miner Armor
                .add(HnSItemRegistry.MINER_HELMET.get())
                .add(HnSItemRegistry.MINER_CHESTPLATE.get())
                .add(HnSItemRegistry.MINER_LEGGINGS.get())
                .add(HnSItemRegistry.MINER_BOOTS.get())

                //Spectral Spelunker Armor
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_HELMET.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_CHESTPLATE.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_LEGGINGS.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_BOOTS.get())

                /*
                *** Archer
                 */

                //Bounty Hunter Armor
                .add(HnSItemRegistry.BOUNTY_HUNTER_HELMET.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_BOOTS.get())

                //Frostbite Hunter Armor
                .add(HnSItemRegistry.FROSTBITE_HUNTER_HELMET.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_BOOTS.get())

                /*
                *** Melee
                 */

                //Frostbite Knight Armor
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_BOOTS.get())

                //Dreadsteel Knight Armor
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_BOOTS.get())

                /*
                *** Misc
                 */


                //Magehunter Armor
                .add(HnSItemRegistry.MAGEHUNTER_HELMET.get())
                .add(HnSItemRegistry.MAGEHUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.MAGEHUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.MAGEHUNTER_BOOTS.get())

                //Mithril Battlemage Armor
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_BOOTS.get())

                //Enderman Shadowwalker Armor
                .add(HnSItemRegistry.ENDERMAN_MASKED.get())
                .add(HnSItemRegistry.ENDERMAN_BLINDFOLD.get())
                .add(HnSItemRegistry.ENDERMAN_HOOD.get())
                .add(HnSItemRegistry.ENDERMAN_CHESTPLATE.get())
                .add(HnSItemRegistry.ENDERMAN_LEGGINGS.get())
                .add(HnSItemRegistry.ENDERMAN_BOOTS.get())

                //Pyromancer Brute Armor
                .add(HnSItemRegistry.PYROMANCER_BRUTE_HELMET.get())
                .add(HnSItemRegistry.PYROMANCER_BRUTE_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItemRegistry.BISHOP_OF_DECEIT_HELMET.get())
                .add(HnSItemRegistry.BISHOP_OF_DECEIT_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItemRegistry.NECROMANCER_HELMET.get())
                .add(HnSItemRegistry.NECROMANCER_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItemRegistry.NAMELESS_ONE_HELMET.get())
                .add(HnSItemRegistry.NAMELESS_ONE_CHESTPLATE.get())

                /*
                *** Tributes
                 */


                //Dark Ritual Templar Armor
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_BOOTS.get())


                //Fireblossom Battlemage Armor
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                //Arbitrium Robes Armor
                .add(HnSItemRegistry.ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_BOOTS.get())

                //Atlas Armor
                .add(HnSItemRegistry.ATLAS_HELMET.get())
                .add(HnSItemRegistry.ATLAS_CHESTPLATE.get())
                .add(HnSItemRegistry.ATLAS_LEGGINGS.get())
                .add(HnSItemRegistry.ATLAS_BOOTS.get())

                //Maverick Armor
                .add(HnSItemRegistry.MAVERICK_HELMET.get())
                .add(HnSItemRegistry.MAVERICK_CHESTPLATE.get())
                .add(HnSItemRegistry.MAVERICK_LEGGINGS.get())
                .add(HnSItemRegistry.MAVERICK_BOOTS.get())

                //SLC!CAT Armor
                .add(HnSItemRegistry.SLC_CAT_HELMET.get())
                .add(HnSItemRegistry.SLC_CAT_CHESTPLATE.get())
                .add(HnSItemRegistry.SLC_CAT_LEGGINGS.get())
                .add(HnSItemRegistry.SLC_CAT_BOOTS.get())

                //Abberant Predator Armor
                .add(HnSItemRegistry.ABBERANT_PREDATOR_HELMET.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_CHESTPLATE.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_LEGGINGS.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_BOOTS.get())

                //Iron431 Armor
                .add(HnSItemRegistry.IRON431_HELMET.get())
                .add(HnSItemRegistry.IRON431_CHESTPLATE.get())
                .add(HnSItemRegistry.IRON431_LEGGINGS.get())
                .add(HnSItemRegistry.IRON431_BOOTS.get())

                .add(HnSItemRegistry.ASCENDED_IRON431_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_BOOTS.get())

                //Sacred Robes Armor
                .add(HnSItemRegistry.SACRED_ROBES_HELMET.get())
                .add(HnSItemRegistry.SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.SACRED_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.SACRED_ROBES_BOOTS.get())

                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_BOOTS.get())

                //Lemon God Armor
                .add(HnSItemRegistry.LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.LEMON_GOD_BOOTS.get())

                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_BOOTS.get())

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

                /*
                *** Tools
                */

                .add(HnSItemRegistry.SPECTRAL_PICKAXE.get())
                .add(HnSItemRegistry.PICKAXE_AXE.get())
                .add(HnSItemRegistry.PICKAXE_AXE_DIVINE_GOLD.get())
        ;

        /*
        *** Armor Tags
         */

        tag(Tags.Items.ARMORS)

                /*
                *** Fire
                 */

                //Calamitas Armor
                .add(HnSItemRegistry.CALAMITAS_HELMET.get())
                .add(HnSItemRegistry.CALAMITAS_CHESTPLATE.get())
                .add(HnSItemRegistry.CALAMITAS_LEGGINGS.get())
                .add(HnSItemRegistry.CALAMITAS_BOOTS.get())

                //Blazeborne Armor
                .add(HnSItemRegistry.BLAZEBORNE_HELMET.get())
                .add(HnSItemRegistry.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItemRegistry.BLAZEBORNE_LEGGINGS.get())
                .add(HnSItemRegistry.BLAZEBORNE_BOOTS.get())

                //Soul Flame Armor
                .add(HnSItemRegistry.SOUL_FLAME_HELMET.get())
                .add(HnSItemRegistry.SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItemRegistry.SOUL_FLAME_LEGGINGS.get())
                .add(HnSItemRegistry.SOUL_FLAME_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_BOOTS.get())

                //Hazel Armor
                .add(HnSItemRegistry.HAZEL_HELMET.get())
                .add(HnSItemRegistry.HAZEL_CHESTPLATE.get())
                .add(HnSItemRegistry.HAZEL_HOLY_MOLLY_CHESTPLATE.get())
                .add(HnSItemRegistry.HAZEL_LEGGINGS.get())
                .add(HnSItemRegistry.HAZEL_BOOTS.get())

                /*
                *** Ice
                 */

                //Cryogenic Ruler Armor
                .add(HnSItemRegistry.CRYOGENIC_RULER_HELMET.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_BOOTS.get())

                //Crystal Arachnid Armor
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_HELMET.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_CHESTPLATE.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_LEGGINGS.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_BOOTS.get())

                //Herta Puppet Armor
                .add(HnSItemRegistry.HERTA_PUPPET_HELMET.get())
                .add(HnSItemRegistry.HERTA_PUPPET_CHESTPLATE.get())
                .add(HnSItemRegistry.HERTA_PUPPET_LEGGINGS.get())
                .add(HnSItemRegistry.HERTA_PUPPET_BOOTS.get())

                /*
                *** Lightning
                 */

                //Cryogenic Ruler Armor
                .add(HnSItemRegistry.CHARGED_SCOURGE_HELMET.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_CHESTPLATE.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_LEGGINGS.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_BOOTS.get())

                //Thunder Prowler Armor
                .add(HnSItemRegistry.THUNDER_PROWLER_HELMET.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_CHESTPLATE.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_LEGGINGS.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_BOOTS.get())

                /*
                *** Nature
                 */

                //Creaking Sorcerer Armor
                .add(HnSItemRegistry.CREAKING_HELMET.get())
                .add(HnSItemRegistry.CREAKING_CHESTPLATE.get())
                .add(HnSItemRegistry.CREAKING_LEGGINGS.get())
                .add(HnSItemRegistry.CREAKING_BOOTS.get())

                // Chlorophyte Armor
                .add(HnSItemRegistry.CHLOROPHYTE_HELMET.get())
                .add(HnSItemRegistry.CHLOROPHYTE_MASK.get())
                .add(HnSItemRegistry.CHLOROPHYTE_HEADGEAR.get())
                .add(HnSItemRegistry.CHLOROPHYTE_CHESTPLATE.get())
                .add(HnSItemRegistry.CHLOROPHYTE_LEGGINGS.get())
                .add(HnSItemRegistry.CHLOROPHYTE_BOOTS.get())

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

                //Ender Dragon Armor
                .add(HnSItemRegistry.ENDER_DRAGON_HELMET.get())
                .add(HnSItemRegistry.ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItemRegistry.ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItemRegistry.ENDER_DRAGON_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_BOOTS.get())

                /*
                 *** Holy
                 */

                //Seraph Armor
                .add(HnSItemRegistry.SERAPH_HELMET.get())
                .add(HnSItemRegistry.SERAPH_CHESTPLATE.get())
                .add(HnSItemRegistry.SERAPH_LEGGINGS.get())
                .add(HnSItemRegistry.SERAPH_BOOTS.get())

                //Gabriel ULTRAKILL Armor
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_BOOTS.get())

                //Mothic Witch Armor
                .add(HnSItemRegistry.MOTHIC_WITCH_HELMET.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_CHESTPLATE.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_SECRET_CHESTPLATE.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_LEGGINGS.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_BOOTS.get())

                /*
                *** Evocation
                */

                //Supreme Witch Armor
                .add(HnSItemRegistry.SUPREME_WITCH_HELMET.get())
                .add(HnSItemRegistry.SUPREME_WITCH_CHESTPLATE.get())
                .add(HnSItemRegistry.SUPREME_WITCH_LEGGINGS.get())
                .add(HnSItemRegistry.SUPREME_WITCH_BOOTS.get())

                //Alchemist Supreme Armor
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_HELMET.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_LEGGINGS.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_BOOTS.get())

                /*
                 *** Radiance
                 */

                //Mycelium Guardian Armor
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_HELMET.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_CHESTPLATE.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_LEGGINGS.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_BOOTS.get())

                /*
                 *** Shadow
                 */

                //Shadow Scale Armor
                .add(HnSItemRegistry.SHADOW_SCALE_HELMET.get())
                .add(HnSItemRegistry.SHADOW_SCALE_CHESTPLATE.get())
                .add(HnSItemRegistry.SHADOW_SCALE_LEGGINGS.get())
                .add(HnSItemRegistry.SHADOW_SCALE_BOOTS.get())

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
                *** Pyrium
                 */

                //Pyrium Armor
                .add(HnSItemRegistry.PYRIUM_HELMET.get())
                .add(HnSItemRegistry.PYRIUM_CHESTPLATE.get())
                .add(HnSItemRegistry.PYRIUM_LEGGINGS.get())
                .add(HnSItemRegistry.PYRIUM_BOOTS.get())

                //Pyrium Battlemage Armor
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_BOOTS.get())

                //Legionnaire Armor
                .add(HnSItemRegistry.LEGIONNAIRE_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_BOOTS.get())

                //Legionnaire Ruler Armor
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_BOOTS.get())

                //Legionnaire Commander Armor
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_BOOTS.get())

                //Tyros Armor
                .add(HnSItemRegistry.TYROS_HELMET.get())
                .add(HnSItemRegistry.TYROS_CHESTPLATE.get())
                .add(HnSItemRegistry.TYROS_LEGGINGS.get())
                .add(HnSItemRegistry.TYROS_BOOTS.get())

                .add(HnSItemRegistry.TYROS_SOUL_HELMET.get())
                .add(HnSItemRegistry.TYROS_SOUL_CHESTPLATE.get())
                .add(HnSItemRegistry.TYROS_SOUL_LEGGINGS.get())
                .add(HnSItemRegistry.TYROS_SOUL_BOOTS.get())

                /*
                *** Cosmetic Battlemage
                 */

                //Frieren Armor
                .add(HnSItemRegistry.FRIEREN_HELMET.get())
                .add(HnSItemRegistry.FRIEREN_CHESTPLATE.get())
                .add(HnSItemRegistry.FRIEREN_LEGGINGS.get())
                .add(HnSItemRegistry.FRIEREN_BOOTS.get())

                //SynthV
                .add(HnSItemRegistry.SYNTHESIZER_V_HELMET.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_CHESTPLATE.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_LEGGINGS.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_BOOTS.get())

                //UTAU Armor
                .add(HnSItemRegistry.UTAU_HELMET.get())
                .add(HnSItemRegistry.UTAU_CHESTPLATE.get())
                .add(HnSItemRegistry.UTAU_LEGGINGS.get())
                .add(HnSItemRegistry.UTAU_BOOTS.get())

                //PROJECT SEKAI Armor
                .add(HnSItemRegistry.PROJECT_SEKAI_HELMET.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_CHESTPLATE.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_LEGGINGS.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_BOOTS.get())

                //Rotten Girl Armor
                .add(HnSItemRegistry.ROTTEN_GIRL_HELMET.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_CHESTPLATE.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_LEGGINGS.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_BOOTS.get())

                //Neru Armor
                .add(HnSItemRegistry.NERU_HELMET.get())
                .add(HnSItemRegistry.NERU_CHESTPLATE.get())
                .add(HnSItemRegistry.NERU_LEGGINGS.get())
                .add(HnSItemRegistry.NERU_BOOTS.get())

                //Giorno Giovanna Armor
                .add(HnSItemRegistry.GIORNO_GIOVANNA_HELMET.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_CHESTPLATE.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_LEGGINGS.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_BOOTS.get())

                /*
                *** Mining
                 */

                //Miner Armor
                .add(HnSItemRegistry.MINER_HELMET.get())
                .add(HnSItemRegistry.MINER_CHESTPLATE.get())
                .add(HnSItemRegistry.MINER_LEGGINGS.get())
                .add(HnSItemRegistry.MINER_BOOTS.get())

                //Spectral Spelunker Armor
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_HELMET.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_CHESTPLATE.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_LEGGINGS.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_BOOTS.get())

                /*
                *** Archer
                 */

                //Bounty Hunter Armor
                .add(HnSItemRegistry.BOUNTY_HUNTER_HELMET.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_BOOTS.get())

                //Frostbite Hunter Armor
                .add(HnSItemRegistry.FROSTBITE_HUNTER_HELMET.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_BOOTS.get())

                /*
                *** Melee
                 */

                //Frostbite Knight Armor
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_BOOTS.get())

                //Dreadsteel Knight Armor
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_BOOTS.get())

                /*
                *** Misc
                 */


                //Magehunter Armor
                .add(HnSItemRegistry.MAGEHUNTER_HELMET.get())
                .add(HnSItemRegistry.MAGEHUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.MAGEHUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.MAGEHUNTER_BOOTS.get())

                //Mithril Battlemage Armor
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_BOOTS.get())

                //Enderman Shadowwalker Armor
                .add(HnSItemRegistry.ENDERMAN_MASKED.get())
                .add(HnSItemRegistry.ENDERMAN_BLINDFOLD.get())
                .add(HnSItemRegistry.ENDERMAN_HOOD.get())
                .add(HnSItemRegistry.ENDERMAN_CHESTPLATE.get())
                .add(HnSItemRegistry.ENDERMAN_LEGGINGS.get())
                .add(HnSItemRegistry.ENDERMAN_BOOTS.get())

                //Pyromancer Brute Armor
                .add(HnSItemRegistry.PYROMANCER_BRUTE_HELMET.get())
                .add(HnSItemRegistry.PYROMANCER_BRUTE_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItemRegistry.BISHOP_OF_DECEIT_HELMET.get())
                .add(HnSItemRegistry.BISHOP_OF_DECEIT_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItemRegistry.NECROMANCER_HELMET.get())
                .add(HnSItemRegistry.NECROMANCER_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItemRegistry.NAMELESS_ONE_HELMET.get())
                .add(HnSItemRegistry.NAMELESS_ONE_CHESTPLATE.get())


                /*
                *** Tributes
                 */


                //Dark Ritual Templar Armor
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_BOOTS.get())


                //Fireblossom Battlemage Armor
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                //Arbitrium Robes Armor
                .add(HnSItemRegistry.ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_BOOTS.get())

                //Atlas Armor
                .add(HnSItemRegistry.ATLAS_HELMET.get())
                .add(HnSItemRegistry.ATLAS_CHESTPLATE.get())
                .add(HnSItemRegistry.ATLAS_LEGGINGS.get())
                .add(HnSItemRegistry.ATLAS_BOOTS.get())

                //Maverick Armor
                .add(HnSItemRegistry.MAVERICK_HELMET.get())
                .add(HnSItemRegistry.MAVERICK_CHESTPLATE.get())
                .add(HnSItemRegistry.MAVERICK_LEGGINGS.get())
                .add(HnSItemRegistry.MAVERICK_BOOTS.get())

                //SLC!CAT Armor
                .add(HnSItemRegistry.SLC_CAT_HELMET.get())
                .add(HnSItemRegistry.SLC_CAT_CHESTPLATE.get())
                .add(HnSItemRegistry.SLC_CAT_LEGGINGS.get())
                .add(HnSItemRegistry.SLC_CAT_BOOTS.get())

                //Abberant Predator Armor
                .add(HnSItemRegistry.ABBERANT_PREDATOR_HELMET.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_CHESTPLATE.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_LEGGINGS.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_BOOTS.get())

                //Iron431 Armor
                .add(HnSItemRegistry.IRON431_HELMET.get())
                .add(HnSItemRegistry.IRON431_CHESTPLATE.get())
                .add(HnSItemRegistry.IRON431_LEGGINGS.get())
                .add(HnSItemRegistry.IRON431_BOOTS.get())

                .add(HnSItemRegistry.ASCENDED_IRON431_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_BOOTS.get())

                //Sacred Robes Armor
                .add(HnSItemRegistry.SACRED_ROBES_HELMET.get())
                .add(HnSItemRegistry.SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.SACRED_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.SACRED_ROBES_BOOTS.get())

                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_BOOTS.get())

                //Lemon God Armor
                .add(HnSItemRegistry.LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.LEMON_GOD_BOOTS.get())

                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_BOOTS.get())
        ;

        tag(ItemTags.HEAD_ARMOR)
                .add(HnSItemRegistry.CALAMITAS_HELMET.get())
                .add(HnSItemRegistry.BLAZEBORNE_HELMET.get())
                .add(HnSItemRegistry.SOUL_FLAME_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_HELMET.get())
                .add(HnSItemRegistry.HAZEL_HELMET.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_HELMET.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_HELMET.get())
                .add(HnSItemRegistry.HERTA_PUPPET_HELMET.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_HELMET.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_HELMET.get())
                .add(HnSItemRegistry.CREAKING_HELMET.get())
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
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_HELMET.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_HELMET.get())
                .add(HnSItemRegistry.SHADOW_SCALE_HELMET.get())
                .add(HnSItemRegistry.INFESTATION_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_INFESTATION_HELMET.get())
                .add(HnSItemRegistry.PYRIUM_HELMET.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_HELMET.get())
                .add(HnSItemRegistry.TYROS_HELMET.get())
                .add(HnSItemRegistry.TYROS_SOUL_HELMET.get())
                .add(HnSItemRegistry.FRIEREN_HELMET.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_HELMET.get())
                .add(HnSItemRegistry.UTAU_HELMET.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_HELMET.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_HELMET.get())
                .add(HnSItemRegistry.NERU_HELMET.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_HELMET.get())
                .add(HnSItemRegistry.MINER_HELMET.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_HELMET.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_HELMET.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_HELMET.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.MAGEHUNTER_HELMET.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.ATLAS_HELMET.get())
                .add(HnSItemRegistry.MAVERICK_HELMET.get())
                .add(HnSItemRegistry.SLC_CAT_HELMET.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_HELMET.get())
                .add(HnSItemRegistry.IRON431_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_HELMET.get())
                .add(HnSItemRegistry.SACRED_ROBES_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_HELMET.get())
                .add(HnSItemRegistry.LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.ENDERMAN_MASKED.get())
                .add(HnSItemRegistry.ENDERMAN_BLINDFOLD.get())
                .add(HnSItemRegistry.ENDERMAN_HOOD.get())
                .add(HnSItemRegistry.PYROMANCER_BRUTE_HELMET.get())
                .add(HnSItemRegistry.BISHOP_OF_DECEIT_HELMET.get())
                .add(HnSItemRegistry.NECROMANCER_HELMET.get())
                .add(HnSItemRegistry.NAMELESS_ONE_HELMET.get())
                .add(HnSItemRegistry.CHLOROPHYTE_HELMET.get())
                .add(HnSItemRegistry.CHLOROPHYTE_HEADGEAR.get())
                .add(HnSItemRegistry.CHLOROPHYTE_MASK.get())
        ;

        tag(ItemTags.CHEST_ARMOR)
                .add(HnSItemRegistry.CALAMITAS_CHESTPLATE.get())
                .add(HnSItemRegistry.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItemRegistry.SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItemRegistry.HAZEL_CHESTPLATE.get())
                .add(HnSItemRegistry.HAZEL_HOLY_MOLLY_CHESTPLATE.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_CHESTPLATE.get())
                .add(HnSItemRegistry.HERTA_PUPPET_CHESTPLATE.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_CHESTPLATE.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_CHESTPLATE.get())
                .add(HnSItemRegistry.CREAKING_CHESTPLATE.get())
                .add(HnSItemRegistry.FLESH_MASS_CHESTPLATE.get())
                .add(HnSItemRegistry.FLESH_MASS_LEGGINGS.get())
                .add(HnSItemRegistry.THE_WITHER_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_THE_WITHER_CHESTPLATE.get())
                .add(HnSItemRegistry.ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItemRegistry.SERAPH_CHESTPLATE.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_CHESTPLATE.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_SECRET_CHESTPLATE.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_CHESTPLATE.get())
                .add(HnSItemRegistry.SHADOW_SCALE_CHESTPLATE.get())
                .add(HnSItemRegistry.INFESTATION_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_INFESTATION_CHESTPLATE.get())
                .add(HnSItemRegistry.PYRIUM_CHESTPLATE.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_CHESTPLATE.get())
                .add(HnSItemRegistry.TYROS_CHESTPLATE.get())
                .add(HnSItemRegistry.TYROS_SOUL_CHESTPLATE.get())
                .add(HnSItemRegistry.FRIEREN_CHESTPLATE.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_CHESTPLATE.get())
                .add(HnSItemRegistry.UTAU_CHESTPLATE.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_CHESTPLATE.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_CHESTPLATE.get())
                .add(HnSItemRegistry.NERU_CHESTPLATE.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_CHESTPLATE.get())
                .add(HnSItemRegistry.MINER_CHESTPLATE.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_CHESTPLATE.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.MAGEHUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ATLAS_CHESTPLATE.get())
                .add(HnSItemRegistry.MAVERICK_CHESTPLATE.get())
                .add(HnSItemRegistry.SLC_CAT_CHESTPLATE.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_CHESTPLATE.get())
                .add(HnSItemRegistry.IRON431_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_CHESTPLATE.get())
                .add(HnSItemRegistry.SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.ENDERMAN_CHESTPLATE.get())
                .add(HnSItemRegistry.PYROMANCER_BRUTE_CHESTPLATE.get())
                .add(HnSItemRegistry.BISHOP_OF_DECEIT_CHESTPLATE.get())
                .add(HnSItemRegistry.NECROMANCER_CHESTPLATE.get())
                .add(HnSItemRegistry.NAMELESS_ONE_CHESTPLATE.get())
                .add(HnSItemRegistry.CHLOROPHYTE_CHESTPLATE.get())
        ;

        tag(ItemTags.LEG_ARMOR)
                .add(HnSItemRegistry.CALAMITAS_LEGGINGS.get())
                .add(HnSItemRegistry.BLAZEBORNE_LEGGINGS.get())
                .add(HnSItemRegistry.SOUL_FLAME_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_LEGGINGS.get())
                .add(HnSItemRegistry.HAZEL_LEGGINGS.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_LEGGINGS.get())
                .add(HnSItemRegistry.HERTA_PUPPET_LEGGINGS.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_LEGGINGS.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_LEGGINGS.get())
                .add(HnSItemRegistry.CREAKING_LEGGINGS.get())
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
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_LEGGINGS.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_LEGGINGS.get())
                .add(HnSItemRegistry.SHADOW_SCALE_LEGGINGS.get())
                .add(HnSItemRegistry.INFESTATION_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_INFESTATION_LEGGINGS.get())
                .add(HnSItemRegistry.PYRIUM_LEGGINGS.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_LEGGINGS.get())
                .add(HnSItemRegistry.TYROS_LEGGINGS.get())
                .add(HnSItemRegistry.TYROS_SOUL_LEGGINGS.get())
                .add(HnSItemRegistry.FRIEREN_LEGGINGS.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_LEGGINGS.get())
                .add(HnSItemRegistry.UTAU_LEGGINGS.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_LEGGINGS.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_LEGGINGS.get())
                .add(HnSItemRegistry.NERU_LEGGINGS.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_LEGGINGS.get())
                .add(HnSItemRegistry.MINER_LEGGINGS.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_LEGGINGS.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.MAGEHUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ATLAS_LEGGINGS.get())
                .add(HnSItemRegistry.MAVERICK_LEGGINGS.get())
                .add(HnSItemRegistry.SLC_CAT_LEGGINGS.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_LEGGINGS.get())
                .add(HnSItemRegistry.IRON431_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_LEGGINGS.get())
                .add(HnSItemRegistry.SACRED_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.ENDERMAN_LEGGINGS.get())
                .add(HnSItemRegistry.NECROMANCER_LEGGINGS.get())
                .add(HnSItemRegistry.NAMELESS_ONE_LEGGINGS.get())
                .add(HnSItemRegistry.CHLOROPHYTE_LEGGINGS.get())
        ;

        tag(ItemTags.FOOT_ARMOR)
                .add(HnSItemRegistry.CALAMITAS_BOOTS.get())
                .add(HnSItemRegistry.BLAZEBORNE_BOOTS.get())
                .add(HnSItemRegistry.SOUL_FLAME_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_BOOTS.get())
                .add(HnSItemRegistry.HAZEL_BOOTS.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_BOOTS.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_BOOTS.get())
                .add(HnSItemRegistry.HERTA_PUPPET_BOOTS.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_BOOTS.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_BOOTS.get())
                .add(HnSItemRegistry.CREAKING_BOOTS.get())
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
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_BOOTS.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_BOOTS.get())
                .add(HnSItemRegistry.SHADOW_SCALE_BOOTS.get())
                .add(HnSItemRegistry.INFESTATION_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_INFESTATION_BOOTS.get())
                .add(HnSItemRegistry.PYRIUM_BOOTS.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_BOOTS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_BOOTS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_BOOTS.get())
                .add(HnSItemRegistry.TYROS_BOOTS.get())
                .add(HnSItemRegistry.TYROS_SOUL_BOOTS.get())
                .add(HnSItemRegistry.FRIEREN_BOOTS.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_BOOTS.get())
                .add(HnSItemRegistry.UTAU_BOOTS.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_BOOTS.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_BOOTS.get())
                .add(HnSItemRegistry.NERU_BOOTS.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_BOOTS.get())
                .add(HnSItemRegistry.MINER_BOOTS.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_BOOTS.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_BOOTS.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_BOOTS.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_BOOTS.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_BOOTS.get())
                .add(HnSItemRegistry.MAGEHUNTER_BOOTS.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_BOOTS.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_BOOTS.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_BOOTS.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItemRegistry.ATLAS_BOOTS.get())
                .add(HnSItemRegistry.MAVERICK_BOOTS.get())
                .add(HnSItemRegistry.SLC_CAT_BOOTS.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_BOOTS.get())
                .add(HnSItemRegistry.IRON431_BOOTS.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_BOOTS.get())
                .add(HnSItemRegistry.SACRED_ROBES_BOOTS.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_BOOTS.get())
                .add(HnSItemRegistry.LEMON_GOD_BOOTS.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_BOOTS.get())
                .add(HnSItemRegistry.ENDERMAN_BOOTS.get())
                .add(HnSItemRegistry.CHLOROPHYTE_BOOTS.get())
        ;

        tag(ItemTags.HEAD_ARMOR)
                .add(HnSItemRegistry.CALAMITAS_HELMET.get())
                .add(HnSItemRegistry.BLAZEBORNE_HELMET.get())
                .add(HnSItemRegistry.SOUL_FLAME_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_HELMET.get())
                .add(HnSItemRegistry.HAZEL_HELMET.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_HELMET.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_HELMET.get())
                .add(HnSItemRegistry.HERTA_PUPPET_HELMET.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_HELMET.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_HELMET.get())
                .add(HnSItemRegistry.CREAKING_HELMET.get())
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
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_HELMET.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_HELMET.get())
                .add(HnSItemRegistry.SHADOW_SCALE_HELMET.get())
                .add(HnSItemRegistry.INFESTATION_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_INFESTATION_HELMET.get())
                .add(HnSItemRegistry.PYRIUM_HELMET.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_HELMET.get())
                .add(HnSItemRegistry.TYROS_HELMET.get())
                .add(HnSItemRegistry.TYROS_SOUL_HELMET.get())
                .add(HnSItemRegistry.FRIEREN_HELMET.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_HELMET.get())
                .add(HnSItemRegistry.UTAU_HELMET.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_HELMET.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_HELMET.get())
                .add(HnSItemRegistry.NERU_HELMET.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_HELMET.get())
                .add(HnSItemRegistry.MINER_HELMET.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_HELMET.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_HELMET.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_HELMET.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.MAGEHUNTER_HELMET.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.ATLAS_HELMET.get())
                .add(HnSItemRegistry.MAVERICK_HELMET.get())
                .add(HnSItemRegistry.SLC_CAT_HELMET.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_HELMET.get())
                .add(HnSItemRegistry.IRON431_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_HELMET.get())
                .add(HnSItemRegistry.SACRED_ROBES_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_HELMET.get())
                .add(HnSItemRegistry.LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.ENDERMAN_MASKED.get())
                .add(HnSItemRegistry.ENDERMAN_BLINDFOLD.get())
                .add(HnSItemRegistry.ENDERMAN_HOOD.get())
                .add(HnSItemRegistry.PYROMANCER_BRUTE_HELMET.get())
                .add(HnSItemRegistry.BISHOP_OF_DECEIT_HELMET.get())
                .add(HnSItemRegistry.NECROMANCER_HELMET.get())
                .add(HnSItemRegistry.NAMELESS_ONE_HELMET.get())
                .add(HnSItemRegistry.CHLOROPHYTE_HELMET.get())
                .add(HnSItemRegistry.CHLOROPHYTE_HEADGEAR.get())
                .add(HnSItemRegistry.CHLOROPHYTE_MASK.get())
        ;

        tag(ItemTags.CHEST_ARMOR)
                .add(HnSItemRegistry.CALAMITAS_CHESTPLATE.get())
                .add(HnSItemRegistry.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItemRegistry.SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItemRegistry.HAZEL_CHESTPLATE.get())
                .add(HnSItemRegistry.HAZEL_HOLY_MOLLY_CHESTPLATE.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_CHESTPLATE.get())
                .add(HnSItemRegistry.HERTA_PUPPET_CHESTPLATE.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_CHESTPLATE.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_CHESTPLATE.get())
                .add(HnSItemRegistry.CREAKING_CHESTPLATE.get())
                .add(HnSItemRegistry.FLESH_MASS_CHESTPLATE.get())
                .add(HnSItemRegistry.FLESH_MASS_LEGGINGS.get())
                .add(HnSItemRegistry.THE_WITHER_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_THE_WITHER_CHESTPLATE.get())
                .add(HnSItemRegistry.ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItemRegistry.SERAPH_CHESTPLATE.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_CHESTPLATE.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_SECRET_CHESTPLATE.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_CHESTPLATE.get())
                .add(HnSItemRegistry.SHADOW_SCALE_CHESTPLATE.get())
                .add(HnSItemRegistry.INFESTATION_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_INFESTATION_CHESTPLATE.get())
                .add(HnSItemRegistry.PYRIUM_CHESTPLATE.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_CHESTPLATE.get())
                .add(HnSItemRegistry.TYROS_CHESTPLATE.get())
                .add(HnSItemRegistry.TYROS_SOUL_CHESTPLATE.get())
                .add(HnSItemRegistry.FRIEREN_CHESTPLATE.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_CHESTPLATE.get())
                .add(HnSItemRegistry.UTAU_CHESTPLATE.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_CHESTPLATE.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_CHESTPLATE.get())
                .add(HnSItemRegistry.NERU_CHESTPLATE.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_CHESTPLATE.get())
                .add(HnSItemRegistry.MINER_CHESTPLATE.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_CHESTPLATE.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.MAGEHUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ATLAS_CHESTPLATE.get())
                .add(HnSItemRegistry.MAVERICK_CHESTPLATE.get())
                .add(HnSItemRegistry.SLC_CAT_CHESTPLATE.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_CHESTPLATE.get())
                .add(HnSItemRegistry.IRON431_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_CHESTPLATE.get())
                .add(HnSItemRegistry.SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.ENDERMAN_CHESTPLATE.get())
                .add(HnSItemRegistry.PYROMANCER_BRUTE_CHESTPLATE.get())
                .add(HnSItemRegistry.BISHOP_OF_DECEIT_CHESTPLATE.get())
                .add(HnSItemRegistry.NECROMANCER_CHESTPLATE.get())
                .add(HnSItemRegistry.NAMELESS_ONE_CHESTPLATE.get())
                .add(HnSItemRegistry.CHLOROPHYTE_CHESTPLATE.get())
        ;

        tag(ItemTags.LEG_ARMOR)
                .add(HnSItemRegistry.CALAMITAS_LEGGINGS.get())
                .add(HnSItemRegistry.BLAZEBORNE_LEGGINGS.get())
                .add(HnSItemRegistry.SOUL_FLAME_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_LEGGINGS.get())
                .add(HnSItemRegistry.HAZEL_LEGGINGS.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_LEGGINGS.get())
                .add(HnSItemRegistry.HERTA_PUPPET_LEGGINGS.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_LEGGINGS.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_LEGGINGS.get())
                .add(HnSItemRegistry.CREAKING_LEGGINGS.get())
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
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_LEGGINGS.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_LEGGINGS.get())
                .add(HnSItemRegistry.SHADOW_SCALE_LEGGINGS.get())
                .add(HnSItemRegistry.INFESTATION_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_INFESTATION_LEGGINGS.get())
                .add(HnSItemRegistry.PYRIUM_LEGGINGS.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_LEGGINGS.get())
                .add(HnSItemRegistry.TYROS_LEGGINGS.get())
                .add(HnSItemRegistry.TYROS_SOUL_LEGGINGS.get())
                .add(HnSItemRegistry.FRIEREN_LEGGINGS.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_LEGGINGS.get())
                .add(HnSItemRegistry.UTAU_LEGGINGS.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_LEGGINGS.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_LEGGINGS.get())
                .add(HnSItemRegistry.NERU_LEGGINGS.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_LEGGINGS.get())
                .add(HnSItemRegistry.MINER_LEGGINGS.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_LEGGINGS.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.MAGEHUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ATLAS_LEGGINGS.get())
                .add(HnSItemRegistry.MAVERICK_LEGGINGS.get())
                .add(HnSItemRegistry.SLC_CAT_LEGGINGS.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_LEGGINGS.get())
                .add(HnSItemRegistry.IRON431_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_LEGGINGS.get())
                .add(HnSItemRegistry.SACRED_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.ENDERMAN_LEGGINGS.get())
                .add(HnSItemRegistry.NECROMANCER_LEGGINGS.get())
                .add(HnSItemRegistry.NAMELESS_ONE_LEGGINGS.get())
                .add(HnSItemRegistry.CHLOROPHYTE_LEGGINGS.get())
        ;

        tag(Tags.Items.ARMORS)
                .add(HnSItemRegistry.CALAMITAS_BOOTS.get())
                .add(HnSItemRegistry.BLAZEBORNE_BOOTS.get())
                .add(HnSItemRegistry.SOUL_FLAME_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_BOOTS.get())
                .add(HnSItemRegistry.HAZEL_BOOTS.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_BOOTS.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_BOOTS.get())
                .add(HnSItemRegistry.HERTA_PUPPET_BOOTS.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_BOOTS.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_BOOTS.get())
                .add(HnSItemRegistry.CREAKING_BOOTS.get())
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
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_BOOTS.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_BOOTS.get())
                .add(HnSItemRegistry.SHADOW_SCALE_BOOTS.get())
                .add(HnSItemRegistry.INFESTATION_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_INFESTATION_BOOTS.get())
                .add(HnSItemRegistry.PYRIUM_BOOTS.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_BOOTS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_BOOTS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_BOOTS.get())
                .add(HnSItemRegistry.TYROS_BOOTS.get())
                .add(HnSItemRegistry.TYROS_SOUL_BOOTS.get())
                .add(HnSItemRegistry.FRIEREN_BOOTS.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_BOOTS.get())
                .add(HnSItemRegistry.UTAU_BOOTS.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_BOOTS.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_BOOTS.get())
                .add(HnSItemRegistry.NERU_BOOTS.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_BOOTS.get())
                .add(HnSItemRegistry.MINER_BOOTS.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_BOOTS.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_BOOTS.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_BOOTS.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_BOOTS.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_BOOTS.get())
                .add(HnSItemRegistry.MAGEHUNTER_BOOTS.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_BOOTS.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_BOOTS.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_BOOTS.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItemRegistry.ATLAS_BOOTS.get())
                .add(HnSItemRegistry.MAVERICK_BOOTS.get())
                .add(HnSItemRegistry.SLC_CAT_BOOTS.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_BOOTS.get())
                .add(HnSItemRegistry.IRON431_BOOTS.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_BOOTS.get())
                .add(HnSItemRegistry.SACRED_ROBES_BOOTS.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_BOOTS.get())
                .add(HnSItemRegistry.LEMON_GOD_BOOTS.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_BOOTS.get())
                .add(HnSItemRegistry.ENDERMAN_BOOTS.get())
                .add(HnSItemRegistry.CHLOROPHYTE_BOOTS.get())
        ;

        tag(ItemTags.ARMOR_ENCHANTABLE)

               /*
                *** Fire
                 */

                //Calamitas Armor
                .add(HnSItemRegistry.CALAMITAS_HELMET.get())
                .add(HnSItemRegistry.CALAMITAS_CHESTPLATE.get())
                .add(HnSItemRegistry.CALAMITAS_LEGGINGS.get())
                .add(HnSItemRegistry.CALAMITAS_BOOTS.get())

                //Blazeborne Armor
                .add(HnSItemRegistry.BLAZEBORNE_HELMET.get())
                .add(HnSItemRegistry.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItemRegistry.BLAZEBORNE_LEGGINGS.get())
                .add(HnSItemRegistry.BLAZEBORNE_BOOTS.get())

                //Soul Flame Armor
                .add(HnSItemRegistry.SOUL_FLAME_HELMET.get())
                .add(HnSItemRegistry.SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItemRegistry.SOUL_FLAME_LEGGINGS.get())
                .add(HnSItemRegistry.SOUL_FLAME_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_BOOTS.get())

                //Hazel Armor
                .add(HnSItemRegistry.HAZEL_HELMET.get())
                .add(HnSItemRegistry.HAZEL_CHESTPLATE.get())
                .add(HnSItemRegistry.HAZEL_HOLY_MOLLY_CHESTPLATE.get())
                .add(HnSItemRegistry.HAZEL_LEGGINGS.get())
                .add(HnSItemRegistry.HAZEL_BOOTS.get())

                /*
                *** Ice
                 */

                //Cryogenic Ruler Armor
                .add(HnSItemRegistry.CRYOGENIC_RULER_HELMET.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_BOOTS.get())

                //Crystal Arachnid Armor
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_HELMET.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_CHESTPLATE.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_LEGGINGS.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_BOOTS.get())

                //Herta Puppet Armor
                .add(HnSItemRegistry.HERTA_PUPPET_HELMET.get())
                .add(HnSItemRegistry.HERTA_PUPPET_CHESTPLATE.get())
                .add(HnSItemRegistry.HERTA_PUPPET_LEGGINGS.get())
                .add(HnSItemRegistry.HERTA_PUPPET_BOOTS.get())

                /*
                *** Lightning
                 */

                //Cryogenic Ruler Armor
                .add(HnSItemRegistry.CHARGED_SCOURGE_HELMET.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_CHESTPLATE.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_LEGGINGS.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_BOOTS.get())

                //Thunder Prowler Armor
                .add(HnSItemRegistry.THUNDER_PROWLER_HELMET.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_CHESTPLATE.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_LEGGINGS.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_BOOTS.get())

                /*
                *** Nature
                 */

                //Creaking Sorcerer Armor
                .add(HnSItemRegistry.CREAKING_HELMET.get())
                .add(HnSItemRegistry.CREAKING_CHESTPLATE.get())
                .add(HnSItemRegistry.CREAKING_LEGGINGS.get())
                .add(HnSItemRegistry.CREAKING_BOOTS.get())

                // Chlorophyte Armor
                .add(HnSItemRegistry.CHLOROPHYTE_HELMET.get())
                .add(HnSItemRegistry.CHLOROPHYTE_MASK.get())
                .add(HnSItemRegistry.CHLOROPHYTE_HEADGEAR.get())
                .add(HnSItemRegistry.CHLOROPHYTE_CHESTPLATE.get())
                .add(HnSItemRegistry.CHLOROPHYTE_LEGGINGS.get())
                .add(HnSItemRegistry.CHLOROPHYTE_BOOTS.get())

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

                //Ender Dragon Armor
                .add(HnSItemRegistry.ENDER_DRAGON_HELMET.get())
                .add(HnSItemRegistry.ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItemRegistry.ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItemRegistry.ENDER_DRAGON_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_BOOTS.get())

                /*
                 *** Holy
                 */

                //Seraph Armor
                .add(HnSItemRegistry.SERAPH_HELMET.get())
                .add(HnSItemRegistry.SERAPH_CHESTPLATE.get())
                .add(HnSItemRegistry.SERAPH_LEGGINGS.get())
                .add(HnSItemRegistry.SERAPH_BOOTS.get())

                //Gabriel ULTRAKILL Armor
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_BOOTS.get())

                //Mothic Witch Armor
                .add(HnSItemRegistry.MOTHIC_WITCH_HELMET.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_CHESTPLATE.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_SECRET_CHESTPLATE.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_LEGGINGS.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_BOOTS.get())

                /*
                *** Evocation
                */

                //Supreme Witch Armor
                .add(HnSItemRegistry.SUPREME_WITCH_HELMET.get())
                .add(HnSItemRegistry.SUPREME_WITCH_CHESTPLATE.get())
                .add(HnSItemRegistry.SUPREME_WITCH_LEGGINGS.get())
                .add(HnSItemRegistry.SUPREME_WITCH_BOOTS.get())

                //Alchemist Supreme Armor
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_HELMET.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_LEGGINGS.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_BOOTS.get())

                /*
                 *** Radiance
                 */

                //Mycelium Guardian Armor
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_HELMET.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_CHESTPLATE.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_LEGGINGS.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_BOOTS.get())

                /*
                 *** Shadow
                 */

                //Shadow Scale Armor
                .add(HnSItemRegistry.SHADOW_SCALE_HELMET.get())
                .add(HnSItemRegistry.SHADOW_SCALE_CHESTPLATE.get())
                .add(HnSItemRegistry.SHADOW_SCALE_LEGGINGS.get())
                .add(HnSItemRegistry.SHADOW_SCALE_BOOTS.get())

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
                *** Pyrium
                 */

                //Pyrium Armor
                .add(HnSItemRegistry.PYRIUM_HELMET.get())
                .add(HnSItemRegistry.PYRIUM_CHESTPLATE.get())
                .add(HnSItemRegistry.PYRIUM_LEGGINGS.get())
                .add(HnSItemRegistry.PYRIUM_BOOTS.get())

                //Pyrium Battlemage Armor
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_BOOTS.get())

                //Legionnaire Armor
                .add(HnSItemRegistry.LEGIONNAIRE_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_BOOTS.get())

                //Legionnaire Ruler Armor
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_BOOTS.get())

                //Legionnaire Commander Armor
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_BOOTS.get())

                //Tyros Armor
                .add(HnSItemRegistry.TYROS_HELMET.get())
                .add(HnSItemRegistry.TYROS_CHESTPLATE.get())
                .add(HnSItemRegistry.TYROS_LEGGINGS.get())
                .add(HnSItemRegistry.TYROS_BOOTS.get())

                .add(HnSItemRegistry.TYROS_SOUL_HELMET.get())
                .add(HnSItemRegistry.TYROS_SOUL_CHESTPLATE.get())
                .add(HnSItemRegistry.TYROS_SOUL_LEGGINGS.get())
                .add(HnSItemRegistry.TYROS_SOUL_BOOTS.get())

                /*
                *** Cosmetic Battlemage
                 */

                //Frieren Armor
                .add(HnSItemRegistry.FRIEREN_HELMET.get())
                .add(HnSItemRegistry.FRIEREN_CHESTPLATE.get())
                .add(HnSItemRegistry.FRIEREN_LEGGINGS.get())
                .add(HnSItemRegistry.FRIEREN_BOOTS.get())

                //SynthV
                .add(HnSItemRegistry.SYNTHESIZER_V_HELMET.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_CHESTPLATE.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_LEGGINGS.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_BOOTS.get())

                //UTAU Armor
                .add(HnSItemRegistry.UTAU_HELMET.get())
                .add(HnSItemRegistry.UTAU_CHESTPLATE.get())
                .add(HnSItemRegistry.UTAU_LEGGINGS.get())
                .add(HnSItemRegistry.UTAU_BOOTS.get())

                //PROJECT SEKAI Armor
                .add(HnSItemRegistry.PROJECT_SEKAI_HELMET.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_CHESTPLATE.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_LEGGINGS.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_BOOTS.get())

                //Rotten Girl Armor
                .add(HnSItemRegistry.ROTTEN_GIRL_HELMET.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_CHESTPLATE.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_LEGGINGS.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_BOOTS.get())

                //Neru Armor
                .add(HnSItemRegistry.NERU_HELMET.get())
                .add(HnSItemRegistry.NERU_CHESTPLATE.get())
                .add(HnSItemRegistry.NERU_LEGGINGS.get())
                .add(HnSItemRegistry.NERU_BOOTS.get())

                //Giorno Giovanna Armor
                .add(HnSItemRegistry.GIORNO_GIOVANNA_HELMET.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_CHESTPLATE.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_LEGGINGS.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_BOOTS.get())

                /*
                *** Mining
                 */

                //Miner Armor
                .add(HnSItemRegistry.MINER_HELMET.get())
                .add(HnSItemRegistry.MINER_CHESTPLATE.get())
                .add(HnSItemRegistry.MINER_LEGGINGS.get())
                .add(HnSItemRegistry.MINER_BOOTS.get())

                //Spectral Spelunker Armor
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_HELMET.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_CHESTPLATE.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_LEGGINGS.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_BOOTS.get())

                /*
                *** Archer
                 */

                //Bounty Hunter Armor
                .add(HnSItemRegistry.BOUNTY_HUNTER_HELMET.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_BOOTS.get())

                //Frostbite Hunter Armor
                .add(HnSItemRegistry.FROSTBITE_HUNTER_HELMET.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_BOOTS.get())

                /*
                *** Melee
                 */

                //Frostbite Knight Armor
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_BOOTS.get())

                //Dreadsteel Knight Armor
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_BOOTS.get())

                /*
                *** Misc
                 */


                //Magehunter Armor
                .add(HnSItemRegistry.MAGEHUNTER_HELMET.get())
                .add(HnSItemRegistry.MAGEHUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.MAGEHUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.MAGEHUNTER_BOOTS.get())

                //Mithril Battlemage Armor
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_BOOTS.get())

                //Enderman Shadowwalker Armor
                .add(HnSItemRegistry.ENDERMAN_MASKED.get())
                .add(HnSItemRegistry.ENDERMAN_BLINDFOLD.get())
                .add(HnSItemRegistry.ENDERMAN_HOOD.get())
                .add(HnSItemRegistry.ENDERMAN_CHESTPLATE.get())
                .add(HnSItemRegistry.ENDERMAN_LEGGINGS.get())
                .add(HnSItemRegistry.ENDERMAN_BOOTS.get())

                //Pyromancer Brute Armor
                .add(HnSItemRegistry.PYROMANCER_BRUTE_HELMET.get())
                .add(HnSItemRegistry.PYROMANCER_BRUTE_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItemRegistry.BISHOP_OF_DECEIT_HELMET.get())
                .add(HnSItemRegistry.BISHOP_OF_DECEIT_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItemRegistry.NECROMANCER_HELMET.get())
                .add(HnSItemRegistry.NECROMANCER_CHESTPLATE.get())

                //Bishop of Deceit Armor
                .add(HnSItemRegistry.NAMELESS_ONE_HELMET.get())
                .add(HnSItemRegistry.NAMELESS_ONE_CHESTPLATE.get())

                /*
                *** Tributes
                 */


                //Dark Ritual Templar Armor
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_BOOTS.get())


                //Fireblossom Battlemage Armor
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                //Arbitrium Robes Armor
                .add(HnSItemRegistry.ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_BOOTS.get())

                //Atlas Armor
                .add(HnSItemRegistry.ATLAS_HELMET.get())
                .add(HnSItemRegistry.ATLAS_CHESTPLATE.get())
                .add(HnSItemRegistry.ATLAS_LEGGINGS.get())
                .add(HnSItemRegistry.ATLAS_BOOTS.get())

                //Maverick Armor
                .add(HnSItemRegistry.MAVERICK_HELMET.get())
                .add(HnSItemRegistry.MAVERICK_CHESTPLATE.get())
                .add(HnSItemRegistry.MAVERICK_LEGGINGS.get())
                .add(HnSItemRegistry.MAVERICK_BOOTS.get())

                //SLC!CAT Armor
                .add(HnSItemRegistry.SLC_CAT_HELMET.get())
                .add(HnSItemRegistry.SLC_CAT_CHESTPLATE.get())
                .add(HnSItemRegistry.SLC_CAT_LEGGINGS.get())
                .add(HnSItemRegistry.SLC_CAT_BOOTS.get())

                //Abberant Predator Armor
                .add(HnSItemRegistry.ABBERANT_PREDATOR_HELMET.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_CHESTPLATE.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_LEGGINGS.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_BOOTS.get())

                //Iron431 Armor
                .add(HnSItemRegistry.IRON431_HELMET.get())
                .add(HnSItemRegistry.IRON431_CHESTPLATE.get())
                .add(HnSItemRegistry.IRON431_LEGGINGS.get())
                .add(HnSItemRegistry.IRON431_BOOTS.get())

                .add(HnSItemRegistry.ASCENDED_IRON431_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_BOOTS.get())

                //Sacred Robes Armor
                .add(HnSItemRegistry.SACRED_ROBES_HELMET.get())
                .add(HnSItemRegistry.SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.SACRED_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.SACRED_ROBES_BOOTS.get())

                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_BOOTS.get())

                //Lemon God Armor
                .add(HnSItemRegistry.LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.LEMON_GOD_BOOTS.get())

                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_BOOTS.get())

                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_BOOTS.get())

        ;

        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(HnSItemRegistry.CALAMITAS_HELMET.get())
                .add(HnSItemRegistry.BLAZEBORNE_HELMET.get())
                .add(HnSItemRegistry.SOUL_FLAME_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_HELMET.get())
                .add(HnSItemRegistry.HAZEL_HELMET.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_HELMET.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_HELMET.get())
                .add(HnSItemRegistry.HERTA_PUPPET_HELMET.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_HELMET.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_HELMET.get())
                .add(HnSItemRegistry.CREAKING_HELMET.get())
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
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_HELMET.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_HELMET.get())
                .add(HnSItemRegistry.SHADOW_SCALE_HELMET.get())
                .add(HnSItemRegistry.INFESTATION_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_INFESTATION_HELMET.get())
                .add(HnSItemRegistry.PYRIUM_HELMET.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_HELMET.get())
                .add(HnSItemRegistry.TYROS_HELMET.get())
                .add(HnSItemRegistry.TYROS_SOUL_HELMET.get())
                .add(HnSItemRegistry.FRIEREN_HELMET.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_HELMET.get())
                .add(HnSItemRegistry.UTAU_HELMET.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_HELMET.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_HELMET.get())
                .add(HnSItemRegistry.NERU_HELMET.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_HELMET.get())
                .add(HnSItemRegistry.MINER_HELMET.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_HELMET.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_HELMET.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_HELMET.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.MAGEHUNTER_HELMET.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_HELMET.get())
                .add(HnSItemRegistry.ATLAS_HELMET.get())
                .add(HnSItemRegistry.MAVERICK_HELMET.get())
                .add(HnSItemRegistry.SLC_CAT_HELMET.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_HELMET.get())
                .add(HnSItemRegistry.IRON431_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_HELMET.get())
                .add(HnSItemRegistry.SACRED_ROBES_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_HELMET.get())
                .add(HnSItemRegistry.LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_HELMET.get())
                .add(HnSItemRegistry.CHLOROPHYTE_HELMET.get())
                .add(HnSItemRegistry.CHLOROPHYTE_MASK.get())
                .add(HnSItemRegistry.CHLOROPHYTE_HEADGEAR.get())
                .add(HnSItemRegistry.PYROMANCER_BRUTE_HELMET.get())
                .add(HnSItemRegistry.ENDERMAN_BLINDFOLD.get())
                .add(HnSItemRegistry.ENDERMAN_MASKED.get())
                .add(HnSItemRegistry.ENDERMAN_HOOD.get())
                .add(HnSItemRegistry.BISHOP_OF_DECEIT_HELMET.get())
                .add(HnSItemRegistry.NECROMANCER_HELMET.get())
                .add(HnSItemRegistry.NAMELESS_ONE_HELMET.get())
        ;

        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(HnSItemRegistry.CALAMITAS_CHESTPLATE.get())
                .add(HnSItemRegistry.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItemRegistry.SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItemRegistry.HAZEL_CHESTPLATE.get())
                .add(HnSItemRegistry.HAZEL_HOLY_MOLLY_CHESTPLATE.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_CHESTPLATE.get())
                .add(HnSItemRegistry.HERTA_PUPPET_CHESTPLATE.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_CHESTPLATE.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_CHESTPLATE.get())
                .add(HnSItemRegistry.CREAKING_CHESTPLATE.get())
                .add(HnSItemRegistry.FLESH_MASS_CHESTPLATE.get())
                .add(HnSItemRegistry.FLESH_MASS_LEGGINGS.get())
                .add(HnSItemRegistry.THE_WITHER_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_THE_WITHER_CHESTPLATE.get())
                .add(HnSItemRegistry.ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItemRegistry.SERAPH_CHESTPLATE.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_CHESTPLATE.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_SECRET_CHESTPLATE.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_CHESTPLATE.get())
                .add(HnSItemRegistry.SHADOW_SCALE_CHESTPLATE.get())
                .add(HnSItemRegistry.INFESTATION_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_INFESTATION_CHESTPLATE.get())
                .add(HnSItemRegistry.PYRIUM_CHESTPLATE.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_CHESTPLATE.get())
                .add(HnSItemRegistry.TYROS_CHESTPLATE.get())
                .add(HnSItemRegistry.TYROS_SOUL_CHESTPLATE.get())
                .add(HnSItemRegistry.FRIEREN_CHESTPLATE.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_CHESTPLATE.get())
                .add(HnSItemRegistry.UTAU_CHESTPLATE.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_CHESTPLATE.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_CHESTPLATE.get())
                .add(HnSItemRegistry.NERU_CHESTPLATE.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_CHESTPLATE.get())
                .add(HnSItemRegistry.MINER_CHESTPLATE.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_CHESTPLATE.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.MAGEHUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ATLAS_CHESTPLATE.get())
                .add(HnSItemRegistry.MAVERICK_CHESTPLATE.get())
                .add(HnSItemRegistry.SLC_CAT_CHESTPLATE.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_CHESTPLATE.get())
                .add(HnSItemRegistry.IRON431_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_CHESTPLATE.get())
                .add(HnSItemRegistry.SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_CHESTPLATE.get())
                .add(HnSItemRegistry.LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_CHESTPLATE.get())
                .add(HnSItemRegistry.CHLOROPHYTE_CHESTPLATE.get())
                .add(HnSItemRegistry.PYROMANCER_BRUTE_CHESTPLATE.get())
                .add(HnSItemRegistry.ENDERMAN_CHESTPLATE.get())
                .add(HnSItemRegistry.BISHOP_OF_DECEIT_CHESTPLATE.get())
                .add(HnSItemRegistry.NECROMANCER_CHESTPLATE.get())
                .add(HnSItemRegistry.NAMELESS_ONE_CHESTPLATE.get())
        ;

        tag(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(HnSItemRegistry.CALAMITAS_LEGGINGS.get())
                .add(HnSItemRegistry.BLAZEBORNE_LEGGINGS.get())
                .add(HnSItemRegistry.SOUL_FLAME_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_LEGGINGS.get())
                .add(HnSItemRegistry.HAZEL_LEGGINGS.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_LEGGINGS.get())
                .add(HnSItemRegistry.HERTA_PUPPET_LEGGINGS.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_LEGGINGS.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_LEGGINGS.get())
                .add(HnSItemRegistry.CREAKING_LEGGINGS.get())
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
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_LEGGINGS.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_LEGGINGS.get())
                .add(HnSItemRegistry.SHADOW_SCALE_LEGGINGS.get())
                .add(HnSItemRegistry.INFESTATION_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_INFESTATION_LEGGINGS.get())
                .add(HnSItemRegistry.PYRIUM_LEGGINGS.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_LEGGINGS.get())
                .add(HnSItemRegistry.TYROS_LEGGINGS.get())
                .add(HnSItemRegistry.TYROS_SOUL_LEGGINGS.get())
                .add(HnSItemRegistry.FRIEREN_LEGGINGS.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_LEGGINGS.get())
                .add(HnSItemRegistry.UTAU_LEGGINGS.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_LEGGINGS.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_LEGGINGS.get())
                .add(HnSItemRegistry.NERU_LEGGINGS.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_LEGGINGS.get())
                .add(HnSItemRegistry.MINER_LEGGINGS.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_LEGGINGS.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.MAGEHUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ATLAS_LEGGINGS.get())
                .add(HnSItemRegistry.MAVERICK_LEGGINGS.get())
                .add(HnSItemRegistry.SLC_CAT_LEGGINGS.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_LEGGINGS.get())
                .add(HnSItemRegistry.IRON431_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_LEGGINGS.get())
                .add(HnSItemRegistry.SACRED_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_LEGGINGS.get())
                .add(HnSItemRegistry.LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_LEGGINGS.get())
                .add(HnSItemRegistry.CHLOROPHYTE_LEGGINGS.get())
                .add(HnSItemRegistry.NECROMANCER_LEGGINGS.get())
                .add(HnSItemRegistry.NAMELESS_ONE_LEGGINGS.get())
        ;

        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(HnSItemRegistry.CALAMITAS_BOOTS.get())
                .add(HnSItemRegistry.BLAZEBORNE_BOOTS.get())
                .add(HnSItemRegistry.SOUL_FLAME_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_BOOTS.get())
                .add(HnSItemRegistry.HAZEL_BOOTS.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_BOOTS.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_BOOTS.get())
                .add(HnSItemRegistry.HERTA_PUPPET_BOOTS.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_BOOTS.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_BOOTS.get())
                .add(HnSItemRegistry.CREAKING_BOOTS.get())
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
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_BOOTS.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_BOOTS.get())
                .add(HnSItemRegistry.SHADOW_SCALE_BOOTS.get())
                .add(HnSItemRegistry.INFESTATION_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_INFESTATION_BOOTS.get())
                .add(HnSItemRegistry.PYRIUM_BOOTS.get())
                .add(HnSItemRegistry.PYRIUM_BATTLEMAGE_BOOTS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_BOOTS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_BOOTS.get())
                .add(HnSItemRegistry.TYROS_BOOTS.get())
                .add(HnSItemRegistry.TYROS_SOUL_BOOTS.get())
                .add(HnSItemRegistry.FRIEREN_BOOTS.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_BOOTS.get())
                .add(HnSItemRegistry.UTAU_BOOTS.get())
                .add(HnSItemRegistry.PROJECT_SEKAI_BOOTS.get())
                .add(HnSItemRegistry.ROTTEN_GIRL_BOOTS.get())
                .add(HnSItemRegistry.NERU_BOOTS.get())
                .add(HnSItemRegistry.GIORNO_GIOVANNA_BOOTS.get())
                .add(HnSItemRegistry.MINER_BOOTS.get())
                .add(HnSItemRegistry.SPECTRAL_SPELUNKER_BOOTS.get())
                .add(HnSItemRegistry.BOUNTY_HUNTER_BOOTS.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_BOOTS.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_BOOTS.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_BOOTS.get())
                .add(HnSItemRegistry.MAGEHUNTER_BOOTS.get())
                .add(HnSItemRegistry.MITHRIL_BATTLEMAGE_BOOTS.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_BOOTS.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_BOOTS.get())
                .add(HnSItemRegistry.ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_BOOTS.get())
                .add(HnSItemRegistry.ATLAS_BOOTS.get())
                .add(HnSItemRegistry.MAVERICK_BOOTS.get())
                .add(HnSItemRegistry.SLC_CAT_BOOTS.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_LEGGINGS.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_BOOTS.get())
                .add(HnSItemRegistry.IRON431_BOOTS.get())
                .add(HnSItemRegistry.ASCENDED_IRON431_BOOTS.get())
                .add(HnSItemRegistry.SACRED_ROBES_BOOTS.get())
                .add(HnSItemRegistry.ASCENDED_SACRED_ROBES_BOOTS.get())
                .add(HnSItemRegistry.LEMON_GOD_BOOTS.get())
                .add(HnSItemRegistry.ASCENDED_LEMON_GOD_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_LEMON_GOD_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_ASCENDED_LEMON_GOD_BOOTS.get())
                .add(HnSItemRegistry.CHLOROPHYTE_BOOTS.get())
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
                .add(HnSItemRegistry.SOUL_FLAME_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_HELMET.get())
                .add(HnSItemRegistry.HAZEL_HELMET.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_HELMET.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_HELMET.get())
                .add(HnSItemRegistry.HERTA_PUPPET_HELMET.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_HELMET.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_HELMET.get())
                .add(HnSItemRegistry.CREAKING_HELMET.get())
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
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_HELMET.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_HELMET.get())
                .add(HnSItemRegistry.SHADOW_SCALE_HELMET.get())
                .add(HnSItemRegistry.INFESTATION_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_INFESTATION_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_HELMET.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_HELMET.get())
                .add(HnSItemRegistry.TYROS_HELMET.get())
                .add(HnSItemRegistry.TYROS_SOUL_HELMET.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_HELMET.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_HELMET.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_HELMET.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.ATLAS_HELMET.get())
                .add(HnSItemRegistry.MAVERICK_HELMET.get())
                .add(HnSItemRegistry.SLC_CAT_HELMET.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_HELMET.get())
                .add(HnSItemRegistry.CHLOROPHYTE_HELMET.get())
                .add(HnSItemRegistry.CHLOROPHYTE_HEADGEAR.get())
                .add(HnSItemRegistry.CHLOROPHYTE_MASK.get())
        ;

        tag(HnSTags.PURE_CHESTPLATE)
                .add(HnSItemRegistry.CALAMITAS_CHESTPLATE.get())
                .add(HnSItemRegistry.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItemRegistry.SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_CHESTPLATE.get())
                .add(HnSItemRegistry.HAZEL_CHESTPLATE.get())
                .add(HnSItemRegistry.HAZEL_HOLY_MOLLY_CHESTPLATE.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_CHESTPLATE.get())
                .add(HnSItemRegistry.HERTA_PUPPET_CHESTPLATE.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_CHESTPLATE.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_CHESTPLATE.get())
                .add(HnSItemRegistry.CREAKING_CHESTPLATE.get())
                .add(HnSItemRegistry.FLESH_MASS_CHESTPLATE.get())
                .add(HnSItemRegistry.FLESH_MASS_LEGGINGS.get())
                .add(HnSItemRegistry.THE_WITHER_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_THE_WITHER_CHESTPLATE.get())
                .add(HnSItemRegistry.ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItemRegistry.SERAPH_CHESTPLATE.get())
                .add(HnSItemRegistry.GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_CHESTPLATE.get())
                .add(HnSItemRegistry.MOTHIC_WITCH_SECRET_CHESTPLATE.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_CHESTPLATE.get())
                .add(HnSItemRegistry.SHADOW_SCALE_CHESTPLATE.get())
                .add(HnSItemRegistry.INFESTATION_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_INFESTATION_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_CHESTPLATE.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_CHESTPLATE.get())
                .add(HnSItemRegistry.TYROS_CHESTPLATE.get())
                .add(HnSItemRegistry.TYROS_SOUL_CHESTPLATE.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_CHESTPLATE.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_CHESTPLATE.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_CHESTPLATE.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.MAVERICK_CHESTPLATE.get())
                .add(HnSItemRegistry.SLC_CAT_CHESTPLATE.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_CHESTPLATE.get())
                .add(HnSItemRegistry.CHLOROPHYTE_CHESTPLATE.get())
        ;

        tag(HnSTags.PURE_LEGGINGS)
                .add(HnSItemRegistry.CALAMITAS_LEGGINGS.get())
                .add(HnSItemRegistry.BLAZEBORNE_LEGGINGS.get())
                .add(HnSItemRegistry.SOUL_FLAME_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_LEGGINGS.get())
                .add(HnSItemRegistry.HAZEL_LEGGINGS.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_LEGGINGS.get())
                .add(HnSItemRegistry.HERTA_PUPPET_LEGGINGS.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_LEGGINGS.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_LEGGINGS.get())
                .add(HnSItemRegistry.CREAKING_LEGGINGS.get())
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
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_LEGGINGS.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_LEGGINGS.get())
                .add(HnSItemRegistry.SHADOW_SCALE_LEGGINGS.get())
                .add(HnSItemRegistry.INFESTATION_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_INFESTATION_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_LEGGINGS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_LEGGINGS.get())
                .add(HnSItemRegistry.TYROS_LEGGINGS.get())
                .add(HnSItemRegistry.TYROS_SOUL_LEGGINGS.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_LEGGINGS.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_LEGGINGS.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_LEGGINGS.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.MAVERICK_LEGGINGS.get())
                .add(HnSItemRegistry.SLC_CAT_LEGGINGS.get())
                .add(HnSItemRegistry.ABBERANT_PREDATOR_LEGGINGS.get())
                .add(HnSItemRegistry.CHLOROPHYTE_LEGGINGS.get())
        ;

        tag(HnSTags.PURE_BOOTS)
                .add(HnSItemRegistry.CALAMITAS_BOOTS.get())
                .add(HnSItemRegistry.BLAZEBORNE_BOOTS.get())
                .add(HnSItemRegistry.SOUL_FLAME_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_SOUL_FLAME_BOOTS.get())
                .add(HnSItemRegistry.HAZEL_BOOTS.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_BOOTS.get())
                .add(HnSItemRegistry.CRYSTAL_ARACHNID_BOOTS.get())
                .add(HnSItemRegistry.HERTA_PUPPET_BOOTS.get())
                .add(HnSItemRegistry.CHARGED_SCOURGE_BOOTS.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_BOOTS.get())
                .add(HnSItemRegistry.CREAKING_BOOTS.get())
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
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_BOOTS.get())
                .add(HnSItemRegistry.MYCELIUM_GUARDIAN_BOOTS.get())
                .add(HnSItemRegistry.SHADOW_SCALE_BOOTS.get())
                .add(HnSItemRegistry.INFESTATION_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_INFESTATION_BOOTS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_RULER_BOOTS.get())
                .add(HnSItemRegistry.LEGIONNAIRE_COMMANDER_BOOTS.get())
                .add(HnSItemRegistry.TYROS_BOOTS.get())
                .add(HnSItemRegistry.TYROS_SOUL_BOOTS.get())
                .add(HnSItemRegistry.SYNTHESIZER_V_BOOTS.get())
                .add(HnSItemRegistry.FROSTBITE_HUNTER_BOOTS.get())
                .add(HnSItemRegistry.FROSTBITE_KNIGHT_BOOTS.get())
                .add(HnSItemRegistry.DREADSTEEL_KNIGHT_BOOTS.get())
                .add(HnSItemRegistry.DARK_RITUAL_TEMPLAR_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_DARK_RITUAL_TEMPLAR_BOOTS.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())
                .add(HnSItemRegistry.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_BOOTS.get())
                .add(HnSItemRegistry.MAVERICK_BOOTS.get())
                .add(HnSItemRegistry.SLC_CAT_BOOTS.get())
                .add(HnSItemRegistry.CHLOROPHYTE_BOOTS.get())
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

                //Nature
                .add(HnSItemRegistry.BOUNTIFUL_HARVEST.get())
                .add(HnSItemRegistry.THORN_CHAKRAM.get())

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

        tag(ModTags.CAN_BE_IMBUED)

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


                /*
                *** Tools
                 */

                .add(HnSItemRegistry.SPECTRAL_PICKAXE.get())
                .add(HnSItemRegistry.PICKAXE_AXE.get())
                .add(HnSItemRegistry.PICKAXE_AXE_DIVINE_GOLD.get())

                /*
                ***
                */

                .add(HnSItemRegistry.WISEWOOD_CANE.get())
                .add(HnSItemRegistry.FRIEREN_STAFF.get())
                .add(HnSItemRegistry.ROD_OF_DISCORD.get())


        ;

        tag(ModTags.CAN_BE_UPGRADED)

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


                /*
                 *** Tools
                 */

                .add(HnSItemRegistry.SPECTRAL_PICKAXE.get())
                .add(HnSItemRegistry.PICKAXE_AXE.get())
                .add(HnSItemRegistry.PICKAXE_AXE_DIVINE_GOLD.get())

                /*
                 ***
                 */

                .add(HnSItemRegistry.WISEWOOD_CANE.get())
                .add(HnSItemRegistry.FRIEREN_STAFF.get())
                .add(HnSItemRegistry.ROD_OF_DISCORD.get())


        ;

        tag(ModTags.INSCRIBED_RUNES)
                .add(HnSItemRegistry.MELEE_RUNE.get())
                .add(HnSItemRegistry.ARCHERY_RUNE.get())
                .add(HnSItemRegistry.HEALTH_RUNE.get())
                .add(HnSItemRegistry.ELDRITCH_RUNE.get())
                .add(HnSItemRegistry.SHADOW_RUNE.get())
                .add(HnSItemRegistry.RADIANCE_RUNE.get())
        ;

    }
}