package net.hazen.hazennstuff.Entity.Spells.Radiance.CrystalineMirror;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CrystalineMirrorModel extends GeoModel<CrystalineMirror> {

    @Override
    public ResourceLocation getModelResource(CrystalineMirror animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/crystaline_mirror.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CrystalineMirror animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/crystaline_mirror.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CrystalineMirror animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/syringe.animation.json");
    }
}