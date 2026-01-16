package net.hazen.hazennstuff.Item.Staves.DivineScepter;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class DivineScepterRenderer extends GeoItemRenderer<DivineScepter> {
    public DivineScepterRenderer() {
        super(new DivineScepterModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
