package com.fork.unwanted.compat;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.blocks.ModBlocks;
import com.fork.unwanted.recipe.*;
import com.fork.unwanted.recipe.category.GemCuttingStationRecipeCategory;
import com.fork.unwanted.recipe.category.GemInfuserRecipeCategory;
import com.fork.unwanted.recipe.category.KettleRecipeCategory;
import com.fork.unwanted.recipe.category.TorridFurnaceRecipeCategory;
import com.fork.unwanted.screen.GemCuttingStationScreen;
import com.fork.unwanted.screen.GemInfuserScreen;
import com.fork.unwanted.screen.KettleScreen;
import com.fork.unwanted.screen.TorridFurnaceScreen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIUnwantedPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                GemCuttingStationRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                GemInfuserRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                TorridFurnaceRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new
                KettleRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<GemCuttingStationRecipe> GemCuttingRecipes = recipeManager
                .getAllRecipesFor(ModRecipes.GEM_CUTTING_TYPE.get()).stream().map(RecipeHolder::value).toList();
        registration.addRecipes(GemCuttingStationRecipeCategory.GEM_CUTTING_STATION_RECIPE_RECIPE_TYPE, GemCuttingRecipes);

        List<GemInfuserRecipe> GemInfuserRecipes = recipeManager
                .getAllRecipesFor(ModRecipes.GEM_INFUSER_TYPE.get()).stream().map(RecipeHolder::value).toList();
        registration.addRecipes(GemInfuserRecipeCategory.GEM_INFUSER_RECIPE_RECIPE_TYPE, GemInfuserRecipes);

        List<TorridFurnaceRecipe> TorridFurnaceRecipes = recipeManager
                .getAllRecipesFor(ModRecipes.TORRID_FURNACE_TYPE.get()).stream().map(RecipeHolder::value).toList();
        registration.addRecipes(TorridFurnaceRecipeCategory.TORRID_FURNACE_RECIPE_RECIPE_TYPE, TorridFurnaceRecipes);

        List<KettleRecipe> KettleRecipes = recipeManager
                .getAllRecipesFor(ModRecipes.KETTLE_TYPE.get()).stream().map(RecipeHolder::value).toList();
        registration.addRecipes(KettleRecipeCategory.KETTLE_RECIPE_RECIPE_TYPE, KettleRecipes);

    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(GemCuttingStationScreen.class, 60, 30, 20 ,30, GemCuttingStationRecipeCategory.GEM_CUTTING_STATION_RECIPE_RECIPE_TYPE);
        registration.addRecipeClickArea(GemInfuserScreen.class, 60, 30, 20 ,30, GemInfuserRecipeCategory.GEM_INFUSER_RECIPE_RECIPE_TYPE);
        registration.addRecipeClickArea(TorridFurnaceScreen.class, 60, 30, 20 ,30, TorridFurnaceRecipeCategory.TORRID_FURNACE_RECIPE_RECIPE_TYPE);
        registration.addRecipeClickArea(KettleScreen.class, 60, 30, 20 ,30, KettleRecipeCategory.KETTLE_RECIPE_RECIPE_TYPE);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.GEM_CUTTING_STATION.get().asItem()),
                GemCuttingStationRecipeCategory.GEM_CUTTING_STATION_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.GEM_INFUSER.get().asItem()),
                GemInfuserRecipeCategory.GEM_INFUSER_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.TORRID_FURNACE.get().asItem()),
                TorridFurnaceRecipeCategory.TORRID_FURNACE_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.KETTLE.get().asItem()),
                KettleRecipeCategory.KETTLE_RECIPE_RECIPE_TYPE);
    }
}
