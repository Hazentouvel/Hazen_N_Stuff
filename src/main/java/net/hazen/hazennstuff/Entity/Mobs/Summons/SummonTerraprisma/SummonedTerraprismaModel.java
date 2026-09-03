package net.hazen.hazennstuff.Entity.Mobs.Summons.SummonTerraprisma;

import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.TransformStack;
import net.hazen.hazennstuff.Entity.Mobs.Mobs.VoidWanderer.VoidWanderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;

public class SummonedTerraprismaModel extends GeoModel<SummonedTerraprisma> {
    protected TransformStack transformStack = new TransformStack();
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/spells/terraprisma/terraprisma_0.png");
    public static final ResourceLocation MODEL = ResourceLocation.fromNamespaceAndPath("hazennstuff", "geo/entities/spells/terraprisma.geo.json");
    public static final ResourceLocation ANIMATIONS = ResourceLocation.fromNamespaceAndPath("hazennstuff", "animations/entities/spells/terraprisma.animation.json");

    public SummonedTerraprismaModel() {
    }

    public ResourceLocation getModelResource(SummonedTerraprisma animatable) {
        return MODEL;
    }

    public ResourceLocation getTextureResource(SummonedTerraprisma animatable) {
        return TEXTURE;
    }

    public ResourceLocation getAnimationResource(SummonedTerraprisma animatable) {
        return ANIMATIONS;
    }

    public void setCustomAnimations(SummonedTerraprisma entity, long instanceId, AnimationState<SummonedTerraprisma> animationState) {
        super.setCustomAnimations(entity, instanceId, animationState);
        if (entity.shouldBeExtraAnimated()) {
            float partialTick = animationState.getPartialTick();
            GeoBone head = this.getAnimationProcessor().getBone("head");
            if (!entity.isAnimating() || entity.shouldAlwaysAnimateHead()) {
                this.transformStack.pushRotation(head, Mth.lerp(partialTick, -entity.xRotO, -entity.getXRot()) * ((float)Math.PI / 180F), Mth.lerp(partialTick, Mth.wrapDegrees(-entity.yHeadRotO + entity.yBodyRotO) * ((float)Math.PI / 180F), Mth.wrapDegrees(-entity.yHeadRot + entity.yBodyRot) * ((float)Math.PI / 180F)), 0.0F);
            }

        }
    }
}
