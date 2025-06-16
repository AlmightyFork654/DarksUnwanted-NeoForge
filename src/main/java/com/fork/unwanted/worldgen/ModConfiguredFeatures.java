package com.fork.unwanted.worldgen;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.blocks.ModBlocks;
import com.fork.unwanted.worldgen.tree.custom.EbonyFoliagePlacer;
import com.fork.unwanted.worldgen.tree.custom.EbonyTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;

public class ModConfiguredFeatures {
//    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_BISMUTH_ORE_KEY = registerKey("bismuth_ore");
//    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_BISMUTH_ORE_KEY = registerKey("nether_bismuth_ore");
//    public static final ResourceKey<ConfiguredFeature<?, ?>> END_BISMUTH_ORE_KEY = registerKey("end_bismuth_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> EBONY_KEY = registerKey("ebony");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TORRID_KEY = registerKey("torrid_bush");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
//        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
//        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
//        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
//        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);
//
//        List<OreConfiguration.TargetBlockState> overworldBismuthOres = List.of(
//                OreConfiguration.target(stoneReplaceables, ModBlocks.BISMUTH_ORE.get().defaultBlockState()),
//                OreConfiguration.target(deepslateReplaceables, ModBlocks.BISMUTH_DEEPSLATE_ORE.get().defaultBlockState()));
//
//        register(context, OVERWORLD_BISMUTH_ORE_KEY, Feature.ORE, new OreConfiguration(overworldBismuthOres, 9));
//        register(context, NETHER_BISMUTH_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
//                ModBlocks.BISMUTH_NETHER_ORE.get().defaultBlockState(), 9));
//        register(context, END_BISMUTH_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
//                ModBlocks.BISMUTH_END_ORE.get().defaultBlockState(), 9));


        register(context, EBONY_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.EBONY_LOG.get()),
                new EbonyTrunkPlacer(2, 2, 2),
                BlockStateProvider.simple(ModBlocks.EBONY_LEAVES.get()),
                new EbonyFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), 5),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, TORRID_KEY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(
                8, 6, 4, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.TORRID_BUSH.get())))));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
