package net.hazen.hazennstuff.Item.Staves.EnderconicScepter;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class EnderconicScepterRenderer extends GeoItemRenderer<EnderconicScepter> {
    public EnderconicScepterRenderer() {
        super(new EnderconicScepterModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
