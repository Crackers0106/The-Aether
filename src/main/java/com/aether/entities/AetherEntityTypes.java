package com.aether.entities;

import com.aether.Aether;
import com.aether.blocks.AetherBlocks;
import com.aether.client.rendering.entity.*;
import com.aether.entities.block.FloatingBlockEntity;
import com.aether.entities.hostile.AechorPlantEntity;
import com.aether.entities.hostile.ChestMimicEntity;
import com.aether.entities.hostile.CockatriceEntity;
import com.aether.entities.passive.*;
import com.aether.entities.projectile.EnchantedDartEntity;
import com.aether.entities.projectile.GoldenDartEntity;
import com.aether.entities.projectile.PoisonDartEntity;
import com.aether.entities.projectile.PoisonNeedleEntity;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.*;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Difficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.WorldAccess;

import java.util.Random;

import static net.minecraft.entity.SpawnReason.SPAWNER;

public class AetherEntityTypes {
    public static final EntityType<AechorPlantEntity> AECHOR_PLANT;
    public static final EntityType<FlyingCowEntity> FLYING_COW;
    public static final EntityType<AerbunnyEntity> AERBUNNY;
    public static final EntityType<MoaEntity> MOA;
    public static final EntityType<PhygEntity> PHYG;
    public static final EntityType<SheepuffEntity> SHEEPUFF;
    public static final EntityType<CockatriceEntity> COCKATRICE;
    public static final EntityType<ChestMimicEntity> CHEST_MIMIC;
    public static final EntityType<FloatingBlockEntity> FLOATING_BLOCK;
    public static final EntityType<GoldenDartEntity> GOLDEN_DART;
    public static final EntityType<EnchantedDartEntity> ENCHANTED_DART;
    public static final EntityType<PoisonDartEntity> POISON_DART;
    public static final EntityType<PoisonNeedleEntity> POISON_NEEDLE;
//    public static EntityType<WhirlwindEntity> WHIRLWIND;
//    public static EntityType<AerwhaleEntity> AERWHALE;
//    public static EntityType<MiniCloudEntity> MINI_CLOUD;
//    public static EntityType<FireMinionEntity> FIRE_MINION;
//    public static EntityType<CrystalEntity> CRYSTAL;
//    public static EntityType<PhoenixArrowEntity> PHOENIX_ARROW;

    static {
        AECHOR_PLANT = register("aechor_plant", SpawnGroup.MONSTER, EntityDimensions.changing(1.0F, 1.0F), (entityType, world) -> new AechorPlantEntity(world));
        FLYING_COW = register("flying_cow", SpawnGroup.CREATURE, EntityDimensions.changing(0.9F, 1.3F), (entityType, world) -> new FlyingCowEntity(world));
        AERBUNNY = register("aerbunny", SpawnGroup.CREATURE, EntityDimensions.changing(0.4F, 0.4F), (entityType, world) -> new AerbunnyEntity(world));
        MOA = register("moa", SpawnGroup.CREATURE, EntityDimensions.changing(1.0F, 2.0F), (entityType, world) -> new MoaEntity(world));
        PHYG = register("phyg", SpawnGroup.CREATURE, EntityDimensions.changing(0.9F, 1.3F), (entityType, world) -> new PhygEntity(world));
        SHEEPUFF = register("sheepuff", SpawnGroup.CREATURE, EntityDimensions.changing(0.9F, 1.3F), (entityType, world) -> new SheepuffEntity(world));
        COCKATRICE = register("cockatrice", SpawnGroup.MONSTER, EntityDimensions.changing(1.0F, 2.0F), (entityType, world) -> new CockatriceEntity(world));
        CHEST_MIMIC = register("chest_mimic", SpawnGroup.MONSTER, EntityDimensions.changing(1.0F, 2.0F), (entityType, world) -> new ChestMimicEntity(world));
        FLOATING_BLOCK = register("floating_block", 160, 20, true, EntityDimensions.changing(0.98F, 0.98F), (entityType, world) -> new FloatingBlockEntity(world));
        GOLDEN_DART = register("golden_dart", SpawnGroup.MISC, EntityDimensions.changing(0.5F, 0.5F), (entityType, world) -> new GoldenDartEntity(world));
        ENCHANTED_DART = register("enchanted_dart", SpawnGroup.MISC, EntityDimensions.changing(0.5F, 0.5F), (entityType, world) -> new EnchantedDartEntity(world));
        POISON_DART = register("poison_dart", SpawnGroup.MISC, EntityDimensions.changing(0.5F, 0.5F), (entityType, world) -> new PoisonDartEntity(world));
        POISON_NEEDLE = register("poison_needle", SpawnGroup.MISC, EntityDimensions.changing(0.5F, 0.5F), (entityType, world) -> new PoisonNeedleEntity(world));

//        WHIRLWIND = register("whirlwind", ...);
//        AERWHALE = register("aerwhale", ...);
//        MINI_CLOUD = register("mini_cloud", ...);
//        FIRE_MINION = register("fire_minion", ...);
//        CRYSTAL = register("crystal", ...);
//        PHOENIX_ARROW = register("phoenix_arrow", ...);
    }

    public static void initializeClient() {
        register(MOA, (entityRenderDispatcher) -> new MoaRenderer(entityRenderDispatcher.getRenderDispatcher()));
        register(FLOATING_BLOCK, (entityRenderDispatcher) -> new FloatingBlockRenderer(entityRenderDispatcher.getRenderDispatcher()));
        register(FLYING_COW, (entityRenderDispatcher) -> new FlyingCowRenderer(entityRenderDispatcher.getRenderDispatcher()));
        register(SHEEPUFF, (entityRenderDispatcher) -> new SheepuffRenderer(entityRenderDispatcher.getRenderDispatcher()));
        register(AERBUNNY, (entityRenderDispatcher) -> new AerbunnyRenderer(entityRenderDispatcher.getRenderDispatcher()));
        register(AECHOR_PLANT, (entityRenderDispatcher) -> new AechorPlantRenderer(entityRenderDispatcher.getRenderDispatcher()));
        register(PHYG, (entityRenderDispatcher) -> new PhygRenderer(entityRenderDispatcher.getRenderDispatcher()));
        register(COCKATRICE, (entityRenderDispatcher) -> new CockatriceRenderer(entityRenderDispatcher.getRenderDispatcher()));

        register(ENCHANTED_DART, (entityRenderDispatcher) -> new DartRenderer(entityRenderDispatcher.getRenderDispatcher()));
        register(GOLDEN_DART, (entityRenderDispatcher) -> new DartRenderer(entityRenderDispatcher.getRenderDispatcher()));
        register(POISON_DART, (entityRenderDispatcher) -> new DartRenderer(entityRenderDispatcher.getRenderDispatcher()));
        register(POISON_NEEDLE, (entityRenderDispatcher) -> new DartRenderer(entityRenderDispatcher.getRenderDispatcher()));

        //entityRenderMap.put(EntityMiniCloud.class, new MiniCloudRenderer(renderManager));
        //entityRenderMap.put(EntityAerwhale.class, new AerwhaleRenderer(renderManager));
        register(CHEST_MIMIC, (entityRendererDispatcher) -> new ChestMimicRenderer(entityRendererDispatcher.getRenderDispatcher()));
        //entityRenderMap.put(EntityWhirlwind.class, new WhirlwindRenderer(renderManager));
        //entityRenderMap.put(EntityPhoenixArrow.class, new PhoenixArrowRenderer(renderManager));

    }

    public static <X extends Entity> EntityType<X> register(String name, int trackingDistance, int updateIntervalTicks, boolean alwaysUpdateVelocity, EntityDimensions size, EntityType.EntityFactory<X> factory) {
        return Registry.register(Registry.ENTITY_TYPE, Aether.locate(name), FabricEntityTypeBuilder.create(SpawnGroup.MISC, factory).trackable(trackingDistance, updateIntervalTicks, alwaysUpdateVelocity).dimensions(size).disableSaving().build());
    }

    public static <X extends Entity> EntityType<X> register(String name, SpawnGroup category, EntityDimensions size, EntityType.EntityFactory<X> factory) {
        return Registry.register(Registry.ENTITY_TYPE, Aether.locate(name), FabricEntityTypeBuilder.create(category, factory).dimensions(size).disableSaving().build());
    }

    private static void register(EntityType<? extends Entity> clazz, EntityRendererFactory factory) {
        EntityRendererRegistry.INSTANCE.register(clazz, factory);
    }

    public static boolean getAnimalData(EntityType<? extends Entity> entityType, WorldAccess WorldAccess, SpawnReason SpawnReason, BlockPos blockPos, Random random) {
        return WorldAccess.getBlockState(blockPos.down()).getBlock() == AetherBlocks.AETHER_GRASS && WorldAccess.getBaseLightLevel(blockPos, 0) > 8 && (SpawnReason == SPAWNER || WorldAccess.getBlockState(blockPos).allowsSpawning(WorldAccess, blockPos, entityType));
    }

    public static boolean getHostileData(EntityType<? extends Entity> entityType_1, ServerWorldAccess WorldAccess_1, SpawnReason SpawnReason, BlockPos blockPos_1, Random random_1) {
        return WorldAccess_1.getDifficulty() != Difficulty.PEACEFUL && HostileEntity.isSpawnDark(WorldAccess_1, blockPos_1, random_1) && (SpawnReason == SPAWNER || WorldAccess_1.getBlockState(blockPos_1).allowsSpawning(WorldAccess_1, blockPos_1, entityType_1));
    }
}
