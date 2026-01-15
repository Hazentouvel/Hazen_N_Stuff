package net.hazen.hazennstuff.Compat;

import net.ender.endersequipment.registries.EEAttributeRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.fml.ModList;

public class EndersSpellsAndStuffCompat {
    public static boolean LOADED;
    public static void init() {
        LOADED = ModList.get().isLoaded("endersequipment");
    }

    public static void addSpellbladeSpellPower(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addSpellbladeSpellPower(attributes, group);
        }
    }

    public static class LoadedOnly {

        public static void addSpellbladeSpellPower(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(EEAttributeRegistry.BLADE_SPELL_POWER,
                    new AttributeModifier(HazenNStuff.id("add_spellblade_spell_power"), 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

    }
}
