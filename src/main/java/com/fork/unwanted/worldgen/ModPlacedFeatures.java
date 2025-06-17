package com.fork.unwanted.worldgen;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.blocks.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> EBONY_PLACED_KEY = registerKey("ebony_placed");

    public static final ResourceKey<PlacedFeature> TORRID_BUSH_PLACED_KEY = registerKey("torrid_bush_placed");

    public static final ResourceKey<PlacedFeature> RUBY_PLACED_KEY = registerKey("ruby_placed");
    public static final ResourceKey<PlacedFeature> EMBARIUM_PLACED_KEY = registerKey("embarium_placed");
    public static final ResourceKey<PlacedFeature> TORRID_PLACED_KEY = registerKey("torrid_placed");
    public static final ResourceKey<PlacedFeature> PROFUNDIUM_PLACED_KEY = registerKey("profundium_placed");

    public static final ResourceKey<PlacedFeature> MARBLE_ORE_PLACED_KEY = registerKey("marble_ore_placed");


    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, EBONY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.EBONY_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(5, 0.2f, 5),
                        ModBlocks.EBONY_SAPLING.get()));

        register(context, TORRID_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TORRID_KEY),
                List.of(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome()));

        register(context, EMBARIUM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.EMBARIUM_ORE_KEY),
                ModOrePlacement.commonOrePlacement( 12, //veins per chunk
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(160)))); // spawn levels
        register(context, PROFUNDIUM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PROFUNDIUM_ORE_KEY),
                ModOrePlacement.commonOrePlacement( 4, //veins per chunk
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-40)))); // spawn levels
        register(context, RUBY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RUBY_ORE_KEY),
                ModOrePlacement.commonOrePlacement( 8, //veins per chunk
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80)))); // spawn levels
        register(context, TORRID_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TORRID_ORE_KEY),
                ModOrePlacement.commonOrePlacement( 24, //veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(240)))); // spawn levels

        register(context, MARBLE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MARBLE_ORE_KEY),
                ModOrePlacement.commonOrePlacement( 5, //veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(240)))); // spawn levels

    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
