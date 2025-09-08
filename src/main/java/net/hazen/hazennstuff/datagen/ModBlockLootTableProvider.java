//package net.hazen.hazennstuff.datagen;
//
//import net.hazen.hazennstuff.registries.HnSItems;
//import net.minecraft.core.Holder;
//import net.minecraft.core.HolderLookup;
//import net.minecraft.data.loot.BlockLootSubProvider;
//import net.minecraft.world.flag.FeatureFlags;
//import net.minecraft.world.level.block.Block;
//
//import java.util.Set;
//
//public class ModBlockLootTableProvider extends BlockLootSubProvider {
//
//    public ModBlockLootTableProvider(HolderLookup.Provider registries) {
//        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
//    }
//
//    @Override
//    protected void generate() {
//        //Drop Self
//        dropSelf(HnSItems.HnSBlocks.ZENALITE_BLOCK.get());
//        dropSelf(HnSItems.HnSBlocks.RUNESTONE_SLAG.get());
//        //Ore
//        add(HnSItems.HnSBlocks.ZENALITE_DEEPSLATE_ORE.get(),
//                block -> createOreDrop(HnSItems.HnSBlocks.ZENALITE_DEEPSLATE_ORE.get(), HnSItems.RAW_ZENALITE.get()));
//        }
//
//
//    @Override
//    protected Iterable<Block> getKnownBlocks() {
//        return HnSItems.HnSBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
//    }
//}