package net.hazen.hazennstuff.Item.Weapons.Ascended.Provocation.Dormant;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class ProvocationRenderer extends GeoItemRenderer<Provocation> {
    public ProvocationRenderer() {
        super(new ProvocationModel());

        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
