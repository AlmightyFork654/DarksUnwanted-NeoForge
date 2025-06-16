package com.fork.unwanted.worldgen.tree;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower EBONY = new TreeGrower(Unwanted.MOD_ID + ":ebony",
            Optional.empty(), Optional.of(ModConfiguredFeatures.EBONY_KEY), Optional.empty());
}
