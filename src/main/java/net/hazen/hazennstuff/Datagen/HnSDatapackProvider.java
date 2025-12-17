package net.hazen.hazennstuff.Datagen;

import net.hazen.hazennstuff.Datagen.Worldgen.Biomes.HnSBiomeModifiers;
import net.hazen.hazennstuff.Datagen.Worldgen.HnSConfiguredFeatures;
import net.hazen.hazennstuff.Datagen.Worldgen.PlacementFeatures.HnSPlacedFeatures;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class HnSDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, HnSConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, HnSPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, HnSBiomeModifiers::bootstrap)

            ;

    public HnSDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(HazenNStuff.MOD_ID));
    }
}
