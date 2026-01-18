package net.hazen.hazennstuff.Items.Equipment.ArmorSets.PyriumTier.LegionnaireRuler;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LegionnaireRulerArmorModel extends GeoModel<LegionnaireRulerArmorItem> {
    public LegionnaireRulerArmorModel() {
    }

    public ResourceLocation getModelResource(LegionnaireRulerArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/armor/legionnaire_ruler_armor.geo.json");
    }

    public ResourceLocation getTextureResource(LegionnaireRulerArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/armor/legionnaire_ruler_soul_armor.png");
    }

    public ResourceLocation getAnimationResource(LegionnaireRulerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
