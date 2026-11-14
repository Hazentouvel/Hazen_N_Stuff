package net.hazen.hazennstuff.Events.ArmorSetBonuses;

import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Item.Armor.AscendedTier.CoruscatedValor.CoruscatedValorArmorItem;
import net.hazen.hazennstuff.Item.Armor.AscendedTier.DeadKing.DeadKingArmorItem;
import net.hazen.hazennstuff.Registries.Effects.ChargeEffect;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;

@EventBusSubscriber(modid = HazenNStuff.MOD_ID)
public class DeadKingSetBonus {
    private static boolean isWearingFullDeadKingSet(LivingEntity entity) {
        return entity.getItemBySlot(ArmorItem.Type.HELMET.getSlot()).getItem() instanceof DeadKingArmorItem &&
                entity.getItemBySlot(ArmorItem.Type.CHESTPLATE.getSlot()).getItem() instanceof DeadKingArmorItem &&
                entity.getItemBySlot(ArmorItem.Type.LEGGINGS.getSlot()).getItem() instanceof DeadKingArmorItem &&
                entity.getItemBySlot(ArmorItem.Type.BOOTS.getSlot()).getItem() instanceof DeadKingArmorItem;
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
