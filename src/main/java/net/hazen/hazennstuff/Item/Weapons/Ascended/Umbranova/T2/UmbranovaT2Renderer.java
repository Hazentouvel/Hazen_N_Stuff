package net.hazen.hazennstuff.Item.Weapons.Ascended.Umbranova.T2;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class UmbranovaT2Renderer extends GeoItemRenderer<UmbranovaT2> {
    public UmbranovaT2Renderer() {
        super(new UmbranovaT2Model());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
