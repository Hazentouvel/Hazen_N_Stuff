package net.hazen.hazennstuff.entity.mobs.wizards.Electromancer;

import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class ElectromancerRenderer extends AbstractSpellCastingMobRenderer {

    public ElectromancerRenderer(EntityRendererProvider.Context context) {
        super(context, new ElectromancerModel());
    }

}