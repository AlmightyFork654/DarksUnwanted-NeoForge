package com.fork.unwanted.items;

import com.fork.unwanted.Unwanted;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(Unwanted.MOD_ID);

    //items

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
