//package net.hazen.hazennstuff.datagen;
//
//import net.hazen.hazennstuff.HazenNStuff;
//import net.hazen.hazennstuff.registries.HnSItems;
//import net.minecraft.data.PackOutput;
//import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
//import net.neoforged.neoforge.common.data.ExistingFileHelper;
//import net.neoforged.neoforge.registries.DeferredBlock;
//
//public class ModBlockStateProvider extends BlockStateProvider {
//    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
//        super(output, HazenNStuff.MOD_ID, exFileHelper);
//    }
//
//    @Override
//    protected void registerStatesAndModels() {
//        blockWithItem(HnSItems.HnSBlocks.ZENALITE_ABYSSLATE_ORE);
//        blockWithItem(HnSItems.HnSBlocks.ZENALITE_DEEPSLATE_ORE);
//        blockWithItem(HnSItems.HnSBlocks.ZENALITE_STONE_ORE);
//    }
//    //Helper method for simple blocks
//    private void blockWithItem(DeferredBlock<?> deferredBlock) {
//        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
//    }
//}