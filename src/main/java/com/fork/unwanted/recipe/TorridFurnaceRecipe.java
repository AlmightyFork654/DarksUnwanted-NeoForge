package com.fork.unwanted.recipe;

import com.fork.unwanted.recipe.input.TorridFurnaceRecipeInput;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.List;

public record TorridFurnaceRecipe(Ingredient ingot, Ingredient armor, ItemStack output) implements Recipe<TorridFurnaceRecipeInput> {
    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(ingot);
        list.add(armor);
        return list;
    }

    @Override
    public boolean matches(TorridFurnaceRecipeInput input, Level level) {
        return ingot.test(input.ingot()) && armor.test(input.armor());
    }

    @Override
    public ItemStack assemble(TorridFurnaceRecipeInput input, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.TORRID_FURNACE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.TORRID_FURNACE_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<TorridFurnaceRecipe> {
        public static final MapCodec<TorridFurnaceRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Codec.list(Ingredient.CODEC_NONEMPTY).fieldOf("ingredients").forGetter(r -> List.of(r.ingot(), r.armor())),
                ItemStack.CODEC.fieldOf("output").forGetter(TorridFurnaceRecipe::output)
        ).apply(inst, (ingredients, output) -> {
            if (ingredients.size() != 2) {
                throw new IllegalArgumentException("Expected 2 ingredients");
            }
            return new TorridFurnaceRecipe(ingredients.get(0), ingredients.get(1), output);
        }));

        public static final StreamCodec<RegistryFriendlyByteBuf, TorridFurnaceRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, TorridFurnaceRecipe::ingot,
                        Ingredient.CONTENTS_STREAM_CODEC, TorridFurnaceRecipe::armor,
                        ItemStack.STREAM_CODEC, TorridFurnaceRecipe::output,
                        TorridFurnaceRecipe::new
                );

        @Override
        public MapCodec<TorridFurnaceRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, TorridFurnaceRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}