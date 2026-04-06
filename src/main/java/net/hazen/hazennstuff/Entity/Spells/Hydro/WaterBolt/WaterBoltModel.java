package net.hazen.hazennstuff.Entity.Spells.Hydro.WaterBolt;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WaterBoltModel extends GeoModel<WaterBolt> {

    @Override
    public ResourceLocation getModelResource(WaterBolt animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/water_bolt.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WaterBolt animatable) {
        int frameCount = 2;
        int frameDuration = 3;
        int frame = (animatable.tickCount / frameDuration) % frameCount;
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/water_bolt_" + frame + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(WaterBolt animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/shadow_reaver.animation.json");
    }
}