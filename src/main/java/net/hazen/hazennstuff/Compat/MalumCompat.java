package net.hazen.hazennstuff.Compat;

import com.sammy.malum.registry.common.MalumAttributes;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.fml.ModList;
import team.lodestar.lodestone.registry.common.LodestoneAttributes;

public class MalumCompat {
    public static boolean LOADED;
    public static void init() {
        LOADED = ModList.get().isLoaded("malum");
    }

    public static void addArcaneResonance(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addArcaneResonance(attributes, group);
        }
    }

    public static void addScytheProfeciency(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addScytheProfeciency(attributes, group);
        }
    }

    public static void addSoulWardCapacity(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addSoulWardCapacity(attributes, group);
        }
    }

    public static void addSoulWardRecoveryRate(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addSoulWardRecoveryRate(attributes, group);
        }
    }

    public static void addMagicProfeciency(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addMagicProfeciency(attributes, group);
        }
    }

    public static void addMagicResistance(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addMagicResistance(attributes, group);
        }
    }

    public static class LoadedOnly {

        public static void addArcaneResonance(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(MalumAttributes.ARCANE_RESONANCE,
                    new AttributeModifier(HazenNStuff.id("add_arcane_resonance"), 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

        public static void addScytheProfeciency(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(MalumAttributes.SCYTHE_PROFICIENCY,
                    new AttributeModifier(HazenNStuff.id("add_scythe_profeciency"), 0.1f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

        public static void addSoulWardCapacity(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(MalumAttributes.SOUL_WARD_CAPACITY,
                    new AttributeModifier(HazenNStuff.id("add_soul_ward_capacity"), 4f, AttributeModifier.Operation.ADD_VALUE),
                    group);
        }

        public static void addSoulWardRecoveryRate(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(MalumAttributes.SOUL_WARD_RECOVERY_RATE,
                    new AttributeModifier(HazenNStuff.id("add_soul_ward_recovery_rate"), 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

        public static void addMagicProfeciency(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(LodestoneAttributes.MAGIC_PROFICIENCY,
                    new AttributeModifier(HazenNStuff.id("add_soul_ward_recovery_rate"), 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }

        public static void addMagicResistance(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(LodestoneAttributes.MAGIC_RESISTANCE,
                    new AttributeModifier(HazenNStuff.id("add_soul_ward_recovery_rate"), 0.1f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }
    }
}