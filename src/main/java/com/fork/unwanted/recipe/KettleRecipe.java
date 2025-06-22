package com.fork.unwanted.recipe;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.component.ModDataComponents;
import com.fork.unwanted.misc.ModTags;
import com.fork.unwanted.recipe.input.KettleRecipeInput;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

public record KettleRecipe(Ingredient base, Ingredient ingredient, ItemStack output) implements Recipe<KettleRecipeInput> {
    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(base);
        list.add(ingredient);
        return list;
    }

    @Override
    public boolean matches(KettleRecipeInput input, Level level) {
        ItemStack baseItem = input.base();
        ItemStack ingredientItem = input.ingredient();
        if (!base.test(baseItem) || !ingredient.test(ingredientItem)) {
            return false;
        }

        String teaType = baseItem.getOrDefault(ModDataComponents.TEA_TYPE.get(), "");
        List<String> additions = baseItem.getOrDefault(ModDataComponents.TEA_ADDITION.get(), List.of());
        List<String> modifiers = baseItem.getOrDefault(ModDataComponents.TEA_MODIFIER.get(), List.of());
        String teleport = baseItem.getOrDefault(ModDataComponents.TEA_TELEPORT.get(), "");
        int glowstoneCount = (int) modifiers.stream().filter(mod -> mod.equals("glowstone")).count();

        if (ingredientItem.is(ModTags.Items.TELEPORTS) && !teleport.isEmpty()) {
            return false;
        }

        if (ingredientItem.is(Items.GLOWSTONE_DUST) && glowstoneCount >= 3) {
            return false;
        }

        if (ingredientItem.is(ModTags.Items.ADDITIVES)) {
            String additive = getAdditiveFromIngredient(ingredientItem);
            return additive != null && !additions.contains(additive);
        }

        return true;
    }

    @Override
    public ItemStack assemble(KettleRecipeInput input, HolderLookup.Provider provider) {
        ItemStack outputCopy = output.copy();
        ItemStack baseItem = input.base();
        ItemStack ingredientItem = input.ingredient();

        String teaType = baseItem.getOrDefault(ModDataComponents.TEA_TYPE.get(), "");
        List<String> additions = new ArrayList<>(baseItem.getOrDefault(ModDataComponents.TEA_ADDITION.get(), List.of()));
        List<String> modifiers = new ArrayList<>(baseItem.getOrDefault(ModDataComponents.TEA_MODIFIER.get(), List.of()));
        String teleport = baseItem.getOrDefault(ModDataComponents.TEA_TELEPORT.get(), "");

        if (ingredientItem.is(ModTags.Items.BASE_TEA) && teaType.isEmpty()) {
            teaType = getTeaTypeFromIngredient(ingredientItem);
        } else if (ingredientItem.is(ModTags.Items.TELEPORTS) && teleport.isEmpty()) {
            teleport = getTeleportFromIngredient(ingredientItem);
        } else if (ingredientItem.is(ModTags.Items.MODS)) {
            String mod = getModFromIngredient(ingredientItem);
            if (mod != null) {
                modifiers.add(mod);
            }
        } else if (ingredientItem.is(ModTags.Items.ADDITIVES)) {
            String additive = getAdditiveFromIngredient(ingredientItem);
            if (additive != null) {
                additions.add(additive);
            }
        }

        additions.sort(String::compareTo);
        modifiers.sort(String::compareTo);

        outputCopy.set(ModDataComponents.TEA_TYPE, teaType);
        outputCopy.set(ModDataComponents.TEA_ADDITION, List.copyOf(additions));
        outputCopy.set(ModDataComponents.TEA_MODIFIER, List.copyOf(modifiers));
        outputCopy.set(ModDataComponents.TEA_TELEPORT, teleport);

        return outputCopy;
    }

    private String getTeaTypeFromIngredient(ItemStack ingredient) {
        if (ingredient.is(ModTags.Items.GRASSY)) return "grassy";
        if (ingredient.is(ModTags.Items.WARPED)) return "warped";
        if (ingredient.is(ModTags.Items.CRIMSON)) return "crimson";
        if (ingredient.is(ModTags.Items.LEAVY)) return "leavy";
        if (ingredient.is(ModTags.Items.KELPED)) return "kelped";
        if (ingredient.is(ModTags.Items.VINEY)) return "viney";
        if (ingredient.is(ModTags.Items.GLOWY)) return "glowy";
        if (ingredient.is(ModTags.Items.SCULKED)) return "sculked";
        if (ingredient.is(ModTags.Items.ROOTED)) return "rooted";
        return "";
    }

    private String getTeleportFromIngredient(ItemStack ingredient) {
        if (ingredient.is(ModTags.Items.SPAWN)) return "spawn";
        if (ingredient.is(ModTags.Items.OVERWORLD)) return "overworld";
        if (ingredient.is(ModTags.Items.NETHER)) return "nether";
        if (ingredient.is(ModTags.Items.END)) return "end";
        return "";
    }

    private String getModFromIngredient(ItemStack ingredient) {
        if (ingredient.is(Items.REDSTONE)) return "redstone";
        if (ingredient.is(Items.GLOWSTONE_DUST)) return "glowstone";
        if (ingredient.is(Items.GUNPOWDER)) return "gunpowder";
        return null;
    }

    private String getAdditiveFromIngredient(ItemStack ingredient) {
        if (ingredient.is(ModTags.Items.RED_STUFF)) return "red_stuff";
        if (ingredient.is(ModTags.Items.GOLDEN_FRUIT)) return "golden_fruit";
        if (ingredient.is(ModTags.Items.GOD_APPLE)) return "god_apple";
        if (ingredient.is(ModTags.Items.SWEET)) return "sweet";
        if (ingredient.is(ModTags.Items.GLOWING_FRUIT)) return "glowing_fruit";
        if (ingredient.is(ModTags.Items.PINK_FLOWER)) return "pink_flower";
        if (ingredient.is(ModTags.Items.YELLOW_FLOWER)) return "yellow_flower";
        if (ingredient.is(ModTags.Items.WHITE_FLOWER)) return "white_flower";
        if (ingredient.is(ModTags.Items.GREY_FLOWER)) return "grey_flower";
        if (ingredient.is(ModTags.Items.BLUE_FLOWER)) return "blue_flower";
        if (ingredient.is(ModTags.Items.PURPLE_FLOWER1)) return "purple_flower_1";
        if (ingredient.is(ModTags.Items.PURPLE_FLOWER2)) return "purple_flower_2";
        if (ingredient.is(ModTags.Items.RED_FLOWER)) return "red_flower";
        if (ingredient.is(ModTags.Items.END_FLOWER)) return "end_flower";
        if (ingredient.is(ModTags.Items.FIRE_FLOWER)) return "fire_flower";
        if (ingredient.is(ModTags.Items.POT_FLOWER)) return "pot_flower";
        if (ingredient.is(ModTags.Items.WING)) return "wing";
        if (ingredient.is(ModTags.Items.FIRE)) return "fire";
        if (ingredient.is(ModTags.Items.TORRID)) return "torrid";
        if (ingredient.is(ModTags.Items.WITHER)) return "wither_flower";
        return null;
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
        return ModRecipes.KETTLE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.KETTLE_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<KettleRecipe> {
        public static final MapCodec<KettleRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Codec.list(Ingredient.CODEC_NONEMPTY).fieldOf("ingredients").forGetter(r -> List.of(r.base(), r.ingredient())),
                ItemStack.CODEC.fieldOf("output").forGetter(KettleRecipe::output)
        ).apply(inst, (ingredients, output) -> {
            if (ingredients.size() != 2) {
                throw new IllegalArgumentException("Expected 2 ingredients");
            }
            return new KettleRecipe(ingredients.get(0), ingredients.get(1), output);
        }));

        public static final StreamCodec<RegistryFriendlyByteBuf, KettleRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, KettleRecipe::base,
                        Ingredient.CONTENTS_STREAM_CODEC, KettleRecipe::ingredient,
                        ItemStack.STREAM_CODEC, KettleRecipe::output,
                        KettleRecipe::new
                );

        @Override
        public MapCodec<KettleRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, KettleRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}