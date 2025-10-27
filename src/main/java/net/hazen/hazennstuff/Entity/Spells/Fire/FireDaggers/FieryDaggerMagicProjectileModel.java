package net.hazen.hazennstuff.Entity.Spells.Fire.FireDaggers;

import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMob;
import io.redspace.ironsspellbooks.render.RenderHelper.CustomerRenderType;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.GeoModel;

// Copied the Fiery Dagger since I don't know how to make it scale off of Fire Spell Power for the spell.
public class FieryDaggerMagicProjectileModel extends GeoModel<FieryDaggerMagicProjectile> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "textures/entity/fiery_dagger.png");
    public static final ResourceLocation MODEL = ResourceLocation.fromNamespaceAndPath("irons_spellbooks", "geo/fiery_dagger.geo.json");

    public FieryDaggerMagicProjectileModel() {
    }

    public ResourceLocation getModelResource(FieryDaggerMagicProjectile animatable) {
        return MODEL;
    }

    public ResourceLocation getTextureResource(FieryDaggerMagicProjectile animatable) {
        return TEXTURE;
    }

    public ResourceLocation getAnimationResource(FieryDaggerMagicProjectile animatable) {
        return AbstractSpellCastingMob.animationInstantCast;
    }

    public @Nullable RenderType getRenderType(FieryDaggerMagicProjectile animatable, ResourceLocation texture) {
        return CustomerRenderType.magic(TEXTURE);
    }
}
