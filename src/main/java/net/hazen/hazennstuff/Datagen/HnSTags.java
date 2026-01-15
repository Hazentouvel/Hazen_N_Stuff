package net.hazen.hazennstuff.Datagen;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class HnSTags {
    public static class Items {

        public static final TagKey<Item> ELDRITCH_RUNE = tag("eldritch_rune");
        public static final TagKey<Item> INGOTS_STEEL = forgeTag("ingots/steel");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(HazenNStuff.MOD_ID, name));
        }
    }


    private static TagKey<Item> forgeTag(String name) {
        return ItemTags.create(new ResourceLocation("forge", name));
    }


    public static class Blocks {


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(HazenNStuff.MOD_ID, name));
        }
    }
}