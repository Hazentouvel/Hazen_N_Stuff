package net.hazen.hazennstuff.Spells.Schools.Lightning;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.RecastInstance;
import net.hazen.hazennstuff.Animations.HnSSpellAnimations;
import net.hazen.hazennstuff.Entity.Spells.Lightning.DazzlingObliteration.NinguDemonbanePetalblade;
import net.hazen.hazennstuff.Entity.Spells.Lightning.DazzlingObliteration.Shuriken.NinguDemonbanePetalbladeShuriken;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class DazzlingObliterationSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "dazzling_obliteration");
    private int recastStage = 1;

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getDamage(spellLevel, caster), 1))
        );
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.EPIC)
            .setSchoolResource(SchoolRegistry.LIGHTNING_RESOURCE)
            .setMaxLevel(5)
            .setCooldownSeconds(20)
            .build();

    public DazzlingObliterationSpell()
    {
        this.manaCostPerLevel = 5;
        this.baseSpellPower = 5;
        this.spellPowerPerLevel = 2;
        this.castTime = 0;
        this.baseManaCost = 50;
    }

    @Override
    public ResourceLocation getSpellResource() {
        return spellId;
    }

    @Override
    public DefaultConfig getDefaultConfig() {
        return defaultConfig;
    }

    @Override
    public CastType getCastType() {
        return CastType.INSTANT;
    }

    @Override
    public AnimationHolder getCastStartAnimation() {
        if (recastStage == 1) {
            return HnSSpellAnimations.RAPPA_RECAST_1;
        } else if (recastStage == 2) {
            return HnSSpellAnimations.RAPPA_RECAST_2;
        } else {
            return HnSSpellAnimations.RAPPA_RECAST_3;
        }
    }

    @Override
    public Optional<SoundEvent> getCastStartSound() {
        if (recastStage == 1) {
            return Optional.of(HnSSounds.NINGU_DEMONBANE_PETALBLADE_CAST_1.value());
        } else if (recastStage == 2) {
            return Optional.of(HnSSounds.NINGU_DEMONBANE_PETALBLADE_CAST_2.value());
        } else {
            return Optional.of(HnSSounds.NINGU_DEMONBANE_PETALBLADE_CAST_3.value());
        }
    }

    @Override
    public int getRecastCount(int spellLevel, @Nullable LivingEntity entity) {
        return 3;
    }

    public boolean checkPreCastConditions(Level level, int spellLevel, LivingEntity entity, MagicData playerMagicData) {
        if (playerMagicData != null && playerMagicData.getPlayerRecasts() != null) {
            int remaining = playerMagicData.getPlayerRecasts().getRemainingRecastsForSpell(spellId.toString());
            if (remaining >= 3) recastStage = 1;
            else if (remaining == 2) recastStage = 2;
            else recastStage = 3;
        } else {
            recastStage = 1;
        }

        Utils.preCastTargetHelper(level, entity, playerMagicData, this, 32, 0.35F, false);

        return true;
    }

    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        if (!playerMagicData.getPlayerRecasts().hasRecastForSpell(getSpellId())) {
            playerMagicData.getPlayerRecasts().addRecast(
                    new RecastInstance(getSpellId(), spellLevel, getRecastCount(spellLevel, entity), 8 * 20, castSource, null),
                    playerMagicData
            );
        }

        // FieryDagger-like formatting: handle each recast stage but keep logic streamlined and consistent
        if (recastStage == 1) {
            // First cast: spawn a single blade 3 blocks to the right of the player and fire forward immediately
            Vec3 forward = entity.getLookAngle().normalize();
            Vec3 right = forward.cross(new Vec3(0, 1, 0)).normalize();
            Vec3 spawnPos = entity.position()
                    .add(right.scale(3.0))
                    .add(0, entity.getEyeHeight() - 0.2f, 0);

            NinguDemonbanePetalblade blade = new NinguDemonbanePetalblade(level, entity);
            blade.setPos(spawnPos);
            // Fire in the direction the player is looking
            blade.shoot(forward);
            blade.setDamage(getDamage(spellLevel, entity));
            level.addFreshEntity(blade);

        } else if (recastStage == 2) {
            // Second cast: spawn two blades from behind the targeted entity so they cross at the mob's center
            var raycast = Utils.raycastForEntity(level, entity, 45.0F, true);
            LivingEntity targetEntity = null;
            Vec3 targetCenter = null;

            if (raycast.getType() == net.minecraft.world.phys.HitResult.Type.ENTITY) {
                Entity hit = ((net.minecraft.world.phys.EntityHitResult) raycast).getEntity();
                if (hit instanceof LivingEntity livingHit) {
                    targetEntity = livingHit;
                    targetCenter = livingHit.position().add(0, livingHit.getBbHeight() * 0.5, 0);
                }
            }

            if (targetEntity != null) {
                Vec3 tForward = targetEntity.getLookAngle().normalize();
                Vec3 tRight = tForward.cross(new Vec3(0, 1, 0)).normalize();

                // Spawn both blades behind the target, offset left and right so they cross at the target center
                Vec3 spawn1 = targetCenter.add(tForward.scale(-3.0)).add(tRight.scale(2.5));
                Vec3 spawn2 = targetCenter.add(tForward.scale(-3.0)).add(tRight.scale(-2.5));

                NinguDemonbanePetalblade blade1 = new NinguDemonbanePetalblade(level, entity);
                blade1.setPos(spawn1);
                blade1.shoot(targetCenter.subtract(spawn1).normalize());
                blade1.setDamage(getDamage(spellLevel, entity));
                level.addFreshEntity(blade1);

                NinguDemonbanePetalblade blade2 = new NinguDemonbanePetalblade(level, entity);
                blade2.setPos(spawn2);
                blade2.shoot(targetCenter.subtract(spawn2).normalize());
                blade2.setDamage(getDamage(spellLevel, entity));
                level.addFreshEntity(blade2);

            } else {
                // No target found: spawn behind the caster's look direction similar to previous fallback
                Vec3 spawnCenter = entity.position()
                        .add(0, entity.getEyeHeight() - 0.2f, 0)
                        .add(entity.getLookAngle().normalize().scale(-7.0));

                NinguDemonbanePetalblade blade1 = new NinguDemonbanePetalblade(level, entity);
                blade1.setPos(spawnCenter.add(-0.5, 0, 0));
                blade1.shoot(entity.getLookAngle());
                blade1.setDamage(getDamage(spellLevel, entity));
                level.addFreshEntity(blade1);

                NinguDemonbanePetalblade blade2 = new NinguDemonbanePetalblade(level, entity);
                blade2.setPos(spawnCenter.add(0.5, 0, 0));
                blade2.shoot(entity.getLookAngle());
                blade2.setDamage(getDamage(spellLevel, entity));
                level.addFreshEntity(blade2);
            }

        } else if (recastStage == 3) {
            // Final cast: spawn the shuriken which will follow the player for a short delay then fire where the player is looking
            int delay = 15;
            NinguDemonbanePetalbladeShuriken shuriken = new NinguDemonbanePetalbladeShuriken(level, entity);
            Vec3 spawnPos = entity.position().add(0, entity.getEyeHeight() - shuriken.getBbHeight() * 0.5, 0);
            shuriken.setSpawnPos(spawnPos);
            // store the offset from the owner so it maintains position relative to the owner while waiting
            shuriken.ownerTrack = spawnPos.subtract(entity.position());
            shuriken.setDelay(delay);
            shuriken.setDamage(getDamage(spellLevel, entity));
            level.addFreshEntity(shuriken);
        }

        int remaining = playerMagicData.getPlayerRecasts().getRemainingRecastsForSpell(spellId.toString());
        if (remaining >= 3) recastStage = 2;
        else if (remaining == 2) recastStage = 3;
        else recastStage = 1;

        super.onCast(level, spellLevel, entity, castSource, playerMagicData);
    }

    public float getDamage(int spellLevel, LivingEntity caster) {
        return 5.0F + 5.0F * this.getSpellPower(spellLevel, caster);
    }
}