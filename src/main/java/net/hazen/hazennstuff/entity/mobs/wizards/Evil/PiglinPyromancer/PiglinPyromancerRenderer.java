package net.hazen.hazennstuff.entity.mobs.wizards.Evil.PiglinPyromancer;

import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMobRenderer;
import net.hazen.hazennstuff.entity.mobs.wizards.Good.Dryad.DryadModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class PiglinPyromancerRenderer extends AbstractSpellCastingMobRenderer {
    public PiglinPyromancerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PiglinPyromancerModel());
    }
}