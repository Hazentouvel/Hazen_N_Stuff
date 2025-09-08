package net.hazen.hazennstuff.item.weapons.MageBane;

import net.hazen.hazennstuff.item.weapons.lights_bane.LightsBaneItem;
import net.hazen.hazennstuff.item.weapons.lights_bane.LightsBaneModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class MageBaneRenderer extends GeoItemRenderer<MageBaneItem> {
    public MageBaneRenderer() {
        super(new MageBaneModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
