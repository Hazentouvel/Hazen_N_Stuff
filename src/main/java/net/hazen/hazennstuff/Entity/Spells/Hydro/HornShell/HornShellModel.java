package net.hazen.hazennstuff.Entity.Spells.Hydro.HornShell;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HornShellModel extends GeoModel<HornShell> {

    @Override
    public ResourceLocation getModelResource(HornShell animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/horn_shell.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HornShell animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/horn_shell.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HornShell animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/horn_shell.animation.json");
    }
}