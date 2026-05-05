package net.hazen.hazennstuff.Entity.Mobs.HnSEntityUtils;

import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.spells.SpellData;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMob;
import io.redspace.ironsspellbooks.entity.mobs.goals.WizardAttackGoal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

/*
 *** This is from Alshanex's FamiliarLib. Thank you Alshanex for allowing me to use it. :P
 */

public class HnSGoals {
    public HnSGoals() {
    }

    public static class HnSFlyingWizardAttackGoal extends WizardAttackGoal {
        private float preferredHeight;
        private float optimalRange;
        private float minSafeRange;
        private float maxCombatRange;
        private float threatAwarenessRadius;
        private @org.jetbrains.annotations.Nullable Vec3 cachedThreatCenter;
        private int threatScanTimer;
        private double orbitAngle;
        private boolean orbitClockwise;
        private int orbitSwitchTimer;

        public HnSFlyingWizardAttackGoal(AbstractSpellCastingMob abstractSpellCastingMob, double speedModifier, int attackInterval) {
            this(abstractSpellCastingMob, speedModifier, attackInterval, attackInterval);
        }

        public HnSFlyingWizardAttackGoal(AbstractSpellCastingMob abstractSpellCastingMob, double speedModifier, int attackIntervalMin, int attackIntervalMax) {
            super(abstractSpellCastingMob, speedModifier, attackIntervalMin, attackIntervalMax);
            this.preferredHeight = 4.0F;
            this.optimalRange = 10.0F;
            this.minSafeRange = 5.0F;
            this.maxCombatRange = 20.0F;
            this.threatAwarenessRadius = 14.0F;
            this.cachedThreatCenter = null;
            this.threatScanTimer = 0;
            this.orbitAngle = (double) 0.0F;
            this.orbitClockwise = true;
            this.orbitSwitchTimer = 0;
            this.isFlying = true;
            this.allowFleeing = false;
        }

        public HnSFlyingWizardAttackGoal setPreferredHeight(float height) {
            this.preferredHeight = height;
            return this;
        }

        public HnSFlyingWizardAttackGoal setCombatRanges(float min, float optimal, float max) {
            this.minSafeRange = min;
            this.optimalRange = optimal;
            this.maxCombatRange = max;
            this.spellcastingRange = max;
            this.spellcastingRangeSqr = max * max;
            return this;
        }

        public HnSFlyingWizardAttackGoal setThreatAwarenessRadius(float radius) {
            this.threatAwarenessRadius = radius;
            return this;
        }

        public void start() {
            super.start();
            this.orbitAngle = this.mob.getRandom().nextDouble() * Math.PI * (double) 2.0F;
            this.orbitClockwise = this.mob.getRandom().nextBoolean();
        }

        public void stop() {
            super.stop();
            this.cachedThreatCenter = null;
        }

        public void tick() {
            if (++this.threatScanTimer >= 5) {
                this.threatScanTimer = 0;
                this.updateThreatAwareness();
            }

            if (++this.orbitSwitchTimer > 60 && this.mob.getRandom().nextFloat() < 0.15F) {
                this.orbitClockwise = !this.orbitClockwise;
                this.orbitSwitchTimer = 0;
            }

            super.tick();
        }

        protected void doMovement(double distanceSquared) {
            if (this.target != null && !this.target.isDeadOrDying()) {
                this.mob.getLookControl().setLookAt(this.target, 30.0F, 30.0F);
                double distance = Math.sqrt(distanceSquared);
                double nearestThreatDistSqr = this.getNearestThreatDistSqr();
                double nearestThreatDist = Math.sqrt(nearestThreatDistSqr);
                double effectiveDist = Math.min(distance, nearestThreatDist);
                if (effectiveDist < (double) this.minSafeRange) {
                    if (this.spellCastingMob.isCasting()) {
                        this.spellCastingMob.cancelCast();
                    }

                    this.doRetreatMovement(this.speedModifier * (double) 1.5F);
                } else if (effectiveDist < (double) this.optimalRange * 0.8) {
                    double retreatSpeed = this.spellCastingMob.isCasting() ? this.speedModifier * 0.8 : this.speedModifier * 1.2;
                    this.doRetreatMovement(retreatSpeed);
                } else if (!(distance > (double) this.maxCombatRange) && this.hasLineOfSight) {
                    double orbitSpeed = this.spellCastingMob.isCasting() ? this.speedModifier * (double) 0.5F : this.speedModifier;
                    this.doOrbitMovement(distance, orbitSpeed);
                } else {
                    double approachSpeed = this.spellCastingMob.isCasting() ? this.speedModifier * (double) 0.5F : this.speedModifier * 1.2;
                    this.doApproachMovement(approachSpeed);
                }

            } else {
                this.mob.getNavigation().stop();
            }
        }

        private void doRetreatMovement(double speed) {
            Vec3 fleeFrom = this.cachedThreatCenter != null ? this.cachedThreatCenter : this.target.position();
            Vec3 awayFromThreats = this.mob.position().subtract(fleeFrom);
            double dist = awayFromThreats.horizontalDistance();
            if (dist < 0.01) {
                awayFromThreats = new Vec3((double) 1.0F, (double) 0.0F, (double) 0.0F);
            }

            Vec3 awayNorm = awayFromThreats.normalize();
            Vec3 lateral = (new Vec3(-awayNorm.z, (double) 0.0F, awayNorm.x)).scale((double) this.getOrbitSide());
            Vec3 retreatPos = this.mob.position().add(awayNorm.scale((double) this.optimalRange * 0.7)).add(lateral.scale((double) this.optimalRange * 0.3));
            double targetY = Math.max(retreatPos.y, this.target.getY() + (double) this.preferredHeight + (double) 2.0F);
            this.mob.getMoveControl().setWantedPosition(retreatPos.x, targetY, retreatPos.z, speed);
        }

        private void doApproachMovement(double speed) {
            Vec3 toTarget = this.target.position().subtract(this.mob.position()).normalize();
            Vec3 approachPos = this.target.position().subtract(toTarget.scale((double) this.optimalRange * 0.8));
            double targetY = this.target.getY() + (double) this.preferredHeight;
            this.mob.getMoveControl().setWantedPosition(approachPos.x, targetY, approachPos.z, speed);
        }

        private void doOrbitMovement(double currentDistance, double speed) {
            double orbitSpeed = 0.04 * (double) (this.orbitClockwise ? 1 : -1);
            if (!this.spellCastingMob.isCasting()) {
                orbitSpeed *= (double) 1.5F;
            }

            this.orbitAngle += orbitSpeed;
            double orbitRadius = (double) this.optimalRange;
            double nearestThreatDist = Math.sqrt(this.getNearestThreatDistSqr());
            if (nearestThreatDist < (double) this.optimalRange) {
                orbitRadius = (double) this.optimalRange + ((double) this.optimalRange - nearestThreatDist) * (double) 0.5F;
            }

            double targetX = this.target.getX() + Math.cos(this.orbitAngle) * orbitRadius;
            double targetZ = this.target.getZ() + Math.sin(this.orbitAngle) * orbitRadius;
            double verticalBob = Math.sin(this.orbitAngle * (double) 2.0F) * (double) 1.0F;
            double targetY = this.target.getY() + (double) this.preferredHeight + verticalBob;
            double orbitMoveSpeed = this.spellCastingMob.isCasting() ? speed * (double) 0.5F : speed;
            this.mob.getMoveControl().setWantedPosition(targetX, targetY, targetZ, orbitMoveSpeed);
        }

        protected void handleAttackLogic(double distanceSquared) {
            double nearestThreatDistSqr = this.getNearestThreatDistSqr();
            boolean threatsAreClose = nearestThreatDistSqr < (double) (this.optimalRange * this.optimalRange);
            boolean threatsAreDangerous = nearestThreatDistSqr < (double) (this.minSafeRange * this.minSafeRange);
            if (threatsAreDangerous) {
                if (this.spellCastingMob.isCasting()) {
                    this.spellCastingMob.cancelCast();
                }

                this.spellAttackDelay = 10;
            } else if (threatsAreClose) {
                if (this.spellCastingMob.isCasting()) {
                    SpellData spellData = MagicData.getPlayerMagicData(this.mob).getCastingSpell();
                    if (spellData != null && spellData.getSpell().getCastTime(spellData.getLevel()) > 30) {
                        this.spellCastingMob.cancelCast();
                    }

                    if (this.target != null && this.target.isDeadOrDying()) {
                        this.spellCastingMob.cancelCast();
                    }
                }

                if (this.spellAttackDelay <= 1) {
                    this.spellAttackDelay = 5;
                }

            } else {
                super.handleAttackLogic(distanceSquared);
            }
        }

        protected int getDefenseWeight() {
            return (int) ((float) super.getDefenseWeight() * 0.7F);
        }

        protected int getMovementWeight() {
            return (int) ((float) super.getMovementWeight() * 1.3F);
        }

        private void updateThreatAwareness() {
            List<LivingEntity> threats = this.getNearbyThreats();
            if (!threats.isEmpty()) {
                Vec3 center = Vec3.ZERO;

                for (LivingEntity threat : threats) {
                    center = center.add(threat.position());
                }

                this.cachedThreatCenter = center.scale((double) 1.0F / (double) threats.size());
            } else if (this.target != null) {
                this.cachedThreatCenter = this.target.position();
            } else {
                this.cachedThreatCenter = null;
            }

            LivingEntity lastAttacker = this.mob.getLastHurtByMob();
            if (lastAttacker != null && lastAttacker.isAlive() && lastAttacker != this.target && this.mob.getLastHurtByMobTimestamp() > this.mob.tickCount - 20 && (this.target == null || this.mob.distanceToSqr(lastAttacker) < this.mob.distanceToSqr(this.target))) {
                this.mob.setTarget(lastAttacker);
            }

        }

        private List<LivingEntity> getNearbyThreats() {
            AABB scanBox = this.mob.getBoundingBox().inflate((double) this.threatAwarenessRadius);
            return this.mob.level().getEntitiesOfClass(LivingEntity.class, scanBox, (entity) -> {
                if (entity != this.mob && entity.isAlive()) {
                    if (entity instanceof Mob) {
                        Mob mobEntity = (Mob) entity;
                        if (mobEntity.getTarget() == this.mob) {
                            return true;
                        }
                    }

                    return entity == this.mob.getLastHurtByMob() && this.mob.getLastHurtByMobTimestamp() > this.mob.tickCount - 40;
                } else {
                    return false;
                }
            });
        }

        private double getNearestThreatDistSqr() {
            List<LivingEntity> threats = this.getNearbyThreats();
            double nearest = Double.MAX_VALUE;

            for (LivingEntity threat : threats) {
                double distSqr = this.mob.distanceToSqr(threat);
                if (distSqr < nearest) {
                    nearest = distSqr;
                }
            }

            return nearest;
        }

        private float getOrbitSide() {
            return this.orbitClockwise ? 1.0F : -1.0F;
        }

        public float getStrafeMultiplier() {
            return 0.0F;
        }
    }
}
