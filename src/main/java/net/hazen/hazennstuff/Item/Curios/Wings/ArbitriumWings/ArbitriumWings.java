package net.hazen.hazennstuff.Item.Curios.Wings.ArbitriumWings;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.Animations.HnSDispatcher;
import net.hazen.hazennstuff.Rarity.HnSRarities;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.SlotContext;

import java.util.List;

public class ArbitriumWings extends CurioBaseItem {
    public final HnSDispatcher dispatcher;


    public ArbitriumWings() {
        super(ItemPropertiesHelper
                .equipment()
                .stacksTo(1)
                .fireResistant()
                .rarity(HnSRarities.HOLY_RARITY.getValue())
        );

        this.dispatcher = new HnSDispatcher();
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack,
                                @NotNull TooltipContext context,
                                @NotNull List<Component> lines,
                                @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, context, lines, flag);

        // Custom item description section
        lines.add(Component.translatable("item.hazennstuff.arbitrium_robes.description")
                .withStyle(ChatFormatting.WHITE, ChatFormatting.ITALIC));
    }



    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier> attr = LinkedHashMultimap.create();
        attr.put(ALObjects.Attributes.ELYTRA_FLIGHT, new AttributeModifier(id, 1f, AttributeModifier.Operation.ADD_VALUE));
        return attr;
    }

    private static final int GLIDE_ANIMATION = 0;

    private void handleFlightState(Player player, ItemStack stack) {
        if (GLIDE_ANIMATION == 0) {
            dispatcher.flight(player, stack);
        }
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity entity = slotContext.entity();
        if (!(entity instanceof Player player) || player.level().isClientSide) return;

        if (!player.level().isClientSide && player.isFallFlying()) {
            elytraFlightTick(stack, player, 0);
        }
        if (player.isFallFlying()) {
            handleFlightState(player, stack);
            player.fallDistance = 0.0f;
        } else {
            dispatcher.idle(player, stack);
        }
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }
}
