package net.hazen.hazennstuff.Item.Block.Starforge;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

public class StarForgeBlockModel extends DefaultedBlockGeoModel<StarForgeBlockEntity> {
    public StarForgeBlockModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(StarForgeBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/block/starforge.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(StarForgeBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/block/starforge.png");
    }

    @Override
    public ResourceLocation getAnimationResource(StarForgeBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/block/starforge.animation.json");
    }
}
