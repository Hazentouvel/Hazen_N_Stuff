package net.hazen.hazennstuff.Rarity;

import net.minecraft.world.item.Rarity;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import net.minecraft.network.chat.Style;

import java.util.function.UnaryOperator;

public class EldritchRarity {
    public static final EnumProxy<Rarity> ELDRITCH_RARITY_PROXY = new EnumProxy<>(Rarity.class,
            -1,
            "hazennstuff:eldritch",
            (UnaryOperator<Style>) ((style) -> style.withColor(1016732))
    );
}