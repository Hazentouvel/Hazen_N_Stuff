package net.hazen.hazennstuff.entity.mobs.wizards.Evil.BishopOfDeciet;

import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMobRenderer;
import net.hazen.hazennstuff.entity.mobs.wizards.Evil.Electromancer.ElectromancerModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BishopOfDeceitRenderer extends AbstractSpellCastingMobRenderer {

    public BishopOfDeceitRenderer(EntityRendererProvider.Context context) {
        super(context, new BishopOfDeceitModel());
    }

}