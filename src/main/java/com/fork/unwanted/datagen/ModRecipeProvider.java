package com.fork.unwanted.datagen;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.blocks.ModBlocks;
import com.fork.unwanted.items.ModItems;
import com.fork.unwanted.misc.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        // ores vanilla smelting

        oreSmelting(recipeOutput, List.of(ModBlocks.RUBY_ORE.get()), RecipeCategory.MISC, ModItems.ROUGH_RUBY.get(),
                0.2f, 200, "rough_ruby");
        oreBlasting(recipeOutput, List.of(ModBlocks.RUBY_ORE.get()), RecipeCategory.MISC, ModItems.ROUGH_RUBY.get(),
                0.3f, 160, "rough_ruby");
        oreSmelting(recipeOutput, List.of(ModBlocks.EMBARIUM_ORE.get()), RecipeCategory.MISC, ModItems.EMBARIUM.get(),
                0.2f, 200, "embarium");
        oreBlasting(recipeOutput, List.of(ModBlocks.EMBARIUM_ORE.get()), RecipeCategory.MISC, ModItems.EMBARIUM.get(),
                0.3f, 160, "embarium");
        oreSmelting(recipeOutput, List.of(ModBlocks.DEEPSLATE_EMBARIUM_ORE.get()), RecipeCategory.MISC, ModItems.EMBARIUM.get(),
                0.2f, 200, "embarium");
        oreBlasting(recipeOutput, List.of(ModBlocks.DEEPSLATE_EMBARIUM_ORE.get()), RecipeCategory.MISC, ModItems.EMBARIUM.get(),
                0.3f, 160, "embarium");
        oreSmelting(recipeOutput, List.of(ModBlocks.TORRID_STEEL_ORE.get()), RecipeCategory.MISC, ModItems.TORRID_STEEL_INGOT.get(),
                0.2f, 200, "torrid_steel_ingot");
        oreBlasting(recipeOutput, List.of(ModBlocks.TORRID_STEEL_ORE.get()), RecipeCategory.MISC, ModItems.TORRID_STEEL_INGOT.get(),
                0.3f, 160, "torrid_steel_ingot");


        //ore blocks

        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, ModItems.RUBY.get(), RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK.get());
        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, ModItems.EMBARIUM.get(), RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMBARIUM_BLOCK.get());
        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, ModItems.TORRID_STEEL_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, ModBlocks.TORRID_STEEL_BLOCK.get());
        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, ModItems.PROFUNDIUM_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, ModBlocks.PROFUNDIUM_BLOCK.get());
        nineBlockStorageRecipesWithCustomPacking(recipeOutput, RecipeCategory.MISC, ModItems.TORRID_STEEL_NUGGET.get(), RecipeCategory.MISC, ModItems.TORRID_STEEL_INGOT.get(), "torrid_steel_ingot_from_nuggets", "torrid_steel_ingot");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TORRID_STEEL_POWDER.get()).requires(ModItems.TORRID_STEEL_NUGGET.get()).unlockedBy(getHasName(ModItems.TORRID_STEEL_NUGGET.get()), has(ModItems.TORRID_STEEL_NUGGET.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PROFUNDIUM_SCRAP.get())
                .requires(Ingredient.of(ModTags.Items.NUGGETS), 4)
                .requires(ModItems.PROFUNDIUM_FLAKE.get(), 4)
                .unlockedBy(getHasName(ModItems.PROFUNDIUM_FLAKE.get()), has(ModItems.PROFUNDIUM_FLAKE.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PROFUNDIUM_INGOT.get())
                .requires(Ingredient.of(ModTags.Items.INGOTS), 4)
                .requires(ModItems.PROFUNDIUM_SCRAP.get(), 4)
                .unlockedBy(getHasName(ModItems.PROFUNDIUM_SCRAP.get()), has(ModItems.PROFUNDIUM_SCRAP.get()))
                .save(recipeOutput);
        // shaped blocks

//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GEM_CUTTING_STATION.get())
//                .pattern("cgc")
//                .pattern("ddd")
//                .pattern("www")
//                .define('w', ItemTags.PLANKS)
//                .define('d', Items.POLISHED_DEEPSLATE_SLAB)
//                .define('c', Items.COPPER_INGOT)
//                .define('g', Items.GLASS)
//                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
//                .save(recipeOutput);
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GEM_INFUSER.get())
//                .pattern(" i ")
//                .pattern("rir")
//                .pattern("ppp")
//                .define('i', Items.IRON_INGOT)
//                .define('r', Items.REDSTONE)
//                .define('p', Items.POLISHED_BLACKSTONE_SLAB)
//                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
//                .save(recipeOutput);
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TORRID_FURNACE.get())
//                .pattern("ttt")
//                .pattern("tft")
//                .pattern("bbb")
//                .define('b', Items.BASALT)
//                .define('t', ModItems.TORRID_STEEL_INGOT.get())
//                .define('f', Items.BLAST_FURNACE)
//                .unlockedBy(getHasName(ModItems.TORRID_STEEL_INGOT.get()), has(ModItems.TORRID_STEEL_INGOT.get()))
//                .save(recipeOutput);

        //kettle

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.RED_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.RED_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORANGE_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.ORANGE_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.ORANGE_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.YELLOW_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.YELLOW_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.YELLOW_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIME_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.LIME_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.LIME_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.GREEN_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.GREEN_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYAN_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.CYAN_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.CYAN_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_BLUE_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.LIGHT_BLUE_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.LIGHT_BLUE_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.BLUE_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.BLUE_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PURPLE_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.PURPLE_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.PURPLE_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAGENTA_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.MAGENTA_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.MAGENTA_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.PINK_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.PINK_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_GRAY_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.LIGHT_GRAY_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.LIGHT_GRAY_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAY_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.GRAY_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.GRAY_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BROWN_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.BROWN_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.BROWN_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.BLACK_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.BLACK_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_BOUNCER_BLOCK.get(), 8)
                .pattern("ccc")
                .pattern("wsw")
                .pattern("www")
                .define('c', Items.WHITE_CARPET)
                .define('s', Items.SLIME_BLOCK)
                .define('w', Items.WHITE_WOOL)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPEEDER_BLOCK.get(), 3)
                .pattern("sss")
                .pattern("mem")
                .pattern("mmm")
                .define('e', ModItems.EMBARIUM.get())
                .define('s', Items.SLIME_BLOCK)
                .define('m', ModBlocks.MARBLE.get())
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMBARIUM_LAMP_BLOCK.get())
                .pattern("pgp")
                .pattern("geg")
                .pattern("pgp")
                .define('e', ModItems.EMBARIUM.get())
                .define('g', Items.GLOWSTONE_DUST)
                .define('p', ItemTags.PLANKS)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(recipeOutput);

        //marble

        //crafting table

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE.get())
                .pattern("mm")
                .pattern("mm")
                .define('m', ModItems.MARBLE_SHARD.get())
                .unlockedBy(getHasName(ModItems.MARBLE_SHARD.get()), has(ModItems.MARBLE_SHARD.get()))
                .save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_SLAB.get(), ModBlocks.MARBLE.get());
        stairBuilder(ModBlocks.MARBLE_STAIRS.get(), Ingredient.of(ModBlocks.MARBLE.get())).unlockedBy(getHasName(ModBlocks.MARBLE.get()), has(ModBlocks.MARBLE.get())).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_WALL.get(), ModBlocks.MARBLE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BRICKS.get(), 4)
                .pattern("mm")
                .pattern("mm")
                .define('m', ModBlocks.MARBLE.get())
                .unlockedBy(getHasName(ModBlocks.MARBLE.get()), has(ModBlocks.MARBLE.get()))
                .save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BRICKS_SLAB.get(), ModBlocks.MARBLE_BRICKS.get());
        stairBuilder(ModBlocks.MARBLE_BRICKS_STAIRS.get(), Ingredient.of(ModBlocks.MARBLE_BRICKS.get())).unlockedBy(getHasName(ModBlocks.MARBLE_BRICKS.get()), has(ModBlocks.MARBLE_BRICKS.get())).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BRICKS_WALL.get(), ModBlocks.MARBLE_BRICKS.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_PILLAR.get(), 2)
                .pattern("m")
                .pattern("m")
                .define('m', ModBlocks.MARBLE_BRICKS.get())
                .unlockedBy(getHasName(ModBlocks.MARBLE_BRICKS.get()), has(ModBlocks.MARBLE_BRICKS.get()))
                .save(recipeOutput);

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MARBLE_BRICKS_SLAB.get(), ModBlocks.CRACKED_MARBLE_BRICKS.get());
        stairBuilder(ModBlocks.CRACKED_MARBLE_BRICKS_STAIRS.get(), Ingredient.of(ModBlocks.CRACKED_MARBLE_BRICKS.get())).unlockedBy(getHasName(ModBlocks.CRACKED_MARBLE_BRICKS.get()), has(ModBlocks.MARBLE_BRICKS.get())).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MARBLE_BRICKS_WALL.get(), ModBlocks.CRACKED_MARBLE_BRICKS_WALL.get());

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MARBLE_BRICKS_SLAB.get(), ModBlocks.MOSSY_MARBLE_BRICKS.get());
        stairBuilder(ModBlocks.MOSSY_MARBLE_BRICKS_STAIRS.get(), Ingredient.of(ModBlocks.MOSSY_MARBLE_BRICKS.get())).unlockedBy(getHasName(ModBlocks.MOSSY_MARBLE_BRICKS.get()), has(ModBlocks.MOSSY_MARBLE_BRICKS.get())).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MARBLE_BRICKS_WALL.get(), ModBlocks.MOSSY_MARBLE_BRICKS.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MARBLE_BRICKS.get())
                .pattern("v")
                .pattern("m")
                .define('m', ModBlocks.MARBLE_BRICKS.get())
                .define('v', Blocks.VINE)
                .unlockedBy(getHasName(ModBlocks.MARBLE_BRICKS.get()), has(ModBlocks.MARBLE_BRICKS.get()))
                .save(recipeOutput);

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_MARBLE_SLAB.get(), ModBlocks.SMOOTH_MARBLE.get());
        stairBuilder(ModBlocks.SMOOTH_MARBLE_STAIRS.get(), Ingredient.of(ModBlocks.SMOOTH_MARBLE.get())).unlockedBy(getHasName(ModBlocks.SMOOTH_MARBLE.get()), has(ModBlocks.SMOOTH_MARBLE.get())).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_MARBLE_WALL.get(), ModBlocks.SMOOTH_MARBLE.get());

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_SLAB.get(), ModBlocks.POLISHED_MARBLE.get());
        stairBuilder(ModBlocks.POLISHED_MARBLE_STAIRS.get(), Ingredient.of(ModBlocks.POLISHED_MARBLE.get())).unlockedBy(getHasName(ModBlocks.POLISHED_MARBLE.get()), has(ModBlocks.POLISHED_MARBLE.get())).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_WALL.get(), ModBlocks.POLISHED_MARBLE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE.get(), 9)
                .pattern("mmm")
                .pattern("mmm")
                .pattern("mmm")
                .define('m', ModBlocks.MARBLE.get())
                .unlockedBy(getHasName(ModBlocks.MARBLE.get()), has(ModBlocks.MARBLE.get()))
                .save(recipeOutput);

        pressurePlate(recipeOutput, ModBlocks.MARBLE_PRESSURE_PLATE.get(), ModBlocks.POLISHED_MARBLE.get());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, ModBlocks.MARBLE_BUTTON.get()).requires(ModBlocks.POLISHED_MARBLE.get()).unlockedBy(getHasName(ModBlocks.POLISHED_MARBLE.get()), has(ModBlocks.POLISHED_MARBLE.get()))
                .save(recipeOutput);

        //stone cutting

        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_SLAB.get(), ModBlocks.MARBLE.get(), 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_STAIRS.get(), ModBlocks.MARBLE.get());
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_WALL.get(), ModBlocks.MARBLE.get());

        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BRICKS.get(), ModBlocks.MARBLE.get());
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BRICKS_SLAB.get(), ModBlocks.MARBLE_BRICKS.get(), 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BRICKS_STAIRS.get(), ModBlocks.MARBLE_BRICKS.get());
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BRICKS_WALL.get(), ModBlocks.MARBLE_BRICKS.get());

        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MARBLE_BRICKS_SLAB.get(), ModBlocks.MOSSY_MARBLE_BRICKS.get(), 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MARBLE_BRICKS_STAIRS.get(), ModBlocks.MOSSY_MARBLE_BRICKS.get());
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MARBLE_BRICKS_WALL.get(), ModBlocks.MOSSY_MARBLE_BRICKS.get());

        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MARBLE_BRICKS_SLAB.get(), ModBlocks.CRACKED_MARBLE_BRICKS.get(), 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MARBLE_BRICKS_STAIRS.get(), ModBlocks.CRACKED_MARBLE_BRICKS.get());
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MARBLE_BRICKS_WALL.get(), ModBlocks.CRACKED_MARBLE_BRICKS.get());

        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_MARBLE_SLAB.get(), ModBlocks.SMOOTH_MARBLE.get(), 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_MARBLE_STAIRS.get(), ModBlocks.SMOOTH_MARBLE.get());
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_MARBLE_WALL.get(), ModBlocks.SMOOTH_MARBLE.get());

        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_SLAB.get(), ModBlocks.POLISHED_MARBLE.get(), 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_STAIRS.get(), ModBlocks.POLISHED_MARBLE.get());
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_MARBLE_WALL.get(), ModBlocks.POLISHED_MARBLE.get());

        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_W_MARBLE.get(), ModBlocks.MARBLE_BRICKS.get());
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_S_MARBLE.get(), ModBlocks.MARBLE_BRICKS.get());
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_E_MARBLE.get(), ModBlocks.MARBLE_BRICKS.get());
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_C_MARBLE.get(), ModBlocks.MARBLE_BRICKS.get());

        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_PILLAR.get(), ModBlocks.MARBLE_BRICKS.get());
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_PILLAR.get(), ModBlocks.MARBLE.get());

        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_PRESSURE_PLATE.get(), ModBlocks.POLISHED_MARBLE.get(), 2);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MARBLE_BUTTON.get(), ModBlocks.POLISHED_MARBLE.get(), 4);

        // smelting

        oreSmelting(recipeOutput, List.of(ModBlocks.MARBLE.get()), RecipeCategory.MISC, ModBlocks.SMOOTH_MARBLE.get().asItem(),
                0.1f, 200, "smooth_marble");

        oreSmelting(recipeOutput, List.of(ModBlocks.MARBLE_BRICKS.get()), RecipeCategory.MISC, ModBlocks.CRACKED_MARBLE_BRICKS.get().asItem(),
                0.1f, 200, "cracked_marble_bricks");
        oreSmelting(recipeOutput, List.of(ModBlocks.MARBLE_BRICKS_SLAB.get()), RecipeCategory.MISC, ModBlocks.CRACKED_MARBLE_BRICKS_SLAB.get().asItem(),
                0.1f, 200, "cracked_marble_bricks_slab");
        oreSmelting(recipeOutput, List.of(ModBlocks.MARBLE_BRICKS_STAIRS.get()), RecipeCategory.MISC, ModBlocks.CRACKED_MARBLE_BRICKS_STAIRS.get().asItem(),
                0.1f, 200, "cracked_marble_bricks_stairs");
        oreSmelting(recipeOutput, List.of(ModBlocks.MARBLE_BRICKS_WALL.get()), RecipeCategory.MISC, ModBlocks.CRACKED_MARBLE_BRICKS_WALL.get().asItem(),
                0.1f, 200, "cracked_marble_bricks_wall");

        //ebony

        planksFromLog(recipeOutput, ModBlocks.EBONY_PLANKS.get(), ModTags.Items.EBONY_LOGS, 4);
        woodFromLogs(recipeOutput, ModBlocks.EBONY_WOOD.get(), ModBlocks.EBONY_LOG.get());
        woodFromLogs(recipeOutput, ModBlocks.STRIPPED_EBONY_WOOD.get(), ModBlocks.STRIPPED_EBONY_LOG.get());

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.EBONY_SLAB.get(), ModBlocks.EBONY_PLANKS.get());
        stairBuilder(ModBlocks.EBONY_STAIRS.get(), Ingredient.of(ModBlocks.EBONY_PLANKS.get())).unlockedBy(getHasName(ModBlocks.EBONY_PLANKS.get()), has(ModBlocks.EBONY_PLANKS.get())).save(recipeOutput);

        wall(recipeOutput, RecipeCategory.REDSTONE, ModBlocks.EBONY_TRAPDOOR.get(), ModBlocks.EBONY_PLANKS.get());
        doorBuilder(ModBlocks.EBONY_DOOR.get(), Ingredient.of(ModBlocks.EBONY_PLANKS.get())).unlockedBy(getHasName(ModBlocks.EBONY_PLANKS.get()), has(ModBlocks.EBONY_PLANKS.get())).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.EBONY_PRESSURE_PLATE.get(), ModBlocks.EBONY_PLANKS.get());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, ModBlocks.EBONY_BUTTON.get()).requires(ModBlocks.EBONY_PLANKS.get()).unlockedBy(getHasName(ModBlocks.EBONY_PLANKS.get()), has(ModBlocks.EBONY_PLANKS.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EBONY_FENCE.get())
                .pattern("ese")
                .pattern("ese")
                .define('e', ModBlocks.EBONY_PLANKS.get())
                .define('s', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.EBONY_PLANKS.get()), has(ModBlocks.EBONY_PLANKS.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EBONY_FENCE_GATE.get())
                .pattern("ses")
                .pattern("ses")
                .define('e', ModBlocks.EBONY_PLANKS.get())
                .define('s', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.EBONY_PLANKS.get()), has(ModBlocks.EBONY_PLANKS.get()))
                .save(recipeOutput);

        woodenBoat(recipeOutput, ModItems.EBONY_BOAT.get(), ModBlocks.EBONY_PLANKS.get());
        chestBoat(recipeOutput, ModItems.EBONY_CHEST_BOAT.get(), ModBlocks.EBONY_PLANKS.get());

        ModsignBuilder(ModItems.EBONY_SIGN.get(), ModBlocks.EBONY_PLANKS.get());
        hangingSign(recipeOutput, ModItems.EBONY_HANGING_SIGN.get(), ModBlocks.STRIPPED_EBONY_LOG.get());

        //items

        //other

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLAZING_WATER.get(), 4)
                .pattern("pwp")
                .pattern("wpw")
                .pattern("pwp")
                .define('p', ModItems.PURE_BLAZE_POWDER.get())
                .define('w', Items.POTION)
                .unlockedBy(getHasName(Items.SLIME_BLOCK), has(Items.SLIME_BLOCK))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PURE_BLAZE_POWDER.get(), 2)
                .requires(Items.BLAZE_POWDER, 4)
                .requires(ModItems.TORRID_STEEL_POWDER.get(), 4)
                .unlockedBy(getHasName(Items.BLAZE_POWDER), has(Items.BLAZE_POWDER))
                .save(recipeOutput);

        twoByTwoPacker(recipeOutput, RecipeCategory.REDSTONE, ModBlocks.TORRID_STEEL_TRAPDOOR.get(), ModItems.TORRID_STEEL_INGOT.get());
        doorBuilder(ModBlocks.TORRID_STEEL_DOOR.get(), Ingredient.of(ModItems.TORRID_STEEL_INGOT.get())).unlockedBy(getHasName(ModItems.TORRID_STEEL_INGOT.get()), has(ModItems.TORRID_STEEL_INGOT.get())).save(recipeOutput);
        twoByTwoPacker(recipeOutput, RecipeCategory.REDSTONE, ModBlocks.TORRID_STEEL_BARS_TRAPDOOR.get(), ModBlocks.TORRID_STEEL_BARS.get());
        doorBuilder(ModBlocks.TORRID_STEEL_BARS_DOOR.get(), Ingredient.of(ModBlocks.TORRID_STEEL_BARS.get())).unlockedBy(getHasName(ModBlocks.TORRID_STEEL_BARS.get()), has(ModBlocks.TORRID_STEEL_BARS.get())).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.TORRID_STEEL_PRESSURE_PLATE.get(), ModItems.TORRID_STEEL_INGOT.get());
        twoByTwoPacker(recipeOutput, RecipeCategory.REDSTONE, ModBlocks.TORRID_STEEL_BUTTON.get(), ModItems.TORRID_STEEL_INGOT.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.TORRID_STEEL_BARS.get(), 16).define('#', ModItems.TORRID_STEEL_INGOT.get()).pattern("###").pattern("###").unlockedBy(getHasName(ModItems.TORRID_STEEL_INGOT.get()), has(ModItems.TORRID_STEEL_INGOT.get())).save(recipeOutput);

        //tool and armor

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CHISEL.get())
                .pattern("d")
                .pattern("s")
                .define('d', Items.DIAMOND)
                .define('s', Items.STICK)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(recipeOutput);

//        upgradeSmithing(recipeOutput, ModItems.CHISEL.get(), Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, RecipeCategory.TOOLS, ModItems.NETHERITE_CHISEL.get());


//        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, ModItems.ELYTRA_GLIDER.get())
//                .pattern("sss")
//                .pattern("f f")
//                .pattern("f f")
//                .define('s', Items.STICK)
//                .define('f', Items.PHANTOM_MEMBRANE)
//                .unlockedBy(getHasName(Items.PHANTOM_MEMBRANE), has(Items.PHANTOM_MEMBRANE))
//                .save(recipeOutput);
//
//        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, ModItems.MECHANICAL_ELYTRA.get())
//                .pattern("tpt")
//                .pattern("tet")
//                .pattern("t t")
//                .define('t', ModItems.TORRID_STEEL_INGOT.get())
//                .define('e', Items.ELYTRA)
//                .define('p', ModItems.PROFUNDIUM_INGOT.get())
//                .unlockedBy(getHasName(Items.ELYTRA), has(Items.ELYTRA))
//                .save(recipeOutput);

//        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.WOODEN_SPEAR.get())
//                .pattern("  k")
//                .pattern(" s ")
//                .pattern("s  ")
//                .define('k', ModItems.WOODEN_SPEAR_HEAD.get()).define('s', Items.STICK)
//                .unlockedBy(getHasName(ModItems.WOODEN_SPEAR_HEAD.get()), has(ModItems.WOODEN_SPEAR_HEAD.get()))
//                .save(recipeOutput);
//
//        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.IRON_SPEAR.get())
//                .pattern("  k")
//                .pattern(" s ")
//                .pattern("s  ")
//                .define('k', Items.IRON_INGOT).define('s', Items.STICK)
//                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
//                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.WOODEN_SPEAR_HEAD.get(), 2)
                .pattern("  w")
                .pattern("ww ")
                .pattern("ww ")
                .define('w', ItemTags.PLANKS)
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(recipeOutput);

        //tea

//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TEA_CUP.get(), 4)
//                .pattern("m m")
//                .pattern(" m ")
//                .define('m', ModItems.MARBLE_SHARD.get())
//                .unlockedBy(getHasName(ModItems.MARBLE_SHARD.get()), has(ModItems.MARBLE_SHARD.get()))
//                .save(recipeOutput);
    }

    protected static RecipeBuilder ModsignBuilder(ItemLike p_176727_, ItemLike p_176728_) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, p_176727_, 3).group("sign").define('#', p_176728_).define('X', Items.STICK).pattern("###").pattern("###").pattern(" X ");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Unwanted.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
