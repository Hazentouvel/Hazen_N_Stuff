package net.hazen.hazennstuff.Items.Equipment.Staves.BlossomOfTheEnchantress;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BlossomOfTheEnchantressModel extends GeoModel<BlossomOfTheEnchantress> {
    public BlossomOfTheEnchantressModel() {
    }

    public ResourceLocation getModelResource(BlossomOfTheEnchantress object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/staves/blossom_of_the_enchantress.geo.json");
    }

    public ResourceLocation getTextureResource(BlossomOfTheEnchantress object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/staves/blossom_of_the_enchantress.png");
    }

    public ResourceLocation getAnimationResource(BlossomOfTheEnchantress animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
