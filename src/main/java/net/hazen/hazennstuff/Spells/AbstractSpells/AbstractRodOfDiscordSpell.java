package net.hazen.hazennstuff.Spells.AbstractSpells;

import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.hazen.hazennstuff.Registries.HnSItemRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;

import static net.acetheeldritchking.aces_spell_utils.utils.ASUtils.isValidUnlockItemInInventory;

public abstract class AbstractRodOfDiscordSpell extends AbstractSpell {

    @Override
    public Component getLockedMessage() {
        return Component.translatable("ui.hazennstuff.staff_resonation");
    }

    @Override
    public boolean allowLooting() {
        return true;
    }

    @Override
    public boolean canBeCraftedBy(Player player) {
        Item item = HnSItemRegistry.ROD_OF_DISCORD.get();
        return isValidUnlockItemInInventory(item, player);
    }
}
