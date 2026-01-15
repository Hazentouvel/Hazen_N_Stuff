package net.hazen.hazennstuff.Datagen.ItemGenerator;

import net.hazen.hazennstuff.Item.Block.HnSBlocks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class HnSBlockStateProvider extends BlockStateProvider {
    public HnSBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, HazenNStuff.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        /*
        *** Stone-Like Blocks
         */

        // Mossy Mud Bricks
        blockWithItem(HnSBlocks.MOSSY_MUD_BRICKS);
        stairsBlock(HnSBlocks.MOSSY_MUD_BRICK_STAIRS.get(), blockTexture(HnSBlocks.MOSSY_MUD_BRICKS.get()));
        slabBlock(HnSBlocks.MOSSY_MUD_BRICK_SLAB.get(), blockTexture(HnSBlocks.MOSSY_MUD_BRICKS.get()), blockTexture(HnSBlocks.MOSSY_MUD_BRICKS.get()));
        wallBlock(HnSBlocks.MOSSY_MUD_BRICK_WALL.get(), blockTexture(HnSBlocks.MOSSY_MUD_BRICKS.get()));

        blockItem(HnSBlocks.MOSSY_MUD_BRICK_SLAB);
        blockItem(HnSBlocks.MOSSY_MUD_BRICK_STAIRS);

        // Zenalite Bricks
        blockWithItem(HnSBlocks.ZENALITE_BRICKS);
        wallBlock(HnSBlocks.ZENALITE_BRICK_WALL.get(), blockTexture(HnSBlocks.ZENALITE_BRICKS.get()));
        stairsBlock(HnSBlocks.ZENALITE_BRICK_STAIRS.get(), blockTexture(HnSBlocks.ZENALITE_BRICKS.get()));
        slabBlock(HnSBlocks.ZENALITE_BRICK_SLAB.get(), blockTexture(HnSBlocks.ZENALITE_BRICKS.get()), blockTexture(HnSBlocks.ZENALITE_BRICKS.get()));

        blockItem(HnSBlocks.ZENALITE_BRICK_SLAB);
        blockItem(HnSBlocks.ZENALITE_BRICK_STAIRS);

        /*
         *** Ores
         */

        blockWithItem(HnSBlocks.CHLOROPHYTE_ORE);
        blockWithItem(HnSBlocks.DREADSTONE_ORE);

        /*
        *** Wood
         */

        //Frostbite Birch
        blockWithItem(HnSBlocks.FROSTBITE_BIRCH_PLANKS);
        blockWithItem(HnSBlocks.FROSTBITE_BIRCH_NAILED_PLANKS);
        stairsBlock(HnSBlocks.FROSTBITE_BIRCH_STAIRS.get(), blockTexture(HnSBlocks.FROSTBITE_BIRCH_PLANKS.get()));
        slabBlock(HnSBlocks.FROSTBITE_BIRCH_SLAB.get(), blockTexture(HnSBlocks.FROSTBITE_BIRCH_PLANKS.get()), blockTexture(HnSBlocks.FROSTBITE_BIRCH_PLANKS.get()));
        fenceBlock(HnSBlocks.FROSTBITE_BIRCH_FENCE.get(), blockTexture(HnSBlocks.FROSTBITE_BIRCH_PLANKS.get()));
        fenceGateBlock(HnSBlocks.FROSTBITE_BIRCH_FENCE_GATE.get(), blockTexture(HnSBlocks.FROSTBITE_BIRCH_PLANKS.get()));
        buttonBlock(HnSBlocks.FROSTBITE_BIRCH_BUTTON.get(), blockTexture(HnSBlocks.FROSTBITE_BIRCH_PLANKS.get()));
        pressurePlateBlock(HnSBlocks.FROSTBITE_BIRCH_PRESSURE_PLATE.get(), blockTexture(HnSBlocks.FROSTBITE_BIRCH_PLANKS.get()));


        logBlock(((RotatedPillarBlock) HnSBlocks.FROSTBITE_BIRCH_LOG.get()));
        axisBlock(((RotatedPillarBlock) HnSBlocks.FROSTBITE_BIRCH_WOOD.get()),
                blockTexture(HnSBlocks.FROSTBITE_BIRCH_LOG.get()), blockTexture(HnSBlocks.FROSTBITE_BIRCH_LOG.get()
                ));

        logBlock(((RotatedPillarBlock) HnSBlocks.STRIPPED_FROSTBITE_BIRCH_LOG.get()));
        axisBlock(((RotatedPillarBlock) HnSBlocks.STRIPPED_FROSTBITE_BIRCH_WOOD.get()),
                blockTexture(HnSBlocks.STRIPPED_FROSTBITE_BIRCH_LOG.get()), blockTexture(HnSBlocks.STRIPPED_FROSTBITE_BIRCH_LOG.get()
                ));

        blockItem(HnSBlocks.FROSTBITE_BIRCH_LOG);
        blockItem(HnSBlocks.FROSTBITE_BIRCH_WOOD);
        blockItem(HnSBlocks.STRIPPED_FROSTBITE_BIRCH_LOG);
        blockItem(HnSBlocks.STRIPPED_FROSTBITE_BIRCH_WOOD);
        blockItem(HnSBlocks.FROSTBITE_BIRCH_STAIRS);
        blockItem(HnSBlocks.FROSTBITE_BIRCH_SLAB);
        blockItem(HnSBlocks.FROSTBITE_BIRCH_PRESSURE_PLATE);
        blockItem(HnSBlocks.FROSTBITE_BIRCH_FENCE_GATE);

        saplingBlock(HnSBlocks.FROSTBITE_BIRCH_SAPLING);
        leavesBlock(HnSBlocks.PERMAFROST_LEAVES);

        // Wisewood
        saplingBlock(HnSBlocks.WISEWOOD_SAPLING);
    }


    //Helper method for simple blocks
    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("hazennstuff:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("hazennstuff:block/" + deferredBlock.getId().getPath() + appendix));
    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}