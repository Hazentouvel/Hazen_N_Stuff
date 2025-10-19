package net.hazen.hazennstuff.Entity.Spells.Shadow.NightsEdgeAfterSlash;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NightsEdgeAfterSlashModel extends GeoModel<NightsEdgeAfterSlash> {

    @Override
    public ResourceLocation getModelResource(NightsEdgeAfterSlash animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/nights_edge_after_slash.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NightsEdgeAfterSlash animatable) {
        int frameCount = 8;
        int frameDuration = 1;
        int frame = (animatable.tickCount / frameDuration) % frameCount;
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/nights_edge_after_slash_" + frame + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(NightsEdgeAfterSlash animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/nights_edge_after_slash.animation.json");
    }
}