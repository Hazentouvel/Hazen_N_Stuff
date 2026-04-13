package net.hazen.hazennstuff.Compat;

import net.alshanex.familiarslib.registry.AttributeRegistry;
import net.alshanex.tunes_n_tomes.registry.TAttributeRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.fml.ModList;

public class FLCompat {
    public static boolean LOADED;
    public static void init() {
        LOADED = ModList.get().isLoaded("familiarslib");
    }

    public static void addFamiliarDamagePure(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addFamiliarDamagePure(attributes, group);
        }
    }

    public static void addFamiliarDamageParagon(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addFamiliarDamageParagon(attributes, group);
        }
    }

    public static void addFamiliarResistPure(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addFamiliarResistPure(attributes, group);
        }
    }

    public static void addFamiliarResistParagon(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addFamiliarResistParagon(attributes, group);
        }
    }

    public static class LoadedOnly {

        public static void addFamiliarDamagePure(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(AttributeRegistry.FAMILIAR_DAMAGE,
                    new AttributeModifier(HazenNStuff.id("add_familiar_damage_pure"), 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

        public static void addFamiliarDamageParagon(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(AttributeRegistry.FAMILIAR_DAMAGE,
                    new AttributeModifier(HazenNStuff.id("add_familiar_damage_paragon"), 0.2f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

        public static void addFamiliarResistPure(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(AttributeRegistry.FAMILIAR_RESIST,
                    new AttributeModifier(HazenNStuff.id("add_familiar_damage_pure"), 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

        public static void addFamiliarResistParagon(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(AttributeRegistry.FAMILIAR_RESIST,
                    new AttributeModifier(HazenNStuff.id("add_familiar_damage_paragon"), 0.2f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }
    }
}
