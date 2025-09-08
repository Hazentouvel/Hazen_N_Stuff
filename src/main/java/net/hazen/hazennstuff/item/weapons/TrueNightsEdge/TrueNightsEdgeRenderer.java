package net.hazen.hazennstuff.item.weapons.TrueNightsEdge;

import net.hazen.hazennstuff.item.weapons.NightsEdge.NightsEdgeItem;
import net.hazen.hazennstuff.item.weapons.NightsEdge.NightsEdgeModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class TrueNightsEdgeRenderer extends GeoItemRenderer<TrueNightsEdgeItem> {
    public TrueNightsEdgeRenderer() {
        super(new TrueNightsEdgeModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
