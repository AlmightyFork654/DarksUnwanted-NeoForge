package com.fork.unwanted.items.armor_and_tools;

import com.fork.unwanted.items.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    
    public static final Tier EMBARIUM = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 1561, 7.0F, 2.0F, 22,
            () -> Ingredient.of(ModItems.EMBARIUM.get()));

    public static final Tier TORRID = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 6.0F, 3.0F, 14,
            () -> Ingredient.of(ModItems.TORRID_STEEL_INGOT.get()));

    public static final Tier TORRID_EMBARIUM = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 1561, 7.0F, 3.0F, 22,
            () -> Ingredient.of(ModItems.EMBARIUM.get()));

    public static final Tier PROFUNDIUM = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2642, 10.0F, 4.0F, 30,
            () -> Ingredient.of(ModItems.PROFUNDIUM_INGOT.get()));


    //embarium

    public static final Tier WOOD_E = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 1561, 7.0F, 3.0F, 22,
            () -> Ingredient.of(ModItems.EMBARIUM.get()));

    public static final Tier STONE_E = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 1561, 7.0F, 3.0F, 22,
            () -> Ingredient.of(ModItems.EMBARIUM.get()));

    public static final Tier GOLD_E = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 1561, 7.0F, 3.0F, 22,
            () -> Ingredient.of(ModItems.EMBARIUM.get()));

    public static final Tier IRON_E = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 1561, 7.0F, 3.0F, 22,
            () -> Ingredient.of(ModItems.EMBARIUM.get()));

    public static final Tier DIAMOND_E = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1561, 7.0F, 3.0F, 22,
            () -> Ingredient.of(ModItems.EMBARIUM.get()));

    public static final Tier NETHERITE_E = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1561, 7.0F, 3.0F, 22,
            () -> Ingredient.of(ModItems.EMBARIUM.get()));

    public static final Tier PROFUNDIUM_E = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2642, 3.0F, 4.0F, 30,
            () -> Ingredient.of(ModItems.EMBARIUM.get()));


    //torrid steel

    public static final Tier WOOD_T = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 1561, 7.0F, 3.0F, 14,
            () -> Ingredient.of(ModItems.EMBARIUM.get()));

    public static final Tier STONE_T = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 1561, 7.0F, 3.0F, 14,
            () -> Ingredient.of(ModItems.EMBARIUM.get()));

    public static final Tier GOLD_T = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 1561, 7.0F, 3.0F, 14,
            () -> Ingredient.of(ModItems.EMBARIUM.get()));

    public static final Tier IRON_T = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 1561, 7.0F, 3.0F, 14,
            () -> Ingredient.of(ModItems.EMBARIUM.get()));

    public static final Tier DIAMOND_T = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1561, 7.0F, 3.0F, 14,
            () -> Ingredient.of(ModItems.EMBARIUM.get()));

    public static final Tier NETHERITE_T = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1561, 7.0F, 3.0F, 22,
            () -> Ingredient.of(ModItems.EMBARIUM.get()));

    public static final Tier PROFUNDIUM_T = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2642, 3.0F, 4.0F, 30,
            () -> Ingredient.of(ModItems.EMBARIUM.get()));


    //embarium torrid steel

    public static final Tier WOOD_ET = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 1561, 7.0F, 3.0F, 22,
            () -> Ingredient.of(ModItems.EMBARIUM.get()));

    public static final Tier STONE_ET = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 1561, 7.0F, 3.0F, 22,
            () -> Ingredient.of(ModItems.EMBARIUM.get()));

    public static final Tier GOLD_ET = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 1561, 7.0F, 3.0F, 22,
            () -> Ingredient.of(ModItems.EMBARIUM.get()));

    public static final Tier IRON_ET = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 1561, 7.0F, 3.0F, 22,
            () -> Ingredient.of(ModItems.EMBARIUM.get()));

    public static final Tier DIAMOND_ET = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1561, 7.0F, 3.0F, 22,
            () -> Ingredient.of(ModItems.EMBARIUM.get()));

    public static final Tier NETHERITE_ET = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1561, 7.0F, 3.0F, 22,
            () -> Ingredient.of(ModItems.EMBARIUM.get()));

    public static final Tier PROFUNDIUM_ET = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2642, 3.0F, 4.0F, 30,
            () -> Ingredient.of(ModItems.EMBARIUM.get()));
}
