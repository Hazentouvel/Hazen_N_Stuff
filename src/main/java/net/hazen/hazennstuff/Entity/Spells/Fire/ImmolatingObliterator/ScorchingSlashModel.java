package net.hazen.hazennstuff.Entity.Spells.Fire.ImmolatingObliterator;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ScorchingSlashModel extends GeoModel<ScorchingSlash> {

    @Override
    public ResourceLocation getModelResource(ScorchingSlash animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/nights_edge_after_slash.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ScorchingSlash animatable) {
        int frameCount = 4;
        int frameDuration = 1;
        int frame = (animatable.tickCount / frameDuration) % frameCount;
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/immolating_obliterator_" + frame + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(ScorchingSlash animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/nights_edge_after_slash.animation.json");
    }
}