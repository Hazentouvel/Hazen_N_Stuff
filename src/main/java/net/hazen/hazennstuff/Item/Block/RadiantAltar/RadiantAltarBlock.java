package net.hazen.hazennstuff.Item.Block.RadiantAltar;

import com.mojang.serialization.MapCodec;
import net.hazen.hazennstuff.Item.Block.HnSBlockEntities;
import net.hazen.hazennstuff.Item.Block.HnSBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

/**
 * The bottom-centre block of the 3x3x3 Radiant Altar. The other 26 cells are invisible RadiantAltarPartBlocks.
 */
public class RadiantAltarBlock extends BaseEntityBlock {
    public static final MapCodec<RadiantAltarBlock> CODEC = simpleCodec(RadiantAltarBlock::new);

    public RadiantAltarBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    // Placement

    // Refuses placement unless the whole 3x3x3 space is free
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos core = context.getClickedPos();
        boolean[] blocked = {false};

        RadiantAltarShapes.forEachPart(core, (x, y, z, pos) -> {
            if (blocked[0]) return;
            if (level.isOutsideBuildHeight(pos)
                    || !level.getBlockState(pos).canBeReplaced(context)
                    || !level.isUnobstructed(partState(x, y, z), pos, CollisionContext.empty())) {
                blocked[0] = true;
            }
        });
        return blocked[0] ? null : this.defaultBlockState();
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(level, pos, state, placer, stack);
        if (level.isClientSide) return;
        RadiantAltarShapes.forEachPart(pos, (x, y, z, partPos) ->
                level.setBlock(partPos, partState(x, y, z), Block.UPDATE_ALL));
    }

    private static BlockState partState(int x, int y, int z) {
        return HnSBlocks.RADIANT_ALTAR_PART.get().defaultBlockState()
                .setValue(RadiantAltarPartBlock.OX, x)
                .setValue(RadiantAltarPartBlock.OY, y)
                .setValue(RadiantAltarPartBlock.OZ, z);
    }

    // Removal

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if (!state.is(newState.getBlock())) {
            if (level.getBlockEntity(pos) instanceof RadiantAltarBlockEntity be) {
                be.dropContents();
            }
            // Clear the rest of the structure. The parts see the core is gone and won't call back.
            RadiantAltarShapes.forEachPart(pos, (x, y, z, partPos) -> {
                BlockState partState = level.getBlockState(partPos);
                if (partState.is(HnSBlocks.RADIANT_ALTAR_PART.get())
                        && partState.getValue(RadiantAltarPartBlock.OX) == x
                        && partState.getValue(RadiantAltarPartBlock.OY) == y
                        && partState.getValue(RadiantAltarPartBlock.OZ) == z) {
                    level.setBlock(partPos, Blocks.AIR.defaultBlockState(),
                            Block.UPDATE_ALL | Block.UPDATE_SUPPRESS_DROPS);
                }
            });
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    // Behaviour

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return RadiantAltarShapes.shape(1, 0, 1);
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                               Player player, BlockHitResult hit) {
        if (!level.isClientSide && level.getBlockEntity(pos) instanceof RadiantAltarBlockEntity be) {
            player.openMenu(be, buf -> buf.writeBlockPos(pos));
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new RadiantAltarBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, HnSBlockEntities.RADIANT_ALTAR.get(),
                level.isClientSide
                        ? RadiantAltarBlockEntity::clientTick
                        : RadiantAltarBlockEntity::serverTick);
    }
}
