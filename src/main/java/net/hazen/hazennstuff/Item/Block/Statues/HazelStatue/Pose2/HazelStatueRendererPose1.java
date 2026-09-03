package net.hazen.hazennstuff.Item.Block.Statues.HazelStatue.Pose2;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class HazelStatueRendererPose1 extends GeoBlockRenderer<HazelStatueBlockEntityPose1> {

    public HazelStatueRendererPose1(BlockEntityRendererProvider.Context context) {
        super(new HazelStatueModelPose1());
    }
}
