package net.hazen.hazennstuff.Spells.Schools.Hydro;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.damage.SpellDamageSource;
import net.acetheeldritchking.aces_spell_utils.registries.ASSchoolRegistry;
import net.hazen.hazennstuff.Entity.Spells.Hydro.RazorbladeTyphoon.RazorbladeTyphoon;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.hazen.hazennstuff.Spells.AbstractSpells.AbstractHydroSpell;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RazorbladeTyphoonSpell extends AbstractHydroSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath("hazennstuff", "razorblade_typhoon");
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

    public RazorbladeTyphoonSpell() {
        this.defaultConfig = (
                new DefaultConfig())
                .setMinRarity(SpellRarity.UNCOMMON)
                .setSchoolResource(ASSchoolRegistry.HYDRO_RESOURCE)
                .setMaxLevel(10)
                .setCooldownSeconds((double)2.5F)
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

    @Override
    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of(HnSSounds.RAZORBLADE_TYPHOON_CAST.get());
    }

    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        RazorbladeTyphoon razorbladeTyphoon = new RazorbladeTyphoon(world, entity);
        razorbladeTyphoon.setPos(entity.position().add((double)0.0F, (double)entity.getEyeHeight() - razorbladeTyphoon.getBoundingBox().getYsize() * (double)0.5F, (double)0.0F));
        razorbladeTyphoon.shoot(entity.getLookAngle());
        razorbladeTyphoon.setDamage(this.getDamage(spellLevel, entity));
        world.addFreshEntity(razorbladeTyphoon);
        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }

    public SpellDamageSource getDamageSource(@Nullable Entity projectile, Entity attacker) {
        return super.getDamageSource(projectile, attacker)
                .setIFrames(3)
                ;
    }

    private float getDamage(int spellLevel, LivingEntity entity) {
        return this.getSpellPower(spellLevel, entity) * 0.5F;
    }
}
