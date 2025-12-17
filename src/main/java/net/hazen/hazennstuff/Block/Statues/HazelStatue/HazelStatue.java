package net.hazen.hazennstuff.Block.Statues.HazelStatue;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.WATERLOGGED;

public class HazelStatue extends HorizontalDirectionalBlock implements EntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_CORE = Block.box(4, 0, 4, 4, 64, 4);
    private static final VoxelShape SHAPE_BODY = Block.box(4, 0, 4, 4, 64, 4);
    private static final VoxelShape SHAPE_BOTTOM_WEST = Block.box(0, 0, 0, 16, 32, 16);
    private static final VoxelShape SHAPE_BOTTOM_EAST = Block.box(4, 0, 4, 4, 64, 4);
    private static final VoxelShape SHAPE_BOTTOM_SOUTH = Block.box(4, 0, 4, 4, 64, 4);
    private static final VoxelShape SHAPE_BOTTOM_NORTH = Block.box(4, 0, 4, 4, 64, 4);

    private static final VoxelShape SHAPE_NORTH = Shapes.or(
            SHAPE_CORE,
            SHAPE_BODY,
            SHAPE_BOTTOM_WEST,
            SHAPE_BOTTOM_EAST,
            SHAPE_BOTTOM_SOUTH,
            SHAPE_BOTTOM_NORTH
    );

    private static VoxelShape rotateBox(VoxelShape shape, Rotation rotation) {
        double x1, y1, z1, x2, y2, z2;
        List<AABB> boxes = shape.toAabbs();

        VoxelShape rotatedShape = Shapes.empty();

        for (AABB box : boxes) {
            x1 = box.minX;
            y1 = box.minY;
            z1 = box.minZ;
            x2 = box.maxX;
            y2 = box.maxY;
            z2 = box.maxZ;

            VoxelShape rotatedBox;
            switch (rotation) {
                case CLOCKWISE_90:
                    rotatedBox = Shapes.box(1 - z2, y1, x1, 1 - z1, y2, x2);
                    break;
                case CLOCKWISE_180:
                    rotatedBox = Shapes.box(1 - x2, y1, 1 - z2, 1 - x1, y2, 1 - z1);
                    break;
                case COUNTERCLOCKWISE_90:
                    rotatedBox = Shapes.box(z1, y1, 1 - x2, z2, y2, 1 - x1);
                    break;
                default:
                    rotatedBox = Shapes.box(x1, y1, z1, x2, y2, z2);
                    break;
            }

            rotatedShape = Shapes.or(rotatedShape, rotatedBox);
        }

        return rotatedShape;
    }

    public HazelStatue(Properties properties) {
        super(properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()
                .getOpposite())
                .setValue(WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
            case SOUTH:
                return rotateBox(SHAPE_NORTH, Rotation.CLOCKWISE_180);
            case EAST:
                return rotateBox(SHAPE_NORTH, Rotation.CLOCKWISE_90);
            case WEST:
                return rotateBox(SHAPE_NORTH, Rotation.COUNTERCLOCKWISE_90);
            default:
                return SHAPE_NORTH;
        }
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return null;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new HazelStatueBlockEntity(pos, state);
    }
}
