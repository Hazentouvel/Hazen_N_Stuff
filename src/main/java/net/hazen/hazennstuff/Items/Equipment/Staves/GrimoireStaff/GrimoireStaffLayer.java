package net.hazen.hazennstuff.Items.Equipment.Staves.GrimoireStaff;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hazen.hazennstuff.Items.Equipment.Staves.InsaniaAeternum.InsaniaAeternum;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class GrimoireStaffLayer extends GeoRenderLayer<GrimoireStaff> {
    private static final ResourceLocation LAYER = ResourceLocation.fromNamespaceAndPath(
            "hazennstuff",
            "textures/staves/grimoire_staff_glowmask.png");

    public GrimoireStaffLayer(GeoRenderer<GrimoireStaff> entityRenderer) {
        super(entityRenderer);
    }

    public void render(PoseStack poseStack, GrimoireStaff animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderType glowRenderType = RenderType.eyes(LAYER);
        this.getRenderer().reRender(this.getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.getBuffer(glowRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 0.5F);
    }
}
