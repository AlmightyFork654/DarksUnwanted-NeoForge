package com.fork.unwanted.items.food;

import com.fork.unwanted.component.ModDataComponents;
import com.fork.unwanted.items.ModItems;
import com.fork.unwanted.mob_effects.ModEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.feature.EndPlatformFeature;
import net.minecraft.world.level.portal.DimensionTransition;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class TeaItem extends Item {
    private static final int DRINK_DURATION = 32;
    private static final int COOLDOWN_TICKS = 300; // 15 seconds * 20 ticks/second

    public TeaItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        super.finishUsingItem(stack, world, entity);

        Player player = entity instanceof Player ? (Player) entity : null;
        if (entity instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, stack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (!world.isClientSide) {
            // Remove specified effects
            List<MobEffectInstance> effectsToRemove = getEffectsToRemove(stack);
            for (MobEffectInstance effectInstance : effectsToRemove) {
                if (entity.hasEffect(effectInstance.getEffect())) {
                    entity.removeEffect(effectInstance.getEffect());
                }
            }

            // Add specified effects
            List<MobEffectInstance> effectsToAdd = getEffectsToAdd(stack);
            for (MobEffectInstance effectInstance : effectsToAdd) {
                entity.addEffect(new MobEffectInstance(effectInstance));
            }

            tryTeleport(stack, entity);
        }

        if (player == null || !player.getAbilities().instabuild) {
            if (stack.isEmpty()) {
                stack.shrink(1);
                return new ItemStack(ModItems.TEA_CUP.get());
            }

            if (player != null) {
                stack.shrink(1);
                player.getInventory().add(new ItemStack(ModItems.TEA_CUP.get()));
            }
        }

        entity.gameEvent(GameEvent.DRINK);
        return stack;
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        List<String> modifiers = stack.getOrDefault(ModDataComponents.TEA_MODIFIER.get(), List.of());
        if (modifiers.contains("gunpowder")) {
            return DRINK_DURATION / 2;
        }
        return DRINK_DURATION;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        String teleport = stack.getOrDefault(ModDataComponents.TEA_TELEPORT.get(), "");
        if (!teleport.isEmpty() && player.getCooldowns().isOnCooldown(this)) {
            return InteractionResultHolder.fail(stack);
        }
        return ItemUtils.startUsingInstantly(world, player, hand);
    }

    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        String teaType = stack.getOrDefault(ModDataComponents.TEA_TYPE.get(), "");
        List<String> additions = stack.getOrDefault(ModDataComponents.TEA_ADDITION.get(), List.of());
        List<String> modifiers = stack.getOrDefault(ModDataComponents.TEA_MODIFIER.get(), List.of());
        String teleport = stack.getOrDefault(ModDataComponents.TEA_TELEPORT.get(), "");

        tooltip.add(Component.literal("§cRemoved effects:"));
        List<MobEffectInstance> effectsToRemove = getEffectsToRemove(stack);
        for (MobEffectInstance effectInstance : effectsToRemove) {
            MutableComponent component = Component.translatable(effectInstance.getDescriptionId());
            if (isBeneficial(effectInstance.getEffect())) {
                component.withStyle(ChatFormatting.GREEN);
            } else if (isHarmful(effectInstance.getEffect())) {
                component.withStyle(ChatFormatting.RED);
            } else {
                component.withStyle(ChatFormatting.GRAY);
            }
            tooltip.add(component);
        }
        tooltip.add(Component.literal(""));
        tooltip.add(Component.literal("§9Added effects:"));
        List<MobEffectInstance> effectsToAdd = getEffectsToAdd(stack);
        for (MobEffectInstance effect : effectsToAdd) {
            MutableComponent component = Component.translatable(effect.getDescriptionId());
            if (effect.getAmplifier() > 0) {
                component = Component.translatable("potion.withAmplifier", component, Component.translatable("potion.potency." + effect.getAmplifier()));
            }
            if (effect.getDuration() > 20) {
                component = Component.translatable("potion.withDuration", component, effect.getDuration() / 20 + "s");
            }
            if (isBeneficial(effect.getEffect())) {
                component.withStyle(ChatFormatting.GREEN);
            } else if (isHarmful(effect.getEffect())) {
                component.withStyle(ChatFormatting.RED);
            } else {
                component.withStyle(ChatFormatting.GRAY);
            }
            tooltip.add(component);
        }

        tooltip.add(Component.literal(""));
        if (!teleport.isEmpty()) {
            tooltip.add(Component.literal("§bTeleports to: " + teleport));
            tooltip.add(Component.literal(""));
        }

        tooltip.add(Component.literal("§aMods:"));
        int redCount = 0;
        int glowCount = 0;
        for (String mod : modifiers) {
            if (mod.equals("redstone")) {
                redCount++;
            } else if (mod.equals("glowstone")) {
                glowCount++;
            }
        }
        if (redCount > 0) {
            tooltip.add(Component.literal("§aRedstone " + redCount + "x"));
        }
        if (glowCount > 0) {
            tooltip.add(Component.literal("§aGlowstone Dust " + glowCount + "x"));
        }
        if (modifiers.contains("gunpowder")) {
            tooltip.add(Component.literal("§aGunpowder"));
        }
    }

    private boolean isBeneficial(Holder<MobEffect> effect) {
        return effect == MobEffects.REGENERATION ||
                effect == MobEffects.ABSORPTION ||
                effect == MobEffects.DAMAGE_RESISTANCE ||
                effect == MobEffects.FIRE_RESISTANCE ||
                effect == MobEffects.MOVEMENT_SPEED ||
                effect == MobEffects.JUMP ||
                effect == MobEffects.INVISIBILITY ||
                effect == MobEffects.DAMAGE_BOOST ||
                effect == MobEffects.DIG_SPEED ||
                effect == MobEffects.HERO_OF_THE_VILLAGE ||
                effect == MobEffects.SATURATION ||
                effect == MobEffects.WATER_BREATHING ||
                effect == MobEffects.DOLPHINS_GRACE ||
                effect == MobEffects.CONDUIT_POWER ||
                effect == MobEffects.HEALTH_BOOST ||
                effect == MobEffects.HEAL ||
                effect == MobEffects.NIGHT_VISION ||
                effect == MobEffects.SLOW_FALLING;
    }

    private boolean isHarmful(Holder<MobEffect> effect) {
        return effect == MobEffects.POISON ||
                effect == MobEffects.WEAKNESS ||
                effect == MobEffects.CONFUSION ||
                effect == MobEffects.DIG_SLOWDOWN ||
                effect == MobEffects.MOVEMENT_SLOWDOWN ||
                effect == MobEffects.GLOWING ||
                effect == MobEffects.DARKNESS ||
                effect == MobEffects.BLINDNESS ||
                effect == MobEffects.HUNGER ||
                effect == MobEffects.BAD_OMEN ||
                effect == MobEffects.LEVITATION ||
                effect == MobEffects.WITHER ||
                effect == ModEffects.FRAGILE;
    }

    private List<MobEffectInstance> getEffectsToRemove(ItemStack stack) {
        List<MobEffectInstance> effects = new ArrayList<>();
        String teaType = stack.getOrDefault(ModDataComponents.TEA_TYPE.get(), "");

        switch (teaType) {
            case "grassy":
                effects.add(new MobEffectInstance(MobEffects.POISON));
                break;
            case "warped":
                effects.add(new MobEffectInstance(ModEffects.FRAGILE));
                break;
            case "crimson":
                effects.add(new MobEffectInstance(MobEffects.WEAKNESS));
                break;
            case "leavy":
                effects.add(new MobEffectInstance(MobEffects.CONFUSION));
                break;
            case "kelped":
                effects.add(new MobEffectInstance(MobEffects.DIG_SLOWDOWN));
                break;
            case "viney":
                effects.add(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN));
                break;
            case "glowy":
                effects.add(new MobEffectInstance(MobEffects.GLOWING));
                break;
            case "sculked":
                effects.add(new MobEffectInstance(MobEffects.DARKNESS));
                effects.add(new MobEffectInstance(MobEffects.BLINDNESS));
                break;
            case "rooted":
                effects.add(new MobEffectInstance(MobEffects.HUNGER));
                break;
        }

        List<String> additives = stack.getOrDefault(ModDataComponents.TEA_ADDITION.get(), List.of());
        for (String additive : additives) {
            if (additive.equals("white_flower")) {
                effects.add(new MobEffectInstance(MobEffects.BAD_OMEN));
            }
            if (additive.equals("end_flower")) {
                effects.add(new MobEffectInstance(MobEffects.LEVITATION));
            }
            if (additive.equals("wither_flower")) {
                effects.add(new MobEffectInstance(MobEffects.WITHER));
            }
        }

        return effects;
    }

    private List<MobEffectInstance> getEffectsToAdd(ItemStack stack) {
        List<MobEffectInstance> effects = new ArrayList<>();
        List<String> additives = stack.getOrDefault(ModDataComponents.TEA_ADDITION.get(), List.of());

        for (String additive : additives) {
            // fruits
            if (additive.equals("red_stuff")) {
                if (!additives.contains("golden_fruit") && !additives.contains("god_apple")) {
                    effects.add(new MobEffectInstance(MobEffects.REGENERATION, 300, 0));
                }
            }
            if (additive.equals("golden_fruit")) {
                if (!additives.contains("god_apple")) {
                    effects.add(new MobEffectInstance(MobEffects.REGENERATION, 600, 1));
                    effects.add(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 0));
                }
            }
            if (additive.equals("god_apple")) {
                effects.add(new MobEffectInstance(MobEffects.REGENERATION, 800, 1));
                effects.add(new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3));
                effects.add(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 0));
                effects.add(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0));
            }
            if (additive.equals("sweet")) {
                effects.add(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 0));
                effects.add(new MobEffectInstance(MobEffects.JUMP, 300, 0));
            }
            if (additive.equals("glowing_fruit")) {
                effects.add(new MobEffectInstance(MobEffects.GLOWING, 300, 0));
            }

            // flowers
            if (additive.equals("pink_flower")) {
                effects.add(new MobEffectInstance(MobEffects.INVISIBILITY, 300, 0));
            }
            if (additive.equals("yellow_flower")) {
                effects.add(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 0));
                effects.add(new MobEffectInstance(MobEffects.DIG_SPEED, 300, 0));
            }
            if (additive.equals("white_flower")) {
                effects.add(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 300, 0));
            }
            if (additive.equals("grey_flower")) {
                effects.add(new MobEffectInstance(MobEffects.SATURATION, 300, 0));
            }
            if (additive.equals("blue_flower")) {
                effects.add(new MobEffectInstance(MobEffects.WATER_BREATHING, 300, 0));
                effects.add(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 300, 0));
                effects.add(new MobEffectInstance(MobEffects.CONDUIT_POWER, 300, 0));
            }
            if (additive.equals("purple_flower_1")) {
                if (!additives.contains("sweet")) {
                    effects.add(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 0));
                }
            }
            if (additive.equals("purple_flower_2")) {
                if (!additives.contains("sweet")) {
                    effects.add(new MobEffectInstance(MobEffects.JUMP, 300, 0));
                }
            }
            if (additive.equals("red_flower")) {
                effects.add(new MobEffectInstance(MobEffects.HEALTH_BOOST, 300, 0));
                effects.add(new MobEffectInstance(MobEffects.HEAL, 300, 0));
            }
            if (additive.equals("end_flower")) {
                effects.add(new MobEffectInstance(MobEffects.SLOW_FALLING, 300, 0));
            }
            if (additive.equals("fire_flower")) {
                if (!additives.contains("god_apple")) {
                    effects.add(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0));
                }
                effects.add(new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0));
            }
            if (additive.equals("pot_flower")) {
                if (!additives.contains("god_apple") && !additives.contains("golden_fruit")) {
                    effects.add(new MobEffectInstance(MobEffects.ABSORPTION, 300, 0));
                }
                effects.add(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 0));
            }

            // other
            if (additive.equals("wing")) {
                effects.add(new MobEffectInstance(MobEffects.LEVITATION, 300, 0));
            }
            if (additive.equals("fire")) {
                if (!additives.contains("fire_flower")) {
                    effects.add(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0));
                }
            }
            if (additive.equals("torrid")) {
                if (!additives.contains("yellow_flower")) {
                    effects.add(new MobEffectInstance(MobEffects.DIG_SPEED, 300, 0));
                }
            }
        }

        return modifyEffects(effects, stack);
    }

    private List<MobEffectInstance> modifyEffects(List<MobEffectInstance> effectInstanceList, ItemStack stack) {
        List<String> modifiers = stack.getOrDefault(ModDataComponents.TEA_MODIFIER.get(), List.of());
        List<MobEffectInstance> modifiedEffects = new ArrayList<>();
        for (MobEffectInstance effect : effectInstanceList) {
            int duration = effect.getDuration();
            int amplifier = effect.getAmplifier();

            for (String mod : modifiers) {
                if (mod.equals("redstone")) {
                    duration += 100;
                }
                if (mod.equals("glowstone") && amplifier < 4) {
                    amplifier++;
                }
            }
            modifiedEffects.add(new MobEffectInstance(effect.getEffect(), duration, amplifier));
        }
        return modifiedEffects;
    }

    private void createNetherPlatform(ServerLevel world, BlockPos pos) {
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                BlockPos platformPos = new BlockPos(pos.getX() + x, pos.getY(), pos.getZ() + z);
                if (world.getRandom().nextBoolean()) {
                    world.setBlockAndUpdate(platformPos, Blocks.CRYING_OBSIDIAN.defaultBlockState());
                } else {
                    world.setBlockAndUpdate(platformPos, Blocks.OBSIDIAN.defaultBlockState());
                }
            }
        }
        for (int layer = 1; layer <= 3; layer++) {
            for (int x = -2; x <= 2; x++) {
                for (int z = -2; z <= 2; z++) {
                    BlockPos airPos = new BlockPos(pos.getX() + x, pos.getY() + layer, pos.getZ() + z);
                    world.setBlockAndUpdate(airPos, Blocks.AIR.defaultBlockState());
                }
            }
        }
    }

    private void tryTeleport(ItemStack stack, LivingEntity entity) {
        String teleport = stack.getOrDefault(ModDataComponents.TEA_TELEPORT.get(), "");
        if (!teleport.isEmpty() && entity instanceof ServerPlayer player) {
            ServerLevel currentLevel = player.serverLevel();
            ServerLevel targetLevel = null;
            BlockPos targetPos = null;
            float yRot = player.getYRot();
            float xRot = player.getXRot();

            if (teleport.equals("spawn")) {
                targetLevel = player.getServer().getLevel(Level.OVERWORLD);
                BlockPos respawnPos = player.getRespawnPosition();
                if (respawnPos != null) {
                    targetPos = findSafePosition(targetLevel, respawnPos);
                } else {
                    targetPos = findSafePosition(targetLevel, targetLevel.getSharedSpawnPos());
                }
            } else if (teleport.equals("overworld")) {
                targetLevel = player.getServer().getLevel(Level.OVERWORLD);
                if (currentLevel.dimension() == Level.OVERWORLD) {
                    targetPos = findSafePosition(targetLevel, targetLevel.getSharedSpawnPos());
                } else if (currentLevel.dimension() == Level.NETHER) {
                    int overX = player.blockPosition().getX() * 8;
                    int overZ = player.blockPosition().getZ() * 8;
                    targetPos = findSafePosition(targetLevel, new BlockPos(overX, targetLevel.getLogicalHeight() / 2, overZ));
                } else if (currentLevel.dimension() == Level.END) {
                    targetPos = findSafePosition(targetLevel, targetLevel.getSharedSpawnPos());
                }
            } else if (teleport.equals("nether")) {
                targetLevel = player.getServer().getLevel(Level.NETHER);
                if (currentLevel.dimension() == Level.OVERWORLD) {
                    int netherX = player.blockPosition().getX() / 8;
                    int netherZ = player.blockPosition().getZ() / 8;
                    targetPos = new BlockPos(netherX, 64, netherZ);
                } else if (currentLevel.dimension() == Level.NETHER) {
                    BlockPos respawnPos = player.getRespawnPosition();
                    if (respawnPos != null) {
                        targetPos = respawnPos;
                    } else {
                        targetPos = new BlockPos(0, 64, 0);
                    }
                } else if (currentLevel.dimension() == Level.END) {
                    targetPos = new BlockPos(0, 64, 0);
                }
            } else if (teleport.equals("end")) {
                targetLevel = player.getServer().getLevel(Level.END);
                if (currentLevel.dimension() == Level.OVERWORLD || currentLevel.dimension() == Level.NETHER) {
                    int endX = player.blockPosition().getX();
                    int endZ = player.blockPosition().getZ();
                    targetPos = new BlockPos(endX, 49, endZ);
                } else if (currentLevel.dimension() == Level.END) {
                    targetPos = new BlockPos(100, 49, 0);
                }
            }

            if (targetLevel != null && targetPos != null) {
                player.sendSystemMessage(Component.literal("Loading dimension..."));
                if (teleport.equals("end")) {
                    EndPlatformFeature.createEndPlatform(targetLevel, targetPos.below(), true);
                } else if (teleport.equals("nether")) {
                    createNetherPlatform(targetLevel, targetPos.below());
                }
                DimensionTransition transition = new DimensionTransition(
                        targetLevel,
                        targetPos.getCenter(),
                        player.getDeltaMovement(),
                        yRot,
                        xRot,
                        DimensionTransition.DO_NOTHING
                );
                player.changeDimension(transition);
                player.getCooldowns().addCooldown(this, COOLDOWN_TICKS);
            }
        }
    }

    private BlockPos findSafePosition(ServerLevel world, BlockPos initialPos) {
        int minY = world.getMinBuildHeight();
        int maxY = world.getMaxBuildHeight() - 3;
        BlockPos.MutableBlockPos checkPos = new BlockPos.MutableBlockPos(initialPos.getX(), minY, initialPos.getZ());

        for (int y = maxY; y >= minY; y--) {
            checkPos.setY(y);
            if (world.getBlockState(checkPos).isSolid() &&
                    world.getBlockState(checkPos.above()).isAir() &&
                    world.getBlockState(checkPos.above(2)).isAir()) {
                return checkPos.above();
            }
        }
        return initialPos; // Fallback to initial position if no safe position is found
    }
}