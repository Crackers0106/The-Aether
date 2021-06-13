package com.aether.client.rendering.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class GoldenOakLeafParticle extends PortalParticle
{
    protected GoldenOakLeafParticle(ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
        super(clientWorld, d, e, f, g, h, i);

        this.colorRed = 0.976F;
        this.colorGreen = 0.7450980392156863F;
        this.colorBlue = 0.0F;
    }

    @Environment(EnvType.CLIENT)
    public static class DefaultFactory implements ParticleFactory<DefaultParticleType>
    {
        private final SpriteProvider spriteProvider;

        public DefaultFactory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            GoldenOakLeafParticle leavesParticle = new GoldenOakLeafParticle(clientWorld, x, y, z, velocityX, velocityY, velocityZ);
            leavesParticle.setSprite(this.spriteProvider);
            return leavesParticle;
        }
    }
}