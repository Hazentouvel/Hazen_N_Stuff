package net.hazen.hazennstuff.Item.Weapons.Generic.VampireKnives;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class VampireKnivesRenderer extends GeoItemRenderer<VampireKnivesItem> {
    public VampireKnivesRenderer() {
        super(new VampireKnivesModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
