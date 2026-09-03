package net.hazen.hazennstuff.Item.Block.Statues.HazelStatue.Pose2.Item;

import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class HazelStatueItemRendererPose1 extends GeoItemRenderer<HazelStatueItemPose1> {
    public HazelStatueItemRendererPose1() {
        super(new HazelStatueItemModelPose1());
    }
}
