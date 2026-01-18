package net.hazen.hazennstuff.Items.Equipment.ArmorSets.PyriumTier.Pyrium;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PyriumArmorModel extends GeoModel<PyriumArmorItem> {
    public PyriumArmorModel() {
    }

    public ResourceLocation getModelResource(PyriumArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/armor/pyrium_armor.geo.json");
    }

    public ResourceLocation getTextureResource(PyriumArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/armor/pyrium_armor.png");
    }

    public ResourceLocation getAnimationResource(PyriumArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
