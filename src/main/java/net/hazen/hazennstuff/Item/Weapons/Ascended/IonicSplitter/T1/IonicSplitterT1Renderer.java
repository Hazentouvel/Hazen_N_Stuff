package net.hazen.hazennstuff.Item.Weapons.Ascended.IonicSplitter.T1;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class IonicSplitterT1Renderer extends GeoItemRenderer<IonicSplitterT1Item> {
    public IonicSplitterT1Renderer() {
        super(new IonicSplitterT1Model());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
