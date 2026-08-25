package net.hazen.hazennstuff.Item.Block.Statues.HazelStatue.Pose1.Item;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class HazelStatueItemModel extends DefaultedItemGeoModel<HazelStatueItem> {
    public HazelStatueItemModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(HazelStatueItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/block/statue/hazel_statue.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HazelStatueItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/block/statue/hazel_statue.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HazelStatueItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/block/hazel_statue.animation.json");
    }
}
