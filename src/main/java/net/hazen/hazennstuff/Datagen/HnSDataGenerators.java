package net.hazen.hazennstuff.Datagen;

import net.hazen.hazennstuff.Datagen.ItemGenerator.HnSBlockStateProvider;
import net.hazen.hazennstuff.Datagen.ItemGenerator.HnSBlockTagProvider;
import net.hazen.hazennstuff.Datagen.ItemGenerator.HnSItemModelProvider;
import net.hazen.hazennstuff.Datagen.ItemGenerator.HnSItemTagProvider;
import net.hazen.hazennstuff.Datagen.LootTables.HnSBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(value = Dist.CLIENT)
public class HnSDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(HnSBlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));
        generator.addProvider(event.includeServer(), new HnSRecipeProvider(packOutput, lookupProvider));

        BlockTagsProvider blockTagsProvider = new HnSBlockTagProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new HnSItemTagProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeClient(), new HnSItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new HnSBlockStateProvider(packOutput, existingFileHelper));

        generator.addProvider(event.includeServer(), new HnSDatapackProvider(packOutput, lookupProvider));
    }
}