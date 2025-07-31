package net.hazen.hazennstuff.registries;

import io.redspace.ironsspellbooks.item.UpgradeOrbItem;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import io.redspace.ironsspellbooks.render.CinderousRarity;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.block.custom.ModFlammableRotatedPillarBlock;
import net.hazen.hazennstuff.item.armor.AzureLib.ArbitriumRobes.ArbitriumRobesArmorItem;
import net.hazen.hazennstuff.item.armor.AzureLib.CreakingSorcerer.CreakingSorcererArmorItem;
import net.hazen.hazennstuff.item.armor.AzureLib.DarkRitualTemplar.DarkRitualTemplarArmorItem;
import net.hazen.hazennstuff.item.armor.AzureLib.EnderDragon.EnderDragonArmorItem;
import net.hazen.hazennstuff.item.armor.AzureLib.FireblossomBattlemage.FireblossomBattlemageCrownedArmorItem;
import net.hazen.hazennstuff.item.armor.AzureLib.FireblossomBattlemage.FireblossomBattlemageHelmetArmorItem;
import net.hazen.hazennstuff.item.armor.AzureLib.SLCCat.SLCCatArmorItem;
import net.hazen.hazennstuff.item.armor.AzureLib.Seraph.SeraphArmorItem;
import net.hazen.hazennstuff.item.armor.AzureLib.SoulFlame.SoulFlameArmorItem;
import net.hazen.hazennstuff.item.armor.AzureLib.SupremeWitch.SupremeWitchArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.ArbitriumRobes.ArbitriumRobesGeckolibArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Atlas.AtlasArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Calamitas.CalamitasArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.ChargedScourge.GeckolibChargedScourgeArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.CreakingSorcerer.GeckolibCreakingSorcererArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.CryogenicRuler.GeckolibCryogenicRulerArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.DarkRitualTemplar.GeckolibDarkRitualTemplarArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.EnderDragon.GeckolibEnderDragonArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.FireblossomBattlemage.GeckolibFireblossomBattlemageCrownedArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.FireblossomBattlemage.GeckolibFireblossomBattlemageHelmetArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.FleshMass.FleshMassArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Frieren.GeckolibFrierenArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Legionnaire.GeckolibLegionnaireArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Maverick.MaverickArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Miner.MinerArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.ProjectSekai.GeckolibProjectSekaiArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.RottenGirl.GeckolibRottenGirlArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Seraph.GeckolibSeraphArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.SoulFlame.GeckolibSoulFlameArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.SpectralSpelunker.SpectralSpelunkerArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.SupremeWitch.GeckolibSupremeWitchArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.SynthesizerV.GeckolibSynthesizerVArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Utau.GeckolibUtauArmorItem;
import net.hazen.hazennstuff.item.curios.*;
import net.hazen.hazennstuff.item.curios.Wings.AngelWings.AngelWings;
import net.hazen.hazennstuff.item.staves.rod_of_discord.RodOfDiscordItem;
import net.hazen.hazennstuff.item.staves.wisewood_cane.WisewoodCaneItem;
import net.hazen.hazennstuff.item.util.spectral_pickaxe.SpectralPickaxeItem;
import net.hazen.hazennstuff.item.weapons.ancient_warriors_axe.AncientWarriorsAxeItem;
import net.hazen.hazennstuff.item.weapons.beongae.BeongaeItem;
import net.hazen.hazennstuff.item.weapons.bountiful_harvest.BountifulHarvestItem;
import net.hazen.hazennstuff.item.weapons.fireblossom_rapier.FireblossomRapierItem;
import net.hazen.hazennstuff.item.weapons.hammer_of_justice.HammerOfJusticeItem;
import net.hazen.hazennstuff.item.weapons.ice_pike.IcePikeItem;
import net.hazen.hazennstuff.item.weapons.lights_bane.LightsBaneItem;
import net.hazen.hazennstuff.item.weapons.skyscorcher.SkyscorcherItem;
import net.hazen.hazennstuff.item.weapons.vampire_knives.VampireKnivesItem;
import net.hazen.hazennstuff.rarity.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.hazen.hazennstuff.item.staves.frieren.FrierenStaffItem;

import java.util.Collection;
import java.util.function.Supplier;

public class HnSItems {
    // Ace comment here, but as a tip for organization, leave some comments for whatever section of
    // Items you want to be organized
    // In DTE, I use comment blocks to organize between different types of items I have (armor, weapons, staves, etc.)
    // Just a little info for you!
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HazenNStuff.MOD_ID);

    /***
     * Upgrade orbs
     */

// Luminescent Upgrade Orb
    public static final DeferredHolder<Item, Item> LUMINESCENT_UPGRADE_ORB = ITEMS.register("luminescent_upgrade_orb",
            () -> new UpgradeOrbItem(ItemPropertiesHelper
                    .material()
                    .rarity(Rarity.UNCOMMON)
                    .component(ComponentRegistry.UPGRADE_ORB_TYPE, HnSUpgradeOrbTypeRegistry.LUMINESCENT_SPELL_POWER))
    );
    // Melee Upgrade Orb
    public static final DeferredHolder<Item, Item> MELEE_UPGRADE_ORB = ITEMS.register("melee_upgrade_orb",
            () -> new UpgradeOrbItem(ItemPropertiesHelper
                    .material()
                    .rarity(Rarity.UNCOMMON)
                    .component(ComponentRegistry.UPGRADE_ORB_TYPE, HnSUpgradeOrbTypeRegistry.MELEE_POWER))
    );
    // Health Upgrade Orb
    public static final DeferredHolder<Item, Item> HEALTH_UPGRADE_ORB = ITEMS.register("health_upgrade_orb",
            () -> new UpgradeOrbItem(ItemPropertiesHelper
                    .material()
                    .rarity(Rarity.UNCOMMON)
                    .component(ComponentRegistry.UPGRADE_ORB_TYPE, HnSUpgradeOrbTypeRegistry.HEALTH_POWER))
    );
    // Archery Upgrade Orb
    public static final DeferredHolder<Item, Item> ARCHERY_UPGRADE_ORB = ITEMS.register("archery_upgrade_orb",
            () -> new UpgradeOrbItem(ItemPropertiesHelper
                    .material()
                    .rarity(Rarity.UNCOMMON)
                    .component(ComponentRegistry.UPGRADE_ORB_TYPE, HnSUpgradeOrbTypeRegistry.ARCHERY_POWER))
    );




    /***
     * Materials
     */

    //Raw Zenalite
    public static final DeferredItem<Item> RAW_ZENALITE = ITEMS.register("raw_zenalite",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.EPIC)
                    .fireResistant())

    );
    //Starkissed Zenalite
    public static final DeferredItem<Item> STARKISSED_ZENALITE = ITEMS.register("starkissed_zenalite",
            () -> new Item(new Item
                    .Properties()
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
                    .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
                    .fireResistant())
    );
    // Zenalite Ingot
    public static final DeferredItem<Item> ZENALITE_INGOT = ITEMS.register("zenalite_ingot",
            () -> new Item(new Item
                    .Properties()
                    .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
                    .fireResistant())

    );
    // Pyrium Nugget
    public static final DeferredItem<Item> PYRIUM_NUGGET = ITEMS.register("pyrium_nugget",
            () -> new Item(new Item
                    .Properties()
                    .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
                    .fireResistant())

    );
    // Silver Scrap
    public static final DeferredItem<Item> SILVER_SCRAPS = ITEMS.register("silver_scraps",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.EPIC)
                    .fireResistant())

    );
    //Excalibur
    public static final DeferredItem<Item> EXCALIBUR_FRAGMENT = ITEMS.register("excalibur_fragment",
            () -> new Item(new Item
                    .Properties()
                    .rarity(DivineRarity.DIVINE_RARITY_PROXY.getValue())
                    .fireResistant())

    );
    //Divine Mold
    public static final DeferredItem<Item> DIVINE_MOLD = ITEMS.register("divine_mold",
            () -> new Item(new Item
                    .Properties()
                    .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
                    .fireResistant()
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true))

    );
    //Deus Essence
    public static final DeferredItem<Item> DEUS_ESSENCE = ITEMS.register("deus_essence",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.EPIC)
                    .fireResistant()
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true))

    );
    //Runestone Fragment
    public static final DeferredItem<Item> RUNESTONE_FRAGMENTS = ITEMS.register("runestone_fragments",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.RARE)
                    .fireResistant())

    );
    //Permafrost Fragment
    public static final DeferredItem<Item> PERMAFROST_FRAGMENT = ITEMS.register("permafrost_fragment",
            () -> new Item(new Item
                    .Properties()
                    .rarity(CryogenicRarity.CRYOGENIC_RARITY_PROXY.getValue())
                    .fireResistant())
    );
    //Charred Bones
    public static final DeferredItem<Item> CHARRED_BONES = ITEMS.register("charred_bones",
            () -> new Item(new Item
                    .Properties())
    );
    //Overgrown Bone
    public static final DeferredItem<Item> OVERGROWN_BONE = ITEMS.register("overgrown_bone",
            () -> new Item(new Item
                    .Properties())
    );
    //Flaming Template
    public static final DeferredItem<Item> FLAMING_TEMPLATE = ITEMS.register("flaming_template",
            () -> new Item(new Item
                    .Properties()
                    .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
                    .fireResistant())
    );

    /***
     * Weapons
     */

    //Ice Pike
    public static final DeferredHolder<Item, Item> ICE_PIKE = ITEMS.register("ice_pike", IcePikeItem::new);
    //Fireblossom Rapier
    public static final DeferredHolder<Item, Item> FIREBLOSSOM_RAPIER = ITEMS.register("fireblossom_rapier", FireblossomRapierItem::new);
    //Beongae
    public static final DeferredHolder<Item, Item> BEONGAE = ITEMS.register("beongae", BeongaeItem::new);
    //Ancient Warrior's Axe
    public static final DeferredHolder<Item, Item> ANCIENT_WARRIORS_AXE = ITEMS.register("ancient_warriors_axe", AncientWarriorsAxeItem::new);
    //Skyscorcher
    public static final DeferredHolder<Item, Item> SKYSCORCHER = ITEMS.register("skyscorcher", SkyscorcherItem::new);
    //Bountiful Harvest
    public static final DeferredHolder<Item, Item> BOUNTIFUL_HARVEST = ITEMS.register("bountiful_harvest", BountifulHarvestItem::new);
    //Hammer of Justice
    public static final DeferredHolder<Item, Item> HAMMER_OF_JUSTICE = ITEMS.register("hammer_of_justice", HammerOfJusticeItem::new);
    //Vampire Knives
    public static final DeferredHolder<Item, Item> VAMPIRE_KNIVES = ITEMS.register("vampire_knives", VampireKnivesItem::new);
    //Lights Bane
    public static final DeferredHolder<Item, Item> LIGHTS_BANE = ITEMS.register("lights_bane", LightsBaneItem::new);


    /***
     * Staves
     */

    //Frieren's Staff
    public static final DeferredHolder<Item, Item> FRIEREN_STAFF = ITEMS.register("frieren_staff", FrierenStaffItem::new);
    //Wisewood Cane
    public static final DeferredHolder<Item, Item> WISEWOOD_CANE = ITEMS.register("wisewood_cane", WisewoodCaneItem::new);
    //Rod of Discord
    public static final DeferredHolder<Item, Item> ROD_OF_DISCORD = ITEMS.register("rod_of_discord", RodOfDiscordItem::new);

    /***
     * Tools
     */

    //Spectral Pickaxe
    public static final DeferredHolder<Item, Item> SPECTRAL_PICKAXE = ITEMS.register("spectral_pickaxe", SpectralPickaxeItem::new);

    /***
     * Curios
     */

        //Mana Crystals

    //Ruptured
    public static final DeferredItem<RupturedCurio> RUPTURED = ITEMS.register("ruptured", RupturedCurio::new);
    //Refined
    public static final DeferredItem<RefinedCurio> REFINED = ITEMS.register("refined", RefinedCurio::new);
    //Reinforced
    public static final DeferredItem<ReinforcedCurio> REINFORCED = ITEMS.register("reinforced", ReinforcedCurio::new);
    //Radiance
    public static final DeferredItem<RadianceCurio> RADIANCE = ITEMS.register("radiance", RadianceCurio::new);

        // Wing
    // Radiance
    public static final DeferredItem<AngelWings> ANGEL_WINGS = ITEMS.register("angel_wings", AngelWings::new);



    /***
     * AzureLib Armor
     */


    //Creaking Armor

        public static final DeferredHolder<Item, Item> CREAKING_HELMET = ITEMS.register("creaking_helmet", () -> new CreakingSorcererArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(NatureRarity.NATURE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> CREAKING_CHESTPLATE = ITEMS.register("creaking_chestplate", () -> new CreakingSorcererArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(NatureRarity.NATURE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> CREAKING_LEGGINGS = ITEMS.register("creaking_leggings", () -> new CreakingSorcererArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(NatureRarity.NATURE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> CREAKING_BOOTS = ITEMS.register("creaking_boots", () -> new CreakingSorcererArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(NatureRarity.NATURE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Seraph Armor

    public static final DeferredHolder<Item, Item> SERAPH_HELMET = ITEMS.register("seraph_helmet", () -> new SeraphArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DivineRarity.DIVINE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> SERAPH_CHESTPLATE = ITEMS.register("seraph_chestplate", () -> new SeraphArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DivineRarity.DIVINE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> SERAPH_LEGGINGS = ITEMS.register("seraph_leggings", () -> new SeraphArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DivineRarity.DIVINE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> SERAPH_BOOTS = ITEMS.register("seraph_boots", () -> new SeraphArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DivineRarity.DIVINE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Soul Flame Armor

    public static final DeferredHolder<Item, Item> SOUL_FLAME_HELMET = ITEMS.register("soul_flame_helmet", () -> new SoulFlameArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> SOUL_FLAME_CHESTPLATE = ITEMS.register("soul_flame_chestplate", () -> new SoulFlameArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> SOUL_FLAME_LEGGINGS = ITEMS.register("soul_flame_leggings", () -> new SoulFlameArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> SOUL_FLAME_BOOTS = ITEMS.register("soul_flame_boots", () -> new SoulFlameArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Supreme Witch Armor

    public static final DeferredHolder<Item, Item> SUPREME_WITCH_HELMET = ITEMS.register("supreme_witch_helmet", () -> new SupremeWitchArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(EvocationRarity.EVOCATION_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> SUPREME_WITCH_CHESTPLATE = ITEMS.register("supreme_witch_chestplate", () -> new SupremeWitchArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(EvocationRarity.EVOCATION_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> SUPREME_WITCH_LEGGINGS = ITEMS.register("supreme_witch_leggings", () -> new SupremeWitchArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(EvocationRarity.EVOCATION_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> SUPREME_WITCH_BOOTS = ITEMS.register("supreme_witch_boots", () -> new SupremeWitchArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(EvocationRarity.EVOCATION_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Ender Dragon Armor

    public static final DeferredHolder<Item, Item> ENDER_DRAGON_HELMET = ITEMS.register("ender_dragon_helmet", () -> new EnderDragonArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(EnderRarity.ENDER_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> ENDER_DRAGON_CHESTPLATE = ITEMS.register("ender_dragon_chestplate", () -> new EnderDragonArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(EnderRarity.ENDER_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> ENDER_DRAGON_LEGGINGS = ITEMS.register("ender_dragon_leggings", () -> new EnderDragonArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(EnderRarity.ENDER_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> ENDER_DRAGON_BOOTS = ITEMS.register("ender_dragon_boots", () -> new EnderDragonArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(EnderRarity.ENDER_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Dark Ritual Templar Armor

    public static final DeferredHolder<Item, Item> DARK_RITUAL_TEMPLAR_HELMET = ITEMS.register("dark_ritual_templar_helmet", () -> new DarkRitualTemplarArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(EldritchRarity.ELDRITCH_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> DARK_RITUAL_TEMPLAR_CHESTPLATE = ITEMS.register("dark_ritual_templar_chestplate", () -> new DarkRitualTemplarArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(EldritchRarity.ELDRITCH_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> DARK_RITUAL_TEMPLAR_LEGGINGS = ITEMS.register("dark_ritual_templar_leggings", () -> new DarkRitualTemplarArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(EldritchRarity.ELDRITCH_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> DARK_RITUAL_TEMPLAR_BOOTS = ITEMS.register("dark_ritual_templar_boots", () -> new DarkRitualTemplarArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(EldritchRarity.ELDRITCH_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Fireblossom Armor

    public static final DeferredHolder<Item, Item> FIREBLOSSOM_BATTLEMAGE_CROWN = ITEMS.register("fireblossom_crown", () -> new FireblossomBattlemageCrownedArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> FIREBLOSSOM_BATTLEMAGE_HELMET = ITEMS.register("fireblossom_helmet", () -> new FireblossomBattlemageHelmetArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> FIREBLOSSOM_BATTLEMAGE_CHESTPLATE = ITEMS.register("fireblossom_chestplate", () -> new FireblossomBattlemageHelmetArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> FIREBLOSSOM_BATTLEMAGE_LEGGINGS = ITEMS.register("fireblossom_leggings", () -> new FireblossomBattlemageHelmetArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> FIREBLOSSOM_BATTLEMAGE_BOOTS = ITEMS.register("fireblossom_boots", () -> new FireblossomBattlemageHelmetArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Dark Ritual Templar Armor

    public static final DeferredHolder<Item, Item> SLC_CAT_HELMET = ITEMS.register("slc_cat_helmet", () -> new SLCCatArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(EldritchRarity.ELDRITCH_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> SLC_CAT_CHESTPLATE = ITEMS.register("slc_cat_chestplate", () -> new SLCCatArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(EldritchRarity.ELDRITCH_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> SLC_CAT_LEGGINGS = ITEMS.register("slc_cat_leggings", () -> new SLCCatArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(EldritchRarity.ELDRITCH_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> SLC_CAT_BOOTS = ITEMS.register("slc_cat_boots", () -> new SLCCatArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(EldritchRarity.ELDRITCH_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));


    //Arbitrium Robes

    public static final DeferredHolder<Item, Item> ARBITRIUM_ROBES_HELMET = ITEMS.register("arbitrium_robes_helmet", () -> new ArbitriumRobesArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.HELMET.getDurability(90))

    ));
    public static final DeferredHolder<Item, Item> ARBITRIUM_ROBES_CHESTPLATE = ITEMS.register("arbitrium_robes_chestplate", () -> new ArbitriumRobesArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(90))));
    public static final DeferredHolder<Item, Item> ARBITRIUM_ROBES_LEGGINGS = ITEMS.register("arbitrium_robes_leggings", () -> new ArbitriumRobesArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(90))));
    public static final DeferredHolder<Item, Item> ARBITRIUM_ROBES_BOOTS = ITEMS.register("arbitrium_robes_boots", () -> new ArbitriumRobesArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.BOOTS.getDurability(90))));

    /***
     * GeckoLib Armor
     */


    //Frieren Armor

    public static final DeferredHolder<Item, Item> FRIEREN_HELMET = ITEMS.register("frieren_helmet", () -> new GeckolibFrierenArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final DeferredHolder<Item, Item> FRIEREN_CHESTPLATE = ITEMS.register("frieren_chestplate", () -> new GeckolibFrierenArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredHolder<Item, Item> FRIEREN_LEGGINGS = ITEMS.register("frieren_leggings", () -> new GeckolibFrierenArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final DeferredHolder<Item, Item> FRIEREN_BOOTS = ITEMS.register("frieren_boots", () -> new GeckolibFrierenArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.BOOTS.getDurability(37))));

    //Miner Armor

    public static final DeferredHolder<Item, Item> MINER_HELMET = ITEMS.register("miner_helmet", () -> new MinerArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final DeferredHolder<Item, Item> MINER_CHESTPLATE = ITEMS.register("miner_chestplate", () -> new MinerArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredHolder<Item, Item> MINER_LEGGINGS = ITEMS.register("miner_leggings", () -> new MinerArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final DeferredHolder<Item, Item> MINER_BOOTS = ITEMS.register("miner_boots", () -> new MinerArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.BOOTS.getDurability(37))));

    //Spectral Spelunker

    public static final DeferredHolder<Item, Item> SPECTRAL_SPELUNKER_HELMET = ITEMS.register("spectral_spelunker_helmet", () -> new SpectralSpelunkerArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(EvocationRarity.EVOCATION_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> SPECTRAL_SPELUNKER_CHESTPLATE = ITEMS.register("spectral_spelunker_chestplate", () -> new SpectralSpelunkerArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(EvocationRarity.EVOCATION_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> SPECTRAL_SPELUNKER_LEGGINGS = ITEMS.register("spectral_spelunker_leggings", () -> new SpectralSpelunkerArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(EvocationRarity.EVOCATION_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> SPECTRAL_SPELUNKER_BOOTS = ITEMS.register("spectral_spelunker_boots", () -> new SpectralSpelunkerArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(EvocationRarity.EVOCATION_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Project Sekai Armor

    public static final DeferredHolder<Item, Item> PROJECT_SEKAI_HELMET = ITEMS.register("project_sekai_helmet", () -> new GeckolibProjectSekaiArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final DeferredHolder<Item, Item> PROJECT_SEKAI_CHESTPLATE = ITEMS.register("project_sekai_chestplate", () -> new GeckolibProjectSekaiArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredHolder<Item, Item> PROJECT_SEKAI_LEGGINGS = ITEMS.register("project_sekai_leggings", () -> new GeckolibProjectSekaiArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final DeferredHolder<Item, Item> PROJECT_SEKAI_BOOTS = ITEMS.register("project_sekai_boots", () -> new GeckolibProjectSekaiArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.BOOTS.getDurability(37))));

    //Project Sekai Armor

    public static final DeferredHolder<Item, Item> ROTTEN_GIRL_HELMET = ITEMS.register("rotten_girl_helmet", () -> new GeckolibRottenGirlArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final DeferredHolder<Item, Item> ROTTEN_GIRL_CHESTPLATE = ITEMS.register("rotten_girl_chestplate", () -> new GeckolibRottenGirlArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredHolder<Item, Item> ROTTEN_GIRL_LEGGINGS = ITEMS.register("rotten_girl_leggings", () -> new GeckolibRottenGirlArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final DeferredHolder<Item, Item> ROTTEN_GIRL_BOOTS = ITEMS.register("rotten_girl_boots", () -> new GeckolibRottenGirlArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.BOOTS.getDurability(37))));

    //Legionnaire Armor

    public static final DeferredHolder<Item, Item> LEGIONNAIRE_HELMET = ITEMS.register("legionnaire_helmet", () -> new GeckolibLegionnaireArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> LEGIONNAIRE_CHESTPLATE = ITEMS.register("legionnaire_chestplate", () -> new GeckolibLegionnaireArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> LEGIONNAIRE_LEGGINGS = ITEMS.register("legionnaire_leggings", () -> new GeckolibLegionnaireArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> LEGIONNAIRE_BOOTS = ITEMS.register("legionnaire_boots", () -> new GeckolibLegionnaireArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Synthesizer V Armor

    public static final DeferredHolder<Item, Item> SYNTHESIZER_V_HELMET = ITEMS.register("synthesizer_v_helmet", () -> new GeckolibSynthesizerVArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final DeferredHolder<Item, Item> SYNTHESIZER_V_CHESTPLATE = ITEMS.register("synthesizer_v_chestplate", () -> new GeckolibSynthesizerVArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredHolder<Item, Item> SYNTHESIZER_V_LEGGINGS = ITEMS.register("synthesizer_v_leggings", () -> new GeckolibSynthesizerVArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final DeferredHolder<Item, Item> SYNTHESIZER_V_BOOTS = ITEMS.register("synthesizer_v_boots", () -> new GeckolibSynthesizerVArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.BOOTS.getDurability(37))));

    //Utau Armor

    public static final DeferredHolder<Item, Item> UTAU_HELMET = ITEMS.register("utau_helmet", () -> new GeckolibUtauArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final DeferredHolder<Item, Item> UTAU_CHESTPLATE = ITEMS.register("utau_chestplate", () -> new GeckolibUtauArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredHolder<Item, Item> UTAU_LEGGINGS = ITEMS.register("utau_leggings", () -> new GeckolibUtauArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final DeferredHolder<Item, Item> UTAU_BOOTS = ITEMS.register("utau_boots", () -> new GeckolibUtauArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.BOOTS.getDurability(37))));

    //Atlas Armor

    public static final DeferredHolder<Item, Item> ATLAS_HELMET = ITEMS.register("atlas_helmet", () -> new AtlasArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final DeferredHolder<Item, Item> ATLAS_CHESTPLATE = ITEMS.register("atlas_chestplate", () -> new AtlasArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredHolder<Item, Item> ATLAS_LEGGINGS = ITEMS.register("atlas_leggings", () -> new AtlasArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final DeferredHolder<Item, Item> ATLAS_BOOTS = ITEMS.register("atlas_boots", () -> new AtlasArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.BOOTS.getDurability(37))));

    // Calamitas

    public static final DeferredHolder<Item, Item> CALAMITAS_HELMET = ITEMS.register("calamitas_helmet", () -> new CalamitasArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> CALAMITAS_CHESTPLATE = ITEMS.register("calamitas_chestplate", () -> new CalamitasArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> CALAMITAS_LEGGINGS = ITEMS.register("calamitas_leggings", () -> new CalamitasArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> CALAMITAS_BOOTS = ITEMS.register("calamitas_boots", () -> new CalamitasArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));



    //Maverick Armor

    public static final DeferredHolder<Item, Item> MAVERICK_HELMET = ITEMS.register("maverick_helmet", () -> new MaverickArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(NatureRarity.NATURE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> MAVERICK_CHESTPLATE = ITEMS.register("maverick_chestplate", () -> new MaverickArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(NatureRarity.NATURE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> MAVERICK_LEGGINGS = ITEMS.register("maverick_leggings", () -> new MaverickArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(NatureRarity.NATURE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> MAVERICK_BOOTS = ITEMS.register("maverick_boots", () -> new MaverickArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(NatureRarity.NATURE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Geckolib Dark Ritual Templar Armor

    public static final DeferredHolder<Item, Item> GECKOLIB_DARK_RITUAL_TEMPLAR_HELMET = ITEMS.register("geckolib_dark_ritual_templar_helmet", () -> new GeckolibDarkRitualTemplarArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(EldritchRarity.ELDRITCH_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_DARK_RITUAL_TEMPLAR_CHESTPLATE = ITEMS.register("geckolib_dark_ritual_templar_chestplate", () -> new GeckolibDarkRitualTemplarArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(EldritchRarity.ELDRITCH_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_DARK_RITUAL_TEMPLAR_LEGGINGS = ITEMS.register("geckolib_dark_ritual_templar_leggings", () -> new GeckolibDarkRitualTemplarArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(EldritchRarity.ELDRITCH_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_DARK_RITUAL_TEMPLAR_BOOTS = ITEMS.register("geckolib_dark_ritual_templar_boots", () -> new GeckolibDarkRitualTemplarArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(EldritchRarity.ELDRITCH_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Geckolib Creaking Armor

    public static final DeferredHolder<Item, Item> GECKOLIB_CREAKING_HELMET = ITEMS.register("geckolib_creaking_helmet", () -> new GeckolibCreakingSorcererArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(NatureRarity.NATURE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_CREAKING_CHESTPLATE = ITEMS.register("geckolib_creaking_chestplate", () -> new GeckolibCreakingSorcererArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(NatureRarity.NATURE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_CREAKING_LEGGINGS = ITEMS.register("geckolib_creaking_leggings", () -> new GeckolibCreakingSorcererArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(NatureRarity.NATURE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_CREAKING_BOOTS = ITEMS.register("geckolib_creaking_boots", () -> new GeckolibCreakingSorcererArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(NatureRarity.NATURE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Geckolib Seraph Armor

    public static final DeferredHolder<Item, Item> GECKOLIB_SERAPH_HELMET = ITEMS.register("geckolib_seraph_helmet", () -> new GeckolibSeraphArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DivineRarity.DIVINE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_SERAPH_CHESTPLATE = ITEMS.register("geckolib_seraph_chestplate", () -> new GeckolibSeraphArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DivineRarity.DIVINE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_SERAPH_LEGGINGS = ITEMS.register("geckolib_seraph_leggings", () -> new GeckolibSeraphArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DivineRarity.DIVINE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_SERAPH_BOOTS = ITEMS.register("geckolib_seraph_boots", () -> new GeckolibSeraphArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DivineRarity.DIVINE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Geckolib Charged Scourge Armor

    public static final DeferredHolder<Item, Item> GECKOLIB_CHARGED_SCOURGE_HELMET = ITEMS.register("geckolib_charged_scourge_helmet", () -> new GeckolibChargedScourgeArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(ElectricRarity.ELECTRIC_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_CHARGED_SCOURGE_CHESTPLATE = ITEMS.register("geckolib_charged_scourge_chestplate", () -> new GeckolibChargedScourgeArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(ElectricRarity.ELECTRIC_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_CHARGED_SCOURGE_LEGGINGS = ITEMS.register("geckolib_charged_scourge_leggings", () -> new GeckolibChargedScourgeArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(ElectricRarity.ELECTRIC_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_CHARGED_SCOURGE_BOOTS = ITEMS.register("geckolib_charged_scourge_boots", () -> new GeckolibChargedScourgeArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(ElectricRarity.ELECTRIC_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));


    //Geckolib Soul Flame Armor

    public static final DeferredHolder<Item, Item> GECKOLIB_SOUL_FLAME_HELMET = ITEMS.register("geckolib_soul_flame_helmet", () -> new GeckolibSoulFlameArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_SOUL_FLAME_CHESTPLATE = ITEMS.register("geckolib_soul_flame_chestplate", () -> new GeckolibSoulFlameArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue()
            ).fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_SOUL_FLAME_LEGGINGS = ITEMS.register("geckolib_soul_flame_leggings", () -> new GeckolibSoulFlameArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_SOUL_FLAME_BOOTS = ITEMS.register("geckolib_soul_flame_boots", () -> new GeckolibSoulFlameArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Geckolib Supreme Witch Armor

    public static final DeferredHolder<Item, Item> GECKOLIB_SUPREME_WITCH_HELMET = ITEMS.register("geckolib_supreme_witch_helmet", () -> new GeckolibSupremeWitchArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(EvocationRarity.EVOCATION_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_SUPREME_WITCH_CHESTPLATE = ITEMS.register("geckolib_supreme_witch_chestplate", () -> new GeckolibSupremeWitchArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(EvocationRarity.EVOCATION_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_SUPREME_WITCH_LEGGINGS = ITEMS.register("geckolib_supreme_witch_leggings", () -> new GeckolibSupremeWitchArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(EvocationRarity.EVOCATION_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_SUPREME_WITCH_BOOTS = ITEMS.register("geckolib_supreme_witch_boots", () -> new GeckolibSupremeWitchArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(EvocationRarity.EVOCATION_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Geckolib Cryogenic Ruler Armor

    public static final DeferredHolder<Item, Item> CRYOGENIC_RULER_HELMET = ITEMS.register("geckolib_cryogenic_ruler_helmet", () -> new GeckolibCryogenicRulerArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(CryogenicRarity.CRYOGENIC_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> CRYOGENIC_RULER_CHESTPLATE = ITEMS.register("geckolib_cryogenic_ruler_chestplate", () -> new GeckolibCryogenicRulerArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(CryogenicRarity.CRYOGENIC_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> CRYOGENIC_RULER_LEGGINGS = ITEMS.register("geckolib_cryogenic_ruler_leggings", () -> new GeckolibCryogenicRulerArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(CryogenicRarity.CRYOGENIC_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> CRYOGENIC_RULER_BOOTS = ITEMS.register("geckolib_cryogenic_ruler_boots", () -> new GeckolibCryogenicRulerArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(CryogenicRarity.CRYOGENIC_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Geckolib Flesh Mass Armor

    public static final DeferredHolder<Item, Item> FLESH_MASS_HELMET = ITEMS.register("geckolib_flesh_mass_helmet", () -> new FleshMassArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(BloodRarity.BLOOD_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> FLESH_MASS_CHESTPLATE = ITEMS.register("geckolib_flesh_mass_chestplate", () -> new FleshMassArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(BloodRarity.BLOOD_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> FLESH_MASS_LEGGINGS = ITEMS.register("geckolib_flesh_mass_leggings", () -> new FleshMassArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(BloodRarity.BLOOD_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> FLESH_MASS_BOOTS = ITEMS.register("geckolib_flesh_mass_boots", () -> new FleshMassArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(BloodRarity.BLOOD_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));


    //Geckolib Ender Dragon Armor

    public static final DeferredHolder<Item, Item> GECKOLIB_ENDER_DRAGON_HELMET = ITEMS.register("geckolib_ender_dragon_helmet", () -> new GeckolibEnderDragonArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(EnderRarity.ENDER_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_ENDER_DRAGON_CHESTPLATE = ITEMS.register("geckolib_ender_dragon_chestplate", () -> new GeckolibEnderDragonArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(EnderRarity.ENDER_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_ENDER_DRAGON_LEGGINGS = ITEMS.register("geckolib_ender_dragon_leggings", () -> new GeckolibEnderDragonArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(EnderRarity.ENDER_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_ENDER_DRAGON_BOOTS = ITEMS.register("geckolib_ender_dragon_boots", () -> new GeckolibEnderDragonArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(EnderRarity.ENDER_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Geckolib Fireblossom Armor

    public static final DeferredHolder<Item, Item> GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CROWN = ITEMS.register("geckolib_fireblossom_crown", () -> new GeckolibFireblossomBattlemageCrownedArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_FIREBLOSSOM_BATTLEMAGE_HELMET = ITEMS.register("geckolib_fireblossom_helmet", () -> new GeckolibFireblossomBattlemageHelmetArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE = ITEMS.register("geckolib_fireblossom_chestplate", () -> new GeckolibFireblossomBattlemageCrownedArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_FIREBLOSSOM_BATTLEMAGE_LEGGINGS = ITEMS.register("geckolib_fireblossom_leggings", () -> new GeckolibFireblossomBattlemageCrownedArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_FIREBLOSSOM_BATTLEMAGE_BOOTS = ITEMS.register("geckolib_fireblossom_boots", () -> new GeckolibFireblossomBattlemageCrownedArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));


    //Geckolib Arbitrium Robes

    public static final DeferredHolder<Item, Item> GECKOLIB_ARBITRIUM_ROBES_HELMET = ITEMS.register("geckolib_arbitrium_robes_helmet", () -> new ArbitriumRobesGeckolibArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(90))));
    public static final DeferredHolder<Item, Item> GECKOLIB_ARBITRIUM_ROBES_CHESTPLATE = ITEMS.register("geckolib_arbitrium_robes_chestplate", () -> new ArbitriumRobesGeckolibArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(90))));
    public static final DeferredHolder<Item, Item> GECKOLIB_ARBITRIUM_ROBES_LEGGINGS = ITEMS.register("geckolib_arbitrium_robes_leggings", () -> new ArbitriumRobesGeckolibArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(90))));
    public static final DeferredHolder<Item, Item> GECKOLIB_ARBITRIUM_ROBES_BOOTS = ITEMS.register("geckolib_arbitrium_robes_boots", () -> new ArbitriumRobesGeckolibArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(90))));



    public static Collection<DeferredHolder<Item, ? extends Item>> getHnSItems()
    {
        return ITEMS.getEntries();
    }

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

    public static class HnSBlocks {
        public static final DeferredRegister.Blocks BLOCKS =
                DeferredRegister.createBlocks(HazenNStuff.MOD_ID);


        //Overworld Blocks

        public static final DeferredBlock<Block> RUNESTONE_SLAG = registerBlock("runestone_slag",
                () -> new Block(BlockBehaviour
                        .Properties.of()
                        .strength(4f)
                        .requiresCorrectToolForDrops()
                        .sound(HnSSounds.SPECIAL_ORE)
                ));
        public static final DeferredBlock<Block> AQUASTONE = registerBlock("aquastone",
                () -> new Block(BlockBehaviour
                        .Properties.of()
                        .strength(4f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.ANCIENT_DEBRIS)
                ));

        //Nether Blocks

        //Fireblossom
        public static final DeferredBlock<Block> FIREBLOSSOM = registerBlock("fireblossom", () -> new RootsBlock(
                BlockBehaviour
                        .Properties
                        .of()
                        .mapColor(MapColor.NETHER)
                        .replaceable()
                        .noCollission()
                        .instabreak()
                        .sound(SoundType.FLOWERING_AZALEA)
                        .offsetType(BlockBehaviour.OffsetType.XZ)
                        .pushReaction(PushReaction.DESTROY)
        ));


        //End Blocks
        public static final DeferredBlock<Block> ABYSSLATE = registerBlock("abysslate",
                () -> new Block(BlockBehaviour
                        .Properties.of()
                        .strength(4f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.ANCIENT_DEBRIS)
                ));
        public static final DeferredBlock<Block> PHANTASMIUM = registerBlock("phantasmium",
                () -> new Block(BlockBehaviour
                        .Properties.of()
                        .strength(4f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.ANCIENT_DEBRIS)
                ));
        public static final DeferredBlock<Block> VOIDSTONE = registerBlock("voidstone",
                () -> new Block(BlockBehaviour
                        .Properties.of()
                        .strength(4f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.ANCIENT_DEBRIS)
                ));
        public static final DeferredBlock<Block> COBBLED_VOIDSTONE = registerBlock("cobbled_voidstone",
                () -> new Block(BlockBehaviour
                        .Properties.of()
                        .strength(4f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.ANCIENT_DEBRIS)
                ));



        //Zenalite Set
        public static final DeferredBlock<Block> ZENALITE_BRICKS = registerBlock("zenalite_bricks",
                () -> new Block(BlockBehaviour
                        .Properties.of()
                        .strength(4f)
                        .requiresCorrectToolForDrops()
                        .sound(SoundType.DEEPSLATE_TILES)
                ));
        public static final DeferredBlock<StairBlock> ZENALITE_STAIRS = registerBlock("zenalite_stairs",
                () -> new StairBlock(HnSBlocks.ZENALITE_BRICKS.get().defaultBlockState(),
                        BlockBehaviour
                                .Properties
                                .of()
                                .strength(2f)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.DEEPSLATE_TILES)
                ));
        public static final DeferredBlock<SlabBlock> ZENALITE_SLAB = registerBlock("zenalite_slab",
                () -> new SlabBlock(
                        BlockBehaviour
                                .Properties
                                .of()
                                .strength(2f)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.DEEPSLATE_TILES)
                ));



        //Zenalite Ore
        public static final DeferredBlock<Block> ZENALITE_STONE_ORE = registerBlock("zenalite_stone_ore",
                () -> new DropExperienceBlock(UniformInt.of(2, 4),
                        BlockBehaviour
                                .Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(HnSSounds.SPECIAL_ORE)
                ));
        public static final DeferredBlock<Block> ZENALITE_DEEPSLATE_ORE = registerBlock("zenalite_deepslate_ore",
                () -> new DropExperienceBlock(UniformInt.of(2, 4),
                        BlockBehaviour
                                .Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(HnSSounds.SPECIAL_ORE)
                ));
        public static final DeferredBlock<Block> ZENALITE_ABYSSLATE_ORE = registerBlock("zenalite_abysslate_ore",
                () -> new DropExperienceBlock(UniformInt.of(2, 4),
                        BlockBehaviour
                                .Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(HnSSounds.SPECIAL_ORE)
                ));
        public static final DeferredBlock<Block> ZENALITE_VOIDSTONE_ORE = registerBlock("zenalite_voidstone_ore",
                () -> new DropExperienceBlock(UniformInt.of(2, 4),
                        BlockBehaviour
                                .Properties.of()
                                .strength(3f)
                                .requiresCorrectToolForDrops()
                                .sound(HnSSounds.SPECIAL_ORE)
                ));



        //Wisewood Set
        public static final DeferredBlock<Block> WISEWOOD_PLANK = registerBlock("wisewood_planks",
                () -> new
                        Block(BlockBehaviour
                                .Properties
                                .of()
                                .mapColor(MapColor.WOOD)
                                .instrument(NoteBlockInstrument.BASS)
                                .strength(2.0F, 3.0F)
                                .sound(SoundType.WOOD)
                                .ignitedByLava()
                ));

        public static final DeferredBlock<StairBlock> WISEWOOD_STAIRS = registerBlock("wisewood_stairs",
                () -> new StairBlock
                        (HnSBlocks.WISEWOOD_PLANK.get().defaultBlockState(),
                        BlockBehaviour
                                .Properties
                                .of()
                                .strength(2.0F, 3.0F)
                                .sound(SoundType.WOOD)
                                .ignitedByLava()
                ));

        public static final DeferredBlock<SlabBlock> WISEWOOD_SLAB = registerBlock("wisewood_slab",
                () -> new SlabBlock(
                        BlockBehaviour
                                .Properties
                                .of()
                                .mapColor(MapColor.WOOD)
                                .instrument(NoteBlockInstrument.BASS)
                                .strength(2.0F, 3.0F)
                                .sound(SoundType.WOOD)
                                .ignitedByLava()
                ));
        public static final DeferredBlock<Block> WISEWOOD_LOG = registerBlock("wisewood_log",
                () -> new ModFlammableRotatedPillarBlock(
                        BlockBehaviour
                                .Properties
                                .ofFullCopy(Blocks.OAK_LOG)
                ));
        public static final DeferredBlock<Block> WISEWOOD_WOOD = registerBlock("wisewood_wood",
                () -> new ModFlammableRotatedPillarBlock(
                        BlockBehaviour
                                .Properties
                                .ofFullCopy(Blocks.OAK_WOOD)
                ));
        public static final DeferredBlock<Block> STRIPPED_WISEWOOD_LOG = registerBlock("stripped_wisewood_log",
                () -> new ModFlammableRotatedPillarBlock(
                        BlockBehaviour
                                .Properties
                                .ofFullCopy(Blocks.STRIPPED_OAK_LOG)
                ));
        public static final DeferredBlock<Block> STRIPPED_WISEWOOD_WOOD = registerBlock("stripped_wisewood_wood",
                () -> new ModFlammableRotatedPillarBlock(
                        BlockBehaviour
                                .Properties
                                .ofFullCopy(Blocks.STRIPPED_OAK_WOOD)
                ));
        public static final DeferredBlock<Block> WISEWOOD_LEAVES = registerBlock("wisewood_leaves",
                () -> new LeavesBlock(
                        BlockBehaviour
                                .Properties
                                .ofFullCopy(Blocks.OAK_LEAVES)) {
                    @Override
                    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                        return true;
                    }

                    @Override
                    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                        return 60;
                    }

                    @Override
                    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                        return 30;
                    }
                });

        public static final DeferredBlock<FenceGateBlock> WISEWOOD_FENCE_GATE = registerBlock("wisewood_fence_gate",
                () -> new FenceGateBlock(WoodType.CHERRY,
                        BlockBehaviour
                                .Properties
                                .of()
                                .mapColor(MapColor.WOOD)
                                .instrument(NoteBlockInstrument.BASS)
                                .strength(2.0F, 3.0F)
                                .sound(SoundType.WOOD)
                                .ignitedByLava()
                ));

        public static final DeferredBlock<FenceBlock> WISEWOOD_FENCE = registerBlock("wisewood_fence",
                () -> new FenceBlock(
                        BlockBehaviour
                                .Properties
                                .of()
                                .mapColor(MapColor.WOOD)
                                .instrument(NoteBlockInstrument.BASS)
                                .strength(2.0F, 3.0F)
                                .ignitedByLava()
                                .sound(SoundType.WOOD)
                ));
        public static final DeferredBlock<DoorBlock> WISEWOOD_DOOR = registerBlock("wisewood_door",
                () -> new DoorBlock(
                        BlockSetType.OAK,
                        BlockBehaviour
                        .Properties
                        .of()
                        .mapColor(MapColor.WOOD)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(3.0F)
                        .noOcclusion()
                        .ignitedByLava()
                        .pushReaction(PushReaction.DESTROY)
                ));
        public static final DeferredBlock<TrapDoorBlock> WISEWOOD_TRAPDOOR = registerBlock("wisewood_trapdoor",
                () -> new TrapDoorBlock(
                        BlockSetType.OAK,
                        BlockBehaviour
                                .Properties
                                .of()
                                .mapColor(MapColor.WOOD)
                                .instrument(NoteBlockInstrument.BASS)
                                .strength(3.0F)
                                .noOcclusion()
                                .isValidSpawn(Blocks::never)
                                .ignitedByLava()));





        //Compact Block Set
        public static final DeferredBlock<Block> ZENALITE_BLOCK = registerBlock("zenalite_block",
                () -> new Block(BlockBehaviour
                        .Properties.of()
                        .strength(4f)
                        .requiresCorrectToolForDrops()
                        .sound(HnSSounds.SPECIAL_ORE)
                ));
        public static final DeferredBlock<Block> PYRIUM_BLOCK = registerBlock("pyrium_block",
                () -> new Block(BlockBehaviour
                        .Properties.of()
                        .strength(4f)
                        .requiresCorrectToolForDrops()
                        .sound(HnSSounds.SPECIAL_ORE)
                ));
        public static final DeferredBlock<Block> MITHRIL_BLOCK = registerBlock("mithril_block",
                () -> new Block(BlockBehaviour
                        .Properties.of()
                        .strength(4f)
                        .requiresCorrectToolForDrops()
                        .sound(HnSSounds.SPECIAL_ORE)
                ));
        public static final DeferredBlock<Block> ARCANE_STEEL_BLOCK = registerBlock("arcane_steel_block",
                () -> new Block(BlockBehaviour
                        .Properties.of()
                        .strength(4f)
                        .requiresCorrectToolForDrops()
                        .sound(HnSSounds.SPECIAL_ORE)
                ));


        private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
            DeferredBlock<T> toReturn = BLOCKS.register(name, block);
            registerBlockItem(name, toReturn);
            return toReturn;
        }

        private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
            ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        }

        public static void register(IEventBus eventBus) {
            BLOCKS.register(eventBus);
        }

    }
}
