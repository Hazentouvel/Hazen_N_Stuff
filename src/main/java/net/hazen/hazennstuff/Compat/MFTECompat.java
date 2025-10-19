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

    public static void addSpiritSpellPower(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addSpiritSpellPower(attributes, group);
        }
    }

    public static void addDuneSpellPower(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addDuneSpellPower(attributes, group);
        }
    }

    public static void addSymmetrySpellPower(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addSymmetrySpellPower(attributes, group);
        }
    }

    public static class LoadedOnly {

        public static void addSpiritSpellPower(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(MFTEAttributeRegistries.SPIRIT_SPELL_POWER,
                    new AttributeModifier(HazenNStuff.id("add_spirit_spell_power"), 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

        public static void addDuneSpellPower(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(MFTEAttributeRegistries.DUNE_SPELL_POWER,
                    new AttributeModifier(HazenNStuff.id("add_dune_spell_power"), 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

        public static void addSymmetrySpellPower(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(MFTEAttributeRegistries.SYMMETRY_SPELL_POWER,
                    new AttributeModifier(HazenNStuff.id("add_symmetry_spell_power"), 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

    }
}
