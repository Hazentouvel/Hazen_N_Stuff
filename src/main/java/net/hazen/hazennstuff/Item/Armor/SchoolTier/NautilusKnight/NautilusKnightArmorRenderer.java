package net.hazen.hazennstuff.Item.Armor.SchoolTier.NautilusKnight;

import io.redspace.ironslib.transmog.client.TransmogArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.Ranger.BountyHunter.BountyHunterArmorItem;
import net.hazen.hazennstuff.Item.Armor.Ranger.BountyHunter.BountyHunterArmorModel;
import net.minecraft.world.phys.Vec3;

public class NautilusKnightArmorRenderer extends TransmogArmorRenderer<NautilusKnightArmorItem> {

    public NautilusKnightArmorRenderer(NautilusKnightArmorModel nautilusKnightArmorModel) {
        super(new NautilusKnightArmorModel());

        this.withCapeBone(new CapeBone("cape", new Vec3(0.5F, 0.5F, 0.5F)));
    }


}