package net.hazen.hazennstuff.Entity.Spells.Ice.Hailstorm.IceChunkB;

import net.hazen.hazennstuff.Entity.Spells.Nature.SpiderLily.SpiderLily;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class IceChunkBModel extends GeoModel<IceChunkB> {

    @Override
    public ResourceLocation getModelResource(IceChunkB animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/ice_chunk_b.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IceChunkB animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/ice_chunk_b.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IceChunkB animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/ice_chunk.animation.json");
    }
}