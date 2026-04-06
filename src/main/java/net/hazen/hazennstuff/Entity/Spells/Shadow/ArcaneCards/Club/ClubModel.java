package net.hazen.hazennstuff.Entity.Spells.Shadow.ArcaneCards.Club;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClubModel extends GeoModel<Club> {

    @Override
    public ResourceLocation getModelResource(Club animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/card.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Club animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/card_club.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Club animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/shadow_reaver.animation.json");
    }
}