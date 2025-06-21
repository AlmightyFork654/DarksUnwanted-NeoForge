package com.fork.unwanted.items;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.items.custom.GemInfuserItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GemInfuserItemModel extends GeoModel<GemInfuserItem> {
    @Override
    public ResourceLocation getModelResource(GemInfuserItem object) {
        return ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID, "geo/gem_infuser.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GemInfuserItem object) {
        return ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID, "textures/block/gem_infuser.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GemInfuserItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID, "animations/gem_infuser.animation.json");
    }
}
