package net.hazen.hazennstuff.Item.Weapons.Ascended.Devastator.T2;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class DevastatorT2Renderer extends GeoItemRenderer<DevastatorT2> {
    public DevastatorT2Renderer() {
        super(new DevastatorT2Model());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
