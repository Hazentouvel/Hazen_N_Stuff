package net.hazen.hazennstuff.Entity.Spells.Astral.Evercomet;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EvercometModel extends GeoModel<Evercomet> {

    @Override
    public ResourceLocation getModelResource(Evercomet animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/evercomet.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Evercomet animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/evercomet.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Evercomet animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/evercomet.animation.json");
    }
}