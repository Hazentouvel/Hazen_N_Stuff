package net.hazen.hazennstuff.Spells.Schools.Radiance;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.network.particles.TeleportParticlesPacket;
import io.redspace.ironsspellbooks.particle.BlastwaveParticleOptions;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import io.redspace.ironsspellbooks.spells.ender.TeleportSpell;
import net.hazen.hazennstuff.Registries.*;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class PrismaticShiftSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath("hazennstuff", "prismatic_shift");
    private final DefaultConfig defaultConfig;

    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.irons_spellbooks.distance", new Object[]{Utils.stringTruncation((double)this.getDistance(spellLevel, caster), 1)}));
    }

    public PrismaticShiftSpell() {
        this.defaultConfig = (new DefaultConfig())
                .setMinRarity(SpellRarity.UNCOMMON)
                .setSchoolResource(HnSSchoolRegistry.RADIANCE_RESOURCE)
                .setMaxLevel(3)
                .setCooldownSeconds((double)3.0F)
                .build();
        this.baseSpellPower = 12;
        this.spellPowerPerLevel = 4;
        this.baseManaCost = 40;
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
        return Optional.of(HnSSounds.TERRARIA_CAST.get());
    }

    public void onClientPreCast(Level level, int spellLevel, LivingEntity entity, InteractionHand hand, @Nullable MagicData playerMagicData) {
        super.onClientPreCast(level, spellLevel, entity, hand, playerMagicData);

        int particleCount = 40;
        double radius = 0.5D;
        double speed = 0.15D;

        Vec3 center = entity.position().add(0, entity.getBbHeight() * 0.1D, 0);

        for (int i = 0; i < particleCount; i++) {
            double angle = 2 * Math.PI * i / particleCount;
            double xOffset = Math.cos(angle) * radius;
            double zOffset = Math.sin(angle) * radius;
            double xMotion = Math.cos(angle) * speed;
            double zMotion = Math.sin(angle) * speed;
            level.addParticle(HnSParticleHelper.ROD_OF_DISCORD_PARTICLE, center.x + xOffset, center.y, center.z + zOffset, xMotion, 0.15, zMotion);
        }
    }

    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {

        Vec3 dest = null;
        TeleportSpell.TeleportData teleportData = (TeleportSpell.TeleportData)playerMagicData.getAdditionalCastData();
        if (teleportData != null) {
            Vec3 potentialTarget = teleportData.getTeleportTargetPosition();
            if (potentialTarget != null) {
                dest = potentialTarget;
                Utils.handleSpellTeleport(this, entity, potentialTarget);
            }
        } else {
            label37: {
                HitResult hitResult = Utils.raycastForEntity(level, entity, this.getDistance(spellLevel, entity), true);
                if (entity.isPassenger()) {
                    entity.stopRiding();
                }

                if (hitResult.getType() == Type.ENTITY) {
                    Entity hitEntity = ((EntityHitResult)hitResult).getEntity();
                    if (hitEntity instanceof LivingEntity target) {

                        for (int j = 0; j < 8; ++j) {
                            dest = target.position().subtract(
                                    new Vec3(0.0F, 0.0F, 1.5F)
                                            .yRot(-(target.getYRot() + (j * 45)) * ((float)Math.PI / 180F))
                            );
                            if (level.getBlockState(BlockPos.containing(dest).above()).isAir()) {
                                break;
                            }
                        }

                        Utils.handleSpellTeleport(this, entity, dest.add(0.0F, 1.0F, 0.0F));
                        entity.lookAt(Anchor.EYES, target.getEyePosition().subtract(0.0F, 0.15, 0.0F));
                        break label37;
                    }
                }

                dest = TeleportSpell.findTeleportLocation(level, entity, this.getDistance(spellLevel, entity));
                Utils.handleSpellTeleport(this, entity, dest);
            }
        }

        this.chaoticTeleportHurt(entity);
        this.chaosState(spellLevel, entity);
        spawnArrivalParticles(level, dest);

        entity.resetFallDistance();
        level.playSound((Player)null, dest.x, dest.y, dest.z, (SoundEvent)this.getCastFinishSound().get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
        super.onCast(level, spellLevel, entity, castSource, playerMagicData);
    }

    public void chaoticTeleportHurt(LivingEntity entity) {
        boolean hasChaosState = entity.hasEffect(HnSEffects.CHAOS_STATE);

        if (entity instanceof ServerPlayer player && !player.level().isClientSide())
        {
            if (hasChaosState)
            {
                float damage = 1.0F;
                DamageSource damageSource = new DamageSource(
                        DamageSources.getHolderFromResource(entity,
                                HnSDamageTypes.CORRUPT_MAGIC
                        )
                );
                entity.hurt(damageSource, damage);

                player.level().playSound(
                        null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.SOUL_ESCAPE, SoundSource.PLAYERS, 1.25f, 1f
                );
            }
        }
    }

    public void chaosState(int spellLevel, LivingEntity entity) {
        boolean hasRodOfHarmonyOn = entity.getMainHandItem().is(HnSItemRegistry.ROD_OF_HARMONY.get());
        boolean hasRodOfHarmonyOff = entity.getOffhandItem().is(HnSItemRegistry.ROD_OF_HARMONY.get());
        boolean hasRodOfHarmony = hasRodOfHarmonyOn || hasRodOfHarmonyOff;

        if (hasRodOfHarmony) {
            if (entity instanceof ServerPlayer serverPlayer && !serverPlayer.level().isClientSide()) {
                if (hasRodOfHarmonyOn) {
                    //entity.addEffect(new MobEffectInstance(MobEffectRegistry.CHARGED, (int)(this.getSpellPower(spellLevel, entity) * 20.0F), spellLevel - 1, false, false, false));
                }
            }
        } else {
            entity.addEffect(new MobEffectInstance(HnSEffects.CHAOS_STATE, 120, 1, false, false, true));
        }
    }

    private void spawnArrivalParticles(Level level, Vec3 dest) {
        if (level.isClientSide()) return;

        MagicManager.spawnParticles(level, new BlastwaveParticleOptions((HnSSpellRegistries.PRISMATIC_SHIFT.get()).getSchoolType().getTargetingColor(), 1.25F), dest.x, dest.y, dest.z, 1, 0.0, 0.0, 0.0, 0.0, true);

        int particleCount = 40;
        double radius = 1.2D;
        double speed = 0.25D;

        for (int i = 0; i < particleCount; i++) {
            double angle = 2 * Math.PI * i / particleCount;

            double xOffset = Math.cos(angle) * radius;
            double zOffset = Math.sin(angle) * radius;

            double spawnX = dest.x + xOffset;
            double spawnY = dest.y + 0.2;
            double spawnZ = dest.z + zOffset;

            double xMotion = -Math.cos(angle) * speed;
            double zMotion = -Math.sin(angle) * speed;

            MagicManager.spawnParticles(level, HnSParticleHelper.ROD_OF_DISCORD_PARTICLE, spawnX, spawnY, spawnZ, 1, xMotion, 0.05D, zMotion, 0.0, true);
        }
    }

    private float getDistance(int spellLevel, LivingEntity sourceEntity) {
        return (float)(Utils.softCapFormula((double)this.getEntityPowerMultiplier(sourceEntity)) * (double)this.getSpellPower(spellLevel, (Entity)null));
    }

    public AnimationHolder getCastStartAnimation() {
        return AnimationHolder.none();
    }
}
