package net.hazen.hazennstuff.Item.Weapons.LightsBane;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class LightsBaneRenderer extends GeoItemRenderer<LightsBaneItem> {
    public LightsBaneRenderer() {
        super(new LightsBaneModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
