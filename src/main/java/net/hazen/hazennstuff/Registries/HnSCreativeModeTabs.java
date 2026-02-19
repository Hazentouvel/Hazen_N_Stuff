package net.hazen.hazennstuff.Registries;

import net.hazen.hazennstuff.Item.Block.HnSBlocks;
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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(HnSItemRegistry.DIVINE_MOLD.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "hazennstuff_blocks"))
                    .title(Component.translatable("creativetab.hazennstuff.hazennstuff_materials"))
                    .displayItems((itemDisplayParameters, output) -> {

                        //Raw Materials
                        output.accept(HnSItemRegistry.RAW_ZENALITE);
                        output.accept(HnSItemRegistry.STARKISSED_ZENALITE);
                        output.accept(HnSItemRegistry.DREADSTONE);
                        output.accept(HnSItemRegistry.CRUDE_METAL);
                        output.accept(HnSItemRegistry.CHLOROPHYTE_CHUNK);
                        output.accept(HnSItemRegistry.SHADESTONE);

                        //Ingots/Crystals/Gems
                        output.accept(HnSItemRegistry.ROSE_QUARTZ);
                        output.accept(HnSItemRegistry.ROSE_GOLD_INGOT);
                        output.accept(HnSItemRegistry.ZENALITE_INGOT);
                        output.accept(HnSItemRegistry.DREADSTEEL_INGOT);
                        output.accept(HnSItemRegistry.STEEL_INGOT);
                        output.accept(HnSItemRegistry.SOLAR_CORE);
                        output.accept(HnSItemRegistry.SILVER_SCRAPS);
                        output.accept(HnSItemRegistry.CHLOROPHYTE_INGOT);
                        output.accept(HnSItemRegistry.HALLOWED_INGOT);
                        output.accept(HnSItemRegistry.DEMONITE_INGOT);

                        //Nuggets
                        output.accept(HnSItemRegistry.PYRIUM_NUGGET);
                        output.accept(HnSItemRegistry.STEEL_NUGGET);

                        //Templates/Molds
                        output.accept(HnSItemRegistry.DIVINE_MOLD);
                        output.accept(HnSItemRegistry.FLAMING_TEMPLATE);

                        //Fragments
                        output.accept(HnSItemRegistry.RUNESTONE_FRAGMENTS);
                        output.accept(HnSItemRegistry.PERMAFROST_FRAGMENT);
                        output.accept(HnSItemRegistry.EXCALIBUR_FRAGMENT);

                        //Bones
                        output.accept(HnSItemRegistry.OVERGROWN_BONE);
                        output.accept(HnSItemRegistry.CHARRED_BONES);

                        //Focus Materials
                        output.accept(HnSItemRegistry.GLOWING_MUSHROOM);
                        output.accept(HnSItemRegistry.SHADOW_SCALE);

                        //Misc
                        output.accept(HnSBlocks.FIREBLOSSOM);
                        output.accept(HnSItemRegistry.DEUS_ESSENCE);
                        output.accept(HnSItemRegistry.CLOTH_OF_THE_FLAMEBEARER);
                        output.accept(HnSItemRegistry.LEMON);
                        output.accept(HnSItemRegistry.DIVINE_LEMON);
                        output.accept(HnSItemRegistry.STORM_WEAVE);
                        output.accept(HnSItemRegistry.SPIDER_FANG);
                        output.accept(HnSItemRegistry.PRISMATIC_SHARD);
                        output.accept(HnSItemRegistry.VOLT_CORE);
                        output.accept(HnSItemRegistry.STARDUST);

                        /*
                        *** Upgrade Orbs
                         */
                        output.accept(HnSItemRegistry.RADIANCE_UPGRADE_ORB.get());
                        output.accept(HnSItemRegistry.SHADOW_UPGRADE_ORB.get());
                        output.accept(HnSItemRegistry.ASTRAL_UPGRADE_ORB.get());
                        output.accept(HnSItemRegistry.ARCHERY_UPGRADE_ORB.get());
                        output.accept(HnSItemRegistry.MELEE_UPGRADE_ORB.get());
                        output.accept(HnSItemRegistry.HEALTH_UPGRADE_ORB.get());

                        // Tier 2 Upgrade Orbs
                        output.accept(HnSItemRegistry.ENHANCED_FIRE_UPGRADE_ORB.get());
                        output.accept(HnSItemRegistry.ENHANCED_ICE_UPGRADE_ORB.get());

                        //Runes
                        output.accept(HnSItemRegistry.MELEE_RUNE.get());
                        output.accept(HnSItemRegistry.ARCHERY_RUNE.get());
                        output.accept(HnSItemRegistry.HEALTH_RUNE.get());
                        output.accept(HnSItemRegistry.SHADOW_RUNE.get());
                        output.accept(HnSItemRegistry.RADIANCE_RUNE.get());
                        output.accept(HnSItemRegistry.ASTRAL_RUNE.get());
                        output.accept(HnSItemRegistry.ELDRITCH_RUNE.get());



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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(HnSItemRegistry.CALAMITAS_HELMET.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "hazennstuff_materials"))
                    .title(Component.translatable("creativetab.hazennstuff.hazennstuff_equipment"))
                    .displayItems((itemDisplayParameters, output) -> {

                        /*
                        *** Fire
                         */

                        // Soul Flamed
                        output.accept(HnSItemRegistry.SOUL_FLAME_HELMET.get());
                        output.accept(HnSItemRegistry.SOUL_FLAME_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.SOUL_FLAME_LEGGINGS.get());
                        output.accept(HnSItemRegistry.SOUL_FLAME_BOOTS.get());

                        // Blazeborne
                        output.accept(HnSItemRegistry.BLAZEBORNE_HELMET.get());
                        output.accept(HnSItemRegistry.BLAZEBORNE_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.BLAZEBORNE_LEGGINGS.get());
                        output.accept(HnSItemRegistry.BLAZEBORNE_BOOTS.get());

                        // Calamitas
                        output.accept(HnSItemRegistry.CALAMITAS_HELMET.get());
                        output.accept(HnSItemRegistry.CALAMITAS_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.CALAMITAS_LEGGINGS.get());
                        output.accept(HnSItemRegistry.CALAMITAS_BOOTS.get());

                        // Hazel
                        output.accept(HnSItemRegistry.HAZEL_HELMET.get());
                        output.accept(HnSItemRegistry.HAZEL_CHESTPLATE.get());
                        //output.accept(HnSItemRegistry.HAZEL_HOLY_MOLLY_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.HAZEL_LEGGINGS.get());
                        output.accept(HnSItemRegistry.HAZEL_BOOTS.get());

                        /*
                        *** Ice
                         */

                        // Cryogenic Ruler
                        output.accept(HnSItemRegistry.CRYOGENIC_RULER_HELMET.get());
                        output.accept(HnSItemRegistry.CRYOGENIC_RULER_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.CRYOGENIC_RULER_LEGGINGS.get());
                        output.accept(HnSItemRegistry.CRYOGENIC_RULER_BOOTS.get());

                        // Crystal Arachnid
                        output.accept(HnSItemRegistry.CRYSTAL_ARACHNID_HELMET.get());
                        output.accept(HnSItemRegistry.CRYSTAL_ARACHNID_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.CRYSTAL_ARACHNID_LEGGINGS.get());
                        output.accept(HnSItemRegistry.CRYSTAL_ARACHNID_BOOTS.get());

                        // Herta Puppet
                        output.accept(HnSItemRegistry.HERTA_PUPPET_HELMET.get());
                        output.accept(HnSItemRegistry.HERTA_PUPPET_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.HERTA_PUPPET_LEGGINGS.get());
                        output.accept(HnSItemRegistry.HERTA_PUPPET_BOOTS.get());

                        /*
                        *** Lightning
                         */

                        output.accept(HnSItemRegistry.CHARGED_SCOURGE_HELMET.get());
                        output.accept(HnSItemRegistry.CHARGED_SCOURGE_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.CHARGED_SCOURGE_LEGGINGS.get());
                        output.accept(HnSItemRegistry.CHARGED_SCOURGE_BOOTS.get());

                        output.accept(HnSItemRegistry.THUNDER_PROWLER_HELMET.get());
                        output.accept(HnSItemRegistry.THUNDER_PROWLER_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.THUNDER_PROWLER_LEGGINGS.get());
                        output.accept(HnSItemRegistry.THUNDER_PROWLER_BOOTS.get());

                        /*
                        *** Nature
                         */

                        // Creaking
                        output.accept(HnSItemRegistry.CREAKING_HELMET.get());
                        output.accept(HnSItemRegistry.CREAKING_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.CREAKING_LEGGINGS.get());
                        output.accept(HnSItemRegistry.CREAKING_BOOTS.get());

                        // Chlorophyte
                        output.accept(HnSItemRegistry.CHLOROPHYTE_HELMET.get());
                        output.accept(HnSItemRegistry.CHLOROPHYTE_HEADGEAR.get());
                        output.accept(HnSItemRegistry.CHLOROPHYTE_MASK.get());
                        output.accept(HnSItemRegistry.CHLOROPHYTE_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.CHLOROPHYTE_LEGGINGS.get());
                        output.accept(HnSItemRegistry.CHLOROPHYTE_BOOTS.get());

                        /*
                        *** Blood
                         */

                        // Flesh Mass
                        output.accept(HnSItemRegistry.FLESH_MASS_HELMET.get());
                        output.accept(HnSItemRegistry.FLESH_MASS_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.FLESH_MASS_LEGGINGS.get());
                        output.accept(HnSItemRegistry.FLESH_MASS_BOOTS.get());

                        // The Wither
                        output.accept(HnSItemRegistry.THE_WITHER_HELMET.get());
                        output.accept(HnSItemRegistry.THE_WITHER_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.THE_WITHER_LEGGINGS.get());
                        output.accept(HnSItemRegistry.THE_WITHER_BOOTS.get());

                        /*
                        *** Ender
                         */

                        // Ender Dragon
                        output.accept(HnSItemRegistry.ENDER_DRAGON_HELMET.get());
                        output.accept(HnSItemRegistry.ENDER_DRAGON_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.ENDER_DRAGON_LEGGINGS.get());
                        output.accept(HnSItemRegistry.ENDER_DRAGON_BOOTS.get());

                        /*
                        *** Holy
                         */

                        // Seraph
                        output.accept(HnSItemRegistry.SERAPH_HELMET.get());
                        output.accept(HnSItemRegistry.SERAPH_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.SERAPH_LEGGINGS.get());
                        output.accept(HnSItemRegistry.SERAPH_BOOTS.get());

                        // Mothic Witch
                        output.accept(HnSItemRegistry.MOTHIC_WITCH_HELMET.get());
                        output.accept(HnSItemRegistry.MOTHIC_WITCH_CHESTPLATE.get());
                        //output.accept(HnSItemRegistry.MOTHIC_WITCH_SECRET_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.MOTHIC_WITCH_LEGGINGS.get());
                        output.accept(HnSItemRegistry.MOTHIC_WITCH_BOOTS.get());

                        // Gabriel Ultrakill
                        output.accept(HnSItemRegistry.GABRIEL_ULTRAKILL_HELMET.get());
                        output.accept(HnSItemRegistry.GABRIEL_ULTRAKILL_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.GABRIEL_ULTRAKILL_LEGGINGS.get());
                        output.accept(HnSItemRegistry.GABRIEL_ULTRAKILL_BOOTS.get());

                        /*
                        *** Evocation
                         */

                        // Supreme Witch
                        output.accept(HnSItemRegistry.SUPREME_WITCH_HELMET.get());
                        output.accept(HnSItemRegistry.SUPREME_WITCH_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.SUPREME_WITCH_LEGGINGS.get());
                        output.accept(HnSItemRegistry.SUPREME_WITCH_BOOTS.get());

                        // Alchemist Supreme
                        output.accept(HnSItemRegistry.ALCHEMIST_SUPREME_HELMET.get());
                        output.accept(HnSItemRegistry.ALCHEMIST_SUPREME_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.ALCHEMIST_SUPREME_LEGGINGS.get());
                        output.accept(HnSItemRegistry.ALCHEMIST_SUPREME_BOOTS.get());

                        /*
                        *** Radiance
                         */



                        // Mycelium Guardian
                        output.accept(HnSItemRegistry.MYCELIUM_GUARDIAN_HELMET.get());
                        output.accept(HnSItemRegistry.MYCELIUM_GUARDIAN_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.MYCELIUM_GUARDIAN_LEGGINGS.get());
                        output.accept(HnSItemRegistry.MYCELIUM_GUARDIAN_BOOTS.get());



                        /*
                         *** Shadow
                         */


                        // Shadow Scale
                        output.accept(HnSItemRegistry.SHADOW_SCALE_HELMET.get());
                        output.accept(HnSItemRegistry.SHADOW_SCALE_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.SHADOW_SCALE_LEGGINGS.get());
                        output.accept(HnSItemRegistry.SHADOW_SCALE_BOOTS.get());

                        /*
                         *** Eldritch
                         */

                        // Dark Ritual Templar
                        output.accept(HnSItemRegistry.DARK_RITUAL_TEMPLAR_HELMET.get());
                        output.accept(HnSItemRegistry.DARK_RITUAL_TEMPLAR_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.DARK_RITUAL_TEMPLAR_LEGGINGS.get());
                        output.accept(HnSItemRegistry.DARK_RITUAL_TEMPLAR_BOOTS.get());

                        // Infestation
                        output.accept(HnSItemRegistry.INFESTATION_HELMET.get());
                        output.accept(HnSItemRegistry.INFESTATION_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.INFESTATION_LEGGINGS.get());
                        output.accept(HnSItemRegistry.INFESTATION_BOOTS.get());

                        /*
                         *** Pyrium
                         */


                        // Pyrium
                        output.accept(HnSItemRegistry.PYRIUM_HELMET.get());
                        output.accept(HnSItemRegistry.PYRIUM_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.PYRIUM_LEGGINGS.get());
                        output.accept(HnSItemRegistry.PYRIUM_BOOTS.get());

                        // Legionnaire
                        output.accept(HnSItemRegistry.LEGACY_LEGIONNAIRE_HELMET.get());
                        output.accept(HnSItemRegistry.LEGACY_LEGIONNAIRE_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.LEGACY_LEGIONNAIRE_LEGGINGS.get());
                        output.accept(HnSItemRegistry.LEGACY_LEGIONNAIRE_BOOTS.get());

                        // Legionnaire Ruler
                        output.accept(HnSItemRegistry.LEGIONNAIRE_RULER_HELMET.get());
                        output.accept(HnSItemRegistry.LEGIONNAIRE_RULER_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.LEGIONNAIRE_RULER_LEGGINGS.get());
                        output.accept(HnSItemRegistry.LEGIONNAIRE_RULER_BOOTS.get());

                        // Legionnaire Ruler Soul
                        output.accept(HnSItemRegistry.SOUL_LEGIONNAIRE_RULER_HELMET.get());
                        output.accept(HnSItemRegistry.SOUL_LEGIONNAIRE_RULER_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.SOUL_LEGIONNAIRE_RULER_LEGGINGS.get());
                        output.accept(HnSItemRegistry.SOUL_LEGIONNAIRE_RULER_BOOTS.get());

                        // Legionnaire Commander
                        output.accept(HnSItemRegistry.LEGIONNAIRE_COMMANDER_HELMET.get());
                        output.accept(HnSItemRegistry.LEGIONNAIRE_COMMANDER_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.LEGIONNAIRE_COMMANDER_LEGGINGS.get());
                        output.accept(HnSItemRegistry.LEGIONNAIRE_COMMANDER_BOOTS.get());

                        // Legionnaire Battlemage
                        output.accept(HnSItemRegistry.PYRIUM_BATTLEMAGE_HELMET.get());
                        output.accept(HnSItemRegistry.PYRIUM_BATTLEMAGE_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.PYRIUM_BATTLEMAGE_LEGGINGS.get());
                        output.accept(HnSItemRegistry.PYRIUM_BATTLEMAGE_BOOTS.get());

                        // Tyros
                        output.accept(HnSItemRegistry.TYROS_HELMET.get());
                        output.accept(HnSItemRegistry.TYROS_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.TYROS_LEGGINGS.get());
                        output.accept(HnSItemRegistry.TYROS_BOOTS.get());

                        // Tyros Soul
                        output.accept(HnSItemRegistry.TYROS_SOUL_HELMET.get());
                        output.accept(HnSItemRegistry.TYROS_SOUL_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.TYROS_SOUL_LEGGINGS.get());
                        output.accept(HnSItemRegistry.TYROS_SOUL_BOOTS.get());


                        /*
                         *** Cosmetic Battlemage
                         */

                        // Frieren
                        output.accept(HnSItemRegistry.FRIEREN_HELMET.get());
                        output.accept(HnSItemRegistry.FRIEREN_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.FRIEREN_LEGGINGS.get());
                        output.accept(HnSItemRegistry.FRIEREN_BOOTS.get());

                        // Synthesizer V
                        output.accept(HnSItemRegistry.SYNTHESIZER_V_HELMET.get());
                        output.accept(HnSItemRegistry.SYNTHESIZER_V_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.SYNTHESIZER_V_LEGGINGS.get());
                        output.accept(HnSItemRegistry.SYNTHESIZER_V_BOOTS.get());

                        // Utau
                        output.accept(HnSItemRegistry.UTAU_HELMET.get());
                        output.accept(HnSItemRegistry.UTAU_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.UTAU_LEGGINGS.get());
                        output.accept(HnSItemRegistry.UTAU_BOOTS.get());

                        // Project Sekai
                        output.accept(HnSItemRegistry.PROJECT_SEKAI_HELMET.get());
                        output.accept(HnSItemRegistry.PROJECT_SEKAI_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.PROJECT_SEKAI_LEGGINGS.get());
                        output.accept(HnSItemRegistry.PROJECT_SEKAI_BOOTS.get());

                        // Rotten Girl
                        output.accept(HnSItemRegistry.ROTTEN_GIRL_HELMET.get());
                        output.accept(HnSItemRegistry.ROTTEN_GIRL_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.ROTTEN_GIRL_LEGGINGS.get());
                        output.accept(HnSItemRegistry.ROTTEN_GIRL_BOOTS.get());

                        // Neru
                        output.accept(HnSItemRegistry.NERU_HELMET.get());
                        output.accept(HnSItemRegistry.NERU_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.NERU_LEGGINGS.get());
                        output.accept(HnSItemRegistry.NERU_BOOTS.get());

                        // Giorno Giovanna
                        output.accept(HnSItemRegistry.GIORNO_GIOVANNA_HELMET.get());
                        output.accept(HnSItemRegistry.GIORNO_GIOVANNA_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.GIORNO_GIOVANNA_LEGGINGS.get());
                        output.accept(HnSItemRegistry.GIORNO_GIOVANNA_BOOTS.get());


                        /*
                        *** Mining Armor Sets
                         */

                        // Miner
                        output.accept(HnSItemRegistry.MINER_HELMET.get());
                        output.accept(HnSItemRegistry.MINER_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.MINER_LEGGINGS.get());
                        output.accept(HnSItemRegistry.MINER_BOOTS.get());

                        // Spectral Spelunker
                        output.accept(HnSItemRegistry.SPECTRAL_SPELUNKER_HELMET.get());
                        output.accept(HnSItemRegistry.SPECTRAL_SPELUNKER_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.SPECTRAL_SPELUNKER_LEGGINGS.get());
                        output.accept(HnSItemRegistry.SPECTRAL_SPELUNKER_BOOTS.get());



                        /*
                        *** Melee Armor Sets
                         */



                        // Frostbite Knight
                        output.accept(HnSItemRegistry.FROSTBITE_KNIGHT_HELMET.get());
                        output.accept(HnSItemRegistry.FROSTBITE_KNIGHT_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.FROSTBITE_KNIGHT_LEGGINGS.get());
                        output.accept(HnSItemRegistry.FROSTBITE_KNIGHT_BOOTS.get());

                        // Frostbite Knight
                        output.accept(HnSItemRegistry.DREADSTEEL_KNIGHT_HELMET.get());
                        output.accept(HnSItemRegistry.DREADSTEEL_KNIGHT_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.DREADSTEEL_KNIGHT_LEGGINGS.get());
                        output.accept(HnSItemRegistry.DREADSTEEL_KNIGHT_BOOTS.get());



                        /*
                         *** Archer Armor Sets
                         */



                        // Bounty Hunter
                        output.accept(HnSItemRegistry.BOUNTY_HUNTER_HELMET.get());
                        output.accept(HnSItemRegistry.BOUNTY_HUNTER_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.BOUNTY_HUNTER_LEGGINGS.get());
                        output.accept(HnSItemRegistry.BOUNTY_HUNTER_BOOTS.get());

                        // Frostbite Hunter
                        output.accept(HnSItemRegistry.FROSTBITE_HUNTER_HELMET.get());
                        output.accept(HnSItemRegistry.FROSTBITE_HUNTER_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.FROSTBITE_HUNTER_LEGGINGS.get());
                        output.accept(HnSItemRegistry.FROSTBITE_HUNTER_BOOTS.get());

                        // Permafrost Prince
                        output.accept(HnSItemRegistry.PERMAFROST_PRINCE_HELMET.get());
                        output.accept(HnSItemRegistry.PERMAFROST_PRINCE_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.PERMAFROST_PRINCE_LEGGINGS.get());
                        output.accept(HnSItemRegistry.PERMAFROST_PRINCE_BOOTS.get());



                        /*
                        *** Misc
                         */



                        // Magehunter
                        output.accept(HnSItemRegistry.MAGEHUNTER_HELMET.get());
                        output.accept(HnSItemRegistry.MAGEHUNTER_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.MAGEHUNTER_LEGGINGS.get());
                        output.accept(HnSItemRegistry.MAGEHUNTER_BOOTS.get());

                        // Mithril Battlemage
                        output.accept(HnSItemRegistry.MITHRIL_BATTLEMAGE_HELMET.get());
                        output.accept(HnSItemRegistry.MITHRIL_BATTLEMAGE_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.MITHRIL_BATTLEMAGE_LEGGINGS.get());
                        output.accept(HnSItemRegistry.MITHRIL_BATTLEMAGE_BOOTS.get());


                        /*
                         *** Tribute Armor Sets
                         */


                        // Fireblossom
                        output.accept(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CROWN.get());
                        output.accept(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_HELMET.get());
                        output.accept(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get());
                        output.accept(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get());

                        // Arbitrium Robes
                        output.accept(HnSItemRegistry.ARBITRIUM_ROBES_HELMET.get());
                        output.accept(HnSItemRegistry.ARBITRIUM_ROBES_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.ARBITRIUM_ROBES_LEGGINGS.get());
                        output.accept(HnSItemRegistry.ARBITRIUM_ROBES_BOOTS.get());

                        output.accept(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_HELMET.get());
                        output.accept(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get());
                        output.accept(HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_BOOTS.get());

                        // Atlas
                        output.accept(HnSItemRegistry.ATLAS_HELMET.get());
                        output.accept(HnSItemRegistry.ATLAS_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.ATLAS_LEGGINGS.get());
                        output.accept(HnSItemRegistry.ATLAS_BOOTS.get());

                        // Maverick
                        output.accept(HnSItemRegistry.MAVERICK_HELMET.get());
                        output.accept(HnSItemRegistry.MAVERICK_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.MAVERICK_LEGGINGS.get());
                        output.accept(HnSItemRegistry.MAVERICK_BOOTS.get());

                        // SLC!Cat
                        output.accept(HnSItemRegistry.SLC_CAT_HELMET.get());
                        output.accept(HnSItemRegistry.SLC_CAT_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.SLC_CAT_LEGGINGS.get());
                        output.accept(HnSItemRegistry.SLC_CAT_BOOTS.get());

                        // Abberant Predator
                        output.accept(HnSItemRegistry.ABBERANT_PREDATOR_HELMET.get());
                        output.accept(HnSItemRegistry.ABBERANT_PREDATOR_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.ABBERANT_PREDATOR_LEGGINGS.get());
                        output.accept(HnSItemRegistry.ABBERANT_PREDATOR_BOOTS.get());

                        // Iron 431
                        output.accept(HnSItemRegistry.IRON431_HELMET.get());
                        output.accept(HnSItemRegistry.IRON431_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.IRON431_LEGGINGS.get());
                        output.accept(HnSItemRegistry.IRON431_BOOTS.get());

                        // Ascended Iron 431
                        output.accept(HnSItemRegistry.ASCENDED_IRON431_HELMET.get());
                        output.accept(HnSItemRegistry.ASCENDED_IRON431_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.ASCENDED_IRON431_LEGGINGS.get());
                        output.accept(HnSItemRegistry.ASCENDED_IRON431_BOOTS.get());

                        // Sacred Robes
                        output.accept(HnSItemRegistry.SACRED_ROBES_HELMET.get());
                        output.accept(HnSItemRegistry.SACRED_ROBES_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.SACRED_ROBES_LEGGINGS.get());
                        output.accept(HnSItemRegistry.SACRED_ROBES_BOOTS.get());

                        // Ascended Sacred Robes
                        output.accept(HnSItemRegistry.ASCENDED_SACRED_ROBES_HELMET.get());
                        output.accept(HnSItemRegistry.ASCENDED_SACRED_ROBES_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.ASCENDED_SACRED_ROBES_LEGGINGS.get());
                        output.accept(HnSItemRegistry.ASCENDED_SACRED_ROBES_BOOTS.get());

                        // Lemon God
                        output.accept(HnSItemRegistry.LEMON_GOD_HELMET.get());
                        output.accept(HnSItemRegistry.LEMON_GOD_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.LEMON_GOD_LEGGINGS.get());
                        output.accept(HnSItemRegistry.LEMON_GOD_BOOTS.get());

                        // Ascended Lemon God
                        output.accept(HnSItemRegistry.ASCENDED_LEMON_GOD_HELMET.get());
                        output.accept(HnSItemRegistry.ASCENDED_LEMON_GOD_CHESTPLATE.get());
                        output.accept(HnSItemRegistry.ASCENDED_LEMON_GOD_LEGGINGS.get());
                        output.accept(HnSItemRegistry.ASCENDED_LEMON_GOD_BOOTS.get());

                    }).build());

    public static final Supplier<CreativeModeTab> HAZEN_N_STUFF_UTILITY = CREATIVE_MODE_TAB.register("hazennstuff_utility",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(HnSItemRegistry.RADIANCE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "hazennstuff_equipment"))
                    .title(Component.translatable("creativetab.hazennstuff.hazennstuff_utility"))
                    .displayItems((itemDisplayParameters, output) -> {

                        /*
                        *** Weapons
                         */


                        //Fire


                        //Fireblossom Rapier
                        output.accept(HnSItemRegistry.FIREBLOSSOM_RAPIER.get());
                        //Fire Brand
                        output.accept(HnSItemRegistry.FIREBRAND.get());
                        //Draconic Splitter
                        output.accept(HnSItemRegistry.DRACONIC_SPLITTER.get());
                        //Ravens Bane
                        output.accept(HnSItemRegistry.RAVENS_BANE.get());
                        // War-Flaming Lance
                        output.accept(HnSItemRegistry.WARFLAMING_LANCE.get());
                        // Volcano
                        output.accept(HnSItemRegistry.VOLCANO.get());


                        //Ice


                        //Ice Pike
                        output.accept(HnSItemRegistry.ICE_PIKE.get());
                        // Frostburn Dagger
                        output.accept(HnSItemRegistry.FROSTBURN_DAGGER.get());


                        //Lightning


                        //Beongae
                        output.accept(HnSItemRegistry.BEONGAE.get());
                        //Skyscorcher
                        output.accept(HnSItemRegistry.SKYSCORCHER.get());

                        /*
                        Ionic Splitter
                         */
                        output.accept(HnSItemRegistry.IONIC_SPLITTER_DORMANT.get());
                        output.accept(HnSItemRegistry.IONIC_SPLITTER_T1.get());
                        output.accept(HnSItemRegistry.IONIC_SPLITTER_T2.get());
                        output.accept(HnSItemRegistry.IONIC_SPLITTER_T3.get());


                        //Nature


                        //Bountiful Harvest
                        output.accept(HnSItemRegistry.BOUNTIFUL_HARVEST.get());
                        //Thorn Chakram
                        output.accept(HnSItemRegistry.THORN_CHAKRAM.get());
                        //Blade of Grass
                        output.accept(HnSItemRegistry.BLADE_OF_GRASS.get());

                        /*
                        *** O' Fortuna
                         */
                        output.accept(HnSItemRegistry.O_FORTUNA_DORMANT.get());


                        //Blood


                        //Vampire Knives
                        output.accept(HnSItemRegistry.VAMPIRE_KNIVES.get());

                        /*
                        *** Devastator
                         */
                        output.accept(HnSItemRegistry.DEVASTATOR_DORMANT.get());


                        //Ender


                        // Obsidian Claymore
                        output.accept(HnSItemRegistry.OBSIDIAN_CLAYMORE.get());
                        // Star Fury
                        output.accept(HnSItemRegistry.STARFURY.get());

                        /*
                        *** Umbranova
                         */
                        output.accept(HnSItemRegistry.UMBRANOVA_DORMANT.get());


                        //Holy


                        // Hammer of Justice
                        output.accept(HnSItemRegistry.HAMMER_OF_JUSTICE.get());
                        // Excalibur
                        output.accept(HnSItemRegistry.EXCALIBUR.get());
                        // Excalibur Divine Gold
                        output.accept(HnSItemRegistry.ISS_EXCALIBUR.get());
                        // Hazen's Excalibur
                        output.accept(HnSItemRegistry.HAZENS_EXCALIBUR.get());
                        // Divine Greatsword
                        output.accept(HnSItemRegistry.DIVINE_GREATSWORD.get());


                        //Radiance


                        //Hammush
                        output.accept(HnSItemRegistry.HAMMUSH.get());
                        //Meowmere
                        output.accept(HnSItemRegistry.MEOWMERE.get());
                        //Spectrum
                        output.accept(HnSItemRegistry.SPECTRUM.get());
                        //Terraprisma
                        output.accept(HnSItemRegistry.TERRAPRISMA.get());


                        //Evocation


                        //Ancient Warriors Axe
                        output.accept(HnSItemRegistry.ANCIENT_WARRIORS_AXE.get());
                        //Malice
                        output.accept(HnSItemRegistry.MALICE.get());

                        /*
                        *** Provocation
                         */
                        output.accept(HnSItemRegistry.PROVOCATION_DORMANT.get());


                        //Shadow


                        //Lights Bane
                        output.accept(HnSItemRegistry.LIGHTS_BANE.get());
                        //Nights Edge
                        output.accept(HnSItemRegistry.NIGHTS_EDGE.get());
                        //True Nights Edge
                        output.accept(HnSItemRegistry.TRUE_NIGHTS_EDGE.get());


                        //Eldritch


                        //The Devourer
                        output.accept(HnSItemRegistry.THE_DEVOURER.get());


                        //Misc


                        //Mage Bane
                        output.accept(HnSItemRegistry.MAGE_BANE.get());

                        //Legionnaire Warlock Axe
                        output.accept(HnSItemRegistry.LEGIONNAIRE_WARLOCK_AXE.get());

                        //Flame Reaver
                        output.accept(HnSItemRegistry.DAWNMAKER.get());

                        //Muramasa
                        output.accept(HnSItemRegistry.MURAMASA.get());


                        /*
                        ***Staves
                         */

                        //Wisewood Cane
                        output.accept(HnSItemRegistry.WISEWOOD_CANE.get());

                        //Frieren Staff
                        output.accept(HnSItemRegistry.FRIEREN_STAFF.get());

                        //Rod of Discord
                        output.accept(HnSItemRegistry.ROD_OF_DISCORD.get());

                        //White Lily Staff
                        output.accept(HnSItemRegistry.WHITE_LILY_STAFF.get());

                        //Soulcalling Scepter
                        output.accept(HnSItemRegistry.SOULCALLING_SCEPTER.get());

                        //Enderconic Scepter
                        output.accept(HnSItemRegistry.ENDERCONIC_SCEPTER.get());

                        //Blossom of the Enchantress
                        output.accept(HnSItemRegistry.BLOSSOM_OF_THE_ENCHANTRESS.get());

                        //Grimoire Staff
                        output.accept(HnSItemRegistry.GRIMOIRE_STAFF.get());

                        //Divine Scepter
                        output.accept(HnSItemRegistry.DIVINE_SCEPTER.get());

                        //Insania Aeternus
                        output.accept(HnSItemRegistry.INSANIA_AETERNUS.get());


                        /*
                        *** Tools
                         */

                        //Pickaxes
                        output.accept(HnSItemRegistry.SPECTRAL_PICKAXE.get());
                        output.accept(HnSItemRegistry.PICKAXE_AXE.get());
                        output.accept(HnSItemRegistry.PICKAXE_AXE_DIVINE_GOLD.get());

                        /*
                        ***Curios
                         */

                        //Mana Crystals
                        output.accept(HnSItemRegistry.RUPTURED.get());
                        output.accept(HnSItemRegistry.REFINED.get());
                        output.accept(HnSItemRegistry.REINFORCED.get());
                        output.accept(HnSItemRegistry.RADIANCE.get());

                        //Life Crystals
                        output.accept(HnSItemRegistry.SHATTERED.get());
                        output.accept(HnSItemRegistry.SACRED.get());
                        output.accept(HnSItemRegistry.STRENGTHENED.get());
                        output.accept(HnSItemRegistry.SINGULARITY.get());

                        //Soul Crystals
                        output.accept(HnSItemRegistry.ABSTRACT.get());
                        output.accept(HnSItemRegistry.ADVANCED.get());
                        output.accept(HnSItemRegistry.ABOMINATION.get());
                        output.accept(HnSItemRegistry.ABSOLUTE.get());

                        //Spellbooks
                        output.accept(HnSItemRegistry.GOLDEN_SHOWER_SPELLBOOK.get());
                        output.accept(HnSItemRegistry.ENERGIZED_CORE_SPELLBOOK.get());

                        //Sheath
                        output.accept(HnSItemRegistry.GALVANIZED_SHEATH.get());
                        output.accept(HnSItemRegistry.SCROLL_SHEATH.get());

                        //Wings
                        output.accept(HnSItemRegistry.ARBITRIUM_WINGS.get());

                        // Cinderous Curios
                        output.accept(HnSItemRegistry.BLADE_OF_THE_LEGATE.get());
                        output.accept(HnSItemRegistry.THE_PREFECTS_RING.get());
                        output.accept(HnSItemRegistry.THE_TRIBUNES_MEDALLION.get());

                        //Misc
                        output.accept(HnSItemRegistry.RING_OF_EFFICIENCY.get());




                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
