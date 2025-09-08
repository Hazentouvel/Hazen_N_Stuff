package net.hazen.hazennstuff.item.weapons.Starfury;

import net.hazen.hazennstuff.item.weapons.ObsidianClaymore.ObsidianClaymoreItem;
import net.hazen.hazennstuff.item.weapons.ObsidianClaymore.ObsidianClaymoreModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class StarfuryRenderer extends GeoItemRenderer<StarfuryItem> {
    public StarfuryRenderer() {
        super(new StarfuryModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
