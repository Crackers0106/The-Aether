package com.aether.client.rendering.armor;

import com.aether.client.model.armor.ObsidianArmorModel;
import com.aether.items.armor.ObsidianArmor;
import software.bernie.geckolib3.renderer.geo.GeoArmorRenderer;

public class ObsidianArmorRenderer extends GeoArmorRenderer<ObsidianArmor> {
    public ObsidianArmorRenderer() {
        super(new ObsidianArmorModel());
    }
}