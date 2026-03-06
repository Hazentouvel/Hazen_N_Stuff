package net.hazen.hazennstuff.Entity.Mobs.Mobs.VoidWanderer;

import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMob;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class VoidWandererModel extends GeoModel<VoidWanderer> {

    @Override
    public ResourceLocation getTextureResource(VoidWanderer mob) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/mobs/void_wanderer.png");
    }

    @Override
    public ResourceLocation getModelResource(VoidWanderer animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/mobs/void_wanderer.geo.json");
    }

    @Override
    public ResourceLocation getAnimationResource(VoidWanderer animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/mobs/void_wanderer.animation.json");
    }
}
