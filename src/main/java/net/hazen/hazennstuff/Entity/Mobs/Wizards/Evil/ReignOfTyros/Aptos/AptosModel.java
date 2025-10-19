package net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.ReignOfTyros.Aptos;

import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMob;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMobModel;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;

public class AptosModel extends AbstractSpellCastingMobModel {
    public static final ResourceLocation textureResource = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/mobs/aptos.png");
    public static final ResourceLocation modelResource = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/mobs/aptos.geo.json");
    public static final ResourceLocation animationResource = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/mobs/aptos.animation.json");

    @Override
    public ResourceLocation getTextureResource(AbstractSpellCastingMob object) {
        return textureResource;
    }

    @Override
    public ResourceLocation getModelResource(AbstractSpellCastingMob object) {
        return modelResource;
    }

    @Override
    public ResourceLocation getAnimationResource(AbstractSpellCastingMob animatable) {
        return animationResource;
    }
}