package net.hazen.hazennstuff.rarity;

import net.minecraft.world.item.Rarity;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import net.minecraft.network.chat.Style;

import java.util.function.UnaryOperator;

import static net.minecraft.ChatFormatting.WHITE;

public class EvocationRarity {
    public static final EnumProxy<Rarity> EVOCATION_RARITY_PROXY = new EnumProxy<>(Rarity.class,
            -1,
            "hazennstuff:evocation",
            (UnaryOperator<Style>) ((style) -> style.withColor(WHITE))
    );
}