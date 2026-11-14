package net.hazen.hazennstuff.Item.Block.RadiantAltar.Item;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class RadiantAltarItemRenderer extends GeoItemRenderer<RadiantAltarItem> {
    public RadiantAltarItemRenderer() {
        super(new RadiantAltarItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
