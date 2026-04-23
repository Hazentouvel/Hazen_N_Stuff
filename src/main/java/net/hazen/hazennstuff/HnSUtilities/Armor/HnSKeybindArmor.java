package net.hazen.hazennstuff.HnSUtilities.Armor;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public interface HnSKeybindArmor {
    void onKeyPacket(Player keyPresser, ItemStack itemStack, int type);
}