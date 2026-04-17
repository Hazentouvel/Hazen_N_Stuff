package net.hazen.hazennstuff.HnSUtilities.HnSExtras.MagicMace.CastingItem;

import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import net.minecraft.util.Unit;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MaceItem;

public class HnSMaceCastingItem extends MaceItem {
    public HnSMaceCastingItem(Properties pProperties) {
        super(pProperties.component(ComponentRegistry.CASTING_IMPLEMENT, Unit.INSTANCE));
    }

    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }
}

