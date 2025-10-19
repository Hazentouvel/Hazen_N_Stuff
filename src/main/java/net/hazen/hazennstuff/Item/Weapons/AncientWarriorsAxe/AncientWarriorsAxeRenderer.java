package net.hazen.hazennstuff.Item.Weapons.AncientWarriorsAxe;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class AncientWarriorsAxeRenderer extends GeoItemRenderer<AncientWarriorsAxeItem> {
    public AncientWarriorsAxeRenderer() {
        super(new AncientWarriorsAxeModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
