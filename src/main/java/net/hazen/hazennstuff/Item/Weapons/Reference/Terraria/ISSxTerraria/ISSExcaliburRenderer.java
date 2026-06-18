package net.hazen.hazennstuff.Item.Weapons.Reference.Terraria.ISSxTerraria;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class ISSExcaliburRenderer extends GeoItemRenderer<ISSExcaliburItem> {
    public ISSExcaliburRenderer() {
        super(new ISSExcaliburModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
