package net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.CreakingSorcerer;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CreakingSorcererArmorModel extends GeoModel<CreakingSorcererArmorItem> {
    public CreakingSorcererArmorModel() {
    }

    public ResourceLocation getModelResource(CreakingSorcererArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/armor/creaking_sorcerer_armor.geo.json");
    }

    public ResourceLocation getTextureResource(CreakingSorcererArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/armor/creaking_sorcerer_armor.png");
    }

    public ResourceLocation getAnimationResource(CreakingSorcererArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
