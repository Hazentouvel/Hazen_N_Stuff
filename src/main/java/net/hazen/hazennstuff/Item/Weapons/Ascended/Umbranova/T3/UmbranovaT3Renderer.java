package net.hazen.hazennstuff.Item.Weapons.Ascended.Umbranova.T3;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class UmbranovaT3Renderer extends GeoItemRenderer<UmbranovaT3> {
    public UmbranovaT3Renderer() {
        super(new UmbranovaT3Model());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
