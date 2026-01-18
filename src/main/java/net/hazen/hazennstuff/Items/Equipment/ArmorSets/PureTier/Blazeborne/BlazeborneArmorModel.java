package net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.Blazeborne;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BlazeborneArmorModel extends GeoModel<BlazeborneArmorItem> {
    public BlazeborneArmorModel() {
    }

    public ResourceLocation getModelResource(BlazeborneArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/armor/blazeborne_armor.geo.json");
    }

    public ResourceLocation getTextureResource(BlazeborneArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/armor/blazeborne_armor.png");
    }

    public ResourceLocation getAnimationResource(BlazeborneArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "animations/armor/blazeborne_armor.animation.json");
    }
}
