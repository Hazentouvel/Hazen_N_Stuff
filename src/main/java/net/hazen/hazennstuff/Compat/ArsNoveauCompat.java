package net.hazen.hazennstuff.Compat;


import com.hollingsworth.arsnouveau.api.perk.PerkAttributes;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.fml.ModList;

public class ArsNoveauCompat extends ArmorCompat {
    public static void init() {
        LOADED = ModList.get().isLoaded("ars_nouveau");
    }

    public static void addMaxMana(ItemAttributeModifiers.Builder attributes,
                                  EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addMaxMana(attributes, group);
        }
    }

    public static void addManaRegen(ItemAttributeModifiers.Builder attributes,
                                    EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addManaRegen(attributes, group);
        }
    }

    public static class LoadedOnly {

        public static void addMaxMana(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            String armor = getArmorName(group);
            if (armor == null) {
                return;
            }

            attributes.add(
                    PerkAttributes.MAX_MANA,
                    new AttributeModifier(
                            HazenNStuff.id("ars_nouveau_add_max_mana_" + armor),
                            120,
                            AttributeModifier.Operation.ADD_VALUE
                    ), group);
        }

        public static void addManaRegen(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            String armor = getArmorName(group);
            if (armor == null) {
                return;
            }



            attributes.add(
                    PerkAttributes.MANA_REGEN_BONUS,
                    new AttributeModifier(
                            HazenNStuff.id("ars_nouveau_add_mana_regen_" + armor),
                            4F,
                            AttributeModifier.Operation.ADD_VALUE
                    ), group);
        }


    }
}
