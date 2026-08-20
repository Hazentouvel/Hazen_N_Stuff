package net.hazen.hazennstuff.Item.Block.Starforge;

import net.hazen.hazennstuff.Item.Block.HnSBlockEntities;
import net.hazen.hazennstuff.Screens.StarForgeMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;

public class StarForgeBlockEntity extends BlockEntity implements GeoBlockEntity, MenuProvider {

    public static final int SLOT_MAIN_1 = 0;
    public static final int SLOT_MAIN_2 = 1;
    public static final int SLOT_MAIN_3 = 2;
    public static final int SLOT_FUEL = 3;
    public static final int SLOT_ARTIFACT = 4;
    public static final int SLOT_OUTPUT = 5;
    public static final int SLOT_COUNT = 6;

    public static final TagKey<Item> ARTIFACTS = TagKey.create(Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath("hazennstuff", "items/artifacts"));

    private final ItemStackHandler items = new ItemStackHandler(SLOT_COUNT) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            sync();
        }

        @Override
        public boolean isItemValid(int slot, ItemStack stack) {
            return switch (slot) {
                case SLOT_FUEL -> stack.getBurnTime(null) > 0;
                case SLOT_ARTIFACT -> stack.is(ARTIFACTS);
                case SLOT_OUTPUT -> false;
                default -> true;
            };
        }

        @Override
        public int getSlotLimit(int slot) {
            return slot == SLOT_ARTIFACT ? 1 : super.getSlotLimit(slot);
        }
    };

    public ItemStackHandler getItems() {
        return this.items;
    }

    @Nullable
    public ItemStackHandler getItemHandler(@Nullable Direction side) {
        return this.items;
    }

    private int progress = 0;
    private int maxProgress = 200;
    private int burnTime = 0;
    private int burnDuration = 0;

    public final ContainerData data = new ContainerData() {
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> progress;
                case 1 -> maxProgress;
                case 2 -> burnTime;
                case 3 -> burnDuration;
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0 -> progress = value;
                case 1 -> maxProgress = value;
                case 2 -> burnTime = value;
                case 3 -> burnDuration = value;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    };

    public boolean isBurning() {
        return this.burnTime > 0;
    }

    private static final RawAnimation IDLE_NO_ITEMS =
            RawAnimation.begin()
                    .thenLoop("idle_without_items");

    private static final RawAnimation IDLE_WITH_ITEMS =
            RawAnimation.begin()
                    .thenLoop("idle_with_items");

    private static final RawAnimation SMELTING =
            RawAnimation.begin()
                    .thenLoop("smelting");

    private final AnimatableInstanceCache cache =
            GeckoLibUtil.createInstanceCache(this);

    public StarForgeBlockEntity(BlockPos pos, BlockState blockState) {
        super(HnSBlockEntities.STARFORGE.get(), pos, blockState);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(
                this,
                "controller",
                0,
                this::animationController
        ));
    }

    private PlayState animationController(AnimationState<StarForgeBlockEntity> state) {
        if (isBurning() && progress > 0) {
            state.setAndContinue(SMELTING);
        } else if (hasAnyMainItem()) {
            state.setAndContinue(IDLE_WITH_ITEMS);
        } else {
            state.setAndContinue(IDLE_NO_ITEMS);
        }
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    public boolean hasAnyMainItem() {
        for (int i = SLOT_MAIN_1; i <= SLOT_MAIN_3; i++) {
            if (!items.getStackInSlot(i).isEmpty()) return true;
        }
        return false;
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.hazennstuff.starforge");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new StarForgeMenu(containerId, inventory, this, this.data);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, StarForgeBlockEntity be) {
        boolean wasBurning = be.isBurning();
        boolean dirty = false;

        if (be.isBurning()) {
            be.burnTime--;
        }

        ItemStack result = be.assembleResult();
        boolean canWork = !result.isEmpty() && be.canOutput(result);

        if (canWork) {
            if (!be.isBurning()) {
                dirty |= be.consumeFuel();
            }

            if (be.isBurning()) {
                be.progress++;
                if (be.progress >= be.maxProgress) {
                    be.craft(result);
                    be.progress = 0;
                    dirty = true;
                }
            } else {
                be.progress = Math.max(0, be.progress - 2);
            }
        } else if (be.progress != 0) {
            be.progress = 0;
            dirty = true;
        }

        if (wasBurning != be.isBurning()) dirty = true;

        if (dirty) {
            be.setChanged();
            be.sync();
        }
    }

    private boolean consumeFuel() {
        ItemStack fuel = items.getStackInSlot(SLOT_FUEL);
        int burn = fuel.getBurnTime(null);
        if (burn <= 0) return false;

        this.burnTime = burn;
        this.burnDuration = burn;

        ItemStack remainder = fuel.getCraftingRemainingItem();
        fuel.shrink(1);
        if (fuel.isEmpty() && !remainder.isEmpty()) {
            items.setStackInSlot(SLOT_FUEL, remainder);
        }
        return true;
    }

    private boolean canOutput(ItemStack result) {
        ItemStack out = items.getStackInSlot(SLOT_OUTPUT);
        if (out.isEmpty()) return true;
        if (!ItemStack.isSameItemSameComponents(out, result)) return false;
        return out.getCount() + result.getCount() <= out.getMaxStackSize();
    }

    private void craft(ItemStack result) {
        for (int i = SLOT_MAIN_1; i <= SLOT_MAIN_3; i++) {
            ItemStack in = items.getStackInSlot(i);
            if (!in.isEmpty()) in.shrink(1);
        }

        ItemStack out = items.getStackInSlot(SLOT_OUTPUT);
        if (out.isEmpty()) {
            items.setStackInSlot(SLOT_OUTPUT, result.copy());
        } else {
            out.grow(result.getCount());
        }
    }

    private ItemStack assembleResult() {
        return ItemStack.EMPTY;
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.put("Items", items.serializeNBT(registries));
        tag.putInt("Progress", progress);
        tag.putInt("MaxProgress", maxProgress);
        tag.putInt("BurnTime", burnTime);
        tag.putInt("BurnDuration", burnDuration);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if (tag.contains("Items")) items.deserializeNBT(registries, tag.getCompound("Items"));
        progress = tag.getInt("Progress");
        maxProgress = tag.contains("MaxProgress") ? tag.getInt("MaxProgress") : 200;
        burnTime = tag.getInt("BurnTime");
        burnDuration = tag.getInt("BurnDuration");
    }

    public void sync() {
        if (level != null && !level.isClientSide) {
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), Block.UPDATE_ALL);
        }
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag tag = new CompoundTag();
        saveAdditional(tag, registries);
        return tag;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt, HolderLookup.Provider registries) {
        if (pkt.getTag() != null) {
            handleUpdateTag(pkt.getTag(), registries);
        }
    }

    public void dropContents() {
        if (level == null) return;
        SimpleContainer inv = new SimpleContainer(items.getSlots());
        for (int i = 0; i < items.getSlots(); i++) {
            inv.setItem(i, items.getStackInSlot(i));
        }
        Containers.dropContents(level, worldPosition, inv);
    }
}
