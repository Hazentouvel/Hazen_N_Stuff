package net.hazen.hazennstuff.Entity.Mobs.Summons.SummonTerraprisma;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SummonedTerraprismaModel extends GeoModel<SummonedTerraprisma> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/spells/terraprisma/terraprisma_0.png");
    public static final ResourceLocation MODEL = ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/entities/spells/terraprisma.geo.json");
    public static final ResourceLocation ANIMATIONS = ResourceLocation.fromNamespaceAndPath("hazennstuff", "animations/entities/spells/terraprisma.animation.json");

    public SummonedTerraprismaModel() {
    }

    public ResourceLocation getModelResource(SummonedTerraprisma animatable) {
        return MODEL;
    }

    public ResourceLocation getTextureResource(SummonedTerraprisma animatable) {
        return TEXTURE;
    }

    public ResourceLocation getAnimationResource(SummonedTerraprisma animatable) {
        return ANIMATIONS;
    }
}
