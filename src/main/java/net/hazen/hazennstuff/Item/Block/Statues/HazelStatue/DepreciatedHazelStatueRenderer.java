package net.hazen.hazennstuff.Item.Block.Statues.HazelStatue;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class DepreciatedHazelStatueRenderer extends GeoBlockRenderer<HazelStatueBlockEntity> {

    public DepreciatedHazelStatueRenderer(BlockEntityRendererProvider.Context context) {
        super(new HazelStatueModel());
    }
}
