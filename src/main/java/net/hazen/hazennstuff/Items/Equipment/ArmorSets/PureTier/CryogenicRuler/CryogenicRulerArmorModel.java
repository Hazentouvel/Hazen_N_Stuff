package net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.CryogenicRuler;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CryogenicRulerArmorModel extends GeoModel<CryogenicRulerArmorItem> {
    public CryogenicRulerArmorModel() {
    }

    public ResourceLocation getModelResource(CryogenicRulerArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/armor/cryogenic_ruler_armor.geo.json");
    }

    public ResourceLocation getTextureResource(CryogenicRulerArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/armor/cryogenic_ruler_armor.png");
    }

    public ResourceLocation getAnimationResource(CryogenicRulerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "animations/armor/cryogenic_ruler_armor.animation.json");
    }
}
