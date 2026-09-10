package net.hazen.hazennstuff.Entity.Spells.Lightning.CoruscatedDischarge;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CoruscatedDischargeModel extends GeoModel<CoruscatedDischarge> {

    @Override
    public ResourceLocation getModelResource(CoruscatedDischarge animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/coruscated_discharge.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CoruscatedDischarge animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/coruscated_discharge_ballas.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CoruscatedDischarge animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/spark.animation.json");
    }
}