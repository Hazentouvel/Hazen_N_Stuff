package net.hazen.hazennstuff.Item.Weapons.Generic.MageBane;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class MageBaneRenderer extends GeoItemRenderer<MageBaneItem> {
    public MageBaneRenderer() {
        super(new MageBaneModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
