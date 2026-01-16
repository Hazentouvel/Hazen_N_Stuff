package net.hazen.hazennstuff.Compat;

import net.acetheeldritchking.discerning_the_eldritch.registries.DTEAttributeRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.fml.ModList;

public class DTECompat {
    public static boolean LOADED;
    public static void init() {
        LOADED = ModList.get().isLoaded("aero_additions");
    }

    public static void addRitualSpellPowerPure(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addRitualSpellPowerPure(attributes, group);
        }
    }

    public static void addRitualSpellPowerParagon(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addRitualSpellPowerParagon(attributes, group);
        }
    }

    public static class LoadedOnly {

        public static void addRitualSpellPowerPure(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(DTEAttributeRegistry.RITUAL_MAGIC_POWER,
                    new AttributeModifier(HazenNStuff.id("add_ritual_spell_power_pure"), 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

        public static void addRitualSpellPowerParagon(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(DTEAttributeRegistry.RITUAL_MAGIC_POWER,
                    new AttributeModifier(HazenNStuff.id("add_ritual_spell_power_paragon"), 0.2f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

    }
}
