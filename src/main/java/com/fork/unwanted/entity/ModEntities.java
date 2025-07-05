package com.fork.unwanted.entity;


import com.fork.unwanted.Unwanted;
import com.fork.unwanted.entity.custom.ModBoatEntity;
import com.fork.unwanted.entity.custom.ModChestBoatEntity;
import com.fork.unwanted.items.spear.ThrownSpear;
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

    public static final Supplier<EntityType<ThrownSpear>> WOODEN_SPEAR =
            ENTITY_TYPES.register("wooden_spear", () -> EntityType.Builder.<ThrownSpear>of(ThrownSpear::new,
                    MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("wooden_spear"));
    public static final Supplier<EntityType<ThrownSpear>> STONE_SPEAR =
            ENTITY_TYPES.register("stone_spear", () -> EntityType.Builder.<ThrownSpear>of(ThrownSpear::new,
                    MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("stone_spear"));
    public static final Supplier<EntityType<ThrownSpear>> GOLDEN_SPEAR =
            ENTITY_TYPES.register("golden_spear", () -> EntityType.Builder.<ThrownSpear>of(ThrownSpear::new,
                    MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("golden_spear"));
    public static final Supplier<EntityType<ThrownSpear>> IRON_SPEAR =
            ENTITY_TYPES.register("iron_spear", () -> EntityType.Builder.<ThrownSpear>of(ThrownSpear::new,
                    MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("iron_spear"));
    public static final Supplier<EntityType<ThrownSpear>> EMBARIUM_SPEAR =
            ENTITY_TYPES.register("embarium_spear", () -> EntityType.Builder.<ThrownSpear>of(ThrownSpear::new,
                    MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("embarium_spear"));
    public static final Supplier<EntityType<ThrownSpear>> TORRID_STEEL_SPEAR =
            ENTITY_TYPES.register("torrid_steel_spear", () -> EntityType.Builder.<ThrownSpear>of(ThrownSpear::new,
                    MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("torrid_steel_spear"));
    public static final Supplier<EntityType<ThrownSpear>> DIAMOND_SPEAR =
            ENTITY_TYPES.register("diamond_spear", () -> EntityType.Builder.<ThrownSpear>of(ThrownSpear::new,
                    MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("diamond_spear"));
    public static final Supplier<EntityType<ThrownSpear>> NETHERITE_SPEAR =
            ENTITY_TYPES.register("netherite_spear", () -> EntityType.Builder.<ThrownSpear>of(ThrownSpear::new,
                    MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("netherite_spear"));
    public static final Supplier<EntityType<ThrownSpear>> PROFUNDIUM_SPEAR =
            ENTITY_TYPES.register("profundium_spear", () -> EntityType.Builder.<ThrownSpear>of(ThrownSpear::new,
                    MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build("profundium_spear"));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
