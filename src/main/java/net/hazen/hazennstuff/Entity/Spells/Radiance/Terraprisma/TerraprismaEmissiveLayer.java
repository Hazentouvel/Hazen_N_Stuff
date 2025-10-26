package net.hazen.hazennstuff.Entity.Spells.Radiance.Terraprisma;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class TerraprismaEmissiveLayer extends GeoRenderLayer<Terraprisma> {

    public TerraprismaEmissiveLayer(GeoEntityRenderer<Terraprisma> renderer) {
        super(renderer);
    }

    private static RenderType glowRenderType(ResourceLocation texture) {
        // energySwirl gives additive glow blending
        return RenderType.entityCutout(texture);
    }

    @Override
    public void render(
            PoseStack poseStack,
            Terraprisma animatable,
            BakedGeoModel bakedModel,
            RenderType renderType,
            MultiBufferSource bufferSource,
            VertexConsumer buffer,
            float partialTick,
            int packedLight,
            int packedOverlay
    ) {
        if (animatable.isInvisible()) return;

        // Animate glow texture
        int frameCount = 20;
        int frame = animatable.tickCount % frameCount;
        ResourceLocation frameTexture = ResourceLocation.fromNamespaceAndPath(
                "hazennstuff",
                "textures/spells/terraprisma/terraprisma_glowmask_" + frame + ".png"
        );

        RenderType emissiveType = glowRenderType(frameTexture);
        VertexConsumer vertexConsumer = bufferSource.getBuffer(emissiveType);

        poseStack.pushPose();
        getRenderer().actuallyRender(
                poseStack,
                animatable,
                bakedModel,
                emissiveType,
                bufferSource,
                vertexConsumer,
                true,
                partialTick,
                0xF000F0, // full-bright
                OverlayTexture.NO_OVERLAY,
                0xFFFFFFFF // white color
        );
        poseStack.popPose();
    }
}
