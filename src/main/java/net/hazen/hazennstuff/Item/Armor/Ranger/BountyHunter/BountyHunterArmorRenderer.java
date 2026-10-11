package net.hazen.hazennstuff.Item.Armor.Ranger.BountyHunter;

import io.redspace.ironslib.transmog.client.TransmogArmorRenderer;
import net.minecraft.world.phys.Vec3;

public class BountyHunterArmorRenderer extends TransmogArmorRenderer<BountyHunterArmorItem> {

    public BountyHunterArmorRenderer(BountyHunterArmorModel bountyHunterArmorModel) {
        super(new BountyHunterArmorModel());

        this.withCapeBone(new TransmogArmorRenderer.CapeBone("cape", new Vec3(0.5F, 0.5F, 0.5F)));
    }


}