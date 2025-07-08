package com.fork.unwanted.datagen;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.blocks.ModBlocks;
import com.fork.unwanted.items.ModItems;
import com.fork.unwanted.misc.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Unwanted.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.TORRID_HELMET.get(),
                        ModItems.TORRID_CHESTPLATE.get(),
                        ModItems.TORRID_LEGGINGS.get(),
                        ModItems.TORRID_BOOTS.get(),
                        ModItems.EMBARIUM_HELMET.get(),
                        ModItems.EMBARIUM_CHESTPLATE.get(),
                        ModItems.EMBARIUM_LEGGINGS.get(),
                        ModItems.EMBARIUM_BOOTS.get(),
                        ModItems.TORRID_EMBARIUM_HELMET.get(),
                        ModItems.TORRID_EMBARIUM_CHESTPLATE.get(),
                        ModItems.TORRID_EMBARIUM_LEGGINGS.get(),
                        ModItems.TORRID_EMBARIUM_BOOTS.get(),
                        ModItems.PROFUNDIUM_HELMET.get(),
                        ModItems.PROFUNDIUM_CHESTPLATE.get(),
                        ModItems.PROFUNDIUM_LEGGINGS.get(),
                        ModItems.PROFUNDIUM_BOOTS.get(),
                        ModItems.LEATHER_TORRID_HELMET.get(),
                        ModItems.LEATHER_TORRID_CHESTPLATE.get(),
                        ModItems.LEATHER_TORRID_LEGGINGS.get(),
                        ModItems.LEATHER_TORRID_BOOTS.get(),
                        ModItems.LEATHER_EMBARIUM_HELMET.get(),
                        ModItems.LEATHER_EMBARIUM_CHESTPLATE.get(),
                        ModItems.LEATHER_EMBARIUM_LEGGINGS.get(),
                        ModItems.LEATHER_EMBARIUM_BOOTS.get(),
                        ModItems.LEATHER_TORRID_EMBARIUM_HELMET.get(),
                        ModItems.LEATHER_TORRID_EMBARIUM_CHESTPLATE.get(),
                        ModItems.LEATHER_TORRID_EMBARIUM_LEGGINGS.get(),
                        ModItems.LEATHER_TORRID_EMBARIUM_BOOTS.get(),
                        ModItems.CHAIN_TORRID_HELMET.get(),
                        ModItems.CHAIN_TORRID_CHESTPLATE.get(),
                        ModItems.CHAIN_TORRID_LEGGINGS.get(),
                        ModItems.CHAIN_TORRID_BOOTS.get(),
                        ModItems.CHAIN_EMBARIUM_HELMET.get(),
                        ModItems.CHAIN_EMBARIUM_CHESTPLATE.get(),
                        ModItems.CHAIN_EMBARIUM_LEGGINGS.get(),
                        ModItems.CHAIN_EMBARIUM_BOOTS.get(),
                        ModItems.CHAIN_TORRID_EMBARIUM_HELMET.get(),
                        ModItems.CHAIN_TORRID_EMBARIUM_CHESTPLATE.get(),
                        ModItems.CHAIN_TORRID_EMBARIUM_LEGGINGS.get(),
                        ModItems.CHAIN_TORRID_EMBARIUM_BOOTS.get(),
                        ModItems.GOLDEN_TORRID_HELMET.get(),
                        ModItems.GOLDEN_TORRID_CHESTPLATE.get(),
                        ModItems.GOLDEN_TORRID_LEGGINGS.get(),
                        ModItems.GOLDEN_TORRID_BOOTS.get(),
                        ModItems.GOLDEN_EMBARIUM_HELMET.get(),
                        ModItems.GOLDEN_EMBARIUM_CHESTPLATE.get(),
                        ModItems.GOLDEN_EMBARIUM_LEGGINGS.get(),
                        ModItems.GOLDEN_EMBARIUM_BOOTS.get(),
                        ModItems.GOLDEN_TORRID_EMBARIUM_HELMET.get(),
                        ModItems.GOLDEN_TORRID_EMBARIUM_CHESTPLATE.get(),
                        ModItems.GOLDEN_TORRID_EMBARIUM_LEGGINGS.get(),
                        ModItems.GOLDEN_TORRID_EMBARIUM_BOOTS.get(),
                        ModItems.IRON_TORRID_HELMET.get(),
                        ModItems.IRON_TORRID_CHESTPLATE.get(),
                        ModItems.IRON_TORRID_LEGGINGS.get(),
                        ModItems.IRON_TORRID_BOOTS.get(),
                        ModItems.IRON_EMBARIUM_HELMET.get(),
                        ModItems.IRON_EMBARIUM_CHESTPLATE.get(),
                        ModItems.IRON_EMBARIUM_LEGGINGS.get(),
                        ModItems.IRON_EMBARIUM_BOOTS.get(),
                        ModItems.IRON_TORRID_EMBARIUM_HELMET.get(),
                        ModItems.IRON_TORRID_EMBARIUM_CHESTPLATE.get(),
                        ModItems.IRON_TORRID_EMBARIUM_LEGGINGS.get(),
                        ModItems.IRON_TORRID_EMBARIUM_BOOTS.get(),
                        ModItems.DIAMOND_TORRID_HELMET.get(),
                        ModItems.DIAMOND_TORRID_CHESTPLATE.get(),
                        ModItems.DIAMOND_TORRID_LEGGINGS.get(),
                        ModItems.DIAMOND_TORRID_BOOTS.get(),
                        ModItems.DIAMOND_EMBARIUM_HELMET.get(),
                        ModItems.DIAMOND_EMBARIUM_CHESTPLATE.get(),
                        ModItems.DIAMOND_EMBARIUM_LEGGINGS.get(),
                        ModItems.DIAMOND_EMBARIUM_BOOTS.get(),
                        ModItems.DIAMOND_TORRID_EMBARIUM_HELMET.get(),
                        ModItems.DIAMOND_TORRID_EMBARIUM_CHESTPLATE.get(),
                        ModItems.DIAMOND_TORRID_EMBARIUM_LEGGINGS.get(),
                        ModItems.DIAMOND_TORRID_EMBARIUM_BOOTS.get(),
                        ModItems.NETHERITE_TORRID_HELMET.get(),
                        ModItems.NETHERITE_TORRID_CHESTPLATE.get(),
                        ModItems.NETHERITE_TORRID_LEGGINGS.get(),
                        ModItems.NETHERITE_TORRID_BOOTS.get(),
                        ModItems.NETHERITE_EMBARIUM_HELMET.get(),
                        ModItems.NETHERITE_EMBARIUM_CHESTPLATE.get(),
                        ModItems.NETHERITE_EMBARIUM_LEGGINGS.get(),
                        ModItems.NETHERITE_EMBARIUM_BOOTS.get(),
                        ModItems.NETHERITE_TORRID_EMBARIUM_HELMET.get(),
                        ModItems.NETHERITE_TORRID_EMBARIUM_CHESTPLATE.get(),
                        ModItems.NETHERITE_TORRID_EMBARIUM_LEGGINGS.get(),
                        ModItems.NETHERITE_TORRID_EMBARIUM_BOOTS.get(),
                        ModItems.PROFUNDIUM_TORRID_HELMET.get(),
                        ModItems.PROFUNDIUM_TORRID_CHESTPLATE.get(),
                        ModItems.PROFUNDIUM_TORRID_LEGGINGS.get(),
                        ModItems.PROFUNDIUM_TORRID_BOOTS.get(),
                        ModItems.PROFUNDIUM_EMBARIUM_HELMET.get(),
                        ModItems.PROFUNDIUM_EMBARIUM_CHESTPLATE.get(),
                        ModItems.PROFUNDIUM_EMBARIUM_LEGGINGS.get(),
                        ModItems.PROFUNDIUM_EMBARIUM_BOOTS.get(),
                        ModItems.PROFUNDIUM_TORRID_EMBARIUM_HELMET.get(),
                        ModItems.PROFUNDIUM_TORRID_EMBARIUM_CHESTPLATE.get(),
                        ModItems.PROFUNDIUM_TORRID_EMBARIUM_LEGGINGS.get(),
                        ModItems.PROFUNDIUM_TORRID_EMBARIUM_BOOTS.get()
                );

        this.tag(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.TORRID_HELMET.get(),
                        ModItems.TORRID_CHESTPLATE.get(),
                        ModItems.TORRID_LEGGINGS.get(),
                        ModItems.TORRID_BOOTS.get(),
                        ModItems.EMBARIUM_HELMET.get(),
                        ModItems.EMBARIUM_CHESTPLATE.get(),
                        ModItems.EMBARIUM_LEGGINGS.get(),
                        ModItems.EMBARIUM_BOOTS.get(),
                        ModItems.TORRID_EMBARIUM_HELMET.get(),
                        ModItems.TORRID_EMBARIUM_CHESTPLATE.get(),
                        ModItems.TORRID_EMBARIUM_LEGGINGS.get(),
                        ModItems.TORRID_EMBARIUM_BOOTS.get(),
                        ModItems.PROFUNDIUM_HELMET.get(),
                        ModItems.PROFUNDIUM_CHESTPLATE.get(),
                        ModItems.PROFUNDIUM_LEGGINGS.get(),
                        ModItems.PROFUNDIUM_BOOTS.get(),
                        ModItems.LEATHER_TORRID_HELMET.get(),
                        ModItems.LEATHER_TORRID_CHESTPLATE.get(),
                        ModItems.LEATHER_TORRID_LEGGINGS.get(),
                        ModItems.LEATHER_TORRID_BOOTS.get(),
                        ModItems.LEATHER_EMBARIUM_HELMET.get(),
                        ModItems.LEATHER_EMBARIUM_CHESTPLATE.get(),
                        ModItems.LEATHER_EMBARIUM_LEGGINGS.get(),
                        ModItems.LEATHER_EMBARIUM_BOOTS.get(),
                        ModItems.LEATHER_TORRID_EMBARIUM_HELMET.get(),
                        ModItems.LEATHER_TORRID_EMBARIUM_CHESTPLATE.get(),
                        ModItems.LEATHER_TORRID_EMBARIUM_LEGGINGS.get(),
                        ModItems.LEATHER_TORRID_EMBARIUM_BOOTS.get(),
                        ModItems.CHAIN_TORRID_HELMET.get(),
                        ModItems.CHAIN_TORRID_CHESTPLATE.get(),
                        ModItems.CHAIN_TORRID_LEGGINGS.get(),
                        ModItems.CHAIN_TORRID_BOOTS.get(),
                        ModItems.CHAIN_EMBARIUM_HELMET.get(),
                        ModItems.CHAIN_EMBARIUM_CHESTPLATE.get(),
                        ModItems.CHAIN_EMBARIUM_LEGGINGS.get(),
                        ModItems.CHAIN_EMBARIUM_BOOTS.get(),
                        ModItems.CHAIN_TORRID_EMBARIUM_HELMET.get(),
                        ModItems.CHAIN_TORRID_EMBARIUM_CHESTPLATE.get(),
                        ModItems.CHAIN_TORRID_EMBARIUM_LEGGINGS.get(),
                        ModItems.CHAIN_TORRID_EMBARIUM_BOOTS.get(),
                        ModItems.GOLDEN_TORRID_HELMET.get(),
                        ModItems.GOLDEN_TORRID_CHESTPLATE.get(),
                        ModItems.GOLDEN_TORRID_LEGGINGS.get(),
                        ModItems.GOLDEN_TORRID_BOOTS.get(),
                        ModItems.GOLDEN_EMBARIUM_HELMET.get(),
                        ModItems.GOLDEN_EMBARIUM_CHESTPLATE.get(),
                        ModItems.GOLDEN_EMBARIUM_LEGGINGS.get(),
                        ModItems.GOLDEN_EMBARIUM_BOOTS.get(),
                        ModItems.GOLDEN_TORRID_EMBARIUM_HELMET.get(),
                        ModItems.GOLDEN_TORRID_EMBARIUM_CHESTPLATE.get(),
                        ModItems.GOLDEN_TORRID_EMBARIUM_LEGGINGS.get(),
                        ModItems.GOLDEN_TORRID_EMBARIUM_BOOTS.get(),
                        ModItems.IRON_TORRID_HELMET.get(),
                        ModItems.IRON_TORRID_CHESTPLATE.get(),
                        ModItems.IRON_TORRID_LEGGINGS.get(),
                        ModItems.IRON_TORRID_BOOTS.get(),
                        ModItems.IRON_EMBARIUM_HELMET.get(),
                        ModItems.IRON_EMBARIUM_CHESTPLATE.get(),
                        ModItems.IRON_EMBARIUM_LEGGINGS.get(),
                        ModItems.IRON_EMBARIUM_BOOTS.get(),
                        ModItems.IRON_TORRID_EMBARIUM_HELMET.get(),
                        ModItems.IRON_TORRID_EMBARIUM_CHESTPLATE.get(),
                        ModItems.IRON_TORRID_EMBARIUM_LEGGINGS.get(),
                        ModItems.IRON_TORRID_EMBARIUM_BOOTS.get(),
                        ModItems.DIAMOND_TORRID_HELMET.get(),
                        ModItems.DIAMOND_TORRID_CHESTPLATE.get(),
                        ModItems.DIAMOND_TORRID_LEGGINGS.get(),
                        ModItems.DIAMOND_TORRID_BOOTS.get(),
                        ModItems.DIAMOND_EMBARIUM_HELMET.get(),
                        ModItems.DIAMOND_EMBARIUM_CHESTPLATE.get(),
                        ModItems.DIAMOND_EMBARIUM_LEGGINGS.get(),
                        ModItems.DIAMOND_EMBARIUM_BOOTS.get(),
                        ModItems.DIAMOND_TORRID_EMBARIUM_HELMET.get(),
                        ModItems.DIAMOND_TORRID_EMBARIUM_CHESTPLATE.get(),
                        ModItems.DIAMOND_TORRID_EMBARIUM_LEGGINGS.get(),
                        ModItems.DIAMOND_TORRID_EMBARIUM_BOOTS.get(),
                        ModItems.NETHERITE_TORRID_HELMET.get(),
                        ModItems.NETHERITE_TORRID_CHESTPLATE.get(),
                        ModItems.NETHERITE_TORRID_LEGGINGS.get(),
                        ModItems.NETHERITE_TORRID_BOOTS.get(),
                        ModItems.NETHERITE_EMBARIUM_HELMET.get(),
                        ModItems.NETHERITE_EMBARIUM_CHESTPLATE.get(),
                        ModItems.NETHERITE_EMBARIUM_LEGGINGS.get(),
                        ModItems.NETHERITE_EMBARIUM_BOOTS.get(),
                        ModItems.NETHERITE_TORRID_EMBARIUM_HELMET.get(),
                        ModItems.NETHERITE_TORRID_EMBARIUM_CHESTPLATE.get(),
                        ModItems.NETHERITE_TORRID_EMBARIUM_LEGGINGS.get(),
                        ModItems.NETHERITE_TORRID_EMBARIUM_BOOTS.get(),
                        ModItems.PROFUNDIUM_TORRID_HELMET.get(),
                        ModItems.PROFUNDIUM_TORRID_CHESTPLATE.get(),
                        ModItems.PROFUNDIUM_TORRID_LEGGINGS.get(),
                        ModItems.PROFUNDIUM_TORRID_BOOTS.get(),
                        ModItems.PROFUNDIUM_EMBARIUM_HELMET.get(),
                        ModItems.PROFUNDIUM_EMBARIUM_CHESTPLATE.get(),
                        ModItems.PROFUNDIUM_EMBARIUM_LEGGINGS.get(),
                        ModItems.PROFUNDIUM_EMBARIUM_BOOTS.get(),
                        ModItems.PROFUNDIUM_TORRID_EMBARIUM_HELMET.get(),
                        ModItems.PROFUNDIUM_TORRID_EMBARIUM_CHESTPLATE.get(),
                        ModItems.PROFUNDIUM_TORRID_EMBARIUM_LEGGINGS.get(),
                        ModItems.PROFUNDIUM_TORRID_EMBARIUM_BOOTS.get()
                );

        this.tag(ItemTags.SWORDS)
                .add(ModItems.EMBARIUM_SWORD.get(),
                        ModItems.TORRID_STEEL_SWORD.get(),
                        ModItems.TORRID_EMBARIUM_SWORD.get(),
                        ModItems.PROFUNDIUM_SWORD.get(),
                        ModItems.WOODEN_TORRID_SWORD.get(),
                        ModItems.WOODEN_EMBARIUM_SWORD.get(),
                        ModItems.WOODEN_TORRID_EMBARIUM_SWORD.get(),
                        ModItems.STONE_TORRID_SWORD.get(),
                        ModItems.STONE_EMBARIUM_SWORD.get(),
                        ModItems.STONE_TORRID_EMBARIUM_SWORD.get(),
                        ModItems.GOLDEN_TORRID_SWORD.get(),
                        ModItems.GOLDEN_EMBARIUM_SWORD.get(),
                        ModItems.GOLDEN_TORRID_EMBARIUM_SWORD.get(),
                        ModItems.IRON_TORRID_SWORD.get(),
                        ModItems.IRON_EMBARIUM_SWORD.get(),
                        ModItems.IRON_TORRID_EMBARIUM_SWORD.get(),
                        ModItems.DIAMOND_TORRID_SWORD.get(),
                        ModItems.DIAMOND_EMBARIUM_SWORD.get(),
                        ModItems.DIAMOND_TORRID_EMBARIUM_SWORD.get(),
                        ModItems.NETHERITE_TORRID_SWORD.get(),
                        ModItems.NETHERITE_EMBARIUM_SWORD.get(),
                        ModItems.NETHERITE_TORRID_EMBARIUM_SWORD.get(),
                        ModItems.PROFUNDIUM_TORRID_SWORD.get(),
                        ModItems.PROFUNDIUM_EMBARIUM_SWORD.get(),
                        ModItems.PROFUNDIUM_TORRID_EMBARIUM_SWORD.get()
                );

        this.tag(ItemTags.PICKAXES)
                .add(ModItems.EMBARIUM_PICKAXE.get(),
                        ModItems.TORRID_STEEL_PICKAXE.get(),
                        ModItems.TORRID_EMBARIUM_PICKAXE.get(),
                        ModItems.PROFUNDIUM_PICKAXE.get(),
                        ModItems.WOODEN_TORRID_PICKAXE.get(),
                        ModItems.WOODEN_EMBARIUM_PICKAXE.get(),
                        ModItems.WOODEN_TORRID_EMBARIUM_PICKAXE.get(),
                        ModItems.STONE_TORRID_PICKAXE.get(),
                        ModItems.STONE_EMBARIUM_PICKAXE.get(),
                        ModItems.STONE_TORRID_EMBARIUM_PICKAXE.get(),
                        ModItems.GOLDEN_TORRID_PICKAXE.get(),
                        ModItems.GOLDEN_EMBARIUM_PICKAXE.get(),
                        ModItems.GOLDEN_TORRID_EMBARIUM_PICKAXE.get(),
                        ModItems.IRON_TORRID_PICKAXE.get(),
                        ModItems.IRON_EMBARIUM_PICKAXE.get(),
                        ModItems.IRON_TORRID_EMBARIUM_PICKAXE.get(),
                        ModItems.DIAMOND_TORRID_PICKAXE.get(),
                        ModItems.DIAMOND_EMBARIUM_PICKAXE.get(),
                        ModItems.DIAMOND_TORRID_EMBARIUM_PICKAXE.get(),
                        ModItems.NETHERITE_TORRID_PICKAXE.get(),
                        ModItems.NETHERITE_EMBARIUM_PICKAXE.get(),
                        ModItems.NETHERITE_TORRID_EMBARIUM_PICKAXE.get(),
                        ModItems.PROFUNDIUM_TORRID_PICKAXE.get(),
                        ModItems.PROFUNDIUM_EMBARIUM_PICKAXE.get(),
                        ModItems.PROFUNDIUM_TORRID_EMBARIUM_PICKAXE.get()
                );

        this.tag(ItemTags.AXES)
                .add(ModItems.EMBARIUM_AXE.get(),
                        ModItems.TORRID_STEEL_AXE.get(),
                        ModItems.TORRID_EMBARIUM_AXE.get(),
                        ModItems.PROFUNDIUM_AXE.get(),
                        ModItems.WOODEN_TORRID_AXE.get(),
                        ModItems.WOODEN_EMBARIUM_AXE.get(),
                        ModItems.WOODEN_TORRID_EMBARIUM_AXE.get(),
                        ModItems.STONE_TORRID_AXE.get(),
                        ModItems.STONE_EMBARIUM_AXE.get(),
                        ModItems.STONE_TORRID_EMBARIUM_AXE.get(),
                        ModItems.GOLDEN_TORRID_AXE.get(),
                        ModItems.GOLDEN_EMBARIUM_AXE.get(),
                        ModItems.GOLDEN_TORRID_EMBARIUM_AXE.get(),
                        ModItems.IRON_TORRID_AXE.get(),
                        ModItems.IRON_EMBARIUM_AXE.get(),
                        ModItems.IRON_TORRID_EMBARIUM_AXE.get(),
                        ModItems.DIAMOND_TORRID_AXE.get(),
                        ModItems.DIAMOND_EMBARIUM_AXE.get(),
                        ModItems.DIAMOND_TORRID_EMBARIUM_AXE.get(),
                        ModItems.NETHERITE_TORRID_AXE.get(),
                        ModItems.NETHERITE_EMBARIUM_AXE.get(),
                        ModItems.NETHERITE_TORRID_EMBARIUM_AXE.get(),
                        ModItems.PROFUNDIUM_TORRID_AXE.get(),
                        ModItems.PROFUNDIUM_EMBARIUM_AXE.get(),
                        ModItems.PROFUNDIUM_TORRID_EMBARIUM_AXE.get()
                );

        this.tag(ItemTags.SHOVELS)
                .add(ModItems.EMBARIUM_SHOVEL.get(),
                        ModItems.TORRID_STEEL_SHOVEL.get(),
                        ModItems.TORRID_EMBARIUM_SHOVEL.get(),
                        ModItems.PROFUNDIUM_SHOVEL.get(),
                        ModItems.WOODEN_TORRID_SHOVEL.get(),
                        ModItems.WOODEN_EMBARIUM_SHOVEL.get(),
                        ModItems.WOODEN_TORRID_EMBARIUM_SHOVEL.get(),
                        ModItems.STONE_TORRID_SHOVEL.get(),
                        ModItems.STONE_EMBARIUM_SHOVEL.get(),
                        ModItems.STONE_TORRID_EMBARIUM_SHOVEL.get(),
                        ModItems.GOLDEN_TORRID_SHOVEL.get(),
                        ModItems.GOLDEN_EMBARIUM_SHOVEL.get(),
                        ModItems.GOLDEN_TORRID_EMBARIUM_SHOVEL.get(),
                        ModItems.IRON_TORRID_SHOVEL.get(),
                        ModItems.IRON_EMBARIUM_SHOVEL.get(),
                        ModItems.IRON_TORRID_EMBARIUM_SHOVEL.get(),
                        ModItems.DIAMOND_TORRID_SHOVEL.get(),
                        ModItems.DIAMOND_EMBARIUM_SHOVEL.get(),
                        ModItems.DIAMOND_TORRID_EMBARIUM_SHOVEL.get(),
                        ModItems.NETHERITE_TORRID_SHOVEL.get(),
                        ModItems.NETHERITE_EMBARIUM_SHOVEL.get(),
                        ModItems.NETHERITE_TORRID_EMBARIUM_SHOVEL.get(),
                        ModItems.PROFUNDIUM_TORRID_SHOVEL.get(),
                        ModItems.PROFUNDIUM_EMBARIUM_SHOVEL.get(),
                        ModItems.PROFUNDIUM_TORRID_EMBARIUM_SHOVEL.get()
                );

        this.tag(ItemTags.HOES)
                .add(ModItems.EMBARIUM_HOE.get(),
                        ModItems.TORRID_STEEL_HOE.get(),
                        ModItems.TORRID_EMBARIUM_HOE.get(),
                        ModItems.PROFUNDIUM_HOE.get(),
                        ModItems.WOODEN_TORRID_HOE.get(),
                        ModItems.WOODEN_EMBARIUM_HOE.get(),
                        ModItems.WOODEN_TORRID_EMBARIUM_HOE.get(),
                        ModItems.STONE_TORRID_HOE.get(),
                        ModItems.STONE_EMBARIUM_HOE.get(),
                        ModItems.STONE_TORRID_EMBARIUM_HOE.get(),
                        ModItems.GOLDEN_TORRID_HOE.get(),
                        ModItems.GOLDEN_EMBARIUM_HOE.get(),
                        ModItems.GOLDEN_TORRID_EMBARIUM_HOE.get(),
                        ModItems.IRON_TORRID_HOE.get(),
                        ModItems.IRON_EMBARIUM_HOE.get(),
                        ModItems.IRON_TORRID_EMBARIUM_HOE.get(),
                        ModItems.DIAMOND_TORRID_HOE.get(),
                        ModItems.DIAMOND_EMBARIUM_HOE.get(),
                        ModItems.DIAMOND_TORRID_EMBARIUM_HOE.get(),
                        ModItems.NETHERITE_TORRID_HOE.get(),
                        ModItems.NETHERITE_EMBARIUM_HOE.get(),
                        ModItems.NETHERITE_TORRID_EMBARIUM_HOE.get(),
                        ModItems.PROFUNDIUM_TORRID_HOE.get(),
                        ModItems.PROFUNDIUM_EMBARIUM_HOE.get(),
                        ModItems.PROFUNDIUM_TORRID_EMBARIUM_HOE.get()
                );

        this.tag(ItemTags.FOOT_ARMOR).add(
                ModItems.TORRID_HELMET.get(),
                ModItems.EMBARIUM_HELMET.get(),
                ModItems.TORRID_EMBARIUM_HELMET.get(),
                ModItems.PROFUNDIUM_HELMET.get(),
                ModItems.LEATHER_TORRID_HELMET.get(),
                ModItems.LEATHER_EMBARIUM_HELMET.get(),
                ModItems.LEATHER_TORRID_EMBARIUM_HELMET.get(),
                ModItems.CHAIN_TORRID_HELMET.get(),
                ModItems.CHAIN_EMBARIUM_HELMET.get(),
                ModItems.CHAIN_TORRID_EMBARIUM_HELMET.get(),
                ModItems.GOLDEN_TORRID_HELMET.get(),
                ModItems.GOLDEN_EMBARIUM_HELMET.get(),
                ModItems.GOLDEN_TORRID_EMBARIUM_HELMET.get(),
                ModItems.IRON_TORRID_HELMET.get(),
                ModItems.IRON_EMBARIUM_HELMET.get(),
                ModItems.IRON_TORRID_EMBARIUM_HELMET.get(),
                ModItems.DIAMOND_TORRID_HELMET.get(),
                ModItems.DIAMOND_EMBARIUM_HELMET.get(),
                ModItems.DIAMOND_TORRID_EMBARIUM_HELMET.get(),
                ModItems.NETHERITE_TORRID_HELMET.get(),
                ModItems.NETHERITE_EMBARIUM_HELMET.get(),
                ModItems.NETHERITE_TORRID_EMBARIUM_HELMET.get(),
                ModItems.PROFUNDIUM_TORRID_HELMET.get(),
                ModItems.PROFUNDIUM_EMBARIUM_HELMET.get(),
                ModItems.PROFUNDIUM_TORRID_EMBARIUM_HELMET.get()
        );

        this.tag(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(
                ModItems.TORRID_HELMET.get(),
                ModItems.EMBARIUM_HELMET.get(),
                ModItems.TORRID_EMBARIUM_HELMET.get(),
                ModItems.PROFUNDIUM_HELMET.get(),
                ModItems.LEATHER_TORRID_HELMET.get(),
                ModItems.LEATHER_EMBARIUM_HELMET.get(),
                ModItems.LEATHER_TORRID_EMBARIUM_HELMET.get(),
                ModItems.CHAIN_TORRID_HELMET.get(),
                ModItems.CHAIN_EMBARIUM_HELMET.get(),
                ModItems.CHAIN_TORRID_EMBARIUM_HELMET.get(),
                ModItems.GOLDEN_TORRID_HELMET.get(),
                ModItems.GOLDEN_EMBARIUM_HELMET.get(),
                ModItems.GOLDEN_TORRID_EMBARIUM_HELMET.get(),
                ModItems.IRON_TORRID_HELMET.get(),
                ModItems.IRON_EMBARIUM_HELMET.get(),
                ModItems.IRON_TORRID_EMBARIUM_HELMET.get(),
                ModItems.DIAMOND_TORRID_HELMET.get(),
                ModItems.DIAMOND_EMBARIUM_HELMET.get(),
                ModItems.DIAMOND_TORRID_EMBARIUM_HELMET.get(),
                ModItems.NETHERITE_TORRID_HELMET.get(),
                ModItems.NETHERITE_EMBARIUM_HELMET.get(),
                ModItems.NETHERITE_TORRID_EMBARIUM_HELMET.get(),
                ModItems.PROFUNDIUM_TORRID_HELMET.get(),
                ModItems.PROFUNDIUM_EMBARIUM_HELMET.get(),
                ModItems.PROFUNDIUM_TORRID_EMBARIUM_HELMET.get()
        );

        this.tag(ItemTags.CHEST_ARMOR).add(
                ModItems.TORRID_CHESTPLATE.get(),
                ModItems.EMBARIUM_CHESTPLATE.get(),
                ModItems.TORRID_EMBARIUM_CHESTPLATE.get(),
                ModItems.PROFUNDIUM_CHESTPLATE.get(),
                ModItems.LEATHER_TORRID_CHESTPLATE.get(),
                ModItems.LEATHER_EMBARIUM_CHESTPLATE.get(),
                ModItems.LEATHER_TORRID_EMBARIUM_CHESTPLATE.get(),
                ModItems.CHAIN_TORRID_CHESTPLATE.get(),
                ModItems.CHAIN_EMBARIUM_CHESTPLATE.get(),
                ModItems.CHAIN_TORRID_EMBARIUM_CHESTPLATE.get(),
                ModItems.GOLDEN_TORRID_CHESTPLATE.get(),
                ModItems.GOLDEN_EMBARIUM_CHESTPLATE.get(),
                ModItems.GOLDEN_TORRID_EMBARIUM_CHESTPLATE.get(),
                ModItems.IRON_TORRID_CHESTPLATE.get(),
                ModItems.IRON_EMBARIUM_CHESTPLATE.get(),
                ModItems.IRON_TORRID_EMBARIUM_CHESTPLATE.get(),
                ModItems.DIAMOND_TORRID_CHESTPLATE.get(),
                ModItems.DIAMOND_EMBARIUM_CHESTPLATE.get(),
                ModItems.DIAMOND_TORRID_EMBARIUM_CHESTPLATE.get(),
                ModItems.NETHERITE_TORRID_CHESTPLATE.get(),
                ModItems.NETHERITE_EMBARIUM_CHESTPLATE.get(),
                ModItems.NETHERITE_TORRID_EMBARIUM_CHESTPLATE.get(),
                ModItems.PROFUNDIUM_TORRID_CHESTPLATE.get(),
                ModItems.PROFUNDIUM_EMBARIUM_CHESTPLATE.get(),
                ModItems.PROFUNDIUM_TORRID_EMBARIUM_CHESTPLATE.get()
        );

        this.tag(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(
                ModItems.TORRID_CHESTPLATE.get(),
                ModItems.EMBARIUM_CHESTPLATE.get(),
                ModItems.TORRID_EMBARIUM_CHESTPLATE.get(),
                ModItems.PROFUNDIUM_CHESTPLATE.get(),
                ModItems.LEATHER_TORRID_CHESTPLATE.get(),
                ModItems.LEATHER_EMBARIUM_CHESTPLATE.get(),
                ModItems.LEATHER_TORRID_EMBARIUM_CHESTPLATE.get(),
                ModItems.CHAIN_TORRID_CHESTPLATE.get(),
                ModItems.CHAIN_EMBARIUM_CHESTPLATE.get(),
                ModItems.CHAIN_TORRID_EMBARIUM_CHESTPLATE.get(),
                ModItems.GOLDEN_TORRID_CHESTPLATE.get(),
                ModItems.GOLDEN_EMBARIUM_CHESTPLATE.get(),
                ModItems.GOLDEN_TORRID_EMBARIUM_CHESTPLATE.get(),
                ModItems.IRON_TORRID_CHESTPLATE.get(),
                ModItems.IRON_EMBARIUM_CHESTPLATE.get(),
                ModItems.IRON_TORRID_EMBARIUM_CHESTPLATE.get(),
                ModItems.DIAMOND_TORRID_CHESTPLATE.get(),
                ModItems.DIAMOND_EMBARIUM_CHESTPLATE.get(),
                ModItems.DIAMOND_TORRID_EMBARIUM_CHESTPLATE.get(),
                ModItems.NETHERITE_TORRID_CHESTPLATE.get(),
                ModItems.NETHERITE_EMBARIUM_CHESTPLATE.get(),
                ModItems.NETHERITE_TORRID_EMBARIUM_CHESTPLATE.get(),
                ModItems.PROFUNDIUM_TORRID_CHESTPLATE.get(),
                ModItems.PROFUNDIUM_EMBARIUM_CHESTPLATE.get(),
                ModItems.PROFUNDIUM_TORRID_EMBARIUM_CHESTPLATE.get()
        );

        this.tag(ItemTags.LEG_ARMOR).add(
                ModItems.TORRID_LEGGINGS.get(),
                ModItems.EMBARIUM_LEGGINGS.get(),
                ModItems.TORRID_EMBARIUM_LEGGINGS.get(),
                ModItems.PROFUNDIUM_LEGGINGS.get(),
                ModItems.LEATHER_TORRID_LEGGINGS.get(),
                ModItems.LEATHER_EMBARIUM_LEGGINGS.get(),
                ModItems.LEATHER_TORRID_EMBARIUM_LEGGINGS.get(),
                ModItems.CHAIN_TORRID_LEGGINGS.get(),
                ModItems.CHAIN_EMBARIUM_LEGGINGS.get(),
                ModItems.CHAIN_TORRID_EMBARIUM_LEGGINGS.get(),
                ModItems.GOLDEN_TORRID_LEGGINGS.get(),
                ModItems.GOLDEN_EMBARIUM_LEGGINGS.get(),
                ModItems.GOLDEN_TORRID_EMBARIUM_LEGGINGS.get(),
                ModItems.IRON_TORRID_LEGGINGS.get(),
                ModItems.IRON_EMBARIUM_LEGGINGS.get(),
                ModItems.IRON_TORRID_EMBARIUM_LEGGINGS.get(),
                ModItems.DIAMOND_TORRID_LEGGINGS.get(),
                ModItems.DIAMOND_EMBARIUM_LEGGINGS.get(),
                ModItems.DIAMOND_TORRID_EMBARIUM_LEGGINGS.get(),
                ModItems.NETHERITE_TORRID_LEGGINGS.get(),
                ModItems.NETHERITE_EMBARIUM_LEGGINGS.get(),
                ModItems.NETHERITE_TORRID_EMBARIUM_LEGGINGS.get(),
                ModItems.PROFUNDIUM_TORRID_LEGGINGS.get(),
                ModItems.PROFUNDIUM_EMBARIUM_LEGGINGS.get(),
                ModItems.PROFUNDIUM_TORRID_EMBARIUM_LEGGINGS.get()
        );

        this.tag(ItemTags.LEG_ARMOR_ENCHANTABLE).add(
                ModItems.TORRID_LEGGINGS.get(),
                ModItems.EMBARIUM_LEGGINGS.get(),
                ModItems.TORRID_EMBARIUM_LEGGINGS.get(),
                ModItems.PROFUNDIUM_LEGGINGS.get(),
                ModItems.LEATHER_TORRID_LEGGINGS.get(),
                ModItems.LEATHER_EMBARIUM_LEGGINGS.get(),
                ModItems.LEATHER_TORRID_EMBARIUM_LEGGINGS.get(),
                ModItems.CHAIN_TORRID_LEGGINGS.get(),
                ModItems.CHAIN_EMBARIUM_LEGGINGS.get(),
                ModItems.CHAIN_TORRID_EMBARIUM_LEGGINGS.get(),
                ModItems.GOLDEN_TORRID_LEGGINGS.get(),
                ModItems.GOLDEN_EMBARIUM_LEGGINGS.get(),
                ModItems.GOLDEN_TORRID_EMBARIUM_LEGGINGS.get(),
                ModItems.IRON_TORRID_LEGGINGS.get(),
                ModItems.IRON_EMBARIUM_LEGGINGS.get(),
                ModItems.IRON_TORRID_EMBARIUM_LEGGINGS.get(),
                ModItems.DIAMOND_TORRID_LEGGINGS.get(),
                ModItems.DIAMOND_EMBARIUM_LEGGINGS.get(),
                ModItems.DIAMOND_TORRID_EMBARIUM_LEGGINGS.get(),
                ModItems.NETHERITE_TORRID_LEGGINGS.get(),
                ModItems.NETHERITE_EMBARIUM_LEGGINGS.get(),
                ModItems.NETHERITE_TORRID_EMBARIUM_LEGGINGS.get(),
                ModItems.PROFUNDIUM_TORRID_LEGGINGS.get(),
                ModItems.PROFUNDIUM_EMBARIUM_LEGGINGS.get(),
                ModItems.PROFUNDIUM_TORRID_EMBARIUM_LEGGINGS.get()
        );

        this.tag(ItemTags.FOOT_ARMOR).add(
                ModItems.TORRID_BOOTS.get(),
                ModItems.EMBARIUM_BOOTS.get(),
                ModItems.TORRID_EMBARIUM_BOOTS.get(),
                ModItems.PROFUNDIUM_BOOTS.get(),
                ModItems.LEATHER_TORRID_BOOTS.get(),
                ModItems.LEATHER_EMBARIUM_BOOTS.get(),
                ModItems.LEATHER_TORRID_EMBARIUM_BOOTS.get(),
                ModItems.CHAIN_TORRID_BOOTS.get(),
                ModItems.CHAIN_EMBARIUM_BOOTS.get(),
                ModItems.CHAIN_TORRID_EMBARIUM_BOOTS.get(),
                ModItems.GOLDEN_TORRID_BOOTS.get(),
                ModItems.GOLDEN_EMBARIUM_BOOTS.get(),
                ModItems.GOLDEN_TORRID_EMBARIUM_BOOTS.get(),
                ModItems.IRON_TORRID_BOOTS.get(),
                ModItems.IRON_EMBARIUM_BOOTS.get(),
                ModItems.IRON_TORRID_EMBARIUM_BOOTS.get(),
                ModItems.DIAMOND_TORRID_BOOTS.get(),
                ModItems.DIAMOND_EMBARIUM_BOOTS.get(),
                ModItems.DIAMOND_TORRID_EMBARIUM_BOOTS.get(),
                ModItems.NETHERITE_TORRID_BOOTS.get(),
                ModItems.NETHERITE_EMBARIUM_BOOTS.get(),
                ModItems.NETHERITE_TORRID_EMBARIUM_BOOTS.get(),
                ModItems.PROFUNDIUM_TORRID_BOOTS.get(),
                ModItems.PROFUNDIUM_EMBARIUM_BOOTS.get(),
                ModItems.PROFUNDIUM_TORRID_EMBARIUM_BOOTS.get()
        );
        this.tag(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(
                ModItems.TORRID_BOOTS.get(),
                ModItems.EMBARIUM_BOOTS.get(),
                ModItems.TORRID_EMBARIUM_BOOTS.get(),
                ModItems.PROFUNDIUM_BOOTS.get(),
                ModItems.LEATHER_TORRID_BOOTS.get(),
                ModItems.LEATHER_EMBARIUM_BOOTS.get(),
                ModItems.LEATHER_TORRID_EMBARIUM_BOOTS.get(),
                ModItems.CHAIN_TORRID_BOOTS.get(),
                ModItems.CHAIN_EMBARIUM_BOOTS.get(),
                ModItems.CHAIN_TORRID_EMBARIUM_BOOTS.get(),
                ModItems.GOLDEN_TORRID_BOOTS.get(),
                ModItems.GOLDEN_EMBARIUM_BOOTS.get(),
                ModItems.GOLDEN_TORRID_EMBARIUM_BOOTS.get(),
                ModItems.IRON_TORRID_BOOTS.get(),
                ModItems.IRON_EMBARIUM_BOOTS.get(),
                ModItems.IRON_TORRID_EMBARIUM_BOOTS.get(),
                ModItems.DIAMOND_TORRID_BOOTS.get(),
                ModItems.DIAMOND_EMBARIUM_BOOTS.get(),
                ModItems.DIAMOND_TORRID_EMBARIUM_BOOTS.get(),
                ModItems.NETHERITE_TORRID_BOOTS.get(),
                ModItems.NETHERITE_EMBARIUM_BOOTS.get(),
                ModItems.NETHERITE_TORRID_EMBARIUM_BOOTS.get(),
                ModItems.PROFUNDIUM_TORRID_BOOTS.get(),
                ModItems.PROFUNDIUM_EMBARIUM_BOOTS.get(),
                ModItems.PROFUNDIUM_TORRID_EMBARIUM_BOOTS.get()
        );

//        this.tag(ItemTags.)
//                .add(ModItems.DARKNESS_MUSIC_DISK.get(), ModItems.CAVE_WHISPERS_MUSIC_DISK.get());

        this.tag(ModTags.Items.CHISELS)
                .add(ModItems.CHISEL.get(), ModItems.NETHERITE_CHISEL.get());

        this.tag(ModTags.Items.FUELS)
                .add(ModItems.PURE_BLAZE_POWDER.get(), Items.BLAZE_POWDER, Items.BLAZE_ROD);

        this.tag(ModTags.Items.ALL_FUELS)
                .add(Items.LAVA_BUCKET,
                        Items.COAL,
                        Items.COAL_BLOCK,
                        Items.CHARCOAL,
                        Items.DRIED_KELP_BLOCK,
                        Items.SCAFFOLDING,
                        Items.BAMBOO,
                        Items.STICK)
                .addTag(ModTags.Items.FUELS)
                .addTag(ItemTags.PLANKS)
                .addTag(ItemTags.LOGS);

        this.tag(Tags.Items.ORES)
                .add(ModBlocks.RUBY_ORE.get().asItem(),
                        ModBlocks.EMBARIUM_ORE.get().asItem(),
                        ModBlocks.DEEPSLATE_EMBARIUM_ORE.get().asItem(),
                        ModBlocks.TORRID_STEEL_ORE.get().asItem(),
                        ModBlocks.PROFUNDIUM_ORE.get().asItem());

        this.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.EBONY_PRESSURE_PLATE.get().asItem());
        this.tag(ItemTags.WOODEN_BUTTONS).add(ModBlocks.EBONY_BUTTON.get().asItem());
        this.tag(ItemTags.STONE_BUTTONS).add(ModBlocks.MARBLE_BUTTON.get().asItem(), ModBlocks.TORRID_STEEL_BUTTON.get().asItem());
        this.tag(ItemTags.DOORS).add(ModBlocks.TORRID_STEEL_BARS_DOOR.get().asItem(), ModBlocks.TORRID_STEEL_DOOR.get().asItem());
        this.tag(ItemTags.WOODEN_DOORS).add(ModBlocks.EBONY_DOOR.get().asItem());
        this.tag(ItemTags.TRAPDOORS).add(ModBlocks.TORRID_STEEL_BARS_TRAPDOOR.get().asItem(), ModBlocks.TORRID_STEEL_TRAPDOOR.get().asItem());
        this.tag(ItemTags.WOODEN_TRAPDOORS).add(ModBlocks.EBONY_TRAPDOOR.get().asItem());

        this.tag(ItemTags.LOGS).addTag(ModTags.Items.EBONY_LOGS);
        this.tag(ItemTags.LOGS_THAT_BURN).addTag(ModTags.Items.EBONY_LOGS);

        this.tag(ItemTags.PLANKS).add(ModBlocks.EBONY_PLANKS.get().asItem());
        this.tag(ItemTags.SAPLINGS).add(ModBlocks.EBONY_SAPLING.get().asItem());
        this.tag(ItemTags.SMALL_FLOWERS).add(ModBlocks.TORRID_BUSH.get().asItem());

        this.tag(ItemTags.SLABS)
                .add(ModBlocks.MARBLE_SLAB.get().asItem(),
                        ModBlocks.POLISHED_MARBLE_SLAB.get().asItem(),
                        ModBlocks.SMOOTH_MARBLE_SLAB.get().asItem(),
                        ModBlocks.MARBLE_BRICKS_SLAB.get().asItem(),
                        ModBlocks.CRACKED_MARBLE_BRICKS_SLAB.get().asItem(),
                        ModBlocks.MOSSY_MARBLE_BRICKS_SLAB.get().asItem(),
                        ModBlocks.CUT_MARBLE_BRICKS_SLAB.get().asItem(),
                        ModBlocks.CUT_CRACKED_MARBLE_BRICKS_SLAB.get().asItem(),
                        ModBlocks.CUT_MOSSY_MARBLE_BRICKS_SLAB.get().asItem());
        this.tag(ItemTags.STAIRS)
                .add(ModBlocks.MARBLE_STAIRS.get().asItem(),
                        ModBlocks.POLISHED_MARBLE_STAIRS.get().asItem(),
                        ModBlocks.SMOOTH_MARBLE_STAIRS.get().asItem(),
                        ModBlocks.MARBLE_BRICKS_STAIRS.get().asItem(),
                        ModBlocks.CRACKED_MARBLE_BRICKS_STAIRS.get().asItem(),
                        ModBlocks.MOSSY_MARBLE_BRICKS_STAIRS.get().asItem(),
                        ModBlocks.CUT_MARBLE_BRICKS_STAIRS.get().asItem(),
                        ModBlocks.CUT_CRACKED_MARBLE_BRICKS_STAIRS.get().asItem(),
                        ModBlocks.CUT_MOSSY_MARBLE_BRICKS_STAIRS.get().asItem());

        this.tag(ItemTags.WOODEN_SLABS).add(ModBlocks.EBONY_SLAB.get().asItem());
        this.tag(ItemTags.WOODEN_STAIRS).add(ModBlocks.EBONY_STAIRS.get().asItem());

        this.tag(ItemTags.WALLS)
                .add(ModBlocks.MARBLE_WALL.get().asItem(),
                        ModBlocks.POLISHED_MARBLE_WALL.get().asItem(),
                        ModBlocks.SMOOTH_MARBLE_WALL.get().asItem(),
                        ModBlocks.MARBLE_BRICKS_WALL.get().asItem(),
                        ModBlocks.CRACKED_MARBLE_BRICKS_WALL.get().asItem(),
                        ModBlocks.MOSSY_MARBLE_BRICKS_WALL.get().asItem(),
                        ModBlocks.CUT_MARBLE_BRICKS_WALL.get().asItem(),
                        ModBlocks.CUT_CRACKED_MARBLE_BRICKS_WALL.get().asItem(),
                        ModBlocks.CUT_MOSSY_MARBLE_BRICKS_WALL.get().asItem());

        this.tag(ItemTags.WOODEN_FENCES).add(ModBlocks.EBONY_FENCE.get().asItem());
        this.tag(ItemTags.FENCE_GATES).add(ModBlocks.EBONY_FENCE_GATE.get().asItem());

        this.tag(ItemTags.STONE_CRAFTING_MATERIALS).add(ModBlocks.MARBLE.get().asItem());
        this.tag(ItemTags.STONE_TOOL_MATERIALS).add(ModBlocks.MARBLE.get().asItem());

        this.tag(ModTags.Items.EBONY_LOGS)
                .add(ModBlocks.EBONY_LOG.get().asItem(),
                        ModBlocks.EBONY_WOOD.get().asItem(),
                        ModBlocks.STRIPPED_EBONY_WOOD.get().asItem(),
                        ModBlocks.STRIPPED_EBONY_LOG.get().asItem());

        this.tag(ModTags.Items.NUGGETS).add(Items.IRON_NUGGET, ModItems.TORRID_STEEL_NUGGET.get());
        this.tag(ModTags.Items.INGOTS).add(Items.IRON_INGOT, ModItems.TORRID_STEEL_INGOT.get());

        this.tag(ModTags.Items.BASE_TEA).addTags(ModTags.Items.GRASSY, ModTags.Items.WARPED, ModTags.Items.CRIMSON,
                ModTags.Items.LEAVY, ModTags.Items.KELPED, ModTags.Items.VINEY,
                ModTags.Items.GLOWY, ModTags.Items.SCULKED, ModTags.Items.ROOTED);
        this.tag(ModTags.Items.GRASSY).add(Items.SHORT_GRASS, Items.TALL_GRASS, Items.SEAGRASS, Items.FERN, Items.LARGE_FERN);
        this.tag(ModTags.Items.WARPED).add(Items.WARPED_FUNGUS, Items.WARPED_ROOTS, Items.NETHER_SPROUTS, Items.TWISTING_VINES);
        this.tag(ModTags.Items.CRIMSON).add(Items.CRIMSON_FUNGUS, Items.CRIMSON_ROOTS, Items.WEEPING_VINES);
        this.tag(ModTags.Items.LEAVY).add(Items.LILY_PAD, Items.BIG_DRIPLEAF, Items.SMALL_DRIPLEAF);
        this.tag(ModTags.Items.KELPED).add(Items.KELP, Items.DRIED_KELP);
        this.tag(ModTags.Items.VINEY).add(Items.VINE);
        this.tag(ModTags.Items.GLOWY).add(Items.GLOW_LICHEN);
        this.tag(ModTags.Items.SCULKED).add(Items.SCULK_VEIN);
        this.tag(ModTags.Items.ROOTED).add(Items.MANGROVE_ROOTS, Items.HANGING_ROOTS);

        this.tag(ModTags.Items.TELEPORTS).addTags(ModTags.Items.SPAWN, ModTags.Items.OVERWORLD, ModTags.Items.NETHER,
                ModTags.Items.END);
        this.tag(ModTags.Items.SPAWN).add(Items.CHORUS_FRUIT, Items.POPPED_CHORUS_FRUIT);
        this.tag(ModTags.Items.OVERWORLD).add(Items.ENDER_PEARL);
        this.tag(ModTags.Items.NETHER).add(Items.GHAST_TEAR);
        this.tag(ModTags.Items.END).add(Items.DRAGON_BREATH);

        this.tag(ModTags.Items.MODS).add(Items.REDSTONE, Items.GLOWSTONE_DUST, Items.GUNPOWDER);

        this.tag(ModTags.Items.ADDITIVES).addTags(ModTags.Items.RED_STUFF, ModTags.Items.GOLDEN_FRUIT, ModTags.Items. GOD_APPLE,
                ModTags.Items. SWEET, ModTags.Items.GLOWING_FRUIT, ModTags.Items.PINK_FLOWER, ModTags.Items.YELLOW_FLOWER,
                ModTags.Items.WHITE_FLOWER, ModTags.Items.GREY_FLOWER, ModTags.Items.PURPLE_FLOWER1, ModTags.Items.PURPLE_FLOWER2, ModTags.Items.BLUE_FLOWER,
                ModTags.Items.RED_FLOWER, ModTags.Items.END_FLOWER, ModTags.Items.FIRE_FLOWER, ModTags.Items.POT_FLOWER,
                ModTags.Items.WING, ModTags.Items.FIRE, ModTags.Items.TORRID, ModTags.Items.WITHER);

        this.tag(ModTags.Items.RED_STUFF).add(Items.APPLE, Items.MELON_SLICE, Items.POPPY, Items.ROSE_BUSH);
        this.tag(ModTags.Items.GOLDEN_FRUIT).add(Items.GOLDEN_APPLE, Items.GLISTERING_MELON_SLICE);
        this.tag(ModTags.Items.GOD_APPLE).add(Items.ENCHANTED_GOLDEN_APPLE);
        this.tag(ModTags.Items.SWEET).add(Items.SUGAR, Items.HONEY_BOTTLE, Items.SWEET_BERRIES);
        this.tag(ModTags.Items.GLOWING_FRUIT).add(Items.GLOW_BERRIES);
        this.tag(ModTags.Items.PINK_FLOWER).add(Items.PINK_PETALS, Items.SPORE_BLOSSOM);
        this.tag(ModTags.Items.YELLOW_FLOWER).add(Items.DANDELION, Items.SUNFLOWER, Items.ORANGE_TULIP);
        this.tag(ModTags.Items.WHITE_FLOWER).add(Items.WHITE_TULIP, Items.LILY_OF_THE_VALLEY);
        this.tag(ModTags.Items.GREY_FLOWER).add(Items.OXEYE_DAISY, Items.AZURE_BLUET);
        this.tag(ModTags.Items.PURPLE_FLOWER1).add(Items.ALLIUM, Items.PEONY);
        this.tag(ModTags.Items.PURPLE_FLOWER2).add(Items.PINK_TULIP, Items.LILAC);
        this.tag(ModTags.Items.BLUE_FLOWER).add(Items.CORNFLOWER, Items.BLUE_ORCHID);
        this.tag(ModTags.Items.RED_FLOWER).add(Items.RED_TULIP);
        this.tag(ModTags.Items.END_FLOWER).add(Items.CHORUS_FLOWER);
        this.tag(ModTags.Items.FIRE_FLOWER).add(Items.TORCHFLOWER);
        this.tag(ModTags.Items.POT_FLOWER).add(Items.PITCHER_PLANT);
        this.tag(ModTags.Items.WING).add(Items.PHANTOM_MEMBRANE);
        this.tag(ModTags.Items.FIRE).add(Items.MAGMA_CREAM, Items.BLAZE_POWDER);
        this.tag(ModTags.Items.TORRID).add(ModItems.TORRID_STEEL_POWDER.get());
        this.tag(ModTags.Items.WITHER).add(Items.WITHER_ROSE);


    }
}