package net.hazen.hazennstuff.Item.Block.Statues.HazelStatue.Pose2.Item;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class HazelStatueItemModelPose1 extends DefaultedItemGeoModel<HazelStatueItemPose1> {
    public HazelStatueItemModelPose1() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(HazelStatueItemPose1 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/block/statue/hazel_statue_pose_1.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HazelStatueItemPose1 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/block/statue/hazel_statue_w_ravens_bane.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HazelStatueItemPose1 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/block/hazel_statue.animation.json");
    }
}
