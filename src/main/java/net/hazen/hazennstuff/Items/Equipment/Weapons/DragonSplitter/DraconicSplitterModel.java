package net.hazen.hazennstuff.Items.Equipment.Weapons.DragonSplitter;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DraconicSplitterModel extends GeoModel<DraconicSplitterItem> {
    public DraconicSplitterModel() {
    }

    public ResourceLocation getModelResource(DraconicSplitterItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/weapons/draconic_splitter.geo.json");
    }

    public ResourceLocation getTextureResource(DraconicSplitterItem object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/weapons/draconic_splitter.png");
    }

    public ResourceLocation getAnimationResource(DraconicSplitterItem animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
