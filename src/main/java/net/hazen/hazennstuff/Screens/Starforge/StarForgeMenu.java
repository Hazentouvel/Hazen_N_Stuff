package net.hazen.hazennstuff.Screens.Starforge;

import net.hazen.hazennstuff.Item.Block.HnSBlocks;
import net.hazen.hazennstuff.Item.Block.Starforge.StarForgeBlockEntity;
import net.hazen.hazennstuff.Registries.HnSMenus;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.SlotItemHandler;

import static net.hazen.hazennstuff.Item.Block.Starforge.StarForgeBlockEntity.*;

public class StarForgeMenu extends AbstractContainerMenu {

    private static final int MAIN_1_X = 68, MAIN_1_Y = 36;
    private static final int MAIN_2_X = 92, MAIN_2_Y = 36;
    private static final int MAIN_3_X = 80, MAIN_3_Y = 58;
    private static final int FUEL_X = 27, FUEL_Y = 98;
    private static final int OUTPUT_X = 80, OUTPUT_Y = 98;
    private static final int ARTIFACT_X = 133, ARTIFACT_Y = 98;

    private static final int INV_X = 8, INV_Y = 140;
    private static final int HOTBAR_X = 8, HOTBAR_Y = 198;

    private static final int PLAYER_SLOT_COUNT = 36;
    private static final int FORGE_FIRST_SLOT = 36;

    public final StarForgeBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public StarForgeMenu(int containerId, Inventory inv, RegistryFriendlyByteBuf buf) {
        this(containerId, inv, inv.player.level().getBlockEntity(buf.readBlockPos()), new SimpleContainerData(4));
    }

    public StarForgeMenu(int containerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(HnSMenus.STARFORGE.get(), containerId);
        this.blockEntity = (StarForgeBlockEntity) entity;
        this.level = inv.player.level();
        this.data = data;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        var handler = this.blockEntity.getItems();
        addSlot(new SlotItemHandler(handler, SLOT_MAIN_1, MAIN_1_X, MAIN_1_Y));
        addSlot(new SlotItemHandler(handler, SLOT_MAIN_2, MAIN_2_X, MAIN_2_Y));
        addSlot(new SlotItemHandler(handler, SLOT_MAIN_3, MAIN_3_X, MAIN_3_Y));
        addSlot(new SlotItemHandler(handler, SLOT_FUEL, FUEL_X, FUEL_Y));
        addSlot(new SlotItemHandler(handler, SLOT_ARTIFACT, ARTIFACT_X, ARTIFACT_Y));
        addSlot(new SlotItemHandler(handler, SLOT_OUTPUT, OUTPUT_X, OUTPUT_Y) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }
        });

        addDataSlots(data);
    }

    private void addPlayerInventory(Inventory inv) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                addSlot(new Slot(inv, col + row * 9 + 9, INV_X + col * 18, INV_Y + row * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory inv) {
        for (int col = 0; col < 9; col++) {
            addSlot(new Slot(inv, col, HOTBAR_X + col * 18, HOTBAR_Y));
        }
    }

    public int getProgress() {
        return data.get(0);
    }

    public int getMaxProgress() {
        return Math.max(1, data.get(1));
    }

    public float getProgressFraction() {
        return Math.min(1f, (float) getProgress() / getMaxProgress());
    }

    public float getFuelFraction() {
        int duration = data.get(3);
        if (duration <= 0) return 0f;
        return Math.min(1f, (float) data.get(2) / duration);
    }

    public boolean isBurning() {
        return data.get(2) > 0;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot source = this.slots.get(index);
        if (!source.hasItem()) return ItemStack.EMPTY;

        ItemStack stack = source.getItem();
        ItemStack original = stack.copy();

        if (index < PLAYER_SLOT_COUNT) {
            if (!moveIntoForge(stack)) return ItemStack.EMPTY;
        } else {
            if (!moveItemStackTo(stack, 0, PLAYER_SLOT_COUNT, true)) return ItemStack.EMPTY;
        }

        if (stack.isEmpty()) {
            source.setByPlayer(ItemStack.EMPTY);
        } else {
            source.setChanged();
        }
        source.onTake(player, stack);
        return original;
    }

    private boolean moveIntoForge(ItemStack stack) {
        if (stack.is(ARTIFACTS)) {
            return moveItemStackTo(stack, FORGE_FIRST_SLOT + SLOT_ARTIFACT, FORGE_FIRST_SLOT + SLOT_ARTIFACT + 1, false);
        }
        if (StarForgeBlockEntity.isFuel(stack)) {
            if (moveItemStackTo(stack, FORGE_FIRST_SLOT + SLOT_FUEL, FORGE_FIRST_SLOT + SLOT_FUEL + 1, false)) {
                return true;
            }
        }
        return moveItemStackTo(stack, FORGE_FIRST_SLOT + SLOT_MAIN_1, FORGE_FIRST_SLOT + SLOT_MAIN_3 + 1, false);
    }

    @Override
    public boolean stillValid(Player player) {
        BlockPos pos = blockEntity.getBlockPos();
        return stillValid(ContainerLevelAccess.create(level, pos), player, HnSBlocks.STARFORGE.get());
    }
}
