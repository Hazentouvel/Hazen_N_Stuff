package net.hazen.hazennstuff;

import com.mojang.logging.LogUtils;
import io.redspace.ironsspellbooks.item.SpellBook;
import io.redspace.ironsspellbooks.render.SpellBookCurioRenderer;
import mod.azure.azurelib.common.animation.cache.AzIdentityRegistry;
import mod.azure.azurelib.common.render.armor.AzArmorRendererRegistry;
import mod.azure.azurelib.common.render.item.AzItemRendererRegistry;
import net.acetheeldritchking.aces_spell_utils.entity.render.items.SheathCurioRenderer;
import net.acetheeldritchking.aces_spell_utils.items.curios.SheathCurioItem;
import net.hazen.hazennstuff.Item.Armor.Dedicated.Fireblossom.DormantTier.AzureLib.FireblossomGownArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.Dedicated.Fireblossom.PureTier.AzureLib.FireblossomBattlemageArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.Dedicated.Fireblossom.SchoolTier.AzureLib.FireblossomKnightArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.PureTier.AstraconicWeaver.AzureLib.AstraconicWeaverArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.SchoolTier.CosmicScholar.AzureLib.CosmicScholarArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.SchoolTier.RadiantCrystal.AzureLib.RadiantCrystalArmorRenderer;
import net.hazen.hazennstuff.Item.Block.HnSBlockEntities;
import net.hazen.hazennstuff.Item.Block.HnSBlocks;
import net.hazen.hazennstuff.Compat.*;
import net.hazen.hazennstuff.Item.Armor.Dedicated.ArbitriumRobes.AzureLib.ArbitriumRobesArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.PureTier.Blazeborne.AzureLib.BlazeborneArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.PureTier.CreakingSorcerer.AzureLib.CreakingSorcererArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.Dedicated.DarkRitualTemplar.AzureLib.DarkRitualTemplarArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.PureTier.EnderDragon.AzureLib.EnderDragonArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.Dedicated.Fireblossom.Legacy.AzureLib.FireblossomBattlemageCrownedArmorRendererLegacy;
import net.hazen.hazennstuff.Item.Armor.Dedicated.Fireblossom.Legacy.AzureLib.FireblossomBattlemageHelmetArmorRendererLegacy;
import net.hazen.hazennstuff.Item.Armor.Cosmetic.PureTier.GabrielULTRAKILL.AzureLib.GabrielArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.PureTier.Infestation.AzureLib.InfestationArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.Dedicated.LemonGod.AzureLib.LemonGodArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.Dedicated.SLCCat.SLCCatArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.PureTier.Seraph.AzureLib.SeraphArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.PureTier.SupremeWitch.AzureLib.SupremeWitchArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.PureTier.TheWither.AzureLib.TheWitherArmorRenderer;
import net.hazen.hazennstuff.HnSUtilities.Armor.HnSArmorMaterials;
import net.hazen.hazennstuff.Item.Curios.Sheaths.GalvanizedSheath.GalvanizedSheathItemRenderer;
import net.hazen.hazennstuff.Item.Curios.Sheaths.ScrollSheath.ScrollSheathItemRenderer;
import net.hazen.hazennstuff.Item.Curios.Spellbooks.EnergizedCoreSpellbook.EnergizedCoreSpellbookRenderer;
import net.hazen.hazennstuff.Item.Curios.Wings.ArbitriumWings.ArbitriumWingsCurioItemRenderer;
import net.hazen.hazennstuff.Item.Curios.Wings.ArbitriumWings.ArbitriumWingsCurioRenderer;
import net.hazen.hazennstuff.Item.Staves.CeaselessVoid.CeaselessVoidRenderer;
import net.hazen.hazennstuff.Item.Staves.InsaniaAeternus.InsaniaAeternusRenderer;
import net.hazen.hazennstuff.Item.Staves.SoulcallingScepter.SoulcallingScepterRenderer;
import net.hazen.hazennstuff.Item.Weapons.Generic.HammerOfJustice.HammerOfJusticeRenderer;
import net.hazen.hazennstuff.Item.Weapons.Generic.Terraprisma.TerraprismaRenderer;
import net.hazen.hazennstuff.Item.Weapons.Generic.Volcano.VolcanoRenderer;
import net.hazen.hazennstuff.Registries.*;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

@Mod(HazenNStuff.MOD_ID)
public class HazenNStuff
{
    public static final String MOD_ID = "hazennstuff";
    public static final Logger LOGGER = LogUtils.getLogger();
    public HazenNStuff(IEventBus modEventBus, ModContainer modContainer)
    {
        NeoForge.EVENT_BUS.register(this);

        //Magic Mod Compat
        MalumCompat.init();
        ArsNoveauCompat.init();

        //ISS Addons Compat
        AACompat.init();
        CSCompat.init();
        DTECompat.init();
        ESSRCompat.init();
        TNTCompat.init();
        MFTECompat.init();

        HnSCreativeModeTabs.register(modEventBus);

        HnSItemRegistry.register(modEventBus);
        HnSBlocks.register(modEventBus);
        HnSBlockEntities.register(modEventBus);
        HnSArmorMaterials.register(modEventBus);

        HnSEffects.register(modEventBus);
        HnSParticleRegistry.register(modEventBus);
        HnSSounds.register(modEventBus);
        HnSEntityRegistry.register(modEventBus);

        HnSSpellRegistries.register(modEventBus);
        HnSAttributeRegistry.register(modEventBus);
        HnSSchoolRegistry.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        modContainer.registerConfig(ModConfig.Type.COMMON, HnSConfig.SPEC, String.format("%s-common.toml", "hazennstuff"));
    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Animation Registry
        AzIdentityRegistry.register(

                //Armor

                HnSItemRegistry.ARBITRIUM_ROBES_HELMET.get(),
                HnSItemRegistry.ARBITRIUM_ROBES_CHESTPLATE.get(),
                HnSItemRegistry.ARBITRIUM_ROBES_LEGGINGS.get(),
                HnSItemRegistry.ARBITRIUM_ROBES_BOOTS.get(),
                HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_HELMET.get(),
                HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get(),
                HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get(),
                HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_BOOTS.get(),

                HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_HELMET.get(),
                HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get(),
                HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get(),
                HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_BOOTS.get(),
                HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_BOOTS.get(),

                HnSItemRegistry.INFESTATION_HELMET.get(),
                HnSItemRegistry.INFESTATION_CHESTPLATE.get(),
                HnSItemRegistry.INFESTATION_LEGGINGS.get(),
                HnSItemRegistry.INFESTATION_BOOTS.get(),


                HnSItemRegistry.BLAZEBORNE_HELMET.get(),
                HnSItemRegistry.BLAZEBORNE_CHESTPLATE.get(),
                HnSItemRegistry.BLAZEBORNE_LEGGINGS.get(),
                HnSItemRegistry.BLAZEBORNE_BOOTS.get(),

                HnSItemRegistry.LEMON_GOD_HELMET.get(),
                HnSItemRegistry.LEMON_GOD_CHESTPLATE.get(),
                HnSItemRegistry.LEMON_GOD_LEGGINGS.get(),
                HnSItemRegistry.LEMON_GOD_BOOTS.get(),

                HnSItemRegistry.ASCENDED_LEMON_GOD_HELMET.get(),
                HnSItemRegistry.ASCENDED_LEMON_GOD_CHESTPLATE.get(),
                HnSItemRegistry.ASCENDED_LEMON_GOD_LEGGINGS.get(),
                HnSItemRegistry.ASCENDED_LEMON_GOD_BOOTS.get(),

                HnSItemRegistry.THE_WITHER_HELMET.get(),
                HnSItemRegistry.THE_WITHER_CHESTPLATE.get(),
                HnSItemRegistry.THE_WITHER_LEGGINGS.get(),
                HnSItemRegistry.THE_WITHER_BOOTS.get(),

                HnSItemRegistry.GABRIEL_ULTRAKILL_HELMET.get(),
                HnSItemRegistry.GABRIEL_ULTRAKILL_CHESTPLATE.get(),
                HnSItemRegistry.GABRIEL_ULTRAKILL_LEGGINGS.get(),
                HnSItemRegistry.GABRIEL_ULTRAKILL_BOOTS.get(),

                HnSItemRegistry.SLC_CAT_HELMET.get(),
                HnSItemRegistry.SLC_CAT_CHESTPLATE.get(),
                HnSItemRegistry.SLC_CAT_LEGGINGS.get(),
                HnSItemRegistry.SLC_CAT_BOOTS.get(),

                // Weapons

                HnSItemRegistry.HAMMER_OF_JUSTICE.get(),
                HnSItemRegistry.VOLCANO.get(),
                HnSItemRegistry.TERRAPRISMA.get(),

                // Staves
                HnSItemRegistry.SOULCALLING_SCEPTER.get(),
                HnSItemRegistry.INSANIA_AETERNUS.get(),

                // Curios

                HnSItemRegistry.ENERGIZED_CORE_SPELLBOOK.get(),

                HnSItemRegistry.ARBITRIUM_WINGS.get(),

                HnSItemRegistry.GALVANIZED_SHEATH.get(),
                HnSItemRegistry.SCROLL_SHEATH.get()

        );
    }

    @EventBusSubscriber(value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

            HnSItemRegistry.getHnSItems().stream().filter(item -> item.get() instanceof SpellBook).forEach((item) -> CuriosRendererRegistry.register(item.get(), SpellBookCurioRenderer::new));
            HnSItemRegistry.getHnSItems().stream().filter(item -> item.get() instanceof SheathCurioItem).forEach((item) -> CuriosRendererRegistry.register(item.get(), SheathCurioRenderer::new));


            // Armor Rendering Registry

            //Arbitrium Robes
            AzArmorRendererRegistry.register(ArbitriumRobesArmorRenderer::new,
                    HnSItemRegistry.ARBITRIUM_ROBES_HELMET.get(),
                    HnSItemRegistry.ARBITRIUM_ROBES_CHESTPLATE.get(),
                    HnSItemRegistry.ARBITRIUM_ROBES_LEGGINGS.get(),
                    HnSItemRegistry.ARBITRIUM_ROBES_BOOTS.get());

            //Creaking
            AzArmorRendererRegistry.register(CreakingSorcererArmorRenderer::new,
                    HnSItemRegistry.CREAKING_HELMET.get(),
                    HnSItemRegistry.CREAKING_CHESTPLATE.get(),
                    HnSItemRegistry.CREAKING_LEGGINGS.get(),
                    HnSItemRegistry.CREAKING_BOOTS.get());

            //Dark Ritual Templar
            AzArmorRendererRegistry.register(DarkRitualTemplarArmorRenderer::new,
                    HnSItemRegistry.DARK_RITUAL_TEMPLAR_HELMET.get(),
                    HnSItemRegistry.DARK_RITUAL_TEMPLAR_CHESTPLATE.get(),
                    HnSItemRegistry.DARK_RITUAL_TEMPLAR_LEGGINGS.get(),
                    HnSItemRegistry.DARK_RITUAL_TEMPLAR_BOOTS.get());

            // Ender Dragon
            AzArmorRendererRegistry.register(EnderDragonArmorRenderer::new,
                    HnSItemRegistry.ENDER_DRAGON_HELMET.get(),
                    HnSItemRegistry.ENDER_DRAGON_CHESTPLATE.get(),
                    HnSItemRegistry.ENDER_DRAGON_LEGGINGS.get(),
                    HnSItemRegistry.ENDER_DRAGON_BOOTS.get());

            // Fireblossom Helmet
            AzArmorRendererRegistry.register(FireblossomBattlemageHelmetArmorRendererLegacy::new,
                    HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_HELMET.get(),
                    HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get(),
                    HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get(),
                    HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_BOOTS.get());
            // Fireblossom Crown
            AzArmorRendererRegistry.register(FireblossomBattlemageCrownedArmorRendererLegacy::new,
                    HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_CROWN.get());

            // Seraph
            AzArmorRendererRegistry.register(SeraphArmorRenderer::new,
                    HnSItemRegistry.SERAPH_HELMET.get(),
                    HnSItemRegistry.SERAPH_CHESTPLATE.get(),
                    HnSItemRegistry.SERAPH_LEGGINGS.get(),
                    HnSItemRegistry.SERAPH_BOOTS.get());

            // Supreme Witch
            AzArmorRendererRegistry.register(SupremeWitchArmorRenderer::new,
                    HnSItemRegistry.SUPREME_WITCH_HELMET.get(),
                    HnSItemRegistry.SUPREME_WITCH_CHESTPLATE.get(),
                    HnSItemRegistry.SUPREME_WITCH_LEGGINGS.get(),
                    HnSItemRegistry.SUPREME_WITCH_BOOTS.get());

            // SLC!Cat
            AzArmorRendererRegistry.register(SLCCatArmorRenderer::new,
                    HnSItemRegistry.SLC_CAT_HELMET.get(),
                    HnSItemRegistry.SLC_CAT_CHESTPLATE.get(),
                    HnSItemRegistry.SLC_CAT_LEGGINGS.get(),
                    HnSItemRegistry.SLC_CAT_BOOTS.get());

            // Infestation
            AzArmorRendererRegistry.register(InfestationArmorRenderer::new,
                    HnSItemRegistry.INFESTATION_HELMET.get(),
                    HnSItemRegistry.INFESTATION_CHESTPLATE.get(),
                    HnSItemRegistry.INFESTATION_LEGGINGS.get(),
                    HnSItemRegistry.INFESTATION_BOOTS.get());

            // Blazeborne
            AzArmorRendererRegistry.register(BlazeborneArmorRenderer::new,
                    HnSItemRegistry.BLAZEBORNE_HELMET.get(),
                    HnSItemRegistry.BLAZEBORNE_CHESTPLATE.get(),
                    HnSItemRegistry.BLAZEBORNE_LEGGINGS.get(),
                    HnSItemRegistry.BLAZEBORNE_BOOTS.get());

            //
            AzArmorRendererRegistry.register(LemonGodArmorRenderer::new,
                    HnSItemRegistry.LEMON_GOD_HELMET.get(),
                    HnSItemRegistry.LEMON_GOD_CHESTPLATE.get(),
                    HnSItemRegistry.LEMON_GOD_LEGGINGS.get(),
                    HnSItemRegistry.LEMON_GOD_BOOTS.get());

            // Ascended Lemon God
            AzArmorRendererRegistry.register(LemonGodArmorRenderer::new,
                    HnSItemRegistry.ASCENDED_LEMON_GOD_HELMET.get(),
                    HnSItemRegistry.ASCENDED_LEMON_GOD_CHESTPLATE.get(),
                    HnSItemRegistry.ASCENDED_LEMON_GOD_LEGGINGS.get(),
                    HnSItemRegistry.ASCENDED_LEMON_GOD_BOOTS.get());

            // The Wither
            AzArmorRendererRegistry.register(TheWitherArmorRenderer::new,
                    HnSItemRegistry.THE_WITHER_HELMET.get(),
                    HnSItemRegistry.THE_WITHER_CHESTPLATE.get(),
                    HnSItemRegistry.THE_WITHER_LEGGINGS.get(),
                    HnSItemRegistry.THE_WITHER_BOOTS.get());

            // Ascended Arbitrium Robes
            AzArmorRendererRegistry.register(ArbitriumRobesArmorRenderer::new,
                    HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_HELMET.get(),
                    HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get(),
                    HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get(),
                    HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_BOOTS.get());

            // Cosmic Scholar
            AzArmorRendererRegistry.register(CosmicScholarArmorRenderer::new,
                    HnSItemRegistry.COSMIC_SCHOLAR_HELMET.get(),
                    HnSItemRegistry.COSMIC_SCHOLAR_CHESTPLATE.get(),
                    HnSItemRegistry.COSMIC_SCHOLAR_LEGGINGS.get(),
                    HnSItemRegistry.COSMIC_SCHOLAR_BOOTS.get());

            // Astraconic Weaver
            AzArmorRendererRegistry.register(AstraconicWeaverArmorRenderer::new,
                    HnSItemRegistry.ASTRACONIC_WEAVER_HELMET.get(),
                    HnSItemRegistry.ASTRACONIC_WEAVER_CHESTPLATE.get(),
                    HnSItemRegistry.ASTRACONIC_WEAVER_LEGGINGS.get(),
                    HnSItemRegistry.ASTRACONIC_WEAVER_BOOTS.get());

            // Radiant Crystal
            AzArmorRendererRegistry.register(RadiantCrystalArmorRenderer::new,
                    HnSItemRegistry.RADIANT_CRYSTAL_HELMET.get(),
                    HnSItemRegistry.RADIANT_CRYSTAL_CHESTPLATE.get(),
                    HnSItemRegistry.RADIANT_CRYSTAL_LEGGINGS.get(),
                    HnSItemRegistry.RADIANT_CRYSTAL_BOOTS.get());

            // Fireblossom Gown
            AzArmorRendererRegistry.register(FireblossomGownArmorRenderer::new,
                    HnSItemRegistry.FIREBLOSSOM_GOWN_HELMET.get(),
                    HnSItemRegistry.FIREBLOSSOM_GOWN_CHESTPLATE.get(),
                    HnSItemRegistry.FIREBLOSSOM_GOWN_LEGGINGS.get(),
                    HnSItemRegistry.FIREBLOSSOM_GOWN_BOOTS.get());

            // Fireblossom Knight
            AzArmorRendererRegistry.register(FireblossomKnightArmorRenderer::new,
                    HnSItemRegistry.FIREBLOSSOM_KNIGHT_HELMET.get(),
                    HnSItemRegistry.FIREBLOSSOM_KNIGHT_CHESTPLATE.get(),
                    HnSItemRegistry.FIREBLOSSOM_KNIGHT_LEGGINGS.get(),
                    HnSItemRegistry.FIREBLOSSOM_KNIGHT_BOOTS.get());

            // Fireblossom Battlemage
            AzArmorRendererRegistry.register(FireblossomBattlemageArmorRenderer::new,
                    HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_HELMET.get(),
                    HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get(),
                    HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get(),
                    HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get());

            // Gabriel Ultrakill
            AzArmorRendererRegistry.register(GabrielArmorRenderer::new,
                    HnSItemRegistry.GABRIEL_ULTRAKILL_HELMET.get(),
                    HnSItemRegistry.GABRIEL_ULTRAKILL_CHESTPLATE.get(),
                    HnSItemRegistry.GABRIEL_ULTRAKILL_LEGGINGS.get(),
                    HnSItemRegistry.GABRIEL_ULTRAKILL_BOOTS.get());



            // Item Rendering Registry
            AzItemRendererRegistry.register(HammerOfJusticeRenderer::new, HnSItemRegistry.HAMMER_OF_JUSTICE.get());
            AzItemRendererRegistry.register(VolcanoRenderer::new, HnSItemRegistry.VOLCANO.get());
            AzItemRendererRegistry.register(TerraprismaRenderer::new, HnSItemRegistry.TERRAPRISMA.get());


            AzItemRendererRegistry.register(SoulcallingScepterRenderer::new, HnSItemRegistry.SOULCALLING_SCEPTER.get());
            AzItemRendererRegistry.register(InsaniaAeternusRenderer::new, HnSItemRegistry.INSANIA_AETERNUS.get());
            AzItemRendererRegistry.register(CeaselessVoidRenderer::new, HnSItemRegistry.CEASELESS_VOID.get());

            //Curios Rendering Registry

            /*
            *** Spellbooks
             */

            AzItemRendererRegistry.register(EnergizedCoreSpellbookRenderer::new, HnSItemRegistry.ENERGIZED_CORE_SPELLBOOK.get());

            /*
            *** Sheaths
             */

            AzItemRendererRegistry.register(ScrollSheathItemRenderer::new, HnSItemRegistry.SCROLL_SHEATH.get());
            AzItemRendererRegistry.register(GalvanizedSheathItemRenderer::new, HnSItemRegistry.GALVANIZED_SHEATH.get());

            /*
            *** Wings
             */

            // Arbitrium Wings
            AzArmorRendererRegistry.register(ArbitriumWingsCurioItemRenderer::new, HnSItemRegistry.ARBITRIUM_WINGS.get());
            CuriosRendererRegistry.register(
                    HnSItemRegistry.ARBITRIUM_WINGS.get(), ArbitriumWingsCurioRenderer::new
            );



            // Animation Registry
            AzIdentityRegistry.register(

                    //Armor

                    HnSItemRegistry.ARBITRIUM_ROBES_HELMET.get(),
                    HnSItemRegistry.ARBITRIUM_ROBES_CHESTPLATE.get(),
                    HnSItemRegistry.ARBITRIUM_ROBES_LEGGINGS.get(),
                    HnSItemRegistry.ARBITRIUM_ROBES_BOOTS.get(),
                    HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_HELMET.get(),
                    HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get(),
                    HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get(),
                    HnSItemRegistry.ASCENDED_ARBITRIUM_ROBES_BOOTS.get(),

                    HnSItemRegistry.CREAKING_HELMET.get(),
                    HnSItemRegistry.CREAKING_CHESTPLATE.get(),
                    HnSItemRegistry.CREAKING_LEGGINGS.get(),
                    HnSItemRegistry.CREAKING_BOOTS.get(),

                    HnSItemRegistry.DARK_RITUAL_TEMPLAR_HELMET.get(),
                    HnSItemRegistry.DARK_RITUAL_TEMPLAR_CHESTPLATE.get(),
                    HnSItemRegistry.DARK_RITUAL_TEMPLAR_LEGGINGS.get(),
                    HnSItemRegistry.DARK_RITUAL_TEMPLAR_BOOTS.get(),

                    HnSItemRegistry.ENDER_DRAGON_HELMET.get(),
                    HnSItemRegistry.ENDER_DRAGON_CHESTPLATE.get(),
                    HnSItemRegistry.ENDER_DRAGON_LEGGINGS.get(),
                    HnSItemRegistry.ENDER_DRAGON_BOOTS.get(),

                    HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_HELMET.get(),
                    HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_CROWN.get(),
                    HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get(),
                    HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get(),
                    HnSItemRegistry.LEGACY_FIREBLOSSOM_BATTLEMAGE_BOOTS.get(),

                    HnSItemRegistry.SERAPH_HELMET.get(),
                    HnSItemRegistry.SERAPH_CHESTPLATE.get(),
                    HnSItemRegistry.SERAPH_LEGGINGS.get(),
                    HnSItemRegistry.SERAPH_BOOTS.get(),

                    HnSItemRegistry.SUPREME_WITCH_HELMET.get(),
                    HnSItemRegistry.SUPREME_WITCH_CHESTPLATE.get(),
                    HnSItemRegistry.SUPREME_WITCH_LEGGINGS.get(),
                    HnSItemRegistry.SUPREME_WITCH_BOOTS.get(),

                    HnSItemRegistry.SLC_CAT_HELMET.get(),
                    HnSItemRegistry.SLC_CAT_CHESTPLATE.get(),
                    HnSItemRegistry.SLC_CAT_LEGGINGS.get(),
                    HnSItemRegistry.SLC_CAT_BOOTS.get(),

                    HnSItemRegistry.INFESTATION_HELMET.get(),
                    HnSItemRegistry.INFESTATION_CHESTPLATE.get(),
                    HnSItemRegistry.INFESTATION_LEGGINGS.get(),
                    HnSItemRegistry.INFESTATION_BOOTS.get(),


                    HnSItemRegistry.BLAZEBORNE_HELMET.get(),
                    HnSItemRegistry.BLAZEBORNE_CHESTPLATE.get(),
                    HnSItemRegistry.BLAZEBORNE_LEGGINGS.get(),
                    HnSItemRegistry.BLAZEBORNE_BOOTS.get(),

                    HnSItemRegistry.LEMON_GOD_HELMET.get(),
                    HnSItemRegistry.LEMON_GOD_CHESTPLATE.get(),
                    HnSItemRegistry.LEMON_GOD_LEGGINGS.get(),
                    HnSItemRegistry.LEMON_GOD_BOOTS.get(),

                    HnSItemRegistry.ASCENDED_LEMON_GOD_HELMET.get(),
                    HnSItemRegistry.ASCENDED_LEMON_GOD_CHESTPLATE.get(),
                    HnSItemRegistry.ASCENDED_LEMON_GOD_LEGGINGS.get(),
                    HnSItemRegistry.ASCENDED_LEMON_GOD_BOOTS.get(),

                    HnSItemRegistry.THE_WITHER_HELMET.get(),
                    HnSItemRegistry.THE_WITHER_CHESTPLATE.get(),
                    HnSItemRegistry.THE_WITHER_LEGGINGS.get(),
                    HnSItemRegistry.THE_WITHER_BOOTS.get(),

                    HnSItemRegistry.GABRIEL_ULTRAKILL_HELMET.get(),
                    HnSItemRegistry.GABRIEL_ULTRAKILL_CHESTPLATE.get(),
                    HnSItemRegistry.GABRIEL_ULTRAKILL_LEGGINGS.get(),
                    HnSItemRegistry.GABRIEL_ULTRAKILL_BOOTS.get(),

                    HnSItemRegistry.FIREBLOSSOM_GOWN_HELMET.get(),
                    HnSItemRegistry.FIREBLOSSOM_GOWN_CHESTPLATE.get(),
                    HnSItemRegistry.FIREBLOSSOM_GOWN_LEGGINGS.get(),
                    HnSItemRegistry.FIREBLOSSOM_GOWN_BOOTS.get(),

                    HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_HELMET.get(),
                    HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get(),
                    HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get(),
                    HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get(),

                    HnSItemRegistry.FIREBLOSSOM_KNIGHT_HELMET.get(),
                    HnSItemRegistry.FIREBLOSSOM_KNIGHT_CHESTPLATE.get(),
                    HnSItemRegistry.FIREBLOSSOM_KNIGHT_LEGGINGS.get(),
                    HnSItemRegistry.FIREBLOSSOM_KNIGHT_BOOTS.get(),

                    // Weapons

                    HnSItemRegistry.HAMMER_OF_JUSTICE.get(),
                    HnSItemRegistry.VOLCANO.get(),
                    HnSItemRegistry.TERRAPRISMA.get(),

                    // Staves
                    HnSItemRegistry.SOULCALLING_SCEPTER.get(),
                    HnSItemRegistry.INSANIA_AETERNUS.get(),
                    HnSItemRegistry.CEASELESS_VOID.get(),

                    // Curios

                    HnSItemRegistry.ENERGIZED_CORE_SPELLBOOK.get(),

                    HnSItemRegistry.ARBITRIUM_WINGS.get(),

                    HnSItemRegistry.GALVANIZED_SHEATH.get(),
                    HnSItemRegistry.SCROLL_SHEATH.get()

            );
        }
    }

    public static ResourceLocation id(@NotNull String path)
    {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, path);
    }
}