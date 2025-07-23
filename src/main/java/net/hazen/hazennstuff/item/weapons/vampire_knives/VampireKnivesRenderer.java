package net.hazen.hazennstuff.item.weapons.vampire_knives;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class VampireKnivesRenderer extends GeoItemRenderer<VampireKnivesItem> {
    public VampireKnivesRenderer() {
        super(new VampireKnivesModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
