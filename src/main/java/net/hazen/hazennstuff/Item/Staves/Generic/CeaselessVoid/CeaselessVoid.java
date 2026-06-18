package net.hazen.hazennstuff.Item.Staves.Generic.CeaselessVoid;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import net.hazen.hazennstuff.HnSUtilities.Item.HnSStaffTier;
import net.hazen.hazentouvelib.Rarities.HLRarities;
import net.minecraft.world.item.Item;

public class CeaselessVoid extends StaffItem {

    public CeaselessVoid() {
        super(
                new Item
                        .Properties()
                        .stacksTo(1)
                        .fireResistant()
                        .rarity(HLRarities.SHADOW_RARITY.getValue())
                        .attributes(ExtendedSwordItem
                                .createAttributes(HnSStaffTier.CEASELESS_VOID))
        );
    }
}
