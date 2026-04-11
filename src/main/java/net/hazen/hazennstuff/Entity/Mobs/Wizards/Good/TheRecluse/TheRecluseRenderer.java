package net.hazen.hazennstuff.Entity.Mobs.Wizards.Good.TheRecluse;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMob;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMobRenderer;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.Good.Dryad.DryadModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;

public class TheRecluseRenderer extends AbstractSpellCastingMobRenderer {
    public TheRecluseRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TheRecluseModel());
    }
}