package net.hazen.hazennstuff.Entity.Spells.Shadow.ShadowReaver;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ShadowReaverModel extends GeoModel<ShadowReaver> {

    @Override
    public ResourceLocation getModelResource(ShadowReaver animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/shadow_reaver.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ShadowReaver animatable) {
        int frameCount = 6;
        int frameDuration = 1; // ticks per frame
        int frame = (animatable.tickCount / frameDuration) % frameCount;
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/shadow_reaver_" + frame + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(ShadowReaver animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/shadow_reaver.animation.json");
    }
}