package net.hazen.hazennstuff.Registries;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class HnSCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HazenNStuff.MOD_ID);

    public static final Supplier<CreativeModeTab> SOTP_ITEMS = CREATIVE_MODE_TABS.register("hazennstuff_items",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(HnSItemRegistry.SKYSCORCHER.get()))
                    .title(Component.translatable("creativetab.hazennstuff.items"))
                    .withTabsBefore(CreativeModeTabs.INGREDIENTS)
                    .withTabsAfter(Identifier.fromNamespaceAndPath(HazenNStuff.MOD_ID, "hazennstuff_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {

                        /*
                        *** Equipment
                         */

                        // Generic
                        output.accept(HnSItemRegistry.STEEL_SWORD);
                        output.accept(HnSItemRegistry.STEEL_SPEAR);
                        output.accept(HnSItemRegistry.STEEL_PICKAXE);
                        output.accept(HnSItemRegistry.STEEL_SHOVEL);
                        output.accept(HnSItemRegistry.STEEL_AXE);
                        output.accept(HnSItemRegistry.STEEL_HOE);

                        // Fire
                        output.accept(HnSItemRegistry.RAVENS_BANE);

                        // Ice
                        output.accept(HnSItemRegistry.ICE_PIKE);

                        // Nature

                        // Lightning
                        output.accept(HnSItemRegistry.SKYSCORCHER);

                        /*
                        *** Armor
                         */

                        // Steel
                        output.accept(HnSItemRegistry.STEEL_HELMET);
                        output.accept(HnSItemRegistry.STEEL_CHESTPLATE);
                        output.accept(HnSItemRegistry.STEEL_LEGGINGS);
                        output.accept(HnSItemRegistry.STEEL_BOOTS);

                        output.accept(HnSItemRegistry.STALWART_HELMET);
                        output.accept(HnSItemRegistry.STALWART_CHESTPLATE);


                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}