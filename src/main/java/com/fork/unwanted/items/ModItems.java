package com.fork.unwanted.items;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.items.armor_and_tools.*;
import com.fork.unwanted.items.custom.PureBlazePowderItem;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(Unwanted.MOD_ID);

    //Items

        //Misc

    public static final DeferredItem<Item> PURE_BLAZE_POWDER = ITEMS.register("pure_blaze_powder",
            () -> new PureBlazePowderItem(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> BLAZING_WATER = ITEMS.register("blazing_water",
        () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));

//    public static final DeferredItem<Item> EBONY_BOAT = ITEMS.register("ebony_boat",
//            () -> new ModBoatItem(false, ModBoatEntity.Type.EBONY, new Item.Properties()));
//    public static final DeferredItem<Item> EBONY_CHEST_BOAT = ITEMS.register("ebony_chest_boat",
//            () -> new ModBoatItem(true, ModBoatEntity.Type.EBONY, new Item.Properties()));

    public static final DeferredItem<Item> WOODEN_SPEAR_HEAD = ITEMS.register("wooden_spear_head",
            ()-> new Item(new Item.Properties()));

//    public static final DeferredItem<Item> TEA_CUP = ITEMS.register("tea_cup",
//            ()-> new TeaCup(new Item.Properties()));

    public static final DeferredItem<Item> CUP_OF_WATER = ITEMS.register("cup_of_water",
            ()-> new Item(new Item.Properties()));

//    public static final DeferredItem<Item> GRASSY_TEA = ITEMS.register("grassy_tea",
//            ()-> new ComplexTeaItem(new Item.Properties()));
//    public static final DeferredItem<Item> WARPED_TEA = ITEMS.register("warped_tea",
//            ()-> new ComplexTeaItem(new Item.Properties()));
//    public static final DeferredItem<Item> CRIMSON_TEA = ITEMS.register("crimson_tea",
//            ()-> new ComplexTeaItem(new Item.Properties()));
//    public static final DeferredItem<Item> LEAVY_TEA = ITEMS.register("leavy_tea",
//            ()-> new ComplexTeaItem(new Item.Properties()));
//    public static final DeferredItem<Item> KELPED_TEA = ITEMS.register("kelped_tea",
//            ()-> new ComplexTeaItem(new Item.Properties()));
//    public static final DeferredItem<Item> VINEY_TEA = ITEMS.register("viney_tea",
//            ()-> new ComplexTeaItem(new Item.Properties()));
//    public static final DeferredItem<Item> GLOWY_TEA = ITEMS.register("glowy_tea",
//            ()-> new ComplexTeaItem(new Item.Properties()));
//    public static final DeferredItem<Item> SCULKED_TEA = ITEMS.register("sculked_tea",
//            ()-> new ComplexTeaItem(new Item.Properties()));
//    public static final DeferredItem<Item> ROOTED_TEA = ITEMS.register("rooted_tea",
//            ()-> new ComplexTeaItem(new Item.Properties()));

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

//    public static final DeferredItem<Item> DARKNESS_MUSIC_DISK = ITEMS.register("darkness_music_disc",
//            () -> new ModDiskItem(15, ModSounds.DARKNESS, 69));
//
//    public static final DeferredItem<Item> CAVE_WHISPERS_MUSIC_DISK = ITEMS.register("cave_whispers_music_disc",
//            () -> new ModDiskItem(15, ModSounds.CAVE_WHISPERS, 132));

        // tools

    public static final DeferredItem<Item>  CHISEL = ITEMS.register("chisel",
            () -> new Item(new Item.Properties().stacksTo(1).durability(256)));

    public static final DeferredItem<Item> NETHERITE_CHISEL = ITEMS.register("netherite_chisel",
            () -> new Item(new Item.Properties().fireResistant().stacksTo(1).durability(1024)));

//    public static final DeferredItem<Item> WOODEN_SPEAR = ITEMS.register("wooden_spear",
//            () -> new WoodenSpearItem(new Item.Properties().durability(32), 3.0D, -1F));
//
//    public static final DeferredItem<Item> IRON_SPEAR = ITEMS.register("iron_spear",
//            () -> new IronSpearItem(new Item.Properties().durability(64), 5.0D, -1F));
    
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
    public static final DeferredItem<Item> PROFUNDIUM_SWORD = ITEMS.register("profundium_sword",
            () -> new SwordItem(ModToolTiers.PROFUNDIUM, (new Item.Properties()).fireResistant().attributes(SwordItem.createAttributes(ModToolTiers.PROFUNDIUM, 4, -1.4F))));
    public static final DeferredItem<PickaxeItem> PROFUNDIUM_PICKAXE = ITEMS.register("profundium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PROFUNDIUM, (new Item.Properties()).fireResistant().attributes(PickaxeItem.createAttributes(ModToolTiers.PROFUNDIUM, 2, -2.4F))));
    public static final DeferredItem<AxeItem> PROFUNDIUM_AXE = ITEMS.register("profundium_axe",
            () -> new AxeItem(ModToolTiers.PROFUNDIUM, (new Item.Properties()).fireResistant().attributes(AxeItem.createAttributes(ModToolTiers.PROFUNDIUM, 6.0F, -2.0F))));
    public static final DeferredItem<ShovelItem> PROFUNDIUM_SHOVEL = ITEMS.register("profundium_shovel",
            () -> new ShovelItem(ModToolTiers.PROFUNDIUM, (new Item.Properties()).fireResistant().attributes(ShovelItem.createAttributes(ModToolTiers.PROFUNDIUM, 2.5F, -2.0F))));
    public static final DeferredItem<HoeItem> PROFUNDIUM_HOE = ITEMS.register("profundium_hoe",
            () -> new HoeItem(ModToolTiers.PROFUNDIUM, (new Item.Properties()).fireResistant().attributes(HoeItem.createAttributes(ModToolTiers.PROFUNDIUM, -3, -1.0F))));

    // advanced wood&leather
//
//    //advanced stone&chainmail
//
//    //advanced iron
//
//    //advanced gold
//
//    //advanced diamond
//
//    //advanced netherite
//
//    //advanced profundium
//    // Torrid, Embarium, Profundium...
//
//    //armor
//
//    //elytra armors
//
//    public static final DeferredItem<Item> ELYTRA_GLIDER = ITEMS.register("elytra_glider",
//            () -> new ElytraGliderItem(new Item.Properties().durability(128)));
//
//    public static final DeferredItem<Item> MECHANICAL_ELYTRA = ITEMS.register("mechanical_elytra",
//            () -> new MechanicalElytraItem(new Item.Properties().stacksTo(1)));
//
    //embarium

    public static final DeferredItem<Item> EMBARIUM_HELMET = ITEMS.register("embarium_helmet",
            () -> new ArmorItem(ModArmorMaterials.EMBARIUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<Item> EMBARIUM_CHESTPLATE = ITEMS.register("embarium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.EMBARIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> EMBARIUM_LEGGINGS = ITEMS.register("embarium_leggings",
            () -> new ArmorItem(ModArmorMaterials.EMBARIUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<Item> EMBARIUM_BOOTS = ITEMS.register("embarium_boots",
            () -> new ArmorItem(ModArmorMaterials.EMBARIUM, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<Item> TORRID_HELMET = ITEMS.register("torrid_steel_helmet",
            () -> new ArmorItem(ModArmorMaterials.TORRID, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> TORRID_CHESTPLATE = ITEMS.register("torrid_steel_chestplate",
            () -> new FireArmorItem(ModArmorMaterials.TORRID, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> TORRID_LEGGINGS = ITEMS.register("torrid_steel_leggings",
            () -> new ArmorItem(ModArmorMaterials.TORRID, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> TORRID_BOOTS = ITEMS.register("torrid_steel_boots",
            () -> new ArmorItem(ModArmorMaterials.TORRID, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> TORRID_EMBARIUM_HELMET = ITEMS.register("torrid_embarium_helmet",
            () -> new ArmorItem(ModArmorMaterials.TORRID_EMBARIUM, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> TORRID_EMBARIUM_CHESTPLATE = ITEMS.register("torrid_embarium_chestplate",
            () -> new NoDamageFireArmorItem(ModArmorMaterials.TORRID_EMBARIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> TORRID_EMBARIUM_LEGGINGS = ITEMS.register("torrid_embarium_leggings",
            () -> new ArmorItem(ModArmorMaterials.TORRID_EMBARIUM, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> TORRID_EMBARIUM_BOOTS = ITEMS.register("torrid_embarium_boots",
            () -> new ArmorItem(ModArmorMaterials.TORRID_EMBARIUM, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> PROFUNDIUM_HELMET = ITEMS.register("profundium_helmet",
            () -> new WingArmorItem(ModArmorMaterials.PROFUNDIUM, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> PROFUNDIUM_CHESTPLATE = ITEMS.register("profundium_chestplate",
            () -> new WingArmorItem(ModArmorMaterials.PROFUNDIUM, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> PROFUNDIUM_LEGGINGS = ITEMS.register("profundium_leggings",
            () -> new WingArmorItem(ModArmorMaterials.PROFUNDIUM, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> PROFUNDIUM_BOOTS = ITEMS.register("profundium_boots",
            () -> new WingArmorItem(ModArmorMaterials.PROFUNDIUM, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    //Block Items

        //stations

//    public static final DeferredItem<Item> GEM_INFUSER_ITEM = ITEMS.register("gem_infuser",
//            () -> new GemInfuserItem(ModBlocks.GEM_INFUSER.get(), new Item.Properties()));

        //wood

//    public static final DeferredItem<Item> EBONY_SIGN = ITEMS.register("ebony_sign",
//            () -> new SignItem(new Item.Properties().stacksTo(16), ModBlocks.EBONY_SIGN.get(), ModBlocks.EBONY_WALL_SIGN.get()));
//    public static final DeferredItem<Item> EBONY_HANGING_SIGN = ITEMS.register("ebony_hanging_sign",
//            () -> new HangingSignItem(ModBlocks.EBONY_HANGING_SIGN.get(), ModBlocks.EBONY_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
