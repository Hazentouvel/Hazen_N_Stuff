package net.hazen.hazennstuff.Item.Block.Statues.HazelStatue.Pose2;

import net.hazen.hazennstuff.Item.Block.GeckolibBlockEntity;
import net.hazen.hazennstuff.Item.Block.HnSBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class HazelStatueBlockEntityPose1 extends GeckolibBlockEntity implements GeoBlockEntity {

    private static final RawAnimation DEPLOY_ANIM =
            RawAnimation.begin()
                    .then("deploy", Animation.LoopType.PLAY_ONCE)
                    .thenLoop("idle");

    private final AnimatableInstanceCache cache =
            GeckoLibUtil.createInstanceCache(this);

    public HazelStatueBlockEntityPose1(BlockPos pos, BlockState state) {
        super(HnSBlockEntities.HAZEL_STATUE_POSE_1.get(), pos, state);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(
                this,
                "controller",
                0,
                this::deployAnimController
        ));
    }

    private PlayState deployAnimController(AnimationState<HazelStatueBlockEntityPose1> state) {
        state.setAnimation(DEPLOY_ANIM);
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
