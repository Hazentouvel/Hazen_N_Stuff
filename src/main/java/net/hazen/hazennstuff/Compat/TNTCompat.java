package net.hazen.hazennstuff.Compat;

import net.alshanex.tunes_n_tomes.registry.TAttributeRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.fml.ModList;

public class TNTCompat {
    public static boolean LOADED;
    public static void init() {
        LOADED = ModList.get().isLoaded("tunes_n_tomes");
    }

    public static void addMelodySpellPowerSchool(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addMelodySpellPowerSchool(attributes, group);
        }
    }

    public static void addMelodySpellPowerPure(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addMelodySpellPowerPure(attributes, group);
        }
    }

    public static void addMelodySpellPowerParagon(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addMelodySpellPowerParagon(attributes, group);
        }
    }

    public static class LoadedOnly {

        public static void addMelodySpellPowerSchool(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(TAttributeRegistry.MELODY_SPELL_POWER,
                    new AttributeModifier(HazenNStuff.id("add_melody_spell_power_school"), 0.1f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

        public static void addMelodySpellPowerPure(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(TAttributeRegistry.MELODY_SPELL_POWER,
                    new AttributeModifier(HazenNStuff.id("add_melody_spell_power_pure"), 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

        public static void addMelodySpellPowerParagon(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(TAttributeRegistry.MELODY_SPELL_POWER,
                    new AttributeModifier(HazenNStuff.id("add_melody_spell_power_paragon"), 0.2f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }
    }
}
