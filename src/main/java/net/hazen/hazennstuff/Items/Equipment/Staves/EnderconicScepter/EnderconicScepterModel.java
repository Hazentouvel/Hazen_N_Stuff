package net.hazen.hazennstuff.Items.Equipment.Staves.EnderconicScepter;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EnderconicScepterModel extends GeoModel<EnderconicScepter> {
    public EnderconicScepterModel() {
    }

    public ResourceLocation getModelResource(EnderconicScepter object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/staves/enderconic_scepter.geo.json");
    }

    public ResourceLocation getTextureResource(EnderconicScepter object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/staves/enderconic_scepter.png");
    }

    public ResourceLocation getAnimationResource(EnderconicScepter animatable) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "animations/staves/enderconic_scepter.animation.json");
    }
}
