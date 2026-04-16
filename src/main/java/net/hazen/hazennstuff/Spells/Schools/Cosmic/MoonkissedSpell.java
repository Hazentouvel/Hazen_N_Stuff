package net.hazen.hazennstuff.Spells.Schools.Cosmic;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.api.spells.SpellAnimations;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;

import java.util.ArrayList;
import java.util.List;

import net.hazen.hazennstuff.Registries.HnSEffects;
import net.hazen.hazennstuff.Registries.HnSSchoolRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class MoonkissedSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath("hazennstuff", "moonkissed");
    private final DefaultConfig defaultConfig;

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        var li = new ArrayList<>(super.getUniqueInfo(spellLevel, caster));


        li.addFirst(Component.literal("\u2999 - Hazen 'n Stuff - \u2999")
                .withStyle(ChatFormatting.GOLD)
                .withStyle(ChatFormatting.BOLD)
        );

        li.addAll(List.of(
                Component.translatable("ui.irons_spellbooks.effect_length",
                        Utils.timeFromTicks(this.getSpellPower(spellLevel, caster) * 20.0F, 1)),

                Component.translatable("attribute.modifier.plus.1",
                        Utils.stringTruncation(this.getPercentSpellPower(spellLevel, caster), 0),
                        Component.translatable("attribute.hazennstuff.cosmic_spell_power")),

                Component.translatable("attribute.modifier.plus.1",
                        Utils.stringTruncation(this.getPercentSpellPower(spellLevel, caster), 0),
                        Component.translatable("attribute.aces_spell_utils.hydro_spell_power")),

                Component.translatable("attribute.modifier.plus.1",
                        Utils.stringTruncation(this.getWaterEfficiency(spellLevel, caster), 0),
                        Component.translatable("attribute.name.generic.water_movement_efficiency")),

                Component.translatable("attribute.modifier.plus.1",
                        Utils.stringTruncation(this.getWaterEfficiency(spellLevel, caster), 0),
                        Component.translatable("attribute.name.player.submerged_mining_speed"))

        ));

        return li;
    }

    public MoonkissedSpell() {
        this.defaultConfig = (new DefaultConfig())
                .setMinRarity(SpellRarity.RARE)
                .setSchoolResource(HnSSchoolRegistry.COSMIC_RESOURCE)
                .setMaxLevel(3)
                .setCooldownSeconds((double)40.0F)
                .build();
        this.manaCostPerLevel = 25;
        this.baseSpellPower = 30;
        this.spellPowerPerLevel = 8;
        this.castTime = 10;
        this.baseManaCost = 50;
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

    public void onCast(Level level, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        entity.addEffect(new MobEffectInstance(HnSEffects.MOONKISSED, (int)(this.getSpellPower(spellLevel, entity) * 20.0F), spellLevel - 1, false, false, true));
        super.onCast(level, spellLevel, entity, castSource, playerMagicData);
    }

    private float getWaterEfficiency(int spellLevel, LivingEntity entity) {
        return (float)spellLevel * 1F * 100.0F;
    }

    private float getPercentSpellPower(int spellLevel, LivingEntity entity) {
        return (float)spellLevel * 0.05F * 100.0F;
    }

    public AnimationHolder getCastStartAnimation() {
        return SpellAnimations.SELF_CAST_ANIMATION;
    }
}
