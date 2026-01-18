package net.hazen.hazennstuff.Items.Equipment.ArmorSets.DedicatedArmorSets.AtlasArmor;

import net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.Blazeborne.BlazeborneArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AtlasArmorModel extends GeoModel<AtlasArmorItem> {
    public AtlasArmorModel() {
    }

    public ResourceLocation getModelResource(AtlasArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/armor/atlas_armor.geo.json");
    }

    public ResourceLocation getTextureResource(AtlasArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/armor/atlas_armor.png");
    }

    public ResourceLocation getAnimationResource(AtlasArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "animations/armor/atlas_armor.animation.json");
    }
}
