package net.hazen.hazennstuff.item.staves.rod_of_discord;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class RodOfDiscordRenderer extends GeoItemRenderer<RodOfDiscordItem> {
    public RodOfDiscordRenderer() {
        super(new RodOfDiscordModel());
        //addRenderLayer(new AutoGlowingGeoLayer<>(this));

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
