package net.hazen.hazennstuff.item.weapons.ThornChakram;

import net.hazen.hazennstuff.item.weapons.bountiful_harvest.BountifulHarvestItem;
import net.hazen.hazennstuff.item.weapons.bountiful_harvest.BountifulHarvestModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ThornChakramRenderer extends GeoItemRenderer<ThornChakramItem> {
    public ThornChakramRenderer() {
        super(new ThornChakramModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
