package net.hazen.hazennstuff.item.armor.AzureLib.LemonGod.Ascended;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.armor.IDisableJacket;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.registries.MobEffectRegistry;
import net.hazen.hazennstuff.compat.ArsNoveauCompat;
import net.hazen.hazennstuff.compat.MalumCompat;
import net.hazen.hazennstuff.item.armor.HnSArmorMaterials;
import net.hazen.hazennstuff.item.armor.ImbuableHnSArmorItem;
import net.hazen.hazennstuff.item.dispatcher.HnSArmorDispatcher;
import net.hazen.hazennstuff.registries.HnSEffects;
import net.hazen.hazennstuff.registries.HnSItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;

import java.util.List;

public class AscendedLemonGodArmorItem extends ImbuableHnSArmorItem implements IDisableJacket {
    // This is your class where you will setup the AzCommands/Animations you wish to play
    public final HnSArmorDispatcher dispatcher;

    public AscendedLemonGodArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterials.DEUS_MATERIAL, type, settings,
                new AttributeContainer(AttributeRegistry.MAX_MANA, 500.0, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, .25, AttributeModifier.Operation.ADD_VALUE)
        );
        // Create the instance of the class here to use later.
        this.dispatcher = new HnSArmorDispatcher();
    }

    public List<ItemAttributeModifiers.Entry> createExtraAttributes() {
        var group = EquipmentSlotGroup.bySlot(getEquipmentSlot());
        ItemAttributeModifiers.Builder attributes = ItemAttributeModifiers.builder();
        MalumCompat.addArcaneResonance(attributes, group);
        ArsNoveauCompat.addMaxMana(attributes, group);
        ArsNoveauCompat.addManaRegen(attributes, group);
        return attributes.build().modifiers();
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof Player player && !level.isClientSide() && isWearingFullSet(player)) {
            evaluateArmorEffects(player);
        }
        if (!level.isClientSide && entity instanceof Player player ) {
            player.getArmorSlots().forEach(wornArmor -> {
                if (wornArmor != null && wornArmor.is(HnSItems.LEMON_GOD_HELMET)) {
                    dispatcher.idle(player, wornArmor);
                }
                if (wornArmor != null && wornArmor.is(HnSItems.LEMON_GOD_CHESTPLATE)) {
                    dispatcher.idle(player, wornArmor);
                }
                if (wornArmor != null && wornArmor.is(HnSItems.LEMON_GOD_LEGGINGS)) {
                    dispatcher.idle(player, wornArmor);
                }
                if (wornArmor != null && wornArmor.is(HnSItems.LEMON_GOD_BOOTS)) {
                    dispatcher.idle(player, wornArmor);
                }
            });
        }
    }

    private void evaluateArmorEffects(Player player) {
        if (!player.hasEffect(HnSEffects.PURE_ARMOR_SET_BONUS)) {
            player.addEffect(new MobEffectInstance(HnSEffects.PURE_ARMOR_SET_BONUS, 200, 0, false, false, false));
        }
        if (!player.hasEffect(MobEffectRegistry.ANGEL_WINGS)) {
            player.addEffect(new MobEffectInstance(MobEffectRegistry.ANGEL_WINGS, 200, 0, false, false, false));
        }
    }

    private boolean isWearingFullSet(Player player) {
        return player.getItemBySlot(Type.HELMET.getSlot()).getItem() instanceof AscendedLemonGodArmorItem &&
                player.getItemBySlot(Type.CHESTPLATE.getSlot()).getItem() instanceof AscendedLemonGodArmorItem &&
                player.getItemBySlot(Type.LEGGINGS.getSlot()).getItem() instanceof AscendedLemonGodArmorItem &&
                player.getItemBySlot(Type.BOOTS.getSlot()).getItem() instanceof AscendedLemonGodArmorItem;
    }
}