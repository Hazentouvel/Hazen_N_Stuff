package net.hazen.hazennstuff.item.weapons.skyscorcher;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class SkyscorcherRenderer extends GeoItemRenderer<SkyscorcherItem> {
    public SkyscorcherRenderer() {
        super(new SkyscorcherModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
