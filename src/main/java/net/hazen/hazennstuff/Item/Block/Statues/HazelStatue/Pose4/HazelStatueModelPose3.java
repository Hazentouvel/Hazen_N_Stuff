package net.hazen.hazennstuff.Item.Block.Statues.HazelStatue.Pose4;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

public class HazelStatueModelPose3 extends DefaultedBlockGeoModel<HazelStatueBlockEntityPose3> {
    public HazelStatueModelPose3() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(HazelStatueBlockEntityPose3 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/block/statue/hazel_statue_pose_3.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HazelStatueBlockEntityPose3 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/block/statue/hazel_statue.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HazelStatueBlockEntityPose3 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/block/hazel_statue.animation.json");
    }
}
