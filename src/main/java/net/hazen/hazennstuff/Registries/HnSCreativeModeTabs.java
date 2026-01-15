package net.hazen.hazennstuff.Registries;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.ItemRegistries.HnSArmorItemRegistry;
import net.hazen.hazennstuff.Registries.ItemRegistries.HnSMaterialItemRegistry;
import net.hazen.hazennstuff.Registries.ItemRegistries.HnSStaveItemRegistry;
import net.hazen.hazennstuff.Registries.ItemRegistries.HnSWeaponItemRegistry;
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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(HnSMaterialItemRegistry.ZENALITE_INGOT.get()))
                    .title(Component.translatable("creativetab.hazennstuff_materials"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(HnSMaterialItemRegistry.ZENALITE_INGOT.get());
                        pOutput.accept(HnSMaterialItemRegistry.RAW_ZENALITE.get());
                        pOutput.accept(HnSMaterialItemRegistry.STARKISSED_ZENALITE.get());
                        pOutput.accept(HnSMaterialItemRegistry.ELDRITCH_RUNE.get());
                        pOutput.accept(HnSMaterialItemRegistry.CRUDE_METAL.get());
                        pOutput.accept(HnSMaterialItemRegistry.STEEL_INGOT.get());
                        pOutput.accept(HnSMaterialItemRegistry.STEEL_NUGGET.get());


                    })
                    .build()
    );

    public static final RegistryObject<CreativeModeTab> HAZENNSTUFF_ARMOR = CREATIVE_MODE_TABS.register("hazennstuff_armor",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(HnSArmorItemRegistry.CRYOGENIC_RULER_HELMET.get()))
                    .title(Component.translatable("creativetab.hazennstuff_armor"))
                    .displayItems((pParameters, pOutput) -> {


                        /*
                        *** Fire
                         */

                        pOutput.accept(HnSArmorItemRegistry.HAZEL_HELMET.get());
                        pOutput.accept(HnSArmorItemRegistry.HAZEL_CHESTPLATE.get());
                        //pOutput.accept(HnSArmorItemRegistry.BIG_HAZEL_CHESTPLATE.get());
                        pOutput.accept(HnSArmorItemRegistry.HAZEL_LEGGINGS.get());
                        pOutput.accept(HnSArmorItemRegistry.HAZEL_BOOTS.get());

                        pOutput.accept(HnSArmorItemRegistry.BLAZEBORNE_HELMET.get());
                        pOutput.accept(HnSArmorItemRegistry.BLAZEBORNE_CHESTPLATE.get());
                        pOutput.accept(HnSArmorItemRegistry.BLAZEBORNE_LEGGINGS.get());
                        pOutput.accept(HnSArmorItemRegistry.BLAZEBORNE_BOOTS.get());

                        /*
                        *** Ice
                         */

                        pOutput.accept(HnSArmorItemRegistry.CRYOGENIC_RULER_HELMET.get());
                        pOutput.accept(HnSArmorItemRegistry.CRYOGENIC_RULER_CHESTPLATE.get());
                        pOutput.accept(HnSArmorItemRegistry.CRYOGENIC_RULER_LEGGINGS.get());
                        pOutput.accept(HnSArmorItemRegistry.CRYOGENIC_RULER_BOOTS.get());

                        /*
                        *** Nature
                         */

                        pOutput.accept(HnSArmorItemRegistry.CREAKING_SORCERER_HELMET.get());
                        pOutput.accept(HnSArmorItemRegistry.CREAKING_SORCERER_CHESTPLATE.get());
                        pOutput.accept(HnSArmorItemRegistry.CREAKING_SORCERER_LEGGINGS.get());
                        pOutput.accept(HnSArmorItemRegistry.CREAKING_SORCERER_BOOTS.get());

                        /*
                        *** Lightning
                         */

                        pOutput.accept(HnSArmorItemRegistry.THUNDER_PROWLER_HELMET.get());
                        pOutput.accept(HnSArmorItemRegistry.THUNDER_PROWLER_CHESTPLATE.get());
                        pOutput.accept(HnSArmorItemRegistry.THUNDER_PROWLER_LEGGINGS.get());
                        pOutput.accept(HnSArmorItemRegistry.THUNDER_PROWLER_BOOTS.get());

                        /*
                        *** Ender
                         */

                        pOutput.accept(HnSArmorItemRegistry.ENDER_DRAGON_HELMET.get());
                        pOutput.accept(HnSArmorItemRegistry.ENDER_DRAGON_CHESTPLATE.get());
                        pOutput.accept(HnSArmorItemRegistry.ENDER_DRAGON_LEGGINGS.get());
                        pOutput.accept(HnSArmorItemRegistry.ENDER_DRAGON_BOOTS.get());

                        /*
                        *** Blood
                         */

                        pOutput.accept(HnSArmorItemRegistry.FLESH_MASS_HELMET.get());
                        pOutput.accept(HnSArmorItemRegistry.FLESH_MASS_CHESTPLATE.get());
                        pOutput.accept(HnSArmorItemRegistry.FLESH_MASS_LEGGINGS.get());
                        pOutput.accept(HnSArmorItemRegistry.FLESH_MASS_BOOTS.get());

                        /*
                        *** Evocation
                         */

                        pOutput.accept(HnSArmorItemRegistry.ALCHEMIST_SUPREME_HELMET.get());
                        pOutput.accept(HnSArmorItemRegistry.ALCHEMIST_SUPREME_CHESTPLATE.get());
                        pOutput.accept(HnSArmorItemRegistry.ALCHEMIST_SUPREME_LEGGINGS.get());
                        pOutput.accept(HnSArmorItemRegistry.ALCHEMIST_SUPREME_BOOTS.get());

                        /*
                        *** Holy
                         */

                        pOutput.accept(HnSArmorItemRegistry.SERAPH_HELMET.get());
                        pOutput.accept(HnSArmorItemRegistry.SERAPH_CHESTPLATE.get());
                        pOutput.accept(HnSArmorItemRegistry.SERAPH_LEGGINGS.get());
                        pOutput.accept(HnSArmorItemRegistry.SERAPH_BOOTS.get());

                        /*
                        *** Eldritch
                         */

                        pOutput.accept(HnSArmorItemRegistry.INFESTATION_HELMET.get());
                        pOutput.accept(HnSArmorItemRegistry.INFESTATION_CHESTPLATE.get());
                        pOutput.accept(HnSArmorItemRegistry.INFESTATION_LEGGINGS.get());
                        pOutput.accept(HnSArmorItemRegistry.INFESTATION_BOOTS.get());

                        /*
                        *** Dedicated Armor Sets
                         */

                        pOutput.accept(HnSArmorItemRegistry.FIREBLOSSOM_BATTLEMAGE_CROWN.get());
                        pOutput.accept(HnSArmorItemRegistry.FIREBLOSSOM_BATTLEMAGE_HELMET.get());
                        pOutput.accept(HnSArmorItemRegistry.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get());
                        pOutput.accept(HnSArmorItemRegistry.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get());
                        pOutput.accept(HnSArmorItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get());


                    })
                    .build()
    );

    public static final RegistryObject<CreativeModeTab> HAZENNSTUFF_EQUIPMENT = CREATIVE_MODE_TABS.register("hazennstuff_equipment",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(HnSWeaponItemRegistry.FIREBLOSSOM_RAPIER.get()))
                    .title(Component.translatable("creativetab.hazennstuff_equipment"))
                    .displayItems((pParameters, pOutput) -> {

                        /*
                        *** Weapons
                         */

                        //Fire
                        pOutput.accept(HnSWeaponItemRegistry.FIREBLOSSOM_RAPIER.get());

                        //Ice

                        //Nature

                        //Lightning

                        //Blood

                        //Ender

                        //Evocation

                        //Holy

                        //Eldritch

                        //Misc


                        /*
                        *** Staves
                         */

                        pOutput.accept(HnSStaveItemRegistry.ENDERCONIC_SCEPTER.get());
                        pOutput.accept(HnSStaveItemRegistry.GRIMOIRE_STAFF.get());
                        pOutput.accept(HnSStaveItemRegistry.DIVINE_SCEPTER.get());
                        pOutput.accept(HnSStaveItemRegistry.BLOSSOM_OF_THE_ENCHANTRESS.get());
                        pOutput.accept(HnSStaveItemRegistry.INSANIA_AETERNUM.get());

                    })
                    .build()
    );


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}