package net.hazen.hazennstuff.Block.Statues.HazelStatue;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

public class HazelStatueModel extends DefaultedBlockGeoModel<HazelStatueBlockEntity> {
    public HazelStatueModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(HazelStatueBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/block/statue/hazel_statue.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HazelStatueBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/block/statue/hazel_statue.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HazelStatueBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/block/hazel_statue.animation.json");
    }
}
