package net.hazen.hazennstuff.rarity;

import net.minecraft.world.item.Rarity;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import net.minecraft.network.chat.Style;

import java.util.function.UnaryOperator;

public class DarkRarity {
    public static final EnumProxy<Rarity> DARK_RARITY_PROXY = new EnumProxy<>(Rarity.class,
            -1,
            "hazennstuff:dark",
            (UnaryOperator<Style>) ((style) -> style.withColor(0x6d62bc))
    );
}