package net.hazen.hazennstuff.rarity;

import net.minecraft.world.item.Rarity;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import net.minecraft.network.chat.Style;

import java.util.function.UnaryOperator;

public class CryogenicRarity {
    public static final EnumProxy<Rarity> CRYOGENIC_RARITY_PROXY = new EnumProxy<>(Rarity.class,
            -1,
            "hazennstuff:cryogenic",
            (UnaryOperator<Style>) ((style) -> style.withColor(13695487))
    );
}