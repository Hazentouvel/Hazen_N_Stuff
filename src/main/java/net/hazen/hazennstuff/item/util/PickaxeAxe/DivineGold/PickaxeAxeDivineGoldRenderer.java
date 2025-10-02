package net.hazen.hazennstuff.item.util.PickaxeAxe.DivineGold;

import net.hazen.hazennstuff.item.util.PickaxeAxe.PickaxeAxeItem;
import net.hazen.hazennstuff.item.util.PickaxeAxe.PickaxeAxeModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class PickaxeAxeDivineGoldRenderer extends GeoItemRenderer<PickaxeAxeDivineGoldItem> {
    public PickaxeAxeDivineGoldRenderer() {
        super(new PickaxeAxeDivineGoldModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
