package net.hazen.hazennstuff.Item.Weapons.WarFlamingLance;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class WarFlamingLanceRenderer extends GeoItemRenderer<WarFlamingLanceItem> {
    public WarFlamingLanceRenderer() {
        super(new WarFlamingLanceModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
