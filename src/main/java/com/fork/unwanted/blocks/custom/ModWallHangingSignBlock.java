package com.fork.unwanted.blocks.custom;

import com.fork.unwanted.blocks.entity.ModHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWallHangingSignBlock extends WallHangingSignBlock {
    public ModWallHangingSignBlock(Properties properties, WoodType type) {
        super(type, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pBlockState) {
        return new ModHangingSignBlockEntity(pPos, pBlockState);
    }
}
