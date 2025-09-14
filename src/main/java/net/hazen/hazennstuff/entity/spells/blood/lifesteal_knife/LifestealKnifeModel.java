package net.hazen.hazennstuff.entity.spells.blood.lifesteal_knife;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LifestealKnifeModel extends GeoModel<LifestealKnife> {

    @Override
    public ResourceLocation getModelResource(LifestealKnife animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/vampire_knife_projectile.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LifestealKnife animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/vampire_knife_projectile/vampire_knife_projectile.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LifestealKnife animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/vampire_knife_projectile.animation.json");
    }


}