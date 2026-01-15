package net.hazen.hazennstuff.Items.Equipment.ArmorSets.Seraph;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SeraphArmorModel extends GeoModel<SeraphArmorItem> {
    public SeraphArmorModel() {
    }

    public ResourceLocation getModelResource(SeraphArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/armor/seraph_armor.geo.json");
    }

    public ResourceLocation getTextureResource(SeraphArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/armor/seraph_armor.png");
    }

    public ResourceLocation getAnimationResource(SeraphArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "animations/armor/seraph_armor.animation.json");
    }
}
