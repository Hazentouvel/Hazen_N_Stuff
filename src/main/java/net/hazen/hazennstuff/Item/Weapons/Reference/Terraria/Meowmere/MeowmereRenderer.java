package net.hazen.hazennstuff.Item.Weapons.Reference.Terraria.Meowmere;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class MeowmereRenderer extends GeoItemRenderer<MeowmereItem> {
    public MeowmereRenderer() {
        super(new MeowmereModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
