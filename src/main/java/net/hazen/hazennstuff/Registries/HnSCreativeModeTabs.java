package net.hazen.hazennstuff.Registries;

import net.hazen.hazennstuff.Block.HnSBlocks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class HnSCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HazenNStuff.MOD_ID);

    public static final Supplier<CreativeModeTab> HAZEN_N_STUFF_MATERIALS = CREATIVE_MODE_TAB.register("hazennstuff_materials",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(HnSItems.DIVINE_MOLD.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "hazennstuff_blocks"))
                    .title(Component.translatable("creativetab.hazennstuff.hazennstuff_materials"))
                    .displayItems((itemDisplayParameters, output) -> {

                        //Raw Materials
                        output.accept(HnSItems.RAW_ZENALITE);
                        output.accept(HnSItems.STARKISSED_ZENALITE);
                        output.accept(HnSItems.DREADSTONE);
                        output.accept(HnSItems.CRUDE_METAL);
                        output.accept(HnSItems.CHLOROPHYTE_CHUNK);
                        output.accept(HnSItems.SHADESTONE);

                        //Ingots/Crystals/Gems
                        output.accept(HnSItems.ROSE_QUARTZ);
                        output.accept(HnSItems.ROSE_GOLD_INGOT);
                        output.accept(HnSItems.ZENALITE_INGOT);
                        output.accept(HnSItems.DREADSTEEL_INGOT);
                        output.accept(HnSItems.STEEL_INGOT);
                        output.accept(HnSItems.SOLAR_CORE);
                        output.accept(HnSItems.SILVER_SCRAPS);
                        output.accept(HnSItems.CHLOROPHYTE_INGOT);
                        output.accept(HnSItems.HALLOWED_INGOT);
                        output.accept(HnSItems.DEMONITE_INGOT);

                        //Nuggets
                        output.accept(HnSItems.PYRIUM_NUGGET);
                        output.accept(HnSItems.STEEL_NUGGET);

                        //Templates/Molds
                        output.accept(HnSItems.DIVINE_MOLD);
                        output.accept(HnSItems.FLAMING_TEMPLATE);

                        //Fragments
                        output.accept(HnSItems.RUNESTONE_FRAGMENTS);
                        output.accept(HnSItems.PERMAFROST_FRAGMENT);
                        output.accept(HnSItems.EXCALIBUR_FRAGMENT);

                        //Bones
                        output.accept(HnSItems.OVERGROWN_BONE);
                        output.accept(HnSItems.CHARRED_BONES);

                        //Focus Materials
                        output.accept(HnSItems.GLOWING_MUSHROOM);
                        output.accept(HnSItems.SHADOW_SCALE);

                        //Misc
                        output.accept(HnSBlocks.FIREBLOSSOM);
                        output.accept(HnSItems.DEUS_ESSENCE);
                        output.accept(HnSItems.CLOTH_OF_THE_FLAMEBEARER);
                        output.accept(HnSItems.LEMON);
                        output.accept(HnSItems.DIVINE_LEMON);
                        output.accept(HnSItems.STORM_WEAVE);
                        output.accept(HnSItems.SPIDER_FANG);
                        output.accept(HnSItems.PRISMATIC_SHARD);
                        output.accept(HnSItems.VOLT_CORE);

                        //Upgrade Orbs
                        output.accept(HnSItems.RADIANCE_UPGRADE_ORB.get());
                        output.accept(HnSItems.SHADOW_UPGRADE_ORB.get());
                        output.accept(HnSItems.ARCHERY_UPGRADE_ORB.get());
                        output.accept(HnSItems.MELEE_UPGRADE_ORB.get());
                        output.accept(HnSItems.HEALTH_UPGRADE_ORB.get());

                        //Runes
                        output.accept(HnSItems.MELEE_RUNE.get());
                        output.accept(HnSItems.ARCHERY_RUNE.get());
                        output.accept(HnSItems.HEALTH_RUNE.get());
                        output.accept(HnSItems.SHADOW_RUNE.get());
                        output.accept(HnSItems.RADIANCE_RUNE.get());
                        output.accept(HnSItems.ELDRITCH_RUNE.get());



                    }).build());

    public static final Supplier<CreativeModeTab> HAZEN_N_STUFF_BLOCKS = CREATIVE_MODE_TAB.register("hazennstuff_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(HnSBlocks.WISEWOOD_PLANKS.get()))
                    .title(Component.translatable("creativetab.hazennstuff.hazennstuff_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {

                        //Compact Blocks
                        output.accept(HnSBlocks.ZENALITE_BLOCK);
                        output.accept(HnSBlocks.PYRIUM_BLOCK);
                        output.accept(HnSBlocks.MITHRIL_BLOCK);
                        output.accept(HnSBlocks.ARCANE_STEEL_BLOCK);


                        /*
                        *** Sets
                         */

                        // Zenalite Brick
                        output.accept(HnSBlocks.ZENALITE_BRICKS);
                        output.accept(HnSBlocks.ZENALITE_BRICK_SLAB);
                        output.accept(HnSBlocks.ZENALITE_BRICK_STAIRS);
                        output.accept(HnSBlocks.ZENALITE_BRICK_WALL);

                        // Mossy Mud Bricks
                        output.accept(HnSBlocks.MOSSY_MUD_BRICKS);
                        output.accept(HnSBlocks.MOSSY_MUD_BRICK_STAIRS);
                        output.accept(HnSBlocks.MOSSY_MUD_BRICK_SLAB);
                        output.accept(HnSBlocks.MOSSY_MUD_BRICK_WALL);

                        //Wisewood Set
                        output.accept(HnSBlocks.WISEWOOD_PLANKS);
                        output.accept(HnSBlocks.WISEWOOD_DOOR);
                        output.accept(HnSBlocks.WISEWOOD_TRAPDOOR);
                        output.accept(HnSBlocks.WISEWOOD_SLAB);
                        output.accept(HnSBlocks.WISEWOOD_FENCE);
                        output.accept(HnSBlocks.WISEWOOD_FENCE_GATE);
                        output.accept(HnSBlocks.WISEWOOD_STAIRS);
                        output.accept(HnSBlocks.WISEWOOD_LEAVES);
                        output.accept(HnSBlocks.WISEWOOD_LOG);
                        output.accept(HnSBlocks.WISEWOOD_WOOD);
                        output.accept(HnSBlocks.STRIPPED_WISEWOOD_LOG);
                        output.accept(HnSBlocks.STRIPPED_WISEWOOD_WOOD);
                        output.accept(HnSBlocks.WISEWOOD_BUTTON);
                        output.accept(HnSBlocks.WISEWOOD_PRESSURE_PLATE);

                        //Wisewood Set
                        output.accept(HnSBlocks.FROSTBITE_BIRCH_PLANKS);
                        output.accept(HnSBlocks.FROSTBITE_BIRCH_NAILED_PLANKS);
                        output.accept(HnSBlocks.FROSTBITE_BIRCH_STAIRS);
                        output.accept(HnSBlocks.FROSTBITE_BIRCH_SLAB);
                        output.accept(HnSBlocks.FROSTBITE_BIRCH_LOG);
                        output.accept(HnSBlocks.FROSTBITE_BIRCH_WOOD);
                        output.accept(HnSBlocks.STRIPPED_FROSTBITE_BIRCH_LOG);
                        output.accept(HnSBlocks.STRIPPED_FROSTBITE_BIRCH_WOOD);
                        output.accept(HnSBlocks.FROSTBITE_BIRCH_FENCE_GATE);
                        output.accept(HnSBlocks.FROSTBITE_BIRCH_FENCE);
                        output.accept(HnSBlocks.FROSTBITE_BIRCH_BUTTON);
                        output.accept(HnSBlocks.FROSTBITE_BIRCH_PRESSURE_PLATE);


                        /*
                        *** Ores
                         */

                        // Zenalite
                        output.accept(HnSBlocks.ZENALITE_DEEPSLATE_ORE);
                        output.accept(HnSBlocks.ZENALITE_STONE_ORE);
                        output.accept(HnSBlocks.ZENALITE_END_STONE_ORE);
                        output.accept(HnSBlocks.ZENALITE_ABYSSLATE_ORE);
                        output.accept(HnSBlocks.ZENALITE_VOIDSTONE_ORE);

                        output.accept(HnSBlocks.SOLAR_CORE_BLACKSTONE_ORE);
                        output.accept(HnSBlocks.SOLAR_CORE_NETHERACK_ORE);

                        output.accept(HnSBlocks.DREADSTONE_ORE);

                        output.accept(HnSBlocks.CHLOROPHYTE_ORE);



                        /*
                        *** Overworld Blocks
                         */
                        output.accept(HnSBlocks.RUNESTONE_SLAG);
                        output.accept(HnSBlocks.AQUASTONE);

                        /*
                        *** Nether Blocks
                         */

                        /*
                        ***End Blocks
                         */

                        output.accept(HnSBlocks.ABYSSLATE);
                        output.accept(HnSBlocks.PHANTASMIUM);
                        output.accept(HnSBlocks.COBBLED_VOIDSTONE);
                        output.accept(HnSBlocks.VOIDSTONE);

                    }).build());

    public static final Supplier<CreativeModeTab> HAZEN_N_STUFF_EQUIPMENT = CREATIVE_MODE_TAB.register("hazennstuff_equipment",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(HnSItems.CALAMITAS_HELMET.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "hazennstuff_materials"))
                    .title(Component.translatable("creativetab.hazennstuff.hazennstuff_equipment"))
                    .displayItems((itemDisplayParameters, output) -> {

                        /*
                        *** Fire
                         */

                        // Soul Flamed
                        output.accept(HnSItems.SOUL_FLAME_HELMET.get());
                        output.accept(HnSItems.SOUL_FLAME_CHESTPLATE.get());
                        output.accept(HnSItems.SOUL_FLAME_LEGGINGS.get());
                        output.accept(HnSItems.SOUL_FLAME_BOOTS.get());

                        // Blazeborne
                        output.accept(HnSItems.BLAZEBORNE_HELMET.get());
                        output.accept(HnSItems.BLAZEBORNE_CHESTPLATE.get());
                        output.accept(HnSItems.BLAZEBORNE_LEGGINGS.get());
                        output.accept(HnSItems.BLAZEBORNE_BOOTS.get());

                        // Calamitas
                        output.accept(HnSItems.CALAMITAS_HELMET.get());
                        output.accept(HnSItems.CALAMITAS_CHESTPLATE.get());
                        output.accept(HnSItems.CALAMITAS_LEGGINGS.get());
                        output.accept(HnSItems.CALAMITAS_BOOTS.get());

                        // Hazel
                        output.accept(HnSItems.HAZEL_HELMET.get());
                        output.accept(HnSItems.HAZEL_CHESTPLATE.get());
                        //output.accept(HnSItems.HAZEL_HOLY_MOLLY_CHESTPLATE.get());
                        output.accept(HnSItems.HAZEL_LEGGINGS.get());
                        output.accept(HnSItems.HAZEL_BOOTS.get());

                        /*
                        *** Ice
                         */

                        // Cryogenic Ruler
                        output.accept(HnSItems.CRYOGENIC_RULER_HELMET.get());
                        output.accept(HnSItems.CRYOGENIC_RULER_CHESTPLATE.get());
                        output.accept(HnSItems.CRYOGENIC_RULER_LEGGINGS.get());
                        output.accept(HnSItems.CRYOGENIC_RULER_BOOTS.get());

                        // Crystal Arachnid
                        output.accept(HnSItems.CRYSTAL_ARACHNID_HELMET.get());
                        output.accept(HnSItems.CRYSTAL_ARACHNID_CHESTPLATE.get());
                        output.accept(HnSItems.CRYSTAL_ARACHNID_LEGGINGS.get());
                        output.accept(HnSItems.CRYSTAL_ARACHNID_BOOTS.get());

                        // Herta Puppet
                        output.accept(HnSItems.HERTA_PUPPET_HELMET.get());
                        output.accept(HnSItems.HERTA_PUPPET_CHESTPLATE.get());
                        output.accept(HnSItems.HERTA_PUPPET_LEGGINGS.get());
                        output.accept(HnSItems.HERTA_PUPPET_BOOTS.get());

                        /*
                        *** Lightning
                         */

                        output.accept(HnSItems.CHARGED_SCOURGE_HELMET.get());
                        output.accept(HnSItems.CHARGED_SCOURGE_CHESTPLATE.get());
                        output.accept(HnSItems.CHARGED_SCOURGE_LEGGINGS.get());
                        output.accept(HnSItems.CHARGED_SCOURGE_BOOTS.get());

                        output.accept(HnSItems.THUNDER_PROWLER_HELMET.get());
                        output.accept(HnSItems.THUNDER_PROWLER_CHESTPLATE.get());
                        output.accept(HnSItems.THUNDER_PROWLER_LEGGINGS.get());
                        output.accept(HnSItems.THUNDER_PROWLER_BOOTS.get());

                        /*
                        *** Nature
                         */

                        // Creaking
                        output.accept(HnSItems.CREAKING_HELMET.get());
                        output.accept(HnSItems.CREAKING_CHESTPLATE.get());
                        output.accept(HnSItems.CREAKING_LEGGINGS.get());
                        output.accept(HnSItems.CREAKING_BOOTS.get());

                        // Chlorophyte
                        output.accept(HnSItems.CHLOROPHYTE_HELMET.get());
                        output.accept(HnSItems.CHLOROPHYTE_HEADGEAR.get());
                        output.accept(HnSItems.CHLOROPHYTE_MASK.get());
                        output.accept(HnSItems.CHLOROPHYTE_CHESTPLATE.get());
                        output.accept(HnSItems.CHLOROPHYTE_LEGGINGS.get());
                        output.accept(HnSItems.CHLOROPHYTE_BOOTS.get());

                        /*
                        *** Blood
                         */

                        // Flesh Mass
                        output.accept(HnSItems.FLESH_MASS_HELMET.get());
                        output.accept(HnSItems.FLESH_MASS_CHESTPLATE.get());
                        output.accept(HnSItems.FLESH_MASS_LEGGINGS.get());
                        output.accept(HnSItems.FLESH_MASS_BOOTS.get());

                        // The Wither
                        output.accept(HnSItems.THE_WITHER_HELMET.get());
                        output.accept(HnSItems.THE_WITHER_CHESTPLATE.get());
                        output.accept(HnSItems.THE_WITHER_LEGGINGS.get());
                        output.accept(HnSItems.THE_WITHER_BOOTS.get());

                        /*
                        *** Ender
                         */

                        // Ender Dragon
                        output.accept(HnSItems.ENDER_DRAGON_HELMET.get());
                        output.accept(HnSItems.ENDER_DRAGON_CHESTPLATE.get());
                        output.accept(HnSItems.ENDER_DRAGON_LEGGINGS.get());
                        output.accept(HnSItems.ENDER_DRAGON_BOOTS.get());

                        /*
                        *** Holy
                         */

                        // Seraph
                        output.accept(HnSItems.SERAPH_HELMET.get());
                        output.accept(HnSItems.SERAPH_CHESTPLATE.get());
                        output.accept(HnSItems.SERAPH_LEGGINGS.get());
                        output.accept(HnSItems.SERAPH_BOOTS.get());

                        // Mothic Witch
                        output.accept(HnSItems.MOTHIC_WITCH_HELMET.get());
                        output.accept(HnSItems.MOTHIC_WITCH_CHESTPLATE.get());
                        //output.accept(HnSItems.MOTHIC_WITCH_SECRET_CHESTPLATE.get());
                        output.accept(HnSItems.MOTHIC_WITCH_LEGGINGS.get());
                        output.accept(HnSItems.MOTHIC_WITCH_BOOTS.get());

                        // Gabriel Ultrakill
                        output.accept(HnSItems.GABRIEL_ULTRAKILL_HELMET.get());
                        output.accept(HnSItems.GABRIEL_ULTRAKILL_CHESTPLATE.get());
                        output.accept(HnSItems.GABRIEL_ULTRAKILL_LEGGINGS.get());
                        output.accept(HnSItems.GABRIEL_ULTRAKILL_BOOTS.get());

                        /*
                        *** Evocation
                         */

                        // Supreme Witch
                        output.accept(HnSItems.SUPREME_WITCH_HELMET.get());
                        output.accept(HnSItems.SUPREME_WITCH_CHESTPLATE.get());
                        output.accept(HnSItems.SUPREME_WITCH_LEGGINGS.get());
                        output.accept(HnSItems.SUPREME_WITCH_BOOTS.get());

                        // Alchemist Supreme
                        output.accept(HnSItems.ALCHEMIST_SUPREME_HELMET.get());
                        output.accept(HnSItems.ALCHEMIST_SUPREME_CHESTPLATE.get());
                        output.accept(HnSItems.ALCHEMIST_SUPREME_LEGGINGS.get());
                        output.accept(HnSItems.ALCHEMIST_SUPREME_BOOTS.get());

                        /*
                        *** Radiance
                         */



                        // Mycelium Guardian
                        output.accept(HnSItems.MYCELIUM_GUARDIAN_HELMET.get());
                        output.accept(HnSItems.MYCELIUM_GUARDIAN_CHESTPLATE.get());
                        output.accept(HnSItems.MYCELIUM_GUARDIAN_LEGGINGS.get());
                        output.accept(HnSItems.MYCELIUM_GUARDIAN_BOOTS.get());



                        /*
                         *** Shadow
                         */


                        // Shadow Scale
                        output.accept(HnSItems.SHADOW_SCALE_HELMET.get());
                        output.accept(HnSItems.SHADOW_SCALE_CHESTPLATE.get());
                        output.accept(HnSItems.SHADOW_SCALE_LEGGINGS.get());
                        output.accept(HnSItems.SHADOW_SCALE_BOOTS.get());

                        /*
                         *** Eldritch
                         */

                        // Dark Ritual Templar
                        output.accept(HnSItems.DARK_RITUAL_TEMPLAR_HELMET.get());
                        output.accept(HnSItems.DARK_RITUAL_TEMPLAR_CHESTPLATE.get());
                        output.accept(HnSItems.DARK_RITUAL_TEMPLAR_LEGGINGS.get());
                        output.accept(HnSItems.DARK_RITUAL_TEMPLAR_BOOTS.get());

                        // Infestation
                        output.accept(HnSItems.INFESTATION_HELMET.get());
                        output.accept(HnSItems.INFESTATION_CHESTPLATE.get());
                        output.accept(HnSItems.INFESTATION_LEGGINGS.get());
                        output.accept(HnSItems.INFESTATION_BOOTS.get());

                        /*
                         *** Pyrium
                         */



                        // Pyrium
                        output.accept(HnSItems.PYRIUM_HELMET.get());
                        output.accept(HnSItems.PYRIUM_CHESTPLATE.get());
                        output.accept(HnSItems.PYRIUM_LEGGINGS.get());
                        output.accept(HnSItems.PYRIUM_BOOTS.get());

                        // Legionnaire
                        output.accept(HnSItems.LEGIONNAIRE_HELMET.get());
                        output.accept(HnSItems.LEGIONNAIRE_CHESTPLATE.get());
                        output.accept(HnSItems.LEGIONNAIRE_LEGGINGS.get());
                        output.accept(HnSItems.LEGIONNAIRE_BOOTS.get());

                        // Legionnaire Ruler
                        output.accept(HnSItems.LEGIONNAIRE_RULER_HELMET.get());
                        output.accept(HnSItems.LEGIONNAIRE_RULER_CHESTPLATE.get());
                        output.accept(HnSItems.LEGIONNAIRE_RULER_LEGGINGS.get());
                        output.accept(HnSItems.LEGIONNAIRE_RULER_BOOTS.get());

                        // Legionnaire Ruler Soul
                        output.accept(HnSItems.SOUL_LEGIONNAIRE_RULER_HELMET.get());
                        output.accept(HnSItems.SOUL_LEGIONNAIRE_RULER_CHESTPLATE.get());
                        output.accept(HnSItems.SOUL_LEGIONNAIRE_RULER_LEGGINGS.get());
                        output.accept(HnSItems.SOUL_LEGIONNAIRE_RULER_BOOTS.get());

                        // Legionnaire Commander
                        output.accept(HnSItems.LEGIONNAIRE_COMMANDER_HELMET.get());
                        output.accept(HnSItems.LEGIONNAIRE_COMMANDER_CHESTPLATE.get());
                        output.accept(HnSItems.LEGIONNAIRE_COMMANDER_LEGGINGS.get());
                        output.accept(HnSItems.LEGIONNAIRE_COMMANDER_BOOTS.get());

                        // Legionnaire Battlemage
                        output.accept(HnSItems.PYRIUM_BATTLEMAGE_HELMET.get());
                        output.accept(HnSItems.PYRIUM_BATTLEMAGE_CHESTPLATE.get());
                        output.accept(HnSItems.PYRIUM_BATTLEMAGE_LEGGINGS.get());
                        output.accept(HnSItems.PYRIUM_BATTLEMAGE_BOOTS.get());

                        // Tyros
                        output.accept(HnSItems.TYROS_HELMET.get());
                        output.accept(HnSItems.TYROS_CHESTPLATE.get());
                        output.accept(HnSItems.TYROS_LEGGINGS.get());
                        output.accept(HnSItems.TYROS_BOOTS.get());

                        // Tyros Soul
                        output.accept(HnSItems.TYROS_SOUL_HELMET.get());
                        output.accept(HnSItems.TYROS_SOUL_CHESTPLATE.get());
                        output.accept(HnSItems.TYROS_SOUL_LEGGINGS.get());
                        output.accept(HnSItems.TYROS_SOUL_BOOTS.get());


                        /*
                         *** Cosmetic Battlemage
                         */

                        // Frieren
                        output.accept(HnSItems.FRIEREN_HELMET.get());
                        output.accept(HnSItems.FRIEREN_CHESTPLATE.get());
                        output.accept(HnSItems.FRIEREN_LEGGINGS.get());
                        output.accept(HnSItems.FRIEREN_BOOTS.get());

                        // Synthesizer V
                        output.accept(HnSItems.SYNTHESIZER_V_HELMET.get());
                        output.accept(HnSItems.SYNTHESIZER_V_CHESTPLATE.get());
                        output.accept(HnSItems.SYNTHESIZER_V_LEGGINGS.get());
                        output.accept(HnSItems.SYNTHESIZER_V_BOOTS.get());

                        // Utau
                        output.accept(HnSItems.UTAU_HELMET.get());
                        output.accept(HnSItems.UTAU_CHESTPLATE.get());
                        output.accept(HnSItems.UTAU_LEGGINGS.get());
                        output.accept(HnSItems.UTAU_BOOTS.get());

                        // Project Sekai
                        output.accept(HnSItems.PROJECT_SEKAI_HELMET.get());
                        output.accept(HnSItems.PROJECT_SEKAI_CHESTPLATE.get());
                        output.accept(HnSItems.PROJECT_SEKAI_LEGGINGS.get());
                        output.accept(HnSItems.PROJECT_SEKAI_BOOTS.get());

                        // Rotten Girl
                        output.accept(HnSItems.ROTTEN_GIRL_HELMET.get());
                        output.accept(HnSItems.ROTTEN_GIRL_CHESTPLATE.get());
                        output.accept(HnSItems.ROTTEN_GIRL_LEGGINGS.get());
                        output.accept(HnSItems.ROTTEN_GIRL_BOOTS.get());

                        // Neru
                        output.accept(HnSItems.NERU_HELMET.get());
                        output.accept(HnSItems.NERU_CHESTPLATE.get());
                        output.accept(HnSItems.NERU_LEGGINGS.get());
                        output.accept(HnSItems.NERU_BOOTS.get());

                        // Giorno Giovanna
                        output.accept(HnSItems.GIORNO_GIOVANNA_HELMET.get());
                        output.accept(HnSItems.GIORNO_GIOVANNA_CHESTPLATE.get());
                        output.accept(HnSItems.GIORNO_GIOVANNA_LEGGINGS.get());
                        output.accept(HnSItems.GIORNO_GIOVANNA_BOOTS.get());


                        /*
                        *** Mining Armor Sets
                         */

                        // Miner
                        output.accept(HnSItems.MINER_HELMET.get());
                        output.accept(HnSItems.MINER_CHESTPLATE.get());
                        output.accept(HnSItems.MINER_LEGGINGS.get());
                        output.accept(HnSItems.MINER_BOOTS.get());

                        // Spectral Spelunker
                        output.accept(HnSItems.SPECTRAL_SPELUNKER_HELMET.get());
                        output.accept(HnSItems.SPECTRAL_SPELUNKER_CHESTPLATE.get());
                        output.accept(HnSItems.SPECTRAL_SPELUNKER_LEGGINGS.get());
                        output.accept(HnSItems.SPECTRAL_SPELUNKER_BOOTS.get());



                        /*
                        *** Melee Armor Sets
                         */



                        // Frostbite Knight
                        output.accept(HnSItems.FROSTBITE_KNIGHT_HELMET.get());
                        output.accept(HnSItems.FROSTBITE_KNIGHT_CHESTPLATE.get());
                        output.accept(HnSItems.FROSTBITE_KNIGHT_LEGGINGS.get());
                        output.accept(HnSItems.FROSTBITE_KNIGHT_BOOTS.get());

                        // Frostbite Knight
                        output.accept(HnSItems.DREADSTEEL_KNIGHT_HELMET.get());
                        output.accept(HnSItems.DREADSTEEL_KNIGHT_CHESTPLATE.get());
                        output.accept(HnSItems.DREADSTEEL_KNIGHT_LEGGINGS.get());
                        output.accept(HnSItems.DREADSTEEL_KNIGHT_BOOTS.get());



                        /*
                         *** Archer Armor Sets
                         */



                        // Bounty Hunter
                        output.accept(HnSItems.BOUNTY_HUNTER_HELMET.get());
                        output.accept(HnSItems.BOUNTY_HUNTER_CHESTPLATE.get());
                        output.accept(HnSItems.BOUNTY_HUNTER_LEGGINGS.get());
                        output.accept(HnSItems.BOUNTY_HUNTER_BOOTS.get());

                        // Frostbite Hunter
                        output.accept(HnSItems.FROSTBITE_HUNTER_HELMET.get());
                        output.accept(HnSItems.FROSTBITE_HUNTER_CHESTPLATE.get());
                        output.accept(HnSItems.FROSTBITE_HUNTER_LEGGINGS.get());
                        output.accept(HnSItems.FROSTBITE_HUNTER_BOOTS.get());

                        // Permafrost Prince
                        output.accept(HnSItems.PERMAFROST_PRINCE_HELMET.get());
                        output.accept(HnSItems.PERMAFROST_PRINCE_CHESTPLATE.get());
                        output.accept(HnSItems.PERMAFROST_PRINCE_LEGGINGS.get());
                        output.accept(HnSItems.PERMAFROST_PRINCE_BOOTS.get());



                        /*
                        *** Misc
                         */



                        // Magehunter
                        output.accept(HnSItems.MAGEHUNTER_HELMET.get());
                        output.accept(HnSItems.MAGEHUNTER_CHESTPLATE.get());
                        output.accept(HnSItems.MAGEHUNTER_LEGGINGS.get());
                        output.accept(HnSItems.MAGEHUNTER_BOOTS.get());

                        // Mithril Battlemage
                        output.accept(HnSItems.MITHRIL_BATTLEMAGE_HELMET.get());
                        output.accept(HnSItems.MITHRIL_BATTLEMAGE_CHESTPLATE.get());
                        output.accept(HnSItems.MITHRIL_BATTLEMAGE_LEGGINGS.get());
                        output.accept(HnSItems.MITHRIL_BATTLEMAGE_BOOTS.get());



                        /*
                         *** Tribute Armor Sets
                         */


                        // Fireblossom
                        output.accept(HnSItems.FIREBLOSSOM_BATTLEMAGE_CROWN.get());
                        output.accept(HnSItems.FIREBLOSSOM_BATTLEMAGE_HELMET.get());
                        output.accept(HnSItems.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get());
                        output.accept(HnSItems.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get());
                        output.accept(HnSItems.FIREBLOSSOM_BATTLEMAGE_BOOTS.get());

                        // Arbitrium Robes
                        output.accept(HnSItems.ARBITRIUM_ROBES_HELMET.get());
                        output.accept(HnSItems.ARBITRIUM_ROBES_CHESTPLATE.get());
                        output.accept(HnSItems.ARBITRIUM_ROBES_LEGGINGS.get());
                        output.accept(HnSItems.ARBITRIUM_ROBES_BOOTS.get());

                        output.accept(HnSItems.ASCENDED_ARBITRIUM_ROBES_HELMET.get());
                        output.accept(HnSItems.ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get());
                        output.accept(HnSItems.ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get());
                        output.accept(HnSItems.ASCENDED_ARBITRIUM_ROBES_BOOTS.get());

                        // Atlas
                        output.accept(HnSItems.ATLAS_HELMET.get());
                        output.accept(HnSItems.ATLAS_CHESTPLATE.get());
                        output.accept(HnSItems.ATLAS_LEGGINGS.get());
                        output.accept(HnSItems.ATLAS_BOOTS.get());

                        // Maverick
                        output.accept(HnSItems.MAVERICK_HELMET.get());
                        output.accept(HnSItems.MAVERICK_CHESTPLATE.get());
                        output.accept(HnSItems.MAVERICK_LEGGINGS.get());
                        output.accept(HnSItems.MAVERICK_BOOTS.get());

                        // SLC!Cat
                        output.accept(HnSItems.SLC_CAT_HELMET.get());
                        output.accept(HnSItems.SLC_CAT_CHESTPLATE.get());
                        output.accept(HnSItems.SLC_CAT_LEGGINGS.get());
                        output.accept(HnSItems.SLC_CAT_BOOTS.get());

                        // Abberant Predator
                        output.accept(HnSItems.ABBERANT_PREDATOR_HELMET.get());
                        output.accept(HnSItems.ABBERANT_PREDATOR_CHESTPLATE.get());
                        output.accept(HnSItems.ABBERANT_PREDATOR_LEGGINGS.get());
                        output.accept(HnSItems.ABBERANT_PREDATOR_BOOTS.get());

                        // Iron 431
                        output.accept(HnSItems.IRON431_HELMET.get());
                        output.accept(HnSItems.IRON431_CHESTPLATE.get());
                        output.accept(HnSItems.IRON431_LEGGINGS.get());
                        output.accept(HnSItems.IRON431_BOOTS.get());

                        // Ascended Iron 431
                        output.accept(HnSItems.ASCENDED_IRON431_HELMET.get());
                        output.accept(HnSItems.ASCENDED_IRON431_CHESTPLATE.get());
                        output.accept(HnSItems.ASCENDED_IRON431_LEGGINGS.get());
                        output.accept(HnSItems.ASCENDED_IRON431_BOOTS.get());

                        // Sacred Robes
                        output.accept(HnSItems.SACRED_ROBES_HELMET.get());
                        output.accept(HnSItems.SACRED_ROBES_CHESTPLATE.get());
                        output.accept(HnSItems.SACRED_ROBES_LEGGINGS.get());
                        output.accept(HnSItems.SACRED_ROBES_BOOTS.get());

                        // Ascended Sacred Robes
                        output.accept(HnSItems.ASCENDED_SACRED_ROBES_HELMET.get());
                        output.accept(HnSItems.ASCENDED_SACRED_ROBES_CHESTPLATE.get());
                        output.accept(HnSItems.ASCENDED_SACRED_ROBES_LEGGINGS.get());
                        output.accept(HnSItems.ASCENDED_SACRED_ROBES_BOOTS.get());

                        // Lemon God
                        output.accept(HnSItems.LEMON_GOD_HELMET.get());
                        output.accept(HnSItems.LEMON_GOD_CHESTPLATE.get());
                        output.accept(HnSItems.LEMON_GOD_LEGGINGS.get());
                        output.accept(HnSItems.LEMON_GOD_BOOTS.get());

                        // Ascended Lemon God
                        output.accept(HnSItems.ASCENDED_LEMON_GOD_HELMET.get());
                        output.accept(HnSItems.ASCENDED_LEMON_GOD_CHESTPLATE.get());
                        output.accept(HnSItems.ASCENDED_LEMON_GOD_LEGGINGS.get());
                        output.accept(HnSItems.ASCENDED_LEMON_GOD_BOOTS.get());

                    }).build());

    public static final Supplier<CreativeModeTab> HAZEN_N_STUFF_UTILITY = CREATIVE_MODE_TAB.register("hazennstuff_utility",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(HnSItems.RADIANCE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "hazennstuff_equipment"))
                    .title(Component.translatable("creativetab.hazennstuff.hazennstuff_utility"))
                    .displayItems((itemDisplayParameters, output) -> {

                        /*
                        *** Weapons
                         */


                        //Fire


                        //Fireblossom Rapier
                        output.accept(HnSItems.FIREBLOSSOM_RAPIER.get());
                        //Fire Brand
                        output.accept(HnSItems.FIREBRAND.get());
                        //Draconic Splitter
                        output.accept(HnSItems.DRACONIC_SPLITTER.get());
                        //Ravens Bane
                        output.accept(HnSItems.RAVENS_BANE.get());
                        // War-Flaming Lance
                        output.accept(HnSItems.WARFLAMING_LANCE.get());
                        // Volcano
                        output.accept(HnSItems.VOLCANO.get());


                        //Ice


                        //Ice Pike
                        output.accept(HnSItems.ICE_PIKE.get());
                        // Frostburn Dagger
                        output.accept(HnSItems.FROSTBURN_DAGGER.get());


                        //Lightning


                        //Beongae
                        output.accept(HnSItems.BEONGAE.get());
                        //Skyscorcher
                        output.accept(HnSItems.SKYSCORCHER.get());
                        /*
                        Ionic Splitter
                         */
                        output.accept(HnSItems.IONIC_SPLITTER_DORMANT.get());
                        output.accept(HnSItems.IONIC_SPLITTER_T1.get());
                        output.accept(HnSItems.IONIC_SPLITTER_T2.get());
                        output.accept(HnSItems.IONIC_SPLITTER_T3.get());


                        //Nature


                        //Bountiful Harvest
                        output.accept(HnSItems.BOUNTIFUL_HARVEST.get());
                        //Thorn Chakram
                        output.accept(HnSItems.THORN_CHAKRAM.get());
                        //Blade of Grass
                        output.accept(HnSItems.BLADE_OF_GRASS.get());


                        //Blood


                        //Vampire Knives
                        output.accept(HnSItems.VAMPIRE_KNIVES.get());


                        //Ender


                        // Obsidian Claymore
                        output.accept(HnSItems.OBSIDIAN_CLAYMORE.get());
                        // Star Fury
                        output.accept(HnSItems.STARFURY.get());


                        //Holy


                        // Hammer of Justice
                        output.accept(HnSItems.HAMMER_OF_JUSTICE.get());
                        // Excalibur
                        output.accept(HnSItems.EXCALIBUR.get());
                        // Excalibur Divine Gold
                        output.accept(HnSItems.ISS_EXCALIBUR.get());
                        // Hazen's Excalibur
                        output.accept(HnSItems.HAZENS_EXCALIBUR.get());
                        // Divine Greatsword
                        output.accept(HnSItems.DIVINE_GREATSWORD.get());


                        //Radiance


                        //Hammush
                        output.accept(HnSItems.HAMMUSH.get());
                        //Meowmere
                        output.accept(HnSItems.MEOWMERE.get());
                        //Spectrum
                        output.accept(HnSItems.SPECTRUM.get());
                        //Terraprisma
                        output.accept(HnSItems.TERRAPRISMA.get());


                        //Evocation


                        //Ancient Warriors Axe
                        output.accept(HnSItems.ANCIENT_WARRIORS_AXE.get());
                        //Malice
                        output.accept(HnSItems.MALICE.get());


                        //Shadow


                        //Lights Bane
                        output.accept(HnSItems.LIGHTS_BANE.get());
                        //Nights Edge
                        output.accept(HnSItems.NIGHTS_EDGE.get());
                        //True Nights Edge
                        output.accept(HnSItems.TRUE_NIGHTS_EDGE.get());


                        //Eldritch


                        //The Devourer
                        output.accept(HnSItems.THE_DEVOURER.get());


                        //Misc


                        //Mage Bane
                        output.accept(HnSItems.MAGE_BANE.get());

                        //Legionnaire Warlock Axe
                        output.accept(HnSItems.LEGIONNAIRE_WARLOCK_AXE.get());

                        //Flame Reaver
                        output.accept(HnSItems.DAWNMAKER.get());

                        //Muramasa
                        output.accept(HnSItems.MURAMASA.get());


                        /*
                        ***Staves
                         */




                        //Wisewood Cane
                        output.accept(HnSItems.WISEWOOD_CANE.get());
                        //Frieren Staff
                        output.accept(HnSItems.FRIEREN_STAFF.get());
                        //Rod of Discord
                        output.accept(HnSItems.ROD_OF_DISCORD.get());
                        //White Lily Staff
                        output.accept(HnSItems.WHITE_LILY_STAFF.get());
                        //Soulcalling Scepter
                        output.accept(HnSItems.SOULCALLING_SCEPTER.get());

                        /*
                        *** Tools
                         */

                        //Pickaxes
                        output.accept(HnSItems.SPECTRAL_PICKAXE.get());
                        output.accept(HnSItems.PICKAXE_AXE.get());
                        output.accept(HnSItems.PICKAXE_AXE_DIVINE_GOLD.get());

                        /*
                        ***Curios
                         */



                        //Mana Crystals
                        output.accept(HnSItems.RUPTURED.get());
                        output.accept(HnSItems.REFINED.get());
                        output.accept(HnSItems.REINFORCED.get());
                        output.accept(HnSItems.RADIANCE.get());

                        //Life Crystals
                        output.accept(HnSItems.SHATTERED.get());
                        output.accept(HnSItems.SACRED.get());
                        output.accept(HnSItems.STRENGTHENED.get());
                        output.accept(HnSItems.SINGULARITY.get());

                        //Soul Crystals
                        output.accept(HnSItems.ABSTRACT.get());
                        output.accept(HnSItems.ADVANCED.get());
                        output.accept(HnSItems.ABOMINATION.get());
                        output.accept(HnSItems.ABSOLUTE.get());

                        //Spellbooks
                        output.accept(HnSItems.GOLDEN_SHOWER_SPELLBOOK.get());
                        output.accept(HnSItems.ENERGIZED_CORE_SPELLBOOK.get());

                        //Sheath
                        output.accept(HnSItems.GALVANIZED_SHEATH.get());
                        output.accept(HnSItems.SCROLL_SHEATH.get());

                        //Wings
                        output.accept(HnSItems.ARBITRIUM_WINGS.get());

                        // Cinderous Curios
                        output.accept(HnSItems.BLADE_OF_THE_LEGATE.get());
                        output.accept(HnSItems.THE_PREFECTS_RING.get());
                        output.accept(HnSItems.THE_TRIBUNES_MEDALLION.get());

                        //Misc
                        output.accept(HnSItems.RING_OF_EFFICIENCY.get());




                    }).build());

//    public static final Supplier<CreativeModeTab> HAZEN_N_STUFF_GECKOLIB = CREATIVE_MODE_TAB.register("hazennstuff_geckolib",
//            () -> CreativeModeTab.builder().icon(() -> new ItemStack(HnSItems.DIVINE_MOLD.get()))
//                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "hazennstuff_utility"))
//                    .title(Component.translatable("creativetab.hazennstuff.hazennstuff_geckolib"))
//                    .displayItems((itemDisplayParameters, output) -> {
//
//
//                        output.accept(HnSItems.GECKOLIB_ARBITRIUM_ROBES_HELMET.get());
//                        output.accept(HnSItems.GECKOLIB_ARBITRIUM_ROBES_CHESTPLATE.get());
//                        output.accept(HnSItems.GECKOLIB_ARBITRIUM_ROBES_LEGGINGS.get());
//                        output.accept(HnSItems.GECKOLIB_ARBITRIUM_ROBES_BOOTS.get());
//
//                        output.accept(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_HELMET.get());
//                        output.accept(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get());
//                        output.accept(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get());
//                        output.accept(HnSItems.GECKOLIB_ASCENDED_ARBITRIUM_ROBES_BOOTS.get());
//
//                        output.accept(HnSItems.GECKOLIB_CREAKING_HELMET.get());
//                        output.accept(HnSItems.GECKOLIB_CREAKING_CHESTPLATE.get());
//                        output.accept(HnSItems.GECKOLIB_CREAKING_LEGGINGS.get());
//                        output.accept(HnSItems.GECKOLIB_CREAKING_BOOTS.get());
//
//                        output.accept(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_HELMET.get());
//                        output.accept(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_CHESTPLATE.get());
//                        output.accept(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_LEGGINGS.get());
//                        output.accept(HnSItems.GECKOLIB_DARK_RITUAL_TEMPLAR_BOOTS.get());
//
//                        output.accept(HnSItems.GECKOLIB_ENDER_DRAGON_HELMET.get());
//                        output.accept(HnSItems.GECKOLIB_ENDER_DRAGON_CHESTPLATE.get());
//                        output.accept(HnSItems.GECKOLIB_ENDER_DRAGON_LEGGINGS.get());
//                        output.accept(HnSItems.GECKOLIB_ENDER_DRAGON_BOOTS.get());
//
//                        output.accept(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CROWN.get());
//                        output.accept(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_HELMET.get());
//                        output.accept(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get());
//                        output.accept(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get());
//                        output.accept(HnSItems.GECKOLIB_FIREBLOSSOM_BATTLEMAGE_BOOTS.get());
//
//                        output.accept(HnSItems.GECKOLIB_SERAPH_HELMET.get());
//                        output.accept(HnSItems.GECKOLIB_SERAPH_CHESTPLATE.get());
//                        output.accept(HnSItems.GECKOLIB_SERAPH_LEGGINGS.get());
//                        output.accept(HnSItems.GECKOLIB_SERAPH_BOOTS.get());
//
//                        output.accept(HnSItems.GECKOLIB_SOUL_FLAME_HELMET.get());
//                        output.accept(HnSItems.GECKOLIB_SOUL_FLAME_CHESTPLATE.get());
//                        output.accept(HnSItems.GECKOLIB_SOUL_FLAME_LEGGINGS.get());
//                        output.accept(HnSItems.GECKOLIB_SOUL_FLAME_BOOTS.get());
//
//                        output.accept(HnSItems.GECKOLIB_SUPREME_WITCH_HELMET.get());
//                        output.accept(HnSItems.GECKOLIB_SUPREME_WITCH_CHESTPLATE.get());
//                        output.accept(HnSItems.GECKOLIB_SUPREME_WITCH_LEGGINGS.get());
//                        output.accept(HnSItems.GECKOLIB_SUPREME_WITCH_BOOTS.get());
//
//                        output.accept(HnSItems.GECKOLIB_LEMON_GOD_HELMET.get());
//                        output.accept(HnSItems.GECKOLIB_LEMON_GOD_CHESTPLATE.get());
//                        output.accept(HnSItems.GECKOLIB_LEMON_GOD_LEGGINGS.get());
//                        output.accept(HnSItems.GECKOLIB_LEMON_GOD_BOOTS.get());
//
//                        output.accept(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_HELMET.get());
//                        output.accept(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_CHESTPLATE.get());
//                        output.accept(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_LEGGINGS.get());
//                        output.accept(HnSItems.GECKOLIB_ASCENDED_LEMON_GOD_BOOTS.get());
//
//                        output.accept(HnSItems.GECKOLIB_THE_WITHER_HELMET.get());
//                        output.accept(HnSItems.GECKOLIB_THE_WITHER_CHESTPLATE.get());
//                        output.accept(HnSItems.GECKOLIB_THE_WITHER_LEGGINGS.get());
//                        output.accept(HnSItems.GECKOLIB_THE_WITHER_BOOTS.get());
//
//                        output.accept(HnSItems.GECKOLIB_SUPREME_WITCH_HELMET.get());
//                        output.accept(HnSItems.GECKOLIB_SUPREME_WITCH_CHESTPLATE.get());
//                        output.accept(HnSItems.GECKOLIB_SUPREME_WITCH_LEGGINGS.get());
//                        output.accept(HnSItems.GECKOLIB_SUPREME_WITCH_BOOTS.get());
//
//                        output.accept(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_HELMET.get());
//                        output.accept(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_CHESTPLATE.get());
//                        output.accept(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS.get());
//                        output.accept(HnSItems.GECKOLIB_GABRIEL_ULTRAKILL_BOOTS.get());
//
//                        output.accept(HnSItems.ENDERMAN_HOOD.get());
//                        output.accept(HnSItems.ENDERMAN_MASKED.get());
//                        output.accept(HnSItems.ENDERMAN_BLINDFOLD.get());
//                        output.accept(HnSItems.ENDERMAN_CHESTPLATE.get());
//                        output.accept(HnSItems.ENDERMAN_LEGGINGS.get());
//                        output.accept(HnSItems.ENDERMAN_BOOTS.get());
//
//                        output.accept(HnSItems.PYROMANCER_BRUTE_HELMET.get());
//                        output.accept(HnSItems.PYROMANCER_BRUTE_CHESTPLATE.get());
//
//                        output.accept(HnSItems.BISHOP_OF_DECEIT_HELMET.get());
//                        output.accept(HnSItems.BISHOP_OF_DECEIT_CHESTPLATE.get());
//
//                        output.accept(HnSItems.NECROMANCER_HELMET.get());
//                        output.accept(HnSItems.NECROMANCER_CHESTPLATE.get());
//                        output.accept(HnSItems.NECROMANCER_LEGGINGS.get());
//
//                        output.accept(HnSItems.NAMELESS_ONE_HELMET.get());
//                        output.accept(HnSItems.NAMELESS_ONE_CHESTPLATE.get());
//                        output.accept(HnSItems.NAMELESS_ONE_LEGGINGS.get());
//
//                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
