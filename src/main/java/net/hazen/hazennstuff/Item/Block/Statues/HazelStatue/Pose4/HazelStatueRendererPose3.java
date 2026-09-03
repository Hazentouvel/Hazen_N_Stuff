package net.hazen.hazennstuff.Item.Block.Statues.HazelStatue.Pose4;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class HazelStatueRendererPose3 extends GeoBlockRenderer<HazelStatueBlockEntityPose3> {

    public HazelStatueRendererPose3(BlockEntityRendererProvider.Context context) {
        super(new HazelStatueModelPose3());
    }
}
