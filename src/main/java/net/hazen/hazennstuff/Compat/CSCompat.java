package net.hazen.hazennstuff.Compat;

import net.acetheeldritchking.cataclysm_spellbooks.registries.CSAttributeRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.fml.ModList;

public class CSCompat {
    public static boolean LOADED;
    public static void init() {
        LOADED = ModList.get().isLoaded("cataclysm_spellbooks");
    }

    public static void addAbyssalSpellPowerPure(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addAbyssalSpellPowerPure(attributes, group);
        }
    }

    public static void addAbyssalSpellPowerParagon(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addAbyssalSpellPowerParagon(attributes, group);
        }
    }

    public static class LoadedOnly {

        public static void addAbyssalSpellPowerPure(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(CSAttributeRegistry.ABYSSAL_MAGIC_POWER,
                    new AttributeModifier(HazenNStuff.id("add_abyssal_spell_power"), 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

        public static void addAbyssalSpellPowerParagon(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(CSAttributeRegistry.ABYSSAL_MAGIC_POWER,
                    new AttributeModifier(HazenNStuff.id("add_abyssal_spell_power"), 0.2f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

    }
}