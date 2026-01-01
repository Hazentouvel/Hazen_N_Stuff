package net.hazen.hazennstuff.Item.Block;

import net.hazen.hazennstuff.Item.Block.Statues.HazelStatue.HazelStatueBlockEntity;
import net.hazen.hazennstuff.HazenNStuff;
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

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
