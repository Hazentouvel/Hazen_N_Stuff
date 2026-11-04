package net.hazen.hazennstuff.Item.Armor.PureTier.CreakingSorcerer;

import net.hazen.hazennstuff.Item.Armor.PureTier.Blazeborne.GeckolibBlazeborneArmorItem;
import net.hazen.hazennstuff.Item.Armor.PureTier.Blazeborne.GeckolibBlazeborneArmorModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class GeckolibCreakingSorcererArmorRenderer extends GeoArmorRenderer<GeckolibCreakingSorcererArmorItem> {
    public GeckolibCreakingSorcererArmorRenderer(GeckolibCreakingSorcererArmorModel creakingSorcererArmorModel) {
        super(new GeckolibCreakingSorcererArmorModel());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }

    public RenderType getRenderType(GeckolibCreakingSorcererArmorItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(this.getTextureLocation(animatable));
    }
}
