package net.hazen.hazennstuff.Entity.Spells.Blood.BoneBolt;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BoneBoltModel extends GeoModel<BoneBolt> {

    @Override
    public ResourceLocation getModelResource(BoneBolt animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/bone.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BoneBolt animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/bone.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BoneBolt animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/spectral_axe.animation.json");
    }
}
