package net.hazen.hazennstuff.Item.Block.Starforge;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BeaconRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

import java.util.ArrayList;
import java.util.List;

public class StarForgeBlockRenderer extends GeoBlockRenderer<StarForgeBlockEntity> {

    // Floating Input Items
    private static final float ORBIT_RADIUS = 0.32f;
    private static final float HOVER_HEIGHT = 1.15f;
    private static final float ITEM_SCALE = 0.5f;
    private static final float ORBIT_SPEED = 1.2f;
    private static final float SPIN_SPEED = 2.0f;

    // Output Item
    private static final float OUTPUT_HEIGHT = 0.85f;
    private static final float OUTPUT_SCALE = 0.55f;
    private static final float OUTPUT_SPIN_SPEED = 1.0f;

    // Beam
    private static final float BEAM_TOP = 2.5f;
    private static final float BEAM_BOTTOM = 0.9f;
    private static final float CORE_RADIUS = 0.055f;
    private static final float GLOW_RADIUS = 0.10f;
    private static final int CORE_COLOR = 0xFFBCCDF4;
    private static final int GLOW_COLOR = 0x40A8BEEE;
    private static final float SCROLL_SPEED = 0.03f;
    private static final float BEAM_FADE_TICKS = 6.0f;

    public StarForgeBlockRenderer(BlockEntityRendererProvider.Context context) {
        super(new StarForgeBlockModel());

        this.addRenderLayer(new StarForgeEmissiveLayer(this));
    }

    @Override
    public AABB getRenderBoundingBox(StarForgeBlockEntity blockEntity) {
        return new AABB(blockEntity.getBlockPos()).inflate(2.0, 3.0, 2.0);
    }

    @Override
    public void render(StarForgeBlockEntity be, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        super.render(be, partialTick, poseStack, bufferSource, packedLight, packedOverlay);
        renderFloatingItems(be, partialTick, poseStack, bufferSource, packedOverlay);
        renderOutputItem(be, partialTick, poseStack, bufferSource, packedOverlay);
        renderBeam(be, partialTick, poseStack, bufferSource);
    }

    private void renderBeam(StarForgeBlockEntity be, float partialTick,
                            PoseStack poseStack, MultiBufferSource bufferSource) {
        Level level = be.getLevel();
        if (level == null || !be.isCrafting()) return;

        float time = (float) (level.getGameTime() % 72000L) + partialTick;

        float extend = Math.min(1.0f, be.getCraftingTicks(partialTick) / BEAM_FADE_TICKS);
        float top = Mth.lerp(extend, BEAM_BOTTOM, BEAM_TOP);

        float scroll = -time * SCROLL_SPEED;
        float pulse = 1.0f + Mth.sin(time * 0.15f) * 0.08f;

        VertexConsumer consumer = bufferSource.getBuffer(
                RenderType.beaconBeam(BeaconRenderer.BEAM_LOCATION, true));

        poseStack.pushPose();
        poseStack.translate(0.5f, 0.0f, 0.5f);

        // Outer halo first, then the core on top of it.
        column(consumer, poseStack.last(), GLOW_COLOR, GLOW_RADIUS * pulse, BEAM_BOTTOM, top, scroll);
        column(consumer, poseStack.last(), CORE_COLOR, CORE_RADIUS * pulse, BEAM_BOTTOM, top, scroll);

        poseStack.popPose();
    }

    /** A four-sided square tube. beaconBeam's render type is no-cull, so winding is free. */
    private static void column(VertexConsumer consumer, PoseStack.Pose pose, int color,
                               float radius, float yBottom, float yTop, float scroll) {
        float v0 = scroll;
        float v1 = scroll + (yTop - yBottom);

        quad(consumer, pose, color, -radius, -radius, -radius, radius, yBottom, yTop, v0, v1);
        quad(consumer, pose, color, radius, radius, radius, -radius, yBottom, yTop, v0, v1);
        quad(consumer, pose, color, radius, -radius, -radius, -radius, yBottom, yTop, v0, v1);
        quad(consumer, pose, color, -radius, radius, radius, radius, yBottom, yTop, v0, v1);
    }

    private static void quad(VertexConsumer consumer, PoseStack.Pose pose, int color,
                             float x0, float z0, float x1, float z1,
                             float yBottom, float yTop, float v0, float v1) {
        vertex(consumer, pose, color, x0, yTop, z0, 1.0f, v0);
        vertex(consumer, pose, color, x0, yBottom, z0, 1.0f, v1);
        vertex(consumer, pose, color, x1, yBottom, z1, 0.0f, v1);
        vertex(consumer, pose, color, x1, yTop, z1, 0.0f, v0);
    }

    private static void vertex(VertexConsumer consumer, PoseStack.Pose pose, int color,
                               float x, float y, float z, float u, float v) {
        consumer.addVertex(pose, x, y, z)
                .setColor(color)
                .setUv(u, v)
                .setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(0xF000F0)
                .setNormal(pose, 0.0f, 1.0f, 0.0f);
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
