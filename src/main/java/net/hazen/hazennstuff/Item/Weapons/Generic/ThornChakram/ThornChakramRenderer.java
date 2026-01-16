package net.hazen.hazennstuff.Item.Weapons.Generic.ThornChakram;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ThornChakramRenderer extends GeoItemRenderer<ThornChakramItem> {
    public ThornChakramRenderer() {
        super(new ThornChakramModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
