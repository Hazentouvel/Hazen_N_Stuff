package net.hazen.hazennstuff.Spells.Schools.Shadow;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.SpellDamageSource;
import io.redspace.ironsspellbooks.particle.TraceParticleOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.redspace.ironsspellbooks.spells.ender.TeleportSpell;
import net.hazen.hazennstuff.Entity.Spells.Shadow.ShadowDagger.ShadowDagger;
import net.hazen.hazentouvelib.Registries.HLSchoolRegistry;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

public class UmbrashiftBarrageSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath("hazennstuff", "umbrashift_barrage");
    private final DefaultConfig defaultConfig;

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        var li = new ArrayList<>(super.getUniqueInfo(spellLevel, caster));


        li.addFirst(Component.literal("\u2999 - Hazen 'n Stuff - \u2999")
                .withStyle(ChatFormatting.GOLD)
                .withStyle(ChatFormatting.BOLD)
        );

        li.addAll(List.of(

                Component.translatable("ui.irons_spellbooks.distance", getDistance(spellLevel, caster)),

                Component.translatable("ui.irons_spellbooks.damage", new Object[]{Utils.stringTruncation((double)this.getDamage(spellLevel, caster), 2)})


        ));

        return li;
    }

    public UmbrashiftBarrageSpell() {
        this.defaultConfig = (new DefaultConfig())
                .setMinRarity(SpellRarity.RARE)
                .setSchoolResource(HLSchoolRegistry.SHADOW_RESOURCE)
                .setMaxLevel(5)
                .setCooldownSeconds((double)12.0F)
                .build();
        this.baseSpellPower = 12;
        this.spellPowerPerLevel = 4;
        this.baseManaCost = 30;
        this.manaCostPerLevel = 10;
        this.castTime = 0;
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

    public Optional<SoundEvent> getCastStartSound() {
        return Optional.empty();
    }

    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of((SoundEvent) HnSSounds.UMBRASHIFT_BARRAGE.get());
    }

    @Override
    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        Vec3 dest = null;
        var teleportData = (TeleportSpell.TeleportData) playerMagicData.getAdditionalCastData();
        if (teleportData != null) {
            var potentialTarget = teleportData.getTeleportTargetPosition();
            if (potentialTarget != null) {
                dest = potentialTarget;
                Utils.handleSpellTeleport(this, entity, dest);
            }
        } else {
            HitResult hitResult = Utils.raycastForEntity(level, entity, getDistance(spellLevel, entity), true);
            if (entity.isPassenger()) {
                entity.stopRiding();
            }
            if (hitResult.getType() == HitResult.Type.ENTITY && ((EntityHitResult) hitResult).getEntity() instanceof LivingEntity target) {
                for (int i = 0; i < 8; i++) {
                    dest = target.position().subtract(new Vec3(0, 0, 1.5).yRot(-(target.getYRot() + i * 45) * Mth.DEG_TO_RAD));
                    if (level.getBlockState(BlockPos.containing(dest).above()).isAir())
                        break;

                }
                Utils.handleSpellTeleport(this, entity, dest.add(0, 1, 0));
                entity.lookAt(EntityAnchorArgument.Anchor.EYES, target.getEyePosition().subtract(0, .15, 0));
            } else {
                dest = TeleportSpell.findTeleportLocation(level, entity, getDistance(spellLevel, entity));
                Utils.handleSpellTeleport(this, entity, dest);

            }
        }
        entity.resetFallDistance();


        //Particles
        Vec3 start = entity.getEyePosition();
        Vec3 end = dest;
        Vec3 rayVector = end.subtract(start);
        Vec3 forward = rayVector.normalize();

        Vec3 up = new Vec3(0, 1, 0);
        if (forward.dot(up) > 0.999) {
            up = new Vec3(1, 0, 0);
        }

        int trailParticles = 15;
        double speed = rayVector.length() / 12.0 * 0.75;

        for (int i = 0; i < trailParticles; ++i) {
            Vec3 particleStart = start.add(Utils.getRandomVec3(1.0));
            Vec3 particleEnd = particleStart.add(rayVector);
            MagicManager.spawnParticles(level,
                    new TraceParticleOptions(Utils.v3f(particleEnd), new Vector3f(0.34F, 0.23F, 0.5F)), particleStart.x, particleStart.y, particleStart.z, 1, 0, 0, 0, speed, false);
        }

        // Daggers
        int daggerCount = Math.min(1 + (spellLevel - 1) * 2, 5);
        float totalSpread = 30f;
        float step = daggerCount > 1 ? totalSpread / (daggerCount - 1) : 0;
        float startAngle = -totalSpread / 2f;
        for (int i = 0; i < daggerCount; i++) {
            float angleOffset = startAngle + (step * i);
            Vec3 look = entity.getLookAngle();
            Vec3 spreadLook = look.yRot(angleOffset * Mth.DEG_TO_RAD);
            ShadowDagger dagger = new ShadowDagger(level, entity);
            dagger.setPos(entity.position().add(0.0, entity.getEyeHeight() - dagger.getBoundingBox().getYsize() * 0.5, 0.0));
            dagger.shoot(spreadLook);
            dagger.setPierceLevel(2);
            dagger.setDamage(this.getDamage(spellLevel, entity));
            level.addFreshEntity(dagger);
        }

        super.onCast(level, spellLevel, entity, castSource, playerMagicData);
    }

    private float getDistance(int spellLevel, LivingEntity sourceEntity) {
        return (float) (Utils.softCapFormula(getEntityPowerMultiplier(sourceEntity)) * (getSpellPower(spellLevel, null) * 0.25));
    }

    private float getDamage(int spellLevel, LivingEntity entity) {
        return this.getSpellPower(spellLevel, entity) * 0.3F;
    }

    public SpellDamageSource getDamageSource(@Nullable Entity projectile, Entity attacker) {
        return super.getDamageSource(projectile, attacker).setIFrames(0);
    }

    public AnimationHolder getCastStartAnimation() {
        return SpellAnimations.SLASH_ANIMATION;
    }
}
