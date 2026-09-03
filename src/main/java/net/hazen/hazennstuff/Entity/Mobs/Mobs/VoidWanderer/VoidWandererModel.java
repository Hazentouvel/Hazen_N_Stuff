package net.hazen.hazennstuff.Entity.Mobs.Mobs.VoidWanderer;

import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMob;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.TransformStack;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector2f;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;

public class VoidWandererModel extends GeoModel<VoidWanderer> {
    protected TransformStack transformStack = new TransformStack();

    @Override
    public ResourceLocation getTextureResource(VoidWanderer mob) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/mobs/void_wanderer.png");
    }

    @Override
    public ResourceLocation getModelResource(VoidWanderer animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/mobs/void_wanderer.geo.json");
    }

    @Override
    public ResourceLocation getAnimationResource(VoidWanderer animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/mobs/void_wanderer.animation.json");
    }

    public void setCustomAnimations(VoidWanderer entity, long instanceId, AnimationState<VoidWanderer> animationState) {
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
