package com.aether.client.rendering.entity;

import com.aether.Aether;
import net.minecraft.client.render.entity.model.PigEntityModel;
import com.aether.client.rendering.entity.layer.PhygWingLayer;
import com.aether.entities.passive.PhygEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.SaddleFeatureRenderer;
import net.minecraft.util.Identifier;

public class PhygRenderer extends MobEntityRenderer<PhygEntity, PigEntityModel<PhygEntity>> {

    private static final Identifier TEXTURE = Aether.locate("textures/entity/phyg/phyg.png");

    public PhygRenderer(EntityRenderDispatcher renderManager) {
        super(renderManager, new PigEntityModel<>(0.0F), 0.7F);

        this.addFeature(new PhygWingLayer(this));
        this.addFeature(new SaddleFeatureRenderer<>(this, new PigEntityModel<PhygEntity>(0.5F), Aether.locate("textures/entity/pig/pig_saddle.png")));
    }

    @Override
    public Identifier getTexture(PhygEntity entity) {
        return TEXTURE;
    }
}
