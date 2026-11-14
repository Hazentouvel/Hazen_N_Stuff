package net.hazen.hazennstuff.Item.Block.RadiantAltar;

import net.hazen.hazennstuff.Item.Block.HnSBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class RadiantAltarPartBlock extends Block {

    public static final IntegerProperty OX = IntegerProperty.create("ox", 0, 2);
    public static final IntegerProperty OY = IntegerProperty.create("oy", 0, RadiantAltarShapes.HEIGHT - 1);
    public static final IntegerProperty OZ = IntegerProperty.create("oz", 0, 2);

    public RadiantAltarPartBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(OX, 0).setValue(OY, 0).setValue(OZ, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(OX, OY, OZ);
    }

    public static BlockPos corePos(BlockPos pos, BlockState state) {
        return RadiantAltarShapes.coreFromPart(pos, state.getValue(OX), state.getValue(OY), state.getValue(OZ));
    }

    private static boolean isCore(Level level, BlockPos core) {
        return level.getBlockState(core).is(HnSBlocks.RADIANT_ALTAR.get());
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return RadiantAltarShapes.shape(state.getValue(OX), state.getValue(OY), state.getValue(OZ));
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }

    @Override
    protected float getShadeBrightness(BlockState state, BlockGetter level, BlockPos pos) {
        return 1.0f;
    }

    @Override
    protected boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos) {
        return true;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                               Player player, BlockHitResult hit) {
        BlockPos core = corePos(pos, state);
        BlockState coreState = level.getBlockState(core);
        if (!coreState.is(HnSBlocks.RADIANT_ALTAR.get())) return InteractionResult.PASS;
        return coreState.useWithoutItem(level, player, hit.withPosition(core));
    }

    @Override
    protected float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        return original(state).getDestroyProgress(player, level, pos);
    }

    private static BlockState original(BlockState state) {
        return RadiantAltarStructure.originalState(state.getValue(OX), state.getValue(OY), state.getValue(OZ));
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide) {
            RadiantAltarStructure.disassemble(level, corePos(pos, state), pos);
            RadiantAltarStructure.dropOriginal(level, pos, state.getValue(OX), state.getValue(OY), state.getValue(OZ), player);
        }
        return super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if (!state.is(newState.getBlock()) && !level.isClientSide && isCore(level, corePos(pos, state))) {
            RadiantAltarStructure.disassemble(level, corePos(pos, state), pos);
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
        BlockState original = original(state);
        return original.isAir() ? ItemStack.EMPTY : new ItemStack(original.getBlock());
    }
}