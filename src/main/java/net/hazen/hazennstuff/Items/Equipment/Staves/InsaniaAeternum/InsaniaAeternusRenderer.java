package net.hazen.hazennstuff.Items.Equipment.Staves.InsaniaAeternum;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class InsaniaAeternusRenderer extends GeoItemRenderer<InsaniaAeternus> {
    public InsaniaAeternusRenderer(InsaniaAeternusModel insaniaAeternusModel) {
        super(new InsaniaAeternusModel());
        this.addRenderLayer(new InsaniaAeternusLayer(this));
    }
}
