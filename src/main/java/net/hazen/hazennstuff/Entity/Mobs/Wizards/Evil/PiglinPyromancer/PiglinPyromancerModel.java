package net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.PiglinPyromancer;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMob;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMobModel;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;

public class PiglinPyromancerModel extends AbstractSpellCastingMobModel {

    @Override
    public ResourceLocation getTextureResource(AbstractSpellCastingMob mob) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/mobs/piglin_pyromancer.png");
    }

    @Override
    public ResourceLocation getModelResource(AbstractSpellCastingMob animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "geo/piglin_casting_mob.geo.json");
    }
}