package net.hazen.hazennstuff.Items.Equipment.Staves.EnderconicScepter;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EnderconicStaffModel extends GeoModel<EnderconicStaff> {
    public EnderconicStaffModel() {
    }

    public ResourceLocation getModelResource(EnderconicStaff object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/staves/enderconic_staff.geo.json");
    }

    public ResourceLocation getTextureResource(EnderconicStaff object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/staves/enderconic_staff.png");
    }

    public ResourceLocation getAnimationResource(EnderconicStaff animatable) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "animations/staves/enderconic_staff.animation.json");
    }
}
