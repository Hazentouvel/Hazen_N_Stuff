package net.hazen.hazennstuff.Screens.RadiantAltar;

import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.hazen.hazennstuff.Item.Block.HnSBlocks;
import net.hazen.hazennstuff.Item.Block.RadiantAltar.RadiantAltarBlockEntity;
import net.hazen.hazennstuff.Item.Block.RadiantAltar.RadiantAltarRecipe;
import net.hazen.hazennstuff.Registries.HnSMenus;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.SlotItemHandler;

import java.util.List;

import static net.hazen.hazennstuff.Item.Block.RadiantAltar.RadiantAltarBlockEntity.SLOT_MAIN;
import static net.hazen.hazennstuff.Item.Block.RadiantAltar.RadiantAltarBlockEntity.SLOT_SECONDARY;

public class RadiantAltarMenu extends AbstractContainerMenu {

    public static final int MAIN_X = 26, MAIN_Y = 18;
    public static final int SECONDARY_X = 26, SECONDARY_Y = 108;
    private static final int INV_X = 72, INV_Y = 161;
    private static final int HOTBAR_Y = 219;

    private static final int PLAYER_SLOT_COUNT = 36;
    private static final int ALTAR_FIRST_SLOT = 36;

    public final RadiantAltarBlockEntity blockEntity;
    private final Player player;
    private final Level level;
    private final ContainerData data;
    private final DataSlot mana;

    public RadiantAltarMenu(int containerId, Inventory inv, RegistryFriendlyByteBuf buf) {
        this(containerId, inv, inv.player.level().getBlockEntity(buf.readBlockPos()), new SimpleContainerData(3));
    }

    public RadiantAltarMenu(int containerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(HnSMenus.RADIANT_ALTAR.get(), containerId);
        this.blockEntity = (RadiantAltarBlockEntity) entity;
        this.player = inv.player;
        this.level = inv.player.level();
        this.data = data;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        var handler = blockEntity.getItems();
        addSlot(new SlotItemHandler(handler, SLOT_MAIN, MAIN_X, MAIN_Y));
        addSlot(new SlotItemHandler(handler, SLOT_SECONDARY, SECONDARY_X, SECONDARY_Y));

        addDataSlots(data);

        // Data slots travel as shorts, hence the clamp.
        this.mana = level.isClientSide
                ? DataSlot.standalone()
                : new DataSlot() {
            @Override
            public int get() {
                return Mth.clamp(Mth.floor(MagicData.getPlayerMagicData(player).getMana()), 0, Short.MAX_VALUE);
            }

            @Override
            public void set(int value) {
            }
        };
        addDataSlot(mana);
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
            addSlot(new Slot(inv, col, INV_X + col * 18, HOTBAR_Y));
        }
    }

    // Accessors for the screen

    public Player getPlayer() {
        return player;
    }

    public boolean isCrafting() {
        return data.get(2) != 0;
    }

    public float getProgressFraction() {
        int max = Math.max(1, data.get(1));
        return Mth.clamp((float) data.get(0) / max, 0f, 1f);
    }

    public int getMana() {
        return mana.get();
    }

    public int getMaxMana() {
        return Mth.floor(player.getAttributeValue(AttributeRegistry.MAX_MANA));
    }

    public ItemStack getMainItem() {
        return blockEntity.getItems().getStackInSlot(SLOT_MAIN);
    }

    public ItemStack getSecondaryItem() {
        return blockEntity.getItems().getStackInSlot(SLOT_SECONDARY);
    }

    @Override
    public boolean clickMenuButton(Player player, int id) {
        if (!(player instanceof ServerPlayer serverPlayer)) return false;
        List<RecipeHolder<RadiantAltarRecipe>> recipes = RadiantAltarRecipe.recipesFor(level, getMainItem());
        if (id < 0 || id >= recipes.size()) return false;
        boolean started = blockEntity.tryStartCraft(serverPlayer, recipes.get(id));
        if (started) broadcastChanges();
        return started;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot source = this.slots.get(index);
        if (!source.hasItem()) return ItemStack.EMPTY;

        ItemStack stack = source.getItem();
        ItemStack original = stack.copy();

        if (index < PLAYER_SLOT_COUNT) {
            // Main slot first (it holds a single item), anything else goes to the secondary slot.
            if (!moveItemStackTo(stack, ALTAR_FIRST_SLOT + SLOT_MAIN, ALTAR_FIRST_SLOT + SLOT_MAIN + 1, false)
                    && !moveItemStackTo(stack, ALTAR_FIRST_SLOT + SLOT_SECONDARY, ALTAR_FIRST_SLOT + SLOT_SECONDARY + 1, false)) {
                return ItemStack.EMPTY;
            }
        } else if (!moveItemStackTo(stack, 0, PLAYER_SLOT_COUNT, true)) {
            return ItemStack.EMPTY;
        }

        if (stack.isEmpty()) {
            source.setByPlayer(ItemStack.EMPTY);
        } else {
            source.setChanged();
        }
        source.onTake(player, stack);
        return original;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), player, HnSBlocks.RADIANT_ALTAR.get());
    }
}
