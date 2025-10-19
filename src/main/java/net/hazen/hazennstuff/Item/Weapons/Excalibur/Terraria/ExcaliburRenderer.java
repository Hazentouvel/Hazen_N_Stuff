package net.hazen.hazennstuff.Item.Weapons.Excalibur.Terraria;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class ExcaliburRenderer extends GeoItemRenderer<ExcaliburItem> {
    public ExcaliburRenderer() {
        super(new ExcaliburModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
