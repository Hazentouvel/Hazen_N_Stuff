package net.hazen.hazennstuff.Items.Equipment.Weapons.RavensBane;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RavensBaneModel extends GeoModel<RavensBaneItem> {
    public RavensBaneModel() {
    }

    public ResourceLocation getModelResource(RavensBaneItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/weapons/ravens_bane.geo.json");
    }

    public ResourceLocation getTextureResource(RavensBaneItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/weapons/ravens_bane.png");
    }

    public ResourceLocation getAnimationResource(RavensBaneItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
