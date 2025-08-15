package net.hazen.hazennstuff.datagen;

import net.hazen.hazennstuff.registries.HnSItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {

        //Drop Self
        dropSelf(HnSItems.HnSBlocks.ABYSSLATE.get());
        dropSelf(HnSItems.HnSBlocks.AQUASTONE.get());
        dropSelf(HnSItems.HnSBlocks.ARCANE_STEEL_BLOCK.get());
        dropSelf(HnSItems.HnSBlocks.PYRIUM_BLOCK.get());
        dropSelf(HnSItems.HnSBlocks.PHANTASMIUM.get());
        dropSelf(HnSItems.HnSBlocks.ZENALITE_BLOCK.get());
        dropSelf(HnSItems.HnSBlocks.ZENALITE_BRICKS.get());
        dropSelf(HnSItems.HnSBlocks.ZENALITE_SLAB.get());
        dropSelf(HnSItems.HnSBlocks.ZENALITE_STAIRS.get());


        //Ore
        add(HnSItems.HnSBlocks.ZENALITE_STONE_ORE.get(),
                block -> createOreDrop(HnSItems.HnSBlocks.ZENALITE_STONE_ORE.get(), HnSItems.RAW_ZENALITE.get()));
        add(HnSItems.HnSBlocks.ZENALITE_ABYSSLATE_ORE.get(),
                block -> createOreDrop(HnSItems.HnSBlocks.ZENALITE_ABYSSLATE_ORE.get(), HnSItems.RAW_ZENALITE.get()));
        add(HnSItems.HnSBlocks.ZENALITE_DEEPSLATE_ORE.get(),
                block -> createOreDrop(HnSItems.HnSBlocks.ZENALITE_DEEPSLATE_ORE.get(), HnSItems.RAW_ZENALITE.get()));
    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return HnSItems.HnSBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}