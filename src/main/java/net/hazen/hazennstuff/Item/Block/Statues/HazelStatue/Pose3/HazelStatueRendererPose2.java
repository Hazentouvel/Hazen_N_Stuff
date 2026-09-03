package net.hazen.hazennstuff.Item.Block.Statues.HazelStatue.Pose3;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class HazelStatueRendererPose2 extends GeoBlockRenderer<HazelStatueBlockEntityPose2> {

    public HazelStatueRendererPose2(BlockEntityRendererProvider.Context context) {
        super(new HazelStatueModelPose2());
    }
}
