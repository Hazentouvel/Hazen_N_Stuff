package net.hazen.hazennstuff.item.weapons.TheDevourer;

import net.hazen.hazennstuff.item.weapons.vampire_knives.VampireKnivesItem;
import net.hazen.hazennstuff.item.weapons.vampire_knives.VampireKnivesModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class TheDevourerRenderer extends GeoItemRenderer<TheDevourerItem> {
    public TheDevourerRenderer() {
        super(new TheDevourerModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
