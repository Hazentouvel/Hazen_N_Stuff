package net.hazen.hazennstuff.Compat;

import net.ender.ess_requiem.registries.GGAttributeRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.fml.ModList;

public class ESSRCompat {
    public static boolean LOADED;
    public static void init() {
        LOADED = ModList.get().isLoaded("ess_requiem");
    }

    public static void addSpellbladeSpellPowerPure(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addSpellbladeSpellPowerPure(attributes, group);
        }
    }

    public static void addSpellbladeSpellPowerParagon(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addSpellbladeSpellPowerParagon(attributes, group);
        }
    }

    public static class LoadedOnly {

        public static void addSpellbladeSpellPowerPure(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(GGAttributeRegistry.BLADE_SPELL_POWER,
                    new AttributeModifier(HazenNStuff.id("add_spellblade_spell_power_pure"), 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

        public static void addSpellbladeSpellPowerParagon(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(GGAttributeRegistry.BLADE_SPELL_POWER,
                    new AttributeModifier(HazenNStuff.id("add_spellblade_spell_power_paragon"), 0.2f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

    }
}
