package net.hazen.hazennstuff.Rarity;

import net.minecraft.world.item.Rarity;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import net.minecraft.network.chat.Style;

import java.util.function.UnaryOperator;

public class HolyRarity {
    public static final EnumProxy<Rarity> HOLY_RARITY_PROXY = new EnumProxy<>(Rarity.class,
            -1,
            "hazennstuff:holy",
            (UnaryOperator<Style>) ((style) -> style.withColor(16775380))
    );
}