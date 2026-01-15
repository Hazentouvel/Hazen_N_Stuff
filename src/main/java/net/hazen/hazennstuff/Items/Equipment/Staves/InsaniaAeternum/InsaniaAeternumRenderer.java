package net.hazen.hazennstuff.Items.Equipment.Staves.InsaniaAeternum;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class InsaniaAeternumRenderer extends GeoItemRenderer<InsaniaAeternum> {
    public InsaniaAeternumRenderer(InsaniaAeternumModel insaniaAeternumModel) {
        super(new InsaniaAeternumModel());
        this.addRenderLayer(new InsaniaAeternumLayer(this));
    }
}
