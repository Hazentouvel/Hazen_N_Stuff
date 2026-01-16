package net.hazen.hazennstuff.Item.Staves.WisewoodCane;

import software.bernie.geckolib.renderer.GeoItemRenderer;

public class WisewoodCaneRenderer extends GeoItemRenderer<WisewoodCane> {
    public WisewoodCaneRenderer() {
        super(new WisewoodCaneModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
