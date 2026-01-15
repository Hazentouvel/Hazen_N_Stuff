package net.hazen.hazennstuff.Entity.Mobs.Summons.SummonTerraprisma;

import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.entity.mobs.goals.WarlockAttackGoal;
import io.redspace.ironsspellbooks.network.SyncAnimationPacket;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;

public class TerraprismaAttackGoal extends WarlockAttackGoal {
    final SummonedTerraprisma keeper;
    int meleeAnimTimer = -1;
    public SummonedTerraprisma.AttackType currentAttack;
    public SummonedTerraprisma.AttackType nextAttack;
    public SummonedTerraprisma.AttackType queueCombo;
    private boolean hasDashed;
    private boolean hasHitDash;
    private Vec3 oldDashPos;

    public TerraprismaAttackGoal(SummonedTerraprisma abstractSpellCastingMob, double pSpeedModifier, int minAttackInterval, int maxAttackInterval) {
        super(abstractSpellCastingMob, pSpeedModifier, minAttackInterval, maxAttackInterval);
        this.keeper = abstractSpellCastingMob;
        this.nextAttack = this.randomizeNextAttack(0.0F);
        this.wantsToMelee = true;
    }

    protected float meleeBias() {
        return 1.0F;
    }

    public boolean isActing() {
        return super.isActing() || this.meleeAnimTimer > 0;
    }

    protected void handleAttackLogic(double distanceSquared) {
        float meleeRange = this.meleeRange();
        float distance = Mth.sqrt((float)distanceSquared);
        this.mob.getLookControl().setLookAt(this.target);
        if (this.meleeAnimTimer > 0) {
            this.forceFaceTarget();
            --this.meleeAnimTimer;

            if (this.currentAttack.data.isHitFrame(this.meleeAnimTimer - 4)) {
                if (this.currentAttack != SummonedTerraprisma.AttackType.Dash) {
                    this.playSwingSound();
                }
            } else if (this.currentAttack.data.isHitFrame(this.meleeAnimTimer)) {
                if (this.currentAttack != SummonedTerraprisma.AttackType.Dash) {
                    Vec3 lunge = this.target.position().subtract(this.mob.position())
                            .normalize()
                            .scale(0.55F);
                    this.mob.push(lunge.x, lunge.y, lunge.z);
                    if (distance <= meleeRange && Utils.hasLineOfSight(this.mob.level(), this.mob, this.target, true)) {
                        boolean flag = this.mob.doHurtTarget(this.target);
                        this.target.invulnerableTime = 0;
                        if (flag) {
                            this.playImpactSound();
                            if (this.currentAttack.data.isSingleHit() && (this.mob.getRandom().nextFloat() < 0.75F || this.target.isBlocking())) {
                                this.queueCombo = this.randomizeNextAttack(0.0F);
                            }
                        }
                    }
                } else {
                    if (!this.hasDashed) {
                        Vec3 dash = this.target.position().subtract(this.mob.position())
                                .normalize()
                                .multiply(2.4,0.5F, 2.4)
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
            this.meleeAnimTimer = -1;
        } else if (distance < meleeRange * (float)(this.nextAttack == SummonedTerraprisma.AttackType.Dash ? 3 : 1)) {
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

    private SummonedTerraprisma.AttackType randomizeNextAttack(float distance) {
        float meleeRange = this.meleeRange();
        int i;
        if (distance < meleeRange * 1.5F) {
            i = SummonedTerraprisma.AttackType.values().length - 1;
        } else {
            if (this.mob.getRandom().nextFloat() < 0.25F && distance > meleeRange * 2.5F) {
                return SummonedTerraprisma.AttackType.Dash;
            }

            i = SummonedTerraprisma.AttackType.values().length;
        }

        return SummonedTerraprisma.AttackType.values()[this.mob.getRandom().nextInt(i)];
    }

    private void forceFaceTarget() {
        if (!this.hasDashed) {
            double d0 = this.target.getX() - this.mob.getX();
            double d1 = this.target.getZ() - this.mob.getZ();
            float yRot = (float)(Mth.atan2(d1, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
            this.mob.setYBodyRot(yRot);
            this.mob.setYHeadRot(yRot);
            this.mob.setYRot(yRot);
        }
    }

    protected void doMeleeAction() {
        this.currentAttack = this.nextAttack;
        if (this.currentAttack != null) {
            this.mob.swing(InteractionHand.MAIN_HAND);
            this.meleeAnimTimer = this.currentAttack.data.lengthInTicks;
            this.hasDashed = false;
            this.hasHitDash = false;
            PacketDistributor.sendToPlayersTrackingEntity(this.keeper, new SyncAnimationPacket(this.currentAttack.toString(), this.keeper), new CustomPacketPayload[0]);
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

    public boolean canContinueToUse() {
        return super.canContinueToUse() || this.meleeAnimTimer > 0;
    }

    public void stop() {
        super.stop();
        this.meleeAnimTimer = -1;
        this.queueCombo = null;
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
