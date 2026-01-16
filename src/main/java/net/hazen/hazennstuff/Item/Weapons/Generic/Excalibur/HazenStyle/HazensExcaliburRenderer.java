package net.hazen.hazennstuff.Item.Weapons.Generic.Excalibur.HazenStyle;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class HazensExcaliburRenderer extends GeoItemRenderer<HazensExcaliburItem> {
    public HazensExcaliburRenderer() {
        super(new HazensExcaliburModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
