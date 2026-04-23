package net.hazen.hazennstuff.Setup;

import io.redspace.ironsspellbooks.api.entity.IMagicEntity;
import io.redspace.ironsspellbooks.damage.ISSDamageTypes;
import io.redspace.ironsspellbooks.effect.ImmolateEffect;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.hazen.hazennstuff.Registries.HnSItemRegistry;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@EventBusSubscriber
public class HnSServerPlayerEvents {
    public HnSServerPlayerEvents() {
    }

    private static boolean isWearingFullTyrosSet(LivingEntity entity) {
        return entity.getItemBySlot(EquipmentSlot.HEAD).getItem() == HnSItemRegistry.TYROS_HELMET.get()
                && entity.getItemBySlot(EquipmentSlot.CHEST).getItem() == HnSItemRegistry.TYROS_CHESTPLATE.get()
                && entity.getItemBySlot(EquipmentSlot.LEGS).getItem() == HnSItemRegistry.TYROS_LEGGINGS.get()
                && entity.getItemBySlot(EquipmentSlot.FEET).getItem() == HnSItemRegistry.TYROS_BOOTS.get();
    }


    @SubscribeEvent
    public static void onLivingIncomingDamage(LivingIncomingDamageEvent event) {
        LivingEntity livingEntity = event.getEntity();

        if ((livingEntity instanceof ServerPlayer || livingEntity instanceof IMagicEntity) && isWearingFullTyrosSet(livingEntity) && event.getSource().is(DamageTypeTags.IS_FIRE)) {
            livingEntity.clearFire();
            event.setCanceled(true);
        }
    }


    @SubscribeEvent
    public static void onBeforeDamageTaken(LivingDamageEvent.Pre event) {
        LivingEntity livingEntity = event.getEntity();

        if (event.getSource().is(ISSDamageTypes.FIRE_MAGIC)) {
            Entity attacker = event.getSource().getEntity();
            if (attacker instanceof LivingEntity livingAttacker) {
                if (isWearingFullTyrosSet(livingAttacker)) {
                    if (livingAttacker instanceof Player player) {
                        Item chest = player.getItemBySlot(EquipmentSlot.CHEST).getItem();
                        if (player.getCooldowns().isOnCooldown(chest)) {
                            return;
                        }
                    }

                    ImmolateEffect.addImmolateStack(livingEntity, livingAttacker);
                }
            }
        }
    }

    @EventBusSubscriber
    public static class TyrosHitEffects {

        @SubscribeEvent
        public static void onLivingDamage(LivingDamageEvent.Post event) {

            LivingEntity target = event.getEntity();
            Entity sourceEntity = event.getSource().getEntity();

            if (!(sourceEntity instanceof LivingEntity attacker)) return;

            if (!isWearingFullTyrosSet(attacker)) return;

            if (attacker.level().isClientSide) return;

            Item head = attacker.getItemBySlot(EquipmentSlot.HEAD).getItem();
            if (attacker instanceof Player player) {
                if (player.getCooldowns().isOnCooldown(head)) {
                    return;
                }
                player.getCooldowns().addCooldown(head, 80);
            }

            boolean inSoulState = attacker.hasEffect(HnSEffects.TYROS_SOUL_STATE);

            if (inSoulState) {
                target.addEffect(new MobEffectInstance(MobEffectRegistry.REND, 160, 0, true, true, true));
            } else {
                target.addEffect(new MobEffectInstance(MobEffectRegistry.REND, 160, 0, true, true, true));
            }
        }
    }

}