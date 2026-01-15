package net.hazen.hazennstuff.Entity.Spells.Radiance.Terraprisma;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TerraprismaModel extends GeoModel<Terraprisma> {

    @Override
    public ResourceLocation getModelResource(Terraprisma animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/terraprisma.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Terraprisma animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/terraprisma/terraprisma_0.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Terraprisma animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/terraprisma.animation.json");
    }
}