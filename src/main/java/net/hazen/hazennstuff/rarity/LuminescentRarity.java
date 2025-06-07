package net.hazen.hazennstuff.rarity;

import net.minecraft.world.item.Rarity;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import net.minecraft.network.chat.Style;

import java.util.function.UnaryOperator;

public class LuminescentRarity {
    public static final EnumProxy<Rarity> LUMINESCENT_RARITY_PROXY = new EnumProxy<>(Rarity.class,
            -1,
            "hazennstuff:luminescent",
            (UnaryOperator<Style>) ((style) -> style.withColor(0x2c2fb0))
    );
}