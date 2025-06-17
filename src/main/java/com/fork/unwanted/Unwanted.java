package com.fork.unwanted;

import com.fork.unwanted.blocks.ModBlocks;
import com.fork.unwanted.blocks.entity.ModBlockEntities;
import com.fork.unwanted.component.ModDataComponents;
import com.fork.unwanted.entity.ModEntities;
import com.fork.unwanted.entity.client.ModBoatRenderer;
import com.fork.unwanted.items.ModCreativeModeTabs;
import com.fork.unwanted.items.ModItems;
import com.fork.unwanted.items.armor_and_tools.layers.ElytraGliderArmorStandLayer;
import com.fork.unwanted.items.armor_and_tools.layers.MechanicalElytraArmorStandLayer;
import com.fork.unwanted.items.armor_and_tools.layers.ProfundiumElytraArmorStandLayer;
import com.fork.unwanted.items.armor_and_tools.layers.ProfundiumElytraLayer;
import com.fork.unwanted.items.armor_and_tools.layers.MechanicalElytraLayer;
import com.fork.unwanted.items.armor_and_tools.layers.ElytraGliderLayer;
import com.fork.unwanted.misc.ModWoodTypes;
import com.fork.unwanted.mob_effects.ModEffects;
import com.fork.unwanted.mob_effects.ModPotions;
import com.fork.unwanted.sfx.ModSounds;
import com.fork.unwanted.worldgen.tree.custom.ModFoliagePlacers;
import com.fork.unwanted.worldgen.tree.custom.ModTrunkPlacerTypes;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Unwanted.MOD_ID)
public class Unwanted {
    public static final String MOD_ID = "unwanted";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Unwanted(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        ModDataComponents.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);
        ModFoliagePlacers.register(modEventBus);
        ModTrunkPlacerTypes.register(modEventBus);

        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::registerElytraLayer);

//        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
//        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.TORRID_BUSH.getId(), ModBlocks.POTTED_TORRID_BUSH);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.EBONY_SAPLING.getId(), ModBlocks.POTTED_EBONY_SAPLING);
        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTab() == ModCreativeModeTabs.ITEMS_TAB.get()) {
            event.accept(ModItems.ROUGH_RUBY);
            event.accept(ModItems.RUBY);
            event.accept(ModItems.PURE_RUBY);
            event.accept(ModItems.TORRID_STEEL_INGOT);
            event.accept(ModItems.TORRID_STEEL_NUGGET);
            event.accept(ModItems.TORRID_STEEL_POWDER);
            event.accept(ModItems.EMBARIUM);
            event.accept(ModItems.PROFUNDIUM_FLAKE);
            event.accept(ModItems.PROFUNDIUM_SCRAP);
            event.accept(ModItems.PROFUNDIUM_INGOT);
            event.accept(ModItems.MARBLE_SHARD);
            event.accept(ModItems.BLAZING_WATER);
            event.accept(ModItems.PURE_BLAZE_POWDER);
            event.accept(ModItems.WOODEN_SPEAR_HEAD);
            event.accept(ModItems.DARKNESS_MUSIC_DISK);
            event.accept(ModItems.CAVE_WHISPERS_MUSIC_DISK);
            event.accept(ModItems.EBONY_BOAT);
            event.accept(ModItems.EBONY_CHEST_BOAT);

//            event.accept(ModItems.TEA_CUP);
            event.accept(ModItems.CUP_OF_WATER);
//            event.accept(ModItems.GRASSY_TEA);
//            event.accept(ModItems.WARPED_TEA);
//            event.accept(ModItems.CRIMSON_TEA);
//            event.accept(ModItems.LEAVY_TEA);
//            event.accept(ModItems.KELPED_TEA);
//            event.accept(ModItems.VINEY_TEA);
//            event.accept(ModItems.GLOWY_TEA);
//            event.accept(ModItems.SCULKED_TEA);
//            event.accept(ModItems.ROOTED_TEA);
        }

        if(event.getTab() == ModCreativeModeTabs.BLOCKS_TAB.get()) {
            event.accept(ModBlocks.RUBY_ORE);
            event.accept(ModBlocks.EMBARIUM_ORE);
            event.accept(ModBlocks.DEEPSLATE_EMBARIUM_ORE);
            event.accept(ModBlocks.PROFUNDIUM_ORE);
            event.accept(ModBlocks.TORRID_STEEL_ORE);
            event.accept(ModBlocks.RUBY_BLOCK);
            event.accept(ModBlocks.EMBARIUM_BLOCK);
            event.accept(ModBlocks.PROFUNDIUM_BLOCK);
            event.accept(ModBlocks.TORRID_STEEL_BLOCK);
            event.accept(ModBlocks.TORRID_STEEL_BARS);

            event.accept(ModBlocks.MARBLE);
            event.accept(ModBlocks.SMOOTH_MARBLE);
            event.accept(ModBlocks.POLISHED_MARBLE);
            event.accept(ModBlocks.MARBLE_BRICKS);
            event.accept(ModBlocks.CRACKED_MARBLE_BRICKS);
            event.accept(ModBlocks.MOSSY_MARBLE_BRICKS);
            event.accept(ModBlocks.MARBLE_STAIRS);
            event.accept(ModBlocks.SMOOTH_MARBLE_STAIRS);
            event.accept(ModBlocks.POLISHED_MARBLE_STAIRS);
            event.accept(ModBlocks.MARBLE_BRICKS_STAIRS);
            event.accept(ModBlocks.CRACKED_MARBLE_BRICKS_STAIRS);
            event.accept(ModBlocks.MOSSY_MARBLE_BRICKS_STAIRS);
            event.accept(ModBlocks.MARBLE_SLAB);
            event.accept(ModBlocks.SMOOTH_MARBLE_SLAB);
            event.accept(ModBlocks.POLISHED_MARBLE_SLAB);
            event.accept(ModBlocks.MARBLE_BRICKS_SLAB);
            event.accept(ModBlocks.CRACKED_MARBLE_BRICKS_SLAB);
            event.accept(ModBlocks.MOSSY_MARBLE_BRICKS_SLAB);
            event.accept(ModBlocks.MARBLE_WALL);
            event.accept(ModBlocks.SMOOTH_MARBLE_WALL);
            event.accept(ModBlocks.POLISHED_MARBLE_WALL);
            event.accept(ModBlocks.MARBLE_BRICKS_WALL);
            event.accept(ModBlocks.CRACKED_MARBLE_BRICKS_WALL);
            event.accept(ModBlocks.MOSSY_MARBLE_BRICKS_WALL);
            event.accept(ModBlocks.CHISELED_C_MARBLE);
            event.accept(ModBlocks.CHISELED_S_MARBLE);
            event.accept(ModBlocks.CHISELED_W_MARBLE);
            event.accept(ModBlocks.CHISELED_E_MARBLE);
            event.accept(ModBlocks.MARBLE_PILLAR);

            event.accept(ModBlocks.EBONY_LOG);
            event.accept(ModBlocks.EBONY_WOOD);
            event.accept(ModBlocks.STRIPPED_EBONY_LOG);
            event.accept(ModBlocks.STRIPPED_EBONY_WOOD);
            event.accept(ModBlocks.EBONY_PLANKS);
            event.accept(ModBlocks.EBONY_STAIRS);
            event.accept(ModBlocks.EBONY_SLAB);
            event.accept(ModBlocks.EBONY_FENCE);
            event.accept(ModBlocks.EBONY_FENCE_GATE);
            event.accept(ModBlocks.EBONY_LEAVES);
            event.accept(ModBlocks.EBONY_SAPLING);
            event.accept(ModBlocks.TORRID_BUSH);
            event.accept(ModItems.EBONY_SIGN);
            event.accept(ModItems.EBONY_HANGING_SIGN);
            event.accept(ModBlocks.TORRID_STEEL_DOOR);
            event.accept(ModBlocks.TORRID_STEEL_TRAPDOOR);
            event.accept(ModBlocks.TORRID_STEEL_BARS_DOOR);
            event.accept(ModBlocks.TORRID_STEEL_BARS_TRAPDOOR);
            event.accept(ModBlocks.TORRID_STEEL_BUTTON);
            event.accept(ModBlocks.TORRID_STEEL_PRESSURE_PLATE);
            event.accept(ModBlocks.MARBLE_BUTTON);
            event.accept(ModBlocks.MARBLE_PRESSURE_PLATE);
            event.accept(ModBlocks.EBONY_DOOR);
            event.accept(ModBlocks.EBONY_TRAPDOOR);
            event.accept(ModBlocks.EBONY_BUTTON);
            event.accept(ModBlocks.EBONY_PRESSURE_PLATE);

            event.accept(ModBlocks.RED_BOUNCER_BLOCK);
            event.accept(ModBlocks.ORANGE_BOUNCER_BLOCK);
            event.accept(ModBlocks.YELLOW_BOUNCER_BLOCK);
            event.accept(ModBlocks.LIME_BOUNCER_BLOCK);
            event.accept(ModBlocks.GREEN_BOUNCER_BLOCK);
            event.accept(ModBlocks.LIGHT_BLUE_BOUNCER_BLOCK);
            event.accept(ModBlocks.CYAN_BOUNCER_BLOCK);
            event.accept(ModBlocks.BLUE_BOUNCER_BLOCK);
            event.accept(ModBlocks.PINK_BOUNCER_BLOCK);
            event.accept(ModBlocks.MAGENTA_BOUNCER_BLOCK);
            event.accept(ModBlocks.PURPLE_BOUNCER_BLOCK);
            event.accept(ModBlocks.LIGHT_GRAY_BOUNCER_BLOCK);
            event.accept(ModBlocks.GRAY_BOUNCER_BLOCK);
            event.accept(ModBlocks.BROWN_BOUNCER_BLOCK);
            event.accept(ModBlocks.BLACK_BOUNCER_BLOCK);
            event.accept(ModBlocks.WHITE_BOUNCER_BLOCK);
            event.accept(ModBlocks.SPEEDER_BLOCK);
            event.accept(ModBlocks.EMBARIUM_LAMP_BLOCK);
//            event.accept(ModBlocks.GEM_CUTTING_STATION);
//            event.accept(ModBlocks.GEM_INFUSER);
//            event.accept(ModBlocks.TORRID_FURNACE);
//            event.accept(ModBlocks.KETTLE);
        }



        if(event.getTab() == ModCreativeModeTabs.COMBAT_TAB.get()) {
            event.accept(ModItems.TORRID_HELMET);
            event.accept(ModItems.TORRID_CHESTPLATE);
            event.accept(ModItems.TORRID_LEGGINGS);
            event.accept(ModItems.TORRID_BOOTS);
            event.accept(ModItems.TORRID_STEEL_SWORD);
            event.accept(ModItems.TORRID_STEEL_PICKAXE);
            event.accept(ModItems.TORRID_STEEL_AXE);
            event.accept(ModItems.TORRID_STEEL_SHOVEL);
            event.accept(ModItems.TORRID_STEEL_HOE);
            event.accept(ModItems.EMBARIUM_HELMET);
            event.accept(ModItems.EMBARIUM_CHESTPLATE);
            event.accept(ModItems.EMBARIUM_LEGGINGS);
            event.accept(ModItems.EMBARIUM_BOOTS);
            event.accept(ModItems.EMBARIUM_SWORD);
            event.accept(ModItems.EMBARIUM_PICKAXE);
            event.accept(ModItems.EMBARIUM_AXE);
            event.accept(ModItems.EMBARIUM_SHOVEL);
            event.accept(ModItems.EMBARIUM_HOE);
            event.accept(ModItems.TORRID_EMBARIUM_HELMET);
            event.accept(ModItems.TORRID_EMBARIUM_CHESTPLATE);
            event.accept(ModItems.TORRID_EMBARIUM_LEGGINGS);
            event.accept(ModItems.TORRID_EMBARIUM_BOOTS);
            event.accept(ModItems.TORRID_EMBARIUM_SWORD);
            event.accept(ModItems.TORRID_EMBARIUM_PICKAXE);
            event.accept(ModItems.TORRID_EMBARIUM_AXE);
            event.accept(ModItems.TORRID_EMBARIUM_SHOVEL);
            event.accept(ModItems.TORRID_EMBARIUM_HOE);
            event.accept(ModItems.LEATHER_TORRID_HELMET);
            event.accept(ModItems.LEATHER_TORRID_CHESTPLATE);
            event.accept(ModItems.LEATHER_TORRID_LEGGINGS);
            event.accept(ModItems.LEATHER_TORRID_BOOTS);
            event.accept(ModItems.WOODEN_TORRID_SWORD);
            event.accept(ModItems.WOODEN_TORRID_PICKAXE);
            event.accept(ModItems.WOODEN_TORRID_AXE);
            event.accept(ModItems.WOODEN_TORRID_SHOVEL);
            event.accept(ModItems.WOODEN_TORRID_HOE);
            event.accept(ModItems.LEATHER_EMBARIUM_HELMET);
            event.accept(ModItems.LEATHER_EMBARIUM_CHESTPLATE);
            event.accept(ModItems.LEATHER_EMBARIUM_LEGGINGS);
            event.accept(ModItems.LEATHER_EMBARIUM_BOOTS);
            event.accept(ModItems.WOODEN_EMBARIUM_SWORD);
            event.accept(ModItems.WOODEN_EMBARIUM_PICKAXE);
            event.accept(ModItems.WOODEN_EMBARIUM_AXE);
            event.accept(ModItems.WOODEN_EMBARIUM_SHOVEL);
            event.accept(ModItems.WOODEN_EMBARIUM_HOE);
            event.accept(ModItems.LEATHER_TORRID_EMBARIUM_HELMET);
            event.accept(ModItems.LEATHER_TORRID_EMBARIUM_CHESTPLATE);
            event.accept(ModItems.LEATHER_TORRID_EMBARIUM_LEGGINGS);
            event.accept(ModItems.LEATHER_TORRID_EMBARIUM_BOOTS);
            event.accept(ModItems.WOODEN_TORRID_EMBARIUM_SWORD);
            event.accept(ModItems.WOODEN_TORRID_EMBARIUM_PICKAXE);
            event.accept(ModItems.WOODEN_TORRID_EMBARIUM_AXE);
            event.accept(ModItems.WOODEN_TORRID_EMBARIUM_SHOVEL);
            event.accept(ModItems.WOODEN_TORRID_EMBARIUM_HOE);
            event.accept(ModItems.CHAIN_TORRID_HELMET);
            event.accept(ModItems.CHAIN_TORRID_CHESTPLATE);
            event.accept(ModItems.CHAIN_TORRID_LEGGINGS);
            event.accept(ModItems.CHAIN_TORRID_BOOTS);
            event.accept(ModItems.STONE_TORRID_SWORD);
            event.accept(ModItems.STONE_TORRID_PICKAXE);
            event.accept(ModItems.STONE_TORRID_AXE);
            event.accept(ModItems.STONE_TORRID_SHOVEL);
            event.accept(ModItems.STONE_TORRID_HOE);
            event.accept(ModItems.CHAIN_EMBARIUM_HELMET);
            event.accept(ModItems.CHAIN_EMBARIUM_CHESTPLATE);
            event.accept(ModItems.CHAIN_EMBARIUM_LEGGINGS);
            event.accept(ModItems.CHAIN_EMBARIUM_BOOTS);
            event.accept(ModItems.STONE_EMBARIUM_SWORD);
            event.accept(ModItems.STONE_EMBARIUM_PICKAXE);
            event.accept(ModItems.STONE_EMBARIUM_AXE);
            event.accept(ModItems.STONE_EMBARIUM_SHOVEL);
            event.accept(ModItems.STONE_EMBARIUM_HOE);
            event.accept(ModItems.CHAIN_TORRID_EMBARIUM_HELMET);
            event.accept(ModItems.CHAIN_TORRID_EMBARIUM_CHESTPLATE);
            event.accept(ModItems.CHAIN_TORRID_EMBARIUM_LEGGINGS);
            event.accept(ModItems.CHAIN_TORRID_EMBARIUM_BOOTS);
            event.accept(ModItems.STONE_TORRID_EMBARIUM_SWORD);
            event.accept(ModItems.STONE_TORRID_EMBARIUM_PICKAXE);
            event.accept(ModItems.STONE_TORRID_EMBARIUM_AXE);
            event.accept(ModItems.STONE_TORRID_EMBARIUM_SHOVEL);
            event.accept(ModItems.STONE_TORRID_EMBARIUM_HOE);
            event.accept(ModItems.GOLDEN_TORRID_HELMET);
            event.accept(ModItems.GOLDEN_TORRID_CHESTPLATE);
            event.accept(ModItems.GOLDEN_TORRID_LEGGINGS);
            event.accept(ModItems.GOLDEN_TORRID_BOOTS);
            event.accept(ModItems.GOLDEN_TORRID_SWORD);
            event.accept(ModItems.GOLDEN_TORRID_PICKAXE);
            event.accept(ModItems.GOLDEN_TORRID_AXE);
            event.accept(ModItems.GOLDEN_TORRID_SHOVEL);
            event.accept(ModItems.GOLDEN_TORRID_HOE);
            event.accept(ModItems.GOLDEN_EMBARIUM_HELMET);
            event.accept(ModItems.GOLDEN_EMBARIUM_CHESTPLATE);
            event.accept(ModItems.GOLDEN_EMBARIUM_LEGGINGS);
            event.accept(ModItems.GOLDEN_EMBARIUM_BOOTS);
            event.accept(ModItems.GOLDEN_EMBARIUM_SWORD);
            event.accept(ModItems.GOLDEN_EMBARIUM_PICKAXE);
            event.accept(ModItems.GOLDEN_EMBARIUM_AXE);
            event.accept(ModItems.GOLDEN_EMBARIUM_SHOVEL);
            event.accept(ModItems.GOLDEN_EMBARIUM_HOE);
            event.accept(ModItems.GOLDEN_TORRID_EMBARIUM_HELMET);
            event.accept(ModItems.GOLDEN_TORRID_EMBARIUM_CHESTPLATE);
            event.accept(ModItems.GOLDEN_TORRID_EMBARIUM_LEGGINGS);
            event.accept(ModItems.GOLDEN_TORRID_EMBARIUM_BOOTS);
            event.accept(ModItems.GOLDEN_TORRID_EMBARIUM_SWORD);
            event.accept(ModItems.GOLDEN_TORRID_EMBARIUM_PICKAXE);
            event.accept(ModItems.GOLDEN_TORRID_EMBARIUM_AXE);
            event.accept(ModItems.GOLDEN_TORRID_EMBARIUM_SHOVEL);
            event.accept(ModItems.GOLDEN_TORRID_EMBARIUM_HOE);
            event.accept(ModItems.IRON_TORRID_HELMET);
            event.accept(ModItems.IRON_TORRID_CHESTPLATE);
            event.accept(ModItems.IRON_TORRID_LEGGINGS);
            event.accept(ModItems.IRON_TORRID_BOOTS);
            event.accept(ModItems.IRON_TORRID_SWORD);
            event.accept(ModItems.IRON_TORRID_PICKAXE);
            event.accept(ModItems.IRON_TORRID_AXE);
            event.accept(ModItems.IRON_TORRID_SHOVEL);
            event.accept(ModItems.IRON_TORRID_HOE);
            event.accept(ModItems.IRON_EMBARIUM_HELMET);
            event.accept(ModItems.IRON_EMBARIUM_CHESTPLATE);
            event.accept(ModItems.IRON_EMBARIUM_LEGGINGS);
            event.accept(ModItems.IRON_EMBARIUM_BOOTS);
            event.accept(ModItems.IRON_EMBARIUM_SWORD);
            event.accept(ModItems.IRON_EMBARIUM_PICKAXE);
            event.accept(ModItems.IRON_EMBARIUM_AXE);
            event.accept(ModItems.IRON_EMBARIUM_SHOVEL);
            event.accept(ModItems.IRON_EMBARIUM_HOE);
            event.accept(ModItems.IRON_TORRID_EMBARIUM_HELMET);
            event.accept(ModItems.IRON_TORRID_EMBARIUM_CHESTPLATE);
            event.accept(ModItems.IRON_TORRID_EMBARIUM_LEGGINGS);
            event.accept(ModItems.IRON_TORRID_EMBARIUM_BOOTS);
            event.accept(ModItems.IRON_TORRID_EMBARIUM_SWORD);
            event.accept(ModItems.IRON_TORRID_EMBARIUM_PICKAXE);
            event.accept(ModItems.IRON_TORRID_EMBARIUM_AXE);
            event.accept(ModItems.IRON_TORRID_EMBARIUM_SHOVEL);
            event.accept(ModItems.IRON_TORRID_EMBARIUM_HOE);
            event.accept(ModItems.DIAMOND_TORRID_HELMET);
            event.accept(ModItems.DIAMOND_TORRID_CHESTPLATE);
            event.accept(ModItems.DIAMOND_TORRID_LEGGINGS);
            event.accept(ModItems.DIAMOND_TORRID_BOOTS);
            event.accept(ModItems.DIAMOND_TORRID_SWORD);
            event.accept(ModItems.DIAMOND_TORRID_PICKAXE);
            event.accept(ModItems.DIAMOND_TORRID_AXE);
            event.accept(ModItems.DIAMOND_TORRID_SHOVEL);
            event.accept(ModItems.DIAMOND_TORRID_HOE);
            event.accept(ModItems.DIAMOND_EMBARIUM_HELMET);
            event.accept(ModItems.DIAMOND_EMBARIUM_CHESTPLATE);
            event.accept(ModItems.DIAMOND_EMBARIUM_LEGGINGS);
            event.accept(ModItems.DIAMOND_EMBARIUM_BOOTS);
            event.accept(ModItems.DIAMOND_EMBARIUM_SWORD);
            event.accept(ModItems.DIAMOND_EMBARIUM_PICKAXE);
            event.accept(ModItems.DIAMOND_EMBARIUM_AXE);
            event.accept(ModItems.DIAMOND_EMBARIUM_SHOVEL);
            event.accept(ModItems.DIAMOND_EMBARIUM_HOE);
            event.accept(ModItems.DIAMOND_TORRID_EMBARIUM_HELMET);
            event.accept(ModItems.DIAMOND_TORRID_EMBARIUM_CHESTPLATE);
            event.accept(ModItems.DIAMOND_TORRID_EMBARIUM_LEGGINGS);
            event.accept(ModItems.DIAMOND_TORRID_EMBARIUM_BOOTS);
            event.accept(ModItems.DIAMOND_TORRID_EMBARIUM_SWORD);
            event.accept(ModItems.DIAMOND_TORRID_EMBARIUM_PICKAXE);
            event.accept(ModItems.DIAMOND_TORRID_EMBARIUM_AXE);
            event.accept(ModItems.DIAMOND_TORRID_EMBARIUM_SHOVEL);
            event.accept(ModItems.DIAMOND_TORRID_EMBARIUM_HOE);
            event.accept(ModItems.NETHERITE_TORRID_HELMET);
            event.accept(ModItems.NETHERITE_TORRID_CHESTPLATE);
            event.accept(ModItems.NETHERITE_TORRID_LEGGINGS);
            event.accept(ModItems.NETHERITE_TORRID_BOOTS);
            event.accept(ModItems.NETHERITE_TORRID_SWORD);
            event.accept(ModItems.NETHERITE_TORRID_PICKAXE);
            event.accept(ModItems.NETHERITE_TORRID_AXE);
            event.accept(ModItems.NETHERITE_TORRID_SHOVEL);
            event.accept(ModItems.NETHERITE_TORRID_HOE);
            event.accept(ModItems.NETHERITE_EMBARIUM_HELMET);
            event.accept(ModItems.NETHERITE_EMBARIUM_CHESTPLATE);
            event.accept(ModItems.NETHERITE_EMBARIUM_LEGGINGS);
            event.accept(ModItems.NETHERITE_EMBARIUM_BOOTS);
            event.accept(ModItems.NETHERITE_EMBARIUM_SWORD);
            event.accept(ModItems.NETHERITE_EMBARIUM_PICKAXE);
            event.accept(ModItems.NETHERITE_EMBARIUM_AXE);
            event.accept(ModItems.NETHERITE_EMBARIUM_SHOVEL);
            event.accept(ModItems.NETHERITE_EMBARIUM_HOE);
            event.accept(ModItems.NETHERITE_TORRID_EMBARIUM_HELMET);
            event.accept(ModItems.NETHERITE_TORRID_EMBARIUM_CHESTPLATE);
            event.accept(ModItems.NETHERITE_TORRID_EMBARIUM_LEGGINGS);
            event.accept(ModItems.NETHERITE_TORRID_EMBARIUM_BOOTS);
            event.accept(ModItems.NETHERITE_TORRID_EMBARIUM_SWORD);
            event.accept(ModItems.NETHERITE_TORRID_EMBARIUM_PICKAXE);
            event.accept(ModItems.NETHERITE_TORRID_EMBARIUM_AXE);
            event.accept(ModItems.NETHERITE_TORRID_EMBARIUM_SHOVEL);
            event.accept(ModItems.NETHERITE_TORRID_EMBARIUM_HOE);
            event.accept(ModItems.PROFUNDIUM_TORRID_HELMET);
            event.accept(ModItems.PROFUNDIUM_TORRID_CHESTPLATE);
            event.accept(ModItems.PROFUNDIUM_TORRID_LEGGINGS);
            event.accept(ModItems.PROFUNDIUM_TORRID_BOOTS);
            event.accept(ModItems.PROFUNDIUM_TORRID_SWORD);
            event.accept(ModItems.PROFUNDIUM_TORRID_PICKAXE);
            event.accept(ModItems.PROFUNDIUM_TORRID_AXE);
            event.accept(ModItems.PROFUNDIUM_TORRID_SHOVEL);
            event.accept(ModItems.PROFUNDIUM_TORRID_HOE);
            event.accept(ModItems.PROFUNDIUM_EMBARIUM_HELMET);
            event.accept(ModItems.PROFUNDIUM_EMBARIUM_CHESTPLATE);
            event.accept(ModItems.PROFUNDIUM_EMBARIUM_LEGGINGS);
            event.accept(ModItems.PROFUNDIUM_EMBARIUM_BOOTS);
            event.accept(ModItems.PROFUNDIUM_EMBARIUM_SWORD);
            event.accept(ModItems.PROFUNDIUM_EMBARIUM_PICKAXE);
            event.accept(ModItems.PROFUNDIUM_EMBARIUM_AXE);
            event.accept(ModItems.PROFUNDIUM_EMBARIUM_SHOVEL);
            event.accept(ModItems.PROFUNDIUM_EMBARIUM_HOE);
            event.accept(ModItems.PROFUNDIUM_TORRID_EMBARIUM_HELMET);
            event.accept(ModItems.PROFUNDIUM_TORRID_EMBARIUM_CHESTPLATE);
            event.accept(ModItems.PROFUNDIUM_TORRID_EMBARIUM_LEGGINGS);
            event.accept(ModItems.PROFUNDIUM_TORRID_EMBARIUM_BOOTS);
            event.accept(ModItems.PROFUNDIUM_TORRID_EMBARIUM_SWORD);
            event.accept(ModItems.PROFUNDIUM_TORRID_EMBARIUM_PICKAXE);
            event.accept(ModItems.PROFUNDIUM_TORRID_EMBARIUM_AXE);
            event.accept(ModItems.PROFUNDIUM_TORRID_EMBARIUM_SHOVEL);
            event.accept(ModItems.PROFUNDIUM_TORRID_EMBARIUM_HOE);
            event.accept(ModItems.PROFUNDIUM_HELMET);
            event.accept(ModItems.PROFUNDIUM_CHESTPLATE);
            event.accept(ModItems.PROFUNDIUM_LEGGINGS);
            event.accept(ModItems.PROFUNDIUM_BOOTS);
            event.accept(ModItems.PROFUNDIUM_SWORD);
            event.accept(ModItems.PROFUNDIUM_PICKAXE);
            event.accept(ModItems.PROFUNDIUM_AXE);
            event.accept(ModItems.PROFUNDIUM_SHOVEL);
            event.accept(ModItems.PROFUNDIUM_HOE);
            event.accept(ModItems.ELYTRA_GLIDER);
            event.accept(ModItems.MECHANICAL_ELYTRA);
//            event.accept(ModItems.WOODEN_SPEAR);
//            event.accept(ModItems.IRON_SPEAR);
            event.accept(ModItems.CHISEL);
            event.accept(ModItems.NETHERITE_CHISEL);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            Sheets.addWoodType(ModWoodTypes.EBONY);

            EntityRenderers.register(ModEntities.MOD_BOAT.get(), p_174010_ -> new ModBoatRenderer(p_174010_, false));
            EntityRenderers.register(ModEntities.MOD_CHEST_BOAT.get(), p_174010_ -> new ModBoatRenderer(p_174010_, true));
        }
    }

//    @OnlyIn(Dist.CLIENT)
//    private void registerElytraLayer(EntityRenderersEvent event) {
//        if(event instanceof EntityRenderersEvent.AddLayers addLayersEvent){
//            EntityModelSet entityModels = addLayersEvent.getEntityModels();
//            addLayersEvent.getSkins().forEach(s -> {
//                LivingEntityRenderer<? extends Player, ? extends EntityModel<? extends Player>> livingEntityRenderer = addLayersEvent.getSkin(s);
//                if(livingEntityRenderer instanceof PlayerRenderer playerRenderer){
////                    playerRenderer.addLayer(new ElytraGliderLayer(playerRenderer, entityModels));
////                    playerRenderer.addLayer(new MechanicalElytraLayer(playerRenderer, entityModels));
//                    playerRenderer.addLayer(new ProfundiumElytraLayer(playerRenderer, entityModels));
//                }
//            });
//            LivingEntityRenderer<ArmorStand, ? extends EntityModel<ArmorStand>> livingEntityRenderer = addLayersEvent.getRenderer(EntityType.ARMOR_STAND);
//            if(livingEntityRenderer instanceof ArmorStandRenderer armorStandRenderer){
////                armorStandRenderer.addLayer(new ElytraGliderArmorStandLayer(armorStandRenderer, entityModels));
//                armorStandRenderer.addLayer(new ProfundiumElytraArmorStandLayer(armorStandRenderer, entityModels));
////                armorStandRenderer.addLayer(new MechanicalElytraArmorStandLayer(armorStandRenderer, entityModels));
//            }
//        }
//    }

@OnlyIn(Dist.CLIENT)
private void registerElytraLayer(EntityRenderersEvent.AddLayers addLayersEvent) {
    EntityModelSet entityModels = addLayersEvent.getEntityModels();
    addLayersEvent.getSkins().forEach(s -> {
        LivingEntityRenderer<? extends Player, ? extends EntityModel<? extends Player>> livingEntityRenderer = addLayersEvent.getSkin(s);
        if (livingEntityRenderer instanceof PlayerRenderer playerRenderer) {
            playerRenderer.addLayer(new ProfundiumElytraLayer(playerRenderer, entityModels));
            playerRenderer.addLayer(new ElytraGliderLayer(playerRenderer, entityModels));
            playerRenderer.addLayer(new MechanicalElytraLayer(playerRenderer, entityModels));
        }
    });
    LivingEntityRenderer<ArmorStand, ? extends EntityModel<ArmorStand>> livingEntityRenderer = addLayersEvent.getRenderer(EntityType.ARMOR_STAND);
    if (livingEntityRenderer instanceof ArmorStandRenderer armorStandRenderer) {
        armorStandRenderer.addLayer(new ProfundiumElytraArmorStandLayer(armorStandRenderer, entityModels));
        armorStandRenderer.addLayer(new MechanicalElytraArmorStandLayer(armorStandRenderer, entityModels));
        armorStandRenderer.addLayer(new ElytraGliderArmorStandLayer(armorStandRenderer, entityModels));
    }
}
}
