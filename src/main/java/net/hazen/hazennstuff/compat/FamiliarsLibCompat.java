package net.hazen.hazennstuff.compat;

import net.alshanex.familiarslib.registry.AttributeRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.fml.ModList;

public class FamiliarsLibCompat {
    public static boolean LOADED;
    public static void init() {
        LOADED = ModList.get().isLoaded("familiarslib");
    }

    public static void addSoundSpellPower(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addSoundSpellPower(attributes, group);
        }
    }

    public static class LoadedOnly {

        public static void addSoundSpellPower(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(AttributeRegistry.SOUND_SPELL_POWER,
                    new AttributeModifier(HazenNStuff.id("add_sound_spell_power"), 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

    }
}
