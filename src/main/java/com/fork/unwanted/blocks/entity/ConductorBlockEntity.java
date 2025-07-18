package com.fork.unwanted.blocks.entity;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.blocks.custom.ConductorBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ConductorBlockEntity extends BlockEntity {
    private int distance = 0;
    private boolean resetScheduled = false;
    private int originalDistance = 0;

    public ConductorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CONDUCTOR_BLOCK_ENTITY.get(), pos, state);
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
        setChanged();
    }

    public boolean isResetScheduled() {
        return resetScheduled;
    }

    public void setResetScheduled(boolean scheduled) {
        this.resetScheduled = scheduled;
        setChanged();
    }

    public int getOriginalDistance() {
        return originalDistance;
    }

    public void setOriginalDistance(int distance) {
        this.originalDistance = distance;
        setChanged();
    }

    public int getPower(Level level, BlockPos pos) {
        return level.getBlockState(pos).getValue(ConductorBlock.POWER);
    }

    public void scheduleReset(Level level, BlockPos pos, int delay) {
        if (!resetScheduled) {
            originalDistance = distance;
            setResetScheduled(true);
            level.scheduleTick(pos, getBlockState().getBlock(), delay);
        }
    }

    public void schedulePowerPropagation(Level level, BlockPos pos, int distance, int power) {
        if (!resetScheduled) {
            level.scheduleTick(pos, getBlockState().getBlock(), ((ConductorBlock) getBlockState().getBlock()).getDelay());
        }
    }

    public void tick(Level level, BlockPos pos, BlockState state) {
        if (level.isClientSide) return;

        if (!(state.getBlock() instanceof ConductorBlock conductorBlock)) return;
        if (resetScheduled) {
            int originalDistance = this.originalDistance;
            setDistance(0);
            setResetScheduled(false);
            level.setBlock(pos, state.setValue(ConductorBlock.POWER, 0), 3);
            propagateReset(level, pos, originalDistance);
        } else {
            int currentDistance = getDistance();
            int currentPower = state.getValue(ConductorBlock.POWER);
            if (currentDistance > 0 && currentPower > 0) {
                propagatePower(level, pos, state, currentDistance, currentPower);
            }
        }
    }

    public void propagateReset(Level level, BlockPos pos, int originalDistance) {
        for (Direction dir : Direction.values()) {
            BlockPos neighborPos = pos.relative(dir);
            BlockState neighborState = level.getBlockState(neighborPos);
            if (neighborState.getBlock() instanceof ConductorBlock) {
                BlockEntity neighborBe = level.getBlockEntity(neighborPos);
                if (neighborBe instanceof ConductorBlockEntity neighborConductor && !neighborConductor.isResetScheduled()) {
                    int neighborDistance = neighborConductor.getDistance();
                    if (neighborDistance > originalDistance) {
                        neighborConductor.scheduleReset(level, neighborPos, ((ConductorBlock) neighborState.getBlock()).getDelay());
                    }
                }
            }
        }
    }

    public void propagatePower(Level level, BlockPos pos, BlockState state, int currentDistance, int currentPower) {
        for (Direction dir : Direction.values()) {
            BlockPos neighborPos = pos.relative(dir);
            BlockState neighborState = level.getBlockState(neighborPos);
            if (neighborState.getBlock() instanceof ConductorBlock) {
                BlockEntity neighborBe = level.getBlockEntity(neighborPos);
                if (neighborBe instanceof ConductorBlockEntity neighborConductor && !neighborConductor.isResetScheduled()) {
                    int neighborDistance = neighborConductor.getDistance();
                    int neighborPower = neighborConductor.getPower(level, neighborPos);
                    int newDistance = currentDistance + 1;
                    int newPower = currentPower;
                    if (neighborDistance == 0 || neighborDistance > currentDistance + 1) {
                        if (newDistance != neighborDistance || newPower != neighborPower) {
                            neighborConductor.setDistance(newDistance);
                            level.setBlock(neighborPos, neighborState.setValue(ConductorBlock.POWER, newPower), 3);
                            level.scheduleTick(neighborPos, neighborState.getBlock(), ((ConductorBlock) neighborState.getBlock()).getDelay());
                        }
                    } else if (neighborDistance == currentDistance + 1 && currentPower > neighborPower) {
                        if (newPower != neighborPower) {
                            level.setBlock(neighborPos, neighborState.setValue(ConductorBlock.POWER, newPower), 3);
                            level.scheduleTick(neighborPos, neighborState.getBlock(), ((ConductorBlock) neighborState.getBlock()).getDelay());
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putInt("DistanceToSource", distance);
        tag.putBoolean("ResetScheduled", resetScheduled);
        tag.putInt("OriginalDistance", originalDistance);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        distance = tag.getInt("DistanceToSource");
        resetScheduled = tag.getBoolean("ResetScheduled");
        originalDistance = tag.getInt("OriginalDistance");
    }
}