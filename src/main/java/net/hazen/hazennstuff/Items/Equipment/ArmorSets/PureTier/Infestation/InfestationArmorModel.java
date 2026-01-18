package net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.Infestation;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class InfestationArmorModel extends GeoModel<InfestationArmorItem> {
    public InfestationArmorModel() {
    }

    public ResourceLocation getModelResource(InfestationArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/armor/infestation_armor.geo.json");
    }

    public ResourceLocation getTextureResource(InfestationArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/armor/infestation_armor.png");
    }

    public ResourceLocation getAnimationResource(InfestationArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "animations/armor/infestation_armor.animation.json");
    }
}
