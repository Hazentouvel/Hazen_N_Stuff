package net.hazen.hazennstuff.Items.Equipment.ArmorSets.PyriumTier.LegionnaireCommander;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LegionnaireCommanderArmorModel extends GeoModel<LegionnaireCommanderArmorItem> {
    public LegionnaireCommanderArmorModel() {
    }

    public ResourceLocation getModelResource(LegionnaireCommanderArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/armor/legionnaire_commander_armor.geo.json");
    }

    public ResourceLocation getTextureResource(LegionnaireCommanderArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/armor/legionnaire_commander_armor.png");
    }

    public ResourceLocation getAnimationResource(LegionnaireCommanderArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
