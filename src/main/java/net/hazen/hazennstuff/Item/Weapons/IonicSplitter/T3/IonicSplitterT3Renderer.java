package net.hazen.hazennstuff.Item.Weapons.IonicSplitter.T3;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class IonicSplitterT3Renderer extends GeoItemRenderer<IonicSplitterT3Item> {
    public IonicSplitterT3Renderer() {
        super(new IonicSplitterT3Model());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
