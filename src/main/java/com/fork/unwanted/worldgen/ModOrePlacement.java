package com.fork.unwanted.worldgen;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModOrePlacement {

    public static List<PlacementModifier> orePlacement(PlacementModifier CountPlacement, PlacementModifier HeightRange) {
        return List.of(CountPlacement, InSquarePlacement.spread(), HeightRange, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int Count, PlacementModifier HeightRange) {
        return orePlacement(CountPlacement.of(Count), HeightRange);
    }

    public static List<PlacementModifier> rareOrePlacement(int Chance, PlacementModifier HeightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(Chance), HeightRange);
    }

}
