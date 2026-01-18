package net.hazen.hazennstuff.Items.Equipment.Weapons.Excalibur;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ExcaliburModel extends GeoModel<ExcaliburItem> {
    public ExcaliburModel() {
    }

    public ResourceLocation getModelResource(ExcaliburItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/weapons/excalibur_hazen_style.geo.json");
    }

    public ResourceLocation getTextureResource(ExcaliburItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/weapons/excalibur_hazen_style.png");
    }

    public ResourceLocation getAnimationResource(ExcaliburItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
