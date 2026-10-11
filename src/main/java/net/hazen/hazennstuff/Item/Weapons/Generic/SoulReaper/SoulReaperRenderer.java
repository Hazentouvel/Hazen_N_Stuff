package net.hazen.hazennstuff.Item.Weapons.Generic.SoulReaper;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class SoulReaperRenderer extends GeoItemRenderer<SoulReaper> {
    public SoulReaperRenderer() {
        super(new SoulReaperModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
