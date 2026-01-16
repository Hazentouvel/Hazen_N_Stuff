package net.hazen.hazennstuff.Compat;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.fml.ModList;
import net.warphan.iss_magicfromtheeast.registries.MFTEAttributeRegistries;

public class MFTECompat {
    public static boolean LOADED;
    public static void init() {
        LOADED = ModList.get().isLoaded("iss_magicfromtheeast");
    }

    public static void addSpiritSpellPowerPure(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addSpiritSpellPowerPure(attributes, group);
        }
    }

    public static void addSpiritSpellPower(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addSpiritSpellPowerParagon(attributes, group);
        }
    }

    public static void addDuneSpellPower(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addDuneSpellPowerPure(attributes, group);
        }
    }

    public static void addDuneSpellPowerParagon(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addDuneSpellPowerParagon(attributes, group);
        }
    }

    public static void addSymmetrySpellPower(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addSymmetrySpellPowerPure(attributes, group);
        }
    }

    public static void addSymmetrySpellPowerParagon(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addSymmetrySpellPowerParagon(attributes, group);
        }
    }

    public static class LoadedOnly {

        public static void addSpiritSpellPowerPure(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(MFTEAttributeRegistries.SPIRIT_SPELL_POWER,
                    new AttributeModifier(HazenNStuff.id("add_spirit_spell_power_pure"), 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

        public static void addDuneSpellPowerPure(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(MFTEAttributeRegistries.DUNE_SPELL_POWER,
                    new AttributeModifier(HazenNStuff.id("add_dune_spell_power_pure"), 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

        public static void addSymmetrySpellPowerPure(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(MFTEAttributeRegistries.SYMMETRY_SPELL_POWER,
                    new AttributeModifier(HazenNStuff.id("add_symmetry_spell_power_pure"), 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

        public static void addSpiritSpellPowerParagon(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(MFTEAttributeRegistries.SPIRIT_SPELL_POWER,
                    new AttributeModifier(HazenNStuff.id("add_spirit_spell_power_paragon"), 0.2f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

        public static void addDuneSpellPowerParagon(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(MFTEAttributeRegistries.DUNE_SPELL_POWER,
                    new AttributeModifier(HazenNStuff.id("add_dune_spell_power_paragon"), 0.2f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

        public static void addSymmetrySpellPowerParagon(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(MFTEAttributeRegistries.SYMMETRY_SPELL_POWER,
                    new AttributeModifier(HazenNStuff.id("add_symmetry_spell_power_paragon"), 0.2f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

    }
}
