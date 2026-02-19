package net.hazen.hazennstuff.Item.UpgradeOrbs.Concentrated.Ice;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class ConcentratedIceUpgradeOrbRenderer extends GeoItemRenderer<ConcentratedIceUpgradeOrb> {
    public ConcentratedIceUpgradeOrbRenderer() {
        super(new ConcentratedIceUpgradeOrbModel());
    }
}
