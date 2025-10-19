package net.hazen.hazennstuff.Spells;

import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.hazen.hazennstuff.Registries.HnSItems;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;

import static net.acetheeldritchking.aces_spell_utils.utils.ASUtils.isValidUnlockItemInInventory;

public abstract class AbstractRodOfDiscordSpell extends AbstractSpell {

    @Override
    public boolean allowLooting() {
        return true;
    }

    @Override
    public boolean canBeCraftedBy(Player player) {
        Item ravensBane = HnSItems.ROD_OF_DISCORD.get();
        return isValidUnlockItemInInventory(ravensBane, player);
    }
}
