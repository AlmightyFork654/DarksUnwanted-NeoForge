package com.fork.unwanted.recipe;

import com.fork.unwanted.Unwanted;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, Unwanted.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, Unwanted.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<GemCuttingStationRecipe>> GEM_CUTTING_SERIALIZER =
            SERIALIZERS.register("gem_cutting", GemCuttingStationRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<GemCuttingStationRecipe>> GEM_CUTTING_TYPE =
            TYPES.register("gem_cutting", () -> new RecipeType<GemCuttingStationRecipe>() {
                @Override
                public String toString() {
                    return "gem_cutting";
                }
            });
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<GemInfuserRecipe>> GEM_INFUSER_SERIALIZER =
            SERIALIZERS.register("gem_infuser", GemInfuserRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<GemInfuserRecipe>> GEM_INFUSER_TYPE =
            TYPES.register("gem_infuser", () -> new RecipeType<GemInfuserRecipe>() {
                @Override
                public String toString() {
                    return "gem_infuser";
                }
            });
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<TorridFurnaceRecipe>> TORRID_FURNACE_SERIALIZER =
            SERIALIZERS.register("torrid_furnace", TorridFurnaceRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<TorridFurnaceRecipe>> TORRID_FURNACE_TYPE =
            TYPES.register("torrid_furnace", () -> new RecipeType<TorridFurnaceRecipe>() {
                @Override
                public String toString() {
                    return "torrid_furnace";
                }
            });
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<KettleRecipe>> KETTLE_SERIALIZER =
            SERIALIZERS.register("kettle", KettleRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<KettleRecipe>> KETTLE_TYPE =
            TYPES.register("kettle", () -> new RecipeType<KettleRecipe>() {
                @Override
                public String toString() {
                    return "kettle";
                }
            });
    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
