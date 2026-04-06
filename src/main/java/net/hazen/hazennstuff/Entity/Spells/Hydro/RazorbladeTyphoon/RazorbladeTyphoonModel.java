package net.hazen.hazennstuff.Entity.Spells.Hydro.RazorbladeTyphoon;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RazorbladeTyphoonModel extends GeoModel<RazorbladeTyphoon> {

    @Override
    public ResourceLocation getModelResource(RazorbladeTyphoon animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/razorblade_typhoon.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RazorbladeTyphoon animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/razorblade_typhoon.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RazorbladeTyphoon animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/razorblade_typhoon.animation.json");
    }
}