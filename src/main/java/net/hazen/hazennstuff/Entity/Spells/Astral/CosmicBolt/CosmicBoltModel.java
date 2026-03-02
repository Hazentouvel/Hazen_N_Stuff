package net.hazen.hazennstuff.Entity.Spells.Astral.CosmicBolt;

import net.hazen.hazennstuff.Entity.Spells.Lightning.EnergyBurst.EnergyBurst;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CosmicBoltModel extends GeoModel<CosmicBolt> {

    @Override
    public ResourceLocation getModelResource(CosmicBolt animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/cosmic_bolt.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CosmicBolt animatable) {
        int frameCount = 8;
        int frameDuration = 1; // ticks per frame
        int frame = (animatable.tickCount / frameDuration) % frameCount;
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/cosmic_bolt_" + frame + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(CosmicBolt animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/cosmic_bolt.animation.json");
    }
}