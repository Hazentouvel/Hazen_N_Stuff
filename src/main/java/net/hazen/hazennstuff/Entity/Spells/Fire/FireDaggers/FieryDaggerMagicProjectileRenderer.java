package net.hazen.hazennstuff.Entity.Spells.Fire.FireDaggers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.util.Color;

// Copied the Fiery Dagger since I don't know how to make it scale off of Fire Spell Power for the spell.
public class FieryDaggerMagicProjectileRenderer extends GeoEntityRenderer<FieryDaggerMagicProjectile> {
    public FieryDaggerMagicProjectileRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FieryDaggerMagicProjectileModel());
    }

    public void preRender(PoseStack poseStack, FieryDaggerMagicProjectile entity, BakedGeoModel model, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTicks, int packedLight, int packedOverlay, int colour) {
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTicks, packedLight, packedOverlay, colour);
        Vec3 motion = entity.deltaMovementOld.add(entity.getDeltaMovement().subtract(entity.deltaMovementOld).scale((double)partialTicks));
        float xRot = (float)(Mth.atan2(motion.horizontalDistance(), motion.y) * (double)(180F / (float)Math.PI)) - 90.0F;
        float yRot = -((float)(Mth.atan2(motion.z, motion.x) * (double)(180F / (float)Math.PI)) - 90.0F);
        poseStack.translate(0.0F, entity.getBbHeight() * 0.5F, 0.0F);
        poseStack.mulPose(Axis.YP.rotationDegrees(yRot));
        poseStack.mulPose(Axis.XP.rotationDegrees(xRot));
    }

    public Color getRenderColor(FieryDaggerMagicProjectile animatable, float partialTick, int packedLight) {
        return Color.LIGHT_GRAY;
    }
}
