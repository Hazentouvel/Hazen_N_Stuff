package net.hazen.hazennstuff.Item.Block.Statues.HazelStatue;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import io.redspace.ironslib.game.block.statue.AbstractStatueBlock;
import io.redspace.ironslib.game.block.statue.client.StaticModel;
import io.redspace.ironslib.game.block.statue.decorative.DecorativeStatueBlockEntity;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.cache.object.GeoBone;

public class HazelStatueBlockRenderer implements BlockEntityRenderer<DecorativeStatueBlockEntity> {
    StaticModel model = new StaticModel(HazenNStuff.id("geo/statue/tyros_statue.geo.json"), HazenNStuff.id("textures/entity/statue/tyros.png")) {
        protected void renderBone(PoseStack poseStack, GeoBone bone, VertexConsumer buffer, int packedLight, int packedOverlay) {
            super.renderBone(poseStack, bone, buffer, packedLight, packedOverlay);
        }
    };

    public HazelStatueBlockRenderer(BlockEntityRendererProvider.Context context) {
    }

    public void render(@NotNull DecorativeStatueBlockEntity statueBlock, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        if (statueBlock.isPrimary()) {
            Block var8 = statueBlock.getBlockState().getBlock();
            if (var8 instanceof AbstractStatueBlock) {
                AbstractStatueBlock statue = (AbstractStatueBlock)var8;
                poseStack.pushPose();
                poseStack.translate((float)statue.xSize * 0.5F, 0.0F, (float)statue.zSize * 0.5F);
                poseStack.mulPose(Axis.YP.rotationDegrees(-RotationSegment.convertToDegrees((Integer)statueBlock.getBlockState().getValue(SkullBlock.ROTATION))));
                poseStack.scale(1.7F, 1.7F, 1.7F);
                this.model.render(poseStack, RenderType::entityCutoutNoCull, bufferSource, packedLight, packedOverlay);
                poseStack.popPose();
            }
        }
    }

    public @NotNull AABB getRenderBoundingBox(@NotNull DecorativeStatueBlockEntity blockEntity) {
        return AABB.INFINITE;
    }
}
