package net.hazen.hazennstuff.item.weapons.NightsEdge;

import net.hazen.hazennstuff.item.weapons.lights_bane.LightsBaneItem;
import net.hazen.hazennstuff.item.weapons.lights_bane.LightsBaneModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class NightsEdgeRenderer extends GeoItemRenderer<NightsEdgeItem> {
    public NightsEdgeRenderer() {
        super(new NightsEdgeModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
