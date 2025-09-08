package net.hazen.hazennstuff.item.weapons.Excalibur.Terraria;

import net.hazen.hazennstuff.item.weapons.Excalibur.HazenStyle.HazensExcaliburItem;
import net.hazen.hazennstuff.item.weapons.Excalibur.HazenStyle.HazensExcaliburModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class ExcaliburRenderer extends GeoItemRenderer<ExcaliburItem> {
    public ExcaliburRenderer() {
        super(new ExcaliburModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
