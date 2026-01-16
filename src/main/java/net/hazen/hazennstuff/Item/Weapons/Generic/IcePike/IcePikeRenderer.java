package net.hazen.hazennstuff.Item.Weapons.Generic.IcePike;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class IcePikeRenderer extends GeoItemRenderer<IcePikeItem> {
    public IcePikeRenderer() {
        super(new IcePikeModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
