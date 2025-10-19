package net.hazen.hazennstuff.Rarity;

import net.minecraft.world.item.Rarity;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import net.minecraft.network.chat.Style;

import java.util.function.UnaryOperator;

import static net.minecraft.ChatFormatting.LIGHT_PURPLE;

public class EnderRarity {
    public static final EnumProxy<Rarity> ENDER_RARITY_PROXY = new EnumProxy<>(Rarity.class,
            -1,
            "hazennstuff:ender",
            (UnaryOperator<Style>) ((style) -> style.withColor(LIGHT_PURPLE))
    );
}