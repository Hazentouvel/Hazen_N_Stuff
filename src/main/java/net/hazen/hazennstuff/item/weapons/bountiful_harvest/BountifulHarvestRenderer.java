package net.hazen.hazennstuff.item.weapons.bountiful_harvest;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class BountifulHarvestRenderer extends GeoItemRenderer<BountifulHarvestItem> {
    public BountifulHarvestRenderer() {
        super(new BountifulHarvestModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
