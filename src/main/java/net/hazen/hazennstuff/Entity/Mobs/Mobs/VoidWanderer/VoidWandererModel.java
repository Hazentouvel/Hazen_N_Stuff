package net.hazen.hazennstuff.Entity.Mobs.Mobs.VoidWanderer;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class VoidWandererModel extends GeoModel<VoidWanderer> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/mobs/void_wanderer.png");
    public static final ResourceLocation MODEL = ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/entities/mobs/void_wanderer.geo.json");
    public static final ResourceLocation ANIMATIONS = ResourceLocation.fromNamespaceAndPath("hazennstuff", "animations/entities/mobs/void_wanderer.animation.json");

    public VoidWandererModel() {
    }

    public ResourceLocation getModelResource(VoidWanderer animatable) {
        return MODEL;
    }

    public ResourceLocation getTextureResource(VoidWanderer animatable) {
        return TEXTURE;
    }

    public ResourceLocation getAnimationResource(VoidWanderer animatable) {
        return ANIMATIONS;
    }
}
