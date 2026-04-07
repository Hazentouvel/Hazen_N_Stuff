package net.hazen.hazennstuff.Entity.Spells.Blood.ViolentRegurgitation.FleshChunk;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FleshChunkModel extends GeoModel<FleshChunk> {

    @Override
    public ResourceLocation getModelResource(FleshChunk animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/hydrobullet.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FleshChunk animatable) {
        int frameCount = 7;
        int frameDuration = 1; // ticks per frame
        int frame = (animatable.tickCount / frameDuration) % frameCount;
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/hydrobullet_" + frame + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(FleshChunk animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/hydrobullet.animation.json");
    }
}