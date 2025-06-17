package com.fork.unwanted.entity.client;

import com.fork.unwanted.Unwanted;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation EBONY_BOAT_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID, "boat/ebony"), "main");
    public static final ModelLayerLocation EBONY_CHEST_BOAT_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID, "chest_boat/ebony"), "main");
    public static final ModelLayerLocation WOODEN_SPEAR = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID, "wooden_spear"), "main");
    public static final ModelLayerLocation IRON_SPEAR = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID, "iron_spear"), "main");
}
