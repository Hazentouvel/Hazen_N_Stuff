package net.hazen.hazennstuff.Item.Block.Starforge.Item;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class StarForgeItemRenderer extends GeoItemRenderer<StarForgeItem> {
    public StarForgeItemRenderer() {
        super(new StarForgeItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
