package com.fork.unwanted.recipe.input;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record GemInfuserRecipeInput(ItemStack armor, ItemStack gem) implements RecipeInput {
    @Override
    public int size() {
        return 2;
    }

    @Override
    public ItemStack getItem(int index) {
        return switch (index) {
            case 0 -> armor;
            case 1 -> gem;
            default -> throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length 2");
        };
    }

    @Override
    public boolean isEmpty() {
        return armor.isEmpty() && gem.isEmpty();
    }
}