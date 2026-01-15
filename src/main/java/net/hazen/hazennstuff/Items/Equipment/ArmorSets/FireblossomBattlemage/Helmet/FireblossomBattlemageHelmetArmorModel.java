package net.hazen.hazennstuff.Items.Equipment.ArmorSets.FireblossomBattlemage.Helmet;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FireblossomBattlemageHelmetArmorModel extends GeoModel<FireblossomBattlemageHelmetArmorItem> {
    public FireblossomBattlemageHelmetArmorModel() {
    }

    public ResourceLocation getModelResource(FireblossomBattlemageHelmetArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/armor/fireblossom_battlemage_armor.geo.json");
    }

    public ResourceLocation getTextureResource(FireblossomBattlemageHelmetArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/armor/fireblossom_battlemage_helmet_armor.png");
    }

    public ResourceLocation getAnimationResource(FireblossomBattlemageHelmetArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "animations/armor/blazeborne_armor.animation.json");
    }
}
