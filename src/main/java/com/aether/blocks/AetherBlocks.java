package com.aether.blocks;

import com.aether.Aether;
import com.aether.blocks.aercloud.*;
import com.aether.blocks.decorative.*;
import com.aether.blocks.natural.*;
import com.aether.client.rendering.block.FluidRenderSetup;
import com.aether.client.rendering.particle.AetherParticles;
import com.aether.entities.util.RenderUtils;
import com.aether.items.AetherItemGroups;
import com.aether.world.feature.tree.*;
import com.google.common.collect.ImmutableSet;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.WallStandingBlockItem;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

import java.util.function.Supplier;

public class AetherBlocks {
    public static final Block AEROGEL;
    public static final Block AETHER_DIRT;
    public static final Block AETHER_ENCHANTED_GRASS;
    public static final Block AETHER_FARMLAND;
    public static final Block AETHER_GRASS_BLOCK;
    public static final Block AETHER_DIRT_PATH;
    public static final Block AMBROSIUM_ORE;
    public static final Block AMBROSIUM_TORCH;
    public static final Block AMBROSIUM_TORCH_WALL;
    public static final Block ANGELIC_SLAB;
    public static final Block ANGELIC_STAIRS;
    public static final Block ANGELIC_STONE;
    public static final Block ANGELIC_WALL;
    public static final Block BLUE_AERCLOUD;
    public static final Block BLUE_PORTAL;
    public static final Block CARVED_SLAB;
    public static final Block CARVED_STAIRS;
    public static final Block CARVED_STONE;
    public static final Block CARVED_STONE_TRAP;
    public static final Block CARVED_WALL;
//  public static final Block CHEST_MIMIC;
    public static final Block COLD_AERCLOUD;
    public static final Block DECORATED_HOLIDAY_LEAVES;
    public static final Block ENCHANTED_GRAVITITE;
    public static final Block ALTAR;
    public static final Block FREEZER;
    public static final Block GOLDEN_AERCLOUD;
    public static final Block GRAVITITE_ORE;
//    public static final Block BLOCK_OF_GRAVITITE;
    public static final Block HELLFIRE_SLAB;
    public static final Block HELLFIRE_STAIRS;
    public static final Block HELLFIRE_STONE;
    public static final Block HELLFIRE_STONE_TRAP;
    public static final Block HELLFIRE_WALL;
    public static final Block HOLIDAY_LEAVES;
    public static final Block HOLYSTONE;
    public static final Block HOLYSTONE_BRICK;
    public static final Block HOLYSTONE_BRICK_SLAB;
    public static final Block HOLYSTONE_BRICK_STAIRS;
    public static final Block HOLYSTONE_BRICK_WALL;
    public static final Block HOLYSTONE_SLAB;
    public static final Block HOLYSTONE_STAIRS;
    public static final Block HOLYSTONE_WALL;
    public static final Block ICESTONE;
    public static final Block INCUBATOR;
    public static final Block LIGHT_ANGELIC_STONE;
    public static final Block LIGHT_ANGELIC_STONE_TRAP;
    public static final Block LIGHT_HELLFIRE_STONE;
    public static final Block LIGHT_HELLFIRE_STONE_TRAP;
    public static final Block MOSSY_HOLYSTONE;
    public static final Block MOSSY_HOLYSTONE_SLAB;
    public static final Block MOSSY_HOLYSTONE_STAIRS;
    public static final Block MOSSY_HOLYSTONE_WALL;
    public static final Block PILLAR;
    public static final Block PILLAR_TOP;
    public static final Block PINK_AERCLOUD;
    public static final Block PRESENT;
    public static final Block QUICKSOIL;
    public static final Block QUICKSOIL_GLASS;
    public static final Block QUICKSOIL_GLASS_PANE;
    public static final Block SENTRY_STONE;
    public static final Block SENTRY_STONE_TRAP;
    public static final Block SKYROOT_BOOKSHELF;
    public static final Block SKYROOT_DOOR;
    public static final Block SKYROOT_FENCE;
    public static final Block SKYROOT_FENCE_GATE;
    public static final Block SKYROOT_LOG;
    public static final Block SKYROOT_PLANKS;
    public static final Block SKYROOT_SLAB;
    public static final Block SKYROOT_STAIRS;
    public static final Block SKYROOT_SAPLING;
    public static final Block SKYROOT_TRAPDOOR;
    public static final Block POTTED_SKYROOT_SAPLING;
    public static final Block SKYROOT_LEAVES;
    public static final Block STRIPPED_SKYROOT_LOG;
    public static final Block GOLDEN_OAK_SAPLING;
    public static final Block POTTED_GOLDEN_OAK_SAPLING;
    public static final Block GOLDEN_OAK_LOG;
    public static final Block STRIPPED_GOLDEN_OAK_LOG;
    public static final Block GOLDEN_OAK_LEAVES;
    public static final Block CRYSTAL_LEAVES;
    public static final Block SUN_ALTAR;
    public static final Block ZANITE_BLOCK;
    public static final Block ZANITE_ORE;
    public static final Block BLUEBERRY_BUSH;
    public static final Block PURPLE_FLOWER;
    public static final Block WHITE_FLOWER;

    static {
        AETHER_DIRT = register("aether_dirt", new Block(FabricBlockSettings.copyOf(Blocks.DIRT).strength(0.3f).breakByTool(FabricToolTags.SHOVELS).breakByHand(true).sounds(BlockSoundGroup.GRAVEL)), buildingBlock());

        // We're going to be using this more than once, so we might as well store it in a variable.
        final FabricBlockSettings GRASS_BLOCKS = FabricBlockSettings.of(Material.SOLID_ORGANIC).breakByTool(FabricToolTags.SHOVELS).breakByHand(true).mapColor(MapColor.CYAN).strength(0.4f).ticksRandomly().sounds(BlockSoundGroup.GRASS);
        AETHER_GRASS_BLOCK = register("aether_grass", new AetherGrassBlock(GRASS_BLOCKS), buildingBlock());

        // Note that because we're changing the material color (which mutates the `FabricBlockSettings`), we want to
        // make a copy of the settings first.

        // Copying block settings is okay in this case, but copying the settings of another block is *not* something
        // you should do unless the new block is *directly related* to the block you're copying from. If the blocks just
        // happen to have several things in common, you should make a new settings object from scratch instead.
        AETHER_ENCHANTED_GRASS = register("enchanted_aether_grass", new EnchantedAetherGrassBlock(FabricBlockSettings.copyOf(GRASS_BLOCKS).mapColor(MapColor.GOLD)), buildingBlock());

        final FabricBlockSettings GRASS = FabricBlockSettings.of(Material.REPLACEABLE_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS);
        AMBROSIUM_ORE = register("ambrosium_ore", new OreBlock(AbstractBlock.Settings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F)), buildingBlock());
        BLUE_PORTAL = register("blue_portal", new AetherPortalBlock(AbstractBlock.Settings.of(Material.PORTAL, MapColor.BLUE).nonOpaque().noCollision().ticksRandomly().dropsNothing().blockVision(AetherBlocks::never).strength(-1.0f).sounds(BlockSoundGroup.GLASS).luminance((state) -> 11)));
        HOLYSTONE = register("holystone", new Block(FabricBlockSettings.of(Material.STONE, MapColor.GRAY).requiresTool().strength(0.5f, 10.0f).sounds(BlockSoundGroup.STONE)), buildingBlock());
        HOLYSTONE_BRICK = register("holystone_brick", new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(1.5F, 6.0F).mapColor(MapColor.WHITE)), buildingBlock());
        MOSSY_HOLYSTONE = register("mossy_holystone", new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(2.0F, 6.0F).mapColor(MapColor.WHITE)), buildingBlock());
        ZANITE_ORE = register("zanite_ore", new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(3.0F, 3.0F)), buildingBlock());
        AEROGEL = register("aerogel", new Block(FabricBlockSettings.of(Material.SOIL).strength(1.0f, 2000.0f).sounds(BlockSoundGroup.GLASS).solidBlock(AetherBlocks::never).nonOpaque()), buildingBlock());
        AETHER_FARMLAND = register("aether_farmland", new AetherFarmlandBlock(FabricBlockSettings.of(Material.SOIL).ticksRandomly().strength(0.6f).sounds(BlockSoundGroup.GRAVEL).blockVision(AetherBlocks::always).suffocates(AetherBlocks::always)), buildingBlock());
        AETHER_DIRT_PATH = register("aether_grass_path", new AetherDirtPathBlock(), buildingBlock());
        AMBROSIUM_TORCH = register("ambrosium_torch",  new AmbrosiumTorchBlock(), false, buildingBlock());
        AMBROSIUM_TORCH_WALL = register("ambrosium_wall_torch", new AmbrosiumTorchWallBlock(), false, buildingBlock());
        Registry.register(Registry.ITEM, Aether.locate("ambrosium_torch"), new WallStandingBlockItem(AMBROSIUM_TORCH, AMBROSIUM_TORCH_WALL, buildingBlock()));

        final FabricBlockSettings ANGELIC_STONES = FabricBlockSettings.of(Material.STONE).hardness(0.5f).resistance(1.0f).sounds(BlockSoundGroup.STONE);
        ANGELIC_STONE = register("angelic_stone", new Block(ANGELIC_STONES), buildingBlock());
        ANGELIC_SLAB = register("angelic_slab", new AetherSlabBlock(ANGELIC_STONE.getDefaultState()), buildingBlock());
        ANGELIC_STAIRS = register("angelic_stairs", new AetherStairsBlock(ANGELIC_STONE.getDefaultState()), buildingBlock());
//        ANGELIC_STONE_TRAP = register("angelic_stone_trap", new Block(FabricBlockSettings.of(Material.STONE).hardness(-1.0f).resistance(6000000.0f).sounds(BlockSoundGroup.STONE)));
        ANGELIC_WALL = register("angelic_wall", new AetherWallBlock(ANGELIC_STONE.getDefaultState()), buildingBlock());
        BLUEBERRY_BUSH = register("blueberry_bush", new BlueberryBushBlock(FabricBlockSettings.of(Material.REPLACEABLE_PLANT).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(AetherBlocks::canSpawnOnLeaves).suffocates(AetherBlocks::never).blockVision(AetherBlocks::never).collidable(false)), buildingBlock());
        CARVED_STONE = register("carved_stone", new Block(FabricBlockSettings.of(Material.STONE).hardness(0.5f).resistance(1.0f).sounds(BlockSoundGroup.STONE)), buildingBlock());
        CARVED_STONE_TRAP = register("carved_stone_trap", new Block(FabricBlockSettings.of(Material.STONE).hardness(-1.0f).resistance(6000000.0f).sounds(BlockSoundGroup.STONE)));
        CARVED_SLAB = register("carved_slab", new AetherSlabBlock(CARVED_STONE.getDefaultState()), buildingBlock());
        CARVED_STAIRS = register("carved_stairs", new AetherStairsBlock(CARVED_STONE.getDefaultState()), buildingBlock());
        CARVED_WALL = register("carved_wall", new AetherWallBlock(CARVED_STONE.getDefaultState()), buildingBlock());
//        CHEST_MIMIC = register("chest_mimic", null);
        COLD_AERCLOUD = register("cold_aercloud", new BaseAercloudBlock(AbstractBlock.Settings.of(Material.ICE, MapColor.WHITE).strength(0.2F).sounds(BlockSoundGroup.WOOL).nonOpaque()), buildingBlock());
        BLUE_AERCLOUD = register("blue_aercloud", new BlueAercloudBlock(AbstractBlock.Settings.of(Material.ICE, MapColor.LIGHT_BLUE).strength(0.2F).sounds(BlockSoundGroup.WOOL).nonOpaque()), buildingBlock());
        PINK_AERCLOUD = register("pink_aercloud", new PinkAercloudBlock(AbstractBlock.Settings.of(Material.ICE, MapColor.PINK).strength(0.2F).sounds(BlockSoundGroup.WOOL).nonOpaque()), buildingBlock());
        DECORATED_HOLIDAY_LEAVES = register("decorated_holiday_leaves", createLeavesBlock(), buildingBlock());
        ALTAR = register("altar", new Block(FabricBlockSettings.of(Material.STONE, MapColor.GRAY).requiresTool().strength(0.5f, 10.0f).sounds(BlockSoundGroup.STONE)), buildingBlock());
        FREEZER = register("freezer", new Block(FabricBlockSettings.of(Material.STONE, MapColor.GRAY).requiresTool().strength(0.5f, 10.0f).sounds(BlockSoundGroup.STONE)), buildingBlock());
        GOLDEN_AERCLOUD = register("golden_aercloud", new GoldenAercloudBlock(AbstractBlock.Settings.of(Material.ICE, MapColor.YELLOW).strength(0.2F).sounds(BlockSoundGroup.WOOL).nonOpaque()), buildingBlock());
        GRAVITITE_ORE = register("gravitite_ore", new FloatingBlock(false, FabricBlockSettings.of(Material.STONE).strength(5.0F).sounds(BlockSoundGroup.STONE).breakByTool(FabricToolTags.PICKAXES, 2)), buildingBlock());
		ENCHANTED_GRAVITITE = register("enchanted_gravitite", new FloatingBlock(true, FabricBlockSettings.of(Material.METAL).strength(3.0f, -1.0f).sounds(BlockSoundGroup.METAL)), buildingBlock());

        final AbstractBlock.Settings HELLFIRE_STONES = FabricBlockSettings.of(Material.STONE).hardness(0.5f).resistance(1.0f).sounds(BlockSoundGroup.STONE);
        HELLFIRE_STONE = register("hellfire_stone", new Block(HELLFIRE_STONES), buildingBlock());
        HELLFIRE_STONE_TRAP = register("hellfire_stone_trap", new Block(FabricBlockSettings.of(Material.STONE).hardness(-1.0f).resistance(6000000.0f).sounds(BlockSoundGroup.STONE)));
        HELLFIRE_WALL = register("hellfire_wall", new AetherWallBlock(HELLFIRE_STONE.getDefaultState()), buildingBlock());
        HELLFIRE_SLAB = register("hellfire_slab", new AetherSlabBlock(HELLFIRE_STONE.getDefaultState()), buildingBlock());
        HELLFIRE_STAIRS = register("hellfire_stairs", new AetherStairsBlock(HELLFIRE_STONE.getDefaultState()), buildingBlock());
        HOLIDAY_LEAVES = register("holiday_leaves", createLeavesBlock(), buildingBlock());
        HOLYSTONE_BRICK_SLAB = register("holystone_brick_slab", new AetherSlabBlock(HOLYSTONE_BRICK.getDefaultState()), buildingBlock());
        HOLYSTONE_BRICK_STAIRS = register("holystone_brick_stairs", new AetherStairsBlock(HOLYSTONE_BRICK.getDefaultState()), buildingBlock());
        HOLYSTONE_BRICK_WALL = register("holystone_brick_wall", new AetherWallBlock(HOLYSTONE_BRICK.getDefaultState()), buildingBlock());
        HOLYSTONE_SLAB = register("holystone_slab", new AetherSlabBlock(HOLYSTONE.getDefaultState()), buildingBlock());
        HOLYSTONE_STAIRS = register("holystone_stairs", new AetherStairsBlock(HOLYSTONE.getDefaultState()), buildingBlock());
        HOLYSTONE_WALL = register("holystone_wall", new AetherWallBlock(HOLYSTONE.getDefaultState()), buildingBlock());
        ICESTONE = register("icestone", new Block(FabricBlockSettings.of(Material.STONE, MapColor.GRAY).requiresTool().strength(3.0f, 3.0f).sounds(BlockSoundGroup.GLASS)), buildingBlock());

        INCUBATOR = register("incubator", new Block(FabricBlockSettings.of(Material.STONE, MapColor.GRAY).requiresTool().strength(0.5f, 10.0f).sounds(BlockSoundGroup.STONE)), buildingBlock());
        LIGHT_ANGELIC_STONE = register("light_angelic_stone", new Block(FabricBlockSettings.of(Material.STONE).hardness(0.5f).luminance(11).resistance(1.0f).sounds(BlockSoundGroup.STONE)), buildingBlock());
        LIGHT_ANGELIC_STONE_TRAP = register("light_angelic_stone_trap", new Block(FabricBlockSettings.of(Material.STONE).hardness(-1.0f).luminance(11).resistance(6000000.0f).sounds(BlockSoundGroup.STONE)));

        LIGHT_HELLFIRE_STONE = register("light_hellfire_stone", new Block(FabricBlockSettings.of(Material.STONE).hardness(0.5f).resistance(1.0f).sounds(BlockSoundGroup.STONE)), buildingBlock());
        LIGHT_HELLFIRE_STONE_TRAP = register("light_hellfire_stone_trap", new Block(FabricBlockSettings.of(Material.STONE).hardness(-1.0f).resistance(6000000.0f).sounds(BlockSoundGroup.STONE)));

        MOSSY_HOLYSTONE_SLAB = register("mossy_holystone_slab", new AetherSlabBlock(MOSSY_HOLYSTONE.getDefaultState()), buildingBlock());
        MOSSY_HOLYSTONE_STAIRS = register("mossy_holystone_stairs", new AetherStairsBlock(MOSSY_HOLYSTONE.getDefaultState()), buildingBlock());
        MOSSY_HOLYSTONE_WALL = register("mossy_holystone_wall", new AetherWallBlock(MOSSY_HOLYSTONE.getDefaultState()), buildingBlock());

        PILLAR = register("pillar", new Block(FabricBlockSettings.of(Material.STONE, MapColor.OFF_WHITE).requiresTool().hardness(0.5f).resistance(1.0f).sounds(BlockSoundGroup.STONE)), buildingBlock());
        PILLAR_TOP = register("pillar_top", new Block(FabricBlockSettings.of(Material.STONE, MapColor.OFF_WHITE).hardness(0.5f).resistance(1.0f).sounds(BlockSoundGroup.STONE)), buildingBlock());

//        POTTED_PURPLE_FLOWER = register("potted_purple_flower", createPottedBlock(PURPLE_FLOWER));
//        POTTED_WHITE_FLOWER = register("potted_white_flower", createPottedBlock(WHITE_FLOWER));
        PRESENT = register("present", new Block(FabricBlockSettings.of(Material.PLANT, MapColor.GREEN).requiresTool().strength(0.6f, 0.6f).sounds(BlockSoundGroup.GRASS)), buildingBlock());

		PURPLE_FLOWER = register("purple_flower", new FlowerBlock(StatusEffects.INSTANT_DAMAGE, 1, AbstractBlock.Settings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)), buildingBlock());
		WHITE_FLOWER = register("white_flower", new FlowerBlock(StatusEffects.ABSORPTION, 1, AbstractBlock.Settings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)), buildingBlock());
        QUICKSOIL = register("quicksoil", new Block(FabricBlockSettings.of(Material.AGGREGATE).strength(0.5f, -1.0f).slipperiness(1.0F).velocityMultiplier(1.102F).sounds(BlockSoundGroup.SAND).breakByTool(FabricToolTags.SHOVELS)), buildingBlock());
        QUICKSOIL_GLASS = register("quicksoil_glass", new GlassBlock(FabricBlockSettings.of(Material.GLASS).luminance(14).strength(0.2f, -1.0f).sounds(BlockSoundGroup.GLASS).nonOpaque().solidBlock(AetherBlocks::never)), buildingBlock());
        QUICKSOIL_GLASS_PANE = register("quicksoil_glass_pane", new QuicksoilGlassPaneBlock(), buildingBlock());

        final FabricBlockSettings SENTRY_STONES = FabricBlockSettings.of(Material.STONE).hardness(0.5f).resistance(1.0f).sounds(BlockSoundGroup.STONE);

        SENTRY_STONE = register("sentry_stone", new Block(SENTRY_STONES.luminance(ignored -> 10)), buildingBlock());
        SENTRY_STONE_TRAP = register("sentry_stone_trap", new Block(FabricBlockSettings.of(Material.STONE).hardness(-1.0f).resistance(6000000.0f).sounds(BlockSoundGroup.STONE)));


        final Block.Settings SAPLINGS = AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS);
        SKYROOT_SAPLING = register("skyroot_sapling", new AetherSaplingBlock(new SkyrootSaplingGenerator(), SAPLINGS), buildingBlock());
        POTTED_SKYROOT_SAPLING = register("potted_skyroot_sapling", createPottedBlock(SKYROOT_SAPLING));
        SKYROOT_LOG = register("skyroot_log", createLogBlock(MapColor.GREEN, MapColor.OAK_TAN), buildingBlock());
        STRIPPED_SKYROOT_LOG = register("stripped_skyroot_log", createLogBlock(MapColor.OAK_TAN, MapColor.OAK_TAN), buildingBlock());
        SKYROOT_LEAVES = register("skyroot_leaves", createLeavesBlock(), buildingBlock());

        final FabricBlockSettings SKYROOT_WOOD = FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD);
        SKYROOT_PLANKS = register("skyroot_planks", new Block(SKYROOT_WOOD), buildingBlock());
        SKYROOT_BOOKSHELF = register("skyroot_bookshelf", new Block(FabricBlockSettings.of(Material.WOOD).strength(1.5f).sounds(BlockSoundGroup.WOOD)), buildingBlock());
        SKYROOT_FENCE = register("skyroot_fence", new FenceBlock(SKYROOT_WOOD), buildingBlock());
        SKYROOT_FENCE_GATE = register("skyroot_fence_gate", new FenceGateBlock(SKYROOT_WOOD), buildingBlock());
        SKYROOT_SLAB = register("skyroot_slab", new AetherSlabBlock(SKYROOT_PLANKS.getDefaultState()), buildingBlock());
        SKYROOT_STAIRS = register("skyroot_stairs", new AetherStairsBlock(SKYROOT_PLANKS.getDefaultState()), buildingBlock());
        SKYROOT_TRAPDOOR = register("skyroot_trapdoor", new AetherTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR)), buildingBlock());
        SKYROOT_DOOR = register("skyroot_door", new AetherDoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR)), buildingBlock());

        GOLDEN_OAK_SAPLING = register("golden_oak_sapling", new AetherSaplingBlock(new GoldenOakSaplingGenerator(), SAPLINGS), buildingBlock());
        POTTED_GOLDEN_OAK_SAPLING = register("potted_golden_oak_sapling", createPottedBlock(GOLDEN_OAK_SAPLING));
        GOLDEN_OAK_LOG = register("golden_oak_log", createLogBlock(MapColor.OAK_TAN, MapColor.RED), buildingBlock());
        STRIPPED_GOLDEN_OAK_LOG = register("stripped_golden_oak_log", createLogBlock(MapColor.RED, MapColor.RED), buildingBlock());
        GOLDEN_OAK_LEAVES = register("golden_oak_leaves", createLeavesBlock(), buildingBlock());
		CRYSTAL_LEAVES = register("crystal_leaves", createCrystalLeavesBlock(BlockSoundGroup.GLASS), buildingBlock());
        
        SUN_ALTAR = register("sun_alter", new Block(FabricBlockSettings.of(Material.STONE, MapColor.RED).requiresTool().strength(0.5f, 10.0f).sounds(BlockSoundGroup.STONE)), buildingBlock());
        ZANITE_BLOCK = register("zanite_block", new Block(FabricBlockSettings.of(Material.METAL).strength(3.0f, -1.0f).sounds(BlockSoundGroup.METAL)), buildingBlock());
//        BLOCK_OF_GRAVITITE = register("block_of_gravitite", new FloatingBlock(false, FabricBlockSettings.of(Material.METAL).strength(3.0f, -1.0f).sounds(BlockSoundGroup.METAL)), buildingBlock());

    }

    static {
        // Logs
        for (Block block : new Block[]{
                SKYROOT_LOG,
                STRIPPED_SKYROOT_LOG,
                GOLDEN_OAK_LOG,
                STRIPPED_GOLDEN_OAK_LOG
        }) {
            registerFlammable(block, 5, 5);
        }
        // Plank stuff
        for (Block block : new Block[]{
                SKYROOT_PLANKS,
                SKYROOT_SLAB,
                SKYROOT_FENCE_GATE,
                SKYROOT_FENCE,
                SKYROOT_STAIRS
        }) {
            registerFlammable(block, 20, 5);
        }
        // Leaves and leaf stuff
        for (Block block : new Block[]{
                SKYROOT_LEAVES,
                GOLDEN_OAK_LEAVES,
				HOLIDAY_LEAVES,
				DECORATED_HOLIDAY_LEAVES,
                CRYSTAL_LEAVES
        }) {
            registerFlammable(block, 60, 30);
        }
        // Grass
        for (Block block : new Block[]{
                BLUEBERRY_BUSH
        }) {
            registerFlammable(block, 100, 60);
        }
        // Misc
        registerFlammable(SKYROOT_BOOKSHELF, 20, 30);

    }

    private static Item.Settings buildingBlock() {
        return new FabricItemSettings().group(AetherItemGroups.Blocks);
    }

    private static Block register(String id, Block block, Item.Settings settings) {
        return register(id, block, true, settings);
    }

    private static void registerFlammable(Block block, int flammability, int encouragement) {
        FlammableBlockRegistry.getDefaultInstance().add(block, flammability, encouragement);
    }

    private static Block register(String id, Block block, boolean registerAsBlockItem, Item.Settings settings) {
        Identifier trueId = Aether.locate(id);
        Registry.register(Registry.BLOCK, trueId, block);
        if (registerAsBlockItem) Registry.register(Registry.ITEM, trueId, new BlockItem(block, settings));
        return block;
    }

    private static Block register(String id, Block block, Block rootBlock, Item.Settings settings) {
        Identifier trueId = Aether.locate(id);
        Registry.register(Registry.BLOCK, trueId, block);
        Registry.register(Registry.ITEM, trueId, new WallStandingBlockItem(rootBlock, block, settings));
        return block;
    }

    private static Block register(String id, Block block) {
        return Registry.register(Registry.BLOCK, Aether.locate(id), block);
    }

    private static PillarBlock createLogBlock(MapColor topMapColor, MapColor sideMapColor) {
        return new PillarBlock(AbstractBlock.Settings.of(Material.WOOD, (blockState) -> blockState.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    }

    private static AetherLeavesBlock createLeavesBlock() {
        return new AetherLeavesBlock(AbstractBlock.Settings.of(Material.LEAVES).strength(0.2f).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning((a, b, c, d) -> false).suffocates(AetherBlocks::never).blockVision(AetherBlocks::never), true);
    }

    private static FabricBlockSettings createLeafPileBlock(BlockSoundGroup sounds) {
        return FabricBlockSettings.of(Material.REPLACEABLE_PLANT).strength(0.2f).sounds(sounds).nonOpaque().suffocates(AetherBlocks::never).blockVision(AetherBlocks::never);
    }

    private static FabricBlockSettings createWisteriaHangerBlock(BlockSoundGroup sounds) {
        return FabricBlockSettings.of(Material.DECORATION).strength(0.2f).noCollision().breakInstantly().sounds(sounds).nonOpaque().suffocates(AetherBlocks::never).blockVision(AetherBlocks::never);
    }

    private static AetherLeavesBlock createLeavesBlock(BlockSoundGroup sounds) {
        return new AetherLeavesBlock(AbstractBlock.Settings.of(Material.LEAVES).strength(0.2f).ticksRandomly().sounds(sounds).nonOpaque().allowsSpawning((a, b, c, d) -> false).suffocates(AetherBlocks::never).blockVision(AetherBlocks::never), true);
    }

    private static AetherLeavesBlock createLeavesBlock(int luminance) {
        return new AetherLeavesBlock(AbstractBlock.Settings.of(Material.LEAVES).strength(0.2f).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning((a, b, c, d) -> false).suffocates(AetherBlocks::never).blockVision(AetherBlocks::never).luminance(ignored -> luminance), true);
    }

    private static CrystalLeavesBlock createCrystalLeavesBlock(BlockSoundGroup sounds) {
        return new CrystalLeavesBlock(AbstractBlock.Settings.of(Material.LEAVES).strength(0.2f).ticksRandomly().sounds(sounds).nonOpaque().allowsSpawning((a, b, c, d) -> false).suffocates(AetherBlocks::never).blockVision(AetherBlocks::never));
    }

    private static FlowerPotBlock createPottedBlock(Block sourceBlock) {
        return new FlowerPotBlock(sourceBlock, AbstractBlock.Settings.of(Material.DECORATION).breakInstantly().nonOpaque());
    }

    public static void init() {

    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(BLUE_PORTAL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BLUEBERRY_BUSH, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BLUEBERRY_BUSH, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(QUICKSOIL_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(QUICKSOIL_GLASS, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(QUICKSOIL_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(QUICKSOIL_GLASS_PANE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AEROGEL, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AMBROSIUM_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AMBROSIUM_TORCH_WALL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SKYROOT_LEAVES, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(GOLDEN_OAK_LEAVES, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(CRYSTAL_LEAVES, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(HOLIDAY_LEAVES, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(DECORATED_HOLIDAY_LEAVES, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(SKYROOT_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SKYROOT_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutoutMipped(), SKYROOT_SAPLING, GOLDEN_OAK_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlock(QUICKSOIL_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(QUICKSOIL_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(COLD_AERCLOUD, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(BLUE_AERCLOUD, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(PINK_AERCLOUD, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(GOLDEN_AERCLOUD, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AETHER_GRASS_BLOCK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutoutMipped(), POTTED_SKYROOT_SAPLING, POTTED_GOLDEN_OAK_SAPLING);
        BlockRenderLayerMap.INSTANCE.putBlock(WHITE_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PURPLE_FLOWER, RenderLayer.getCutout());

    }

    private static Boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return type == EntityType.OCELOT || type == EntityType.PARROT;
    }

    public static boolean never(BlockState blockState, BlockView blockView, BlockPos blockPos) {
        return false;
    }

    public static boolean always(BlockState blockState, BlockView blockView, BlockPos blockPos) {
        return true;
    }
}
