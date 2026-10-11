package net.hazen.hazennstuff.Item.Armor.PureTier.Blazeborne;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class GeckolibBlazeborneArmorRenderer extends GeoArmorRenderer<GeckolibBlazeborneArmorItem> {
    public GeckolibBlazeborneArmorRenderer(GeckolibBlazeborneArmorModel blazeborneArmorModel) {
        super(new GeckolibBlazeborneArmorModel());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }

    public RenderType getRenderType(GeckolibBlazeborneArmorItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }
}
