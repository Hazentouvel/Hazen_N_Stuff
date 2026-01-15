package net.hazen.hazennstuff.Items.Extensions;

import io.redspace.ironsspellbooks.api.spells.IPresetSpellContainer;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import net.minecraft.world.item.ItemStack;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

public abstract class HnSImbuableArmorItem extends HnSArmorItem implements IPresetSpellContainer {
    public HnSImbuableArmorItem(HnSArmorMaterial material, Type type, Properties settings) {
        super(material, type, settings);
    }

    @Override
    public void initializeSpellContainer(ItemStack itemStack) {
        if (itemStack == null) {
            return;
        }

        if (itemStack.getItem() instanceof HnSArmorItem armorItem)
        {
            if (armorItem.getType() == Type.CHESTPLATE || armorItem.getType() == Type.HELMET)
            {
                if (!ISpellContainer.isSpellContainer(itemStack)) {
                    var spellContainer = ISpellContainer.create(1, true, true);
                    spellContainer.save(itemStack);
                }
            }
        }
    }
}
