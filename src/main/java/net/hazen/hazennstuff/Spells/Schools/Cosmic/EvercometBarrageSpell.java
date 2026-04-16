package net.hazen.hazennstuff.Spells.Schools.Cosmic;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.damage.SpellDamageSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import net.hazen.hazennstuff.Entity.Spells.Cosmic.Evercomet.Evercomet;
import net.hazen.hazennstuff.Registries.HnSAttributeRegistry;
import net.hazen.hazennstuff.Registries.HnSSchoolRegistry;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class EvercometBarrageSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath("hazennstuff", "evercomet_barrage");
    private final DefaultConfig defaultConfig;

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        var li = new ArrayList<>(super.getUniqueInfo(spellLevel, caster));


        li.addFirst(Component.literal("Hazen 'n Stuff")
                .withStyle(ChatFormatting.GOLD)
                .withStyle(ChatFormatting.ITALIC)
                .withStyle(ChatFormatting.BOLD)
        );

        li.add(Component.translatable("ui.irons_spellbooks.damage", new Object[]{Utils.stringTruncation((double)this.getDamage(spellLevel, caster), 2)}));

        System.out.println(li.getFirst().toString()+"\n"+ li.getFirst().getStyle());
        return li;
    }

    public EvercometBarrageSpell() {
        this.defaultConfig = (
                new DefaultConfig())
                .setMinRarity(SpellRarity.RARE)
                .setSchoolResource(HnSSchoolRegistry.COSMIC_RESOURCE)
                .setMaxLevel(6)
                .setCooldownSeconds((double)20.0F)
                .build();
        this.manaCostPerLevel = 1;
        this.baseSpellPower = 5;
        this.spellPowerPerLevel = 1;
        this.castTime = 55;
        this.baseManaCost = 5;
    }

    public int getCastTime(int spellLevel) {
        return this.castTime + 5 * spellLevel;
    }

    public CastType getCastType() {
        return CastType.CONTINUOUS;
    }

    public DefaultConfig getDefaultConfig() {
        return this.defaultConfig;
    }

    public ResourceLocation getSpellResource() {
        return this.spellId;
    }

    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of(HnSSounds.EVERCOMET_CAST.get());
    }

    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.empty();
    }

    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }

    public void onServerCastTick(Level level, int spellLevel, LivingEntity entity, @Nullable MagicData playerMagicData) {
        if (playerMagicData != null && (playerMagicData.getCastDurationRemaining() + 1) % 3 == 0) {
            this.shootComet(level, spellLevel, entity);
        }

    }

    public float getDamage(int spellLevel, LivingEntity caster) {
        if (caster == null) {
            return (float) getSpellPower(spellLevel, null) * 7;
        }
        double icePower = caster.getAttributeValue(AttributeRegistry.ICE_SPELL_POWER);
        double cosmicPower = caster.getAttributeValue(HnSAttributeRegistry.COSMIC_SPELL_POWER);
        return (float)(4.0 + 4.0 * getSpellPower(spellLevel, caster) * (0.4 * icePower + 0.4 * cosmicPower));
    }

    public void shootComet(Level world, int spellLevel, LivingEntity entity) {
        Vec3 origin = entity.getEyePosition().add(entity.getForward().normalize().scale((double)0.4F));
        Evercomet everComet = new Evercomet(world, entity);
        everComet.setPos(origin.subtract((double)0.0F, (double) everComet.getBbHeight(), (double)0.0F));
        everComet.shoot(entity.getLookAngle(), 0.05F);
        everComet.setDamage(this.getDamage(spellLevel, entity));
        world.playSound((Player)null, origin.x, origin.y, origin.z, HnSSounds.EVERCOMET_CAST.get(), SoundSource.PLAYERS, 0.5F, 1.0F);
        world.addFreshEntity(everComet);
    }

    public SpellDamageSource getDamageSource(@javax.annotation.Nullable Entity projectile, Entity attacker) {
        return super.getDamageSource(projectile, attacker).setFreezeTicks(80).setIFrames(0);
    }
}
