package net.hazen.hazennstuff.Entity.Spells.Blood.ViolentRegurgitation.FleshChunk;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FleshChunkModel extends GeoModel<FleshChunk> {

    @Override
    public ResourceLocation getModelResource(FleshChunk animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/flesh_chunk.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FleshChunk animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/flesh_chunk.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FleshChunk animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/flesh_chunk.animation.json");
    }
}