package com.fork.unwanted.events;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.blocks.ModBlocks;
import com.fork.unwanted.items.ModItems;
import com.fork.unwanted.misc.ModTags;
import com.fork.unwanted.mob_effects.ModPotions;
import com.fork.unwanted.villager.ModVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import java.util.List;
import java.util.Optional;

@EventBusSubscriber(modid = Unwanted.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {
    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, ModItems.TORRID_STEEL_POWDER.get(), ModPotions.FRAGILE_POTION);
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event){
        RandomSource random = RandomSource.create();
        //Enchanter
        //lv1
        if(event.getType() == ModVillagers.ENCHANTER.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack lapis = new ItemStack(Items.LAPIS_LAZULI, 16);
            ItemStack ruby = new ItemStack(ModItems.RUBY.get(), 4);
            ItemStack obsidian = new ItemStack(Items.OBSIDIAN, 8);
            ItemStack cryingObsidian = new ItemStack(Items.CRYING_OBSIDIAN, 6);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(),4),
                    lapis,12,3,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.LAPIS_LAZULI,16),
                    ruby,12,3,0.025F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(),24),
                    obsidian,8,4,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(),30),
                    cryingObsidian,8,5,0.02F));
        }
        //lv2
        if(event.getType() == ModVillagers.ENCHANTER.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack bookshelf = new ItemStack(Items.BOOKSHELF, 8);
            ItemStack XP = new ItemStack(Items.EXPERIENCE_BOTTLE, 16);

            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(), 2),
                    bookshelf,4,1,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(), 4),
                    XP,12,4,0.02F));

            // BOA
            trades.get(villagerLevel).add((trader, rand) -> {
                Optional<Holder<Enchantment>> frostOptional = trader.level().registryAccess().registryOrThrow(Registries.ENCHANTMENT).getRandomElementOf(ModTags.Enchantments.BOA, random);
                ItemStack book = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(frostOptional.get(), 2));
                return new MerchantOffer(new ItemCost(ModItems.RUBY.get(), 4), book, 4, 4, 0.09F);
            });

            // smite
            trades.get(villagerLevel).add((trader, rand) -> {
                Optional<Holder<Enchantment>> soulOptional = trader.level().registryAccess().registryOrThrow(Registries.ENCHANTMENT).getRandomElementOf(ModTags.Enchantments.SMITE, random);
                ItemStack book = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(soulOptional.get(), 2));
                return new MerchantOffer(new ItemCost(ModItems.RUBY.get(), 5),book,2, 4, 0.09F);
            });

            // luck
            trades.get(villagerLevel).add((trader, rand) -> {
                Optional<Holder<Enchantment>> BindingOptional = trader.level().registryAccess().registryOrThrow(Registries.ENCHANTMENT).getRandomElementOf(ModTags.Enchantments.LUCK, random);
                ItemStack book = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(BindingOptional.get(), 3));
                return new MerchantOffer(new ItemCost(ModItems.RUBY.get(), 2),book,3, 4, 0.09F);
            });

            // channeling
            trades.get(villagerLevel).add((trader, rand) -> {
                Optional<Holder<Enchantment>> VanishOptional = trader.level().registryAccess().registryOrThrow(Registries.ENCHANTMENT).getRandomElementOf(ModTags.Enchantments.CHANNELING, random);
                ItemStack book = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(VanishOptional.get(), 2));
                return new MerchantOffer(new ItemCost(ModItems.RUBY.get(), 2),book,2, 4, 0.09F);
            });

            // quick_charge
            trades.get(villagerLevel).add((trader, rand) -> {
                Optional<Holder<Enchantment>> ProtOptional = trader.level().registryAccess().registryOrThrow(Registries.ENCHANTMENT).getRandomElementOf(ModTags.Enchantments.QC, random);
                ItemStack book = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(ProtOptional.get(), 1));
                return new MerchantOffer(new ItemCost(ModItems.RUBY.get(), 5),book,4, 4, 0.09F);
            });

            // power
            trades.get(villagerLevel).add((trader, rand) -> {
                Optional<Holder<Enchantment>> RiptideOptional = trader.level().registryAccess().registryOrThrow(Registries.ENCHANTMENT).getRandomElementOf(ModTags.Enchantments.POWER, random);
                ItemStack book = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(RiptideOptional.get(), 2));
                return new MerchantOffer(new ItemCost(ModItems.RUBY.get(), 5),book,2, 4, 0.09F);
            });

            // sweeping_edge
            trades.get(villagerLevel).add((trader, rand) -> {
                Optional<Holder<Enchantment>> VanishOptional = trader.level().registryAccess().registryOrThrow(Registries.ENCHANTMENT).getRandomElementOf(ModTags.Enchantments.SWEEP, random);
                ItemStack book = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(VanishOptional.get(), 2));
                return new MerchantOffer(new ItemCost(ModItems.RUBY.get(), 2),book,4, 4, 0.09F);
            });

            // unbreaking
            trades.get(villagerLevel).add((trader, rand) -> {
                Optional<Holder<Enchantment>> ProtOptional = trader.level().registryAccess().registryOrThrow(Registries.ENCHANTMENT).getRandomElementOf(ModTags.Enchantments.UNBREAKING, random);
                ItemStack book = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(ProtOptional.get(), 3));
                return new MerchantOffer(new ItemCost(ModItems.RUBY.get(), 8),book,3, 6, 0.09F);
            });

            // fall
            trades.get(villagerLevel).add((trader, rand) -> {
                Optional<Holder<Enchantment>> RiptideOptional = trader.level().registryAccess().registryOrThrow(Registries.ENCHANTMENT).getRandomElementOf(ModTags.Enchantments.FALL, random);
                ItemStack book = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(RiptideOptional.get(), 4));
                return new MerchantOffer(new ItemCost(ModItems.RUBY.get(), 7),book,2, 6, 0.09F);
            });
        }
        //lv3
        if(event.getType() == ModVillagers.ENCHANTER.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack enderPearl = new ItemStack(Items.ENDER_PEARL, 12);
            ItemStack enderEye = new ItemStack(Items.ENDER_EYE, 6);
            ItemStack blaze = new ItemStack(Items.BLAZE_POWDER, 8);
            ItemStack blaze_water = new ItemStack(ModItems.BLAZING_WATER.get(), 6);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(), 6),
                    enderPearl,8,6,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(), 12),
                    enderEye,6,6,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(), 12),
                    blaze,12,4,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(), 12),
                    blaze_water,12,4,0.02F));
        }
        //lv4
        if (event.getType() == ModVillagers.ENCHANTER.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            int villagerLevel = 4;

            // Mending Trade
            trades.get(villagerLevel).add((trader, rand) -> {
                Optional<Holder<Enchantment>> mendingOptional = trader.level().registryAccess().registryOrThrow(Registries.ENCHANTMENT).getRandomElementOf(ModTags.Enchantments.MENDING, random);
                ItemStack mending = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(mendingOptional.get(), 1));
//                ItemStack book;
//                if (mendingOptional.isPresent()) {
//                    book = EnchantedBookItem.createForEnchantment(
//                            new EnchantmentInstance(mendingOptional.get(), 1)
//                    );
//                } else {
//                    book = new ItemStack(Items.BOOK);
//                }
                return new MerchantOffer(new ItemCost(ModItems.RUBY.get(), 6), mending, 4, 6, 0.09F);
            });

//            trades.get(villagerLevel).add((trader, rand) -> {
//                Optional<Holder<Enchantment>> mendingOptional = trader.level().registryAccess().registryOrThrow(Registries.ENCHANTMENT).getRandomElementOf(ModTags.Enchantments.FROST_WALKER, random);
//                ItemStack mending = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(mendingOptional.get(), 1));
//                return new MerchantOffer(new ItemCost(ModItems.RUBY.get(), 6), mending, 4, 6, 0.09F);
//            });

            // Frost Walker Trade
            trades.get(villagerLevel).add((trader, rand) -> {
                Optional<Holder<Enchantment>> frostOptional = trader.level().registryAccess().registryOrThrow(Registries.ENCHANTMENT).getRandomElementOf(ModTags.Enchantments.FROST_WALKER, random);
                ItemStack book = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(frostOptional.get(), 2));
                return new MerchantOffer(new ItemCost(ModItems.RUBY.get(), 4), book, 2, 6, 0.09F);
            });

            // Soul Speed Trade
            trades.get(villagerLevel).add((trader, rand) -> {
                Optional<Holder<Enchantment>> soulOptional = trader.level().registryAccess().registryOrThrow(Registries.ENCHANTMENT).getRandomElementOf(ModTags.Enchantments.SOUL_SPEED, random);
                ItemStack book = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(soulOptional.get(), 3));
                return new MerchantOffer(new ItemCost(ModItems.RUBY.get(), 5),book,2, 6, 0.09F);
            });

            // Binding Curse Trade
            trades.get(villagerLevel).add((trader, rand) -> {
                Optional<Holder<Enchantment>> BindingOptional = trader.level().registryAccess().registryOrThrow(Registries.ENCHANTMENT).getRandomElementOf(ModTags.Enchantments.BINDING_CURSE, random);
                ItemStack book = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(BindingOptional.get(), 1));
                return new MerchantOffer(new ItemCost(ModItems.RUBY.get(), 2),book,4, 6, 0.09F);
            });

            // Vanishing Curse Trade
            trades.get(villagerLevel).add((trader, rand) -> {
                Optional<Holder<Enchantment>> VanishOptional = trader.level().registryAccess().registryOrThrow(Registries.ENCHANTMENT).getRandomElementOf(ModTags.Enchantments.VANISH_CURSE, random);
                ItemStack book = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(VanishOptional.get(), 1));
                return new MerchantOffer(new ItemCost(ModItems.RUBY.get(), 2),book,4, 6, 0.09F);
            });

            // Protection Trade
            trades.get(villagerLevel).add((trader, rand) -> {
                Optional<Holder<Enchantment>> ProtOptional = trader.level().registryAccess().registryOrThrow(Registries.ENCHANTMENT).getRandomElementOf(ModTags.Enchantments.PROT, random);
                ItemStack book = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(ProtOptional.get(), 4));
                return new MerchantOffer(new ItemCost(ModItems.RUBY.get(), 5),book,4, 6, 0.09F);
            });

            // Riptide Trade
            trades.get(villagerLevel).add((trader, rand) -> {
                Optional<Holder<Enchantment>> RiptideOptional = trader.level().registryAccess().registryOrThrow(Registries.ENCHANTMENT).getRandomElementOf(ModTags.Enchantments.RIPTIDE, random);
                ItemStack book = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(RiptideOptional.get(), 3));
                return new MerchantOffer(new ItemCost(ModItems.RUBY.get(), 5),book,2, 6, 0.09F);
            });
        }
        //lv5
        if(event.getType() == ModVillagers.ENCHANTER.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack Totem = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack Ruby = new ItemStack(ModItems.RUBY.get(), 64);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(), 64),
                    Totem,2,8,0.0F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.TOTEM_OF_UNDYING, 1),
                    Ruby,12,8,0.0F));
        }
        //Musician
        //lv1
        if(event.getType() == ModVillagers.MUSICIAN.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack cave = new ItemStack(ModItems.CAVE_WHISPERS_MUSIC_DISK.get(), 1);
            ItemStack note_block = new ItemStack(Items.NOTE_BLOCK, 4);
            ItemStack jukebox = new ItemStack(Items.JUKEBOX, 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(),16),
                    cave,4,8,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(),16),
                    note_block,12,4,0.025F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(),6),
                    jukebox,8,4,0.02F));

        }
        //lv2
        if(event.getType() == ModVillagers.MUSICIAN.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack cat = new ItemStack(Items.MUSIC_DISC_CAT, 1);
            ItemStack ten_three = new ItemStack(Items.MUSIC_DISC_13, 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(), 18),
                    cat,4,5,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(), 18),
                    ten_three,4,5,0.02F));
        }
        //lv3
        if(event.getType() == ModVillagers.MUSICIAN.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack blocks = new ItemStack(Items.MUSIC_DISC_BLOCKS, 1);
            ItemStack chirp = new ItemStack(Items.MUSIC_DISC_CHIRP, 1);
            ItemStack far = new ItemStack(Items.MUSIC_DISC_FAR, 1);
            ItemStack mall = new ItemStack(Items.MUSIC_DISC_MALL, 1);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(), 24),
                    blocks,4,5,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(), 24),
                    chirp,4,5,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(), 28),
                    far,4,5,0.03F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(), 28),
                    mall,4,5,0.03F));
        }
        //lv4
        if(event.getType() == ModVillagers.MUSICIAN.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack mellohi = new ItemStack(Items.MUSIC_DISC_MELLOHI, 1);
            ItemStack stal = new ItemStack(Items.MUSIC_DISC_STAL, 1);
            ItemStack strad = new ItemStack(Items.MUSIC_DISC_FAR, 1);
            ItemStack ward = new ItemStack(Items.MUSIC_DISC_MALL, 1);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(), 32),
                    mellohi,4,5,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(), 32),
                    stal,4,5,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(), 36),
                    strad,4,5,0.03F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(), 36),
                    ward,4,5,0.03F));
        }
        //lv5
        if(event.getType() == ModVillagers.MUSICIAN.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack eleven = new ItemStack(Items.MUSIC_DISC_11, 1);
            ItemStack wait = new ItemStack(Items.MUSIC_DISC_WAIT, 1);
            ItemStack otherside = new ItemStack(Items.MUSIC_DISC_OTHERSIDE, 1);
            ItemStack pigstep = new ItemStack(Items.MUSIC_DISC_PIGSTEP, 1);
            ItemStack darkness = new ItemStack(ModItems.DARKNESS_MUSIC_DISK.get(), 1);
            ItemStack note_block = new ItemStack(Items.NOTE_BLOCK, 4);
            ItemStack jukebox = new ItemStack(Items.JUKEBOX, 1);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(), 56),
                    eleven,4,12,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(), 36),
                    wait,4,8,0.02F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(), 64),
                    otherside,4,16,0.0F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(), 64),
                    pigstep,4,16,0.0F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(), 64),
                    darkness,4,16,0.0F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(),16),
                    note_block,12,1,0.025F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(),6),
                    jukebox,8,2,0.02F));
        }
        //Gem Cutter
        //lv1
        if(event.getType() == ModVillagers.GEM_CUTTER.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack rough_ruby = new ItemStack(ModItems.ROUGH_RUBY.get(), 2);
            ItemStack ruby = new ItemStack(ModItems.RUBY.get(), 2);
            ItemStack pure_ruby = new ItemStack(ModItems.PURE_RUBY.get(), 2);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModBlocks.RUBY_ORE.get(),1),
                    rough_ruby,12,6,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.ROUGH_RUBY.get(),1),
                    ruby,8,6,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(),1),
                    pure_ruby,4,6,0.1F));
        }
        //lv2
        if(event.getType() == ModVillagers.GEM_CUTTER.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack embarium = new ItemStack(ModItems.EMBARIUM.get(), 4);
            ItemStack lapis = new ItemStack(Items.LAPIS_LAZULI, 6);
            ItemStack deep_lapis = new ItemStack(Items.LAPIS_LAZULI, 8);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModBlocks.EMBARIUM_ORE.get(),1),
                    embarium,12,6,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.LAPIS_ORE,1),
                    lapis,12,5,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.DEEPSLATE_LAPIS_ORE,1),
                    deep_lapis,10,5,0.1F));
        }
        //lv3
        if(event.getType() == ModVillagers.GEM_CUTTER.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack amethyst = new ItemStack(Items.AMETHYST_SHARD, 4);
            ItemStack emerald = new ItemStack(Items.EMERALD, 6);
            ItemStack deep_emerald = new ItemStack(Items.EMERALD, 8);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.AMETHYST_BLOCK,1),
                    amethyst,12,5,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD_ORE,1),
                    emerald,10,5,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.DEEPSLATE_EMERALD_ORE,1),
                    deep_emerald,10,6,0.1F));
        }
        //lv4
        if(event.getType() == ModVillagers.GEM_CUTTER.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack dia = new ItemStack(Items.DIAMOND, 6);
            ItemStack deep_dia = new ItemStack(Items.DIAMOND, 8);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.DIAMOND_ORE,1),
                    dia,10,5,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.DEEPSLATE_DIAMOND_ORE,1),
                    deep_dia,10,6,0.1F));
        }
        //lv5
        if(event.getType() == ModVillagers.GEM_CUTTER.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack Totem = new ItemStack(Items.TOTEM_OF_UNDYING, 1);
            ItemStack Ruby = new ItemStack(ModItems.RUBY.get(), 64);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(), 64),
                    Totem,2,8,0.0F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.TOTEM_OF_UNDYING, 1),
                    Ruby,12,8,0.0F));

            //temp
        }
        //Collector
        //lv1
        if(event.getType() == ModVillagers.COLLECTOR.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack mob_head1 = new ItemStack(Blocks.CREEPER_HEAD, 1);
            ItemStack mob_head2 = new ItemStack(Blocks.ZOMBIE_HEAD, 1);
            ItemStack mob_head3 = new ItemStack(Blocks.SKELETON_SKULL, 1);
            ItemStack ruby = new ItemStack(ModItems.RUBY.get(), 15);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(),18),
                    mob_head1,6,6,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(),18),
                    mob_head2,6,6,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(),18),
                    mob_head3,6,6,0.1F));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Blocks.CREEPER_HEAD,1),
                    ruby,6,4,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Blocks.ZOMBIE_HEAD,1),
                    ruby,6,4,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Blocks.SKELETON_SKULL,1),
                    ruby,6,4,0.1F));
        }
        //lv2
        if(event.getType() == ModVillagers.COLLECTOR.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack mob_head1 = new ItemStack(Blocks.PIGLIN_HEAD, 1);
            ItemStack t_scute = new ItemStack(Items.TURTLE_SCUTE, 1);
            ItemStack a_scute = new ItemStack(Items.ARMADILLO_SCUTE, 1);
            ItemStack eyes = new ItemStack(Items.ENDER_EYE, 4);
            ItemStack ruby = new ItemStack(ModItems.RUBY.get(), 15);
            ItemStack ruby1 = new ItemStack(ModItems.RUBY.get(), 44);
            ItemStack ruby2 = new ItemStack(ModItems.RUBY.get(), 58);
            int villagerLevel = 2;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(),18),
                    mob_head1,6,6,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(),12),
                    t_scute,4,2,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(),12),
                    a_scute,4,2,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(),12),
                    eyes,4,2,0.1F));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Blocks.PIGLIN_HEAD,1),
                    ruby,6,4,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Blocks.WITHER_SKELETON_SKULL,1),
                    ruby1,6,4,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Blocks.DRAGON_HEAD,1),
                    ruby2,6,4,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.GHAST_TEAR,8),
                    ruby2,8,5,0.1F));
        }
        //lv3
        if(event.getType() == ModVillagers.COLLECTOR.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack ruby = new ItemStack(ModItems.RUBY.get(), 16);
            ItemStack ruby2 = new ItemStack(ModItems.RUBY.get(), 32);
            ItemStack head = new ItemStack(Items.PLAYER_HEAD, 1);
            int villagerLevel = 3;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.HEART_OF_THE_SEA,1),
                    ruby,8,4,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.ECHO_SHARD,1),
                    ruby,8,3,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(ModItems.RUBY.get(),20),
                    head,4,6,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.ELYTRA,1),
                    ruby2,8,5,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.ENCHANTED_BOOK,1),
                    ruby,8,4,0.1F));

        }
        //lv4
        if(event.getType() == ModVillagers.COLLECTOR.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack ruby = new ItemStack(ModItems.RUBY.get(), 54);
            ItemStack ruby2 = new ItemStack(ModItems.RUBY.get(), 64);
            ItemStack ruby3 = new ItemStack(ModItems.RUBY.get(), 18);
            int villagerLevel = 4;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.NETHER_STAR,1),
                    ruby,8,5,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.SHULKER_SHELL,1),
                    ruby3,8,3,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.NAUTILUS_SHELL,1),
                    ruby3,8,3,0.1F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.ENCHANTED_GOLDEN_APPLE,1),
                    ruby2,8,5,0.1F));
        }
        //lv5
        if(event.getType() == ModVillagers.COLLECTOR.value()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack Ruby = new ItemStack(ModItems.RUBY.get(), 64);
            int villagerLevel = 5;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.TOTEM_OF_UNDYING, 1),
                    Ruby,12,8,0.0F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.DRAGON_BREATH, 4),
                    Ruby,12,8,0.0F));
            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemCost(Items.PHANTOM_MEMBRANE, 4),
                    Ruby,12,8,0.0F));

            //temp
        }
    }

    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

//        genericTrades.add((entity, randomSource) -> new MerchantOffer(
//                new ItemCost(Items.EMERALD, 16),
//                new ItemStack(ModItems.KAUPEN_SMITHING_TEMPLATE.get(), 1), 1, 10, 0.2f));
//
//        rareTrades.add((entity, randomSource) -> new MerchantOffer(
//                new ItemCost(Items.NETHERITE_INGOT, 1),
//                new ItemStack(ModItems.BAR_BRAWL_MUSIC_DISC.get(), 1), 1, 10, 0.2f));
    }
}
