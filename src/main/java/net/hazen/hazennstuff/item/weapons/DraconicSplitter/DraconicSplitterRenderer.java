package net.hazen.hazennstuff.item.weapons.DraconicSplitter;

import net.hazen.hazennstuff.item.weapons.DivineGreatsword.DivineGreatswordItem;
import net.hazen.hazennstuff.item.weapons.DivineGreatsword.DivineGreatswordModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class DraconicSplitterRenderer extends GeoItemRenderer<DraconicSplitterItem> {
    public DraconicSplitterRenderer() {
        super(new DraconicSplitterModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
