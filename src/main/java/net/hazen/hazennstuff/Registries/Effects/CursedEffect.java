package net.hazen.hazennstuff.Registries.Effects;

import io.redspace.ironsspellbooks.api.events.SpellPreCastEvent;
import io.redspace.ironsspellbooks.effect.ISyncedMobEffect;
import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;

@EventBusSubscriber
public class CursedEffect extends MagicMobEffect implements ISyncedMobEffect {
    public static final float LEVEL = 0.2F;


    @SubscribeEvent
    public static void onPlayerCastEvent(SpellPreCastEvent event) {
        var entity = event.getEntity();

        if (!entity.hasEffect(HnSEffects.CURSED)) {
            return;
        }

        if (entity instanceof ServerPlayer player) {
            MobEffectInstance previous = player.getEffect(HnSEffects.CURSED);

            if (previous == null) {
                return;
            }

            double amplifier = LEVEL + previous.getAmplifier() * 0.05;

            if (player.getRandom().nextDouble() <= amplifier) {
                event.setCanceled(true);
                player.level.playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.SOUL_ESCAPE, SoundSource.PLAYERS, 0.5f, 1f);
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerInput(InputEvent.InteractionKeyMappingTriggered event) {
        LocalPlayer player = Minecraft.getInstance().player;

        if (player == null || !player.hasEffect(HnSEffects.CURSED)) {
            return;
        }

        if (!event.isAttack() && !event.isUseItem()) {
            return;
        }

        MobEffectInstance effect = player.getEffect(HnSEffects.CURSED);

        if (effect == null) {
            return;
        }

        double chance = CursedEffect.LEVEL + effect.getAmplifier() * 0.05;

        chance = Math.min(chance, 1.0);

        if (player.getRandom().nextDouble() <= chance) {
            event.setSwingHand(false);
            event.setCanceled(true);
        }
    }

    public CursedEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }
}
