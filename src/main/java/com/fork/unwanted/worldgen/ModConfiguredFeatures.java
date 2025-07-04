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
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> EBONY_KEY = registerKey("ebony");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TORRID_KEY = registerKey("torrid_bush");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_KEY = registerKey("ruby");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EMBARIUM_ORE_KEY = registerKey("embarium");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TORRID_ORE_KEY = registerKey("torrid");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PROFUNDIUM_ORE_KEY = registerKey("profundium");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MARBLE_ORE_KEY = registerKey("marble_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endstoneReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> embariumOres = List.of(OreConfiguration.target(stoneReplaceables,
                        ModBlocks.EMBARIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_EMBARIUM_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> ProfundiumOres = List.of(OreConfiguration.target(stoneReplaceables,
                        ModBlocks.PROFUNDIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.PROFUNDIUM_ORE.get().defaultBlockState()));

        register(context, EMBARIUM_ORE_KEY, Feature.ORE, new OreConfiguration(embariumOres, 6));
        register(context, PROFUNDIUM_ORE_KEY, Feature.ORE, new OreConfiguration(ProfundiumOres, 3));
        register(context, RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(endstoneReplaceables,
                ModBlocks.RUBY_ORE.get().defaultBlockState(), 4));
        register(context, TORRID_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.TORRID_STEEL_ORE.get().defaultBlockState(), 9));

        register(context, MARBLE_ORE_KEY, Feature.ORE, new OreConfiguration(stoneReplaceables,
                ModBlocks.MARBLE.get().defaultBlockState(), 32));

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
