package net.hazen.hazennstuff.Datagen;

import net.hazen.hazennstuff.Datagen.Items.HnSBlockStateProvider;
import net.hazen.hazennstuff.Datagen.Items.HnSBlockTagGenerator;
import net.hazen.hazennstuff.Datagen.Items.HnSItemModelProvider;
import net.hazen.hazennstuff.Datagen.Items.HnSItemTagGenerator;
import net.hazen.hazennstuff.Datagen.Worldgen.HnSWorldGenProvider;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = HazenNStuff.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new HnSRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), HnSLootTableProvider.create(packOutput));

        generator.addProvider(event.includeClient(), new HnSBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new HnSItemModelProvider(packOutput, existingFileHelper));

        HnSBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new HnSBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new HnSItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeServer(), new HnSWorldGenProvider(packOutput, lookupProvider));
    }
}