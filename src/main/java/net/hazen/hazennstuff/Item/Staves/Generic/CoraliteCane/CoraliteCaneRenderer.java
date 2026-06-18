package net.hazen.hazennstuff.Item.Staves.Generic.CoraliteCane;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class CoraliteCaneRenderer extends GeoItemRenderer<CoraliteCane> {
    public CoraliteCaneRenderer() {
        super(new CoraliteCaneModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
