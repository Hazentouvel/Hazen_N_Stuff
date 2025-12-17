package net.hazen.hazennstuff.Item.Armor.AzureLib.ArbitriumRobes;

import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.armor.IDisableJacket;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import net.hazen.hazennstuff.Compat.ArsNoveauCompat;
import net.hazen.hazennstuff.Compat.MalumCompat;
import net.hazen.hazennstuff.Animations.HnSDispatcher;
import net.hazen.hazennstuff.Item.Armor.HnSArmorMaterials;
import net.hazen.hazennstuff.Item.Armor.ImbuableHnSArmorItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ArbitriumRobesElytraArmorItem extends ImbuableHnSArmorItem implements IDisableJacket {
    // This is your class where you will setup the AzCommands/Animations you wish to play
    public final HnSDispatcher dispatcher;

    public ArbitriumRobesElytraArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterials.NERFED_DEUS_MATERIAL, type, settings,
                new AttributeContainer(ALObjects.Attributes.ELYTRA_FLIGHT, 1, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.MAX_MANA, 300.0, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, .25, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
        );
        this.dispatcher = new HnSDispatcher();
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
    public void appendHoverText(@NotNull ItemStack stack,
                                @NotNull TooltipContext context,
                                @NotNull List<Component> lines,
                                @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, context, lines, flag);

        // --- Custom item description section ---
        lines.add(Component.translatable("item.hazennstuff.arbitrium_robes.description")
                .withStyle(ChatFormatting.WHITE, ChatFormatting.ITALIC));
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (!(entity instanceof Player player) || level.isClientSide) return;

        boolean isFlying = player.isFallFlying();

        player.getArmorSlots().forEach(wornArmor -> {
            if (wornArmor != null && wornArmor.getItem() instanceof ArbitriumRobesElytraArmorItem) {
                if (isFlying) {
                    dispatcher.flight(player, wornArmor);  // Play flight animation
                } else {
                    dispatcher.idle(player, wornArmor);   // Play idle animation
                }
            }
        });
    }

    @Override
    public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
        return true;
    }

    @Override
    public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
        return true; // Needed to allow flight ticking
    }
}