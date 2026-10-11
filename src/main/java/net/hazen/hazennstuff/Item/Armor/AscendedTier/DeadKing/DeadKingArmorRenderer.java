package net.hazen.hazennstuff.Item.Armor.AscendedTier.DeadKing;

import io.redspace.ironslib.transmog.client.TransmogArmorRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class DeadKingArmorRenderer extends TransmogArmorRenderer<DeadKingArmorItem> {
    public DeadKingArmorRenderer(DeadKingArmorModel blazeborneArmorModel) {
        super(new DeadKingArmorModel());
        this.addRenderLayer(new DeadKingArmorLayer(this));
        this.head = new GeoBone((GeoBone)null, "armorHead", false, (double)0.0F, false, false);
        this.body = new GeoBone((GeoBone)null, "armorBody", false, (double)0.0F, false, false);
        this.rightArm = new GeoBone((GeoBone)null, "armorRightArm", false, (double)0.0F, false, false);
        this.leftArm = new GeoBone((GeoBone)null, "armorLeftArm", false, (double)0.0F, false, false);
        this.rightLeg = new GeoBone((GeoBone)null, "armorRightLeg", false, (double)0.0F, false, false);
        this.leftLeg = new GeoBone((GeoBone)null, "armorLeftLeg", false, (double)0.0F, false, false);
        this.rightBoot = new GeoBone((GeoBone)null, "armorRightBoot", false, (double)0.0F, false, false);
        this.leftBoot = new GeoBone((GeoBone)null, "armorLeftBoot", false, (double)0.0F, false, false);


        this.withCapeBone(new TransmogArmorRenderer.CapeBone("cape", new Vec3(0.5F, 0.5F, 0.75F)));
        this.withCapeBone(new TransmogArmorRenderer.CapeBone("booty_cape", new Vec3(0.5F, 0.5F, 0.5F)));
    }

    public RenderType getRenderType(DeadKingArmorItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }
}
