package net.hazen.hazennstuff.Item.Weapons.Ascended.Devastator.T3;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class DevastatorT3Renderer extends GeoItemRenderer<DevastatorT3> {
    public DevastatorT3Renderer() {
        super(new DevastatorT3Model());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
