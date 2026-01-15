package net.hazen.hazennstuff.Entity.Spells.Blood.LifestealKnife;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LifestealKnifeModel extends GeoModel<VampireKnife> {

    @Override
    public ResourceLocation getModelResource(VampireKnife animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/vampire_knife_projectile.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(VampireKnife animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/vampire_knife_projectile.png");
    }

    @Override
    public ResourceLocation getAnimationResource(VampireKnife animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/vampire_knife_projectile.animation.json");
    }


}