package com.fork.unwanted.datagen;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.blocks.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Unwanted.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.RUBY_ORE);
        blockWithItem(ModBlocks.TORRID_STEEL_ORE);
        blockWithItem(ModBlocks.EMBARIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_EMBARIUM_ORE);
        blockWithItem(ModBlocks.PROFUNDIUM_ORE);
        blockWithItem(ModBlocks.RUBY_BLOCK);
        simpleBlockWithItem(ModBlocks.EMBARIUM_BLOCK.get(), models().cubeAll(blockTexture(ModBlocks.EMBARIUM_BLOCK.get()).getPath(),
                blockTexture(ModBlocks.EMBARIUM_BLOCK.get())).renderType("translucent"));
        blockWithItem(ModBlocks.TORRID_STEEL_BLOCK);
        blockWithItem(ModBlocks.PROFUNDIUM_BLOCK);

        blockWithItem(ModBlocks.MARBLE);
        blockWithItem(ModBlocks.SMOOTH_MARBLE);
        blockWithItem(ModBlocks.POLISHED_MARBLE);
        blockWithItem(ModBlocks.MARBLE_BRICKS);
        blockWithItem(ModBlocks.CRACKED_MARBLE_BRICKS);
        blockWithItem(ModBlocks.MOSSY_MARBLE_BRICKS);
        horizontalBlock(ModBlocks.CHISELED_C_MARBLE.get(), modLoc("block/chiseled_c_marble"), modLoc("block/chiseled_c_marble"), modLoc("block/chiseled_c_marble_top"));
        horizontalBlock(ModBlocks.CHISELED_S_MARBLE.get(), modLoc("block/chiseled_s_marble"), modLoc("block/chiseled_s_marble"), modLoc("block/chiseled_s_marble_top"));
        horizontalBlock(ModBlocks.CHISELED_W_MARBLE.get(), modLoc("block/chiseled_w_marble"), modLoc("block/chiseled_w_marble"), modLoc("block/chiseled_w_marble_top"));
        horizontalBlock(ModBlocks.CHISELED_E_MARBLE.get(), modLoc("block/chiseled_e_marble"), modLoc("block/chiseled_e_marble"), modLoc("block/chiseled_e_marble_top"));
        blockItem(ModBlocks.CHISELED_C_MARBLE);
        blockItem(ModBlocks.CHISELED_S_MARBLE);
        blockItem(ModBlocks.CHISELED_W_MARBLE);
        blockItem(ModBlocks.CHISELED_E_MARBLE);
        logBlock(((RotatedPillarBlock) ModBlocks.MARBLE_PILLAR.get()));
        blockItem(ModBlocks.MARBLE_PILLAR);

        stairsBlock(ModBlocks.MARBLE_STAIRS.get(), blockTexture(ModBlocks.MARBLE.get()));
        stairsBlock(ModBlocks.POLISHED_MARBLE_STAIRS.get(), blockTexture(ModBlocks.POLISHED_MARBLE.get()));
        stairsBlock(ModBlocks.SMOOTH_MARBLE_STAIRS.get(), blockTexture(ModBlocks.SMOOTH_MARBLE.get()));
        stairsBlock(ModBlocks.MARBLE_BRICKS_STAIRS.get(), blockTexture(ModBlocks.MARBLE_BRICKS.get()));
        stairsBlock(ModBlocks.CRACKED_MARBLE_BRICKS_STAIRS.get(), blockTexture(ModBlocks.CRACKED_MARBLE_BRICKS.get()));
        stairsBlock(ModBlocks.MOSSY_MARBLE_BRICKS_STAIRS.get(), blockTexture(ModBlocks.MOSSY_MARBLE_BRICKS.get()));

        blockItem(ModBlocks.MARBLE_STAIRS);
        blockItem(ModBlocks.POLISHED_MARBLE_STAIRS);
        blockItem(ModBlocks.SMOOTH_MARBLE_STAIRS);
        blockItem(ModBlocks.MARBLE_BRICKS_STAIRS);
        blockItem(ModBlocks.CRACKED_MARBLE_BRICKS_STAIRS);
        blockItem(ModBlocks.MOSSY_MARBLE_BRICKS_STAIRS);

        slabBlock(ModBlocks.MARBLE_SLAB.get(), blockTexture(ModBlocks.MARBLE.get()), blockTexture(ModBlocks.MARBLE.get()));
        slabBlock(ModBlocks.POLISHED_MARBLE_SLAB.get(), blockTexture(ModBlocks.DOUBLE_POLISHED_MARBLE_SLAB.get()), blockTexture(ModBlocks.POLISHED_MARBLE.get()));
        slabBlock(ModBlocks.SMOOTH_MARBLE_SLAB.get(), blockTexture(ModBlocks.DOUBLE_SMOOTH_MARBLE_SLAB.get()), blockTexture(ModBlocks.SMOOTH_MARBLE.get()));
        slabBlock(ModBlocks.MARBLE_BRICKS_SLAB.get(), blockTexture(ModBlocks.MARBLE_BRICKS.get()), blockTexture(ModBlocks.MARBLE_BRICKS.get()));
        slabBlock(ModBlocks.CRACKED_MARBLE_BRICKS_SLAB.get(), blockTexture(ModBlocks.CRACKED_MARBLE_BRICKS.get()), blockTexture(ModBlocks.CRACKED_MARBLE_BRICKS.get()));
        slabBlock(ModBlocks.MOSSY_MARBLE_BRICKS_SLAB.get(), blockTexture(ModBlocks.MOSSY_MARBLE_BRICKS.get()), blockTexture(ModBlocks.MOSSY_MARBLE_BRICKS.get()));

        blockItem(ModBlocks.MARBLE_SLAB);
        blockItem(ModBlocks.POLISHED_MARBLE_SLAB);
        blockItem(ModBlocks.SMOOTH_MARBLE_SLAB);
        blockItem(ModBlocks.MARBLE_BRICKS_SLAB);
        blockItem(ModBlocks.CRACKED_MARBLE_BRICKS_SLAB);
        blockItem(ModBlocks.MOSSY_MARBLE_BRICKS_SLAB);

        wallBlock(ModBlocks.MARBLE_WALL.get(), blockTexture(ModBlocks.MARBLE.get()));
        wallBlock(ModBlocks.POLISHED_MARBLE_WALL.get(), blockTexture(ModBlocks.POLISHED_MARBLE.get()));
        wallBlock(ModBlocks.SMOOTH_MARBLE_WALL.get(), blockTexture(ModBlocks.SMOOTH_MARBLE.get()));
        wallBlock(ModBlocks.MARBLE_BRICKS_WALL.get(), blockTexture(ModBlocks.MARBLE_BRICKS.get()));
        wallBlock(ModBlocks.CRACKED_MARBLE_BRICKS_WALL.get(), blockTexture(ModBlocks.CRACKED_MARBLE_BRICKS.get()));
        wallBlock(ModBlocks.MOSSY_MARBLE_BRICKS_WALL.get(), blockTexture(ModBlocks.MOSSY_MARBLE_BRICKS.get()));

        buttonBlock(ModBlocks.MARBLE_BUTTON.get(), blockTexture(ModBlocks.MARBLE.get()));
        pressurePlateBlock(ModBlocks.MARBLE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.MARBLE.get()));
        blockItem(ModBlocks.MARBLE_PRESSURE_PLATE);

        doorBlockWithRenderType(ModBlocks.TORRID_STEEL_DOOR.get(), modLoc("block/torrid_steel_door_bottom"), modLoc("block/torrid_steel_door_top"), "translucent");
        trapdoorBlockWithRenderType(ModBlocks.TORRID_STEEL_TRAPDOOR.get(), modLoc("block/torrid_steel_trapdoor"), true , "translucent");
        blockItem(ModBlocks.TORRID_STEEL_TRAPDOOR, "_bottom");
        doorBlockWithRenderType(ModBlocks.TORRID_STEEL_BARS_DOOR.get(), modLoc("block/torrid_steel_bars_door_bottom"), modLoc("block/torrid_steel_bars_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.TORRID_STEEL_BARS_TRAPDOOR.get(), modLoc("block/torrid_steel_bars_trapdoor"), true , "cutout");
        blockItem(ModBlocks.TORRID_STEEL_BARS_TRAPDOOR, "_bottom");
        buttonBlock(ModBlocks.TORRID_STEEL_BUTTON.get(), blockTexture(ModBlocks.TORRID_STEEL_BLOCK.get()));
        pressurePlateBlock(ModBlocks.TORRID_STEEL_PRESSURE_PLATE.get(), blockTexture(ModBlocks.TORRID_STEEL_BLOCK.get()));
        blockItem(ModBlocks.TORRID_STEEL_PRESSURE_PLATE);

        blockWithItem(ModBlocks.EBONY_PLANKS);
        stairsBlock(ModBlocks.EBONY_STAIRS.get(), blockTexture(ModBlocks.EBONY_PLANKS.get()));
        blockItem(ModBlocks.EBONY_STAIRS);
        slabBlock(ModBlocks.EBONY_SLAB.get(), blockTexture(ModBlocks.EBONY_PLANKS.get()), blockTexture(ModBlocks.EBONY_PLANKS.get()));
        blockItem(ModBlocks.EBONY_SLAB);
        fenceBlock(ModBlocks.EBONY_FENCE.get(), blockTexture(ModBlocks.EBONY_PLANKS.get()));
        fenceGateBlock(ModBlocks.EBONY_FENCE_GATE.get(), blockTexture(ModBlocks.EBONY_PLANKS.get()));
        blockItem(ModBlocks.EBONY_FENCE_GATE);
        doorBlockWithRenderType(ModBlocks.EBONY_DOOR.get(), modLoc("block/ebony_door_bottom"), modLoc("block/ebony_door_top"), "translucent");
        trapdoorBlockWithRenderType( ModBlocks.EBONY_TRAPDOOR.get(), modLoc("block/ebony_trapdoor"), true , "translucent");
        blockItem(ModBlocks.EBONY_TRAPDOOR, "_bottom");
        buttonBlock(ModBlocks.EBONY_BUTTON.get(), blockTexture(ModBlocks.EBONY_PLANKS.get()));
        pressurePlateBlock(ModBlocks.EBONY_PRESSURE_PLATE.get(), blockTexture(ModBlocks.EBONY_PLANKS.get()));
        blockItem(ModBlocks.EBONY_PRESSURE_PLATE);

        signBlock(((StandingSignBlock) ModBlocks.EBONY_SIGN.get()), ((WallSignBlock) ModBlocks.EBONY_WALL_SIGN.get()), blockTexture(ModBlocks.EBONY_PLANKS.get()));
        hangingSignBlock((CeilingHangingSignBlock) ModBlocks.EBONY_HANGING_SIGN.get(), (WallHangingSignBlock) ModBlocks.EBONY_WALL_HANGING_SIGN.get(), blockTexture(ModBlocks.EBONY_PLANKS.get()));

//        horizontalBlock(ModBlocks.GEM_CUTTING_STATION.get(), new ModelFile.UncheckedModelFile(modLoc("block/gem_cutting_station")));
//        horizontalBlock(ModBlocks.GEM_INFUSER.get(), new ModelFile.UncheckedModelFile(modLoc("block/gem_infuser")));
//        horizontalBlock(ModBlocks.TORRID_FURNACE.get(), new ModelFile.UncheckedModelFile(modLoc("block/torrid_furnace")));
//        horizontalBlock(ModBlocks.KETTLE.get(), new ModelFile.UncheckedModelFile(modLoc("block/kettle")));

        horizontalBlock(ModBlocks.RED_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/red_bouncer_block")));
        horizontalBlock(ModBlocks.ORANGE_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/orange_bouncer_block")));
        horizontalBlock(ModBlocks.YELLOW_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/yellow_bouncer_block")));
        horizontalBlock(ModBlocks.LIME_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/lime_bouncer_block")));
        horizontalBlock(ModBlocks.GREEN_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/green_bouncer_block")));
        horizontalBlock(ModBlocks.CYAN_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/cyan_bouncer_block")));
        horizontalBlock(ModBlocks.LIGHT_BLUE_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/light_blue_bouncer_block")));
        horizontalBlock(ModBlocks.BLUE_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/blue_bouncer_block")));
        horizontalBlock(ModBlocks.PURPLE_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/purple_bouncer_block")));
        horizontalBlock(ModBlocks.MAGENTA_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/magenta_bouncer_block")));
        horizontalBlock(ModBlocks.PINK_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/pink_bouncer_block")));
        horizontalBlock(ModBlocks.BROWN_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/brown_bouncer_block")));
        horizontalBlock(ModBlocks.GRAY_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/gray_bouncer_block")));
        horizontalBlock(ModBlocks.LIGHT_GRAY_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/light_gray_bouncer_block")));
        horizontalBlock(ModBlocks.WHITE_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/white_bouncer_block")));
        horizontalBlock(ModBlocks.BLACK_BOUNCER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/black_bouncer_block")));
        horizontalBlock(ModBlocks.SPEEDER_BLOCK.get(), new ModelFile.UncheckedModelFile(modLoc("block/speeder_block")));

        logBlock(((RotatedPillarBlock) ModBlocks.EBONY_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.EBONY_WOOD.get()), blockTexture(ModBlocks.EBONY_LOG.get()), blockTexture(ModBlocks.EBONY_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_EBONY_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_EBONY_WOOD.get()), blockTexture(ModBlocks.STRIPPED_EBONY_LOG.get()), blockTexture(ModBlocks.STRIPPED_EBONY_LOG.get()));

        blockItem(ModBlocks.EBONY_LOG);
        blockItem(ModBlocks.EBONY_WOOD);
        blockItem(ModBlocks.STRIPPED_EBONY_LOG);
        blockItem(ModBlocks.STRIPPED_EBONY_WOOD);

        leavesBlock(ModBlocks.EBONY_LEAVES);
        saplingBlock(ModBlocks.EBONY_SAPLING);

        saplingBlock(ModBlocks.TORRID_BUSH);

//        simpleBlock(ModBlocks.TORRID_BUSH.get(), models().cross(blockTexture(ModBlocks.TORRID_BUSH.get()).getPath(),
//                blockTexture(ModBlocks.TORRID_BUSH.get())).renderType("cutout"));
        simpleBlock(ModBlocks.POTTED_TORRID_BUSH.get(), models().singleTexture("potted_torrid_bush", ResourceLocation.parse("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.TORRID_BUSH.get())).renderType("cutout"));
//        simpleBlock(ModBlocks.EBONY_SAPLING.get(), models().cross(blockTexture(ModBlocks.EBONY_SAPLING.get()).getPath(),
//                blockTexture(ModBlocks.EBONY_SAPLING.get())).renderType("cutout"));
        simpleBlock(ModBlocks.POTTED_EBONY_SAPLING.get(), models().singleTexture("potted_ebony_sapling", ResourceLocation.parse("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.EBONY_SAPLING.get())).renderType("cutout"));
    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("unwanted:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("unwanted:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
