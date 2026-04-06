package net.hazen.hazennstuff.Entity.Spells.Shadow.ArcaneCards.Diamond;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DiamondModel extends GeoModel<Diamond> {

    @Override
    public ResourceLocation getModelResource(Diamond animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/card.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Diamond animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/card_diamond.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Diamond animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/shadow_reaver.animation.json");
    }
}