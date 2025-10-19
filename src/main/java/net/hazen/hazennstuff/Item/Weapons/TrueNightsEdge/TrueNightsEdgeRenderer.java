package net.hazen.hazennstuff.Item.Weapons.TrueNightsEdge;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class TrueNightsEdgeRenderer extends GeoItemRenderer<TrueNightsEdgeItem> {
    public TrueNightsEdgeRenderer() {
        super(new TrueNightsEdgeModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
