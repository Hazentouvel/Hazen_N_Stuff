package net.hazen.hazennstuff.Item.Weapons.Generic.NightsEdge;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class NightsEdgeRenderer extends GeoItemRenderer<NightsEdgeItem> {
    public NightsEdgeRenderer() {
        super(new NightsEdgeModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
