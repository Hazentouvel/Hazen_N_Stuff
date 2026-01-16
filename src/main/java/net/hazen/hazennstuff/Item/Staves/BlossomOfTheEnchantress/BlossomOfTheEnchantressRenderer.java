package net.hazen.hazennstuff.Item.Staves.BlossomOfTheEnchantress;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class BlossomOfTheEnchantressRenderer extends GeoItemRenderer<BlossomOfTheEnchantress> {
    public BlossomOfTheEnchantressRenderer() {
        super(new BlossomOfTheEnchantressModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
