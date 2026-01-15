package net.hazen.hazennstuff.Datagen.ItemGenerator;

import net.hazen.hazennstuff.Item.Block.HnSBlocks;
import net.hazen.hazennstuff.Datagen.HnSTags;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class HnSBlockTagProvider extends BlockTagsProvider {
    public HnSBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, HazenNStuff.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        //Mining Tags
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(HnSBlocks.ZENALITE_ABYSSLATE_ORE.get())
                .add(HnSBlocks.ZENALITE_DEEPSLATE_ORE.get())
                .add(HnSBlocks.ZENALITE_STONE_ORE.get())
                .add(HnSBlocks.ZENALITE_END_STONE_ORE.get())
                .add(HnSBlocks.SOLAR_CORE_BLACKSTONE_ORE.get())
                .add(HnSBlocks.SOLAR_CORE_NETHERACK_ORE.get())
                .add(HnSBlocks.DREADSTONE_ORE.get())
                .add(HnSBlocks.CHLOROPHYTE_ORE.get())

                .add(HnSBlocks.ZENALITE_BLOCK.get())
                .add(HnSBlocks.ARCANE_STEEL_BLOCK.get())
                .add(HnSBlocks.MITHRIL_BLOCK.get())
                .add(HnSBlocks.PYRIUM_BLOCK.get())


                .add(HnSBlocks.ZENALITE_BRICK_SLAB.get())
                .add(HnSBlocks.ZENALITE_BRICK_STAIRS.get())
                .add(HnSBlocks.ZENALITE_BRICKS.get())
                .add(HnSBlocks.ZENALITE_BRICK_WALL.get())


                .add(HnSBlocks.AQUASTONE.get())
                .add(HnSBlocks.ABYSSLATE.get())
                .add(HnSBlocks.VOIDSTONE.get())

                .add(HnSBlocks.MOSSY_MUD_BRICKS.get())
                .add(HnSBlocks.MOSSY_MUD_BRICK_STAIRS.get())
                .add(HnSBlocks.MOSSY_MUD_BRICK_SLAB.get())
                .add(HnSBlocks.MOSSY_MUD_BRICK_WALL.get())

                .add(HnSBlocks.RUNESTONE_SLAG.get())
        ;

        tag(BlockTags.MINEABLE_WITH_AXE)

                .add(HnSBlocks.WISEWOOD_PLANKS.get())
                .add(HnSBlocks.WISEWOOD_LOG.get())
                .add(HnSBlocks.STRIPPED_WISEWOOD_LOG.get())
                .add(HnSBlocks.WISEWOOD_WOOD.get())
                .add(HnSBlocks.STRIPPED_WISEWOOD_WOOD.get())
                .add(HnSBlocks.WISEWOOD_DOOR.get())
                .add(HnSBlocks.WISEWOOD_TRAPDOOR.get())
                .add(HnSBlocks.WISEWOOD_FENCE.get())
                .add(HnSBlocks.WISEWOOD_FENCE_GATE.get())
                .add(HnSBlocks.WISEWOOD_BUTTON.get())
                .add(HnSBlocks.WISEWOOD_PRESSURE_PLATE.get())

                .add(HnSBlocks.FROSTBITE_BIRCH_PLANKS.get())
                .add(HnSBlocks.FROSTBITE_BIRCH_NAILED_PLANKS.get())
                .add(HnSBlocks.FROSTBITE_BIRCH_STAIRS.get())
                .add(HnSBlocks.FROSTBITE_BIRCH_SLAB.get())
                .add(HnSBlocks.FROSTBITE_BIRCH_LOG.get())
                .add(HnSBlocks.FROSTBITE_BIRCH_WOOD.get())
                .add(HnSBlocks.STRIPPED_FROSTBITE_BIRCH_WOOD.get())
                .add(HnSBlocks.FROSTBITE_BIRCH_FENCE_GATE.get())
                .add(HnSBlocks.FROSTBITE_BIRCH_FENCE.get())
                .add(HnSBlocks.FROSTBITE_BIRCH_BUTTON.get())
                .add(HnSBlocks.FROSTBITE_BIRCH_PRESSURE_PLATE.get())

        ;

        tag(BlockTags.MINEABLE_WITH_HOE)

        ;

        tag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)

        ;

        tag(BlockTags.INCORRECT_FOR_IRON_TOOL)

                .add(HnSBlocks.ZENALITE_ABYSSLATE_ORE.get())
                .add(HnSBlocks.ZENALITE_DEEPSLATE_ORE.get())
                .add(HnSBlocks.ZENALITE_STONE_ORE.get())
                .add(HnSBlocks.ZENALITE_END_STONE_ORE.get())
                .add(HnSBlocks.SOLAR_CORE_BLACKSTONE_ORE.get())
                .add(HnSBlocks.SOLAR_CORE_NETHERACK_ORE.get())

        ;

        tag(BlockTags.INCORRECT_FOR_GOLD_TOOL)


        ;

        tag(BlockTags.INCORRECT_FOR_STONE_TOOL)

                .add(HnSBlocks.ZENALITE_BLOCK.get())
                .add(HnSBlocks.ARCANE_STEEL_BLOCK.get())
                .add(HnSBlocks.MITHRIL_BLOCK.get())
                .add(HnSBlocks.DREADSTONE_ORE.get())
                .add(HnSBlocks.PYRIUM_BLOCK.get())

        ;

        tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL)


        ;

        tag(HnSTags.Blocks.NEEDS_MITRHIL_TOOL)
                .add(HnSBlocks.CHLOROPHYTE_ORE.get())
                .add(HnSBlocks.ZENALITE_ABYSSLATE_ORE.get())
                .add(HnSBlocks.ZENALITE_DEEPSLATE_ORE.get())
                .add(HnSBlocks.ZENALITE_STONE_ORE.get())
                .add(HnSBlocks.ZENALITE_END_STONE_ORE.get())
                .addTag(Tags.Blocks.NEEDS_NETHERITE_TOOL)

        ;

        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(HnSBlocks.CHLOROPHYTE_ORE.get())

        ;

        tag(BlockTags.NEEDS_DIAMOND_TOOL)

                .add(HnSBlocks.SOLAR_CORE_BLACKSTONE_ORE.get())
                .add(HnSBlocks.SOLAR_CORE_NETHERACK_ORE.get())
                .add(HnSBlocks.SOLAR_CORE_NETHERACK_ORE.get())

                .add(HnSBlocks.RUNESTONE_SLAG.get())
        ;

        tag(BlockTags.NEEDS_IRON_TOOL)

                .add(HnSBlocks.DREADSTONE_ORE.get())
                .add(HnSBlocks.ZENALITE_BLOCK.get())
                .add(HnSBlocks.ARCANE_STEEL_BLOCK.get())
                .add(HnSBlocks.MITHRIL_BLOCK.get())
                .add(HnSBlocks.PYRIUM_BLOCK.get())
        ;

        tag(BlockTags.NEEDS_STONE_TOOL)
        ;


        /*
        *** Generic Tags
         */

        //Door
        tag(BlockTags.DOORS)

                .add(HnSBlocks.WISEWOOD_DOOR.get())

        ;

        tag(BlockTags.WOODEN_DOORS)

                .add(HnSBlocks.WISEWOOD_DOOR.get())

        ;

        //Trapdoor
        tag(BlockTags.TRAPDOORS)

                .add(HnSBlocks.WISEWOOD_TRAPDOOR.get())
        ;

        tag(BlockTags.WOODEN_TRAPDOORS)

                .add(HnSBlocks.WISEWOOD_TRAPDOOR.get())

        ;

        //Fence
        tag(BlockTags.FENCES)

                .add(HnSBlocks.WISEWOOD_FENCE.get())
                .add(HnSBlocks.FROSTBITE_BIRCH_FENCE.get())

        ;

        tag(BlockTags.WOODEN_FENCES)

                .add(HnSBlocks.WISEWOOD_FENCE.get())
                .add(HnSBlocks.FROSTBITE_BIRCH_FENCE.get())

        ;

        tag(BlockTags.FENCE_GATES)

                .add(HnSBlocks.WISEWOOD_FENCE_GATE.get())
                .add(HnSBlocks.FROSTBITE_BIRCH_FENCE_GATE.get())

        ;

        //Fence
        tag(BlockTags.WALLS)

                .add(HnSBlocks.MOSSY_MUD_BRICK_WALL.get())
                .add(HnSBlocks.ZENALITE_BRICK_WALL.get())

        ;

        //Stairs
        tag(BlockTags.STAIRS)

                .add(HnSBlocks.WISEWOOD_STAIRS.get())
                .add(HnSBlocks.ZENALITE_BRICK_STAIRS.get())
                .add(HnSBlocks.MOSSY_MUD_BRICK_STAIRS.get())
                .add(HnSBlocks.FROSTBITE_BIRCH_STAIRS.get())
        ;

        tag(BlockTags.WOODEN_STAIRS)

                .add(HnSBlocks.WISEWOOD_STAIRS.get())
                .add(HnSBlocks.FROSTBITE_BIRCH_STAIRS.get())

        ;

        //Slabs
        tag(BlockTags.SLABS)

                .add(HnSBlocks.WISEWOOD_SLAB.get())
                .add(HnSBlocks.ZENALITE_BRICK_SLAB.get())
                .add(HnSBlocks.MOSSY_MUD_BRICK_SLAB.get())
                .add(HnSBlocks.FROSTBITE_BIRCH_SLAB.get())
        ;

        tag(BlockTags.WOODEN_SLABS)

                .add(HnSBlocks.WISEWOOD_SLAB.get())
                .add(HnSBlocks.FROSTBITE_BIRCH_SLAB.get())


        ;


        //Bricks
        tag(BlockTags.STONE_BRICKS)

                .add(HnSBlocks.ZENALITE_BRICKS.get())
                .add(HnSBlocks.MOSSY_MUD_BRICKS.get())

        ;

        tag(BlockTags.BUTTONS)

                .add(HnSBlocks.WISEWOOD_BUTTON.get())
                .add(HnSBlocks.FROSTBITE_BIRCH_BUTTON.get())

        ;

        tag(BlockTags.PRESSURE_PLATES)

                .add(HnSBlocks.WISEWOOD_PRESSURE_PLATE.get())
                .add(HnSBlocks.FROSTBITE_BIRCH_PRESSURE_PLATE.get())

        ;

        /*
        *** Complex Tags
         */

        tag(BlockTags.MOB_INTERACTABLE_DOORS)

                .add(HnSBlocks.WISEWOOD_DOOR.get())

        ;

        tag(BlockTags.BEACON_BASE_BLOCKS)

                .add(HnSBlocks.PYRIUM_BLOCK.get())
                .add(HnSBlocks.MITHRIL_BLOCK.get())
                .add(HnSBlocks.ARCANE_STEEL_BLOCK.get())
                .add(HnSBlocks.ZENALITE_BLOCK.get())

        ;

        /*
        *** Wood Tags
         */


        tag(BlockTags.PLANKS)

                .add(HnSBlocks.WISEWOOD_PLANKS.get())
                .add(HnSBlocks.FROSTBITE_BIRCH_PLANKS.get())

        ;

        tag(BlockTags.LOGS)

                .add(HnSBlocks.WISEWOOD_LOG.get())
                .add(HnSBlocks.STRIPPED_WISEWOOD_LOG.get())
                .add(HnSBlocks.WISEWOOD_WOOD.get())
                .add(HnSBlocks.STRIPPED_WISEWOOD_WOOD.get())

        ;

        tag(BlockTags.LOGS_THAT_BURN)

                .add(HnSBlocks.WISEWOOD_LOG.get())
                .add(HnSBlocks.STRIPPED_WISEWOOD_LOG.get())
                .add(HnSBlocks.WISEWOOD_WOOD.get())
                .add(HnSBlocks.STRIPPED_WISEWOOD_WOOD.get())

                .add(HnSBlocks.FROSTBITE_BIRCH_LOG.get())
                .add(HnSBlocks.STRIPPED_FROSTBITE_BIRCH_LOG.get())
                .add(HnSBlocks.FROSTBITE_BIRCH_WOOD.get())
                .add(HnSBlocks.STRIPPED_FROSTBITE_BIRCH_WOOD.get())

        ;

        tag(BlockTags.LEAVES)

                .add(HnSBlocks.PERMAFROST_LEAVES.get())
                .add(HnSBlocks.WISEWOOD_LEAVES.get())

        ;

        /*
        *** Stone Tags
         */

        tag(BlockTags.STONE_ORE_REPLACEABLES)

                .add(HnSBlocks.ZENALITE_STONE_ORE.get())

        ;

        tag(BlockTags.DEEPSLATE_ORE_REPLACEABLES)

                .add(HnSBlocks.ZENALITE_STONE_ORE.get())

        ;

        /*
        *** Misc
         */

        tag(BlockTags.SAPLINGS)
                .add(HnSBlocks.FROSTBITE_BIRCH_SAPLING.get())
                .add(HnSBlocks.WISEWOOD_SAPLING.get())

        ;

    }
}