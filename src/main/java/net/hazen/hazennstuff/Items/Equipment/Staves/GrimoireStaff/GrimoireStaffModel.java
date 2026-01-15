package net.hazen.hazennstuff.Items.Equipment.Staves.GrimoireStaff;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GrimoireStaffModel extends GeoModel<GrimoireStaff> {
    public GrimoireStaffModel() {
    }

    public ResourceLocation getModelResource(GrimoireStaff object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/staves/grimoire_staff.geo.json");
    }

    public ResourceLocation getTextureResource(GrimoireStaff object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/staves/grimoire_staff.png");
    }

    public ResourceLocation getAnimationResource(GrimoireStaff animatable) {
        return ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "animations/wizard_armor_animation.json");
    }
}
