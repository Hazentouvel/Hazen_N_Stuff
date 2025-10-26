package net.hazen.hazennstuff.Rarity;

import net.minecraft.world.item.Rarity;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import net.minecraft.network.chat.Style;

import java.util.function.UnaryOperator;

public class IceRarity {
    public static final EnumProxy<Rarity> ICE_RARITY_PROXY = new EnumProxy<>(Rarity.class,
            -1,
            "hazennstuff:ice",
            (UnaryOperator<Style>) ((style) -> style.withColor(13695487))
    );
}