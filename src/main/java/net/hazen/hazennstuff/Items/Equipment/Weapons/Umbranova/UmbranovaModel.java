package net.hazen.hazennstuff.Items.Equipment.Weapons.Umbranova;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class UmbranovaModel extends GeoModel<UmbranovaItem> {
    public UmbranovaModel() {
    }

    public ResourceLocation getModelResource(UmbranovaItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/weapons/umbranova.geo.json");
    }

    public ResourceLocation getTextureResource(UmbranovaItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/weapons/umbranova.png");
    }

    public ResourceLocation getAnimationResource(UmbranovaItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "animations/weapons/umbranova.animation.json");
    }
}
