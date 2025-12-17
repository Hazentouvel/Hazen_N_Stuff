package net.hazen.hazennstuff.Spells.Schools.Eldritch;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.Utils;
import net.hazen.hazennstuff.Entity.Spells.Eldritch.SoulSeeker.SoulSeeker;
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
public class SoulSeekersSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "soul_seekers");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getDamage(spellLevel, caster), 2))
        );
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.LEGENDARY)
            .setSchoolResource(SchoolRegistry.ELDRITCH_RESOURCE)
            .setMaxLevel(5)
            .setCooldownSeconds(15f)
            .build();

    public SoulSeekersSpell() {
        this.manaCostPerLevel = 15;
        this.baseSpellPower = 15;
        this.spellPowerPerLevel = 0;
        this.castTime = 20;
        this.baseManaCost = 90;
    }

    @Override
    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of(HnSSounds.BRIMSTONE_HELLBLAST_CAST.get());
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
        return Optional.of(HnSSounds.BRIMSTONE_CAST.get());
    }



    @Override
    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        if (world.isClientSide)
            return;

        Vec3 look = entity.getLookAngle();
        Vec3 origin = entity.position().add(0, entity.getEyeHeight() - 0.25f, 0);
        float spreadAngle = 10f;

        for (int i = 0; i < 3; i++) {
            SoulSeeker seeker = new SoulSeeker(world, entity);

            double angleOffset = Math.toRadians((i - 1) * spreadAngle);
            Vec3 direction = look.yRot((float) angleOffset);

            seeker.setPos(origin);
            seeker.shoot(direction);
            seeker.setDamage(getDamage(spellLevel, entity));

            world.addFreshEntity(seeker);
        }

        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }




    private float getDamage(int spellLevel, LivingEntity entity) {
        return getSpellPower(spellLevel, entity) * .3f;
    }
}