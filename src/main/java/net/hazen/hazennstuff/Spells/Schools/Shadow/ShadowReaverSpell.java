package net.hazen.hazennstuff.Spells.Schools.Shadow;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.api.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.hazen.hazennstuff.Entity.Spells.Shadow.ShadowReaver.ShadowReaver;
import net.hazen.hazentouvelib.Registries.HLSchoolRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class ShadowReaverSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath("hazennstuff", "shadow_reaver");
    private final DefaultConfig defaultConfig;

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        var li = new ArrayList<>(super.getUniqueInfo(spellLevel, caster));


        li.addFirst(Component.literal("\u2999 - Hazen 'n Stuff - \u2999")
                .withStyle(ChatFormatting.GOLD)
                .withStyle(ChatFormatting.BOLD)
        );

        li.add(Component.translatable("ui.irons_spellbooks.damage", new Object[]{Utils.stringTruncation((double)this.getDamage(spellLevel, caster), 2)}));

        return li;
    }

    public ShadowReaverSpell() {
        this.defaultConfig = (
                new DefaultConfig())
                .setMinRarity(SpellRarity.EPIC)
                .setSchoolResource(HLSchoolRegistry.SHADOW_RESOURCE)
                .setMaxLevel(6)
                .setCooldownSeconds((double)4F)
                .build();
        this.manaCostPerLevel = 15;
        this.baseSpellPower = 1;
        this.spellPowerPerLevel = 1;
        this.castTime = 40;
        this.baseManaCost = 60;
    }

    public DefaultConfig getDefaultConfig() {
        return this.defaultConfig;
    }

    public CastType getCastType() {
        return CastType.LONG;
    }

    public ResourceLocation getSpellResource() {
        return this.spellId;
    }

    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of((SoundEvent) SoundRegistry.BLACK_HOLE_CHARGE.get());
    }

    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        ShadowReaver shadowReaver = new ShadowReaver(world, entity);
        shadowReaver.setPos(entity.position().add((double)0.0F, (double)entity.getEyeHeight() - shadowReaver.getBoundingBox().getYsize() * (double)0.5F, (double)0.0F));
        shadowReaver.shoot(entity.getLookAngle());
        shadowReaver.setDamage(this.getDamage(spellLevel, entity));
        world.addFreshEntity(shadowReaver);
        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }

    public float getDamage(int spellLevel, LivingEntity caster) {
        return 5.0F + 5.0F * this.getSpellPower(spellLevel, caster);
    }
}
