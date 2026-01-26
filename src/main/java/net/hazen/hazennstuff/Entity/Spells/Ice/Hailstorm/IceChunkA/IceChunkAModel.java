package net.hazen.hazennstuff.Entity.Spells.Ice.Hailstorm.IceChunkA;

import net.hazen.hazennstuff.Entity.Spells.Nature.SpiderLily.SpiderLily;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class IceChunkAModel extends GeoModel<IceChunkA> {

    @Override
    public ResourceLocation getModelResource(IceChunkA animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/ice_chunk_a.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IceChunkA animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/ice_chunk_a.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IceChunkA animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/ice_chunk.animation.json");
    }
}