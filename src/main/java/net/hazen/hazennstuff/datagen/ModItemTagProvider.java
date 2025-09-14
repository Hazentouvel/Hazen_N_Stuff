package net.hazen.hazennstuff.datagen;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.registries.HnSItems;
import net.hazen.hazennstuff.registries.HnSTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, HazenNStuff.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        //Ores and Ingots
        tag(Tags.Items.INGOTS)
                .add(HnSItems.ZENALITE_INGOT.get())
        ;

        tag(Tags.Items.NUGGETS)
                .add(HnSItems.PYRIUM_NUGGET.get())
        ;

        tag(Tags.Items.ORES)

                .add(HnSItems.RAW_ZENALITE.get())

        ;

        tag(Tags.Items.RAW_MATERIALS)

                .add(HnSItems.RAW_ZENALITE.get())

        ;

        tag(Tags.Items.GEMS)

        ;

        tag(Tags.Items.GEMS_QUARTZ)

        ;

        tag(HnSTags.ZENALITE)

                .add(HnSItems.RAW_ZENALITE.get())
                .add(HnSItems.STARKISSED_ZENALITE.get())

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

                /*
                *** Weapons
                */

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

                /*
                *** Weapons
                 */

                //Fire
                .add(HnSItems.FIREBLOSSOM_RAPIER.get())
                .add(HnSItems.DRACONIC_SPLITTER.get())
                .add(HnSItems.FIREBRAND.get())

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

                /*
                *** Tools
                */

                .add(HnSItems.SPECTRAL_PICKAXE.get())
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
        ;

        /*
        *** Tools and Weapons Tags
         */

        tag(ItemTags.AXES)
                .add(HnSItems.BEONGAE.get())
                .add(HnSItems.SKYSCORCHER.get())
                .add(HnSItems.ANCIENT_WARRIORS_AXE.get())
                .add(HnSItems.FIREBRAND.get())
                .add(HnSItems.LEGIONNAIRE_WARLOCK_AXE.get())
        ;

        tag(ItemTags.SWORDS)
                //Fire
                .add(HnSItems.FIREBLOSSOM_RAPIER.get())
                .add(HnSItems.DRACONIC_SPLITTER.get())
                .add(HnSItems.FIREBRAND.get())

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
        ;

        tag(ItemTags.PICKAXES)
                .add(HnSItems.SPECTRAL_PICKAXE.get())
        ;

        tag(Tags.Items.TOOLS_MACE)
                .add(HnSItems.SKYSCORCHER.get())
        ;

        tag(Tags.Items.TOOLS_SPEAR)
                .add(HnSItems.ICE_PIKE.get())
        ;

        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                //Fire
                .add(HnSItems.FIREBLOSSOM_RAPIER.get())
                .add(HnSItems.DRACONIC_SPLITTER.get())
                .add(HnSItems.FIREBRAND.get())

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

    }
}