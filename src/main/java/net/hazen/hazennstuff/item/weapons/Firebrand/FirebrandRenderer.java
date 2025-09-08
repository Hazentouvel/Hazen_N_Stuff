package net.hazen.hazennstuff.item.weapons.Firebrand;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class FirebrandRenderer extends GeoItemRenderer<FirebrandItem> {
    public FirebrandRenderer() {
        super(new FirebrandModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
