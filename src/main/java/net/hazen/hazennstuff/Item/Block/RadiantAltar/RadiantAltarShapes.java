package net.hazen.hazennstuff.Item.Block.RadiantAltar;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Geometry of the 3x2x3 altar.
 */
public final class RadiantAltarShapes {

    public static final int HEIGHT = 2;

    // Model cubes in pixels, relative to the core block's corner (model x/z + 8)
    private static final List<double[]> MODEL_BOXES = new ArrayList<>();

    static {
        // platform
        box(-22, 0, -22, 22, 2, 22);
        box(-16, 2, -16, 16, 5, 16);
        box(-12, 5, -12, 12, 8, 12);
        // pedestal / table
        box(-8, 8, -8, 8, 12, 8);
        box(-5, 12, -5, 5, 17, 5);
        box(-10, 17, -10, 10, 19, 10);
        box(-7, 19, -7, 7, 22, 7);
        // the four pillars
        for (int sx : new int[]{-1, 1}) {
            for (int sz : new int[]{-1, 1}) {
                double bx0 = sx < 0 ? -24 : 8, bz0 = sz < 0 ? -24 : 8;
                double sx0 = sx < 0 ? -21 : 11, sz0 = sz < 0 ? -21 : 11;
                box(bx0, 0, bz0, bx0 + 16, 12, bz0 + 16);
                box(sx0, 12, sz0, sx0 + 10, 26, sz0 + 10);
                box(bx0, 26, bz0, bx0 + 16, 32, bz0 + 16);
            }
        }
    }

    private static void box(double x0, double y0, double z0, double x1, double y1, double z1) {
        MODEL_BOXES.add(new double[]{x0 + 8, y0, z0 + 8, x1 + 8, y1, z1 + 8});
    }

    // Indexed [x][y][z] with x,z in 0..2 (1 = centre column) and y in 0..1 (0 = bottom)
    private static final VoxelShape[][][] SHAPES = new VoxelShape[3][HEIGHT][3];

    static {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                for (int z = 0; z < 3; z++) {
                    SHAPES[x][y][z] = build((x - 1) * 16, y * 16, (z - 1) * 16);
                }
            }
        }
    }

    private static VoxelShape build(int ox, int oy, int oz) {
        VoxelShape shape = Shapes.empty();
        for (double[] b : MODEL_BOXES) {
            double x0 = Math.max(0, b[0] - ox), y0 = Math.max(0, b[1] - oy), z0 = Math.max(0, b[2] - oz);
            double x1 = Math.min(16, b[3] - ox), y1 = Math.min(16, b[4] - oy), z1 = Math.min(16, b[5] - oz);
            if (x1 > x0 && y1 > y0 && z1 > z0) {
                shape = Shapes.or(shape, Block.box(x0, y0, z0, x1, y1, z1));
            }
        }
        return shape.optimize();
    }

    public static VoxelShape shape(int x, int y, int z) {
        return SHAPES[x][y][z];
    }

    public static boolean isCore(int x, int y, int z) {
        return x == 1 && y == 0 && z == 1;
    }

    public static void forEachPart(BlockPos core, PartVisitor visitor) {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                for (int z = 0; z < 3; z++) {
                    if (isCore(x, y, z)) continue;
                    visitor.visit(x, y, z, core.offset(x - 1, y, z - 1));
                }
            }
        }
    }

    public static void forEachPartPos(BlockPos core, Consumer<BlockPos> consumer) {
        forEachPart(core, (x, y, z, pos) -> consumer.accept(pos));
    }

    public static BlockPos coreFromPart(BlockPos part, int x, int y, int z) {
        return part.offset(1 - x, -y, 1 - z);
    }

    @FunctionalInterface
    public interface PartVisitor {
        void visit(int x, int y, int z, BlockPos pos);
    }
}
