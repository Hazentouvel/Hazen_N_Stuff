package net.hazen.hazennstuff.compat;

import com.snackpirate.aeromancy.spells.AASpells;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.fml.ModList;

public class AeromancyAdditionsCompat {
    public static boolean LOADED;
    public static void init() {
        LOADED = ModList.get().isLoaded("aeromancy_additions");
    }

    public static void addWindSpellPower(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addWindSpellPower(attributes, group);
        }
    }

    public static class LoadedOnly {

        public static void addWindSpellPower(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(AASpells.Attributes.WIND_SPELL_POWER,
                    new AttributeModifier(HazenNStuff.id("add_wind_spell_power"), 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

    }
}
