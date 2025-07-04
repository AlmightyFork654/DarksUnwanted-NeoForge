package com.fork.unwanted.datagen;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.blocks.ModBlocks;
import com.fork.unwanted.misc.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Unwanted.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(ModTags.Blocks.EBONY_LOGS)
                .add(ModBlocks.EBONY_LOG.get(),
                        ModBlocks.EBONY_WOOD.get(),
                        ModBlocks.STRIPPED_EBONY_WOOD.get(),
                        ModBlocks.STRIPPED_EBONY_LOG.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(ModTags.Blocks.EBONY_LOGS)
                .add(ModBlocks.EBONY_PLANKS.get(),
                    ModBlocks.EBONY_SLAB.get(),
                    ModBlocks.EBONY_STAIRS.get(),
                    ModBlocks.EBONY_FENCE.get(),
                    ModBlocks.EBONY_FENCE_GATE.get(),
                    ModBlocks.EBONY_DOOR.get(),
                    ModBlocks.EBONY_TRAPDOOR.get(),
                    ModBlocks.EBONY_PRESSURE_PLATE.get(),
                    ModBlocks.EBONY_BUTTON.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RUBY_ORE.get(),
                        ModBlocks.EMBARIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_EMBARIUM_ORE.get(),
                        ModBlocks.TORRID_STEEL_ORE.get(),
                        ModBlocks.PROFUNDIUM_ORE.get(),
                        ModBlocks.RUBY_BLOCK.get(),
                        ModBlocks.EMBARIUM_BLOCK.get(),
                        ModBlocks.EMBARIUM_LAMP_BLOCK.get(),
                        ModBlocks.PROFUNDIUM_BLOCK.get(),
                        ModBlocks.TORRID_STEEL_BLOCK.get(),
                        ModBlocks.TORRID_STEEL_BARS.get(),
                        ModBlocks.MARBLE.get(),
                      ModBlocks.MARBLE_WALL.get(),
                        ModBlocks.MARBLE_STAIRS.get(),
                        ModBlocks.MARBLE_SLAB.get(),
                        ModBlocks.MARBLE_PILLAR.get(),
                        ModBlocks.POLISHED_MARBLE.get(),
                      ModBlocks.POLISHED_MARBLE_WALL.get(),
                        ModBlocks.POLISHED_MARBLE_STAIRS.get(),
                        ModBlocks.POLISHED_MARBLE_SLAB.get(),
                        ModBlocks.SMOOTH_MARBLE.get(),
                      ModBlocks.SMOOTH_MARBLE_WALL.get(),
                        ModBlocks.SMOOTH_MARBLE_SLAB.get(),
                        ModBlocks.SMOOTH_MARBLE_STAIRS.get(),
                        ModBlocks.MARBLE_BRICKS.get(),
                      ModBlocks.MARBLE_BRICKS_WALL.get(),
                        ModBlocks.MARBLE_BRICKS_SLAB.get(),
                        ModBlocks.MARBLE_BRICKS_STAIRS.get(),
                        ModBlocks.CRACKED_MARBLE_BRICKS.get(),
                      ModBlocks.CRACKED_MARBLE_BRICKS_WALL.get(),
                        ModBlocks.CRACKED_MARBLE_BRICKS_SLAB.get(),
                        ModBlocks.CRACKED_MARBLE_BRICKS_STAIRS.get(),
                        ModBlocks.MOSSY_MARBLE_BRICKS.get(),
                      ModBlocks.MOSSY_MARBLE_BRICKS_WALL.get(),
                        ModBlocks.MOSSY_MARBLE_BRICKS_SLAB.get(),
                        ModBlocks.MOSSY_MARBLE_BRICKS_STAIRS.get(),
                        ModBlocks.CHISELED_C_MARBLE.get(),
                        ModBlocks.CHISELED_E_MARBLE.get(),
                        ModBlocks.CHISELED_S_MARBLE.get(),
                        ModBlocks.CHISELED_W_MARBLE.get(),
                        ModBlocks.SPEEDER_BLOCK.get(),
                        ModBlocks.TORRID_FURNACE.get(),
                        ModBlocks.GEM_INFUSER.get(),
                        ModBlocks.GEM_CUTTING_STATION.get(),
                        ModBlocks.KETTLE.get(),
                        ModBlocks.MARBLE_BUTTON.get(),
                        ModBlocks.MARBLE_PRESSURE_PLATE.get(),
                        ModBlocks.TORRID_STEEL_DOOR.get(),
                        ModBlocks.TORRID_STEEL_BARS_DOOR.get(),
                        ModBlocks.TORRID_STEEL_TRAPDOOR.get(),
                        ModBlocks.TORRID_STEEL_BARS_TRAPDOOR.get(),
                        ModBlocks.TORRID_STEEL_BUTTON.get(),
                        ModBlocks.TORRID_STEEL_PRESSURE_PLATE.get());

        this.tag(Tags.Blocks.ORES)
                .add(ModBlocks.RUBY_ORE.get(),
                        ModBlocks.EMBARIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_EMBARIUM_ORE.get(),
                        ModBlocks.TORRID_STEEL_ORE.get(),
                        ModBlocks.PROFUNDIUM_ORE.get());

        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.EBONY_PRESSURE_PLATE.get());
        this.tag(BlockTags.STONE_PRESSURE_PLATES).add(ModBlocks.MARBLE_PRESSURE_PLATE.get(), ModBlocks.TORRID_STEEL_PRESSURE_PLATE.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(ModBlocks.EBONY_BUTTON.get());
        this.tag(BlockTags.STONE_BUTTONS).add(ModBlocks.MARBLE_BUTTON.get(), ModBlocks.TORRID_STEEL_BUTTON.get());
        this.tag(BlockTags.DOORS).add(ModBlocks.TORRID_STEEL_BARS_DOOR.get(), ModBlocks.TORRID_STEEL_DOOR.get());
        this.tag(BlockTags.WOODEN_DOORS).add(ModBlocks.EBONY_DOOR.get());
        this.tag(BlockTags.TRAPDOORS).add(ModBlocks.TORRID_STEEL_BARS_TRAPDOOR.get(), ModBlocks.TORRID_STEEL_TRAPDOOR.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.EBONY_TRAPDOOR.get());

        this.tag(BlockTags.LOGS).addTag(ModTags.Blocks.EBONY_LOGS);
        this.tag(BlockTags.LOGS_THAT_BURN).addTag(ModTags.Blocks.EBONY_LOGS);

        this.tag(BlockTags.PLANKS).add(ModBlocks.EBONY_PLANKS.get());
        this.tag(BlockTags.SAPLINGS).add(ModBlocks.EBONY_SAPLING.get());
        this.tag(BlockTags.SMALL_FLOWERS).add(ModBlocks.TORRID_BUSH.get());

        this.tag(BlockTags.SLABS)
                .add(ModBlocks.MARBLE_SLAB.get(),
                        ModBlocks.POLISHED_MARBLE_SLAB.get(),
                        ModBlocks.SMOOTH_MARBLE_SLAB.get(),
                        ModBlocks.MARBLE_BRICKS_SLAB.get(),
                        ModBlocks.CRACKED_MARBLE_BRICKS_SLAB.get(),
                        ModBlocks.MOSSY_MARBLE_BRICKS_SLAB.get());
        this.tag(BlockTags.STAIRS)
                .add(ModBlocks.MARBLE_STAIRS.get(),
                        ModBlocks.POLISHED_MARBLE_STAIRS.get(),
                        ModBlocks.SMOOTH_MARBLE_STAIRS.get(),
                        ModBlocks.MARBLE_BRICKS_STAIRS.get(),
                        ModBlocks.CRACKED_MARBLE_BRICKS_STAIRS.get(),
                        ModBlocks.MOSSY_MARBLE_BRICKS_STAIRS.get());

        this.tag(BlockTags.WOODEN_SLABS).add(ModBlocks.EBONY_SLAB.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(ModBlocks.EBONY_STAIRS.get());

        this.tag(BlockTags.WALLS)
                .add(ModBlocks.MARBLE_WALL.get(),
                        ModBlocks.POLISHED_MARBLE_WALL.get(),
                        ModBlocks.SMOOTH_MARBLE_WALL.get(),
                        ModBlocks.MARBLE_BRICKS_WALL.get(),
                        ModBlocks.CRACKED_MARBLE_BRICKS_WALL.get(),
                        ModBlocks.MOSSY_MARBLE_BRICKS_WALL.get());

        this.tag(BlockTags.WOODEN_FENCES).add(ModBlocks.EBONY_FENCE.get());
        this.tag(BlockTags.FENCE_GATES).add(ModBlocks.EBONY_FENCE_GATE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.RUBY_ORE.get(), ModBlocks.PROFUNDIUM_ORE.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.EMBARIUM_ORE.get(), ModBlocks.DEEPSLATE_EMBARIUM_ORE.get());
        this.tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.TORRID_STEEL_ORE.get());

        //new tags for mining...

    }
}
