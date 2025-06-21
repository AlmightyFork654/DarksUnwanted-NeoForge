package com.fork.unwanted.events;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.blocks.ModBlocks;
import com.fork.unwanted.blocks.entity.ModBlockEntities;
import com.fork.unwanted.blocks.entity.custom.renderer.GemCuttingStationEntityRenderer;
import com.fork.unwanted.blocks.entity.custom.renderer.GemInfuserBlockEntityRenderer;
import com.fork.unwanted.blocks.entity.custom.renderer.TorridFurnaceBlockEntityRenderer;
import com.fork.unwanted.entity.client.ModModelLayers;
import com.fork.unwanted.items.spear.SpearModel;
import com.fork.unwanted.screen.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

import static net.minecraft.client.gui.screens.MenuScreens.*;

@EventBusSubscriber(modid = Unwanted.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TORRID_STEEL_BARS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TORRID_STEEL_BARS_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TORRID_STEEL_BARS_TRAPDOOR.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EBONY_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EBONY_TRAPDOOR.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TORRID_STEEL_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TORRID_STEEL_TRAPDOOR.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EMBARIUM_BLOCK.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TORRID_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_TORRID_BUSH.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EBONY_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EBONY_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_EBONY_SAPLING.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GEM_CUTTING_STATION.get(), RenderType.translucent());

//        MenuScreens.register(ModMenuTypes.GEM_CUTTING_STATION_MENU.get(), GemCuttingStationScreen::new);
//        MenuScreens.register(ModMenuTypes.GEM_INFUSER_MENU.get(), GemInfuserScreen::new);
//        MenuScreens.register(ModMenuTypes.TORRID_FURNACE_MENU.get(), TorridFurnaceScreen::new);
//        MenuScreens.register(ModMenuTypes.KETTLE_MENU.get(), KettleScreen::new);
    }

    @SubscribeEvent
    public static void onRegisterMenuScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenuTypes.GEM_CUTTING_STATION_MENU.get(), GemCuttingStationScreen::new);
        event.register(ModMenuTypes.GEM_INFUSER_MENU.get(), GemInfuserScreen::new);
        event.register(ModMenuTypes.TORRID_FURNACE_MENU.get(), TorridFurnaceScreen::new);
        event.register(ModMenuTypes.KETTLE_MENU.get(), KettleScreen::new);
    }

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event){
        event.registerBlockEntityRenderer(ModBlockEntities.GEM_CUTTING_STATION_BLOCK_ENTITY.get(), GemCuttingStationEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.GEM_INFUSER_BLOCK_ENTITY.get(), GemInfuserBlockEntityRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.TORRID_FURNACE_BLOCK_ENTITY.get(), TorridFurnaceBlockEntityRenderer::new);
//        event.registerBlockEntityRenderer(ModBlockEntities.KETTLE_BLOCK_ENTITY.get(), KettleBlockEntityRenderer::new);

        event.registerBlockEntityRenderer(ModBlockEntities.MOD_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.EBONY_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(ModModelLayers.EBONY_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);

        event.registerLayerDefinition(ModModelLayers.WOODEN_SPEAR, SpearModel::createLayer);
        event.registerLayerDefinition(ModModelLayers.IRON_SPEAR, SpearModel::createLayer);
    }
}
