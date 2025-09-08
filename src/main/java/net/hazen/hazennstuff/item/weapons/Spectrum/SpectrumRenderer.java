package net.hazen.hazennstuff.item.weapons.Spectrum;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SpectrumRenderer extends GeoItemRenderer<SpectrumItem> {
    public SpectrumRenderer() {
        super(new SpectrumModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
