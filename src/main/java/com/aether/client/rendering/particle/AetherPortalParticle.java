package com.aether.client.rendering.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class AetherPortalParticle extends PortalParticle {

    protected AetherPortalParticle(ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
        super(clientWorld, d, e, f, g, h, i);

        float j = this.random.nextFloat() * 0.6F + 0.4F;

        this.colorRed = this.colorGreen = this.colorBlue = 1.0F * j;
        this.colorRed *= 0.2F;
        this.colorGreen *= 0.2F;
    }

    @Environment(EnvType.CLIENT)
    public static class DefaultFactory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider spriteProvider;

        public DefaultFactory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            AetherPortalParticle portalParticle = new AetherPortalParticle(clientWorld, x, y, z, velocityX, velocityY, velocityZ);
            portalParticle.setSprite(this.spriteProvider);
            return portalParticle;
        }

    }

}