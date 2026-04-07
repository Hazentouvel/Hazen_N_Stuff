package net.hazen.hazennstuff.Entity.Spells.Blood.ViolentRegurgitation.FleshChunk.FleshMound;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FleshMoundModel extends GeoModel<FleshMound> {

    @Override
    public ResourceLocation getModelResource(FleshMound animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/flesh_mound.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FleshMound animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/flesh_mound.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FleshMound animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/flesh_mound.animation.json");
    }
}