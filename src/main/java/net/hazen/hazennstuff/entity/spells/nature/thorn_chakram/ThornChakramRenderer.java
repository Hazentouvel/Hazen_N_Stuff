package net.hazen.hazennstuff.entity.spells.nature.thorn_chakram;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.entity.spells.fire.brimstone_hellblast.BrimstoneHellblast;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ThornChakramRenderer extends GeoEntityRenderer<ThornChakram> {
    public ThornChakramRenderer(EntityRendererProvider.Context context) {
        super(context, new ThornChakramModel());
        this.shadowRadius = 0f;
    }

    @Override
    public ResourceLocation getTextureLocation(ThornChakram animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/thorn_chakram_spell.png");
    }

    @Override
    public void preRender(PoseStack poseStack, ThornChakram animatable, BakedGeoModel model, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {

        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTick, animatable.yRotO, animatable.getYRot())));
        poseStack.mulPose(Axis.XP.rotationDegrees(-Mth.lerp(partialTick, animatable.xRotO, animatable.getXRot())));

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
    }

    @Override
    public RenderType getRenderType(ThornChakram animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.energySwirl(texture, 0, 0);
    }

    @Override
    public void render(ThornChakram entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();

        poseStack.scale(1F, 1F, 1F); // Example: 1.5x size

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);

        poseStack.popPose();
    }

}