package net.hazen.hazennstuff.Item.Weapons.Generic.Starfury;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class StarfuryRenderer extends GeoItemRenderer<StarfuryItem> {
    public StarfuryRenderer() {
        super(new StarfuryModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
