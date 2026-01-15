package net.hazen.hazennstuff.Registries.ItemRegistries;

import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.AlchemistSupreme.AlchemistSupremeArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.Blazeborne.BlazeborneArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.CreakingSorcerer.CreakingSorcererArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.CryogenicRuler.CryogenicRulerArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.EnderDragon.EnderDragonArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.FireblossomBattlemage.Crown.FireblossomBattlemageCrownArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.FireblossomBattlemage.FireblossomBattlemageArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.FireblossomBattlemage.Helmet.FireblossomBattlemageHelmetArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.FleshMass.FleshMassArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.Hazel.BigHazelArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.Hazel.HazelArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.Infestation.InfestationArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.Seraph.SeraphArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.ThunderProwler.ThunderProwlerArmorItem;
import net.hazen.hazennstuff.Items.Equipment.Weapons.FireblossomRapier.FireblossomRapierItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HnSMaterialItemRegistry {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HazenNStuff.MOD_ID);

    /*
    *** Materials
     */

    public static final RegistryObject<Item> ZENALITE_INGOT = ITEMS.register("zenalite_ingot",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.EPIC)
                    .fireResistant()
            ));
    public static final RegistryObject<Item> RAW_ZENALITE = ITEMS.register("raw_zenalite",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.EPIC)
                    .fireResistant()
            ));
    public static final RegistryObject<Item> STARKISSED_ZENALITE = ITEMS.register("starkissed_zenalite",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.EPIC)
                    .fireResistant()
            ));

    public static final RegistryObject<Item> ELDRITCH_RUNE = ITEMS.register("eldritch_rune",
            () -> new Item(new Item
                    .Properties()
            ));

    public static final RegistryObject<Item> CRUDE_METAL = ITEMS.register("crude_metal",
            () -> new Item(new Item
                    .Properties()
            ));

    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item
                    .Properties()
            ));

    public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget",
            () -> new Item(new Item
                    .Properties()
            ));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}