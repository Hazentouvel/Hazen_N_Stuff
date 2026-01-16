package net.hazen.hazennstuff.Item.Weapons.Generic.Beongae;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class BeongaeRenderer extends GeoItemRenderer<BeongaeItem> {
    public BeongaeRenderer() {
        super(new BeongaeModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
