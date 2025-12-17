package net.hazen.hazennstuff.Datagen.Worldgen.PlacementFeatures;

import net.hazen.hazennstuff.Datagen.Worldgen.HnSConfiguredFeatures;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class HnSPlacedFeatures {
    public static final ResourceKey<PlacedFeature> ZENALITE_ORE_PLACED_KEY = registerKey("zenalite_ore_placed");
    public static final ResourceKey<PlacedFeature> SOLAR_CORE_ORE_PLACED_KEY = registerKey("solar_core_ore_placed");
    public static final ResourceKey<PlacedFeature> RUNESTONE_SLAG_PLACED_KEY = registerKey("runestone_slag_placed");
    public static final ResourceKey<PlacedFeature> CHLOROPHYTE_PLACED_KEY = registerKey("chlorophyte_ore_placed");
    public static final ResourceKey<PlacedFeature> DREADSTONE_PLACED_KEY = registerKey("dreadstone_ore_placed");


    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, ZENALITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(HnSConfiguredFeatures.ZENALITE_ORE_KEY),
                HnSOrePlacement.commonOrePlacement(2,
                        HeightRangePlacement
                                .uniform(VerticalAnchor.absolute(-64),
                                        VerticalAnchor.absolute(80))
                ));

        register(context, SOLAR_CORE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(HnSConfiguredFeatures.SOLAR_CORE_ORE_KEY),
                HnSOrePlacement.commonOrePlacement(5,
                        HeightRangePlacement
                                .uniform(VerticalAnchor.absolute(-64),
                                        VerticalAnchor.absolute(80))
                ));

        register(context, RUNESTONE_SLAG_PLACED_KEY, configuredFeatures.getOrThrow(HnSConfiguredFeatures.RUNESTONE_SLAG_KEY),
                HnSOrePlacement
                        .commonOrePlacement(16, HeightRangePlacement
                                .uniform(VerticalAnchor.absolute(0),
                                        VerticalAnchor.top()))
        );

        register(context, CHLOROPHYTE_PLACED_KEY, configuredFeatures.getOrThrow(HnSConfiguredFeatures.CHLOROPHYTE_ORE_KEY),
                HnSOrePlacement
                        .commonOrePlacement(5, HeightRangePlacement
                                .uniform(VerticalAnchor
                                                .absolute(0),
                                        VerticalAnchor.top()))
        );

        register(context, DREADSTONE_PLACED_KEY, configuredFeatures.getOrThrow(HnSConfiguredFeatures.DREADSTONE_ORE_KEY),
                HnSOrePlacement
                        .commonOrePlacement(12, HeightRangePlacement
                                .uniform(VerticalAnchor
                                        .absolute(-64), VerticalAnchor
                                        .absolute(0)))
        );


    }


    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
