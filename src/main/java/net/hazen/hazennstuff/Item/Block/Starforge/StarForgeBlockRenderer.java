package net.hazen.hazennstuff.Item.Block.Starforge;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

import java.util.ArrayList;
import java.util.List;

public class StarForgeBlockRenderer extends GeoBlockRenderer<StarForgeBlockEntity> {

    private static final float ORBIT_RADIUS = 0.32f;
    private static final float HOVER_HEIGHT = 1.15f;
    private static final float ITEM_SCALE = 0.5f;
    private static final float ORBIT_SPEED = 1.2f;
    private static final float SPIN_SPEED = 2.0f;
    private static final float OUTPUT_HEIGHT = 0.85f;
    private static final float OUTPUT_SCALE = 0.55f;
    private static final float OUTPUT_SPIN_SPEED = 1.0f;

    public StarForgeBlockRenderer(BlockEntityRendererProvider.Context context) {
        super(new StarForgeBlockModel());
    }

    @Override
    public AABB getRenderBoundingBox(StarForgeBlockEntity blockEntity) {
        return new AABB(blockEntity.getBlockPos()).inflate(2.0);
    }

    @Override
    public void render(StarForgeBlockEntity be, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        super.render(be, partialTick, poseStack, bufferSource, packedLight, packedOverlay);
        renderFloatingItems(be, partialTick, poseStack, bufferSource, packedOverlay);
        renderOutputItem(be, partialTick, poseStack, bufferSource, packedOverlay);
    }

    private void renderFloatingItems(StarForgeBlockEntity be, float partialTick, PoseStack poseStack,
                                     MultiBufferSource bufferSource, int packedOverlay) {
        Level level = be.getLevel();
        if (level == null) return;

        List<ItemStack> stacks = new ArrayList<>(3);
        for (int slot = StarForgeBlockEntity.SLOT_MAIN_1; slot <= StarForgeBlockEntity.SLOT_MAIN_3; slot++) {
            ItemStack stack = be.getItems().getStackInSlot(slot);
            if (!stack.isEmpty()) stacks.add(stack);
        }
        if (stacks.isEmpty()) return;

        int count = stacks.size();

        float radius = count == 1 ? 0f : ORBIT_RADIUS;
        float step = 360f / count;

        float time = (float) (level.getGameTime() % 72000L) + partialTick;
        float orbit = time * ORBIT_SPEED;
        float spin = time * SPIN_SPEED;
        float bob = Mth.sin(time * 0.06f) * 0.05f;

        int light = LevelRenderer.getLightColor(level, be.getBlockPos().above());
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

        for (int i = 0; i < count; i++) {
            float angle = (orbit + i * step) * Mth.DEG_TO_RAD;

            poseStack.pushPose();
            poseStack.translate(
                    0.5f + Mth.cos(angle) * radius,
                    HOVER_HEIGHT + bob,
                    0.5f + Mth.sin(angle) * radius);
            poseStack.mulPose(Axis.YP.rotationDegrees(spin));
            poseStack.scale(ITEM_SCALE, ITEM_SCALE, ITEM_SCALE);

            itemRenderer.renderStatic(stacks.get(i), ItemDisplayContext.GROUND,
                    light, packedOverlay, poseStack, bufferSource, level, 0);

            poseStack.popPose();
        }
    }

    private void renderOutputItem(StarForgeBlockEntity be, float partialTick, PoseStack poseStack,
                                  MultiBufferSource bufferSource, int packedOverlay) {
        Level level = be.getLevel();
        if (level == null) return;

        ItemStack stack = be.getItems().getStackInSlot(StarForgeBlockEntity.SLOT_OUTPUT);
        if (stack.isEmpty()) return;

        float time = (float) (level.getGameTime() % 72000L) + partialTick;
        float spin = time * OUTPUT_SPIN_SPEED;
        float bob = Mth.sin(time * 0.06f + Mth.PI) * 0.03f;

        int light = LevelRenderer.getLightColor(level, be.getBlockPos().above());

        poseStack.pushPose();
        poseStack.translate(0.5f, OUTPUT_HEIGHT + bob, 0.5f);
        poseStack.mulPose(Axis.YP.rotationDegrees(spin));
        poseStack.scale(OUTPUT_SCALE, OUTPUT_SCALE, OUTPUT_SCALE);

        Minecraft.getInstance().getItemRenderer().renderStatic(stack, ItemDisplayContext.GROUND,
                light, packedOverlay, poseStack, bufferSource, level, 0);

        poseStack.popPose();
    }
}
