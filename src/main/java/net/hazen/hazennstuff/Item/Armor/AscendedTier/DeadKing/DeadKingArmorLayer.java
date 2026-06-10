package net.hazen.hazennstuff.Item.Armor.AscendedTier.DeadKing;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;


public class DeadKingArmorLayer extends GeoRenderLayer<DeadKingArmorItem> {
    private ResourceLocation getGlowTexture() {
        ResourceLocation normalGlow = ResourceLocation.fromNamespaceAndPath(
                HazenNStuff.MOD_ID,
                "textures/armor/dead_king_armor_glowmask.png");

        ResourceLocation ominousGlow = ResourceLocation.fromNamespaceAndPath(
                HazenNStuff.MOD_ID,
                "textures/armor/ominous_dead_king_armor_glowmask.png");

        ResourceLocation enragedGlow = ResourceLocation.fromNamespaceAndPath(
                HazenNStuff.MOD_ID,
                "textures/armor/dead_king_enraged_armor_glowmask.png");

        ResourceLocation ominousEnragedGlow = ResourceLocation.fromNamespaceAndPath(
                HazenNStuff.MOD_ID,
                "textures/armor/ominous_dead_king_enraged_armor_glowmask.png");

        LivingEntity player = Minecraft.getInstance().player;

        if (player != null && player.hasEffect(HnSEffects.AWAKENING)) {
            if (player.hasEffect(HnSEffects.DEAD_KING_SOUL_STATE)) {
                return ominousEnragedGlow;
            }
            return enragedGlow;
        }

        if (player != null && player.hasEffect(HnSEffects.DEAD_KING_SOUL_STATE)) {
            return ominousGlow;
        }

        return normalGlow;
    }

    public DeadKingArmorLayer(GeoRenderer<DeadKingArmorItem> entityRenderer) {
        super(entityRenderer);
    }

    public void render(PoseStack poseStack, DeadKingArmorItem animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderType glowRenderType = RenderType.eyes(getGlowTexture());
        this.getRenderer()
                .reRender(this.getDefaultBakedModel(animatable),
                        poseStack,
                        bufferSource,
                        animatable,
                        glowRenderType,
                        bufferSource.getBuffer(glowRenderType),
                        partialTick,
                        packedLight,
                        OverlayTexture.NO_OVERLAY,
                        0xFFFFFFFF
                );
    }
}
