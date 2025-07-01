package com.fork.unwanted.villager;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.blocks.ModBlocks;
import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModVillagers {

    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, Unwanted.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, Unwanted.MOD_ID);


    //enchanter
    public static final Holder<PoiType> ENCHANTING_TABLE = POI_TYPES.register("enchanting_table",
            () -> new PoiType(ImmutableSet.copyOf(Blocks.ENCHANTING_TABLE.getStateDefinition().getPossibleStates()), 1, 1));
    public static final Holder<VillagerProfession> ENCHANTER = VILLAGER_PROFESSIONS.register("enchanter",
            () -> new VillagerProfession("enchanter", holder -> holder.value() ==  ENCHANTING_TABLE.value(), holder -> holder.value() == ENCHANTING_TABLE.value(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_LIBRARIAN));

    //musician
    public static final Holder<PoiType> JUKEBOX = POI_TYPES.register("jukebox",
            () -> new PoiType(ImmutableSet.copyOf(Blocks.JUKEBOX.getStateDefinition().getPossibleStates()), 1, 1));
    public static final Holder<VillagerProfession> MUSICIAN = VILLAGER_PROFESSIONS.register("musician",
            () -> new VillagerProfession("musician", holder -> holder.value() ==   JUKEBOX.value(), holder -> holder.value() == JUKEBOX.value(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_MASON));

    //gem cutter
    public static final Holder<PoiType> GEM_CUTTING_STATION = POI_TYPES.register("gem_cutting_station",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.GEM_CUTTING_STATION.get().getStateDefinition().getPossibleStates()), 1, 1));
    public static final Holder<VillagerProfession> GEM_CUTTER = VILLAGER_PROFESSIONS.register("gem_cutter",
            () -> new VillagerProfession("gem_cutter", holder -> holder.value() ==   GEM_CUTTING_STATION.value(), holder -> holder.value() == GEM_CUTTING_STATION.value(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));

    //collecter
    public static final Holder<PoiType> COLLECTING_STATION = POI_TYPES.register("collecting_station",
            () -> new PoiType(ImmutableSet.copyOf(Blocks.SHULKER_BOX.getStateDefinition().getPossibleStates()), 1, 1));
    public static final Holder<VillagerProfession> COLLECTOR = VILLAGER_PROFESSIONS.register("collector",
            () -> new VillagerProfession("collector", holder -> holder.value() ==   COLLECTING_STATION.value(), holder -> holder.value() == COLLECTING_STATION.value(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_LIBRARIAN));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
