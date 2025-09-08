package net.hazen.hazennstuff.item.weapons.Malice;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class MaliceRenderer extends GeoItemRenderer<MaliceItem> {
    public MaliceRenderer() {
        super(new MaliceModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
