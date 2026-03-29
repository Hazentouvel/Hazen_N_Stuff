package net.hazen.hazennstuff.Item.Armor.AzureLib.Fireblossom.SchoolTier;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.armor.IDisableHat;
import net.hazen.hazennstuff.Item.HnSUtilities.HnSArmorMaterials;
import net.hazen.hazennstuff.Item.HnSUtilities.ImbuableHnSArmorItem;

public class FireblossomKnightArmor extends ImbuableHnSArmorItem implements IDisableHat {

    public FireblossomKnightArmor(Type type, Properties settings) {
        super(HnSArmorMaterials.ADVANCED_BATTLEMAGE_MATERIAL, type, settings, pureTierMulti(
                AttributeRegistry.FIRE_SPELL_POWER,
                AttributeRegistry.NATURE_SPELL_POWER
        ));
    }
}