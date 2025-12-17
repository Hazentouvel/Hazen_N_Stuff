package net.hazen.hazennstuff.Spells.Schools.Radiance;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.damage.SpellDamageSource;
import net.hazen.hazennstuff.Entity.Spells.Radiance.Syringe.Syringe;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.HnSSchoolRegistry;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

@AutoSpellConfig
public class SyringeBarrageSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "syringe_barrage");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getDamage(spellLevel, caster), 2))
        );
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.COMMON)
            .setSchoolResource(HnSSchoolRegistry.RADIANCE_RESOURCE)
            .setMaxLevel(10)
            .setCooldownSeconds(2)
            .build();

    public SyringeBarrageSpell() {
        this.manaCostPerLevel = 3;
        this.baseSpellPower = 12;
        this.spellPowerPerLevel = 1;
        this.castTime = 0;
        this.baseManaCost = 40;
    }

    @Override
    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of(HnSSounds.SYRINGE_BARRAGE_CAST.get());
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
    public void onCast(Level world, int spellLevel, LivingEntity caster,
                       CastSource castSource, MagicData playerMagicData) {
        if (world.isClientSide) return;

        int count = 3;
        int delayBetween = 3;

        Vec3 look = caster.getLookAngle();
        Vec3 castPos = caster.position().add(0, caster.getEyeHeight() - 0.8, 0);

        for (int i = 0; i < count; i++) {
            Syringe syringe = new Syringe(world, caster);
            syringe.setDelay(i * delayBetween);
            syringe.setDamage(getDamage(spellLevel, caster));
            syringe.setSpawnPos(castPos);
            syringe.shoot(look);
            world.addFreshEntity(syringe);
        }

        super.onCast(world, spellLevel, caster, castSource, playerMagicData);
    }


    public SpellDamageSource getDamageSource(@Nullable Entity projectile, Entity attacker) {
        return super.getDamageSource(projectile, attacker).setIFrames(0);
    }

    private float getDamage(int spellLevel, LivingEntity entity) {
        return getSpellPower(spellLevel, entity) * .3f;
    }
}