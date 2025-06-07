package net.hazen.hazennstuff.item.util.spectral_pickaxe;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SpectralPickaxeRenderer extends GeoItemRenderer<SpectralPickaxeItem> {
    public SpectralPickaxeRenderer() {
        super(new SpectralPickaxeModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
