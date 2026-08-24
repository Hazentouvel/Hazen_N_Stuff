package net.hazen.hazennstuff.Item.Block;

import com.mojang.blaze3d.vertex.PoseStack;
import io.redspace.ironslib.game.block.statue.decorative.DecorativeStatueBlockEntity;
import io.redspace.ironslib.util.MemoizedSupplier;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

public class GeckolibBlockRenderer implements IClientItemExtensions {
    private final MemoizedSupplier<BlockEntityWithoutLevelRenderer> renderer;

    public GeckolibBlockRenderer(Supplier<Block> block, Supplier<BlockEntityType<GeckolibBlockEntity>> type) {
        this.renderer = new MemoizedSupplier(() -> new BlockEntityWithoutLevelRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels()) {
                public void renderByItem(@NotNull ItemStack stack, @NotNull ItemDisplayContext displayContext, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight, int packedOverlay) {
                    Minecraft.getInstance().getBlockEntityRenderDispatcher().renderItem((GeckolibBlockEntity)GeckolibBlockEntity.from(type).create(BlockPos.ZERO, ((Block)block.get()).defaultBlockState()), poseStack, buffer, packedLight, packedOverlay);
                }
            });
    }

    public @NotNull BlockEntityWithoutLevelRenderer getCustomRenderer() {
        return (BlockEntityWithoutLevelRenderer)this.renderer.get();
    }
}
