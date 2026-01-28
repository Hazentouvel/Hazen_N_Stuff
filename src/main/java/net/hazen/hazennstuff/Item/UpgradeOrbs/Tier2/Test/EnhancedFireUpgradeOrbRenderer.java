package net.hazen.hazennstuff.Item.UpgradeOrbs.Tier2.Test;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class EnhancedFireUpgradeOrbRenderer extends GeoItemRenderer<EnhancedFireUpgradeOrb> {
    public EnhancedFireUpgradeOrbRenderer() {
        super(new EnhancedFireUpgradeOrbModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
