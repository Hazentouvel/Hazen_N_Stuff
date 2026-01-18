package net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.FleshMass;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FleshMassArmorModel extends GeoModel<FleshMassArmorItem> {
    public FleshMassArmorModel() {
    }

    public ResourceLocation getModelResource(FleshMassArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/armor/flesh_mass_armor.geo.json");
    }

    public ResourceLocation getTextureResource(FleshMassArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/armor/flesh_mass_armor.png");
    }

    public ResourceLocation getAnimationResource(FleshMassArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "animations/armor/flesh_mass_armor.animation.json");
    }
}
