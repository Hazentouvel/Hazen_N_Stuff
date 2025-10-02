package net.hazen.hazennstuff.item.weapons.WarFlamingLance;

import net.hazen.hazennstuff.item.weapons.vampire_knives.VampireKnivesItem;
import net.hazen.hazennstuff.item.weapons.vampire_knives.VampireKnivesModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class WarFlamingLanceRenderer extends GeoItemRenderer<WarFlamingLanceItem> {
    public WarFlamingLanceRenderer() {
        super(new WarFlamingLanceModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
