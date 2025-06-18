package com.fork.unwanted.items.spear;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SpearModel extends Model {

    private final ModelPart root;

    public SpearModel(ModelPart p_171016_) {
        super(RenderType::entitySolid);
        this.root = p_171016_;
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition partdefinition1 = partdefinition.addOrReplaceChild("pole", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 28.0F, 1.0F), PartPose.ZERO);
        partdefinition1.addOrReplaceChild("spike1", CubeListBuilder.create().texOffs(4, -5).addBox(0.0F, -5.0F, -2.5F, 0.0F, 8.0F, 5.0F), PartPose.ZERO);
        partdefinition1.addOrReplaceChild("spike2", CubeListBuilder.create().texOffs(4, 0).mirror().addBox(-2.5F, -5.0F, 0.0F, 5.0F, 8.0F, 0.0F), PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
        this.root.render(poseStack, buffer, packedLight, packedOverlay, color);
    }
}
