package net.hazen.hazennstuff.Datagen.Worldgen;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class HnSPlacedFeatures {
    public static final ResourceKey<PlacedFeature> END_ZENALITE_ORE_PLACED_KEY = registerKey("end_zenalite_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, END_ZENALITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(HnSConfiguredFeatures.END_ZENALITE_ORE_PLACED_KEY),
                HnSOrePlacement.commonOrePlacement(
                        12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(80))
                ));
    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(HazenNStuff.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
