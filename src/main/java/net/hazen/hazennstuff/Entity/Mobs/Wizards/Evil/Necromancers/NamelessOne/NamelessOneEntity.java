package net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.Necromancers.NamelessOne;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMob;
import io.redspace.ironsspellbooks.entity.mobs.goals.WizardAttackGoal;
import io.redspace.ironsspellbooks.entity.mobs.goals.WizardRecoverGoal;
import net.hazen.hazennstuff.Registries.HnSItemRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;
import java.util.List;

public class NamelessOneEntity extends AbstractSpellCastingMob implements Enemy {
    public NamelessOneEntity(EntityType<? extends AbstractSpellCastingMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.xpReward = 15;
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(4, (new WizardAttackGoal(this, (double)1.25F, 35, 80)).setSpells(List.of((AbstractSpell)SpellRegistry.FANG_STRIKE_SPELL.get(), (AbstractSpell)SpellRegistry.ICICLE_SPELL.get(), (AbstractSpell)SpellRegistry.MAGIC_MISSILE_SPELL.get()), List.of((AbstractSpell)SpellRegistry.FANG_WARD_SPELL.get()), List.of(), List.of((AbstractSpell)SpellRegistry.BLIGHT_SPELL.get(), (AbstractSpell)SpellRegistry.ROOT_SPELL.get())).setSingleUseSpell((AbstractSpell)SpellRegistry.RAISE_DEAD_SPELL.get(), 80, 350, 4, 5).setDrinksPotions());
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, (double)1.0F));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(10, new WizardRecoverGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, new Class[0]));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, IronGolem.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Turtle.class, 10, true, false, Turtle.BABY_ON_LAND_SELECTOR));
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.SKELETON_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.SKELETON_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.SKELETON_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.SKELETON_STEP;
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData) {
        RandomSource randomsource = Utils.random;
        this.populateDefaultEquipmentSlots(randomsource, pDifficulty);
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData);
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(HnSItemRegistry.NAMELESS_ONE_HELMET.get()));
        this.setDropChance(EquipmentSlot.HEAD, 0.0f);
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(HnSItemRegistry.NAMELESS_ONE_CHESTPLATE.get()));
        this.setDropChance(EquipmentSlot.CHEST, 0.0F);
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(HnSItemRegistry.NAMELESS_ONE_LEGGINGS.get()));
        this.setDropChance(EquipmentSlot.LEGS, 0.0f);
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return LivingEntity.createLivingAttributes().add(Attributes.ATTACK_DAMAGE, (double)3.0F).add(Attributes.ATTACK_KNOCKBACK, (double)0.0F).add(Attributes.MAX_HEALTH, (double)25.0F).add(Attributes.FOLLOW_RANGE, (double)25.0F).add(AttributeRegistry.SPELL_POWER, (double)0.75F).add(Attributes.MOVEMENT_SPEED, (double)0.25F);
    }

    protected boolean shouldDespawnInPeaceful() {
        return true;
    }
}
