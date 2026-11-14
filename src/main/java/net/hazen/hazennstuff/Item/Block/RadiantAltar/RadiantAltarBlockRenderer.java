package net.hazen.hazennstuff.Item.Block.RadiantAltar;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EnderDragonRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

import java.util.List;

public class RadiantAltarBlockRenderer extends GeoBlockRenderer<RadiantAltarBlockEntity> {

    // Main item on the pedestal
    private static final float MAIN_SCALE = 0.6f;
    private static final float MAIN_SPIN_SPEED = 1.5f;

    // Materials orbiting the pedestal while crafting
    private static final float ORBIT_SCALE = 0.45f;
    private static final float ORBIT_SPEED = 1.6f;
    private static final float ORBIT_SPIN_SPEED = 3.0f;

    // Beam
    private static final float BEAM_EXTEND_TICKS = 10.0f;

    public RadiantAltarBlockRenderer(BlockEntityRendererProvider.Context context) {
        super(new RadiantAltarBlockModel());
        this.addRenderLayer(new RadiantAltarEmissiveLayer(this));
    }

    // The model is 3x3x3 plus a 5-block-wide floor ring and the star above it
    @Override
    public AABB getRenderBoundingBox(RadiantAltarBlockEntity blockEntity) {
        return new AABB(blockEntity.getBlockPos()).inflate(2.5, 0.0, 2.5)
                .expandTowards(0, RadiantAltarBlockEntity.STAR_HEIGHT + 1.0, 0);
    }

    @Override
    public void render(RadiantAltarBlockEntity be, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        super.render(be, partialTick, poseStack, bufferSource, packedLight, packedOverlay);

        Level level = be.getLevel();
        if (level == null) return;

        float time = (float) (level.getGameTime() % 72000L) + partialTick;

        int light = LevelRenderer.getLightColor(level, be.getBlockPos().above(2));

        renderMainItem(be, time, poseStack, bufferSource, light, packedOverlay);
        if (be.isCrafting()) {
            renderOrbitItems(be, time, poseStack, bufferSource, light, packedOverlay);
            renderBeam(be, partialTick, poseStack, bufferSource);
        }
    }

    private void renderMainItem(RadiantAltarBlockEntity be, float time, PoseStack poseStack,
                                MultiBufferSource bufferSource, int light, int packedOverlay) {
        ItemStack stack = be.getItems().getStackInSlot(RadiantAltarBlockEntity.SLOT_MAIN);
        if (stack.isEmpty()) return;

        float bob = Mth.sin(time * 0.06f) * 0.05f;

        poseStack.pushPose();
        poseStack.translate(0.5f, RadiantAltarBlockEntity.ITEM_HEIGHT + bob, 0.5f);
        poseStack.mulPose(Axis.YP.rotationDegrees(time * MAIN_SPIN_SPEED));
        poseStack.scale(MAIN_SCALE, MAIN_SCALE, MAIN_SCALE);
        itemRenderer().renderStatic(stack, ItemDisplayContext.GROUND, light, packedOverlay,
                poseStack, bufferSource, be.getLevel(), 0);
        poseStack.popPose();
    }

    private void renderOrbitItems(RadiantAltarBlockEntity be, float time, PoseStack poseStack,
                                  MultiBufferSource bufferSource, int light, int packedOverlay) {
        List<ItemStack> stacks = be.getOrbitItems();
        if (stacks.isEmpty()) return;

        int count = stacks.size();
        float step = 360f / count;
        float orbit = time * ORBIT_SPEED;

        for (int i = 0; i < count; i++) {
            float angle = (orbit + i * step) * Mth.DEG_TO_RAD;
            float bob = Mth.sin(time * 0.08f + i * 1.3f) * 0.08f;

            poseStack.pushPose();
            poseStack.translate(
                    0.5f + Mth.cos(angle) * RadiantAltarBlockEntity.ORBIT_RADIUS,
                    RadiantAltarBlockEntity.ORBIT_HEIGHT + bob,
                    0.5f + Mth.sin(angle) * RadiantAltarBlockEntity.ORBIT_RADIUS);
            poseStack.mulPose(Axis.YP.rotationDegrees(time * ORBIT_SPIN_SPEED));
            poseStack.scale(ORBIT_SCALE, ORBIT_SCALE, ORBIT_SCALE);
            itemRenderer().renderStatic(stacks.get(i), ItemDisplayContext.GROUND, light, packedOverlay,
                    poseStack, bufferSource, be.getLevel(), i + 1);
            poseStack.popPose();
        }
    }

    // The End Crystal beam
    private static final float VANILLA_BEAM_START_OFFSET = 2.0f;

    private void renderBeam(RadiantAltarBlockEntity be, float partialTick, PoseStack poseStack,
                            MultiBufferSource bufferSource) {
        float length = RadiantAltarBlockEntity.STAR_HEIGHT - RadiantAltarBlockEntity.BEAM_TARGET.height;
        float extend = Math.min(1.0f, be.getCraftingTicks(partialTick) / BEAM_EXTEND_TICKS);
        if (extend <= 0f || length <= 0f) return;

        int ticks = (int) (be.getLevel().getGameTime() % 72000L);

        poseStack.pushPose();
        poseStack.translate(0.5f, RadiantAltarBlockEntity.STAR_HEIGHT - VANILLA_BEAM_START_OFFSET, 0.5f);
        EnderDragonRenderer.renderCrystalBeams(0.0f, -length * extend, 0.0f,
                partialTick, ticks, poseStack, bufferSource, 0xF000F0);
        poseStack.popPose();
    }

    private static ItemRenderer itemRenderer() {
        return Minecraft.getInstance().getItemRenderer();
    }
}