package net.hazen.hazennstuff.Item.Curios.Misc;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.curios.SimpleDescriptiveCurio;
import io.redspace.ironsspellbooks.render.CinderousRarity;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.SlotContext;

import java.util.List;

public class LegionnaireCurios extends SimpleDescriptiveCurio {

    public LegionnaireCurios() {
        super(ItemPropertiesHelper.equipment()
                .stacksTo(1)
                .fireResistant()
                .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
        );
    }

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier> attr = LinkedHashMultimap.create();
        attr.put(AttributeRegistry.FIRE_SPELL_POWER, new AttributeModifier(id, 0.15, AttributeModifier.Operation.ADD_VALUE));
        attr.put(AttributeRegistry.FIRE_MAGIC_RESIST, new AttributeModifier(id, 0.05, AttributeModifier.Operation.ADD_VALUE));
        return attr;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack,
                                @NotNull TooltipContext context,
                                @NotNull List<Component> lines,
                                @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, context, lines, flag);

        // Custom item description section
        lines.add(Component.translatable("item.hazennstuff.legionnaire_curios.description")
                .withStyle(Style.EMPTY.withColor(15881518).withItalic(true)));
    }
}
