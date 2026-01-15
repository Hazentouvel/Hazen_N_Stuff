package net.hazen.hazennstuff.Items.Equipment.Staves.EnderconicScepter;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class EnderconicStaffRenderer extends GeoItemRenderer<EnderconicStaff> {
    public EnderconicStaffRenderer(EnderconicStaffModel enderconicStaffModel) {
        super(new EnderconicStaffModel());
        this.addRenderLayer(new EnderconicStaffLayer(this));
    }
}
