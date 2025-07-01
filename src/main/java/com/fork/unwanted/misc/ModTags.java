package com.fork.unwanted.misc;

import com.fork.unwanted.Unwanted;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {

        public static final TagKey<Block> EBONY_LOGS
                = tag("ebony_logs");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> CHISELS
                = tag("chisels");
        public static final TagKey<Item> FUELS
                = tag("fuels");
        public static final TagKey<Item> ALL_FUELS
                = tag("all_fuels");
        public static final TagKey<Item> EBONY_LOGS
                = tag("ebony_logs");
        public static final TagKey<Item> NUGGETS
                = tag("nuggets");
        public static final TagKey<Item> INGOTS
                = tag("ingots");
        //tea tags

        public static final TagKey<Item> BASE_TEA
                = tag("base_teas");

        public static final TagKey<Item> GRASSY
                = tag("grassy");
        public static final TagKey<Item> WARPED
                = tag("warped");
        public static final TagKey<Item> CRIMSON
                = tag("crimson");
        public static final TagKey<Item> LEAVY
                = tag("leavy");
        public static final TagKey<Item> KELPED
                = tag("kelped");
        public static final TagKey<Item> VINEY
                = tag("viney");
        public static final TagKey<Item> GLOWY
                = tag("glowy");
        public static final TagKey<Item> SCULKED
                = tag("sculked");
        public static final TagKey<Item> ROOTED
                = tag("rooted");

        public static final TagKey<Item> TELEPORTS
                = tag("teleports");

        public static final TagKey<Item> SPAWN
                = tag("spawn");
        public static final TagKey<Item> OVERWORLD
                = tag("overworld");
        public static final TagKey<Item> NETHER
                = tag("nether");
        public static final TagKey<Item> END
                = tag("end");

        public static final TagKey<Item> MODS
                = tag("mods");

        public static final TagKey<Item> ADDITIVES
                = tag("additives");

        public static final TagKey<Item> RED_STUFF
                = tag("red_stuff");
        public static final TagKey<Item> GOLDEN_FRUIT
                = tag("golden_fruit");
        public static final TagKey<Item> GOD_APPLE
                = tag("god_apple");
        public static final TagKey<Item> SWEET
                = tag("sweet");
        public static final TagKey<Item> GLOWING_FRUIT
                = tag("glowing_fruit");
        public static final TagKey<Item> PINK_FLOWER
                = tag("pink_flower");
        public static final TagKey<Item> YELLOW_FLOWER
                = tag("yellow_flower");
        public static final TagKey<Item> WHITE_FLOWER
                = tag("white_flower");
        public static final TagKey<Item> GREY_FLOWER
                = tag("grey_flower");
        public static final TagKey<Item> BLUE_FLOWER
                = tag("blue_flower");
        public static final TagKey<Item> PURPLE_FLOWER1
                = tag("purple_flower1");
        public static final TagKey<Item> PURPLE_FLOWER2
                = tag("purple_flower2");
        public static final TagKey<Item> RED_FLOWER
                = tag("red_flower");
        public static final TagKey<Item> END_FLOWER
                = tag("end_flower");
        public static final TagKey<Item> FIRE_FLOWER
                = tag("fire_flower");
        public static final TagKey<Item> POT_FLOWER
                = tag("pot_flower");
        public static final TagKey<Item> WING
                = tag("wing");
        public static final TagKey<Item> FIRE
                = tag("fire");
        public static final TagKey<Item> TORRID
                = tag("torrid");
        public static final TagKey<Item> WITHER
                = tag("wither");



        private static TagKey<Item> tag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID, name));
        }
    }

    public static class Enchantments {

        public static final TagKey<Enchantment> MENDING
                = tag("mending");
        public static final TagKey<Enchantment> FROST_WALKER
                = tag("frost_walker");
        public static final TagKey<Enchantment> SOUL_SPEED
                = tag("soul_speed");
        public static final TagKey<Enchantment> BINDING_CURSE
                = tag("curse_of_binding");
        public static final TagKey<Enchantment> VANISH_CURSE
                = tag("curse_of_vanishing");
        public static final TagKey<Enchantment> PROT
                = tag("prot");
        public static final TagKey<Enchantment> RIPTIDE
                = tag("riptide");
        public static final TagKey<Enchantment> UNBREAKING
                = tag("unbreaking");
        public static final TagKey<Enchantment> SWEEP
                = tag("sweep");
        public static final TagKey<Enchantment> FALL
                = tag("fall");
        public static final TagKey<Enchantment> BOA
                = tag("boa");
        public static final TagKey<Enchantment> QC
                = tag("qc");
        public static final TagKey<Enchantment> SMITE
                = tag("smite");
        public static final TagKey<Enchantment> CHANNELING
                = tag("channeling");
        public static final TagKey<Enchantment> LUCK
                = tag("luck");
        public static final TagKey<Enchantment> POWER
                = tag("power");

        private static TagKey<Enchantment> tag(String name) {
            return createEnchantTag(String.valueOf(name));
        }

        private static TagKey<Enchantment> createEnchantTag(String name) {
            return TagKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID, name));
        }
    }
}
