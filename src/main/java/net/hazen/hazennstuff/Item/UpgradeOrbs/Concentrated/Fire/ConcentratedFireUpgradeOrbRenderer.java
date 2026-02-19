package net.hazen.hazennstuff.Item.UpgradeOrbs.Concentrated.Fire;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class ConcentratedFireUpgradeOrbRenderer extends GeoItemRenderer<ConcentratedFireUpgradeOrb> {
    public ConcentratedFireUpgradeOrbRenderer() {
        super(new ConcentratedFireUpgradeOrbModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
