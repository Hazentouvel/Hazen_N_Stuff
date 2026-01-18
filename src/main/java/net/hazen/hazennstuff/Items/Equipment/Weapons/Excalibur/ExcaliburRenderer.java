package net.hazen.hazennstuff.Items.Equipment.Weapons.Excalibur;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ExcaliburRenderer extends GeoItemRenderer<ExcaliburItem> {
    public ExcaliburRenderer(ExcaliburModel excaliburModel) {
        super(new ExcaliburModel());
        this.addRenderLayer(new ExcaliburLayer(this));
    }
}
