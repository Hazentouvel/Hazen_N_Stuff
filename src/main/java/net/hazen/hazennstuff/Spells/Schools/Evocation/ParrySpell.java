package net.hazen.hazennstuff.Spells.Schools.Evocation;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.hazen.hazennstuff.Animations.HnSSpellAnimations;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ParrySpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath("hazennstuff", "parry");
    private final DefaultConfig defaultConfig;

    public ParrySpell() {
        this.defaultConfig = (new DefaultConfig())
                .setMinRarity(SpellRarity.COMMON)
                .setSchoolResource(SchoolRegistry.EVOCATION_RESOURCE)
                .setMaxLevel(1)
                .setCooldownSeconds((double)12.0F)
                .build();
        this.manaCostPerLevel = 15;
        this.baseSpellPower = 5;
        this.spellPowerPerLevel = 1;
        this.castTime = 0;
        this.baseManaCost = 30;
    }

    public CastType getCastType() {
        return CastType.INSTANT;
    }

    public DefaultConfig getDefaultConfig() {
        return this.defaultConfig;
    }

    public ResourceLocation getSpellResource() {
        return this.spellId;
    }

    public void onClientCast(Level level, int spellLevel, LivingEntity entity, ICastData castData) {
        super.onClientCast(level, spellLevel, entity, castData);
        entity.setYBodyRot(entity.getYRot());
    }

    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of(HnSSounds.PUNCH.get());
    }

    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        float distance = 12.0F;
        Vec3 forward = entity.getForward();
        Vec3 end = Utils.raycastForBlock(level, entity.getEyePosition(), entity.getEyePosition().add(forward.scale((double)distance)), Fluid.NONE).getLocation();

        AABB hitbox = entity.getHitbox().expandTowards(end.subtract(entity.getEyePosition()))
                .inflate(6.0D);

        List<Entity> targetableEntities = level.getEntities(entity, hitbox, (e) -> !e.isSpectator() && e instanceof Projectile && e.getBoundingBox().getCenter().subtract(entity.getBoundingBox().getCenter()).normalize().dot(entity.getForward()) >= 0.85);
        targetableEntities.sort(Comparator.comparingDouble((e) -> e.distanceToSqr(entity)));
        if (!targetableEntities.isEmpty() && targetableEntities.get(0).distanceToSqr(entity) < (double)(distance * distance)) {
            Entity closestEntity = targetableEntities.get(0);

            float radius = 4.0F;
            AABB damageBox = AABB.ofSize(closestEntity.getBoundingBox().getCenter(), (double)radius, (double)(radius + 1.0F), (double)radius).move(forward.scale((double)(radius / 2.0F)));
            List<Entity> damageEntities = level.getEntities(entity, damageBox);
            boolean projectileEffects = false;

            for (Entity targetEntity : damageEntities) {
                if (targetEntity instanceof Projectile) {
                    Projectile projectile = (Projectile) targetEntity;
                    if (!projectile.noPhysics) {
                        projectileEffects = true;

                        // Reflect the projectile
                        projectile.setOwner(entity);
                        projectile.shoot(forward.x, forward.y, forward.z, (float) projectile.getDeltaMovement().length(), 0.0F);

                        // Play PARRY sound immediately at the projectile's position
                        level.playSound(
                                (Player) null,
                                projectile.getX(),
                                projectile.getY(),
                                projectile.getZ(),
                                HnSSounds.PARRY.get(),
                                entity.getSoundSource()
                        );
                    }
                }
            }
        }

        super.onCast(level, spellLevel, entity, castSource, playerMagicData);
    }

    public AnimationHolder getCastStartAnimation() {
        return HnSSpellAnimations.PARRY;
    }
}

