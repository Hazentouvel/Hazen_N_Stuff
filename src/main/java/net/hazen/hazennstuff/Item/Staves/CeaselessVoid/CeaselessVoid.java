package net.hazen.hazennstuff.Item.Staves.CeaselessVoid;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.HnSUtilities.Item.HnSStaffTier;
import net.hazen.hazennstuff.Rarity.HnSRarities;

public class CeaselessVoid extends StaffItem {

    public CeaselessVoid() {
        super(
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(HnSRarities.SHADOW_RARITY.getValue())
                        .attributes(ExtendedSwordItem
                                .createAttributes(HnSStaffTier.CEASELESS_VOID))
        );
    }
}
