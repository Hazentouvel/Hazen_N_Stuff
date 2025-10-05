package net.hazen.hazennstuff.entity.spells.lightning.spark;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.entity.spells.eldritch.soul_seeker.SoulSeeker;
import net.hazen.hazennstuff.entity.spells.fire.brimstone_hellblast.BrimstoneHellblast;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class EnergyBurstRenderer extends GeoEntityRenderer<EnergyBurst> {
    public EnergyBurstRenderer(EntityRendererProvider.Context context) {
        super(context, new EnergyBurstModel());
        this.shadowRadius = 0f;
    }

    @Override
    public ResourceLocation getTextureLocation(EnergyBurst animatable) {
        int frame = (animatable.tickCount / 1) % 4;
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/spark_" + frame + ".png");
    }

    @Override
    public void preRender(PoseStack poseStack, EnergyBurst animatable, BakedGeoModel model,
                          @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer,
                          boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {

        Vec3 motion = animatable.getDeltaMovement();

        float xRot = (float) (-(Mth.atan2(motion.y, motion.horizontalDistance()) * (180F / Math.PI)));
        float yRot = -((float) (Mth.atan2(motion.z, motion.x) * (180F / (float) Math.PI)) + 90.0F) + 180.0F;

        poseStack.mulPose(Axis.YP.rotationDegrees(yRot));
        poseStack.mulPose(Axis.XP.rotationDegrees(xRot));

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
    }

    @Override
    public RenderType getRenderType(EnergyBurst animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.energySwirl(texture, 0, 0);
    }
}