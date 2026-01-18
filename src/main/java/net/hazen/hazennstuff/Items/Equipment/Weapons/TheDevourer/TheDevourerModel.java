package net.hazen.hazennstuff.Items.Equipment.Weapons.TheDevourer;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TheDevourerModel extends GeoModel<TheDevourerItem> {
    public TheDevourerModel() {
    }

    public ResourceLocation getModelResource(TheDevourerItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/weapons/the_devourer.geo.json");
    }

    public ResourceLocation getTextureResource(TheDevourerItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/weapons/the_devourer.png");
    }

    public ResourceLocation getAnimationResource(TheDevourerItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
