package net.hazen.hazennstuff.Items.Equipment.ArmorSets.MithrilTier.MithrilBattlemage;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MithrilBattlemageArmorModel extends GeoModel<MithrilBattlemageArmorItem> {
    public MithrilBattlemageArmorModel() {
    }

    public ResourceLocation getModelResource(MithrilBattlemageArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/armor/mithril_battlemage_armor.geo.json");
    }

    public ResourceLocation getTextureResource(MithrilBattlemageArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/armor/mithril_battlemage_armor.png");
    }

    public ResourceLocation getAnimationResource(MithrilBattlemageArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
