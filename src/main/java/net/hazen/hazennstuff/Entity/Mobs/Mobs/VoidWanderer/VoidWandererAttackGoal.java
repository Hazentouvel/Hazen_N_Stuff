package net.hazen.hazennstuff.Entity.Mobs.Mobs.VoidWanderer;

import io.redspace.ironsspellbooks.entity.mobs.goals.melee.AttackKeyframe;
import io.redspace.ironsspellbooks.entity.mobs.wizards.GenericAnimatedWarlockAttackGoal;
import io.redspace.ironsspellbooks.entity.spells.EarthquakeAoe;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.network.SyncAnimationPacket;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.network.PacketDistributor;
import net.minecraft.world.phys.Vec3;

public class VoidWandererAttackGoal extends GenericAnimatedWarlockAttackGoal<VoidWanderer> {
    final VoidWanderer voidWanderer;
    int meleeAnimTimer = -1;
    public VoidWanderer.AttackType currentAttackType;
    public VoidWanderer.AttackType nextAttack;
    public VoidWanderer.AttackType queueCombo;
    private boolean hasDashed;
    private boolean hasHitDash;
    private Vec3 oldDashPos;

    public VoidWandererAttackGoal(VoidWanderer abstractSpellCastingMob, double pSpeedModifier, int minAttackInterval, int maxAttackInterval) {
        super(abstractSpellCastingMob, pSpeedModifier, minAttackInterval, maxAttackInterval);
        this.voidWanderer = abstractSpellCastingMob;
        this.nextAttack = this.randomizeNextAttack(0.0F);
    }

    protected float meleeBias() {
        return 0.4F;
    }

    @Override
    protected void handleAttackLogic(double distanceSquared) {
        if (this.mob.isCasting()) {
            super.handleAttackLogic(distanceSquared);
            return;
        }
        if (this.target == null) {
            super.handleAttackLogic(distanceSquared);
            return;
        }
        if (this.meleeAnimTimer < 0) {
            super.handleAttackLogic(distanceSquared);
            return;
        }
        float meleeRange = this.meleeRange();
        float distance = (float)Math.sqrt(distanceSquared);
        this.mob.getLookControl().setLookAt(this.target);

        if (this.meleeAnimTimer > 0) {
            this.forceFaceTargetIfNeeded();
            --this.meleeAnimTimer;

            if (this.currentAttackType != null && this.currentAttackType.data.isHitFrame(this.meleeAnimTimer - 4)) {
                if (this.currentAttackType != VoidWanderer.AttackType.Dash) {
                    this.playSwingSound();
                }
            } else if (this.currentAttackType != null && this.currentAttackType.data.isHitFrame(this.meleeAnimTimer)) {
                if (this.currentAttackType != VoidWanderer.AttackType.Dash) {
                    AttackKeyframe attackData = this.currentAttackType.data.getHitFrame(this.meleeAnimTimer);

                    if (attackData == null) {
                        return;
                    }

                    // Lunge
                    Vec3 lunge = this.target.position().subtract(this.mob.position())
                            .normalize()
                            .scale(0.55F);
                    this.mob.push(lunge.x, lunge.y, lunge.z);

                    if (distance <= meleeRange && Utils.hasLineOfSight(this.mob.level(), this.mob, this.target, true)) {
                        boolean flag = this.mob.doHurtTarget(this.target);
                        this.target.invulnerableTime = 0;
                        if (flag) {
                            this.playImpactSound();
                            if (this.currentAttackType.data.isSingleHit() && (this.mob.getRandom().nextFloat() < 0.75F || this.target.isBlocking())) {
                                this.queueCombo = this.randomizeNextAttack(0.0F);
                            }
                        }
                    }

                    // Slam
                    if (this.currentAttackType == VoidWanderer.AttackType.Slam) {
                        for (LivingEntity target : ((VoidWanderer)this.mob).level().getEntitiesOfClass(this.target.getClass(), ((VoidWanderer)this.mob).getBoundingBox().inflate((double)3.5F))) {
                            if (target != null) {
                                boolean hit = this.mob.doHurtTarget(target);
                                if (hit) this.playImpactSound();
                            }
                        }
                        this.spawnVisualEarthquake();
                    }
                } else {
                    // Dash
                    if (!this.hasDashed) {
                        Vec3 dash = this.target.position().subtract(this.mob.position())
                                .normalize()
                                .multiply(2.4, 0.5F, 2.4)
                                .add(0.0F, 0.15, 0.0F);
                        this.mob.push(dash.x, dash.y, dash.z);
                        this.oldDashPos = this.mob.position();
                        this.mob.getNavigation().stop();
                        this.hasDashed = true;
                        this.playSwingSound();
                    }

                    if (!this.hasHitDash && distance <= meleeRange * 0.45F) {
                        if (this.mob.doHurtTarget(this.target)) {
                            this.playImpactSound();
                        }

                        Vec3 knockback = this.oldDashPos.subtract(this.target.position());
                        this.target.knockback(1.0F, knockback.x, knockback.z);
                        this.hasHitDash = true;
                    }
                }
            }
        } else if (this.queueCombo != null && this.target != null && !this.target.isDeadOrDying()) {
            this.nextAttack = this.queueCombo;
            this.queueCombo = null;
            this.doMeleeAction();
        } else if (this.meleeAnimTimer == 0) {
            this.nextAttack = this.randomizeNextAttack(distance);
            this.resetMeleeAttackInterval(distanceSquared);
        } else if (distance < meleeRange * (float)(this.nextAttack == VoidWanderer.AttackType.Dash ? 3 : 1)) {
            if (this.hasLineOfSight && --this.meleeAttackDelay == 0) {
                this.doMeleeAction();
            } else if (this.meleeAttackDelay < 0) {
                this.resetMeleeAttackInterval(distanceSquared);
            }
        } else if (--this.meleeAttackDelay < 0) {
            this.resetMeleeAttackInterval(distanceSquared);
            this.nextAttack = this.randomizeNextAttack(distance);
        }
    }

    private VoidWanderer.AttackType randomizeNextAttack(float distance) {
        float meleeRange = this.meleeRange();
        int i;
        if (distance < meleeRange * 1.5F) {
            // prefer melee attacks when close
            i = VoidWanderer.AttackType.values().length - 1;
        } else {
            if (this.mob.getRandom().nextFloat() < 0.25F && distance > meleeRange * 2.5F) {
                return VoidWanderer.AttackType.Dash;
            }

            i = VoidWanderer.AttackType.values().length;
        }

        return VoidWanderer.AttackType.values()[this.mob.getRandom().nextInt(i)];
    }

    private void forceFaceTargetIfNeeded() {
        if (!this.hasDashed && this.target != null) {
            double d0 = this.target.getX() - this.mob.getX();
            double d1 = this.target.getZ() - this.mob.getZ();
            float yRot = (float)(Mth.atan2(d1, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
            this.mob.setYBodyRot(yRot);
            this.mob.setYHeadRot(yRot);
            this.mob.setYRot(yRot);
        }
    }

    protected void doMeleeAction() {
        this.currentAttackType = this.nextAttack;
        if (this.currentAttackType != null) {
            super.currentAttack = this.currentAttackType.data;
            try {
                this.voidWanderer.playAnimation(this.currentAttackType.name());
            } catch (Exception ignored) {}
            this.mob.swing(InteractionHand.MAIN_HAND);
            this.meleeAnimTimer = this.currentAttackType.data.lengthInTicks;
            this.hasDashed = false;
            this.hasHitDash = false;
            PacketDistributor.sendToPlayersTrackingEntity(this.voidWanderer, new SyncAnimationPacket(this.currentAttackType.toString(), this.voidWanderer), new CustomPacketPayload[0]);
        }
    }

    protected void doMovement(double distanceSquared) {
        float meleeRange = this.meleeRange();
        if (this.target.isDeadOrDying()) {
            this.mob.getNavigation().stop();
        } else if (distanceSquared > (double)(meleeRange * meleeRange)) {
            this.mob.getNavigation().moveTo(this.target, this.speedModifier * (double)1.3F);
        }
    }

    public boolean isActing() {
        return super.isActing() || this.meleeAnimTimer > 0;
    }

    public boolean canContinueToUse() {
        return super.canContinueToUse() || this.meleeAnimTimer > 0;
    }

    public void stop() {
        super.stop();
        this.meleeAnimTimer = -1;
        this.queueCombo = null;
        super.currentAttack = null;
        this.currentAttackType = null;
    }

    private void spawnVisualEarthquake() {
        EarthquakeAoe aoe = new EarthquakeAoe(((VoidWanderer)this.mob).level());
        aoe.moveTo(this.target.position());
        aoe.setOwner(this.mob);
        aoe.setCircular();
        aoe.setRadius(5.0F);
        aoe.setDuration(10);
        aoe.setDamage(3.0F);
        aoe.setSlownessAmplifier(0);
        ((VoidWanderer)this.mob).level().addFreshEntity(aoe);
    }

    public void playSwingSound() {
        this.mob.playSound(SoundRegistry.KEEPER_SWING.get(),
                1.0F,
                (float)Mth.randomBetweenInclusive(this.mob.getRandom(),
                        9,
                        13) * 0.1F);
    }

    public void playImpactSound() {
        this.mob.playSound(SoundRegistry.KEEPER_SWORD_IMPACT.get(),
                1.0F,
                (float)Mth.randomBetweenInclusive(this.mob.getRandom(),
                        9,
                        13) * 0.1F);
    }
}