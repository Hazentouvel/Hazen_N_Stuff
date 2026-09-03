package net.hazen.hazennstuff.Setup;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Item.Armor.AscendedTier.CoruscatedValor.CoruscatedValorArmorItem;
import net.hazen.hazennstuff.Registries.Effects.ChargeEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@EventBusSubscriber(modid = HazenNStuff.MOD_ID)
public class HnSSetBonuses {
    private static boolean isCoruscatedValor(LivingEntity entity) {
        return entity.getItemBySlot(ArmorItem.Type.HELMET.getSlot()).getItem() instanceof CoruscatedValorArmorItem &&
                entity.getItemBySlot(ArmorItem.Type.CHESTPLATE.getSlot()).getItem() instanceof CoruscatedValorArmorItem &&
                entity.getItemBySlot(ArmorItem.Type.LEGGINGS.getSlot()).getItem() instanceof CoruscatedValorArmorItem &&
                entity.getItemBySlot(ArmorItem.Type.BOOTS.getSlot()).getItem() instanceof CoruscatedValorArmorItem;
    }



    @SubscribeEvent
    public static void onLivingIncomingDamage(LivingIncomingDamageEvent event) {
        LivingEntity livingEntity = event.getEntity();
        if (!livingEntity.getCommandSenderWorld().isClientSide && isCoruscatedValor(livingEntity)) {
            if (!event.isCanceled()) {
                ChargeEffect.addChargeStack(livingEntity, event.getSource().getEntity());
            }
        }
    }

}
