package com.fork.unwanted.blocks;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.blocks.custom.BouncerBlock;
import com.fork.unwanted.blocks.custom.EmbariumLampBlock;
import com.fork.unwanted.blocks.custom.SpeederBlock;
import com.fork.unwanted.items.ModItems;
import com.fork.unwanted.sfx.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Unwanted.MOD_ID);

    //blocks

        //ores

    public static final DeferredBlock<DropExperienceBlock> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)
                    .strength(6f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<DropExperienceBlock> TORRID_STEEL_ORE = registerBlock("torrid_steel_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)
                    .strength(6f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<DropExperienceBlock> EMBARIUM_ORE = registerBlock("embarium_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(6f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_EMBARIUM_ORE = registerBlock("deepslate_embarium_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)
                    .strength(6f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<DropExperienceBlock> PROFUNDIUM_ORE = registerBlock("profundium_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 7), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)
                    .strength(6f).requiresCorrectToolForDrops()));

    //block

    public static final DeferredBlock<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_BLOCK).sound(SoundType.METAL).strength(5F, 6F).destroyTime(8).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> TORRID_STEEL_BLOCK = registerBlock("torrid_steel_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.METAL).strength(5F, 6F).destroyTime(8).requiresCorrectToolForDrops()));

    public static final DeferredBlock<IronBarsBlock> TORRID_STEEL_BARS = registerBlock("torrid_steel_bars",
            () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BARS).sound(SoundType.METAL).strength(5F, 6F).destroyTime(5).requiresCorrectToolForDrops().noOcclusion()));

    public static final DeferredBlock<Block> EMBARIUM_BLOCK = registerBlock("embarium_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).sound(ModSounds.EMBARIUM_SOUNDS)
                    .strength(0.3F, 0.3F).destroyTime(3).requiresCorrectToolForDrops().lightLevel((blockState) -> 8).noOcclusion()));

    public static final DeferredBlock<Block> PROFUNDIUM_BLOCK = registerBlock("profundium_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).sound(SoundType.METAL).strength(50F, 50F).destroyTime(10)));

    public static final DeferredBlock<Block> EMBARIUM_LAMP_BLOCK = registerBlock("embarium_lamp_block",
            () -> new EmbariumLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.REDSTONE_LAMP).sound(SoundType.AMETHYST_CLUSTER)
                    .strength(0.3F, 0.3F).destroyTime(3).requiresCorrectToolForDrops().lightLevel((blockState) -> blockState.getValue(EmbariumLampBlock.CLICKED) ? 15 : 0)));

    //crafting

//    public static final DeferredBlock<Block> GEM_CUTTING_STATION = registerBlock("gem_cutting_station",
//            () -> new GemCuttingStationBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SMITHING_TABLE).noOcclusion()));
//
//    public static final DeferredBlock<Block> GEM_INFUSER = BLOCKS.register("gem_infuser",
//            ()-> new GemInfuserBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SMITHING_TABLE).noOcclusion()));
//
//    public static final DeferredBlock<Block> TORRID_FURNACE = registerBlock("torrid_furnace",
//            () -> new TorridFurnaceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SMITHING_TABLE).noOcclusion()));
//
//    public static final DeferredBlock<Block> KETTLE = registerBlock("kettle",
//            () -> new KettleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SMITHING_TABLE).noOcclusion()));

    //bouncy

    public static final DeferredBlock<Block> WHITE_BOUNCER_BLOCK = registerBlock("white_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final DeferredBlock<Block> BLACK_BOUNCER_BLOCK = registerBlock("black_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final DeferredBlock<Block> GRAY_BOUNCER_BLOCK = registerBlock("gray_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final DeferredBlock<Block> LIGHT_GRAY_BOUNCER_BLOCK = registerBlock("light_gray_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final DeferredBlock<Block> BROWN_BOUNCER_BLOCK = registerBlock("brown_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final DeferredBlock<Block> BLUE_BOUNCER_BLOCK = registerBlock("blue_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final DeferredBlock<Block> CYAN_BOUNCER_BLOCK = registerBlock("cyan_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final DeferredBlock<Block> LIGHT_BLUE_BOUNCER_BLOCK = registerBlock("light_blue_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final DeferredBlock<Block> GREEN_BOUNCER_BLOCK = registerBlock("green_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final DeferredBlock<Block> LIME_BOUNCER_BLOCK = registerBlock("lime_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final DeferredBlock<Block> MAGENTA_BOUNCER_BLOCK = registerBlock("magenta_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final DeferredBlock<Block> ORANGE_BOUNCER_BLOCK = registerBlock("orange_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final DeferredBlock<Block> PINK_BOUNCER_BLOCK = registerBlock("pink_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final DeferredBlock<Block> PURPLE_BOUNCER_BLOCK = registerBlock("purple_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final DeferredBlock<Block> RED_BOUNCER_BLOCK = registerBlock("red_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));
    public static final DeferredBlock<Block> YELLOW_BOUNCER_BLOCK = registerBlock("yellow_bouncer_block",
            () -> new BouncerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 1F).friction(0.5F).destroyTime(1).instabreak().dynamicShape()));

    public static final DeferredBlock<Block> SPEEDER_BLOCK = registerBlock("speeder_block",
            () -> new SpeederBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPONGE).sound(SoundType.SLIME_BLOCK).strength(1F, 3F).friction(1.0F)));

    //marble
    public static final DeferredBlock<Block> MARBLE = registerBlock("marble",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> SMOOTH_MARBLE = registerBlock("smooth_marble",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DOUBLE_SMOOTH_MARBLE_SLAB = registerBlock("double_smooth_marble_slab",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops().noLootTable()));
    public static final DeferredBlock<Block> POLISHED_MARBLE = registerBlock("polished_marble",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DOUBLE_POLISHED_MARBLE_SLAB = registerBlock("double_polished_marble_slab",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops().noLootTable()));

    public static final DeferredBlock<Block> MARBLE_BRICKS = registerBlock("marble_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> CRACKED_MARBLE_BRICKS = registerBlock("cracked_marble_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> MOSSY_MARBLE_BRICKS = registerBlock("mossy_marble_bricks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));

//    public static final DeferredBlock<Block> CHISELED_W_MARBLE = registerBlock("chiseled_w_marble",
//            () -> new SimpleRotateableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> CHISELED_S_MARBLE = registerBlock("chiseled_s_marble",
//            () -> new SimpleRotateableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> CHISELED_C_MARBLE = registerBlock("chiseled_c_marble",
//            () -> new SimpleRotateableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));
//    public static final DeferredBlock<Block> CHISELED_E_MARBLE = registerBlock("chiseled_e_marble",
//            () -> new SimpleRotateableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));

    public static final DeferredBlock<RotatedPillarBlock> MARBLE_PILLAR = registerBlock("marble_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));

    //marble stairs
    public static final DeferredBlock<StairBlock> MARBLE_STAIRS = registerBlock("marble_stairs",
            () -> new StairBlock(ModBlocks.MARBLE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));
    public static final DeferredBlock<StairBlock> SMOOTH_MARBLE_STAIRS = registerBlock("smooth_marble_stairs",
            () -> new StairBlock(ModBlocks.SMOOTH_MARBLE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));
    public static final DeferredBlock<StairBlock> POLISHED_MARBLE_STAIRS = registerBlock("polished_marble_stairs",
            () -> new StairBlock(ModBlocks.POLISHED_MARBLE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));
    public static final DeferredBlock<StairBlock> MARBLE_BRICKS_STAIRS = registerBlock("marble_bricks_stairs",
            () -> new StairBlock(ModBlocks.MARBLE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));
    public static final DeferredBlock<StairBlock> CRACKED_MARBLE_BRICKS_STAIRS = registerBlock("cracked_marble_bricks_stairs",
            () -> new StairBlock(ModBlocks.CRACKED_MARBLE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(1).requiresCorrectToolForDrops()));
    public static final DeferredBlock<StairBlock> MOSSY_MARBLE_BRICKS_STAIRS = registerBlock("mossy_marble_bricks_stairs",
            () -> new StairBlock(ModBlocks.MOSSY_MARBLE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));

    //marble slabs
    public static final DeferredBlock<SlabBlock> MARBLE_SLAB = registerBlock("marble_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));
    public static final DeferredBlock<SlabBlock> SMOOTH_MARBLE_SLAB = registerBlock("smooth_marble_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));
    public static final DeferredBlock<SlabBlock> POLISHED_MARBLE_SLAB = registerBlock("polished_marble_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));
    public static final DeferredBlock<SlabBlock> MARBLE_BRICKS_SLAB = registerBlock("marble_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));
    public static final DeferredBlock<SlabBlock> CRACKED_MARBLE_BRICKS_SLAB = registerBlock("cracked_marble_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(1).requiresCorrectToolForDrops()));
    public static final DeferredBlock<SlabBlock> MOSSY_MARBLE_BRICKS_SLAB = registerBlock("mossy_marble_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));

    //marble walls
    public static final DeferredBlock<WallBlock> MARBLE_WALL = registerBlock("marble_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));
    public static final DeferredBlock<WallBlock> SMOOTH_MARBLE_WALL = registerBlock("smooth_marble_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));
    public static final DeferredBlock<WallBlock> POLISHED_MARBLE_WALL = registerBlock("polished_marble_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(3).requiresCorrectToolForDrops()));
    public static final DeferredBlock<WallBlock> MARBLE_BRICKS_WALL = registerBlock("marble_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));
    public static final DeferredBlock<WallBlock> CRACKED_MARBLE_BRICKS_WALL = registerBlock("cracked_marble_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(1).requiresCorrectToolForDrops()));
    public static final DeferredBlock<WallBlock> MOSSY_MARBLE_BRICKS_WALL = registerBlock("mossy_marble_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE).strength(1.5F, 6F).destroyTime(2).requiresCorrectToolForDrops()));

    // non-blocks

    //doors

    public static final DeferredBlock<Block> TORRID_STEEL_DOOR = registerBlock("torrid_steel_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR).sound(SoundType.METAL)
                    .strength(5F, 6F).destroyTime(32).noOcclusion()));
    public static final DeferredBlock<Block> TORRID_STEEL_BARS_DOOR = registerBlock("torrid_steel_bars_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR).sound(SoundType.METAL)
                    .strength(5F, 6F).destroyTime(16).noOcclusion()));

    //trapdoors

    public static final DeferredBlock<Block> TORRID_STEEL_TRAPDOOR = registerBlock("torrid_steel_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_TRAPDOOR).sound(SoundType.METAL)
                    .strength(5F, 6F).destroyTime(32).noOcclusion()));
    public static final DeferredBlock<Block> TORRID_STEEL_BARS_TRAPDOOR = registerBlock("torrid_steel_bars_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR).sound(SoundType.METAL)
                    .strength(5F, 6F).destroyTime(16).noOcclusion()));

    //buttons

    public static final DeferredBlock<ButtonBlock> TORRID_STEEL_BUTTON = registerBlock("torrid_steel_button",
            () -> new ButtonBlock(BlockSetType.IRON, 40, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON).sound(SoundType.METAL)
                    .strength(5F, 6F).destroyTime(4).noCollission()));
    public static final DeferredBlock<ButtonBlock> MARBLE_BUTTON = registerBlock("marble_button",
            () -> new ButtonBlock(BlockSetType.STONE, 30, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(SoundType.STONE)
                    .strength(1.5F, 3F).destroyTime(2).noCollission()));

    //pressure plates

    public static final DeferredBlock<PressurePlateBlock> TORRID_STEEL_PRESSURE_PLATE = registerBlock("torrid_steel_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.ofFullCopy(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE)
                    .sound(SoundType.METAL).strength(5F, 6F).destroyTime(4)));
    public static final DeferredBlock<PressurePlateBlock> MARBLE_PRESSURE_PLATE = registerBlock("marble_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE)
                    .sound(SoundType.STONE).strength(1.5F, 3F).destroyTime(2)));

//nature

//    public static final DeferredBlock<Block> TORRID_BUSH = registerBlock("torrid_bush",
//            () -> new NetherFlowerBlock(MobEffects.FIRE_RESISTANCE,15 ,BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_FUNGUS).noOcclusion()));
//
//    public static final DeferredBlock<Block> POTTED_TORRID_BUSH = registerBlockWithoutBlockItem("potted_torrid_bush",
//            () -> new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, ModBlocks.TORRID_BUSH, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_WARPED_FUNGUS).noOcclusion()));

//tree

//    public static final DeferredBlock<Block> EBONY_LOG = registerBlock("ebony_log",
//            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
//
//    public static final DeferredBlock<Block> EBONY_WOOD = registerBlock("ebony_wood",
//            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
//
//    public static final DeferredBlock<Block> STRIPPED_EBONY_LOG = registerBlock("stripped_ebony_log",
//            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
//
//    public static final DeferredBlock<Block> STRIPPED_EBONY_WOOD = registerBlock("stripped_ebony_wood",
//            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> EBONY_PLANKS = registerBlock("ebony_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }
            });


    public static final DeferredBlock<Block> EBONY_LEAVES = registerBlock("ebony_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                protected boolean decaying(BlockState p_221386_) {
                    return !p_221386_.getValue(PERSISTENT) && p_221386_.getValue(DISTANCE) == 12;
                }
            });

//    public static final DeferredBlock<Block> EBONY_SAPLING = registerBlock("ebony_sapling",
//            () -> new SaplingBlock(new EbonyTreeGrower(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
//
//    public static final DeferredBlock<Block> POTTED_EBONY_SAPLING = registerBlockWithoutBlockItem("potted_ebony_sapling",
//            () -> new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, ModBlocks.EBONY_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_OAK_SAPLING).noOcclusion()));


//    ebony non-blocks

    public static final DeferredBlock<StairBlock> EBONY_STAIRS = registerBlock("ebony_stairs",
            () -> new StairBlock(ModBlocks.EBONY_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).strength(1F, 2F)));
    public static final DeferredBlock<SlabBlock> EBONY_SLAB = registerBlock("ebony_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)
                    .strength(1F, 2F)));

    public static final DeferredBlock<FenceBlock> EBONY_FENCE = registerBlock("ebony_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)
                    .strength(1F, 2F)));
    public static final DeferredBlock<FenceGateBlock> EBONY_FENCE_GATE = registerBlock("ebony_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)
                    .strength(1F, 2F)));

    public static final DeferredBlock<ButtonBlock> EBONY_BUTTON = registerBlock("ebony_button",
            () -> new ButtonBlock(BlockSetType.OAK, 20, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)
                    .strength(1F, 2F).noCollission().destroyTime(2)));
    public static final DeferredBlock<PressurePlateBlock> EBONY_PRESSURE_PLATE = registerBlock("ebony_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)
                    .strength(1F, 2F).destroyTime(2)));

    public static final DeferredBlock<DoorBlock> EBONY_DOOR = registerBlock("ebony_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)
                    .strength(1F, 2F).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> EBONY_TRAPDOOR = registerBlock("ebony_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)
                    .strength(1F, 2F).noOcclusion()));
//
//    public static final DeferredBlock<Block> EBONY_SIGN = BLOCKS.register("ebony_sign",
//            () -> new ModStandingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_SIGN), ModWoodTypes.EBONY));
//    public static final DeferredBlock<Block> EBONY_WALL_SIGN = BLOCKS.register("ebony_wall_sign",
//            () -> new ModWallSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_WALL_SIGN), ModWoodTypes.EBONY));
//    public static final DeferredBlock<Block> EBONY_HANGING_SIGN = BLOCKS.register("ebony_hanging_sign",
//            () -> new ModHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_HANGING_SIGN), ModWoodTypes.EBONY));
//    public static final DeferredBlock<Block> EBONY_WALL_HANGING_SIGN = BLOCKS.register("ebony_wall_hanging_sign",
//            () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_WALL_HANGING_SIGN), ModWoodTypes.EBONY));




    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register (IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
