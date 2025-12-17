package net.hazen.hazennstuff.Entity.Spells.Eldritch.SoulSeeker;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SoulSeekerModel extends GeoModel<SoulSeeker> {

    @Override
    public ResourceLocation getModelResource(SoulSeeker animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/soul_seeker.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SoulSeeker animatable) {
        int frameCount = 4;
        int frameDuration = 1; // ticks per frame
        int frame = (animatable.tickCount / frameDuration) % frameCount;
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/soul_seeker_" + frame + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(SoulSeeker animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/spark.animation.json");
    }
}