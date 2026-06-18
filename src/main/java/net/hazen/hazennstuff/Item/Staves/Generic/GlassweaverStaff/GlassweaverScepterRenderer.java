package net.hazen.hazennstuff.Item.Staves.Generic.GlassweaverStaff;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class GlassweaverScepterRenderer extends GeoItemRenderer<GlassweaverScepter> {
    public GlassweaverScepterRenderer() {
        super(new GlassweaverStaffModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
