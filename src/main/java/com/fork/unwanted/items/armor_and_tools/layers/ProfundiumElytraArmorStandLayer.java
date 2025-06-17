package com.fork.unwanted.items.armor_and_tools.layers;

import com.fork.unwanted.Unwanted;
import com.fork.unwanted.items.ModItems;
import net.minecraft.client.model.ArmorStandArmorModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ProfundiumElytraArmorStandLayer extends ElytraLayer<ArmorStand, ArmorStandArmorModel> {
    private static final ResourceLocation TEXTURE_ELYTRA = ResourceLocation.fromNamespaceAndPath(Unwanted.MOD_ID,
            "textures/models/armor/elytra.png");

    public ProfundiumElytraArmorStandLayer(ArmorStandRenderer armorStandRenderer,
                                       EntityModelSet entityModelSet) {
        super(armorStandRenderer, entityModelSet);
    }

    @Override
    public boolean shouldRender(ItemStack stack, ArmorStand entity) {
        return stack.getItem() == ModItems.PROFUNDIUM_CHESTPLATE.get() || stack.getItem() == ModItems.PROFUNDIUM_TORRID_CHESTPLATE.get() || stack.getItem() == ModItems.PROFUNDIUM_EMBARIUM_CHESTPLATE.get() || stack.getItem() == ModItems.PROFUNDIUM_TORRID_EMBARIUM_CHESTPLATE.get();
    }

    @Override
    public ResourceLocation getElytraTexture(ItemStack stack, ArmorStand entity) {
        return TEXTURE_ELYTRA;
    }
}
