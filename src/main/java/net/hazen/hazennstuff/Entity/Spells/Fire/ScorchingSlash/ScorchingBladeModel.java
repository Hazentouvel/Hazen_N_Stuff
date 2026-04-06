package net.hazen.hazennstuff.Entity.Spells.Fire.ScorchingSlash;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ScorchingBladeModel extends GeoModel<ScorchingBlade> {

    @Override
    public ResourceLocation getModelResource(ScorchingBlade animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/scorched_blade.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ScorchingBlade animatable) {
        int frameCount = 7;
        int frameDuration = 1;
        int frame = (animatable.tickCount / frameDuration) % frameCount;
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/scorched_blade_" + frame + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(ScorchingBlade animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/scorched_blade.animation.json");
    }
}