package net.hazen.hazennstuff.Item.Lootbags;

import io.redspace.ironsspellbooks.render.CinderousRarity;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.acetheeldritchking.aces_spell_utils.items.custom.LootBagItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Rarity;

public class TyrosLootBag extends LootBagItem {
    static ResourceLocation lootTable = ResourceLocation.fromNamespaceAndPath("hazennstuff", "loot_bags/tyros_loot_bag");

    public TyrosLootBag() {
        super(ItemPropertiesHelper
                .equipment(8)
                .fireResistant()
                .rarity((Rarity)CinderousRarity.CINDEROUS_RARITY_PROXY.getValue()),
                lootTable);
    }
}
