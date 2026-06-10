package net.hazen.hazennstuff.Setup;

import io.redspace.ironsspellbooks.api.entity.IMagicEntity;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.ISSDamageTypes;
import io.redspace.ironsspellbooks.effect.ImmolateEffect;
import io.redspace.ironsspellbooks.particle.FlameStrikeParticleOptions;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import it.crystalnest.prometheus.api.FireManager;
import net.hazen.hazennstuff.Item.Armor.AscendedTier.DeadKing.DeadKingArmorItem;
import net.hazen.hazennstuff.Item.Armor.AscendedTier.GarmentsOfTheFirstFlamebearer.GarmentsOfTheFirstFlamebearerArmorItem;
import net.hazen.hazennstuff.Particle.SlashParticles.Spells.SoulFlameStrike.SoulFlameStrikeOptions;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;

@EventBusSubscriber
public class HnSServerPlayerEvents {
    public HnSServerPlayerEvents() {
    }

    private static boolean isWearingFullTyrosSet(LivingEntity entity) {
        return entity.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof GarmentsOfTheFirstFlamebearerArmorItem
                && entity.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof GarmentsOfTheFirstFlamebearerArmorItem
                && entity.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof GarmentsOfTheFirstFlamebearerArmorItem
                && entity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof GarmentsOfTheFirstFlamebearerArmorItem;
    }

    private static boolean isWearingFullDeadKingSet(LivingEntity entity) {
        return entity.getItemBySlot(ArmorItem.Type.HELMET.getSlot()).getItem() instanceof DeadKingArmorItem &&
                entity.getItemBySlot(ArmorItem.Type.CHESTPLATE.getSlot()).getItem() instanceof DeadKingArmorItem &&
                entity.getItemBySlot(ArmorItem.Type.LEGGINGS.getSlot()).getItem() instanceof DeadKingArmorItem &&
                entity.getItemBySlot(ArmorItem.Type.BOOTS.getSlot()).getItem() instanceof DeadKingArmorItem;
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
                        Item chest = player.getItemBySlot(EquipmentSlot.LEGS).getItem();
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
        private static boolean mirrored = false;

        @SubscribeEvent
        public static void rendOnHit(LivingDamageEvent.Post event) {

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
                player.getCooldowns().addCooldown(head, 200);
            }

            int amplifier = 0;

            try {
                double attrVal = 0.0;
                try {
                    attrVal = attacker.getAttributeValue(AttributeRegistry.FIRE_SPELL_POWER);
                } catch (IllegalArgumentException ex) {
                    attrVal = 0.0;
                }

                double percent;
                if (attrVal <= 0.0) {
                    percent = 0.0;
                } else if (attrVal < 10.0) {
                    // Likely a multiplier (e.g. 1.0 == 100%)
                    percent = attrVal * 100.0;
                } else {
                    // Likely already percent (e.g. 150.0 == 150%)
                    percent = attrVal;
                }

                int fullHundreds = (int)Math.floor(percent / 100.0);
                amplifier = Math.max(0, fullHundreds - 1);
            } catch (Throwable t) {
                amplifier = 0;
            }

            boolean inSoulState = attacker.hasEffect(HnSEffects.TYROS_SOUL_STATE);

            if (inSoulState) {
                target.addEffect(new MobEffectInstance(MobEffectRegistry.SOUL_BURN, 100, amplifier, false, true, true));
            } else {
                target.addEffect(new MobEffectInstance(MobEffectRegistry.REND, 100, amplifier, false, true, true));
            }
        }

        @SubscribeEvent
        public static void igniteOnHit(LivingDamageEvent.Post event) {

            LivingEntity target = event.getEntity();
            Entity sourceEntity = event.getSource().getEntity();

            if (!(sourceEntity instanceof LivingEntity attacker)) return;

            // Must wear full Tyros set
            if (!isWearingFullTyrosSet(attacker)) return;
            if (attacker.level().isClientSide) return;

            Item head = attacker.getItemBySlot(EquipmentSlot.CHEST).getItem();

            // Cooldown handling
            if (attacker instanceof Player player) {
                if (player.getCooldowns().isOnCooldown(head)) {
                    return;
                }
                player.getCooldowns().addCooldown(head, 20);
            }
            int fireTicks = 100;
            Vec3 forward = attacker.getForward();
            Vec3 hitLocation = target.getBoundingBox().getCenter();

            if (attacker.hasEffect(HnSEffects.TYROS_SOUL_STATE)) {
                FireManager.setOnFire(target, fireTicks / 20f, FireManager.SOUL_FIRE_TYPE);
                MagicManager.spawnParticles(attacker.level(), new SoulFlameStrikeOptions((float) forward.x, (float) forward.y, (float) forward.z, mirrored, false, 1.0F), hitLocation.x, hitLocation.y, hitLocation.z, 1, 0, 0, 0, 0, true);

            } else {
                target.igniteForSeconds(fireTicks / 20f);
                MagicManager.spawnParticles(attacker.level(), new FlameStrikeParticleOptions((float) forward.x, (float) forward.y, (float) forward.z, mirrored, false, 1.0F), hitLocation.x, hitLocation.y, hitLocation.z, 1, 0, 0, 0, 0, true);
            }
            // Alternate every hit
            mirrored = !mirrored;
        }
    }

    @SubscribeEvent
    public static void DeathEvent(LivingDeathEvent event) {
        DamageSource source = event.getSource();
        if (!source.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            if(tryDeadKingRevive(event.getEntity())){
                event.setCanceled(true);
            }

        }
    }

    @SubscribeEvent
    public static void preventEffectRemoval(MobEffectEvent.Remove event) {
        MobEffectInstance effectInstance = event.getEffectInstance();

        if (effectInstance != null && effectInstance.getEffect() == HnSEffects.REVIVE_COOLDOWN.get()) {
            event.setCanceled(true);
        }
    }

    private static boolean tryDeadKingRevive(LivingEntity living) {
        if ((living.level() instanceof ServerLevel serverLevel) && isWearingFullDeadKingSet(living) && !living.hasEffect(HnSEffects.REVIVE_COOLDOWN) && !living.hasEffect(HnSEffects.AWAKENING)) {
            living.setHealth(10F);
            serverLevel.playSound(
                    null,
                    living.getX(), living.getY(), living.getZ(),
                    SoundRegistry.DEAD_KING_EXPLODE,
                    living.getSoundSource(),
                    1.25f,
                    1.0F
            );
            living.addEffect(new MobEffectInstance(HnSEffects.AWAKENING, 3600, 0, false, true, true));
            double d0 = living.getX();
            double d1 = living.getY() + 3F;
            double d2 = living.getZ();
            serverLevel.sendParticles(ParticleTypes.SOUL, d0, d1, d2, 1, 0.0, 0, 0.0, 0);
            return true;
        }
        return false;
    }


}
