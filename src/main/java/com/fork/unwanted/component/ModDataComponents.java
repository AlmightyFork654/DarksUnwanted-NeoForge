package com.fork.unwanted.component;

import com.fork.unwanted.Unwanted;
import com.mojang.serialization.Codec;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.UnaryOperator;

public class ModDataComponents {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES =
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Unwanted.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> TEA_TYPE = register("tea_type",
            builder -> builder.persistent(Codec.STRING));

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<List<String>>> TEA_ADDITION = register("tea_addition",
            builder -> builder.persistent(Codec.STRING.listOf()));

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<List<String>>> TEA_MODIFIER = register("tea_modifier",
            builder -> builder.persistent(Codec.STRING.listOf()));

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> TEA_TELEPORT = register("tea_teleport",
            builder -> builder.persistent(Codec.STRING));

    private static <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name,
                                                                                           UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return DATA_COMPONENT_TYPES.register(name, () -> builderOperator.apply(DataComponentType.builder()).build());
    }

    public static void register(IEventBus eventBus) {
        DATA_COMPONENT_TYPES.register(eventBus);
    }
}