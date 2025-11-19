package net.hazen.hazennstuff.Entity.Mobs.Mobs.Blazes.CinderousFurnace;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMob;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class CinderousFurnaceEmissiveLayer extends GeoRenderLayer<AbstractSpellCastingMob> {

    private static final ResourceLocation GLOW_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(
                    HazenNStuff.MOD_ID,
                    "textures/mobs/cinderous_furnace_blaze.png"
            );

    public CinderousFurnaceEmissiveLayer(GeoEntityRenderer<AbstractSpellCastingMob> renderer) {
        super(renderer);
    }

    private static RenderType glowRenderType(ResourceLocation texture) {
        return RenderType.entityCutout(texture);
    }

    public void render(
            PoseStack poseStack,
            CinderousFurnace animatable,
            BakedGeoModel bakedModel,
            RenderType renderType,
            MultiBufferSource bufferSource,
            VertexConsumer buffer,
            float partialTick,
            int packedLight,
            int packedOverlay
    ) {
        if (animatable.isInvisible()) return;

        RenderType emissive = glowRenderType(GLOW_TEXTURE);
        VertexConsumer vc = bufferSource.getBuffer(emissive);

        poseStack.pushPose();
        getRenderer().actuallyRender(
                poseStack,
                animatable,
                bakedModel,
                emissive,
                bufferSource,
                vc,
                true,
                partialTick,
                0xF000F0,
                OverlayTexture.NO_OVERLAY,
                0xFFFFFFFF
        );
        poseStack.popPose();
    }
}

