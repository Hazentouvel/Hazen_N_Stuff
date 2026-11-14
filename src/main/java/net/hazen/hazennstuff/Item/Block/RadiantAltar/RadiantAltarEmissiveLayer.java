package net.hazen.hazennstuff.Item.Block.RadiantAltar;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class RadiantAltarEmissiveLayer extends GeoRenderLayer<RadiantAltarBlockEntity> {

    private static final ResourceLocation GLOWMASK = ResourceLocation.fromNamespaceAndPath(
            HazenNStuff.MOD_ID, "textures/block/radiant_altar_glowmask.png");

    public RadiantAltarEmissiveLayer(GeoBlockRenderer<RadiantAltarBlockEntity> renderer) {
        super(renderer);
    }

    @Override
    public void render(PoseStack poseStack, RadiantAltarBlockEntity animatable, BakedGeoModel bakedModel,
                       RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer,
                       float partialTick, int packedLight, int packedOverlay) {
        RenderType emissiveType = RenderType.entityCutout(GLOWMASK);
        VertexConsumer vertexConsumer = bufferSource.getBuffer(emissiveType);

        poseStack.pushPose();
        getRenderer().actuallyRender(poseStack, animatable, bakedModel, emissiveType, bufferSource,
                vertexConsumer, true, partialTick, 0xF000F0, OverlayTexture.NO_OVERLAY, 0xFFFFFFFF);
        poseStack.popPose();
    }
}
