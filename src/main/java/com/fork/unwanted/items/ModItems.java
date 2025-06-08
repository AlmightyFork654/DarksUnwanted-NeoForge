package com.fork.unwanted.items;

import com.fork.unwanted.Unwanted;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(Unwanted.MOD_ID);

    //Items

        //Stone

        //Ores

    public static final DeferredItem<Item> ROUGH_RUBY = ITEMS.register("rough_ruby",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PURE_RUBY = ITEMS.register("pure_ruby",
            () -> new Item(new Item.Properties()));

    //Block Items

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
