package net.hazen.hazennstuff.Item.Weapons.Spectrum;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SpectrumRenderer extends GeoItemRenderer<SpectrumItem> {
    public SpectrumRenderer() {
        super(new SpectrumModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
