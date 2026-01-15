package net.hazen.hazennstuff.Items.Equipment.ArmorSets.Hazel;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HazelArmorModel extends GeoModel<HazelArmorItem> {
    public HazelArmorModel() {
    }

    public ResourceLocation getModelResource(HazelArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/armor/hazel_reprised.geo.json");
    }

    public ResourceLocation getTextureResource(HazelArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/armor/hazel.png");
    }

    public ResourceLocation getAnimationResource(HazelArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
