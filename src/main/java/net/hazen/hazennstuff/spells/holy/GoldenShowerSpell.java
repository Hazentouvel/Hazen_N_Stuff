package net.hazen.hazennstuff.spells.holy;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import java.util.Timer;
import java.util.TimerTask;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.Utils;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.entity.spells.holy.ichor_stream.IchorStream;
import net.hazen.hazennstuff.entity.spells.lightning.spark.EnergyBurst;
import net.hazen.hazennstuff.registries.HnSSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Optional;
import java.util.TimerTask;

@AutoSpellConfig
public class GoldenShowerSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "golden_shower");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getDamage(spellLevel, caster), 2))
        );
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.RARE)
            .setSchoolResource(SchoolRegistry.HOLY_RESOURCE)
            .setMaxLevel(5)
            .setCooldownSeconds(3)
            .build();

    public GoldenShowerSpell() {
        this.manaCostPerLevel = 6;
        this.baseSpellPower = 20;
        this.spellPowerPerLevel = 1;
        this.castTime = 55;
        this.baseManaCost = 30;
    }

    public int getCastTime(int spellLevel) {
        return this.castTime + 5 * spellLevel;
    }

    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of(HnSSounds.GOLDEN_SHOWER_CAST.get());
    }

    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.empty();
    }


    @Override
    public CastType getCastType() {
        return CastType.CONTINUOUS;
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
                @Override
                public void run() {
                    float spellPower = getSpellPower(spellLevel, entity);
                    IchorStream spark = new IchorStream(world, entity, spellLevel, spellPower);
                    spark.setPos(entity.position().add(0, entity.getEyeHeight() - spark.getBoundingBox().getYsize() * 0.5f, 0));
                    spark.shoot(entity.getLookAngle());
                    world.addFreshEntity(spark);
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


    private float getDamage ( int spellLevel, LivingEntity entity){
        return getSpellPower(spellLevel, entity) * 0.3f;
    }
}