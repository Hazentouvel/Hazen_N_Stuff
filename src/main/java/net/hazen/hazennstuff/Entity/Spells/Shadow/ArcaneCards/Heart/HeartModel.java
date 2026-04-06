package net.hazen.hazennstuff.Entity.Spells.Shadow.ArcaneCards.Heart;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HeartModel extends GeoModel<Heart> {

    @Override
    public ResourceLocation getModelResource(Heart animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/card.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Heart animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/card_heart.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Heart animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/shadow_reaver.animation.json");
    }
}