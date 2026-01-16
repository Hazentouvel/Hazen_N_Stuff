package net.hazen.hazennstuff.Item.Weapons.Generic.FrostburnDagger;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class FrostburnDaggerRenderer extends GeoItemRenderer<FrostburnDaggerItem> {
    public FrostburnDaggerRenderer() {
        super(new FrostburnDaggerModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
