package net.hazen.hazennstuff.spells.fire;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.entity.spells.brimstone_hellblast.BrimstoneHellblast;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Optional;

@AutoSpellConfig
public class BrimstoneHellblastSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "brimstone_hellblast");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getDamage(spellLevel, caster), 2)),
                Component.translatable("ui.irons_spellbooks.radius", getRadius(spellLevel, caster))
        );
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.LEGENDARY)
            .setSchoolResource(SchoolRegistry.FIRE_RESOURCE)
            .setMaxLevel(5)
            .setCooldownSeconds(25)
            .build();

    public BrimstoneHellblastSpell() {
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

    @Override
    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of(SoundRegistry.FIREBALL_START.get());
    }

    @Override
    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        Vec3 origin = entity.getEyePosition();

        BrimstoneHellblast brimstoneHellblast = new BrimstoneHellblast(world, entity);

        brimstoneHellblast.setDamage(getDamage(spellLevel, entity));

        brimstoneHellblast.setPos(origin.add(entity.getForward()).subtract(0, brimstoneHellblast.getBbHeight() / 2, 0));
        brimstoneHellblast.shoot(entity.getLookAngle());

        world.addFreshEntity(brimstoneHellblast);
        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }


    public float getDamage(int spellLevel, LivingEntity caster) {
        if (caster == null) {
            return (float) getSpellPower(spellLevel, null) * 7;
        }

        double firePower = caster.getAttributeValue(AttributeRegistry.FIRE_SPELL_POWER);
        double bloodPower = caster.getAttributeValue(AttributeRegistry.BLOOD_SPELL_POWER);
        double generalPower = caster.getAttributeValue(AttributeRegistry.SPELL_POWER);

        float damage = 8 + 5 * (float)(firePower + bloodPower + generalPower);
        return damage;
    }

    //public float getDamage(int spellLevel, LivingEntity caster) {
        //return 5 + 5 * getSpellPower(spellLevel, caster);
    //}

    public int getRadius(int spellLevel, LivingEntity caster) {
        return 2 + (int) getSpellPower(spellLevel, caster);
    }
}