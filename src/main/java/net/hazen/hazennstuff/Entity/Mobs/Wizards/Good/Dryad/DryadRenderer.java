package net.hazen.hazennstuff.Entity.Mobs.Wizards.Good.Dryad;

import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class DryadRenderer extends AbstractSpellCastingMobRenderer {
    public DryadRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DryadModel());
    }
}