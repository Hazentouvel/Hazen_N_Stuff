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

public class HnSArmorItemRegistry {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HazenNStuff.MOD_ID);

    /*
    *** Armor
     */

    // Hazel Armor
    public static final RegistryObject<Item> HAZEL_HELMET = ITEMS.register("hazel_helmet", () -> new HazelArmorItem
            (ArmorItem.Type.HELMET,
             ItemPropertiesHelper
                     .equipment()
                     .rarity(Rarity.EPIC)
                     .fireResistant()
    ));
    public static final RegistryObject<Item> HAZEL_CHESTPLATE = ITEMS.register("hazel_chestplate", () -> new HazelArmorItem
            (ArmorItem.Type.CHESTPLATE,
             ItemPropertiesHelper
                     .equipment()
                     .rarity(Rarity.EPIC)
                     .fireResistant()
    ));
    public static final RegistryObject<Item> BIG_HAZEL_CHESTPLATE = ITEMS.register("how_did_you_find_the_hazel_chestplate", () -> new BigHazelArmorItem
            (ArmorItem.Type.CHESTPLATE,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            ));
    public static final RegistryObject<Item> HAZEL_LEGGINGS = ITEMS.register("hazel_leggings", () -> new HazelArmorItem
            (ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()
    ));
    public static final RegistryObject<Item> HAZEL_BOOTS = ITEMS.register("hazel_boots", () -> new HazelArmorItem
            (ArmorItem.Type.BOOTS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

    ));

    // Blazeborne Armor
    public static final RegistryObject<Item> BLAZEBORNE_HELMET = ITEMS.register("blazeborne_helmet", () -> new BlazeborneArmorItem
            (ArmorItem.Type.HELMET,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            ));
    public static final RegistryObject<Item> BLAZEBORNE_CHESTPLATE = ITEMS.register("blazeborne_chestplate", () -> new BlazeborneArmorItem
            (ArmorItem.Type.CHESTPLATE,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            ));
    public static final RegistryObject<Item> BLAZEBORNE_LEGGINGS = ITEMS.register("blazeborne_leggings", () -> new BlazeborneArmorItem
            (ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()
            ));
    public static final RegistryObject<Item> BLAZEBORNE_BOOTS = ITEMS.register("blazeborne_boots", () -> new BlazeborneArmorItem
            (ArmorItem.Type.BOOTS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));

    // Blazeborne Armor
    public static final RegistryObject<Item> CRYOGENIC_RULER_HELMET = ITEMS.register("cryogenic_ruler_helmet", () -> new CryogenicRulerArmorItem
            (ArmorItem.Type.HELMET,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            ));
    public static final RegistryObject<Item> CRYOGENIC_RULER_CHESTPLATE = ITEMS.register("cryogenic_ruler_chestplate", () -> new CryogenicRulerArmorItem
            (ArmorItem.Type.CHESTPLATE,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            ));
    public static final RegistryObject<Item> CRYOGENIC_RULER_LEGGINGS = ITEMS.register("cryogenic_ruler_leggings", () -> new CryogenicRulerArmorItem
            (ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()
            ));
    public static final RegistryObject<Item> CRYOGENIC_RULER_BOOTS = ITEMS.register("cryogenic_ruler_boots", () -> new CryogenicRulerArmorItem
            (ArmorItem.Type.BOOTS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));

    // Blazeborne Armor
    public static final RegistryObject<Item> CREAKING_SORCERER_HELMET = ITEMS.register("creaking_sorcerer_helmet", () -> new CreakingSorcererArmorItem
            (ArmorItem.Type.HELMET,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            ));
    public static final RegistryObject<Item> CREAKING_SORCERER_CHESTPLATE = ITEMS.register("creaking_sorcerer_chestplate", () -> new CreakingSorcererArmorItem
            (ArmorItem.Type.CHESTPLATE,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            ));
    public static final RegistryObject<Item> CREAKING_SORCERER_LEGGINGS = ITEMS.register("creaking_sorcerer_leggings", () -> new CreakingSorcererArmorItem
            (ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()
            ));
    public static final RegistryObject<Item> CREAKING_SORCERER_BOOTS = ITEMS.register("creaking_sorcerer_boots", () -> new CreakingSorcererArmorItem
            (ArmorItem.Type.BOOTS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));

    // Blazeborne Armor
    public static final RegistryObject<Item> THUNDER_PROWLER_HELMET = ITEMS.register("thunder_prowler_helmet", () -> new ThunderProwlerArmorItem
            (ArmorItem.Type.HELMET,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            ));
    public static final RegistryObject<Item> THUNDER_PROWLER_CHESTPLATE = ITEMS.register("thunder_prowler_chestplate", () -> new ThunderProwlerArmorItem
            (ArmorItem.Type.CHESTPLATE,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            ));
    public static final RegistryObject<Item> THUNDER_PROWLER_LEGGINGS = ITEMS.register("thunder_prowler_leggings", () -> new ThunderProwlerArmorItem
            (ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()
            ));
    public static final RegistryObject<Item> THUNDER_PROWLER_BOOTS = ITEMS.register("thunder_prowler_boots", () -> new ThunderProwlerArmorItem
            (ArmorItem.Type.BOOTS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));

    // Blazeborne Armor
    public static final RegistryObject<Item> ENDER_DRAGON_HELMET = ITEMS.register("ender_dragon_helmet", () -> new EnderDragonArmorItem
            (ArmorItem.Type.HELMET,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            ));
    public static final RegistryObject<Item> ENDER_DRAGON_CHESTPLATE = ITEMS.register("ender_dragon_chestplate", () -> new EnderDragonArmorItem
            (ArmorItem.Type.CHESTPLATE,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            ));
    public static final RegistryObject<Item> ENDER_DRAGON_LEGGINGS = ITEMS.register("ender_dragon_leggings", () -> new EnderDragonArmorItem
            (ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()
            ));
    public static final RegistryObject<Item> ENDER_DRAGON_BOOTS = ITEMS.register("ender_dragon_boots", () -> new EnderDragonArmorItem
            (ArmorItem.Type.BOOTS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));

    // Blazeborne Armor
    public static final RegistryObject<Item> FLESH_MASS_HELMET = ITEMS.register("flesh_mass_helmet", () -> new FleshMassArmorItem
            (ArmorItem.Type.HELMET,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            ));
    public static final RegistryObject<Item> FLESH_MASS_CHESTPLATE = ITEMS.register("flesh_mass_chestplate", () -> new FleshMassArmorItem
            (ArmorItem.Type.CHESTPLATE,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            ));
    public static final RegistryObject<Item> FLESH_MASS_LEGGINGS = ITEMS.register("flesh_mass_leggings", () -> new FleshMassArmorItem
            (ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()
            ));
    public static final RegistryObject<Item> FLESH_MASS_BOOTS = ITEMS.register("flesh_mass_boots", () -> new FleshMassArmorItem
            (ArmorItem.Type.BOOTS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));

    // Blazeborne Armor
    public static final RegistryObject<Item> ALCHEMIST_SUPREME_CHESTPLATE = ITEMS.register("alchemist_supreme_chestplate", () -> new AlchemistSupremeArmorItem
            (ArmorItem.Type.CHESTPLATE,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            ));
    public static final RegistryObject<Item> ALCHEMIST_SUPREME_HELMET = ITEMS.register("alchemist_supreme_helmet", () -> new AlchemistSupremeArmorItem
            (ArmorItem.Type.HELMET,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            ));
    public static final RegistryObject<Item> ALCHEMIST_SUPREME_LEGGINGS = ITEMS.register("alchemist_supreme_leggings", () -> new AlchemistSupremeArmorItem
            (ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()
            ));
    public static final RegistryObject<Item> ALCHEMIST_SUPREME_BOOTS = ITEMS.register("alchemist_supreme_boots", () -> new AlchemistSupremeArmorItem
            (ArmorItem.Type.BOOTS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));

    // Blazeborne Armor
    public static final RegistryObject<Item> SERAPH_HELMET = ITEMS.register("seraph_helmet", () -> new SeraphArmorItem
            (ArmorItem.Type.HELMET,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            ));
    public static final RegistryObject<Item> SERAPH_CHESTPLATE = ITEMS.register("seraph_chestplate", () -> new SeraphArmorItem
            (ArmorItem.Type.CHESTPLATE,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            ));
    public static final RegistryObject<Item> SERAPH_LEGGINGS = ITEMS.register("seraph_leggings", () -> new SeraphArmorItem
            (ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()
            ));
    public static final RegistryObject<Item> SERAPH_BOOTS = ITEMS.register("seraph_boots", () -> new SeraphArmorItem
            (ArmorItem.Type.BOOTS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));

    // Infestation Armor
    public static final RegistryObject<Item> INFESTATION_HELMET = ITEMS.register("infestation_helmet", () -> new InfestationArmorItem
            (ArmorItem.Type.HELMET,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            ));
    public static final RegistryObject<Item> INFESTATION_CHESTPLATE = ITEMS.register("infestation_chestplate", () -> new InfestationArmorItem
            (ArmorItem.Type.CHESTPLATE,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            ));
    public static final RegistryObject<Item> INFESTATION_LEGGINGS = ITEMS.register("infestation_leggings", () -> new InfestationArmorItem
            (ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()
            ));
    public static final RegistryObject<Item> INFESTATION_BOOTS = ITEMS.register("infestation_boots", () -> new InfestationArmorItem
            (ArmorItem.Type.BOOTS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));

    // Fireblossom Battlemage Armor
    public static final RegistryObject<Item> FIREBLOSSOM_BATTLEMAGE_HELMET = ITEMS.register("fireblossom_battlemage_helmet", () -> new FireblossomBattlemageHelmetArmorItem
            (ArmorItem.Type.HELMET,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            ));
    public static final RegistryObject<Item> FIREBLOSSOM_BATTLEMAGE_CROWN = ITEMS.register("fireblossom_battlemage_crown", () -> new FireblossomBattlemageCrownArmorItem
            (ArmorItem.Type.HELMET,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            ));
    public static final RegistryObject<Item> FIREBLOSSOM_BATTLEMAGE_CHESTPLATE = ITEMS.register("fireblossom_battlemage_chestplate", () -> new FireblossomBattlemageArmorItem
            (ArmorItem.Type.CHESTPLATE,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()
            ));
    public static final RegistryObject<Item> FIREBLOSSOM_BATTLEMAGE_LEGGINGS = ITEMS.register("fireblossom_battlemage_leggings", () -> new FireblossomBattlemageArmorItem
            (ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()
            ));
    public static final RegistryObject<Item> FIREBLOSSOM_BATTLEMAGE_BOOTS = ITEMS.register("fireblossom_battlemage_boots", () -> new FireblossomBattlemageArmorItem
            (ArmorItem.Type.BOOTS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}