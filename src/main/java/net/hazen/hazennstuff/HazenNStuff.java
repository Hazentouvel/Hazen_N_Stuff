package net.hazen.hazennstuff;

import mod.azure.azurelib.rewrite.animation.cache.AzIdentityRegistry;
import mod.azure.azurelib.rewrite.render.armor.AzArmorRendererRegistry;
import mod.azure.azurelib.rewrite.render.item.AzItemRendererRegistry;
import net.hazen.hazennstuff.block.HnSBlocks;
import net.hazen.hazennstuff.compat.*;
import net.hazen.hazennstuff.item.armor.AzureLib.ArbitriumRobes.ArbitriumRobesArmorRenderer;
import net.hazen.hazennstuff.item.armor.AzureLib.Blazeborne.BlazeborneArmorRenderer;
import net.hazen.hazennstuff.item.armor.AzureLib.CreakingSorcerer.CreakingSorcererArmorRenderer;
import net.hazen.hazennstuff.item.armor.AzureLib.DarkRitualTemplar.DarkRitualTemplarArmorRenderer;
import net.hazen.hazennstuff.item.armor.AzureLib.EnderDragon.EnderDragonArmorRenderer;
import net.hazen.hazennstuff.item.armor.AzureLib.FireblossomBattlemage.FireblossomBattlemageCrownedArmorRenderer;
import net.hazen.hazennstuff.item.armor.AzureLib.FireblossomBattlemage.FireblossomBattlemageHelmetArmorRenderer;
import net.hazen.hazennstuff.item.armor.AzureLib.GabrielULTRAKILL.GabrielArmorRenderer;
import net.hazen.hazennstuff.item.armor.AzureLib.Infestation.InfestationArmorRenderer;
import net.hazen.hazennstuff.item.armor.AzureLib.LemonGod.LemonGodArmorRenderer;
import net.hazen.hazennstuff.item.armor.AzureLib.SLCCat.SLCCatArmorRenderer;
import net.hazen.hazennstuff.item.armor.AzureLib.Seraph.SeraphArmorRenderer;
import net.hazen.hazennstuff.item.armor.AzureLib.SoulFlame.SoulFlameArmorRenderer;
import net.hazen.hazennstuff.item.armor.AzureLib.SupremeWitch.SupremeWitchArmorRenderer;
import net.hazen.hazennstuff.item.armor.AzureLib.TheWither.TheWitherArmorRenderer;
import net.hazen.hazennstuff.item.curios.Spellbooks.EnergizedCoreSpellbook.EnergizedCoreSpellbookCurioItemRenderer;
import net.hazen.hazennstuff.item.curios.Spellbooks.EnergizedCoreSpellbook.EnergizedCoreSpellbookCurioRenderer;
import net.hazen.hazennstuff.registries.*;
import net.hazen.hazennstuff.item.weapons.hammer_of_justice.HammerOfJusticeRenderer;
import net.hazen.hazennstuff.item.armor.HnSArmorMaterials;
import net.hazen.hazennstuff.spells.HnSSpellRegistries;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
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
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(HazenNStuff.MOD_ID)
public class HazenNStuff
{
    public static final String MOD_ID = "hazennstuff";
    private static final Logger LOGGER = LogUtils.getLogger();
    public HazenNStuff(IEventBus modEventBus, ModContainer modContainer)
    {
        NeoForge.EVENT_BUS.register(this);

        //Magic Mod Compat
        MalumCompat.init();
        ArsNoveauCompat.init();

        //ISS Addons Compat
        AeromancyAdditionsCompat.init();
        CataclysmSpellbooksCompat.init();
        EndersSpellsAndStuffCompat.init();
        FamiliarsLibCompat.init();
        MFTECompat.init();

        HnSCreativeModeTabs.register(modEventBus);

        HnSItems.register(modEventBus);
        HnSBlocks.register(modEventBus);
        HnSArmorMaterials.register(modEventBus);

        HnSEffects.register(modEventBus);
        HnSParticleRegistry.register(modEventBus);
        HnSSounds.register(modEventBus);
        HnSEntityRegistry.register(modEventBus);

        HnSSpellRegistries.register(modEventBus);
        HnSAttributeRegistry.register(modEventBus);
        HnSSchoolRegistry.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELP!");
    }

    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {


            // Armor Rendering Registry

            //Arbitrium Robes
            AzArmorRendererRegistry.register(ArbitriumRobesArmorRenderer::new,
                    HnSItems.ARBITRIUM_ROBES_HELMET.get(),
                    HnSItems.ARBITRIUM_ROBES_CHESTPLATE.get(),
                    HnSItems.ARBITRIUM_ROBES_LEGGINGS.get(),
                    HnSItems.ARBITRIUM_ROBES_BOOTS.get());

            //Creaking
            AzArmorRendererRegistry.register(CreakingSorcererArmorRenderer::new,
                    HnSItems.CREAKING_HELMET.get(),
                    HnSItems.CREAKING_CHESTPLATE.get(),
                    HnSItems.CREAKING_LEGGINGS.get(),
                    HnSItems.CREAKING_BOOTS.get());

            //Dark Ritual Templar
            AzArmorRendererRegistry.register(DarkRitualTemplarArmorRenderer::new,
                    HnSItems.DARK_RITUAL_TEMPLAR_HELMET.get(),
                    HnSItems.DARK_RITUAL_TEMPLAR_CHESTPLATE.get(),
                    HnSItems.DARK_RITUAL_TEMPLAR_LEGGINGS.get(),
                    HnSItems.DARK_RITUAL_TEMPLAR_BOOTS.get());

            // Ender Dragon
            AzArmorRendererRegistry.register(EnderDragonArmorRenderer::new,
                    HnSItems.ENDER_DRAGON_HELMET.get(),
                    HnSItems.ENDER_DRAGON_CHESTPLATE.get(),
                    HnSItems.ENDER_DRAGON_LEGGINGS.get(),
                    HnSItems.ENDER_DRAGON_BOOTS.get());

            // Fireblossom Helmet
            AzArmorRendererRegistry.register(FireblossomBattlemageHelmetArmorRenderer::new,
                    HnSItems.FIREBLOSSOM_BATTLEMAGE_HELMET.get(),
                    HnSItems.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get(),
                    HnSItems.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get(),
                    HnSItems.FIREBLOSSOM_BATTLEMAGE_BOOTS.get());
            // Fireblossom Crown
            AzArmorRendererRegistry.register(FireblossomBattlemageCrownedArmorRenderer::new,
                    HnSItems.FIREBLOSSOM_BATTLEMAGE_CROWN.get());

            // Seraph
            AzArmorRendererRegistry.register(SeraphArmorRenderer::new,
                    HnSItems.SERAPH_HELMET.get(),
                    HnSItems.SERAPH_CHESTPLATE.get(),
                    HnSItems.SERAPH_LEGGINGS.get(),
                    HnSItems.SERAPH_BOOTS.get());

            // Soul Flame
            AzArmorRendererRegistry.register(SoulFlameArmorRenderer::new,
                    HnSItems.SOUL_FLAME_HELMET.get(),
                    HnSItems.SOUL_FLAME_CHESTPLATE.get(),
                    HnSItems.SOUL_FLAME_LEGGINGS.get(),
                    HnSItems.SOUL_FLAME_BOOTS.get());

            // Supreme Witch
            AzArmorRendererRegistry.register(SupremeWitchArmorRenderer::new,
                    HnSItems.SUPREME_WITCH_HELMET.get(),
                    HnSItems.SUPREME_WITCH_CHESTPLATE.get(),
                    HnSItems.SUPREME_WITCH_LEGGINGS.get(),
                    HnSItems.SUPREME_WITCH_BOOTS.get());

            // SLC!Cat
            AzArmorRendererRegistry.register(SLCCatArmorRenderer::new,
                    HnSItems.SLC_CAT_HELMET.get(),
                    HnSItems.SLC_CAT_CHESTPLATE.get(),
                    HnSItems.SLC_CAT_LEGGINGS.get(),
                    HnSItems.SLC_CAT_BOOTS.get());

            // Infestation
            AzArmorRendererRegistry.register(InfestationArmorRenderer::new,
                    HnSItems.INFESTATION_HELMET.get(),
                    HnSItems.INFESTATION_CHESTPLATE.get(),
                    HnSItems.INFESTATION_LEGGINGS.get(),
                    HnSItems.INFESTATION_BOOTS.get());

            // Blazeborne
            AzArmorRendererRegistry.register(BlazeborneArmorRenderer::new,
                    HnSItems.BLAZEBORNE_HELMET.get(),
                    HnSItems.BLAZEBORNE_CHESTPLATE.get(),
                    HnSItems.BLAZEBORNE_LEGGINGS.get(),
                    HnSItems.BLAZEBORNE_BOOTS.get());

            //
            AzArmorRendererRegistry.register(LemonGodArmorRenderer::new,
                    HnSItems.LEMON_GOD_HELMET.get(),
                    HnSItems.LEMON_GOD_CHESTPLATE.get(),
                    HnSItems.LEMON_GOD_LEGGINGS.get(),
                    HnSItems.LEMON_GOD_BOOTS.get());

            // Ascended Lemon God
            AzArmorRendererRegistry.register(LemonGodArmorRenderer::new,
                    HnSItems.ASCENDED_LEMON_GOD_HELMET.get(),
                    HnSItems.ASCENDED_LEMON_GOD_CHESTPLATE.get(),
                    HnSItems.ASCENDED_LEMON_GOD_LEGGINGS.get(),
                    HnSItems.ASCENDED_LEMON_GOD_BOOTS.get());

            // The Wither
            AzArmorRendererRegistry.register(TheWitherArmorRenderer::new,
                    HnSItems.THE_WITHER_HELMET.get(),
                    HnSItems.THE_WITHER_CHESTPLATE.get(),
                    HnSItems.THE_WITHER_LEGGINGS.get(),
                    HnSItems.THE_WITHER_BOOTS.get());

            // Ascended Arbitrium Robes
            AzArmorRendererRegistry.register(ArbitriumRobesArmorRenderer::new,
                    HnSItems.ASCENDED_ARBITRIUM_ROBES_HELMET.get(),
                    HnSItems.ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get(),
                    HnSItems.ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get(),
                    HnSItems.ASCENDED_ARBITRIUM_ROBES_BOOTS.get());

            // Gabriel Ultrakill
            AzArmorRendererRegistry.register(GabrielArmorRenderer::new,
                    HnSItems.GABRIEL_ULTRAKILL_HELMET.get(),
                    HnSItems.GABRIEL_ULTRAKILL_CHESTPLATE.get(),
                    HnSItems.GABRIEL_ULTRAKILL_LEGGINGS.get(),
                    HnSItems.GABRIEL_ULTRAKILL_BOOTS.get());



            // Item Rendering Registry
            AzItemRendererRegistry.register(HammerOfJusticeRenderer::new, HnSItems.HAMMER_OF_JUSTICE.get());

            //Curios Rendering Registry

            AzArmorRendererRegistry.register(EnergizedCoreSpellbookCurioItemRenderer::new, HnSItems.ENERGIZED_CORE_SPELLBOOK.get());
            CuriosRendererRegistry.register(
                    HnSItems.ENERGIZED_CORE_SPELLBOOK.get(), EnergizedCoreSpellbookCurioRenderer::new
            );

            // Animation Registry
            AzIdentityRegistry.register(

                    //Armor

                    HnSItems.ARBITRIUM_ROBES_HELMET.get(),
                    HnSItems.ARBITRIUM_ROBES_CHESTPLATE.get(),
                    HnSItems.ARBITRIUM_ROBES_LEGGINGS.get(),
                    HnSItems.ARBITRIUM_ROBES_BOOTS.get(),
                    HnSItems.ASCENDED_ARBITRIUM_ROBES_HELMET.get(),
                    HnSItems.ASCENDED_ARBITRIUM_ROBES_CHESTPLATE.get(),
                    HnSItems.ASCENDED_ARBITRIUM_ROBES_LEGGINGS.get(),
                    HnSItems.ASCENDED_ARBITRIUM_ROBES_BOOTS.get(),

                    HnSItems.CREAKING_HELMET.get(),
                    HnSItems.CREAKING_CHESTPLATE.get(),
                    HnSItems.CREAKING_LEGGINGS.get(),
                    HnSItems.CREAKING_BOOTS.get(),

                    HnSItems.DARK_RITUAL_TEMPLAR_HELMET.get(),
                    HnSItems.DARK_RITUAL_TEMPLAR_CHESTPLATE.get(),
                    HnSItems.DARK_RITUAL_TEMPLAR_LEGGINGS.get(),
                    HnSItems.DARK_RITUAL_TEMPLAR_BOOTS.get(),

                    HnSItems.ENDER_DRAGON_HELMET.get(),
                    HnSItems.ENDER_DRAGON_CHESTPLATE.get(),
                    HnSItems.ENDER_DRAGON_LEGGINGS.get(),
                    HnSItems.ENDER_DRAGON_BOOTS.get(),

                    HnSItems.FIREBLOSSOM_BATTLEMAGE_HELMET.get(),
                    HnSItems.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get(),
                    HnSItems.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get(),
                    HnSItems.FIREBLOSSOM_BATTLEMAGE_BOOTS.get(),
                    HnSItems.FIREBLOSSOM_BATTLEMAGE_BOOTS.get(),

                    HnSItems.SERAPH_HELMET.get(),
                    HnSItems.SERAPH_CHESTPLATE.get(),
                    HnSItems.SERAPH_LEGGINGS.get(),
                    HnSItems.SERAPH_BOOTS.get(),

                    HnSItems.SOUL_FLAME_HELMET.get(),
                    HnSItems.SOUL_FLAME_CHESTPLATE.get(),
                    HnSItems.SOUL_FLAME_LEGGINGS.get(),
                    HnSItems.SOUL_FLAME_BOOTS.get(),

                    HnSItems.SUPREME_WITCH_HELMET.get(),
                    HnSItems.SUPREME_WITCH_CHESTPLATE.get(),
                    HnSItems.SUPREME_WITCH_LEGGINGS.get(),
                    HnSItems.SUPREME_WITCH_BOOTS.get(),

                    HnSItems.SLC_CAT_HELMET.get(),
                    HnSItems.SLC_CAT_CHESTPLATE.get(),
                    HnSItems.SLC_CAT_LEGGINGS.get(),
                    HnSItems.SLC_CAT_BOOTS.get(),

                    HnSItems.INFESTATION_HELMET.get(),
                    HnSItems.INFESTATION_CHESTPLATE.get(),
                    HnSItems.INFESTATION_LEGGINGS.get(),
                    HnSItems.INFESTATION_BOOTS.get(),

                    HnSItems.BLAZEBORNE_HELMET.get(),
                    HnSItems.BLAZEBORNE_CHESTPLATE.get(),
                    HnSItems.BLAZEBORNE_LEGGINGS.get(),
                    HnSItems.BLAZEBORNE_BOOTS.get(),

                    HnSItems.LEMON_GOD_HELMET.get(),
                    HnSItems.LEMON_GOD_CHESTPLATE.get(),
                    HnSItems.LEMON_GOD_LEGGINGS.get(),
                    HnSItems.LEMON_GOD_BOOTS.get(),

                    HnSItems.ASCENDED_LEMON_GOD_HELMET.get(),
                    HnSItems.ASCENDED_LEMON_GOD_CHESTPLATE.get(),
                    HnSItems.ASCENDED_LEMON_GOD_LEGGINGS.get(),
                    HnSItems.ASCENDED_LEMON_GOD_BOOTS.get(),

                    HnSItems.THE_WITHER_HELMET.get(),
                    HnSItems.THE_WITHER_CHESTPLATE.get(),
                    HnSItems.THE_WITHER_LEGGINGS.get(),
                    HnSItems.THE_WITHER_BOOTS.get(),

                    HnSItems.GABRIEL_ULTRAKILL_HELMET.get(),
                    HnSItems.GABRIEL_ULTRAKILL_CHESTPLATE.get(),
                    HnSItems.GABRIEL_ULTRAKILL_LEGGINGS.get(),
                    HnSItems.GABRIEL_ULTRAKILL_BOOTS.get(),

                    // Weapons

                    HnSItems.HAMMER_OF_JUSTICE.get(),

                    // Curios

                    HnSItems.ENERGIZED_CORE_SPELLBOOK.get()

            );
        }
    }

    public static ResourceLocation id(@NotNull String path)
    {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, path);
    }
}