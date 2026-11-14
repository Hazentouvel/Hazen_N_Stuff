package net.hazen.hazennstuff.Item.Block.RadiantAltar;

import io.redspace.ironsspellbooks.api.magic.MagicData;
import net.hazen.hazennstuff.Item.Block.GeckolibBlockEntity;
import net.hazen.hazennstuff.Item.Block.HnSBlockEntities;
import net.hazen.hazennstuff.Registries.HnSParticleRegistry;
import net.hazen.hazennstuff.Screens.RadiantAltar.RadiantAltarMenu;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.items.ItemStackHandler;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RadiantAltarBlockEntity extends GeckolibBlockEntity implements GeoBlockEntity, MenuProvider {

    public static final int SLOT_MAIN = 0;
    public static final int SLOT_SECONDARY = 1;
    public static final int SLOT_COUNT = 2;

    public static final float LOWER_RING_HEIGHT = 34.5f / 16f;
    public static final float UPPER_RING_HEIGHT = 42f / 16f;

    public static final float ITEM_HEIGHT = LOWER_RING_HEIGHT;

    public static final float ORBIT_RADIUS = 1.4f;

    public static final float ORBIT_HEIGHT = ITEM_HEIGHT + 0.1f;

    public static final float STAR_OFFSET_ABOVE_TOP_RING = 3.0f;

    public static final float STAR_HEIGHT = UPPER_RING_HEIGHT + STAR_OFFSET_ABOVE_TOP_RING;

    public enum BeamTarget {
        UPPER_RING(UPPER_RING_HEIGHT),
        LOWER_RING(LOWER_RING_HEIGHT),
        PEDESTAL(ITEM_HEIGHT);

        public final float height;

        BeamTarget(float height) {
            this.height = height;
        }
    }

    public static final BeamTarget BEAM_TARGET = BeamTarget.UPPER_RING;
    private static final int STAR_RESPAWN = 20;

    private final ItemStackHandler items = new ItemStackHandler(SLOT_COUNT) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            sync();
        }

        // Both slots are locked while the altar is working
        @Override
        public boolean isItemValid(int slot, ItemStack stack) {
            return !crafting;
        }

        @Override
        public ItemStack extractItem(int slot, int amount, boolean simulate) {
            return crafting ? ItemStack.EMPTY : super.extractItem(slot, amount, simulate);
        }

        @Override
        public int getSlotLimit(int slot) {
            return slot == SLOT_MAIN ? 1 : super.getSlotLimit(slot);
        }
    };

    private boolean crafting = false;
    private int progress = 0;
    private int maxProgress = RadiantAltarRecipe.DEFAULT_CRAFT_TIME;

    private ItemStack pendingResult = ItemStack.EMPTY;

    private List<ItemStack> orbitItems = new ArrayList<>();

    private boolean disassembling = false;

    // Client-only
    private int craftingTicks = 0;
    private int starTimer = 0;

    public final ContainerData data = new ContainerData() {
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> progress;
                case 1 -> maxProgress;
                case 2 -> crafting ? 1 : 0;
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0 -> progress = value;
                case 1 -> maxProgress = value;
                case 2 -> crafting = value != 0;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    };

    public boolean isDisassembling() {
        return disassembling;
    }

    public void setDisassembling(boolean disassembling) {
        this.disassembling = disassembling;
    }

    public RadiantAltarBlockEntity(BlockPos pos, BlockState state) {
        super(HnSBlockEntities.RADIANT_ALTAR.get(), pos, state);
    }

    public ItemStackHandler getItems() {
        return items;
    }

    @Nullable
    public ItemStackHandler getItemHandler(@Nullable Direction side) {
        return items;
    }

    public boolean isCrafting() {
        return crafting;
    }

    public List<ItemStack> getOrbitItems() {
        return Collections.unmodifiableList(orbitItems);
    }

    public float getCraftingTicks(float partialTick) {
        return craftingTicks + (craftingTicks > 0 ? partialTick : 0f);
    }

    // Animations

    private static final RawAnimation IDLE = RawAnimation.begin().thenLoop("idle");
    private static final RawAnimation SMELTING = RawAnimation.begin().thenLoop("smelting");

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 10, this::animationController));
    }

    private PlayState animationController(AnimationState<RadiantAltarBlockEntity> state) {
        state.setAndContinue(crafting ? SMELTING : IDLE);
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    // Menu

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.hazennstuff.radiant_altar");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new RadiantAltarMenu(containerId, inventory, this, this.data);
    }

    // Crafting

    public boolean tryStartCraft(ServerPlayer player, RecipeHolder<RadiantAltarRecipe> holder) {
        if (level == null) return false;
        RadiantAltarRecipe recipe = holder.value();
        ItemStack main = items.getStackInSlot(SLOT_MAIN);
        ItemStack secondary = items.getStackInSlot(SLOT_SECONDARY);

        RadiantAltarCrafting.Problem problem =
                RadiantAltarCrafting.check(recipe, player, main, secondary, crafting, 0);
        if (problem != RadiantAltarCrafting.Problem.NONE) {
            player.displayClientMessage(Component.translatable(RadiantAltarCrafting.translationKey(problem))
                    .withStyle(ChatFormatting.RED), true);
            return false;
        }

        pendingResult = recipe.assemble(new RadiantAltarRecipe.Input(main, secondary), level.registryAccess());
        orbitItems = new ArrayList<>(RadiantAltarCrafting.consumeMaterials(player.getInventory(), recipe.materials()));

        recipe.secondary().ifPresent(s -> secondary.shrink(s.count()));

        if (recipe.mana() > 0 && !player.getAbilities().instabuild) {
            MagicData magic = MagicData.getPlayerMagicData(player);
            magic.setMana(Math.max(0f, magic.getMana() - recipe.mana()));
        }

        progress = 0;
        maxProgress = recipe.craftTime();
        crafting = true;

        level.playSound(null, worldPosition, SoundEvents.BEACON_ACTIVATE, SoundSource.BLOCKS, 1.0f, 1.2f);
        setChanged();
        sync();
        return true;
    }

    private void finishCraft() {
        items.setStackInSlot(SLOT_MAIN, pendingResult.copy());
        pendingResult = ItemStack.EMPTY;
        orbitItems = new ArrayList<>();
        crafting = false;
        progress = 0;

        if (level instanceof ServerLevel serverLevel) {
            Vec3 c = Vec3.atBottomCenterOf(worldPosition).add(0, ITEM_HEIGHT, 0);
            serverLevel.sendParticles(ParticleTypes.END_ROD, c.x, c.y, c.z, 30, 0.2, 0.2, 0.2, 0.08);
            serverLevel.playSound(null, worldPosition, SoundEvents.BEACON_POWER_SELECT, SoundSource.BLOCKS, 1.0f, 1.0f);
            serverLevel.playSound(null, worldPosition, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 1.5f, 0.8f);
        }
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, RadiantAltarBlockEntity be) {
        if (!be.crafting) return;

        be.progress++;
        if (be.progress >= be.maxProgress) {
            be.finishCraft();
            be.setChanged();
            be.sync();
        } else {
            be.setChanged();
        }
    }

    public static void clientTick(Level level, BlockPos pos, BlockState state, RadiantAltarBlockEntity be) {
        if (!be.crafting) {
            be.craftingTicks = 0;
            be.starTimer = 0;
            return;
        }
        be.craftingTicks++;

        double cx = pos.getX() + 0.5;
        double cz = pos.getZ() + 0.5;

        if (be.starTimer <= 0) {
            level.addParticle(HnSParticleRegistry.RADIANT_ALTAR_STAR.get(),
                    cx, pos.getY() + STAR_HEIGHT, cz, 0.0, 0.0, 0.0);
            be.starTimer = STAR_RESPAWN;
        }
        be.starTimer--;

        // Enchant glyphs drift from the orbit ring into the main item.
        RandomSource random = level.random;
        if (random.nextInt(2) == 0) {
            float angle = random.nextFloat() * Mth.TWO_PI;
            double r = ORBIT_RADIUS;
            level.addParticle(ParticleTypes.ENCHANT,
                    cx, pos.getY() + ITEM_HEIGHT, cz,
                    Mth.cos(angle) * r, random.nextDouble() * 0.4, Mth.sin(angle) * r);
        }
    }

    // Persistence & sync

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.put("Items", items.serializeNBT(registries));
        tag.putBoolean("Crafting", crafting);
        tag.putInt("Progress", progress);
        tag.putInt("MaxProgress", maxProgress);
        if (!pendingResult.isEmpty()) tag.put("PendingResult", pendingResult.save(registries));

        ListTag orbit = new ListTag();
        for (ItemStack stack : orbitItems) {
            if (!stack.isEmpty()) orbit.add(stack.save(registries));
        }
        tag.put("OrbitItems", orbit);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if (tag.contains("Items")) items.deserializeNBT(registries, tag.getCompound("Items"));
        crafting = tag.getBoolean("Crafting");
        progress = tag.getInt("Progress");
        maxProgress = tag.contains("MaxProgress") ? tag.getInt("MaxProgress") : RadiantAltarRecipe.DEFAULT_CRAFT_TIME;
        pendingResult = tag.contains("PendingResult")
                ? ItemStack.parseOptional(registries, tag.getCompound("PendingResult"))
                : ItemStack.EMPTY;

        orbitItems = new ArrayList<>();
        ListTag orbit = tag.getList("OrbitItems", Tag.TAG_COMPOUND);
        for (int i = 0; i < orbit.size(); i++) {
            ItemStack stack = ItemStack.parseOptional(registries, orbit.getCompound(i));
            if (!stack.isEmpty()) orbitItems.add(stack);
        }

        // A craft with nothing to produce can't finish meaningfully; drop back to idle.
        if (crafting && pendingResult.isEmpty()) crafting = false;
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

    // Drops the slots, plus the consumed materials if the altar is broken mid-craft. The mana spent is not refunded
    public void dropContents() {
        if (level == null) return;
        List<ItemStack> drops = new ArrayList<>();
        for (int i = 0; i < items.getSlots(); i++) drops.add(items.getStackInSlot(i).copy());
        if (crafting) orbitItems.forEach(s -> drops.add(s.copy()));

        for (ItemStack stack : drops) {
            while (!stack.isEmpty()) {
                Block.popResource(level, worldPosition.above(RadiantAltarShapes.HEIGHT), stack.split(stack.getMaxStackSize()));
            }
        }
    }
}