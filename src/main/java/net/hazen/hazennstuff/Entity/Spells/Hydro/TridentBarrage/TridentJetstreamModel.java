package net.hazen.hazennstuff.Entity.Spells.Hydro.TridentBarrage;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TridentJetstreamModel extends GeoModel<TridentJetstream> {

    @Override
    public ResourceLocation getModelResource(TridentJetstream animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/trident_jetstream.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TridentJetstream animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/trident_jetstream.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TridentJetstream animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/trident_jetstream.animation.json");
    }
}