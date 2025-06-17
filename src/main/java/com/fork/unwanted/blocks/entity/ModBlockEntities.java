package com.fork.unwanted.blocks.entity;


import com.fork.unwanted.Unwanted;
import com.fork.unwanted.blocks.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
    DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Unwanted.MOD_ID);

//    public static final RegistryObject<BlockEntityType<GemCuttingStationBlockEntity>> GEM_CUTTING_STATION_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("gem_cutting_station_block_entity",
//            () -> BlockEntityType.Builder.of(GemCuttingStationBlockEntity::new, ModBlocks.GEM_CUTTING_STATION.get()).build(null));
//
//    public static final RegistryObject<BlockEntityType<GemInfuserBlockEntity>> GEM_INFUSER_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("gem_infuser_block_entity",
//            () -> BlockEntityType.Builder.of(GemInfuserBlockEntity::new, ModBlocks.GEM_INFUSER.get()).build(null));
//
//    public static final RegistryObject<BlockEntityType<TorridFurnaceBlockEntity>> TORRID_FURNACE_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("torrid_furnace_block_entity",
//            () -> BlockEntityType.Builder.of(TorridFurnaceBlockEntity::new, ModBlocks.TORRID_FURNACE.get()).build(null));
//
//    public static final RegistryObject<BlockEntityType<KettleBlockEntity>> KETTLE_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("kettle_block_entity",
//            () -> BlockEntityType.Builder.of(KettleBlockEntity::new, ModBlocks.KETTLE.get()).build(null));

    public static final Supplier<BlockEntityType<ModSignBlockEntity>> MOD_SIGN = BLOCK_ENTITY_TYPES.register("mod_sign",
            () -> BlockEntityType.Builder.of(ModSignBlockEntity::new, ModBlocks.EBONY_SIGN.get(), ModBlocks.EBONY_WALL_SIGN.get()).build(null));

    public static final Supplier<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN = BLOCK_ENTITY_TYPES.register("mod_hanging_sign",
            () -> BlockEntityType.Builder.of(ModHangingSignBlockEntity::new, ModBlocks.EBONY_HANGING_SIGN.get(), ModBlocks.EBONY_WALL_HANGING_SIGN.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY_TYPES.register(eventBus);
    }
}
