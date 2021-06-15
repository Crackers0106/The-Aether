package com.aether.world.feature;

import com.aether.world.feature.config.AercloudConfig;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;


public class AercloudFeature extends Feature<AercloudConfig> {
    private static final Codec<AercloudConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BlockState.CODEC.fieldOf("state").forGetter(AercloudConfig::getCloudState),
            Codec.BOOL.fieldOf("flat").forGetter(AercloudConfig::isFlat),
            Codec.INT.fieldOf("maxRadius").forGetter(AercloudConfig::maxSegments),
            Codec.INT.fieldOf("y").forGetter(AercloudConfig::getY)
    ).apply(instance, AercloudConfig::new));

    public AercloudFeature() {
        super(CODEC);
    }

    @Override
    public boolean generate(StructureWorldAccess worldIn, ChunkGenerator generator, Random randIn, BlockPos posIn, AercloudConfig configIn) {
        BlockPos origin = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        BlockPos position = new BlockPos(origin.getX() + 8, origin.getY(), origin.getZ() + 8);

        for (int amount = 0; amount < 16; ++amount) {
            int xOffset = rand.nextInt(2);
            int yOffset = (rand.nextBoolean() ? rand.nextInt(3) - 1 : 0);
            int zOffset = rand.nextInt(2);

            position = position.add(xOffset, yOffset, zOffset);

            for (int x = position.getX(); x < position.getX() + rand.nextInt(2) + 3; ++x) {
                for (int y = position.getY(); y < position.getY() + rand.nextInt(1) + 2; ++y) {
                    for (int z = position.getZ(); z < position.getZ() + rand.nextInt(2) + 3; ++z) {
                        BlockPos newPosition = new BlockPos(x, y, z);

                        if (reader.isAir(newPosition)) {
                            if (Math.abs(x - position.getX()) + Math.abs(y - position.getY()) + Math.abs(z - position.getZ()) < 4 + rand.nextInt(2)) {
                                this.setBlockState(reader, newPosition, state);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}