package net.hazen.hazennstuff.Item.Armor.SchoolTier.CosmicScholar.AzureLib;

import io.redspace.ironsspellbooks.item.armor.IDisableHat;
import io.redspace.ironsspellbooks.item.armor.IDisableJacket;
import io.redspace.ironsspellbooks.registries.ArmorMaterialRegistry;
import net.hazen.hazennstuff.HnSUtilities.Armor.ImbuableHnSArmorItem;
import net.hazen.hazennstuff.Registries.HnSAttributeRegistry;

import static io.redspace.ironsspellbooks.item.armor.ExtendedArmorItem.schoolAttributes;

public class CosmicScholarArmorItem extends ImbuableHnSArmorItem implements IDisableJacket, IDisableHat {

    public CosmicScholarArmorItem(Type type, Properties settings) {
        super(ArmorMaterialRegistry.SCHOOL, type, settings, schoolAttributes(
                HnSAttributeRegistry.COSMIC_SPELL_POWER
        ));
    }
}