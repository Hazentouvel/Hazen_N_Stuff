package net.hazen.hazennstuff.HnSUtilities.Spells;

import it.crystalnest.prometheus.api.FireManager;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber
public class HnSDamageSources {

    @SubscribeEvent
    public static void postHitEffects(LivingDamageEvent.Post event) {

        var damageSource = event.getSource();

        if (damageSource instanceof HnSSpellDamageSource spellDamageSource
                && spellDamageSource.hasPostHitEffects()) {

            var target = event.getEntity();

            if (spellDamageSource.getSoulFireTime() > 0) {

                FireManager.setOnFire(target, spellDamageSource.getSoulFireTime() / 20f, FireManager.SOUL_FIRE_TYPE
                );
            }
        }
    }
}