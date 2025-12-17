package net.hazen.hazennstuff.Spells.Schools.Evocation;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.Utils;
import net.hazen.hazennstuff.Entity.Spells.Evocation.SpectralAxe.SpectralAxe;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.HnSSounds;
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
public class SpectralAxeSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "spectral_axe");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getDamage(spellLevel, caster), 2))
        );
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.RARE)
            .setSchoolResource(SchoolRegistry.EVOCATION_RESOURCE)
            .setMaxLevel(8)
            .setCooldownSeconds(3)
            .build();

    public SpectralAxeSpell() {
        this.manaCostPerLevel = 4;
        this.baseSpellPower = 20;
        this.spellPowerPerLevel = 1;
        this.castTime = 0;
        this.baseManaCost = 30;
    }

    @Override
    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of(HnSSounds.TERRABLADE_SLASH.value());
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
    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        Vec3 origin = entity.getEyePosition();

        SpectralAxe spectralAxe = new SpectralAxe(world, entity);

        spectralAxe.setDamage(getDamage(spellLevel, entity));

        spectralAxe.setPos(origin.add(entity.getForward()).subtract(0, spectralAxe.getBbHeight() / 2, 0));
        spectralAxe.shoot(entity.getLookAngle());

        world.addFreshEntity(spectralAxe);
        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }



    private float getDamage(int spellLevel, LivingEntity entity) {
        return getSpellPower(spellLevel, entity) * .3f;
    }
}