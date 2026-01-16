package net.hazen.hazennstuff.Item.Weapons.Ascended.Umbranova.T1;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class UmbranovaT1Renderer extends GeoItemRenderer<UmbranovaT1> {
    public UmbranovaT1Renderer() {
        super(new UmbranovaT1Model());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
