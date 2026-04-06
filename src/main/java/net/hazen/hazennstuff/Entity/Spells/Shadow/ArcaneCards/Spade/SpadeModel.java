package net.hazen.hazennstuff.Entity.Spells.Shadow.ArcaneCards.Spade;

import net.hazen.hazennstuff.Entity.Spells.Shadow.ArcaneCards.Heart.Heart;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpadeModel extends GeoModel<Spade> {

    @Override
    public ResourceLocation getModelResource(Spade animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/card.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Spade animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/card_spade.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Spade animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/shadow_reaver.animation.json");
    }
}