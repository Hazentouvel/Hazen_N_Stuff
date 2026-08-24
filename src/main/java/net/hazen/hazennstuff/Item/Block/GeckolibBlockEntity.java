package net.hazen.hazennstuff.Item.Block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class GeckolibBlockEntity extends BlockEntity {
    public static BlockEntityType.BlockEntitySupplier<GeckolibBlockEntity> from(Supplier<BlockEntityType<GeckolibBlockEntity>> type) {
        return (pos, state) -> new GeckolibBlockEntity((BlockEntityType)type.get(), pos, state);
    }

    public GeckolibBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }
}
