package net.hazen.hazennstuff.item.weapons.NightsEdge;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class NightsEdgeRenderer extends GeoItemRenderer<NightsEdgeItem> {
    public NightsEdgeRenderer() {
        super(new NightsEdgeModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
