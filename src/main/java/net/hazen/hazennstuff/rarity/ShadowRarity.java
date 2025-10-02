package net.hazen.hazennstuff.rarity;

import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Rarity;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;

import java.util.function.UnaryOperator;

public class ShadowRarity {
    public static final EnumProxy<Rarity> SHADOW_RARITY_PROXY = new EnumProxy<>(Rarity.class,
            -1,
            "hazennstuff:shadow",
            (UnaryOperator<Style>) ((style) -> style.withColor(0x6d62bc))
    );
}