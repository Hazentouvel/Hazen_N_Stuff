package net.hazen.hazennstuff.Item.Weapons.Ascended.Devastator.Dormant;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class DevastatorRenderer extends GeoItemRenderer<Devastator> {
    public DevastatorRenderer() {
        super(new DevastatorModel());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
