package net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.ServantsOfEnder;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.entity.mobs.goals.*;
import net.hazen.hazennstuff.Datagen.HnSTags;
import net.hazen.hazennstuff.Entity.Mobs.HnSEntityUtils.AbstractSpellCastingEnderman;
import net.hazen.hazennstuff.Registries.HnSItemRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class ServantsOfEnderEntity extends AbstractSpellCastingEnderman implements Enemy {

    public ServantsOfEnderEntity(EntityType<? extends AbstractSpellCastingEnderman> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        xpReward = 15;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new EndermanFreezeWhenLookedAt(this));
        this.goalSelector.addGoal(2, new SpellBarrageGoal(this, SpellRegistry.COUNTERSPELL_SPELL.get(), 3, 6, 100, 250, 1));
        this.goalSelector.addGoal(3, new WizardAttackGoal(this, 1.25f, 35, 70)
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

        this.goalSelector.addGoal(7, new PatrolNearLocationGoal(this, 30, 1f));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, (double)1.0F, 0.0F));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(10, new WizardRecoverGoal(this));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new EndermanLookForPlayerGoal(this, this::isAngryAt));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this, new Class[0]));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractSpellCastingEnderman.class, true, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, true, (entity) -> !entity.getType().is(HnSTags.SPAWNS_OF_ENDER)));
        this.targetSelector.addGoal(3,
                new NearestAttackableTargetGoal<>(this, Mob.class, true,
                        entity -> entity.getType().is(HnSTags.ASTRAL_CONSTRUCT)
                ));
        this.targetSelector.addGoal(4, new ResetUniversalAngerTargetGoal<>(this, false));
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENDERMAN_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.ENDERMAN_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENDERMAN_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.STEM_STEP;
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(HnSItemRegistry.ENDERMAN_MASKED.get()));
        this.setDropChance(EquipmentSlot.HEAD, 0.0f);
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(HnSItemRegistry.ENDERMAN_CHESTPLATE.get()));
        this.setDropChance(EquipmentSlot.CHEST, 0.0F);
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(HnSItemRegistry.ENDERMAN_LEGGINGS.get()));
        this.setDropChance(EquipmentSlot.LEGS, 0.0F);
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(HnSItemRegistry.ENDERMAN_BOOTS.get()));
        this.setDropChance(EquipmentSlot.FEET, 0.0F);
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.ATTACK_DAMAGE, 3.0)
                .add(Attributes.ATTACK_KNOCKBACK, 0.0)
                .add(Attributes.MAX_HEALTH, 50)
                .add(Attributes.FOLLOW_RANGE, 25.0)
                .add(AttributeRegistry.SPELL_POWER, 0.75)
                .add(Attributes.MOVEMENT_SPEED, .25);
    }

    @Override
    protected boolean shouldDespawnInPeaceful() {
        return true;
    }

    @Override
    public SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData) {
        RandomSource randomsource = Utils.random;
        this.populateDefaultEquipmentSlots(randomsource, pDifficulty);
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData);
    }
}