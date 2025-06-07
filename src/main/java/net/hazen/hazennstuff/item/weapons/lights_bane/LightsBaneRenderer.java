package net.hazen.hazennstuff.item.weapons.lights_bane;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class LightsBaneRenderer extends GeoItemRenderer<LightsBaneItem> {
    public LightsBaneRenderer() {
        super(new LightsBaneModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
