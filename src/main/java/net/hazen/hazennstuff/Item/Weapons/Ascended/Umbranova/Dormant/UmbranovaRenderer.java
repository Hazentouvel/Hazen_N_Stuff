package net.hazen.hazennstuff.Item.Weapons.Ascended.Umbranova.Dormant;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class UmbranovaRenderer extends GeoItemRenderer<Umbranova> {
    public UmbranovaRenderer() {
        super(new UmbranovaModel());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
