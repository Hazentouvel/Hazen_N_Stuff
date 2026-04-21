package net.hazen.hazennstuff.Item.Armor.Dedicated.Fireblossom.SchoolTier.AzureLib;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.armor.IDisableHat;
import io.redspace.ironsspellbooks.registries.ArmorMaterialRegistry;
import net.hazen.hazennstuff.HnSUtilities.Armor.HnSArmorMaterials;
import net.hazen.hazennstuff.HnSUtilities.Armor.ImbuableHnSArmorItem;

public class FireblossomKnightArmor extends ImbuableHnSArmorItem implements IDisableHat {

    public FireblossomKnightArmor(Type type, Properties settings) {
        super(ArmorMaterialRegistry.NETHERITE_BATTLEMAGE, type, settings, pureTierMulti(
                AttributeRegistry.FIRE_SPELL_POWER,
                AttributeRegistry.NATURE_SPELL_POWER
        ));
    }
}