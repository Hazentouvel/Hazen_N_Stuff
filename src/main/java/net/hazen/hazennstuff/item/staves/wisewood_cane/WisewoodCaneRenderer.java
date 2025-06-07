package net.hazen.hazennstuff.item.staves.wisewood_cane;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class WisewoodCaneRenderer extends GeoItemRenderer<WisewoodCaneItem> {
    public WisewoodCaneRenderer() {
        super(new WisewoodCaneModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
