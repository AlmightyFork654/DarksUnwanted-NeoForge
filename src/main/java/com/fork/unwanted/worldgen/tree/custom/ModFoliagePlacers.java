package com.fork.unwanted.worldgen.tree.custom;

import com.fork.unwanted.Unwanted;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, Unwanted.MOD_ID);

    public static final Supplier<FoliagePlacerType<EbonyFoliagePlacer>> EBONY_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("ebony_foliage_placer", () -> new FoliagePlacerType<>(EbonyFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}
