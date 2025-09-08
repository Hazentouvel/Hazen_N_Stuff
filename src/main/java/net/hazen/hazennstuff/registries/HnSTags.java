package net.hazen.hazennstuff.registries;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class HnSTags {

    /***
     * Items
     */

    // Luminescent School Focus
    public static final TagKey<Item> RADIANCE_FOCUS = ItemTags
            .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "radiance_focus").toString()));
    // Corrupt School Focus
    public static final TagKey<Item> SHADOW_FOCUS = ItemTags
            .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "shadow_focus").toString()));


    // Ores
    public static final TagKey<Item> ZENALITE = ItemTags
            .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "ores/zenalite").toString()));



    public static class Blocks {
        public static final TagKey<Block> NEEDS_MITRHIL_TOOL = BlockTags
                .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "needs_mithril_tool").toString()));

        public static final TagKey<Block> INCORRECT_FOR_MITHRIL_TOOl = BlockTags
                .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "incorrect_for_mithril_tool").toString()));


        private static TagKey<Block> createTag (String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, name));
        }

        public static class Items {

            private static TagKey<Item> createTag (String name) {
                return ItemTags.create(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, name));
            }
        }
    }
}