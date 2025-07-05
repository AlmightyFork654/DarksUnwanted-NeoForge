package com.fork.unwanted.items.spear;


import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow.Pickup;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

import java.util.List;

public class SpearItem extends Item implements ProjectileItem {
    public final float damageVal;
    public final int useDur;
    public final Item repairItem;
    public final EntityType entityType;

    public SpearItem(Item.Properties properties, float damageVal, int UseDur, Item item, EntityType type) {
        super(properties);
        this.damageVal = damageVal;
        this.useDur = UseDur * 20;
        this.repairItem = item;
        this.entityType = type;
    }

//    public static ItemAttributeModifiers createAttributes() {
//        return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 8.0, Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -2.9000000953674316, Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
//    }
//
//    public static Tool createToolProperties() {
//        return new Tool(List.of(), 1.0F, 2);
//    }

    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        return !player.isCreative();
    }

    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.SPEAR;
    }

    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return this.useDur;
    }

    public void releaseUsing (ItemStack stack, Level level, LivingEntity entity, int p_43397_) {
        if (entity instanceof Player player) {
            int i = this.getUseDuration(stack, entity) - p_43397_;
            if (i >= 10) {
                stack.setDamageValue(stack.getDamageValue() + 1);
                ThrownSpear thrownSpear = new ThrownSpear(level, player, stack, damageVal, entityType);
                thrownSpear.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F + (float) 0 * 0.5F, 1.0F);
                if (player.getAbilities().instabuild) {
                    thrownSpear.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                }

                level.addFreshEntity(thrownSpear);
                level.playLocalSound(thrownSpear, SoundEvents.TRIDENT_THROW.value(), SoundSource.PLAYERS, 1f, 1f);
                if (!player.getAbilities().instabuild) {
                    player.getInventory().removeItem(stack);
                }
            }
        }
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (isTooDamagedToUse(itemstack)) {
            return InteractionResultHolder.fail(itemstack);
        } else {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(itemstack);
        }
    }

    private static boolean isTooDamagedToUse(ItemStack stack) {
        return stack.getDamageValue() >= stack.getMaxDamage() - 1;
    }



    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return true;
    }

    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }

    public int getEnchantmentValue() {
        return 1;
    }

    public Projectile asProjectile(Level level, Position pos, ItemStack stack, Direction direction) {
        ThrownSpear thrownSpear = new ThrownSpear(level, pos.x(), pos.y(), pos.z(), stack.copyWithCount(1), this.entityType);
        thrownSpear.pickup = Pickup.ALLOWED;
        return thrownSpear;
    }

    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return ItemAbilities.DEFAULT_TRIDENT_ACTIONS.contains(itemAbility);
    }

    @Override
    public boolean isValidRepairItem(ItemStack stack, ItemStack repairCandidate) {
        return repairCandidate.is(this.repairItem);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        tooltipComponents.add(Component.literal(this.damageVal + " Attack Damage").withStyle(ChatFormatting.DARK_GREEN));
        tooltipComponents.add(Component.literal((this.useDur / 20) + " Attack Speed").withStyle(ChatFormatting.DARK_GREEN));
    }
}
