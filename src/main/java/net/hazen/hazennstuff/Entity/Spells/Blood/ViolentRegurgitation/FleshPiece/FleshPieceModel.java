package net.hazen.hazennstuff.Entity.Spells.Blood.ViolentRegurgitation.FleshPiece;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FleshPieceModel extends GeoModel<FleshPiece> {

    @Override
    public ResourceLocation getModelResource(FleshPiece animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/flesh_piece.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FleshPiece animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/flesh_piece.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FleshPiece animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/flesh_piece.animation.json");
    }
}