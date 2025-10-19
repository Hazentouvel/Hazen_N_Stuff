package net.hazen.hazennstuff.Rarity;

import net.minecraft.world.item.Rarity;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;
import net.minecraft.network.chat.Style;

import java.util.function.UnaryOperator;

import static net.minecraft.ChatFormatting.DARK_RED;

public class BloodRarity {
    public static final EnumProxy<Rarity> BLOOD_RARITY_PROXY = new EnumProxy<>(Rarity.class,
            -1,
            "hazennstuff:blood",
            (UnaryOperator<Style>) ((style) -> style.withColor(DARK_RED))
    );
}