package net.hazen.hazennstuff.Item.Weapons.Generic.AstraliteCleaver;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class AstraliteCleaverRenderer extends GeoItemRenderer<AstraliteCleaver> {
    public AstraliteCleaverRenderer() {
        super(new AstraliteCleaverModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
