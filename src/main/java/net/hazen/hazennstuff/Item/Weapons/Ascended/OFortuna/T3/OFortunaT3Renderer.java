package net.hazen.hazennstuff.Item.Weapons.Ascended.OFortuna.T3;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class OFortunaT3Renderer extends GeoItemRenderer<OFortunaT3> {
    public OFortunaT3Renderer() {
        super(new OFortunaT3Model());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
