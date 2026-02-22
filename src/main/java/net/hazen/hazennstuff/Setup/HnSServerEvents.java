package net.hazen.hazennstuff.Setup;

import io.redspace.ironsspellbooks.api.config.IronConfigParameters;
import io.redspace.ironsspellbooks.api.config.ModifyDefaultConfigValuesEvent;
import io.redspace.ironsspellbooks.api.events.SpellPreCastEvent;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.damage.DamageSources;
import io.redspace.ironsspellbooks.spells.ender.BlackHoleSpell;
import net.hazen.hazennstuff.Registries.HnSDamageTypes;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.hazen.hazennstuff.Registries.HnSSchoolRegistry;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;


@EventBusSubscriber
public class HnSServerEvents {

    @SubscribeEvent
    public static void onPlayerCastEvent(SpellPreCastEvent event)
    {
        var entity = event.getEntity();
        var spell = SpellRegistry.getSpell(event.getSpellId());

        // Hexed
        boolean hasHexedEffect = entity.hasEffect(HnSEffects.HEXED);
        if (entity instanceof ServerPlayer player && !player.level().isClientSide())
        {
            if (hasHexedEffect)
            {
                // Damage
                float damage = 1.0F;
                DamageSource damageSource = new DamageSource(
                        DamageSources.getHolderFromResource(entity,
                                HnSDamageTypes.CORRUPT_MAGIC
                        )
                );
                entity.hurt(damageSource, damage);

                player.level().playSound(
                        null, player.getX(), player.getY(), player.getZ(),
                        HnSSounds.BRIMSTONE_HELLBLAST_IMPACT, SoundSource.PLAYERS, 0.5f, 1f
                );
            }
        }

    }


    /*
    *** Changing Spell Schools *****************************************************************************************
     */
//    @SubscribeEvent
//    public static void modifyBlackholeSchool (ModifyDefaultConfigValuesEvent event) {
//        if(event.getSpell() instanceof BlackHoleSpell) {
//            event.setDefaultValue(IronConfigParameters.SCHOOL, HnSSchoolRegistry.COSMIC.get());
//        }
//    }
}