package net.hazen.hazennstuff.Item.Armor.Dedicated.SacredRobes;

import io.redspace.ironslib.transmog.client.TransmogArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.SchoolTier.NautilusKnight.NautilusKnightArmorItem;
import net.hazen.hazennstuff.Item.Armor.SchoolTier.NautilusKnight.NautilusKnightArmorModel;
import net.minecraft.world.phys.Vec3;

public class SacredRobesArmorRenderer extends TransmogArmorRenderer<SacredRobesArmorItem> {

    public SacredRobesArmorRenderer(SacredRobesArmorModel sacredRobesArmorModel) {
        super(new SacredRobesArmorModel());

        this.withCapeBone(new CapeBone("booty_cape", new Vec3(0.5F, 0.5F, 0.5F)));
    }


}