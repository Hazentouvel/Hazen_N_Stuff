package net.hazen.hazennstuff.Entity.Mobs.Wizards.Good.TheRecluse;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.SchoolType;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.entity.mobs.IMagicSummon;
import io.redspace.ironsspellbooks.entity.mobs.SupportMob;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMob;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.NeutralWizard;
import io.redspace.ironsspellbooks.entity.mobs.goals.*;
import io.redspace.ironsspellbooks.entity.mobs.wizards.IMerchantWizard;
import io.redspace.ironsspellbooks.entity.mobs.wizards.priest.PriestEntity;
import io.redspace.ironsspellbooks.item.FurledMapItem;
import io.redspace.ironsspellbooks.item.InkItem;
import io.redspace.ironsspellbooks.loot.SpellFilter;
import io.redspace.ironsspellbooks.player.AdditionalWanderingTrades;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import io.redspace.ironsspellbooks.util.ModTags;
import net.hazen.hazennstuff.Datagen.HnSTags;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.AbstractNeutralSpellcastingEnderman;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.AbstractSpellCastingEnderman;
import net.hazen.hazennstuff.Registries.HnSItemRegistry;
import net.hazen.hazennstuff.Registries.HnSItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.npc.VillagerData;
import net.minecraft.world.entity.npc.VillagerDataHolder;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class TheRecluseEntity extends AbstractNeutralSpellcastingEnderman implements VillagerDataHolder, SupportMob, HomeOwner, IMerchantWizard {
    private static final EntityDataAccessor<VillagerData> DATA_VILLAGER_DATA = SynchedEntityData.defineId(TheRecluseEntity.class, EntityDataSerializers.VILLAGER_DATA);
    private static final EntityDataAccessor<Boolean> DATA_VILLAGER_UNHAPPY = SynchedEntityData.defineId(TheRecluseEntity.class, EntityDataSerializers.BOOLEAN);
    public GoalSelector supportTargetSelector;
    private int unhappyTimer;

    public TheRecluseEntity(EntityType<? extends AbstractSpellCastingMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        xpReward = 15;

    }

    boolean shouldLookForPoi;

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new AbstractNeutralSpellcastingEnderman.EndermanFreezeWhenLookedAt(this));
        this.goalSelector.addGoal(1, new SpellBarrageGoal(this, SpellRegistry.COUNTERSPELL_SPELL.get(), 3, 6, 100, 250, 1));
        this.goalSelector.addGoal(2, new WizardAttackGoal(this, 1.25f, 35, 70)
                .setSpells(
                        List.of(
                                SpellRegistry.MAGIC_MISSILE_SPELL.get(),
                                SpellRegistry.MAGIC_MISSILE_SPELL.get(),
                                SpellRegistry.MAGIC_MISSILE_SPELL.get(),
                                SpellRegistry.MAGIC_ARROW_SPELL.get()),
                        List.of(
                        ),
                        List.of(

                        ),
                        List.of(
                                SpellRegistry.ECHOING_STRIKES_SPELL.get()
                        ))
                .setSingleUseSpell(SpellRegistry.EVASION_SPELL.get(), 80, 400, 3, 4)
                .setSpellQuality(0.3f, 0.5f)
                .setDrinksPotions());
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, (double)1.0F, 0.0F));
        this.goalSelector.addGoal(7, new PatrolNearLocationGoal(this, 30, 1f));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(10, new WizardRecoverGoal(this));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isHostileTowards));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, (mob) -> mob instanceof Enemy && !(mob instanceof Endermite)));
        this.targetSelector.addGoal(5, new ResetUniversalAngerTargetGoal<>(this, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, true, (entity) -> !entity.getType().is(HnSTags.SPAWNS_OF_ENDER)));
        this.targetSelector.addGoal(3,
                new NearestAttackableTargetGoal<>(this, Mob.class, true,
                        entity -> entity.getType().is(HnSTags.ASTRAL_CONSTRUCT)
                ));

        this.supportTargetSelector = new GoalSelector(this.level().getProfilerSupplier());
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData) {
        RandomSource randomsource = Utils.random;
        this.populateDefaultEquipmentSlots(randomsource, pDifficulty);
        if (pReason == MobSpawnType.STRUCTURE) {
            this.shouldLookForPoi = true;
        }
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData);
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(HnSItemRegistry.ENDERMAN_BLINDFOLD.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(HnSItemRegistry.ENDERMAN_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(HnSItemRegistry.ENDERMAN_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(HnSItemRegistry.ENDERMAN_BOOTS.get()));
        this.setDropChance(EquipmentSlot.HEAD, 0.0F);
        this.setDropChance(EquipmentSlot.CHEST, 0.0F);
        this.setDropChance(EquipmentSlot.LEGS, 0.0F);
        this.setDropChance(EquipmentSlot.FEET, 0.0F);
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.ATTACK_DAMAGE, 3.0)
                .add(Attributes.ATTACK_KNOCKBACK, 0.0)
                .add(Attributes.MAX_HEALTH, 60.0)
                .add(Attributes.FOLLOW_RANGE, 24.0)
                .add(AttributeRegistry.CAST_TIME_REDUCTION, 1.5)
                .add(Attributes.MOVEMENT_SPEED, .23);
    }

    @Override
    protected PathNavigation createNavigation(Level pLevel) {
        return new GroundPathNavigation(this, pLevel) {
            @Override
            protected PathFinder createPathFinder(int pMaxVisitedNodes) {
                this.nodeEvaluator = new WalkNodeEvaluator();
                this.nodeEvaluator.setCanPassDoors(true);
                this.nodeEvaluator.setCanOpenDoors(true);
                return new PathFinder(this.nodeEvaluator, pMaxVisitedNodes);
            }
        };
    }

    @Override
    public boolean guardsBlocks() {
        return false;
    }

    @javax.annotation.Nullable
    protected SoundEvent getAmbientSound() {
        if (this.isSleeping()) {
            return null;
        } else {
            return this.isTrading() ? SoundEvents.ENDERMAN_AMBIENT : SoundEvents.ENDERMAN_AMBIENT;
        }
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENDERMAN_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.ENDERMAN_HURT;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(DATA_VILLAGER_DATA, new VillagerData(VillagerType.PLAINS, VillagerProfession.NONE, 1));
        pBuilder.define(DATA_VILLAGER_UNHAPPY, false);
    }

    public void setVillagerData(VillagerData villagerdata) {
        villagerdata.setProfession(VillagerProfession.NONE);
        this.entityData.set(DATA_VILLAGER_DATA, villagerdata);
    }

    public boolean isUnhappy() {
        return this.entityData.get(DATA_VILLAGER_UNHAPPY);
    }

    public @NotNull VillagerData getVillagerData() {
        return this.entityData.get(DATA_VILLAGER_DATA);
    }

    LivingEntity supportTarget;

    @Nullable
    @Override
    public LivingEntity getSupportTarget() {
        return supportTarget;
    }

    @Override
    public void setSupportTarget(LivingEntity target) {
        this.supportTarget = target;
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();
        if (shouldLookForPoi) {
            if (this.level() instanceof ServerLevel serverLevel) {
                Optional<BlockPos> optional1 = serverLevel.getPoiManager().find((poiTypeHolder) -> poiTypeHolder.is(PoiTypes.MEETING),
                        (blockPos) -> true, this.blockPosition(), 100, PoiManager.Occupancy.ANY);
                optional1.ifPresent((this::setHome));
            }
            shouldLookForPoi = false;
        }
        if (this.tickCount % 4 == 0 && this.tickCount > 1) {
            this.supportTargetSelector.tick();
        }
        if (this.tickCount % 60 == 0) {
            this.level().getEntities(this, this.getBoundingBox().inflate(this.getAttributeValue(Attributes.FOLLOW_RANGE)), (entity) -> entity instanceof Enemy && !(entity instanceof Creeper || entity instanceof IMagicSummon || entity instanceof TamableAnimal)).forEach((enemy) -> {
                if (enemy instanceof Mob mob && mob.getTarget() == null && TargetingConditions.forCombat().test(mob, this)) {
                    mob.setTarget(this);
                }
            });
        }

        if (unhappyTimer > 0 && --unhappyTimer == 0) {
            this.entityData.set(DATA_VILLAGER_UNHAPPY, false);
        }

    }

    @Override
    protected InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {

        boolean preventTrade = (!this.level().isClientSide && this.getOffers().isEmpty()) || this.getTarget() != null || isAngryAt(pPlayer);
        if (pHand == InteractionHand.MAIN_HAND) {
            if (preventTrade && !this.level().isClientSide) {
                this.setUnhappy();
            }
        }
        if (!preventTrade) {
            if (!this.level().isClientSide && !this.getOffers().isEmpty()) {
                if (shouldRestock()) {
                    restock();
                }
                this.startTrading(pPlayer);
            }
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        }
        return super.mobInteract(pPlayer, pHand);
    }

    public void setUnhappy() {
        if (!level().isClientSide) {
            this.playSound(SoundEvents.ENDERMAN_AMBIENT, this.getSoundVolume(), this.getVoicePitch());
            unhappyTimer = 20;
            this.entityData.set(DATA_VILLAGER_UNHAPPY, true);
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        serializeHome(this, pCompound);
        serializeMerchant(pCompound, this.offers, this.lastRestockGameTime, this.numberOfRestocksToday);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        deserializeHome(this, pCompound);
        deserializeMerchant(pCompound, c -> this.offers = c);
    }

    @Override
    public Optional<SoundEvent> getAngerSound() {
        return Optional.of(SoundEvents.ENDERMAN_STARE);
    }

    /*
     * Homeowner Implementations
     */
    BlockPos homePos;

    @Nullable
    @Override
    public BlockPos getHome() {
        return homePos;
    }

    @Override
    public void setHome(BlockPos homePos) {
        this.homePos = homePos;
    }


    /*
     * Merchant Implementations
     */
    @Nullable
    private Player tradingPlayer;
    @Nullable
    protected MerchantOffers offers;

    private long lastRestockGameTime;
    private int numberOfRestocksToday;
    private long lastRestockCheckDayTime;

    public void setTradingPlayer(@Nullable Player pTradingPlayer) {
        this.tradingPlayer = pTradingPlayer;
    }
    public @Nullable Player getTradingPlayer() {
        return this.tradingPlayer;
    }

    @Override
    protected boolean isImmobile() {
        return super.isImmobile() || isTrading();
    }

    public void overrideOffers(MerchantOffers pOffers) {
    }

    public void notifyTrade(MerchantOffer pOffer) {
        pOffer.increaseUses();
        this.ambientSoundTime = -this.getAmbientSoundInterval();
    }

    @Override
    public void notifyTradeUpdated(ItemStack itemStack) {

    }

    @Override
    public SoundEvent getNotifyTradeSound() {
        return SoundEvents.ENDERMAN_AMBIENT;
    }

    protected SoundEvent getTradeUpdatedSound(boolean pIsYesSound) {
        return pIsYesSound ? SoundEvents.ENDERMAN_AMBIENT : SoundEvents.ENDERMAN_HURT;
    }

    private void startTrading(Player pPlayer) {
        this.setTradingPlayer(pPlayer);
        this.openTradingScreen(pPlayer, this.getDisplayName(), this.getVillagerData().getLevel());
    }

    public int getRestocksToday() {
        return this.numberOfRestocksToday;
    }

    public void setRestocksToday(int restocks) {
        this.numberOfRestocksToday = restocks;
    }

    public long getLastRestockGameTime() {
        return this.lastRestockGameTime;
    }

    public void setLastRestockGameTime(long time) {
        this.lastRestockGameTime = time;
    }

    public long getLastRestockCheckDayTime() {
        return this.lastRestockCheckDayTime;
    }

    public void setLastRestockCheckDayTime(long time) {
        this.lastRestockCheckDayTime = time;
    }

    public MerchantOffers getOffers() {
        if (this.offers == null) {
            this.offers = new MerchantOffers();
            this.offers.add(new MerchantOffer(
                    new ItemCost(Items.EMERALD),
                    new ItemStack(HnSItemRegistry.STARDUST.get(), 2),
                    12,
                    0,
                    0.2F
            ));
            this.offers.add(new MerchantOffer(
                    new ItemCost(Items.DIAMOND, 16),
                    new ItemStack(ItemRegistry.ENDER_RUNE.get(), 1),
                    3,
                    0,
                    0.2F
            ));

            if (this.random.nextFloat() < 0.25F) {
                this.offers.add((new AdditionalWanderingTrades.InkBuyTrade((InkItem)ItemRegistry.INK_COMMON.get())).getOffer(this, this.random));
            }

            if (this.random.nextFloat() < 0.25F) {
                this.offers.add((new AdditionalWanderingTrades.InkBuyTrade((InkItem)ItemRegistry.INK_UNCOMMON.get())).getOffer(this, this.random));
            }

            if (this.random.nextFloat() < 0.25F) {
                this.offers.add((new AdditionalWanderingTrades.InkBuyTrade((InkItem)ItemRegistry.INK_RARE.get())).getOffer(this, this.random));
            }

            this.offers.add((new AdditionalWanderingTrades.RandomScrollTrade(new SpellFilter((SchoolType) SchoolRegistry.ENDER.get()), 0.0F, 0.25F)).getOffer(this, this.random));
            if (this.random.nextFloat() < 0.8F) {
                this.offers.add((new AdditionalWanderingTrades.RandomScrollTrade(new SpellFilter((SchoolType)SchoolRegistry.ENDER.get()), 0.3F, 0.7F)).getOffer(this, this.random));
            }

            if (this.random.nextFloat() < 0.8F) {
                this.offers.add((new AdditionalWanderingTrades.RandomScrollTrade(new SpellFilter((SchoolType)SchoolRegistry.ENDER.get()), 0.8F, 1.0F)).getOffer(this, this.random));
            }

            this.offers.add(new ObsidianClaymoreTrade().getOffer(this, this.random));
            this.offers.removeIf(Objects::isNull);
            ++this.numberOfRestocksToday;
        }

        return this.offers;
    }

    static class ObsidianClaymoreTrade extends AdditionalWanderingTrades.SimpleTrade {
        private ObsidianClaymoreTrade() {
            super((trader, random) -> {
                if (!trader.level().isClientSide) {
                    ItemStack cost = new ItemStack(ItemRegistry.AMETHYST_RAPIER.get());
                    ItemStack forSale = new ItemStack(HnSItemRegistry.OBSIDIAN_CLAYMORE.get());
                    return new MerchantOffer(new ItemCost(cost.getItem(), cost.getCount()), forSale, 1, 25, 0.5f);
                }
                return null;
            });
        }
    }
}