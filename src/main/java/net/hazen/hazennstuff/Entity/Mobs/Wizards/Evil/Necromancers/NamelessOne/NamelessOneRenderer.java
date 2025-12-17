package net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.Necromancers.NamelessOne;

import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMob;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMobRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class NamelessOneRenderer extends AbstractSpellCastingMobRenderer {
    public NamelessOneRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new NamelessOneModel());

        this.addRenderLayer(new NamelessOneEmissiveLayer(this));
    }

    public RenderType getRenderType(AbstractSpellCastingMob animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return animatable.isInvisible() ? RenderType.entityTranslucent(texture) : RenderType.entityCutoutNoCull(texture);
    }
}
