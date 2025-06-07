package net.hazen.hazennstuff.item.armor.AzureLib.CreakingSorcerer;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.armor.IDisableJacket;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import net.hazen.hazennstuff.item.armor.HnSArmorMaterials;
import net.hazen.hazennstuff.item.armor.ImbuableHnSArmorItem;
import net.hazen.hazennstuff.registries.HnSEffects;
import net.hazen.hazennstuff.item.custom.HnSArmorDispatcher;
import net.hazen.hazennstuff.registries.HnSItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CreakingSorcererArmorItem extends ImbuableHnSArmorItem implements IDisableJacket {
    // This is your class where you will setup the AzCommands/Animations you wish to play
    public final HnSArmorDispatcher dispatcher;

    public CreakingSorcererArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterials.CREAKING_SORCERER_MATERIAL, type, settings,
                new AttributeContainer(AttributeRegistry.MAX_MANA, 500.0, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, .25, AttributeModifier.Operation.ADD_VALUE)
        );
        // Create the instance of the class here to use later.
        this.dispatcher = new HnSArmorDispatcher();
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof Player player && !level.isClientSide() && isWearingFullSet(player)) {
            evaluateArmorEffects(player);
        }
        if (!level.isClientSide && entity instanceof Player player ) {
            player.getArmorSlots().forEach(wornArmor -> {
                if (wornArmor != null && wornArmor.is(HnSItems.CREAKING_HELMET)) {
                    dispatcher.idle(player, wornArmor);
                }
                if (wornArmor != null && wornArmor.is(HnSItems.CREAKING_CHESTPLATE)) {
                    dispatcher.idle(player, wornArmor);
                }
                if (wornArmor != null && wornArmor.is(HnSItems.CREAKING_LEGGINGS)) {
                    dispatcher.idle(player, wornArmor);
                }
                if (wornArmor != null && wornArmor.is(HnSItems.CREAKING_BOOTS)) {
                    dispatcher.idle(player, wornArmor);
                }
            });
        }
    }

    private void evaluateArmorEffects(Player player) {
        if (!player.hasEffect(HnSEffects.CALL_OF_THE_GARDEN_EFFECT)) {
            player.addEffect(new MobEffectInstance(HnSEffects.CALL_OF_THE_GARDEN_EFFECT, 200, 0, false, false, false));
        }
    }

    private boolean isWearingFullSet(Player player) {
        return player.getItemBySlot(ArmorItem.Type.HELMET.getSlot()).getItem() instanceof CreakingSorcererArmorItem &&
                player.getItemBySlot(ArmorItem.Type.CHESTPLATE.getSlot()).getItem() instanceof CreakingSorcererArmorItem &&
                player.getItemBySlot(ArmorItem.Type.LEGGINGS.getSlot()).getItem() instanceof CreakingSorcererArmorItem &&
                player.getItemBySlot(ArmorItem.Type.BOOTS.getSlot()).getItem() instanceof CreakingSorcererArmorItem;
    }
}