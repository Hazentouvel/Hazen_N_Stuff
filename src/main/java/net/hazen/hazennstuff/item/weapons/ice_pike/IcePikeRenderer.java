package net.hazen.hazennstuff.item.weapons.ice_pike;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class IcePikeRenderer extends GeoItemRenderer<IcePikeItem> {
    public IcePikeRenderer() {
        super(new IcePikeModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
