package net.hazen.hazennstuff.Item.Weapons.Generic.ObsidianClaymore;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class ObsidianClaymoreRenderer extends GeoItemRenderer<ObsidianClaymoreItem> {
    public ObsidianClaymoreRenderer() {
        super(new ObsidianClaymoreModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
