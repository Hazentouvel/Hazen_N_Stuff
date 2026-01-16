package net.hazen.hazennstuff.Item.Weapons.Ascended.IonicSplitter.T2;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class IonicSplitterT2Renderer extends GeoItemRenderer<IonicSplitterT2Item> {
    public IonicSplitterT2Renderer() {
        super(new IonicSplitterT2Model());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
