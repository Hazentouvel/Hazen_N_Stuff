package net.hazen.hazennstuff.Items.Equipment.Weapons.Devastator;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DevastatorModel extends GeoModel<DevastatorItem> {
    public DevastatorModel() {
    }

    public ResourceLocation getModelResource(DevastatorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/weapons/devastator.geo.json");
    }

    public ResourceLocation getTextureResource(DevastatorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/weapons/devastator.png");
    }

    public ResourceLocation getAnimationResource(DevastatorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
