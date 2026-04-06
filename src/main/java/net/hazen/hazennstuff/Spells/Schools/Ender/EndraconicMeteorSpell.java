package net.hazen.hazennstuff.Spells.Schools.Ender;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import net.hazen.hazennstuff.Animations.HnSSpellAnimations;
import net.hazen.hazennstuff.Entity.Spells.Ender.EndraconicMeteor.EndraconicMeteor;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.hazen.hazennstuff.Spells.AbstractSpells.AbstractCalamitasSpell;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Optional;

public class EndraconicMeteorSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "endraconic_meteor");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getDamage(spellLevel, caster), 2)),
                Component.translatable("ui.irons_spellbooks.radius", getRadius(spellLevel, caster))
        );
    }

    public boolean allowLooting() {
        return false;
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.EPIC)
            .setSchoolResource(SchoolRegistry.ENDER_RESOURCE)
            .setMaxLevel(5)
            .setCooldownSeconds(25)
            .build();

    public EndraconicMeteorSpell() {
        this.manaCostPerLevel = 15;
        this.baseSpellPower = 1;
        this.spellPowerPerLevel = 1;
        this.castTime = 30;
        this.baseManaCost = 60;
    }

    @Override
    public CastType getCastType() {
        return CastType.LONG;
    }

    @Override
    public DefaultConfig getDefaultConfig() {
        return defaultConfig;
    }

    @Override
    public ResourceLocation getSpellResource() {
        return spellId;
    }

    public AnimationHolder getCastStartAnimation() {
        return SpellAnimations.CHARGE_ANIMATION;
    }

    public AnimationHolder getCastFinishAnimation() {
        return SpellAnimations.FINISH_ANIMATION;
    }

    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of(HnSSounds.ENDRACONIC_METEOR_CHARGING.get());
    }

    @Override
    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        if (world.isClientSide) return;

        Vec3 look = entity.getLookAngle().normalize();

        int count = 3;
        double arcAngle = Math.toRadians(45);
        double radius = 1.2;
        double heightAboveHead = 4.0;
        int baseDelay = 20;
        int delayBetween = 6;

        Vec3 forward = entity.getLookAngle().normalize();
        Vec3 up = new Vec3(0, 1, 0);
        Vec3 right = forward.cross(up).normalize();
        up = right.cross(forward).normalize();

        Vec3 arcCenter = entity.position()
                .add(0, entity.getEyeHeight() + heightAboveHead, 0)
                .add(forward.scale(0.5));

        Vec3 targetPoint = entity.getEyePosition().add(look.scale(60.0));

        for (int i = 0; i < count; i++) {
            double t = (double) i / (count - 1 == 0 ? 1 : (count - 1));
            double angle = -arcAngle / 2 + t * arcAngle;

            Vec3 offset = right.scale(Math.sin(angle) * radius)
                    .add(up.scale(Math.cos(angle) * radius * 0.7));

            Vec3 spawnPos = arcCenter.add(offset);

            EndraconicMeteor meteor = new EndraconicMeteor(world, entity);
            meteor.setOwner(entity);
            meteor.setDamage(getDamage(spellLevel, entity));
            meteor.setExplosionRadius((float) this.getRadius(spellLevel, entity));

            meteor.setPos(spawnPos);
            meteor.setDeltaMovement(0, 0, 0);

            // Have the meteor "follow" or hold above the player before firing.
            meteor.ownerTrack = spawnPos.subtract(entity.position());
            meteor.delay = baseDelay + i * delayBetween;

            // Compute the launch direction toward the point the player is looking at
            Vec3 launchDir = targetPoint.subtract(spawnPos).normalize();
            meteor.launchDir = launchDir;

            world.addFreshEntity(meteor);
        }

        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }


    public float getDamage(int spellLevel, LivingEntity caster) {
        return 5.0F + 5.0F * this.getSpellPower(spellLevel, caster);
    }

    public int getRadius(int spellLevel, LivingEntity caster) {
        return 2 + (int) getSpellPower(spellLevel, caster);
    }
}
