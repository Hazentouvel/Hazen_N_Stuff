package net.hazen.hazennstuff.Items.Equipment.Weapons.Umbranova;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class UmbranovaRenderer extends GeoItemRenderer<UmbranovaItem> {
    public UmbranovaRenderer(UmbranovaModel umbranovaModel) {
        super(new UmbranovaModel());
        this.addRenderLayer(new UmbranovaLayer(this));
    }
}
