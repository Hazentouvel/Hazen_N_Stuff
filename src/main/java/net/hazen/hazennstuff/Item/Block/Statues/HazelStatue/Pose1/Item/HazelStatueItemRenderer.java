package net.hazen.hazennstuff.Item.Block.Statues.HazelStatue.Pose1.Item;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class HazelStatueItemRenderer extends GeoItemRenderer<HazelStatueItem> {
    public HazelStatueItemRenderer() {
        super(new HazelStatueItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
