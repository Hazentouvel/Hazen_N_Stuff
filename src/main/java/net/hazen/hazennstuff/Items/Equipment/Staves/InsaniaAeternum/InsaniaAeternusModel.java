package net.hazen.hazennstuff.Items.Equipment.Staves.InsaniaAeternum;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class InsaniaAeternusModel extends GeoModel<InsaniaAeternus> {
    public InsaniaAeternusModel() {
    }

    public ResourceLocation getModelResource(InsaniaAeternus object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/staves/insania_aeternus.geo.json");
    }

    public ResourceLocation getTextureResource(InsaniaAeternus object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/staves/insania_aeternus.png");
    }

    public ResourceLocation getAnimationResource(InsaniaAeternus animatable) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "animations/staves/insania_aeternus.animation.json");
    }
}
