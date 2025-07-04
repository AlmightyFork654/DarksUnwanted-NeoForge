package com.fork.unwanted.recipe.category;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.blocks.ModBlocks;
import com.fork.unwanted.items.ModItems;
import com.fork.unwanted.misc.ModTags;
import com.fork.unwanted.recipe.GemCuttingStationRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.checkerframework.checker.nullness.qual.NonNull;

public class GemCuttingStationRecipeCategory implements IRecipeCategory<GemCuttingStationRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID, "gem_cutting");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID, "textures/gui/gem_cutting_station_gui.png");

    public static final RecipeType<GemCuttingStationRecipe> GEM_CUTTING_STATION_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, GemCuttingStationRecipe.class);

    private final IDrawable bg;
    private final IDrawable icon;

    public GemCuttingStationRecipeCategory(IGuiHelper helper) {
        this.bg = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.GEM_CUTTING_STATION.get()));
    }

    @Override
    public RecipeType<GemCuttingStationRecipe> getRecipeType() {
        return GEM_CUTTING_STATION_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Gem Cutting Station");
    }

    @Override
    public IDrawable getBackground() {
        return this.bg;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@NonNull IRecipeLayoutBuilder builder, @NonNull GemCuttingStationRecipe recipe, @NonNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 34, 40).addIngredients(Ingredient.of((ModItems.BLAZING_WATER.get()).getDefaultInstance()));
        builder.addSlot(RecipeIngredientRole.INPUT, 57, 18).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 103, 18).addIngredients(Ingredient.of(ModTags.Items.CHISELS));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 60).addItemStack(recipe.output());
    }
}
