package net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.ThunderProwler;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ThunderProwlerArmorModel extends GeoModel<ThunderProwlerArmorItem> {
    public ThunderProwlerArmorModel() {
    }

    public ResourceLocation getModelResource(ThunderProwlerArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/armor/thunder_prowler_armor.geo.json");
    }

    public ResourceLocation getTextureResource(ThunderProwlerArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/armor/thunder_prowler_armor.png");
    }

    public ResourceLocation getAnimationResource(ThunderProwlerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
