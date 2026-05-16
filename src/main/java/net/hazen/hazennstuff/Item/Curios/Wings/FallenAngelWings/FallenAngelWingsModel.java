package net.hazen.hazennstuff.Item.Curios.Wings.FallenAngelWings;

import net.hazen.hazentouvelib.HazentouveLib;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class FallenAngelWingsModel extends DefaultedItemGeoModel<FallenAngelWings> {
    public FallenAngelWingsModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazentouveLib.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(FallenAngelWings animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazentouveLib.MOD_ID, "geo/item/wing_base.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FallenAngelWings animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazentouveLib.MOD_ID, "textures/item/curios/wings/fallen_angel_wings.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FallenAngelWings animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazentouveLib.MOD_ID, "animations/item/wing_base.animation.json");
    }
}
