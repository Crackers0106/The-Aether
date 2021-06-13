package com.aether.client.rendering.entity.layer;

import com.aether.Aether;
import com.aether.client.model.entity.PhygWingModel;
import com.aether.entities.passive.PhygEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PigEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class PhygWingLayer extends FeatureRenderer<PhygEntity, PigEntityModel<PhygEntity>> {

    private static final Identifier TEXTURE = Aether.locate("textures/entity/phyg/wings.png");
    private final PhygWingModel model;

    public PhygWingLayer(FeatureRendererContext<PhygEntity, PigEntityModel<PhygEntity>> context) {
        super(context);
		this.model = new PhygWingModel();
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, PhygEntity phyg, float limbAngle, float limbDistance, float tickDelta, float customAngle, float netHeadYaw, float headPitch) {
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCull(TEXTURE));
		this.model.setAngles(phyg, limbAngle, limbDistance, customAngle, netHeadYaw, headPitch);
        this.model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
    }

    // TODO: ???
    /*@Override
    public boolean hasHurtOverlay()
    {
        return false;
    }*/

}
