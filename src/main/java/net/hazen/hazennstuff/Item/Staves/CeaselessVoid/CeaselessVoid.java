package net.hazen.hazennstuff.Item.Staves.CeaselessVoid;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.HnSUtilities.Item.HnSStaffTier;
import net.hazen.hazentouvelib.Rarities.HLRarities;

public class CeaselessVoid extends StaffItem {

    public CeaselessVoid() {
        super(
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(HLRarities.SHADOW_RARITY.getValue())
                        .attributes(ExtendedSwordItem
                                .createAttributes(HnSStaffTier.CEASELESS_VOID))
        );
    }
}
