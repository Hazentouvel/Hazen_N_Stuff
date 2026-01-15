package net.hazen.hazennstuff.Items.Equipment.Staves.GrimoireStaff;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class GrimoireStaffRenderer extends GeoItemRenderer<GrimoireStaff> {
    public GrimoireStaffRenderer(GrimoireStaffModel grimoireStaffModel) {
        super(new GrimoireStaffModel());
        this.addRenderLayer(new GrimoireStaffLayer(this));
    }
}
