package net.hazen.hazennstuff.item.weapons.beongae;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class BeongaeRenderer extends GeoItemRenderer<BeongaeItem> {
    public BeongaeRenderer() {
        super(new BeongaeModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
