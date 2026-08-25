package net.hazen.hazennstuff.Item.Block.Statues.HazelStatue.Pose1;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class HazelStatueRenderer extends GeoBlockRenderer<HazelStatueBlockEntity> {

    public HazelStatueRenderer(BlockEntityRendererProvider.Context context) {
        super(new HazelStatueModel());
    }
}
