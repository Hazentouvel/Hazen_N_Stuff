package net.hazen.hazennstuff.Item.Weapons.TheDevourer;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class TheDevourerRenderer extends GeoItemRenderer<TheDevourerItem> {
    public TheDevourerRenderer() {
        super(new TheDevourerModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
