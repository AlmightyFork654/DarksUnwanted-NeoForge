package com.fork.unwanted.recipe;

import com.fork.unwanted.recipe.input.GemInfuserRecipeInput;
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

public record GemInfuserRecipe(Ingredient armor, Ingredient gem, ItemStack output) implements Recipe<GemInfuserRecipeInput> {
    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(armor);
        list.add(gem);
        return list;
    }

    @Override
    public boolean matches(GemInfuserRecipeInput input, Level level) {
        return armor.test(input.armor()) && gem.test(input.gem());
    }

    @Override
    public ItemStack assemble(GemInfuserRecipeInput input, HolderLookup.Provider provider) {
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
        return ModRecipes.GEM_INFUSER_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.GEM_INFUSER_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<GemInfuserRecipe> {
        public static final MapCodec<GemInfuserRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Codec.list(Ingredient.CODEC_NONEMPTY).fieldOf("ingredients").forGetter(r -> List.of(r.armor(), r.gem())),
                ItemStack.CODEC.fieldOf("output").forGetter(GemInfuserRecipe::output)
        ).apply(inst, (ingredients, output) -> {
            if (ingredients.size() != 2) {
                throw new IllegalArgumentException("Expected 2 ingredients");
            }
            return new GemInfuserRecipe(ingredients.get(0), ingredients.get(1), output);
        }));

        public static final StreamCodec<RegistryFriendlyByteBuf, GemInfuserRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, GemInfuserRecipe::armor,
                        Ingredient.CONTENTS_STREAM_CODEC, GemInfuserRecipe::gem,
                        ItemStack.STREAM_CODEC, GemInfuserRecipe::output,
                        GemInfuserRecipe::new
                );

        @Override
        public MapCodec<GemInfuserRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, GemInfuserRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}