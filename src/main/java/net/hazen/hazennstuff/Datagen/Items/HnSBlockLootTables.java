package net.hazen.hazennstuff.Datagen.Items;

import net.hazen.hazennstuff.Blocks.HnSBlockRegistry;
import net.hazen.hazennstuff.Registries.ItemRegistries.HnSMaterialItemRegistry;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class HnSBlockLootTables extends BlockLootSubProvider {
    public HnSBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(HnSBlockRegistry.ZENALITE_BLOCK.get());


        this.add(HnSBlockRegistry.STONE_ZENALITE_ORE.get(),
                block -> createOreDrop(HnSBlockRegistry.STONE_ZENALITE_ORE.get(), HnSMaterialItemRegistry.RAW_ZENALITE.get()));
        this.add(HnSBlockRegistry.DEEPSLATE_ZENALITE_ORE.get(),
                block -> createOreDrop(HnSBlockRegistry.DEEPSLATE_ZENALITE_ORE.get(), HnSMaterialItemRegistry.RAW_ZENALITE.get()));
        this.add(HnSBlockRegistry.END_STONE_ZENALITE_ORE.get(),
                block -> createOreDrop(HnSBlockRegistry.END_STONE_ZENALITE_ORE.get(), HnSMaterialItemRegistry.RAW_ZENALITE.get()));

    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return HnSBlockRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}