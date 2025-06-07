package net.hazen.hazennstuff.rarity;

import net.minecraft.world.item.Rarity;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import net.minecraft.network.chat.Style;

import java.util.function.UnaryOperator;

public class DeusRarity {
    public static final EnumProxy<Rarity> DEUS_RARITY_PROXY = new EnumProxy<>(Rarity.class,
            -1,
            "hazennstuff:deus",
            (UnaryOperator<Style>) ((style) -> style.withColor(0xc4ffee))
    );
}