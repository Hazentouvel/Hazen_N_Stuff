package net.hazen.hazennstuff.Entity.Spells.Nature.SpiderLily;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpiderLilyModel extends GeoModel<SpiderLily> {

    @Override
    public ResourceLocation getModelResource(SpiderLily animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/spider_lily.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SpiderLily animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/spider_lily.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SpiderLily animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/spider_lily.animation.json");
    }
}