package net.hazen.hazennstuff.Item.Curios.Wings.AngelWings;

import net.hazen.hazentouvelib.HazentouveLib;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class AngelWingsModel extends DefaultedItemGeoModel<AngelWings> {
    public AngelWingsModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazentouveLib.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(AngelWings animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazentouveLib.MOD_ID, "geo/item/wing_base.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AngelWings animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazentouveLib.MOD_ID, "textures/item/curios/wings/wing_base.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AngelWings animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazentouveLib.MOD_ID, "animations/item/wing_base.animation.json");
    }
}
