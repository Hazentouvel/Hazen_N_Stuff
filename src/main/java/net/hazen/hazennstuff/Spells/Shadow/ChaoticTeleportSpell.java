package net.hazen.hazennstuff.Spells.Shadow;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.spells.ender.TeleportSpell;
import net.hazen.hazennstuff.Registries.HnSParticleHelper;
import net.hazen.hazennstuff.Registries.HnSSchoolRegistry;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

@AutoSpellConfig
public class ChaoticTeleportSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath("hazennstuff", "chaotic_teleport");
    private final DefaultConfig defaultConfig;

    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.irons_spellbooks.distance", new Object[]{Utils.stringTruncation((double)this.getDistance(spellLevel, caster), 1)}));
    }

    public ChaoticTeleportSpell() {
        this.defaultConfig = (new DefaultConfig())
                .setMinRarity(SpellRarity.UNCOMMON)
                .setSchoolResource(HnSSchoolRegistry.SHADOW_RESOURCE)
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
        return Optional.of(HnSSounds.CHAOTIC_TELEPORT.get());
    }

    public void onClientPreCast(Level level, int spellLevel, LivingEntity entity, InteractionHand hand, @Nullable MagicData playerMagicData) {
        super.onClientPreCast(level, spellLevel, entity, hand, playerMagicData);
        Vec3 forward = entity.getForward().normalize();

        for(int i = 0; i < 35; ++i) {
            Vec3 motion = forward.scale(Utils.random.nextDouble() * (double)0.25F);
            level.addParticle(HnSParticleHelper.ROD_OF_DISCORD_PARTICLE, entity.getRandomX((double)0.4F), entity.getRandomY(), entity.getRandomZ((double)0.4F), motion.x, motion.y, motion.z);
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

        entity.resetFallDistance();
        level.playSound((Player)null, dest.x, dest.y, dest.z, (SoundEvent)this.getCastFinishSound().get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
        super.onCast(level, spellLevel, entity, castSource, playerMagicData);
    }

    private float getDistance(int spellLevel, LivingEntity sourceEntity) {
        return (float)(Utils.softCapFormula((double)this.getEntityPowerMultiplier(sourceEntity)) * (double)this.getSpellPower(spellLevel, (Entity)null));
    }

    public AnimationHolder getCastStartAnimation() {
        return AnimationHolder.none();
    }
}
