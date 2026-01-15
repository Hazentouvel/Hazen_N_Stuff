package net.hazen.hazennstuff.Items.Equipment.Staves.InsaniaAeternum;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class InsaniaAeternumModel extends GeoModel<InsaniaAeternum> {
    public InsaniaAeternumModel() {
    }

    public ResourceLocation getModelResource(InsaniaAeternum object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/staves/insania_aeternum.geo.json");
    }

    public ResourceLocation getTextureResource(InsaniaAeternum object) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/staves/insania_aeternum.png");
    }

    public ResourceLocation getAnimationResource(InsaniaAeternum animatable) {
        return ResourceLocation.fromNamespaceAndPath("hazennstuff", "animations/staves/insania_aeternum.animation.json");
    }
}
