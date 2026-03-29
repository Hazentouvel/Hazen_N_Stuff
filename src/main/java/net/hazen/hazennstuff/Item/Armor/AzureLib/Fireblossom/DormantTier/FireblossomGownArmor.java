package net.hazen.hazennstuff.Item.Armor.AzureLib.Fireblossom.DormantTier;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.armor.IDisableHat;
import net.hazen.hazennstuff.Item.HnSUtilities.HnSArmorMaterials;
import net.hazen.hazennstuff.Item.HnSUtilities.ImbuableHnSArmorItem;

public class FireblossomGownArmor extends ImbuableHnSArmorItem implements IDisableHat {

    public FireblossomGownArmor(Type type, Properties settings) {
        super(HnSArmorMaterials.ADVANCED_BATTLEMAGE_MATERIAL, type, settings, schoolTierDual(
                AttributeRegistry.FIRE_SPELL_POWER,
                AttributeRegistry.NATURE_SPELL_POWER
        ));
    }
}