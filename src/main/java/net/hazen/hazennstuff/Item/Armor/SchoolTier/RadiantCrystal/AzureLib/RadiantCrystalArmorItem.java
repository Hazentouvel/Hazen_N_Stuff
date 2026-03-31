package net.hazen.hazennstuff.Item.Armor.SchoolTier.RadiantCrystal.AzureLib;

import io.redspace.ironsspellbooks.item.armor.IDisableHat;
import io.redspace.ironsspellbooks.item.armor.IDisableJacket;
import io.redspace.ironsspellbooks.registries.ArmorMaterialRegistry;
import net.hazen.hazennstuff.Item.HnSUtilities.ImbuableHnSArmorItem;
import net.hazen.hazennstuff.Registries.HnSAttributeRegistry;

import static io.redspace.ironsspellbooks.item.armor.ExtendedArmorItem.schoolAttributes;

public class RadiantCrystalArmorItem extends ImbuableHnSArmorItem implements IDisableJacket, IDisableHat {

    public RadiantCrystalArmorItem(Type type, Properties settings) {
        super(ArmorMaterialRegistry.SCHOOL, type, settings, schoolAttributes(
                HnSAttributeRegistry.RADIANCE_SPELL_POWER
        ));
    }
}