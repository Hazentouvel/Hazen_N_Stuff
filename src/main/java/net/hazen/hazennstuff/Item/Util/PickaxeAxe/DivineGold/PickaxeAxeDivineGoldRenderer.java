package net.hazen.hazennstuff.Item.Util.PickaxeAxe.DivineGold;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class PickaxeAxeDivineGoldRenderer extends GeoItemRenderer<PickaxeAxeDivineGoldItem> {
    public PickaxeAxeDivineGoldRenderer() {
        super(new PickaxeAxeDivineGoldModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
