package net.hazen.hazennstuff.datagen;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.registries.HnSItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, HazenNStuff.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        //Mining Tags
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(HnSItems.HnSBlocks.ZENALITE_ABYSSLATE_ORE.get())
                .add(HnSItems.HnSBlocks.ZENALITE_DEEPSLATE_ORE.get())
                .add(HnSItems.HnSBlocks.ZENALITE_STONE_ORE.get())

                .add(HnSItems.HnSBlocks.ZENALITE_BLOCK.get())
                .add(HnSItems.HnSBlocks.ARCANE_STEEL_BLOCK.get())
                .add(HnSItems.HnSBlocks.MITHRIL_BLOCK.get())
                .add(HnSItems.HnSBlocks.PYRIUM_BLOCK.get())


                .add(HnSItems.HnSBlocks.ZENALITE_SLAB.get())
                .add(HnSItems.HnSBlocks.ZENALITE_STAIRS.get())
                .add(HnSItems.HnSBlocks.ZENALITE_BRICKS.get())


                .add(HnSItems.HnSBlocks.AQUASTONE.get())
                .add(HnSItems.HnSBlocks.ABYSSLATE.get())
                .add(HnSItems.HnSBlocks.VOIDSTONE.get())
        ;

        tag(BlockTags.MINEABLE_WITH_AXE)

                .add(HnSItems.HnSBlocks.WISEWOOD_PLANK.get())
                .add(HnSItems.HnSBlocks.WISEWOOD_LOG.get())
                .add(HnSItems.HnSBlocks.STRIPPED_WISEWOOD_LOG.get())
                .add(HnSItems.HnSBlocks.WISEWOOD_WOOD.get())
                .add(HnSItems.HnSBlocks.STRIPPED_WISEWOOD_WOOD.get())
                .add(HnSItems.HnSBlocks.WISEWOOD_DOOR.get())
                .add(HnSItems.HnSBlocks.WISEWOOD_TRAPDOOR.get())
                .add(HnSItems.HnSBlocks.WISEWOOD_FENCE.get())
                .add(HnSItems.HnSBlocks.WISEWOOD_FENCE_GATE.get())

        ;

        tag(BlockTags.MINEABLE_WITH_HOE)

        ;

        tag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)

        ;

        tag(BlockTags.INCORRECT_FOR_IRON_TOOL)

                .add(HnSItems.HnSBlocks.ZENALITE_DEEPSLATE_ORE.get())
                .add(HnSItems.HnSBlocks.ZENALITE_ABYSSLATE_ORE.get())

        ;

        tag(BlockTags.INCORRECT_FOR_GOLD_TOOL)

                .add(HnSItems.HnSBlocks.ZENALITE_DEEPSLATE_ORE.get())

        ;

        tag(BlockTags.INCORRECT_FOR_STONE_TOOL)

                .add(HnSItems.HnSBlocks.ZENALITE_DEEPSLATE_ORE.get())

        ;

        tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL)

        ;

        tag(BlockTags.NEEDS_DIAMOND_TOOL)

                .add(HnSItems.HnSBlocks.ZENALITE_ABYSSLATE_ORE.get())
                .add(HnSItems.HnSBlocks.ZENALITE_ABYSSLATE_ORE.get())
        ;

        tag(BlockTags.NEEDS_IRON_TOOL)

                .add(HnSItems.HnSBlocks.ZENALITE_STONE_ORE.get())
        ;


        /*
        *** Generic Tags
         */

        //Door
        tag(BlockTags.DOORS)

                .add(HnSItems.HnSBlocks.WISEWOOD_DOOR.get())

        ;

        tag(BlockTags.WOODEN_DOORS)

                .add(HnSItems.HnSBlocks.WISEWOOD_DOOR.get())

        ;

        //Trapdoor
        tag(BlockTags.TRAPDOORS)

                .add(HnSItems.HnSBlocks.WISEWOOD_TRAPDOOR.get())
        ;

        tag(BlockTags.WOODEN_TRAPDOORS)

                .add(HnSItems.HnSBlocks.WISEWOOD_TRAPDOOR.get())

        ;

        //Fence
        tag(BlockTags.FENCES)

                .add(HnSItems.HnSBlocks.WISEWOOD_FENCE.get())

        ;

        tag(BlockTags.WOODEN_FENCES)

                .add(HnSItems.HnSBlocks.WISEWOOD_FENCE.get())

        ;

        tag(BlockTags.FENCE_GATES)

                .add(HnSItems.HnSBlocks.WISEWOOD_FENCE_GATE.get())

        ;

        //Stairs
        tag(BlockTags.STAIRS)

                .add(HnSItems.HnSBlocks.WISEWOOD_STAIRS.get())
                .add(HnSItems.HnSBlocks.ZENALITE_STAIRS.get())
        ;

        tag(BlockTags.WOODEN_STAIRS)

                .add(HnSItems.HnSBlocks.WISEWOOD_STAIRS.get())

        ;

        //Slabs
        tag(BlockTags.SLABS)

                .add(HnSItems.HnSBlocks.WISEWOOD_SLAB.get())
                .add(HnSItems.HnSBlocks.ZENALITE_SLAB.get())
        ;

        tag(BlockTags.WOODEN_SLABS)

                .add(HnSItems.HnSBlocks.WISEWOOD_SLAB.get())

        ;


        //Bricks
        tag(BlockTags.STONE_BRICKS)

                .add(HnSItems.HnSBlocks.ZENALITE_BRICKS.get())

        ;

        /*
        *** Complex Tags
         */

        tag(BlockTags.MOB_INTERACTABLE_DOORS)

                .add(HnSItems.HnSBlocks.WISEWOOD_DOOR.get())

        ;

        tag(BlockTags.BEACON_BASE_BLOCKS)

                .add(HnSItems.HnSBlocks.PYRIUM_BLOCK.get())
                .add(HnSItems.HnSBlocks.MITHRIL_BLOCK.get())
                .add(HnSItems.HnSBlocks.ARCANE_STEEL_BLOCK.get())
                .add(HnSItems.HnSBlocks.ZENALITE_BLOCK.get())

        ;

        /*
        *** Wood Tags
         */


        tag(BlockTags.PLANKS)

                .add(HnSItems.HnSBlocks.WISEWOOD_PLANK.get())

        ;

        tag(BlockTags.LOGS)

                .add(HnSItems.HnSBlocks.WISEWOOD_LOG.get())
                .add(HnSItems.HnSBlocks.STRIPPED_WISEWOOD_LOG.get())
                .add(HnSItems.HnSBlocks.WISEWOOD_WOOD.get())
                .add(HnSItems.HnSBlocks.STRIPPED_WISEWOOD_WOOD.get())

        ;

        tag(BlockTags.LOGS_THAT_BURN)

                .add(HnSItems.HnSBlocks.WISEWOOD_LOG.get())
                .add(HnSItems.HnSBlocks.STRIPPED_WISEWOOD_LOG.get())
                .add(HnSItems.HnSBlocks.WISEWOOD_WOOD.get())
                .add(HnSItems.HnSBlocks.STRIPPED_WISEWOOD_WOOD.get())

        ;

        /*
        *** Stone Tags
         */

        tag(BlockTags.STONE_ORE_REPLACEABLES)

                .add(HnSItems.HnSBlocks.ZENALITE_STONE_ORE.get())

        ;

        tag(BlockTags.DEEPSLATE_ORE_REPLACEABLES)

                .add(HnSItems.HnSBlocks.ZENALITE_STONE_ORE.get())

        ;


    }
}