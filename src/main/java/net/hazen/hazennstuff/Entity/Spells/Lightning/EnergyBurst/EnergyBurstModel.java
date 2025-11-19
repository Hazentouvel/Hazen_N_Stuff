package net.hazen.hazennstuff.Entity.Spells.Lightning.EnergyBurst;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EnergyBurstModel extends GeoModel<EnergyBurst> {

    @Override
    public ResourceLocation getModelResource(EnergyBurst animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/energy_burst.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EnergyBurst animatable) {
        int frameCount = 4;
        int frameDuration = 1; // ticks per frame
        int frame = (animatable.tickCount / frameDuration) % frameCount;
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/spark_" + frame + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(EnergyBurst animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/spark.animation.json");
    }
}