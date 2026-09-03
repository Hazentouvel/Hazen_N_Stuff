package net.hazen.hazennstuff.Item.Block.Statues.HazelStatue.Pose3.Item;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class HazelStatueItemRendererPose2 extends GeoItemRenderer<HazelStatueItemPose2> {
    public HazelStatueItemRendererPose2() {
        super(new HazelStatueItemModelPose2());
    }
}
