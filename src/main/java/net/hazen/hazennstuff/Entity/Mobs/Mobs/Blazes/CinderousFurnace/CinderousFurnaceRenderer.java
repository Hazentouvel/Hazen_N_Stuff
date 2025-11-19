package net.hazen.hazennstuff.Entity.Mobs.Mobs.Blazes.CinderousFurnace;

import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class CinderousFurnaceRenderer extends AbstractSpellCastingMobRenderer {

    public CinderousFurnaceRenderer(EntityRendererProvider.Context context) {
        super(context, new CinderousFurnaceModel());

        this.addRenderLayer(new CinderousFurnaceEmissiveLayer(this));
    }

}