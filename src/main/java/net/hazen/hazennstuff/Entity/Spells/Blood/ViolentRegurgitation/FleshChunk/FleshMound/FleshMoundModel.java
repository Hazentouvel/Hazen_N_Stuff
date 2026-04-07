package net.hazen.hazennstuff.Entity.Spells.Blood.ViolentRegurgitation.FleshChunk.FleshMound;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FleshMoundModel extends GeoModel<FleshMound> {

    @Override
    public ResourceLocation getModelResource(FleshMound animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/endraconic_breath.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FleshMound animatable) {
        int frameCount = 4;
        int frameDuration = 1;
        int frame = (animatable.tickCount / frameDuration) % frameCount;
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/endraconic_breath_" + frame + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(FleshMound animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/endraconic_breath_.animation.json");
    }
}