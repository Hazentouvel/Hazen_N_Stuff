package net.hazen.hazennstuff.entity.mobs.wizards.Good.Dryad;

import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMob;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMobModel;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.entity.mobs.wizards.Good.Dryad.DryadEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DryadModel extends AbstractSpellCastingMobModel {

    @Override
    public ResourceLocation getTextureResource(AbstractSpellCastingMob mob) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/mobs/dryad.png");
    }

    @Override
    public ResourceLocation getModelResource(AbstractSpellCastingMob animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/mobs/dryad.geo.json");
    }
}