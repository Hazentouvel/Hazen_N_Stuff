package net.hazen.hazennstuff.entity.spells.evocation.spectral_axe;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.entity.spells.radiance.syringe.Syringe;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpectralAxeModel extends GeoModel<SpectralAxe> {

    @Override
    public ResourceLocation getModelResource(SpectralAxe animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/spectral_axe.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SpectralAxe animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/spectral_axe.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SpectralAxe animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/spectral_axe.animation.json");
    }
}
