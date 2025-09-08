package net.hazen.hazennstuff.item.weapons.DivineGreatsword;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class DivineGreatswordRenderer extends GeoItemRenderer<DivineGreatswordItem> {
    public DivineGreatswordRenderer() {
        super(new DivineGreatswordModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
