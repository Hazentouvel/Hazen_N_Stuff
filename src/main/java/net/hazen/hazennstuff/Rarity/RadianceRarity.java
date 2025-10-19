package net.hazen.hazennstuff.Rarity;

import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Rarity;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;

import java.util.function.UnaryOperator;

public class RadianceRarity {
    public static final EnumProxy<Rarity> RADIANCE_RARITY_PROXY = new EnumProxy<>(Rarity.class,
            -1,
            "hazennstuff:radiance",
            (UnaryOperator<Style>) ((style) -> style.withColor(0xe1cee3))
    );
}