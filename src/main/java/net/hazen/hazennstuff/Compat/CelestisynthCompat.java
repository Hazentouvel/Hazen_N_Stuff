package net.hazen.hazennstuff.Compat;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.fml.ModList;
import org.thecelestialworkshop.celestisynth.common.registry.CSAttributes;

public class CelestisynthCompat extends ArmorCompat {
    public static boolean LOADED;
    public static void init() {
        LOADED = ModList.get().isLoaded("celestisynth");
    }

    public static void addCelestialDamage(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addCelestialDamage(attributes, group);
        }
    }

    public static void addCelestialDamageParagon(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addCelestialDamageParagon(attributes, group);
        }
    }


    public static void addCelestialRes(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addCelestialRes(attributes, group);
        }
    }

    public static void addCelestialResParagon(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addCelestialResParagon(attributes, group);
        }
    }

    public static class LoadedOnly {

        public static void addCelestialDamage(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            String armor = getArmorName(group);
            if (armor == null) {
                return;
            }

            attributes.add(CSAttributes.CELESTIAL_DAMAGE,
                    new AttributeModifier(HazenNStuff.id("add_celestial_damage" + armor),
                            0.05f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                    ), group);
        }

        public static void addCelestialRes(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            String armor = getArmorName(group);
            if (armor == null) {
                return;
            }

            attributes.add(CSAttributes.CELESTIAL_DAMAGE_REDUCTION,
                    new AttributeModifier(HazenNStuff.id("add_celestial_damage_reduction" + armor),
                            0.05f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                    ), group);
        }

        public static void addCelestialDamageParagon(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            String armor = getArmorName(group);
            if (armor == null) {
                return;
            }

            attributes.add(CSAttributes.CELESTIAL_DAMAGE,
                    new AttributeModifier(HazenNStuff.id("add_celestial_damage_paragon" + armor),
                            0.15f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                    ), group);
        }

        public static void addCelestialResParagon(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            String armor = getArmorName(group);
            if (armor == null) {
                return;
            }

            attributes.add(CSAttributes.CELESTIAL_DAMAGE_REDUCTION,
                    new AttributeModifier(HazenNStuff.id("add_celestial_damage_reduction_paragon" + armor),
                            0.15f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                    ), group);
        }



    }
}