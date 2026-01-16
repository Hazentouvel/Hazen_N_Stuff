package net.hazen.hazennstuff.Item.Staves.GrimoireStaff;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class GrimoireStaffRenderer extends GeoItemRenderer<GrimoireStaff> {
    public GrimoireStaffRenderer() {
        super(new GrimoireStaffModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
