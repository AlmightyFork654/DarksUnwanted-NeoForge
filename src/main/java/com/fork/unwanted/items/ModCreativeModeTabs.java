package com.fork.unwanted.items;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Unwanted.MOD_ID);

    public static final Supplier<CreativeModeTab> ITEMS_TAB = CREATIVE_MODE_TAB.register("items_tab", () ->
        CreativeModeTab.builder().icon(() -> new ItemStack(Items.STICK)) //ruby
                .title(Component.translatable("itemGroup.ItemsTab"))
                .displayItems((itemDisplayParameters, output) -> {
                    output.accept(Items.STICK);
                }).build());
    public static final Supplier<CreativeModeTab> BLOCKS_TAB = CREATIVE_MODE_TAB.register("blocks_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Items.STICK)) // marble block
                    .title(Component.translatable("itemGroup.BlocksTab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Items.STICK);
                    }).build());
    public static final Supplier<CreativeModeTab> TOOLS_TAB = CREATIVE_MODE_TAB.register("tools_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Items.STICK)) // embarium sword
                    .title(Component.translatable("itemGroup.ToolsTab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Items.STICK);
                    }).build());
    public static final Supplier<CreativeModeTab> COMBAT_TAB = CREATIVE_MODE_TAB.register("combat_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(Items.STICK)) // embarium chestplate
                    .title(Component.translatable("itemGroup.CombatTab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Items.STICK);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
