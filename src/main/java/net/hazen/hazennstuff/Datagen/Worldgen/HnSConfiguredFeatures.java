package net.hazen.hazennstuff.Datagen.Worldgen;

import net.hazen.hazennstuff.Block.HnSBlocks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class HnSConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?,?>> ZENALITE_ORE_KEY = registerKey("zenalite_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> RUNESTONE_SLAG_KEY = registerKey("runestone_slag");
    public static final ResourceKey<ConfiguredFeature<?,?>> SOLAR_CORE_ORE_KEY = registerKey("solar_core_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> CHLOROPHYTE_ORE_KEY = registerKey("chlorophyte_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> DREADSTONE_ORE_KEY = registerKey("dreadstone_ore");


    public static final ResourceKey<ConfiguredFeature<?,?>> WISEWOOD_KEY =  registerKey("wisewood");
    public static final ResourceKey<ConfiguredFeature<?,?>> FROSTBITE_BIRCH_KEY =  registerKey("frostbite_birch");


    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest blackstoneReplaceables = new BlockMatchTest(Blocks.BLACKSTONE);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);
        RuleTest mudReplaceables = new BlockMatchTest(Blocks.MUD);

        List<OreConfiguration.TargetBlockState> netherSolarCoreOres = List.of(
                OreConfiguration.target(netherrackReplaceables, HnSBlocks.SOLAR_CORE_NETHERACK_ORE.get().defaultBlockState()),
                OreConfiguration.target(blackstoneReplaceables, HnSBlocks.SOLAR_CORE_BLACKSTONE_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> overworldRunestoneSlag = List.of(
                OreConfiguration.target(stoneReplaceables, HnSBlocks.RUNESTONE_SLAG.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, HnSBlocks.RUNESTONE_SLAG.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> endZenaliteOres = List.of(
                OreConfiguration.target(endReplaceables, HnSBlocks.ZENALITE_END_STONE_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> overworldChlorophyteOres = List.of(
                OreConfiguration.target(mudReplaceables, HnSBlocks.CHLOROPHYTE_ORE.get().defaultBlockState()),
                OreConfiguration.target(stoneReplaceables, HnSBlocks.CHLOROPHYTE_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> overworldDreadstoneOres = List.of(
                OreConfiguration.target(deepslateReplaceables, HnSBlocks.DREADSTONE_ORE.get().defaultBlockState())
        );

        register(context, SOLAR_CORE_ORE_KEY, Feature.ORE, new OreConfiguration(netherSolarCoreOres, 6));
        register(context, RUNESTONE_SLAG_KEY, Feature.ORE, new OreConfiguration(overworldRunestoneSlag, 16));
        register(context, ZENALITE_ORE_KEY, Feature.ORE, new OreConfiguration(endZenaliteOres, 6));
        register(context, CHLOROPHYTE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldChlorophyteOres, 6));
        register(context, DREADSTONE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldDreadstoneOres, 6));


        register(context, WISEWOOD_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(HnSBlocks.WISEWOOD_LOG.get()),
                new ForkingTrunkPlacer(2, 1, 2),

                BlockStateProvider.simple(HnSBlocks.WISEWOOD_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, FROSTBITE_BIRCH_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(HnSBlocks.FROSTBITE_BIRCH_LOG.get()),
                new ForkingTrunkPlacer(2, 1, 2),

                BlockStateProvider.simple(HnSBlocks.PERMAFROST_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, name));

    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
