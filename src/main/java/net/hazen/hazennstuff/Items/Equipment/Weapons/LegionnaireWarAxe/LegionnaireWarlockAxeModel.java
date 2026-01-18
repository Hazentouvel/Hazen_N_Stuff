package net.hazen.hazennstuff.Items.Equipment.Weapons.LegionnaireWarAxe;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LegionnaireWarlockAxeModel extends GeoModel<LegionnaireWarlockAxeItem> {
    public LegionnaireWarlockAxeModel() {
    }

    public ResourceLocation getModelResource(LegionnaireWarlockAxeItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/weapons/legionnaire_warlock_axe.geo.json");
    }

    public ResourceLocation getTextureResource(LegionnaireWarlockAxeItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/weapons/legionnaire_warlock_axe.png");
    }

    public ResourceLocation getAnimationResource(LegionnaireWarlockAxeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
