package net.hazen.hazennstuff.Items.Equipment.Weapons.IcePike;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class IcePikeModel extends GeoModel<IcePikeItem> {
    public IcePikeModel() {
    }

    public ResourceLocation getModelResource(IcePikeItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/weapons/ice_pike.geo.json");
    }

    public ResourceLocation getTextureResource(IcePikeItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/weapons/ice_pike.png");
    }

    public ResourceLocation getAnimationResource(IcePikeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
