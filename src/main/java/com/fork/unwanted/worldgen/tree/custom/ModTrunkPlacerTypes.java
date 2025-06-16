package com.fork.unwanted.worldgen.tree.custom;

import com.fork.unwanted.Unwanted;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModTrunkPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, Unwanted.MOD_ID);

    public static final Supplier<TrunkPlacerType<EbonyTrunkPlacer>> EBONY_TRUNK_PLACER =
            TRUNK_PLACER.register("ebony_trunk_placer", () -> new TrunkPlacerType<>(EbonyTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER.register(eventBus);
    }
}
