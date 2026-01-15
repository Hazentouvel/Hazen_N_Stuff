package net.hazen.hazennstuff.Datagen.Items;

import net.hazen.hazennstuff.Blocks.HnSBlockRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class HnSBlockStateProvider extends BlockStateProvider {
    public HnSBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, HazenNStuff.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(HnSBlockRegistry.ZENALITE_BLOCK);

        blockWithItem(HnSBlockRegistry.STONE_ZENALITE_ORE);
        blockWithItem(HnSBlockRegistry.DEEPSLATE_ZENALITE_ORE);
        blockWithItem(HnSBlockRegistry.END_STONE_ZENALITE_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}