package net.hazen.hazennstuff.Item.Armor.AzureLib.Blazeborne;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.armor.IDisableHat;
import io.redspace.ironsspellbooks.item.armor.IDisableJacket;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import net.hazen.hazennstuff.Compat.MalumCompat;
import net.hazen.hazennstuff.Item.Armor.HnSArmorMaterials;
import net.hazen.hazennstuff.Item.Armor.ImbuableHnSArmorItem;
import net.hazen.hazennstuff.Item.Dispatcher.HnSDispatcher;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.hazen.hazennstuff.Registries.HnSItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;

import java.util.List;

public class BlazeborneArmorItem extends ImbuableHnSArmorItem implements IDisableJacket, IDisableHat {
    // This is your class where you will setup the AzCommands/Animations you wish to play
    public final HnSDispatcher dispatcher;

    public BlazeborneArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterials.PURE_ARMOR_TIER_MATERIAL, type, settings,
                new AttributeContainer(AttributeRegistry.MAX_MANA, 150.0, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.HOLY_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.ELDRITCH_SPELL_POWER, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
        );
        // Create the instance of the class here to use later.
        this.dispatcher = new HnSDispatcher();
    }

    public List<ItemAttributeModifiers.Entry> createExtraAttributes() {
        var group = EquipmentSlotGroup.bySlot(getEquipmentSlot());
        ItemAttributeModifiers.Builder attributes = ItemAttributeModifiers.builder();
        MalumCompat.addArcaneResonance(attributes, group);
        return attributes.build().modifiers();
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof Player player && !level.isClientSide() && isWearingFullSet(player)) {
            evaluateArmorEffects(player);
        }
        if (!level.isClientSide && entity instanceof Player player ) {
            player.getArmorSlots().forEach(wornArmor -> {
                if (wornArmor != null && wornArmor.is(HnSItems.BLAZEBORNE_HELMET)) {
                    dispatcher.idle(player, wornArmor);
                }
                if (wornArmor != null && wornArmor.is(HnSItems.BLAZEBORNE_CHESTPLATE)) {
                    dispatcher.idle(player, wornArmor);
                }
                if (wornArmor != null && wornArmor.is(HnSItems.BLAZEBORNE_LEGGINGS)) {
                    dispatcher.idle(player, wornArmor);
                }
                if (wornArmor != null && wornArmor.is(HnSItems.BLAZEBORNE_BOOTS)) {
                    dispatcher.idle(player, wornArmor);
                }
            });
        }
    }

    private void evaluateArmorEffects(Player player) {
        if (!player.hasEffect(HnSEffects.MAGE_SET_BONUS)) {
            player.addEffect(new MobEffectInstance(HnSEffects.MAGE_SET_BONUS, 320, 0, false, false, false));
        }
    }

    private boolean isWearingFullSet(Player player) {
        return player.getItemBySlot(ArmorItem.Type.HELMET.getSlot()).getItem() instanceof BlazeborneArmorItem &&
                player.getItemBySlot(ArmorItem.Type.CHESTPLATE.getSlot()).getItem() instanceof BlazeborneArmorItem &&
                player.getItemBySlot(ArmorItem.Type.LEGGINGS.getSlot()).getItem() instanceof BlazeborneArmorItem &&
                player.getItemBySlot(ArmorItem.Type.BOOTS.getSlot()).getItem() instanceof BlazeborneArmorItem;
    }
}