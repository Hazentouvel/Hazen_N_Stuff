package net.hazen.hazennstuff.Item.Block.Statues.HazelStatue.Pose4.Item;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class HazelStatueItemModelPose3 extends DefaultedItemGeoModel<HazelStatueItemPose3> {
    public HazelStatueItemModelPose3() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(HazelStatueItemPose3 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/block/statue/hazel_statue_pose_3.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HazelStatueItemPose3 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/block/statue/hazel_statue.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HazelStatueItemPose3 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/block/hazel_statue.animation.json");
    }
}
