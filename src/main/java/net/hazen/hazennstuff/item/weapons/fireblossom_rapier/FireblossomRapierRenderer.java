package net.hazen.hazennstuff.item.weapons.fireblossom_rapier;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class FireblossomRapierRenderer extends GeoItemRenderer<FireblossomRapierItem> {
    public FireblossomRapierRenderer() {
        super(new FireblossomRapierModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
