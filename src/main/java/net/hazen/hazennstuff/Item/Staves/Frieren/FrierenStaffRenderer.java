package net.hazen.hazennstuff.Item.Staves.Frieren;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class FrierenStaffRenderer extends GeoItemRenderer<FrierenStaff> {
    public FrierenStaffRenderer() {
        super(new FrierenStaffModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
