package net.hazen.hazennstuff.Datagen.Tags;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.HnSItemRegistry;
import net.hazen.hazentouvelib.Registries.HLItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class HnSItemTagsProvider extends ItemTagsProvider {
    public HnSItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, HazenNStuff.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

        tag(HnSTags.Items.STEEL_REPAIR)
                .add(HLItemRegistry.STEEL_INGOT.get())
        ;

        tag(ItemTags.SPEARS)
                .add(HnSItemRegistry.STEEL_SPEAR.get())
                .add(HnSItemRegistry.ICE_PIKE.get())
        ;

        tag(ItemTags.SWORDS)
                .add(HnSItemRegistry.STEEL_SWORD.get())
        ;

        tag(ItemTags.PICKAXES)
                .add(HnSItemRegistry.STEEL_PICKAXE.get())
        ;

        tag(ItemTags.AXES)
                .add(HnSItemRegistry.STEEL_AXE.get())
                .add(HnSItemRegistry.SKYSCORCHER.get())
                .add(HnSItemRegistry.RAVENS_BANE.get())
        ;

        tag(ItemTags.HOES)
                .add(HnSItemRegistry.STEEL_HOE.get())
        ;

        tag(ItemTags.SHOVELS)
                .add(HnSItemRegistry.STEEL_SHOVEL.get())
        ;

        tag(ItemTags.HEAD_ARMOR)
                .add(HnSItemRegistry.STEEL_HELMET.get())
                .add(HnSItemRegistry.STALWART_HELMET.get())
        ;

        tag(ItemTags.CHEST_ARMOR)
                .add(HnSItemRegistry.STEEL_CHESTPLATE.get())
                .add(HnSItemRegistry.STALWART_CHESTPLATE.get())
        ;

        tag(ItemTags.LEG_ARMOR)
                .add(HnSItemRegistry.STEEL_LEGGINGS.get())
        ;

        tag(ItemTags.FOOT_ARMOR)
                .add(HnSItemRegistry.STEEL_BOOTS.get())
        ;

    }
}