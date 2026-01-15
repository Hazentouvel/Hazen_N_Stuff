package net.hazen.hazennstuff.Items.Equipment.Staves.DivineScepter;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DivineScepterModel extends GeoModel<DivineScepter> {
    public DivineScepterModel() {
    }

    public ResourceLocation getModelResource(DivineScepter object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/staves/divine_scepter.geo.json");
    }

    public ResourceLocation getTextureResource(DivineScepter object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/staves/divine_scepter.png");
    }

    public ResourceLocation getAnimationResource(DivineScepter animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
