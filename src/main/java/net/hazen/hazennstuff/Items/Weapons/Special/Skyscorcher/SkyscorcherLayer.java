package net.hazen.hazennstuff.Items.Weapons.Special.Skyscorcher;

import com.geckolib.renderer.GeoItemRenderer;
import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.renderer.base.GeoRenderer;
import com.geckolib.renderer.base.RenderPassInfo;
import com.geckolib.renderer.layer.GeoRenderLayer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;

public class SkyscorcherLayer<R extends GeoRenderState>
        extends GeoRenderLayer<SkyscorcherItem, GeoItemRenderer.RenderData, R> {

    private static final Identifier LAYER = Identifier.fromNamespaceAndPath(
            HazenNStuff.MOD_ID,
            "textures/item/equipment/weapons/skyscorcher_glowmask.png"
    );

    public SkyscorcherLayer(
            GeoRenderer<SkyscorcherItem, GeoItemRenderer.RenderData, R> renderer
    ) {
        super(renderer);
    }

    @Override
    public void submitRenderTask(RenderPassInfo<R> renderPassInfo, SubmitNodeCollector renderTasks) {
        RenderType eyes = RenderTypes.eyes(LAYER);

        final int packedLight = renderPassInfo.packedLight();
        final int packedOverlay = renderPassInfo.packedOverlay();
        final int renderColor = renderPassInfo.renderColor();

        renderTasks.submitCustomGeometry(renderPassInfo.poseStack(), eyes, (pose, vertexConsumer) -> {
                    PoseStack poseStack = renderPassInfo.poseStack();
                    poseStack.pushPose();
                    poseStack.last().set(pose);

                    renderPassInfo.renderPosed(() -> renderPassInfo
                            .model()
                            .render(renderPassInfo, vertexConsumer, packedLight, packedOverlay, renderColor)
                    );

                    poseStack.popPose();
                }
        );

    }
}