package net.hazen.hazennstuff.Entity.Spells.Shadow.ShadowDagger;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ShadowDaggerModel extends GeoModel<ShadowDagger> {

    @Override
    public ResourceLocation getModelResource(ShadowDagger animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/shadow_dagger.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ShadowDagger animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/shadow_dagger.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ShadowDagger animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/spark.animation.json");
    }
}