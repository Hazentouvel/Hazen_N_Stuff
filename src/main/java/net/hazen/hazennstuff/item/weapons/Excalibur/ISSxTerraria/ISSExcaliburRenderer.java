package net.hazen.hazennstuff.item.weapons.Excalibur.ISSxTerraria;

import net.hazen.hazennstuff.item.weapons.Excalibur.Terraria.ExcaliburItem;
import net.hazen.hazennstuff.item.weapons.Excalibur.Terraria.ExcaliburModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class ISSExcaliburRenderer extends GeoItemRenderer<ISSExcaliburItem> {
    public ISSExcaliburRenderer() {
        super(new ISSExcaliburModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
