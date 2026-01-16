package net.hazen.hazennstuff.Item.Weapons.Ascended.RavensBane;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class RavensBaneRenderer extends GeoItemRenderer<RavensBaneItem> {
    public RavensBaneRenderer() {
        super(new RavensBaneModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
