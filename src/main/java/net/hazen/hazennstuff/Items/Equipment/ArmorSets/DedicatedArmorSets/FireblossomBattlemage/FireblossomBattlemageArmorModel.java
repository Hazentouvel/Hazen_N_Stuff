package net.hazen.hazennstuff.Items.Equipment.ArmorSets.DedicatedArmorSets.FireblossomBattlemage;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FireblossomBattlemageArmorModel extends GeoModel<FireblossomBattlemageArmorItem> {
    public FireblossomBattlemageArmorModel() {
    }

    public ResourceLocation getModelResource(FireblossomBattlemageArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/armor/fireblossom_battlemage_armor.geo.json");
    }

    public ResourceLocation getTextureResource(FireblossomBattlemageArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/armor/fireblossom_battlemage_helmet_armor.png");
    }

    public ResourceLocation getAnimationResource(FireblossomBattlemageArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "animations/armor/blazeborne_armor.animation.json");
    }
}
