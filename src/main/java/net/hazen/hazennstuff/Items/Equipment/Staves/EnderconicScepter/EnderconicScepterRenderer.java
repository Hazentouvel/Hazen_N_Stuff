package net.hazen.hazennstuff.Items.Equipment.Staves.EnderconicScepter;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class EnderconicScepterRenderer extends GeoItemRenderer<EnderconicScepter> {
    public EnderconicScepterRenderer(EnderconicScepterModel enderconicScepterModel) {
        super(new EnderconicScepterModel());
        this.addRenderLayer(new EnderconicScepterLayer(this));
    }
}
