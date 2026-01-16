package net.hazen.hazennstuff.Item.Weapons.Ascended.Devastator.T1;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class DevastatorT1Renderer extends GeoItemRenderer<DevastatorT1> {
    public DevastatorT1Renderer() {
        super(new DevastatorT1Model());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
