package net.hazen.hazennstuff.Events.ArmorSetBonuses;

import io.redspace.ironslib.soulfire.SoulFireHelper;
import io.redspace.ironsspellbooks.api.entity.IMagicEntity;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.damage.ISSDamageTypes;
import io.redspace.ironsspellbooks.effect.ImmolateEffect;
import io.redspace.ironsspellbooks.particle.FlameStrikeParticleOptions;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.hazen.hazennstuff.Item.Armor.AscendedTier.GarmentsOfTheFirstFlamebearer.GarmentsOfTheFirstFlamebearerArmorItem;
import net.hazen.hazennstuff.Particle.SlashParticles.Spells.SoulFlameStrike.SoulFlameStrikeOptions;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@EventBusSubscriber
public class TyrosSetBonus {
    public TyrosSetBonus() {
    }

    private static boolean isWearingFullTyrosSet(LivingEntity entity) {
        return entity.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof GarmentsOfTheFirstFlamebearerArmorItem
                && entity.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof GarmentsOfTheFirstFlamebearerArmorItem
                && entity.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof GarmentsOfTheFirstFlamebearerArmorItem
                && entity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof GarmentsOfTheFirstFlamebearerArmorItem;
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
                        Item legs = player.getItemBySlot(EquipmentSlot.LEGS).getItem();
                        if (player.getCooldowns().isOnCooldown(legs)) {
                            return;
                        }
                        player.getCooldowns().addCooldown(legs, 10);
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
                SoulFireHelper.igniteSoul(target, fireTicks);
                MagicManager.spawnParticles(attacker.level(), new SoulFlameStrikeOptions((float) forward.x, (float) forward.y, (float) forward.z, mirrored, false, 1.0F), hitLocation.x, hitLocation.y, hitLocation.z, 1, 0, 0, 0, 0, true);

            } else {
                target.igniteForSeconds(fireTicks / 20f);
                MagicManager.spawnParticles(attacker.level(), new FlameStrikeParticleOptions((float) forward.x, (float) forward.y, (float) forward.z, mirrored, false, 1.0F), hitLocation.x, hitLocation.y, hitLocation.z, 1, 0, 0, 0, 0, true);
            }
            // Alternate every hit
            mirrored = !mirrored;
        }
    }


}
