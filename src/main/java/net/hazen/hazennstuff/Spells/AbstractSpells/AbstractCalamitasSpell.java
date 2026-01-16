package net.hazen.hazennstuff.Spells.AbstractSpells;

import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.hazen.hazennstuff.Registries.HnSItemRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;

import static net.acetheeldritchking.aces_spell_utils.utils.ASUtils.isValidUnlockItemInInventory;

public abstract class AbstractCalamitasSpell extends AbstractSpell {

    @Override
    public Component getLockedMessage() {
        return Component.translatable("ui.hazennstuff.armor_resonation");
    }

    @Override
    public boolean allowLooting() {
        return true;
    }

    @Override
    public boolean canBeCraftedBy(Player player) {
        Item[] validItems = {
                HnSItemRegistry.CALAMITAS_HELMET.get(),
                HnSItemRegistry.CALAMITAS_CHESTPLATE.get(),
                HnSItemRegistry.CALAMITAS_LEGGINGS.get(),
                HnSItemRegistry.CALAMITAS_BOOTS.get()
        };
        for (Item item : validItems) {
            if (isValidUnlockItemInInventory(item, player)) {
                return true;
            }
        }
        return false;
    }
}
