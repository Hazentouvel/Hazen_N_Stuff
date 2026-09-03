package net.hazen.hazennstuff.Item.Block.Statues.HazelStatue.Pose4.Item;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class HazelStatueItemRendererPose3 extends GeoItemRenderer<HazelStatueItemPose3> {
    public HazelStatueItemRendererPose3() {
        super(new HazelStatueItemModelPose3());
    }
}
