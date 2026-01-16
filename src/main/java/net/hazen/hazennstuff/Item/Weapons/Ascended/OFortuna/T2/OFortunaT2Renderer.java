package net.hazen.hazennstuff.Item.Weapons.Ascended.OFortuna.T2;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class OFortunaT2Renderer extends GeoItemRenderer<OFortunaT2> {
    public OFortunaT2Renderer() {
        super(new OFortunaT2Model());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
