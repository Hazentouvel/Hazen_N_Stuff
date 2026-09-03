package net.hazen.hazennstuff.Item.Block;

import net.hazen.hazennstuff.Item.Block.Starforge.StarForgeBlockEntity;
import net.hazen.hazennstuff.Item.Block.Statues.HazelStatue.Pose1.HazelStatueBlockEntity;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Item.Block.Statues.HazelStatue.Pose2.HazelStatueBlockEntityPose1;
import net.hazen.hazennstuff.Item.Block.Statues.HazelStatue.Pose3.HazelStatueBlockEntityPose2;
import net.hazen.hazennstuff.Item.Block.Statues.HazelStatue.Pose4.HazelStatueBlockEntityPose3;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class HnSBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, HazenNStuff.MOD_ID);

    public static final Supplier<BlockEntityType<HazelStatueBlockEntity>> HAZEL_STATUE =
            BLOCK_ENTITIES.register("hazel_statue", () -> BlockEntityType.Builder.of(
                    HazelStatueBlockEntity::new, HnSBlocks.HAZEL_STATUE.get()).build(null));

    public static final Supplier<BlockEntityType<HazelStatueBlockEntityPose1>> HAZEL_STATUE_POSE_1 =
            BLOCK_ENTITIES.register("hazel_statue_pose_1", () -> BlockEntityType.Builder.of(
                    HazelStatueBlockEntityPose1::new, HnSBlocks.HAZEL_STATUE_POSE_1.get()).build(null));

    public static final Supplier<BlockEntityType<HazelStatueBlockEntityPose2>> HAZEL_STATUE_POSE_2 =
            BLOCK_ENTITIES.register("hazel_statue_pose_2", () -> BlockEntityType.Builder.of(
                    HazelStatueBlockEntityPose2::new, HnSBlocks.HAZEL_STATUE_POSE_2.get()).build(null));

    public static final Supplier<BlockEntityType<HazelStatueBlockEntityPose3>> HAZEL_STATUE_POSE_3 =
            BLOCK_ENTITIES.register("hazel_statue_pose_3", () -> BlockEntityType.Builder.of(
                    HazelStatueBlockEntityPose3::new, HnSBlocks.HAZEL_STATUE_POSE_3.get()).build(null));

    public static final Supplier<BlockEntityType<StarForgeBlockEntity>> STARFORGE =
            BLOCK_ENTITIES.register("starforge", () -> BlockEntityType.Builder.of(
                    StarForgeBlockEntity::new, HnSBlocks.STARFORGE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
