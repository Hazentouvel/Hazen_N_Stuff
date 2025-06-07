package net.hazen.hazennstuff.registries;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class HnSTags {
    /***
     * Items
     */

    // Luminescent School Focus
    public static final TagKey<Item> LUMINESCENT_FOCUS = ItemTags.create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "luminescent_focus").toString()));
    // Corrupt School Focus
    public static final TagKey<Item> DARK_FOCUS = ItemTags.create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "luminescent_focus").toString()));


    // Armor Items For Idle
    public static final TagKey<Item> ARMORS_FOR_IDLE = ItemTags.create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "armors_for_idle").toString()));
    // Armor Items For Idle
    public static final TagKey<Item> ARMORS_FOR_FLIGHT = ItemTags.create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "armors_for_flight").toString()));


    /***
     * Entities
     */
}