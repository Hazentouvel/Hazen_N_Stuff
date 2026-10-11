package net.hazen.hazennstuff.Item.Armor.Dedicated.Iron431;

import io.redspace.ironslib.transmog.client.TransmogArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.Ranger.BountyHunter.BountyHunterArmorItem;
import net.hazen.hazennstuff.Item.Armor.Ranger.BountyHunter.BountyHunterArmorModel;
import net.minecraft.world.phys.Vec3;

public class Iron431ArmorRenderer extends TransmogArmorRenderer<Iron431ArmorItem> {

    public Iron431ArmorRenderer(Iron431ArmorModel iron431ArmorModel) {
        super(new Iron431ArmorModel());

        this.withCapeBone(new CapeBone("cape", new Vec3(0.5F, 0.5F, 0.5F)));
    }


}