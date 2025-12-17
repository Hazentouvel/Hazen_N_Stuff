package net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.PiglinPyromancer;

import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class PiglinPyromancerRenderer extends AbstractSpellCastingMobRenderer {
    public PiglinPyromancerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PiglinPyromancerModel());
    }
}