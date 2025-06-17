package com.fork.unwanted.misc;

import com.fork.unwanted.Unwanted;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType EBONY = WoodType.register(new WoodType(Unwanted.MOD_ID + ":ebony", BlockSetType.DARK_OAK));
}
