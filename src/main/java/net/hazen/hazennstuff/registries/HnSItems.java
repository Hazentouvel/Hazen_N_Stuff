package net.hazen.hazennstuff.registries;

import io.redspace.ironsspellbooks.item.UpgradeOrbItem;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import io.redspace.ironsspellbooks.render.CinderousRarity;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.item.armor.AzureLib.ArbitriumRobes.ArbitriumRobesElytraArmorItem;
import net.hazen.hazennstuff.item.armor.AzureLib.ArbitriumRobes.Ascended.AscendedArbitriumRobesArmorItem;
import net.hazen.hazennstuff.item.armor.AzureLib.ArbitriumRobes.Ascended.AscendedArbitriumRobesElytraArmorItem;
import net.hazen.hazennstuff.item.armor.AzureLib.Blazeborne.BlazeborneArmorItem;
import net.hazen.hazennstuff.item.armor.AzureLib.GabrielULTRAKILL.GabrielArmorItem;
import net.hazen.hazennstuff.item.armor.AzureLib.GabrielULTRAKILL.GabrielElytraArmorItem;
import net.hazen.hazennstuff.item.armor.AzureLib.Infestation.InfestationArmorItem;
import net.hazen.hazennstuff.item.armor.AzureLib.LemonGod.Ascended.AscendedLemonGodArmorItem;
import net.hazen.hazennstuff.item.armor.AzureLib.LemonGod.LemonGodArmorItem;
import net.hazen.hazennstuff.item.armor.AzureLib.TheWither.TheWitherArmorItem;
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
import net.hazen.hazennstuff.item.armor.Geckolib.AbberantPredator.AbberantPredatorArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.AlchemistSupreme.AlchemistSupremeArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.ArbitriumRobes.Ascended.GeckolibAscendedArbitriumRobesArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.ArbitriumRobes.Ascended.GeckolibAscendedArbitriumRobesElytraItem;
import net.hazen.hazennstuff.item.armor.Geckolib.ArbitriumRobes.GeckolibArbitriumRobesArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.ArbitriumRobes.GeckolibArbitriumRobesElytraItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Atlas.AtlasArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.BishopOfDeceitArmor.BishopOfDeceitArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.BountyHunter.BountyHunterArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Calamitas.CalamitasArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Calamitas.CalamitasChestplateArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.ChargedScourge.GeckolibChargedScourgeArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Chlorophyte.ChlorophyteArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Chlorophyte.Headgear.ChlorophyteHeadgearArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Chlorophyte.Helmet.ChlorophyteHelmetArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Chlorophyte.Mask.ChlorophyteMaskArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.CreakingSorcerer.GeckolibCreakingSorcererArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.CryogenicRuler.CryogenicRulerArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.CrystalArachnid.CrystalArachnidArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.DarkRitualTemplar.GeckolibDarkRitualTemplarArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.DreadsteelKnight.DreadsteelKnightArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.EnderDragon.GeckolibEnderDragonArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.FireblossomBattlemage.GeckolibFireblossomBattlemageCrownedArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.FireblossomBattlemage.GeckolibFireblossomBattlemageHelmetArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.FleshMass.FleshMassArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Frieren.FrierenArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.FrostbiteHunter.FrostbiteHunterArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.FrostbiteKnight.FrostbiteKnightArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.GabrielULTRAKILL.GeckolibGabrielArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.GabrielULTRAKILL.GeckolibGabrielElytraItem;
import net.hazen.hazennstuff.item.armor.Geckolib.GarmentsOfTheFirstFlamebearer.GarmentsOfTheFirstFlamebearerArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.GarmentsOfTheFirstFlamebearer.GarmentsOfTheFirstFlamebearerChestplateArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.GarmentsOfTheFirstFlamebearer.SoulMode.GarmentsOfTheFirstFlamebearerSoulArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.GarmentsOfTheFirstFlamebearer.SoulMode.GarmentsOfTheFirstFlamebearerSoulChestplateArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.GiornoGiovanna.GiornoGiovannaArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Hazel.HazelArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Hazel.HazelHOLYMOLYArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.HertaPuppet.HertaPuppetArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Infestation.GeckolibInfestationArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Iron431.Ascended.AscendedIron431ArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Iron431.Iron431ArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Legionnaire.OldLegionnaireArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.LegionnaireCommander.LegionnaireCommanderArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.LegionnaireRuler.LegionnaireRulerArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.LegionnaireRuler.Soul.SoulLegionnaireRulerArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.LemonGod.Ascended.GeckolibAscendedLemonGodArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.LemonGod.GeckolibLemonGodArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.MageHunter.MageHunterArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Maverick.MaverickArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Miner.MinerArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.MithrilBattlemage.MithrilBattlemageArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.MothicWitch.MothicWitchArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.MothicWitch.NerfedMothicWitchArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.MyceliumGuardian.MyceliumGuardianArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.NamelessOneArmor.NamelessOneArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.NecromancerArmor.NecromancerArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Neru.NeruArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.PermafrostPrince.PermafrostPrinceArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.ProjectSekai.ProjectSekaiArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.PyriumArmor.PyriumArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.PyriumBattlemage.PyriumBattlemageArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.PyromancerBrute.PyromancerBruteArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.RottenGirl.RottenGirlArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.SacredRobes.Ascended.AscendedSacredRobesArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.SacredRobes.SacredRobesArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Seraph.GeckolibSeraphArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.ShadowScale.ShadowScaleArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.ShadowWalkerEnderman.ShadowwalkerEndermanArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.ShadowWalkerEnderman.ShadowwalkerEndermanBlindfoldItem;
import net.hazen.hazennstuff.item.armor.Geckolib.ShadowWalkerEnderman.ShadowwalkerEndermanHoodItem;
import net.hazen.hazennstuff.item.armor.Geckolib.SoulFlame.GeckolibSoulFlameArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.SpectralSpelunker.SpectralSpelunkerArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.SupremeWitch.GeckolibSupremeWitchArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.SynthesizerV.SynthesizerVArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.TheWither.GeckolibTheWitherArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.ThunderProwler.ThunderProwlerArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Utau.UtauArmorItem;
import net.hazen.hazennstuff.item.curios.Crystals.LifeCrystals.SacredCurio;
import net.hazen.hazennstuff.item.curios.Crystals.LifeCrystals.ShatteredCurio;
import net.hazen.hazennstuff.item.curios.Crystals.LifeCrystals.SingularityCurio;
import net.hazen.hazennstuff.item.curios.Crystals.LifeCrystals.StrengthenedCurio;
import net.hazen.hazennstuff.item.curios.Crystals.ManaCrystals.RadianceCurio;
import net.hazen.hazennstuff.item.curios.Crystals.ManaCrystals.RefinedCurio;
import net.hazen.hazennstuff.item.curios.Crystals.ManaCrystals.ReinforcedCurio;
import net.hazen.hazennstuff.item.curios.Crystals.ManaCrystals.RupturedCurio;
import net.hazen.hazennstuff.item.curios.Crystals.SpiritCrystals.AbominationCurio;
import net.hazen.hazennstuff.item.curios.Crystals.SpiritCrystals.AbsoluteCurio;
import net.hazen.hazennstuff.item.curios.Crystals.SpiritCrystals.AbstractCurio;
import net.hazen.hazennstuff.item.curios.Crystals.SpiritCrystals.AdvancedCurio;
import net.hazen.hazennstuff.item.curios.Rings.RingOfEfficiencyCurio;
import net.hazen.hazennstuff.item.curios.Sheaths.GalvanizedSheath.GalvanizedSheath;
import net.hazen.hazennstuff.item.curios.Sheaths.ScrollSheath.ScrollSheath;
import net.hazen.hazennstuff.item.curios.Spellbooks.EnergizedCoreSpellbook.EnergizedCoreSpellbook;
import net.hazen.hazennstuff.item.curios.Spellbooks.GoldenShowerSpellbook;
import net.hazen.hazennstuff.item.curios.Wings.ArbitriumWings.ArbitriumWings;
import net.hazen.hazennstuff.item.misc.HnSFoodProperties;
import net.hazen.hazennstuff.item.staves.WhiteLilyStaff.WhiteLilyStaffItem;
import net.hazen.hazennstuff.item.staves.rod_of_discord.RodOfDiscordItem;
import net.hazen.hazennstuff.item.staves.wisewood_cane.WisewoodCaneItem;
import net.hazen.hazennstuff.item.util.PickaxeAxe.DivineGold.PickaxeAxeDivineGoldItem;
import net.hazen.hazennstuff.item.util.PickaxeAxe.PickaxeAxeItem;
import net.hazen.hazennstuff.item.util.spectral_pickaxe.SpectralPickaxeItem;
import net.hazen.hazennstuff.item.weapons.BladeOfGrass.BladeOfGrassItem;
import net.hazen.hazennstuff.item.weapons.DivineGreatsword.DivineGreatswordItem;
import net.hazen.hazennstuff.item.weapons.DraconicSplitter.DraconicSplitterItem;
import net.hazen.hazennstuff.item.weapons.Excalibur.HazenStyle.HazensExcaliburItem;
import net.hazen.hazennstuff.item.weapons.Excalibur.ISSxTerraria.ISSExcaliburItem;
import net.hazen.hazennstuff.item.weapons.Excalibur.Terraria.ExcaliburItem;
import net.hazen.hazennstuff.item.weapons.Firebrand.FirebrandItem;
import net.hazen.hazennstuff.item.weapons.Dawnmaker.DawnmakerItem;
import net.hazen.hazennstuff.item.weapons.FrostburnDagger.FrostburnDaggerItem;
import net.hazen.hazennstuff.item.weapons.Hammush.HammushItem;
import net.hazen.hazennstuff.item.weapons.MageBane.MageBaneItem;
import net.hazen.hazennstuff.item.weapons.Malice.MaliceItem;
import net.hazen.hazennstuff.item.weapons.Meowmere.MeowmereItem;
import net.hazen.hazennstuff.item.weapons.Muramasa.MuramasaItem;
import net.hazen.hazennstuff.item.weapons.NightsEdge.NightsEdgeItem;
import net.hazen.hazennstuff.item.weapons.ObsidianClaymore.ObsidianClaymoreItem;
import net.hazen.hazennstuff.item.weapons.RavensBane.RavensBaneItem;
import net.hazen.hazennstuff.item.weapons.Spectrum.SpectrumItem;
import net.hazen.hazennstuff.item.weapons.Starfury.StarfuryItem;
import net.hazen.hazennstuff.item.weapons.TheDevourer.TheDevourerItem;
import net.hazen.hazennstuff.item.weapons.ThornChakram.ThornChakramItem;
import net.hazen.hazennstuff.item.weapons.TrueNightsEdge.TrueNightsEdgeItem;
import net.hazen.hazennstuff.item.weapons.Volcano.VolcanoItem;
import net.hazen.hazennstuff.item.weapons.WarFlamingLance.WarFlamingLanceItem;
import net.hazen.hazennstuff.item.weapons.ancient_warriors_axe.AncientWarriorsAxeItem;
import net.hazen.hazennstuff.item.weapons.beongae.BeongaeItem;
import net.hazen.hazennstuff.item.weapons.bountiful_harvest.BountifulHarvestItem;
import net.hazen.hazennstuff.item.weapons.fireblossom_rapier.FireblossomRapierItem;
import net.hazen.hazennstuff.item.weapons.hammer_of_justice.HammerOfJusticeItem;
import net.hazen.hazennstuff.item.weapons.ice_pike.IcePikeItem;
import net.hazen.hazennstuff.item.weapons.legionnaire_warlock_axe.LegionnaireWarlockAxeItem;
import net.hazen.hazennstuff.item.weapons.lights_bane.LightsBaneItem;
import net.hazen.hazennstuff.item.weapons.skyscorcher.SkyscorcherItem;
import net.hazen.hazennstuff.item.weapons.vampire_knives.VampireKnivesItem;
import net.hazen.hazennstuff.rarity.*;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.hazen.hazennstuff.item.staves.frieren.FrierenStaffItem;

import java.util.Collection;

public class HnSItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HazenNStuff.MOD_ID);

    /*
     *** Upgrade orbs
     */

    // Radiance Upgrade Orb
    public static final DeferredHolder<Item, Item> RADIANCE_UPGRADE_ORB = ITEMS.register("radiance_upgrade_orb",
            () -> new UpgradeOrbItem(ItemPropertiesHelper
                    .material()
                    .rarity(Rarity.UNCOMMON)
                    .component(ComponentRegistry.UPGRADE_ORB_TYPE, HnSUpgradeOrbTypeRegistry.RADIANCE_SPELL_POWER))
    );

    // Shadow Upgrade Orb
    public static final DeferredHolder<Item, Item> SHADOW_UPGRADE_ORB = ITEMS.register("shadow_upgrade_orb",
            () -> new UpgradeOrbItem(ItemPropertiesHelper
                    .material()
                    .rarity(Rarity.UNCOMMON)
                    .component(ComponentRegistry.UPGRADE_ORB_TYPE, HnSUpgradeOrbTypeRegistry.SHADOW_SPELL_POWER))
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

    /*
     *** Runes
     */

    //Melee Rune
    public static final DeferredHolder<Item, Item> MELEE_RUNE = ITEMS.register("melee_rune",
            () -> new Item(ItemPropertiesHelper.material())
    );

    //Archery Rune
    public static final DeferredHolder<Item, Item> ARCHERY_RUNE = ITEMS.register("archery_rune",
            () -> new Item(ItemPropertiesHelper.material())
    );

    //Health Rune
    public static final DeferredHolder<Item, Item> HEALTH_RUNE = ITEMS.register("health_rune",
            () -> new Item(ItemPropertiesHelper.material())
    );

    //Shadow Rune
    public static final DeferredHolder<Item, Item> SHADOW_RUNE = ITEMS.register("shadow_rune",
            () -> new Item(ItemPropertiesHelper.material())
    );

    //Radiance Rune
    public static final DeferredHolder<Item, Item> RADIANCE_RUNE = ITEMS.register("radiance_rune",
            () -> new Item(ItemPropertiesHelper.material())
    );

    //Eldritch Rune
    public static final DeferredHolder<Item, Item> ELDRITCH_RUNE = ITEMS.register("eldritch_rune",
            () -> new Item(ItemPropertiesHelper.material())
    );




    /*
    *** Materials
     */


    /*
    *** Templates
     */

    //Divine Mold
    public static final DeferredItem<Item> DIVINE_MOLD = ITEMS.register("divine_mold",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.EPIC)
                    .fireResistant()
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true))
    );

    //Flaming Template
    public static final DeferredItem<Item> FLAMING_TEMPLATE = ITEMS.register("flaming_template",
            () -> new Item(new Item
                    .Properties()
                    .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
                    .fireResistant())
    );

    /*
    *** Crafting Materials
     */

    //Spider Fang
    public static final DeferredItem<Item> SPIDER_FANG = ITEMS.register("spider_fang",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.RARE))
    );

    //Storm Weave
    public static final DeferredItem<Item> STORM_WEAVE = ITEMS.register("storm_weave",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.RARE))
    );

    //Volt Core
    public static final DeferredItem<Item> VOLT_CORE = ITEMS.register("volt_core",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.RARE))
    );

    //Prismatic Shard
    public static final DeferredItem<Item> PRISMATIC_SHARD = ITEMS.register("prismatic_shard",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.RARE))
    );

    //Excalibur
    public static final DeferredItem<Item> EXCALIBUR_FRAGMENT = ITEMS.register("excalibur_fragment",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.EPIC))
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
                    .rarity(Rarity.UNCOMMON))
    );

    //Permafrost Fragment
    public static final DeferredItem<Item> PERMAFROST_FRAGMENT = ITEMS.register("permafrost_fragment",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.RARE))
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

    //Glowing Mushroom
    public static final DeferredItem<Item> GLOWING_MUSHROOM = ITEMS.register("glowing_mushroom",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.UNCOMMON))
    );

    //Shadow Scale
    public static final DeferredItem<Item> SHADOW_SCALE = ITEMS.register("shadow_scale",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.RARE))

    );

    //Cloth of the Flamebearerer
    public static final DeferredItem<Item> CLOTH_OF_THE_FLAMEBEARER = ITEMS.register("cloth_of_the_flamebearer",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.EPIC)
                    .fireResistant())

    );

    //Lemon
    public static final DeferredItem<Item> LEMON = ITEMS.register("lemon",
            () -> new Item(new Item
                    .Properties()
                    .food(HnSFoodProperties.LEMON)
                    .rarity(Rarity.UNCOMMON))
    );

    //Divine Lemon
    public static final DeferredItem<Item> DIVINE_LEMON = ITEMS.register("divine_lemon",
            () -> new Item(new Item
                    .Properties()
                    .food(HnSFoodProperties.DIVINE_LEMON)
                    .rarity(Rarity.EPIC)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true))

    );


    /*
    *** Ingots and Raw Material
     */

    //Dreadstone
    public static final DeferredItem<Item> DREADSTONE = ITEMS.register("dreadstone",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.RARE))
    );

    //Dreadsteel Ingot
    public static final DeferredItem<Item> DREADSTEEL_INGOT = ITEMS.register("dreadsteel_ingot",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.RARE)
                    .fireResistant())
    );


    //Crude Metal
    public static final DeferredItem<Item> CRUDE_METAL = ITEMS.register("crude_metal",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.RARE)
                    .fireResistant())
    );

    //Steel Ingot
    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.RARE)
                    .fireResistant())
    );

    //Steel Nugget
    public static final DeferredItem<Item> STEEL_NUGGET = ITEMS.register("steel_nugget",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.RARE)
                    .fireResistant())
    );

    //Solar Core
    public static final DeferredItem<Item> SOLAR_CORE = ITEMS.register("solar_core",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.RARE)
                    .fireResistant())

    );

    // Chlorophyte Ingot
    public static final DeferredItem<Item> CHLOROPHYTE_INGOT = ITEMS.register("chlorophyte_ingot",
            () -> new Item(new Item
                    .Properties()
                    .rarity(NatureRarity.NATURE_RARITY_PROXY.getValue())
                    .fireResistant())

    );

    // Chlorophyte Chunk
    public static final DeferredItem<Item> CHLOROPHYTE_CHUNK = ITEMS.register("chlorophyte_chunk",
            () -> new Item(new Item
                    .Properties()
                    .rarity(NatureRarity.NATURE_RARITY_PROXY.getValue()))
    );

    // Hallowed Ingot
    public static final DeferredItem<Item> HALLOWED_INGOT = ITEMS.register("hallowed_ingot",
            () -> new Item(new Item
                    .Properties()
                    .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue()))
    );

    // Demonite Ingot
    public static final DeferredItem<Item> DEMONITE_INGOT = ITEMS.register("demonite_ingot",
            () -> new Item(new Item
                    .Properties()
                    .rarity(ShadowRarity.SHADOW_RARITY_PROXY.getValue()))

    );

    // Chlorophyte Chunk
    public static final DeferredItem<Item> SHADESTONE = ITEMS.register("shadestone",
            () -> new Item(new Item
                    .Properties()
                    .rarity(ShadowRarity.SHADOW_RARITY_PROXY.getValue()))
    );

    //Rose Quartz
    public static final DeferredItem<Item> ROSE_QUARTZ = ITEMS.register("rose_quartz",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.RARE))
    );

    //Rose Gold Ingot
    public static final DeferredItem<Item> ROSE_GOLD_INGOT = ITEMS.register("rose_gold_ingot",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.RARE))
    );

    // Zenalite Ingot
    public static final DeferredItem<Item> ZENALITE_INGOT = ITEMS.register("zenalite_ingot",
            () -> new Item(new Item
                    .Properties()
                    .rarity(Rarity.EPIC)
                    .fireResistant())
    );

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
                    .rarity(Rarity.EPIC)
                    .fireResistant())
    );


    // Pyrium Nugget
    public static final DeferredItem<Item> PYRIUM_NUGGET = ITEMS.register("pyrium_nugget",
            () -> new Item(
                    ItemPropertiesHelper.material()
                    .rarity((Rarity)CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
                    .fireResistant())
    );

    // Silver Scrap
    public static final DeferredItem<Item> SILVER_SCRAPS = ITEMS.register("silver_scraps",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.RARE))
    );




    /***
     * Weapons
     */



    /*
    *** Fire
     */

    //Fireblossom Rapier
    public static final DeferredHolder<Item, Item> FIREBLOSSOM_RAPIER = ITEMS.register
            ("fireblossom_rapier", FireblossomRapierItem::new);

    //Draconic Splitter
    public static final DeferredHolder<Item, Item> DRACONIC_SPLITTER = ITEMS.register
            ("draconic_splitter", DraconicSplitterItem::new);

    //Firebrand
    public static final DeferredHolder<Item, Item> FIREBRAND = ITEMS.register
            ("firebrand", FirebrandItem::new);

    // Ravens Bane
    public static final DeferredHolder<Item, Item> RAVENS_BANE = ITEMS.register
            ("ravens_bane", RavensBaneItem::new);

    // War-Flaming Lance
    public static final DeferredHolder<Item, Item> WARFLAMING_LANCE = ITEMS.register
            ("war_flaming_lance", WarFlamingLanceItem::new);

    // War-Flaming Lance
    public static final DeferredHolder<Item, Item> VOLCANO = ITEMS.register
            ("volcano", VolcanoItem::new);

    /*
    *** Ice
     */

    //Ice Pike
    public static final DeferredHolder<Item, Item> ICE_PIKE = ITEMS.register
            ("ice_pike", IcePikeItem::new);

    //Frostburn Dagger
    public static final DeferredHolder<Item, Item> FROSTBURN_DAGGER = ITEMS.register
            ("frostburn_dagger", FrostburnDaggerItem::new);

    /*
    *** Lightning
     */

    //Beongae
    public static final DeferredHolder<Item, Item> BEONGAE = ITEMS.register
            ("beongae", BeongaeItem::new);

    //Skyscorcher
    public static final DeferredHolder<Item, Item> SKYSCORCHER = ITEMS.register
            ("skyscorcher", SkyscorcherItem::new);

    /*
    *** Nature
     */

    //Bountiful Harvest
    public static final DeferredHolder<Item, Item> BOUNTIFUL_HARVEST = ITEMS.register
            ("bountiful_harvest", BountifulHarvestItem::new);

    //Thorn Chakram
    public static final DeferredHolder<Item, Item> THORN_CHAKRAM = ITEMS.register
            ("thorn_chakram", ThornChakramItem::new);

    //Thorn Chakram
    public static final DeferredHolder<Item, Item> BLADE_OF_GRASS = ITEMS.register
            ("blade_of_grass", BladeOfGrassItem::new);

    /*
    *** Blood
     */

    //Vampire Knives
    public static final DeferredHolder<Item, Item> VAMPIRE_KNIVES = ITEMS.register
            ("vampire_knives", VampireKnivesItem::new);

    /*
    *** Ender
     */

    //Obsidian Claymore
    public static final DeferredHolder<Item, Item> OBSIDIAN_CLAYMORE = ITEMS.register
            ("obsidian_claymore", ObsidianClaymoreItem::new);

    //Starfury
    public static final DeferredHolder<Item, Item> STARFURY = ITEMS.register
            ("starfury", StarfuryItem::new);

    /*
    *** Radiance
     */

    //Spectrum
    public static final DeferredHolder<Item, Item> SPECTRUM = ITEMS.register
            ("spectrum", SpectrumItem::new);

    //Meowmere
    public static final DeferredHolder<Item, Item> MEOWMERE = ITEMS.register
            ("meowmere", MeowmereItem::new);

    //Hammush
    public static final DeferredHolder<Item, Item> HAMMUSH = ITEMS.register
            ("hammush", HammushItem::new);

    /*
    *** Shadow
     */

    //Lights Bane
    public static final DeferredHolder<Item, Item> LIGHTS_BANE = ITEMS.register
            ("lights_bane", LightsBaneItem::new);

    //Nights Edge
    public static final DeferredHolder<Item, Item> NIGHTS_EDGE = ITEMS.register
            ("nights_edge", NightsEdgeItem::new);


    //True Nights Edge
    public static final DeferredHolder<Item, Item> TRUE_NIGHTS_EDGE = ITEMS.register
            ("true_nights_edge", TrueNightsEdgeItem::new);

    /*
    *** Holy
     */

    //Hammer of Justice
    public static final DeferredHolder<Item, Item> HAMMER_OF_JUSTICE = ITEMS.register
            ("hammer_of_justice", HammerOfJusticeItem::new);

    //Divine Greatsword
    public static final DeferredHolder<Item, Item> DIVINE_GREATSWORD = ITEMS.register
            ("divine_greatsword", DivineGreatswordItem::new);

    //Hazen's Excalibur
    public static final DeferredHolder<Item, Item> HAZENS_EXCALIBUR = ITEMS.register
            ("hazens_excalibur", HazensExcaliburItem::new);

    //Excalibur
    public static final DeferredHolder<Item, Item> EXCALIBUR = ITEMS.register
            ("excalibur", ExcaliburItem::new);

    //Excalibur Divine Gold
    public static final DeferredHolder<Item, Item> ISS_EXCALIBUR = ITEMS.register
            ("excalibur_divine_gold", ISSExcaliburItem::new);

    /*
    *** Evocation
     */

    //Ancient Warrior's Axe
    public static final DeferredHolder<Item, Item> ANCIENT_WARRIORS_AXE = ITEMS.register
            ("ancient_warriors_axe", AncientWarriorsAxeItem::new);

    //Malice
    public static final DeferredHolder<Item, Item> MALICE = ITEMS.register
            ("malice", MaliceItem::new);

    /*
    *** Eldritch
     */

    //The Devourer
    public static final DeferredHolder<Item, Item> THE_DEVOURER = ITEMS.register
            ("the_devourer", TheDevourerItem::new);

    /*
    *** Misc
     */

    //Mage Bane
    public static final DeferredHolder<Item, Item> MAGE_BANE = ITEMS.register
            ("mage_bane", MageBaneItem::new);

    //Dawn Maker
    public static final DeferredHolder<Item, Item> DAWNMAKER = ITEMS.register
            ("dawnmaker", DawnmakerItem::new);

    //Muramasa
    public static final DeferredHolder<Item, Item> MURAMASA = ITEMS.register
            ("muramasa", MuramasaItem::new);

    //Legionnaire Warlock Axe
    public static final DeferredHolder<Item, Item> LEGIONNAIRE_WARLOCK_AXE = ITEMS.register
            ("legionnaire_warlock_axe", LegionnaireWarlockAxeItem::new);



    /***
     * Staves
     */



    //Frieren's Staff
    public static final DeferredHolder<Item, Item> FRIEREN_STAFF = ITEMS.register("frieren_staff", FrierenStaffItem::new);
    //Wisewood Cane
    public static final DeferredHolder<Item, Item> WISEWOOD_CANE = ITEMS.register("wisewood_cane", WisewoodCaneItem::new);
    //Rod of Discord
    public static final DeferredHolder<Item, Item> ROD_OF_DISCORD = ITEMS.register("rod_of_discord", RodOfDiscordItem::new);
    //White Lily Staff
    public static final DeferredHolder<Item, Item> WHITE_LILY_STAFF = ITEMS.register("white_lily_staff", WhiteLilyStaffItem::new);

    /***
     * Tools
     */

    //Spectral Pickaxe
    public static final DeferredHolder<Item, Item> SPECTRAL_PICKAXE = ITEMS.register("spectral_pickaxe", SpectralPickaxeItem::new);

    //Spectral Pickaxe
    public static final DeferredHolder<Item, Item> PICKAXE_AXE = ITEMS.register("pickaxe_axe", PickaxeAxeItem::new);
    //Spectral Pickaxe
    public static final DeferredHolder<Item, Item> PICKAXE_AXE_DIVINE_GOLD = ITEMS.register("pickaxe_axe_divine_gold", PickaxeAxeDivineGoldItem::new);


    /***
     * Curios
     */

    /*
    *** Mana Crystals
     */

    //Ruptured
    public static final DeferredItem<RupturedCurio> RUPTURED = ITEMS.register("ruptured", RupturedCurio::new);
    //Refined
    public static final DeferredItem<RefinedCurio> REFINED = ITEMS.register("refined", RefinedCurio::new);
    //Reinforced
    public static final DeferredItem<ReinforcedCurio> REINFORCED = ITEMS.register("reinforced", ReinforcedCurio::new);
    //Radiance
    public static final DeferredItem<RadianceCurio> RADIANCE = ITEMS.register("radiance", RadianceCurio::new);

    /*
     *** Life Crystals
     */

    //Ruptured
    public static final DeferredItem<ShatteredCurio> SHATTERED = ITEMS.register("shattered", ShatteredCurio::new);
    //Refined
    public static final DeferredItem<SacredCurio> SACRED = ITEMS.register("sacred", SacredCurio::new);
    //Reinforced
    public static final DeferredItem<StrengthenedCurio> STRENGTHENED = ITEMS.register("strengthened", StrengthenedCurio::new);
    //Radiance
    public static final DeferredItem<SingularityCurio> SINGULARITY = ITEMS.register("singularity", SingularityCurio::new);

    /*
     *** Life Crystals
     */

    //Ruptured
    public static final DeferredItem<AbstractCurio> ABSTRACT = ITEMS.register("abstract", AbstractCurio::new);
    //Refined
    public static final DeferredItem<AdvancedCurio> ADVANCED = ITEMS.register("advanced", AdvancedCurio::new);
    //Reinforced
    public static final DeferredItem<AbominationCurio> ABOMINATION = ITEMS.register("abomination", AbominationCurio::new);
    //Radiance
    public static final DeferredItem<AbsoluteCurio> ABSOLUTE = ITEMS.register("absolute", AbsoluteCurio::new);


    /*
    *** Spellbooks
     */

    public static final DeferredItem <GoldenShowerSpellbook> GOLDEN_SHOWER_SPELLBOOK = ITEMS.register("golden_shower_spellbook", GoldenShowerSpellbook::new);
    public static final DeferredItem <EnergizedCoreSpellbook> ENERGIZED_CORE_SPELLBOOK = ITEMS.register("energized_core_spellbook", EnergizedCoreSpellbook::new);

    /*
    *** Sheaths
     */

    public static final DeferredItem <GalvanizedSheath> GALVANIZED_SHEATH = ITEMS.register("galvanized_sheath", GalvanizedSheath::new);
    public static final DeferredItem <ScrollSheath> SCROLL_SHEATH = ITEMS.register("scroll_sheath", ScrollSheath::new);

    /*
    *** Wings
     */

    //Radiance
    public static final DeferredItem<ArbitriumWings> ARBITRIUM_WINGS = ITEMS.register("arbitrium_wings", ArbitriumWings::new);

    /*
     *** Misc
     */

    //Ring of Efficiency
    public static final DeferredItem<RingOfEfficiencyCurio> RING_OF_EFFICIENCY = ITEMS.register("ring_of_efficiency", RingOfEfficiencyCurio::new);




    /***
     * AzureLib Armor
     */

    //Creaking Armor

    public static final DeferredHolder<Item, Item> CREAKING_HELMET = ITEMS.register("creaking_helmet", () -> new CreakingSorcererArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(NatureRarity.NATURE_RARITY_PROXY.getValue())
            .fireResistant()

            ));

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


    //SLC!Cat Armor

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


    //Arbitrium Robes Armor

    public static final DeferredHolder<Item, Item> ARBITRIUM_ROBES_HELMET = ITEMS.register("arbitrium_robes_helmet", () -> new ArbitriumRobesArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.HELMET.getDurability(90))));

    public static final DeferredHolder<Item, Item> ARBITRIUM_ROBES_CHESTPLATE = ITEMS.register("arbitrium_robes_chestplate", () -> new ArbitriumRobesElytraArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
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

    //Arbitrium Robes Armor

    public static final DeferredHolder<Item, Item> ASCENDED_ARBITRIUM_ROBES_HELMET = ITEMS.register("ascended_arbitrium_robes_helmet", () -> new AscendedArbitriumRobesArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.HELMET.getDurability(90))));

    public static final DeferredHolder<Item, Item> ASCENDED_ARBITRIUM_ROBES_CHESTPLATE = ITEMS.register("ascended_arbitrium_robes_chestplate", () -> new AscendedArbitriumRobesElytraArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(90))));

    public static final DeferredHolder<Item, Item> ASCENDED_ARBITRIUM_ROBES_LEGGINGS = ITEMS.register("ascended_arbitrium_robes_leggings", () -> new AscendedArbitriumRobesArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(90))));

    public static final DeferredHolder<Item, Item> ASCENDED_ARBITRIUM_ROBES_BOOTS = ITEMS.register("ascended_arbitrium_robes_boots", () -> new AscendedArbitriumRobesArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.BOOTS.getDurability(90))));

    //Infestation Armor

    public static final DeferredHolder<Item, Item> INFESTATION_HELMET = ITEMS.register("infestation_helmet", () -> new InfestationArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(EldritchRarity.ELDRITCH_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.HELMET.getDurability(90))));

    public static final DeferredHolder<Item, Item> INFESTATION_CHESTPLATE = ITEMS.register("infestation_chestplate", () -> new InfestationArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(EldritchRarity.ELDRITCH_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(90))));

    public static final DeferredHolder<Item, Item> INFESTATION_LEGGINGS = ITEMS.register("infestation_leggings", () -> new InfestationArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(EldritchRarity.ELDRITCH_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(90))));

    public static final DeferredHolder<Item, Item> INFESTATION_BOOTS = ITEMS.register("infestation_boots", () -> new InfestationArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(EldritchRarity.ELDRITCH_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.BOOTS.getDurability(90))));

    //Blazeborne Armor

    public static final DeferredHolder<Item, Item> BLAZEBORNE_HELMET = ITEMS.register("blazeborne_helmet", () -> new BlazeborneArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.HELMET.getDurability(90))));

    public static final DeferredHolder<Item, Item> BLAZEBORNE_CHESTPLATE = ITEMS.register("blazeborne_chestplate", () -> new BlazeborneArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(90))));

    public static final DeferredHolder<Item, Item> BLAZEBORNE_LEGGINGS = ITEMS.register("blazeborne_leggings", () -> new BlazeborneArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(90))));

    public static final DeferredHolder<Item, Item> BLAZEBORNE_BOOTS = ITEMS.register("blazeborne_boots", () -> new BlazeborneArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(FlamingRarity.FLAMING_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.BOOTS.getDurability(90))));

    //The Wither Armor

    public static final DeferredHolder<Item, Item> THE_WITHER_HELMET = ITEMS.register("the_wither_helmet", () -> new TheWitherArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(BloodRarity.BLOOD_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> THE_WITHER_CHESTPLATE = ITEMS.register("the_wither_chestplate", () -> new TheWitherArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(BloodRarity.BLOOD_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> THE_WITHER_LEGGINGS = ITEMS.register("the_wither_leggings", () -> new TheWitherArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(BloodRarity.BLOOD_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> THE_WITHER_BOOTS = ITEMS.register("the_wither_boots", () -> new TheWitherArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(BloodRarity.BLOOD_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Lemon God Armor

    public static final DeferredHolder<Item, Item> LEMON_GOD_HELMET = ITEMS.register("lemon_god_helmet", () -> new LemonGodArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> LEMON_GOD_CHESTPLATE = ITEMS.register("lemon_god_chestplate", () -> new LemonGodArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> LEMON_GOD_LEGGINGS = ITEMS.register("lemon_god_leggings", () -> new LemonGodArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> LEMON_GOD_BOOTS = ITEMS.register("lemon_god_boots", () -> new LemonGodArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    public static final DeferredHolder<Item, Item> ASCENDED_LEMON_GOD_HELMET = ITEMS.register("ascended_lemon_god_helmet", () -> new AscendedLemonGodArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> ASCENDED_LEMON_GOD_CHESTPLATE = ITEMS.register("ascended_lemon_god_chestplate", () -> new AscendedLemonGodArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> ASCENDED_LEMON_GOD_LEGGINGS = ITEMS.register("ascended_lemon_god_leggings", () -> new AscendedLemonGodArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> ASCENDED_LEMON_GOD_BOOTS = ITEMS.register("ascended_lemon_god_boots", () -> new AscendedLemonGodArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));


    //Gabriel Ultrakill Armor

    public static final DeferredHolder<Item, Item> GABRIEL_ULTRAKILL_HELMET = ITEMS.register("gabriel_ultrakill_helmet", () -> new GabrielArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> GABRIEL_ULTRAKILL_CHESTPLATE = ITEMS.register("gabriel_ultrakill_chestplate", () -> new GabrielElytraArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> GABRIEL_ULTRAKILL_LEGGINGS = ITEMS.register("gabriel_ultrakill_leggings", () -> new GabrielArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> GABRIEL_ULTRAKILL_BOOTS = ITEMS.register("gabriel_ultrakill_boots", () -> new GabrielArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));



    /***
     * GeckoLib Armor
     */



    //Infestation Armor

    public static final DeferredHolder<Item, Item> GECKOLIB_INFESTATION_HELMET = ITEMS.register("geckolib_infestation_helmet", () -> new GeckolibInfestationArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(EldritchRarity.ELDRITCH_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.HELMET.getDurability(90))));

    public static final DeferredHolder<Item, Item> GECKOLIB_INFESTATION_CHESTPLATE = ITEMS.register("geckolib_infestation_chestplate", () -> new GeckolibInfestationArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(EldritchRarity.ELDRITCH_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(90))));

    public static final DeferredHolder<Item, Item> GECKOLIB_INFESTATION_LEGGINGS = ITEMS.register("geckolib_infestation_leggings", () -> new GeckolibInfestationArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(EldritchRarity.ELDRITCH_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(90))));

    public static final DeferredHolder<Item, Item> GECKOLIB_INFESTATION_BOOTS = ITEMS.register("geckolib_infestation_boots", () -> new GeckolibInfestationArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(EldritchRarity.ELDRITCH_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.BOOTS.getDurability(90))));

    //Frieren Armor

    public static final DeferredHolder<Item, Item> FRIEREN_HELMET = ITEMS.register("frieren_helmet", () -> new FrierenArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final DeferredHolder<Item, Item> FRIEREN_CHESTPLATE = ITEMS.register("frieren_chestplate", () -> new FrierenArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredHolder<Item, Item> FRIEREN_LEGGINGS = ITEMS.register("frieren_leggings", () -> new FrierenArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final DeferredHolder<Item, Item> FRIEREN_BOOTS = ITEMS.register("frieren_boots", () -> new FrierenArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
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

    public static final DeferredHolder<Item, Item> PROJECT_SEKAI_HELMET = ITEMS.register("project_sekai_helmet", () -> new ProjectSekaiArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final DeferredHolder<Item, Item> PROJECT_SEKAI_CHESTPLATE = ITEMS.register("project_sekai_chestplate", () -> new ProjectSekaiArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredHolder<Item, Item> PROJECT_SEKAI_LEGGINGS = ITEMS.register("project_sekai_leggings", () -> new ProjectSekaiArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final DeferredHolder<Item, Item> PROJECT_SEKAI_BOOTS = ITEMS.register("project_sekai_boots", () -> new ProjectSekaiArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.BOOTS.getDurability(37))));

    //Project Sekai Armor

    public static final DeferredHolder<Item, Item> ROTTEN_GIRL_HELMET = ITEMS.register("rotten_girl_helmet", () -> new RottenGirlArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final DeferredHolder<Item, Item> ROTTEN_GIRL_CHESTPLATE = ITEMS.register("rotten_girl_chestplate", () -> new RottenGirlArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredHolder<Item, Item> ROTTEN_GIRL_LEGGINGS = ITEMS.register("rotten_girl_leggings", () -> new RottenGirlArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final DeferredHolder<Item, Item> ROTTEN_GIRL_BOOTS = ITEMS.register("rotten_girl_boots", () -> new RottenGirlArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.BOOTS.getDurability(37))));

    //Legionnaire Armor

    public static final DeferredHolder<Item, Item> LEGIONNAIRE_HELMET = ITEMS.register("legionnaire_helmet", () -> new OldLegionnaireArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> LEGIONNAIRE_CHESTPLATE = ITEMS.register("legionnaire_chestplate", () -> new OldLegionnaireArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> LEGIONNAIRE_LEGGINGS = ITEMS.register("legionnaire_leggings", () -> new OldLegionnaireArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> LEGIONNAIRE_BOOTS = ITEMS.register("legionnaire_boots", () -> new OldLegionnaireArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Synthesizer V Armor

    public static final DeferredHolder<Item, Item> SYNTHESIZER_V_HELMET = ITEMS.register("synthesizer_v_helmet", () -> new SynthesizerVArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final DeferredHolder<Item, Item> SYNTHESIZER_V_CHESTPLATE = ITEMS.register("synthesizer_v_chestplate", () -> new SynthesizerVArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredHolder<Item, Item> SYNTHESIZER_V_LEGGINGS = ITEMS.register("synthesizer_v_leggings", () -> new SynthesizerVArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final DeferredHolder<Item, Item> SYNTHESIZER_V_BOOTS = ITEMS.register("synthesizer_v_boots", () -> new SynthesizerVArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.BOOTS.getDurability(37))));

    //Utau Armor

    public static final DeferredHolder<Item, Item> UTAU_HELMET = ITEMS.register("utau_helmet", () -> new UtauArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.HELMET.getDurability(37))));
    public static final DeferredHolder<Item, Item> UTAU_CHESTPLATE = ITEMS.register("utau_chestplate", () -> new UtauArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredHolder<Item, Item> UTAU_LEGGINGS = ITEMS.register("utau_leggings", () -> new UtauArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final DeferredHolder<Item, Item> UTAU_BOOTS = ITEMS.register("utau_boots", () -> new UtauArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
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
    public static final DeferredHolder<Item, Item> CALAMITAS_CHESTPLATE = ITEMS.register("calamitas_chestplate", () -> new CalamitasChestplateArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
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

    //Charged Scourge Armor

    public static final DeferredHolder<Item, Item> CHARGED_SCOURGE_HELMET = ITEMS.register("charged_scourge_helmet", () -> new GeckolibChargedScourgeArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(ElectricRarity.ELECTRIC_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> CHARGED_SCOURGE_CHESTPLATE = ITEMS.register("charged_scourge_chestplate", () -> new GeckolibChargedScourgeArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(ElectricRarity.ELECTRIC_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> CHARGED_SCOURGE_LEGGINGS = ITEMS.register("charged_scourge_leggings", () -> new GeckolibChargedScourgeArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(ElectricRarity.ELECTRIC_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> CHARGED_SCOURGE_BOOTS = ITEMS.register("charged_scourge_boots", () -> new GeckolibChargedScourgeArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(ElectricRarity.ELECTRIC_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Thunder Prowler Armor

    public static final DeferredHolder<Item, Item> THUNDER_PROWLER_HELMET = ITEMS.register("thunder_prowler_helmet", () -> new ThunderProwlerArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(ElectricRarity.ELECTRIC_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> THUNDER_PROWLER_CHESTPLATE = ITEMS.register("thunder_prowler_chestplate", () -> new ThunderProwlerArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(ElectricRarity.ELECTRIC_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> THUNDER_PROWLER_LEGGINGS = ITEMS.register("thunder_prowler_leggings", () -> new ThunderProwlerArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(ElectricRarity.ELECTRIC_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> THUNDER_PROWLER_BOOTS = ITEMS.register("thunder_prowler_boots", () -> new ThunderProwlerArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
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

    //Geckolib Supreme Witch Armor

    public static final DeferredHolder<Item, Item> ALCHEMIST_SUPREME_HELMET = ITEMS.register("alchemist_supreme_helmet", () -> new AlchemistSupremeArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(EvocationRarity.EVOCATION_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> ALCHEMIST_SUPREME_CHESTPLATE = ITEMS.register("alchemist_supreme_chestplate", () -> new AlchemistSupremeArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(EvocationRarity.EVOCATION_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> ALCHEMIST_SUPREME_LEGGINGS = ITEMS.register("alchemist_supreme_leggings", () -> new AlchemistSupremeArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(EvocationRarity.EVOCATION_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> ALCHEMIST_SUPREME_BOOTS = ITEMS.register("alchemist_supreme_boots", () -> new AlchemistSupremeArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(EvocationRarity.EVOCATION_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Geckolib Cryogenic Ruler Armor

    public static final DeferredHolder<Item, Item> CRYOGENIC_RULER_HELMET = ITEMS.register("cryogenic_ruler_helmet", () -> new CryogenicRulerArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(CryogenicRarity.CRYOGENIC_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> CRYOGENIC_RULER_CHESTPLATE = ITEMS.register("cryogenic_ruler_chestplate", () -> new CryogenicRulerArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(CryogenicRarity.CRYOGENIC_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> CRYOGENIC_RULER_LEGGINGS = ITEMS.register("cryogenic_ruler_leggings", () -> new CryogenicRulerArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(CryogenicRarity.CRYOGENIC_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> CRYOGENIC_RULER_BOOTS = ITEMS.register("cryogenic_ruler_boots", () -> new CryogenicRulerArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(CryogenicRarity.CRYOGENIC_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Flesh Mass Armor

    public static final DeferredHolder<Item, Item> FLESH_MASS_HELMET = ITEMS.register("flesh_mass_helmet", () -> new FleshMassArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(BloodRarity.BLOOD_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> FLESH_MASS_CHESTPLATE = ITEMS.register("flesh_mass_chestplate", () -> new FleshMassArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(BloodRarity.BLOOD_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> FLESH_MASS_LEGGINGS = ITEMS.register("flesh_mass_leggings", () -> new FleshMassArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(BloodRarity.BLOOD_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> FLESH_MASS_BOOTS = ITEMS.register("flesh_mass_boots", () -> new FleshMassArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
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

    public static final DeferredHolder<Item, Item> GECKOLIB_ARBITRIUM_ROBES_HELMET = ITEMS.register("geckolib_arbitrium_robes_helmet", () -> new GeckolibArbitriumRobesArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(90))));
    public static final DeferredHolder<Item, Item> GECKOLIB_ARBITRIUM_ROBES_CHESTPLATE = ITEMS.register("geckolib_arbitrium_robes_chestplate", () -> new GeckolibArbitriumRobesElytraItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(90))));
    public static final DeferredHolder<Item, Item> GECKOLIB_ARBITRIUM_ROBES_LEGGINGS = ITEMS.register("geckolib_arbitrium_robes_leggings", () -> new GeckolibArbitriumRobesArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(90))));
    public static final DeferredHolder<Item, Item> GECKOLIB_ARBITRIUM_ROBES_BOOTS = ITEMS.register("geckolib_arbitrium_robes_boots", () -> new GeckolibArbitriumRobesArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(90))));

    //Geckolib Arbitrium Robes

    public static final DeferredHolder<Item, Item> GECKOLIB_ASCENDED_ARBITRIUM_ROBES_HELMET = ITEMS.register("geckolib_ascended_arbitrium_robes_helmet", () -> new GeckolibAscendedArbitriumRobesArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(90))));
    public static final DeferredHolder<Item, Item> GECKOLIB_ASCENDED_ARBITRIUM_ROBES_CHESTPLATE = ITEMS.register("geckolib_ascended_arbitrium_robes_chestplate", () -> new GeckolibAscendedArbitriumRobesElytraItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(90))));
    public static final DeferredHolder<Item, Item> GECKOLIB_ASCENDED_ARBITRIUM_ROBES_LEGGINGS = ITEMS.register("geckolib_ascended_arbitrium_robes_leggings", () -> new GeckolibAscendedArbitriumRobesArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(90))));
    public static final DeferredHolder<Item, Item> GECKOLIB_ASCENDED_ARBITRIUM_ROBES_BOOTS = ITEMS.register("geckolib_ascended_arbitrium_robes_boots", () -> new GeckolibAscendedArbitriumRobesArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(90))));

    //Legionnaire Commander Armor

    public static final DeferredHolder<Item, Item> LEGIONNAIRE_COMMANDER_HELMET = ITEMS.register("legionnaire_commander_helmet", () -> new LegionnaireCommanderArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.HELMET.getDurability(90))));

    public static final DeferredHolder<Item, Item> LEGIONNAIRE_COMMANDER_CHESTPLATE = ITEMS.register("legionnaire_commander_chestplate", () -> new LegionnaireCommanderArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(90))));

    public static final DeferredHolder<Item, Item> LEGIONNAIRE_COMMANDER_LEGGINGS = ITEMS.register("legionnaire_commander_leggings", () -> new LegionnaireCommanderArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(90))));

    public static final DeferredHolder<Item, Item> LEGIONNAIRE_COMMANDER_BOOTS = ITEMS.register("legionnaire_commander_boots", () -> new LegionnaireCommanderArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.BOOTS.getDurability(90))));

    //Tyros Armor

    public static final DeferredHolder<Item, Item> TYROS_HELMET = ITEMS.register("garments_of_the_first_flamebearer_helmet", () -> new GarmentsOfTheFirstFlamebearerArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.HELMET.getDurability(90))));

    public static final DeferredHolder<Item, Item> TYROS_CHESTPLATE = ITEMS.register("garments_of_the_first_flamebearer_chestplate", () -> new GarmentsOfTheFirstFlamebearerChestplateArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(90))));

    public static final DeferredHolder<Item, Item> TYROS_LEGGINGS = ITEMS.register("garments_of_the_first_flamebearer_leggings", () -> new GarmentsOfTheFirstFlamebearerArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(90))));

    public static final DeferredHolder<Item, Item> TYROS_BOOTS = ITEMS.register("garments_of_the_first_flamebearer_boots", () -> new GarmentsOfTheFirstFlamebearerArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.BOOTS.getDurability(90))));

    //Tyros Soul Mode Armor

    public static final DeferredHolder<Item, Item> TYROS_SOUL_HELMET = ITEMS.register("garments_of_the_first_flamebearer_soul_helmet", () -> new GarmentsOfTheFirstFlamebearerSoulArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.HELMET.getDurability(90))));

    public static final DeferredHolder<Item, Item> TYROS_SOUL_CHESTPLATE = ITEMS.register("garments_of_the_first_flamebearer_soul_chestplate", () -> new GarmentsOfTheFirstFlamebearerSoulChestplateArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(90))));

    public static final DeferredHolder<Item, Item> TYROS_SOUL_LEGGINGS = ITEMS.register("garments_of_the_first_flamebearer_soul_leggings", () -> new GarmentsOfTheFirstFlamebearerSoulArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(90))));

    public static final DeferredHolder<Item, Item> TYROS_SOUL_BOOTS = ITEMS.register("garments_of_the_first_flamebearer_soul_boots", () -> new GarmentsOfTheFirstFlamebearerSoulArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.BOOTS.getDurability(90))));

    //Crystal Arachnid Armor

    public static final DeferredHolder<Item, Item> CRYSTAL_ARACHNID_HELMET = ITEMS.register("crystal_arachnid_helmet", () -> new CrystalArachnidArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> CRYSTAL_ARACHNID_CHESTPLATE = ITEMS.register("crystal_arachnid_chestplate", () -> new CrystalArachnidArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> CRYSTAL_ARACHNID_LEGGINGS = ITEMS.register("crystal_arachnid_leggings", () -> new CrystalArachnidArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> CRYSTAL_ARACHNID_BOOTS = ITEMS.register("crystal_arachnid_boots", () -> new CrystalArachnidArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Abberant Predator Armor

    public static final DeferredHolder<Item, Item> ABBERANT_PREDATOR_HELMET = ITEMS.register("abberant_predator_helmet", () -> new AbberantPredatorArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> ABBERANT_PREDATOR_CHESTPLATE = ITEMS.register("abberant_predator_chestplate", () -> new AbberantPredatorArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> ABBERANT_PREDATOR_LEGGINGS = ITEMS.register("abberant_predator_leggings", () -> new AbberantPredatorArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> ABBERANT_PREDATOR_BOOTS = ITEMS.register("abberant_predator_boots", () -> new AbberantPredatorArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Bounty Hunter Armor

    public static final DeferredHolder<Item, Item> BOUNTY_HUNTER_HELMET = ITEMS.register("bounty_hunter_helmet", () -> new BountyHunterArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> BOUNTY_HUNTER_CHESTPLATE = ITEMS.register("bounty_hunter_chestplate", () -> new BountyHunterArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> BOUNTY_HUNTER_LEGGINGS = ITEMS.register("bounty_hunter_leggings", () -> new BountyHunterArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> BOUNTY_HUNTER_BOOTS = ITEMS.register("bounty_hunter_boots", () -> new BountyHunterArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Frostbite Hunter Armor

    public static final DeferredHolder<Item, Item> FROSTBITE_HUNTER_HELMET = ITEMS.register("frostbite_hunter_helmet", () -> new FrostbiteHunterArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> FROSTBITE_HUNTER_CHESTPLATE = ITEMS.register("frostbite_hunter_chestplate", () -> new FrostbiteHunterArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> FROSTBITE_HUNTER_LEGGINGS = ITEMS.register("frostbite_hunter_leggings", () -> new FrostbiteHunterArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> FROSTBITE_HUNTER_BOOTS = ITEMS.register("frostbite_hunter_boots", () -> new FrostbiteHunterArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Frostbite Knight Armor

    public static final DeferredHolder<Item, Item> FROSTBITE_KNIGHT_HELMET = ITEMS.register("frostbite_knight_helmet", () -> new FrostbiteKnightArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> FROSTBITE_KNIGHT_CHESTPLATE = ITEMS.register("frostbite_knight_chestplate", () -> new FrostbiteKnightArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> FROSTBITE_KNIGHT_LEGGINGS = ITEMS.register("frostbite_knight_leggings", () -> new FrostbiteKnightArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> FROSTBITE_KNIGHT_BOOTS = ITEMS.register("frostbite_knight_boots", () -> new FrostbiteKnightArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Frostbite Knight Armor

    public static final DeferredHolder<Item, Item> DREADSTEEL_KNIGHT_HELMET = ITEMS.register("dreadsteel_knight_helmet", () -> new DreadsteelKnightArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> DREADSTEEL_KNIGHT_CHESTPLATE = ITEMS.register("dreadsteel_knight_chestplate", () -> new DreadsteelKnightArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> DREADSTEEL_KNIGHT_LEGGINGS = ITEMS.register("dreadsteel_knight_leggings", () -> new DreadsteelKnightArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> DREADSTEEL_KNIGHT_BOOTS = ITEMS.register("dreadsteel_knight_boots", () -> new DreadsteelKnightArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Giorno Giovanna Armor

    public static final DeferredHolder<Item, Item> GIORNO_GIOVANNA_HELMET = ITEMS.register("giorno_giovanna_helmet", () -> new GiornoGiovannaArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> GIORNO_GIOVANNA_CHESTPLATE = ITEMS.register("giorno_giovanna_chestplate", () -> new GiornoGiovannaArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> GIORNO_GIOVANNA_LEGGINGS = ITEMS.register("giorno_giovanna_leggings", () -> new GiornoGiovannaArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> GIORNO_GIOVANNA_BOOTS = ITEMS.register("giorno_giovanna_boots", () -> new GiornoGiovannaArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Herta Puppet Armor

    public static final DeferredHolder<Item, Item> HERTA_PUPPET_HELMET = ITEMS.register("herta_puppet_helmet", () -> new HertaPuppetArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> HERTA_PUPPET_CHESTPLATE = ITEMS.register("herta_puppet_chestplate", () -> new HertaPuppetArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> HERTA_PUPPET_LEGGINGS = ITEMS.register("herta_puppet_leggings", () -> new HertaPuppetArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> HERTA_PUPPET_BOOTS = ITEMS.register("herta_puppet_boots", () -> new HertaPuppetArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Hazel Armor

    public static final DeferredHolder<Item, Item> HAZEL_HELMET = ITEMS.register("hazel_helmet", () -> new HazelArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> HAZEL_CHESTPLATE = ITEMS.register("hazel_chestplate", () -> new HazelArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> HAZEL_HOLY_MOLLY_CHESTPLATE = ITEMS.register("how_did_you_find_the_hazel_chestplate", () -> new HazelHOLYMOLYArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> HAZEL_LEGGINGS = ITEMS.register("hazel_leggings", () -> new HazelArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> HAZEL_BOOTS = ITEMS.register("hazel_boots", () -> new HazelArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Mothic Witch Armor

    public static final DeferredHolder<Item, Item> MOTHIC_WITCH_HELMET = ITEMS.register("mothic_witch_helmet", () -> new MothicWitchArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> MOTHIC_WITCH_CHESTPLATE = ITEMS.register("mothic_witch_chestplate", () -> new NerfedMothicWitchArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> MOTHIC_WITCH_SECRET_CHESTPLATE = ITEMS.register("how_did_you_find_the_mothic_witch_chestplate", () -> new MothicWitchArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> MOTHIC_WITCH_LEGGINGS = ITEMS.register("mothic_witch_leggings", () -> new MothicWitchArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> MOTHIC_WITCH_BOOTS = ITEMS.register("mothic_witch_boots", () -> new MothicWitchArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Iron431 Armor

    public static final DeferredHolder<Item, Item> IRON431_HELMET = ITEMS.register("iron431_helmet", () -> new Iron431ArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> IRON431_CHESTPLATE = ITEMS.register("iron431_chestplate", () -> new Iron431ArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> IRON431_LEGGINGS = ITEMS.register("iron431_leggings", () -> new Iron431ArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> IRON431_BOOTS = ITEMS.register("iron431_boots", () -> new Iron431ArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Ascended Iron431 Armor

    public static final DeferredHolder<Item, Item> ASCENDED_IRON431_HELMET = ITEMS.register("ascended_iron431_helmet", () -> new AscendedIron431ArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> ASCENDED_IRON431_CHESTPLATE = ITEMS.register("ascended_iron431_chestplate", () -> new AscendedIron431ArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> ASCENDED_IRON431_LEGGINGS = ITEMS.register("ascended_iron431_leggings", () -> new AscendedIron431ArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> ASCENDED_IRON431_BOOTS = ITEMS.register("ascended_iron431_boots", () -> new AscendedIron431ArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Legionnaire Ruler Armor

    public static final DeferredHolder<Item, Item> LEGIONNAIRE_RULER_HELMET = ITEMS.register("legionnaire_ruler_helmet", () -> new LegionnaireRulerArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> LEGIONNAIRE_RULER_CHESTPLATE = ITEMS.register("legionnaire_ruler_chestplate", () -> new LegionnaireRulerArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> LEGIONNAIRE_RULER_LEGGINGS = ITEMS.register("legionnaire_ruler_leggings", () -> new LegionnaireRulerArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> LEGIONNAIRE_RULER_BOOTS = ITEMS.register("legionnaire_ruler_boots", () -> new LegionnaireRulerArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Legionnaire Commander Armor

    public static final DeferredHolder<Item, Item> SOUL_LEGIONNAIRE_RULER_HELMET = ITEMS.register("soul_legionnaire_ruler_helmet", () -> new SoulLegionnaireRulerArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.HELMET.getDurability(90))));

    public static final DeferredHolder<Item, Item> SOUL_LEGIONNAIRE_RULER_CHESTPLATE = ITEMS.register("soul_legionnaire_ruler_chestplate", () -> new SoulLegionnaireRulerArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(90))));

    public static final DeferredHolder<Item, Item> SOUL_LEGIONNAIRE_RULER_LEGGINGS = ITEMS.register("soul_legionnaire_ruler_leggings", () -> new SoulLegionnaireRulerArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(90))));

    public static final DeferredHolder<Item, Item> SOUL_LEGIONNAIRE_RULER_BOOTS = ITEMS.register("soul_legionnaire_ruler_boots", () -> new SoulLegionnaireRulerArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.BOOTS.getDurability(90))));

    //Mage Hunter Armor

    public static final DeferredHolder<Item, Item> MAGEHUNTER_HELMET = ITEMS.register("magehunter_helmet", () -> new MageHunterArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> MAGEHUNTER_CHESTPLATE = ITEMS.register("magehunter_chestplate", () -> new MageHunterArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> MAGEHUNTER_LEGGINGS = ITEMS.register("magehunter_leggings", () -> new MageHunterArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> MAGEHUNTER_BOOTS = ITEMS.register("magehunter_boots", () -> new MageHunterArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Mithril Battlemage Armor

    public static final DeferredHolder<Item, Item> MITHRIL_BATTLEMAGE_HELMET = ITEMS.register("mithril_battlemage_helmet", () -> new MithrilBattlemageArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> MITHRIL_BATTLEMAGE_CHESTPLATE = ITEMS.register("mithril_battlemage_chestplate", () -> new MithrilBattlemageArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> MITHRIL_BATTLEMAGE_LEGGINGS = ITEMS.register("mithril_battlemage_leggings", () -> new MithrilBattlemageArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> MITHRIL_BATTLEMAGE_BOOTS = ITEMS.register("mithril_battlemage_boots", () -> new MithrilBattlemageArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Mycelium Guardian Armor

    public static final DeferredHolder<Item, Item> MYCELIUM_GUARDIAN_HELMET = ITEMS.register("mycelium_guardian_helmet", () -> new MyceliumGuardianArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> MYCELIUM_GUARDIAN_CHESTPLATE = ITEMS.register("mycelium_guardian_chestplate", () -> new MyceliumGuardianArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> MYCELIUM_GUARDIAN_LEGGINGS = ITEMS.register("mycelium_guardian_leggings", () -> new MyceliumGuardianArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> MYCELIUM_GUARDIAN_BOOTS = ITEMS.register("mycelium_guardian_boots", () -> new MyceliumGuardianArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Neru Armor

    public static final DeferredHolder<Item, Item> NERU_HELMET = ITEMS.register("neru_helmet", () -> new NeruArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> NERU_CHESTPLATE = ITEMS.register("neru_chestplate", () -> new NeruArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> NERU_LEGGINGS = ITEMS.register("neru_leggings", () -> new NeruArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> NERU_BOOTS = ITEMS.register("neru_boots", () -> new NeruArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Permafrost Prince Armor

    public static final DeferredHolder<Item, Item> PERMAFROST_PRINCE_HELMET = ITEMS.register("permafrost_prince_helmet", () -> new PermafrostPrinceArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> PERMAFROST_PRINCE_CHESTPLATE = ITEMS.register("permafrost_prince_chestplate", () -> new PermafrostPrinceArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> PERMAFROST_PRINCE_LEGGINGS = ITEMS.register("permafrost_prince_leggings", () -> new PermafrostPrinceArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> PERMAFROST_PRINCE_BOOTS = ITEMS.register("permafrost_prince_boots", () -> new PermafrostPrinceArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Pyrium Armor

    public static final DeferredHolder<Item, Item> PYRIUM_HELMET = ITEMS.register("pyrium_helmet", () -> new PyriumArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> PYRIUM_CHESTPLATE = ITEMS.register("pyrium_chestplate", () -> new PyriumArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> PYRIUM_LEGGINGS = ITEMS.register("pyrium_leggings", () -> new PyriumArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> PYRIUM_BOOTS = ITEMS.register("pyrium_boots", () -> new PyriumArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Pyrium Battlemage Armor

    public static final DeferredHolder<Item, Item> PYRIUM_BATTLEMAGE_HELMET = ITEMS.register("pyrium_battlemage_helmet", () -> new PyriumBattlemageArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> PYRIUM_BATTLEMAGE_CHESTPLATE = ITEMS.register("pyrium_battlemage_chestplate", () -> new PyriumBattlemageArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> PYRIUM_BATTLEMAGE_LEGGINGS = ITEMS.register("pyrium_battlemage_leggings", () -> new PyriumBattlemageArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> PYRIUM_BATTLEMAGE_BOOTS = ITEMS.register("pyrium_battlemage_boots", () -> new PyriumBattlemageArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(CinderousRarity.CINDEROUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Sacred Robes Armor

    public static final DeferredHolder<Item, Item> SACRED_ROBES_HELMET = ITEMS.register("sacred_robes_helmet", () -> new SacredRobesArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> SACRED_ROBES_CHESTPLATE = ITEMS.register("sacred_robes_chestplate", () -> new SacredRobesArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> SACRED_ROBES_LEGGINGS = ITEMS.register("sacred_robes_leggings", () -> new SacredRobesArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> SACRED_ROBES_BOOTS = ITEMS.register("sacred_robes_boots", () -> new SacredRobesArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Ascended Sacred Robes Armor

    public static final DeferredHolder<Item, Item> ASCENDED_SACRED_ROBES_HELMET = ITEMS.register("ascended_sacred_robes_helmet", () -> new AscendedSacredRobesArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
    ));
    public static final DeferredHolder<Item, Item> ASCENDED_SACRED_ROBES_CHESTPLATE = ITEMS.register("ascended_sacred_robes_chestplate", () -> new AscendedSacredRobesArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
    ));
    public static final DeferredHolder<Item, Item> ASCENDED_SACRED_ROBES_LEGGINGS = ITEMS.register("ascended_sacred_robes_leggings", () -> new AscendedSacredRobesArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
    ));
    public static final DeferredHolder<Item, Item> ASCENDED_SACRED_ROBES_BOOTS = ITEMS.register("ascended_sacred_robes_boots", () -> new AscendedSacredRobesArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            ));

    //Geckolib The Wither Armor

    public static final DeferredHolder<Item, Item> GECKOLIB_THE_WITHER_HELMET = ITEMS.register("geckolib_the_wither_helmet", () -> new GeckolibTheWitherArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(BloodRarity.BLOOD_RARITY_PROXY.getValue())
            .fireResistant()
    ));
    public static final DeferredHolder<Item, Item> GECKOLIB_THE_WITHER_CHESTPLATE = ITEMS.register("geckolib_the_wither_chestplate", () -> new GeckolibTheWitherArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(BloodRarity.BLOOD_RARITY_PROXY.getValue())
            .fireResistant()
    ));
    public static final DeferredHolder<Item, Item> GECKOLIB_THE_WITHER_LEGGINGS = ITEMS.register("geckolib_the_wither_leggings", () -> new GeckolibTheWitherArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(BloodRarity.BLOOD_RARITY_PROXY.getValue())
    ));
    public static final DeferredHolder<Item, Item> GECKOLIB_THE_WITHER_BOOTS = ITEMS.register("geckolib_the_wither_boots", () -> new GeckolibTheWitherArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .fireResistant()
            .rarity(BloodRarity.BLOOD_RARITY_PROXY.getValue())
    ));

    //Lemon God Armor

    public static final DeferredHolder<Item, Item> GECKOLIB_LEMON_GOD_HELMET = ITEMS.register("geckolib_lemon_god_helmet", () -> new GeckolibLemonGodArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_LEMON_GOD_CHESTPLATE = ITEMS.register("geckolib_lemon_god_chestplate", () -> new GeckolibLemonGodArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_LEMON_GOD_LEGGINGS = ITEMS.register("geckolib_lemon_god_leggings", () -> new GeckolibLemonGodArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_LEMON_GOD_BOOTS = ITEMS.register("geckolib_lemon_god_boots", () -> new GeckolibLemonGodArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    public static final DeferredHolder<Item, Item> GECKOLIB_ASCENDED_LEMON_GOD_HELMET = ITEMS.register("geckolib_ascended_lemon_god_helmet", () -> new GeckolibAscendedLemonGodArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_ASCENDED_LEMON_GOD_CHESTPLATE = ITEMS.register("geckolib_ascended_lemon_god_chestplate", () -> new GeckolibAscendedLemonGodArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_ASCENDED_LEMON_GOD_LEGGINGS = ITEMS.register("geckolib_ascended_lemon_god_leggings", () -> new GeckolibAscendedLemonGodArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_ASCENDED_LEMON_GOD_BOOTS = ITEMS.register("geckolib_ascended_lemon_god_boots", () -> new GeckolibAscendedLemonGodArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Shadow Scale Armor

    public static final DeferredHolder<Item, Item> SHADOW_SCALE_HELMET = ITEMS.register("shadow_scale_helmet", () -> new ShadowScaleArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(ShadowRarity.SHADOW_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> SHADOW_SCALE_CHESTPLATE = ITEMS.register("shadow_scale_chestplate", () -> new ShadowScaleArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(ShadowRarity.SHADOW_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> SHADOW_SCALE_LEGGINGS = ITEMS.register("shadow_scale_leggings", () -> new ShadowScaleArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(ShadowRarity.SHADOW_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> SHADOW_SCALE_BOOTS = ITEMS.register("shadow_scale_boots", () -> new ShadowScaleArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(ShadowRarity.SHADOW_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Gabriel ULTRAKILL Armor

    public static final DeferredHolder<Item, Item> GECKOLIB_GABRIEL_ULTRAKILL_HELMET = ITEMS.register("geckolib_gabriel_ultrakill_helmet", () -> new GeckolibGabrielArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_GABRIEL_ULTRAKILL_CHESTPLATE = ITEMS.register("geckolib_gabriel_ultrakill_chestplate", () -> new GeckolibGabrielElytraItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_GABRIEL_ULTRAKILL_LEGGINGS = ITEMS.register("geckolib_gabriel_ultrakill_leggings", () -> new GeckolibGabrielArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> GECKOLIB_GABRIEL_ULTRAKILL_BOOTS = ITEMS.register("geckolib_gabriel_ultrakill_boots", () -> new GeckolibGabrielArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));

    //Shadowwalker Enderman Armor

    public static final DeferredHolder<Item, Item> ENDERMAN_BLINDFOLD = ITEMS.register("shadowwalker_enderman_blindfold", () -> new ShadowwalkerEndermanBlindfoldItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.HELMET.getDurability(37))));

    public static final DeferredHolder<Item, Item> ENDERMAN_HOOD = ITEMS.register("shadowwalker_enderman_hood", () -> new ShadowwalkerEndermanHoodItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.HELMET.getDurability(37))));

    public static final DeferredHolder<Item, Item> ENDERMAN_MASKED = ITEMS.register("shadowwalker_enderman_masked", () -> new ShadowwalkerEndermanArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.HELMET.getDurability(37))));

    public static final DeferredHolder<Item, Item> ENDERMAN_CHESTPLATE = ITEMS.register("shadowwalker_enderman_chestplate", () -> new ShadowwalkerEndermanArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));
    public static final DeferredHolder<Item, Item> ENDERMAN_LEGGINGS = ITEMS.register("shadowwalker_enderman_leggings", () -> new ShadowwalkerEndermanArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.LEGGINGS.getDurability(37))));
    public static final DeferredHolder<Item, Item> ENDERMAN_BOOTS = ITEMS.register("shadowwalker_enderman_boots", () -> new ShadowwalkerEndermanArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.BOOTS.getDurability(37))));

    //Pyromancer Brute Armor

    public static final DeferredHolder<Item, Item> PYROMANCER_BRUTE_HELMET = ITEMS.register("pyromancer_brute_helmet", () -> new PyromancerBruteArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.HELMET.getDurability(37))));

    public static final DeferredHolder<Item, Item> PYROMANCER_BRUTE_CHESTPLATE = ITEMS.register("pyromancer_brute_chestplate", () -> new PyromancerBruteArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(Rarity.EPIC)
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));

    //Bishop of Deceit Armor

    public static final DeferredHolder<Item, Item> BISHOP_OF_DECEIT_HELMET = ITEMS.register("bishop_of_deceit_helmet", () -> new BishopOfDeceitArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.HELMET.getDurability(37))));

    public static final DeferredHolder<Item, Item> BISHOP_OF_DECEIT_CHESTPLATE = ITEMS.register("bishop_of_deceit_chestplate", () -> new BishopOfDeceitArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));

    //Necromancer Armor

    public static final DeferredHolder<Item, Item> NECROMANCER_HELMET = ITEMS.register("necromancer_helmet", () -> new NecromancerArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.HELMET.getDurability(37))));

    public static final DeferredHolder<Item, Item> NECROMANCER_CHESTPLATE = ITEMS.register("necromancer_chestplate", () -> new NecromancerArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));

    public static final DeferredHolder<Item, Item> NECROMANCER_LEGGINGS = ITEMS.register("necromancer_leggings", () -> new NecromancerArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.LEGGINGS.getDurability(37))));

    //Nameless One Armor

    public static final DeferredHolder<Item, Item> NAMELESS_ONE_HELMET = ITEMS.register("nameless_one_helmet", () -> new NamelessOneArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.HELMET.getDurability(37))));

    public static final DeferredHolder<Item, Item> NAMELESS_ONE_CHESTPLATE = ITEMS.register("nameless_one_chestplate", () -> new NamelessOneArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(37))));

    public static final DeferredHolder<Item, Item> NAMELESS_ONE_LEGGINGS = ITEMS.register("nameless_one_leggings", () -> new NamelessOneArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .durability(ArmorItem.Type.LEGGINGS.getDurability(37))));


    //Chlorophyte Armor

    public static final DeferredHolder<Item, Item> CHLOROPHYTE_HELMET = ITEMS.register("chlorophyte_helmet", () -> new ChlorophyteHelmetArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(NatureRarity.NATURE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> CHLOROPHYTE_MASK = ITEMS.register("chlorophyte_mask", () -> new ChlorophyteMaskArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(NatureRarity.NATURE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> CHLOROPHYTE_HEADGEAR = ITEMS.register("chlorophyte_headgear", () -> new ChlorophyteHeadgearArmorItem(ArmorItem.Type.HELMET, ItemPropertiesHelper
            .equipment(1)
            .rarity(NatureRarity.NATURE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.HELMET.getDurability(64))));
    public static final DeferredHolder<Item, Item> CHLOROPHYTE_CHESTPLATE = ITEMS.register("chlorophyte_chestplate", () -> new ChlorophyteArmorItem(ArmorItem.Type.CHESTPLATE, ItemPropertiesHelper
            .equipment(1)
            .rarity(NatureRarity.NATURE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.CHESTPLATE.getDurability(64))));
    public static final DeferredHolder<Item, Item> CHLOROPHYTE_LEGGINGS = ITEMS.register("chlorophyte_leggings", () -> new ChlorophyteArmorItem(ArmorItem.Type.LEGGINGS, ItemPropertiesHelper
            .equipment(1)
            .rarity(NatureRarity.NATURE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.LEGGINGS.getDurability(64))));
    public static final DeferredHolder<Item, Item> CHLOROPHYTE_BOOTS = ITEMS.register("chlorophyte_boots", () -> new ChlorophyteArmorItem(ArmorItem.Type.BOOTS, ItemPropertiesHelper
            .equipment(1)
            .rarity(NatureRarity.NATURE_RARITY_PROXY.getValue())
            .fireResistant()
            .durability(ArmorItem.Type.BOOTS.getDurability(64))));




    public static Collection<DeferredHolder<Item, ? extends Item>> getHnSItems()
    {
        return ITEMS.getEntries();
    }

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
