package net.hazen.hazennstuff.Items.Equipment.ArmorSets.EnderDragon;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EnderDragonArmorModel extends GeoModel<EnderDragonArmorItem> {
    public EnderDragonArmorModel() {
    }

    public ResourceLocation getModelResource(EnderDragonArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/armor/ender_dragon_armor.geo.json");
    }

    public ResourceLocation getTextureResource(EnderDragonArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/armor/ender_dragon_armor.png");
    }

    public ResourceLocation getAnimationResource(EnderDragonArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
