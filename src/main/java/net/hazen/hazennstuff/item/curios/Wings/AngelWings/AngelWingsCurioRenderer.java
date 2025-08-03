package net.hazen.hazennstuff.item.curios.Wings.AngelWings;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

@OnlyIn(Dist.CLIENT)
public class AngelWingsCurioRenderer implements ICurioRenderer {
    private final AngelWingsRenderer angelWingsRenderer = new AngelWingsRenderer();

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(
            ItemStack stack,
            SlotContext slotContext,
            PoseStack matrixStack,
            RenderLayerParent<T, M> renderLayerParent,
            MultiBufferSource renderTypeBuffer,
            int light,
            float limbSwing,
            float limbSwingAmount,
            float partialTicks,
            float ageInTicks,
            float netHeadYaw,
            float headPitch) {

        matrixStack.pushPose();

        matrixStack.translate(0.5F, 1.1F, -0.5F);

        matrixStack.mulPose(Axis.ZP.rotationDegrees(180.0F));

        angelWingsRenderer.renderByItem(stack, matrixStack, renderTypeBuffer, light);

        matrixStack.popPose();

    }
}