package com.fork.unwanted.items.armor_and_tools;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class FireArmorItem extends ArmorItem {
    private static final Map<Holder<ArmorMaterial>, List<MobEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<Holder<ArmorMaterial>, List<MobEffectInstance>>())
                    .put(ModArmorMaterials.TORRID, List.of(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 25, 0, false, false)))
                    .put(ModArmorMaterials.TORRID_EMBARIUM, List.of(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 25, 0, false, false)))
                    .put(ModArmorMaterials.LEATHER_T, List.of(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 25, 0, false, false)))
                    .put(ModArmorMaterials.LEATHER_ET, List.of(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 25, 0, false, false)))
                    .put(ModArmorMaterials.CHAINMAIL_T, List.of(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 25, 0, false, false)))
                    .put(ModArmorMaterials.CHAINMAIL_ET, List.of(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 25, 0, false, false)))
                    .put(ModArmorMaterials.GOLD_T, List.of(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 25, 0, false, false)))
                    .put(ModArmorMaterials.GOLD_ET, List.of(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 25, 0, false, false)))
                    .put(ModArmorMaterials.IRON_T, List.of(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 25, 0, false, false)))
                    .put(ModArmorMaterials.IRON_ET, List.of(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 25, 0, false, false)))
                    .put(ModArmorMaterials.DIAMOND_T, List.of(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 25, 0, false, false)))
                    .put(ModArmorMaterials.DIAMOND_ET, List.of(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 25, 0, false, false)))
                    .put(ModArmorMaterials.NETHERITE_T, List.of(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 25, 0, false, false)))
                    .put(ModArmorMaterials.NETHERITE_ET, List.of(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 25, 0, false, false)))
                    .put(ModArmorMaterials.PROFUNDIUM_ET, List.of(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 25, 0, false, false)))
                    .put(ModArmorMaterials.PROFUNDIUM_T, List.of(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 25, 0, false, false)))
                    .build();

    public FireArmorItem(Holder<ArmorMaterial> material, ArmorItem.Type slot, Item.Properties settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(entity instanceof Player player && !level.isClientSide() && hasFullSuitOfArmorOn(player)) {
            evaluateArmorEffects(player);
        }
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<Holder<ArmorMaterial>, List<MobEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            Holder<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<MobEffectInstance> mapStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectToPlayer(player, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectToPlayer(Player player, List<MobEffectInstance> mapStatusEffect) {
        boolean hasPlayerEffect = mapStatusEffect.stream().allMatch((effect -> player.hasEffect(effect.getEffect())));

        if(!hasPlayerEffect) {
            for(MobEffectInstance effect : mapStatusEffect) {
                player.addEffect(new MobEffectInstance(effect.getEffect(),
                        effect.getDuration(), effect.getAmplifier(), effect.isAmbient(), effect.isVisible()));
            }
        }
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack breastplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(Holder<ArmorMaterial> material, Player player) {
        for (ItemStack armorStack: player.getInventory().armor) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}
