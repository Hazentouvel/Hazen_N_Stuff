package net.hazen.hazennstuff.Item.Staves.Reference.Frieren;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class FrierenStaffRenderer extends GeoItemRenderer<FrierenStaff> {
    public FrierenStaffRenderer() {
        super(new FrierenStaffModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
