package com.fork.unwanted.items;


import com.fork.unwanted.items.custom.GemInfuserItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class GemInfuserItemRenderer extends GeoItemRenderer<GemInfuserItem> {
    public GemInfuserItemRenderer() {
        super(new GemInfuserItemModel());
    }
}
