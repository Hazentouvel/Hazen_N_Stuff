package net.hazen.hazennstuff.Items.Equipment.Weapons.FireblossomRapier;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FireblossomRapierModel extends GeoModel<FireblossomRapierItem> {
    public FireblossomRapierModel() {
    }

    public ResourceLocation getModelResource(FireblossomRapierItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/weapons/fireblossom_rapier.geo.json");
    }

    public ResourceLocation getTextureResource(FireblossomRapierItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/weapons/fireblossom_rapier.png");
    }

    public ResourceLocation getAnimationResource(FireblossomRapierItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
