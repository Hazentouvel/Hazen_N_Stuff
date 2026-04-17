package net.hazen.hazennstuff.HnSUtilities.HnSExtras.MagicMace.CastingItem;

import net.minecraft.world.item.ItemStack;

public class HnSMaceStaffItem extends HnSMaceCastingItem {
    public HnSMaceStaffItem(Properties properties) {
        super(properties);
    }

    public boolean isEnchantable(ItemStack pStack) {
        return true;
    }

    public int getEnchantmentValue(ItemStack stack) {
        return 20;
    }

    public boolean hasCustomRendering() {
        return false;
    }
}
