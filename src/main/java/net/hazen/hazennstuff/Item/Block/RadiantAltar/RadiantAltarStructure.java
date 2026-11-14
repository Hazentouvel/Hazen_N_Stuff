package net.hazen.hazennstuff.Item.Block.RadiantAltar;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Item.Block.HnSBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import javax.annotation.Nullable;

/**
 * The Radiant Altar is built in the world
 */
@EventBusSubscriber(modid = HazenNStuff.MOD_ID)
public final class RadiantAltarStructure {

    public static final boolean CONSUME_SOULSHARD = true;

    @Nullable
    public static Block expectedBlock(int x, int y, int z) {
        boolean corner = x != 1 && z != 1;
        boolean centre = x == 1 && z == 1;

        if (corner) return Blocks.QUARTZ_PILLAR;
        if (y == 0) return centre ? HnSBlocks.MITHRIL_BLOCK.get() : Blocks.DIAMOND_BLOCK;
        if (centre) return HnSBlocks.ZENALITE_BLOCK.get();
        return null;
    }

    public static BlockState originalState(int x, int y, int z) {
        Block block = expectedBlock(x, y, z);
        return block == null ? Blocks.AIR.defaultBlockState() : block.defaultBlockState();
    }

    private static boolean cellMatches(Level level, BlockPos pos, int x, int y, int z) {
        BlockState state = level.getBlockState(pos);
        Block expected = expectedBlock(x, y, z);
        if (expected == null) return state.canBeReplaced(); // air, grass, snow layers...
        return state.is(expected);
    }

    public static boolean matches(Level level, BlockPos core) {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < RadiantAltarShapes.HEIGHT; y++) {
                for (int z = 0; z < 3; z++) {
                    if (!cellMatches(level, core.offset(x - 1, y, z - 1), x, y, z)) return false;
                }
            }
        }
        return true;
    }

    public static void form(Level level, BlockPos core) {
        RadiantAltarShapes.forEachPart(core, (x, y, z, pos) -> level.setBlock(pos,
                HnSBlocks.RADIANT_ALTAR_PART.get().defaultBlockState()
                        .setValue(RadiantAltarPartBlock.OX, x)
                        .setValue(RadiantAltarPartBlock.OY, y)
                        .setValue(RadiantAltarPartBlock.OZ, z),
                Block.UPDATE_ALL));
        level.setBlock(core, HnSBlocks.RADIANT_ALTAR.get().defaultBlockState(), Block.UPDATE_ALL);

        level.playSound(null, core, SoundEvents.BEACON_ACTIVATE, SoundSource.BLOCKS, 1.0f, 1.4f);
        level.playSound(null, core, SoundEvents.AMETHYST_BLOCK_RESONATE, SoundSource.BLOCKS, 1.0f, 1.0f);
        if (level instanceof ServerLevel server) {
            server.sendParticles(ParticleTypes.END_ROD, core.getX() + 0.5, core.getY() + 1.0, core.getZ() + 0.5,
                    60, 1.0, 0.7, 1.0, 0.05);
        }
    }

    public static void disassemble(Level level, BlockPos core, @Nullable BlockPos skip) {
        if (!(level.getBlockEntity(core) instanceof RadiantAltarBlockEntity be) || be.isDisassembling()) return;
        be.setDisassembling(true);
        be.dropContents();

        // Parts first, core last: the core owns the block entity the parts check.
        RadiantAltarShapes.forEachPart(core, (x, y, z, pos) -> {
            if (pos.equals(skip)) return;
            BlockState state = level.getBlockState(pos);
            if (state.is(HnSBlocks.RADIANT_ALTAR_PART.get())
                    && state.getValue(RadiantAltarPartBlock.OX) == x
                    && state.getValue(RadiantAltarPartBlock.OY) == y
                    && state.getValue(RadiantAltarPartBlock.OZ) == z) {
                level.setBlock(pos, originalState(x, y, z), Block.UPDATE_ALL);
            }
        });
        if (!core.equals(skip) && level.getBlockState(core).is(HnSBlocks.RADIANT_ALTAR.get())) {
            level.setBlock(core, originalState(1, 0, 1), Block.UPDATE_ALL);
        }
    }

    public static void dropOriginal(Level level, BlockPos pos, int x, int y, int z, Player player) {
        BlockState original = originalState(x, y, z);
        if (original.isAir() || player.isCreative() || !player.hasCorrectToolForDrops(original)) return;
        Block.dropResources(original, level, pos, null, player, player.getMainHandItem());
    }

    // Activation

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        ItemStack held = event.getItemStack();
        if (!held.is(ItemRegistry.DIVINE_SOULSHARD.get())) return;

        Level level = event.getLevel();
        BlockPos clicked = event.getPos();
        if (!level.getBlockState(clicked).is(HnSBlocks.ZENALITE_BLOCK.get())) return;

        BlockPos core = clicked.below();
        Player player = event.getEntity();

        // Handled here on both sides so the hand swings and nothing else uses the click.
        event.setCanceled(true);

        if (!matches(level, core)) {
            event.setCancellationResult(InteractionResult.FAIL);
            if (!level.isClientSide) {
                player.displayClientMessage(Component.translatable("message.hazennstuff.radiant_altar.incomplete")
                        .withStyle(ChatFormatting.RED), true);
            }
            return;
        }

        event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide));
        if (!level.isClientSide) {
            form(level, core);
            if (CONSUME_SOULSHARD && !player.getAbilities().instabuild) held.shrink(1);
        }
    }
}