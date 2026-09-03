package net.hazen.hazennstuff.Item.Block.Statues.HazelStatue.Pose2;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

public class HazelStatueModelPose1 extends DefaultedBlockGeoModel<HazelStatueBlockEntityPose1> {
    public HazelStatueModelPose1() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(HazelStatueBlockEntityPose1 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/block/statue/hazel_statue_pose_1.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HazelStatueBlockEntityPose1 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/block/statue/hazel_statue.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HazelStatueBlockEntityPose1 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/block/hazel_statue.animation.json");
    }
}
