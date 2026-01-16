package net.hazen.hazennstuff.Item.Armor.AzureLib.ArbitriumRobes.Ascended;

import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.armor.IDisableJacket;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import net.hazen.hazennstuff.Compat.ArsNoveauCompat;
import net.hazen.hazennstuff.Compat.MalumCompat;
import net.hazen.hazennstuff.Animations.HnSDispatcher;
import net.hazen.hazennstuff.Item.Armor.AzureLib.ArbitriumRobes.ArbitriumRobesArmorItem;
import net.hazen.hazennstuff.Item.Armor.AzureLib.ArbitriumRobes.ArbitriumRobesElytraArmorItem;
import net.hazen.hazennstuff.Item.HnSUtilities.HnSArmorMaterials;
import net.hazen.hazennstuff.Item.HnSUtilities.ImbuableHnSArmorItem;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
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

public class AscendedArbitriumRobesArmorItem extends ImbuableHnSArmorItem implements IDisableJacket {
    // This is your class where you will setup the AzCommands/Animations you wish to play
    public final HnSDispatcher dispatcher;

    public AscendedArbitriumRobesArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterials.NERFED_DEUS_MATERIAL, type, settings,
                new AttributeContainer(ALObjects.Attributes.ELYTRA_FLIGHT, 1, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.MAX_MANA, 9900, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, 1, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, 0.90, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
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

        lines.add(Component.translatable("item.hazennstuff.arbitrium_robes.description")
                .withStyle(ChatFormatting.WHITE, ChatFormatting.ITALIC));
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (!(entity instanceof Player player) || level.isClientSide) return;

        boolean isFlying = player.isFallFlying();

        player.getArmorSlots().forEach(wornArmor -> {
            if (wornArmor != null && wornArmor.getItem() instanceof AscendedArbitriumRobesArmorItem) {
                if (isFlying) {
                    dispatcher.flight(player, wornArmor);
                } else {
                    dispatcher.idle(player, wornArmor);
                }
            }
        });
        if (isWearingFullSet(player) && !player.hasEffect(HnSEffects.MAGE_SET_BONUS)) {
            evaluateArmorEffects(player);
        }
    }

    private void evaluateArmorEffects(Player player) {
        if (!player.hasEffect(HnSEffects.MAGE_SET_BONUS)) {
            player.addEffect(new MobEffectInstance(HnSEffects.MAGE_SET_BONUS,
                    320,
                    0,
                    false,
                    false,
                    false
            ));
        }
    }

    private boolean isWearingFullSet(Player player) {
        return player.getItemBySlot(Type.HELMET.getSlot()).getItem() instanceof AscendedArbitriumRobesArmorItem &&
                player.getItemBySlot(Type.CHESTPLATE.getSlot()).getItem() instanceof AscendedArbitriumRobesElytraArmorItem &&
                player.getItemBySlot(Type.LEGGINGS.getSlot()).getItem() instanceof AscendedArbitriumRobesArmorItem &&
                player.getItemBySlot(Type.BOOTS.getSlot()).getItem() instanceof AscendedArbitriumRobesArmorItem;
    }

    @Override
    public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
        return true;
    }

    @Override
    public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
        return true;
    }
}