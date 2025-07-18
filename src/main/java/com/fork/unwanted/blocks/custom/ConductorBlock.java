package com.fork.unwanted.blocks.custom;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.blocks.ModBlocks;
import com.fork.unwanted.blocks.entity.ConductorBlockEntity;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

public class ConductorBlock extends BaseEntityBlock {
    public static final MapCodec<ConductorBlock> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(Codec.INT.fieldOf("delay").forGetter(block -> block.delay), propertiesCodec()).apply(instance, ConductorBlock::new)
    );
    public static final IntegerProperty POWER = IntegerProperty.create("power", 0, 15);
    private final int delay;

    public ConductorBlock(int delay, Properties properties) {
        super(properties.noOcclusion().isRedstoneConductor((state, getter, pos) -> false));
        this.delay = Math.max(0, delay); // Ensure delay is at least 0 tick
        this.registerDefaultState(this.stateDefinition.any().setValue(POWER, 0));
    }

    public int getDelay() {
        return this.delay;
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWER);
    }

    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        if (direction == null) return false;
        BlockState targetState = level.getBlockState(pos.relative(direction));
        Block targetBlock = targetState.getBlock();
        return !(targetBlock == Blocks.REDSTONE_WIRE || targetBlock == Blocks.COMPARATOR || targetBlock == Blocks.REPEATER);
    }

    @Override
    public int getSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof ConductorBlockEntity conductorBe && conductorBe.isResetScheduled()) {
            return 0;
        }
        int power = state.getValue(POWER);
        return power;
    }

    @Override
    public int getDirectSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return getSignal(state, level, pos, direction);
    }

    @Override
    public boolean isSignalSource(BlockState state) {
        return state.getValue(POWER) > 0;
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!level.isClientSide) {
            level.scheduleTick(pos, this, delay);
        }
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!oldState.is(this) && !level.isClientSide) {
            level.scheduleTick(pos, this, delay);
        }
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock()) && !level.isClientSide) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof ConductorBlockEntity conductorBe) {
                int originalDistance = conductorBe.getDistance();
                conductorBe.setDistance(0);
                conductorBe.setResetScheduled(false);
                for (Direction dir : Direction.values()) {
                    BlockPos neighborPos = pos.relative(dir);
                    BlockState neighborState = level.getBlockState(neighborPos);
                    if (neighborState.getBlock() instanceof ConductorBlock) {
                        BlockEntity neighborBe = level.getBlockEntity(neighborPos);
                        if (neighborBe instanceof ConductorBlockEntity neighborConductor && !neighborConductor.isResetScheduled()) {
                            int neighborDistance = neighborConductor.getDistance();
                            if (neighborDistance > originalDistance) {
                                neighborConductor.scheduleReset(level, neighborPos, delay);
                            }
                        }
                    }
                }
            }
            super.onRemove(state, level, pos, newState, isMoving);
            for (Direction dir : Direction.values()) {
                level.updateNeighborsAt(pos.relative(dir), this);
            }
        }
    }

    private void updatePower(Level level, BlockPos pos, BlockState state) {
        BlockEntity be = level.getBlockEntity(pos);
        if (!(be instanceof ConductorBlockEntity conductorBe)) return;

        if (conductorBe.isResetScheduled()) {
            return;
        }

        int currentPower = state.getValue(POWER);
        int currentDistance = conductorBe.getDistance();
        PowerCalculationResult result = calculateTargetPower(level, pos, currentPower, currentDistance);

        if (result.power != currentPower || result.distance != currentDistance) {
            conductorBe.setDistance(result.distance);
            level.setBlock(pos, state.setValue(POWER, result.power), 3);
            if (result.power == 0 && currentPower > 0) {
                conductorBe.scheduleReset(level, pos, delay);
            } else if (result.power > 0) {
                conductorBe.schedulePowerPropagation(level, pos, result.distance, result.power);
            }
        }
    }

    private static class PowerCalculationResult {
        int power;
        int distance;
        PowerCalculationResult(int power, int distance) {
            this.power = power;
            this.distance = distance;
        }
    }

    private PowerCalculationResult calculateTargetPower(Level level, BlockPos pos, int currentPower, int currentDistance) {
        int maxPower = 0;
        int minDistance = Integer.MAX_VALUE;
        boolean hasValidSource = false;

        for (Direction direction : Direction.values()) {
            BlockPos neighborPos = pos.relative(direction);
            BlockState neighborState = level.getBlockState(neighborPos);
            Block neighborBlock = neighborState.getBlock();

//            if (neighborBlock == Blocks.REDSTONE_WIRE || neighborBlock == Blocks.COMPARATOR || neighborBlock == Blocks.REPEATER) {
//                continue;
//            }

            if (neighborState.isSignalSource()) {
                BlockEntity neighborBe = level.getBlockEntity(neighborPos);
                if (neighborBlock instanceof ConductorBlock && neighborBe instanceof ConductorBlockEntity neighborConductor) {
                    if (neighborConductor.isResetScheduled() || neighborConductor.getDistance() >= currentDistance) {
                        continue; // Prevent feedback loops
                    }
                    int neighborDistance = neighborConductor.getDistance();
                    if (neighborDistance <= 0) {
                        continue;
                    }
                    int neighborPower = level.getSignal(neighborPos, direction.getOpposite());
                    if (neighborPower > 0) {
                        hasValidSource = true;
                        int effectiveDistance = neighborDistance + 1;
                        if (neighborPower > maxPower) {
                            maxPower = neighborPower;
                            minDistance = effectiveDistance;
                        } else if (neighborPower == maxPower && effectiveDistance < minDistance) {
                            minDistance = effectiveDistance;
                        }
                    }
                } else {
                    int neighborPower = level.getSignal(neighborPos, direction.getOpposite());
                    if (neighborPower > 0) {
                        hasValidSource = true;
                        int effectiveDistance = 1;
                        if (neighborPower > maxPower) {
                            maxPower = neighborPower;
                            minDistance = effectiveDistance;
                        } else if (neighborPower == maxPower && effectiveDistance < minDistance) {
                            minDistance = effectiveDistance;
                        }
                    }
                }
            }
        }

        if (!hasValidSource) {
            return new PowerCalculationResult(0, 0);
        }

        return new PowerCalculationResult(maxPower, minDistance);
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        updatePower(level, pos, state);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ConductorBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide ? null : (lvl, pos, st, be) -> {
            if (be instanceof ConductorBlockEntity conductor) {
                conductor.tick(lvl, pos, st);
            }
        };
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return this == ModBlocks.SILVER_BLOCK.get()
                || this == ModBlocks.EXPOSED_SILVER_BLOCK.get()
                || this == ModBlocks.WEATHERED_SILVER_BLOCK.get();
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (isRandomlyTicking(state) && random.nextFloat() < 0.05688889F) {
            Block nextBlock = getNextOxidationBlock();
            if (nextBlock != null) {
                BlockEntity be = level.getBlockEntity(pos);
                if (be instanceof ConductorBlockEntity conductorBe) {
                    int distance = conductorBe.getDistance();
                    boolean resetScheduled = conductorBe.isResetScheduled();
                    int originalDistance = conductorBe.getOriginalDistance();
                    BlockState newState = nextBlock.defaultBlockState().setValue(POWER, state.getValue(POWER));
                    level.setBlock(pos, newState, 3);
                    BlockEntity newBe = level.getBlockEntity(pos);
                    if (newBe instanceof ConductorBlockEntity newConductorBe) {
                        newConductorBe.setDistance(distance);
                        newConductorBe.setResetScheduled(resetScheduled);
                        newConductorBe.setOriginalDistance(originalDistance);
                    }
                }
            }
        }
    }

    private Block getNextOxidationBlock() {
        if (this == ModBlocks.SILVER_BLOCK.get()) return ModBlocks.EXPOSED_SILVER_BLOCK.get();
        if (this == ModBlocks.EXPOSED_SILVER_BLOCK.get()) return ModBlocks.WEATHERED_SILVER_BLOCK.get();
        if (this == ModBlocks.WEATHERED_SILVER_BLOCK.get()) return ModBlocks.OXIDIZED_SILVER_BLOCK.get();
        return null;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        Item item = stack.getItem();

        if (item == Items.HONEYCOMB) {
            Block waxedBlock = getWaxedBlock();
            if (waxedBlock != null) {
                if (!level.isClientSide) {
                    BlockEntity be = level.getBlockEntity(pos);
                    if (be instanceof ConductorBlockEntity conductorBe) {
                        int distance = conductorBe.getDistance();
                        boolean resetScheduled = conductorBe.isResetScheduled();
                        int originalDistance = conductorBe.getOriginalDistance();
                        BlockState newState = waxedBlock.defaultBlockState().setValue(POWER, state.getValue(POWER));
                        level.setBlock(pos, newState, 11);
                        BlockEntity newBe = level.getBlockEntity(pos);
                        if (newBe instanceof ConductorBlockEntity newConductorBe) {
                            newConductorBe.setDistance(distance);
                            newConductorBe.setResetScheduled(resetScheduled);
                            newConductorBe.setOriginalDistance(originalDistance);
                        }
                        if (!player.isCreative()) stack.shrink(1);
                    }
                }
                return ItemInteractionResult.sidedSuccess(level.isClientSide());
            }
        }

        if (stack.getItem() instanceof AxeItem) {
            Block newBlock = getUnwaxedOrPreviousOxidationBlock();
            if (newBlock != null && newBlock != this) {
                if (!level.isClientSide) {
                    BlockEntity be = level.getBlockEntity(pos);
                    if (be instanceof ConductorBlockEntity conductorBe) {
                        int distance = conductorBe.getDistance();
                        boolean resetScheduled = conductorBe.isResetScheduled();
                        int originalDistance = conductorBe.getOriginalDistance();
                        BlockState newState = newBlock.defaultBlockState().setValue(POWER, state.getValue(POWER));
                        level.setBlock(pos, newState, 11);
                        BlockEntity newBe = level.getBlockEntity(pos);
                        if (newBe instanceof ConductorBlockEntity newConductorBe) {
                            newConductorBe.setDistance(distance);
                            newConductorBe.setResetScheduled(resetScheduled);
                            newConductorBe.setOriginalDistance(originalDistance);
                        }
                        if (!player.isCreative()) stack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
                    }
                }
                return ItemInteractionResult.sidedSuccess(level.isClientSide());
            }
        }

        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    private Block getWaxedBlock() {
        if (this == ModBlocks.SILVER_BLOCK.get()) return ModBlocks.WAXED_SILVER_BLOCK.get();
        if (this == ModBlocks.EXPOSED_SILVER_BLOCK.get()) return ModBlocks.WAXED_EXPOSED_SILVER_BLOCK.get();
        if (this == ModBlocks.WEATHERED_SILVER_BLOCK.get()) return ModBlocks.WAXED_WEATHERED_SILVER_BLOCK.get();
        if (this == ModBlocks.OXIDIZED_SILVER_BLOCK.get()) return ModBlocks.WAXED_OXIDIZED_SILVER_BLOCK.get();
        return null;
    }

    private Block getUnwaxedOrPreviousOxidationBlock() {
        if (this == ModBlocks.WAXED_SILVER_BLOCK.get()) return ModBlocks.SILVER_BLOCK.get();
        if (this == ModBlocks.WAXED_EXPOSED_SILVER_BLOCK.get()) return ModBlocks.EXPOSED_SILVER_BLOCK.get();
        if (this == ModBlocks.WAXED_WEATHERED_SILVER_BLOCK.get()) return ModBlocks.WEATHERED_SILVER_BLOCK.get();
        if (this == ModBlocks.WAXED_OXIDIZED_SILVER_BLOCK.get()) return ModBlocks.OXIDIZED_SILVER_BLOCK.get();
        if (this == ModBlocks.EXPOSED_SILVER_BLOCK.get()) return ModBlocks.SILVER_BLOCK.get();
        if (this == ModBlocks.WEATHERED_SILVER_BLOCK.get()) return ModBlocks.EXPOSED_SILVER_BLOCK.get();
        if (this == ModBlocks.OXIDIZED_SILVER_BLOCK.get()) return ModBlocks.WEATHERED_SILVER_BLOCK.get();
        return null;
    }
}