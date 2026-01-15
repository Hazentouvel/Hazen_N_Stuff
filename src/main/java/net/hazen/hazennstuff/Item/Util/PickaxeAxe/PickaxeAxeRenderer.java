package net.hazen.hazennstuff.Item.Util.PickaxeAxe;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class PickaxeAxeRenderer extends GeoItemRenderer<PickaxeAxeItem> {
    public PickaxeAxeRenderer() {
        super(new PickaxeAxeModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
