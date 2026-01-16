package net.hazen.hazennstuff.Item.Weapons.Ascended.Provocation.T2;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class ProvocationT2Renderer extends GeoItemRenderer<ProvocationT2> {
    public ProvocationT2Renderer() {
        super(new ProvocationT2Model());

        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
