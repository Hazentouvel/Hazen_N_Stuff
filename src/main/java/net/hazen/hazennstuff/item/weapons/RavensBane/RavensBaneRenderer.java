package net.hazen.hazennstuff.item.weapons.RavensBane;

import net.hazen.hazennstuff.item.weapons.WarFlamingLance.WarFlamingLanceItem;
import net.hazen.hazennstuff.item.weapons.WarFlamingLance.WarFlamingLanceModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class RavensBaneRenderer extends GeoItemRenderer<RavensBaneItem> {
    public RavensBaneRenderer() {
        super(new RavensBaneModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
