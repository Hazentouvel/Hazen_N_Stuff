package net.hazen.hazennstuff.Items.Equipment.Weapons.Provocation;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ProvocationModel extends GeoModel<ProvocationItem> {
    public ProvocationModel() {
    }

    public ResourceLocation getModelResource(ProvocationItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/weapons/provocation.geo.json");
    }

    public ResourceLocation getTextureResource(ProvocationItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/weapons/provocation.png");
    }

    public ResourceLocation getAnimationResource(ProvocationItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "animations/weapons/provocation.animation.json");
    }
}
