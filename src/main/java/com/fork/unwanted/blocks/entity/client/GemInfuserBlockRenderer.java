package com.fork.unwanted.blocks.entity.client;

import com.fork.unwanted.blocks.entity.custom.GemInfuserBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

import javax.annotation.Nullable;


public class GemInfuserBlockRenderer extends GeoBlockRenderer<GemInfuserBlockEntity> {
    public GemInfuserBlockRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
        super(new GemInfuserBlockModel());
    }

    @Override
    public @org.jetbrains.annotations.Nullable RenderType getRenderType(GemInfuserBlockEntity animatable, ResourceLocation texture, @org.jetbrains.annotations.Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }
}
