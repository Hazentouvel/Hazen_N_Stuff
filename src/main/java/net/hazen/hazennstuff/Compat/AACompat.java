package net.hazen.hazennstuff.Compat;

import com.snackpirate.aeromancy.spells.AASpells;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.fml.ModList;

public class AACompat {
    public static boolean LOADED;
    public static void init() {
        LOADED = ModList.get().isLoaded("aero_additions");
    }

    public static void addWindSpellPowerPure(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addWindSpellPowerPure(attributes, group);
        }
    }

    public static void addWindSpellPowerParagon (ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addWindSpellPowerParagon(attributes, group);
        }
    }

    public static class LoadedOnly {

        public static void addWindSpellPowerPure(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(AASpells.Attributes.WIND_SPELL_POWER,
                    new AttributeModifier(HazenNStuff.id("add_wind_spell_power_pure"), 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

        public static void addWindSpellPowerParagon(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(AASpells.Attributes.WIND_SPELL_POWER,
                    new AttributeModifier(HazenNStuff.id("add_wind_spell_power_paragon"), 0.2f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

    }
}
