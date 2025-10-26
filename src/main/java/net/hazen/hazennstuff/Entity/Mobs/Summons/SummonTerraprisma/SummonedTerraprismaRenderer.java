package net.hazen.hazennstuff.Entity.Mobs.Summons.SummonTerraprisma;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.redspace.ironsspellbooks.render.RenderHelper.CustomerRenderType;
import java.util.function.Supplier;

import net.hazen.hazennstuff.Entity.Spells.Radiance.Terraprisma.TerraprismaEmissiveLayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.util.Color;

public class SummonedTerraprismaRenderer extends GeoEntityRenderer<SummonedTerraprismicEntity> {
    public SummonedTerraprismaRenderer(EntityRendererProvider.Context renderManager, Supplier<GeoModel<SummonedTerraprismicEntity>> model) {
        super(renderManager, model.get());

        this.addRenderLayer(new SummonedTerraprismaEmissiveLayer(this));
    }

    public void preRender(PoseStack poseStack, SummonedTerraprismicEntity entity, BakedGeoModel model, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTicks, int packedLight, int packedOverlay, int colour) {
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTicks, packedLight, packedOverlay, colour);
        poseStack.translate(0.0F, entity.getBbHeight() * 0.5F, 0.0F);
    }

    public @Nullable RenderType getRenderType(SummonedTerraprismicEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return CustomerRenderType.magic(texture);
    }

    public Color getRenderColor(SummonedTerraprismicEntity animatable, float partialTick, int packedLight) {
        return Color.LIGHT_GRAY;
    }
}
