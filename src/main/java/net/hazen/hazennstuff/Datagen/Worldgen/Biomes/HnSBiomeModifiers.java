package net.hazen.hazennstuff.Datagen.Worldgen.Biomes;

import net.hazen.hazennstuff.Datagen.Worldgen.PlacementFeatures.HnSPlacedFeatures;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class HnSBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_ZENALITE_ORE = registerKey("add_zenalite_ore");
    public static final ResourceKey<BiomeModifier> ADD_SOLAR_CORE_ORE = registerKey("add_solar_core_ore");
    public static final ResourceKey<BiomeModifier> ADD_RUNESTONE_SLAG = registerKey("add_runestone_slag");
    public static final ResourceKey<BiomeModifier> ADD_CHLOROPHYTE_ORE = registerKey("add_chlorophyte_ore");
    public static final ResourceKey<BiomeModifier> ADD_DREADSTONE_ORE = registerKey("add_dreadstone_ore");


    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_RUNESTONE_SLAG, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(HnSPlacedFeatures.RUNESTONE_SLAG_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_SOLAR_CORE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(HnSPlacedFeatures.SOLAR_CORE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_ZENALITE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.END_BARRENS), biomes.getOrThrow(Biomes.END_MIDLANDS), biomes.getOrThrow(Biomes.END_HIGHLANDS)),
                HolderSet.direct(placedFeatures.getOrThrow(HnSPlacedFeatures.ZENALITE_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_CHLOROPHYTE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.JUNGLE), biomes.getOrThrow(Biomes.BAMBOO_JUNGLE)),
                HolderSet.direct(placedFeatures.getOrThrow(HnSPlacedFeatures.CHLOROPHYTE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_DREADSTONE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(HnSPlacedFeatures.DREADSTONE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

    }



    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, name));
    }
}
