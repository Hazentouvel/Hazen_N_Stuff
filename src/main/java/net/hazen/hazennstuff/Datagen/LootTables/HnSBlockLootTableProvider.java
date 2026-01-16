package net.hazen.hazennstuff.Datagen.LootTables;

import net.hazen.hazennstuff.Item.Block.HnSBlocks;
import net.hazen.hazennstuff.Registries.HnSItemRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class HnSBlockLootTableProvider extends BlockLootSubProvider {

    public HnSBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        /*
        *** Drop Self
         */


        // Overworld
        dropSelf(HnSBlocks.AQUASTONE.get());
        dropSelf(HnSBlocks.RUNESTONE_SLAG.get());


        // Nether
        dropSelf(HnSBlocks.FIREBLOSSOM.get());

        // End Stones
        dropSelf(HnSBlocks.ABYSSLATE.get());
        dropSelf(HnSBlocks.PHANTASMIUM.get());
        dropSelf(HnSBlocks.VOIDSTONE.get());
        dropSelf(HnSBlocks.COBBLED_VOIDSTONE.get());


        // Zenalite Bricks
        dropSelf(HnSBlocks.ZENALITE_BRICKS.get());
        dropSelf(HnSBlocks.ZENALITE_BRICK_SLAB.get());
        dropSelf(HnSBlocks.ZENALITE_BRICK_STAIRS.get());
        dropSelf(HnSBlocks.ZENALITE_BRICK_WALL.get());


        // Mossy Mud Bricks
        dropSelf(HnSBlocks.MOSSY_MUD_BRICKS.get());
        dropSelf(HnSBlocks.MOSSY_MUD_BRICK_SLAB.get());
        dropSelf(HnSBlocks.MOSSY_MUD_BRICK_STAIRS.get());
        dropSelf(HnSBlocks.MOSSY_MUD_BRICK_WALL.get());

        // Wisewood
        dropSelf(HnSBlocks.WISEWOOD_PLANKS.get());
        dropSelf(HnSBlocks.WISEWOOD_SLAB.get());
        dropSelf(HnSBlocks.WISEWOOD_STAIRS.get());
        dropSelf(HnSBlocks.WISEWOOD_LOG.get());
        dropSelf(HnSBlocks.WISEWOOD_WOOD.get());
        dropSelf(HnSBlocks.STRIPPED_WISEWOOD_LOG.get());
        dropSelf(HnSBlocks.STRIPPED_WISEWOOD_WOOD.get());

        dropSelf(HnSBlocks.WISEWOOD_TRAPDOOR.get());
        dropSelf(HnSBlocks.WISEWOOD_FENCE_GATE.get());
        dropSelf(HnSBlocks.WISEWOOD_FENCE.get());
        dropSelf(HnSBlocks.WISEWOOD_BUTTON.get());
        dropSelf(HnSBlocks.WISEWOOD_PRESSURE_PLATE.get());
        add(HnSBlocks.WISEWOOD_DOOR.get(),
                block -> createDoorTable(HnSBlocks.WISEWOOD_DOOR.get()));
        this.dropSelf(HnSBlocks.WISEWOOD_SAPLING.get());

        // Frostbite Birch
        dropSelf(HnSBlocks.FROSTBITE_BIRCH_PLANKS.get());
        dropSelf(HnSBlocks.FROSTBITE_BIRCH_NAILED_PLANKS.get());
        dropSelf(HnSBlocks.FROSTBITE_BIRCH_SLAB.get());
        dropSelf(HnSBlocks.FROSTBITE_BIRCH_STAIRS.get());
        dropSelf(HnSBlocks.FROSTBITE_BIRCH_LOG.get());
        dropSelf(HnSBlocks.FROSTBITE_BIRCH_WOOD.get());
        dropSelf(HnSBlocks.STRIPPED_FROSTBITE_BIRCH_LOG.get());
        dropSelf(HnSBlocks.STRIPPED_FROSTBITE_BIRCH_WOOD.get());

        //dropSelf(HnSItemRegistry.HnSBlocks.FROSTBITE_BIRCH_TRAPDOOR.get());
        dropSelf(HnSBlocks.FROSTBITE_BIRCH_FENCE_GATE.get());
        dropSelf(HnSBlocks.FROSTBITE_BIRCH_FENCE.get());
        //add(HnSItemRegistry.HnSBlocks.FROSTBITE_BIRCH_DOOR.get(),
        //        block -> createDoorTable(HnSItemRegistry.HnSBlocks.WISEWOOD_DOOR.get()));
        this.dropSelf(HnSBlocks.FROSTBITE_BIRCH_SAPLING.get());
        this.dropSelf(HnSBlocks.FROSTBITE_BIRCH_BUTTON.get());
        this.dropSelf(HnSBlocks.FROSTBITE_BIRCH_PRESSURE_PLATE.get());


        // Metals
        dropSelf(HnSBlocks.ZENALITE_BLOCK.get());
        dropSelf(HnSBlocks.MITHRIL_BLOCK.get());
        dropSelf(HnSBlocks.PYRIUM_BLOCK.get());
        dropSelf(HnSBlocks.ARCANE_STEEL_BLOCK.get());

        // Statues
        dropSelf(HnSBlocks.HAZEL_STATUE.get());

        /*
        *** Ore
         */

        //Zenalite
        add(HnSBlocks.ZENALITE_STONE_ORE.get(),
                block -> createOreDrop(HnSBlocks.ZENALITE_STONE_ORE.get(), HnSItemRegistry.RAW_ZENALITE.get()));
        add(HnSBlocks.ZENALITE_DEEPSLATE_ORE.get(),
                block -> createOreDrop(HnSBlocks.ZENALITE_DEEPSLATE_ORE.get(), HnSItemRegistry.RAW_ZENALITE.get()));
        add(HnSBlocks.ZENALITE_END_STONE_ORE.get(),
                block -> createOreDrop(HnSBlocks.ZENALITE_END_STONE_ORE.get(), HnSItemRegistry.RAW_ZENALITE.get()));
        add(HnSBlocks.ZENALITE_ABYSSLATE_ORE.get(),
                block -> createOreDrop(HnSBlocks.ZENALITE_ABYSSLATE_ORE.get(), HnSItemRegistry.RAW_ZENALITE.get()));
        add(HnSBlocks.ZENALITE_VOIDSTONE_ORE.get(),
                block -> createOreDrop(HnSBlocks.ZENALITE_DEEPSLATE_ORE.get(), HnSItemRegistry.RAW_ZENALITE.get()));

        // Solar Core
        add(HnSBlocks.SOLAR_CORE_NETHERACK_ORE.get(),
                block -> createOreDrop(HnSBlocks.SOLAR_CORE_NETHERACK_ORE.get(), HnSItemRegistry.SOLAR_CORE.get()));
        add(HnSBlocks.SOLAR_CORE_BLACKSTONE_ORE.get(),
                block -> createOreDrop(HnSBlocks.SOLAR_CORE_BLACKSTONE_ORE.get(), HnSItemRegistry.SOLAR_CORE.get()));

        // Dreadstone
        add(HnSBlocks.DREADSTONE_ORE.get(),
                block -> createOreDrop(HnSBlocks.DREADSTONE_ORE.get(), HnSItemRegistry.DREADSTONE.get()));

        // Dreadstone
        add(HnSBlocks.CHLOROPHYTE_ORE.get(),
                block -> createOreDrop(HnSBlocks.CHLOROPHYTE_ORE.get(), HnSItemRegistry.CHLOROPHYTE_CHUNK.get()));

        // Runestone
        add(HnSBlocks.RUNESTONE_SLAG.get(),
                block -> createMultipleOreDrops(HnSBlocks.RUNESTONE_SLAG.get(), HnSItemRegistry.RUNESTONE_FRAGMENTS.get(), 2, 5));


        // Leaves
        this.add(HnSBlocks.WISEWOOD_LEAVES.get(), block ->
                createLeavesDrops(block, HnSBlocks.WISEWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(HnSBlocks.PERMAFROST_LEAVES.get(), block ->
                createLeavesDrops(block, HnSBlocks.FROSTBITE_BIRCH_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }




    @Override
    protected Iterable<Block> getKnownBlocks() {
        return HnSBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}