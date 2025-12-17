package net.hazen.hazennstuff.Spells.Schools.Nature;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.*;
import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.hazen.hazennstuff.Entity.Spells.Nature.DeathSentence.DeathSentence;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Optional;

@AutoSpellConfig
public class DeathSentenceSpell extends AbstractSpell {
    private final ResourceLocation spellId = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "death_sentence");

    public List<MutableComponent> getUniqueInfo(int spellLevel, LivingEntity caster) {
        return List.of(Component.translatable("ui.irons_spellbooks.damage", new Object[]{Utils.stringTruncation((double)this.getDamage(spellLevel, caster), 2)}), Component.translatable("ui.irons_spellbooks.radius", new Object[]{Utils.stringTruncation((double)this.getRadius(spellLevel, caster), 2)}));
    }

    private final DefaultConfig defaultConfig = new DefaultConfig()
            .setMinRarity(SpellRarity.COMMON)
            .setSchoolResource(SchoolRegistry.NATURE_RESOURCE)
            .setMaxLevel(5)
            .setCooldownSeconds(15)
            .build();

    public DeathSentenceSpell() {
        this.manaCostPerLevel = 15;
        this.baseSpellPower = 5;
        this.spellPowerPerLevel = 2;
        this.castTime = 10;
        this.baseManaCost = 30;
    }

    public CastType getCastType() {
        return CastType.LONG;
    }

    public DefaultConfig getDefaultConfig() {
        return this.defaultConfig;
    }

    public ResourceLocation getSpellResource() {
        return this.spellId;
    }

    public Optional<SoundEvent> getCastStartSound() {
        return Optional.of((SoundEvent)SoundRegistry.FIREFLY_SPELL_PREPARE.get());
    }

    @Override
    public void onCast(Level level, int spellLevel, LivingEntity caster, CastSource castSource, MagicData magicData) {
        if (level.isClientSide)
            return;

        // Launch player upward/forward
//        Vec3 look = caster.getLookAngle();
//        double verticalPower = 0.8;
//        double forwardPower = 1.2;
//
//        Vec3 launch = new Vec3(
//                look.x * forwardPower,
//                verticalPower,
//                look.z * forwardPower
//        );
//
//        caster.setDeltaMovement(launch);
//        caster.hasImpulse = true;
//        caster.hurtMarked = true;

        if (level instanceof ServerLevel serverLevel) {
            fireProjectiles(serverLevel, caster, spellLevel);
        }
    }

    private void fireProjectiles(ServerLevel level, LivingEntity caster, int spellLevel) {
        int count = 8;
        double radius = 1.2;

        for (int i = 0; i < count; i++) {
            double angle = Math.toRadians((360.0 / count) * i);
            Vec3 dir = new Vec3(Math.cos(angle), 0, Math.sin(angle)).normalize().scale(radius);

            DeathSentence projectile = new DeathSentence(level, caster);
            projectile.setPos(caster.getX(), caster.getY() + 1.0, caster.getZ());
            projectile.setYRot((float) Math.toDegrees(angle));
            projectile.setDeltaMovement(dir);
            projectile.setDamage(getDamage(spellLevel, caster));

            level.addFreshEntity(projectile);
        }
    }




    public float getRadius(int spellLevel, LivingEntity caster) {
        return 6.0F + spellLevel * 0.75F;
    }

    public int getDuration(int spellLevel, LivingEntity caster) {
        return (int) (getSpellPower(spellLevel, caster) * 20.0F);
    }

    public float getDamage(int spellLevel, LivingEntity caster) {
        return 5.0F + getSpellPower(spellLevel, caster) * 0.6F;
    }

    @Override
    public AnimationHolder getCastStartAnimation() {
        return SpellAnimations.CHARGE_RAISED_HAND;
    }

    @Override
    public AnimationHolder getCastFinishAnimation() {
        return SpellAnimations.TOUCH_GROUND_ANIMATION;
    }
}
