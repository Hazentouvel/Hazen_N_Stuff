package net.hazen.hazennstuff.entity.spells.lightning.spark;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SparkModel extends GeoModel<Spark> {

    @Override
    public ResourceLocation getModelResource(Spark animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/spark.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Spark animatable) {
        int frameCount = 4;
        int frameDuration = 1; // ticks per frame
        int frame = (animatable.tickCount / frameDuration) % frameCount;
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/spark/spark_" + frame + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(Spark animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/spark.animation.json");
    }
}