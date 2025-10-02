package net.hazen.hazennstuff.item.util.PickaxeAxe;

import net.hazen.hazennstuff.item.util.spectral_pickaxe.SpectralPickaxeItem;
import net.hazen.hazennstuff.item.util.spectral_pickaxe.SpectralPickaxeModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class PickaxeAxeRenderer extends GeoItemRenderer<PickaxeAxeItem> {
    public PickaxeAxeRenderer() {
        super(new PickaxeAxeModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
