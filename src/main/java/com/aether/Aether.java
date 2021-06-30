package com.aether;

import com.aether.blocks.AetherBlocks;
import com.aether.client.model.AetherArmorModels;
import com.aether.client.model.AetherModelPredicates;
import com.aether.client.rendering.block.AetherColorProvs;
import com.aether.client.rendering.entity.AetherEntityRenderers;

import com.aether.entities.AetherEntityTypes;
import com.aether.entities.util.AetherMoaTypes;
import com.aether.items.AetherItems;
import com.aether.registry.TrinketSlotRegistry;
import com.aether.world.dimension.AetherDimension;
import com.aether.world.feature.AetherConfiguredFeatures;
import com.aether.world.feature.AetherFeatures;
import de.guntram.mcmod.crowdintranslate.CrowdinTranslate;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Aether implements ModInitializer, ClientModInitializer {

    public static final String MOD_ID = "the_aether";
    public static final Logger LOG = LogManager.getLogger(MOD_ID);

    public static Identifier locate(String location) {
        return new Identifier(MOD_ID, location);
    }

    @Override
    public void onInitialize() {
        TrinketSlotRegistry.init();
        AetherFeatures.registerFeatures();
        AetherConfiguredFeatures.registerFeatures();
        AetherDimension.setupDimension();
        AetherEntityTypes.init();
        AetherItems.init();
        AetherBlocks.init();
        AetherMoaTypes.init();
		FuelRegistry.INSTANCE.add(AetherItems.AMBROSIUM_SHARD, 500);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void onInitializeClient() {
        CrowdinTranslate.downloadTranslations("aether", MOD_ID);
        AetherItems.initClient();
        AetherModelPredicates.init();
        AetherArmorModels.registerArmorModels();
        AetherEntityRenderers.initClient();
        AetherBlocks.initClient();
        //AetherSounds.initializeClient();
    }
}
