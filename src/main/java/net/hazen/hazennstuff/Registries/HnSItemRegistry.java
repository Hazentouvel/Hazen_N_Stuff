package net.hazen.hazennstuff.Registries;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Items.Weapons.Ascended.IcePike.IcePikeItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Collection;

public class HnSItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HazenNStuff.MOD_ID);

    public static final DeferredHolder<Item, Item> ICE_PIKE = ITEMS.register
            ("ice_pike", IcePikeItem::new);
    public static Collection<DeferredHolder<Item, ? extends Item>> getHnSItems()
    {
        return ITEMS.getEntries();
    }

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
