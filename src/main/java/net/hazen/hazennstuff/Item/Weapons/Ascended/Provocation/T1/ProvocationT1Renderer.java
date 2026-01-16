package net.hazen.hazennstuff.Item.Weapons.Ascended.Provocation.T1;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class ProvocationT1Renderer extends GeoItemRenderer<ProvocationT1> {
    public ProvocationT1Renderer() {
        super(new ProvocationT1Model());

        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
