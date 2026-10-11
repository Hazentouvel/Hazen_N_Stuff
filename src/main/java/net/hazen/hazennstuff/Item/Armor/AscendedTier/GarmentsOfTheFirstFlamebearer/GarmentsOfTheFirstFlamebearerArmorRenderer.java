package net.hazen.hazennstuff.Item.Armor.AscendedTier.GarmentsOfTheFirstFlamebearer;

import io.redspace.ironslib.transmog.client.TransmogArmorRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.cache.object.GeoBone;

public class GarmentsOfTheFirstFlamebearerArmorRenderer extends TransmogArmorRenderer<GarmentsOfTheFirstFlamebearerArmorItem> {
    public GarmentsOfTheFirstFlamebearerArmorRenderer(GarmentsOfTheFirstFlamebearerArmorModel garmentsOfTheFirstFlamebearerArmorModel) {
        super(new GarmentsOfTheFirstFlamebearerArmorModel());
        this.withCapeBone(new CapeBone("cape", new Vec3(0.5F, 0.5F, 0.75F)));
    }

    public RenderType getRenderType(GarmentsOfTheFirstFlamebearerArmorItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }
}
