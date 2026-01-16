package net.hazen.hazennstuff;

import com.mojang.logging.LogUtils;
import io.redspace.ironsspellbooks.item.SpellBook;
import io.redspace.ironsspellbooks.render.SpellBookCurioRenderer;
import mod.azure.azurelib.common.animation.cache.AzIdentityRegistry;
import mod.azure.azurelib.common.render.armor.AzArmorRendererRegistry;
import mod.azure.azurelib.common.render.item.AzItemRendererRegistry;
import net.acetheeldritchking.aces_spell_utils.entity.render.items.SheathCurioRenderer;
import net.acetheeldritchking.aces_spell_utils.items.curios.SheathCurioItem;
import net.hazen.hazennstuff.Item.Block.HnSBlockEntities;
import net.hazen.hazennstuff.Item.Block.HnSBlocks;
import net.hazen.hazennstuff.Compat.*;
import net.hazen.hazennstuff.Item.Armor.AzureLib.ArbitriumRobes.ArbitriumRobesArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.AzureLib.Blazeborne.BlazeborneArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.AzureLib.CreakingSorcerer.CreakingSorcererArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.AzureLib.DarkRitualTemplar.DarkRitualTemplarArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.AzureLib.EnderDragon.EnderDragonArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.AzureLib.FireblossomBattlemage.FireblossomBattlemageCrownedArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.AzureLib.FireblossomBattlemage.FireblossomBattlemageHelmetArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.AzureLib.GabrielULTRAKILL.GabrielArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.AzureLib.Infestation.InfestationArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.AzureLib.LemonGod.LemonGodArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.AzureLib.SLCCat.SLCCatArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.AzureLib.Seraph.SeraphArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.AzureLib.SoulFlame.SoulFlameArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.AzureLib.SupremeWitch.SupremeWitchArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.AzureLib.TheWither.TheWitherArmorRenderer;
import net.hazen.hazennstuff.Item.HnSUtilities.HnSArmorMaterials;
import net.hazen.hazennstuff.Item.Curios.Sheaths.GalvanizedSheath.GalvanizedCurioRenderer;
import net.hazen.hazennstuff.Item.Curios.Sheaths.GalvanizedSheath.GalvanizedSheathItemRenderer;
import net.hazen.hazennstuff.Item.Curios.Sheaths.ScrollSheath.ScrollCurioRenderer;
import net.hazen.hazennstuff.Item.Curios.Sheaths.ScrollSheath.ScrollSheathItemRenderer;
import net.hazen.hazennstuff.Item.Curios.Spellbooks.EnergizedCoreSpellbook.EnergizedCoreSpellbookCurioItemRenderer;
import net.hazen.hazennstuff.Item.Curios.Spellbooks.EnergizedCoreSpellbook.EnergizedCoreSpellbookCurioRenderer;
import net.hazen.hazennstuff.Item.Curios.Wings.ArbitriumWings.ArbitriumWingsCurioItemRenderer;
import net.hazen.hazennstuff.Item.Curios.Wings.ArbitriumWings.ArbitriumWingsCurioRenderer;
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
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
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
        FLCompat.init();
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

        modContainer.registerConfig(ModConfig.Type.COMMON, HnSConfig.SPEC);
    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
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
            AzArmorRendererRegistry.register(FireblossomBattlemageHelmetArmorRenderer::new,
                    HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_HELMET.get(),
                    HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get(),
                    HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get(),
                    HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get());
            // Fireblossom Crown
            AzArmorRendererRegistry.register(FireblossomBattlemageCrownedArmorRenderer::new,
                    HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CROWN.get());

            // Seraph
            AzArmorRendererRegistry.register(SeraphArmorRenderer::new,
                    HnSItemRegistry.SERAPH_HELMET.get(),
                    HnSItemRegistry.SERAPH_CHESTPLATE.get(),
                    HnSItemRegistry.SERAPH_LEGGINGS.get(),
                    HnSItemRegistry.SERAPH_BOOTS.get());

            // Soul Flame
            AzArmorRendererRegistry.register(SoulFlameArmorRenderer::new,
                    HnSItemRegistry.SOUL_FLAME_HELMET.get(),
                    HnSItemRegistry.SOUL_FLAME_CHESTPLATE.get(),
                    HnSItemRegistry.SOUL_FLAME_LEGGINGS.get(),
                    HnSItemRegistry.SOUL_FLAME_BOOTS.get());

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

            //Curios Rendering Registry

            /*
            *** Spellbooks
             */

            //Energized Core Spellbook
            AzArmorRendererRegistry.register(EnergizedCoreSpellbookCurioItemRenderer::new, HnSItemRegistry.ENERGIZED_CORE_SPELLBOOK.get());
            CuriosRendererRegistry.register(
                    HnSItemRegistry.ENERGIZED_CORE_SPELLBOOK.get(), EnergizedCoreSpellbookCurioRenderer::new
            );

            /*
            *** Sheaths
             */

            // Galvanized Sheath
            AzArmorRendererRegistry.register(GalvanizedSheathItemRenderer::new, HnSItemRegistry.GALVANIZED_SHEATH.get());
            CuriosRendererRegistry.register(
                    HnSItemRegistry.GALVANIZED_SHEATH.get(), GalvanizedCurioRenderer::new
            );

            // Scroll Sheath
            AzArmorRendererRegistry.register(ScrollSheathItemRenderer::new, HnSItemRegistry.SCROLL_SHEATH.get());
            CuriosRendererRegistry.register(
                    HnSItemRegistry.SCROLL_SHEATH.get(), ScrollCurioRenderer::new
            );

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

                    HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_HELMET.get(),
                    HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get(),
                    HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get(),
                    HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get(),
                    HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get(),

                    HnSItemRegistry.SERAPH_HELMET.get(),
                    HnSItemRegistry.SERAPH_CHESTPLATE.get(),
                    HnSItemRegistry.SERAPH_LEGGINGS.get(),
                    HnSItemRegistry.SERAPH_BOOTS.get(),

                    HnSItemRegistry.SOUL_FLAME_HELMET.get(),
                    HnSItemRegistry.SOUL_FLAME_CHESTPLATE.get(),
                    HnSItemRegistry.SOUL_FLAME_LEGGINGS.get(),
                    HnSItemRegistry.SOUL_FLAME_BOOTS.get(),

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

                    // Weapons

                    HnSItemRegistry.HAMMER_OF_JUSTICE.get(),
                    HnSItemRegistry.VOLCANO.get(),
                    HnSItemRegistry.TERRAPRISMA.get(),

                    // Staves
                    HnSItemRegistry.SOULCALLING_SCEPTER.get(),

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