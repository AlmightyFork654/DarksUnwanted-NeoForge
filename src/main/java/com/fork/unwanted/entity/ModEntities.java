package com.fork.unwanted.entity;


import com.fork.unwanted.Unwanted;
import com.fork.unwanted.entity.custom.ModBoatEntity;
import com.fork.unwanted.entity.custom.ModChestBoatEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Unwanted.MOD_ID);

    public static final Supplier<EntityType<ModBoatEntity>> MOD_BOAT =
            ENTITY_TYPES.register("mod_boat", () -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new,
                    MobCategory.MISC).sized(1.375f, 0.5625f).build("mod_boat"));
    public static final Supplier<EntityType<ModChestBoatEntity>> MOD_CHEST_BOAT =
            ENTITY_TYPES.register("mod_chest_boat", () -> EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new,
                    MobCategory.MISC).sized(1.375f, 0.5625f).build("mod_chest_boat"));

//    public static final Supplier<EntityType<WoodenThrownSpear>> WOODEN_SPEAR =
//            ENTITY_TYPES.register("wooden_spear", () -> EntityType.Builder.<WoodenThrownSpear>of(WoodenThrownSpear::new,
//                    MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("wooden_spear"));
//
//    public static final Supplier<EntityType<IronThrownSpear>> IRON_SPEAR =
//            ENTITY_TYPES.register("iron_spear", () -> EntityType.Builder.<IronThrownSpear>of(IronThrownSpear::new,
//                    MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("iron_spear"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
