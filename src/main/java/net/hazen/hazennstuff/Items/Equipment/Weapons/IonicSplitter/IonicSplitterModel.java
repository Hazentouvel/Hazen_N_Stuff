package net.hazen.hazennstuff.Items.Equipment.Weapons.IonicSplitter;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class IonicSplitterModel extends GeoModel<IonicSplitterItem> {
    public IonicSplitterModel() {
    }

    public ResourceLocation getModelResource(IonicSplitterItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/weapons/ionic_splitter.geo.json");
    }

    public ResourceLocation getTextureResource(IonicSplitterItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/weapons/ionic_splitter_t3.png");
    }

    public ResourceLocation getAnimationResource(IonicSplitterItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
