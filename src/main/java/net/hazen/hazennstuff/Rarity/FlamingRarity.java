package net.hazen.hazennstuff.Rarity;

import net.minecraft.world.item.Rarity;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import net.minecraft.network.chat.Style;

import java.util.function.UnaryOperator;

import static net.minecraft.ChatFormatting.GOLD;

public class FlamingRarity {
    public static final EnumProxy<Rarity> FLAMING_RARITY_PROXY = new EnumProxy<>(Rarity.class,
            -1,
            "hazennstuff:flaming",
            (UnaryOperator<Style>) ((style) -> style.withColor(GOLD))
    );
}