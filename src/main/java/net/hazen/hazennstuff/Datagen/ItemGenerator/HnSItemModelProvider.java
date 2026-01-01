package net.hazen.hazennstuff.Datagen.ItemGenerator;

import net.hazen.hazennstuff.Item.Block.HnSBlocks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class HnSItemModelProvider extends ItemModelProvider {

    public HnSItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, HazenNStuff.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        buttonItem(HnSBlocks.FROSTBITE_BIRCH_BUTTON, HnSBlocks.FROSTBITE_BIRCH_PLANKS);
        fenceItem(HnSBlocks.FROSTBITE_BIRCH_FENCE, HnSBlocks.FROSTBITE_BIRCH_PLANKS);
        wallItem(HnSBlocks.MOSSY_MUD_BRICK_WALL, HnSBlocks.MOSSY_MUD_BRICKS);
        wallItem(HnSBlocks.ZENALITE_BRICK_WALL, HnSBlocks.ZENALITE_BRICKS);

        saplingItem(HnSBlocks.FROSTBITE_BIRCH_SAPLING);
        saplingItem(HnSBlocks.WISEWOOD_SAPLING);
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID,"block/" + item.getId().getPath()));
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID,"item/" + item.getId().getPath()));
    }
}