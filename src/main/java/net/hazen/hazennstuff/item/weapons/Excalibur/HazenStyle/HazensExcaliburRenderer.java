package net.hazen.hazennstuff.item.weapons.Excalibur.HazenStyle;

import net.hazen.hazennstuff.item.weapons.DivineGreatsword.DivineGreatswordItem;
import net.hazen.hazennstuff.item.weapons.DivineGreatsword.DivineGreatswordModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class HazensExcaliburRenderer extends GeoItemRenderer<HazensExcaliburItem> {
    public HazensExcaliburRenderer() {
        super(new HazensExcaliburModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
