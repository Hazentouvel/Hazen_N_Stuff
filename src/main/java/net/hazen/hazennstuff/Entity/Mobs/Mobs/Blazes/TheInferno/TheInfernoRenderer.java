package net.hazen.hazennstuff.Entity.Mobs.Mobs.Blazes.TheInferno;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMobRenderer;
import io.redspace.ironsspellbooks.render.RenderHelper;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.util.Color;

public class TheInfernoRenderer extends AbstractSpellCastingMobRenderer {

    public TheInfernoRenderer(EntityRendererProvider.Context context) {
        super(context, new TheInfernoModel());

        this.addRenderLayer(new TheInfernoEmissiveLayer(this));
    }

    public void preRender(PoseStack poseStack, TheInferno entity, BakedGeoModel model, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTicks, int packedLight, int packedOverlay, int colour) {
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTicks, packedLight, packedOverlay, colour);
        poseStack.translate(0.0F, entity.getBbHeight() * 0.5F, 0.0F);
    }

    public @Nullable RenderType getRenderType(TheInferno animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderHelper.CustomerRenderType.magic(texture);
    }

    public Color getRenderColor(TheInferno animatable, float partialTick, int packedLight) {
        return Color.LIGHT_GRAY;
    }
}