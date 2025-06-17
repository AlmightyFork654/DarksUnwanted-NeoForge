package com.fork.unwanted.blocks.custom;

import com.fork.unwanted.blocks.entity.ModSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModStandingSignBlock extends StandingSignBlock {
    public ModStandingSignBlock(Properties properties, WoodType type) {
        super(type, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pBlockState) {
        return new ModSignBlockEntity(pPos, pBlockState);
    }
}
