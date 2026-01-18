package net.hazen.hazennstuff.Items.Equipment.Weapons.OFortuna;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OFortunaModel extends GeoModel<OFortunaItem> {
    public OFortunaModel() {
    }

    public ResourceLocation getModelResource(OFortunaItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/weapons/o_fortuna.geo.json");
    }

    public ResourceLocation getTextureResource(OFortunaItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/weapons/o_fortuna.png");
    }

    public ResourceLocation getAnimationResource(OFortunaItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
