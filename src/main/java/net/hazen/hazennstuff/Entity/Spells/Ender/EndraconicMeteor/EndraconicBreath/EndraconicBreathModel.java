package net.hazen.hazennstuff.Entity.Spells.Ender.EndraconicMeteor.EndraconicBreath;

import net.hazen.hazennstuff.Entity.Spells.Fire.ScorchingSlash.ScorchingBlade;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EndraconicBreathModel extends GeoModel<EndraconicBreath> {

    @Override
    public ResourceLocation getModelResource(EndraconicBreath animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/endraconic_breath.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EndraconicBreath animatable) {
        int frameCount = 4;
        int frameDuration = 1;
        int frame = (animatable.tickCount / frameDuration) % frameCount;
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/endraconic_breath_" + frame + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(EndraconicBreath animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/endraconic_breath.animation.json");
    }
}