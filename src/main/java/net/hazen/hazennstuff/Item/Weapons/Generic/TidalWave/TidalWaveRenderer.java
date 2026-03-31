package net.hazen.hazennstuff.Item.Weapons.Generic.TidalWave;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class TidalWaveRenderer extends GeoItemRenderer<TidalWave> {
    public TidalWaveRenderer() {
        super(new TidalWaveModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
