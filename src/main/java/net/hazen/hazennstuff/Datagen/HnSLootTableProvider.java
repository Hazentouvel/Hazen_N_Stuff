package net.hazen.hazennstuff.Datagen;

import net.hazen.hazennstuff.Datagen.Items.HnSBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class HnSLootTableProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(HnSBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}