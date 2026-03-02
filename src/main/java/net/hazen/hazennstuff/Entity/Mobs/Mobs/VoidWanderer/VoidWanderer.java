package net.hazen.hazennstuff.Entity.Mobs.Mobs.VoidWanderer;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.entity.mobs.IAnimatedAttacker;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMob;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.NeutralWizard;
import io.redspace.ironsspellbooks.entity.mobs.goals.PatrolNearLocationGoal;
import io.redspace.ironsspellbooks.entity.mobs.goals.SpellBarrageGoal;
import io.redspace.ironsspellbooks.entity.mobs.goals.WizardRecoverGoal;
import io.redspace.ironsspellbooks.entity.mobs.goals.melee.AttackAnimationData;
import io.redspace.ironsspellbooks.entity.mobs.wizards.GenericAnimatedWarlockAttackGoal;
import io.redspace.ironsspellbooks.entity.mobs.wizards.fire_boss.NotIdioticNavigation;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import java.util.List;
import javax.annotation.Nullable;

import net.acetheeldritchking.aces_spell_utils.entity.mobs.UniqueAbstractSpellCastingMob;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.AnimationController.State;

public class VoidWanderer extends UniqueAbstractSpellCastingMob implements Enemy, IAnimatedAttacker {
    RawAnimation animationToPlay = null;
    private final AnimationController<VoidWanderer> meleeController = new AnimationController(this, "void_wanderer_animations", 20, this::predicate);

    public VoidWanderer(EntityType<? extends AbstractSpellCastingMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.xpReward = 25;
        this.lookControl = this.createLookControl();
        this.moveControl = this.createMoveControl();
    }

    protected LookControl createLookControl() {
        return new LookControl(this) {
            protected float rotateTowards(float pFrom, float pTo, float pMaxDelta) {
                return super.rotateTowards(pFrom, pTo, pMaxDelta * 2.5F);
            }

            protected boolean resetXRotOnTick() {
                return VoidWanderer.this.getTarget() == null;
            }
        };
    }

    protected MoveControl createMoveControl() {
        return new MoveControl(this) {
            protected float rotlerp(float pSourceAngle, float pTargetAngle, float pMaximumChange) {
                double d0 = this.wantedX - this.mob.getX();
                double d1 = this.wantedZ - this.mob.getZ();
                return d0 * d0 + d1 * d1 < (double)0.5F ? pSourceAngle : super.rotlerp(pSourceAngle, pTargetAngle, pMaximumChange * 0.25F);
            }
        };
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new SpellBarrageGoal(this,
                (AbstractSpell)HnSSpellRegistries.SHOOTING_STAR.get(), 3, 6, 100, 250, 1));
        this.goalSelector.addGoal(3, (new GenericAnimatedWarlockAttackGoal(this, (double)1.25F, 50, 75))
                .setMoveset(List.of(
                        new AttackAnimationData(9, "simple_sword_upward_swipe", new int[]{5}),
                        new AttackAnimationData(8, "simple_sword_lunge_stab", new int[]{6}),
                        new AttackAnimationData(10, "simple_sword_stab_alternate", new int[]{8}),
                        new AttackAnimationData(10, "simple_sword_horizontal_cross_swipe", new int[]{8})
                ))
                .setComboChance(0.4F)
                .setMeleeAttackInverval(10, 30)
                .setMeleeMovespeedModifier(1.5F)
                .setSpells(
                        List.of(
                        (AbstractSpell) HnSSpellRegistries.SHOOTING_STAR.get(),
                        (AbstractSpell) HnSSpellRegistries.SHOOTING_STAR.get(),
                        (AbstractSpell) HnSSpellRegistries.SHOOTING_STAR.get(),
                        (AbstractSpell) HnSSpellRegistries.SHOOTING_STAR.get()),
                        List.of(
                                (AbstractSpell)HnSSpellRegistries.SHOOTING_STAR.get()),
                        List.of(),
                        List.of())
                .setDrinksPotions()
        );
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(10, new WizardRecoverGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData) {
        RandomSource randomsource = Utils.random;
        this.populateDefaultEquipmentSlots(randomsource, pDifficulty);
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData);
    }

    public static AttributeSupplier.Builder prepareAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.ATTACK_DAMAGE, (double)3.0F)
                .add(Attributes.ATTACK_KNOCKBACK, (double)0.0F)
                .add(Attributes.MAX_HEALTH, (double)60.0F)
                .add(Attributes.FOLLOW_RANGE, (double)24.0F)
                .add(Attributes.ENTITY_INTERACTION_RANGE, (double)3.0F)
                .add(Attributes.MOVEMENT_SPEED, (double)0.25F)
                ;
    }

    public void playAnimation(String animationId) {
        try {
            this.animationToPlay = RawAnimation.begin().thenPlay(animationId);
        } catch (Exception var3) {
            IronsSpellbooks.LOGGER.error("Entity {} Failed to play animation: {}", this, animationId);
        }

    }

    private PlayState predicate(AnimationState<VoidWanderer> animationEvent) {
        AnimationController<VoidWanderer> controller = animationEvent.getController();
        if (this.animationToPlay != null) {
            controller.forceAnimationReset();
            controller.setAnimation(this.animationToPlay);
            this.animationToPlay = null;
        }

        return PlayState.CONTINUE;
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(this.meleeController);
        super.registerControllers(controllerRegistrar);
    }

    public boolean isAnimating() {
        return this.meleeController.getAnimationState() != State.STOPPED || super.isAnimating();
    }

    protected PathNavigation createNavigation(Level pLevel) {
        return new NotIdioticNavigation(this, pLevel);
    }
}
