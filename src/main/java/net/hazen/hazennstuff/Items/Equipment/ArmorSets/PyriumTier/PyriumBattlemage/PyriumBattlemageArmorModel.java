package net.hazen.hazennstuff.Items.Equipment.ArmorSets.PyriumTier.PyriumBattlemage;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PyriumBattlemageArmorModel extends GeoModel<PyriumBattlemageArmorItem> {
    public PyriumBattlemageArmorModel() {
    }

    public ResourceLocation getModelResource(PyriumBattlemageArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/armor/pyrium_battlemage_armor.geo.json");
    }

    public ResourceLocation getTextureResource(PyriumBattlemageArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/armor/pyrium_battlemage_armor.png");
    }

    public ResourceLocation getAnimationResource(PyriumBattlemageArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
