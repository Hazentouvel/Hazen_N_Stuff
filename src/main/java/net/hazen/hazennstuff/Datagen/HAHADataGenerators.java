package net.hazen.hazennstuff.Datagen;

import net.hazen.hazennstuff.Datagen.Tags.HnSItemTagsProvider;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = HazenNStuff.MOD_ID)
public class HAHADataGenerators {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        var lookupProvider = event.getLookupProvider();


        generator.addProvider(true, new HnSRecipeProvider.Runner(packOutput, lookupProvider));
        generator.addProvider(true, new HnSItemTagsProvider(packOutput, lookupProvider));
    }
}