package net.hazen.hazennstuff.Registries;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class HnSCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HazenNStuff.MOD_ID);

    public static final RegistryObject<CreativeModeTab> HAZENNSTUFF_MATERIALS = CREATIVE_MODE_TABS.register("hazennstuff_materials",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(HnSItemRegistry.ZENALITE_INGOT.get()))
                    .title(Component.translatable("creativetab.hazennstuff_materials"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(HnSItemRegistry.ZENALITE_INGOT.get());
                        pOutput.accept(HnSItemRegistry.RAW_ZENALITE.get());
                        pOutput.accept(HnSItemRegistry.STARKISSED_ZENALITE.get());
                        pOutput.accept(HnSItemRegistry.ELDRITCH_RUNE.get());
                        pOutput.accept(HnSItemRegistry.DIVINE_MOLD.get());
                        pOutput.accept(HnSItemRegistry.CRUDE_METAL.get());
                        pOutput.accept(HnSItemRegistry.STEEL_INGOT.get());
                        pOutput.accept(HnSItemRegistry.STEEL_NUGGET.get());
                        pOutput.accept(HnSItemRegistry.PYRIUM_NUGGET.get());


                    })
                    .build()
    );

    public static final RegistryObject<CreativeModeTab> HAZENNSTUFF_ARMOR = CREATIVE_MODE_TABS.register("hazennstuff_armor",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(HnSItemRegistry.CRYOGENIC_RULER_HELMET.get()))
                    .title(Component.translatable("creativetab.hazennstuff_armor"))
                    .displayItems((pParameters, pOutput) -> {


                        /*
                        *** Fire
                         */

                        pOutput.accept(HnSItemRegistry.HAZEL_HELMET.get());
                        pOutput.accept(HnSItemRegistry.HAZEL_CHESTPLATE.get());
                        //pOutput.accept(HnSItemRegistry.BIG_HAZEL_CHESTPLATE.get());
                        pOutput.accept(HnSItemRegistry.HAZEL_LEGGINGS.get());
                        pOutput.accept(HnSItemRegistry.HAZEL_BOOTS.get());

                        pOutput.accept(HnSItemRegistry.BLAZEBORNE_HELMET.get());
                        pOutput.accept(HnSItemRegistry.BLAZEBORNE_CHESTPLATE.get());
                        pOutput.accept(HnSItemRegistry.BLAZEBORNE_LEGGINGS.get());
                        pOutput.accept(HnSItemRegistry.BLAZEBORNE_BOOTS.get());

                        /*
                        *** Ice
                         */

                        pOutput.accept(HnSItemRegistry.CRYOGENIC_RULER_HELMET.get());
                        pOutput.accept(HnSItemRegistry.CRYOGENIC_RULER_CHESTPLATE.get());
                        pOutput.accept(HnSItemRegistry.CRYOGENIC_RULER_LEGGINGS.get());
                        pOutput.accept(HnSItemRegistry.CRYOGENIC_RULER_BOOTS.get());

                        /*
                        *** Nature
                         */

                        pOutput.accept(HnSItemRegistry.CREAKING_SORCERER_HELMET.get());
                        pOutput.accept(HnSItemRegistry.CREAKING_SORCERER_CHESTPLATE.get());
                        pOutput.accept(HnSItemRegistry.CREAKING_SORCERER_LEGGINGS.get());
                        pOutput.accept(HnSItemRegistry.CREAKING_SORCERER_BOOTS.get());

                        /*
                        *** Lightning
                         */

                        pOutput.accept(HnSItemRegistry.THUNDER_PROWLER_HELMET.get());
                        pOutput.accept(HnSItemRegistry.THUNDER_PROWLER_CHESTPLATE.get());
                        pOutput.accept(HnSItemRegistry.THUNDER_PROWLER_LEGGINGS.get());
                        pOutput.accept(HnSItemRegistry.THUNDER_PROWLER_BOOTS.get());

                        /*
                        *** Ender
                         */

                        pOutput.accept(HnSItemRegistry.ENDER_DRAGON_HELMET.get());
                        pOutput.accept(HnSItemRegistry.ENDER_DRAGON_CHESTPLATE.get());
                        pOutput.accept(HnSItemRegistry.ENDER_DRAGON_LEGGINGS.get());
                        pOutput.accept(HnSItemRegistry.ENDER_DRAGON_BOOTS.get());

                        /*
                        *** Blood
                         */

                        pOutput.accept(HnSItemRegistry.FLESH_MASS_HELMET.get());
                        pOutput.accept(HnSItemRegistry.FLESH_MASS_CHESTPLATE.get());
                        pOutput.accept(HnSItemRegistry.FLESH_MASS_LEGGINGS.get());
                        pOutput.accept(HnSItemRegistry.FLESH_MASS_BOOTS.get());

                        /*
                        *** Evocation
                         */

                        pOutput.accept(HnSItemRegistry.ALCHEMIST_SUPREME_HELMET.get());
                        pOutput.accept(HnSItemRegistry.ALCHEMIST_SUPREME_CHESTPLATE.get());
                        pOutput.accept(HnSItemRegistry.ALCHEMIST_SUPREME_LEGGINGS.get());
                        pOutput.accept(HnSItemRegistry.ALCHEMIST_SUPREME_BOOTS.get());

                        /*
                        *** Holy
                         */

                        pOutput.accept(HnSItemRegistry.SERAPH_HELMET.get());
                        pOutput.accept(HnSItemRegistry.SERAPH_CHESTPLATE.get());
                        pOutput.accept(HnSItemRegistry.SERAPH_LEGGINGS.get());
                        pOutput.accept(HnSItemRegistry.SERAPH_BOOTS.get());

                        /*
                        *** Eldritch
                         */

                        pOutput.accept(HnSItemRegistry.INFESTATION_HELMET.get());
                        pOutput.accept(HnSItemRegistry.INFESTATION_CHESTPLATE.get());
                        pOutput.accept(HnSItemRegistry.INFESTATION_LEGGINGS.get());
                        pOutput.accept(HnSItemRegistry.INFESTATION_BOOTS.get());

                        /*
                        *** Misc
                         */

                        pOutput.accept(HnSItemRegistry.PYRIUM_HELMET.get());
                        pOutput.accept(HnSItemRegistry.PYRIUM_CHESTPLATE.get());
                        pOutput.accept(HnSItemRegistry.PYRIUM_LEGGINGS.get());
                        pOutput.accept(HnSItemRegistry.PYRIUM_BOOTS.get());

                        pOutput.accept(HnSItemRegistry.PYRIUM_BATTLEMAGE_HELMET.get());
                        pOutput.accept(HnSItemRegistry.PYRIUM_BATTLEMAGE_CHESTPLATE.get());
                        pOutput.accept(HnSItemRegistry.PYRIUM_BATTLEMAGE_LEGGINGS.get());
                        pOutput.accept(HnSItemRegistry.PYRIUM_BATTLEMAGE_BOOTS.get());

                        pOutput.accept(HnSItemRegistry.MITHRIL_BATTLEMAGE_HELMET.get());
                        pOutput.accept(HnSItemRegistry.MITHRIL_BATTLEMAGE_CHESTPLATE.get());
                        pOutput.accept(HnSItemRegistry.MITHRIL_BATTLEMAGE_LEGGINGS.get());
                        pOutput.accept(HnSItemRegistry.MITHRIL_BATTLEMAGE_BOOTS.get());

                        pOutput.accept(HnSItemRegistry.LEGIONNAIRE_RULER_HELMET.get());
                        pOutput.accept(HnSItemRegistry.LEGIONNAIRE_RULER_CHESTPLATE.get());
                        pOutput.accept(HnSItemRegistry.LEGIONNAIRE_RULER_LEGGINGS.get());
                        pOutput.accept(HnSItemRegistry.LEGIONNAIRE_RULER_BOOTS.get());

                        pOutput.accept(HnSItemRegistry.LEGIONNAIRE_COMMANDER_HELMET.get());
                        pOutput.accept(HnSItemRegistry.LEGIONNAIRE_COMMANDER_CHESTPLATE.get());
                        pOutput.accept(HnSItemRegistry.LEGIONNAIRE_COMMANDER_LEGGINGS.get());
                        pOutput.accept(HnSItemRegistry.LEGIONNAIRE_COMMANDER_BOOTS.get());

                        /*
                        *** Dedicated Armor Sets
                         */

                        pOutput.accept(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CROWN.get());
                        pOutput.accept(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_HELMET.get());
                        pOutput.accept(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get());
                        pOutput.accept(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get());
                        pOutput.accept(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get());

                        pOutput.accept(HnSItemRegistry.ATLAS_HELMET.get());
                        pOutput.accept(HnSItemRegistry.ATLAS_CHESTPLATE.get());
                        pOutput.accept(HnSItemRegistry.ATLAS_LEGGINGS.get());
                        pOutput.accept(HnSItemRegistry.ATLAS_BOOTS.get());


                    })
                    .build()
    );

    public static final RegistryObject<CreativeModeTab> HAZENNSTUFF_EQUIPMENT = CREATIVE_MODE_TABS.register("hazennstuff_equipment",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(HnSItemRegistry.FIREBLOSSOM_RAPIER.get()))
                    .title(Component.translatable("creativetab.hazennstuff_equipment"))
                    .displayItems((pParameters, pOutput) -> {

                        /*
                        *** Weapons
                         */

                        //Fire
                        pOutput.accept(HnSItemRegistry.FIREBLOSSOM_RAPIER.get());
                        pOutput.accept(HnSItemRegistry.DRACONIC_SPLITTER.get());
                        pOutput.accept(HnSItemRegistry.RAVENS_BANE.get());

                        //Ice
                        pOutput.accept(HnSItemRegistry.ICE_PIKE.get());

                        //Nature
                        pOutput.accept(HnSItemRegistry.O_FORTUNA.get());

                        //Lightning
                        pOutput.accept(HnSItemRegistry.IONIC_SPLITTER.get());

                        //Blood
                        pOutput.accept(HnSItemRegistry.DEVASTATOR.get());

                        //Ender
                        pOutput.accept(HnSItemRegistry.UMBRANOVA.get());

                        //Evocation
                        pOutput.accept(HnSItemRegistry.PROVOCATION.get());

                        //Holy
                        pOutput.accept(HnSItemRegistry.EXCALIBUR.get());

                        //Eldritch
                        pOutput.accept(HnSItemRegistry.THE_DEVOURER.get());

                        //Misc
                        pOutput.accept(HnSItemRegistry.LEGIONNAIRE_WARLOCK_AXE.get());


                        /*
                        *** Staves
                         */

                        pOutput.accept(HnSItemRegistry.ENDERCONIC_SCEPTER.get());
                        pOutput.accept(HnSItemRegistry.GRIMOIRE_STAFF.get());
                        pOutput.accept(HnSItemRegistry.DIVINE_SCEPTER.get());
                        pOutput.accept(HnSItemRegistry.BLOSSOM_OF_THE_ENCHANTRESS.get());
                        pOutput.accept(HnSItemRegistry.INSANIA_AETERNUS.get());

                    })
                    .build()
    );


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}