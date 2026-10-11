package net.hazen.hazennstuff.Item.Armor.Melee.FrostbiteKnight;

import io.redspace.ironslib.transmog.client.TransmogArmorRenderer;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class FrostbiteKnightArmorRenderer extends TransmogArmorRenderer<FrostbiteKnightArmorItem> {

    public FrostbiteKnightArmorRenderer(FrostbiteKnightArmorModel bountyHunterArmorModel) {
        super(new FrostbiteKnightArmorModel());

        this.withCapeBone(new CapeBone("cape", new Vec3(0.5F, 0.5F, 0.5F)));
    }


}