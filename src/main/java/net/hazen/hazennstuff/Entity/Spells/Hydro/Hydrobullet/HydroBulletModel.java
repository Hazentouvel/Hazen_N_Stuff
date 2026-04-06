package net.hazen.hazennstuff.Entity.Spells.Hydro.Hydrobullet;

import net.hazen.hazennstuff.Entity.Spells.Hydro.WaterBolt.WaterBolt;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HydroBulletModel extends GeoModel<HydroBullet> {

    @Override
    public ResourceLocation getModelResource(HydroBullet animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/hydrobullet.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HydroBullet animatable) {
        int frameCount = 7;
        int frameDuration = 1; // ticks per frame
        int frame = (animatable.tickCount / frameDuration) % frameCount;
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/hydrobullet_" + frame + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(HydroBullet animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/hydrobullet.animation.json");
    }
}