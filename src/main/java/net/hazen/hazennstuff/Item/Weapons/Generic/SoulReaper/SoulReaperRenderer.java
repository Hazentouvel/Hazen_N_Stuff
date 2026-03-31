package net.hazen.hazennstuff.Item.Weapons.Generic.SoulReaper;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SoulReaperRenderer extends GeoItemRenderer<SoulReaper> {
    public SoulReaperRenderer() {
        super(new SoulReaperModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
