package net.hazen.hazennstuff.Datagen;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;

public interface HnSEnchantmentTags {
    TagKey<Enchantment> SPELLBOOK_EXCLUSIVE = createTag("spellbook_exclusive");
    TagKey<Enchantment> SPELL_ENHANCEMENT = createTag("spell_enhancement");


    private static TagKey<Enchantment> createTag(String name) {
        return TagKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, name)
        );
    }
}
