package net.hazen.hazennstuff.Entity.Spells.Astral.ShootingStar.FallingStars;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FallingStarModel extends GeoModel<FallingStar> {

    @Override
    public ResourceLocation getModelResource(FallingStar animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/shooting_star.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FallingStar animatable) {
        int frameCount = 3;
        int frameDuration = 1; // ticks per frame
        int frame = (animatable.tickCount / frameDuration) % frameCount;
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/shooting_star_" + frame + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(FallingStar animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/shooting_star.animation.json");
    }
}