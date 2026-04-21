package net.hazen.hazennstuff.Item.Armor.Dedicated.Fireblossom.DormantTier.AzureLib;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.armor.IDisableHat;
import io.redspace.ironsspellbooks.registries.ArmorMaterialRegistry;
import net.hazen.hazennstuff.HnSUtilities.Armor.HnSArmorMaterials;
import net.hazen.hazennstuff.HnSUtilities.Armor.ImbuableHnSArmorItem;

public class FireblossomGownArmor extends ImbuableHnSArmorItem implements IDisableHat {

    public FireblossomGownArmor(Type type, Properties settings) {
        super(ArmorMaterialRegistry.SCHOOL, type, settings, schoolTierDual(
                AttributeRegistry.FIRE_SPELL_POWER,
                AttributeRegistry.NATURE_SPELL_POWER
        ));
    }
}