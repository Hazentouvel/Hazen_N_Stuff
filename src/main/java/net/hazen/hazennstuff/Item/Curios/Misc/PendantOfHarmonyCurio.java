package net.hazen.hazennstuff.Item.Curios.Misc;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.curios.SimpleDescriptiveCurio;
import io.redspace.ironsspellbooks.render.CinderousRarity;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.Rarity.HnSRarities;
import net.hazen.hazennstuff.Registries.HnSAttributeRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;
import top.theillusivec4.curios.api.SlotContext;

import java.util.List;

public class PendantOfHarmonyCurio extends SimpleDescriptiveCurio {

    public PendantOfHarmonyCurio() {
        super(ItemPropertiesHelper.equipment()
                .stacksTo(1)
                .fireResistant()
                .rarity(HnSRarities.RADIANCE_RARITY.getValue())
        );
    }

    @Override
    public Component getName(ItemStack stack) {
        String baseName = super.getName(stack).getString();

        MutableComponent rainbowName = Component.literal("");

        Minecraft mc = Minecraft.getInstance();
        long ticks = (mc.level != null) ? mc.level.getGameTime() : 0;

        for (int i = 0; i < baseName.length(); i++) {
            float hue = ((i * 40) + (ticks * 2.25f)) % 360 / 360f;

            int rgb = java.awt.Color.HSBtoRGB(hue, 1f, 1f);
            String hex = String.format("#%06X", (0xFFFFFF & rgb));

            TextColor color = TextColor.parseColor(hex).getOrThrow();

            rainbowName = rainbowName.append(
                    Component.literal(String.valueOf(baseName.charAt(i)))
                            .withStyle(style -> style.withColor(color))
            );
        }
        return rainbowName;
    }

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier> attr = LinkedHashMultimap.create();
        attr.put(HnSAttributeRegistry.RADIANCE_SPELL_POWER, new AttributeModifier(id, 0.1, AttributeModifier.Operation.ADD_VALUE));
        attr.put(HnSAttributeRegistry.RADIANCE_SPELL_RESIST, new AttributeModifier(id, 0.05, AttributeModifier.Operation.ADD_VALUE));
        return attr;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack,
                                @NotNull TooltipContext context,
                                @NotNull List<Component> lines,
                                @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, context, lines, flag);

        lines.add(Component.translatable("item.hazennstuff.pendant_of_harmony.description")
                .withStyle(Style.EMPTY.withColor(0xe66af3).withItalic(true)));
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }
}
