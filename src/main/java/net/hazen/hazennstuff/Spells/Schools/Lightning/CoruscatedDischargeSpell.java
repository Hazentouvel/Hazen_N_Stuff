package net.hazen.hazennstuff.Spells.Schools.Lightning;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.api.spells.SpellAnimations;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import java.util.List;
import java.util.Optional;

import net.hazen.hazennstuff.Entity.Spells.Lightning.CoruscatedDischarge.CoruscatedDischarge;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class CoruscatedDischargeSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "coruscated_discharge");
    private final DefaultConfig defaultConfig;

    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.irons_spellbooks.damage", new Object[]{Utils.stringTruncation((double)this.getDamage(spellLevel, caster), 2)}), Component.translatable("ui.irons_spellbooks.aoe_damage", new Object[]{Utils.stringTruncation((double)this.getAoeDamage(spellLevel, caster), 1)}), Component.translatable("ui.irons_spellbooks.radius", new Object[]{Utils.stringTruncation((double)this.getRadius(spellLevel, caster), 1)}));
    }

    public CoruscatedDischargeSpell() {
        this.defaultConfig = (new DefaultConfig())
                .setMinRarity(SpellRarity.EPIC)
                .setSchoolResource(SchoolRegistry.LIGHTNING_RESOURCE)
                .setMaxLevel(3)
                .setCooldownSeconds((double)12.0F)
                .build();
        this.manaCostPerLevel = 5;
        this.baseSpellPower = 15;
        this.spellPowerPerLevel = 5;
        this.castTime = 50;
        this.baseManaCost = 30;
    }

    public CastType getCastType() {
        return CastType.LONG;
    }

    public DefaultConfig getDefaultConfig() {
        return this.defaultConfig;
    }

    public ResourceLocation getSpellResource() {
        return this.spellId;
    }

    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of((SoundEvent) HnSSounds.CORUSCATED_DISCHARGE_CHARGE.get());
    }

    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of((SoundEvent) HnSSounds.CORUSCATED_DISCHARGE_CAST.get());
    }

    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        CoruscatedDischarge orb = new CoruscatedDischarge(level, entity);
        float radius = this.getRadius(spellLevel, entity);

        orb.setPos(entity.position().add((double)0.0F, (double)entity.getEyeHeight() - orb.getBoundingBox().getYsize() * (double)0.5F, (double)0.0F).add(entity.getForward()));
        orb.shoot(entity.getLookAngle());
        orb.setDeltaMovement(orb.getDeltaMovement().add((double)0.0F, 0.2, (double)0.0F));

        orb.setExplosionRadius(radius);
        orb.setSpellRadius(radius);
        orb.setDamage(this.getDamage(spellLevel, entity));
        level.addFreshEntity(orb);
        super.onCast(level, spellLevel, entity, castSource, playerMagicData);
    }



    public float getRadius(int spellLevel, LivingEntity caster) {
        return 3.0F + this.getEntityPowerMultiplier(caster);
    }

    public float getDamage(int spellLevel, LivingEntity caster) {
        return (float)this.baseSpellPower * this.getEntityPowerMultiplier(caster);
    }

    public float getAoeDamage(int spellLevel, LivingEntity caster) {
        return 6.0F + this.getSpellPower(spellLevel, caster) * 0.1F;
    }

    public AnimationHolder getCastStartAnimation() {
        return SpellAnimations.ANIMATION_CHARGED_CAST;
    }
}
