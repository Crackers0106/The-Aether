package com.aether.client.rendering.entity;

import com.aether.Aether;
import com.aether.client.model.entity.MoaModel;
import com.aether.entities.passive.MoaEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class MoaRenderer extends MobEntityRenderer<MoaEntity, MoaModel> {

    private static final Identifier TEXTURE = Aether.locate("textures/entity/moas/highlands/blue.png");

    public MoaRenderer(EntityRenderDispatcher rendermanagerIn) {
        super(rendermanagerIn, new MoaModel(), 1.0F);
    }

    @Override
    protected float getAnimationProgress(MoaEntity moa, float f) {
        float f1 = moa.prevWingRotation + (moa.wingRotation - moa.prevWingRotation) * f;
        float f2 = moa.prevDestPos + (moa.destPos - moa.prevDestPos) * f;

        return (MathHelper.sin(f1) + 1.0F) * f2;
    }

    @Override
    protected void scale(MoaEntity moa, MatrixStack matrices, float f) {
        matrices.scale(1.8F, 1.8F, 1.8F);
    }

    @Override
    public Identifier getTexture(MoaEntity moa) {
        return TEXTURE;
    }
}
