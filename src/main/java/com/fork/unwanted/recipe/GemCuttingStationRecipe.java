package com.fork.unwanted.recipe;

import com.fork.unwanted.recipe.input.GemCuttingStationRecipeInput;
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

public record GemCuttingStationRecipe(Ingredient gem, Ingredient chisel, ItemStack output) implements Recipe<GemCuttingStationRecipeInput> {
    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(gem);
        list.add(chisel);
        return list;
    }

    @Override
    public boolean matches(GemCuttingStationRecipeInput input, Level level) {
        return gem.test(input.gem()) && chisel.test(input.chisel());
    }

    @Override
    public ItemStack assemble(GemCuttingStationRecipeInput input, HolderLookup.Provider provider) {
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
        return ModRecipes.GEM_CUTTING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.GEM_CUTTING_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<GemCuttingStationRecipe> {
        public static final MapCodec<GemCuttingStationRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Codec.list(Ingredient.CODEC_NONEMPTY).fieldOf("ingredients").forGetter(r -> List.of(r.gem(), r.chisel())),
                ItemStack.CODEC.fieldOf("output").forGetter(GemCuttingStationRecipe::output)
        ).apply(inst, (ingredients, output) -> {
            if (ingredients.size() != 2) {
                throw new IllegalArgumentException("Expected 2 ingredients");
            }
            return new GemCuttingStationRecipe(ingredients.get(0), ingredients.get(1), output);
        }));

        public static final StreamCodec<RegistryFriendlyByteBuf, GemCuttingStationRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, GemCuttingStationRecipe::gem,
                        Ingredient.CONTENTS_STREAM_CODEC, GemCuttingStationRecipe::chisel,
                        ItemStack.STREAM_CODEC, GemCuttingStationRecipe::output,
                        GemCuttingStationRecipe::new
                );

        @Override
        public MapCodec<GemCuttingStationRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, GemCuttingStationRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}