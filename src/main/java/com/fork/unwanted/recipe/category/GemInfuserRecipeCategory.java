package com.fork.unwanted.recipe.category;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.blocks.ModBlocks;
import com.fork.unwanted.items.ModItems;
import com.fork.unwanted.recipe.GemInfuserRecipe;
import com.fork.unwanted.recipe.KettleRecipe;
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

import javax.annotation.Nonnull;

public class GemInfuserRecipeCategory implements IRecipeCategory<GemInfuserRecipe> {
    public static final ResourceLocation UID =  ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID, "gem_infuser");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID, "textures/gui/gem_infuser_gui.png");

    public static final RecipeType<GemInfuserRecipe> GEM_INFUSER_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, GemInfuserRecipe.class);

    private final IDrawable bg;
    private final IDrawable icon;

    public GemInfuserRecipeCategory(IGuiHelper helper) {
        this.bg = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.GEM_INFUSER.get()));
    }

    @Override
    public RecipeType<GemInfuserRecipe> getRecipeType() {
        return GEM_INFUSER_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Gem Infuser");
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
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull GemInfuserRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 22).addIngredients(Ingredient.of((ModItems.BLAZING_WATER.get())));
        builder.addSlot(RecipeIngredientRole.INPUT, 80, 31).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 116, 22).addIngredients(recipe.getIngredients().get(1));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 58).addItemStack(recipe.output());
    }
}
