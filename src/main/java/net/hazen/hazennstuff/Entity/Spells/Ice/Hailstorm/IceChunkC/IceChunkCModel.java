package net.hazen.hazennstuff.Entity.Spells.Ice.Hailstorm.IceChunkC;

import net.hazen.hazennstuff.Entity.Spells.Nature.SpiderLily.SpiderLily;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class IceChunkCModel extends GeoModel<IceChunkC> {

    @Override
    public ResourceLocation getModelResource(IceChunkC animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/ice_chunk_c.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IceChunkC animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/ice_chunk_c.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IceChunkC animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/ice_chunk.animation.json");
    }
}