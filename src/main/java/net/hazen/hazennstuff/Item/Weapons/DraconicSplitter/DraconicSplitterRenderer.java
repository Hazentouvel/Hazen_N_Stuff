package net.hazen.hazennstuff.Item.Weapons.DraconicSplitter;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class DraconicSplitterRenderer extends GeoItemRenderer<DraconicSplitterItem> {
    public DraconicSplitterRenderer() {
        super(new DraconicSplitterModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
