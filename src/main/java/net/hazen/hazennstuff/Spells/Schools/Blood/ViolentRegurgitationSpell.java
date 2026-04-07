package net.hazen.hazennstuff.Spells.Schools.Blood;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.CastSource;
import io.redspace.ironsspellbooks.api.spells.CastType;
import io.redspace.ironsspellbooks.api.spells.SpellRarity;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import net.hazen.hazennstuff.Animations.HnSSpellAnimations;
import net.hazen.hazennstuff.Entity.Spells.Blood.ViolentRegurgitation.FleshChunk.FleshChunk;
import net.hazen.hazennstuff.Entity.Spells.Blood.ViolentRegurgitation.FleshPiece.FleshPiece;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.hazen.hazennstuff.Spells.AbstractSpells.AbstractCalamitasSpell;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Optional;

public class ViolentRegurgitationSpell extends AbstractCalamitasSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "violent_regurgitation");

    @Override
    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(
                Component.translatable("ui.irons_spellbooks.damage", Utils.stringTruncation(getDamage(spellLevel, caster), 2))
        );
    }

    public boolean allowLooting() {
        return false;
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.EPIC)
            .setSchoolResource(SchoolRegistry.BLOOD_RESOURCE)
            .setMaxLevel(5)
            .setCooldownSeconds(25)
            .build();

    public ViolentRegurgitationSpell() {
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
    public AnimationHolder getCastStartAnimation() {
        return HnSSpellAnimations.VIOLENT_REGURGITATION_CHARGING;
    }

    @Override
    public AnimationHolder getCastFinishAnimation() {
        return HnSSpellAnimations.VIOLENT_REGURGITATION_CAST;
    }

    @Override
    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of(HnSSounds.VIOLENT_REGURGITATION_CHARGING.get());
    }

    public Optional<SoundEvent> getCastFinishSound() {
        return Optional.of(HnSSounds.VIOLENT_REGURGITATION_CAST.get());
    }


    @Override
    public void onCast(Level world, int spellLevel, LivingEntity entity, CastSource castSource, MagicData playerMagicData) {
        Vec3 origin = entity.getEyePosition();

        FleshChunk fleshChunk = new FleshChunk(world, entity);

        fleshChunk.setDamage(getDamage(spellLevel, entity));

        fleshChunk.setPos(origin.add(entity.getForward()).subtract(0, fleshChunk.getBbHeight() / 2, 0));
        fleshChunk.shoot(entity.getLookAngle());

        if (!world.isClientSide) {
            world.addFreshEntity(fleshChunk);
        }

        int pieces = 4 + Utils.random.nextInt(8);
        double forwardOffset = 0.5D;
        double spawnRadius = 0.8D;
        double spread = 0.6D;

        for (int i = 0; i < pieces; i++) {
            FleshPiece piece = new FleshPiece(world, entity);
            piece.setDamage(getDamage(spellLevel, entity));

            Vec3 base = origin.add(entity.getForward().scale(forwardOffset));
            Vec3 rand = Utils.getRandomVec3(spawnRadius);
            Vec3 spawnPos = base.add(rand);
            piece.setPos(spawnPos);

            Vec3 dir = entity.getLookAngle().add(Utils.getRandomVec3(spread)).normalize();
            piece.shoot(dir);

            if (!world.isClientSide) {
                world.addFreshEntity(piece);
            }
        }

        super.onCast(world, spellLevel, entity, castSource, playerMagicData);
    }


    public float getDamage(int spellLevel, LivingEntity caster) {
        return 5.0F + 5.0F * this.getSpellPower(spellLevel, caster);
    }
}