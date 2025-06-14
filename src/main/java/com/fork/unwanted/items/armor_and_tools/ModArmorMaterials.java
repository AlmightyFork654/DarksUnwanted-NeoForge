package com.fork.unwanted.items.armor_and_tools;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.items.ModItems;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class  ModArmorMaterials {

    public static final Holder<ArmorMaterial> EMBARIUM = register("embarium",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 1);
                attribute.put(ArmorItem.Type.LEGGINGS, 4);
                attribute.put(ArmorItem.Type.CHESTPLATE, 5);
                attribute.put(ArmorItem.Type.HELMET, 2);
                attribute.put(ArmorItem.Type.BODY, 7);
            }), 25, 0f, 0.2f, () -> ModItems.EMBARIUM.get(), SoundEvents.ARMOR_EQUIP_DIAMOND);
    public static final Holder<ArmorMaterial> TORRID = register("torrid_steel",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 2);
                attribute.put(ArmorItem.Type.LEGGINGS, 5);
                attribute.put(ArmorItem.Type.CHESTPLATE, 6);
                attribute.put(ArmorItem.Type.HELMET, 2);
                attribute.put(ArmorItem.Type.BODY, 7);
            }), 9, 0.5f, 0f, () -> ModItems.TORRID_STEEL_INGOT.get(), SoundEvents.ARMOR_EQUIP_IRON);
    public static final Holder<ArmorMaterial> TORRID_EMBARIUM = register("torrid_embarium",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 2);
                attribute.put(ArmorItem.Type.LEGGINGS, 5);
                attribute.put(ArmorItem.Type.CHESTPLATE, 6);
                attribute.put(ArmorItem.Type.HELMET, 3);
                attribute.put(ArmorItem.Type.BODY, 7);
            }), 25, 0.5f, 0.2f, () -> ModItems.EMBARIUM.get(), SoundEvents.ARMOR_EQUIP_DIAMOND); //tag so both mats can repair?
    public static final Holder<ArmorMaterial> PROFUNDIUM = register("profundium",
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 4);
                attribute.put(ArmorItem.Type.LEGGINGS, 7);
                attribute.put(ArmorItem.Type.CHESTPLATE, 9);
                attribute.put(ArmorItem.Type.HELMET, 4);
                attribute.put(ArmorItem.Type.BODY, 13);
            }), 30, 4f, 0.2f, () -> ModItems.PROFUNDIUM_INGOT.get(), SoundEvents.ARMOR_EQUIP_NETHERITE);


    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection,
                                                  int enchantability, float toughness, float knockbackResistance,
                                                  Supplier<Item> ingredientItem, Holder<SoundEvent> sound) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID, name);
        Holder<SoundEvent> equipSound = sound;
        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));

        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            typeMap.put(type, typeProtection.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location,
                new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, toughness, knockbackResistance));
    }

}

//    EMBARIUM("embarium", 33, new int[]{1, 4, 5, 2}, 25, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.2F, () -> {
//        return Ingredient.of(ModItems.EMBARIUM.get());
//    }),
//    TORRID("torrid_steel", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_IRON, 0.5F, 0.0F, () -> {
//        return Ingredient.of(ModItems.TORRID_STEEL_INGOT.get());
//    }),
//    TORRID_EMBARIUM("torrid_embarium", 33, new int[]{2, 5, 6, 3}, 25, SoundEvents.ARMOR_EQUIP_IRON, 0.5F, 0.2F, () -> {
//        return Ingredient.of(ModItems.EMBARIUM.get());
//    }),
//    PROFUNDIUM("profundium", 40, new int[]{4, 7, 9, 4}, 30, SoundEvents.ARMOR_EQUIP_NETHERITE, 4F, 0.2F, () -> {
//        return Ingredient.of(ModItems.EMBARIUM.get());
//    });

