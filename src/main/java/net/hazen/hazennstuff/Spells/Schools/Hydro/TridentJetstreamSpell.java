package net.hazen.hazennstuff.Spells.Schools.Hydro;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.damage.SpellDamageSource;

import java.util.List;
import java.util.Optional;

import net.acetheeldritchking.aces_spell_utils.registries.ASSchoolRegistry;
import net.hazen.hazennstuff.Entity.Spells.Hydro.TridentBarrage.TridentJetstream;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class TridentJetstreamSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath("hazennstuff", "trident_jetstream");
    private final DefaultConfig defaultConfig;

    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.irons_spellbooks.damage", new Object[]{Utils.stringTruncation((double)this.getDamage(spellLevel, caster), 2)}));
    }

    public TridentJetstreamSpell() {
        this.defaultConfig = (new DefaultConfig())
                .setMinRarity(SpellRarity.RARE)
                .setSchoolResource(ASSchoolRegistry.HYDRO_RESOURCE)
                .setMaxLevel(10)
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
        return Optional.of(HnSSounds.TRIDENT_JETSTREAM_CAST.get());
    }

    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.empty();
    }

    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }

    public void onServerCastTick(Level level, int spellLevel, LivingEntity entity, @Nullable MagicData playerMagicData) {
        if (playerMagicData != null && (playerMagicData.getCastDurationRemaining() + 1) % 5 == 0) {
            this.shootBlazeFireball(level, spellLevel, entity);
        }

    }

    private float getDamage(int spellLevel, LivingEntity caster) {
        return this.getSpellPower(spellLevel, caster) * 0.4F;
    }

    public void shootBlazeFireball(Level world, int spellLevel, LivingEntity entity) {
        Vec3 origin = entity.getEyePosition().add(entity.getForward().normalize().scale((double)0.4F));
        TridentJetstream tridentJetstream = new TridentJetstream(world, entity);
        tridentJetstream.setPos(origin.subtract((double)0.0F, (double) tridentJetstream.getBbHeight(), (double)0.0F));
        tridentJetstream.shoot(entity.getLookAngle());
        tridentJetstream.setDamage(this.getDamage(spellLevel, entity));
        world.playSound((Player)null, origin.x, origin.y, origin.z, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 2.0F, 1.0F);
        world.addFreshEntity(tridentJetstream);
    }

    public SpellDamageSource getDamageSource(@Nullable Entity projectile, Entity attacker) {
        return super.getDamageSource(projectile, attacker)
                .setIFrames(0);
    }
}
