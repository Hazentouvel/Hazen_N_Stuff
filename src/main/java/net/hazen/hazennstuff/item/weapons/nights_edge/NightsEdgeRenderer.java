package net.hazen.hazennstuff.item.weapons.nights_edge;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class NightsEdgeRenderer extends GeoItemRenderer<NightsEdgeItem> {
    public NightsEdgeRenderer() {
        super(new NightsEdgeModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
