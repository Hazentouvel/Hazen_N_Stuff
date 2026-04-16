package net.hazen.hazennstuff.Setup;

import io.redspace.ironsspellbooks.api.config.ModifyDefaultConfigValuesEvent;
import io.redspace.ironsspellbooks.api.config.SpellConfigParameter;
import io.redspace.ironsspellbooks.api.events.SpellPreCastEvent;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.entity.mobs.abstract_spell_casting_mob.AbstractSpellCastingMob;
import io.redspace.ironsspellbooks.spells.blood.WitherSkullSpell;
import io.redspace.ironsspellbooks.spells.ender.BlackHoleSpell;
import io.redspace.ironsspellbooks.spells.ender.StarfallSpell;
import net.hazen.hazennstuff.Registries.HnSDamageTypes;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.hazen.hazennstuff.Registries.HnSSchoolRegistry;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.EntityTickEvent;


@EventBusSubscriber
public class HnSServerEvents {

    @SubscribeEvent
    public static void onPlayerCastEvent(SpellPreCastEvent event)
    {
        var entity = event.getEntity();

        // Only run on server
        if (entity.level().isClientSide()) return;

        // Hexed check
        if (entity.hasEffect(HnSEffects.HEXED))
        {
            float percentDamage = 0.25F;

            float maxHealth = entity.getMaxHealth();
            float damage = Math.max(1.0F, maxHealth * percentDamage);

            DamageSource damageSource = new DamageSource(DamageSources.getHolderFromResource(entity, HnSDamageTypes.CORRUPT_MAGIC));

            entity.hurt(damageSource, damage);

            // Only play sound if it's a player (optional)
            if (entity instanceof ServerPlayer player) {
                player.level().playSound(
                        null, player.getX(), player.getY(), player.getZ(),
                        HnSSounds.BRIMSTONE_HELLBLAST_IMPACT,
                        SoundSource.PLAYERS, 0.5f, 1f
                );
            }
        }
    }


    @SubscribeEvent
    public static void onSpellcasterMobTick(EntityTickEvent.Post event) {
        if (!(event.getEntity() instanceof AbstractSpellCastingMob mob)) {
            return;
        }

        if (mob.level().isClientSide()) {
            return;
        }

        if (!mob.isCasting()) {
            return;
        }

        // Run only once near the start of the cast
        if (mob.getMagicData().getCastDurationRemaining()
                != mob.getMagicData().getCastDuration()) {
            return;
        }

        if (mob.hasEffect(HnSEffects.HEXED)) {
            float damage = Math.max(1.0F, mob.getMaxHealth() * 0.25F);

            DamageSource damageSource = new DamageSource(
                    DamageSources.getHolderFromResource(mob, HnSDamageTypes.CORRUPT_MAGIC)
            );

            mob.hurt(damageSource, damage);

            mob.level().playSound(
                    null,
                    mob.getX(),
                    mob.getY(),
                    mob.getZ(),
                    HnSSounds.BRIMSTONE_HELLBLAST_IMPACT,
                    SoundSource.HOSTILE,
                    0.5f,
                    1.0f
            );
        }
    }


    /*
    *** Changing Spell Schools *****************************************************************************************
     */

    @SubscribeEvent
    public static void modifySpellSchool(ModifyDefaultConfigValuesEvent event) {
        if(event.getSpell() instanceof BlackHoleSpell) {
            event.setDefaultValue(SpellConfigParameter.SCHOOL, HnSSchoolRegistry.COSMIC.get());
        }

        if(event.getSpell() instanceof StarfallSpell) {
            event.setDefaultValue(SpellConfigParameter.SCHOOL, HnSSchoolRegistry.COSMIC.get());
        }

        if(event.getSpell() instanceof WitherSkullSpell) {
            event.setDefaultValue(SpellConfigParameter.SCHOOL, HnSSchoolRegistry.SHADOW.get());
        }
    }
}