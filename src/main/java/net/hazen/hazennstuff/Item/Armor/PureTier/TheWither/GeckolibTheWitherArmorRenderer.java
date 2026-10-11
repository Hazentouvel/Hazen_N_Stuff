package net.hazen.hazennstuff.Item.Armor.PureTier.TheWither;

import io.redspace.ironslib.transmog.client.TransmogArmorRenderer;
import net.hazen.hazennstuff.Item.Armor.PureTier.Infestation.GeckolibInfestationArmorItem;
import net.hazen.hazennstuff.Item.Armor.PureTier.Infestation.GeckolibInfestationArmorModel;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class GeckolibTheWitherArmorRenderer extends TransmogArmorRenderer<GeckolibTheWitherArmorItem> {

    public GeckolibTheWitherArmorRenderer(GeckolibTheWitherArmorModel theWitherArmorModel) {
        super(new GeckolibTheWitherArmorModel());

        addRenderLayer(new AutoGlowingGeoLayer<>(this));
        this.withCapeBone(new CapeBone("cape", new Vec3(0.5F, 0.5F, 0.5F)));
    }


}