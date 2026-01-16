package net.hazen.hazennstuff.Item.Weapons.Generic.FireblossomRapier;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class FireblossomRapierRenderer extends GeoItemRenderer<FireblossomRapierItem> {
    public FireblossomRapierRenderer() {
        super(new FireblossomRapierModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
