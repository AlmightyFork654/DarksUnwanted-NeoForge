package com.fork.unwanted.recipe.input;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record KettleRecipeInput(ItemStack base, ItemStack ingredient) implements RecipeInput {
    @Override
    public int size() {
        return 2;
    }

    @Override
    public ItemStack getItem(int index) {
        return switch (index) {
            case 0 -> base;
            case 1 -> ingredient;
            default -> throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length 2");
        };
    }

    @Override
    public boolean isEmpty() {
        return base.isEmpty() && ingredient.isEmpty();
    }
}