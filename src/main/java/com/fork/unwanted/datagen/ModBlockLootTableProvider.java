package com.fork.unwanted.datagen;

import com.fork.unwanted.items.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import com.fork.unwanted.blocks.ModBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.RUBY_BLOCK.get());
        dropSelf(ModBlocks.EMBARIUM_BLOCK.get());
        dropSelf(ModBlocks.TORRID_STEEL_BLOCK.get());
        dropSelf(ModBlocks.TORRID_STEEL_BARS.get());
        dropSelf(ModBlocks.PROFUNDIUM_BLOCK.get());

        dropSelf(ModBlocks.SMOOTH_MARBLE.get());
        dropSelf(ModBlocks.POLISHED_MARBLE.get());
        dropSelf(ModBlocks.MARBLE_BRICKS.get());
        dropSelf(ModBlocks.CRACKED_MARBLE_BRICKS.get());
        dropSelf(ModBlocks.MOSSY_MARBLE_BRICKS.get());
        dropSelf(ModBlocks.CHISELED_C_MARBLE.get());
        dropSelf(ModBlocks.CHISELED_S_MARBLE.get());
        dropSelf(ModBlocks.CHISELED_W_MARBLE.get());
        dropSelf(ModBlocks.CHISELED_E_MARBLE.get());
        dropSelf(ModBlocks.MARBLE_PILLAR.get());

        dropSelf(ModBlocks.SMOOTH_MARBLE_STAIRS.get());
        dropSelf(ModBlocks.POLISHED_MARBLE_STAIRS.get());
        dropSelf(ModBlocks.MARBLE_BRICKS_STAIRS.get());
        dropSelf(ModBlocks.CRACKED_MARBLE_BRICKS_STAIRS.get());
        dropSelf(ModBlocks.MOSSY_MARBLE_BRICKS_STAIRS.get());

        dropSelf(ModBlocks.SMOOTH_MARBLE_WALL.get());
        dropSelf(ModBlocks.POLISHED_MARBLE_WALL.get());
        dropSelf(ModBlocks.MARBLE_BRICKS_WALL.get());
        dropSelf(ModBlocks.CRACKED_MARBLE_BRICKS_WALL.get());
        dropSelf(ModBlocks.MOSSY_MARBLE_BRICKS_WALL.get());

        dropSelf(ModBlocks.RED_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.ORANGE_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.YELLOW_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.LIME_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.GREEN_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.LIGHT_BLUE_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.CYAN_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.BLUE_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.PINK_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.MAGENTA_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.PURPLE_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.LIGHT_GRAY_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.GRAY_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.BROWN_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.BLACK_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.WHITE_BOUNCER_BLOCK.get());
        dropSelf(ModBlocks.SPEEDER_BLOCK.get());

        add(ModBlocks.RUBY_ORE.get(),
                (block -> createRubyOreDrops(ModBlocks.RUBY_ORE.get(), ModItems.ROUGH_RUBY.get())));
        add(ModBlocks.TORRID_STEEL_ORE.get(),
                (block -> createTorridOreDrops(ModBlocks.TORRID_STEEL_ORE.get(), ModItems.TORRID_STEEL_NUGGET.get())));
        add(ModBlocks.EMBARIUM_ORE.get(),
                (block -> createEmbariumOreDrops(ModBlocks.EMBARIUM_ORE.get(), ModItems.EMBARIUM.get())));
        add(ModBlocks.DEEPSLATE_EMBARIUM_ORE.get(),
                (block -> createEmbariumOreDrops(ModBlocks.DEEPSLATE_EMBARIUM_ORE.get(), ModItems.EMBARIUM.get())));
        dropSelf(ModBlocks.PROFUNDIUM_ORE.get());

        add(ModBlocks.MARBLE.get(),
                (block -> createOreDrop(ModBlocks.MARBLE.get(), ModItems.MARBLE_SHARD.get())));
        add(ModBlocks.MARBLE_WALL.get(),
                (block -> createSingleItemTableWithSilkTouch(ModBlocks.MARBLE_WALL.get(), ModItems.MARBLE_SHARD.get(), ConstantValue.exactly(2.0F))));
        add(ModBlocks.MARBLE_STAIRS.get(),
                (block -> createSingleItemTableWithSilkTouch(ModBlocks.MARBLE_STAIRS.get(), ModItems.MARBLE_SHARD.get(), ConstantValue.exactly(2.0F))));
//        add(ModBlocks.MARBLE_SLAB.get(),
//                (block -> createSingleItemTableWithSilkTouch(ModBlocks.MARBLE_SLAB.get(), ModItems.MARBLE_SHARD.get(), ConstantValue.exactly(1.0F))));
//
//        add(ModBlocks.MARBLE_SLAB.get(),
//                (block -> createSlabItemTable(ModBlocks.MARBLE_SLAB.get())));

        add(ModBlocks.MARBLE_SLAB.get(),
                (block -> createSoftSLabDrop(ModBlocks.MARBLE_SLAB.get(), ModItems.MARBLE_SHARD.get())));

//        createSoftSLabDrop(ModBlocks.MARBLE_SLAB.get(), ModItems.MARBLE_SHARD.get());

        add(ModBlocks.EBONY_SLAB.get(),
                (block -> createSlabItemTable(ModBlocks.EBONY_SLAB.get())));
        add(ModBlocks.SMOOTH_MARBLE_SLAB.get(),
                (block -> createSlabItemTable(ModBlocks.SMOOTH_MARBLE_SLAB.get())));
        add(ModBlocks.POLISHED_MARBLE_SLAB.get(),
                (block -> createSlabItemTable(ModBlocks.POLISHED_MARBLE_SLAB.get())));
        add(ModBlocks.MARBLE_BRICKS_SLAB.get(),
                (block -> createSlabItemTable(ModBlocks.MARBLE_BRICKS_SLAB.get())));
        add(ModBlocks.MOSSY_MARBLE_BRICKS_SLAB.get(),
                (block -> createSlabItemTable(ModBlocks.MOSSY_MARBLE_BRICKS_SLAB.get())));
        add(ModBlocks.CRACKED_MARBLE_BRICKS_SLAB.get(),
                (block -> createSlabItemTable(ModBlocks.CRACKED_MARBLE_BRICKS_SLAB.get())));

        add(ModBlocks.TORRID_STEEL_DOOR.get(),
                (block -> createDoorTable(ModBlocks.TORRID_STEEL_DOOR.get())));
        add(ModBlocks.TORRID_STEEL_BARS_DOOR.get(),
                (block -> createDoorTable(ModBlocks.TORRID_STEEL_BARS_DOOR.get())));
        add(ModBlocks.EBONY_DOOR.get(),
                (block -> createDoorTable(ModBlocks.EBONY_DOOR.get())));

        dropSelf(ModBlocks.TORRID_STEEL_BARS_TRAPDOOR.get());
        dropSelf(ModBlocks.TORRID_STEEL_TRAPDOOR.get());
        dropSelf(ModBlocks.EBONY_TRAPDOOR.get());
        dropSelf(ModBlocks.MARBLE_BUTTON.get());
        dropSelf(ModBlocks.TORRID_STEEL_BUTTON.get());
        dropSelf(ModBlocks.EBONY_BUTTON.get());
        dropSelf(ModBlocks.TORRID_STEEL_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.MARBLE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.EBONY_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.EBONY_FENCE.get());
        dropSelf(ModBlocks.EBONY_FENCE_GATE.get());

        dropSelf(ModBlocks.EBONY_PLANKS.get());
        dropSelf(ModBlocks.EBONY_LOG.get());
        dropSelf(ModBlocks.STRIPPED_EBONY_LOG.get());
        dropSelf(ModBlocks.EBONY_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_EBONY_WOOD.get());
        dropSelf(ModBlocks.EBONY_STAIRS.get());
        dropSelf(ModBlocks.EBONY_SAPLING.get());

        add(ModBlocks.TORRID_BUSH.get(),
                (block -> createSingleItemTableWithSilkTouch(ModBlocks.TORRID_BUSH.get(), ModItems.TORRID_STEEL_POWDER.get(), ConstantValue.exactly(2.0F))));

//        dropSelf(ModBlocks.GEM_CUTTING_STATION.get());
//        dropSelf(ModBlocks.GEM_INFUSER.get());
//        dropSelf(ModBlocks.TORRID_FURNACE.get());
//        dropSelf(ModBlocks.KETTLE.get());


        add(ModBlocks.POTTED_TORRID_BUSH.get(),
                (block -> createPotFlowerItemTable(ModBlocks.TORRID_BUSH.get())));
        add(ModBlocks.POTTED_EBONY_SAPLING.get(),
                (block -> createPotFlowerItemTable(ModBlocks.EBONY_SAPLING.get())));

        add(ModBlocks.EMBARIUM_LAMP_BLOCK.get(),
                (block -> createSingleItemTableWithSilkTouch(ModBlocks.EMBARIUM_LAMP_BLOCK.get(), Blocks.GLASS)));

        add(ModBlocks.EBONY_LEAVES.get(),
                (block -> createLeavesDrops(ModBlocks.EBONY_LEAVES.get(), ModBlocks.EBONY_SAPLING.get(), 0.2f))); // replace w EBONY_SAPLING
//
//        add(ModBlocks.EBONY_SIGN.get(), block ->
//                createSingleItemTable(ModItems.EBONY_SIGN.get()));
//        add(ModBlocks.EBONY_WALL_SIGN.get(), block ->
//                createSingleItemTable(ModItems.EBONY_SIGN.get()));
//        add(ModBlocks.EBONY_HANGING_SIGN.get(), block ->
//                createSingleItemTable(ModItems.EBONY_HANGING_SIGN.get()));
//        add(ModBlocks.EBONY_WALL_HANGING_SIGN.get(), block ->
//                createSingleItemTable(ModItems.EBONY_HANGING_SIGN.get()));


    }

    protected LootTable.Builder createRubyOreDrops(Block block, Item item) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }


    protected LootTable.Builder createEmbariumOreDrops(Block block, Item item) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.EFFICIENCY)))));
    }

    protected LootTable.Builder createTorridOreDrops(Block block, Item item) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(5.0F, 11.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    protected static LootTable.Builder SilkTouchableSlabDrop (Block block, LootItemCondition.Builder enchant, LootPoolEntryContainer.Builder<?> other) {
        return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(block).when(enchant).otherwise(other))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE)))));
    }

    protected LootTable.Builder createSoftSLabDrop(Block block, ItemLike item) {
        return SilkTouchableSlabDrop(block, this.hasSilkTouch(), LootItem.lootTableItem(item));
    }

    protected LootTable.Builder createMultipleOreDrops(Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
