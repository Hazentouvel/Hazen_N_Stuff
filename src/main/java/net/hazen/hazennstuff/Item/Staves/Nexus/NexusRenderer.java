package net.hazen.hazennstuff.Item.Staves.Nexus;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class NexusRenderer extends GeoItemRenderer<Nexus> {
    public NexusRenderer() {
        super(new NexusModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
