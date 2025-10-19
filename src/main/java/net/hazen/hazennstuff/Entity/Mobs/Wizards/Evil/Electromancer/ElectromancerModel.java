package net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.Electromancer;

import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMob;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMobModel;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;

public class ElectromancerModel extends AbstractSpellCastingMobModel {
    @Override
    public ResourceLocation getTextureResource(AbstractSpellCastingMob mob) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/mobs/electromancer.png");
    }
}