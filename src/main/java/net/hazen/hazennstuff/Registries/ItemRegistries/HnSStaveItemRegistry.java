package net.hazen.hazennstuff.Registries.ItemRegistries;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Items.Equipment.Staves.BlossomOfTheEnchantress.BlossomOfTheEnchantress;
import net.hazen.hazennstuff.Items.Equipment.Staves.DivineScepter.DivineScepter;
import net.hazen.hazennstuff.Items.Equipment.Staves.EnderconicScepter.EnderconicStaff;
import net.hazen.hazennstuff.Items.Equipment.Staves.GrimoireStaff.GrimoireStaff;
import net.hazen.hazennstuff.Items.Equipment.Staves.InsaniaAeternum.InsaniaAeternum;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HnSStaveItemRegistry {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HazenNStuff.MOD_ID);

    // Enderconic Scepter
    public static final RegistryObject<Item> ENDERCONIC_SCEPTER = ITEMS.register
            ("enderconic_scepter", EnderconicStaff::new);

    // Divine Scepter
    public static final RegistryObject<Item> DIVINE_SCEPTER = ITEMS.register
            ("divine_scepter", DivineScepter::new);

    // Grimoire Staff
    public static final RegistryObject<Item> GRIMOIRE_STAFF = ITEMS.register
            ("grimoire_staff", GrimoireStaff::new);

    // Insania Aeternum
    public static final RegistryObject<Item> INSANIA_AETERNUM = ITEMS.register
            ("insania_aeternum", InsaniaAeternum::new);

    // Blossom of the Enchantress
    public static final RegistryObject<Item> BLOSSOM_OF_THE_ENCHANTRESS = ITEMS.register
            ("blossom_of_the_enchantress", BlossomOfTheEnchantress::new);



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}