package net.hazen.hazennstuff.Items.Equipment.Weapons.OFortuna;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class OFortunaRenderer extends GeoItemRenderer<OFortunaItem> {
    public OFortunaRenderer(OFortunaModel oFortunaModel) {
        super(new OFortunaModel());
        this.addRenderLayer(new OFortunaLayer(this));
    }
}
