package net.hazen.hazennstuff.Item.Weapons.IonicSplitter.Dormant;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class IonicSplitterRenderer extends GeoItemRenderer<IonicSplitterItem> {
    public IonicSplitterRenderer() {
        super(new IonicSplitterModel());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
