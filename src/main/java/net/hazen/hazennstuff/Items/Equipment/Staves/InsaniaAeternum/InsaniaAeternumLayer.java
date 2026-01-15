package net.hazen.hazennstuff.Items.Equipment.Staves.InsaniaAeternum;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class InsaniaAeternumLayer extends GeoRenderLayer<InsaniaAeternum> {
    private static final ResourceLocation LAYER = ResourceLocation.fromNamespaceAndPath(
            "hazennstuff",
            "textures/staves/insania_aeternum_glowmask.png");

    public InsaniaAeternumLayer(GeoRenderer<InsaniaAeternum> entityRenderer) {
        super(entityRenderer);
    }

    public void render(PoseStack poseStack, InsaniaAeternum animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderType glowRenderType = RenderType.eyes(LAYER);
        this.getRenderer().reRender(this.getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.getBuffer(glowRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 0.5F);
    }
}
