package net.hazen.hazennstuff.spells.radiance;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.damage.SpellDamageSource;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.entity.spells.lightning.spark.EnergyBurst;
import net.hazen.hazennstuff.entity.spells.radiance.syringe.Syringe;
import net.hazen.hazennstuff.registries.HnSSchoolRegistry;
import net.hazen.hazennstuff.registries.HnSSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

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
    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        Timer timer = new Timer();

        int delayBetweenBolts = 150;

        for (int i = 0; i < 3; i++) {
            int delay = i * delayBetweenBolts;
            timer.schedule(new TimerTask() {
                public void run() {
                    Syringe syringe = new Syringe(world, entity);
                    syringe.setPos(entity.position().add(0, entity.getEyeHeight() - syringe.getBoundingBox().getYsize() * 0.5f, 0));
                    syringe.shoot(entity.getLookAngle());
                    syringe.setDamage(getDamage(spellLevel, entity));
                    world.addFreshEntity(syringe);
                }
            }, delay);
        }

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timer.cancel();
            }
        }, 3 * delayBetweenBolts);

        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }

    public SpellDamageSource getDamageSource(@Nullable Entity projectile, Entity attacker) {
        return super.getDamageSource(projectile, attacker).setIFrames(0);
    }

    private float getDamage(int spellLevel, LivingEntity entity) {
        return getSpellPower(spellLevel, entity) * .3f;
    }
}