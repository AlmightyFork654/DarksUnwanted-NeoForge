package com.fork.unwanted.blocks.custom;

import com.fork.unwanted.blocks.ModBlocks;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

public class ConductorBlock extends Block {
    // Block state properties
    public static final IntegerProperty POWER = IntegerProperty.create("power", 0, 15);
    private final int delay;

    public ConductorBlock(int delay, Properties properties) {
        super(properties);
        this.delay = delay;
        // Set default state: unpowered
        this.registerDefaultState(this.stateDefinition.any().setValue(POWER, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWER);
    }

    // --- Redstone Signal Handling ---
    @Override
    public int getSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return state.getValue(POWER); // Outputs power in all directions
    }

    @Override
    public int getDirectSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return state.getValue(POWER); // Direct signal matches weak signal
    }

    @Override
    public boolean isSignalSource(BlockState state) {
        return true; // Can provide redstone power
    }

    // Update power when neighbors change or block is placed
    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!level.isClientSide) {
            updatePower(level, pos, state);
        }
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!oldState.is(this) && !level.isClientSide) {
            updatePower(level, pos, state);
        }
    }

    private void updatePower(Level level, BlockPos pos, BlockState state) {
        int targetPower = calculateTargetPower(level, pos);
        if (targetPower != state.getValue(POWER)) {
            // Schedule a tick with the block's delay for powering on, or 40 ticks (2 seconds) for powering off
            int tickDelay = targetPower > 0 ? delay : 40;
            level.scheduleTick(pos, this, tickDelay); // Schedule update
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int targetPower = calculateTargetPower(level, pos);
        level.setBlock(pos, state.setValue(POWER, targetPower), 2);
        level.updateNeighborsAt(pos, this);
    }

//    private int calculateTargetPower(Level level, BlockPos pos) {
//        int maxPower = 0;
//        for (Direction direction : Direction.values()) {
//            BlockPos neighborPos = pos.relative(direction);
//            int neighborPower = level.getSignal(neighborPos, direction.getOpposite());
//            maxPower = Math.max(maxPower, neighborPower);
//        }
//        return maxPower; // No degradation
//    }

    private int calculateTargetPower(Level level, BlockPos pos) {
        int maxPower = 0;
        for (Direction direction : Direction.values()) {
            BlockPos neighborPos = pos.relative(direction);
            BlockState neighborState = level.getBlockState(neighborPos);
            // Only consider blocks that are redstone signal sources or ConductorBlocks
            if (neighborState.isSignalSource() || neighborState.getBlock() instanceof ConductorBlock) {
                int neighborPower = level.getSignal(neighborPos, direction.getOpposite());
                maxPower = Math.max(maxPower, neighborPower);
            }
        }
        return maxPower; // No degradation
    }

    // --- Oxidation Progression ---
    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return this == ModBlocks.SILVER_BLOCK.get() ||
                this == ModBlocks.EXPOSED_SILVER_BLOCK.get() ||
                this == ModBlocks.WEATHERED_SILVER_BLOCK.get();
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (isRandomlyTicking(state) && random.nextFloat() < 0.05688889F) { // Vanilla oxidation chance
            Block nextBlock = getNextOxidationBlock();
            if (nextBlock != null) {
                level.setBlock(pos, nextBlock.defaultBlockState().setValue(POWER, state.getValue(POWER)), 2);
            }
        }
    }

    private Block getNextOxidationBlock() {
        if (this == ModBlocks.SILVER_BLOCK.get()) {
            return ModBlocks.EXPOSED_SILVER_BLOCK.get();
        } else if (this == ModBlocks.EXPOSED_SILVER_BLOCK.get()) {
            return ModBlocks.WEATHERED_SILVER_BLOCK.get();
        } else if (this == ModBlocks.WEATHERED_SILVER_BLOCK.get()) {
            return ModBlocks.OXIDIZED_SILVER_BLOCK.get();
        }
        return null;
    }

    // --- Player Interactions: Waxing and Stripping ---
    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        Item item = stack.getItem();

        // Waxing with honeycomb
        if (item == Items.HONEYCOMB) {
            Block waxedBlock = getWaxedBlock();
            if (waxedBlock != null) {
                if (!level.isClientSide) {
                    level.setBlock(pos, waxedBlock.defaultBlockState().setValue(POWER, state.getValue(POWER)), 11);
                    if (!player.isCreative()) {
                        stack.shrink(1); // Consume honeycomb
                    }
                }
                return ItemInteractionResult.sidedSuccess(level.isClientSide());
            }
        }

        // Stripping with axe
        if (stack.getItem() instanceof AxeItem) {
            Block newBlock = getUnwaxedOrPreviousOxidationBlock();
            if (newBlock != null && newBlock != this) {
                if (!level.isClientSide) {
                    level.setBlock(pos, newBlock.defaultBlockState().setValue(POWER, state.getValue(POWER)), 11);
                    if (!player.isCreative()) {
                        stack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND); // Damage axe
                    }
                }
                return ItemInteractionResult.sidedSuccess(level.isClientSide());
            }
        }

        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    private Block getWaxedBlock() {
        if (this == ModBlocks.SILVER_BLOCK.get()) {
            return ModBlocks.WAXED_SILVER_BLOCK.get();
        } else if (this == ModBlocks.EXPOSED_SILVER_BLOCK.get()) {
            return ModBlocks.WAXED_EXPOSED_SILVER_BLOCK.get();
        } else if (this == ModBlocks.WEATHERED_SILVER_BLOCK.get()) {
            return ModBlocks.WAXED_WEATHERED_SILVER_BLOCK.get();
        } else if (this == ModBlocks.OXIDIZED_SILVER_BLOCK.get()) {
            return ModBlocks.WAXED_OXIDIZED_SILVER_BLOCK.get();
        }
        return null;
    }

    private Block getUnwaxedOrPreviousOxidationBlock() {
        if (this == ModBlocks.WAXED_SILVER_BLOCK.get()) {
            return ModBlocks.SILVER_BLOCK.get();
        } else if (this == ModBlocks.WAXED_EXPOSED_SILVER_BLOCK.get()) {
            return ModBlocks.EXPOSED_SILVER_BLOCK.get();
        } else if (this == ModBlocks.WAXED_WEATHERED_SILVER_BLOCK.get()) {
            return ModBlocks.WEATHERED_SILVER_BLOCK.get();
        } else if (this == ModBlocks.WAXED_OXIDIZED_SILVER_BLOCK.get()) {
            return ModBlocks.OXIDIZED_SILVER_BLOCK.get();
        } else if (this == ModBlocks.EXPOSED_SILVER_BLOCK.get()) {
            return ModBlocks.SILVER_BLOCK.get();
        } else if (this == ModBlocks.WEATHERED_SILVER_BLOCK.get()) {
            return ModBlocks.EXPOSED_SILVER_BLOCK.get();
        } else if (this == ModBlocks.OXIDIZED_SILVER_BLOCK.get()) {
            return ModBlocks.WEATHERED_SILVER_BLOCK.get();
        }
        return null;
    }
}