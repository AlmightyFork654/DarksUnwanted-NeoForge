package com.fork.unwanted.items;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.blocks.ModBlocks;
import com.fork.unwanted.entity.ModEntities;
import com.fork.unwanted.entity.custom.ModBoatEntity;
import com.fork.unwanted.items.armor_and_tools.*;
import com.fork.unwanted.items.custom.GemInfuserItem;
import com.fork.unwanted.items.custom.ModBoatItem;
import com.fork.unwanted.items.custom.PureBlazePowderItem;
import com.fork.unwanted.items.food.TeaCupItem;
import com.fork.unwanted.items.food.TeaItem;
import com.fork.unwanted.items.spear.SpearItem;
import com.fork.unwanted.sfx.ModSounds;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(Unwanted.MOD_ID);

    //Items

        //Misc

    public static final DeferredItem<Item> GEM_INFUSER_ITEM = ITEMS.register("gem_infuser",
            () -> new GemInfuserItem(ModBlocks.GEM_INFUSER.get(), new Item.Properties()));

    public static final DeferredItem<Item> PURE_BLAZE_POWDER = ITEMS.register("pure_blaze_powder",
            () -> new PureBlazePowderItem(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> BLAZING_WATER = ITEMS.register("blazing_water",
        () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));

    public static final DeferredItem<Item> EBONY_BOAT = ITEMS.register("ebony_boat",
            () -> new ModBoatItem(false, ModBoatEntity.Type.EBONY, new Item.Properties()));
    public static final DeferredItem<Item> EBONY_CHEST_BOAT = ITEMS.register("ebony_chest_boat",
            () -> new ModBoatItem(true, ModBoatEntity.Type.EBONY, new Item.Properties()));

    public static final DeferredItem<Item> WOODEN_SPEAR_HEAD = ITEMS.register("wooden_spear_head",
            ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TEA_CUP = ITEMS.register("tea_cup",
            ()-> new TeaCupItem(new Item.Properties()));

    public static final DeferredItem<Item> CUP_OF_WATER = ITEMS.register("cup_of_water",
            ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> GRASSY_TEA = ITEMS.register("grassy_tea",
            ()-> new TeaItem(new Item.Properties()));
    public static final DeferredItem<Item> WARPED_TEA = ITEMS.register("warped_tea",
            ()-> new TeaItem(new Item.Properties()));
    public static final DeferredItem<Item> CRIMSON_TEA = ITEMS.register("crimson_tea",
            ()-> new TeaItem(new Item.Properties()));
    public static final DeferredItem<Item> LEAVY_TEA = ITEMS.register("leavy_tea",
            ()-> new TeaItem(new Item.Properties()));
    public static final DeferredItem<Item> KELPED_TEA = ITEMS.register("kelped_tea",
            ()-> new TeaItem(new Item.Properties()));
    public static final DeferredItem<Item> VINEY_TEA = ITEMS.register("viney_tea",
            ()-> new TeaItem(new Item.Properties()));
    public static final DeferredItem<Item> GLOWY_TEA = ITEMS.register("glowy_tea",
            ()-> new TeaItem(new Item.Properties()));
    public static final DeferredItem<Item> SCULKED_TEA = ITEMS.register("sculked_tea",
            ()-> new TeaItem(new Item.Properties()));
    public static final DeferredItem<Item> ROOTED_TEA = ITEMS.register("rooted_tea",
            ()-> new TeaItem(new Item.Properties()));

        //Stone

    public static final DeferredItem<Item> MARBLE_SHARD = ITEMS.register("marble_shard",
            () -> new Item(new Item.Properties()));

        //Ores

    public static final DeferredItem<Item> ROUGH_RUBY = ITEMS.register("rough_ruby",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PURE_RUBY = ITEMS.register("pure_ruby",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TORRID_STEEL_INGOT = ITEMS.register("torrid_steel_ingot",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> TORRID_STEEL_NUGGET = ITEMS.register("torrid_steel_nugget",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> TORRID_STEEL_POWDER = ITEMS.register("torrid_steel_powder",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> EMBARIUM = ITEMS.register("embarium",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PROFUNDIUM_FLAKE = ITEMS.register("profundium_flake",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> PROFUNDIUM_SCRAP = ITEMS.register("profundium_scrap",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> PROFUNDIUM_INGOT = ITEMS.register("profundium_ingot",
            () -> new Item(new Item.Properties().fireResistant()));

        //music

    public static final DeferredItem<Item> DARKNESS_MUSIC_DISK = ITEMS.register("darkness_music_disc",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.DARKNESS_KEY).stacksTo(1)));

    public static final DeferredItem<Item> CAVE_WHISPERS_MUSIC_DISK = ITEMS.register("cave_whispers_music_disc",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.CAVE_WHISPERS_KEY)));

        // tools

    public static final DeferredItem<Item>  CHISEL = ITEMS.register("chisel",
            () -> new Item(new Item.Properties().stacksTo(1).durability(256)));

    public static final DeferredItem<Item> NETHERITE_CHISEL = ITEMS.register("netherite_chisel",
            () -> new Item(new Item.Properties().fireResistant().stacksTo(1).durability(1024)));

    public static final DeferredItem<Item> WOODEN_SPEAR = ITEMS.register("wooden_spear",
            () -> new SpearItem(new Item.Properties().durability(32).attributes(SpearItem.createAttributes(2f, -3f))
                    .component(DataComponents.TOOL, SpearItem.createToolProperties()), 3f, 5, ModItems.WOODEN_SPEAR_HEAD.get(), ModEntities.WOODEN_SPEAR.get()));
    public static final DeferredItem<Item> STONE_SPEAR = ITEMS.register("stone_spear",
            () -> new SpearItem(new Item.Properties().durability(64).attributes(SpearItem.createAttributes(4f, -2f))
                    .component(DataComponents.TOOL, SpearItem.createToolProperties()), 5f, 4, Items.STONE, ModEntities.STONE_SPEAR.get()));
    public static final DeferredItem<Item> GOLDEN_SPEAR = ITEMS.register("golden_spear",
            () -> new SpearItem(new Item.Properties().durability(32).attributes(SpearItem.createAttributes(4f, 1f))
                    .component(DataComponents.TOOL, SpearItem.createToolProperties()), 5f, 1, Items.GOLD_INGOT, ModEntities.GOLDEN_SPEAR.get()));
    public static final DeferredItem<Item> IRON_SPEAR = ITEMS.register("iron_spear",
            () -> new SpearItem(new Item.Properties().durability(128).attributes(SpearItem.createAttributes(5f, -1f))
                    .component(DataComponents.TOOL, SpearItem.createToolProperties()), 6f, 3, Items.IRON_INGOT, ModEntities.IRON_SPEAR.get()));
    public static final DeferredItem<Item> EMBARIUM_SPEAR = ITEMS.register("embarium_spear",
            () -> new SpearItem(new Item.Properties().durability(196).attributes(SpearItem.createAttributes(5f, -1f))
                    .component(DataComponents.TOOL, SpearItem.createToolProperties()), 6f, 3, ModItems.EMBARIUM.get(), ModEntities.EMBARIUM_SPEAR.get()));
    public static final DeferredItem<Item> TORRID_STEEL_SPEAR = ITEMS.register("torrid_steel_spear",
            () -> new SpearItem(new Item.Properties().durability(128).fireResistant().attributes(SpearItem.createAttributes(6f, 0f))
                    .component(DataComponents.TOOL, SpearItem.createToolProperties()), 7f, 2, ModItems.TORRID_STEEL_INGOT.get(), ModEntities.TORRID_STEEL_SPEAR.get()));
    public static final DeferredItem<Item> DIAMOND_SPEAR = ITEMS.register("diamond_spear",
            () -> new SpearItem(new Item.Properties().durability(196).attributes(SpearItem.createAttributes(7f, 0f))
                    .component(DataComponents.TOOL, SpearItem.createToolProperties()), 8f, 2, Items.DIAMOND, ModEntities.DIAMOND_SPEAR.get()));
    public static final DeferredItem<Item> NETHERITE_SPEAR = ITEMS.register("netherite_spear",
            () -> new SpearItem(new Item.Properties().durability(256).fireResistant().attributes(SpearItem.createAttributes(9f, 0f))
                    .component(DataComponents.TOOL, SpearItem.createToolProperties()), 10f, 2, Items.NETHERITE_INGOT, ModEntities.NETHERITE_SPEAR.get()));
    public static final DeferredItem<Item> PROFUNDIUM_SPEAR = ITEMS.register("profundium_spear",
            () -> new SpearItem(new Item.Properties().durability(320).fireResistant().attributes(SpearItem.createAttributes(11f, 1f))
                    .component(DataComponents.TOOL, SpearItem.createToolProperties()), 12f, 1, ModItems.PROFUNDIUM_INGOT.get(), ModEntities.PROFUNDIUM_SPEAR.get()));

    
    //armor&tools

    //embarium
    public static final DeferredItem<SwordItem> EMBARIUM_SWORD = ITEMS.register("embarium_sword",
            () -> new SwordItem(ModToolTiers.EMBARIUM, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.EMBARIUM, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> EMBARIUM_PICKAXE = ITEMS.register("embarium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.EMBARIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.EMBARIUM, 1, -2.8F))));
    public static final DeferredItem<AxeItem> EMBARIUM_AXE = ITEMS.register("embarium_axe",
            () -> new AxeItem(ModToolTiers.EMBARIUM, new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.EMBARIUM, 6, -3.1F))));
    public static final DeferredItem<ShovelItem> EMBARIUM_SHOVEL = ITEMS.register("embarium_shovel",
            () -> new ShovelItem(ModToolTiers.EMBARIUM, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.EMBARIUM, 1.5f, -3.0F))));
    public static final DeferredItem<HoeItem> EMBARIUM_HOE = ITEMS.register("embarium_hoe",
            () -> new HoeItem(ModToolTiers.EMBARIUM, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.EMBARIUM, -2, -1.0F))));

    //torrid steel
    public static final DeferredItem<FireSwordItem> TORRID_STEEL_SWORD = ITEMS.register("torrid_steel_sword",
            () -> new FireSwordItem(ModToolTiers.TORRID, new Item.Properties().fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.TORRID, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> TORRID_STEEL_PICKAXE = ITEMS.register("torrid_steel_pickaxe",
            () -> new PickaxeItem(ModToolTiers.TORRID, new Item.Properties().fireResistant().attributes(PickaxeItem.createAttributes(ModToolTiers.TORRID, 1, -2.8F))));
    public static final DeferredItem<AxeItem> TORRID_STEEL_AXE = ITEMS.register("torrid_steel_axe",
            () -> new AxeItem(ModToolTiers.TORRID, new Item.Properties().fireResistant().attributes(AxeItem.createAttributes(ModToolTiers.TORRID, 5.0F, -3.1F))));
    public static final DeferredItem<ShovelItem> TORRID_STEEL_SHOVEL = ITEMS.register("torrid_steel_shovel",
            () -> new ShovelItem(ModToolTiers.TORRID, new Item.Properties().fireResistant().attributes(ShovelItem.createAttributes(ModToolTiers.TORRID, 0.5F, -3.0F))));
    public static final DeferredItem<HoeItem> TORRID_STEEL_HOE = ITEMS.register("torrid_steel_hoe",
            () -> new HoeItem(ModToolTiers.TORRID, new Item.Properties().fireResistant().attributes(HoeItem.createAttributes(ModToolTiers.TORRID, -3, -1.0F))));


    //embarium torrid steel
    public static final DeferredItem<FireSwordItem> TORRID_EMBARIUM_SWORD = ITEMS.register("torrid_embarium_sword",
            () -> new FireSwordItem(ModToolTiers.TORRID_EMBARIUM, new Item.Properties().fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.TORRID_EMBARIUM, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> TORRID_EMBARIUM_PICKAXE = ITEMS.register("torrid_embarium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.TORRID_EMBARIUM, new Item.Properties().fireResistant().attributes(PickaxeItem.createAttributes(ModToolTiers.TORRID_EMBARIUM, 1, -2.8F))));
    public static final DeferredItem<AxeItem> TORRID_EMBARIUM_AXE = ITEMS.register("torrid_embarium_axe",
            () -> new AxeItem(ModToolTiers.TORRID_EMBARIUM, new Item.Properties().fireResistant().attributes(AxeItem.createAttributes(ModToolTiers.TORRID_EMBARIUM, 5.0F, -3.1F))));
    public static final DeferredItem<ShovelItem> TORRID_EMBARIUM_SHOVEL = ITEMS.register("torrid_embarium_shovel",
            () -> new ShovelItem(ModToolTiers.TORRID_EMBARIUM, new Item.Properties().fireResistant().attributes(ShovelItem.createAttributes(ModToolTiers.TORRID_EMBARIUM, 0.5F, -3.0F))));
    public static final DeferredItem<HoeItem> TORRID_EMBARIUM_HOE = ITEMS.register("torrid_embarium_hoe",
            () -> new HoeItem(ModToolTiers.TORRID_EMBARIUM, new Item.Properties().fireResistant().attributes(HoeItem.createAttributes(ModToolTiers.TORRID_EMBARIUM, -3, -1.0F))));

    //profundium
    public static final DeferredItem<SwordItem> PROFUNDIUM_SWORD = ITEMS.register("profundium_sword",
            () -> new SwordItem(ModToolTiers.PROFUNDIUM, (new Item.Properties()).fireResistant().attributes(SwordItem.createAttributes(ModToolTiers.PROFUNDIUM, 4, -1.4F))));
    public static final DeferredItem<PickaxeItem> PROFUNDIUM_PICKAXE = ITEMS.register("profundium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PROFUNDIUM, (new Item.Properties()).fireResistant().attributes(PickaxeItem.createAttributes(ModToolTiers.PROFUNDIUM, 2, -2.4F))));
    public static final DeferredItem<AxeItem> PROFUNDIUM_AXE = ITEMS.register("profundium_axe",
            () -> new AxeItem(ModToolTiers.PROFUNDIUM, (new Item.Properties()).fireResistant().attributes(AxeItem.createAttributes(ModToolTiers.PROFUNDIUM, 6.0F, -2.0F))));
    public static final DeferredItem<ShovelItem> PROFUNDIUM_SHOVEL = ITEMS.register("profundium_shovel",
            () -> new ShovelItem(ModToolTiers.PROFUNDIUM, (new Item.Properties()).fireResistant().attributes(ShovelItem.createAttributes(ModToolTiers.PROFUNDIUM, 2.5F, -2.0F))));
    public static final DeferredItem<HoeItem> PROFUNDIUM_HOE = ITEMS.register("profundium_hoe",
            () -> new HoeItem(ModToolTiers.PROFUNDIUM, (new Item.Properties()).fireResistant().attributes(HoeItem.createAttributes(ModToolTiers.PROFUNDIUM, -3, -1.0F))));

//advanced

    //advanced wood

    public static final DeferredItem<FireSwordItem> WOODEN_TORRID_SWORD = ITEMS.register("wooden_torrid_sword",
            () -> new FireSwordItem(ModToolTiers.WOOD_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.WOOD_T, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> WOODEN_TORRID_PICKAXE = ITEMS.register("wooden_torrid_pickaxe",
            () -> new PickaxeItem(ModToolTiers.WOOD_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.WOOD_T, 1, -2.8F))));
    public static final DeferredItem<AxeItem> WOODEN_TORRID_AXE = ITEMS.register("wooden_torrid_axe",
            () -> new AxeItem(ModToolTiers.WOOD_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.WOOD_T, 6.0F, -3.2F))));
    public static final DeferredItem<ShovelItem> WOODEN_TORRID_SHOVEL = ITEMS.register("wooden_torrid_shovel",
            () -> new ShovelItem(ModToolTiers.WOOD_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.WOOD_T, 1.5F, -3.0F))));
    public static final DeferredItem<HoeItem> WOODEN_TORRID_HOE = ITEMS.register("wooden_torrid_hoe",
            () -> new HoeItem(ModToolTiers.WOOD_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.WOOD_T, 0, -3.0F))));

    public static final DeferredItem<SwordItem> WOODEN_EMBARIUM_SWORD = ITEMS.register("wooden_embarium_sword",
            () -> new SwordItem(ModToolTiers.WOOD_E, (new Item.Properties()).attributes(SwordItem.createAttributes(ModToolTiers.WOOD_E, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> WOODEN_EMBARIUM_PICKAXE = ITEMS.register("wooden_embarium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.WOOD_E, (new Item.Properties()).attributes(PickaxeItem.createAttributes(ModToolTiers.WOOD_E, 1, -2.8F))));
    public static final DeferredItem<AxeItem> WOODEN_EMBARIUM_AXE = ITEMS.register("wooden_embarium_axe",
            () -> new AxeItem(ModToolTiers.WOOD_E, (new Item.Properties()).attributes(AxeItem.createAttributes(ModToolTiers.WOOD_E, 6.0F, -3.2F))));
    public static final DeferredItem<ShovelItem> WOODEN_EMBARIUM_SHOVEL = ITEMS.register("wooden_embarium_shovel",
            () -> new ShovelItem(ModToolTiers.WOOD_E, (new Item.Properties()).attributes(ShovelItem.createAttributes(ModToolTiers.WOOD_E, 1.5F, -3.0F))));
    public static final DeferredItem<HoeItem> WOODEN_EMBARIUM_HOE = ITEMS.register("wooden_embarium_hoe",
            () -> new HoeItem(ModToolTiers.WOOD_E, (new Item.Properties()).attributes(HoeItem.createAttributes(ModToolTiers.WOOD_E, 0, -3.0F))));

    public static final DeferredItem<FireSwordItem> WOODEN_TORRID_EMBARIUM_SWORD = ITEMS.register("wooden_torrid_embarium_sword",
            () -> new FireSwordItem(ModToolTiers.WOOD_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.WOOD_ET, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> WOODEN_TORRID_EMBARIUM_PICKAXE = ITEMS.register("wooden_torrid_embarium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.WOOD_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.WOOD_ET, 1, -2.8F))));
    public static final DeferredItem<AxeItem> WOODEN_TORRID_EMBARIUM_AXE = ITEMS.register("wooden_torrid_embarium_axe",
            () -> new AxeItem(ModToolTiers.WOOD_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.WOOD_ET, 6.0F, -3.2F))));
    public static final DeferredItem<ShovelItem> WOODEN_TORRID_EMBARIUM_SHOVEL = ITEMS.register("wooden_torrid_embarium_shovel",
            () -> new ShovelItem(ModToolTiers.WOOD_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.WOOD_ET, 1.5F, -3.0F))));
    public static final DeferredItem<HoeItem> WOODEN_TORRID_EMBARIUM_HOE = ITEMS.register("wooden_torrid_embarium_hoe",
            () -> new HoeItem(ModToolTiers.WOOD_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.WOOD_ET, 0, -3.0F))));

    //advanced stone

    public static final DeferredItem<FireSwordItem> STONE_TORRID_SWORD = ITEMS.register("stone_torrid_sword",
            () -> new FireSwordItem(ModToolTiers.STONE_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.STONE_T, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> STONE_TORRID_PICKAXE = ITEMS.register("stone_torrid_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STONE_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.STONE_T, 1, -2.8F))));
    public static final DeferredItem<AxeItem> STONE_TORRID_AXE = ITEMS.register("stone_torrid_axe",
            () -> new AxeItem(ModToolTiers.STONE_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.STONE_T, 7.0F, -3.2F))));
    public static final DeferredItem<ShovelItem> STONE_TORRID_SHOVEL = ITEMS.register("stone_torrid_shovel",
            () -> new ShovelItem(ModToolTiers.STONE_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.STONE_T, 1.5F, -3.0F))));
    public static final DeferredItem<HoeItem> STONE_TORRID_HOE = ITEMS.register("stone_torrid_hoe",
            () -> new HoeItem(ModToolTiers.STONE_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.STONE_T, -1, -2.0F))));

    public static final DeferredItem<SwordItem> STONE_EMBARIUM_SWORD = ITEMS.register("stone_embarium_sword",
            () -> new SwordItem(ModToolTiers.STONE_E, (new Item.Properties()).attributes(SwordItem.createAttributes(ModToolTiers.STONE_E, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> STONE_EMBARIUM_PICKAXE = ITEMS.register("stone_embarium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STONE_E, (new Item.Properties()).attributes(PickaxeItem.createAttributes(ModToolTiers.STONE_E, 1, -2.8F))));
    public static final DeferredItem<AxeItem> STONE_EMBARIUM_AXE = ITEMS.register("stone_embarium_axe",
            () -> new AxeItem(ModToolTiers.STONE_E, (new Item.Properties()).attributes(AxeItem.createAttributes(ModToolTiers.STONE_E, 7.0F, -3.2F))));
    public static final DeferredItem<ShovelItem> STONE_EMBARIUM_SHOVEL = ITEMS.register("stone_embarium_shovel",
            () -> new ShovelItem(ModToolTiers.STONE_E, (new Item.Properties()).attributes(ShovelItem.createAttributes(ModToolTiers.STONE_E, 1.5F, -3.0F))));
    public static final DeferredItem<HoeItem> STONE_EMBARIUM_HOE = ITEMS.register("stone_embarium_hoe",
            () -> new HoeItem(ModToolTiers.STONE_E, (new Item.Properties()).attributes(HoeItem.createAttributes(ModToolTiers.STONE_E, -1, -2.0F))));

    public static final DeferredItem<FireSwordItem> STONE_TORRID_EMBARIUM_SWORD = ITEMS.register("stone_torrid_embarium_sword",
            () -> new FireSwordItem(ModToolTiers.STONE_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.STONE_ET, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> STONE_TORRID_EMBARIUM_PICKAXE = ITEMS.register("stone_torrid_embarium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STONE_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.STONE_ET, 1, -2.8F))));
    public static final DeferredItem<AxeItem> STONE_TORRID_EMBARIUM_AXE = ITEMS.register("stone_torrid_embarium_axe",
            () -> new AxeItem(ModToolTiers.STONE_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.STONE_ET, 7.0F, -3.2F))));
    public static final DeferredItem<ShovelItem> STONE_TORRID_EMBARIUM_SHOVEL = ITEMS.register("stone_torrid_embarium_shovel",
            () -> new ShovelItem(ModToolTiers.STONE_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.STONE_ET, 1.5F, -3.0F))));
    public static final DeferredItem<HoeItem> STONE_TORRID_EMBARIUM_HOE = ITEMS.register("stone_torrid_embarium_hoe",
            () -> new HoeItem(ModToolTiers.STONE_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.STONE_ET, -1, -2.0F))));

    //advanced iron

    public static final DeferredItem<FireSwordItem> IRON_TORRID_SWORD = ITEMS.register("iron_torrid_sword",
            () -> new FireSwordItem(ModToolTiers.IRON_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.IRON_T, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> IRON_TORRID_PICKAXE = ITEMS.register("iron_torrid_pickaxe",
            () -> new PickaxeItem(ModToolTiers.IRON_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.IRON_T, 1, -2.8F))));
    public static final DeferredItem<AxeItem> IRON_TORRID_AXE = ITEMS.register("iron_torrid_axe",
            () -> new AxeItem(ModToolTiers.IRON_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.IRON_T, 6.0F, -3.1F))));
    public static final DeferredItem<ShovelItem> IRON_TORRID_SHOVEL = ITEMS.register("iron_torrid_shovel",
            () -> new ShovelItem(ModToolTiers.IRON_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.IRON_T, 1.5F, -3.0F))));
    public static final DeferredItem<HoeItem> IRON_TORRID_HOE = ITEMS.register("iron_torrid_hoe",
            () -> new HoeItem(ModToolTiers.IRON_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.IRON_T, -2, -1.0F))));

    public static final DeferredItem<SwordItem> IRON_EMBARIUM_SWORD = ITEMS.register("iron_embarium_sword",
            () -> new SwordItem(ModToolTiers.IRON_E, (new Item.Properties()).attributes(SwordItem.createAttributes(ModToolTiers.IRON_E, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> IRON_EMBARIUM_PICKAXE = ITEMS.register("iron_embarium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.IRON_E, (new Item.Properties()).attributes(PickaxeItem.createAttributes(ModToolTiers.IRON_E, 1, -2.8F))));
    public static final DeferredItem<AxeItem> IRON_EMBARIUM_AXE = ITEMS.register("iron_embarium_axe",
            () -> new AxeItem(ModToolTiers.IRON_E, (new Item.Properties()).attributes(AxeItem.createAttributes(ModToolTiers.IRON_E, 6.0F, -3.1F))));
    public static final DeferredItem<ShovelItem> IRON_EMBARIUM_SHOVEL = ITEMS.register("iron_embarium_shovel",
            () -> new ShovelItem(ModToolTiers.IRON_E, (new Item.Properties()).attributes(ShovelItem.createAttributes(ModToolTiers.IRON_E, 1.5F, -3.0F))));
    public static final DeferredItem<HoeItem> IRON_EMBARIUM_HOE = ITEMS.register("iron_embarium_hoe",
            () -> new HoeItem(ModToolTiers.IRON_E, (new Item.Properties()).attributes(HoeItem.createAttributes(ModToolTiers.IRON_E, -2, -1.0F))));

    public static final DeferredItem<FireSwordItem> IRON_TORRID_EMBARIUM_SWORD = ITEMS.register("iron_torrid_embarium_sword",
            () -> new FireSwordItem(ModToolTiers.IRON_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.IRON_ET, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> IRON_TORRID_EMBARIUM_PICKAXE = ITEMS.register("iron_torrid_embarium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.IRON_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.IRON_ET, 1, -2.8F))));
    public static final DeferredItem<AxeItem> IRON_TORRID_EMBARIUM_AXE = ITEMS.register("iron_torrid_embarium_axe",
            () -> new AxeItem(ModToolTiers.IRON_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.IRON_ET, 6.0F, -3.1F))));
    public static final DeferredItem<ShovelItem> IRON_TORRID_EMBARIUM_SHOVEL = ITEMS.register("iron_torrid_embarium_shovel",
            () -> new ShovelItem(ModToolTiers.IRON_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.IRON_ET, 1.5F, -3.0F))));
    public static final DeferredItem<HoeItem> IRON_TORRID_EMBARIUM_HOE = ITEMS.register("iron_torrid_embarium_hoe",
            () -> new HoeItem(ModToolTiers.IRON_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.IRON_ET, -2, -1.0F))));

    //advanced gold

    public static final DeferredItem<FireSwordItem> GOLDEN_TORRID_SWORD = ITEMS.register("golden_torrid_sword",
            () -> new FireSwordItem(ModToolTiers.GOLD_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.GOLD_T, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> GOLDEN_TORRID_PICKAXE = ITEMS.register("golden_torrid_pickaxe",
            () -> new PickaxeItem(ModToolTiers.GOLD_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.GOLD_T, 1, -2.8F))));
    public static final DeferredItem<AxeItem> GOLDEN_TORRID_AXE = ITEMS.register("golden_torrid_axe",
            () -> new AxeItem(ModToolTiers.GOLD_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.GOLD_T, 6.0F, -3.0F))));
    public static final DeferredItem<ShovelItem> GOLDEN_TORRID_SHOVEL = ITEMS.register("golden_torrid_shovel",
            () -> new ShovelItem(ModToolTiers.GOLD_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.GOLD_T, 1.5F, -3.0F))));
    public static final DeferredItem<HoeItem> GOLDEN_TORRID_HOE = ITEMS.register("golden_torrid_hoe",
            () -> new HoeItem(ModToolTiers.GOLD_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.GOLD_T, 0, -3.0F))));

    public static final DeferredItem<SwordItem> GOLDEN_EMBARIUM_SWORD = ITEMS.register("golden_embarium_sword",
            () -> new SwordItem(ModToolTiers.GOLD_E, (new Item.Properties()).attributes(SwordItem.createAttributes(ModToolTiers.GOLD_E, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> GOLDEN_EMBARIUM_PICKAXE = ITEMS.register("golden_embarium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.GOLD_E, (new Item.Properties()).attributes(PickaxeItem.createAttributes(ModToolTiers.GOLD_E, 1, -2.8F))));
    public static final DeferredItem<AxeItem> GOLDEN_EMBARIUM_AXE = ITEMS.register("golden_embarium_axe",
            () -> new AxeItem(ModToolTiers.GOLD_E, (new Item.Properties()).attributes(AxeItem.createAttributes(ModToolTiers.GOLD_E, 6.0F, -3.0F))));
    public static final DeferredItem<ShovelItem> GOLDEN_EMBARIUM_SHOVEL = ITEMS.register("golden_embarium_shovel",
            () -> new ShovelItem(ModToolTiers.GOLD_E, (new Item.Properties()).attributes(ShovelItem.createAttributes(ModToolTiers.GOLD_E, 1.5F, -3.0F))));
    public static final DeferredItem<HoeItem> GOLDEN_EMBARIUM_HOE = ITEMS.register("golden_embarium_hoe",
            () -> new HoeItem(ModToolTiers.GOLD_E, (new Item.Properties()).attributes(HoeItem.createAttributes(ModToolTiers.GOLD_E, 0, -3.0F))));

    public static final DeferredItem<FireSwordItem> GOLDEN_TORRID_EMBARIUM_SWORD = ITEMS.register("golden_torrid_embarium_sword",
            () -> new FireSwordItem(ModToolTiers.GOLD_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.GOLD_ET, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> GOLDEN_TORRID_EMBARIUM_PICKAXE = ITEMS.register("golden_torrid_embarium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.GOLD_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.GOLD_ET, 1, -2.8F))));
    public static final DeferredItem<AxeItem> GOLDEN_TORRID_EMBARIUM_AXE = ITEMS.register("golden_torrid_embarium_axe",
            () -> new AxeItem(ModToolTiers.GOLD_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.GOLD_ET, 6.0F, -3.0F))));
    public static final DeferredItem<ShovelItem> GOLDEN_TORRID_EMBARIUM_SHOVEL = ITEMS.register("golden_torrid_embarium_shovel",
            () -> new ShovelItem(ModToolTiers.GOLD_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.GOLD_ET, 1.5F, -3.0F))));
    public static final DeferredItem<HoeItem> GOLDEN_TORRID_EMBARIUM_HOE = ITEMS.register("golden_torrid_embarium_hoe",
            () -> new HoeItem(ModToolTiers.GOLD_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.GOLD_ET, 0, -3.0F))));

    //advanced diamond

    public static final DeferredItem<FireSwordItem> DIAMOND_TORRID_SWORD = ITEMS.register("diamond_torrid_sword",
            () -> new FireSwordItem(ModToolTiers.DIAMOND_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.DIAMOND_T, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> DIAMOND_TORRID_PICKAXE = ITEMS.register("diamond_torrid_pickaxe",
            () -> new PickaxeItem(ModToolTiers.DIAMOND_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.DIAMOND_T, 1, -2.8F))));
    public static final DeferredItem<AxeItem> DIAMOND_TORRID_AXE = ITEMS.register("diamond_torrid_axe",
            () -> new AxeItem(ModToolTiers.DIAMOND_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.DIAMOND_T, 5.0F, -3.0F))));
    public static final DeferredItem<ShovelItem> DIAMOND_TORRID_SHOVEL = ITEMS.register("diamond_torrid_shovel",
            () -> new ShovelItem(ModToolTiers.DIAMOND_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.DIAMOND_T, 1.5F, -3.0F))));
    public static final DeferredItem<HoeItem> DIAMOND_TORRID_HOE = ITEMS.register("diamond_torrid_hoe",
            () -> new HoeItem(ModToolTiers.DIAMOND_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.DIAMOND_T, -3, 0.0F))));

    public static final DeferredItem<SwordItem> DIAMOND_EMBARIUM_SWORD = ITEMS.register("diamond_embarium_sword",
            () -> new SwordItem(ModToolTiers.DIAMOND_E, (new Item.Properties()).attributes(SwordItem.createAttributes(ModToolTiers.DIAMOND_E, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> DIAMOND_EMBARIUM_PICKAXE = ITEMS.register("diamond_embarium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.DIAMOND_E, (new Item.Properties()).attributes(PickaxeItem.createAttributes(ModToolTiers.DIAMOND_E, 1, -2.8F))));
    public static final DeferredItem<AxeItem> DIAMOND_EMBARIUM_AXE = ITEMS.register("diamond_embarium_axe",
            () -> new AxeItem(ModToolTiers.DIAMOND_E, (new Item.Properties()).attributes(AxeItem.createAttributes(ModToolTiers.DIAMOND_E, 5.0F, -3.0F))));
    public static final DeferredItem<ShovelItem> DIAMOND_EMBARIUM_SHOVEL = ITEMS.register("diamond_embarium_shovel",
            () -> new ShovelItem(ModToolTiers.DIAMOND_E, (new Item.Properties()).attributes(ShovelItem.createAttributes(ModToolTiers.DIAMOND_E, 1.5F, -3.0F))));
    public static final DeferredItem<HoeItem> DIAMOND_EMBARIUM_HOE = ITEMS.register("diamond_embarium_hoe",
            () -> new HoeItem(ModToolTiers.DIAMOND_E, (new Item.Properties()).attributes(HoeItem.createAttributes(ModToolTiers.DIAMOND_E, -3, 0.0F))));

    public static final DeferredItem<FireSwordItem> DIAMOND_TORRID_EMBARIUM_SWORD = ITEMS.register("diamond_torrid_embarium_sword",
            () -> new FireSwordItem(ModToolTiers.DIAMOND_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.DIAMOND_ET, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> DIAMOND_TORRID_EMBARIUM_PICKAXE = ITEMS.register("diamond_torrid_embarium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.DIAMOND_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.DIAMOND_ET, 1, -2.8F))));
    public static final DeferredItem<AxeItem> DIAMOND_TORRID_EMBARIUM_AXE = ITEMS.register("diamond_torrid_embarium_axe",
            () -> new AxeItem(ModToolTiers.DIAMOND_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.DIAMOND_ET, 5.0F, -3.0F))));
    public static final DeferredItem<ShovelItem> DIAMOND_TORRID_EMBARIUM_SHOVEL = ITEMS.register("diamond_torrid_embarium_shovel",
            () -> new ShovelItem(ModToolTiers.DIAMOND_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.DIAMOND_ET, 1.5F, -3.0F))));
    public static final DeferredItem<HoeItem> DIAMOND_TORRID_EMBARIUM_HOE = ITEMS.register("diamond_torrid_embarium_hoe",
            () -> new HoeItem(ModToolTiers.DIAMOND_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.DIAMOND_ET, -3, 0.0F))));

    //advanced netherite

    public static final DeferredItem<FireSwordItem> NETHERITE_TORRID_SWORD = ITEMS.register("netherite_torrid_sword",
            () -> new FireSwordItem(ModToolTiers.NETHERITE_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.NETHERITE_T, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> NETHERITE_TORRID_PICKAXE = ITEMS.register("netherite_torrid_pickaxe",
            () -> new PickaxeItem(ModToolTiers.NETHERITE_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.NETHERITE_T, 1, -2.8F))));
    public static final DeferredItem<AxeItem> NETHERITE_TORRID_AXE = ITEMS.register("netherite_torrid_axe",
            () -> new AxeItem(ModToolTiers.NETHERITE_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.NETHERITE_T, 5.0F, -3.0F))));
    public static final DeferredItem<ShovelItem> NETHERITE_TORRID_SHOVEL = ITEMS.register("netherite_torrid_shovel",
            () -> new ShovelItem(ModToolTiers.NETHERITE_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.NETHERITE_T, 1.5F, -3.0F))));
    public static final DeferredItem<HoeItem> NETHERITE_TORRID_HOE = ITEMS.register("netherite_torrid_hoe",
            () -> new HoeItem(ModToolTiers.NETHERITE_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.NETHERITE_T, -4, 0.0F))));

    public static final DeferredItem<SwordItem> NETHERITE_EMBARIUM_SWORD = ITEMS.register("netherite_embarium_sword",
            () -> new SwordItem(ModToolTiers.NETHERITE_E, (new Item.Properties()).attributes(SwordItem.createAttributes(ModToolTiers.NETHERITE_E, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> NETHERITE_EMBARIUM_PICKAXE = ITEMS.register("netherite_embarium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.NETHERITE_E, (new Item.Properties()).attributes(PickaxeItem.createAttributes(ModToolTiers.NETHERITE_E, 1, -2.8F))));
    public static final DeferredItem<AxeItem> NETHERITE_EMBARIUM_AXE = ITEMS.register("netherite_embarium_axe",
            () -> new AxeItem(ModToolTiers.NETHERITE_E, (new Item.Properties()).attributes(AxeItem.createAttributes(ModToolTiers.NETHERITE_E, 5.0F, -3.0F))));
    public static final DeferredItem<ShovelItem> NETHERITE_EMBARIUM_SHOVEL = ITEMS.register("netherite_embarium_shovel",
            () -> new ShovelItem(ModToolTiers.NETHERITE_E, (new Item.Properties()).attributes(ShovelItem.createAttributes(ModToolTiers.NETHERITE_E, 1.5F, -3.0F))));
    public static final DeferredItem<HoeItem> NETHERITE_EMBARIUM_HOE = ITEMS.register("netherite_embarium_hoe",
            () -> new HoeItem(ModToolTiers.NETHERITE_E, (new Item.Properties()).attributes(HoeItem.createAttributes(ModToolTiers.NETHERITE_E, -4, 0.0F))));

    public static final DeferredItem<FireSwordItem> NETHERITE_TORRID_EMBARIUM_SWORD = ITEMS.register("netherite_torrid_embarium_sword",
            () -> new FireSwordItem(ModToolTiers.NETHERITE_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.NETHERITE_ET, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> NETHERITE_TORRID_EMBARIUM_PICKAXE = ITEMS.register("netherite_torrid_embarium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.NETHERITE_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.NETHERITE_ET, 1, -2.8F))));
    public static final DeferredItem<AxeItem> NETHERITE_TORRID_EMBARIUM_AXE = ITEMS.register("netherite_torrid_embarium_axe",
            () -> new AxeItem(ModToolTiers.NETHERITE_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.NETHERITE_ET, 5.0F, -3.0F))));
    public static final DeferredItem<ShovelItem> NETHERITE_TORRID_EMBARIUM_SHOVEL = ITEMS.register("netherite_torrid_embarium_shovel",
            () -> new ShovelItem(ModToolTiers.NETHERITE_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.NETHERITE_ET, 1.5F, -3.0F))));
    public static final DeferredItem<HoeItem> NETHERITE_TORRID_EMBARIUM_HOE = ITEMS.register("netherite_torrid_embarium_hoe",
            () -> new HoeItem(ModToolTiers.NETHERITE_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.NETHERITE_ET, -4, 0.0F))));

    //advanced profundium

    public static final DeferredItem<FireSwordItem> PROFUNDIUM_TORRID_SWORD = ITEMS.register("profundium_torrid_sword",
            () -> new FireSwordItem(ModToolTiers.PROFUNDIUM_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.PROFUNDIUM_T, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> PROFUNDIUM_TORRID_PICKAXE = ITEMS.register("profundium_torrid_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PROFUNDIUM_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.PROFUNDIUM_T, 1, -2.8F))));
    public static final DeferredItem<AxeItem> PROFUNDIUM_TORRID_AXE = ITEMS.register("profundium_torrid_axe",
            () -> new AxeItem(ModToolTiers.PROFUNDIUM_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.PROFUNDIUM_T, 5.0F, -3.0F))));
    public static final DeferredItem<ShovelItem> PROFUNDIUM_TORRID_SHOVEL = ITEMS.register("profundium_torrid_shovel",
            () -> new ShovelItem(ModToolTiers.PROFUNDIUM_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.PROFUNDIUM_T, 1.5F, -3.0F))));
    public static final DeferredItem<HoeItem> PROFUNDIUM_TORRID_HOE = ITEMS.register("profundium_torrid_hoe",
            () -> new HoeItem(ModToolTiers.PROFUNDIUM_T, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.PROFUNDIUM_T, -4, 0.0F))));

    public static final DeferredItem<SwordItem> PROFUNDIUM_EMBARIUM_SWORD = ITEMS.register("profundium_embarium_sword",
            () -> new SwordItem(ModToolTiers.PROFUNDIUM_E, (new Item.Properties()).attributes(SwordItem.createAttributes(ModToolTiers.PROFUNDIUM_E, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> PROFUNDIUM_EMBARIUM_PICKAXE = ITEMS.register("profundium_embarium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PROFUNDIUM_E, (new Item.Properties()).attributes(PickaxeItem.createAttributes(ModToolTiers.PROFUNDIUM_E, 1, -2.8F))));
    public static final DeferredItem<AxeItem> PROFUNDIUM_EMBARIUM_AXE = ITEMS.register("profundium_embarium_axe",
            () -> new AxeItem(ModToolTiers.PROFUNDIUM_E, (new Item.Properties()).attributes(AxeItem.createAttributes(ModToolTiers.PROFUNDIUM_E, 5.0F, -3.0F))));
    public static final DeferredItem<ShovelItem> PROFUNDIUM_EMBARIUM_SHOVEL = ITEMS.register("profundium_embarium_shovel",
            () -> new ShovelItem(ModToolTiers.PROFUNDIUM_E, (new Item.Properties()).attributes(ShovelItem.createAttributes(ModToolTiers.PROFUNDIUM_E, 1.5F, -3.0F))));
    public static final DeferredItem<HoeItem> PROFUNDIUM_EMBARIUM_HOE = ITEMS.register("profundium_embarium_hoe",
            () -> new HoeItem(ModToolTiers.PROFUNDIUM_E, (new Item.Properties()).attributes(HoeItem.createAttributes(ModToolTiers.PROFUNDIUM_E, -4, 0.0F))));

    public static final DeferredItem<FireSwordItem> PROFUNDIUM_TORRID_EMBARIUM_SWORD = ITEMS.register("profundium_torrid_embarium_sword",
            () -> new FireSwordItem(ModToolTiers.PROFUNDIUM_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.PROFUNDIUM_ET, 3, -2.4F))));
    public static final DeferredItem<PickaxeItem> PROFUNDIUM_TORRID_EMBARIUM_PICKAXE = ITEMS.register("profundium_torrid_embarium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PROFUNDIUM_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.PROFUNDIUM_ET, 1, -2.8F))));
    public static final DeferredItem<AxeItem> PROFUNDIUM_TORRID_EMBARIUM_AXE = ITEMS.register("profundium_torrid_embarium_axe",
            () -> new AxeItem(ModToolTiers.PROFUNDIUM_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.PROFUNDIUM_ET, 5.0F, -3.0F))));
    public static final DeferredItem<ShovelItem> PROFUNDIUM_TORRID_EMBARIUM_SHOVEL = ITEMS.register("profundium_torrid_embarium_shovel",
            () -> new ShovelItem(ModToolTiers.PROFUNDIUM_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.PROFUNDIUM_ET, 1.5F, -3.0F))));
    public static final DeferredItem<HoeItem> PROFUNDIUM_TORRID_EMBARIUM_HOE = ITEMS.register("profundium_torrid_embarium_hoe",
            () -> new HoeItem(ModToolTiers.PROFUNDIUM_ET, (new Item.Properties()).fireResistant().attributes(FireSwordItem.createAttributes(ModToolTiers.PROFUNDIUM_ET, -4, 0.0F))));

    //armor

    //elytra armors

    public static final DeferredItem<Item> ELYTRA_GLIDER = ITEMS.register("elytra_glider",
            () -> new ElytraGliderItem(new Item.Properties().durability(128)));

    public static final DeferredItem<Item> MECHANICAL_ELYTRA = ITEMS.register("mechanical_elytra",
            () -> new MechanicalElytraItem(new Item.Properties().stacksTo(1).fireResistant()));

    //embarium

    public static final DeferredItem<ArmorItem> EMBARIUM_HELMET = ITEMS.register("embarium_helmet",
            () -> new ArmorItem(ModArmorMaterials.EMBARIUM, ArmorItem.Type.HELMET, new Item.Properties().durability(11 * 33)));
    public static final DeferredItem<ArmorItem> EMBARIUM_CHESTPLATE = ITEMS.register("embarium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.EMBARIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(16 * 33)));
    public static final DeferredItem<ArmorItem> EMBARIUM_LEGGINGS = ITEMS.register("embarium_leggings",
            () -> new ArmorItem(ModArmorMaterials.EMBARIUM, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(15 * 33)));
    public static final DeferredItem<ArmorItem> EMBARIUM_BOOTS = ITEMS.register("embarium_boots",
            () -> new ArmorItem(ModArmorMaterials.EMBARIUM, ArmorItem.Type.BOOTS, new Item.Properties().durability(13 * 33)));

    public static final DeferredItem<ArmorItem> TORRID_HELMET = ITEMS.register("torrid_steel_helmet",
            () -> new ArmorItem(ModArmorMaterials.TORRID, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(11 * 15)));
    public static final DeferredItem<ArmorItem> TORRID_CHESTPLATE = ITEMS.register("torrid_steel_chestplate",
            () -> new FireArmorItem(ModArmorMaterials.TORRID, FireArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(16 * 15)));
    public static final DeferredItem<ArmorItem> TORRID_LEGGINGS = ITEMS.register("torrid_steel_leggings",
            () -> new ArmorItem(ModArmorMaterials.TORRID, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(15 * 15)));
    public static final DeferredItem<ArmorItem> TORRID_BOOTS = ITEMS.register("torrid_steel_boots",
            () -> new ArmorItem(ModArmorMaterials.TORRID, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(13 * 15)));

    public static final DeferredItem<ArmorItem> TORRID_EMBARIUM_HELMET = ITEMS.register("torrid_embarium_helmet",
            () -> new ArmorItem(ModArmorMaterials.TORRID_EMBARIUM, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(11 * 33)));
    public static final DeferredItem<ArmorItem> TORRID_EMBARIUM_CHESTPLATE = ITEMS.register("torrid_embarium_chestplate",
            () -> new FireArmorItem(ModArmorMaterials.TORRID_EMBARIUM, FireArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(16 * 33)));
    public static final DeferredItem<ArmorItem> TORRID_EMBARIUM_LEGGINGS = ITEMS.register("torrid_embarium_leggings",
            () -> new ArmorItem(ModArmorMaterials.TORRID_EMBARIUM, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(15 * 33)));
    public static final DeferredItem<ArmorItem> TORRID_EMBARIUM_BOOTS = ITEMS.register("torrid_embarium_boots",
            () -> new ArmorItem(ModArmorMaterials.TORRID_EMBARIUM, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(13 * 33)));

    public static final DeferredItem<ArmorItem> PROFUNDIUM_HELMET = ITEMS.register("profundium_helmet",
            () -> new WingArmorItem(ModArmorMaterials.PROFUNDIUM, WingArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(11 * 55)));
    public static final DeferredItem<ArmorItem> PROFUNDIUM_CHESTPLATE = ITEMS.register("profundium_chestplate",
            () -> new WingArmorItem(ModArmorMaterials.PROFUNDIUM, WingArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(16 * 55)));
    public static final DeferredItem<ArmorItem> PROFUNDIUM_LEGGINGS = ITEMS.register("profundium_leggings",
            () -> new WingArmorItem(ModArmorMaterials.PROFUNDIUM, WingArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(15 * 55)));
    public static final DeferredItem<ArmorItem> PROFUNDIUM_BOOTS = ITEMS.register("profundium_boots",
            () -> new WingArmorItem(ModArmorMaterials.PROFUNDIUM, WingArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(13 * 55)));

    // Leather

    public static final DeferredItem<ArmorItem> LEATHER_EMBARIUM_HELMET = ITEMS.register("leather_embarium_helmet",
            () -> new ArmorItem(ModArmorMaterials.LEATHER_E, ArmorItem.Type.HELMET, new Item.Properties().durability(11 * 33)));
    public static final DeferredItem<ArmorItem> LEATHER_EMBARIUM_CHESTPLATE = ITEMS.register("leather_embarium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.LEATHER_E, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(16 * 33)));
    public static final DeferredItem<ArmorItem> LEATHER_EMBARIUM_LEGGINGS = ITEMS.register("leather_embarium_leggings",
            () -> new ArmorItem(ModArmorMaterials.LEATHER_E, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(15 * 33)));
    public static final DeferredItem<ArmorItem> LEATHER_EMBARIUM_BOOTS = ITEMS.register("leather_embarium_boots",
            () -> new ArmorItem(ModArmorMaterials.LEATHER_E, ArmorItem.Type.BOOTS, new Item.Properties().durability(13 * 33)));

    public static final DeferredItem<ArmorItem> LEATHER_TORRID_HELMET = ITEMS.register("leather_torrid_helmet",
            () -> new ArmorItem(ModArmorMaterials.LEATHER_T, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(11 * 15)));
    public static final DeferredItem<ArmorItem> LEATHER_TORRID_CHESTPLATE = ITEMS.register("leather_torrid_chestplate",
            () -> new FireArmorItem(ModArmorMaterials.LEATHER_T, FireArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(16 * 15)));
    public static final DeferredItem<ArmorItem> LEATHER_TORRID_LEGGINGS = ITEMS.register("leather_torrid_leggings",
            () -> new ArmorItem(ModArmorMaterials.LEATHER_T, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(15 * 15)));
    public static final DeferredItem<ArmorItem> LEATHER_TORRID_BOOTS = ITEMS.register("leather_torrid_boots",
            () -> new ArmorItem(ModArmorMaterials.LEATHER_T, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(13 * 15)));

    public static final DeferredItem<ArmorItem> LEATHER_TORRID_EMBARIUM_HELMET = ITEMS.register("leather_torrid_embarium_helmet",
            () -> new ArmorItem(ModArmorMaterials.LEATHER_ET, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(11 * 33)));
    public static final DeferredItem<ArmorItem> LEATHER_TORRID_EMBARIUM_CHESTPLATE = ITEMS.register("leather_torrid_embarium_chestplate",
            () -> new FireArmorItem(ModArmorMaterials.LEATHER_ET, FireArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(16 * 33)));
    public static final DeferredItem<ArmorItem> LEATHER_TORRID_EMBARIUM_LEGGINGS = ITEMS.register("leather_torrid_embarium_leggings",
            () -> new ArmorItem(ModArmorMaterials.LEATHER_ET, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(15 * 33)));
    public static final DeferredItem<ArmorItem> LEATHER_TORRID_EMBARIUM_BOOTS = ITEMS.register("leather_torrid_embarium_boots",
            () -> new ArmorItem(ModArmorMaterials.LEATHER_ET, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(13 * 33)));

    // Chain

    public static final DeferredItem<ArmorItem> CHAIN_EMBARIUM_HELMET = ITEMS.register("chain_embarium_helmet",
            () -> new ArmorItem(ModArmorMaterials.CHAINMAIL_E, ArmorItem.Type.HELMET, new Item.Properties().durability(11 * 33)));
    public static final DeferredItem<ArmorItem> CHAIN_EMBARIUM_CHESTPLATE = ITEMS.register("chain_embarium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CHAINMAIL_E, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(16 * 33)));
    public static final DeferredItem<ArmorItem> CHAIN_EMBARIUM_LEGGINGS = ITEMS.register("chain_embarium_leggings",
            () -> new ArmorItem(ModArmorMaterials.CHAINMAIL_E, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(15 * 33)));
    public static final DeferredItem<ArmorItem> CHAIN_EMBARIUM_BOOTS = ITEMS.register("chain_embarium_boots",
            () -> new ArmorItem(ModArmorMaterials.CHAINMAIL_E, ArmorItem.Type.BOOTS, new Item.Properties().durability(13 * 33)));

    public static final DeferredItem<ArmorItem> CHAIN_TORRID_HELMET = ITEMS.register("chain_torrid_helmet",
            () -> new ArmorItem(ModArmorMaterials.CHAINMAIL_T, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(11 * 15)));
    public static final DeferredItem<ArmorItem> CHAIN_TORRID_CHESTPLATE = ITEMS.register("chain_torrid_chestplate",
            () -> new FireArmorItem(ModArmorMaterials.CHAINMAIL_T, FireArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(16 * 15)));
    public static final DeferredItem<ArmorItem> CHAIN_TORRID_LEGGINGS = ITEMS.register("chain_torrid_leggings",
            () -> new ArmorItem(ModArmorMaterials.CHAINMAIL_T, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(15 * 15)));
    public static final DeferredItem<ArmorItem> CHAIN_TORRID_BOOTS = ITEMS.register("chain_torrid_boots",
            () -> new ArmorItem(ModArmorMaterials.CHAINMAIL_T, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(13 * 15)));

    public static final DeferredItem<ArmorItem> CHAIN_TORRID_EMBARIUM_HELMET = ITEMS.register("chain_torrid_embarium_helmet",
            () -> new ArmorItem(ModArmorMaterials.CHAINMAIL_ET, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(11 * 33)));
    public static final DeferredItem<ArmorItem> CHAIN_TORRID_EMBARIUM_CHESTPLATE = ITEMS.register("chain_torrid_embarium_chestplate",
            () -> new FireArmorItem(ModArmorMaterials.CHAINMAIL_ET, FireArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(16 * 33)));
    public static final DeferredItem<ArmorItem> CHAIN_TORRID_EMBARIUM_LEGGINGS = ITEMS.register("chain_torrid_embarium_leggings",
            () -> new ArmorItem(ModArmorMaterials.CHAINMAIL_ET, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(15 * 33)));
    public static final DeferredItem<ArmorItem> CHAIN_TORRID_EMBARIUM_BOOTS = ITEMS.register("chain_torrid_embarium_boots",
            () -> new ArmorItem(ModArmorMaterials.CHAINMAIL_ET, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(13 * 33)));

    // gold 

    public static final DeferredItem<ArmorItem> GOLDEN_EMBARIUM_HELMET = ITEMS.register("golden_embarium_helmet",
            () -> new ArmorItem(ModArmorMaterials.GOLD_E, ArmorItem.Type.HELMET, new Item.Properties().durability(11 * 33)));
    public static final DeferredItem<ArmorItem> GOLDEN_EMBARIUM_CHESTPLATE = ITEMS.register("golden_embarium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.GOLD_E, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(16 * 33)));
    public static final DeferredItem<ArmorItem> GOLDEN_EMBARIUM_LEGGINGS = ITEMS.register("golden_embarium_leggings",
            () -> new ArmorItem(ModArmorMaterials.GOLD_E, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(15 * 33)));
    public static final DeferredItem<ArmorItem> GOLDEN_EMBARIUM_BOOTS = ITEMS.register("golden_embarium_boots",
            () -> new ArmorItem(ModArmorMaterials.GOLD_E, ArmorItem.Type.BOOTS, new Item.Properties().durability(13 * 33)));

    public static final DeferredItem<ArmorItem> GOLDEN_TORRID_HELMET = ITEMS.register("golden_torrid_helmet",
            () -> new ArmorItem(ModArmorMaterials.GOLD_T, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(11 * 15)));
    public static final DeferredItem<ArmorItem> GOLDEN_TORRID_CHESTPLATE = ITEMS.register("golden_torrid_chestplate",
            () -> new FireArmorItem(ModArmorMaterials.GOLD_T, FireArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(16 * 15)));
    public static final DeferredItem<ArmorItem> GOLDEN_TORRID_LEGGINGS = ITEMS.register("golden_torrid_leggings",
            () -> new ArmorItem(ModArmorMaterials.GOLD_T, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(15 * 15)));
    public static final DeferredItem<ArmorItem> GOLDEN_TORRID_BOOTS = ITEMS.register("golden_torrid_boots",
            () -> new ArmorItem(ModArmorMaterials.GOLD_T, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(13 * 15)));

    public static final DeferredItem<ArmorItem> GOLDEN_TORRID_EMBARIUM_HELMET = ITEMS.register("golden_torrid_embarium_helmet",
            () -> new ArmorItem(ModArmorMaterials.GOLD_ET, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(11 * 33)));
    public static final DeferredItem<ArmorItem> GOLDEN_TORRID_EMBARIUM_CHESTPLATE = ITEMS.register("golden_torrid_embarium_chestplate",
            () -> new FireArmorItem(ModArmorMaterials.GOLD_ET, FireArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(16 * 33)));
    public static final DeferredItem<ArmorItem> GOLDEN_TORRID_EMBARIUM_LEGGINGS = ITEMS.register("golden_torrid_embarium_leggings",
            () -> new ArmorItem(ModArmorMaterials.GOLD_ET, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(15 * 33)));
    public static final DeferredItem<ArmorItem> GOLDEN_TORRID_EMBARIUM_BOOTS = ITEMS.register("golden_torrid_embarium_boots",
            () -> new ArmorItem(ModArmorMaterials.GOLD_ET, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(13 * 33)));

    // iron 

    public static final DeferredItem<ArmorItem> IRON_EMBARIUM_HELMET = ITEMS.register("iron_embarium_helmet",
            () -> new ArmorItem(ModArmorMaterials.IRON_E, ArmorItem.Type.HELMET, new Item.Properties().durability(11 * 33)));
    public static final DeferredItem<ArmorItem> IRON_EMBARIUM_CHESTPLATE = ITEMS.register("iron_embarium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.IRON_E, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(16 * 33)));
    public static final DeferredItem<ArmorItem> IRON_EMBARIUM_LEGGINGS = ITEMS.register("iron_embarium_leggings",
            () -> new ArmorItem(ModArmorMaterials.IRON_E, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(15 * 33)));
    public static final DeferredItem<ArmorItem> IRON_EMBARIUM_BOOTS = ITEMS.register("iron_embarium_boots",
            () -> new ArmorItem(ModArmorMaterials.IRON_E, ArmorItem.Type.BOOTS, new Item.Properties().durability(13 * 33)));

    public static final DeferredItem<ArmorItem> IRON_TORRID_HELMET = ITEMS.register("iron_torrid_helmet",
            () -> new ArmorItem(ModArmorMaterials.IRON_T, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(11 * 15)));
    public static final DeferredItem<ArmorItem> IRON_TORRID_CHESTPLATE = ITEMS.register("iron_torrid_chestplate",
            () -> new FireArmorItem(ModArmorMaterials.IRON_T, FireArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(16 * 15)));
    public static final DeferredItem<ArmorItem> IRON_TORRID_LEGGINGS = ITEMS.register("iron_torrid_leggings",
            () -> new ArmorItem(ModArmorMaterials.IRON_T, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(15 * 15)));
    public static final DeferredItem<ArmorItem> IRON_TORRID_BOOTS = ITEMS.register("iron_torrid_boots",
            () -> new ArmorItem(ModArmorMaterials.IRON_T, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(13 * 15)));

    public static final DeferredItem<ArmorItem> IRON_TORRID_EMBARIUM_HELMET = ITEMS.register("iron_torrid_embarium_helmet",
            () -> new ArmorItem(ModArmorMaterials.IRON_ET, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(11 * 33)));
    public static final DeferredItem<ArmorItem> IRON_TORRID_EMBARIUM_CHESTPLATE = ITEMS.register("iron_torrid_embarium_chestplate",
            () -> new FireArmorItem(ModArmorMaterials.IRON_ET, FireArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(16 * 33)));
    public static final DeferredItem<ArmorItem> IRON_TORRID_EMBARIUM_LEGGINGS = ITEMS.register("iron_torrid_embarium_leggings",
            () -> new ArmorItem(ModArmorMaterials.IRON_ET, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(15 * 33)));
    public static final DeferredItem<ArmorItem> IRON_TORRID_EMBARIUM_BOOTS = ITEMS.register("iron_torrid_embarium_boots",
            () -> new ArmorItem(ModArmorMaterials.IRON_ET, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(13 * 33)));

    // dia 

    public static final DeferredItem<ArmorItem> DIAMOND_EMBARIUM_HELMET = ITEMS.register("diamond_embarium_helmet",
            () -> new ArmorItem(ModArmorMaterials.DIAMOND_E, ArmorItem.Type.HELMET, new Item.Properties().durability(11 * 33)));
    public static final DeferredItem<ArmorItem> DIAMOND_EMBARIUM_CHESTPLATE = ITEMS.register("diamond_embarium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.DIAMOND_E, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(16 * 33)));
    public static final DeferredItem<ArmorItem> DIAMOND_EMBARIUM_LEGGINGS = ITEMS.register("diamond_embarium_leggings",
            () -> new ArmorItem(ModArmorMaterials.DIAMOND_E, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(15 * 33)));
    public static final DeferredItem<ArmorItem> DIAMOND_EMBARIUM_BOOTS = ITEMS.register("diamond_embarium_boots",
            () -> new ArmorItem(ModArmorMaterials.DIAMOND_E, ArmorItem.Type.BOOTS, new Item.Properties().durability(13 * 33)));

    public static final DeferredItem<ArmorItem> DIAMOND_TORRID_HELMET = ITEMS.register("diamond_torrid_helmet",
            () -> new ArmorItem(ModArmorMaterials.DIAMOND_T, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(11 * 33)));
    public static final DeferredItem<ArmorItem> DIAMOND_TORRID_CHESTPLATE = ITEMS.register("diamond_torrid_chestplate",
            () -> new FireArmorItem(ModArmorMaterials.DIAMOND_T, FireArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(16 * 33)));
    public static final DeferredItem<ArmorItem> DIAMOND_TORRID_LEGGINGS = ITEMS.register("diamond_torrid_leggings",
            () -> new ArmorItem(ModArmorMaterials.DIAMOND_T, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(15 * 33)));
    public static final DeferredItem<ArmorItem> DIAMOND_TORRID_BOOTS = ITEMS.register("diamond_torrid_boots",
            () -> new ArmorItem(ModArmorMaterials.DIAMOND_T, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(13 * 33)));

    public static final DeferredItem<ArmorItem> DIAMOND_TORRID_EMBARIUM_HELMET = ITEMS.register("diamond_torrid_embarium_helmet",
            () -> new ArmorItem(ModArmorMaterials.DIAMOND_ET, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(11 * 33)));
    public static final DeferredItem<ArmorItem> DIAMOND_TORRID_EMBARIUM_CHESTPLATE = ITEMS.register("diamond_torrid_embarium_chestplate",
            () -> new FireArmorItem(ModArmorMaterials.DIAMOND_ET, FireArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(16 * 33)));
    public static final DeferredItem<ArmorItem> DIAMOND_TORRID_EMBARIUM_LEGGINGS = ITEMS.register("diamond_torrid_embarium_leggings",
            () -> new ArmorItem(ModArmorMaterials.DIAMOND_ET, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(15 * 33)));
    public static final DeferredItem<ArmorItem> DIAMOND_TORRID_EMBARIUM_BOOTS = ITEMS.register("diamond_torrid_embarium_boots",
            () -> new ArmorItem(ModArmorMaterials.DIAMOND_ET, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(13 * 33)));

    // netherite

    public static final DeferredItem<ArmorItem> NETHERITE_EMBARIUM_HELMET = ITEMS.register("netherite_embarium_helmet",
            () -> new ArmorItem(ModArmorMaterials.NETHERITE_E, ArmorItem.Type.HELMET, new Item.Properties().durability(11 * 37)));
    public static final DeferredItem<ArmorItem> NETHERITE_EMBARIUM_CHESTPLATE = ITEMS.register("netherite_embarium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.NETHERITE_E, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(16 * 37)));
    public static final DeferredItem<ArmorItem> NETHERITE_EMBARIUM_LEGGINGS = ITEMS.register("netherite_embarium_leggings",
            () -> new ArmorItem(ModArmorMaterials.NETHERITE_E, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(15 * 37)));
    public static final DeferredItem<ArmorItem> NETHERITE_EMBARIUM_BOOTS = ITEMS.register("netherite_embarium_boots",
            () -> new ArmorItem(ModArmorMaterials.NETHERITE_E, ArmorItem.Type.BOOTS, new Item.Properties().durability(13 * 37)));

    public static final DeferredItem<ArmorItem> NETHERITE_TORRID_HELMET = ITEMS.register("netherite_torrid_helmet",
            () -> new ArmorItem(ModArmorMaterials.NETHERITE_T, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(11 * 37)));
    public static final DeferredItem<ArmorItem> NETHERITE_TORRID_CHESTPLATE = ITEMS.register("netherite_torrid_chestplate",
            () -> new FireArmorItem(ModArmorMaterials.NETHERITE_T, FireArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(16 * 37)));
    public static final DeferredItem<ArmorItem> NETHERITE_TORRID_LEGGINGS = ITEMS.register("netherite_torrid_leggings",
            () -> new ArmorItem(ModArmorMaterials.NETHERITE_T, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(15 * 37)));
    public static final DeferredItem<ArmorItem> NETHERITE_TORRID_BOOTS = ITEMS.register("netherite_torrid_boots",
            () -> new ArmorItem(ModArmorMaterials.NETHERITE_T, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(13 * 37)));

    public static final DeferredItem<ArmorItem> NETHERITE_TORRID_EMBARIUM_HELMET = ITEMS.register("netherite_torrid_embarium_helmet",
            () -> new ArmorItem(ModArmorMaterials.NETHERITE_ET, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(11 * 37)));
    public static final DeferredItem<ArmorItem> NETHERITE_TORRID_EMBARIUM_CHESTPLATE = ITEMS.register("netherite_torrid_embarium_chestplate",
            () -> new FireArmorItem(ModArmorMaterials.NETHERITE_ET, FireArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(16 * 37)));
    public static final DeferredItem<ArmorItem> NETHERITE_TORRID_EMBARIUM_LEGGINGS = ITEMS.register("netherite_torrid_embarium_leggings",
            () -> new ArmorItem(ModArmorMaterials.NETHERITE_ET, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(15 * 37)));
    public static final DeferredItem<ArmorItem> NETHERITE_TORRID_EMBARIUM_BOOTS = ITEMS.register("netherite_torrid_embarium_boots",
            () -> new ArmorItem(ModArmorMaterials.NETHERITE_ET, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(13 * 37)));

    // profundium

    public static final DeferredItem<ArmorItem> PROFUNDIUM_EMBARIUM_HELMET = ITEMS.register("profundium_embarium_helmet",
            () -> new WingArmorItem(ModArmorMaterials.PROFUNDIUM_E, WingArmorItem.Type.HELMET, new Item.Properties().durability(11 * 55)));
    public static final DeferredItem<ArmorItem> PROFUNDIUM_EMBARIUM_CHESTPLATE = ITEMS.register("profundium_embarium_chestplate",
            () -> new WingArmorItem(ModArmorMaterials.PROFUNDIUM_E, WingArmorItem.Type.CHESTPLATE, new Item.Properties().durability(16 * 55)));
    public static final DeferredItem<ArmorItem> PROFUNDIUM_EMBARIUM_LEGGINGS = ITEMS.register("profundium_embarium_leggings",
            () -> new WingArmorItem(ModArmorMaterials.PROFUNDIUM_E, WingArmorItem.Type.LEGGINGS, new Item.Properties().durability(15 * 55)));
    public static final DeferredItem<ArmorItem> PROFUNDIUM_EMBARIUM_BOOTS = ITEMS.register("profundium_embarium_boots",
            () -> new WingArmorItem(ModArmorMaterials.PROFUNDIUM_E, WingArmorItem.Type.BOOTS, new Item.Properties().durability(13 * 55)));

    public static final DeferredItem<ArmorItem> PROFUNDIUM_TORRID_HELMET = ITEMS.register("profundium_torrid_helmet",
            () -> new WingArmorItem(ModArmorMaterials.PROFUNDIUM_T, WingArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(11 * 55)));
    public static final DeferredItem<ArmorItem> PROFUNDIUM_TORRID_CHESTPLATE = ITEMS.register("profundium_torrid_chestplate",
            () -> new FireWingArmorItem(ModArmorMaterials.PROFUNDIUM_T, FireWingArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(16 * 55)));
    public static final DeferredItem<ArmorItem> PROFUNDIUM_TORRID_LEGGINGS = ITEMS.register("profundium_torrid_leggings",
            () -> new WingArmorItem(ModArmorMaterials.PROFUNDIUM_T, WingArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(15 * 55)));
    public static final DeferredItem<ArmorItem> PROFUNDIUM_TORRID_BOOTS = ITEMS.register("profundium_torrid_boots",
            () -> new WingArmorItem(ModArmorMaterials.PROFUNDIUM_T, WingArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(13 * 55)));

    public static final DeferredItem<ArmorItem> PROFUNDIUM_TORRID_EMBARIUM_HELMET = ITEMS.register("profundium_torrid_embarium_helmet",
            () -> new WingArmorItem(ModArmorMaterials.PROFUNDIUM_ET, WingArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(11 * 55)));
    public static final DeferredItem<ArmorItem> PROFUNDIUM_TORRID_EMBARIUM_CHESTPLATE = ITEMS.register("profundium_torrid_embarium_chestplate",
            () -> new FireWingArmorItem(ModArmorMaterials.PROFUNDIUM_ET, FireWingArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(16 * 55)));
    public static final DeferredItem<ArmorItem> PROFUNDIUM_TORRID_EMBARIUM_LEGGINGS = ITEMS.register("profundium_torrid_embarium_leggings",
            () -> new WingArmorItem(ModArmorMaterials.PROFUNDIUM_ET, WingArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(15 * 55)));
    public static final DeferredItem<ArmorItem> PROFUNDIUM_TORRID_EMBARIUM_BOOTS = ITEMS.register("profundium_torrid_embarium_boots",
            () -> new WingArmorItem(ModArmorMaterials.PROFUNDIUM_ET, WingArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(13 * 55)));

    //Block Items

        //stations

//    public static final DeferredItem<Item> GEM_INFUSER_ITEM = ITEMS.register("gem_infuser",
//            () -> new GemInfuserItem(ModBlocks.GEM_INFUSER.get(), new Item.Properties()));

        //wood

    public static final DeferredItem<Item> EBONY_SIGN = ITEMS.register("ebony_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.EBONY_SIGN.get(), ModBlocks.EBONY_WALL_SIGN.get()));
    public static final DeferredItem<Item> EBONY_HANGING_SIGN = ITEMS.register("ebony_hanging_sign",
            () -> new HangingSignItem(ModBlocks.EBONY_HANGING_SIGN.get(), ModBlocks.EBONY_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
