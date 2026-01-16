package net.hazen.hazennstuff.Item.Weapons.Ascended.OFortuna.Dormant;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class OFortunaRenderer extends GeoItemRenderer<OFortuna> {
    public OFortunaRenderer() {
        super(new OFortunaModel());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
