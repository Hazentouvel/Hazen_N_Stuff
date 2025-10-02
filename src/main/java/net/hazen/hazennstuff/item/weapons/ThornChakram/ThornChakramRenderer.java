package net.hazen.hazennstuff.item.weapons.ThornChakram;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ThornChakramRenderer extends GeoItemRenderer<ThornChakramItem> {
    public ThornChakramRenderer() {
        super(new ThornChakramModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
