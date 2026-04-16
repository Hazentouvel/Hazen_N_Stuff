package net.hazen.hazennstuff.Spells.Schools.Fire;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import io.redspace.ironsspellbooks.spells.ender.TeleportSpell;
import io.redspace.ironsspellbooks.util.ParticleHelper;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CinderousStepSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "cinderous_step");

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.UNCOMMON)
            .setSchoolResource(SchoolRegistry.FIRE_RESOURCE)
            .setMaxLevel(5)
            .setCooldownSeconds(12)
            .build();

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        var li = new ArrayList<>(super.getUniqueInfo(spellLevel, caster));


        li.addFirst(Component.literal("\u2999 - Hazen 'n Stuff - \u2999")
                .withStyle(ChatFormatting.GOLD)
                .withStyle(ChatFormatting.BOLD)
        );

        li.addAll(List.of(

                Component.translatable("ui.irons_spellbooks.distance", getDistance(spellLevel, caster)),

                Component.translatable("attribute.modifier.plus.1",
                        Utils.stringTruncation(this.getFlameKissed(spellLevel, caster), 0),
                        Component.translatable("attribute.irons_spellbooks.fire_spell_power")),

                Component.translatable("attribute.modifier.plus.1",
                        Utils.stringTruncation(this.getFlameKissed(spellLevel, caster), 0),
                        Component.translatable("apotheosis:fire_damage"))

        ));

        return li;
    }

    public CinderousStepSpell() {
        this.baseSpellPower = 12;
        this.spellPowerPerLevel = 4;
        this.baseManaCost = 30;
        this.manaCostPerLevel = 10;
        this.castTime = 0;
    }

    @Override
    public CastType getCastType() {
        return CastType.INSTANT;
    }

    @Override
    public DefaultConfig getDefaultConfig() {
        return defaultConfig;
    }

    @Override
    public ResourceLocation getSpellResource() {
        return spellId;
    }

    @Override
    public Optional<SoundEvent> getCastStartSound() {
        return Optional.empty();
    }

    @Override
    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of(SoundRegistry.FIRE_CAST.get());
    }

    @Override
    public void onClientPreCast(Level level, int spellLevel, LivingEntity entity, InteractionHand hand, @Nullable MagicData playerMagicData) {
        super.onClientPreCast(level, spellLevel, entity, hand, playerMagicData);
        Vec3 forward = entity.getForward().normalize();
        for (int i = 0; i < 35; i++) {
            Vec3 motion = forward.scale(Utils.random.nextDouble() * .25f);
            level.addParticle(ParticleHelper.FIERY_SMOKE, entity.getRandomX(.4f), entity.getRandomY(), entity.getRandomZ(.4f), motion.x, motion.y, motion.z);
        }
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
                //dest = target.position().subtract(new Vec3(0, 0, 1.5).yRot(target.getYRot()));
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
        level.playSound(null, dest.x, dest.y, dest.z, getCastFinishSound().get(), SoundSource.NEUTRAL, 1f, 1f);

        entity.addEffect(new MobEffectInstance(HnSEffects.FLAME_KISSED, (int)(this.getSpellPower(spellLevel, entity) * 20.0F), spellLevel - 1, false, false, true));

        super.onCast(level, spellLevel, entity, castSource, playerMagicData);
    }

    private float getDistance(int spellLevel, LivingEntity sourceEntity) {
        return (float) (Utils.softCapFormula(getEntityPowerMultiplier(sourceEntity)) * getSpellPower(spellLevel, null));
    }

    private float getFlameKissed(int spellLevel, LivingEntity entity) {
        return (float)spellLevel * 0.03F * 100.0F;
    }

    @Override
    public AnimationHolder getCastStartAnimation() {
        return AnimationHolder.none();
    }

}