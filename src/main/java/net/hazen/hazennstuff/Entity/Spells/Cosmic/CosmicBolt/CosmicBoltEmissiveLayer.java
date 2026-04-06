package net.hazen.hazennstuff.Entity.Spells.Cosmic.CosmicBolt;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class CosmicBoltEmissiveLayer extends GeoRenderLayer<CosmicBolt> {

    public CosmicBoltEmissiveLayer(GeoEntityRenderer<CosmicBolt> renderer) {
        super(renderer);
    }

    private static RenderType glowRenderType(ResourceLocation texture) {
        return RenderType.entityCutout(texture);
    }

    @Override
    public void render(PoseStack poseStack, CosmicBolt animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay
    ) {
        if (animatable.isInvisible()) return;

        // Animate glow texture
        int frameCount = 8;
        int frame = animatable.tickCount % frameCount;
        ResourceLocation frameTexture = ResourceLocation.fromNamespaceAndPath(
                "hazennstuff",
                "textures/spells/cosmic_bolt_glowmask_" + frame + ".png"
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
