package net.hazen.hazennstuff.item.staves.frieren;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class FrierenStaffRenderer extends GeoItemRenderer<FrierenStaffItem> {
    public FrierenStaffRenderer() {
        super(new FrierenStaffModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
