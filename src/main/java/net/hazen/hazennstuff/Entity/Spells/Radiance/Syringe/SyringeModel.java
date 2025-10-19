package net.hazen.hazennstuff.Entity.Spells.Radiance.Syringe;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SyringeModel extends GeoModel<Syringe> {

    @Override
    public ResourceLocation getModelResource(Syringe animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/syringe.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Syringe animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/syringe_alt.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Syringe animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/syringe.animation.json");
    }
}
