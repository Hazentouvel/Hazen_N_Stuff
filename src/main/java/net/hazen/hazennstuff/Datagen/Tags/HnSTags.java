package net.hazen.hazennstuff.Datagen.Tags;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class HnSTags {

    public static class Blocks {

        // Steel (Depreciated)
        public static final TagKey<Block> NEEDS_STEEL_TOOL = createTag("needs_steel_tool");
        public static final TagKey<Block> INCORRECT_FOR_STEEL_TOOL = createTag("incorrect_for_steel_tool");

        // Zenalite
        public static final TagKey<Block> NEEDS_ZENALITE_TOOL = createTag("needs_zenalite_tool");
        public static final TagKey<Block> INCORRECT_FOR_ZENALITE_TOOL = createTag("incorrect_for_zenalite_tool");


        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(Identifier.fromNamespaceAndPath(HazenNStuff.MOD_ID, name));
        }
    }


    public static class Items {


        public static final TagKey<Item> STEEL_REPAIR = createTag("steel_repair");
        public static final TagKey<Item> ZENALITE_REPAIR = createTag("zenalite_repair");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath(HazenNStuff.MOD_ID, name));
        }


    }
}