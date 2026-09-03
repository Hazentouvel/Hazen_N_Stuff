package net.hazen.hazennstuff.Item.Block.Statues.HazelStatue.Pose3;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

public class HazelStatueModelPose2 extends DefaultedBlockGeoModel<HazelStatueBlockEntityPose2> {
    public HazelStatueModelPose2() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(HazelStatueBlockEntityPose2 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/block/statue/hazel_statue_pose_2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HazelStatueBlockEntityPose2 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/block/statue/hazel_statue_w_ravens_bane.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HazelStatueBlockEntityPose2 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/block/hazel_statue.animation.json");
    }
}
