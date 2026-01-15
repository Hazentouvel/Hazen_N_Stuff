package net.hazen.hazennstuff.Items.Equipment.ArmorSets.Hazel;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BigHazelArmorModel extends GeoModel<BigHazelArmorItem> {
    public BigHazelArmorModel() {
    }

    public ResourceLocation getModelResource(BigHazelArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/armor/hazel_reprised.geo.json");
    }

    public ResourceLocation getTextureResource(BigHazelArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/armor/hazel.png");
    }

    public ResourceLocation getAnimationResource(BigHazelArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
