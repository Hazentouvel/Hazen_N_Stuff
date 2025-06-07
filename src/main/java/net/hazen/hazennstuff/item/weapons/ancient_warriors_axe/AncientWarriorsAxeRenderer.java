package net.hazen.hazennstuff.item.weapons.ancient_warriors_axe;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class AncientWarriorsAxeRenderer extends GeoItemRenderer<AncientWarriorsAxeItem> {
    public AncientWarriorsAxeRenderer() {
        super(new AncientWarriorsAxeModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
