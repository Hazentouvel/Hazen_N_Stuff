package net.hazen.hazennstuff.Entity.Spells.Fire.BrimstoneHellblast;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BrimstoneHellblastModel extends GeoModel<BrimstoneHellblast> {

    @Override
    public ResourceLocation getModelResource(BrimstoneHellblast animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/brimstone_hellblast.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BrimstoneHellblast animatable) {
        int frameCount = 5;
        int frameDuration = 2; // ticks per frame
        int frame = (animatable.tickCount / frameDuration) % frameCount;
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/brimstone_hellblast_" + frame + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(BrimstoneHellblast animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/brimstone_hellblast.animation.json");
    }

}