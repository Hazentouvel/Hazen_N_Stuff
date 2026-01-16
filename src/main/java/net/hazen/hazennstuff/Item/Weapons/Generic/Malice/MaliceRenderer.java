package net.hazen.hazennstuff.Item.Weapons.Generic.Malice;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class MaliceRenderer extends GeoItemRenderer<MaliceItem> {
    public MaliceRenderer() {
        super(new MaliceModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
