package net.hazen.hazennstuff.Compat;

import com.Polarice3.Goety.init.ModAttributes;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.fml.ModList;

public class GoetyCompat extends ArmorCompat {
    public static boolean LOADED;
    public static void init() {
        LOADED = ModList.get().isLoaded("goety");
    }

    public static void addSpellPotency(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addSpellPotency(attributes, group);
        }
    }

    public static void addSpellDuration(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addSpellDuration(attributes, group);
        }
    }

    public static void addSpellBurning(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addSpellBurning(attributes, group);
        }
    }

    public static void addSpellRange(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addSpellRange(attributes, group);
        }
    }

    public static void addSpellVelocity(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addSpellVelocity(attributes, group);
        }
    }

    public static void addCastingSpeed(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addCastingSpeed(attributes, group);
        }
    }

    public static void addSoulDiscount(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addSoulDiscount(attributes, group);
        }
    }

    public static void addCooldownDiscount(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addCooldownDiscount(attributes, group);
        }
    }

    public static void addAbyssPotency(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addAbyssPotency(attributes, group);
        }
    }

    public static void addFrostPotency(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addFrostPotency(attributes, group);
        }
    }

    public static void addGeomancyPotency(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addGeomancyPotency(attributes, group);
        }
    }

    public static void addNecromancyPotency(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addNecromancyPotency(attributes, group);
        }
    }

    public static void addNetherPotency(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addNetherPotency(attributes, group);
        }
    }

    public static void addStormPotency(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addStormPotency(attributes, group);
        }
    }

    public static void addVoidPotency(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addVoidPotency(attributes, group);
        }
    }

    public static class LoadedOnly {

        public static void addSpellPotency(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            String armor = getArmorName(group);
            if (armor == null) {
                return;
            }

            attributes.add(ModAttributes.SPELL_POTENCY,
                    new AttributeModifier(HazenNStuff.id("add_spell_potency" + armor),
                            0.1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                    ), group);
        }

        public static void addSpellDuration(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            String armor = getArmorName(group);
            if (armor == null) {
                return;
            }

            attributes.add(ModAttributes.SPELL_DURATION,
                    new AttributeModifier(HazenNStuff.id("add_spell_duration" + armor),
                            0.1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                    ), group);
        }

        public static void addSpellRange(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            String armor = getArmorName(group);
            if (armor == null) {
                return;
            }

            attributes.add(ModAttributes.SPELL_RANGE,
                    new AttributeModifier(HazenNStuff.id("add_spell_range" + armor),
                            0.1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                    ), group);
        }

        public static void addSpellBurning(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            String armor = getArmorName(group);
            if (armor == null) {
                return;
            }

            attributes.add(ModAttributes.SPELL_BURNING,
                    new AttributeModifier(HazenNStuff.id("add_spell_burning" + armor),
                            0.1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                    ), group);
        }

        public static void addSpellVelocity(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            String armor = getArmorName(group);
            if (armor == null) {
                return;
            }

            attributes.add(ModAttributes.SPELL_VELOCITY,
                    new AttributeModifier(HazenNStuff.id("add_spell_velocity" + armor),
                            0.1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                    ), group);
        }



        public static void addCastingSpeed(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            String armor = getArmorName(group);
            if (armor == null) {
                return;
            }

            attributes.add(ModAttributes.CASTING_SPEED,
                    new AttributeModifier(HazenNStuff.id("add_casting_speed" + armor),
                            0.1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                    ), group);
        }

        public static void addSoulDiscount(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            String armor = getArmorName(group);
            if (armor == null) {
                return;
            }

            attributes.add(ModAttributes.SOUL_DISCOUNT,
                    new AttributeModifier(HazenNStuff.id("add_soul_discount" + armor),
                            0.1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                    ), group);
        }

        public static void addCooldownDiscount(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            String armor = getArmorName(group);
            if (armor == null) {
                return;
            }

            attributes.add(ModAttributes.COOLDOWN_DISCOUNT,
                    new AttributeModifier(HazenNStuff.id("add_cooldown_discount" + armor),
                            0.1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                    ), group);
        }

        public static void addFrostPotency(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            String armor = getArmorName(group);
            if (armor == null) {
                return;
            }

            attributes.add(ModAttributes.FROST_POTENCY,
                    new AttributeModifier(HazenNStuff.id("add_frost_potency" + armor),
                            0.1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                    ), group);
        }

        public static void addNecromancyPotency(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            String armor = getArmorName(group);
            if (armor == null) {
                return;
            }

            attributes.add(ModAttributes.NECROMANCY_POTENCY,
                    new AttributeModifier(HazenNStuff.id("add_necromancy_potency" + armor),
                            0.1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                    ), group);
        }

        public static void addNetherPotency(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            String armor = getArmorName(group);
            if (armor == null) {
                return;
            }

            attributes.add(ModAttributes.NETHER_POTENCY,
                    new AttributeModifier(HazenNStuff.id("add_nether_potency" + armor),
                            0.1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                    ), group);
        }

        public static void addStormPotency(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            String armor = getArmorName(group);
            if (armor == null) {
                return;
            }

            attributes.add(ModAttributes.STORM_POTENCY,
                    new AttributeModifier(HazenNStuff.id("add_storm_potency" + armor),
                            0.1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                    ), group);
        }

        public static void addGeomancyPotency(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            String armor = getArmorName(group);
            if (armor == null) {
                return;
            }

            attributes.add(ModAttributes.GEOMANCY_POTENCY,
                    new AttributeModifier(HazenNStuff.id("add_geomancy_potency" + armor),
                            0.1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                    ), group);
        }

        public static void addAbyssPotency(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            String armor = getArmorName(group);
            if (armor == null) {
                return;
            }
            attributes.add(ModAttributes.ABYSS_POTENCY,
                    new AttributeModifier(HazenNStuff.id("add_abyss_potency" + armor),
                            0.1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                    ), group);

        }

        public static void addVoidPotency(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            String armor = getArmorName(group);
            if (armor == null) {
                return;
            }

            attributes.add(ModAttributes.VOID_POTENCY,
                    new AttributeModifier(HazenNStuff.id("add_void_potency" + armor),
                            0.1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                    ), group);
        }



    }
}