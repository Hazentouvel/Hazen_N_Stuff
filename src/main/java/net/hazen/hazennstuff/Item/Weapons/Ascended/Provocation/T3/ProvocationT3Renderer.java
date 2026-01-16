package net.hazen.hazennstuff.Item.Weapons.Ascended.Provocation.T3;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class ProvocationT3Renderer extends GeoItemRenderer<ProvocationT3> {
    public ProvocationT3Renderer() {
        super(new ProvocationT3Model());

        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
