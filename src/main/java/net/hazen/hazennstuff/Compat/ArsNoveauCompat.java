package net.hazen.hazennstuff.Compat;


import com.hollingsworth.arsnouveau.api.perk.PerkAttributes;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.fml.ModList;

public class ArsNoveauCompat {
    public static boolean LOADED;
    public static void init() {
        LOADED = ModList.get().isLoaded("ars_nouveau");
    }

    public static void addMaxMana(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addMaxMana(attributes, group);
        }
    }

    public static void addManaRegen(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addManaRegen(attributes, group);
        }
    }

    public static class LoadedOnly {

        public static void addMaxMana(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(PerkAttributes.MAX_MANA,
                    new AttributeModifier(HazenNStuff.id("add_max_mana"), 120f, AttributeModifier.Operation.ADD_VALUE),
                    group);
        }

        public static void addManaRegen(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(PerkAttributes.MANA_REGEN_BONUS,
                    new AttributeModifier(HazenNStuff.id("add_mana_regen"), 4f, AttributeModifier.Operation.ADD_VALUE),
                    group);
        }


    }
}
