package com.fork.unwanted.recipe.input;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record GemCuttingStationRecipeInput(ItemStack gem, ItemStack chisel) implements RecipeInput {
    @Override
    public int size() {
        return 2;
    }

    @Override
    public ItemStack getItem(int index) {
        return switch (index) {
            case 0 -> gem;
            case 1 -> chisel;
            default -> throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length 2");
        };
    }

    @Override
    public boolean isEmpty() {
        return gem.isEmpty() && chisel.isEmpty();
    }
}
