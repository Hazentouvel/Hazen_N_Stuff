package net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.AlchemistSupreme;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AlchemistSupremeArmorModel extends GeoModel<AlchemistSupremeArmorItem> {
    public AlchemistSupremeArmorModel() {
    }

    public ResourceLocation getModelResource(AlchemistSupremeArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/armor/alchemist_supreme_armor.geo.json");
    }

    public ResourceLocation getTextureResource(AlchemistSupremeArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/armor/alchemist_supreme_armor.png");
    }

    public ResourceLocation getAnimationResource(AlchemistSupremeArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
