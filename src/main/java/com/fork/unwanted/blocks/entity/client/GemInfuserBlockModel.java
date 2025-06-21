package com.fork.unwanted.blocks.entity.client;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.blocks.entity.custom.GemInfuserBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GemInfuserBlockModel extends GeoModel<GemInfuserBlockEntity> {
    @Override
    public ResourceLocation getModelResource(GemInfuserBlockEntity object) {
        return ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID, "geo/gem_infuser.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GemInfuserBlockEntity object) {
        return ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID, "textures/block/gem_infuser.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GemInfuserBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID, "animations/gem_infuser.animation.json");
    }
}