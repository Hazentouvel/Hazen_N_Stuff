package net.hazen.hazennstuff.Entity.Spells.Ender.EndraconicMeteor;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EndraconicMeteorModel extends GeoModel<EndraconicMeteor> {

    @Override
    public ResourceLocation getModelResource(EndraconicMeteor animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/endraconic_meteor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EndraconicMeteor animatable) {
        int frameCount = 5;
        int frameDuration = 2; // ticks per frame
        int frame = (animatable.tickCount / frameDuration) % frameCount;
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/endraconic_meteor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EndraconicMeteor animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/endraconic_meteor.animation.json");
    }

}