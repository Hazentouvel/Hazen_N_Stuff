package net.hazen.hazennstuff.registries;

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
                        output.accept(HnSItems.ZENALITE_INGOT);
                        output.accept(HnSItems.RAW_ZENALITE);
                        output.accept(HnSItems.STARKISSED_ZENALITE);
                        output.accept(HnSItems.DIVINE_MOLD);
                        output.accept(HnSItems.SILVER_SCRAPS);
                        output.accept(HnSItems.EXCALIBUR_FRAGMENT);
                        output.accept(HnSItems.FLAMING_TEMPLATE);
                        output.accept(HnSItems.DEUS_ESSENCE);
                        output.accept(HnSItems.RUNESTONE_FRAGMENTS);
                        output.accept(HnSItems.PERMAFROST_FRAGMENT);
                        output.accept(HnSItems.OVERGROWN_BONE);
                        output.accept(HnSItems.CHARRED_BONES);
                        output.accept(HnSItems.PYRIUM_NUGGET);
                        output.accept(HnSItems.LUMINESCENT_UPGRADE_ORB.get());
                        output.accept(HnSItems.ARCHERY_UPGRADE_ORB.get());
                        output.accept(HnSItems.HnSBlocks.FIREBLOSSOM);
                    }).build());

    public static final Supplier<CreativeModeTab> HAZEN_N_STUFF_BLOCKS = CREATIVE_MODE_TAB.register("hazennstuff_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(HnSItems.HnSBlocks.WISEWOOD_PLANK.get()))
                    .title(Component.translatable("creativetab.hazennstuff.hazennstuff_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {

                        //Compact Blocks
                        output.accept(HnSItems.HnSBlocks.ZENALITE_BLOCK);
                        output.accept(HnSItems.HnSBlocks.PYRIUM_BLOCK);
                        output.accept(HnSItems.HnSBlocks.MITHRIL_BLOCK);
                        output.accept(HnSItems.HnSBlocks.ARCANE_STEEL_BLOCK);


                        //Zenalite Set
                        output.accept(HnSItems.HnSBlocks.ZENALITE_BRICKS);
                        output.accept(HnSItems.HnSBlocks.ZENALITE_SLAB);
                        output.accept(HnSItems.HnSBlocks.ZENALITE_STAIRS);


                        //Ore
                        output.accept(HnSItems.HnSBlocks.ZENALITE_DEEPSLATE_ORE);
                        output.accept(HnSItems.HnSBlocks.ZENALITE_STONE_ORE);
                        output.accept(HnSItems.HnSBlocks.ZENALITE_ABYSSLATE_ORE);
                        output.accept(HnSItems.HnSBlocks.ZENALITE_VOIDSTONE_ORE);

                        //Overworld Blocks
                        output.accept(HnSItems.HnSBlocks.RUNESTONE_SLAG);
                        output.accept(HnSItems.HnSBlocks.AQUASTONE);

                        //Nether Blocks

                        //End Blocks
                        output.accept(HnSItems.HnSBlocks.ABYSSLATE);
                        output.accept(HnSItems.HnSBlocks.PHANTASMIUM);
                        output.accept(HnSItems.HnSBlocks.COBBLED_VOIDSTONE);
                        output.accept(HnSItems.HnSBlocks.VOIDSTONE);

                        //Wisewood Set
                        output.accept(HnSItems.HnSBlocks.WISEWOOD_PLANK);
                        output.accept(HnSItems.HnSBlocks.WISEWOOD_DOOR);
                        output.accept(HnSItems.HnSBlocks.WISEWOOD_TRAPDOOR);
                        output.accept(HnSItems.HnSBlocks.WISEWOOD_SLAB);
                        output.accept(HnSItems.HnSBlocks.WISEWOOD_FENCE);
                        output.accept(HnSItems.HnSBlocks.WISEWOOD_FENCE_GATE);
                        output.accept(HnSItems.HnSBlocks.WISEWOOD_STAIRS);
                        output.accept(HnSItems.HnSBlocks.WISEWOOD_LEAVES);
                        output.accept(HnSItems.HnSBlocks.WISEWOOD_LOG);
                        output.accept(HnSItems.HnSBlocks.WISEWOOD_WOOD);
                        output.accept(HnSItems.HnSBlocks.STRIPPED_WISEWOOD_LOG);
                        output.accept(HnSItems.HnSBlocks.STRIPPED_WISEWOOD_WOOD);
                    }).build());

    public static final Supplier<CreativeModeTab> HAZEN_N_STUFF_EQUIPMENT = CREATIVE_MODE_TAB.register("hazennstuff_equipment",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(HnSItems.CALAMITAS_HELMET.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "hazennstuff_materials"))
                    .title(Component.translatable("creativetab.hazennstuff.hazennstuff_equipment"))
                    .displayItems((itemDisplayParameters, output) -> {
                        // Creaking
                        output.accept(HnSItems.CREAKING_HELMET.get());
                        output.accept(HnSItems.CREAKING_CHESTPLATE.get());
                        output.accept(HnSItems.CREAKING_LEGGINGS.get());
                        output.accept(HnSItems.CREAKING_BOOTS.get());
                        // Legionnaire
                        output.accept(HnSItems.LEGIONNAIRE_HELMET.get());
                        output.accept(HnSItems.LEGIONNAIRE_CHESTPLATE.get());
                        output.accept(HnSItems.LEGIONNAIRE_LEGGINGS.get());
                        output.accept(HnSItems.LEGIONNAIRE_BOOTS.get());
                        // Seraph
                        output.accept(HnSItems.SERAPH_HELMET.get());
                        output.accept(HnSItems.SERAPH_CHESTPLATE.get());
                        output.accept(HnSItems.SERAPH_LEGGINGS.get());
                        output.accept(HnSItems.SERAPH_BOOTS.get());
                        // Scourge
                        output.accept(HnSItems.CHARGED_SCOURGE_HELMET.get());
                        output.accept(HnSItems.CHARGED_SCOURGE_CHESTPLATE.get());
                        output.accept(HnSItems.CHARGED_SCOURGE_LEGGINGS.get());
                        output.accept(HnSItems.CHARGED_SCOURGE_BOOTS.get());
                        // Soul Flamed
                        output.accept(HnSItems.SOUL_FLAME_HELMET.get());
                        output.accept(HnSItems.SOUL_FLAME_CHESTPLATE.get());
                        output.accept(HnSItems.SOUL_FLAME_LEGGINGS.get());
                        output.accept(HnSItems.SOUL_FLAME_BOOTS.get());
                        // Supreme Witch
                        output.accept(HnSItems.SUPREME_WITCH_HELMET.get());
                        output.accept(HnSItems.SUPREME_WITCH_CHESTPLATE.get());
                        output.accept(HnSItems.SUPREME_WITCH_LEGGINGS.get());
                        output.accept(HnSItems.SUPREME_WITCH_BOOTS.get());
                        // Cryogenic Ruler
                        output.accept(HnSItems.CRYOGENIC_RULER_HELMET.get());
                        output.accept(HnSItems.CRYOGENIC_RULER_CHESTPLATE.get());
                        output.accept(HnSItems.CRYOGENIC_RULER_LEGGINGS.get());
                        output.accept(HnSItems.CRYOGENIC_RULER_BOOTS.get());
                        // Flesh Mass
                        output.accept(HnSItems.FLESH_MASS_HELMET.get());
                        output.accept(HnSItems.FLESH_MASS_CHESTPLATE.get());
                        output.accept(HnSItems.FLESH_MASS_LEGGINGS.get());
                        output.accept(HnSItems.FLESH_MASS_BOOTS.get());
                        // Ender Dragon
                        output.accept(HnSItems.ENDER_DRAGON_HELMET.get());
                        output.accept(HnSItems.ENDER_DRAGON_CHESTPLATE.get());
                        output.accept(HnSItems.ENDER_DRAGON_LEGGINGS.get());
                        output.accept(HnSItems.ENDER_DRAGON_BOOTS.get());
                        // Dark Ritual Templar
                        output.accept(HnSItems.DARK_RITUAL_TEMPLAR_HELMET.get());
                        output.accept(HnSItems.DARK_RITUAL_TEMPLAR_CHESTPLATE.get());
                        output.accept(HnSItems.DARK_RITUAL_TEMPLAR_LEGGINGS.get());
                        output.accept(HnSItems.DARK_RITUAL_TEMPLAR_BOOTS.get());
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
                        // Fireblossom
                        output.accept(HnSItems.FIREBLOSSOM_BATTLEMAGE_CROWN.get());
                        output.accept(HnSItems.FIREBLOSSOM_BATTLEMAGE_HELMET.get());
                        output.accept(HnSItems.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get());
                        output.accept(HnSItems.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get());
                        output.accept(HnSItems.FIREBLOSSOM_BATTLEMAGE_BOOTS.get());
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
                        // Arbitrium Robes
                        output.accept(HnSItems.ARBITRIUM_ROBES_HELMET.get());
                        output.accept(HnSItems.ARBITRIUM_ROBES_CHESTPLATE.get());
                        output.accept(HnSItems.ARBITRIUM_ROBES_LEGGINGS.get());
                        output.accept(HnSItems.ARBITRIUM_ROBES_BOOTS.get());
                        // Atlas
                        output.accept(HnSItems.ATLAS_HELMET.get());
                        output.accept(HnSItems.ATLAS_CHESTPLATE.get());
                        output.accept(HnSItems.ATLAS_LEGGINGS.get());
                        output.accept(HnSItems.ATLAS_BOOTS.get());
                        // Calamitas
                        output.accept(HnSItems.CALAMITAS_HELMET.get());
                        output.accept(HnSItems.CALAMITAS_CHESTPLATE.get());
                        output.accept(HnSItems.CALAMITAS_LEGGINGS.get());
                        output.accept(HnSItems.CALAMITAS_BOOTS.get());
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
                    }).build());

    public static final Supplier<CreativeModeTab> HAZEN_N_STUFF_UTILITY = CREATIVE_MODE_TAB.register("hazennstuff_utility",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(HnSItems.RADIANCE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "hazennstuff_equipment"))
                    .title(Component.translatable("creativetab.hazennstuff.hazennstuff_utility"))
                    .displayItems((itemDisplayParameters, output) -> {

                        //Weapons


                        //Fireblossom Rapier
                        output.accept(HnSItems.FIREBLOSSOM_RAPIER.get());
                        //Beongae
                        output.accept(HnSItems.BEONGAE.get());
                        //Ancient Warriors Axe
                        output.accept(HnSItems.ANCIENT_WARRIORS_AXE.get());
                        //Ice Pike
                        output.accept(HnSItems.ICE_PIKE.get());
                        //Skyscorcher
                        output.accept(HnSItems.SKYSCORCHER.get());
                        //Bountiful Harvest
                        output.accept(HnSItems.BOUNTIFUL_HARVEST.get());
                        //Starfury
                        output.accept(HnSItems.STARFURY.get());
                        //Hammer of Justince
                        output.accept(HnSItems.HAMMER_OF_JUSTICE.get());
                        //Lights Bane
                        output.accept(HnSItems.LIGHTS_BANE.get());
                        //Night's Edge
                        output.accept(HnSItems.NIGHTS_EDGE.get());
                        //True Night's Edge
                        output.accept(HnSItems.TRUE_NIGHTS_EDGE.get());
                        //Vampire Knives
                        output.accept(HnSItems.VAMPIRE_KNIVES.get());


                        //Staves

                        //Wisewood Cane
                        output.accept(HnSItems.WISEWOOD_CANE.get());
                        //Frieren Staff
                        output.accept(HnSItems.FRIEREN_STAFF.get());
                        //Frieren Staff
                        output.accept(HnSItems.ROD_OF_DISCORD.get());


                        //Curios
                        output.accept(HnSItems.RUPTURED.get());
                        output.accept(HnSItems.REFINED.get());
                        output.accept(HnSItems.REINFORCED.get());
                        output.accept(HnSItems.RADIANCE.get());


                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
