package net.hazen.hazennstuff.Item.Block.Starforge;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Item.Block.HnSBlockEntities;
import net.hazen.hazennstuff.Registries.HnSParticleRegistry;
import net.hazen.hazennstuff.Registries.HnSRecipes;
import net.hazen.hazennstuff.Screens.Starforge.StarForgeMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.items.ItemStackHandler;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class StarForgeBlockEntity extends BlockEntity implements GeoBlockEntity, MenuProvider {

    public static final int SLOT_MAIN_1 = 0;
    public static final int SLOT_MAIN_2 = 1;
    public static final int SLOT_MAIN_3 = 2;
    public static final int SLOT_FUEL = 3;
    public static final int SLOT_ARTIFACT = 4;
    public static final int SLOT_OUTPUT = 5;
    public static final int SLOT_COUNT = 6;

    /** One partial-fuel item is exactly a ninth of the tank, so nine of them fill it. */
    public static final int FUEL_PER_ITEM = 2700;
    public static final int MAX_FUEL = FUEL_PER_ITEM * 9;

    public static final TagKey<Item> ARTIFACTS = TagKey.create(Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "items/artifacts"));

    public static final TagKey<Item> POTENT_ARTIFACTS = TagKey.create(Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "items/potent_artifacts"));

    public static final TagKey<Item> EXPERIENCE_ARTIFACTS = TagKey.create(Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "items/experience_artifacts"));

    public static final TagKey<Item> NONCONSUMABLE_ARTIFACTS = TagKey.create(Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "items/nonconsumable_artifacts"));

    public static final TagKey<Item> FULL_RECHARGE_FUEL = TagKey.create(Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "items/full_recharge_fuel"));

    public static final TagKey<Item> PARTIAL_FUEL = TagKey.create(Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "items/partial_fuel"));

    public static boolean isFuel(ItemStack stack) {
        return stack.is(FULL_RECHARGE_FUEL) || stack.is(PARTIAL_FUEL);
    }

    public static final float STAR_HEIGHT = 2.5f;
    private static final float BEAM_TARGET_HEIGHT = 1.0f;
    private static final int STAR_RESPAWN = 20;

    /** 8 seconds of activation sound before the loop takes over. */
    private static final int ACTIVATE_TICKS = 40;
    private static final int LOOP_TICKS = 110;

    private int loopTimer = 0;

    private final ItemStackHandler items = new ItemStackHandler(SLOT_COUNT) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            sync();
        }

        @Override
        public boolean isItemValid(int slot, ItemStack stack) {
            return switch (slot) {
                case SLOT_FUEL -> isFuel(stack);
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

    /**
     * What the artifact in the artifact slot does to the running craft.
     *
     * @param speedMultiplier >1 smelts faster, <1 slower
     * @param fuelPerTick     fuel drained per tick of progress
     */
    public record ArtifactModifiers(float speedMultiplier, int fuelPerTick) {
        public static final ArtifactModifiers NONE = new ArtifactModifiers(1.0f, 1);
    }

    public ArtifactModifiers artifactModifiers() {
        ItemStack artifact = items.getStackInSlot(SLOT_ARTIFACT);
        if (artifact.isEmpty()) return ArtifactModifiers.NONE;
        if (artifact.is(POTENT_ARTIFACTS)) return new ArtifactModifiers(2.0f, 3);
        return ArtifactModifiers.NONE;
    }

    private boolean hasExperienceArtifact() {
        return items.getStackInSlot(SLOT_ARTIFACT).is(EXPERIENCE_ARTIFACTS);
    }

    private boolean hasNonConsumableArtifact() {
        return items.getStackInSlot(SLOT_ARTIFACT).is(NONCONSUMABLE_ARTIFACTS);
    }

    private int progress = 0;
    private int maxProgress = StarForgeRecipe.DEFAULT_SMELT_TIME;
    private int fuel = 0;
    private boolean crafting = false;

    private int craftingTicks = 0;
    private int starTimer = 0;
    private boolean clientTicked = false;

    /** Caches the last matching recipe so we're not scanning the whole list every tick. */
    private final RecipeManager.CachedCheck<StarForgeRecipe.Input, StarForgeRecipe> quickCheck =
            RecipeManager.createCheck(HnSRecipes.STARFORGE_TYPE.get());

    public final ContainerData data = new ContainerData() {
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> progress;
                case 1 -> maxProgress;
                case 2 -> fuel;
                case 3 -> MAX_FUEL;
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0 -> progress = value;
                case 1 -> maxProgress = value;
                case 2 -> fuel = value;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    };

    public boolean hasFuel() {
        return this.fuel > 0;
    }

    public int getFuel() {
        return this.fuel;
    }

    public boolean isCrafting() {
        return this.crafting;
    }

    public float getCraftingTicks(float partialTick) {
        return craftingTicks + (craftingTicks > 0 ? partialTick : 0f);
    }

    // Animations

    private static final RawAnimation IDLE_NO_ITEMS = RawAnimation.begin().thenLoop("idle_without_items");
    private static final RawAnimation IDLE_WITH_ITEMS = RawAnimation.begin().thenLoop("idle_with_items");
    private static final RawAnimation SMELTING = RawAnimation.begin().thenLoop("smelting");

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public StarForgeBlockEntity(BlockPos pos, BlockState blockState) {
        super(HnSBlockEntities.STARFORGE.get(), pos, blockState);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 5, this::animationController));
    }

    private PlayState animationController(AnimationState<StarForgeBlockEntity> state) {
        if (crafting) {
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
        // Two separate flags on purpose. saveDirty is cheap bookkeeping; itemsDirty triggers a block-update packet for the renderer.
        // Fuel and progress change every single tick, and firing sendBlockUpdated that often would flood the network -- the open GUI
        // already gets those numbers through the ContainerData.
        boolean saveDirty = false;
        boolean itemsDirty = false;

        if (be.tryRefuel()) {
            saveDirty = true;
            itemsDirty = true;
        }

        StarForgeRecipe.Input input = be.createRecipeInput();
        Optional<RecipeHolder<StarForgeRecipe>> match = input.isEmpty()
                ? Optional.empty()
                : be.quickCheck.getRecipeFor(input, level);

        boolean working = false;

        if (match.isPresent()) {
            StarForgeRecipe recipe = match.get().value();
            ItemStack result = recipe.assemble(input, level.registryAccess());

            if (be.canOutput(result)) {
                ArtifactModifiers mods = be.artifactModifiers();

                int target = Math.max(1, Math.round(recipe.smeltTime() / mods.speedMultiplier()));
                if (be.maxProgress != target) {
                    be.maxProgress = target;
                    saveDirty = true;
                }

                if (be.fuel > 0) {
                    working = true;
                    be.fuel = Math.max(0, be.fuel - mods.fuelPerTick());
                    be.progress++;
                    saveDirty = true;

                    if (be.progress >= be.maxProgress) {
                        be.craft(recipe, input, result);
                        be.progress = 0;
                        itemsDirty = true;
                    }
                }
            }
        }

        // No fuel, or nothing valid in the slots: unwind rather than snap to zero.
        if (!working && be.progress > 0) {
            be.progress = Math.max(0, be.progress - 2);
            saveDirty = true;
        }

        // One packet when a craft starts and one when it stops.
        if (be.crafting != working) {
            be.crafting = working;
            saveDirty = true;
            itemsDirty = true;
        }

        if (saveDirty) be.setChanged();
        if (itemsDirty) be.sync();
    }

    public static void clientTick(Level level, BlockPos pos, BlockState state, StarForgeBlockEntity be) {
        boolean firstTick = !be.clientTicked;
        be.clientTicked = true;

        if (be.crafting) {
            if (firstTick) {
                be.craftingTicks = ACTIVATE_TICKS;
                StarForgeSoundInstance.playLoop(be);
                be.loopTimer = LOOP_TICKS;
            } else {
                be.craftingTicks++;
                if (be.craftingTicks == 1) {
                    StarForgeSoundInstance.playActivate(be);
                } else if (be.craftingTicks == ACTIVATE_TICKS) {
                    StarForgeSoundInstance.playLoop(be);
                    be.loopTimer = LOOP_TICKS;
                } else if (be.craftingTicks > ACTIVATE_TICKS && --be.loopTimer <= 0) {
                    StarForgeSoundInstance.playLoop(be);
                    be.loopTimer = LOOP_TICKS;
                }
            }
        } else {
            be.craftingTicks = 0;
            be.loopTimer = 0;
        }

        if (!be.hasFuel()) {
            be.starTimer = 0;   // reappear immediately once refuelled
            return;
        }

        double cx = pos.getX() + 0.5;
        double cz = pos.getZ() + 0.5;

        if (be.starTimer <= 0) {
            level.addParticle(HnSParticleRegistry.STARFORGE_STAR.get(),
                    cx, pos.getY() + STAR_HEIGHT, cz, 0.0, 0.0, 0.0);
            be.starTimer = STAR_RESPAWN;
        }
        be.starTimer--;

        if (!be.crafting) return;

        RandomSource random = level.random;
        level.addParticle(ParticleTypes.ENCHANT,
                cx, pos.getY() + BEAM_TARGET_HEIGHT, cz,
                (random.nextDouble() - 0.5) * 0.9,
                STAR_HEIGHT - BEAM_TARGET_HEIGHT,
                (random.nextDouble() - 0.5) * 0.9);
    }

    public StarForgeRecipe.Input createRecipeInput() {
        return new StarForgeRecipe.Input(List.of(
                items.getStackInSlot(SLOT_MAIN_1),
                items.getStackInSlot(SLOT_MAIN_2),
                items.getStackInSlot(SLOT_MAIN_3)));
    }

    private boolean tryRefuel() {
        if (fuel >= MAX_FUEL) return false;

        ItemStack stack = items.getStackInSlot(SLOT_FUEL);
        if (stack.isEmpty()) return false;

        if (stack.is(FULL_RECHARGE_FUEL)) {
            fuel = MAX_FUEL;
        } else if (stack.is(PARTIAL_FUEL)) {
            if (fuel + FUEL_PER_ITEM > MAX_FUEL) return false;
            fuel += FUEL_PER_ITEM;
        } else {
            return false;
        }

        ItemStack remainder = stack.getCraftingRemainingItem();
        stack.shrink(1);
        if (stack.isEmpty() && !remainder.isEmpty()) {
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

    private void craft(StarForgeRecipe recipe, StarForgeRecipe.Input input, ItemStack result) {
        int[] assignment = recipe.findAssignment(input);
        if (assignment == null) return;
        boolean nonConsumable = hasNonConsumableArtifact();

        for (int i = 0; i < assignment.length; i++) {
            ItemStack stack = items.getStackInSlot(assignment[i]);
            int count = recipe.countFor(i);

            if (nonConsumable) {
                for (int j = 0; j < count; j++) {
                    if (level.random.nextFloat() >= 0.15f) stack.shrink(1);
                }
            } else {
                stack.shrink(count);
            }
        }

        ItemStack out = items.getStackInSlot(SLOT_OUTPUT);
        if (out.isEmpty()) {
            items.setStackInSlot(SLOT_OUTPUT, result.copy());
        } else {
            out.grow(result.getCount());
        }

        if (level instanceof ServerLevel serverLevel && hasExperienceArtifact() && recipe.experience() > 0.0f) {
            awardExperience(serverLevel, recipe.experience());
        }


        if (level != null) {
            level.playSound(null, worldPosition, SoundEvents.EXPERIENCE_ORB_PICKUP,
                    SoundSource.BLOCKS, 1.0f, 1.0f);
        }
    }

    private void awardExperience(ServerLevel level, float experience) {
        int xp = Math.round(experience);
        if (xp > 0) {
            ExperienceOrb.award(level, Vec3.atCenterOf(worldPosition), xp);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.put("Items", items.serializeNBT(registries));
        tag.putInt("Progress", progress);
        tag.putInt("MaxProgress", maxProgress);
        tag.putInt("Fuel", fuel);
        tag.putBoolean("Crafting", crafting);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if (tag.contains("Items")) items.deserializeNBT(registries, tag.getCompound("Items"));
        progress = tag.getInt("Progress");
        maxProgress = tag.contains("MaxProgress")
                ? tag.getInt("MaxProgress")
                : StarForgeRecipe.DEFAULT_SMELT_TIME;
        fuel = tag.getInt("Fuel");
        crafting = tag.getBoolean("Crafting");
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
