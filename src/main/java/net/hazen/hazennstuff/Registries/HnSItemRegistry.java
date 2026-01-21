package net.hazen.hazennstuff.Registries;

import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.DedicatedArmorSets.AtlasArmor.AtlasArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.MithrilTier.MithrilBattlemage.MithrilBattlemageArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.AlchemistSupreme.AlchemistSupremeArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.Blazeborne.BlazeborneArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.CreakingSorcerer.CreakingSorcererArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.CryogenicRuler.CryogenicRulerArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.EnderDragon.EnderDragonArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.DedicatedArmorSets.FireblossomBattlemage.Crown.FireblossomBattlemageCrownArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.DedicatedArmorSets.FireblossomBattlemage.FireblossomBattlemageArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.DedicatedArmorSets.FireblossomBattlemage.Helmet.FireblossomBattlemageHelmetArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.FleshMass.FleshMassArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.Hazel.BigHazelArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.Hazel.HazelArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.Infestation.InfestationArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.Seraph.SeraphArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.PureTier.ThunderProwler.ThunderProwlerArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.PyriumTier.LegionnaireCommander.LegionnaireCommanderArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.PyriumTier.LegionnaireRuler.LegionnaireRulerArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.PyriumTier.Pyrium.PyriumArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.PyriumTier.PyriumBattlemage.PyriumBattlemageArmorItem;
import net.hazen.hazennstuff.Items.Equipment.Staves.BlossomOfTheEnchantress.BlossomOfTheEnchantress;
import net.hazen.hazennstuff.Items.Equipment.Staves.DivineScepter.DivineScepter;
import net.hazen.hazennstuff.Items.Equipment.Staves.EnderconicScepter.EnderconicScepter;
import net.hazen.hazennstuff.Items.Equipment.Staves.GrimoireStaff.GrimoireStaff;
import net.hazen.hazennstuff.Items.Equipment.Staves.InsaniaAeternum.InsaniaAeternus;
import net.hazen.hazennstuff.Items.Equipment.Weapons.Devastator.DevastatorItem;
import net.hazen.hazennstuff.Items.Equipment.Weapons.DragonSplitter.DraconicSplitterItem;
import net.hazen.hazennstuff.Items.Equipment.Weapons.Excalibur.ExcaliburItem;
import net.hazen.hazennstuff.Items.Equipment.Weapons.FireblossomRapier.FireblossomRapierItem;
import net.hazen.hazennstuff.Items.Equipment.Weapons.IcePike.IcePikeItem;
import net.hazen.hazennstuff.Items.Equipment.Weapons.IonicSplitter.IonicSplitterItem;
import net.hazen.hazennstuff.Items.Equipment.Weapons.LegionnaireWarAxe.LegionnaireWarlockAxeItem;
import net.hazen.hazennstuff.Items.Equipment.Weapons.OFortuna.OFortunaItem;
import net.hazen.hazennstuff.Items.Equipment.Weapons.Provocation.ProvocationItem;
import net.hazen.hazennstuff.Items.Equipment.Weapons.RavensBane.RavensBaneItem;
import net.hazen.hazennstuff.Items.Equipment.Weapons.TheDevourer.TheDevourerItem;
import net.hazen.hazennstuff.Items.Equipment.Weapons.Umbranova.UmbranovaItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HnSItemRegistry {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HazenNStuff.MOD_ID);

    /*
     *** Materials *****************************************************************************************************
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

    public static final RegistryObject<Item> DIVINE_MOLD = ITEMS.register("divine_mold",
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

    public static final RegistryObject<Item> PYRIUM_NUGGET = ITEMS.register("pyrium_nugget",
            () -> new Item(new Item
                    .Properties()
            ));

    /*
    *** Weapons ********************************************************************************************************
     */

    /*
    *** Fire
     */

    // Fireblossom Rapier
    public static final RegistryObject<Item> FIREBLOSSOM_RAPIER = ITEMS.register("fireblossom_rapier", () -> new FireblossomRapierItem(
                    SpellDataRegistryHolder.of(
                            new SpellDataRegistryHolder(SpellRegistry.FLAMING_STRIKE_SPELL, 5))
            )
    );

    // Draconic Splitter
    public static final RegistryObject<Item> DRACONIC_SPLITTER = ITEMS.register("draconic_splitter", () -> new DraconicSplitterItem(
                    SpellDataRegistryHolder.of(
                            new SpellDataRegistryHolder(SpellRegistry.FIRE_BREATH_SPELL, 10))
            )
    );

    // Raven's Bane
    public static final RegistryObject<Item> RAVENS_BANE = ITEMS.register("ravens_bane", () -> new RavensBaneItem(
                    SpellDataRegistryHolder.of(
                            new SpellDataRegistryHolder(SpellRegistry.RAISE_HELL_SPELL, 5))
            )
    );

    /*
    *** Ice
     */

    // Ice Pike
    public static final RegistryObject<Item> ICE_PIKE = ITEMS.register("ice_pike", () -> new IcePikeItem(
                    SpellDataRegistryHolder.of(
                            new SpellDataRegistryHolder(SpellRegistry.ICE_SPIKES_SPELL, 5))
            )
    );

    /*
     *** Nature
     */

    // O' Fortuna
    public static final RegistryObject<Item> O_FORTUNA = ITEMS.register("o_fortuna", () -> new OFortunaItem(
                    SpellDataRegistryHolder.of(
                            new SpellDataRegistryHolder(SpellRegistry.POISON_SPLASH_SPELL, 5))
            )
    );

    /*
     *** Lightning
     */

    // Ionic Splitter
    public static final RegistryObject<Item> IONIC_SPLITTER = ITEMS.register("ionic_splitter", () -> new IonicSplitterItem(
                    SpellDataRegistryHolder.of(
                            new SpellDataRegistryHolder(SpellRegistry.CHAIN_LIGHTNING_SPELL, 5))
            )
    );

    /*
     *** Ender
     */

    // Umbranova
    public static final RegistryObject<Item> UMBRANOVA = ITEMS.register("umbranova", () -> new UmbranovaItem(
                    SpellDataRegistryHolder.of(
                            new SpellDataRegistryHolder(SpellRegistry.ECHOING_STRIKES_SPELL, 5))
            )
    );

    /*
     *** Blood
     */

    // Devastator
    public static final RegistryObject<Item> DEVASTATOR = ITEMS.register("devastator", () -> new DevastatorItem(
                    SpellDataRegistryHolder.of(
                            new SpellDataRegistryHolder(SpellRegistry.BLOOD_SLASH_SPELL, 5))
            )
    );

    /*
     *** Evocation
     */

    // Provocation
    public static final RegistryObject<Item> PROVOCATION = ITEMS.register("provocation", () -> new ProvocationItem(
                    SpellDataRegistryHolder.of(
                            new SpellDataRegistryHolder(SpellRegistry.ARROW_VOLLEY_SPELL, 6))
            )
    );

    /*
     *** Holy
     */

    // Excalibur
    public static final RegistryObject<Item> EXCALIBUR = ITEMS.register("excalibur", () -> new ExcaliburItem(
                    SpellDataRegistryHolder.of(
                            new SpellDataRegistryHolder(SpellRegistry.DIVINE_SMITE_SPELL, 5))
            )
    );

    /*
     *** Eldritch
     */

    // The Devourer
    public static final RegistryObject<Item> THE_DEVOURER = ITEMS.register("the_devourer", () -> new TheDevourerItem(
                    SpellDataRegistryHolder.of(
                            new SpellDataRegistryHolder(SpellRegistry.ELDRITCH_BLAST_SPELL, 5))
            )
    );

    /*
    *** Misc
     */

    // The Devourer
    public static final RegistryObject<Item> LEGIONNAIRE_WARLOCK_AXE = ITEMS.register("legionnaire_warlock_axe", () -> new LegionnaireWarlockAxeItem(
                    SpellDataRegistryHolder.of(
                            new SpellDataRegistryHolder(SpellRegistry.RAISE_HELL_SPELL, 5))
            )
    );

    /*
     *** Staves ********************************************************************************************************
     */

    // Enderconic Scepter
    public static final RegistryObject<Item> ENDERCONIC_SCEPTER = ITEMS.register
            ("enderconic_scepter", EnderconicScepter::new);

    // Divine Scepter
    public static final RegistryObject<Item> DIVINE_SCEPTER = ITEMS.register
            ("divine_scepter", DivineScepter::new);

    // Grimoire Staff
    public static final RegistryObject<Item> GRIMOIRE_STAFF = ITEMS.register
            ("grimoire_staff", GrimoireStaff::new);

    // Insania Aeternum
    public static final RegistryObject<Item> INSANIA_AETERNUS = ITEMS.register
            ("insania_aeternus", InsaniaAeternus::new);

    // Blossom of the Enchantress
    public static final RegistryObject<Item> BLOSSOM_OF_THE_ENCHANTRESS = ITEMS.register
            ("blossom_of_the_enchantress", BlossomOfTheEnchantress::new);

    /*
     *** Armor *********************************************************************************************************
     */

    /*
    *** Fire
     */

    // Hazel
    public static final RegistryObject<Item> HAZEL_HELMET = ITEMS.register("hazel_helmet", () -> new HazelArmorItem
            (ArmorItem.Type.HELMET, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> HAZEL_CHESTPLATE = ITEMS.register("hazel_chestplate", () -> new HazelArmorItem
            (ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> BIG_HAZEL_CHESTPLATE = ITEMS.register("how_did_you_find_the_hazel_chestplate", () -> new BigHazelArmorItem
            (ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
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

    // Blazeborne
    public static final RegistryObject<Item> BLAZEBORNE_HELMET = ITEMS.register("blazeborne_helmet", () -> new BlazeborneArmorItem
            (ArmorItem.Type.HELMET, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> BLAZEBORNE_CHESTPLATE = ITEMS.register("blazeborne_chestplate", () -> new BlazeborneArmorItem
            (ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
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

    /*
    *** Ice
     */

    // Cryogenic Ruler
    public static final RegistryObject<Item> CRYOGENIC_RULER_HELMET = ITEMS.register("cryogenic_ruler_helmet", () -> new CryogenicRulerArmorItem
            (ArmorItem.Type.HELMET, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> CRYOGENIC_RULER_CHESTPLATE = ITEMS.register("cryogenic_ruler_chestplate", () -> new CryogenicRulerArmorItem
            (ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
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

    /*
    *** Nature
     */

    // Creaking Sorcerer
    public static final RegistryObject<Item> CREAKING_SORCERER_HELMET = ITEMS.register("creaking_sorcerer_helmet", () -> new CreakingSorcererArmorItem
            (ArmorItem.Type.HELMET, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> CREAKING_SORCERER_CHESTPLATE = ITEMS.register("creaking_sorcerer_chestplate", () -> new CreakingSorcererArmorItem
            (ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
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

    /*
    *** Lightning
     */

    // Thunder Prowler
    public static final RegistryObject<Item> THUNDER_PROWLER_HELMET = ITEMS.register("thunder_prowler_helmet", () -> new ThunderProwlerArmorItem
            (ArmorItem.Type.HELMET, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> THUNDER_PROWLER_CHESTPLATE = ITEMS.register("thunder_prowler_chestplate", () -> new ThunderProwlerArmorItem
            (ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
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

    /*
    *** Ender
     */

    // Ender Dragon
    public static final RegistryObject<Item> ENDER_DRAGON_HELMET = ITEMS.register("ender_dragon_helmet", () -> new EnderDragonArmorItem
            (ArmorItem.Type.HELMET, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> ENDER_DRAGON_CHESTPLATE = ITEMS.register("ender_dragon_chestplate", () -> new EnderDragonArmorItem
            (ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
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

    /*
    *** Blood
     */

    // Flesh Mass
    public static final RegistryObject<Item> FLESH_MASS_HELMET = ITEMS.register("flesh_mass_helmet", () -> new FleshMassArmorItem
            (ArmorItem.Type.HELMET, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> FLESH_MASS_CHESTPLATE = ITEMS.register("flesh_mass_chestplate", () -> new FleshMassArmorItem
            (ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
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

    /*
    *** Evocation
     */

    // Alchemist Supreme
    public static final RegistryObject<Item> ALCHEMIST_SUPREME_CHESTPLATE = ITEMS.register("alchemist_supreme_chestplate", () -> new AlchemistSupremeArmorItem
            (ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> ALCHEMIST_SUPREME_HELMET = ITEMS.register("alchemist_supreme_helmet", () -> new AlchemistSupremeArmorItem
            (ArmorItem.Type.HELMET, ItemPropertiesHelper
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

    /*
    *** Holy
     */

    // Seraph
    public static final RegistryObject<Item> SERAPH_HELMET = ITEMS.register("seraph_helmet", () -> new SeraphArmorItem
            (ArmorItem.Type.HELMET, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> SERAPH_CHESTPLATE = ITEMS.register("seraph_chestplate", () -> new SeraphArmorItem
            (ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
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

    /*
    *** Eldritch
     */

    // Infestation
    public static final RegistryObject<Item> INFESTATION_HELMET = ITEMS.register("infestation_helmet", () -> new InfestationArmorItem
            (ArmorItem.Type.HELMET, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> INFESTATION_CHESTPLATE = ITEMS.register("infestation_chestplate", () -> new InfestationArmorItem
            (ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
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

    /*
     *** Misc
     */

    // Pyrium
    public static final RegistryObject<Item> PYRIUM_HELMET = ITEMS.register("pyrium_helmet", () -> new PyriumArmorItem
            (ArmorItem.Type.HELMET, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> PYRIUM_CHESTPLATE = ITEMS.register("pyrium_chestplate", () -> new PyriumArmorItem
            (ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> PYRIUM_LEGGINGS = ITEMS.register("pyrium_leggings", () -> new PyriumArmorItem
            (ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> PYRIUM_BOOTS = ITEMS.register("pyrium_boots", () -> new PyriumArmorItem
            (ArmorItem.Type.BOOTS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));

    // Pyrium
    public static final RegistryObject<Item>PYRIUM_BATTLEMAGE_HELMET = ITEMS.register("pyrium_battlemage_helmet", () -> new PyriumBattlemageArmorItem
            (ArmorItem.Type.HELMET, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> PYRIUM_BATTLEMAGE_CHESTPLATE = ITEMS.register("pyrium_battlemage_chestplate", () -> new PyriumBattlemageArmorItem
            (ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> PYRIUM_BATTLEMAGE_LEGGINGS = ITEMS.register("pyrium_battlemage_leggings", () -> new PyriumBattlemageArmorItem
            (ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> PYRIUM_BATTLEMAGE_BOOTS = ITEMS.register("pyrium_battlemage_boots", () -> new PyriumBattlemageArmorItem
            (ArmorItem.Type.BOOTS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));

    // Legionnaire Ruler
    public static final RegistryObject<Item> LEGIONNAIRE_RULER_HELMET = ITEMS.register("legionnaire_ruler_helmet", () -> new LegionnaireRulerArmorItem
            (ArmorItem.Type.HELMET, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> LEGIONNAIRE_RULER_CHESTPLATE = ITEMS.register("legionnaire_ruler_chestplate", () -> new LegionnaireRulerArmorItem
            (ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> LEGIONNAIRE_RULER_LEGGINGS = ITEMS.register("legionnaire_ruler_leggings", () -> new LegionnaireRulerArmorItem
            (ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> LEGIONNAIRE_RULER_BOOTS = ITEMS.register("legionnaire_ruler_boots", () -> new LegionnaireRulerArmorItem
            (ArmorItem.Type.BOOTS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));

    // Legionnaire Commander
    public static final RegistryObject<Item> LEGIONNAIRE_COMMANDER_HELMET = ITEMS.register("legionnaire_commander_helmet", () -> new LegionnaireCommanderArmorItem
            (ArmorItem.Type.HELMET, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> LEGIONNAIRE_COMMANDER_CHESTPLATE = ITEMS.register("legionnaire_commander_chestplate", () -> new LegionnaireCommanderArmorItem
            (ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> LEGIONNAIRE_COMMANDER_LEGGINGS = ITEMS.register("legionnaire_commander_leggings", () -> new LegionnaireCommanderArmorItem
            (ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> LEGIONNAIRE_COMMANDER_BOOTS = ITEMS.register("legionnaire_commander_boots", () -> new LegionnaireCommanderArmorItem
            (ArmorItem.Type.BOOTS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));

    // Mithril Battlemage
    public static final RegistryObject<Item> MITHRIL_BATTLEMAGE_HELMET = ITEMS.register("mithril_battlemage_helmet", () -> new MithrilBattlemageArmorItem
            (ArmorItem.Type.HELMET, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> MITHRIL_BATTLEMAGE_CHESTPLATE = ITEMS.register("mithril_battlemage_chestplate", () -> new MithrilBattlemageArmorItem
            (ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> MITHRIL_BATTLEMAGE_LEGGINGS = ITEMS.register("mithril_battlemage_leggings", () -> new MithrilBattlemageArmorItem
            (ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> MITHRIL_BATTLEMAGE_BOOTS = ITEMS.register("mithril_battlemage_boots", () -> new MithrilBattlemageArmorItem
            (ArmorItem.Type.BOOTS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));

    /*
    *** Dedicated
     */

    // Fireblossom Battlemage
    public static final RegistryObject<Item> FIREBLOSSOM_BATTLEMAGE_HELMET = ITEMS.register("fireblossom_battlemage_helmet", () -> new FireblossomBattlemageHelmetArmorItem
            (ArmorItem.Type.HELMET, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> FIREBLOSSOM_BATTLEMAGE_CROWN = ITEMS.register("fireblossom_battlemage_crown", () -> new FireblossomBattlemageCrownArmorItem
            (ArmorItem.Type.HELMET, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> FIREBLOSSOM_BATTLEMAGE_CHESTPLATE = ITEMS.register("fireblossom_battlemage_chestplate", () -> new FireblossomBattlemageArmorItem
            (ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
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

    public static final RegistryObject<Item> ATLAS_HELMET = ITEMS.register("atlas_helmet", () -> new AtlasArmorItem
            (ArmorItem.Type.HELMET,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()

            ));
    public static final RegistryObject<Item> ATLAS_CHESTPLATE = ITEMS.register("atlas_chestplate", () -> new AtlasArmorItem
            (ArmorItem.Type.CHESTPLATE,
                    ItemPropertiesHelper
                            .equipment()
                            .rarity(Rarity.EPIC)
                            .fireResistant()

            ));
    public static final RegistryObject<Item> ATLAS_LEGGINGS = ITEMS.register("atlas_leggings", () -> new AtlasArmorItem
            (ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));
    public static final RegistryObject<Item> ATLAS_BOOTS = ITEMS.register("atlas_boots", () -> new AtlasArmorItem
            (ArmorItem.Type.BOOTS, ItemPropertiesHelper
                    .equipment()
                    .rarity(Rarity.EPIC)
                    .fireResistant()

            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}