package com.fork.unwanted.screen;

import com.fork.unwanted.Unwanted;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(BuiltInRegistries.MENU, Unwanted.MOD_ID);

    public static final Supplier<MenuType<GemCuttingStationMenu>> GEM_CUTTING_STATION_MENU =
            registerMenuType(GemCuttingStationMenu::new, "gem_cutting_station_menu");

    public static final Supplier<MenuType<GemInfuserMenu>> GEM_INFUSER_MENU =
            registerMenuType(GemInfuserMenu::new, "gem_infuser_menu");

    public static final Supplier<MenuType<TorridFurnaceMenu>> TORRID_FURNACE_MENU =
            registerMenuType(TorridFurnaceMenu::new, "torrid_furnace_menu");

    public static final Supplier<MenuType<KettleMenu>> KETTLE_MENU =
            registerMenuType(KettleMenu::new, "kettle_menu");

    private static <T extends AbstractContainerMenu>Supplier<MenuType<T>> registerMenuType(IContainerFactory<T> factory,
                                                                                           String name) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
