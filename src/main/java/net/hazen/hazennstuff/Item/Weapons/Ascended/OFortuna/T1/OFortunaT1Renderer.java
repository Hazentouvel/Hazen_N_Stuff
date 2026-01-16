package net.hazen.hazennstuff.Item.Weapons.Ascended.OFortuna.T1;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class OFortunaT1Renderer extends GeoItemRenderer<OFortunaT1> {
    public OFortunaT1Renderer() {
        super(new OFortunaT1Model());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
